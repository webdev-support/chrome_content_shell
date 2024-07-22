package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class CorsErrorStatus extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int corsError;
  public String failedParameter;
  public boolean hasAuthorizationCoveredByWildcardOnPreflight;
  public UnguessableToken issueId;
  public int resourceAddressSpace;
  public int targetAddressSpace;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CorsErrorStatus(int version) {
    super(40, version);
    this.targetAddressSpace = 3;
    this.resourceAddressSpace = 3;
    this.hasAuthorizationCoveredByWildcardOnPreflight = false;
  }

  public CorsErrorStatus() {
    this(0);
  }

  public static CorsErrorStatus deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CorsErrorStatus deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CorsErrorStatus decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CorsErrorStatus result = new CorsErrorStatus(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.corsError = readInt;
      CorsError.validate(readInt);
      result.corsError = CorsError.toKnownValue(result.corsError);
      int readInt2 = decoder0.readInt(12);
      result.targetAddressSpace = readInt2;
      IpAddressSpace.validate(readInt2);
      result.targetAddressSpace = IpAddressSpace.toKnownValue(result.targetAddressSpace);
      result.failedParameter = decoder0.readString(16, false);
      int readInt3 = decoder0.readInt(24);
      result.resourceAddressSpace = readInt3;
      IpAddressSpace.validate(readInt3);
      result.resourceAddressSpace = IpAddressSpace.toKnownValue(result.resourceAddressSpace);
      result.hasAuthorizationCoveredByWildcardOnPreflight = decoder0.readBoolean(28, 0);
      Decoder decoder1 = decoder0.readPointer(32, false);
      result.issueId = UnguessableToken.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.corsError, 8);
    encoder0.encode(this.targetAddressSpace, 12);
    encoder0.encode(this.failedParameter, 16, false);
    encoder0.encode(this.resourceAddressSpace, 24);
    encoder0.encode(this.hasAuthorizationCoveredByWildcardOnPreflight, 28, 0);
    encoder0.encode((Struct) this.issueId, 32, false);
  }
}
