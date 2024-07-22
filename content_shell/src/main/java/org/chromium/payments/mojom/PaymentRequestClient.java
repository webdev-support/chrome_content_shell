package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface PaymentRequestClient extends Interface {
  public static final Interface.Manager<PaymentRequestClient, Proxy> MANAGER =
      PaymentRequestClient_Internal.MANAGER;

  public interface AllowConnectToSource_Response {
    void call(boolean z);
  }

  public interface Proxy extends PaymentRequestClient, Interface.Proxy {}

  void allowConnectToSource(
      Url url, Url url2, boolean z, AllowConnectToSource_Response allowConnectToSource_Response);

  void onAbort(boolean z);

  void onCanMakePayment(int i);

  void onComplete();

  void onError(int i, String str);

  void onHasEnrolledInstrument(int i);

  void onPayerDetailChange(PayerDetail payerDetail);

  void onPaymentMethodChange(String str, String str2);

  void onPaymentResponse(PaymentResponse paymentResponse);

  void onShippingAddressChange(PaymentAddress paymentAddress);

  void onShippingOptionChange(String str);

  void warnNoFavicon();
}
