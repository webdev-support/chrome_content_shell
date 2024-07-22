package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class RemoteFrameInterfacesFromBrowser extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public AssociatedInterfaceNotSupported frameHost;
  public AssociatedInterfaceRequestNotSupported frameReceiver;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private RemoteFrameInterfacesFromBrowser(int version) {
    super(24, version);
  }

  public RemoteFrameInterfacesFromBrowser() {
    this(0);
  }

  public static RemoteFrameInterfacesFromBrowser deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RemoteFrameInterfacesFromBrowser deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RemoteFrameInterfacesFromBrowser decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RemoteFrameInterfacesFromBrowser result =
          new RemoteFrameInterfacesFromBrowser(elementsOrVersion);
      result.frameReceiver = decoder0.readAssociatedInterfaceRequestNotSupported(8, false);
      result.frameHost = decoder0.readAssociatedServiceInterfaceNotSupported(12, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.frameReceiver, 8, false);
    encoder0.encode(this.frameHost, 12, false);
  }
}
