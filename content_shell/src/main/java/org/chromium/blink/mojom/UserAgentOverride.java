package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class UserAgentOverride extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public UserAgentMetadata uaMetadataOverride;
  public String uaStringOverride;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UserAgentOverride(int version) {
    super(24, version);
  }

  public UserAgentOverride() {
    this(0);
  }

  public static UserAgentOverride deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UserAgentOverride deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UserAgentOverride decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UserAgentOverride result = new UserAgentOverride(elementsOrVersion);
      result.uaStringOverride = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, true);
      result.uaMetadataOverride = UserAgentMetadata.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.uaStringOverride, 8, false);
    encoder0.encode((Struct) this.uaMetadataOverride, 16, true);
  }
}
