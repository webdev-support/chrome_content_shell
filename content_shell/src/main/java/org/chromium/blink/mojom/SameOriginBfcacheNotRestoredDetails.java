package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SameOriginBfcacheNotRestoredDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public BackForwardCacheNotRestoredReasons[] children;
  public String url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SameOriginBfcacheNotRestoredDetails(int version) {
    super(24, version);
  }

  public SameOriginBfcacheNotRestoredDetails() {
    this(0);
  }

  public static SameOriginBfcacheNotRestoredDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SameOriginBfcacheNotRestoredDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SameOriginBfcacheNotRestoredDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SameOriginBfcacheNotRestoredDetails result =
          new SameOriginBfcacheNotRestoredDetails(elementsOrVersion);
      result.url = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.children = new BackForwardCacheNotRestoredReasons[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.children[i1] = BackForwardCacheNotRestoredReasons.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.url, 8, false);
    BackForwardCacheNotRestoredReasons[] backForwardCacheNotRestoredReasonsArr = this.children;
    if (backForwardCacheNotRestoredReasonsArr == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder1 =
        encoder0.encodePointerArray(backForwardCacheNotRestoredReasonsArr.length, 16, -1);
    int i0 = 0;
    while (true) {
      BackForwardCacheNotRestoredReasons[] backForwardCacheNotRestoredReasonsArr2 = this.children;
      if (i0 < backForwardCacheNotRestoredReasonsArr2.length) {
        encoder1.encode((Struct) backForwardCacheNotRestoredReasonsArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}