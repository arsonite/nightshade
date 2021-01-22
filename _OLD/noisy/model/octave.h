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
#ifndef OCTAVE_H
#define OCTAVE_H

/**
 * @brief The Octave class
 */
class Octave
{
public:
    /* Standard constructor */
    Octave();

    /* Alternative constructor */
    Octave(float *hurst, unsigned int *frequency);

    /* Alternative constructor */
    Octave(float *hurst, unsigned int *frequency, unsigned int *curb);

    /* Complete constructor */
    Octave(float *hurst, unsigned int *frequency, unsigned int *curb, float *elevation);

    /* Set-functions for class members */
    void setHurst(float *hurst);

    /* */
    void setFrequency(unsigned int *frequency);

    /* */
    void setCurb(unsigned int *curb);

    /* */
    void setElevation(float *elevation);

    /* Get-functions for class members */
    float* hurst() const;

    /* */
    unsigned int* frequency() const;

    /* */
    unsigned int* curb() const;

    /* */
    float* elevation() const;

private:
    /* */
    float *_hurst;

    /* */
    unsigned int *_frequency;

    /* */
    unsigned int *_curb;

    /* */
    float *_elevation;

    /*
    float _lacunarity;
    float _persistence;
    float _scale;
    */
};

#endif // OCTAVE_H

/*
float SimplexNoise::fractal(size_t octaves, float x) const {
    float output    = 0.f;
    float denom     = 0.f;
    float frequency = mFrequency;
    float amplitude = mAmplitude;

    for (size_t i = 0; i < octaves; i++) {
        output += (amplitude * noise(x * frequency));
        denom += amplitude;

        frequency *= mLacunarity;
        amplitude *= mPersistence;
    }

    return (output / denom);
}
float SimplexNoise::fractal(size_t octaves, float x, float y) const {
    float output = 0.f;
    float denom  = 0.f;
    float frequency = mFrequency;
    float amplitude = mAmplitude;

    for (size_t i = 0; i < octaves; i++) {
        output += (amplitude * noise(x * frequency, y * frequency));
        denom += amplitude;

        frequency *= mLacunarity;
        amplitude *= mPersistence;
    }

    return (output / denom);
}
*/
