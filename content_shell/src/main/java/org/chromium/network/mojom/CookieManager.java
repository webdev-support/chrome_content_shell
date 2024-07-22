package org.chromium.network.mojom;

import org.chromium.content_settings.mojom.ContentSettingPatternSource;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.url.mojom.Url;

public interface CookieManager extends Interface {
  public static final Interface.Manager<CookieManager, Proxy> MANAGER =
      CookieManager_Internal.MANAGER;

  public interface AllowFileSchemeCookies_Response {
    void call(boolean z);
  }

  public interface DeleteCanonicalCookie_Response {
    void call(boolean z);
  }

  public interface DeleteCookies_Response {
    void call(int i);
  }

  public interface DeleteSessionOnlyCookies_Response {
    void call(int i);
  }

  public interface FlushCookieStore_Response {
    void call();
  }

  public interface GetAllCookiesWithAccessSemantics_Response {
    void call(CanonicalCookie[] canonicalCookieArr, int[] iArr);
  }

  public interface GetAllCookies_Response {
    void call(CanonicalCookie[] canonicalCookieArr);
  }

  public interface GetCookieList_Response {
    void call(
        CookieWithAccessResult[] cookieWithAccessResultArr,
        CookieWithAccessResult[] cookieWithAccessResultArr2);
  }

  public interface Proxy extends CookieManager, Interface.Proxy {}

  public interface SetCanonicalCookie_Response {
    void call(CookieAccessResult cookieAccessResult);
  }

  public interface SetContentSettings_Response {
    void call();
  }

  void addCookieChangeListener(Url url, String str, CookieChangeListener cookieChangeListener);

  void addGlobalChangeListener(CookieChangeListener cookieChangeListener);

  void allowFileSchemeCookies(
      boolean z, AllowFileSchemeCookies_Response allowFileSchemeCookies_Response);

  void blockThirdPartyCookies(boolean z);

  void blockTruncatedCookies(boolean z);

  void cloneInterface(InterfaceRequest<CookieManager> interfaceRequest);

  void deleteCanonicalCookie(
      CanonicalCookie canonicalCookie,
      DeleteCanonicalCookie_Response deleteCanonicalCookie_Response);

  void deleteCookies(
      CookieDeletionFilter cookieDeletionFilter, DeleteCookies_Response deleteCookies_Response);

  void deleteSessionOnlyCookies(
      DeleteSessionOnlyCookies_Response deleteSessionOnlyCookies_Response);

  void flushCookieStore(FlushCookieStore_Response flushCookieStore_Response);

  void getAllCookies(GetAllCookies_Response getAllCookies_Response);

  void getAllCookiesWithAccessSemantics(
      GetAllCookiesWithAccessSemantics_Response getAllCookiesWithAccessSemantics_Response);

  void getCookieList(
      Url url,
      CookieOptions cookieOptions,
      CookiePartitionKeyCollection cookiePartitionKeyCollection,
      GetCookieList_Response getCookieList_Response);

  void setCanonicalCookie(
      CanonicalCookie canonicalCookie,
      Url url,
      CookieOptions cookieOptions,
      SetCanonicalCookie_Response setCanonicalCookie_Response);

  void setContentSettings(
      int i,
      ContentSettingPatternSource[] contentSettingPatternSourceArr,
      SetContentSettings_Response setContentSettings_Response);

  void setForceKeepSessionState();

  void setMitigationsEnabledFor3pcd(boolean z);

  void setPreCommitCallbackDelayForTesting(TimeDelta timeDelta);

  void setTrackingProtectionEnabledFor3pcd(boolean z);
}
