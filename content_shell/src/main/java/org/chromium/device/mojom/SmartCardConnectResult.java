package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class SmartCardConnectResult extends Union {

  private int mError;
  private SmartCardConnectSuccess mSuccess;

  public static final class Tag {
    public static final int Error = 1;
    public static final int Success = 0;
  }

  public void setSuccess(SmartCardConnectSuccess success) {
    this.mTag = 0;
    this.mSuccess = success;
  }

  public SmartCardConnectSuccess getSuccess() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mSuccess;
  }

  public void setError(int error) {
    this.mTag = 1;
    this.mError = error;
  }

  public int getError() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mError;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mSuccess, offset + 8, false);
        return;
      case 1:
        encoder0.encode(this.mError, offset + 8);
        return;
      default:
        return;
    }
  }

  public static SmartCardConnectResult deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final SmartCardConnectResult decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    SmartCardConnectResult result = new SmartCardConnectResult();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mSuccess = SmartCardConnectSuccess.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        int readInt = decoder0.readInt(offset + 8);
        result.mError = readInt;
        SmartCardError.validate(readInt);
        result.mError = SmartCardError.toKnownValue(result.mError);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
