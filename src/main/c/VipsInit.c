 /*
  Copyright (c) 2020 Criteo

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

#include <jni.h>
#include <vips/vips.h>

JNIEXPORT jstring JNICALL
Java_com_criteo_vips_VipsInit_getArgv0(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj)
{
    char *cret = NULL;

    cret = vips_get_argv0();

    return (*env)->NewStringUTF(env, cret);
}
        

JNIEXPORT jint JNICALL
Java_com_criteo_vips_VipsInit_init(JNIEnv *env, __attribute__((unused)) jclass obj, jstring argv0)
{
    char *cargv0 = (*env)->GetStringUTFChars(env, argv0, NULL);

    return vips_init(cargv0);
}
        

JNIEXPORT void JNICALL
Java_com_criteo_vips_VipsInit_checkInit(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj)
{
    vips_check_init();
}
        

JNIEXPORT void JNICALL
Java_com_criteo_vips_VipsInit_threadShutdown(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj)
{
    vips_thread_shutdown();
}
        

JNIEXPORT void JNICALL
Java_com_criteo_vips_VipsInit_shutdown(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj)
{
    vips_shutdown();
}
        

JNIEXPORT jstring JNICALL
Java_com_criteo_vips_VipsInit_guessPrefix(JNIEnv *env, __attribute__((unused)) jclass obj, jstring argv0, jstring env_name)
{
    char *cargv0 = (*env)->GetStringUTFChars(env, argv0, NULL);    
    char *cenv_name = (*env)->GetStringUTFChars(env, env_name, NULL);    
    char *cret = NULL;

    cret = vips_guess_prefix(cargv0, cenv_name);

    return (*env)->NewStringUTF(env, cret);
}
        

JNIEXPORT jstring JNICALL
Java_com_criteo_vips_VipsInit_guessLibdir(JNIEnv *env, __attribute__((unused)) jclass obj, jstring argv0, jstring env_name)
{
    char *cargv0 = (*env)->GetStringUTFChars(env, argv0, NULL);    
    char *cenv_name = (*env)->GetStringUTFChars(env, env_name, NULL);    
    char *cret = NULL;

    cret = vips_guess_libdir(cargv0, cenv_name);

    return (*env)->NewStringUTF(env, cret);
}
        

JNIEXPORT jstring JNICALL
Java_com_criteo_vips_VipsInit_versionString(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj)
{
    char *cret = NULL;

    cret = vips_version_string();

    return (*env)->NewStringUTF(env, cret);
}
        

JNIEXPORT jint JNICALL
Java_com_criteo_vips_VipsInit_version(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj, jint flag)
{
    return vips_version(flag);
}
        

JNIEXPORT void JNICALL
Java_com_criteo_vips_VipsInit_leakSet(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj, jboolean leak)
{
    vips_leak_set(leak);
}
        