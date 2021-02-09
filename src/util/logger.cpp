/** DISCLAIMER
 * Copyright (C) https://github.com/arsonite (Burak Günaydin)
 * 
 * Distributed under the MIT License (MIT).
 * For more information read the accompanying LICENSE file in the
 * root directory or visit http://opensource.org/licenses/MIT)
 */
#include "logger.h"

#include <ctime>
#include <iostream>

Logger::Logger(string className): _className(className),
    _logPath("C:/Users/guenbura/AppData/local/ProjectNightshade/logs") {}

void Logger::log(string message) const {

}

void Logger::print(std::__cxx11::string message) const {
    string date = Logger::getDate();
    string time = Logger::getTime();
    string printStatement = "[" + _className + "](" + date + "-" + time + ")" + ": " + message;
    cout << printStatement << endl;
}

string Logger::getDate() {
    time_t now = time(0);
    tm *ltm = localtime(&now);
    string year = to_string(1900 + ltm->tm_year);
    string month = to_string(1 + ltm->tm_mon);
    string day = to_string(ltm->tm_mday);
    return year + "." + month + "." + day;
}

string Logger::getTime() {
    time_t now = time(0);
    tm *ltm = localtime(&now);
    string hour = to_string(5+ltm->tm_hour);
    string minute = to_string(30+ltm->tm_min);
    string second = to_string(ltm->tm_sec);
    return hour + ":" + minute + ":" + second;
}
