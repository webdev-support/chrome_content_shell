package org.chromium.blink.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.Interface;

public interface ManagedConfigurationService extends Interface {
  public static final Interface.Manager<ManagedConfigurationService, Proxy> MANAGER =
      ManagedConfigurationService_Internal.MANAGER;

  public interface GetManagedConfiguration_Response {
    void call(Map<String, String> map);
  }

  public interface Proxy extends ManagedConfigurationService, Interface.Proxy {}

  void getManagedConfiguration(
      String[] strArr, GetManagedConfiguration_Response getManagedConfiguration_Response);

  void subscribeToManagedConfiguration(ManagedConfigurationObserver managedConfigurationObserver);
}
