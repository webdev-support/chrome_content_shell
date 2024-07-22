package org.chromium.blink.mojom;

import org.chromium.device.mojom.SmartCardCreateContextResult;
import org.chromium.mojo.bindings.Interface;

public interface SmartCardService extends Interface {
  public static final Interface.Manager<SmartCardService, Proxy> MANAGER =
      SmartCardService_Internal.MANAGER;

  public interface CreateContext_Response {
    void call(SmartCardCreateContextResult smartCardCreateContextResult);
  }

  public interface Proxy extends SmartCardService, Interface.Proxy {}

  void createContext(CreateContext_Response createContext_Response);
}
