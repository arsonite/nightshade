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
#ifndef BIOME_H
#define BIOME_H

#include <string>

#include <QColor>

using namespace std;

/**
 * @brief The Biome class
 */
class Biome
{
public:
    /* */
    Biome(string *name, float *value, QColor *color);

    /* */
    ~Biome();

    /* Getter */
    string *name();
    float *value();
    QColor *color();

    /* Setter */
    void setName(string name);
    void setValue(float value);
    void setColor(QColor color);

private:
    /* */
    string *_name;

    /* */
    float *_value;

    /* */
    QColor *_color;
};

#endif // BIOME_H
