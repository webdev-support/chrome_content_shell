package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class NonEmptyNetworkIsolationKey extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public SchemefulSite frameSite;
  public UnguessableToken nonce;
  public SchemefulSite topFrameSite;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NonEmptyNetworkIsolationKey(int version) {
    super(32, version);
  }

  public NonEmptyNetworkIsolationKey() {
    this(0);
  }

  public static NonEmptyNetworkIsolationKey deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NonEmptyNetworkIsolationKey deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NonEmptyNetworkIsolationKey decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NonEmptyNetworkIsolationKey result = new NonEmptyNetworkIsolationKey(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.topFrameSite = SchemefulSite.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.frameSite = SchemefulSite.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.nonce = UnguessableToken.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.topFrameSite, 8, false);
    encoder0.encode((Struct) this.frameSite, 16, false);
    encoder0.encode((Struct) this.nonce, 24, true);
  }
}
