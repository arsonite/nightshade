/** DISCLAIMER
 * MIT-License (C) Arsonite (2019-2021)
 */
#include "graphics/gui/mainwindow.h"

#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    //MainWindow w;
    //w.show();

    QResource::registerResource("/path/to/myresource.rcc");

    return a.exec();
}