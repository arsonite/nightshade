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
#ifndef BASEGENERATOR_H
#define BASEGENERATOR_H

#include <map>

#include <time.h>

#include "abstractgenerator.h"

/**
 * @brief The BaseGenerator class
 */
class BaseGenerator: public AbstractGenerator
{
public:
    /* */
    explicit BaseGenerator();

    /* */
    virtual ~BaseGenerator();

    /* */
    explicit BaseGenerator(unsigned int seed);

    /* */
    explicit BaseGenerator(unsigned int width, unsigned int height);

    /* */
    explicit BaseGenerator(unsigned int seed, unsigned int width, unsigned int height);

    /* Inherited function */
    void generate() override;

    /* Getter */
    /* Inherited functions */
    Matrix<float> *values() override;
    unsigned int seed() override;
    unsigned int width() override;
    unsigned int height() override;

    /* Setter */
    /* Inherited functions */
    void setSeed(unsigned int seed) override;
    void setWidth(unsigned int width) override;
    void setHeight(unsigned int height) override;

protected:
    /* */
    unsigned int randomSeed() override;

    /* */
    Matrix<float> *_values;

    /* */
    unsigned int _seed;

    /* */
    unsigned int _width;

    /* */
    unsigned int _height;
};

#endif // BASEGENERATOR_H
