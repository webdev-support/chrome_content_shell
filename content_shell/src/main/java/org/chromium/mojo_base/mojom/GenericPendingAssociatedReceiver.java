package org.chromium.mojo_base.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class GenericPendingAssociatedReceiver extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public String interfaceName;
  public AssociatedInterfaceRequestNotSupported receiver;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GenericPendingAssociatedReceiver(int version) {
    super(24, version);
  }

  public GenericPendingAssociatedReceiver() {
    this(0);
  }

  public static GenericPendingAssociatedReceiver deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GenericPendingAssociatedReceiver deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GenericPendingAssociatedReceiver decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GenericPendingAssociatedReceiver result =
          new GenericPendingAssociatedReceiver(elementsOrVersion);
      result.interfaceName = decoder0.readString(8, false);
      result.receiver = decoder0.readAssociatedInterfaceRequestNotSupported(16, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.interfaceName, 8, false);
    encoder0.encode(this.receiver, 16, false);
  }
}
