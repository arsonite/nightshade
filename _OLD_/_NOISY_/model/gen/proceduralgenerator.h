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
#ifndef PROCEDURAL_H
#define PROCEDURAL_H

#include <math.h>

#include "basegenerator.h"
#include "model/noise/basenoise.h"
#include "model/noise/perlinnoise.h"
#include "model/noise/simplexnoise.h"

using namespace std;

/**
 * @brief The Procedural class
 */
class ProceduralGenerator: public BaseGenerator
{
public:
    /* Inherited function */
    explicit ProceduralGenerator();

    /* Inherited function */
    explicit ProceduralGenerator(unsigned int seed);

    /* Inherited function */
    explicit ProceduralGenerator(unsigned int width, unsigned int height);

    /* Inherited function */
    explicit ProceduralGenerator(unsigned int seed, unsigned int width, unsigned int height);

    explicit ProceduralGenerator(unsigned int seed, unsigned int width, unsigned int height,
                                 bool createIslandsOnly, bool erode, unsigned int octaves, float elevation,
                                 float erosionFactor, float lacunarity, float persistence, float scale);

    /* */
    virtual ~ProceduralGenerator() override;

    /* */
    float value(const unsigned int x, const unsigned int y);

    /* Inherited function */
    void generate() override;

    /* Getter */
    bool createIslandsOnly() const;
    bool erode() const;
    unsigned int octaves() const;
    float elevation() const;
    float erosionFactor() const;
    float lacunarity() const;
    float persistence() const;
    float scale() const;

    /* Inherited functions */
    Matrix<float> *values() override;
    unsigned int seed() override;
    unsigned int width() override;
    unsigned int height() override;

    /* Setter */
    void setCreateIslandsOnly(bool createIslandsOnly);
    void setErode(bool erode);
    void setOctaves(unsigned int octaves);
    void setElevation(float elevation);
    void setErosionFactor(float erosionFactor);
    void setLacunarity(float lacunarity);
    void setPersistence(float persistence);
    void setScale(float scale);

    /* Inherited functions */
    void setSeed(unsigned int seed) override;
    void setWidth(unsigned int width) override;
    void setHeight(unsigned int height) override;

private:
    /* */
    BaseNoise *_noise;

    /* */
    BaseNoise *_erosionNoise;

    bool _createIslandsOnly;

    bool _erode;

    unsigned int _octaves;

    float _elevation;

    float _erosionFactor;

    float _lacunarity;

    float _persistence;

    float _scale;
};

#endif // PROCEDURAL_H
