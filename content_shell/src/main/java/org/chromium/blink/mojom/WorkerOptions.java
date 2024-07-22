package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.CredentialsMode;

public final class WorkerOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public int credentials;
  public String name;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WorkerOptions(int version) {
    super(24, version);
    this.type = 0;
    this.credentials = 1;
    this.name = "";
  }

  public WorkerOptions() {
    this(0);
  }

  public static WorkerOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WorkerOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WorkerOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WorkerOptions result = new WorkerOptions(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.type = readInt;
      ScriptType.validate(readInt);
      result.type = ScriptType.toKnownValue(result.type);
      int readInt2 = decoder0.readInt(12);
      result.credentials = readInt2;
      CredentialsMode.validate(readInt2);
      result.credentials = CredentialsMode.toKnownValue(result.credentials);
      result.name = decoder0.readString(16, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.type, 8);
    encoder0.encode(this.credentials, 12);
    encoder0.encode(this.name, 16, false);
  }
}
