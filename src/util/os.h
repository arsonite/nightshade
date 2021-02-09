/** DISCLAIMER
 * Copyright (C) https://github.com/arsonite (Burak Günaydin)
 * 
 * Distributed under the MIT License (MIT).
 * For more information read the accompanying LICENSE file in the
 * root directory or visit http://opensource.org/licenses/MIT)
 */
#pragma once
#ifndef OS_H
#define OS_H

#include "path.h"

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

        inline static const Path *_homePath;
        inline static const Path *_applicationPath;
};

#endif // OS_H
