package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class IdentityProviderGetParameters extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int context;
  public int mode;
  public IdentityProviderRequestOptions[] providers;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private IdentityProviderGetParameters(int version) {
    super(24, version);
  }

  public IdentityProviderGetParameters() {
    this(0);
  }

  public static IdentityProviderGetParameters deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static IdentityProviderGetParameters deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static IdentityProviderGetParameters decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      IdentityProviderGetParameters result = new IdentityProviderGetParameters(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.providers = new IdentityProviderRequestOptions[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.providers[i1] = IdentityProviderRequestOptions.decode(decoder2);
      }
      int readInt = decoder0.readInt(16);
      result.context = readInt;
      RpContext.validate(readInt);
      result.context = RpContext.toKnownValue(result.context);
      int readInt2 = decoder0.readInt(20);
      result.mode = readInt2;
      RpMode.validate(readInt2);
      result.mode = RpMode.toKnownValue(result.mode);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    IdentityProviderRequestOptions[] identityProviderRequestOptionsArr = this.providers;
    if (identityProviderRequestOptionsArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 =
          encoder0.encodePointerArray(identityProviderRequestOptionsArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        IdentityProviderRequestOptions[] identityProviderRequestOptionsArr2 = this.providers;
        if (i0 >= identityProviderRequestOptionsArr2.length) {
          break;
        }
        encoder1.encode((Struct) identityProviderRequestOptionsArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.context, 16);
    encoder0.encode(this.mode, 20);
  }
}
