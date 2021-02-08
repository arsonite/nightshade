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

struct Path {
    public:
        explicit Path(unsigned int statusCode, string url);

        virtual ~Path();

        /* GETTER */
        unsigned int statusCode() const;
        string url() const;
    private:
        const unsigned int _statusCode;
        const string _url;
};

class OS {
    public:
        static void init();

        /* GETTER */
        static const Path *homePath();
        static const Path *applicationPath();

    private:
        /* SETTER */
        static void setHomePath();
        static void setApplicationPath();

        static const Path *_homePath;
        static const Path *_applicationPath;
};

#endif // OS_H
