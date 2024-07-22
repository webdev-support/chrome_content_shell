package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PaymentCredential extends Interface {
  public static final Interface.Manager<PaymentCredential, Proxy> MANAGER =
      PaymentCredential_Internal.MANAGER;

  public interface Proxy extends PaymentCredential, Interface.Proxy {}

  public interface StorePaymentCredential_Response {
    void call(int i);
  }

  void storePaymentCredential(
      byte[] bArr,
      String str,
      byte[] bArr2,
      StorePaymentCredential_Response storePaymentCredential_Response);
}
