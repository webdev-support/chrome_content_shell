package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;

public final class PrerenderPageActivationParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public TimeTicks activationStart;
  public ViewTransitionState viewTransitionState;
  public int wasUserActivated;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PrerenderPageActivationParams(int version) {
    super(32, version);
  }

  public PrerenderPageActivationParams() {
    this(0);
  }

  public static PrerenderPageActivationParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PrerenderPageActivationParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PrerenderPageActivationParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PrerenderPageActivationParams result = new PrerenderPageActivationParams(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.wasUserActivated = readInt;
      WasActivatedOption.validate(readInt);
      result.wasUserActivated = WasActivatedOption.toKnownValue(result.wasUserActivated);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.activationStart = TimeTicks.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.viewTransitionState = ViewTransitionState.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.wasUserActivated, 8);
    encoder0.encode((Struct) this.activationStart, 16, false);
    encoder0.encode((Struct) this.viewTransitionState, 24, true);
  }
}
