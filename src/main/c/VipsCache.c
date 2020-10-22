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

JNIEXPORT void JNICALL
Java_com_criteo_vips_VipsCache_print(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj)
{
    vips_cache_print();
}
        

JNIEXPORT void JNICALL
Java_com_criteo_vips_VipsCache_dropAll(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj)
{
    vips_cache_drop_all();
}
        

JNIEXPORT void JNICALL
Java_com_criteo_vips_VipsCache_setMax(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj, jint max)
{
    vips_cache_set_max(max);
}
        

JNIEXPORT void JNICALL
Java_com_criteo_vips_VipsCache_setMaxMem(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj, jlong max_mem)
{
    vips_cache_set_max_mem(max_mem);
}
        

JNIEXPORT jint JNICALL
Java_com_criteo_vips_VipsCache_getMax(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj)
{
    return vips_cache_get_max();
}
        

JNIEXPORT jint JNICALL
Java_com_criteo_vips_VipsCache_getSize(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj)
{
    return vips_cache_get_size();
}
        

JNIEXPORT jint JNICALL
Java_com_criteo_vips_VipsCache_getMaxMem(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj)
{
    return vips_cache_get_max_mem();
}
        

JNIEXPORT jint JNICALL
Java_com_criteo_vips_VipsCache_getMaxFiles(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj)
{
    return vips_cache_get_max_files();
}
        

JNIEXPORT void JNICALL
Java_com_criteo_vips_VipsCache_setMaxFiles(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj, jint max_files)
{
    vips_cache_set_max_files(max_files);
}
        

JNIEXPORT void JNICALL
Java_com_criteo_vips_VipsCache_setDump(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj, jboolean dump)
{
    vips_cache_set_dump(dump);
}
        

JNIEXPORT void JNICALL
Java_com_criteo_vips_VipsCache_setTrace(__attribute__((unused)) JNIEnv *env, __attribute__((unused)) jclass obj, jboolean trace)
{
    vips_cache_set_trace(trace);
}
        