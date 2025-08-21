#!/usr/bin/env python3
import csv
import re
import random
from pathlib import Path
from concurrent.futures import ProcessPoolExecutor

from rapidfuzz import process
import spacy
from nltk.corpus import wordnet as wn

# ========= CONFIG =========
TSV_PATH = r"c:\Users\chris\Downloads\klingon-english.csv"   # TODO: change this
ROOT_DIR = r"C:\Users\chris\git\photonvision\docs\source"     # TODO: change this
FILE_EXTS = (".md", ".rst")
FUZZY_THRESHOLD = 80
N_WORKERS = 10   # adjust for your CPU
# ========= END CONFIG =========

# Load spaCy English model once
nlp = spacy.load("en_core_web_sm")

# ---------- Dictionary Loading ----------
def load_klingon_dictionary(tsv_path: str):
    """Load TSV into a Klingon->English structure and an English->Klingon index."""
    klingon_dict = {}
    eng_to_klingon = {}

    with open(tsv_path, newline="", encoding="utf-8") as tsvfile:
        reader = csv.reader(tsvfile, delimiter="\t")
        for row in reader:
            if len(row) < 2:
                continue
            klingon_word = row[0].strip()
            english_raw = row[1].strip()

            # Extract part of speech (last parentheses)
            m = re.search(r"\(([^)]+)\)\s*$", english_raw)
            pos = m.group(1) if m else None
            english_no_pos = english_raw[:m.start()].strip() if m else english_raw

            # Split glosses by commas
            glosses = [g.strip().lower() for g in english_no_pos.split(",")]

            klingon_dict[klingon_word] = {
                "glosses": glosses,
                "pos": pos
            }

            for gloss in glosses:
                eng_to_klingon.setdefault(gloss, set()).add(klingon_word)

    return klingon_dict, eng_to_klingon

klingon_dict, eng_to_klingon = load_klingon_dictionary(TSV_PATH)
print(f"Loaded {len(klingon_dict)} Klingon entries, {len(eng_to_klingon)} English glosses.")

# ---------- Word Processing ----------
def lemmatize(word: str) -> str:
    doc = nlp(word)
    return doc[0].lemma_ if doc else word

def fuzzy_lookup(word: str, eng_to_klingon: dict[str, set[str]]) -> str | None:
    # Look against glosses
    glosses = list(eng_to_klingon.keys())
    match = process.extractOne(word, glosses)
    if match and match[1] >= FUZZY_THRESHOLD:
        klingons = eng_to_klingon[match[0]]
        return random.choice(list(klingons))  # pick one if multiple
    return None

def pseudo_klingon(word: str) -> str:
    word = re.sub("c", "q", word)
    word = re.sub("r", "rr", word)
    word = re.sub("s", "tlh", word)
    if len(word) > 3:
        i = random.randint(1, len(word)-1)
        word = word[:i] + "'" + word[i:]
    return word

def klingon_lookup(word: str) -> str:
    base = lemmatize(word.lower())

    # exact match
    if base in eng_to_klingon:
        return random.choice(list(eng_to_klingon[base]))

    # fuzzy match
    match = fuzzy_lookup(base, eng_to_klingon)
    if match:
        return match

    # fallback
    return pseudo_klingon(word)

# ---------- File Translation ----------
def translate_line(line: str) -> str:
    def repl(match):
        word = match.group(0)
        return klingon_lookup(word)
    return re.sub(r"\b[a-zA-Z]+\b", repl, line)

def translate_markdown(text: str) -> str:
    # Regex for code fences (```...```)
    code_fence_pattern = re.compile(r"```.*?```", re.DOTALL)
    # Regex for markdown links: [text](url)
    link_pattern = re.compile(r"\[([^\]]+)\]\([^)]+\)")

    # Find all code fences and replace with placeholders
    code_fences = []
    def code_fence_replacer(match):
        code_fences.append(match.group(0))
        return f"__CODE_FENCE_{len(code_fences)-1}__"
    text = code_fence_pattern.sub(code_fence_replacer, text)

    # Find all links and replace with placeholders
    links = []
    def link_replacer(match):
        links.append(match.group(0))
        return f"__LINK_{len(links)-1}__"
    text = link_pattern.sub(link_replacer, text)

    # Translate remaining text (words only)
    def repl(match):
        word = match.group(0)
        return klingon_lookup(word)
    text = re.sub(r"\b[a-zA-Z]+\b", repl, text)

    # Restore links
    for i, link in enumerate(links):
        text = text.replace(f"__LINK_{i}__", link)
    # Restore code fences
    for i, code in enumerate(code_fences):
        text = text.replace(f"__CODE_FENCE_{i}__", code)
    return text

def translate_file(filepath: Path):
    print(f"Processing {filepath}")
    text = filepath.read_text(encoding="utf-8", errors="ignore")
    translated = translate_markdown(text)
    filepath.write_text(translated, encoding="utf-8")
# ---------- Runner ----------
def main():
    all_files = [p for p in Path(ROOT_DIR).rglob("*") if p.suffix in FILE_EXTS]
    print(f"Found {len(all_files)} files to translate.")

    with ProcessPoolExecutor(max_workers=N_WORKERS) as exe:
        list(exe.map(translate_file, all_files))

if __name__ == "__main__":
    main()
