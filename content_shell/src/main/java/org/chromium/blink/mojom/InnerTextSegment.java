package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class InnerTextSegment extends Union {

  private InnerTextFrame mFrame;
  private int mNodeLocation;
  private String mText;

  public static final class Tag {
    public static final int Frame = 2;
    public static final int NodeLocation = 0;
    public static final int Text = 1;
  }

  public void setNodeLocation(int nodeLocation) {
    this.mTag = 0;
    this.mNodeLocation = nodeLocation;
  }

  public int getNodeLocation() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mNodeLocation;
  }

  public void setText(String text) {
    this.mTag = 1;
    this.mText = text;
  }

  public String getText() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mText;
  }

  public void setFrame(InnerTextFrame frame) {
    this.mTag = 2;
    this.mFrame = frame;
  }

  public InnerTextFrame getFrame() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mFrame;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mNodeLocation, offset + 8);
        return;
      case 1:
        encoder0.encode(this.mText, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mFrame, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static InnerTextSegment deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final InnerTextSegment decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    InnerTextSegment result = new InnerTextSegment();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        int readInt = decoder0.readInt(offset + 8);
        result.mNodeLocation = readInt;
        NodeLocationType.validate(readInt);
        result.mNodeLocation = NodeLocationType.toKnownValue(result.mNodeLocation);
        result.mTag = 0;
        break;
      case 1:
        result.mText = decoder0.readString(offset + 8, false);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mFrame = InnerTextFrame.decode(decoder1);
        result.mTag = 2;
        break;
    }
    return result;
  }
}
