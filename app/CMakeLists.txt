
cmake_minimum_required(VERSION 3.4.1)

file(GLOB source_file src/main/cpp/*.cpp)

add_library(
             native-lib
             SHARED
       ${source_file})

include_directories(src/main/cpp/include)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L${CMAKE_SOURCE_DIR}/src/main/cpp/libs/${CMAKE_ANDROID_ARCH_ABI}")

target_link_libraries(
                     native-lib
                    avcodec avfilter avformat avutil swresample swscale
                       log z)
