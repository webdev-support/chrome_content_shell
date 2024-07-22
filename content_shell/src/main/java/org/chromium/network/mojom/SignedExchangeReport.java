package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.url.mojom.Url;

public final class SignedExchangeReport extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 88;
  private static final DataHeader[] VERSION_ARRAY;
  public Url certUrl;
  public TimeDelta elapsedTime;
  public Url innerUrl;
  public String method;
  public Url outerUrl;
  public String protocol;
  public String referrer;
  public IpAddress serverIpAddress;
  public int statusCode;
  public boolean success;
  public String type;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(88, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SignedExchangeReport(int version) {
    super(88, version);
  }

  public SignedExchangeReport() {
    this(0);
  }

  public static SignedExchangeReport deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SignedExchangeReport deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SignedExchangeReport decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SignedExchangeReport result = new SignedExchangeReport(elementsOrVersion);
      result.success = decoder0.readBoolean(8, 0);
      result.statusCode = decoder0.readInt(12);
      result.type = decoder0.readString(16, false);
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.outerUrl = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(32, false);
      result.innerUrl = Url.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(40, false);
      result.certUrl = Url.decode(decoder13);
      result.referrer = decoder0.readString(48, false);
      Decoder decoder14 = decoder0.readPointer(56, false);
      result.serverIpAddress = IpAddress.decode(decoder14);
      result.protocol = decoder0.readString(64, false);
      result.method = decoder0.readString(72, false);
      Decoder decoder15 = decoder0.readPointer(80, false);
      result.elapsedTime = TimeDelta.decode(decoder15);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.success, 8, 0);
    encoder0.encode(this.statusCode, 12);
    encoder0.encode(this.type, 16, false);
    encoder0.encode((Struct) this.outerUrl, 24, false);
    encoder0.encode((Struct) this.innerUrl, 32, false);
    encoder0.encode((Struct) this.certUrl, 40, false);
    encoder0.encode(this.referrer, 48, false);
    encoder0.encode((Struct) this.serverIpAddress, 56, false);
    encoder0.encode(this.protocol, 64, false);
    encoder0.encode(this.method, 72, false);
    encoder0.encode((Struct) this.elapsedTime, 80, false);
  }
}
