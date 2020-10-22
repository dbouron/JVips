/*
  Copyright (c) 2019 Criteo

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

#include "VipsContext.h"

JNIEXPORT void JNICALL
Java_com_criteo_vips_VipsContext_setConcurrency(__attribute__((unused))JNIEnv *env, __attribute__((unused)) jclass obj, jint concurrency)
{
    vips_concurrency_set(concurrency);
}

JNIEXPORT jint JNICALL
Java_com_criteo_vips_VipsContext_getConcurrency(__attribute__((unused))JNIEnv *env, __attribute__((unused)) jclass obj)
{
    return vips_concurrency_get();
}