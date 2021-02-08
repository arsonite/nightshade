/** DISCLAIMER
 * MIT-License (C) https://github.com/arsonite
 */
#include "os.h"

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
    boolean homeDirectoryFound = true;
    string homeDirectory = "";
    if (SHGetFolderPathA(NULL, CSIDL_PROFILE, NULL, 0, path) != S_OK) {
        homeDirectoryFound = 0;
    } else {
        homeDirectory = path;
    }
    _homePath = new Path(homeDirectoryFound, homeDirectory);
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
    _applicationPath = new const Path(applicationDirectoryFound, applicationDirectory);
}
