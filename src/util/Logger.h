/** DISCLAIMER
 * Copyright (C) https://github.com/arsonite (Burak Günaydin)
 * 
 * Distributed under the MIT License (MIT).
 * For more information read the accompanying LICENSE file in the
 * root directory or visit http://opensource.org/licenses/MIT)
 */
#pragma once
#ifndef LOGGER_H
#define LOGGER_H

#include <string>

using namespace std;

class Logger {
    public:
        Logger(string className); // Standard constructor

        ~Logger(); // Standard destructor

        void log(string message) const;
        void log(int number) const;
        void log(float number) const;

        void print(string message) const;
        void print(int number) const;
        void print(float number) const;

        static string getDate();
        static string getTime();

    private:
        const string _className;
        const string _logPath;
};

#endif // LOGGER_H
