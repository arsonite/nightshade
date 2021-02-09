/** DISCLAIMER
 * Copyright (C) https://github.com/arsonite (Burak Günaydin)
 * 
 * Distributed under the MIT License (MIT).
 * For more information read the accompanying LICENSE file in the
 * root directory or visit http://opensource.org/licenses/MIT)
 */
#pragma once
#ifndef DIRECTORY_H
#define DIRECTORY_H

#include "path.h"

class Directory {
    public:
        Directory(); // Standard constructor

        ~Directory(); // Standard destructor

        static void init(const Path applicationPath);
};

#endif // DIRECTORY_H
