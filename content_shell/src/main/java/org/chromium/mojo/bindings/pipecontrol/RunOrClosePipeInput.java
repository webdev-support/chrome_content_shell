package org.chromium.mojo.bindings.pipecontrol;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class RunOrClosePipeInput extends Union {

  private FlushAsync mFlushAsync;
  private PauseUntilFlushCompletes mPauseUntilFlushCompletes;
  private PeerAssociatedEndpointClosedEvent mPeerAssociatedEndpointClosedEvent;

  public static final class Tag {
    public static final int FlushAsync = 2;
    public static final int PauseUntilFlushCompletes = 1;
    public static final int PeerAssociatedEndpointClosedEvent = 0;
  }

  public void setPeerAssociatedEndpointClosedEvent(
      PeerAssociatedEndpointClosedEvent peerAssociatedEndpointClosedEvent) {
    this.mTag = 0;
    this.mPeerAssociatedEndpointClosedEvent = peerAssociatedEndpointClosedEvent;
  }

  public PeerAssociatedEndpointClosedEvent getPeerAssociatedEndpointClosedEvent() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mPeerAssociatedEndpointClosedEvent;
  }

  public void setPauseUntilFlushCompletes(PauseUntilFlushCompletes pauseUntilFlushCompletes) {
    this.mTag = 1;
    this.mPauseUntilFlushCompletes = pauseUntilFlushCompletes;
  }

  public PauseUntilFlushCompletes getPauseUntilFlushCompletes() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mPauseUntilFlushCompletes;
  }

  public void setFlushAsync(FlushAsync flushAsync) {
    this.mTag = 2;
    this.mFlushAsync = flushAsync;
  }

  public FlushAsync getFlushAsync() {
    if (this.mTag != 2) {
      throw new AssertionError();
    }
    return this.mFlushAsync;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mPeerAssociatedEndpointClosedEvent, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mPauseUntilFlushCompletes, offset + 8, false);
        return;
      case 2:
        encoder0.encode((Struct) this.mFlushAsync, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static RunOrClosePipeInput deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final RunOrClosePipeInput decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    RunOrClosePipeInput result = new RunOrClosePipeInput();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mPeerAssociatedEndpointClosedEvent =
            PeerAssociatedEndpointClosedEvent.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mPauseUntilFlushCompletes = PauseUntilFlushCompletes.decode(decoder12);
        result.mTag = 1;
        break;
      case 2:
        Decoder decoder13 = decoder0.readPointer(offset + 8, false);
        result.mFlushAsync = FlushAsync.decode(decoder13);
        result.mTag = 2;
        break;
    }
    return result;
  }
}
