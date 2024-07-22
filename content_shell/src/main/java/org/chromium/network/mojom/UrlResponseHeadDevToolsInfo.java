package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;

public final class UrlResponseHeadDevToolsInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 112;
  private static final DataHeader[] VERSION_ARRAY;
  public String alpnNegotiatedProtocol;
  public int alternateProtocolUsage;
  public String cacheStorageCacheName;
  public int certStatus;
  public String charset;
  public boolean emittedExtraInfo;
  public long encodedDataLength;
  public HttpResponseHeaders headers;
  public LoadTimingInfo loadTiming;
  public String mimeType;
  public IpEndPoint remoteEndpoint;
  public Time responseTime;
  public int serviceWorkerResponseSource;
  public ServiceWorkerRouterInfo serviceWorkerRouterInfo;
  public SslInfo sslInfo;
  public boolean wasFetchedViaServiceWorker;
  public boolean wasFetchedViaSpdy;
  public boolean wasInPrefetchCache;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(112, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UrlResponseHeadDevToolsInfo(int version) {
    super(112, version);
  }

  public UrlResponseHeadDevToolsInfo() {
    this(0);
  }

  public static UrlResponseHeadDevToolsInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UrlResponseHeadDevToolsInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UrlResponseHeadDevToolsInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UrlResponseHeadDevToolsInfo result = new UrlResponseHeadDevToolsInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.responseTime = Time.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.headers = HttpResponseHeaders.decode(decoder12);
      result.mimeType = decoder0.readString(24, false);
      result.charset = decoder0.readString(32, false);
      Decoder decoder13 = decoder0.readPointer(40, false);
      result.loadTiming = LoadTimingInfo.decode(decoder13);
      result.certStatus = decoder0.readInt(48);
      result.wasInPrefetchCache = decoder0.readBoolean(52, 0);
      result.wasFetchedViaServiceWorker = decoder0.readBoolean(52, 1);
      result.wasFetchedViaSpdy = decoder0.readBoolean(52, 2);
      result.emittedExtraInfo = decoder0.readBoolean(52, 3);
      result.encodedDataLength = decoder0.readLong(56);
      result.cacheStorageCacheName = decoder0.readString(64, false);
      result.alpnNegotiatedProtocol = decoder0.readString(72, false);
      int readInt = decoder0.readInt(80);
      result.alternateProtocolUsage = readInt;
      AlternateProtocolUsage.validate(readInt);
      result.alternateProtocolUsage =
          AlternateProtocolUsage.toKnownValue(result.alternateProtocolUsage);
      int readInt2 = decoder0.readInt(84);
      result.serviceWorkerResponseSource = readInt2;
      FetchResponseSource.validate(readInt2);
      result.serviceWorkerResponseSource =
          FetchResponseSource.toKnownValue(result.serviceWorkerResponseSource);
      Decoder decoder14 = decoder0.readPointer(88, true);
      result.serviceWorkerRouterInfo = ServiceWorkerRouterInfo.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(96, true);
      result.sslInfo = SslInfo.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(104, false);
      result.remoteEndpoint = IpEndPoint.decode(decoder16);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.responseTime, 8, false);
    encoder0.encode((Struct) this.headers, 16, false);
    encoder0.encode(this.mimeType, 24, false);
    encoder0.encode(this.charset, 32, false);
    encoder0.encode((Struct) this.loadTiming, 40, false);
    encoder0.encode(this.certStatus, 48);
    encoder0.encode(this.wasInPrefetchCache, 52, 0);
    encoder0.encode(this.wasFetchedViaServiceWorker, 52, 1);
    encoder0.encode(this.wasFetchedViaSpdy, 52, 2);
    encoder0.encode(this.emittedExtraInfo, 52, 3);
    encoder0.encode(this.encodedDataLength, 56);
    encoder0.encode(this.cacheStorageCacheName, 64, false);
    encoder0.encode(this.alpnNegotiatedProtocol, 72, false);
    encoder0.encode(this.alternateProtocolUsage, 80);
    encoder0.encode(this.serviceWorkerResponseSource, 84);
    encoder0.encode((Struct) this.serviceWorkerRouterInfo, 88, true);
    encoder0.encode((Struct) this.sslInfo, 96, true);
    encoder0.encode((Struct) this.remoteEndpoint, 104, false);
  }
}
