package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class DeviceAttributeResult extends Union {

  private String mAttribute;
  private String mErrorMessage;

  public static final class Tag {
    public static final int Attribute = 1;
    public static final int ErrorMessage = 0;
  }

  public void setErrorMessage(String errorMessage) {
    this.mTag = 0;
    this.mErrorMessage = errorMessage;
  }

  public String getErrorMessage() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mErrorMessage;
  }

  public void setAttribute(String attribute) {
    this.mTag = 1;
    this.mAttribute = attribute;
  }

  public String getAttribute() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mAttribute;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mErrorMessage, offset + 8, false);
        return;
      case 1:
        encoder0.encode(this.mAttribute, offset + 8, true);
        return;
      default:
        return;
    }
  }

  public static DeviceAttributeResult deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final DeviceAttributeResult decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    DeviceAttributeResult result = new DeviceAttributeResult();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mErrorMessage = decoder0.readString(offset + 8, false);
        result.mTag = 0;
        break;
      case 1:
        result.mAttribute = decoder0.readString(offset + 8, true);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
