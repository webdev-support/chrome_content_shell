package org.chromium.service_manager.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Token;

public final class Identity extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public Token globallyUniqueId;
  public Token instanceGroup;
  public Token instanceId;
  public String name;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private Identity(int version) {
    super(40, version);
  }

  public Identity() {
    this(0);
  }

  public static Identity deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static Identity deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static Identity decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      Identity result = new Identity(elementsOrVersion);
      result.name = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.instanceGroup = Token.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.instanceId = Token.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.globallyUniqueId = Token.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.name, 8, false);
    encoder0.encode((Struct) this.instanceGroup, 16, false);
    encoder0.encode((Struct) this.instanceId, 24, false);
    encoder0.encode((Struct) this.globallyUniqueId, 32, false);
  }
}
