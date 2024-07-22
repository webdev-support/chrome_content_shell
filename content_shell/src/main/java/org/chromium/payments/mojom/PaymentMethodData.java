package org.chromium.payments.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class PaymentMethodData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public int apiVersion;
  public int environment;
  public int minGooglePlayServicesVersion;
  public SecurePaymentConfirmationRequest securePaymentConfirmation;
  public String stringifiedData;
  public String supportedMethod;
  public int[] supportedNetworks;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private PaymentMethodData(int version) {
    super(56, version);
  }

  public PaymentMethodData() {
    this(0);
  }

  public static PaymentMethodData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static PaymentMethodData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static PaymentMethodData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      PaymentMethodData result = new PaymentMethodData(elementsOrVersion);
      result.supportedMethod = decoder0.readString(8, false);
      result.stringifiedData = decoder0.readString(16, false);
      int readInt = decoder0.readInt(24);
      result.environment = readInt;
      AndroidPayEnvironment.validate(readInt);
      result.environment = AndroidPayEnvironment.toKnownValue(result.environment);
      result.minGooglePlayServicesVersion = decoder0.readInt(28);
      result.apiVersion = decoder0.readInt(32);
      result.supportedNetworks = decoder0.readInts(40, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.supportedNetworks;
        if (i1 < iArr.length) {
          BasicCardNetwork.validate(iArr[i1]);
          i1++;
        } else {
          Decoder decoder1 = decoder0.readPointer(48, true);
          result.securePaymentConfirmation = SecurePaymentConfirmationRequest.decode(decoder1);
          return result;
        }
      }
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.supportedMethod, 8, false);
    encoder0.encode(this.stringifiedData, 16, false);
    encoder0.encode(this.environment, 24);
    encoder0.encode(this.minGooglePlayServicesVersion, 28);
    encoder0.encode(this.apiVersion, 32);
    encoder0.encode(this.supportedNetworks, 40, 0, -1);
    encoder0.encode((Struct) this.securePaymentConfirmation, 48, true);
  }
}
