package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class CrossOriginOpenerPolicy extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public String reportOnlyReportingEndpoint;
  public int reportOnlyValue;
  public String reportingEndpoint;
  public int soapByDefaultValue;
  public int value;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CrossOriginOpenerPolicy(int version) {
    super(40, version);
    this.value = 0;
    this.reportOnlyValue = 0;
    this.soapByDefaultValue = 0;
  }

  public CrossOriginOpenerPolicy() {
    this(0);
  }

  public static CrossOriginOpenerPolicy deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CrossOriginOpenerPolicy deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CrossOriginOpenerPolicy decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CrossOriginOpenerPolicy result = new CrossOriginOpenerPolicy(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.value = readInt;
      CrossOriginOpenerPolicyValue.validate(readInt);
      result.value = CrossOriginOpenerPolicyValue.toKnownValue(result.value);
      int readInt2 = decoder0.readInt(12);
      result.reportOnlyValue = readInt2;
      CrossOriginOpenerPolicyValue.validate(readInt2);
      result.reportOnlyValue = CrossOriginOpenerPolicyValue.toKnownValue(result.reportOnlyValue);
      result.reportingEndpoint = decoder0.readString(16, true);
      result.reportOnlyReportingEndpoint = decoder0.readString(24, true);
      int readInt3 = decoder0.readInt(32);
      result.soapByDefaultValue = readInt3;
      CrossOriginOpenerPolicyValue.validate(readInt3);
      result.soapByDefaultValue =
          CrossOriginOpenerPolicyValue.toKnownValue(result.soapByDefaultValue);
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
    encoder0.encode(this.soapByDefaultValue, 32);
  }
}
