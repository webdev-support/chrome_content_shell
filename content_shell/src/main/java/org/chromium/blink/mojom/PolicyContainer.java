package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PolicyContainer extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public PolicyContainerPolicies policies;
  public AssociatedInterfaceNotSupported remote;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PolicyContainer(int version) {
    super(24, version);
  }

  public PolicyContainer() {
    this(0);
  }

  public static PolicyContainer deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PolicyContainer deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PolicyContainer decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PolicyContainer result = new PolicyContainer(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.policies = PolicyContainerPolicies.decode(decoder1);
      result.remote = decoder0.readAssociatedServiceInterfaceNotSupported(16, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.policies, 8, false);
    encoder0.encode(this.remote, 16, false);
  }
}
