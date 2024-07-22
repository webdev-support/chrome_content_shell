package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class MixedContentIssueDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public AffectedFrame frame;
  public String insecureUrl;
  public String mainResourceUrl;
  public AffectedRequest request;
  public int requestContext;
  public int resolutionStatus;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private MixedContentIssueDetails(int version) {
    super(48, version);
  }

  public MixedContentIssueDetails() {
    this(0);
  }

  public static MixedContentIssueDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MixedContentIssueDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MixedContentIssueDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MixedContentIssueDetails result = new MixedContentIssueDetails(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.requestContext = readInt;
      RequestContextType.validate(readInt);
      result.requestContext = RequestContextType.toKnownValue(result.requestContext);
      int readInt2 = decoder0.readInt(12);
      result.resolutionStatus = readInt2;
      MixedContentResolutionStatus.validate(readInt2);
      result.resolutionStatus = MixedContentResolutionStatus.toKnownValue(result.resolutionStatus);
      result.insecureUrl = decoder0.readString(16, false);
      result.mainResourceUrl = decoder0.readString(24, false);
      Decoder decoder1 = decoder0.readPointer(32, true);
      result.request = AffectedRequest.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(40, true);
      result.frame = AffectedFrame.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.requestContext, 8);
    encoder0.encode(this.resolutionStatus, 12);
    encoder0.encode(this.insecureUrl, 16, false);
    encoder0.encode(this.mainResourceUrl, 24, false);
    encoder0.encode((Struct) this.request, 32, true);
    encoder0.encode((Struct) this.frame, 40, true);
  }
}
