package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DigitalIdentityRequest extends Interface {
  public static final Interface.Manager<DigitalIdentityRequest, Proxy> MANAGER =
      DigitalIdentityRequest_Internal.MANAGER;

  public interface Proxy extends DigitalIdentityRequest, Interface.Proxy {}

  public interface Request_Response {
    void call(int i, String str);
  }

  void abort();

  void request(
      DigitalCredentialProvider digitalCredentialProvider, Request_Response request_Response);
}
