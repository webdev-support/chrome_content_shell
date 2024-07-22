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

public final class DigitalCredentialProvider extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public Map<String, String> params;
  public String protocol;
  public String publicKey;
  public String request;
  public DigitalCredentialSelector selector;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DigitalCredentialProvider(int version) {
    super(48, version);
  }

  public DigitalCredentialProvider() {
    this(0);
  }

  public static DigitalCredentialProvider deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DigitalCredentialProvider deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DigitalCredentialProvider decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DigitalCredentialProvider result = new DigitalCredentialProvider(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      if (decoder1 == null) {
        result.params = null;
      } else {
        decoder1.readDataHeaderForMap();
        Decoder decoder2 = decoder1.readPointer(8, false);
        DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
        String[] keys0 = new String[si2.elementsOrVersion];
        for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
          keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
        }
        Decoder decoder22 = decoder1.readPointer(16, false);
        DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
        String[] values0 = new String[si22.elementsOrVersion];
        for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
          values0[i22] = decoder22.readString((i22 * 8) + 8, false);
        }
        result.params = new HashMap();
        for (int index0 = 0; index0 < keys0.length; index0++) {
          result.params.put(keys0[index0], values0[index0]);
        }
      }
      result.selector = DigitalCredentialSelector.decode(decoder0.readPointer(16, true));
      result.protocol = decoder0.readString(24, true);
      result.request = decoder0.readString(32, true);
      result.publicKey = decoder0.readString(40, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    if (this.params == null) {
      encoder0.encodeNullPointer(8, true);
    } else {
      Encoder encoder1 = encoder0.encoderForMap(8);
      int size0 = this.params.size();
      String[] keys0 = new String[size0];
      String[] values0 = new String[size0];
      int index0 = 0;
      for (Map.Entry<String, String> entry0 : this.params.entrySet()) {
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
    encoder0.encode((Struct) this.selector, 16, true);
    encoder0.encode(this.protocol, 24, true);
    encoder0.encode(this.request, 32, true);
    encoder0.encode(this.publicKey, 40, true);
  }
}
