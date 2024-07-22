package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.network.mojom.SchemefulSite;
import org.chromium.url.internal.mojom.Origin;

public final class StorageKey extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public int ancestorChainBit;
  public int ancestorChainBitIfThirdPartyEnabled;
  public UnguessableToken nonce;
  public Origin origin;
  public SchemefulSite topLevelSite;
  public SchemefulSite topLevelSiteIfThirdPartyEnabled;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private StorageKey(int version) {
    super(48, version);
  }

  public StorageKey() {
    this(0);
  }

  public static StorageKey deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static StorageKey deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static StorageKey decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      StorageKey result = new StorageKey(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.origin = Origin.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.topLevelSite = SchemefulSite.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.nonce = UnguessableToken.decode(decoder13);
      int readInt = decoder0.readInt(32);
      result.ancestorChainBit = readInt;
      AncestorChainBit.validate(readInt);
      result.ancestorChainBit = AncestorChainBit.toKnownValue(result.ancestorChainBit);
      int readInt2 = decoder0.readInt(36);
      result.ancestorChainBitIfThirdPartyEnabled = readInt2;
      AncestorChainBit.validate(readInt2);
      result.ancestorChainBitIfThirdPartyEnabled =
          AncestorChainBit.toKnownValue(result.ancestorChainBitIfThirdPartyEnabled);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.topLevelSiteIfThirdPartyEnabled = SchemefulSite.decode(decoder14);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.origin, 8, false);
    encoder0.encode((Struct) this.topLevelSite, 16, false);
    encoder0.encode((Struct) this.nonce, 24, true);
    encoder0.encode(this.ancestorChainBit, 32);
    encoder0.encode(this.ancestorChainBitIfThirdPartyEnabled, 36);
    encoder0.encode((Struct) this.topLevelSiteIfThirdPartyEnabled, 40, false);
  }
}
