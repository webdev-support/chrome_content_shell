package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.url.mojom.Url;

public final class ObliviousHttpRequest extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public String keyConfig;
  public String method;
  public ObliviousHttpPaddingParameters paddingParams;
  public Url relayUrl;
  public ObliviousHttpRequestBody requestBody;
  public Url resourceUrl;
  public TimeDelta timeoutDuration;
  public MutableNetworkTrafficAnnotationTag trafficAnnotation;
  public TrustTokenParams trustTokenParams;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ObliviousHttpRequest(int version) {
    super(80, version);
  }

  public ObliviousHttpRequest() {
    this(0);
  }

  public static ObliviousHttpRequest deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ObliviousHttpRequest deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ObliviousHttpRequest decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ObliviousHttpRequest result = new ObliviousHttpRequest(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.relayUrl = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.trafficAnnotation = MutableNetworkTrafficAnnotationTag.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.timeoutDuration = TimeDelta.decode(decoder13);
      result.keyConfig = decoder0.readString(32, false);
      Decoder decoder14 = decoder0.readPointer(40, false);
      result.resourceUrl = Url.decode(decoder14);
      result.method = decoder0.readString(48, false);
      Decoder decoder15 = decoder0.readPointer(56, true);
      result.requestBody = ObliviousHttpRequestBody.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(64, true);
      result.trustTokenParams = TrustTokenParams.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(72, true);
      result.paddingParams = ObliviousHttpPaddingParameters.decode(decoder17);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.relayUrl, 8, false);
    encoder0.encode((Struct) this.trafficAnnotation, 16, false);
    encoder0.encode((Struct) this.timeoutDuration, 24, true);
    encoder0.encode(this.keyConfig, 32, false);
    encoder0.encode((Struct) this.resourceUrl, 40, false);
    encoder0.encode(this.method, 48, false);
    encoder0.encode((Struct) this.requestBody, 56, true);
    encoder0.encode((Struct) this.trustTokenParams, 64, true);
    encoder0.encode((Struct) this.paddingParams, 72, true);
  }
}
