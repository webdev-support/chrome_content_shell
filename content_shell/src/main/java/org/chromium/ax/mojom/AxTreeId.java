package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class AxTreeId extends Union {

  private UnguessableToken mToken;
  private byte mUnknown;

  public static final class Tag {
    public static final int Token = 1;
    public static final int Unknown = 0;
  }

  public void setUnknown(byte unknown) {
    this.mTag = 0;
    this.mUnknown = unknown;
  }

  public byte getUnknown() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mUnknown;
  }

  public void setToken(UnguessableToken token) {
    this.mTag = 1;
    this.mToken = token;
  }

  public UnguessableToken getToken() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mToken;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mUnknown, offset + 8);
        return;
      case 1:
        encoder0.encode((Struct) this.mToken, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static AxTreeId deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final AxTreeId decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    AxTreeId result = new AxTreeId();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mUnknown = decoder0.readByte(offset + 8);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mToken = UnguessableToken.decode(decoder1);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
