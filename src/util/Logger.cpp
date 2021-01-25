/** DISCLAIMER
 * MIT-License (C) Arsonite (2019-2021)
 */
#ifndef LOGGER_H
#define LOGGER_H

#include <string>

using namespace std;

class Logger
{
public:
    Logger();

    ~Logger();

    int error(string message);
};

#endif // LOGGER_H
