package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.ListValue;
import org.chromium.mojo_base.mojom.Value;

public final class StatusData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public StatusData cause;
  public short code;
  public Value data;
  public ListValue frames;
  public String group;
  public String message;
  public long packedRootCause;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private StatusData(int version) {
    super(72, version);
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
      result.code = decoder0.readShort(16);
      result.message = decoder0.readString(24, false);
      Decoder decoder1 = decoder0.readPointer(32, false);
      result.frames = ListValue.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(40, true);
      result.cause = decode(decoder12);
      result.data = Value.decode(decoder0, 48);
      result.packedRootCause = decoder0.readLong(64);
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
    encoder0.encode((Struct) this.frames, 32, false);
    encoder0.encode((Struct) this.cause, 40, true);
    encoder0.encode((Union) this.data, 48, false);
    encoder0.encode(this.packedRootCause, 64);
  }
}
