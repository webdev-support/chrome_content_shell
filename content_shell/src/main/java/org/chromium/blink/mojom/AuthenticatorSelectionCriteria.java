package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AuthenticatorSelectionCriteria extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int authenticatorAttachment;
  public int residentKey;
  public int userVerification;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AuthenticatorSelectionCriteria(int version) {
    super(24, version);
  }

  public AuthenticatorSelectionCriteria() {
    this(0);
  }

  public static AuthenticatorSelectionCriteria deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AuthenticatorSelectionCriteria deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AuthenticatorSelectionCriteria decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AuthenticatorSelectionCriteria result = new AuthenticatorSelectionCriteria(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.authenticatorAttachment = readInt;
      AuthenticatorAttachment.validate(readInt);
      result.authenticatorAttachment =
          AuthenticatorAttachment.toKnownValue(result.authenticatorAttachment);
      int readInt2 = decoder0.readInt(12);
      result.residentKey = readInt2;
      ResidentKeyRequirement.validate(readInt2);
      result.residentKey = ResidentKeyRequirement.toKnownValue(result.residentKey);
      int readInt3 = decoder0.readInt(16);
      result.userVerification = readInt3;
      UserVerificationRequirement.validate(readInt3);
      result.userVerification = UserVerificationRequirement.toKnownValue(result.userVerification);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.authenticatorAttachment, 8);
    encoder0.encode(this.residentKey, 12);
    encoder0.encode(this.userVerification, 16);
  }
}
