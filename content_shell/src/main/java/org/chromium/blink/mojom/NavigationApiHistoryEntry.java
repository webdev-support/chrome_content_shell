package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class NavigationApiHistoryEntry extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public long documentSequenceNumber;

  public String16 f444id;
  public long itemSequenceNumber;
  public String16 key;
  public String16 state;
  public String16 url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NavigationApiHistoryEntry(int version) {
    super(56, version);
  }

  public NavigationApiHistoryEntry() {
    this(0);
  }

  public static NavigationApiHistoryEntry deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NavigationApiHistoryEntry deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NavigationApiHistoryEntry decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NavigationApiHistoryEntry result = new NavigationApiHistoryEntry(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.key = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.f444id = String16.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.url = String16.decode(decoder13);
      result.itemSequenceNumber = decoder0.readLong(32);
      result.documentSequenceNumber = decoder0.readLong(40);
      Decoder decoder14 = decoder0.readPointer(48, true);
      result.state = String16.decode(decoder14);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.key, 8, false);
    encoder0.encode((Struct) this.f444id, 16, false);
    encoder0.encode((Struct) this.url, 24, false);
    encoder0.encode(this.itemSequenceNumber, 32);
    encoder0.encode(this.documentSequenceNumber, 40);
    encoder0.encode((Struct) this.state, 48, true);
  }
}
