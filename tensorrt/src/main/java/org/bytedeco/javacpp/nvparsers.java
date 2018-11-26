// Targeted by JavaCPP version 1.4.4-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.javacpp;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.cuda.*;
import static org.bytedeco.javacpp.nvinfer.*;

public class nvparsers extends org.bytedeco.javacpp.presets.nvparsers {
    static { Loader.load(); }

// Parsed from NvCaffeParser.h

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

// #ifndef NV_CAFFE_PARSER_H
// #define NV_CAFFE_PARSER_H

// #include "NvInfer.h"
    @Namespace("ditcaffe") @Opaque public static class NetParameter extends Pointer {
        /** Empty constructor. Calls {@code super((Pointer)null)}. */
        public NetParameter() { super((Pointer)null); }
        /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
        public NetParameter(Pointer p) { super(p); }
    }


/**
 *  \class IBlobNameToTensor
 * 
 *  \brief Object used to store and query Tensors after they have been extracted from a Caffe model using the ICaffeParser.
 * 
 *  \note The lifetime of IBlobNameToTensor is the same as the lifetime of its parent ICaffeParser.
 * 
 *  @see nvcaffeparser1::ICaffeParser
 *  */
@Namespace("nvcaffeparser1") public static class IBlobNameToTensor extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IBlobNameToTensor(Pointer p) { super(p); }

    /** \brief Given a blob name, returns a pointer to a ITensor object.
     * 
     *  @param name Caffe blob name for which the user wants the corresponding ITensor.
     * 
     *  @return ITensor* corresponding to the queried name. If no such ITensor exists, then nullptr is returned.
     *  */
    public native ITensor find(String name);
    public native ITensor find(@Cast("const char*") BytePointer name);
}

/**
 *  \class IBinaryProtoBlob
 * 
 *  \brief Object used to store and query data extracted from a binaryproto file using the ICaffeParser.
 * 
 *  @see nvcaffeparser1::ICaffeParser
 *  */
@Namespace("nvcaffeparser1") public static class IBinaryProtoBlob extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IBinaryProtoBlob(Pointer p) { super(p); }

    public native @Const Pointer getData();
    public native @ByVal DimsNCHW getDimensions();
    public native DataType getDataType();
    public native void destroy();
}

/**
 *  \class IPluginFactory
 * 
 *  \brief Plugin factory used to configure plugins.
 *  */
@Namespace("nvcaffeparser1") public static class IPluginFactory extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IPluginFactory(Pointer p) { super(p); }

    /**
     *  \brief A user implemented function that determines if a layer configuration is provided by an IPlugin.
     * 
     *  @param layerName Name of the layer which the user wishes to validate.
     *  */
    
    
    //!
    //!
    //!
    public native @Cast("bool") boolean isPlugin(String layerName);
    public native @Cast("bool") boolean isPlugin(@Cast("const char*") BytePointer layerName);

    /**
     *  \brief Creates a plugin.
     * 
     *  @param layerName Name of layer associated with the plugin.
     *  @param weights Weights used for the layer.
     *  @param nbWeights Number of weights.
     *  */
    public native IPlugin createPlugin(String layerName, @Const Weights weights, int nbWeights);
    public native IPlugin createPlugin(@Cast("const char*") BytePointer layerName, @Const Weights weights, int nbWeights);
}

/**
 *  \class IPluginFactoryExt
 * 
 *  \brief Plugin factory used to configure plugins with added support for TRT versioning.
 *  */
@Namespace("nvcaffeparser1") public static class IPluginFactoryExt extends IPluginFactory {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IPluginFactoryExt(Pointer p) { super(p); }

    
    
    //!
    //!
    //!
    public native int getVersion();

    /**
     *  \brief A user implemented function that determines if a layer configuration is provided by an IPluginExt.
     * 
     *  @param layerName Name of the layer which the user wishes to validate.
     *  */
    public native @Cast("bool") boolean isPluginExt(String layerName);
    public native @Cast("bool") boolean isPluginExt(@Cast("const char*") BytePointer layerName);
}

/**
 *  \class ICaffeParser
 * 
 *  \brief Class used for parsing Caffe models.
 * 
 *  Allows users to export models trained using Caffe to TRT.
 *  */
