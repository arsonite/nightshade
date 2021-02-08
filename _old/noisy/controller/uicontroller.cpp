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
#include <QDebug>
#include <QFileDialog>
#include <QImageReader>

#include "uicontroller.h"
#include "view/slider.h"
#include "model/math/matrix.h"

using namespace std;

/**
 * @brief UIController::UIController
 */
UIController::UIController(MainWindow *mainWindow): _mainWindow(mainWindow)
{
    /* Initializing the default biomes and their respective values via the factory class */
    _biomeHandler = new Handler<Biome>();
    _biomeHandler->add(BiomeFactory::create("deepocean", 0.25f, 0, 25, 100));
    _biomeHandler->add(BiomeFactory::create("ocean", 0.3f, 25, 50, 150));
    _biomeHandler->add(BiomeFactory::create("sea", 0.35f, 25, 50, 150));
    _biomeHandler->add(BiomeFactory::create("water", 0.4f, 50, 75, 175));
    _biomeHandler->add(BiomeFactory::create("shallow", 0.45f, 75, 100, 200));
    _biomeHandler->add(BiomeFactory::create("beach", 0.5f, 200, 200, 100));
    _biomeHandler->add(BiomeFactory::create("mud", 0.55f, 75, 175, 75));
    _biomeHandler->add(BiomeFactory::create("meadow", 0.6f, 25, 125, 25));
    _biomeHandler->add(BiomeFactory::create("green", 0.7f, 50, 150, 50));
    _biomeHandler->add(BiomeFactory::create("forest", 0.75f, 15, 100, 15));
    _biomeHandler->add(BiomeFactory::create("heavyrock", 0.8f, 80, 60, 40));
    _biomeHandler->add(BiomeFactory::create("rock", 0.85f, 100, 80, 60));
    _biomeHandler->add(BiomeFactory::create("lightrock", 0.9f, 120, 100, 80));
    _biomeHandler->add(BiomeFactory::create("snow", 0.95f, 250, 250, 250));
    _biomeHandler->add(BiomeFactory::create("ice", 1.0f, 230, 230, 255));

    /* Default parameters */
    int seed = time(NULL);
    bool randomSeed = true;
    bool realtime = false;
    bool bw = false;
    bool erode = true;
    bool islandsOnly = false;
    unsigned int octaves = 8;
    float elevation = 1.0f;
    float erosionFactor = -0.0f;
    float persistence = 0.5f;
    float lacunarity = 2.0f;
    float scale = 0.3f;

    /* Executing creation methods of MainWindow after initializing
     * the controller necessities to counter segmentation fault errors
     */
    mainWindow->createSeedField(seed);
    mainWindow->createGenerateButton();
    mainWindow->createImageLoadButton();
    mainWindow->createRandomSeedCheckbox(randomSeed);
    mainWindow->createRealtimeCheckbox(realtime);
    mainWindow->createBWCheckbox(bw);
    mainWindow->createErodeCheckbox(erode);
    mainWindow->createIslandsOnlyCheckbox(islandsOnly);
    //mainWindow->createNoiseRadiobuttons(); Only Simplex Noise needed
    mainWindow->createfBmSliders(elevation, erosionFactor, persistence, lacunarity, scale);

    /* Make the workspace of the procedural generator a square */
    _proceduralGenerator = new ProceduralGenerator(seed,
                                                   min(_mainWindow->width(), _mainWindow->height()),
                                                   min(_mainWindow->width(), _mainWindow->height()),
                                                   islandsOnly, erode, octaves, elevation, erosionFactor, lacunarity, persistence, scale);

    /* Registering controller signals before MainWindow signals */
    registerSignals();
    _mainWindow->registerSignals();

    kickstartGeneration();
}

/**
 * @brief UIController::~UIController
 */
UIController::~UIController()
{
    delete _mainWindow;
}

/**
 * Method to register and connect the signals of the UIController of the MainWindow to enable
 * MVC-pattern usual seperation of concern.
 *
 * @brief UIController::registerSignals
 */
void UIController::registerSignals()
{
    /* Connecting MainWindow signals to UIController signals */
    connect(_mainWindow, &MainWindow::delegation, this, &UIController::delegate);
}

/**
 * @brief UIController::delegate
 * @param id
 */
void UIController::delegate(string id, string value)
{
    qDebug() << QString::fromStdString(id) << " " << QString::fromStdString(value);

    if(id == "_generateButton") {
        kickstartGeneration();
    } else if(id == "_loadFileButton") {
        loadFile();
    } else if(id == "_erodeCheckbox") {
        _proceduralGenerator->setErode(!_proceduralGenerator->erode());
    } else if(id == "_islandsOnlyCheckbox") {
        _proceduralGenerator->setCreateIslandsOnly(!_proceduralGenerator->createIslandsOnly());
    } else if(id == "_elevation") {
        _proceduralGenerator->setElevation(_mainWindow->fBmSliders()->at(id)->value());
    } else if(id == "_erosionFactor") {
        _proceduralGenerator->setErosionFactor(_mainWindow->fBmSliders()->at(id)->value());
    } else if(id == "_persistence") {
        _proceduralGenerator->setPersistence(_mainWindow->fBmSliders()->at(id)->value());
    } else if(id == "_lacunarity") {
        _proceduralGenerator->setLacunarity(_mainWindow->fBmSliders()->at(id)->value());
    } else if(id == "_scale") {
        _proceduralGenerator->setScale(_mainWindow->fBmSliders()->at(id)->value());
    }

    if(_mainWindow->liveRenderCheckbox()->isChecked()) {
        kickstartGeneration();
    }
}

/**
 * @brief UIController::kickstartGeneration
 * @return
 */
void UIController::kickstartGeneration()
{
    int seed;
    if(_mainWindow->randomSeedCheckbox()->isChecked()) {
        seed = time(NULL);
        _mainWindow->seedInput()->setText(QString::number(seed));
    } else {
        seed = _mainWindow->seedInput()->text().toInt();
    }
    _proceduralGenerator->setSeed(seed);
    _proceduralGenerator->generate();
    _mainWindow->draw(_proceduralGenerator->values(), _biomeHandler);
}

/**
 * @brief UIController::loadFile
 */
void UIController::loadFile()
{
    QString path = QFileDialog::getOpenFileName(_mainWindow, tr("Open Image"), "./ressources/", tr("Image Files (*.png *.jpg)"));
    QImageReader *reader = new QImageReader(path);
    QImage *img = new QImage(reader->read());
    Matrix<float> *m = new Matrix<float>(img->width(), img->height());
    for(unsigned int x = 0; x < static_cast<unsigned int>(img->width()); x++) {
        for(unsigned int y = 0; y < static_cast<unsigned int>(img->height()); y++) {
            QColor color(img->pixel(x, y));
            /* Normalize greyscale rgb to [0.0, 1.0] */
            float value =  1.0f * color.red() / 255.0f;
            m->insert(x, y, value);
        }
    }
    _mainWindow->draw(m, _biomeHandler);
    delete m;
}
