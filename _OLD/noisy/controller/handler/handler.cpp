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

#include "handler.h"

/**
 * @brief Handler<T>::Handler
 */
template <typename T>
Handler<T>::Handler(): _list(new vector<T *>()){}

/**
 * @brief Handler::~Handler
 */
template <typename T>
Handler<T>::~Handler()
{
    delete _list;
}

/**
 * @brief Handler<T>::add
 * @param biome
 */
template <typename T>
void Handler<T>::add(T *element)
{
    _list->push_back(element);
}

/**
 * @brief Handler<T>::remove
 * @param index
 */
template <typename T>
void Handler<T>::remove(const unsigned int index) const
{
    _list->erase(_list->begin() + index - 1);
}

/**
 * @brief Handler<T>::get
 * @param index
 * @return
 */
template <typename T>
T *Handler<T>::get(const unsigned int index) const
{
    return _list->at(index);
}

/**
 * @brief Handler<T>::getAll
 * @return
 */
template <typename T>
vector<T *> *Handler<T>::getAll() const
{
    return _list;
}

/* */
template class Handler<Biome>;
template class Handler<Octave>;
