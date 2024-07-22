package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PaymentDetailsModifier extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 32;
  private static final DataHeader[] VERSION_ARRAY;
  public PaymentItem[] additionalDisplayItems;
  public PaymentMethodData methodData;
  public PaymentItem total;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PaymentDetailsModifier(int version) {
    super(32, version);
  }

  public PaymentDetailsModifier() {
    this(0);
  }

  public static PaymentDetailsModifier deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PaymentDetailsModifier deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PaymentDetailsModifier decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PaymentDetailsModifier result = new PaymentDetailsModifier(elementsOrVersion);
      result.total = PaymentItem.decode(decoder0.readPointer(8, true));
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.additionalDisplayItems = new PaymentItem[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.additionalDisplayItems[i1] = PaymentItem.decode(decoder2);
      }
      result.methodData = PaymentMethodData.decode(decoder0.readPointer(24, false));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.total, 8, true);
    PaymentItem[] paymentItemArr = this.additionalDisplayItems;
    if (paymentItemArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(paymentItemArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        PaymentItem[] paymentItemArr2 = this.additionalDisplayItems;
        if (i0 >= paymentItemArr2.length) {
          break;
        }
        encoder1.encode((Struct) paymentItemArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.methodData, 24, false);
  }
}
