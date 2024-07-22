package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ClientSecurityState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public CrossOriginEmbedderPolicy crossOriginEmbedderPolicy;
  public int ipAddressSpace;
  public boolean isWebSecureContext;
  public int privateNetworkRequestPolicy;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ClientSecurityState(int version) {
    super(32, version);
    this.isWebSecureContext = false;
    this.ipAddressSpace = 3;
    this.privateNetworkRequestPolicy = 0;
  }

  public ClientSecurityState() {
    this(0);
  }

  public static ClientSecurityState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ClientSecurityState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ClientSecurityState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ClientSecurityState result = new ClientSecurityState(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.crossOriginEmbedderPolicy = CrossOriginEmbedderPolicy.decode(decoder1);
      result.isWebSecureContext = decoder0.readBoolean(16, 0);
      int readInt = decoder0.readInt(20);
      result.ipAddressSpace = readInt;
      IpAddressSpace.validate(readInt);
      result.ipAddressSpace = IpAddressSpace.toKnownValue(result.ipAddressSpace);
      int readInt2 = decoder0.readInt(24);
      result.privateNetworkRequestPolicy = readInt2;
      PrivateNetworkRequestPolicy.validate(readInt2);
      result.privateNetworkRequestPolicy =
          PrivateNetworkRequestPolicy.toKnownValue(result.privateNetworkRequestPolicy);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.crossOriginEmbedderPolicy, 8, false);
    encoder0.encode(this.isWebSecureContext, 16, 0);
    encoder0.encode(this.ipAddressSpace, 20);
    encoder0.encode(this.privateNetworkRequestPolicy, 24);
  }
}
