package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SupplementalPubKeysRequest extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int attestation;
  public String[] attestationFormats;
  public boolean deviceScopeRequested;
  public boolean providerScopeRequested;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SupplementalPubKeysRequest(int version) {
    super(24, version);
  }

  public SupplementalPubKeysRequest() {
    this(0);
  }

  public static SupplementalPubKeysRequest deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SupplementalPubKeysRequest deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SupplementalPubKeysRequest decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SupplementalPubKeysRequest result = new SupplementalPubKeysRequest(elementsOrVersion);
      result.deviceScopeRequested = decoder0.readBoolean(8, 0);
      result.providerScopeRequested = decoder0.readBoolean(8, 1);
      int readInt = decoder0.readInt(12);
      result.attestation = readInt;
      AttestationConveyancePreference.validate(readInt);
      result.attestation = AttestationConveyancePreference.toKnownValue(result.attestation);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.attestationFormats = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.attestationFormats[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.deviceScopeRequested, 8, 0);
    encoder0.encode(this.providerScopeRequested, 8, 1);
    encoder0.encode(this.attestation, 12);
    String[] strArr = this.attestationFormats;
    if (strArr == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 16, -1);
    int i0 = 0;
    while (true) {
      String[] strArr2 = this.attestationFormats;
      if (i0 < strArr2.length) {
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
