SOURCES += \
    src/controller/*.cpp \
    src/controller/factory/*.cpp \
    src/controller/handler/*.cpp \
    src/model/*.cpp \
    src/model/gen/*.cpp \
    src/model/math/*.cpp \
    src/model/noise/*.cpp \
    src/view/*.cpp \
    src/*.cpp \

HEADERS += \
    src/controller/*.h \
    src/controller/factory/*.h \
    src/controller/handler/*.h \
    src/model/*.h \
    src/model/gen/*.h \
    src/model/math/*.h \
    src/model/noise/*.h \
    src/view/*.h \
    src/*.h \

FORMS += \
    src/view/*.ui \

DISTFILES += \
    .qmake.stash \
    debug/noisy.exe \
    object_script.noisy.Debug \
    object_script.noisy.Release \
