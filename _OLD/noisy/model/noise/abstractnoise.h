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

#ifndef ABSTRACTNOISE_H
#define ABSTRACTNOISE_H

#include <cstddef>
#include <cstdint>

/**
 * @brief The AbstractNoise class
 */
class AbstractNoise
{
public:
    /* */
    virtual void populatePermutationtable() = 0;

    /* */
    virtual float noise(const float x) = 0;

    /* */
    virtual float noise(const float x, const float y) = 0;

    /* Getter */
    virtual unsigned int seed() = 0;

    /* Setter */
    virtual void setSeed(unsigned int seed) = 0;
};

#endif // ABSTRACTNOISE_H
