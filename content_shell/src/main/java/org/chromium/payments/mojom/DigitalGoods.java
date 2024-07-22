package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DigitalGoods extends Interface {
  public static final Interface.Manager<DigitalGoods, Proxy> MANAGER =
      DigitalGoods_Internal.MANAGER;

  public interface Consume_Response {
    void call(int i);
  }

  public interface GetDetails_Response {
    void call(int i, ItemDetails[] itemDetailsArr);
  }

  public interface ListPurchaseHistory_Response {
    void call(int i, PurchaseReference[] purchaseReferenceArr);
  }

  public interface ListPurchases_Response {
    void call(int i, PurchaseReference[] purchaseReferenceArr);
  }

  public interface Proxy extends DigitalGoods, Interface.Proxy {}

  void consume(String str, Consume_Response consume_Response);

  void getDetails(String[] strArr, GetDetails_Response getDetails_Response);

  void listPurchaseHistory(ListPurchaseHistory_Response listPurchaseHistory_Response);

  void listPurchases(ListPurchases_Response listPurchases_Response);
}
