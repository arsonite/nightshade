/** DISCLAIMER
 * Beuth University
 * Bachelor-Thesis: Appliance of procedural generation via fractal noise
 * Burak Günaydin (2019-2020)
 */
#include <math.h>
#include <stdlib.h>

#include "randomgenerator.h"

using namespace std;

vector<int> RandomGenerator::pseudo(const unsigned int n, const unsigned int min, const unsigned int max)
{
    vector<int> temp = vector<int>();
    for (int i = 0; i < n; i++)
    {
        int val = rand() % (max - min) + min;
        temp.push_back(round(val));
    }
    return temp;
}
