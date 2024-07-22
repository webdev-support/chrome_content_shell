package org.chromium.gpu.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class MailboxHolder extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public Mailbox mailbox;
  public SyncToken syncToken;
  public int textureTarget;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private MailboxHolder(int version) {
    super(32, version);
  }

  public MailboxHolder() {
    this(0);
  }

  public static MailboxHolder deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static MailboxHolder deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static MailboxHolder decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      MailboxHolder result = new MailboxHolder(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.mailbox = Mailbox.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.syncToken = SyncToken.decode(decoder12);
      result.textureTarget = decoder0.readInt(24);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.mailbox, 8, false);
    encoder0.encode((Struct) this.syncToken, 16, false);
    encoder0.encode(this.textureTarget, 24);
  }
}
