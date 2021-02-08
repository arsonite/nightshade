/** DISCLAIMER
 * MIT-License (C) https://github.com/arsonite
 */
#pragma once
#ifndef LOGGER_H
#define LOGGER_H

#include <string>

using namespace std;

class Logger {
    public:
        explicit Logger(string className); // Standard constructor

        virtual ~Logger(); // Standard destructor

        string log(string message) const;
        int log(int number) const;
        float log(float number) const;

        string print(string message) const;
        int print(int number) const;
        float print(float number) const;

        static string getDate();
        static string getTime();

    private:
        const string _logPath;
        const string _className;
};

#endif // LOGGER_H
