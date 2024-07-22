package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.LoadTimingInfo;
import org.chromium.network.mojom.RequestDestination;
import org.chromium.network.mojom.RequestPriority;
import org.chromium.url.mojom.Url;

public final class ResourceLoadInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 120;
  private static final DataHeader[] VERSION_ARRAY;
  public Url finalUrl;
  public int httpStatusCode;
  public LoadTimingInfo loadTimingInfo;
  public String method;
  public String mimeType;
  public int netError;
  public CommonNetworkInfo networkInfo;
  public Url originalUrl;
  public long rawBodyBytes;
  public RedirectInfo[] redirectInfoChain;
  public Url referrer;
  public int requestDestination;
  public long requestId;
  public int requestPriority;
  public long totalReceivedBytes;
  public boolean wasCached;
  public boolean wasInNetworkServiceMemoryCache;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(120, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ResourceLoadInfo(int version) {
    super(120, version);
    this.wasInNetworkServiceMemoryCache = false;
  }

  public ResourceLoadInfo() {
    this(0);
  }

  public static ResourceLoadInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ResourceLoadInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ResourceLoadInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ResourceLoadInfo result = new ResourceLoadInfo(elementsOrVersion);
      result.requestId = decoder0.readLong(8);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.finalUrl = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, false);
      result.referrer = Url.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      result.originalUrl = Url.decode(decoder13);
      result.method = decoder0.readString(40, false);
      int readInt = decoder0.readInt(48);
      result.requestDestination = readInt;
      RequestDestination.validate(readInt);
      result.requestDestination = RequestDestination.toKnownValue(result.requestDestination);
      int readInt2 = decoder0.readInt(52);
      result.requestPriority = readInt2;
      RequestPriority.validate(readInt2);
      result.requestPriority = RequestPriority.toKnownValue(result.requestPriority);
      result.mimeType = decoder0.readString(56, false);
      result.wasCached = decoder0.readBoolean(64, 0);
      result.wasInNetworkServiceMemoryCache = decoder0.readBoolean(64, 1);
      result.netError = decoder0.readInt(68);
      Decoder decoder14 = decoder0.readPointer(72, false);
      result.networkInfo = CommonNetworkInfo.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(80, false);
      result.loadTimingInfo = LoadTimingInfo.decode(decoder15);
      result.rawBodyBytes = decoder0.readLong(88);
      result.totalReceivedBytes = decoder0.readLong(96);
      Decoder decoder16 = decoder0.readPointer(104, false);
      DataHeader si1 = decoder16.readDataHeaderForPointerArray(-1);
      result.redirectInfoChain = new RedirectInfo[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder16.readPointer((i1 * 8) + 8, false);
        result.redirectInfoChain[i1] = RedirectInfo.decode(decoder2);
      }
      result.httpStatusCode = decoder0.readInt(112);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.requestId, 8);
    encoder0.encode((Struct) this.finalUrl, 16, false);
    encoder0.encode((Struct) this.referrer, 24, false);
    encoder0.encode((Struct) this.originalUrl, 32, false);
    encoder0.encode(this.method, 40, false);
    encoder0.encode(this.requestDestination, 48);
    encoder0.encode(this.requestPriority, 52);
    encoder0.encode(this.mimeType, 56, false);
    encoder0.encode(this.wasCached, 64, 0);
    encoder0.encode(this.wasInNetworkServiceMemoryCache, 64, 1);
    encoder0.encode(this.netError, 68);
    encoder0.encode((Struct) this.networkInfo, 72, false);
    encoder0.encode((Struct) this.loadTimingInfo, 80, false);
    encoder0.encode(this.rawBodyBytes, 88);
    encoder0.encode(this.totalReceivedBytes, 96);
    RedirectInfo[] redirectInfoArr = this.redirectInfoChain;
    if (redirectInfoArr == null) {
      encoder0.encodeNullPointer(104, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(redirectInfoArr.length, 104, -1);
      int i0 = 0;
      while (true) {
        RedirectInfo[] redirectInfoArr2 = this.redirectInfoChain;
        if (i0 >= redirectInfoArr2.length) {
          break;
        }
        encoder1.encode((Struct) redirectInfoArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.httpStatusCode, 112);
  }
}
