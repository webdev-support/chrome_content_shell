package org.chromium.attribution_reporting.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AggregatableDedupKey extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public Long dedupKey;
  public FilterPair filters;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AggregatableDedupKey(int version) {
    super(32, version);
  }

  public AggregatableDedupKey() {
    this(0);
  }

  public static AggregatableDedupKey deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AggregatableDedupKey deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AggregatableDedupKey decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AggregatableDedupKey result = new AggregatableDedupKey(elementsOrVersion);
      if (decoder0.readBoolean(8, 0)) {
        result.dedupKey = new Long(decoder0.readLong(16));
      } else {
        result.dedupKey = null;
      }
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.filters = FilterPair.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    long dedupKey$value;
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    Long l = this.dedupKey;
    boolean dedupKey$flag = l != null;
    if (dedupKey$flag) {
      dedupKey$value = l.longValue();
    } else {
      dedupKey$value = 0;
    }
    encoder0.encode(dedupKey$flag, 8, 0);
    encoder0.encode(dedupKey$value, 16);
    encoder0.encode((Struct) this.filters, 24, false);
  }
}
