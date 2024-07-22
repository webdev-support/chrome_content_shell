package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AdProperties extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public String adType;
  public double bidFloor;
  public String height;
  public String lang;
  public String slot;
  public String width;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AdProperties(int version) {
    super(56, version);
  }

  public AdProperties() {
    this(0);
  }

  public static AdProperties deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AdProperties deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AdProperties decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AdProperties result = new AdProperties(elementsOrVersion);
      result.width = decoder0.readString(8, false);
      result.height = decoder0.readString(16, false);
      result.slot = decoder0.readString(24, false);
      result.lang = decoder0.readString(32, false);
      result.adType = decoder0.readString(40, false);
      result.bidFloor = decoder0.readDouble(48);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.width, 8, false);
    encoder0.encode(this.height, 16, false);
    encoder0.encode(this.slot, 24, false);
    encoder0.encode(this.lang, 32, false);
    encoder0.encode(this.adType, 40, false);
    encoder0.encode(this.bidFloor, 48);
  }
}
