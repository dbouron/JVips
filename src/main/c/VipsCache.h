/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_criteo_vips_VipsCache */

#ifndef _Included_com_criteo_vips_VipsCache
#define _Included_com_criteo_vips_VipsCache
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_criteo_vips_VipsCache
 * Method:    print
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_criteo_vips_VipsCache_print
  (JNIEnv *, jclass);

/*
 * Class:     com_criteo_vips_VipsCache
 * Method:    dropAll
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_criteo_vips_VipsCache_dropAll
  (JNIEnv *, jclass);

/*
 * Class:     com_criteo_vips_VipsCache
 * Method:    setMax
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_criteo_vips_VipsCache_setMax
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_criteo_vips_VipsCache
 * Method:    setMaxMem
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_criteo_vips_VipsCache_setMaxMem
  (JNIEnv *, jclass, jlong);

/*
 * Class:     com_criteo_vips_VipsCache
 * Method:    getMax
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_criteo_vips_VipsCache_getMax
  (JNIEnv *, jclass);

/*
 * Class:     com_criteo_vips_VipsCache
 * Method:    getSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_criteo_vips_VipsCache_getSize
  (JNIEnv *, jclass);

/*
 * Class:     com_criteo_vips_VipsCache
 * Method:    getMaxMem
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_criteo_vips_VipsCache_getMaxMem
  (JNIEnv *, jclass);

/*
 * Class:     com_criteo_vips_VipsCache
 * Method:    getMaxFiles
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_criteo_vips_VipsCache_getMaxFiles
  (JNIEnv *, jclass);

/*
 * Class:     com_criteo_vips_VipsCache
 * Method:    setMaxFiles
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_criteo_vips_VipsCache_setMaxFiles
  (JNIEnv *, jclass, jint);

/*
 * Class:     com_criteo_vips_VipsCache
 * Method:    setDump
 * Signature: (Z)V
 */
JNIEXPORT void JNICALL Java_com_criteo_vips_VipsCache_setDump
  (JNIEnv *, jclass, jboolean);

/*
 * Class:     com_criteo_vips_VipsCache
 * Method:    setTrace
 * Signature: (Z)V
 */
JNIEXPORT void JNICALL Java_com_criteo_vips_VipsCache_setTrace
  (JNIEnv *, jclass, jboolean);

#ifdef __cplusplus
}
#endif
#endif