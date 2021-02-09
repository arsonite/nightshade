/** DISCLAIMER
 * Copyright (C) https://github.com/arsonite (Burak Günaydin)
 * 
 * Distributed under the MIT License (MIT).
 * For more information read the accompanying LICENSE file in the
 * root directory or visit http://opensource.org/licenses/MIT)
 */
#include "os.h"

#include <shlobj.h>
#include <windows.h>

void OS::init() {
    OS::setHomePath();
    OS::setApplicationPath();
}

const Path *OS::homePath() {
    return OS::_homePath;
}

const Path *OS::applicationPath() {
    return OS::_applicationPath;
}

void OS::setHomePath() {
    char path[MAX_PATH];
    unsigned int homeDirectoryFound = 1;
    string homeDirectory = "";
    if (SHGetFolderPathA(NULL, CSIDL_PROFILE, NULL, 0, path) != S_OK) {
        homeDirectoryFound = 0;
    } else {
        homeDirectory = path;
    }
    OS::_homePath = new const Path(homeDirectoryFound, homeDirectory);
}

void OS::setApplicationPath() {
    char path[MAX_PATH];
    unsigned int applicationDirectoryFound = 1;
    string applicationDirectory = "";
    if (SHGetFolderPathA(NULL, CSIDL_LOCAL_APPDATA, NULL, 0, path) != S_OK) {
        applicationDirectoryFound = 0;
    } else {
        applicationDirectory = path;
    }
    OS::_applicationPath = new const Path(applicationDirectoryFound, applicationDirectory);
}
