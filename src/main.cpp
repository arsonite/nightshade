/** DISCLAIMER
 * MIT-License (C) https://github.com/arsonite
 */
#include <QApplication>
#include <QResource>

#include "graphics/gui/mainwindow.h"

/* TEST-IMPORTS */
#include "util/directory.h"
#include "util/file.h"
#include "util/logger.h"
#include "util/os.h"
/****************/

int main(int argc, char *argv[])
{
    /*
    QApplication a(argc, argv);
    MainWindow mainWindow;
    mainWindow.show();
    return a.exec();
    */

   OS::init();
   Directory::init(*OS::applicationPath());
   File::init(*OS::applicationPath());

   std::string applicationPath = OS::applicationPath()->url();
   Logger *logger = new Logger("main.cpp");
   logger->print(applicationPath);
}
