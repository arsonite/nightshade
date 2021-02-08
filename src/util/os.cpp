/** DISCLAIMER
 * MIT-License (C) https://github.com/arsonite
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
    OS::_homePath = new Path(homeDirectoryFound, homeDirectory);
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
    OS::_applicationPath = new Path(applicationDirectoryFound, applicationDirectory);
}
