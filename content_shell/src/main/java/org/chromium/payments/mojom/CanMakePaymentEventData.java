package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class CanMakePaymentEventData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public PaymentMethodData[] methodData;
  public PaymentDetailsModifier[] modifiers;
  public Url paymentRequestOrigin;
  public Url topOrigin;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CanMakePaymentEventData(int version) {
    super(40, version);
  }

  public CanMakePaymentEventData() {
    this(0);
  }

  public static CanMakePaymentEventData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CanMakePaymentEventData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CanMakePaymentEventData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CanMakePaymentEventData result = new CanMakePaymentEventData(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.topOrigin = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.paymentRequestOrigin = Url.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
      result.methodData = new PaymentMethodData[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder13.readPointer((i1 * 8) + 8, false);
        result.methodData[i1] = PaymentMethodData.decode(decoder2);
      }
      Decoder decoder14 = decoder0.readPointer(32, false);
      DataHeader si12 = decoder14.readDataHeaderForPointerArray(-1);
      result.modifiers = new PaymentDetailsModifier[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder14.readPointer((i12 * 8) + 8, false);
        result.modifiers[i12] = PaymentDetailsModifier.decode(decoder22);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.topOrigin, 8, false);
    encoder0.encode((Struct) this.paymentRequestOrigin, 16, false);
    PaymentMethodData[] paymentMethodDataArr = this.methodData;
    if (paymentMethodDataArr == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(paymentMethodDataArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        PaymentMethodData[] paymentMethodDataArr2 = this.methodData;
        if (i0 >= paymentMethodDataArr2.length) {
          break;
        }
        encoder1.encode((Struct) paymentMethodDataArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    PaymentDetailsModifier[] paymentDetailsModifierArr = this.modifiers;
    if (paymentDetailsModifierArr == null) {
      encoder0.encodeNullPointer(32, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(paymentDetailsModifierArr.length, 32, -1);
    int i02 = 0;
    while (true) {
      PaymentDetailsModifier[] paymentDetailsModifierArr2 = this.modifiers;
      if (i02 < paymentDetailsModifierArr2.length) {
        encoder12.encode((Struct) paymentDetailsModifierArr2[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
