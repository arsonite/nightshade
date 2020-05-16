/** DISCLAIMER
 * Copyright (c) 2019-2020 Burak Günaydin at Beuth University
 *
 * A practical implementation of the following bachelor-thesis:
 *
 *      Appliance of procedural generation via fractal noise
 *
 * Distributed under the MIT License (MIT).
 * For more information read the accompanying LICENSE file in the
 * root directory or visit http://opensource.org/licenses/MIT)
 */
#ifndef ABSTRACTHANDLER_H
#define ABSTRACTHANDLER_H

#include <vector>

using namespace std;

/**
 * @brief The AbstractHandler class
 */
template <typename T>
class AbstractHandler
{
protected:
    /* */
    virtual void add(T *element) = 0;

    /* */
    virtual void remove(const unsigned int index) const = 0;

    /* */
    virtual T *get(const unsigned int index) const = 0;

    /* */
    virtual vector<T *> *getAll() const = 0;
};

#endif // ABSTRACTHANDLER_H
