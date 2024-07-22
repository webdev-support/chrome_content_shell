package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.network.mojom.AuthChallengeInfo;
import org.chromium.network.mojom.ConnectionInfo;
import org.chromium.network.mojom.FetchResponseSource;
import org.chromium.network.mojom.FetchResponseType;
import org.chromium.network.mojom.ParsedHeaders;
import org.chromium.url.mojom.Url;

public final class FetchApiResponse extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 152;
  private static final DataHeader[] VERSION_ARRAY;
  public String alpnNegotiatedProtocol;
  public AuthChallengeInfo authChallengeInfo;
  public SerializedBlob blob;
  public String cacheStorageCacheName;
  public int connectionInfo;
  public String[] corsExposedHeaderNames;
  public int error;
  public boolean hasRangeRequested;
  public Map<String, String> headers;
  public String mimeType;
  public long padding;
  public ParsedHeaders parsedHeaders;
  public boolean requestIncludeCredentials;
  public String requestMethod;
  public int responseSource;
  public Time responseTime;
  public int responseType;
  public SerializedBlob sideDataBlob;
  public SerializedBlob sideDataBlobForCachePut;
  public short statusCode;
  public String statusText;
  public Url[] urlList;
  public boolean wasFetchedViaSpdy;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(152, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FetchApiResponse(int version) {
    super(152, version);
    this.statusCode = (short) 0;
    this.responseType = 2;
    this.padding = 0L;
    this.responseSource = 0;
    this.error = 0;
    this.alpnNegotiatedProtocol = "unknown";
    this.wasFetchedViaSpdy = false;
    this.hasRangeRequested = false;
    this.requestIncludeCredentials = true;
  }

  public FetchApiResponse() {
    this(0);
  }

  public static FetchApiResponse deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FetchApiResponse deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FetchApiResponse decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FetchApiResponse result = new FetchApiResponse(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.urlList = new Url[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.urlList[i1] = Url.decode(decoder1.readPointer((i1 * 8) + 8, false));
      }
      result.statusCode = decoder0.readShort(16);
      result.wasFetchedViaSpdy = decoder0.readBoolean(18, 0);
      result.hasRangeRequested = decoder0.readBoolean(18, 1);
      result.requestIncludeCredentials = decoder0.readBoolean(18, 2);
      int readInt = decoder0.readInt(20);
      result.responseType = readInt;
      FetchResponseType.validate(readInt);
      result.responseType = FetchResponseType.toKnownValue(result.responseType);
      result.statusText = decoder0.readString(24, false);
      result.padding = decoder0.readLong(32);
      int readInt2 = decoder0.readInt(40);
      result.responseSource = readInt2;
      FetchResponseSource.validate(readInt2);
      result.responseSource = FetchResponseSource.toKnownValue(result.responseSource);
      int readInt3 = decoder0.readInt(44);
      result.error = readInt3;
      ServiceWorkerResponseError.validate(readInt3);
      result.error = ServiceWorkerResponseError.toKnownValue(result.error);
      Decoder decoder12 = decoder0.readPointer(48, false);
      decoder12.readDataHeaderForMap();
      Decoder decoder2 = decoder12.readPointer(8, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
      String[] keys0 = new String[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
      }
      Decoder decoder22 = decoder12.readPointer(16, false);
      DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
      String[] values0 = new String[si22.elementsOrVersion];
      for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
        values0[i22] = decoder22.readString((i22 * 8) + 8, false);
      }
      result.headers = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.headers.put(keys0[index0], values0[index0]);
      }
      result.mimeType = decoder0.readString(56, true);
      result.requestMethod = decoder0.readString(64, true);
      result.blob = SerializedBlob.decode(decoder0.readPointer(72, true));
      result.responseTime = Time.decode(decoder0.readPointer(80, false));
      result.cacheStorageCacheName = decoder0.readString(88, true);
      Decoder decoder13 = decoder0.readPointer(96, false);
      DataHeader si12 = decoder13.readDataHeaderForPointerArray(-1);
      result.corsExposedHeaderNames = new String[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        result.corsExposedHeaderNames[i12] = decoder13.readString((i12 * 8) + 8, false);
      }
      result.sideDataBlob = SerializedBlob.decode(decoder0.readPointer(104, true));
      result.sideDataBlobForCachePut = SerializedBlob.decode(decoder0.readPointer(112, true));
      result.parsedHeaders = ParsedHeaders.decode(decoder0.readPointer(120, true));
      int readInt4 = decoder0.readInt(128);
      result.connectionInfo = readInt4;
      ConnectionInfo.validate(readInt4);
      result.connectionInfo = ConnectionInfo.toKnownValue(result.connectionInfo);
      result.alpnNegotiatedProtocol = decoder0.readString(136, false);
      result.authChallengeInfo = AuthChallengeInfo.decode(decoder0.readPointer(144, true));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    Url[] urlArr = this.urlList;
    if (urlArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(urlArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        Url[] urlArr2 = this.urlList;
        if (i0 >= urlArr2.length) {
          break;
        }
        encoder1.encode((Struct) urlArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.statusCode, 16);
    encoder0.encode(this.wasFetchedViaSpdy, 18, 0);
    encoder0.encode(this.hasRangeRequested, 18, 1);
    encoder0.encode(this.requestIncludeCredentials, 18, 2);
    encoder0.encode(this.responseType, 20);
    encoder0.encode(this.statusText, 24, false);
    encoder0.encode(this.padding, 32);
    encoder0.encode(this.responseSource, 40);
    encoder0.encode(this.error, 44);
    if (this.headers == null) {
      encoder0.encodeNullPointer(48, false);
    } else {
      Encoder encoder12 = encoder0.encoderForMap(48);
      int size0 = this.headers.size();
      String[] keys0 = new String[size0];
      String[] values0 = new String[size0];
      int index0 = 0;
      for (Map.Entry<String, String> entry0 : this.headers.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue();
        index0++;
      }
      Encoder encoder2 = encoder12.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode(keys0[i1], (i1 * 8) + 8, false);
      }
      Encoder encoder22 = encoder12.encodePointerArray(values0.length, 16, -1);
      for (int i12 = 0; i12 < values0.length; i12++) {
        encoder22.encode(values0[i12], (i12 * 8) + 8, false);
      }
    }
    encoder0.encode(this.mimeType, 56, true);
    encoder0.encode(this.requestMethod, 64, true);
    encoder0.encode((Struct) this.blob, 72, true);
    encoder0.encode((Struct) this.responseTime, 80, false);
    encoder0.encode(this.cacheStorageCacheName, 88, true);
    String[] strArr = this.corsExposedHeaderNames;
    if (strArr == null) {
      encoder0.encodeNullPointer(96, false);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(strArr.length, 96, -1);
      int i02 = 0;
      while (true) {
        String[] strArr2 = this.corsExposedHeaderNames;
        if (i02 >= strArr2.length) {
          break;
        }
        encoder13.encode(strArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    encoder0.encode((Struct) this.sideDataBlob, 104, true);
    encoder0.encode((Struct) this.sideDataBlobForCachePut, 112, true);
    encoder0.encode((Struct) this.parsedHeaders, 120, true);
    encoder0.encode(this.connectionInfo, 128);
    encoder0.encode(this.alpnNegotiatedProtocol, 136, false);
    encoder0.encode((Struct) this.authChallengeInfo, 144, true);
  }
}
