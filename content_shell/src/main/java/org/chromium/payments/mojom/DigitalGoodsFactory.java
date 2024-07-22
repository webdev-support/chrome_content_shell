package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DigitalGoodsFactory extends Interface {
  public static final Interface.Manager<DigitalGoodsFactory, Proxy> MANAGER =
      DigitalGoodsFactory_Internal.MANAGER;

  public interface CreateDigitalGoods_Response {
    void call(int i, DigitalGoods digitalGoods);
  }

  public interface Proxy extends DigitalGoodsFactory, Interface.Proxy {}

  void createDigitalGoods(String str, CreateDigitalGoods_Response createDigitalGoods_Response);
}
