package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface CookieStore extends Interface {
  public static final Interface.Manager<CookieStore, Proxy> MANAGER = CookieStore_Internal.MANAGER;

  public interface AddSubscriptions_Response {
    void call(boolean z);
  }

  public interface GetSubscriptions_Response {
    void call(CookieChangeSubscription[] cookieChangeSubscriptionArr, boolean z);
  }

  public interface Proxy extends CookieStore, Interface.Proxy {}

  public interface RemoveSubscriptions_Response {
    void call(boolean z);
  }

  void addSubscriptions(
      long j,
      CookieChangeSubscription[] cookieChangeSubscriptionArr,
      AddSubscriptions_Response addSubscriptions_Response);

  void getSubscriptions(long j, GetSubscriptions_Response getSubscriptions_Response);

  void removeSubscriptions(
      long j,
      CookieChangeSubscription[] cookieChangeSubscriptionArr,
      RemoveSubscriptions_Response removeSubscriptions_Response);
}
