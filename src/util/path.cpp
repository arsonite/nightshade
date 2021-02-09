/** DISCLAIMER
 * Copyright (C) https://github.com/arsonite (Burak Günaydin)
 *
 * Distributed under the MIT License (MIT).
 * For more information read the accompanying LICENSE file in the
 * root directory or visit http://opensource.org/licenses/MIT)
 */
#include "path.h"

Path::Path(unsigned int statusCode, string url): _statusCode(statusCode), _url(url) {}

unsigned int Path::statusCode() const {
    return _statusCode;
}

string Path::url() const {
    return _url;
}

vector<string> Path::seperatedURL() const
{
    return _seperatedURL;
}
