package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.blink.mojom.AuthenticatorAttachment;
import org.chromium.blink.mojom.CommonCredentialInfo;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class SecurePaymentConfirmationResponse extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int authenticatorAttachment;
  public CommonCredentialInfo credentialInfo;
  public byte[] signature;
  public byte[] userHandle;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SecurePaymentConfirmationResponse(int version) {
    super(40, version);
  }

  public SecurePaymentConfirmationResponse() {
    this(0);
  }

  public static SecurePaymentConfirmationResponse deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SecurePaymentConfirmationResponse deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SecurePaymentConfirmationResponse decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SecurePaymentConfirmationResponse result =
          new SecurePaymentConfirmationResponse(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.credentialInfo = CommonCredentialInfo.decode(decoder1);
      result.signature = decoder0.readBytes(16, 0, -1);
      int readInt = decoder0.readInt(24);
      result.authenticatorAttachment = readInt;
      AuthenticatorAttachment.validate(readInt);
      result.authenticatorAttachment =
          AuthenticatorAttachment.toKnownValue(result.authenticatorAttachment);
      result.userHandle = decoder0.readBytes(32, 1, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.credentialInfo, 8, false);
    encoder0.encode(this.signature, 16, 0, -1);
    encoder0.encode(this.authenticatorAttachment, 24);
    encoder0.encode(this.userHandle, 32, 1, -1);
  }
}
