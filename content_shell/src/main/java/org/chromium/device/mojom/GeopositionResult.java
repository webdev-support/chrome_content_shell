package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class GeopositionResult extends Union {

  private GeopositionError mError;
  private Geoposition mPosition;

  public static final class Tag {
    public static final int Error = 1;
    public static final int Position = 0;
  }

  public void setPosition(Geoposition position) {
    this.mTag = 0;
    this.mPosition = position;
  }

  public Geoposition getPosition() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mPosition;
  }

  public void setError(GeopositionError error) {
    this.mTag = 1;
    this.mError = error;
  }

  public GeopositionError getError() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mError;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mPosition, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mError, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static GeopositionResult deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final GeopositionResult decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    GeopositionResult result = new GeopositionResult();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mPosition = Geoposition.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mError = GeopositionError.decode(decoder12);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
