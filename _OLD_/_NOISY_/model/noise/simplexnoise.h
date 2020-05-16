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

#ifndef SIMPLEXNOISE_H
#define SIMPLEXNOISE_H

#include <cstddef>
#include <cstdint>

#include "basenoise.h"

/**
 * @brief The SimplexNoise class
 */
class SimplexNoise: public BaseNoise
{
public:
    /* */
    explicit SimplexNoise(unsigned int seed);

    /* */
    virtual ~SimplexNoise() override;

    /* Inherited function */
    void populatePermutationtable() override;

    /* Copyright (c) 2014-2018 Sebastien Rombauts (sebastien.rombauts@gmail.com) */
    uint8_t hash(const int32_t i);

    /* Copyright (c) 2014-2018 Sebastien Rombauts (sebastien.rombauts@gmail.com) */
    int32_t fastFloor(const float fp);

    /* Copyright (c) 2014-2018 Sebastien Rombauts (sebastien.rombauts@gmail.com) */
    float grad(const int32_t hash, const float x);

    /* Copyright (c) 2014-2018 Sebastien Rombauts (sebastien.rombauts@gmail.com) */
    float grad(const int32_t hash, const float x, const float y);

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
};

#endif // SIMPLEXNOISE_H
