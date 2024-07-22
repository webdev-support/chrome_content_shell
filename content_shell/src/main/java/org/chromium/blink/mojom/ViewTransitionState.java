package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class ViewTransitionState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public float devicePixelRatio;
  public ViewTransitionElement[] elements;
  public UnguessableToken navigationId;
  public Size snapshotRootSizeAtCapture;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ViewTransitionState(int version) {
    super(40, version);
  }

  public ViewTransitionState() {
    this(0);
  }

  public static ViewTransitionState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ViewTransitionState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ViewTransitionState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ViewTransitionState result = new ViewTransitionState(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.elements = new ViewTransitionElement[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.elements[i1] = ViewTransitionElement.decode(decoder2);
      }
      result.navigationId = UnguessableToken.decode(decoder0.readPointer(16, false));
      result.snapshotRootSizeAtCapture = Size.decode(decoder0.readPointer(24, false));
      result.devicePixelRatio = decoder0.readFloat(32);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    ViewTransitionElement[] viewTransitionElementArr = this.elements;
    if (viewTransitionElementArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(viewTransitionElementArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        ViewTransitionElement[] viewTransitionElementArr2 = this.elements;
        if (i0 >= viewTransitionElementArr2.length) {
          break;
        }
        encoder1.encode((Struct) viewTransitionElementArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.navigationId, 16, false);
    encoder0.encode((Struct) this.snapshotRootSizeAtCapture, 24, false);
    encoder0.encode(this.devicePixelRatio, 32);
  }
}