@Namespace("nvcaffeparser1") public static class ICaffeParser extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ICaffeParser(Pointer p) { super(p); }


    /**
     *  \brief Parse a prototxt file and a binaryproto Caffe model to extract
     *    network configuration and weights associated with the network, respectively.
     * 
     *  @param deploy The plain text, prototxt file used to define the network configuration.
     *  @param model The binaryproto Caffe model that contains the weights associated with the network.
     *  @param network Network in which the CaffeParser will fill the layers.
     *  @param weightType The type to which the weights will transformed.
     * 
     *  @return A pointer to an IBlobNameToTensor object that contains the extracted data.
     * 
     *  @see nvcaffeparser1::IBlobNameToTensor
     *  */
    
    
    //!
    //!
    //!
    //!
    //!
    //!
    public native @Const IBlobNameToTensor parse(String deploy,
                                                  String model,
                                                  @ByRef INetworkDefinition network,
                                                  DataType weightType);
    public native @Const IBlobNameToTensor parse(@Cast("const char*") BytePointer deploy,
                                                  @Cast("const char*") BytePointer model,
                                                  @ByRef INetworkDefinition network,
                                                  @Cast("nvinfer1::DataType") int weightType);

    /**
     *  \brief Parse and extract data stored in binaryproto file.
     * 
     *  The binaryproto file contains data stored in a binary blob. parseBinaryProto() converts it
     *  to an IBinaryProtoBlob object which gives the user access to the data and meta-data about data.
     * 
     *  @param fileName Path to file containing binary proto.
     * 
     *  @return A pointer to an IBinaryProtoBlob object that contains the extracted data.
     * 
     *  @see nvcaffeparser1::IBinaryProtoBlob
     *  */
    
    
    //!
    //!
    //!
    //!
    public native IBinaryProtoBlob parseBinaryProto(String fileName);
    public native IBinaryProtoBlob parseBinaryProto(@Cast("const char*") BytePointer fileName);

    /**
     *  \brief Set buffer size for the parsing and storage of the learned model.
     * 
     *  @param size The size of the buffer specified as the number of bytes.
     * 
     *  \note  Default size is 2^30 bytes.
     *  */
    
    
    //!
    //!
    //!
    public native void setProtobufBufferSize(@Cast("size_t") long size);

    /**
     *  \brief Set the IPluginFactory used to create the user defined plugins.
     * 
     *  @param factory Pointer to an instance of the user implmentation of IPluginFactory.
     *  */
    
    
    //!
    //!
    //!
    public native void setPluginFactory(IPluginFactory factory);

    /**
     *  \brief Set the IPluginFactoryExt used to create the user defined pluginExts.
     * 
     *  @param factory Pointer to an instance of the user implmentation of IPluginFactoryExt.
     *  */
    
    
    //!
    //!
    public native void setPluginFactoryExt(IPluginFactoryExt factory);

    /**
     *  \brief Destroy this ICaffeParser object.
     *  */
    public native void destroy();
}

/**
 *  \brief Creates a ICaffeParser object.
 * 
 *  @return A pointer to the ICaffeParser object is returned.
 * 
 *  @see nvcaffeparser1::ICaffeParser
 *  */


//!
//!
//!
@Namespace("nvcaffeparser1") public static native ICaffeParser createCaffeParser();

/**
 *  \brief Shuts down protocol buffers library.
 * 
 *  \note No part of the protocol buffers library can be used after this function is called.
 *  */
@Namespace("nvcaffeparser1") public static native void shutdownProtobufLibrary();


// #endif


// Parsed from NvUffParser.h

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

// #ifndef NV_UFF_PARSER_H
// #define NV_UFF_PARSER_H

// #include "NvInfer.h"

//Current supported Universal Framework Format (UFF) version for the parser.
public static final int UFF_REQUIRED_VERSION_MAJOR = 0;
public static final int UFF_REQUIRED_VERSION_MINOR = 4;
public static final int UFF_REQUIRED_VERSION_PATCH = 0;

/**
 *  \enum UffInputOrder
 *  \brief The different possible supported input order.
 *  */
@Namespace("nvuffparser") public enum UffInputOrder {
    /** NCHW order. */
    kNCHW(0),
    /** NHWC order. */
    kNHWC(1),
    /** NC order. */
    kNC(2);

    public final int value;
    private UffInputOrder(int v) { this.value = v; }
    private UffInputOrder(UffInputOrder e) { this.value = e.value; }
    public UffInputOrder intern() { for (UffInputOrder e : values()) if (e.value == value) return e; return this; }
    @Override public String toString() { return intern().name(); }
}

/**
 *  \enum FieldType
 *  \brief The possible field types for custom layer.
 *  */

@Namespace("nvuffparser") public enum FieldType {
    /** FP32 field type. */
    kFLOAT(0),
    /** INT32 field type. */
    kINT32(1),
    /** char field type. String for length>1. */
    kCHAR(2),
    /** nvinfer1::Dims field type. */
    kDIMS(4),
    /** nvinfer1::DataType field type. */
    kDATATYPE(5),
    kUNKNOWN(6);

