package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.payments.mojom.PaymentCurrencyAmount;
import org.chromium.url.internal.mojom.Origin;

public final class PaymentOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public PaymentCredentialInstrument instrument;
  public String payeeName;
  public Origin payeeOrigin;
  public PaymentCurrencyAmount total;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PaymentOptions(int version) {
    super(40, version);
  }

  public PaymentOptions() {
    this(0);
  }

  public static PaymentOptions deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PaymentOptions deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PaymentOptions decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PaymentOptions result = new PaymentOptions(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.total = PaymentCurrencyAmount.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.instrument = PaymentCredentialInstrument.decode(decoder12);
      result.payeeName = decoder0.readString(24, true);
      Decoder decoder13 = decoder0.readPointer(32, true);
      result.payeeOrigin = Origin.decode(decoder13);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.total, 8, false);
    encoder0.encode((Struct) this.instrument, 16, false);
    encoder0.encode(this.payeeName, 24, true);
    encoder0.encode((Struct) this.payeeOrigin, 32, true);
  }
}
