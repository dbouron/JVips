# Pre-compile java classes for generating JNI header files

set(JAVA_SOURCE_DIRECTORY "${PROJECT_SOURCE_DIR}/src/main/java/com/criteo/vips/")
set(JNI_HEADER_DIRECTORY "${PROJECT_SOURCE_DIR}/src/main/c/")
set(JAVA_SOURCE_FILES
    "${JAVA_SOURCE_DIRECTORY}/Max1Result.java"
    "${JAVA_SOURCE_DIRECTORY}/PixelPacket.java"
    "${JAVA_SOURCE_DIRECTORY}/Vips.java"
    "${JAVA_SOURCE_DIRECTORY}/VipsThreadpool.java"
    "${JAVA_SOURCE_DIRECTORY}/VipsCache.java"
    "${JAVA_SOURCE_DIRECTORY}/VipsException.java"
    "${JAVA_SOURCE_DIRECTORY}/Image.java"
    "${JAVA_SOURCE_DIRECTORY}/VipsImage.java"
    "${JAVA_SOURCE_DIRECTORY}/VipsInit.java")
file(GLOB JAVA_ENUM_SOURCE_FILES "${JAVA_SOURCE_DIRECTORY}/enums/*.java")

add_jar(JVipsWrapper ${JAVA_ENUM_SOURCE_FILES} ${JAVA_SOURCE_FILES})

file(REMOVE ${JNI_HEADER_DIRECTORY}/Vips.h
            ${JNI_HEADER_DIRECTORY}/VipsContext.h
            ${JNI_HEADER_DIRECTORY}/VipsImage.h)

create_javah(TARGET VipsThreadpool_header
             CLASSES com.criteo.vips.VipsThreadpool
             CLASSPATH JVipsWrapper
             OUTPUT_NAME ${JNI_HEADER_DIRECTORY}/VipsThreadpool.h)
create_javah(TARGET VipsInit_header
             CLASSES com.criteo.vips.VipsInit
             CLASSPATH JVipsWrapper
             OUTPUT_NAME ${JNI_HEADER_DIRECTORY}/VipsInit.h)
create_javah(TARGET VipsCache_header
             CLASSES com.criteo.vips.VipsCache
             CLASSPATH JVipsWrapper
             OUTPUT_NAME ${JNI_HEADER_DIRECTORY}/VipsCache.h)
create_javah(TARGET VipsImage_header
             CLASSES com.criteo.vips.VipsImage
             CLASSPATH JVipsWrapper
             OUTPUT_NAME ${JNI_HEADER_DIRECTORY}/VipsImage.h)
create_javah(TARGET Max1Result_header
             CLASSES com.criteo.vips.Max1Result
             CLASSPATH JVipsWrapper
             OUTPUT_NAME ${JNI_HEADER_DIRECTORY}/Max1Result.h)

if(NOT ${BUILD_TARGET} STREQUAL "macOS")
    add_dependencies(VipsThreadpool_header libvips)
    add_dependencies(VipsInit_header libvips)
    add_dependencies(VipsCache_header libvips)
    add_dependencies(VipsImage_header libvips)
    add_dependencies(Max1Result_header libvips)
endif()
