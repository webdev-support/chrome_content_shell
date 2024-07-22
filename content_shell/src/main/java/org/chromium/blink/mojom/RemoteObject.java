package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface RemoteObject extends Interface {
  public static final Interface.Manager<RemoteObject, Proxy> MANAGER =
      RemoteObject_Internal.MANAGER;

  public interface GetMethods_Response {
    void call(String[] strArr);
  }

  public interface HasMethod_Response {
    void call(boolean z);
  }

  public interface InvokeMethod_Response {
    void call(RemoteInvocationResult remoteInvocationResult);
  }

  public interface Proxy extends RemoteObject, Interface.Proxy {}

  void getMethods(GetMethods_Response getMethods_Response);

  void hasMethod(String str, HasMethod_Response hasMethod_Response);

  void invokeMethod(
      String str,
      RemoteInvocationArgument[] remoteInvocationArgumentArr,
      InvokeMethod_Response invokeMethod_Response);

  void notifyReleasedObject();
}
