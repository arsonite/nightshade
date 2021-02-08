#ifndef OCTAVEFACTORY_H
#define OCTAVEFACTORY_H

#include "model/octave.h"

/**
 * @brief The OctaveFactory class
 */
class OctaveFactory
{
public:
    /* */
    static Octave* create(float coefficient, unsigned int frequency);

    /* */
    static Octave* create(float coefficient, unsigned int frequency, unsigned int curb);

    /* */
    static Octave* create(float coefficient, unsigned int frequency, unsigned int curb, float elevation);
};

#endif // OCTAVEFACTORY_H
