package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.SiteForCookies;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public final class MediaUrlParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean allowCredentials;
  public boolean hasStorageAccess;
  public Map<String, String> headers;
  public boolean isHls;
  public Url mediaUrl;
  public SiteForCookies siteForCookies;
  public Origin topFrameOrigin;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private MediaUrlParams(int version) {
    super(48, version);
  }

  public MediaUrlParams() {
    this(0);
  }

  public static MediaUrlParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MediaUrlParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MediaUrlParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MediaUrlParams result = new MediaUrlParams(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.mediaUrl = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.siteForCookies = SiteForCookies.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.topFrameOrigin = Origin.decode(decoder13);
      result.hasStorageAccess = decoder0.readBoolean(32, 0);
      result.allowCredentials = decoder0.readBoolean(32, 1);
      result.isHls = decoder0.readBoolean(32, 2);
      Decoder decoder14 = decoder0.readPointer(40, false);
      decoder14.readDataHeaderForMap();
      Decoder decoder2 = decoder14.readPointer(8, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
      String[] keys0 = new String[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
      }
      Decoder decoder22 = decoder14.readPointer(16, false);
      DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
      String[] values0 = new String[si22.elementsOrVersion];
      for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
        values0[i22] = decoder22.readString((i22 * 8) + 8, false);
      }
      result.headers = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.headers.put(keys0[index0], values0[index0]);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.mediaUrl, 8, false);
    encoder0.encode((Struct) this.siteForCookies, 16, false);
    encoder0.encode((Struct) this.topFrameOrigin, 24, false);
    encoder0.encode(this.hasStorageAccess, 32, 0);
    encoder0.encode(this.allowCredentials, 32, 1);
    encoder0.encode(this.isHls, 32, 2);
    if (this.headers == null) {
      encoder0.encodeNullPointer(40, false);
      return;
    }
    Encoder encoder1 = encoder0.encoderForMap(40);
    int size0 = this.headers.size();
    String[] keys0 = new String[size0];
    String[] values0 = new String[size0];
    int index0 = 0;
    for (Map.Entry<String, String> entry0 : this.headers.entrySet()) {
      keys0[index0] = entry0.getKey();
      values0[index0] = entry0.getValue();
      index0++;
    }
    Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
    for (int i1 = 0; i1 < keys0.length; i1++) {
      encoder2.encode(keys0[i1], (i1 * 8) + 8, false);
    }
    Encoder encoder22 = encoder1.encodePointerArray(values0.length, 16, -1);
    for (int i12 = 0; i12 < values0.length; i12++) {
      encoder22.encode(values0[i12], (i12 * 8) + 8, false);
    }
  }
}
