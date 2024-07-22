package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface WebOtpService extends Interface {
  public static final Interface.Manager<WebOtpService, Proxy> MANAGER =
      WebOtpService_Internal.MANAGER;

  public interface Proxy extends WebOtpService, Interface.Proxy {}

  public interface Receive_Response {
    void call(int i, String str);
  }

  void abort();

  void receive(Receive_Response receive_Response);
}
