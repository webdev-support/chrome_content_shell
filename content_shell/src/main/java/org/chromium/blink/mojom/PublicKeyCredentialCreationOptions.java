package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class PublicKeyCredentialCreationOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 128;
  private static final DataHeader[] VERSION_ARRAY;
  public String appidExclude;
  public int attestation;
  public AuthenticatorSelectionCriteria authenticatorSelection;
  public byte[] challenge;
  public byte[] credBlob;
  public boolean credProps;
  public boolean enforceProtectionPolicy;
  public PublicKeyCredentialDescriptor[] excludeCredentials;
  public int[] hints;
  public boolean hmacCreateSecret;
  public boolean isPaymentCredentialCreation;
  public int largeBlobEnable;
  public boolean minPinLengthRequested;
  public boolean prfEnable;
  public PrfValues prfInput;
  public int protectionPolicy;
  public PublicKeyCredentialParameters[] publicKeyParameters;
  public PublicKeyCredentialRpEntity relyingParty;
  public RemoteDesktopClientOverride remoteDesktopClientOverride;
  public SupplementalPubKeysRequest supplementalPubKeys;
  public TimeDelta timeout;
  public PublicKeyCredentialUserEntity user;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(128, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PublicKeyCredentialCreationOptions(int version) {
    super(128, version);
    this.minPinLengthRequested = false;
  }

  public PublicKeyCredentialCreationOptions() {
    this(0);
  }

  public static PublicKeyCredentialCreationOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PublicKeyCredentialCreationOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PublicKeyCredentialCreationOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PublicKeyCredentialCreationOptions result =
          new PublicKeyCredentialCreationOptions(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.relyingParty = PublicKeyCredentialRpEntity.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.user = PublicKeyCredentialUserEntity.decode(decoder12);
      result.challenge = decoder0.readBytes(24, 0, -1);
      Decoder decoder13 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
      result.publicKeyParameters = new PublicKeyCredentialParameters[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder13.readPointer((i1 * 8) + 8, false);
        result.publicKeyParameters[i1] = PublicKeyCredentialParameters.decode(decoder2);
      }
      Decoder decoder14 = decoder0.readPointer(40, true);
      result.timeout = TimeDelta.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, false);
      DataHeader si12 = decoder15.readDataHeaderForPointerArray(-1);
      result.excludeCredentials = new PublicKeyCredentialDescriptor[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder15.readPointer((i12 * 8) + 8, false);
        result.excludeCredentials[i12] = PublicKeyCredentialDescriptor.decode(decoder22);
      }
      Decoder decoder16 = decoder0.readPointer(56, true);
      result.authenticatorSelection = AuthenticatorSelectionCriteria.decode(decoder16);
      result.hints = decoder0.readInts(64, 0, -1);
      int i13 = 0;
      while (true) {
        int[] iArr = result.hints;
        if (i13 < iArr.length) {
          Hint.validate(iArr[i13]);
          i13++;
        } else {
          int readInt = decoder0.readInt(72);
          result.attestation = readInt;
          AttestationConveyancePreference.validate(readInt);
          result.attestation = AttestationConveyancePreference.toKnownValue(result.attestation);
          result.hmacCreateSecret = decoder0.readBoolean(76, 0);
          result.prfEnable = decoder0.readBoolean(76, 1);
          result.enforceProtectionPolicy = decoder0.readBoolean(76, 2);
          result.credProps = decoder0.readBoolean(76, 3);
          result.isPaymentCredentialCreation = decoder0.readBoolean(76, 4);
          result.minPinLengthRequested = decoder0.readBoolean(76, 5);
          Decoder decoder17 = decoder0.readPointer(80, true);
          result.prfInput = PrfValues.decode(decoder17);
          int readInt2 = decoder0.readInt(88);
          result.protectionPolicy = readInt2;
          ProtectionPolicy.validate(readInt2);
          result.protectionPolicy = ProtectionPolicy.toKnownValue(result.protectionPolicy);
          int readInt3 = decoder0.readInt(92);
          result.largeBlobEnable = readInt3;
          LargeBlobSupport.validate(readInt3);
          result.largeBlobEnable = LargeBlobSupport.toKnownValue(result.largeBlobEnable);
          result.appidExclude = decoder0.readString(96, true);
          result.credBlob = decoder0.readBytes(104, 1, -1);
          Decoder decoder18 = decoder0.readPointer(112, true);
          result.remoteDesktopClientOverride = RemoteDesktopClientOverride.decode(decoder18);
          Decoder decoder19 = decoder0.readPointer(120, true);
          result.supplementalPubKeys = SupplementalPubKeysRequest.decode(decoder19);
          return result;
        }
      }
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.relyingParty, 8, false);
    encoder0.encode((Struct) this.user, 16, false);
    encoder0.encode(this.challenge, 24, 0, -1);
    PublicKeyCredentialParameters[] publicKeyCredentialParametersArr = this.publicKeyParameters;
    if (publicKeyCredentialParametersArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder1 =
          encoder0.encodePointerArray(publicKeyCredentialParametersArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        PublicKeyCredentialParameters[] publicKeyCredentialParametersArr2 =
            this.publicKeyParameters;
        if (i0 >= publicKeyCredentialParametersArr2.length) {
          break;
        }
        encoder1.encode((Struct) publicKeyCredentialParametersArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.timeout, 40, true);
    PublicKeyCredentialDescriptor[] publicKeyCredentialDescriptorArr = this.excludeCredentials;
    if (publicKeyCredentialDescriptorArr == null) {
      encoder0.encodeNullPointer(48, false);
    } else {
      Encoder encoder12 =
          encoder0.encodePointerArray(publicKeyCredentialDescriptorArr.length, 48, -1);
      int i02 = 0;
      while (true) {
        PublicKeyCredentialDescriptor[] publicKeyCredentialDescriptorArr2 = this.excludeCredentials;
        if (i02 >= publicKeyCredentialDescriptorArr2.length) {
          break;
        }
        encoder12.encode((Struct) publicKeyCredentialDescriptorArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    encoder0.encode((Struct) this.authenticatorSelection, 56, true);
    encoder0.encode(this.hints, 64, 0, -1);
    encoder0.encode(this.attestation, 72);
    encoder0.encode(this.hmacCreateSecret, 76, 0);
    encoder0.encode(this.prfEnable, 76, 1);
    encoder0.encode(this.enforceProtectionPolicy, 76, 2);
    encoder0.encode(this.credProps, 76, 3);
    encoder0.encode(this.isPaymentCredentialCreation, 76, 4);
    encoder0.encode(this.minPinLengthRequested, 76, 5);
    encoder0.encode((Struct) this.prfInput, 80, true);
    encoder0.encode(this.protectionPolicy, 88);
    encoder0.encode(this.largeBlobEnable, 92);
    encoder0.encode(this.appidExclude, 96, true);
    encoder0.encode(this.credBlob, 104, 1, -1);
    encoder0.encode((Struct) this.remoteDesktopClientOverride, 112, true);
    encoder0.encode((Struct) this.supplementalPubKeys, 120, true);
  }
}
