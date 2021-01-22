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

#ifndef BASENOISE_H
#define BASENOISE_H

#include <array>

#include "abstractnoise.h"

using namespace std;

/**
 * @brief The BaseNoise class
 */
class BaseNoise: public AbstractNoise
{
public:
    /* The single constructor with the solely positive seed as it's only parameter */
    explicit BaseNoise(unsigned int seed);

    /* */
    virtual ~BaseNoise();

    /* Inherited function */
    void populatePermutationtable() override;

    /* Inherited function */
    float noise(const float x) override;

    /* Inherited function */
    float noise(const float x, const float y) override;

    /* Getter */
    /* Inherited function */
    unsigned int seed() override;

    /* Setter */
    /* Inherited function */
    void setSeed(unsigned int seed) override;

protected:
    /* A solely positive integer representing the passed seed for the pseudo-number-generation */
    array<unsigned int, 256> _permutationTable;

    /* A solely positive integer representing the passed seed for the pseudo-number-generation */
    unsigned int _seed;
};

#endif // BASENOISE_H
