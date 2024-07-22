package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AuthenticationExtensionsClientOutputs extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean appidExtension;
  public boolean echoAppidExtension;
  public boolean echoLargeBlob;
  public boolean echoLargeBlobWritten;
  public boolean echoPrf;
  public boolean echoUserVerificationMethods;
  public byte[] getCredBlob;
  public byte[] largeBlob;
  public boolean largeBlobWritten;
  public boolean prfNotEvaluated;
  public PrfValues prfResults;
  public SupplementalPubKeysResponse supplementalPubKeys;
  public UvmEntry[] userVerificationMethods;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AuthenticationExtensionsClientOutputs(int version) {
    super(56, version);
  }

  public AuthenticationExtensionsClientOutputs() {
    this(0);
  }

  public static AuthenticationExtensionsClientOutputs deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AuthenticationExtensionsClientOutputs deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AuthenticationExtensionsClientOutputs decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AuthenticationExtensionsClientOutputs result =
          new AuthenticationExtensionsClientOutputs(elementsOrVersion);
      result.echoAppidExtension = decoder0.readBoolean(8, 0);
      result.appidExtension = decoder0.readBoolean(8, 1);
      result.echoUserVerificationMethods = decoder0.readBoolean(8, 2);
      result.echoPrf = decoder0.readBoolean(8, 3);
      result.prfNotEvaluated = decoder0.readBoolean(8, 4);
      result.echoLargeBlob = decoder0.readBoolean(8, 5);
      result.echoLargeBlobWritten = decoder0.readBoolean(8, 6);
      result.largeBlobWritten = decoder0.readBoolean(8, 7);
      Decoder decoder1 = decoder0.readPointer(16, true);
      if (decoder1 == null) {
        result.userVerificationMethods = null;
      } else {
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.userVerificationMethods = new UvmEntry[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.userVerificationMethods[i1] = UvmEntry.decode(decoder2);
        }
      }
      result.prfResults = PrfValues.decode(decoder0.readPointer(24, true));
      result.largeBlob = decoder0.readBytes(32, 1, -1);
      result.getCredBlob = decoder0.readBytes(40, 1, -1);
      result.supplementalPubKeys =
          SupplementalPubKeysResponse.decode(decoder0.readPointer(48, true));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.echoAppidExtension, 8, 0);
    encoder0.encode(this.appidExtension, 8, 1);
    encoder0.encode(this.echoUserVerificationMethods, 8, 2);
    encoder0.encode(this.echoPrf, 8, 3);
    encoder0.encode(this.prfNotEvaluated, 8, 4);
    encoder0.encode(this.echoLargeBlob, 8, 5);
    encoder0.encode(this.echoLargeBlobWritten, 8, 6);
    encoder0.encode(this.largeBlobWritten, 8, 7);
    UvmEntry[] uvmEntryArr = this.userVerificationMethods;
    if (uvmEntryArr == null) {
      encoder0.encodeNullPointer(16, true);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(uvmEntryArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        UvmEntry[] uvmEntryArr2 = this.userVerificationMethods;
        if (i0 >= uvmEntryArr2.length) {
          break;
        }
        encoder1.encode((Struct) uvmEntryArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.prfResults, 24, true);
    encoder0.encode(this.largeBlob, 32, 1, -1);
    encoder0.encode(this.getCredBlob, 40, 1, -1);
    encoder0.encode((Struct) this.supplementalPubKeys, 48, true);
  }
}
