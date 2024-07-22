package org.chromium.content_public.browser;

import java.util.List;
import org.chromium.base.Callback;
import org.chromium.mojo.bindings.Interface;
import org.chromium.url.GURL;
import org.chromium.url.Origin;

public interface RenderFrameHost {
  boolean areInputEventsIgnored();

  void executeJavaScriptInIsolatedWorld(String str, int i, JavaScriptCallback javaScriptCallback);

  List<RenderFrameHost> getAllRenderFrameHosts();

  void getCanonicalUrlForSharing(Callback<GURL> callback);

  GlobalRenderFrameHostId getGlobalRenderFrameHostId();

  <I extends Interface, P extends Interface.Proxy> P getInterfaceToRendererFrame(
      Interface.Manager<I, P> manager);

  Origin getLastCommittedOrigin();

  GURL getLastCommittedURL();

  int getLifecycleState();

  void insertVisualStateCallback(Callback<Boolean> callback);

  boolean isCloseWatcherActive();

  boolean isFeatureEnabled(int i);

  boolean isIncognito();

  boolean isRenderFrameLive();

  void notifyUserActivation();

  void notifyWebAuthnAssertionRequestSucceeded();

  void performGetAssertionWebAuthSecurityChecks(
      String str, Origin origin, boolean z, Callback<WebAuthSecurityChecksResults> callback);

  void performMakeCredentialWebAuthSecurityChecks(
      String str, Origin origin, boolean z, Callback<Integer> callback);

  boolean signalCloseWatcherIfActive();

  void terminateRendererDueToBadMessage(int i);

  public static final class WebAuthSecurityChecksResults {
    public final boolean isCrossOrigin;
    public final int securityCheckResult;

    public WebAuthSecurityChecksResults(int securityCheckResult, boolean isCrossOrigin) {
      this.securityCheckResult = securityCheckResult;
      this.isCrossOrigin = isCrossOrigin;
    }
  }
}
