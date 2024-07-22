package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SmartCardContextFactory extends Interface {
  public static final Interface.Manager<SmartCardContextFactory, Proxy> MANAGER =
      SmartCardContextFactory_Internal.MANAGER;

  public interface CreateContext_Response {
    void call(SmartCardCreateContextResult smartCardCreateContextResult);
  }

  public interface Proxy extends SmartCardContextFactory, Interface.Proxy {}

  void createContext(CreateContext_Response createContext_Response);
}
