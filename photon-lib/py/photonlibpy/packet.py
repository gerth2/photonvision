###############################################################################
## Copyright (C) Photon Vision.
###############################################################################
## This program is free software: you can redistribute it and/or modify
## it under the terms of the GNU General Public License as published by
## the Free Software Foundation, either version 3 of the License, or
## (at your option) any later version.
##
## This program is distributed in the hope that it will be useful,
## but WITHOUT ANY WARRANTY; without even the implied warranty of
## MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
## GNU General Public License for more details.
##
## You should have received a copy of the GNU General Public License
## along with this program.  If not, see <https://www.gnu.org/licenses/>.
###############################################################################

import struct
from typing import Any, Optional, Type
from wpimath.geometry import Transform3d, Translation3d, Rotation3d, Quaternion
import wpilib


class Packet:
    def __init__(self, data: bytes):
        """
        * Constructs an empty packet.
        *
        * @param self.size The self.size of the packet buffer.
        """
        self.packetData = data
        self.size = len(data)
        self.readPos = 0
        self.outOfBytes = False

    def clear(self):
        """Clears the packet and resets the read and write positions."""
        self.packetData = [0] * self.size
        self.readPos = 0
        self.outOfBytes = False

    def getSize(self):
        return self.size

    _NO_MORE_BYTES_MESSAGE = """
    Photonlib - Ran out of bytes while decoding.
    Make sure the version of photonvision on the coprocessor
    matches the version of photonlib running in the robot code.
    """

    def _getNextByteAsInt(self) -> int:
        retVal = 0x00

        if not self.outOfBytes:
            try:
                retVal = 0x00FF & self.packetData[self.readPos]
                self.readPos += 1
            except IndexError:
                wpilib.reportError(Packet._NO_MORE_BYTES_MESSAGE, True)
                self.outOfBytes = True

        return retVal

    def getData(self) -> bytes:
        """
        * Returns the packet data.
        *
        * @return The packet data.
        """
        return self.packetData

    def setData(self, data: bytes):
        """
        * Sets the packet data.
        *
        * @param data The packet data.
        """
        self.clear()
        self.packetData = data
        self.size = len(self.packetData)

    def _decodeGeneric(self, unpackFormat, numBytes):
        # Read ints in from the data buffer
        intList = []
        for _ in range(numBytes):
            intList.append(self._getNextByteAsInt())

        # Interpret the bytes as a floating point number
        value = struct.unpack(unpackFormat, bytes(intList))[0]

        return value
    
    def _encodeGeneric(self, packFormat: str, value) -> None:
        """
        Encodes a value using a given format and appends the resulting bytes to the packet data.
        
        :param packFormat: The struct format string to use for packing the value.
        :param value: The value to encode and append to the packet data.
        """
        # Convert the value to bytes using the specified format
        encodedBytes = struct.pack(packFormat, value)
        
        # Append each byte to the packetData
        self.packetData.extend(encodedBytes)
        self.size = len(self.packetData)  # Update the size after modification

    def encode8(self, value: int) -> None:
        """Encodes a single byte and appends it to the packet data."""
        self._encodeGeneric(">b", value)

    def decode8(self) -> int:
        """
        * Returns a single decoded byte from the packet.
        *
        * @return A decoded byte from the packet.
        """
        return self._decodeGeneric(">b", 1)

    def encode16(self, value: int) -> None:
        """Encodes a 16-bit short and appends it to the packet data."""
        self._encodeGeneric(">h", value)

    def decode16(self) -> int:
        """
        * Returns a single decoded short from the packet.
        *
        * @return A decoded short from the packet.
        """
        return self._decodeGeneric(">h", 2)

    def encodeInt(self, value: int) -> None:
        """Encodes a 32-bit integer and appends it to the packet data."""
        self._encodeGeneric(">l", value)

    def decodeInt(self) -> int:
        """
        * Returns a decoded int (32 bytes) from the packet.
        *
        * @return A decoded int from the packet.
        """
        return self._decodeGeneric(">l", 4)

    def encodeFloat(self, value: float) -> None:
        """Encodes a 32-bit float and appends it to the packet data."""
        self._encodeGeneric(">f", value)

    def decodeFloat(self) -> float:
        """
        * Returns a decoded float from the packet.
        *
        * @return A decoded float from the packet.
        """
        return self._decodeGeneric(">f", 4)

    def encodeLong(self, value: int) -> None:
        """Encodes a 64-bit long integer and appends it to the packet data."""
        self._encodeGeneric(">q", value)

    def decodeLong(self) -> int:
        """
        * Returns a decoded int64 from the packet.
        *
        * @return A decoded int64 from the packet.
        """
        return self._decodeGeneric(">q", 8)

    def encodeDouble(self, value: float) -> None:
        """Encodes a 64-bit double and appends it to the packet data."""
        self._encodeGeneric(">d", value)

    def decodeDouble(self) -> float:
        """
        * Returns a decoded double from the packet.
        *
        * @return A decoded double from the packet.
        """
        return self._decodeGeneric(">d", 8)

    def encodeBoolean(self, value: bool) -> None:
        """Encodes a boolean value and appends it to the packet data."""
        # Encode True as 1 and False as 0 using an 8-bit signed integer
        self.encode8(1 if value else 0)

    def decodeBoolean(self) -> bool:
        """
        * Returns a decoded boolean from the packet.
        *
        * @return A decoded boolean from the packet.
        """
        return self.decode8() == 1

    def encodeDoubleArray(self, values: list[float]) -> None:
        """
        Encodes an array of doubles and appends it to the packet data.
        
        :param values: The list of double values to encode.
        """
        for value in values:
            self.encodeDouble(value)

    def decodeDoubleArray(self, length: int) -> list[float]:
        """
        * Returns a decoded array of floats from the packet.
        """
        ret = []
        for _ in range(length):
            ret.append(self.decodeDouble())
        return ret

    def encodeShortList(self, values: list[int]) -> None:
        """
        Encodes a list of shorts, preceded by its length, and appends it to the packet data.
        
        :param values: The list of short values to encode.
        """
        # Encode the length of the list first
        self.encode8(len(values))
        for value in values:
            self.encode16(value)

    def decodeShortList(self) -> list[float]:
        """
        * Returns a decoded array of shorts from the packet.
        """
        length = self.decode8()
        ret = []
        for _ in range(length):
            ret.append(self.decode16())
        return ret
    
    def encodeTransform(self, t:Transform3d)->None:
        trans = t.translation()
        self.encodeDouble(trans.X())
        self.encodeDouble(trans.Y())
        self.encodeDouble(trans.Z())

        rotq = t.rotation().getQuaternion()
        self.encodeDouble(rotq.W())
        self.encodeDouble(rotq.X())
        self.encodeDouble(rotq.Y())
        self.encodeDouble(rotq.Z())

    def decodeTransform(self) -> Transform3d:
        """
        * Returns a decoded Transform3d
        *
        * @return A decoded Tansform3d from the packet.
        """
        x = self.decodeDouble()
        y = self.decodeDouble()
        z = self.decodeDouble()
        translation = Translation3d(x, y, z)

        w = self.decodeDouble()
        x = self.decodeDouble()
        y = self.decodeDouble()
        z = self.decodeDouble()
        rotation = Rotation3d(Quaternion(w, x, y, z))

        return Transform3d(translation, rotation)
    
    def encodeList(self, values: list[Any], serde: Type) -> None:
        """
        Encodes a list of values and appends them to the packet data.
        
        :param values: The list of values to encode.
        :param serde: The serializer/deserializer type used to encode each value.
        """
        # First encode the length of the list as an 8-bit integer
        self.encode8(len(values))

        # Encode each item in the list using the provided serde type's pack method
        for value in values:
            serde.pack(self, value)

    def decodeList(self, serde: Type) -> list[Any]:
        retList = []
        arr_len = self.decode8()
        for _ in range(arr_len):
            retList.append(serde.unpack(self))
        return retList

    def encodeOptional(self, value: Optional[Any], serde: Type) -> None:
        """
        Encodes an optional value and appends it to the packet data.
        
        :param value: The optional value to encode. Can be `None`.
        :param serde: The serializer/deserializer type used to encode the value if present.
        """
        # Encode whether the value is present (True/False as 1/0)
        self.encodeBoolean(value is not None)
        
        # If the value is present, encode it using the provided serde type's pack method
        if value is not None:
            serde.pack(self, value)  # Assuming `serde` has a `pack` method


    def decodeOptional(self, serde: Type) -> Optional[Any]:
        if self.decodeBoolean():
            return serde.unpack(self)
        else:
            return None
