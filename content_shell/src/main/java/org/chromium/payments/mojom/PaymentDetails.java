package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PaymentDetails extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public PaymentItem[] displayItems;
  public String error;

  public String f712id;
  public PaymentDetailsModifier[] modifiers;
  public boolean paymentHandlerMinimalHeaderUxEnabled;
  public AddressErrors shippingAddressErrors;
  public PaymentShippingOption[] shippingOptions;
  public String stringifiedPaymentMethodErrors;
  public PaymentItem total;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PaymentDetails(int version) {
    super(80, version);
    this.error = "";
    this.paymentHandlerMinimalHeaderUxEnabled = false;
  }

  public PaymentDetails() {
    this(0);
  }

  public static PaymentDetails deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PaymentDetails deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PaymentDetails decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PaymentDetails result = new PaymentDetails(elementsOrVersion);
      result.total = PaymentItem.decode(decoder0.readPointer(8, true));
      Decoder decoder1 = decoder0.readPointer(16, true);
      if (decoder1 == null) {
        result.displayItems = null;
      } else {
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.displayItems = new PaymentItem[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.displayItems[i1] = PaymentItem.decode(decoder2);
        }
      }
      Decoder decoder12 = decoder0.readPointer(24, true);
      if (decoder12 == null) {
        result.shippingOptions = null;
      } else {
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.shippingOptions = new PaymentShippingOption[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
          result.shippingOptions[i12] = PaymentShippingOption.decode(decoder22);
        }
      }
      Decoder decoder13 = decoder0.readPointer(32, true);
      if (decoder13 == null) {
        result.modifiers = null;
      } else {
        DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
        result.modifiers = new PaymentDetailsModifier[si13.elementsOrVersion];
        for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
          Decoder decoder23 = decoder13.readPointer((i13 * 8) + 8, false);
          result.modifiers[i13] = PaymentDetailsModifier.decode(decoder23);
        }
      }
      result.error = decoder0.readString(40, false);
      result.shippingAddressErrors = AddressErrors.decode(decoder0.readPointer(48, true));
      result.f712id = decoder0.readString(56, true);
      result.stringifiedPaymentMethodErrors = decoder0.readString(64, true);
      result.paymentHandlerMinimalHeaderUxEnabled = decoder0.readBoolean(72, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.total, 8, true);
    PaymentItem[] paymentItemArr = this.displayItems;
    if (paymentItemArr == null) {
      encoder0.encodeNullPointer(16, true);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(paymentItemArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        PaymentItem[] paymentItemArr2 = this.displayItems;
        if (i0 >= paymentItemArr2.length) {
          break;
        }
        encoder1.encode((Struct) paymentItemArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    PaymentShippingOption[] paymentShippingOptionArr = this.shippingOptions;
    if (paymentShippingOptionArr == null) {
      encoder0.encodeNullPointer(24, true);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(paymentShippingOptionArr.length, 24, -1);
      int i02 = 0;
      while (true) {
        PaymentShippingOption[] paymentShippingOptionArr2 = this.shippingOptions;
        if (i02 >= paymentShippingOptionArr2.length) {
          break;
        }
        encoder12.encode((Struct) paymentShippingOptionArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    PaymentDetailsModifier[] paymentDetailsModifierArr = this.modifiers;
    if (paymentDetailsModifierArr == null) {
      encoder0.encodeNullPointer(32, true);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(paymentDetailsModifierArr.length, 32, -1);
      int i03 = 0;
      while (true) {
        PaymentDetailsModifier[] paymentDetailsModifierArr2 = this.modifiers;
        if (i03 >= paymentDetailsModifierArr2.length) {
          break;
        }
        encoder13.encode((Struct) paymentDetailsModifierArr2[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    encoder0.encode(this.error, 40, false);
    encoder0.encode((Struct) this.shippingAddressErrors, 48, true);
    encoder0.encode(this.f712id, 56, true);
    encoder0.encode(this.stringifiedPaymentMethodErrors, 64, true);
    encoder0.encode(this.paymentHandlerMinimalHeaderUxEnabled, 72, 0);
  }
}
