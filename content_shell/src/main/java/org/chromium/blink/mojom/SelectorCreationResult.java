package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;

public final class SelectorCreationResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public AnnotationAgent agentRemote;
  public InterfaceRequest<AnnotationAgentHost> hostReceiver;
  public String16 selectedText;
  public String serializedSelector;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SelectorCreationResult(int version) {
    super(40, version);
  }

  public SelectorCreationResult() {
    this(0);
  }

  public static SelectorCreationResult deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SelectorCreationResult deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SelectorCreationResult decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SelectorCreationResult result = new SelectorCreationResult(elementsOrVersion);
      result.hostReceiver = decoder0.readInterfaceRequest(8, false);
      result.agentRemote =
          (AnnotationAgent) decoder0.readServiceInterface(12, false, AnnotationAgent.MANAGER);
      result.serializedSelector = decoder0.readString(24, false);
      Decoder decoder1 = decoder0.readPointer(32, false);
      result.selectedText = String16.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((InterfaceRequest) this.hostReceiver, 8, false);
    encoder0.encode(this.agentRemote, 12, false, AnnotationAgent.MANAGER);
    encoder0.encode(this.serializedSelector, 24, false);
    encoder0.encode((Struct) this.selectedText, 32, false);
  }
}
