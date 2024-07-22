package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class HomeTabUnion extends Union {

  private HomeTabParams mParams;
  private int mVisibility;

  public static final class Tag {
    public static final int Params = 1;
    public static final int Visibility = 0;
  }

  public void setVisibility(int visibility) {
    this.mTag = 0;
    this.mVisibility = visibility;
  }

  public int getVisibility() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mVisibility;
  }

  public void setParams(HomeTabParams params) {
    this.mTag = 1;
    this.mParams = params;
  }

  public HomeTabParams getParams() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mParams;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mVisibility, offset + 8);
        return;
      case 1:
        encoder0.encode((Struct) this.mParams, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static HomeTabUnion deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final HomeTabUnion decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    HomeTabUnion result = new HomeTabUnion();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        int readInt = decoder0.readInt(offset + 8);
        result.mVisibility = readInt;
        TabStripMemberVisibility.validate(readInt);
        result.mVisibility = TabStripMemberVisibility.toKnownValue(result.mVisibility);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mParams = HomeTabParams.decode(decoder1);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
