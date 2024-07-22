package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface PushMessaging extends Interface {
  public static final Interface.Manager<PushMessaging, Proxy> MANAGER =
      PushMessaging_Internal.MANAGER;

  public interface GetSubscription_Response {
    void call(int i, PushSubscription pushSubscription);
  }

  public interface Proxy extends PushMessaging, Interface.Proxy {}

  public interface Subscribe_Response {
    void call(int i, PushSubscription pushSubscription);
  }

  public interface Unsubscribe_Response {
    void call(int i, boolean z, String str);
  }

  void getSubscription(long j, GetSubscription_Response getSubscription_Response);

  void subscribe(
      long j,
      PushSubscriptionOptions pushSubscriptionOptions,
      boolean z,
      Subscribe_Response subscribe_Response);

  void unsubscribe(long j, Unsubscribe_Response unsubscribe_Response);
}
