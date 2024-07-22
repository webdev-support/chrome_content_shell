package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class WebTransportError extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public String details;
  public int netError;
  public int quicError;
  public boolean safeToReportDetails;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WebTransportError(int version) {
    super(32, version);
    this.netError = 0;
    this.quicError = 0;
    this.safeToReportDetails = false;
  }

  public WebTransportError() {
    this(0);
  }

  public static WebTransportError deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WebTransportError deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WebTransportError decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WebTransportError result = new WebTransportError(elementsOrVersion);
      result.netError = decoder0.readInt(8);
      result.quicError = decoder0.readInt(12);
      result.details = decoder0.readString(16, false);
      result.safeToReportDetails = decoder0.readBoolean(24, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.netError, 8);
    encoder0.encode(this.quicError, 12);
    encoder0.encode(this.details, 16, false);
    encoder0.encode(this.safeToReportDetails, 24, 0);
  }
}
