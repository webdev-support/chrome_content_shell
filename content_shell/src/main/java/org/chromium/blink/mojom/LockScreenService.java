package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface LockScreenService extends Interface {
  public static final Interface.Manager<LockScreenService, Proxy> MANAGER =
      LockScreenService_Internal.MANAGER;

  public interface GetKeys_Response {
    void call(String[] strArr);
  }

  public interface Proxy extends LockScreenService, Interface.Proxy {}

  public interface SetData_Response {
    void call(int i);
  }

  void getKeys(GetKeys_Response getKeys_Response);

  void setData(String str, String str2, SetData_Response setData_Response);
}
