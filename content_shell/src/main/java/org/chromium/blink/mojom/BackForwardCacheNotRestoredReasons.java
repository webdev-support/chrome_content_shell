package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class BackForwardCacheNotRestoredReasons extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;

  public String f409id;
  public String name;
  public BfCacheBlockingDetailedReason[] reasons;
  public SameOriginBfcacheNotRestoredDetails sameOriginDetails;
  public String src;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BackForwardCacheNotRestoredReasons(int version) {
    super(48, version);
  }

  public BackForwardCacheNotRestoredReasons() {
    this(0);
  }

  public static BackForwardCacheNotRestoredReasons deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BackForwardCacheNotRestoredReasons deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BackForwardCacheNotRestoredReasons decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BackForwardCacheNotRestoredReasons result =
          new BackForwardCacheNotRestoredReasons(elementsOrVersion);
      result.src = decoder0.readString(8, true);
      result.f409id = decoder0.readString(16, true);
      result.name = decoder0.readString(24, true);
      Decoder decoder1 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.reasons = new BfCacheBlockingDetailedReason[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.reasons[i1] = BfCacheBlockingDetailedReason.decode(decoder2);
      }
      result.sameOriginDetails =
          SameOriginBfcacheNotRestoredDetails.decode(decoder0.readPointer(40, true));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.src, 8, true);
    encoder0.encode(this.f409id, 16, true);
    encoder0.encode(this.name, 24, true);
    BfCacheBlockingDetailedReason[] bfCacheBlockingDetailedReasonArr = this.reasons;
    if (bfCacheBlockingDetailedReasonArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder1 =
          encoder0.encodePointerArray(bfCacheBlockingDetailedReasonArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        BfCacheBlockingDetailedReason[] bfCacheBlockingDetailedReasonArr2 = this.reasons;
        if (i0 >= bfCacheBlockingDetailedReasonArr2.length) {
          break;
        }
        encoder1.encode((Struct) bfCacheBlockingDetailedReasonArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.sameOriginDetails, 40, true);
  }
}
