package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PaymentHandlerHost extends Interface {
  public static final Interface.Manager<PaymentHandlerHost, Proxy> MANAGER =
      PaymentHandlerHost_Internal.MANAGER;

  public interface ChangePaymentMethod_Response {
    void call(PaymentRequestDetailsUpdate paymentRequestDetailsUpdate);
  }

  public interface ChangeShippingAddress_Response {
    void call(PaymentRequestDetailsUpdate paymentRequestDetailsUpdate);
  }

  public interface ChangeShippingOption_Response {
    void call(PaymentRequestDetailsUpdate paymentRequestDetailsUpdate);
  }

  public interface Proxy extends PaymentHandlerHost, Interface.Proxy {}

  void changePaymentMethod(
      PaymentHandlerMethodData paymentHandlerMethodData,
      ChangePaymentMethod_Response changePaymentMethod_Response);

  void changeShippingAddress(
      PaymentAddress paymentAddress, ChangeShippingAddress_Response changeShippingAddress_Response);

  void changeShippingOption(
      String str, ChangeShippingOption_Response changeShippingOption_Response);
}
