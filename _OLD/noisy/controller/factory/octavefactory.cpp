#include "octavefactory.h"

/**
 * @brief OctaveFactory::create
 * @return
 */
Octave *OctaveFactory::create(float coefficient, unsigned int frequency)
{
    return new Octave(new float(coefficient), new unsigned int(frequency));
}

/**
 * @brief OctaveFactory::create
 * @param coefficient
 * @param frequency
 * @param curb
 * @return
 */
Octave *OctaveFactory::create(float coefficient, unsigned int frequency, unsigned int curb)
{
    return new Octave(new float(coefficient), new unsigned int(frequency), new unsigned int(curb));
}

/**
 * @brief OctaveFactory::create
 * @param coefficient
 * @param frequency
 * @param curb
 * @param elevation
 * @return
 */
Octave* OctaveFactory::create(float coefficient, unsigned int frequency, unsigned int curb, float elevation)
{
    return new Octave(new float(coefficient), new unsigned int(frequency), new unsigned int(curb), new float(elevation));
}
