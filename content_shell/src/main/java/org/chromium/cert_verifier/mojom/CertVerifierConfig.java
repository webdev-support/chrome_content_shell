package org.chromium.cert_verifier.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CertVerifierConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean disableSymantecEnforcement;
  public boolean enableRevChecking;
  public boolean enableSha1LocalAnchors;
  public boolean requireRevCheckingLocalAnchors;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CertVerifierConfig(int version) {
    super(16, version);
  }

  public CertVerifierConfig() {
    this(0);
  }

  public static CertVerifierConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CertVerifierConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CertVerifierConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CertVerifierConfig result = new CertVerifierConfig(elementsOrVersion);
      result.enableRevChecking = decoder0.readBoolean(8, 0);
      result.requireRevCheckingLocalAnchors = decoder0.readBoolean(8, 1);
      result.enableSha1LocalAnchors = decoder0.readBoolean(8, 2);
      result.disableSymantecEnforcement = decoder0.readBoolean(8, 3);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.enableRevChecking, 8, 0);
    encoder0.encode(this.requireRevCheckingLocalAnchors, 8, 1);
    encoder0.encode(this.enableSha1LocalAnchors, 8, 2);
    encoder0.encode(this.disableSymantecEnforcement, 8, 3);
  }
}
