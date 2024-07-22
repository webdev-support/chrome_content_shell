package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.BufferUsageAndFormat;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SharedImageCapabilities extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean disableR8SharedImages;
  public boolean disableWebgpuSharedImages;
  public boolean isR16fSupported;
  public boolean sharedImageD3d;
  public boolean sharedImageSwapChain;
  public boolean supportsLuminanceSharedImages;
  public boolean supportsR16SharedImages;
  public boolean supportsScanoutSharedImages;
  public BufferUsageAndFormat[] textureTargetExceptionList;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SharedImageCapabilities(int version) {
    super(24, version);
  }

  public SharedImageCapabilities() {
    this(0);
  }

  public static SharedImageCapabilities deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SharedImageCapabilities deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SharedImageCapabilities decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SharedImageCapabilities result = new SharedImageCapabilities(elementsOrVersion);
      result.supportsScanoutSharedImages = decoder0.readBoolean(8, 0);
      result.supportsLuminanceSharedImages = decoder0.readBoolean(8, 1);
      result.supportsR16SharedImages = decoder0.readBoolean(8, 2);
      result.isR16fSupported = decoder0.readBoolean(8, 3);
      result.disableR8SharedImages = decoder0.readBoolean(8, 4);
      result.disableWebgpuSharedImages = decoder0.readBoolean(8, 5);
      result.sharedImageD3d = decoder0.readBoolean(8, 6);
      result.sharedImageSwapChain = decoder0.readBoolean(8, 7);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.textureTargetExceptionList = new BufferUsageAndFormat[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.textureTargetExceptionList[i1] = BufferUsageAndFormat.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.supportsScanoutSharedImages, 8, 0);
    encoder0.encode(this.supportsLuminanceSharedImages, 8, 1);
    encoder0.encode(this.supportsR16SharedImages, 8, 2);
    encoder0.encode(this.isR16fSupported, 8, 3);
    encoder0.encode(this.disableR8SharedImages, 8, 4);
    encoder0.encode(this.disableWebgpuSharedImages, 8, 5);
    encoder0.encode(this.sharedImageD3d, 8, 6);
    encoder0.encode(this.sharedImageSwapChain, 8, 7);
    BufferUsageAndFormat[] bufferUsageAndFormatArr = this.textureTargetExceptionList;
    if (bufferUsageAndFormatArr == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(bufferUsageAndFormatArr.length, 16, -1);
    int i0 = 0;
    while (true) {
      BufferUsageAndFormat[] bufferUsageAndFormatArr2 = this.textureTargetExceptionList;
      if (i0 < bufferUsageAndFormatArr2.length) {
        encoder1.encode((Struct) bufferUsageAndFormatArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
