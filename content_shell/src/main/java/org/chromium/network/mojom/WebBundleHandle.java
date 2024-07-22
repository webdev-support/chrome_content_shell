package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface WebBundleHandle extends Interface {
  public static final Interface.Manager<WebBundleHandle, Proxy> MANAGER =
      WebBundleHandle_Internal.MANAGER;

  public interface Proxy extends WebBundleHandle, Interface.Proxy {}

  void clone(InterfaceRequest<WebBundleHandle> interfaceRequest);

  void onWebBundleError(int i, String str);

  void onWebBundleLoadFinished(boolean z);
}
