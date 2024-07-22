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

public final class ServiceWorkerContainerInfoForClient extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public AssociatedInterfaceRequestNotSupported clientReceiver;
  public AssociatedInterfaceNotSupported hostRemote;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ServiceWorkerContainerInfoForClient(int version) {
    super(24, version);
  }

  public ServiceWorkerContainerInfoForClient() {
    this(0);
  }

  public static ServiceWorkerContainerInfoForClient deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ServiceWorkerContainerInfoForClient deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ServiceWorkerContainerInfoForClient decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ServiceWorkerContainerInfoForClient result =
          new ServiceWorkerContainerInfoForClient(elementsOrVersion);
      result.hostRemote = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
      result.clientReceiver = decoder0.readAssociatedInterfaceRequestNotSupported(16, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.hostRemote, 8, false);
    encoder0.encode(this.clientReceiver, 16, false);
  }
}
