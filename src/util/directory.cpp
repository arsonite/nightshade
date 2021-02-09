/** DISCLAIMER
 * Copyright (C) https://github.com/arsonite (Burak Günaydin)
 * 
 * Distributed under the MIT License (MIT).
 * For more information read the accompanying LICENSE file in the
 * root directory or visit http://opensource.org/licenses/MIT)
 */
#include "directory.h"

#include <filesystem>
#include <string>

using namespace std;

void Directory::init()
{
    namespace fs = filesystem;
    fs::create_directories("./a/b/c");
}
