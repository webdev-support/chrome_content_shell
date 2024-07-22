package org.chromium.media.stable.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.media.mojom.EncryptionPattern;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class DecryptConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public EncryptionPattern encryptionPattern;
  public int encryptionScheme;

  public String f675iv;
  public String keyId;
  public SubsampleEntry[] subsamples;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DecryptConfig(int version) {
    super(48, version);
  }

  public DecryptConfig() {
    this(0);
  }

  public static DecryptConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DecryptConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DecryptConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DecryptConfig result = new DecryptConfig(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.encryptionScheme = readInt;
      EncryptionScheme.validate(readInt);
      result.encryptionScheme = EncryptionScheme.toKnownValue(result.encryptionScheme);
      result.keyId = decoder0.readString(16, false);
      result.f675iv = decoder0.readString(24, false);
      Decoder decoder1 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.subsamples = new SubsampleEntry[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.subsamples[i1] = SubsampleEntry.decode(decoder2);
      }
      result.encryptionPattern = EncryptionPattern.decode(decoder0.readPointer(40, true));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.encryptionScheme, 8);
    encoder0.encode(this.keyId, 16, false);
    encoder0.encode(this.f675iv, 24, false);
    SubsampleEntry[] subsampleEntryArr = this.subsamples;
    if (subsampleEntryArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(subsampleEntryArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        SubsampleEntry[] subsampleEntryArr2 = this.subsamples;
        if (i0 >= subsampleEntryArr2.length) {
          break;
        }
        encoder1.encode((Struct) subsampleEntryArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.encryptionPattern, 40, true);
  }
}
