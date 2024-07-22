package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SubAppsService extends Interface {
  public static final Interface.Manager<SubAppsService, Proxy> MANAGER =
      SubAppsService_Internal.MANAGER;

  public interface Add_Response {
    void call(SubAppsServiceAddResult[] subAppsServiceAddResultArr);
  }

  public interface List_Response {
    void call(SubAppsServiceListResult subAppsServiceListResult);
  }

  public interface Proxy extends SubAppsService, Interface.Proxy {}

  public interface Remove_Response {
    void call(SubAppsServiceRemoveResult[] subAppsServiceRemoveResultArr);
  }

  void add(SubAppsServiceAddParameters[] subAppsServiceAddParametersArr, Add_Response add_Response);

  void list(List_Response list_Response);

  void remove(String[] strArr, Remove_Response remove_Response);
}
