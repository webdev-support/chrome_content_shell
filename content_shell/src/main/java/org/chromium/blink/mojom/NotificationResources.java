package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.skia.mojom.BitmapN32;

public final class NotificationResources extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public BitmapN32[] actionIcons;
  public BitmapN32 badge;
  public BitmapN32 icon;
  public BitmapN32 image;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NotificationResources(int version) {
    super(40, version);
  }

  public NotificationResources() {
    this(0);
  }

  public static NotificationResources deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NotificationResources deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NotificationResources decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NotificationResources result = new NotificationResources(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.image = BitmapN32.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.icon = BitmapN32.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.badge = BitmapN32.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, true);
      if (decoder14 == null) {
        result.actionIcons = null;
      } else {
        DataHeader si1 = decoder14.readDataHeaderForPointerArray(-1);
        result.actionIcons = new BitmapN32[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder14.readPointer((i1 * 8) + 8, true);
          result.actionIcons[i1] = BitmapN32.decode(decoder2);
        }
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.image, 8, true);
    encoder0.encode((Struct) this.icon, 16, true);
    encoder0.encode((Struct) this.badge, 24, true);
    BitmapN32[] bitmapN32Arr = this.actionIcons;
    if (bitmapN32Arr == null) {
      encoder0.encodeNullPointer(32, true);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(bitmapN32Arr.length, 32, -1);
    int i0 = 0;
    while (true) {
      BitmapN32[] bitmapN32Arr2 = this.actionIcons;
      if (i0 < bitmapN32Arr2.length) {
        encoder1.encode((Struct) bitmapN32Arr2[i0], (i0 * 8) + 8, true);
        i0++;
      } else {
        return;
      }
    }
  }
}
