/** DISCLAIMER
 * MIT-License (C) https://github.com/arsonite
 */
#pragma once
#ifndef OS_H
#define OS_H

#include <string>
#include <tuple>

#include <shlobj.h>
#include <windows.h>

#include "userenv.h"

using namespace std;

class OS
{
public:
    static void init();

    /* Getter */
    static const tuple<const unsigned int, const string> *homePath();
    static const tuple<const unsigned int, const string> *applicationPath();

private:
    /* Setter */
    static void setHomePath();
    static void setApplicationPath();

    static const tuple<const unsigned int, const string> *_homePath;
    static const tuple<const unsigned int, const string> *_applicationPath;
};

#endif // OS_H
