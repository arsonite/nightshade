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
#ifndef RANDOM_H
#define RANDOM_H

#include <vector>

#include "basegenerator.h"

/**
 * @brief The Random class
 */
class RandomGenerator: BaseGenerator
{
public:
    /**
     * @brief pseudo
     * @param x
     * @param y
     */
    vector<int> pseudo(const unsigned int n, const unsigned int min, const unsigned int max);

    /**
     * @brief real
     * @param x
     * @param y
     */
    vector<int> real(const unsigned int n, const unsigned int min, const unsigned int max);
};

#endif // RANDOM_H
