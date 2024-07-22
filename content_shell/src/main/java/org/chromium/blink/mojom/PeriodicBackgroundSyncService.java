package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PeriodicBackgroundSyncService extends Interface {
  public static final Interface.Manager<PeriodicBackgroundSyncService, Proxy> MANAGER =
      PeriodicBackgroundSyncService_Internal.MANAGER;

  public interface GetRegistrations_Response {
    void call(int i, SyncRegistrationOptions[] syncRegistrationOptionsArr);
  }

  public interface Proxy extends PeriodicBackgroundSyncService, Interface.Proxy {}

  public interface Register_Response {
    void call(int i, SyncRegistrationOptions syncRegistrationOptions);
  }

  public interface Unregister_Response {
    void call(int i);
  }

  void getRegistrations(long j, GetRegistrations_Response getRegistrations_Response);

  void register(
      SyncRegistrationOptions syncRegistrationOptions, long j, Register_Response register_Response);

  void unregister(long j, String str, Unregister_Response unregister_Response);
}
