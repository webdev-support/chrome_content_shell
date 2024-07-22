package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class VideoCaptureParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public int bufferType;
  public boolean enableFaceDetection;
  public boolean isHighDpiEnabled;
  public int powerLineFrequency;
  public VideoCaptureFormat requestedFormat;
  public int resolutionChangePolicy;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0), new DataHeader(32, 1)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[1];
  }

  private VideoCaptureParams(int version) {
    super(32, version);
  }

  public VideoCaptureParams() {
    this(1);
  }

  public static VideoCaptureParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoCaptureParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoCaptureParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoCaptureParams result = new VideoCaptureParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.requestedFormat = VideoCaptureFormat.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.bufferType = readInt;
      VideoCaptureBufferType.validate(readInt);
      result.bufferType = VideoCaptureBufferType.toKnownValue(result.bufferType);
      int readInt2 = decoder0.readInt(20);
      result.resolutionChangePolicy = readInt2;
      ResolutionChangePolicy.validate(readInt2);
      result.resolutionChangePolicy =
          ResolutionChangePolicy.toKnownValue(result.resolutionChangePolicy);
      int readInt3 = decoder0.readInt(24);
      result.powerLineFrequency = readInt3;
      PowerLineFrequency.validate(readInt3);
      result.powerLineFrequency = PowerLineFrequency.toKnownValue(result.powerLineFrequency);
      result.enableFaceDetection = decoder0.readBoolean(28, 0);
      if (elementsOrVersion >= 1) {
        result.isHighDpiEnabled = decoder0.readBoolean(28, 1);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.requestedFormat, 8, false);
    encoder0.encode(this.bufferType, 16);
    encoder0.encode(this.resolutionChangePolicy, 20);
    encoder0.encode(this.powerLineFrequency, 24);
    encoder0.encode(this.enableFaceDetection, 28, 0);
    encoder0.encode(this.isHighDpiEnabled, 28, 1);
  }
}
