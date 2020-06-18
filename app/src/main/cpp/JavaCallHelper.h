//
// Created by rengu on 2020/6/12.
//

#ifndef ANDK_JAVACALLHELPER_CPP
#define ANDK_JAVACALLHELPER_CPP

#include <jni.h>

class JavaCallHelper {

public:
    JavaCallHelper(JavaVM *vm, JNIEnv *env, jobject instance);

    ~JavaCallHelper();

private:
    JavaVM *vm;
    JNIEnv *env;
    jobject instance;
    jmethodID onErrorId;
    jmethodID onPrepareId;
};

#endif //ANDK_JAVACALLHELPER_CPP
