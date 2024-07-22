package org.chromium.device.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class InputDeviceInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;

  public String f593id;
  public boolean isAccelerometer;
  public boolean isJoystick;
  public boolean isKey;
  public boolean isKeyboard;
  public boolean isMouse;
  public boolean isTablet;
  public boolean isTouchpad;
  public boolean isTouchscreen;
  public String name;
  public int subsystem;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private InputDeviceInfo(int version) {
    super(40, version);
  }

  public InputDeviceInfo() {
    this(0);
  }

  public static InputDeviceInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static InputDeviceInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static InputDeviceInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      InputDeviceInfo result = new InputDeviceInfo(elementsOrVersion);
      result.f593id = decoder0.readString(8, false);
      result.name = decoder0.readString(16, false);
      int readInt = decoder0.readInt(24);
      result.subsystem = readInt;
      InputDeviceSubsystem.validate(readInt);
      result.subsystem = InputDeviceSubsystem.toKnownValue(result.subsystem);
      int readInt2 = decoder0.readInt(28);
      result.type = readInt2;
      InputDeviceType.validate(readInt2);
      result.type = InputDeviceType.toKnownValue(result.type);
      result.isAccelerometer = decoder0.readBoolean(32, 0);
      result.isJoystick = decoder0.readBoolean(32, 1);
      result.isKey = decoder0.readBoolean(32, 2);
      result.isKeyboard = decoder0.readBoolean(32, 3);
      result.isMouse = decoder0.readBoolean(32, 4);
      result.isTablet = decoder0.readBoolean(32, 5);
      result.isTouchpad = decoder0.readBoolean(32, 6);
      result.isTouchscreen = decoder0.readBoolean(32, 7);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f593id, 8, false);
    encoder0.encode(this.name, 16, false);
    encoder0.encode(this.subsystem, 24);
    encoder0.encode(this.type, 28);
    encoder0.encode(this.isAccelerometer, 32, 0);
    encoder0.encode(this.isJoystick, 32, 1);
    encoder0.encode(this.isKey, 32, 2);
    encoder0.encode(this.isKeyboard, 32, 3);
    encoder0.encode(this.isMouse, 32, 4);
    encoder0.encode(this.isTablet, 32, 5);
    encoder0.encode(this.isTouchpad, 32, 6);
    encoder0.encode(this.isTouchscreen, 32, 7);
  }
}
