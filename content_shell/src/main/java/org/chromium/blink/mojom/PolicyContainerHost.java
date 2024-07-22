package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.network.mojom.ContentSecurityPolicy;

public interface PolicyContainerHost extends Interface {
  public static final Interface.Manager<PolicyContainerHost, Proxy> MANAGER =
      PolicyContainerHost_Internal.MANAGER;

  public interface Proxy extends PolicyContainerHost, Interface.Proxy {}

  void addContentSecurityPolicies(ContentSecurityPolicy[] contentSecurityPolicyArr);

  void issueKeepAliveHandle(InterfaceRequest<PolicyContainerHostKeepAliveHandle> interfaceRequest);

  void setReferrerPolicy(int i);
}
