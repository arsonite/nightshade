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

#ifndef PERLINNOISE_H
#define PERLINNOISE_H

#include "basenoise.h"

/**
 * @brief The PerlinNoise class
 */
class PerlinNoise: public BaseNoise
{
public:
    /* */
    explicit PerlinNoise(unsigned int seed);

    /* */
    virtual ~PerlinNoise() override;

    /* Inherited function */
    void populatePermutationtable() override;

    /* */
    float fade(const float t);

    /* */
    float lerp(const float t, const float a, const float b);

    /* */
    float grad(const std::uint8_t hash, const float x, const float y, const float z);

    /* Inherited function */
    float noise(const float x) override;

    /* Inherited function */
    float noise(const float x, const float y) override;

    /* */
    float noise(float x, float y, float z);

    /* Getter */
    /* Inherited function */
    unsigned int seed() override;

    /* Setter */
    /* Inherited function */
    void setSeed(unsigned int seed) override;
};

#endif // PERLINNOISE_H
