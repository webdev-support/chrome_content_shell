package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class MakeCredentialAuthenticatorResponse extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public byte[] attestationObject;
  public int authenticatorAttachment;
  public boolean credBlob;
  public boolean credPropsRk;
  public boolean echoCredBlob;
  public boolean echoCredProps;
  public boolean echoHmacCreateSecret;
  public boolean echoLargeBlob;
  public boolean echoPrf;
  public boolean hasCredPropsRk;
  public boolean hmacCreateSecret;
  public CommonCredentialInfo info;
  public boolean prf;
  public PrfValues prfResults;
  public int publicKeyAlgo;
  public byte[] publicKeyDer;
  public SupplementalPubKeysResponse supplementalPubKeys;
  public boolean supportsLargeBlob;
  public int[] transports;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private MakeCredentialAuthenticatorResponse(int version) {
    super(72, version);
  }

  public MakeCredentialAuthenticatorResponse() {
    this(0);
  }

  public static MakeCredentialAuthenticatorResponse deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MakeCredentialAuthenticatorResponse deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MakeCredentialAuthenticatorResponse decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MakeCredentialAuthenticatorResponse result =
          new MakeCredentialAuthenticatorResponse(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.info = CommonCredentialInfo.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.authenticatorAttachment = readInt;
      AuthenticatorAttachment.validate(readInt);
      result.authenticatorAttachment =
          AuthenticatorAttachment.toKnownValue(result.authenticatorAttachment);
      result.echoHmacCreateSecret = decoder0.readBoolean(20, 0);
      result.hmacCreateSecret = decoder0.readBoolean(20, 1);
      result.echoPrf = decoder0.readBoolean(20, 2);
      result.prf = decoder0.readBoolean(20, 3);
      result.echoCredBlob = decoder0.readBoolean(20, 4);
      result.credBlob = decoder0.readBoolean(20, 5);
      result.echoCredProps = decoder0.readBoolean(20, 6);
      result.hasCredPropsRk = decoder0.readBoolean(20, 7);
      result.credPropsRk = decoder0.readBoolean(21, 0);
      result.echoLargeBlob = decoder0.readBoolean(21, 1);
      result.supportsLargeBlob = decoder0.readBoolean(21, 2);
      result.attestationObject = decoder0.readBytes(24, 0, -1);
      result.transports = decoder0.readInts(32, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.transports;
        if (i1 >= iArr.length) {
          Decoder decoder12 = decoder0.readPointer(40, true);
          result.prfResults = PrfValues.decode(decoder12);
          result.publicKeyDer = decoder0.readBytes(48, 1, -1);
          result.publicKeyAlgo = decoder0.readInt(56);
          Decoder decoder13 = decoder0.readPointer(64, true);
          result.supplementalPubKeys = SupplementalPubKeysResponse.decode(decoder13);
          return result;
        }
        AuthenticatorTransport.validate(iArr[i1]);
        i1++;
      }
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.info, 8, false);
    encoder0.encode(this.authenticatorAttachment, 16);
    encoder0.encode(this.echoHmacCreateSecret, 20, 0);
    encoder0.encode(this.hmacCreateSecret, 20, 1);
    encoder0.encode(this.echoPrf, 20, 2);
    encoder0.encode(this.prf, 20, 3);
    encoder0.encode(this.echoCredBlob, 20, 4);
    encoder0.encode(this.credBlob, 20, 5);
    encoder0.encode(this.echoCredProps, 20, 6);
    encoder0.encode(this.hasCredPropsRk, 20, 7);
    encoder0.encode(this.credPropsRk, 21, 0);
    encoder0.encode(this.echoLargeBlob, 21, 1);
    encoder0.encode(this.supportsLargeBlob, 21, 2);
    encoder0.encode(this.attestationObject, 24, 0, -1);
    encoder0.encode(this.transports, 32, 0, -1);
    encoder0.encode((Struct) this.prfResults, 40, true);
    encoder0.encode(this.publicKeyDer, 48, 1, -1);
    encoder0.encode(this.publicKeyAlgo, 56);
    encoder0.encode((Struct) this.supplementalPubKeys, 64, true);
  }
}
