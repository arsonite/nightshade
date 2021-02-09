/** DISCLAIMER
 * Copyright (C) https://github.com/arsonite (Burak Günaydin)
 * 
 * Distributed under the MIT License (MIT).
 * For more information read the accompanying LICENSE file in the
 * root directory or visit http://opensource.org/licenses/MIT)
 */



/*
import pyperclip
import time

from collections import Counter
from datetime import datetime
from uuid import uuid4

class ID():
    @staticmethod
    def exists():
        return False

    @staticmethod
    def generate(printID=False, copyToClipboard=False):
        """
        Generates a 60-bit pseudo-random UUID with a custom algorithm that also takes the current timestamp into account,
        without exposing the MAC-address of the PC that the UUID is generated on (unlike the official UUID1 specification).
        Sucessfully tested collisions with 100.000.000 single threaded generated IDs in non-interrupted sequence and
        10.000.000 multi threaded generated IDs.

        Args:
            printID (bool, optional): Print the generated ID to the console. Defaults to False.
            copyToClipboard (bool, optional): Copy the generated ID to your systems clipboard. Defaults to False.

        Returns:
            String: The generated UUID
        """
        t = datetime.now()  # Grabbing current datetime
        datestamp = f'{t.day}{t.month}{t.year}'  # Reformat the date
        # Reformat the time, I seperated date and time to keep the date as a consistent part of the ID
        timestamp = f'{t.microsecond}{t.second}{t.minute}{t.hour}'
        # Converting date and time to integer and those integer into hex
        firstID = hex(int(timestamp))[2:] + hex(int(datestamp))[2:] + datestamp
        # Generating a pseudo-random second ID via UUID4 specification, to ensure further collision-safety
        secondID = (str(uuid4()) + str(uuid4())).replace('-', '')
        # Concatenating both IDs and trimming the final ID down to 60 bytes for DB and HTTP compatibility
        uuid = (firstID + secondID)[:60]
        if printID:
            print(f'Generated ID: {uuid}')
        if copyToClipboard:
            # Copies the ID to the clipboard of your OS for easier manual use
            pyperclip.copy(uuid)
        return uuid
    
if __name__ == '__main__':
    ID.generate(False, True)
*/