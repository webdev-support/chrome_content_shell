package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PaymentRequest extends Interface {
  public static final Interface.Manager<PaymentRequest, Proxy> MANAGER =
      PaymentRequest_Internal.MANAGER;

  public interface Proxy extends PaymentRequest, Interface.Proxy {}

  void abort();

  void canMakePayment();

  void complete(int i);

  void hasEnrolledInstrument();

  void init(
      PaymentRequestClient paymentRequestClient,
      PaymentMethodData[] paymentMethodDataArr,
      PaymentDetails paymentDetails,
      PaymentOptions paymentOptions);

  void onPaymentDetailsNotUpdated();

  void retry(PaymentValidationErrors paymentValidationErrors);

  void show(boolean z, boolean z2);

  void updateWith(PaymentDetails paymentDetails);
}
