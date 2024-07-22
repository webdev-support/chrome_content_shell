package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class LoadInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public String host;
  public int loadState;
  public String16 stateParam;
  public TimeTicks timestamp;
  public long uploadPosition;
  public long uploadSize;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private LoadInfo(int version) {
    super(56, version);
  }

  public LoadInfo() {
    this(0);
  }

  public static LoadInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static LoadInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static LoadInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      LoadInfo result = new LoadInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.timestamp = TimeTicks.decode(decoder1);
      result.host = decoder0.readString(16, false);
      result.loadState = decoder0.readInt(24);
      Decoder decoder12 = decoder0.readPointer(32, false);
      result.stateParam = String16.decode(decoder12);
      result.uploadPosition = decoder0.readLong(40);
      result.uploadSize = decoder0.readLong(48);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.timestamp, 8, false);
    encoder0.encode(this.host, 16, false);
    encoder0.encode(this.loadState, 24);
    encoder0.encode((Struct) this.stateParam, 32, false);
    encoder0.encode(this.uploadPosition, 40);
    encoder0.encode(this.uploadSize, 48);
  }
}
