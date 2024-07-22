package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class FindOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean findMatch;
  public boolean force;
  public boolean forward;
  public boolean matchCase;
  public boolean newSession;
  public boolean runSynchronouslyForTesting;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private FindOptions(int version) {
    super(16, version);
    this.forward = true;
    this.matchCase = false;
    this.newSession = true;
    this.findMatch = true;
    this.force = false;
    this.runSynchronouslyForTesting = false;
  }

  public FindOptions() {
    this(0);
  }

  public static FindOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FindOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FindOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FindOptions result = new FindOptions(elementsOrVersion);
      result.forward = decoder0.readBoolean(8, 0);
      result.matchCase = decoder0.readBoolean(8, 1);
      result.newSession = decoder0.readBoolean(8, 2);
      result.findMatch = decoder0.readBoolean(8, 3);
      result.force = decoder0.readBoolean(8, 4);
      result.runSynchronouslyForTesting = decoder0.readBoolean(8, 5);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.forward, 8, 0);
    encoder0.encode(this.matchCase, 8, 1);
    encoder0.encode(this.newSession, 8, 2);
    encoder0.encode(this.findMatch, 8, 3);
    encoder0.encode(this.force, 8, 4);
    encoder0.encode(this.runSynchronouslyForTesting, 8, 5);
  }
}
