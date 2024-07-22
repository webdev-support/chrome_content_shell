package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SharedArrayBufferIssueDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public AffectedLocation affectedLocation;
  public boolean isWarning;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SharedArrayBufferIssueDetails(int version) {
    super(24, version);
  }

  public SharedArrayBufferIssueDetails() {
    this(0);
  }

  public static SharedArrayBufferIssueDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SharedArrayBufferIssueDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SharedArrayBufferIssueDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SharedArrayBufferIssueDetails result = new SharedArrayBufferIssueDetails(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.affectedLocation = AffectedLocation.decode(decoder1);
      result.isWarning = decoder0.readBoolean(16, 0);
      int readInt = decoder0.readInt(20);
      result.type = readInt;
      SharedArrayBufferIssueType.validate(readInt);
      result.type = SharedArrayBufferIssueType.toKnownValue(result.type);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.affectedLocation, 8, true);
    encoder0.encode(this.isWarning, 16, 0);
    encoder0.encode(this.type, 20);
  }
}
