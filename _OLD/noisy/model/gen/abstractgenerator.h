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
#pragma once

#ifndef ABSTRACTGENERATOR_H
#define ABSTRACTGENERATOR_H

#include <vector>

#include "model/octave.h"
#include "model/math/matrix.h"

using namespace std;

/**
 * @brief The AbstractGenerator class
 */
class AbstractGenerator
{
public:
    /* */
    virtual void generate() = 0;

    /* Getter */
    virtual Matrix<float> *values() = 0;
    virtual unsigned int seed() = 0;
    virtual unsigned int width() = 0;
    virtual unsigned int height() = 0;

    /* Setter */
    virtual void setSeed(unsigned int seed) = 0;
    virtual void setWidth(unsigned int width) = 0;
    virtual void setHeight(unsigned int height) = 0;

protected:
    /* */
    virtual unsigned int randomSeed() = 0;
};

#endif // ABSTRACTGENERATOR_H
