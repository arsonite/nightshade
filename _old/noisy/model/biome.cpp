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

#include "biome.h"

/**
 * @brief Biome::Biome
 * @param name
 * @param value
 * @param color
 */
Biome::Biome(string *name, float *value, QColor *color) : _name(name), _value(value), _color(color) {}

/**
 * @brief Biome::~Biome
 */
Biome::~Biome()
{
    delete _name;
    delete _value;
    delete _color;
}

/**
 * @brief Biome::getName
 * @return
 */
string *Biome::name()
{
    return _name;
}

/**
 * @brief Biome::getValue
 * @return
 */
float *Biome::value()
{
    return _value;
}

/**
 * @brief Biome::getColor
 * @return
 */
QColor *Biome::color()
{
    return _color;
}