    public final int value;
    private FieldType(int v) { this.value = v; }
    private FieldType(FieldType e) { this.value = e.value; }
    public FieldType intern() { for (FieldType e : values()) if (e.value == value) return e; return this; }
    @Override public String toString() { return intern().name(); }
}

/**
 *  \class FieldMap
 * 
 *  \brief An array of field params used as a layer parameter for plugin layers.
 * 
 *  The node fields are passed by the parser to the API through the plugin
 *  constructor. The implementation of the plugin should parse the contents of
 *  the fieldMap as part of the plugin constructor
 *  */
@Namespace("nvuffparser") @NoOffset public static class FieldMap extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FieldMap(Pointer p) { super(p); }

    @MemberGetter public native String name();
    @MemberGetter public native @Const Pointer data();
    public native FieldType type(); public native FieldMap type(FieldType type);
    public native int length(); public native FieldMap length(int length);

    public FieldMap(String name, @Const Pointer data, FieldType type, int length/*=1*/) { super((Pointer)null); allocate(name, data, type, length); }
    private native void allocate(String name, @Const Pointer data, FieldType type, int length/*=1*/);
    public FieldMap(String name, @Const Pointer data, FieldType type) { super((Pointer)null); allocate(name, data, type); }
    private native void allocate(String name, @Const Pointer data, FieldType type);
    public FieldMap(@Cast("const char*") BytePointer name, @Const Pointer data, @Cast("nvuffparser::FieldType") int type, int length/*=1*/) { super((Pointer)null); allocate(name, data, type, length); }
    private native void allocate(@Cast("const char*") BytePointer name, @Const Pointer data, @Cast("nvuffparser::FieldType") int type, int length/*=1*/);
    public FieldMap(@Cast("const char*") BytePointer name, @Const Pointer data, @Cast("nvuffparser::FieldType") int type) { super((Pointer)null); allocate(name, data, type); }
    private native void allocate(@Cast("const char*") BytePointer name, @Const Pointer data, @Cast("nvuffparser::FieldType") int type);
}

@Namespace("nvuffparser") public static class FieldCollection extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public FieldCollection() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public FieldCollection(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FieldCollection(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public FieldCollection position(long position) {
        return (FieldCollection)super.position(position);
    }

    public native int nbFields(); public native FieldCollection nbFields(int nbFields);
    @MemberGetter public native @Const FieldMap fields();
}

/**
 *  \class IPluginFactory
 * 
 *  \brief Plugin factory used to configure plugins.
 *  */
@Name("nvuffparser::IPluginFactory") public static class IUffPluginFactory extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IUffPluginFactory(Pointer p) { super(p); }

    /**
     *  \brief A user implemented function that determines if a layer configuration is provided by an IPlugin.
     * 
     *  @param layerName Name of the layer which the user wishes to validate.
     *  */
    
    
    //!
    //!
    //!
    //!
    public native @Cast("bool") boolean isPlugin(String layerName);
    public native @Cast("bool") boolean isPlugin(@Cast("const char*") BytePointer layerName);

    /**
     *  \brief Creates a plugin.
     * 
     *  @param layerName Name of layer associated with the plugin.
     *  @param weights Weights used for the layer.
     *  @param nbWeights Number of weights.
     *  @param fc A collection of FieldMaps used as layer parameters for different plugin layers.
     * 
     *  @see FieldCollection
     *  */
    public native IPlugin createPlugin(String layerName, @Const Weights weights, int nbWeights,
                                                @Const @ByVal FieldCollection fc);
    public native IPlugin createPlugin(@Cast("const char*") BytePointer layerName, @Const Weights weights, int nbWeights,
                                                @Const @ByVal FieldCollection fc);

}

/**
 *  \class IPluginFactoryExt
 * 
 *  \brief Plugin factory used to configure plugins with added support for TRT versioning.
 *  */
@Name("nvuffparser::IPluginFactoryExt") public static class IUffPluginFactoryExt extends IUffPluginFactory {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IUffPluginFactoryExt(Pointer p) { super(p); }

    
    
    //!
    //!
    //!
    public native int getVersion();

    /**
     *  \brief A user implemented function that determines if a layer configuration is provided by an IPluginExt.
     * 
     *  @param layerName Name of the layer which the user wishes to validate.
     *  */
    public native @Cast("bool") boolean isPluginExt(String layerName);
    public native @Cast("bool") boolean isPluginExt(@Cast("const char*") BytePointer layerName);
}

/**
 *  \class IUffParser
 * 
 *  \brief Class used for parsing models described using the UFF format.
 *  */
