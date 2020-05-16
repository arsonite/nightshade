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
#ifndef HANDLER_H
#define HANDLER_H

#include "abstracthandler.h"
#include "model/biome.h"
#include "model/octave.h"

/**
 * @brief The Handler class
 */
template <typename T>
class Handler: public AbstractHandler<T>
{
public:
    /* */
    Handler();

    /* */
    virtual ~Handler();

    /* Inherited function */
    void add(T *element) override;

    /* Inherited function */
    void remove(const unsigned int index) const override;

    /* Inherited function */
    T *get(const unsigned int index) const override;

    /* Inherited function */
    vector<T *> *getAll() const override;

private:
    /* */
    vector<T *> *_list;

    /* */
    size_t *_size;
};

#endif // HANDLER_H
