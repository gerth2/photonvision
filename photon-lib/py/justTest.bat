@echo off
setlocal

:: Pick up the local install of the module
set PYTHONPATH=./

pytest
