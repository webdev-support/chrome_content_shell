package org.chromium.mojo.native_types;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class NativeStruct extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[] data;
  public SerializedHandle[] handles;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NativeStruct(int version) {
    super(24, version);
  }

  public NativeStruct() {
    this(0);
  }

  public static NativeStruct deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NativeStruct deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NativeStruct decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NativeStruct result = new NativeStruct(elementsOrVersion);
      result.data = decoder0.readBytes(8, 0, -1);
      Decoder decoder1 = decoder0.readPointer(16, true);
      if (decoder1 == null) {
        result.handles = null;
      } else {
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.handles = new SerializedHandle[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.handles[i1] = SerializedHandle.decode(decoder2);
        }
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.data, 8, 0, -1);
    SerializedHandle[] serializedHandleArr = this.handles;
    if (serializedHandleArr == null) {
      encoder0.encodeNullPointer(16, true);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(serializedHandleArr.length, 16, -1);
    int i0 = 0;
    while (true) {
      SerializedHandle[] serializedHandleArr2 = this.handles;
      if (i0 < serializedHandleArr2.length) {
        encoder1.encode((Struct) serializedHandleArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
