/** DISCLAIMER
 * Copyright (c) 2019-2020 Burak Günaydin at Beuth University
 *
 * A practical implementation of the following bachelor-thesis:
 *
 *      Appliance of ProceduralGenerator generation via fractal noise
 *
 * Distributed under the MIT License (MIT).
 * For more information read the accompanying LICENSE file in the
 * root directory or visit http://opensource.org/licenses/MIT)
 */

#include <QDebug>

#include <chrono>
#include <iostream>

#include <math.h>

#include "proceduralgenerator.h"

using namespace std;

/**
 * @brief ProceduralGenerator::ProceduralGenerator
 * @param width
 * @param height
 */
ProceduralGenerator::ProceduralGenerator(unsigned int width, unsigned int height):
    BaseGenerator(width, height), _noise(new SimplexNoise(_seed)), _erosionNoise(new SimplexNoise(_seed + 1)) {}

/**
 * @brief ProceduralGenerator::ProceduralGenerator
 * @param seed
 * @param width
 * @param height
 */
ProceduralGenerator::ProceduralGenerator(unsigned int seed, unsigned int width, unsigned int height):
    BaseGenerator(seed, width, height), _noise(new SimplexNoise(seed)), _erosionNoise(new SimplexNoise(_seed + 1)) {}

/**
 * @brief ProceduralGenerator::ProceduralGenerator
 * @param seed
 * @param width
 * @param height
 * @param createIslandsOnly
 * @param erode
 * @param octaves
 * @param distanceFactor
 * @param elevation
 * @param erosionFactor
 * @param lacunarity
 * @param persistence
 * @param scale
 */
ProceduralGenerator::ProceduralGenerator(unsigned int seed, unsigned int width, unsigned int height,
                                         bool createIslandsOnly, bool erode, unsigned int octaves,
                                         float elevation, float erosionFactor, float lacunarity,
                                         float persistence, float scale):
    BaseGenerator(seed, width, height), _noise(new SimplexNoise(seed)), _erosionNoise(new SimplexNoise(_seed + 1)),
    _createIslandsOnly(createIslandsOnly), _erode(erode), _octaves(octaves), _elevation(elevation), _erosionFactor(erosionFactor),
    _lacunarity(lacunarity), _persistence(persistence), _scale(scale)
{

}

/**
 * @brief ProceduralGenerator::~ProceduralGenerator
 */
ProceduralGenerator::~ProceduralGenerator() {}

/**
 * @brief ProceduralGenerator::getValue
 * @param x
 * @param y
 * @return
 */
float ProceduralGenerator::value(const unsigned int x, const unsigned int y)
{
    return _values->get(x, y);
}

/**
 * Big O ignores statements
 *
 * runtime-scale: O(n!) > O(2^n) > O(n^2) > O(n log n) > O(n) > O(log n), O(1)
 *
 * runtime: O((n * m * p) + (n * m))
 *
 * @brief ProceduralGenerator::generate2D
 * @param x
 * @param y
 * @return
 */
void ProceduralGenerator::generate()
{
    using namespace std;

    chrono::steady_clock::time_point begin = std::chrono::steady_clock::now();
    chrono::steady_clock::time_point end = std::chrono::steady_clock::now();

    cout << "Time difference = " << std::chrono::duration_cast<std::chrono::microseconds>(end - begin).count() << "[µs]" << std::endl;
    cout << "Time difference = " << std::chrono::duration_cast<std::chrono::nanoseconds> (end - begin).count() << "[ns]" << std::endl;

    /* Maximum and minimum values for later normalization */
    float mininum = 0.0f;
    float maximum = 0.0f;

    for (unsigned int x = 0; x < _width; x++) {
        for (unsigned int y = 0; y < _height; y++) {
            float nx = static_cast<float>(x) / _width; // Smallified x-coordinate
            float ny = static_cast<float>(y) / _height; // Smallified y-coordinate
            float z = 0.0f; // Noise "z" value
            float e = 0.0f; // Non-simulative erosion-factor

            float amplitudeSum = 0.0f; // Summation of successively decreasing amplitude
            for(unsigned int i = 1; i <= _octaves; i++) {
                float frequency = static_cast<float>(pow(_lacunarity, i));
                float amplitude = static_cast<float>(pow(_persistence, i));
                amplitudeSum += amplitude;
                z += (amplitude * _noise->noise((nx * frequency) * _scale, (ny * frequency) * _scale)); // fBm
                if(_erode) {
                    /* Absolute fBm */
                    e += (amplitude * _erosionFactor - (abs(_erosionNoise->noise((nx * frequency) * _scale, (ny * frequency) * _scale))));
                }
            }
            if(_erode) {
              z *= e; // Superimpose erosion onto the height
            }
            z /= amplitudeSum; // Get the average retrieved from the incremented amplitude

            if(_createIslandsOnly) {
                /* Calculate radial gradient:
                 * https://math.stackexchange.com/questions/1617721/formula-to-create-a-radial-gradient
                 */
                unsigned int radiusX = _width / 2;
                unsigned int radiusY = _height / 2;
                float distance = sqrt((radiusX - x) * (radiusX - x) + (radiusY - y) * (radiusY - y));
                z = z - (distance / min(radiusX, radiusY));
            }

            if(z < mininum) {
                mininum = z;
            } else if(z > maximum) {
                maximum = z;
            }
            z *= _elevation;

            _values->insert(x, y, z);
        }
    }

    /* Normalization of z values to [0.0, 1.0] */
    for (unsigned int x = 0; x < _width; x++) {
        for (unsigned int y = 0; y < _height; y++) {
            float z = _values->get(x, y);
            z = (z - mininum) / (maximum - mininum);
            _values->insert(x, y, z);
        }
    }
}

