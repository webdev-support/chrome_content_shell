package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;

public final class PotentiallyOpaqueBool extends Union {

  private int mOpaque;
  private boolean mTransparent;

  public static final class Tag {
    public static final int Opaque = 1;
    public static final int Transparent = 0;
  }

  public void setTransparent(boolean transparent) {
    this.mTag = 0;
    this.mTransparent = transparent;
  }

  public boolean getTransparent() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mTransparent;
  }

  public void setOpaque(int opaque) {
    this.mTag = 1;
    this.mOpaque = opaque;
  }

  public int getOpaque() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mOpaque;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mTransparent, offset + 8, 0);
        return;
      case 1:
        encoder0.encode(this.mOpaque, offset + 8);
        return;
      default:
        return;
    }
  }

  public static PotentiallyOpaqueBool deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final PotentiallyOpaqueBool decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    PotentiallyOpaqueBool result = new PotentiallyOpaqueBool();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mTransparent = decoder0.readBoolean(offset + 8, 0);
        result.mTag = 0;
        break;
      case 1:
        int readInt = decoder0.readInt(offset + 8);
        result.mOpaque = readInt;
        Opaque.validate(readInt);
        result.mOpaque = Opaque.toKnownValue(result.mOpaque);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
