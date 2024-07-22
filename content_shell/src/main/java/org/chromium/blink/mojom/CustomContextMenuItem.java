package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class CustomContextMenuItem extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public int action;
  public boolean checked;
  public boolean enabled;
  public boolean hasDirectionalOverride;
  public String16 icon;
  public String16 label;
  public boolean rtl;
  public CustomContextMenuItem[] submenu;
  public String16 toolTip;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CustomContextMenuItem(int version) {
    super(56, version);
  }

  public CustomContextMenuItem() {
    this(0);
  }

  public static CustomContextMenuItem deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CustomContextMenuItem deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CustomContextMenuItem decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CustomContextMenuItem result = new CustomContextMenuItem(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.label = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.icon = String16.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.toolTip = String16.decode(decoder13);
      int readInt = decoder0.readInt(32);
      result.type = readInt;
      CustomContextMenuItemType.validate(readInt);
      result.type = CustomContextMenuItemType.toKnownValue(result.type);
      result.action = decoder0.readInt(36);
      result.rtl = decoder0.readBoolean(40, 0);
      result.hasDirectionalOverride = decoder0.readBoolean(40, 1);
      result.enabled = decoder0.readBoolean(40, 2);
      result.checked = decoder0.readBoolean(40, 3);
      Decoder decoder14 = decoder0.readPointer(48, false);
      DataHeader si1 = decoder14.readDataHeaderForPointerArray(-1);
      result.submenu = new CustomContextMenuItem[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder14.readPointer((i1 * 8) + 8, false);
        result.submenu[i1] = decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.label, 8, false);
    encoder0.encode((Struct) this.icon, 16, false);
    encoder0.encode((Struct) this.toolTip, 24, false);
    encoder0.encode(this.type, 32);
    encoder0.encode(this.action, 36);
    encoder0.encode(this.rtl, 40, 0);
    encoder0.encode(this.hasDirectionalOverride, 40, 1);
    encoder0.encode(this.enabled, 40, 2);
    encoder0.encode(this.checked, 40, 3);
    CustomContextMenuItem[] customContextMenuItemArr = this.submenu;
    if (customContextMenuItemArr == null) {
      encoder0.encodeNullPointer(48, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(customContextMenuItemArr.length, 48, -1);
    int i0 = 0;
    while (true) {
      CustomContextMenuItem[] customContextMenuItemArr2 = this.submenu;
      if (i0 < customContextMenuItemArr2.length) {
        encoder1.encode((Struct) customContextMenuItemArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
