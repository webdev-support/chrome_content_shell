package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlySharedMemoryRegion;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public interface RestrictedCookieManager extends Interface {
  public static final Interface.Manager<RestrictedCookieManager, Proxy> MANAGER =
      RestrictedCookieManager_Internal.MANAGER;

  public interface AddChangeListener_Response {
    void call();
  }

  public interface CookiesEnabledFor_Response {
    void call(boolean z);
  }

  public interface GetAllForUrl_Response {
    void call(CookieWithAccessResult[] cookieWithAccessResultArr);
  }

  public interface GetCookiesString_Response {
    void call(long j, ReadOnlySharedMemoryRegion readOnlySharedMemoryRegion, String str);
  }

  public interface Proxy extends RestrictedCookieManager, Interface.Proxy {}

  public interface SetCanonicalCookie_Response {
    void call(boolean z);
  }

  public interface SetCookieFromString_Response {
    void call();
  }

  void addChangeListener(
      Url url,
      SiteForCookies siteForCookies,
      Origin origin,
      boolean z,
      CookieChangeListener cookieChangeListener,
      AddChangeListener_Response addChangeListener_Response);

  void cookiesEnabledFor(
      Url url,
      SiteForCookies siteForCookies,
      Origin origin,
      boolean z,
      CookiesEnabledFor_Response cookiesEnabledFor_Response);

  void getAllForUrl(
      Url url,
      SiteForCookies siteForCookies,
      Origin origin,
      boolean z,
      CookieManagerGetOptions cookieManagerGetOptions,
      boolean z2,
      GetAllForUrl_Response getAllForUrl_Response);

  void getCookiesString(
      Url url,
      SiteForCookies siteForCookies,
      Origin origin,
      boolean z,
      boolean z2,
      boolean z3,
      GetCookiesString_Response getCookiesString_Response);

  void setCanonicalCookie(
      CanonicalCookie canonicalCookie,
      Url url,
      SiteForCookies siteForCookies,
      Origin origin,
      boolean z,
      CookieInclusionStatus cookieInclusionStatus,
      SetCanonicalCookie_Response setCanonicalCookie_Response);

  void setCookieFromString(
      Url url,
      SiteForCookies siteForCookies,
      Origin origin,
      boolean z,
      String str,
      SetCookieFromString_Response setCookieFromString_Response);
}
