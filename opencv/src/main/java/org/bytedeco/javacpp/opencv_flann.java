// Targeted by JavaCPP version 1.2-SNAPSHOT

package org.bytedeco.javacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.opencv_core.*;

public class opencv_flann extends org.bytedeco.javacpp.presets.opencv_flann {
    static { Loader.load(); }

// Parsed from <opencv2/flann/defines.h>

/***********************************************************************
 * Software License Agreement (BSD License)
 *
 * Copyright 2008-2011  Marius Muja (mariusm\cs.ubc.ca). All rights reserved.
 * Copyright 2008-2011  David G. Lowe (lowe\cs.ubc.ca). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR {@code }AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *************************************************************************/


// #ifndef OPENCV_FLANN_DEFINES_H_
// #define OPENCV_FLANN_DEFINES_H_

// #include "config.h"

// #ifdef FLANN_EXPORT
// #endif
// #ifdef WIN32
/* win32 dll export/import directives */
//  #ifdef FLANN_EXPORTS
//   #define FLANN_EXPORT __declspec(dllexport)
//  #elif defined(FLANN_STATIC)
//   #define FLANN_EXPORT
//  #else
//   #define FLANN_EXPORT __declspec(dllimport)
//  #endif
// #else
/* unix needs nothing */
//  #define FLANN_EXPORT
// #endif


// #ifdef FLANN_DEPRECATED
// #endif
// #ifdef __GNUC__
// #define FLANN_DEPRECATED __attribute__ ((deprecated))
// #elif defined(_MSC_VER)
// #else
// #pragma message("WARNING: You need to implement FLANN_DEPRECATED for this compiler")
// #define FLANN_DEPRECATED
// #endif


// #undef FLANN_PLATFORM_32_BIT
// #undef FLANN_PLATFORM_64_BIT
// #if defined __amd64__ || defined __x86_64__ || defined _WIN64 || defined _M_X64
// #define FLANN_PLATFORM_64_BIT
// #else
// #define FLANN_PLATFORM_32_BIT
// #endif


// #undef FLANN_ARRAY_LEN
// #define FLANN_ARRAY_LEN(a) (sizeof(a)/sizeof(a[0]))

/* Nearest neighbour index algorithms */
/** enum cvflann::flann_algorithm_t */
public static final int
    FLANN_INDEX_LINEAR = 0,
    FLANN_INDEX_KDTREE = 1,
    FLANN_INDEX_KMEANS = 2,
    FLANN_INDEX_COMPOSITE = 3,
    FLANN_INDEX_KDTREE_SINGLE = 4,
    FLANN_INDEX_HIERARCHICAL = 5,
    FLANN_INDEX_LSH = 6,
    FLANN_INDEX_SAVED = 254,
    FLANN_INDEX_AUTOTUNED = 255,

    // deprecated constants, should use the FLANN_INDEX_* ones instead
    LINEAR = 0,
    KDTREE = 1,
    KMEANS = 2,
    COMPOSITE = 3,
    KDTREE_SINGLE = 4,
    SAVED = 254,
    AUTOTUNED = 255;



/** enum cvflann::flann_centers_init_t */
public static final int
    FLANN_CENTERS_RANDOM = 0,
    FLANN_CENTERS_GONZALES = 1,
    FLANN_CENTERS_KMEANSPP = 2,
    FLANN_CENTERS_GROUPWISE = 3,

    // deprecated constants, should use the FLANN_CENTERS_* ones instead
    CENTERS_RANDOM = 0,
    CENTERS_GONZALES = 1,
    CENTERS_KMEANSPP = 2;

/** enum cvflann::flann_log_level_t */
public static final int
    FLANN_LOG_NONE = 0,
    FLANN_LOG_FATAL = 1,
    FLANN_LOG_ERROR = 2,
    FLANN_LOG_WARN = 3,
    FLANN_LOG_INFO = 4;

/** enum cvflann::flann_distance_t */
public static final int
    FLANN_DIST_EUCLIDEAN = 1,
    FLANN_DIST_L2 = 1,
    FLANN_DIST_MANHATTAN = 2,
    FLANN_DIST_L1 = 2,
    FLANN_DIST_MINKOWSKI = 3,
    FLANN_DIST_MAX   = 4,
    FLANN_DIST_HIST_INTERSECT   = 5,
    FLANN_DIST_HELLINGER = 6,
    FLANN_DIST_CHI_SQUARE = 7,
    FLANN_DIST_CS         = 7,
    FLANN_DIST_KULLBACK_LEIBLER  = 8,
    FLANN_DIST_KL                = 8,
    FLANN_DIST_HAMMING          = 9,

