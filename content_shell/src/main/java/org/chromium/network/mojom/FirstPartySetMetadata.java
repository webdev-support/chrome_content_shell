package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class FirstPartySetMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public FirstPartySetEntry frameEntry;
  public FirstPartySetEntry topFrameEntry;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FirstPartySetMetadata(int version) {
    super(24, version);
  }

  public FirstPartySetMetadata() {
    this(0);
  }

  public static FirstPartySetMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FirstPartySetMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FirstPartySetMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FirstPartySetMetadata result = new FirstPartySetMetadata(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.frameEntry = FirstPartySetEntry.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.topFrameEntry = FirstPartySetEntry.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.frameEntry, 8, true);
    encoder0.encode((Struct) this.topFrameEntry, 16, true);
  }
}
