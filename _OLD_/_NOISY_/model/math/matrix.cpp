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
#include <iostream>

#include "matrix.h"

/**
 * @brief Matrix::Matrix
 * @param width
 * @param height
 */
template <typename T>
Matrix<T>::Matrix(const unsigned int width, const unsigned int height):
    _internalArray(new T[width * height]),
    _width(width),
    _height(height) {}

/**
 * @brief Matrix::~Matrix
 */
template <typename T>
Matrix<T>::~Matrix()
{
    delete _internalArray;
}

/**
 * @brief Matrix::get
 * @param x
 * @param y
 * @return
 */
template <typename T>
T Matrix<T>::get(const unsigned int x, const unsigned int y)
{
    return _internalArray[calculateIndex(x, y)];
}

/**
 * @brief Matrix::set
 * @param x
 * @param y
 * @param value
 * @return
 */
template <typename T>
void Matrix<T>::insert(const unsigned int x, const unsigned int y, float value)
{
    _internalArray[calculateIndex(x, y)] = value;
}

/**
 * @brief Matrix::getWidth
 * @return
 */
template <typename T>
unsigned int Matrix<T>::width() const
{
    return _width;
}

/**
 * @brief Matrix::getHeight
 * @return
 */
template <typename T>
unsigned int Matrix<T>::height() const
{
    return _height;
}

/**
 * @brief Matrix::setWidth
 * @param width
 */
template <typename T>
void Matrix<T>::setWidth(unsigned int width)
{
    _width = width;
}

/**
 * @brief Matrix::setHeight
 * @param height
 */
template <typename T>
void Matrix<T>::setHeight(unsigned int height)
{
    _height = height;
}

/**
 * @brief Matrix::index
 * @param x
 * @param y
 * @return
 */
template <typename T>
unsigned int Matrix<T>::calculateIndex(const unsigned int x, const unsigned int y) const
{
    return static_cast<unsigned int>(x + _width * y);
}

/* */
template class Matrix<double>;
template class Matrix<float>;
template class Matrix<int>;
