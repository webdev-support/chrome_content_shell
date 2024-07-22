package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CableAuthentication extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[] authenticatorEid;
  public byte[] clientEid;
  public byte[] experiments;
  public byte[] serverLinkData;
  public byte[] sessionPreKey;
  public byte version;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CableAuthentication(int version) {
    super(56, version);
  }

  public CableAuthentication() {
    this(0);
  }

  public static CableAuthentication deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CableAuthentication deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CableAuthentication decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CableAuthentication result = new CableAuthentication(elementsOrVersion);
      result.version = decoder0.readByte(8);
      result.clientEid = decoder0.readBytes(16, 1, 16);
      result.authenticatorEid = decoder0.readBytes(24, 1, 16);
      result.sessionPreKey = decoder0.readBytes(32, 1, 32);
      result.serverLinkData = decoder0.readBytes(40, 1, -1);
      result.experiments = decoder0.readBytes(48, 1, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.version, 8);
    encoder0.encode(this.clientEid, 16, 1, 16);
    encoder0.encode(this.authenticatorEid, 24, 1, 16);
    encoder0.encode(this.sessionPreKey, 32, 1, 32);
    encoder0.encode(this.serverLinkData, 40, 1, -1);
    encoder0.encode(this.experiments, 48, 1, -1);
  }
}
