package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.blink.mojom.GetAssertionAuthenticatorResponse;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PaymentResponse extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public GetAssertionAuthenticatorResponse getAssertionAuthenticatorResponse;
  public String methodName;
  public PayerDetail payer;
  public SecurePaymentConfirmationResponse securePaymentConfirmation;
  public PaymentAddress shippingAddress;
  public String shippingOption;
  public String stringifiedDetails;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PaymentResponse(int version) {
    super(64, version);
  }

  public PaymentResponse() {
    this(0);
  }

  public static PaymentResponse deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PaymentResponse deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PaymentResponse decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PaymentResponse result = new PaymentResponse(elementsOrVersion);
      result.methodName = decoder0.readString(8, false);
      result.stringifiedDetails = decoder0.readString(16, false);
      Decoder decoder1 = decoder0.readPointer(24, true);
      result.shippingAddress = PaymentAddress.decode(decoder1);
      result.shippingOption = decoder0.readString(32, true);
      Decoder decoder12 = decoder0.readPointer(40, false);
      result.payer = PayerDetail.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(48, true);
      result.securePaymentConfirmation = SecurePaymentConfirmationResponse.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(56, true);
      result.getAssertionAuthenticatorResponse =
          GetAssertionAuthenticatorResponse.decode(decoder14);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.methodName, 8, false);
    encoder0.encode(this.stringifiedDetails, 16, false);
    encoder0.encode((Struct) this.shippingAddress, 24, true);
    encoder0.encode(this.shippingOption, 32, true);
    encoder0.encode((Struct) this.payer, 40, false);
    encoder0.encode((Struct) this.securePaymentConfirmation, 48, true);
    encoder0.encode((Struct) this.getAssertionAuthenticatorResponse, 56, true);
  }
}
