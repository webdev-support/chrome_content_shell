package org.chromium.viz.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class SharedImageFormat extends Union {

  private MultiplanarFormat mMultiplanarFormat;
  private int mSingleplanarFormat;

  public static final class Tag {
    public static final int MultiplanarFormat = 1;
    public static final int SingleplanarFormat = 0;
  }

  public void setSingleplanarFormat(int singleplanarFormat) {
    this.mTag = 0;
    this.mSingleplanarFormat = singleplanarFormat;
  }

  public int getSingleplanarFormat() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mSingleplanarFormat;
  }

  public void setMultiplanarFormat(MultiplanarFormat multiplanarFormat) {
    this.mTag = 1;
    this.mMultiplanarFormat = multiplanarFormat;
  }

  public MultiplanarFormat getMultiplanarFormat() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mMultiplanarFormat;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mSingleplanarFormat, offset + 8);
        return;
      case 1:
        encoder0.encode((Struct) this.mMultiplanarFormat, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static SharedImageFormat deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final SharedImageFormat decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    SharedImageFormat result = new SharedImageFormat();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        int readInt = decoder0.readInt(offset + 8);
        result.mSingleplanarFormat = readInt;
        SingleplanarFormat.validate(readInt);
        result.mSingleplanarFormat = SingleplanarFormat.toKnownValue(result.mSingleplanarFormat);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mMultiplanarFormat = MultiplanarFormat.decode(decoder1);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
