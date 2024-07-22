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

public final class IdentityProviderRequestOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public IdentityProviderConfig config;
  public String domainHint;
  public String loginHint;
  public String nonce;
  public Map<String, String> params;
  public String[] responseType;
  public String[] scope;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private IdentityProviderRequestOptions(int version) {
    super(64, version);
  }

  public IdentityProviderRequestOptions() {
    this(0);
  }

  public static IdentityProviderRequestOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static IdentityProviderRequestOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static IdentityProviderRequestOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      IdentityProviderRequestOptions result = new IdentityProviderRequestOptions(elementsOrVersion);
      result.config = IdentityProviderConfig.decode(decoder0.readPointer(8, false));
      result.nonce = decoder0.readString(16, false);
      result.loginHint = decoder0.readString(24, false);
      result.domainHint = decoder0.readString(32, false);
      Decoder decoder1 = decoder0.readPointer(40, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.scope = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.scope[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      Decoder decoder12 = decoder0.readPointer(48, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.responseType = new String[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        result.responseType[i12] = decoder12.readString((i12 * 8) + 8, false);
      }
      Decoder decoder13 = decoder0.readPointer(56, false);
      decoder13.readDataHeaderForMap();
      Decoder decoder2 = decoder13.readPointer(8, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
      String[] keys0 = new String[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
      }
      Decoder decoder22 = decoder13.readPointer(16, false);
      DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
      String[] values0 = new String[si22.elementsOrVersion];
      for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
        values0[i22] = decoder22.readString((i22 * 8) + 8, false);
      }
      result.params = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.params.put(keys0[index0], values0[index0]);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.config, 8, false);
    encoder0.encode(this.nonce, 16, false);
    encoder0.encode(this.loginHint, 24, false);
    encoder0.encode(this.domainHint, 32, false);
    String[] strArr = this.scope;
    if (strArr == null) {
      encoder0.encodeNullPointer(40, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 40, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.scope;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    String[] strArr3 = this.responseType;
    if (strArr3 == null) {
      encoder0.encodeNullPointer(48, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(strArr3.length, 48, -1);
      int i02 = 0;
      while (true) {
        String[] strArr4 = this.responseType;
        if (i02 >= strArr4.length) {
          break;
        }
        encoder12.encode(strArr4[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    if (this.params == null) {
      encoder0.encodeNullPointer(56, false);
      return;
    }
    Encoder encoder13 = encoder0.encoderForMap(56);
    int size0 = this.params.size();
    String[] keys0 = new String[size0];
    String[] values0 = new String[size0];
    int index0 = 0;
    for (Map.Entry<String, String> entry0 : this.params.entrySet()) {
      keys0[index0] = entry0.getKey();
      values0[index0] = entry0.getValue();
      index0++;
    }
    Encoder encoder2 = encoder13.encodePointerArray(keys0.length, 8, -1);
    for (int i1 = 0; i1 < keys0.length; i1++) {
      encoder2.encode(keys0[i1], (i1 * 8) + 8, false);
    }
    Encoder encoder22 = encoder13.encodePointerArray(values0.length, 16, -1);
    for (int i12 = 0; i12 < values0.length; i12++) {
      encoder22.encode(values0[i12], (i12 * 8) + 8, false);
    }
  }
}
