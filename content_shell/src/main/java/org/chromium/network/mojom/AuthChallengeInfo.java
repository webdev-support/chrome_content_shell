package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.SchemeHostPort;

public final class AuthChallengeInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public String challenge;
  public SchemeHostPort challenger;
  public boolean isProxy;
  public String path;
  public String realm;
  public String scheme;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AuthChallengeInfo(int version) {
    super(56, version);
  }

  public AuthChallengeInfo() {
    this(0);
  }

  public static AuthChallengeInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AuthChallengeInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AuthChallengeInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AuthChallengeInfo result = new AuthChallengeInfo(elementsOrVersion);
      result.isProxy = decoder0.readBoolean(8, 0);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.challenger = SchemeHostPort.decode(decoder1);
      result.scheme = decoder0.readString(24, false);
      result.realm = decoder0.readString(32, false);
      result.challenge = decoder0.readString(40, false);
      result.path = decoder0.readString(48, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.isProxy, 8, 0);
    encoder0.encode((Struct) this.challenger, 16, false);
    encoder0.encode(this.scheme, 24, false);
    encoder0.encode(this.realm, 32, false);
    encoder0.encode(this.challenge, 40, false);
    encoder0.encode(this.path, 48, false);
  }
}
