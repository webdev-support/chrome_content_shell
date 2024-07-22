package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class VideoCaptureResult extends Union {

  private int mErrorCode;
  private int mState;

  public static final class Tag {
    public static final int ErrorCode = 1;
    public static final int State = 0;
  }

  public void setState(int state) {
    this.mTag = 0;
    this.mState = state;
  }

  public int getState() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mState;
  }

  public void setErrorCode(int errorCode) {
    this.mTag = 1;
    this.mErrorCode = errorCode;
  }

  public int getErrorCode() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mErrorCode;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mState, offset + 8);
        return;
      case 1:
        encoder0.encode(this.mErrorCode, offset + 8);
        return;
      default:
        return;
    }
  }

  public static VideoCaptureResult deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final VideoCaptureResult decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    VideoCaptureResult result = new VideoCaptureResult();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        int readInt = decoder0.readInt(offset + 8);
        result.mState = readInt;
        VideoCaptureState.validate(readInt);
        result.mState = VideoCaptureState.toKnownValue(result.mState);
        result.mTag = 0;
        break;
      case 1:
        int readInt2 = decoder0.readInt(offset + 8);
        result.mErrorCode = readInt2;
        VideoCaptureError.validate(readInt2);
        result.mErrorCode = VideoCaptureError.toKnownValue(result.mErrorCode);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
