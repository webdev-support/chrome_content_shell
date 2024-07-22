package org.chromium.ui.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Range;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.BigString16;

public final class TextInputState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 88;
  private static final DataHeader[] VERSION_ARRAY;
  public int action;
  public boolean alwaysHideIme;
  public boolean canComposeInline;
  public Range composition;
  public Rect editContextControlBounds;
  public Rect editContextSelectionBounds;
  public int flags;
  public ImeTextSpanInfo[] imeTextSpansInfo;
  public int lastVkVisibilityRequest;
  public int mode;
  public int nodeId;
  public boolean replyToRequest;
  public Range selection;
  public boolean showImeIfNeeded;
  public int type;
  public BigString16 value;
  public int vkPolicy;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(88, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TextInputState(int version) {
    super(88, version);
    this.nodeId = 0;
    this.type = 0;
    this.mode = 0;
    this.action = 0;
    this.canComposeInline = true;
    this.vkPolicy = 0;
    this.lastVkVisibilityRequest = 0;
  }

  public TextInputState() {
    this(0);
  }

  public static TextInputState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TextInputState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TextInputState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TextInputState result = new TextInputState(elementsOrVersion);
      result.nodeId = decoder0.readInt(8);
      int readInt = decoder0.readInt(12);
      result.type = readInt;
      TextInputType.validate(readInt);
      result.type = TextInputType.toKnownValue(result.type);
      int readInt2 = decoder0.readInt(16);
      result.mode = readInt2;
      TextInputMode.validate(readInt2);
      result.mode = TextInputMode.toKnownValue(result.mode);
      int readInt3 = decoder0.readInt(20);
      result.action = readInt3;
      TextInputAction.validate(readInt3);
      result.action = TextInputAction.toKnownValue(result.action);
      result.flags = decoder0.readInt(24);
      result.canComposeInline = decoder0.readBoolean(28, 0);
      result.showImeIfNeeded = decoder0.readBoolean(28, 1);
      result.alwaysHideIme = decoder0.readBoolean(28, 2);
      result.replyToRequest = decoder0.readBoolean(28, 3);
      Decoder decoder1 = decoder0.readPointer(32, true);
      result.value = BigString16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(40, false);
      result.selection = Range.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(48, true);
      result.composition = Range.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(56, true);
      result.editContextControlBounds = Rect.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(64, true);
      result.editContextSelectionBounds = Rect.decode(decoder15);
      int readInt4 = decoder0.readInt(72);
      result.vkPolicy = readInt4;
      VirtualKeyboardPolicy.validate(readInt4);
      result.vkPolicy = VirtualKeyboardPolicy.toKnownValue(result.vkPolicy);
      int readInt5 = decoder0.readInt(76);
      result.lastVkVisibilityRequest = readInt5;
      VirtualKeyboardVisibilityRequest.validate(readInt5);
      result.lastVkVisibilityRequest =
          VirtualKeyboardVisibilityRequest.toKnownValue(result.lastVkVisibilityRequest);
      Decoder decoder16 = decoder0.readPointer(80, false);
      DataHeader si1 = decoder16.readDataHeaderForPointerArray(-1);
      result.imeTextSpansInfo = new ImeTextSpanInfo[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder16.readPointer((i1 * 8) + 8, false);
        result.imeTextSpansInfo[i1] = ImeTextSpanInfo.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.nodeId, 8);
    encoder0.encode(this.type, 12);
    encoder0.encode(this.mode, 16);
    encoder0.encode(this.action, 20);
    encoder0.encode(this.flags, 24);
    encoder0.encode(this.canComposeInline, 28, 0);
    encoder0.encode(this.showImeIfNeeded, 28, 1);
    encoder0.encode(this.alwaysHideIme, 28, 2);
    encoder0.encode(this.replyToRequest, 28, 3);
    encoder0.encode((Struct) this.value, 32, true);
    encoder0.encode((Struct) this.selection, 40, false);
    encoder0.encode((Struct) this.composition, 48, true);
    encoder0.encode((Struct) this.editContextControlBounds, 56, true);
    encoder0.encode((Struct) this.editContextSelectionBounds, 64, true);
    encoder0.encode(this.vkPolicy, 72);
    encoder0.encode(this.lastVkVisibilityRequest, 76);
    ImeTextSpanInfo[] imeTextSpanInfoArr = this.imeTextSpansInfo;
    if (imeTextSpanInfoArr == null) {
      encoder0.encodeNullPointer(80, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(imeTextSpanInfoArr.length, 80, -1);
    int i0 = 0;
    while (true) {
      ImeTextSpanInfo[] imeTextSpanInfoArr2 = this.imeTextSpansInfo;
      if (i0 < imeTextSpanInfoArr2.length) {
        encoder1.encode((Struct) imeTextSpanInfoArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
