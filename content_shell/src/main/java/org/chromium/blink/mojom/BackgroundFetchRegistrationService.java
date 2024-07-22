package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.skia.mojom.BitmapN32;

public interface BackgroundFetchRegistrationService extends Interface {
  public static final Interface.Manager<BackgroundFetchRegistrationService, Proxy> MANAGER =
      BackgroundFetchRegistrationService_Internal.MANAGER;

  public interface Abort_Response {
    void call(int i);
  }

  public interface MatchRequests_Response {
    void call(BackgroundFetchSettledFetch[] backgroundFetchSettledFetchArr);
  }

  public interface Proxy extends BackgroundFetchRegistrationService, Interface.Proxy {}

  public interface UpdateUi_Response {
    void call(int i);
  }

  void abort(Abort_Response abort_Response);

  void addRegistrationObserver(
      BackgroundFetchRegistrationObserver backgroundFetchRegistrationObserver);

  void matchRequests(
      FetchApiRequest fetchApiRequest,
      CacheQueryOptions cacheQueryOptions,
      boolean z,
      MatchRequests_Response matchRequests_Response);

  void updateUi(String str, BitmapN32 bitmapN32, UpdateUi_Response updateUi_Response);
}
