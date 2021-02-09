/** DISCLAIMER
 * Copyright (C) https://github.com/arsonite (Burak Günaydin)
 *
 * Distributed under the MIT License (MIT).
 * For more information read the accompanying LICENSE file in the
 * root directory or visit http://opensource.org/licenses/MIT)
 */
#pragma once
#ifndef PATH_H
#define PATH_H

#include <string>
#include <vector>

using namespace std;

struct Path {
    public:
        Path(unsigned int statusCode, string url);

        ~Path();

        /* GETTER */
        unsigned int statusCode() const;
        string url() const;
        vector<string> seperatedURL() const;

    private:
        const unsigned int _statusCode;
        const string _url;
        const vector<string> _seperatedURL;
};

#endif // PATH_H
