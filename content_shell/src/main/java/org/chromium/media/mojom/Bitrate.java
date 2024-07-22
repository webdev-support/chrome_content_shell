package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class Bitrate extends Union {

  private ConstantBitrate mConstant;
  private ExternalBitrate mExternal;
  private VariableBitrate mVariable;

  public static final class Tag {
    public static final int Constant = 0;
    public static final int External = 2;
    public static final int Variable = 1;
  }

  public void setConstant(ConstantBitrate constant) {
    this.mTag = 0;
    this.mConstant = constant;
  }

  public ConstantBitrate getConstant() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mConstant;
  }

  public void setVariable(VariableBitrate variable) {
    this.mTag = 1;
    this.mVariable = variable;
  }

  public VariableBitrate getVariable() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mVariable;
  }

  public void setExternal(ExternalBitrate external) {
    this.mTag = 2;
    this.mExternal = external;
  }

  public ExternalBitrate getExternal() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mExternal;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mConstant, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mVariable, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mExternal, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static Bitrate deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final Bitrate decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    Bitrate result = new Bitrate();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mConstant = ConstantBitrate.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mVariable = VariableBitrate.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mExternal = ExternalBitrate.decode(decoder13);
        result.mTag = 2;
        break;
    }
    return result;
  }
}
