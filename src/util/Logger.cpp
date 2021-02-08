/** DISCLAIMER
 * MIT-License (C) https://github.com/arsonite
 */
#ifndef LOGGER_H
#define LOGGER_H

#include <string>

using namespace std;

class Logger
{
public:
    Logger(); // Empty constructor

    ~Logger(); // Standard destructor

    int error(string message);
};

#endif // LOGGER_H
