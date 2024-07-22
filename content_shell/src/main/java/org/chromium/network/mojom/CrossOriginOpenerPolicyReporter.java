package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface CrossOriginOpenerPolicyReporter extends Interface {
  public static final Interface.Manager<CrossOriginOpenerPolicyReporter, Proxy> MANAGER =
      CrossOriginOpenerPolicyReporter_Internal.MANAGER;

  public interface Proxy extends CrossOriginOpenerPolicyReporter, Interface.Proxy {}

  void queueAccessReport(int i, String str, SourceLocation sourceLocation, String str2);
}
