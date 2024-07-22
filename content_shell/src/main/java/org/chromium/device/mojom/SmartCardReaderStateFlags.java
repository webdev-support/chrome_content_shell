package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SmartCardReaderStateFlags extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean changed;
  public boolean empty;
  public boolean exclusive;
  public boolean ignore;
  public boolean inuse;
  public boolean mute;
  public boolean present;
  public boolean unavailable;
  public boolean unaware;
  public boolean unknown;
  public boolean unpowered;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SmartCardReaderStateFlags(int version) {
    super(16, version);
  }

  public SmartCardReaderStateFlags() {
    this(0);
  }

  public static SmartCardReaderStateFlags deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SmartCardReaderStateFlags deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SmartCardReaderStateFlags decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SmartCardReaderStateFlags result = new SmartCardReaderStateFlags(elementsOrVersion);
      result.unaware = decoder0.readBoolean(8, 0);
      result.ignore = decoder0.readBoolean(8, 1);
      result.changed = decoder0.readBoolean(8, 2);
      result.unknown = decoder0.readBoolean(8, 3);
      result.unavailable = decoder0.readBoolean(8, 4);
      result.empty = decoder0.readBoolean(8, 5);
      result.present = decoder0.readBoolean(8, 6);
      result.exclusive = decoder0.readBoolean(8, 7);
      result.inuse = decoder0.readBoolean(9, 0);
      result.mute = decoder0.readBoolean(9, 1);
      result.unpowered = decoder0.readBoolean(9, 2);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.unaware, 8, 0);
    encoder0.encode(this.ignore, 8, 1);
    encoder0.encode(this.changed, 8, 2);
    encoder0.encode(this.unknown, 8, 3);
    encoder0.encode(this.unavailable, 8, 4);
    encoder0.encode(this.empty, 8, 5);
    encoder0.encode(this.present, 8, 6);
    encoder0.encode(this.exclusive, 8, 7);
    encoder0.encode(this.inuse, 9, 0);
    encoder0.encode(this.mute, 9, 1);
    encoder0.encode(this.unpowered, 9, 2);
  }
}
