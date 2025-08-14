cmake_minimum_required(VERSION 3.22.1)
project(editium_video)

set(CMAKE_CXX_STANDARD 17)
add_library(editium_video SHARED
    src/ffmpeg_bridge.cpp
    src/gpu_pipeline.cpp
    src/yuv_utils.cpp
)

add_library(avcodec SHARED IMPORTED)
set_target_properties(avcodec PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libavcodec.so)
add_library(avformat SHARED IMPORTED)
set_target_properties(avformat PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libavformat.so)
add_library(avutil SHARED IMPORTED)
set_target_properties(avutil PROPERTIES IMPORTED_LOCATION
    ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libavutil.so)

find_library(log-lib log)
find_library(android-lib android)
find_library(egl-lib EGL)
find_library(gles-lib GLESv3)

target_include_directories(editium_video PRIVATE ${CMAKE_SOURCE_DIR}/include)

# Link placeholders (libs expected in jniLibs)
target_link_libraries(editium_video avcodec avformat avutil ${log-lib} ${android-lib} ${egl-lib} ${gles-lib})
