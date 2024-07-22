package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PresentationConnectionResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public InterfaceRequest<PresentationConnection> connectionReceiver;
  public PresentationConnection connectionRemote;
  public PresentationInfo presentationInfo;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PresentationConnectionResult(int version) {
    super(32, version);
  }

  public PresentationConnectionResult() {
    this(0);
  }

  public static PresentationConnectionResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PresentationConnectionResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PresentationConnectionResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PresentationConnectionResult result = new PresentationConnectionResult(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.presentationInfo = PresentationInfo.decode(decoder1);
      result.connectionRemote =
          (PresentationConnection)
              decoder0.readServiceInterface(16, false, PresentationConnection.MANAGER);
      result.connectionReceiver = decoder0.readInterfaceRequest(24, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.presentationInfo, 8, false);
    encoder0.encode(this.connectionRemote, 16, false, PresentationConnection.MANAGER);
    encoder0.encode((InterfaceRequest) this.connectionReceiver, 24, false);
  }
}
