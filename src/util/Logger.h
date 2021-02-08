/** DISCLAIMER
 * MIT-License (C) https://github.com/arsonite
 */
#ifndef LOGGER_H
#define LOGGER_H

#include <iostream>
#include <string>
#include <shlobj.h>
#include <windows.h>

#include "userenv.h"

using namespace std;

class Logger
{
public:
    Logger(string classname); // Standard constructor

    ~Logger(); // Standard destructor

    string log(string message) const;
    string log(int number) const;
    string log(float number) const;

    string print(string message) const;
    string print(int number) const;
    string print(float number) const;
};

#endif // LOGGER_H
