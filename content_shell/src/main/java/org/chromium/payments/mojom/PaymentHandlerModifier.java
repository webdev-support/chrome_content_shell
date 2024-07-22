package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PaymentHandlerModifier extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public PaymentHandlerMethodData methodData;
  public PaymentCurrencyAmount total;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PaymentHandlerModifier(int version) {
    super(24, version);
  }

  public PaymentHandlerModifier() {
    this(0);
  }

  public static PaymentHandlerModifier deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PaymentHandlerModifier deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PaymentHandlerModifier decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PaymentHandlerModifier result = new PaymentHandlerModifier(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.total = PaymentCurrencyAmount.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.methodData = PaymentHandlerMethodData.decode(decoder12);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.total, 8, true);
    encoder0.encode((Struct) this.methodData, 16, false);
  }
}
