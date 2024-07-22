package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.internal.mojom.Origin;

public final class RemoteDesktopClientOverride extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public Origin origin;
  public boolean sameOriginWithAncestors;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private RemoteDesktopClientOverride(int version) {
    super(24, version);
  }

  public RemoteDesktopClientOverride() {
    this(0);
  }

  public static RemoteDesktopClientOverride deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RemoteDesktopClientOverride deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RemoteDesktopClientOverride decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RemoteDesktopClientOverride result = new RemoteDesktopClientOverride(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.origin = Origin.decode(decoder1);
      result.sameOriginWithAncestors = decoder0.readBoolean(16, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.origin, 8, false);
    encoder0.encode(this.sameOriginWithAncestors, 16, 0);
  }
}
