package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface PaymentManager extends Interface {
  public static final Interface.Manager<PaymentManager, Proxy> MANAGER =
      PaymentManager_Internal.MANAGER;

  public interface ClearPaymentInstruments_Response {
    void call(int i);
  }

  public interface DeletePaymentInstrument_Response {
    void call(int i);
  }

  public interface EnableDelegations_Response {
    void call(int i);
  }

  public interface GetPaymentInstrument_Response {
    void call(PaymentInstrument paymentInstrument, int i);
  }

  public interface HasPaymentInstrument_Response {
    void call(int i);
  }

  public interface KeysOfPaymentInstruments_Response {
    void call(String[] strArr, int i);
  }

  public interface Proxy extends PaymentManager, Interface.Proxy {}

  public interface SetPaymentInstrument_Response {
    void call(int i);
  }

  void clearPaymentInstruments(ClearPaymentInstruments_Response clearPaymentInstruments_Response);

  void deletePaymentInstrument(
      String str, DeletePaymentInstrument_Response deletePaymentInstrument_Response);

  void enableDelegations(int[] iArr, EnableDelegations_Response enableDelegations_Response);

  void getPaymentInstrument(
      String str, GetPaymentInstrument_Response getPaymentInstrument_Response);

  void hasPaymentInstrument(
      String str, HasPaymentInstrument_Response hasPaymentInstrument_Response);

  void init(Url url, String str);

  void keysOfPaymentInstruments(
      KeysOfPaymentInstruments_Response keysOfPaymentInstruments_Response);

  void setPaymentInstrument(
      String str,
      PaymentInstrument paymentInstrument,
      SetPaymentInstrument_Response setPaymentInstrument_Response);

  void setUserHint(String str);
}
