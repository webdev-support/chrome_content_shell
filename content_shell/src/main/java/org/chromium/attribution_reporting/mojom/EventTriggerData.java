package org.chromium.attribution_reporting.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class EventTriggerData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public long data;
  public Long dedupKey;
  public FilterPair filters;
  public long priority;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private EventTriggerData(int version) {
    super(48, version);
    this.data = 0L;
    this.priority = 0L;
  }

  public EventTriggerData() {
    this(0);
  }

  public static EventTriggerData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static EventTriggerData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static EventTriggerData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      EventTriggerData result = new EventTriggerData(elementsOrVersion);
      result.data = decoder0.readLong(8);
      result.priority = decoder0.readLong(16);
      if (decoder0.readBoolean(24, 0)) {
        result.dedupKey = new Long(decoder0.readLong(32));
      } else {
        result.dedupKey = null;
      }
      Decoder decoder1 = decoder0.readPointer(40, false);
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
    encoder0.encode(this.data, 8);
    encoder0.encode(this.priority, 16);
    Long l = this.dedupKey;
    boolean dedupKey$flag = l != null;
    if (dedupKey$flag) {
      dedupKey$value = l.longValue();
    } else {
      dedupKey$value = 0;
    }
    encoder0.encode(dedupKey$flag, 24, 0);
    encoder0.encode(dedupKey$value, 32);
    encoder0.encode((Struct) this.filters, 40, false);
  }
}
