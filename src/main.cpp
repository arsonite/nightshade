/** DISCLAIMER
 * MIT-License (C) https://github.com/arsonite
 */
#include <iostream>
#include <string>
#include <shlobj.h>
#include <windows.h>

#include "userenv.h"

#include <QApplication>
#include <QResource>

#include "graphics/gui/mainwindow.h"

using namespace std;

int main(int argc, char *argv[])
{
    /*
    QApplication a(argc, argv);
    MainWindow mainWindow;
    mainWindow.show();
    return a.exec();
    */

    char path[MAX_PATH];
    int homeDirectoryFound = 1;
    string homeDirectory = "";
    if (SHGetFolderPathA(NULL, CSIDL_PROFILE, NULL, 0, path) != S_OK) {
        homeDirectoryFound = 0;
    } else {
        homeDirectory = path;
    }

    int applicationDirectoryFound = 1;
    string applicationDirectory = "";
    if (SHGetFolderPathA(NULL, CSIDL_LOCAL_APPDATA, NULL, 0, path) != S_OK) {
        applicationDirectoryFound = 0;
    } else {
        applicationDirectory = path;
    }
    cout << homeDirectory << endl;
    cout << applicationDirectory << endl;
}
