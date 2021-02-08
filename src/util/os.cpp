/** DISCLAIMER
 * MIT-License (C) https://github.com/arsonite
 */
#include "OS.h"

void OS::init() {
    OS::setHomePath();
    OS::setApplicationPath();
}

const tuple<const unsigned int, const std::__cxx11::string> *OS::homePath() {
    return OS::_homePath;
}

const tuple<const unsigned int, const std::__cxx11::string> *OS::applicationPath() {
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