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
#ifndef UICONTROLLER_H
#define UICONTROLLER_H

#include "controller/handler/handler.h"
#include "controller/factory/biomefactory.h"
#include "controller/factory/octavefactory.h"
#include "model/gen/proceduralgenerator.h"
#include "model/gen/randomgenerator.h"
#include "view/mainwindow.h"

using namespace std;

/**
 * @brief The UIController class
 */
class UIController: public QObject
{
    Q_OBJECT
public:
    UIController(MainWindow *mainWindow);

    ~UIController() override;

    void registerSignals();

public slots:
    void delegate(string id, string value);

    void kickstartGeneration();

    void loadFile();

private:
    MainWindow *_mainWindow;

    /* Model-factories */
    BiomeFactory *_biomeFactory;
    OctaveFactory *_octaveFactory;

    /* Model-handlers */
    Handler<Biome> *_biomeHandler;
    Handler<Octave> *_octaveHandler;

    /* Generators */
    ProceduralGenerator *_proceduralGenerator;
    RandomGenerator *_randomGenerator;
};

#endif // UICONTROLLER_H
