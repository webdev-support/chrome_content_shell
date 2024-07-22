package org.chromium.viz.mojom;

import org.chromium.gpu.mojom.Mailbox;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class BundledFrameSubmissionData extends Union {

  private Mailbox mDidDeleteSharedBitmap;
  private BeginFrameAck mDidNotProduceFrame;
  private BundledCompositorFrame mFrame;

  public static final class Tag {
    public static final int DidDeleteSharedBitmap = 2;
    public static final int DidNotProduceFrame = 1;
    public static final int Frame = 0;
  }

  public void setFrame(BundledCompositorFrame frame) {
    this.mTag = 0;
    this.mFrame = frame;
  }

  public BundledCompositorFrame getFrame() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mFrame;
  }

  public void setDidNotProduceFrame(BeginFrameAck didNotProduceFrame) {
    this.mTag = 1;
    this.mDidNotProduceFrame = didNotProduceFrame;
  }

  public BeginFrameAck getDidNotProduceFrame() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mDidNotProduceFrame;
  }

  public void setDidDeleteSharedBitmap(Mailbox didDeleteSharedBitmap) {
    this.mTag = 2;
    this.mDidDeleteSharedBitmap = didDeleteSharedBitmap;
  }

  public Mailbox getDidDeleteSharedBitmap() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mDidDeleteSharedBitmap;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mFrame, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mDidNotProduceFrame, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mDidDeleteSharedBitmap, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static BundledFrameSubmissionData deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final BundledFrameSubmissionData decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    BundledFrameSubmissionData result = new BundledFrameSubmissionData();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mFrame = BundledCompositorFrame.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mDidNotProduceFrame = BeginFrameAck.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mDidDeleteSharedBitmap = Mailbox.decode(decoder13);
        result.mTag = 2;
        break;
    }
    return result;
  }
}
