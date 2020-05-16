#ifndef BIOMEFACTORY_H
#define BIOMEFACTORY_H

#include <array>

#include "model/biome.h"

using namespace std;

/**
 * @brief The BiomeFactory class
 */
class BiomeFactory
{
public:
    /* */
    static Biome* create(
            string name,
            float value,
            unsigned int red,
            unsigned int green,
            unsigned int blue,
            bool alpha = false
            );
};

#endif // BIOMEFACTORY_H
