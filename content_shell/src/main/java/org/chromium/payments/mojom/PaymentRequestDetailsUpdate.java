package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PaymentRequestDetailsUpdate extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public String error;
  public PaymentHandlerModifier[] modifiers;
  public AddressErrors shippingAddressErrors;
  public PaymentShippingOption[] shippingOptions;
  public String stringifiedPaymentMethodErrors;
  public PaymentCurrencyAmount total;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PaymentRequestDetailsUpdate(int version) {
    super(56, version);
    this.error = "";
  }

  public PaymentRequestDetailsUpdate() {
    this(0);
  }

  public static PaymentRequestDetailsUpdate deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PaymentRequestDetailsUpdate deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PaymentRequestDetailsUpdate decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PaymentRequestDetailsUpdate result = new PaymentRequestDetailsUpdate(elementsOrVersion);
      result.total = PaymentCurrencyAmount.decode(decoder0.readPointer(8, true));
      Decoder decoder1 = decoder0.readPointer(16, true);
      if (decoder1 == null) {
        result.shippingOptions = null;
      } else {
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.shippingOptions = new PaymentShippingOption[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.shippingOptions[i1] = PaymentShippingOption.decode(decoder2);
        }
      }
      Decoder decoder12 = decoder0.readPointer(24, true);
      if (decoder12 == null) {
        result.modifiers = null;
      } else {
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.modifiers = new PaymentHandlerModifier[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
          result.modifiers[i12] = PaymentHandlerModifier.decode(decoder22);
        }
      }
      result.error = decoder0.readString(32, false);
      result.stringifiedPaymentMethodErrors = decoder0.readString(40, true);
      result.shippingAddressErrors = AddressErrors.decode(decoder0.readPointer(48, true));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.total, 8, true);
    PaymentShippingOption[] paymentShippingOptionArr = this.shippingOptions;
    if (paymentShippingOptionArr == null) {
      encoder0.encodeNullPointer(16, true);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(paymentShippingOptionArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        PaymentShippingOption[] paymentShippingOptionArr2 = this.shippingOptions;
        if (i0 >= paymentShippingOptionArr2.length) {
          break;
        }
        encoder1.encode((Struct) paymentShippingOptionArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    PaymentHandlerModifier[] paymentHandlerModifierArr = this.modifiers;
    if (paymentHandlerModifierArr == null) {
      encoder0.encodeNullPointer(24, true);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(paymentHandlerModifierArr.length, 24, -1);
      int i02 = 0;
      while (true) {
        PaymentHandlerModifier[] paymentHandlerModifierArr2 = this.modifiers;
        if (i02 >= paymentHandlerModifierArr2.length) {
          break;
        }
        encoder12.encode((Struct) paymentHandlerModifierArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    encoder0.encode(this.error, 32, false);
    encoder0.encode(this.stringifiedPaymentMethodErrors, 40, true);
    encoder0.encode((Struct) this.shippingAddressErrors, 48, true);
  }
}
