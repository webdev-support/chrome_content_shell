package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.UntypedHandle;
import org.chromium.mojo_base.mojom.FilePath;

public final class TransferableDirectory extends Union {

  private UntypedHandle mHandleForIpc;
  private FilePath mPath;

  public static final class Tag {
    public static final int HandleForIpc = 0;
    public static final int Path = 1;
  }

  public void setHandleForIpc(UntypedHandle handleForIpc) {
    this.mTag = 0;
    this.mHandleForIpc = handleForIpc;
  }

  public UntypedHandle getHandleForIpc() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mHandleForIpc;
  }

  public void setPath(FilePath path) {
    this.mTag = 1;
    this.mPath = path;
  }

  public FilePath getPath() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mPath;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Handle) this.mHandleForIpc, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mPath, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static TransferableDirectory deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final TransferableDirectory decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    TransferableDirectory result = new TransferableDirectory();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mHandleForIpc = decoder0.readUntypedHandle(offset + 8, false);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mPath = FilePath.decode(decoder1);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
