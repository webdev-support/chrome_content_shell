package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ChangedServiceWorkerObjectsMask extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean active;
  public boolean installing;
  public boolean waiting;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ChangedServiceWorkerObjectsMask(int version) {
    super(16, version);
  }

  public ChangedServiceWorkerObjectsMask() {
    this(0);
  }

  public static ChangedServiceWorkerObjectsMask deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ChangedServiceWorkerObjectsMask deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ChangedServiceWorkerObjectsMask decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ChangedServiceWorkerObjectsMask result =
          new ChangedServiceWorkerObjectsMask(elementsOrVersion);
      result.installing = decoder0.readBoolean(8, 0);
      result.waiting = decoder0.readBoolean(8, 1);
      result.active = decoder0.readBoolean(8, 2);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.installing, 8, 0);
    encoder0.encode(this.waiting, 8, 1);
    encoder0.encode(this.active, 8, 2);
  }
}
