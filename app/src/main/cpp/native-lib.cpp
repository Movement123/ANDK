#include <jni.h>
#include <string>


extern "C"
JNIEXPORT void JNICALL
Java_com_ren_andk_RenPlayer_native_1prepare(JNIEnv *env, jobject thiz, jstring data_source) {


    const char *dataSource = env->GetStringUTFChars(data_source, NULL);


    env->ReleaseStringUTFChars(data_source, dataSource);

}