    // deprecated constants, should use the FLANN_DIST_* ones instead
    EUCLIDEAN = 1,
    MANHATTAN = 2,
    MINKOWSKI = 3,
    MAX_DIST   = 4,
    HIST_INTERSECT   = 5,
    HELLINGER = 6,
    CS         = 7,
    KL         = 8,
    KULLBACK_LEIBLER  = 8;

/** enum cvflann::flann_datatype_t */
public static final int
    FLANN_INT8 = 0,
    FLANN_INT16 = 1,
    FLANN_INT32 = 2,
    FLANN_INT64 = 3,
    FLANN_UINT8 = 4,
    FLANN_UINT16 = 5,
    FLANN_UINT32 = 6,
    FLANN_UINT64 = 7,
    FLANN_FLOAT32 = 8,
    FLANN_FLOAT64 = 9;

/** enum cvflann:: */
public static final int
    FLANN_CHECKS_UNLIMITED = -1,
    FLANN_CHECKS_AUTOTUNED = -2;



// #endif /* OPENCV_FLANN_DEFINES_H_ */


// Parsed from <opencv2/flann/miniflann.hpp>

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef _OPENCV_MINIFLANN_HPP_
// #define _OPENCV_MINIFLANN_HPP_

// #include "opencv2/core.hpp"
// #include "opencv2/flann/defines.h"

@Namespace("cv::flann") @NoOffset public static class IndexParams extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IndexParams(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public IndexParams(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public IndexParams position(long position) {
        return (IndexParams)super.position(position);
    }

    public IndexParams() { super((Pointer)null); allocate(); }
    private native void allocate();

    public native @Str BytePointer getString(@Str BytePointer key, @Str BytePointer defaultVal/*=cv::String()*/);
    public native @Str BytePointer getString(@Str BytePointer key);
    public native @Str String getString(@Str String key, @Str String defaultVal/*=cv::String()*/);
    public native @Str String getString(@Str String key);
    public native int getInt(@Str BytePointer key, int defaultVal/*=-1*/);
    public native int getInt(@Str BytePointer key);
    public native int getInt(@Str String key, int defaultVal/*=-1*/);
    public native int getInt(@Str String key);
    public native double getDouble(@Str BytePointer key, double defaultVal/*=-1*/);
    public native double getDouble(@Str BytePointer key);
    public native double getDouble(@Str String key, double defaultVal/*=-1*/);
    public native double getDouble(@Str String key);

    public native void setString(@Str BytePointer key, @Str BytePointer value);
    public native void setString(@Str String key, @Str String value);
    public native void setInt(@Str BytePointer key, int value);
    public native void setInt(@Str String key, int value);
    public native void setDouble(@Str BytePointer key, double value);
    public native void setDouble(@Str String key, double value);
    public native void setFloat(@Str BytePointer key, float value);
    public native void setFloat(@Str String key, float value);
    public native void setBool(@Str BytePointer key, @Cast("bool") boolean value);
    public native void setBool(@Str String key, @Cast("bool") boolean value);
    public native void setAlgorithm(int value);

    public native void getAll(@ByRef StringVector names,
                    @StdVector IntPointer types,
                    @ByRef StringVector strValues,
                    @StdVector DoublePointer numValues);
    public native void getAll(@ByRef StringVector names,
                    @StdVector IntBuffer types,
                    @ByRef StringVector strValues,
                    @StdVector DoubleBuffer numValues);
    public native void getAll(@ByRef StringVector names,
                    @StdVector int[] types,
                    @ByRef StringVector strValues,
                    @StdVector double[] numValues);

    public native Pointer params(); public native IndexParams params(Pointer params);
}

@Namespace("cv::flann") public static class KDTreeIndexParams extends IndexParams {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public KDTreeIndexParams(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public KDTreeIndexParams(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public KDTreeIndexParams position(long position) {
        return (KDTreeIndexParams)super.position(position);
    }

    public KDTreeIndexParams(int trees/*=4*/) { super((Pointer)null); allocate(trees); }
    private native void allocate(int trees/*=4*/);
    public KDTreeIndexParams() { super((Pointer)null); allocate(); }
    private native void allocate();
}

@Namespace("cv::flann") public static class LinearIndexParams extends IndexParams {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LinearIndexParams(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public LinearIndexParams(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public LinearIndexParams position(long position) {
        return (LinearIndexParams)super.position(position);
    }

    public LinearIndexParams() { super((Pointer)null); allocate(); }
    private native void allocate();
}

@Namespace("cv::flann") public static class CompositeIndexParams extends IndexParams {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public CompositeIndexParams(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public CompositeIndexParams(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public CompositeIndexParams position(long position) {
        return (CompositeIndexParams)super.position(position);
    }

    public CompositeIndexParams(int trees/*=4*/, int branching/*=32*/, int iterations/*=11*/,
                             @Cast("cvflann::flann_centers_init_t") int centers_init/*=cvflann::FLANN_CENTERS_RANDOM*/, float cb_index/*=0.2f*/ ) { super((Pointer)null); allocate(trees, branching, iterations, centers_init, cb_index); }
    private native void allocate(int trees/*=4*/, int branching/*=32*/, int iterations/*=11*/,
                             @Cast("cvflann::flann_centers_init_t") int centers_init/*=cvflann::FLANN_CENTERS_RANDOM*/, float cb_index/*=0.2f*/ );
    public CompositeIndexParams( ) { super((Pointer)null); allocate(); }
    private native void allocate( );
}

@Namespace("cv::flann") public static class AutotunedIndexParams extends IndexParams {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public AutotunedIndexParams(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public AutotunedIndexParams(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public AutotunedIndexParams position(long position) {
        return (AutotunedIndexParams)super.position(position);
    }

    public AutotunedIndexParams(float target_precision/*=0.8f*/, float build_weight/*=0.01f*/,
                             float memory_weight/*=0*/, float sample_fraction/*=0.1f*/) { super((Pointer)null); allocate(target_precision, build_weight, memory_weight, sample_fraction); }
    private native void allocate(float target_precision/*=0.8f*/, float build_weight/*=0.01f*/,
                             float memory_weight/*=0*/, float sample_fraction/*=0.1f*/);
    public AutotunedIndexParams() { super((Pointer)null); allocate(); }
    private native void allocate();
}

@Namespace("cv::flann") public static class HierarchicalClusteringIndexParams extends IndexParams {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public HierarchicalClusteringIndexParams(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public HierarchicalClusteringIndexParams(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public HierarchicalClusteringIndexParams position(long position) {
        return (HierarchicalClusteringIndexParams)super.position(position);
    }

    public HierarchicalClusteringIndexParams(int branching/*=32*/,
                          @Cast("cvflann::flann_centers_init_t") int centers_init/*=cvflann::FLANN_CENTERS_RANDOM*/, int trees/*=4*/, int leaf_size/*=100*/ ) { super((Pointer)null); allocate(branching, centers_init, trees, leaf_size); }
    private native void allocate(int branching/*=32*/,
                          @Cast("cvflann::flann_centers_init_t") int centers_init/*=cvflann::FLANN_CENTERS_RANDOM*/, int trees/*=4*/, int leaf_size/*=100*/ );
    public HierarchicalClusteringIndexParams( ) { super((Pointer)null); allocate(); }
    private native void allocate( );
}

@Namespace("cv::flann") public static class KMeansIndexParams extends IndexParams {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public KMeansIndexParams(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public KMeansIndexParams(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public KMeansIndexParams position(long position) {
        return (KMeansIndexParams)super.position(position);
    }

    public KMeansIndexParams(int branching/*=32*/, int iterations/*=11*/,
                          @Cast("cvflann::flann_centers_init_t") int centers_init/*=cvflann::FLANN_CENTERS_RANDOM*/, float cb_index/*=0.2f*/ ) { super((Pointer)null); allocate(branching, iterations, centers_init, cb_index); }
    private native void allocate(int branching/*=32*/, int iterations/*=11*/,
                          @Cast("cvflann::flann_centers_init_t") int centers_init/*=cvflann::FLANN_CENTERS_RANDOM*/, float cb_index/*=0.2f*/ );
    public KMeansIndexParams( ) { super((Pointer)null); allocate(); }
    private native void allocate( );
}

@Namespace("cv::flann") public static class LshIndexParams extends IndexParams {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public LshIndexParams(Pointer p) { super(p); }

    public LshIndexParams(int table_number, int key_size, int multi_probe_level) { super((Pointer)null); allocate(table_number, key_size, multi_probe_level); }
    private native void allocate(int table_number, int key_size, int multi_probe_level);
}

@Namespace("cv::flann") public static class SavedIndexParams extends IndexParams {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SavedIndexParams(Pointer p) { super(p); }

    public SavedIndexParams(@Str BytePointer filename) { super((Pointer)null); allocate(filename); }
    private native void allocate(@Str BytePointer filename);
    public SavedIndexParams(@Str String filename) { super((Pointer)null); allocate(filename); }
    private native void allocate(@Str String filename);
}

@Namespace("cv::flann") public static class SearchParams extends IndexParams {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SearchParams(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public SearchParams(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public SearchParams position(long position) {
        return (SearchParams)super.position(position);
    }

    public SearchParams( int checks/*=32*/, float eps/*=0*/, @Cast("bool") boolean sorted/*=true*/ ) { super((Pointer)null); allocate(checks, eps, sorted); }
    private native void allocate( int checks/*=32*/, float eps/*=0*/, @Cast("bool") boolean sorted/*=true*/ );
    public SearchParams( ) { super((Pointer)null); allocate(); }
    private native void allocate( );
}

@Namespace("cv::flann") @NoOffset public static class Index extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Index(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Index(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public Index position(long position) {
        return (Index)super.position(position);
    }

    public Index() { super((Pointer)null); allocate(); }
    private native void allocate();
    public Index(@ByVal Mat features, @Const @ByRef IndexParams params, @Cast("cvflann::flann_distance_t") int distType/*=cvflann::FLANN_DIST_L2*/) { super((Pointer)null); allocate(features, params, distType); }
    private native void allocate(@ByVal Mat features, @Const @ByRef IndexParams params, @Cast("cvflann::flann_distance_t") int distType/*=cvflann::FLANN_DIST_L2*/);
    public Index(@ByVal Mat features, @Const @ByRef IndexParams params) { super((Pointer)null); allocate(features, params); }
    private native void allocate(@ByVal Mat features, @Const @ByRef IndexParams params);

    public native void build(@ByVal Mat features, @Const @ByRef IndexParams params, @Cast("cvflann::flann_distance_t") int distType/*=cvflann::FLANN_DIST_L2*/);
    public native void build(@ByVal Mat features, @Const @ByRef IndexParams params);
    public native void knnSearch(@ByVal Mat query, @ByVal Mat indices,
                       @ByVal Mat dists, int knn, @Const @ByRef(nullValue = "cv::flann::SearchParams()") SearchParams params/*=cv::flann::SearchParams()*/);
    public native void knnSearch(@ByVal Mat query, @ByVal Mat indices,
                       @ByVal Mat dists, int knn);

    public native int radiusSearch(@ByVal Mat query, @ByVal Mat indices,
                                 @ByVal Mat dists, double radius, int maxResults,
                                 @Const @ByRef(nullValue = "cv::flann::SearchParams()") SearchParams params/*=cv::flann::SearchParams()*/);
    public native int radiusSearch(@ByVal Mat query, @ByVal Mat indices,
                                 @ByVal Mat dists, double radius, int maxResults);

    public native void save(@Str BytePointer filename);
    public native void save(@Str String filename);
    public native @Cast("bool") boolean load(@ByVal Mat features, @Str BytePointer filename);
    public native @Cast("bool") boolean load(@ByVal Mat features, @Str String filename);
    public native void release();
    public native @Cast("cvflann::flann_distance_t") int getDistance();
    public native @Cast("cvflann::flann_algorithm_t") int getAlgorithm();
}

  // namespace cv::flann

// #endif


}
