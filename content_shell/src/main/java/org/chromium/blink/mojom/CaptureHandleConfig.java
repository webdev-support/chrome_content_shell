package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.internal.mojom.Origin;

public final class CaptureHandleConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean allOriginsPermitted;
  public String16 captureHandle;
  public boolean exposeOrigin;
  public Origin[] permittedOrigins;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CaptureHandleConfig(int version) {
    super(32, version);
    this.exposeOrigin = false;
    this.allOriginsPermitted = false;
  }

  public CaptureHandleConfig() {
    this(0);
  }

  public static CaptureHandleConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CaptureHandleConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CaptureHandleConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CaptureHandleConfig result = new CaptureHandleConfig(elementsOrVersion);
      result.exposeOrigin = decoder0.readBoolean(8, 0);
      result.allOriginsPermitted = decoder0.readBoolean(8, 1);
      result.captureHandle = String16.decode(decoder0.readPointer(16, false));
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.permittedOrigins = new Origin[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.permittedOrigins[i1] = Origin.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.exposeOrigin, 8, 0);
    encoder0.encode(this.allOriginsPermitted, 8, 1);
    encoder0.encode((Struct) this.captureHandle, 16, false);
    Origin[] originArr = this.permittedOrigins;
    if (originArr == null) {
      encoder0.encodeNullPointer(24, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(originArr.length, 24, -1);
    int i0 = 0;
    while (true) {
      Origin[] originArr2 = this.permittedOrigins;
      if (i0 < originArr2.length) {
        encoder1.encode((Struct) originArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
