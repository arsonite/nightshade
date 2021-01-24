QT += quick core gui opengl

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

CONFIG += c++20

# You can make your code fail to compile if it uses deprecated APIs.
# In order to do so, uncomment the following line.

SOURCES = $$files(src/*.cpp, true) \
    main.cpp

HEADERS = $$files(src/*.h, true) \
    src/engine/util/ID.h \
    src/engine/util/ID.h \
    src/graphics/gui/mainwindow.h \
    src/graphics/gui/mainwindow.h

HEADERS = $$files(src/*.ui, true)

TRANSLATIONS += \
    nightshade_en_US.ts

INCLUDEPATH += src/

# Default rules for deployment.
qnx: target.path = /tmp/$${TARGET}/bin
else: unix:!android: target.path = /opt/$${TARGET}/bin
!isEmpty(target.path): INSTALLS += target

DISTFILES += \
    src/audio/music/placeholder \
    src/audio/sfx/placeholder \
    src/audio/util/placeholder \
    src/debug/placeholder \
    src/engine/asset/base/placeholder \
    src/engine/asset/core/placeholder \
    src/engine/asset/util/core/placeholder \
    src/engine/asset/util/placeholder \
    src/engine/base/placeholder \
    src/engine/core/placeholder \
    src/engine/gen/placeholder \
    src/engine/math/placeholder \
    src/graphics/gfx/placeholder \
    src/graphics/util/placeholder \
    src/tests/placeholder

RESOURCES += \
    audio_music.qrc \
    audio_music.qrc \
    audio_sfx.qrc \
    audio_sfx.qrc
