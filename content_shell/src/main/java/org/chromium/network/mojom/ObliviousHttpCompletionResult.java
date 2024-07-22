package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class ObliviousHttpCompletionResult extends Union {

  private ObliviousHttpResponse mInnerResponse;
  private int mNetError;
  private int mOuterResponseErrorCode;

  public static final class Tag {
    public static final int InnerResponse = 2;
    public static final int NetError = 0;
    public static final int OuterResponseErrorCode = 1;
  }

  public void setNetError(int netError) {
    this.mTag = 0;
    this.mNetError = netError;
  }

  public int getNetError() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mNetError;
  }

  public void setOuterResponseErrorCode(int outerResponseErrorCode) {
    this.mTag = 1;
    this.mOuterResponseErrorCode = outerResponseErrorCode;
  }

  public int getOuterResponseErrorCode() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mOuterResponseErrorCode;
  }

  public void setInnerResponse(ObliviousHttpResponse innerResponse) {
    this.mTag = 2;
    this.mInnerResponse = innerResponse;
  }

  public ObliviousHttpResponse getInnerResponse() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mInnerResponse;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mNetError, offset + 8);
        return;
      case 1:
        encoder0.encode(this.mOuterResponseErrorCode, offset + 8);
        return;
      case 2:
        encoder0.encode((Struct) this.mInnerResponse, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static ObliviousHttpCompletionResult deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final ObliviousHttpCompletionResult decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    ObliviousHttpCompletionResult result = new ObliviousHttpCompletionResult();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mNetError = decoder0.readInt(offset + 8);
        result.mTag = 0;
        break;
      case 1:
        result.mOuterResponseErrorCode = decoder0.readInt(offset + 8);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mInnerResponse = ObliviousHttpResponse.decode(decoder1);
        result.mTag = 2;
        break;
    }
    return result;
  }
}
