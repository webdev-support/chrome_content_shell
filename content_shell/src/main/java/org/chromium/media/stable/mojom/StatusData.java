package org.chromium.media.stable.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.Value;

public final class StatusData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public StatusData cause;
  public int code;
  public Value data;
  public Value[] frames;
  public String group;
  public String message;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private StatusData(int version) {
    super(64, version);
  }

  public StatusData() {
    this(0);
  }

  public static StatusData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static StatusData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static StatusData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      StatusData result = new StatusData(elementsOrVersion);
      result.group = decoder0.readString(8, false);
      int readInt = decoder0.readInt(16);
      result.code = readInt;
      StatusCode.validate(readInt);
      result.code = StatusCode.toKnownValue(result.code);
      result.message = decoder0.readString(24, false);
      Decoder decoder1 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.frames = new Value[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.frames[i1] = Value.decode(decoder1, (i1 * 16) + 8);
      }
      result.cause = decode(decoder0.readPointer(40, true));
      result.data = Value.decode(decoder0, 48);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.group, 8, false);
    encoder0.encode(this.code, 16);
    encoder0.encode(this.message, 24, false);
    Value[] valueArr = this.frames;
    if (valueArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder1 = encoder0.encodeUnionArray(valueArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        Value[] valueArr2 = this.frames;
        if (i0 >= valueArr2.length) {
          break;
        }
        encoder1.encode((Union) valueArr2[i0], (i0 * 16) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.cause, 40, true);
    encoder0.encode((Union) this.data, 48, false);
  }
}
