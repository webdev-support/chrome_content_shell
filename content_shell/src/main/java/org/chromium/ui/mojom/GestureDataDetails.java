package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class GestureDataDetails extends Union {

  private GesturePinchData mPinch;
  private GestureSwipeData mSwipe;

  public static final class Tag {
    public static final int Pinch = 0;
    public static final int Swipe = 1;
  }

  public void setPinch(GesturePinchData pinch) {
    this.mTag = 0;
    this.mPinch = pinch;
  }

  public GesturePinchData getPinch() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mPinch;
  }

  public void setSwipe(GestureSwipeData swipe) {
    this.mTag = 1;
    this.mSwipe = swipe;
  }

  public GestureSwipeData getSwipe() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mSwipe;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mPinch, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mSwipe, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static GestureDataDetails deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final GestureDataDetails decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    GestureDataDetails result = new GestureDataDetails();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mPinch = GesturePinchData.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mSwipe = GestureSwipeData.decode(decoder12);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
