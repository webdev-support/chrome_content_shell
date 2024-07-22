package org.chromium.mojo.bindings.interfacecontrol;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class RunOutput extends Union {

  private QueryVersionResult mQueryVersionResult;

  public static final class Tag {
    public static final int QueryVersionResult = 0;
  }

  public void setQueryVersionResult(QueryVersionResult queryVersionResult) {
    this.mTag = 0;
    this.mQueryVersionResult = queryVersionResult;
  }

  public QueryVersionResult getQueryVersionResult() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mQueryVersionResult;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mQueryVersionResult, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static RunOutput deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final RunOutput decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    RunOutput result = new RunOutput();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mQueryVersionResult = QueryVersionResult.decode(decoder1);
        result.mTag = 0;
        break;
    }
    return result;
  }
}
