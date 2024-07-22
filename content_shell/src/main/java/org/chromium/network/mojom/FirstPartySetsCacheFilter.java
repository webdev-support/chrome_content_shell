package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class FirstPartySetsCacheFilter extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public long browserRunId;
  public Map<SchemefulSite, Long> filter;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FirstPartySetsCacheFilter(int version) {
    super(24, version);
    this.browserRunId = 0L;
  }

  public FirstPartySetsCacheFilter() {
    this(0);
  }

  public static FirstPartySetsCacheFilter deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FirstPartySetsCacheFilter deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FirstPartySetsCacheFilter decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FirstPartySetsCacheFilter result = new FirstPartySetsCacheFilter(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      decoder1.readDataHeaderForMap();
      Decoder decoder2 = decoder1.readPointer(8, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
      SchemefulSite[] keys0 = new SchemefulSite[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        Decoder decoder3 = decoder2.readPointer((i2 * 8) + 8, false);
        keys0[i2] = SchemefulSite.decode(decoder3);
      }
      long[] values0 = decoder1.readLongs(16, 0, keys0.length);
      result.filter = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.filter.put(keys0[index0], Long.valueOf(values0[index0]));
      }
      result.browserRunId = decoder0.readLong(16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    if (this.filter == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encoderForMap(8);
      int size0 = this.filter.size();
      SchemefulSite[] keys0 = new SchemefulSite[size0];
      long[] values0 = new long[size0];
      int index0 = 0;
      for (Map.Entry<SchemefulSite, Long> entry0 : this.filter.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue().longValue();
        index0++;
      }
      Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode((Struct) keys0[i1], (i1 * 8) + 8, false);
      }
      encoder1.encode(values0, 16, 0, -1);
    }
    encoder0.encode(this.browserRunId, 16);
  }
}
