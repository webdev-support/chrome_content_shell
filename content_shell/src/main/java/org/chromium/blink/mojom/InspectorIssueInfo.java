package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class InspectorIssueInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int code;
  public InspectorIssueDetails details;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private InspectorIssueInfo(int version) {
    super(24, version);
  }

  public InspectorIssueInfo() {
    this(0);
  }

  public static InspectorIssueInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static InspectorIssueInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static InspectorIssueInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      InspectorIssueInfo result = new InspectorIssueInfo(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.code = readInt;
      InspectorIssueCode.validate(readInt);
      result.code = InspectorIssueCode.toKnownValue(result.code);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.details = InspectorIssueDetails.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.code, 8);
    encoder0.encode((Struct) this.details, 16, false);
  }
}
