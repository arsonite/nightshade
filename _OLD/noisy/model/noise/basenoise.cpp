/** DISCLAIMER
 * Copyright (c) 2019-2020 Burak Günaydin at Beuth University
 *
 * A practical implementation of the following bachelor-thesis:
 *
 *      Appliance of procedural generation via fractal BaseNoise
 *
 * Distributed under the MIT License (MIT).
 * For more information read the accompanying LICENSE file in the
 * root directory or visit http://opensource.org/licenses/MIT)
 */
#include <iostream>
#include <stdlib.h>

#include "basenoise.h"

/**
 * @brief BaseNoise::BaseNoise
 * @param seed
 */
BaseNoise::BaseNoise(unsigned int seed) : _seed(seed) {}

/**
 * @brief BaseNoise::~BaseNoise
 */
BaseNoise::~BaseNoise() {}

/**
 * @brief BaseNoise::populatePermutationtable
 */
void BaseNoise::populatePermutationtable()
{
    const unsigned int N = static_cast<unsigned int>(_permutationTable.size());
    const unsigned int MAX = 255;
    const unsigned int MIN = 0;

    /* */
    for(unsigned int i = 0; i < N; i++){
        _permutationTable[i] = static_cast<uint8_t>(i);
    }

    /* */
    srand(_seed);
    for(unsigned int i = 0; i < N; i++) {
        unsigned int randomIndex = rand() % (MAX - MIN) + MIN;
        unsigned int swap = _permutationTable[i];
        _permutationTable[i] = _permutationTable[randomIndex];
        _permutationTable[randomIndex] = static_cast<uint8_t>(swap);
    }
}

/**
 * @brief BaseNoise::BaseNoise
 * @param x
 * @return
 */
float BaseNoise::noise(const float x) {}

/**
 * @brief BaseNoise::BaseNoise
 * @param x
 * @param y
 * @return
 */
float BaseNoise::noise(const float x, const float y) {}

/**
 * @brief BaseNoise::setSeed
 * @param seed
 */
void BaseNoise::setSeed(unsigned int seed)
{
    _seed = seed;
}

/**
 * @brief BaseNoise::seed
 * @return
 */
unsigned int BaseNoise::seed()
{
    return _seed;
}
