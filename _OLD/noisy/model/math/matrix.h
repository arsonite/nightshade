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
#ifndef MATRIX_H
#define MATRIX_H

/**
 * @brief The Matrix class
 */
template <typename T>
class Matrix
{
public:
    /* */
    explicit Matrix(const unsigned int width, const unsigned int height);

    /* */
    ~Matrix();

    // TODO: Alternatively implemented [] operators

    /* */
    T get(const unsigned int x, const unsigned int y);

    /* */
    void insert(const unsigned int x, const unsigned int y, const float value);

    /* */
    T remove(const unsigned int x, const unsigned int y);

    /* Getter */
    unsigned int width() const;
    unsigned int height() const;

    /* Setter */
    void setWidth(unsigned int width);
    void setHeight(unsigned int height);

private:
    /* Function to calculate the index of the 2D-array structured as a 1D-array */
    unsigned int calculateIndex(const unsigned int x, const unsigned int y) const;

    /* */
    T *_internalArray;

    /* */
    unsigned int _width;

    /* */
    unsigned int _height;
};

#endif // MATRIX_H
