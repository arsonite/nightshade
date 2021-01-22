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
#include <cstdint>
#include <numeric>
#include <algorithm>
#include <random>
#include <iterator>
#include <type_traits>
#include <QDebug>

#include "perlinnoise.h"

/**
 * @brief PerlinNoise::PerlinNoise
 * @param seed
 */
PerlinNoise::PerlinNoise(unsigned int seed): BaseNoise(seed)
{
    populatePermutationtable();
}

/**
 * @brief PerlinNoise::~PerlinNoise
 */
PerlinNoise::~PerlinNoise() {}

void PerlinNoise::populatePermutationtable()
{
    BaseNoise::populatePermutationtable();
}

/**
 * @brief PerlinNoise::seed
 * @return
 */
unsigned int PerlinNoise::seed()
{
    return _seed;
}

/**
 * @brief PerlinNoise::setSeed
 * @param seed
 */
void PerlinNoise::setSeed(unsigned int seed)
{
    BaseNoise::setSeed(seed);
}

/* From here on copyright: https://github.com/Reputeless/PerlinNoise/blob/master/PerlinNoise.hpp */

/**
 * @brief PerlinNoise::fade
 * @param t
 * @return
 */
float PerlinNoise::fade(const float t)
{
    return t * t * t * (t * (t * 6.0f - 15.0f) + 10.0f);
}

/**
 * @brief PerlinNoise::lerp
 * @param t
 * @param a
 * @param b
 * @return
 */
float PerlinNoise::lerp(const float t, const float a, const float b)
{
    return a + t * (b - a);
}

/**
 * @brief PerlinNoise::grad
 * @param hash
 * @param x
 * @param y
 * @param z
 * @return
 */
float PerlinNoise::grad(const std::uint8_t hash, const float x, const float y, const float z)
{
    const std::uint8_t h = hash & 15;
    const float u = h < 8.0f ? x : y;
    const float v = h < 4.0f ? y : h == 12.0f || h == 14.0f ? x : z;
    return ((h & 1) == 0 ? u : -u) + ((h & 2) == 0 ? v : -v);
}

/**
 * @brief PerlinNoise::noise
 * @param x
 * @return
 */
float PerlinNoise::noise(const float x)
{
    return noise(x, 0.0f, 0.0f);
}

/**
 * @brief PerlinNoise::noise
 * @param x
 * @param y
 * @return
 */
float PerlinNoise::noise(const float x, const float y)
{
    float dx = x;
    float dy = y;
    return noise(dx, dy, 0.0f);
}

/**
 * runtime: O(2^n)
 *
 * @brief PerlinNoise::noise
 * @param x
 * @param y
 * @param z
 * @return
 */
float PerlinNoise::noise(float x, float y, float z)
{
    // Find the unit cube that contains the point
    int X = (int) floor(x) & 255;
    int Y = (int) floor(y) & 255;
    int Z = (int) floor(z) & 255;

    // Find relative x, y,z of point in cube
    x -= x - floor(x);
    y -= x - floor(y);
    z -= x - floor(z);

    // Compute fade curves for each of x, y, z
    float u = fade(x);
    float v = fade(y);
    float w = fade(z);

    // Hash coordinates of the 8 cube corners
    int A = _permutationTable[X] + Y;
    int AA = _permutationTable[A] + Z;
    int AB = _permutationTable[A + 1] + Z;
    int B = _permutationTable[X + 1] + Y;
    int BA = _permutationTable[B] + Z;
    int BB = _permutationTable[B + 1] + Z;

    // Add blended results from 8 corners of cube
    double res = lerp(w, lerp(v, lerp(u, grad(_permutationTable[AA], x, y, z),
                    grad(_permutationTable[BA], x-1, y, z)),
                    lerp(u, grad(_permutationTable[AB], x, y-1, z),
                    grad(_permutationTable[BB], x-1, y-1, z))),
                    lerp(v, lerp(u, grad(_permutationTable[AA+1], x, y, z-1),
                    grad(_permutationTable[BA+1], x-1, y, z-1)),
                    lerp(u, grad(_permutationTable[AB+1], x, y-1, z-1),
                    grad(_permutationTable[BB+1], x-1, y-1, z-1))));
    return (res + 1.0) / 2.0;
}
