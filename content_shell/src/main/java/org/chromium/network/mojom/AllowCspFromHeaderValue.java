package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.url.internal.mojom.Origin;

public final class AllowCspFromHeaderValue extends Union {

  private boolean mAllowStar;
  private String mErrorMessage;
  private Origin mOrigin;

  public static final class Tag {
    public static final int AllowStar = 0;
    public static final int ErrorMessage = 2;
    public static final int Origin = 1;
  }

  public void setAllowStar(boolean allowStar) {
    this.mTag = 0;
    this.mAllowStar = allowStar;
  }

  public boolean getAllowStar() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mAllowStar;
  }

  public void setOrigin(Origin origin) {
    this.mTag = 1;
    this.mOrigin = origin;
  }

  public Origin getOrigin() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mOrigin;
  }

  public void setErrorMessage(String errorMessage) {
    this.mTag = 2;
    this.mErrorMessage = errorMessage;
  }

  public String getErrorMessage() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mErrorMessage;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mAllowStar, offset + 8, 0);
        return;
      case 1:
        encoder0.encode((Struct) this.mOrigin, offset + 8, false);
        return;
      case 2:
        encoder0.encode(this.mErrorMessage, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static AllowCspFromHeaderValue deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final AllowCspFromHeaderValue decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    AllowCspFromHeaderValue result = new AllowCspFromHeaderValue();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mAllowStar = decoder0.readBoolean(offset + 8, 0);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mOrigin = Origin.decode(decoder1);
        result.mTag = 1;
        break;
      case 2:
        result.mErrorMessage = decoder0.readString(offset + 8, false);
        result.mTag = 2;
        break;
    }
    return result;
  }
}
