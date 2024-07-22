package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PaymentShippingOption extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public PaymentCurrencyAmount amount;

  public String f713id;
  public String label;
  public boolean selected;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PaymentShippingOption(int version) {
    super(40, version);
  }

  public PaymentShippingOption() {
    this(0);
  }

  public static PaymentShippingOption deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PaymentShippingOption deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PaymentShippingOption decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PaymentShippingOption result = new PaymentShippingOption(elementsOrVersion);
      result.f713id = decoder0.readString(8, false);
      result.label = decoder0.readString(16, false);
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.amount = PaymentCurrencyAmount.decode(decoder1);
      result.selected = decoder0.readBoolean(32, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.f713id, 8, false);
    encoder0.encode(this.label, 16, false);
    encoder0.encode((Struct) this.amount, 24, false);
    encoder0.encode(this.selected, 32, 0);
  }
}
