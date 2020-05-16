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

#include "octave.h"

/**
 * @brief Octave::sethurst
 * @param hurst
 */
Octave::Octave() {}

/**
 * @brief Octave::Octave
 * @param hurst
 * @param frequency
 */
Octave::Octave(float *hurst, unsigned int *frequency): _hurst(hurst), _frequency(frequency) {}

/**
 * @brief Octave::Octave
 * @param hurst
 * @param frequency
 * @param curb
 */
Octave::Octave(float *hurst, unsigned int *frequency, unsigned int *curb):
    _hurst(hurst), _frequency(frequency), _curb(curb) {}

/**
 * @brief Octave::Octave
 * @param hurst<
 * @param frequency
 * @param curb
 * @param elevation
 */
Octave::Octave(float *hurst, unsigned int *frequency, unsigned int *curb, float *elevation):
    _hurst(hurst), _frequency(frequency), _curb(curb), _elevation(elevation) {}

/**
 * @brief Octave::sethurst
 * @param hurst
 */
void Octave::setHurst(float *hurst)
{
    _hurst = hurst;
}

/**
 * @brief Octave::setFrequency
 * @param frequency
 */
void Octave::setFrequency(unsigned int *frequency)
{
    _frequency = frequency;
}

/**
 * @brief Octave::setCurb
 * @param curb
 */
void Octave::setCurb(unsigned int *curb)
{
    _curb = curb;
}

/**
 * @brief Octave::setElevation
 * @param elevation
 */
void Octave::setElevation(float *elevation)
{
    _elevation = elevation;
}

/**
 * @brief Octave::hurst
 * @return
 */
float* Octave::hurst() const
{
    return _hurst;
}

/**
 * @brief Octave::frequency
 * @return
 */
unsigned int* Octave::frequency() const
{
    return _frequency;
}

/**
 * @brief Octave::curb
 * @return
 */
unsigned int* Octave::curb() const
{
    return _curb;
}

/**
 * @brief Octave::elevation
 * @return
 */
float* Octave::elevation() const
{
    return _elevation;
}
