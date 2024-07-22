package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PaymentHandlerResponse extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public String methodName;
  public String payerEmail;
  public String payerName;
  public String payerPhone;
  public int responseType;
  public PaymentAddress shippingAddress;
  public String shippingOption;
  public String stringifiedDetails;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PaymentHandlerResponse(int version) {
    super(72, version);
  }

  public PaymentHandlerResponse() {
    this(0);
  }

  public static PaymentHandlerResponse deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PaymentHandlerResponse deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PaymentHandlerResponse decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PaymentHandlerResponse result = new PaymentHandlerResponse(elementsOrVersion);
      result.methodName = decoder0.readString(8, false);
      result.stringifiedDetails = decoder0.readString(16, false);
      int readInt = decoder0.readInt(24);
      result.responseType = readInt;
      PaymentEventResponseType.validate(readInt);
      result.responseType = PaymentEventResponseType.toKnownValue(result.responseType);
      result.payerName = decoder0.readString(32, true);
      result.payerEmail = decoder0.readString(40, true);
      result.payerPhone = decoder0.readString(48, true);
      Decoder decoder1 = decoder0.readPointer(56, true);
      result.shippingAddress = PaymentAddress.decode(decoder1);
      result.shippingOption = decoder0.readString(64, true);
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
    encoder0.encode(this.responseType, 24);
    encoder0.encode(this.payerName, 32, true);
    encoder0.encode(this.payerEmail, 40, true);
    encoder0.encode(this.payerPhone, 48, true);
    encoder0.encode((Struct) this.shippingAddress, 56, true);
    encoder0.encode(this.shippingOption, 64, true);
  }
}
