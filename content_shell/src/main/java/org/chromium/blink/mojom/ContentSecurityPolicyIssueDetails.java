package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class ContentSecurityPolicyIssueDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public AffectedLocation affectedLocation;
  public Url blockedUrl;
  public int contentSecurityPolicyViolationType;
  public AffectedFrame frameAncestor;
  public boolean isReportOnly;
  public String violatedDirective;
  public int violatingNodeId;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ContentSecurityPolicyIssueDetails(int version) {
    super(56, version);
    this.violatingNodeId = 0;
  }

  public ContentSecurityPolicyIssueDetails() {
    this(0);
  }

  public static ContentSecurityPolicyIssueDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ContentSecurityPolicyIssueDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ContentSecurityPolicyIssueDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ContentSecurityPolicyIssueDetails result =
          new ContentSecurityPolicyIssueDetails(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.blockedUrl = Url.decode(decoder1);
      result.violatedDirective = decoder0.readString(16, false);
      result.isReportOnly = decoder0.readBoolean(24, 0);
      int readInt = decoder0.readInt(28);
      result.contentSecurityPolicyViolationType = readInt;
      ContentSecurityPolicyViolationType.validate(readInt);
      result.contentSecurityPolicyViolationType =
          ContentSecurityPolicyViolationType.toKnownValue(
              result.contentSecurityPolicyViolationType);
      Decoder decoder12 = decoder0.readPointer(32, true);
      result.frameAncestor = AffectedFrame.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(40, true);
      result.affectedLocation = AffectedLocation.decode(decoder13);
      result.violatingNodeId = decoder0.readInt(48);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.blockedUrl, 8, true);
    encoder0.encode(this.violatedDirective, 16, false);
    encoder0.encode(this.isReportOnly, 24, 0);
    encoder0.encode(this.contentSecurityPolicyViolationType, 28);
    encoder0.encode((Struct) this.frameAncestor, 32, true);
    encoder0.encode((Struct) this.affectedLocation, 40, true);
    encoder0.encode(this.violatingNodeId, 48);
  }
}
