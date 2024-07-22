package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class UrlLoaderCompletionStatus extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 96;
  private static final DataHeader[] VERSION_ARRAY;
  public BlockedByResponseReasonWrapper blockedByResponseReason;
  public TimeTicks completionTime;
  public CorsErrorStatus corsErrorStatus;
  public long decodedBodyLength;
  public long encodedBodyLength;
  public long encodedDataLength;
  public int errorCode;
  public boolean existsInCache;
  public boolean existsInMemoryCache;
  public int extendedErrorCode;
  public int privateNetworkAccessPreflightResult;
  public ResolveErrorInfo resolveErrorInfo;
  public boolean shouldCollapseInitiator;
  public boolean shouldReportOrbBlocking;
  public SslInfo sslInfo;
  public int trustTokenOperationStatus;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(96, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UrlLoaderCompletionStatus(int version) {
    super(96, version);
    this.errorCode = 0;
    this.extendedErrorCode = 0;
    this.existsInCache = false;
    this.existsInMemoryCache = false;
    this.encodedDataLength = 0L;
    this.encodedBodyLength = 0L;
    this.decodedBodyLength = 0L;
    this.privateNetworkAccessPreflightResult = 0;
    this.trustTokenOperationStatus = 0;
    this.shouldReportOrbBlocking = false;
    this.shouldCollapseInitiator = false;
  }

  public UrlLoaderCompletionStatus() {
    this(0);
  }

  public static UrlLoaderCompletionStatus deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UrlLoaderCompletionStatus deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UrlLoaderCompletionStatus decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UrlLoaderCompletionStatus result = new UrlLoaderCompletionStatus(elementsOrVersion);
      result.errorCode = decoder0.readInt(8);
      result.extendedErrorCode = decoder0.readInt(12);
      result.existsInCache = decoder0.readBoolean(16, 0);
      result.existsInMemoryCache = decoder0.readBoolean(16, 1);
      result.shouldReportOrbBlocking = decoder0.readBoolean(16, 2);
      result.shouldCollapseInitiator = decoder0.readBoolean(16, 3);
      int readInt = decoder0.readInt(20);
      result.privateNetworkAccessPreflightResult = readInt;
      PrivateNetworkAccessPreflightResult.validate(readInt);
      result.privateNetworkAccessPreflightResult =
          PrivateNetworkAccessPreflightResult.toKnownValue(
              result.privateNetworkAccessPreflightResult);
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.completionTime = TimeTicks.decode(decoder1);
      result.encodedDataLength = decoder0.readLong(32);
      result.encodedBodyLength = decoder0.readLong(40);
      result.decodedBodyLength = decoder0.readLong(48);
      Decoder decoder12 = decoder0.readPointer(56, true);
      result.corsErrorStatus = CorsErrorStatus.decode(decoder12);
      int readInt2 = decoder0.readInt(64);
      result.trustTokenOperationStatus = readInt2;
      TrustTokenOperationStatus.validate(readInt2);
      result.trustTokenOperationStatus =
          TrustTokenOperationStatus.toKnownValue(result.trustTokenOperationStatus);
      Decoder decoder13 = decoder0.readPointer(72, true);
      result.sslInfo = SslInfo.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(80, true);
      result.blockedByResponseReason = BlockedByResponseReasonWrapper.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(88, false);
      result.resolveErrorInfo = ResolveErrorInfo.decode(decoder15);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.errorCode, 8);
    encoder0.encode(this.extendedErrorCode, 12);
    encoder0.encode(this.existsInCache, 16, 0);
    encoder0.encode(this.existsInMemoryCache, 16, 1);
    encoder0.encode(this.shouldReportOrbBlocking, 16, 2);
    encoder0.encode(this.shouldCollapseInitiator, 16, 3);
    encoder0.encode(this.privateNetworkAccessPreflightResult, 20);
    encoder0.encode((Struct) this.completionTime, 24, false);
    encoder0.encode(this.encodedDataLength, 32);
    encoder0.encode(this.encodedBodyLength, 40);
    encoder0.encode(this.decodedBodyLength, 48);
    encoder0.encode((Struct) this.corsErrorStatus, 56, true);
    encoder0.encode(this.trustTokenOperationStatus, 64);
    encoder0.encode((Struct) this.sslInfo, 72, true);
    encoder0.encode((Struct) this.blockedByResponseReason, 80, true);
    encoder0.encode((Struct) this.resolveErrorInfo, 88, false);
  }
}
