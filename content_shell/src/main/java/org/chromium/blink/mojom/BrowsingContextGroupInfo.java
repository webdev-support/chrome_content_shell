package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class BrowsingContextGroupInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public UnguessableToken browsingContextGroupToken;
  public UnguessableToken coopRelatedGroupToken;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BrowsingContextGroupInfo(int version) {
    super(24, version);
  }

  public BrowsingContextGroupInfo() {
    this(0);
  }

  public static BrowsingContextGroupInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BrowsingContextGroupInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BrowsingContextGroupInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BrowsingContextGroupInfo result = new BrowsingContextGroupInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.browsingContextGroupToken = UnguessableToken.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.coopRelatedGroupToken = UnguessableToken.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.browsingContextGroupToken, 8, false);
    encoder0.encode((Struct) this.coopRelatedGroupToken, 16, false);
  }
}
