package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class EarlyHints extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public ParsedHeaders headers;
  public int ipAddressSpace;
  public int referrerPolicy;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private EarlyHints(int version) {
    super(24, version);
  }

  public EarlyHints() {
    this(0);
  }

  public static EarlyHints deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static EarlyHints deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static EarlyHints decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      EarlyHints result = new EarlyHints(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.headers = ParsedHeaders.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.referrerPolicy = readInt;
      ReferrerPolicy.validate(readInt);
      result.referrerPolicy = ReferrerPolicy.toKnownValue(result.referrerPolicy);
      int readInt2 = decoder0.readInt(20);
      result.ipAddressSpace = readInt2;
      IpAddressSpace.validate(readInt2);
      result.ipAddressSpace = IpAddressSpace.toKnownValue(result.ipAddressSpace);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.headers, 8, false);
    encoder0.encode(this.referrerPolicy, 16);
    encoder0.encode(this.ipAddressSpace, 20);
  }
}
