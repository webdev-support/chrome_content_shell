package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class GetAssertionAuthenticatorResponse extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public int authenticatorAttachment;
  public AuthenticationExtensionsClientOutputs extensions;
  public CommonCredentialInfo info;
  public byte[] signature;
  public byte[] userHandle;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GetAssertionAuthenticatorResponse(int version) {
    super(48, version);
  }

  public GetAssertionAuthenticatorResponse() {
    this(0);
  }

  public static GetAssertionAuthenticatorResponse deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GetAssertionAuthenticatorResponse deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GetAssertionAuthenticatorResponse decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GetAssertionAuthenticatorResponse result =
          new GetAssertionAuthenticatorResponse(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.info = CommonCredentialInfo.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.authenticatorAttachment = readInt;
      AuthenticatorAttachment.validate(readInt);
      result.authenticatorAttachment =
          AuthenticatorAttachment.toKnownValue(result.authenticatorAttachment);
      result.signature = decoder0.readBytes(24, 0, -1);
      result.userHandle = decoder0.readBytes(32, 1, -1);
      Decoder decoder12 = decoder0.readPointer(40, false);
      result.extensions = AuthenticationExtensionsClientOutputs.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.info, 8, false);
    encoder0.encode(this.authenticatorAttachment, 16);
    encoder0.encode(this.signature, 24, 0, -1);
    encoder0.encode(this.userHandle, 32, 1, -1);
    encoder0.encode((Struct) this.extensions, 40, false);
  }
}
