package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TextDirection;

public final class MenuItem extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int action;
  public boolean checked;
  public boolean enabled;
  public boolean hasTextDirectionOverride;
  public String label;
  public int textDirection;
  public String toolTip;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class Type {
    public static final int CHECKABLE_OPTION = 1;
    public static final int GROUP = 2;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 4;
    public static final int MIN_VALUE = 0;
    public static final int OPTION = 0;
    public static final int SEPARATOR = 3;
    public static final int SUB_MENU = 4;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 4;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private Type() {}
  }

  private MenuItem(int version) {
    super(40, version);
    this.type = 0;
    this.action = 0;
    this.textDirection = 2;
    this.hasTextDirectionOverride = false;
    this.enabled = false;
    this.checked = false;
  }

  public MenuItem() {
    this(0);
  }

  public static MenuItem deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MenuItem deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MenuItem decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MenuItem result = new MenuItem(elementsOrVersion);
      result.label = decoder0.readString(8, true);
      result.toolTip = decoder0.readString(16, true);
      int readInt = decoder0.readInt(24);
      result.type = readInt;
      Type.validate(readInt);
      result.type = Type.toKnownValue(result.type);
      result.action = decoder0.readInt(28);
      int readInt2 = decoder0.readInt(32);
      result.textDirection = readInt2;
      TextDirection.validate(readInt2);
      result.textDirection = TextDirection.toKnownValue(result.textDirection);
      result.hasTextDirectionOverride = decoder0.readBoolean(36, 0);
      result.enabled = decoder0.readBoolean(36, 1);
      result.checked = decoder0.readBoolean(36, 2);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.label, 8, true);
    encoder0.encode(this.toolTip, 16, true);
    encoder0.encode(this.type, 24);
    encoder0.encode(this.action, 28);
    encoder0.encode(this.textDirection, 32);
    encoder0.encode(this.hasTextDirectionOverride, 36, 0);
    encoder0.encode(this.enabled, 36, 1);
    encoder0.encode(this.checked, 36, 2);
  }
}
