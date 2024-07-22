package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class TrustTokenKeyCommitmentResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int batchSize;

  public int f707id;
  public TrustTokenVerificationKey[] keys;
  public int protocolVersion;
  public int[] requestIssuanceLocallyOn;
  public int unavailableLocalOperationFallback;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class C4372Os {
    public static final int ANDROID = 0;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 0;
    public static final int MIN_VALUE = 0;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 0;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private C4372Os() {}
  }

  public static final class UnavailableLocalOperationFallback {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 1;
    public static final int MIN_VALUE = 0;
    public static final int RETURN_WITH_ERROR = 1;
    public static final int WEB_ISSUANCE = 0;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private UnavailableLocalOperationFallback() {}
  }

  private TrustTokenKeyCommitmentResult(int version) {
    super(40, version);
  }

  public TrustTokenKeyCommitmentResult() {
    this(0);
  }

  public static TrustTokenKeyCommitmentResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TrustTokenKeyCommitmentResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TrustTokenKeyCommitmentResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TrustTokenKeyCommitmentResult result = new TrustTokenKeyCommitmentResult(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.protocolVersion = readInt;
      TrustTokenProtocolVersion.validate(readInt);
      result.protocolVersion = TrustTokenProtocolVersion.toKnownValue(result.protocolVersion);
      result.f707id = decoder0.readInt(12);
      result.batchSize = decoder0.readInt(16);
      int readInt2 = decoder0.readInt(20);
      result.unavailableLocalOperationFallback = readInt2;
      UnavailableLocalOperationFallback.validate(readInt2);
      result.unavailableLocalOperationFallback =
          UnavailableLocalOperationFallback.toKnownValue(result.unavailableLocalOperationFallback);
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.keys = new TrustTokenVerificationKey[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.keys[i1] = TrustTokenVerificationKey.decode(decoder2);
      }
      result.requestIssuanceLocallyOn = decoder0.readInts(32, 0, -1);
      int i12 = 0;
      while (true) {
        int[] iArr = result.requestIssuanceLocallyOn;
        if (i12 < iArr.length) {
          C4372Os.validate(iArr[i12]);
          i12++;
        } else {
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
    encoder0.encode(this.protocolVersion, 8);
    encoder0.encode(this.f707id, 12);
    encoder0.encode(this.batchSize, 16);
    encoder0.encode(this.unavailableLocalOperationFallback, 20);
    TrustTokenVerificationKey[] trustTokenVerificationKeyArr = this.keys;
    if (trustTokenVerificationKeyArr == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(trustTokenVerificationKeyArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        TrustTokenVerificationKey[] trustTokenVerificationKeyArr2 = this.keys;
        if (i0 >= trustTokenVerificationKeyArr2.length) {
          break;
        }
        encoder1.encode((Struct) trustTokenVerificationKeyArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.requestIssuanceLocallyOn, 32, 0, -1);
  }
}
