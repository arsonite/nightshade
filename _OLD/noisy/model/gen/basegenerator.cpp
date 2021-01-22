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
#include "basegenerator.h"

/**
 * @brief BaseGenerator
 */
BaseGenerator::BaseGenerator(): _seed(randomSeed()) {}

/**
 * @brief BaseGenerator::~BaseGenerator
 */
BaseGenerator::~BaseGenerator()
{
    delete _values;
}

/**
 * @brief BaseGenerator
 * @param seed
 */
BaseGenerator::BaseGenerator(unsigned int seed): _seed(seed), _values(new Matrix<float>(256, 256)) {}

/**
 * @brief BaseGenerator::Generator
 * @param width
 * @param height
 */
BaseGenerator::BaseGenerator(unsigned int width, unsigned int height):
    _seed(randomSeed()), _width(width), _height(height), _values(new Matrix<float>(width, height)) {}

/**
 * @brief BaseGenerator::Generator
 * @param seed
 * @param width
 * @param height
 */
BaseGenerator::BaseGenerator(unsigned int seed, unsigned int width, unsigned int height):
    _seed(seed), _width(width), _height(height), _values(new Matrix<float>(width, height)) {}


/**
 * @brief BaseGenerator::values
 * @return
 */
Matrix<float> *BaseGenerator::values()
{
    return _values;
}

/**
 * @brief getSeed
 * @return
 */
unsigned int BaseGenerator::seed()
{
    return _seed;
}

/**
 * @brief BaseGenerator::getWidth
 * @return
 */
unsigned int BaseGenerator::width()
{
    return _width;
}

/**
 * @brief BaseGenerator::getHeight
 * @return
 */
unsigned int BaseGenerator::height()
{
    return _height;
}

/**
 * @brief BaseGenerator::setSeed
 * @param seed
 */
void BaseGenerator::setSeed(unsigned int seed)
{
    _seed = seed;
}

/**
 * @brief BaseGenerator::setWidth
 * @param width
 */
void BaseGenerator::setWidth(unsigned int width)
{
    _width = width;
}

/**
 * @brief BaseGenerator::setHeight
 * @param height
 */
void BaseGenerator::setHeight(unsigned int height)
{
    _height = height;
}

/**
 * @brief BaseGenerator::generate
 * @param dimensions
 */
void BaseGenerator::generate() {}

/**
 * @brief BaseGenerator::randomSeed
 * @return
 */
unsigned int BaseGenerator::randomSeed()
{
    return static_cast<unsigned int>(time(nullptr));
}
