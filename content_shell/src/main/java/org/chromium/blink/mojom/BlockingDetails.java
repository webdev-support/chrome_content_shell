package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class BlockingDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public long columnNumber;
  public Integer feature;
  public String functionName;
  public long lineNumber;
  public String url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BlockingDetails(int version) {
    super(48, version);
  }

  public BlockingDetails() {
    this(0);
  }

  public static BlockingDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BlockingDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BlockingDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BlockingDetails result = new BlockingDetails(elementsOrVersion);
      if (decoder0.readBoolean(8, 0)) {
        result.feature = new Integer(decoder0.readInt(12));
      } else {
        result.feature = null;
      }
      result.url = decoder0.readString(16, true);
      result.functionName = decoder0.readString(24, true);
      result.lineNumber = decoder0.readLong(32);
      result.columnNumber = decoder0.readLong(40);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    int feature$value;
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    Integer num = this.feature;
    boolean feature$flag = num != null;
    if (feature$flag) {
      feature$value = num.intValue();
    } else {
      feature$value = 0;
    }
    encoder0.encode(feature$flag, 8, 0);
    encoder0.encode(feature$value, 12);
    encoder0.encode(this.url, 16, true);
    encoder0.encode(this.functionName, 24, true);
    encoder0.encode(this.lineNumber, 32);
    encoder0.encode(this.columnNumber, 40);
  }
}