@Namespace("nvuffparser") public static class IUffParser extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public IUffParser(Pointer p) { super(p); }

    /**
     *  \brief Register an input name of a UFF network with the associated Dimensions.
     * 
     *  @param inputName Input name.
     *  @param inputDims Input Dimensions, always provide your dimensions in CHW even if your network
     *                   input was in HWC in yout original framework.
     *  @param inputOrder Input order on which the framework input was originally.
     *  */
    
    
    //!
    //!
    //!
    public native @Cast("bool") boolean registerInput(String inputName, @ByVal Dims inputDims, UffInputOrder inputOrder);
    public native @Cast("bool") boolean registerInput(@Cast("const char*") BytePointer inputName, @ByVal Dims inputDims, @Cast("nvuffparser::UffInputOrder") int inputOrder);

    /**
     *  \brief Register an output name of a UFF network.
     * 
     *  @param outputName Output name.
     *  */
    
    
    //!
    //!
    //!
    public native @Cast("bool") boolean registerOutput(String outputName);
    public native @Cast("bool") boolean registerOutput(@Cast("const char*") BytePointer outputName);

    /**
     *  \brief Parse a UFF file.
     * 
     *  @param file File name of the UFF file.
     *  @param network Network in which the UFFParser will fill the layers.
     *  @param weightsType The type on which the weights will transformed in.
     *  */
    
    
    //!
    //!
    //!
    public native @Cast("bool") boolean parse(String file,
                           @ByRef INetworkDefinition network,
                           DataType weightsType/*=nvinfer1::DataType::kFLOAT*/);
    public native @Cast("bool") boolean parse(String file,
                           @ByRef INetworkDefinition network);
    public native @Cast("bool") boolean parse(@Cast("const char*") BytePointer file,
                           @ByRef INetworkDefinition network,
                           @Cast("nvinfer1::DataType") int weightsType/*=nvinfer1::DataType::kFLOAT*/);
    public native @Cast("bool") boolean parse(@Cast("const char*") BytePointer file,
                           @ByRef INetworkDefinition network);

    /**
     *  \brief Parse a UFF buffer, useful if the file already live in memory.
     * 
     *  @param buffer Buffer of the UFF file.
     *  @param size Size of buffer of the UFF file.
     *  @param network Network in which the UFFParser will fill the layers.
     *  @param weightsType The type on which the weights will transformed in.
     *  */
    public native @Cast("bool") boolean parseBuffer(String buffer, @Cast("std::size_t") long size,
                                 @ByRef INetworkDefinition network,
                                 DataType weightsType/*=nvinfer1::DataType::kFLOAT*/);
    public native @Cast("bool") boolean parseBuffer(String buffer, @Cast("std::size_t") long size,
                                 @ByRef INetworkDefinition network);
    public native @Cast("bool") boolean parseBuffer(@Cast("const char*") BytePointer buffer, @Cast("std::size_t") long size,
                                 @ByRef INetworkDefinition network,
                                 @Cast("nvinfer1::DataType") int weightsType/*=nvinfer1::DataType::kFLOAT*/);
    public native @Cast("bool") boolean parseBuffer(@Cast("const char*") BytePointer buffer, @Cast("std::size_t") long size,
                                 @ByRef INetworkDefinition network);

    
    
    //!
    //!
    public native void destroy();

    /**
     *  \brief Return Version Major of the UFF.
     *  */
    
    
    //!
    //!
    public native int getUffRequiredVersionMajor();

    /**
     *  \brief Return Version Minor of the UFF.
     *  */
    
    
    //!
    //!
    public native int getUffRequiredVersionMinor();

    /**
     *  \brief Return Patch Version of the UFF.
     *  */
    
    
    //!
    //!
    //!
    public native int getUffRequiredVersionPatch();

    /**
     *  \brief Set the IPluginFactory used to create the user defined plugins.
     * 
     *  @param factory Pointer to an instance of the user implmentation of IPluginFactory.
     *  */
    
    
    //!
    //!
    //!
    public native void setPluginFactory(IUffPluginFactory factory);

    /**
     *  \brief Set the IPluginFactoryExt used to create the user defined pluginExts.
     * 
     *  @param factory Pointer to an instance of the user implmentation of IPluginFactoryExt.
     *  */
    public native void setPluginFactoryExt(IUffPluginFactoryExt factory);
}

/**
 *  \brief Creates a IUffParser object.
 * 
 *  @return A pointer to the IUffParser object is returned.
 * 
 *  @see nvuffparser::IUffParser
 *  */


//!
//!
//!
@Namespace("nvuffparser") public static native IUffParser createUffParser();

/**
 *  \brief Shuts down protocol buffers library.
 * 
 *  \note No part of the protocol buffers library can be used after this function is called.
 *  */



// #endif /* !NV_UFF_PARSER_H */


}
