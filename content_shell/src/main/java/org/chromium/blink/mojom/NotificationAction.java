package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

public final class NotificationAction extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public String action;
  public Url icon;
  public String16 placeholder;
  public String16 title;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NotificationAction(int version) {
    super(48, version);
  }

  public NotificationAction() {
    this(0);
  }

  public static NotificationAction deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NotificationAction deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NotificationAction decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NotificationAction result = new NotificationAction(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      NotificationActionType.validate(readInt);
      result.type = NotificationActionType.toKnownValue(result.type);
      result.action = decoder0.readString(16, false);
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.title = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(32, false);
      result.icon = Url.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(40, true);
      result.placeholder = String16.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode(this.action, 16, false);
    encoder0.encode((Struct) this.title, 24, false);
    encoder0.encode((Struct) this.icon, 32, false);
    encoder0.encode((Struct) this.placeholder, 40, true);
  }
}
