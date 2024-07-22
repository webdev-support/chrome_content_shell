package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.url.mojom.Url;

public interface CrossOriginEmbedderPolicyReporter extends Interface {
  public static final Interface.Manager<CrossOriginEmbedderPolicyReporter, Proxy> MANAGER =
      CrossOriginEmbedderPolicyReporter_Internal.MANAGER;

  public interface Proxy extends CrossOriginEmbedderPolicyReporter, Interface.Proxy {}

  void clone(InterfaceRequest<CrossOriginEmbedderPolicyReporter> interfaceRequest);

  void queueCorpViolationReport(Url url, int i, boolean z);
}
