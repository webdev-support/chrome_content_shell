package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class SmartCardCreateContextResult extends Union {

  private SmartCardContext mContext;
  private int mError;

  public static final class Tag {
    public static final int Context = 0;
    public static final int Error = 1;
  }

  public void setContext(SmartCardContext context) {
    this.mTag = 0;
    this.mContext = context;
  }

  public SmartCardContext getContext() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mContext;
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
        encoder0.encode(this.mContext, offset + 8, false, SmartCardContext.MANAGER);
        return;
      case 1:
        encoder0.encode(this.mError, offset + 8);
        return;
      default:
        return;
    }
  }

  public static SmartCardCreateContextResult deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final SmartCardCreateContextResult decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    SmartCardCreateContextResult result = new SmartCardCreateContextResult();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mContext =
            (SmartCardContext)
                decoder0.readServiceInterface(offset + 8, false, SmartCardContext.MANAGER);
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
