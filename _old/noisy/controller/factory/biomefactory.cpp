#include "biomefactory.h"

/**
 * @brief BiomeFactory::create
 * @param name
 * @param value
 * @param color
 * @return
 */
Biome *BiomeFactory::create(
        string name,
        float value,
        unsigned int red,
        unsigned int green,
        unsigned int blue,
        bool alpha)
{
    return new Biome(
                new string(name),
                new float(value),
                new QColor(
                    static_cast<int>(red),
                    static_cast<int>(green),
                    static_cast<int>(blue)
                    )
                );
}
