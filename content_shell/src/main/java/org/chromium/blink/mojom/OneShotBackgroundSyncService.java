package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface OneShotBackgroundSyncService extends Interface {
  public static final Interface.Manager<OneShotBackgroundSyncService, Proxy> MANAGER =
      OneShotBackgroundSyncService_Internal.MANAGER;

  public interface GetRegistrations_Response {
    void call(int i, SyncRegistrationOptions[] syncRegistrationOptionsArr);
  }

  public interface Proxy extends OneShotBackgroundSyncService, Interface.Proxy {}

  public interface Register_Response {
    void call(int i, SyncRegistrationOptions syncRegistrationOptions);
  }

  void didResolveRegistration(BackgroundSyncRegistrationInfo backgroundSyncRegistrationInfo);

  void getRegistrations(long j, GetRegistrations_Response getRegistrations_Response);

  void register(
      SyncRegistrationOptions syncRegistrationOptions, long j, Register_Response register_Response);
}
