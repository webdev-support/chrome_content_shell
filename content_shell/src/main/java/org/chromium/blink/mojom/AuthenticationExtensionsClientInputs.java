package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AuthenticationExtensionsClientInputs extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public String appid;
  public CableAuthentication[] cableAuthenticationData;
  public boolean getCredBlob;
  public boolean largeBlobRead;
  public byte[] largeBlobWrite;
  public boolean prf;
  public PrfValues[] prfInputs;
  public boolean prfInputsHashed;
  public RemoteDesktopClientOverride remoteDesktopClientOverride;
  public SupplementalPubKeysRequest supplementalPubKeys;
  public boolean userVerificationMethods;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AuthenticationExtensionsClientInputs(int version) {
    super(64, version);
  }

  public AuthenticationExtensionsClientInputs() {
    this(0);
  }

  public static AuthenticationExtensionsClientInputs deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AuthenticationExtensionsClientInputs deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AuthenticationExtensionsClientInputs decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AuthenticationExtensionsClientInputs result =
          new AuthenticationExtensionsClientInputs(elementsOrVersion);
      result.appid = decoder0.readString(8, true);
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.cableAuthenticationData = new CableAuthentication[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.cableAuthenticationData[i1] = CableAuthentication.decode(decoder2);
      }
      result.userVerificationMethods = decoder0.readBoolean(24, 0);
      result.prf = decoder0.readBoolean(24, 1);
      result.prfInputsHashed = decoder0.readBoolean(24, 2);
      result.largeBlobRead = decoder0.readBoolean(24, 3);
      result.getCredBlob = decoder0.readBoolean(24, 4);
      Decoder decoder12 = decoder0.readPointer(32, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.prfInputs = new PrfValues[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.prfInputs[i12] = PrfValues.decode(decoder22);
      }
      result.largeBlobWrite = decoder0.readBytes(40, 1, -1);
      result.remoteDesktopClientOverride =
          RemoteDesktopClientOverride.decode(decoder0.readPointer(48, true));
      result.supplementalPubKeys =
          SupplementalPubKeysRequest.decode(decoder0.readPointer(56, true));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.appid, 8, true);
    CableAuthentication[] cableAuthenticationArr = this.cableAuthenticationData;
    if (cableAuthenticationArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(cableAuthenticationArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        CableAuthentication[] cableAuthenticationArr2 = this.cableAuthenticationData;
        if (i0 >= cableAuthenticationArr2.length) {
          break;
        }
        encoder1.encode((Struct) cableAuthenticationArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.userVerificationMethods, 24, 0);
    encoder0.encode(this.prf, 24, 1);
    encoder0.encode(this.prfInputsHashed, 24, 2);
    encoder0.encode(this.largeBlobRead, 24, 3);
    encoder0.encode(this.getCredBlob, 24, 4);
    PrfValues[] prfValuesArr = this.prfInputs;
    if (prfValuesArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(prfValuesArr.length, 32, -1);
      int i02 = 0;
      while (true) {
        PrfValues[] prfValuesArr2 = this.prfInputs;
        if (i02 >= prfValuesArr2.length) {
          break;
        }
        encoder12.encode((Struct) prfValuesArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    encoder0.encode(this.largeBlobWrite, 40, 1, -1);
    encoder0.encode((Struct) this.remoteDesktopClientOverride, 48, true);
    encoder0.encode((Struct) this.supplementalPubKeys, 56, true);
  }
}
