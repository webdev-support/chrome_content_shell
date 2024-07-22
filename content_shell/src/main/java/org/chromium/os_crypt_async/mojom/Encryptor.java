package org.chromium.os_crypt_async.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class Encryptor extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public Map<String, Key> keyEntries;
  public String providerForEncryption;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private Encryptor(int version) {
    super(24, version);
  }

  public Encryptor() {
    this(0);
  }

  public static Encryptor deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static Encryptor deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static Encryptor decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      Encryptor result = new Encryptor(elementsOrVersion);
      result.providerForEncryption = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      decoder1.readDataHeaderForMap();
      Decoder decoder2 = decoder1.readPointer(8, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
      String[] keys0 = new String[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
      }
      Decoder decoder22 = decoder1.readPointer(16, false);
      DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
      Key[] values0 = new Key[si22.elementsOrVersion];
      for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
        Decoder decoder3 = decoder22.readPointer((i22 * 8) + 8, false);
        values0[i22] = Key.decode(decoder3);
      }
      result.keyEntries = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.keyEntries.put(keys0[index0], values0[index0]);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.providerForEncryption, 8, false);
    if (this.keyEntries == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder1 = encoder0.encoderForMap(16);
    int size0 = this.keyEntries.size();
    String[] keys0 = new String[size0];
    Key[] values0 = new Key[size0];
    int index0 = 0;
    for (Map.Entry<String, Key> entry0 : this.keyEntries.entrySet()) {
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
      encoder22.encode((Struct) values0[i12], (i12 * 8) + 8, false);
    }
  }
}
