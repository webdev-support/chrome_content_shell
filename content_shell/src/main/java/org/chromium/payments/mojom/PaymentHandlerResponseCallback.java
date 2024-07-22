package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PaymentHandlerResponseCallback extends Interface {
  public static final Interface.Manager<PaymentHandlerResponseCallback, Proxy> MANAGER =
      PaymentHandlerResponseCallback_Internal.MANAGER;

  public interface Proxy extends PaymentHandlerResponseCallback, Interface.Proxy {}

  void onResponseForAbortPayment(boolean z);

  void onResponseForCanMakePayment(CanMakePaymentResponse canMakePaymentResponse);

  void onResponseForPaymentRequest(PaymentHandlerResponse paymentHandlerResponse);
}
