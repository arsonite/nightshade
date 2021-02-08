QT += quick core gui opengl

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

CONFIG += c++20

# You can make your code fail to compile if it uses deprecated APIs.
# In order to do so, uncomment the following line.

SOURCES = $$files(src/*.cpp, true)

HEADERS = $$files(src/*.h, true)

FORMS = $$files(src/*.ui, true)

TRANSLATIONS += $$files(lang/*.ts, true)

INCLUDEPATH += src/

# Default rules for deployment.
qnx: target.path = /tmp/$${TARGET}/bin
else: unix:!android: target.path = /opt/$${TARGET}/bin
!isEmpty(target.path): INSTALLS += target

#DISTFILES += \

RESOURCES += $$files(sources/*.qrc, true)