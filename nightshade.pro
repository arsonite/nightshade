QT += quick core gui opengl

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

CONFIG += c++17

SOURCES = $$files(src/*.cpp, true) \
    src/util/path.cpp

HEADERS = $$files(src/*.h, true) \
    src/util/path.h

FORMS = $$files(src/*.ui, true)

TRANSLATIONS += $$files(lang/*.ts, true)

INCLUDEPATH += src/

#DISTFILES += \

#RESOURCES += $$files(sources/*.qrc, true)

# Default rules for deployment.
qnx: target.path = /tmp/$${TARGET}/bin
else: unix:!android: target.path = /opt/$${TARGET}/bin
!isEmpty(target.path): INSTALLS += target
