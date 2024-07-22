package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CrossOriginEmbedderPolicy extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public String reportOnlyReportingEndpoint;
  public int reportOnlyValue;
  public String reportingEndpoint;
  public int value;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CrossOriginEmbedderPolicy(int version) {
    super(32, version);
    this.value = 0;
    this.reportOnlyValue = 0;
  }

  public CrossOriginEmbedderPolicy() {
    this(0);
  }

  public static CrossOriginEmbedderPolicy deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CrossOriginEmbedderPolicy deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CrossOriginEmbedderPolicy decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CrossOriginEmbedderPolicy result = new CrossOriginEmbedderPolicy(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.value = readInt;
      CrossOriginEmbedderPolicyValue.validate(readInt);
      result.value = CrossOriginEmbedderPolicyValue.toKnownValue(result.value);
      int readInt2 = decoder0.readInt(12);
      result.reportOnlyValue = readInt2;
      CrossOriginEmbedderPolicyValue.validate(readInt2);
      result.reportOnlyValue = CrossOriginEmbedderPolicyValue.toKnownValue(result.reportOnlyValue);
      result.reportingEndpoint = decoder0.readString(16, true);
      result.reportOnlyReportingEndpoint = decoder0.readString(24, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.value, 8);
    encoder0.encode(this.reportOnlyValue, 12);
    encoder0.encode(this.reportingEndpoint, 16, true);
    encoder0.encode(this.reportOnlyReportingEndpoint, 24, true);
  }
}
