package org.chromium.cert_verifier.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AdditionalCertificates extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[][] allCertificates;
  public byte[][] distrustedSpkis;
  public boolean includeSystemTrustStore;
  public byte[][] trustAnchors;
  public byte[][] trustAnchorsWithEnforcedConstraints;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AdditionalCertificates(int version) {
    super(48, version);
    this.includeSystemTrustStore = true;
  }

  public AdditionalCertificates() {
    this(0);
  }

  public static AdditionalCertificates deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AdditionalCertificates deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AdditionalCertificates decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AdditionalCertificates result = new AdditionalCertificates(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.allCertificates = new byte[si1.elementsOrVersion][];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.allCertificates[i1] = decoder1.readBytes((i1 * 8) + 8, 0, -1);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.trustAnchors = new byte[si12.elementsOrVersion][];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        result.trustAnchors[i12] = decoder12.readBytes((i12 * 8) + 8, 0, -1);
      }
      Decoder decoder13 = decoder0.readPointer(24, false);
      DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
      result.trustAnchorsWithEnforcedConstraints = new byte[si13.elementsOrVersion][];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        result.trustAnchorsWithEnforcedConstraints[i13] = decoder13.readBytes((i13 * 8) + 8, 0, -1);
      }
      Decoder decoder14 = decoder0.readPointer(32, false);
      DataHeader si14 = decoder14.readDataHeaderForPointerArray(-1);
      result.distrustedSpkis = new byte[si14.elementsOrVersion][];
      for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
        result.distrustedSpkis[i14] = decoder14.readBytes((i14 * 8) + 8, 0, -1);
      }
      result.includeSystemTrustStore = decoder0.readBoolean(40, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    byte[][] bArr = this.allCertificates;
    if (bArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(bArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        byte[][] bArr2 = this.allCertificates;
        if (i0 >= bArr2.length) {
          break;
        }
        encoder1.encode(bArr2[i0], (i0 * 8) + 8, 0, -1);
        i0++;
      }
    }
    byte[][] bArr3 = this.trustAnchors;
    if (bArr3 == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(bArr3.length, 16, -1);
      int i02 = 0;
      while (true) {
        byte[][] bArr4 = this.trustAnchors;
        if (i02 >= bArr4.length) {
          break;
        }
        encoder12.encode(bArr4[i02], (i02 * 8) + 8, 0, -1);
        i02++;
      }
    }
    byte[][] bArr5 = this.trustAnchorsWithEnforcedConstraints;
    if (bArr5 == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(bArr5.length, 24, -1);
      int i03 = 0;
      while (true) {
        byte[][] bArr6 = this.trustAnchorsWithEnforcedConstraints;
        if (i03 >= bArr6.length) {
          break;
        }
        encoder13.encode(bArr6[i03], (i03 * 8) + 8, 0, -1);
        i03++;
      }
    }
    byte[][] bArr7 = this.distrustedSpkis;
    if (bArr7 == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder14 = encoder0.encodePointerArray(bArr7.length, 32, -1);
      int i04 = 0;
      while (true) {
        byte[][] bArr8 = this.distrustedSpkis;
        if (i04 >= bArr8.length) {
          break;
        }
        encoder14.encode(bArr8[i04], (i04 * 8) + 8, 0, -1);
        i04++;
      }
    }
    encoder0.encode(this.includeSystemTrustStore, 40, 0);
  }
}
