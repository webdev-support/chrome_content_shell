package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class NetworkInterface extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public IpAddress address;
  public String friendlyName;
  public int interfaceIndex;
  public int ipAddressAttributes;
  public byte[] macAddress;
  public String name;
  public int prefixLength;
  public int type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NetworkInterface(int version) {
    super(56, version);
  }

  public NetworkInterface() {
    this(0);
  }

  public static NetworkInterface deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NetworkInterface deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NetworkInterface decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NetworkInterface result = new NetworkInterface(elementsOrVersion);
      result.name = decoder0.readString(8, false);
      result.friendlyName = decoder0.readString(16, false);
      result.interfaceIndex = decoder0.readInt(24);
      int readInt = decoder0.readInt(28);
      result.type = readInt;
      ConnectionType.validate(readInt);
      result.type = ConnectionType.toKnownValue(result.type);
      Decoder decoder1 = decoder0.readPointer(32, false);
      result.address = IpAddress.decode(decoder1);
      result.prefixLength = decoder0.readInt(40);
      result.ipAddressAttributes = decoder0.readInt(44);
      result.macAddress = decoder0.readBytes(48, 1, 6);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.name, 8, false);
    encoder0.encode(this.friendlyName, 16, false);
    encoder0.encode(this.interfaceIndex, 24);
    encoder0.encode(this.type, 28);
    encoder0.encode((Struct) this.address, 32, false);
    encoder0.encode(this.prefixLength, 40);
    encoder0.encode(this.ipAddressAttributes, 44);
    encoder0.encode(this.macAddress, 48, 1, 6);
  }
}
