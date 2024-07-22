package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class InspectorIssueDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 128;
  private static final DataHeader[] VERSION_ARRAY;
  public AttributionReportingIssueDetails attributionReportingIssueDetails;
  public BlockedByResponseIssueDetails blockedByResponseIssueDetails;
  public BounceTrackingIssueDetails bounceTrackingIssueDetails;
  public CookieDeprecationMetadataIssueDetails cookieDeprecationMetadataIssueDetails;
  public CookieIssueDetails cookieIssueDetails;
  public ContentSecurityPolicyIssueDetails cspIssueDetails;
  public DeprecationIssueDetails deprecationIssueDetails;
  public FederatedAuthRequestIssueDetails federatedAuthRequestDetails;
  public FederatedAuthUserInfoRequestIssueDetails federatedAuthUserInfoRequestDetails;
  public GenericIssueDetails genericIssueDetails;
  public HeavyAdIssueDetails heavyAdIssueDetails;
  public UnguessableToken issueId;
  public LowTextContrastIssue lowTextContrastDetails;
  public MixedContentIssueDetails mixedContentIssueDetails;
  public SharedArrayBufferIssueDetails sabIssueDetails;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(128, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private InspectorIssueDetails(int version) {
    super(128, version);
  }

  public InspectorIssueDetails() {
    this(0);
  }

  public static InspectorIssueDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static InspectorIssueDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static InspectorIssueDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      InspectorIssueDetails result = new InspectorIssueDetails(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.cookieIssueDetails = CookieIssueDetails.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.mixedContentIssueDetails = MixedContentIssueDetails.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.blockedByResponseIssueDetails = BlockedByResponseIssueDetails.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, true);
      result.cspIssueDetails = ContentSecurityPolicyIssueDetails.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(40, true);
      result.sabIssueDetails = SharedArrayBufferIssueDetails.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(48, true);
      result.heavyAdIssueDetails = HeavyAdIssueDetails.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(56, true);
      result.attributionReportingIssueDetails = AttributionReportingIssueDetails.decode(decoder17);
      Decoder decoder18 = decoder0.readPointer(64, true);
      result.lowTextContrastDetails = LowTextContrastIssue.decode(decoder18);
      Decoder decoder19 = decoder0.readPointer(72, true);
      result.federatedAuthRequestDetails = FederatedAuthRequestIssueDetails.decode(decoder19);
      Decoder decoder110 = decoder0.readPointer(80, true);
      result.bounceTrackingIssueDetails = BounceTrackingIssueDetails.decode(decoder110);
      Decoder decoder111 = decoder0.readPointer(88, true);
      result.cookieDeprecationMetadataIssueDetails =
          CookieDeprecationMetadataIssueDetails.decode(decoder111);
      Decoder decoder112 = decoder0.readPointer(96, true);
      result.genericIssueDetails = GenericIssueDetails.decode(decoder112);
      Decoder decoder113 = decoder0.readPointer(104, true);
      result.deprecationIssueDetails = DeprecationIssueDetails.decode(decoder113);
      Decoder decoder114 = decoder0.readPointer(112, true);
      result.federatedAuthUserInfoRequestDetails =
          FederatedAuthUserInfoRequestIssueDetails.decode(decoder114);
      Decoder decoder115 = decoder0.readPointer(120, true);
      result.issueId = UnguessableToken.decode(decoder115);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.cookieIssueDetails, 8, true);
    encoder0.encode((Struct) this.mixedContentIssueDetails, 16, true);
    encoder0.encode((Struct) this.blockedByResponseIssueDetails, 24, true);
    encoder0.encode((Struct) this.cspIssueDetails, 32, true);
    encoder0.encode((Struct) this.sabIssueDetails, 40, true);
    encoder0.encode((Struct) this.heavyAdIssueDetails, 48, true);
    encoder0.encode((Struct) this.attributionReportingIssueDetails, 56, true);
    encoder0.encode((Struct) this.lowTextContrastDetails, 64, true);
    encoder0.encode((Struct) this.federatedAuthRequestDetails, 72, true);
    encoder0.encode((Struct) this.bounceTrackingIssueDetails, 80, true);
    encoder0.encode((Struct) this.cookieDeprecationMetadataIssueDetails, 88, true);
    encoder0.encode((Struct) this.genericIssueDetails, 96, true);
    encoder0.encode((Struct) this.deprecationIssueDetails, 104, true);
    encoder0.encode((Struct) this.federatedAuthUserInfoRequestDetails, 112, true);
    encoder0.encode((Struct) this.issueId, 120, true);
  }
}
