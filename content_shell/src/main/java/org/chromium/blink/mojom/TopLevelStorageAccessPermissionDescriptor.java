package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.internal.mojom.Origin;

public final class TopLevelStorageAccessPermissionDescriptor extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public Origin requestedOrigin;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TopLevelStorageAccessPermissionDescriptor(int version) {
    super(16, version);
  }

  public TopLevelStorageAccessPermissionDescriptor() {
    this(0);
  }

  public static TopLevelStorageAccessPermissionDescriptor deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TopLevelStorageAccessPermissionDescriptor deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TopLevelStorageAccessPermissionDescriptor decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TopLevelStorageAccessPermissionDescriptor result =
          new TopLevelStorageAccessPermissionDescriptor(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.requestedOrigin = Origin.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.requestedOrigin, 8, false);
  }
}
