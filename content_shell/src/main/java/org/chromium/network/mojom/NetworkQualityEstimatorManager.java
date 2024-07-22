package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface NetworkQualityEstimatorManager extends Interface {
  public static final Interface.Manager<NetworkQualityEstimatorManager, Proxy> MANAGER =
      NetworkQualityEstimatorManager_Internal.MANAGER;

  public interface Proxy extends NetworkQualityEstimatorManager, Interface.Proxy {}

  void requestNotifications(
      NetworkQualityEstimatorManagerClient networkQualityEstimatorManagerClient);
}
