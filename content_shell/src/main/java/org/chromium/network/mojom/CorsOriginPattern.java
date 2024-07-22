package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CorsOriginPattern extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public String domain;
  public int domainMatchMode;
  public short port;
  public int portMatchMode;
  public int priority;
  public String protocol;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CorsOriginPattern(int version) {
    super(40, version);
  }

  public CorsOriginPattern() {
    this(0);
  }

  public static CorsOriginPattern deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CorsOriginPattern deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CorsOriginPattern decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CorsOriginPattern result = new CorsOriginPattern(elementsOrVersion);
      result.protocol = decoder0.readString(8, false);
      result.domain = decoder0.readString(16, false);
      result.port = decoder0.readShort(24);
      int readInt = decoder0.readInt(28);
      result.domainMatchMode = readInt;
      CorsDomainMatchMode.validate(readInt);
      result.domainMatchMode = CorsDomainMatchMode.toKnownValue(result.domainMatchMode);
      int readInt2 = decoder0.readInt(32);
      result.portMatchMode = readInt2;
      CorsPortMatchMode.validate(readInt2);
      result.portMatchMode = CorsPortMatchMode.toKnownValue(result.portMatchMode);
      int readInt3 = decoder0.readInt(36);
      result.priority = readInt3;
      CorsOriginAccessMatchPriority.validate(readInt3);
      result.priority = CorsOriginAccessMatchPriority.toKnownValue(result.priority);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.protocol, 8, false);
    encoder0.encode(this.domain, 16, false);
    encoder0.encode(this.port, 24);
    encoder0.encode(this.domainMatchMode, 28);
    encoder0.encode(this.portMatchMode, 32);
    encoder0.encode(this.priority, 36);
  }
}
