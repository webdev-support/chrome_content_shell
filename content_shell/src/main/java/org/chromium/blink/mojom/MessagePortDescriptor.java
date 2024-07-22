package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class MessagePortDescriptor extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;

  public UnguessableToken f443id;
  public MessagePipeHandle pipeHandle;
  public long sequenceNumber;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private MessagePortDescriptor(int version) {
    super(32, version);
    this.pipeHandle = InvalidHandle.INSTANCE;
  }

  public MessagePortDescriptor() {
    this(0);
  }

  public static MessagePortDescriptor deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MessagePortDescriptor deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MessagePortDescriptor decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MessagePortDescriptor result = new MessagePortDescriptor(elementsOrVersion);
      result.pipeHandle = decoder0.readMessagePipeHandle(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.f443id = UnguessableToken.decode(decoder1);
      result.sequenceNumber = decoder0.readLong(24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Handle) this.pipeHandle, 8, false);
    encoder0.encode((Struct) this.f443id, 16, false);
    encoder0.encode(this.sequenceNumber, 24);
  }
}
