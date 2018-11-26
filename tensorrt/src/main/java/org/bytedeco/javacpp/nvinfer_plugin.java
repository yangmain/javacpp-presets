// Targeted by JavaCPP version 1.4.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.javacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.cuda.*;
import static org.bytedeco.javacpp.nvinfer.*;

public class nvinfer_plugin extends org.bytedeco.javacpp.presets.nvinfer_plugin {
    static { Loader.load(); }

// Parsed from NvInferPlugin.h

/*
 * Copyright 1993-2018 NVIDIA Corporation.  All rights reserved.
 *
 * NOTICE TO LICENSEE:
 *
 * This source code and/or documentation ("Licensed Deliverables") are
 * subject to NVIDIA intellectual property rights under U.S. and
 * international Copyright laws.
 *
 * These Licensed Deliverables contained herein is PROPRIETARY and
 * CONFIDENTIAL to NVIDIA and is being provided under the terms and
 * conditions of a form of NVIDIA software license agreement by and
 * between NVIDIA and Licensee ("License Agreement") or electronically
 * accepted by Licensee.  Notwithstanding any terms or conditions to
 * the contrary in the License Agreement, reproduction or disclosure
 * of the Licensed Deliverables to any third party without the express
 * written consent of NVIDIA is prohibited.
 *
 * NOTWITHSTANDING ANY TERMS OR CONDITIONS TO THE CONTRARY IN THE
 * LICENSE AGREEMENT, NVIDIA MAKES NO REPRESENTATION ABOUT THE
 * SUITABILITY OF THESE LICENSED DELIVERABLES FOR ANY PURPOSE.  IT IS
 * PROVIDED "AS IS" WITHOUT EXPRESS OR IMPLIED WARRANTY OF ANY KIND.
 * NVIDIA DISCLAIMS ALL WARRANTIES WITH REGARD TO THESE LICENSED
 * DELIVERABLES, INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY,
 * NONINFRINGEMENT, AND FITNESS FOR A PARTICULAR PURPOSE.
 * NOTWITHSTANDING ANY TERMS OR CONDITIONS TO THE CONTRARY IN THE
 * LICENSE AGREEMENT, IN NO EVENT SHALL NVIDIA BE LIABLE FOR ANY
 * SPECIAL, INDIRECT, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, OR ANY
 * DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS,
 * WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS
 * ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE
 * OF THESE LICENSED DELIVERABLES.
 *
 * U.S. Government End Users.  These Licensed Deliverables are a
 * "commercial item" as that term is defined at 48 C.F.R. 2.101 (OCT
 * 1995), consisting of "commercial computer software" and "commercial
 * computer software documentation" as such terms are used in 48
 * C.F.R. 12.212 (SEPT 1995) and is provided to the U.S. Government
 * only as a commercial end item.  Consistent with 48 C.F.R.12.212 and
 * 48 C.F.R. 227.7202-1 through 227.7202-4 (JUNE 1995), all
 * U.S. Government End Users acquire the Licensed Deliverables with
 * only those rights set forth herein.
 *
 * Any use of the Licensed Deliverables in individual and commercial
 * software must include, in the user documentation and internal
 * comments to the code, the above Disclaimer and U.S. Government End
 * Users Notice.
 */

// #ifndef NV_INFER_PLUGIN_H
// #define NV_INFER_PLUGIN_H



//!
//!
//!
// #include "NvInfer.h"

/**
 *  \file NvInferPlugin.h
 * 
 *  This is the API for the Nvidia provided TensorRT plugins.
 *  */
/**
 *  \enum PluginType
 * 
 *  \brief The type values for the various plugins.
 * 
 *  @see INvPlugin::getPluginType()
 *  */
@Namespace("nvinfer1") public enum PluginType {
    /** FasterRCNN fused plugin (RPN + ROI pooling). */
    kFASTERRCNN(0),
    /** Normalize plugin. */
    kNORMALIZE(1),
    /** Permute plugin. */
    kPERMUTE(2),
    /** PriorBox plugin. */
    kPRIORBOX(3),
    /** SSD DetectionOutput plugin. */
    kSSDDETECTIONOUTPUT(4),
    /** Concat plugin. */
    kCONCAT(5),
    /** YOLO PReLU Plugin. */
    kPRELU(6),
    /** YOLO Reorg Plugin. */
    kYOLOREORG(7),
    /** YOLO Region Plugin. */
    kYOLOREGION(8),
    /** SSD Grid Anchor Generator. */
    kANCHORGENERATOR(9);

