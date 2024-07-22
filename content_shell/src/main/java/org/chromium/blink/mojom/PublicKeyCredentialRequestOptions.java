package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class PublicKeyCredentialRequestOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public PublicKeyCredentialDescriptor[] allowCredentials;
  public byte[] challenge;
  public AuthenticationExtensionsClientInputs extensions;
  public int[] hints;
  public boolean isConditional;
  public String relyingPartyId;
  public TimeDelta timeout;
  public int userVerification;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PublicKeyCredentialRequestOptions(int version) {
    super(64, version);
  }

  public PublicKeyCredentialRequestOptions() {
    this(0);
  }

  public static PublicKeyCredentialRequestOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PublicKeyCredentialRequestOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PublicKeyCredentialRequestOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PublicKeyCredentialRequestOptions result =
          new PublicKeyCredentialRequestOptions(elementsOrVersion);
      result.isConditional = decoder0.readBoolean(8, 0);
      int readInt = decoder0.readInt(12);
      result.userVerification = readInt;
      UserVerificationRequirement.validate(readInt);
      result.userVerification = UserVerificationRequirement.toKnownValue(result.userVerification);
      result.challenge = decoder0.readBytes(16, 0, -1);
      result.timeout = TimeDelta.decode(decoder0.readPointer(24, true));
      result.relyingPartyId = decoder0.readString(32, false);
      Decoder decoder1 = decoder0.readPointer(40, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.allowCredentials = new PublicKeyCredentialDescriptor[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.allowCredentials[i1] = PublicKeyCredentialDescriptor.decode(decoder2);
      }
      result.hints = decoder0.readInts(48, 0, -1);
      int i12 = 0;
      while (true) {
        int[] iArr = result.hints;
        if (i12 < iArr.length) {
          Hint.validate(iArr[i12]);
          i12++;
        } else {
          result.extensions =
              AuthenticationExtensionsClientInputs.decode(decoder0.readPointer(56, false));
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
    encoder0.encode(this.isConditional, 8, 0);
    encoder0.encode(this.userVerification, 12);
    encoder0.encode(this.challenge, 16, 0, -1);
    encoder0.encode((Struct) this.timeout, 24, true);
    encoder0.encode(this.relyingPartyId, 32, false);
    PublicKeyCredentialDescriptor[] publicKeyCredentialDescriptorArr = this.allowCredentials;
    if (publicKeyCredentialDescriptorArr == null) {
      encoder0.encodeNullPointer(40, false);
    } else {
      Encoder encoder1 =
          encoder0.encodePointerArray(publicKeyCredentialDescriptorArr.length, 40, -1);
      int i0 = 0;
      while (true) {
        PublicKeyCredentialDescriptor[] publicKeyCredentialDescriptorArr2 = this.allowCredentials;
        if (i0 >= publicKeyCredentialDescriptorArr2.length) {
          break;
        }
        encoder1.encode((Struct) publicKeyCredentialDescriptorArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.hints, 48, 0, -1);
    encoder0.encode((Struct) this.extensions, 56, false);
  }
}
