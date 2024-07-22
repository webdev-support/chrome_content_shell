package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class FingerprintMessage extends Union {

  private int mFingerprintError;
  private int mScanResult;

  public static final class Tag {
    public static final int FingerprintError = 0;
    public static final int ScanResult = 1;
  }

  public void setFingerprintError(int fingerprintError) {
    this.mTag = 0;
    this.mFingerprintError = fingerprintError;
  }

  public int getFingerprintError() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mFingerprintError;
  }

  public void setScanResult(int scanResult) {
    this.mTag = 1;
    this.mScanResult = scanResult;
  }

  public int getScanResult() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mScanResult;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mFingerprintError, offset + 8);
        return;
      case 1:
        encoder0.encode(this.mScanResult, offset + 8);
        return;
      default:
        return;
    }
  }

  public static FingerprintMessage deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final FingerprintMessage decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    FingerprintMessage result = new FingerprintMessage();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        int readInt = decoder0.readInt(offset + 8);
        result.mFingerprintError = readInt;
        FingerprintError.validate(readInt);
        result.mFingerprintError = FingerprintError.toKnownValue(result.mFingerprintError);
        result.mTag = 0;
        break;
      case 1:
        int readInt2 = decoder0.readInt(offset + 8);
        result.mScanResult = readInt2;
        ScanResult.validate(readInt2);
        result.mScanResult = ScanResult.toKnownValue(result.mScanResult);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
