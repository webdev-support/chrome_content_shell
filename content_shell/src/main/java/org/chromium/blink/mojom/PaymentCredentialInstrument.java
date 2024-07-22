package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class PaymentCredentialInstrument extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public String displayName;
  public Url icon;
  public boolean iconMustBeShown;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PaymentCredentialInstrument(int version) {
    super(32, version);
  }

  public PaymentCredentialInstrument() {
    this(0);
  }

  public static PaymentCredentialInstrument deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PaymentCredentialInstrument deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PaymentCredentialInstrument decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PaymentCredentialInstrument result = new PaymentCredentialInstrument(elementsOrVersion);
      result.displayName = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.icon = Url.decode(decoder1);
      result.iconMustBeShown = decoder0.readBoolean(24, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.displayName, 8, false);
    encoder0.encode((Struct) this.icon, 16, false);
    encoder0.encode(this.iconMustBeShown, 24, 0);
  }
}
