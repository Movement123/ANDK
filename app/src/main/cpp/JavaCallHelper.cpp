//
// Created by rengu on 2020/6/12.
//

#include "JavaCallHelper.h"
#include "macro.h"


JavaCallHelper::JavaCallHelper(JavaVM *vm, JNIEnv *env, jobject instance) {
    this->vm = vm;
    this->env = env;
    this->instance = env->NewGlobalRef(instance);
}

JavaCallHelper::~JavaCallHelper() {
    env->DeleteGlobalRef(instance);

    jclass clazz = env->GetObjectClass(instance);
    onErrorId = env->GetMethodID(clazz,"onError","(I)V");
}