    public final int value;
    private PluginType(int v) { this.value = v; }
    private PluginType(PluginType e) { this.value = e.value; }
    public PluginType intern() { for (PluginType e : values()) if (e.value == value) return e; return this; }
    @Override public String toString() { return intern().name(); }
}

/**
 *  \class INvPlugin
 * 
 *  \brief Common interface for the Nvidia created plugins.
 * 
 *  This class provides a common subset of functionality that is used
 *  to provide distinguish the Nvidia created plugins. Each plugin provides a
 *  function to validate the parameter options and create the plugin
 *  object.
 *  */
@Namespace("nvinfer1::plugin") public static class INvPlugin extends IPlugin {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public INvPlugin(Pointer p) { super(p); }

    /**
     *  \brief Get the parameter plugin ID.
     * 
     *  @return The ID of the plugin.
     *  */
    
    
    //!
    //!
    //!
    //!
    public native PluginType getPluginType();

    /**
     *  \brief Get the name of the plugin from the ID
     * 
     *  @return The name of the plugin specified by \p id. Return nullptr if invalid ID is specified.
     * 
     *  The valid \p id values are ranged [0, numPlugins()).
     *  */
    
    
    //!
    //!
    //!
    public native String getName();

    /**
     *  \brief Destroy the plugin.
     * 
     *  The valid \p id values are ranged [0, numPlugins()).
     *  */
    public native void destroy();
} // INvPlugin

/**
 *  @param featureStride Feature stride.
 *  @param preNmsTop Number of proposals to keep before applying NMS.
 *  @param nmsMaxOut Number of remaining proposals after applying NMS.
 *  @param iouThreshold IoU threshold.
 *  @param minBoxSize Minimum allowed bounding box size before scaling.
 *  @param spatialScale Spatial scale between the input image and the last feature map.
 *  @param pooling Spatial dimensions of pooled ROIs.
 *  @param anchorRatios Aspect ratios for generating anchor windows.
 *  @param anchorScales Scales for generating anchor windows.
 *  \brief Create a plugin layer that fuses the RPN and ROI pooling using user-defined parameters.
 * 
 *  @return Returns a FasterRCNN fused RPN+ROI pooling plugin. Returns nullptr on invalid inputs.
 * 
 *  @see INvPlugin
 *  @deprecated . This plugin is superseded by createRPNROIPlugin()
 *  */
@Namespace("nvinfer1::plugin") public static native INvPlugin createFasterRCNNPlugin(int featureStride, int preNmsTop,
                                              int nmsMaxOut, float iouThreshold, float minBoxSize,
                                              float spatialScale, @ByVal DimsHW pooling,
                                              @ByVal Weights anchorRatios, @ByVal Weights anchorScales);


//!
//!
@Namespace("nvinfer1::plugin") public static native INvPlugin createFasterRCNNPlugin(@Const Pointer data, @Cast("size_t") long length);

/**
 *  \brief The Normalize plugin layer normalizes the input to have L2 norm of 1 with scale learnable.
 *  @param scales Scale weights that are applied to the output tensor.
 *  @param acrossSpatial Whether to compute the norm over adjacent channels (acrossSpatial is true) or nearby spatial locations (within channel in which case acrossSpatial is false).
 *  @param channelShared Whether the scale weight(s) is shared across channels.
 *  @param eps Epsilon for not diviiding by zero.
 *  @deprecated . This plugin is superseded by createNormalizePlugin()
 *  */
@Namespace("nvinfer1::plugin") public static native INvPlugin createSSDNormalizePlugin(@Const Weights scales, @Cast("bool") boolean acrossSpatial, @Cast("bool") boolean channelShared, float eps);


//!
//!
@Namespace("nvinfer1::plugin") public static native INvPlugin createSSDNormalizePlugin(@Const Pointer data, @Cast("size_t") long length);

/**
 *  \brief The Permute plugin layer permutes the input tensor by changing the memory order of the data.
 *  Quadruple defines a structure that contains an array of 4 integers. They can represent the permute orders or the strides in each dimension.
 *  */
@Namespace("nvinfer1::plugin") public static class Quadruple extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public Quadruple() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Quadruple(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Quadruple(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public Quadruple position(long position) {
        return (Quadruple)super.position(position);
    }

    public native int data(int i); public native Quadruple data(int i, int data);
    @MemberGetter public native IntPointer data();
}

/**
 *  @param permuteOrder The new orders that are used to permute the data.
 *  @deprecated . Please use the TensorRT Shuffle layer for Permute operation
 *  */
@Namespace("nvinfer1::plugin") public static native INvPlugin createSSDPermutePlugin(@ByVal Quadruple permuteOrder);


//!
//!
@Namespace("nvinfer1::plugin") public static native INvPlugin createSSDPermutePlugin(@Const Pointer data, @Cast("size_t") long length);

/**
 *  \brief The PriorBox plugin layer generates the prior boxes of designated sizes and aspect ratios across all dimensions \f$ (H \times W) \f$.
 *  PriorBoxParameters defines a set of parameters for creating the PriorBox plugin layer.
 *  It contains:
 *  @param minSize Minimum box size in pixels. Can not be nullptr.
 *  @param maxSize Maximum box size in pixels. Can be nullptr.
 *  @param aspectRatios Aspect ratios of the boxes. Can be nullptr.
 *  @param numMinSize Number of elements in minSize. Must be larger than 0.
 *  @param numMaxSize Number of elements in maxSize. Can be 0 or same as numMinSize.
 *  @param numAspectRatios Number of elements in aspectRatios. Can be 0.
 *  @param flip If true, will flip each aspect ratio. For example, if there is aspect ratio "r", the aspect ratio "1.0/r" will be generated as well.
 *  @param clip If true, will clip the prior so that it is within [0,1].
 *  @param variance Variance for adjusting the prior boxes.
 *  @param imgH Image height. If 0, then the H dimension of the data tensor will be used.
 *  @param imgW Image width. If 0, then the W dimension of the data tensor will be used.
 *  @param stepH Step in H. If 0, then (float)imgH/h will be used where h is the H dimension of the 1st input tensor.
 *  @param stepW Step in W. If 0, then (float)imgW/w will be used where w is the W dimension of the 1st input tensor.
 *  @param offset Offset to the top left corner of each cell.
 *  */
@Namespace("nvinfer1::plugin") public static class PriorBoxParameters extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public PriorBoxParameters() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public PriorBoxParameters(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public PriorBoxParameters(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public PriorBoxParameters position(long position) {
        return (PriorBoxParameters)super.position(position);
    }

    public native FloatPointer minSize(); public native PriorBoxParameters minSize(FloatPointer minSize);
    public native FloatPointer maxSize(); public native PriorBoxParameters maxSize(FloatPointer maxSize);
    public native FloatPointer aspectRatios(); public native PriorBoxParameters aspectRatios(FloatPointer aspectRatios);
    public native int numMinSize(); public native PriorBoxParameters numMinSize(int numMinSize);
    public native int numMaxSize(); public native PriorBoxParameters numMaxSize(int numMaxSize);
    public native int numAspectRatios(); public native PriorBoxParameters numAspectRatios(int numAspectRatios);
    public native @Cast("bool") boolean flip(); public native PriorBoxParameters flip(boolean flip);
    public native @Cast("bool") boolean clip(); public native PriorBoxParameters clip(boolean clip);
    public native float variance(int i); public native PriorBoxParameters variance(int i, float variance);
    @MemberGetter public native FloatPointer variance();
    public native int imgH(); public native PriorBoxParameters imgH(int imgH);
    public native int imgW(); public native PriorBoxParameters imgW(int imgW);
    public native float stepH(); public native PriorBoxParameters stepH(float stepH);
    public native float stepW(); public native PriorBoxParameters stepW(float stepW);
    public native float offset(); public native PriorBoxParameters offset(float offset);
}

/**
 *  \brief The Anchor Generator plugin layer generates the prior boxes of designated sizes and aspect ratios across all dimensions \f$ (H \times W) \f$.
 *  GridAnchorParameters defines a set of parameters for creating the plugin layer for all feature maps.
 *  It contains:
 *  @param minScale Scale of anchors corresponding to finest resolution.
 *  @param maxScale Scale of anchors corresponding to coarsest resolution.
 *  @param aspectRatios List of aspect ratios to place on each grid point.
 *  @param numAspectRatios Number of elements in aspectRatios.
 *  @param H Height of feature map to generate anchors for.
 *  @param W Width of feature map to generate anchors for.
 *  @param variance Variance for adjusting the prior boxes.
 *  */
@Namespace("nvinfer1::plugin") public static class GridAnchorParameters extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public GridAnchorParameters() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public GridAnchorParameters(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public GridAnchorParameters(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public GridAnchorParameters position(long position) {
        return (GridAnchorParameters)super.position(position);
    }

    public native float minSize(); public native GridAnchorParameters minSize(float minSize);
    public native float maxSize(); public native GridAnchorParameters maxSize(float maxSize);
    public native FloatPointer aspectRatios(); public native GridAnchorParameters aspectRatios(FloatPointer aspectRatios);
    public native int numAspectRatios(); public native GridAnchorParameters numAspectRatios(int numAspectRatios);
    public native int H(); public native GridAnchorParameters H(int H);
    public native int W(); public native GridAnchorParameters W(int W);
    public native float variance(int i); public native GridAnchorParameters variance(int i, float variance);
    @MemberGetter public native FloatPointer variance();
}

/**
 *  @param param Set of parameters for creating the PriorBox plugin layer.
 *  @deprecated . This plugin is superseded by createPriorBoxPlugin()
 *  */
@Namespace("nvinfer1::plugin") public static native INvPlugin createSSDPriorBoxPlugin(@ByVal PriorBoxParameters param);


//!
//!
@Namespace("nvinfer1::plugin") public static native INvPlugin createSSDPriorBoxPlugin(@Const Pointer data, @Cast("size_t") long length);

/**
 *  \brief The Grid Anchor Generator plugin layer generates the prior boxes of
 *  designated sizes and aspect ratios across all dimensions \f$ (H \times W) \f$ for all feature maps.
 *  GridAnchorParameters defines a set of parameters for creating the GridAnchorGenerator plugin layer.
 *  @deprecated . This plugin is superseded by createAnchorGeneratorPlugin()
 *  */
@Namespace("nvinfer1::plugin") public static native INvPlugin createSSDAnchorGeneratorPlugin(GridAnchorParameters param, int numLayers);


//!
//!
@Namespace("nvinfer1::plugin") public static native INvPlugin createSSDAnchorGeneratorPlugin(@Const Pointer data, @Cast("size_t") long length);

/**
 *  \enum CodeTypeSSD
 *  \brief The type of encoding used for decoding the bounding boxes and loc_data.
 *  */
@Namespace("nvinfer1::plugin") public enum CodeTypeSSD {
    /** Use box corners. */
    CORNER(0),
    /** Use box centers and size. */
    CENTER_SIZE(1),
    /** Use box centers and size. */
    CORNER_SIZE(2),
    /** Use box centers and size but flip x and y co-ordinates. */
    TF_CENTER(3);

    public final int value;
    private CodeTypeSSD(int v) { this.value = v; }
    private CodeTypeSSD(CodeTypeSSD e) { this.value = e.value; }
    public CodeTypeSSD intern() { for (CodeTypeSSD e : values()) if (e.value == value) return e; return this; }
    @Override public String toString() { return intern().name(); }
}

/**
 *  \brief The DetectionOutput plugin layer generates the detection output based on location and confidence predictions by doing non maximum suppression.
 *  DetectionOutputParameters defines a set of parameters for creating the DetectionOutput plugin layer.
 *  It contains:
 *  @param shareLocation If true, bounding box are shared among different classes.
 *  @param varianceEncodedInTarget If true, variance is encoded in target. Otherwise we need to adjust the predicted offset accordingly.
 *  @param backgroundLabelId Background label ID. If there is no background class, set it as -1.
 *  @param numClasses Number of classes to be predicted.
 *  @param topK Number of boxes per image with top confidence scores that are fed into the NMS algorithm.
 *  @param keepTopK Number of total bounding boxes to be kept per image after NMS step.
 *  @param confidenceThreshold Only consider detections whose confidences are larger than a threshold.
 *  @param nmsThreshold Threshold to be used in NMS.
 *  @param codeType Type of coding method for bbox.
 *  @param inputOrder Specifies the order of inputs {loc_data, conf_data, priorbox_data}.
 *  @param confSigmoid Set to true to calculate sigmoid of confidence scores.
 *  @param isNormalized Set to true if bounding box data is normalized by the network.
 *  */
@Namespace("nvinfer1::plugin") public static class DetectionOutputParameters extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public DetectionOutputParameters() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public DetectionOutputParameters(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public DetectionOutputParameters(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public DetectionOutputParameters position(long position) {
        return (DetectionOutputParameters)super.position(position);
    }

    public native @Cast("bool") boolean shareLocation(); public native DetectionOutputParameters shareLocation(boolean shareLocation);
    public native @Cast("bool") boolean varianceEncodedInTarget(); public native DetectionOutputParameters varianceEncodedInTarget(boolean varianceEncodedInTarget);
    public native int backgroundLabelId(); public native DetectionOutputParameters backgroundLabelId(int backgroundLabelId);
    public native int numClasses(); public native DetectionOutputParameters numClasses(int numClasses);
    public native int topK(); public native DetectionOutputParameters topK(int topK);
    public native int keepTopK(); public native DetectionOutputParameters keepTopK(int keepTopK);
    public native float confidenceThreshold(); public native DetectionOutputParameters confidenceThreshold(float confidenceThreshold);
    public native float nmsThreshold(); public native DetectionOutputParameters nmsThreshold(float nmsThreshold);
    public native CodeTypeSSD codeType(); public native DetectionOutputParameters codeType(CodeTypeSSD codeType);
    public native int inputOrder(int i); public native DetectionOutputParameters inputOrder(int i, int inputOrder);
    @MemberGetter public native IntPointer inputOrder();
    public native @Cast("bool") boolean confSigmoid(); public native DetectionOutputParameters confSigmoid(boolean confSigmoid);
    public native @Cast("bool") boolean isNormalized(); public native DetectionOutputParameters isNormalized(boolean isNormalized);
}

/**
 *  @param param Set of parameters for creating the DetectionOutput plugin layer.
 *  @deprecated . This plugin is superseded by createNMSPlugin()
 *  */
@Namespace("nvinfer1::plugin") public static native INvPlugin createSSDDetectionOutputPlugin(@ByVal DetectionOutputParameters param);


//!
//!
@Namespace("nvinfer1::plugin") public static native INvPlugin createSSDDetectionOutputPlugin(@Const Pointer data, @Cast("size_t") long length);

/**
 *  \brief The Concat plugin layer basically performs the concatention for 4D tensors. Unlike the Concatenation layer in early version of TensorRT,
 *  it allows the user to specify the axis along which to concatenate. The axis can be 1 (across channel), 2 (across H), or 3 (across W).
 *  More particularly, this Concat plugin layer also implements the "ignoring the batch dimension" switch. If turned on, all the input tensors will be treated as if their batch sizes were 1.
 *  @param concatAxis Axis along which to concatenate. Can't be the "N" dimension.
 *  @param ignoreBatch If true, all the input tensors will be treated as if their batch sizes were 1.
 *  @deprecated . This plugin is superseded by createConcatPluginV2()
 *  */
@Namespace("nvinfer1::plugin") public static native INvPlugin createConcatPlugin(int concatAxis, @Cast("bool") boolean ignoreBatch);


//!
//!
@Namespace("nvinfer1::plugin") public static native INvPlugin createConcatPlugin(@Const Pointer data, @Cast("size_t") long length);

/**
 *  \brief The PReLu plugin layer performs leaky ReLU for 4D tensors. Give an input value x, the PReLU layer computes the output as x if x > 0
 *   and negative_slope //! x if x <= 0.
 *  @param negSlope Negative_slope value.
 *  @deprecated . This plugin is superseded by createLReLUPlugin()
 *  */
@Namespace("nvinfer1::plugin") public static native INvPlugin createPReLUPlugin(float negSlope);


//!
//!
@Namespace("nvinfer1::plugin") public static native INvPlugin createPReLUPlugin(@Const Pointer data, @Cast("size_t") long length);

/**
 *  \brief The Reorg plugin layer maps the 512x26x26 feature map onto a 2048x13x13 feature map, so that it can be concatenated with the feature maps at 13x13 resolution.
 *  @param stride Strides in H and W.
 *  @deprecated . This plugin is superseded by createReorgPlugin()
 *  */
@Namespace("nvinfer1::plugin") public static native INvPlugin createYOLOReorgPlugin(int stride);


//!
//!
@Namespace("nvinfer1::plugin") public static native INvPlugin createYOLOReorgPlugin(@Const Pointer data, @Cast("size_t") long length);

/**
 *  \brief The Region plugin layer performs region proposal calculation: generate 5 bounding boxes per cell (for yolo9000, generate 3 bounding boxes per cell).
 *  For each box, calculating its probablities of objects detections from 80 pre-defined classifications (yolo9000 has 9416 pre-defined classifications,
 *  and these 9416 items are organized as work-tree structure).
 *  RegionParameters defines a set of parameters for creating the Region plugin layer.
 *  @param num Number of predicted bounding box for each grid cell.
 *  @param coords Number of coordinates for a bounding box.
 *  @param classes Number of classfications to be predicted.
 *  @param softmaxTree When performing yolo9000, softmaxTree is helping to do softmax on confidence scores, for element to get the precise classfication through word-tree structured classfication definition.
 *  @deprecated . This plugin is superseded by createRegionPlugin()
 *  */
@Namespace("nvinfer1::plugin") public static class softmaxTree extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public softmaxTree() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public softmaxTree(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public softmaxTree(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public softmaxTree position(long position) {
        return (softmaxTree)super.position(position);
    }

    public native IntPointer leaf(); public native softmaxTree leaf(IntPointer leaf);
    public native int n(); public native softmaxTree n(int n);
    public native IntPointer parent(); public native softmaxTree parent(IntPointer parent);
    public native IntPointer child(); public native softmaxTree child(IntPointer child);
    public native IntPointer group(); public native softmaxTree group(IntPointer group);
    public native @Cast("char*") BytePointer name(int i); public native softmaxTree name(int i, BytePointer name);
    public native @Cast("char**") PointerPointer name(); public native softmaxTree name(PointerPointer name);

    public native int groups(); public native softmaxTree groups(int groups);
    public native IntPointer groupSize(); public native softmaxTree groupSize(IntPointer groupSize);
    public native IntPointer groupOffset(); public native softmaxTree groupOffset(IntPointer groupOffset);
} // softmax tree

@Namespace("nvinfer1::plugin") public static class RegionParameters extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public RegionParameters() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public RegionParameters(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public RegionParameters(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public RegionParameters position(long position) {
        return (RegionParameters)super.position(position);
    }

    public native int num(); public native RegionParameters num(int num);
    public native int coords(); public native RegionParameters coords(int coords);
    public native int classes(); public native RegionParameters classes(int classes);
    public native softmaxTree smTree(); public native RegionParameters smTree(softmaxTree smTree);
}

@Namespace("nvinfer1::plugin") public static native INvPlugin createYOLORegionPlugin(@ByVal RegionParameters params);
@Namespace("nvinfer1::plugin") public static native INvPlugin createYOLORegionPlugin(@Const Pointer data, @Cast("size_t") long length);

 // end plugin namespace
 // end nvinfer1 namespace
/**
 *  \brief Create a plugin layer that fuses the RPN and ROI pooling using user-defined parameters.
 *  Registered plugin type "RPROI_TRT". Registered plugin version "1".
 *  @param featureStride Feature stride.
 *  @param preNmsTop Number of proposals to keep before applying NMS.
 *  @param nmsMaxOut Number of remaining proposals after applying NMS.
 *  @param iouThreshold IoU threshold.
 *  @param minBoxSize Minimum allowed bounding box size before scaling.
 *  @param spatialScale Spatial scale between the input image and the last feature map.
 *  @param pooling Spatial dimensions of pooled ROIs.
 *  @param anchorRatios Aspect ratios for generating anchor windows.
 *  @param anchorScales Scales for generating anchor windows.
 * 
 *  @return Returns a FasterRCNN fused RPN+ROI pooling plugin. Returns nullptr on invalid inputs.
 *  */


//!
//!
public static native IPluginExt createRPNROIPlugin(int featureStride, int preNmsTop,
                                                                int nmsMaxOut, float iouThreshold, float minBoxSize,
                                                                float spatialScale, @ByVal DimsHW pooling,
                                                                @ByVal Weights anchorRatios, @ByVal Weights anchorScales);

/**
 *  \brief The Normalize plugin layer normalizes the input to have L2 norm of 1 with scale learnable.
 *  Registered plugin type "Normalize_TRT". Registered plugin version "1".
 *  @param scales Scale weights that are applied to the output tensor.
 *  @param acrossSpatial Whether to compute the norm over adjacent channels (acrossSpatial is true) or nearby spatial locations (within channel in which case acrossSpatial is false).
 *  @param channelShared Whether the scale weight(s) is shared across channels.
 *  @param eps Epsilon for not diviiding by zero.
 *  */


//!
//!
public static native IPluginExt createNormalizePlugin(@Const Weights scales, @Cast("bool") boolean acrossSpatial, @Cast("bool") boolean channelShared, float eps);

/**
 *  \brief The PriorBox plugin layer generates the prior boxes of designated sizes and aspect ratios across all dimensions \f$ (H \times W) \f$.
 *  PriorBoxParameters defines a set of parameters for creating the PriorBox plugin layer.
 *  Registered plugin type "PriorBox_TRT". Registered plugin version "1".
 *  */


//!
//!
public static native IPluginExt createPriorBoxPlugin(@ByVal PriorBoxParameters param);

/**
 *  \brief The Grid Anchor Generator plugin layer generates the prior boxes of
 *  designated sizes and aspect ratios across all dimensions \f$ (H \times W) \f$ for all feature maps.
 *  GridAnchorParameters defines a set of parameters for creating the GridAnchorGenerator plugin layer.
 *  Registered plugin type "GridAnchor_TRT". Registered plugin version "1".
 *  */


//!
//!
public static native IPluginExt createAnchorGeneratorPlugin(GridAnchorParameters param, int numLayers);

/**
 *  \brief The DetectionOutput plugin layer generates the detection output based on location and confidence predictions by doing non maximum suppression.
 *  DetectionOutputParameters defines a set of parameters for creating the DetectionOutput plugin layer.
 *  Registered plugin type "NMS_TRT". Registered plugin version "1".
 *  */


//!
//!
public static native IPluginExt createNMSPlugin(@ByVal DetectionOutputParameters param);

/**
 *  \brief The Concat plugin layer basically performs the concatention for 4D tensors. Unlike the Concatenation layer in early version of TensorRT,
 *  it allows the user to specify the axis along which to concatenate. The axis can be 1 (across channel), 2 (across H), or 3 (across W).
 *  More particularly, this Concat plugin layer also implements the "ignoring the batch dimension" switch. If turned on, all the input tensors will be treated as if their batch sizes were 1.
 *  Registered plugin type "Concat_TRT". Registered plugin version "1".
 *  @param concatAxis Axis along which to concatenate. Can't be the "N" dimension.
 *  @param ignoreBatch If true, all the input tensors will be treated as if their batch sizes were 1.
 *  */


//!
//!
public static native IPluginExt createConcatPluginV2(int concatAxis, @Cast("bool") boolean ignoreBatch);

/**
 *  \brief The LReLu plugin layer performs leaky ReLU for 4D tensors. Give an input value x, the PReLU layer computes the output as x if x > 0 and negative_slope //! x if x <= 0.
 *  Registered plugin type "LReLU_TRT". Registered plugin version "1".
 *  @param negSlope Negative_slope value.
 *  */


//!
//!
public static native IPluginExt createLReLUPlugin(float negSlope);

/**
 *  \brief The Reorg plugin layer maps the 512x26x26 feature map onto a 2048x13x13 feature map, so that it can be concatenated with the feature maps at 13x13 resolution.
 *  Registered plugin type "Reorg_TRT". Registered plugin version "1".
 *  @param stride Strides in H and W.
 *  */


//!
public static native IPluginExt createReorgPlugin(int stride);

/**
 *  \brief The Region plugin layer performs region proposal calculation: generate 5 bounding boxes per cell (for yolo9000, generate 3 bounding boxes per cell).
 *  For each box, calculating its probablities of objects detections from 80 pre-defined classifications (yolo9000 has 9416 pre-defined classifications,
 *  and these 9416 items are organized as work-tree structure).
 *  RegionParameters defines a set of parameters for creating the Region plugin layer.
 *  Registered plugin type "Region_TRT". Registered plugin version "1". */



//!
//!
public static native IPluginExt createRegionPlugin(@ByVal RegionParameters params);

/**
 *  \brief Register all the existing TensorRT plugins to the Plugin Registry.
 *  This function should be called before accessing the Plugin Registry.
 *  */
public static native void registerAllTensorRTPlugins(); // extern "C"

// #endif // NV_INFER_PLUGIN_H


}