/**
 * @brief ProceduralGenerator::createIslandsOnly
 * @return
 */
bool ProceduralGenerator::createIslandsOnly() const
{
    return _createIslandsOnly;
}

/**
 * @brief ProceduralGenerator::erode
 * @return
 */
bool ProceduralGenerator::erode() const
{
     return _erode;
}

/**
 * @brief ProceduralGenerator::octaves
 * @return
 */
unsigned int ProceduralGenerator::octaves() const
{
     return _octaves;
}

/**
 * @brief ProceduralGenerator::elevation
 * @return
 */
float ProceduralGenerator::elevation() const
{
     return _elevation;
}

/**
 * @brief ProceduralGenerator::erosionFactor
 * @return
 */
float ProceduralGenerator::erosionFactor() const
{
     return _erosionFactor;
}

/**
 * @brief ProceduralGenerator::lacunarity
 * @return
 */
float ProceduralGenerator::lacunarity() const
{
     return _lacunarity;
}

/**
 * @brief ProceduralGenerator::persistence
 * @return
 */
float ProceduralGenerator::persistence() const
{
     return _persistence;
}

/**
 * @brief ProceduralGenerator::values
 * @return
 */
Matrix<float> *ProceduralGenerator::values()
{
    return BaseGenerator::values();
}

/**
 * @brief ProceduralGenerator::seed
 * @return
 */
unsigned int ProceduralGenerator::seed()
{
    return BaseGenerator::seed();
}

/**
 * @brief ProceduralGenerator::width
 * @return
 */
unsigned int ProceduralGenerator::width()
{
    return BaseGenerator::width();
}

/**
 * @brief ProceduralGenerator::height
 * @return
 */
unsigned int ProceduralGenerator::height()
{
    return BaseGenerator::height();
}

/**
 * @brief ProceduralGenerator::setCreateIslandsOnly
 * @param createIslandsOnly
 */
void ProceduralGenerator::setCreateIslandsOnly(bool createIslandsOnly)
{
    _createIslandsOnly = createIslandsOnly;
}

/**
 * @brief ProceduralGenerator::setErode
 * @param erode
 */
void ProceduralGenerator::setErode(bool erode)
{
    _erode = erode;
}

/**
 * @brief ProceduralGenerator::setOctaves
 * @param octaves
 */
void ProceduralGenerator::setOctaves(unsigned int octaves)
{
    _octaves = octaves;
}

/**
 * @brief ProceduralGenerator::setElevation
 * @param elevation
 */
void ProceduralGenerator::setElevation(float elevation)
{
    _elevation = elevation;
}

/**
 * @brief ProceduralGenerator::setErosionFactor
 * @param erosionFactor
 */
void ProceduralGenerator::setErosionFactor(float erosionFactor)
{
    _erosionFactor = erosionFactor;
}

/**
 * @brief ProceduralGenerator::setLacunarity
 * @param lacunarity
 */
void ProceduralGenerator::setLacunarity(float lacunarity)
{
    _lacunarity = lacunarity;
}

/**
 * @brief ProceduralGenerator::setPersistence
 * @param persistence
 */
void ProceduralGenerator::setPersistence(float persistence)
{
    _persistence = persistence;
}

/**

 * @brief ProceduralGenerator::setScale
 * @param scale
 */
void ProceduralGenerator::setScale(float scale)
{
    _scale = scale;
}

/**
 * @brief ProceduralGenerator::setSeed
 * @param seed
 */
void ProceduralGenerator::setSeed(unsigned int seed)
{
    BaseGenerator::setSeed(seed);
    _noise->setSeed(seed);
    _erosionNoise->setSeed(seed);
}

/**
 * @brief ProceduralGenerator::setWidth
 * @param width
 */
void ProceduralGenerator::setWidth(unsigned int width)
{
    BaseGenerator::setWidth(width);
}

/**
 * @brief ProceduralGenerator::setHeight
 * @param height
 */
void ProceduralGenerator::setHeight(unsigned int height)
{
    BaseGenerator::setHeight(height);
}
