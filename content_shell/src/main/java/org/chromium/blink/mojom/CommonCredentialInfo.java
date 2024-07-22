package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CommonCredentialInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[] authenticatorData;
  public byte[] clientDataJson;

  public String f411id;
  public byte[] rawId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CommonCredentialInfo(int version) {
    super(40, version);
  }

  public CommonCredentialInfo() {
    this(0);
  }

  public static CommonCredentialInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CommonCredentialInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CommonCredentialInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CommonCredentialInfo result = new CommonCredentialInfo(elementsOrVersion);
      result.f411id = decoder0.readString(8, false);
      result.rawId = decoder0.readBytes(16, 0, -1);
      result.clientDataJson = decoder0.readBytes(24, 0, -1);
      result.authenticatorData = decoder0.readBytes(32, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f411id, 8, false);
    encoder0.encode(this.rawId, 16, 0, -1);
    encoder0.encode(this.clientDataJson, 24, 0, -1);
    encoder0.encode(this.authenticatorData, 32, 0, -1);
  }
}
