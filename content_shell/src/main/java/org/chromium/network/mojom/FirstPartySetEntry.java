package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class FirstPartySetEntry extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public SchemefulSite primary;
  public SiteIndex siteIndex;
  public int siteType;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FirstPartySetEntry(int version) {
    super(32, version);
  }

  public FirstPartySetEntry() {
    this(0);
  }

  public static FirstPartySetEntry deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FirstPartySetEntry deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FirstPartySetEntry decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FirstPartySetEntry result = new FirstPartySetEntry(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.primary = SchemefulSite.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.siteType = readInt;
      SiteType.validate(readInt);
      result.siteType = SiteType.toKnownValue(result.siteType);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.siteIndex = SiteIndex.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.primary, 8, false);
    encoder0.encode(this.siteType, 16);
    encoder0.encode((Struct) this.siteIndex, 24, true);
  }
}
