package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.UntypedHandle;

public final class CaLayerContent extends Union {

  private int mCaContextId;
  private UntypedHandle mIoSurfaceMachPort;

  public static final class Tag {
    public static final int CaContextId = 0;
    public static final int IoSurfaceMachPort = 1;
  }

  public void setCaContextId(int caContextId) {
    this.mTag = 0;
    this.mCaContextId = caContextId;
  }

  public int getCaContextId() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mCaContextId;
  }

  public void setIoSurfaceMachPort(UntypedHandle ioSurfaceMachPort) {
    this.mTag = 1;
    this.mIoSurfaceMachPort = ioSurfaceMachPort;
  }

  public UntypedHandle getIoSurfaceMachPort() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mIoSurfaceMachPort;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mCaContextId, offset + 8);
        return;
      case 1:
        encoder0.encode((Handle) this.mIoSurfaceMachPort, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static CaLayerContent deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final CaLayerContent decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    CaLayerContent result = new CaLayerContent();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mCaContextId = decoder0.readInt(offset + 8);
        result.mTag = 0;
        break;
      case 1:
        result.mIoSurfaceMachPort = decoder0.readUntypedHandle(offset + 8, false);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
