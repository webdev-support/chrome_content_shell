package org.chromium.blink.test.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.network.mojom.CookieWithAccessResult;

public interface CookieManagerAutomation extends Interface {
  public static final Interface.Manager<CookieManagerAutomation, Proxy> MANAGER =
      CookieManagerAutomation_Internal.MANAGER;

  public interface DeleteAllCookies_Response {
    void call();
  }

  public interface GetAllCookies_Response {
    void call(CookieWithAccessResult[] cookieWithAccessResultArr);
  }

  public interface GetNamedCookie_Response {
    void call(CookieWithAccessResult cookieWithAccessResult);
  }

  public interface Proxy extends CookieManagerAutomation, Interface.Proxy {}

  void deleteAllCookies(DeleteAllCookies_Response deleteAllCookies_Response);

  void getAllCookies(GetAllCookies_Response getAllCookies_Response);

  void getNamedCookie(String str, GetNamedCookie_Response getNamedCookie_Response);
}
