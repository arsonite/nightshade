/** DISCLAIMER
 * Copyright (C) https://github.com/arsonite (Burak Günaydin)
 * 
 * Distributed under the MIT License (MIT).
 * For more information read the accompanying LICENSE file in the
 * root directory or visit http://opensource.org/licenses/MIT)
 */
#pragma once
#ifndef FILE_H
#define FILE_H

#include "path.h"

#include <string>

using namespace std;

class File {
    public:
        File(); // Standard constructor

        ~File(); // Standard destructor

        static void init(const Path applicationPath);
};

#endif // FILE_H
