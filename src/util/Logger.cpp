/** DISCLAIMER
 * MIT-License (C) https://github.com/arsonite
 */
#include "logger.h"

#include <iostream>

/**
 * @brief Logger::Logger
 * @param className
 */
Logger::Logger(string className): _className(className) {}

std::__cxx11::string Logger::print(std::__cxx11::string message) const {
    string date = Logger::getDate();
    string time = Logger::getTime();
    string printStatement = "<" + _className + "> [" + date + "-" + time + "]" + ": " + message;
    cout << printStatement << endl;
    return printStatement;
}

string Logger::getDate() {

}

string Logger::getTime() {

}
