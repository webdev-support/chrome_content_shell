package org.chromium.content.browser.framehost;

import org.chromium.base.Callback;
import org.chromium.base.UnguessableToken;
import org.chromium.content_public.browser.JavaScriptCallback;
import org.chromium.content_public.browser.RenderFrameHost;
import org.chromium.url.GURL;
import org.chromium.url.Origin;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class RenderFrameHostImplJni implements RenderFrameHostImpl.Natives {

  public static final JniStaticTestMocker<RenderFrameHostImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<RenderFrameHostImpl.Natives>() {
        @Override
        public void setInstanceForTesting(RenderFrameHostImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          RenderFrameHostImplJni.testInstance = instance;
        }
      };
  private static RenderFrameHostImpl.Natives testInstance;

  RenderFrameHostImplJni() {}

  @Override
  public void executeJavaScriptInIsolatedWorld(
      long nativeRenderFrameHostAndroid,
      String stript,
      int isolatedWorldId,
      JavaScriptCallback callback) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_framehost_RenderFrameHostImpl_executeJavaScriptInIsolatedWorld(
            nativeRenderFrameHostAndroid, stript, isolatedWorldId, callback);
  }

  @Override
  public RenderFrameHost[] getAllRenderFrameHosts(
      long nativeRenderFrameHostAndroid, RenderFrameHostImpl caller) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    return (RenderFrameHost[])
        GEN_JNI.org_chromium_content_browser_framehost_RenderFrameHostImpl_getAllRenderFrameHosts(
            nativeRenderFrameHostAndroid, caller);
  }

  @Override
  public UnguessableToken getAndroidOverlayRoutingToken(
      long nativeRenderFrameHostAndroid, RenderFrameHostImpl caller) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    return (UnguessableToken)
        GEN_JNI
            .org_chromium_content_browser_framehost_RenderFrameHostImpl_getAndroidOverlayRoutingToken(
                nativeRenderFrameHostAndroid, caller);
  }

  @Override
  public void getCanonicalUrlForSharing(
      long nativeRenderFrameHostAndroid, RenderFrameHostImpl caller, Callback callback) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_RenderFrameHostImpl_getCanonicalUrlForSharing(
        nativeRenderFrameHostAndroid, caller, callback);
  }

  @Override
  public void getInterfaceToRendererFrame(
      long nativeRenderFrameHostAndroid,
      RenderFrameHostImpl caller,
      String interfacename,
      long messagePipeRawHandle) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_RenderFrameHostImpl_getInterfaceToRendererFrame(
        nativeRenderFrameHostAndroid, caller, interfacename, messagePipeRawHandle);
  }

  @Override
  public Origin getLastCommittedOrigin(
      long nativeRenderFrameHostAndroid, RenderFrameHostImpl caller) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    return (Origin)
        GEN_JNI.org_chromium_content_browser_framehost_RenderFrameHostImpl_getLastCommittedOrigin(
            nativeRenderFrameHostAndroid, caller);
  }

  @Override
  public GURL getLastCommittedURL(long nativeRenderFrameHostAndroid, RenderFrameHostImpl caller) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    return (GURL)
        GEN_JNI.org_chromium_content_browser_framehost_RenderFrameHostImpl_getLastCommittedURL(
            nativeRenderFrameHostAndroid, caller);
  }

  @Override
  public int getLifecycleState(long nativeRenderFrameHostAndroid, RenderFrameHostImpl caller) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_framehost_RenderFrameHostImpl_getLifecycleState(
        nativeRenderFrameHostAndroid, caller);
  }

  @Override
  public void insertVisualStateCallback(long nativeRenderFrameHostAndroid, Callback callback) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_RenderFrameHostImpl_insertVisualStateCallback(
        nativeRenderFrameHostAndroid, callback);
  }

  @Override
  public boolean isCloseWatcherActive(
      long nativeRenderFrameHostAndroid, RenderFrameHostImpl caller) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_framehost_RenderFrameHostImpl_isCloseWatcherActive(
        nativeRenderFrameHostAndroid, caller);
  }

  @Override
  public boolean isFeatureEnabled(
      long nativeRenderFrameHostAndroid, RenderFrameHostImpl caller, int feature) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_framehost_RenderFrameHostImpl_isFeatureEnabled(
        nativeRenderFrameHostAndroid, caller, feature);
  }

  @Override
  public boolean isProcessBlocked(long nativeRenderFrameHostAndroid, RenderFrameHostImpl caller) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_framehost_RenderFrameHostImpl_isProcessBlocked(
        nativeRenderFrameHostAndroid, caller);
  }

  @Override
  public boolean isRenderFrameLive(long nativeRenderFrameHostAndroid, RenderFrameHostImpl caller) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_framehost_RenderFrameHostImpl_isRenderFrameLive(
        nativeRenderFrameHostAndroid, caller);
  }

  @Override
  public void notifyUserActivation(long nativeRenderFrameHostAndroid, RenderFrameHostImpl caller) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_framehost_RenderFrameHostImpl_notifyUserActivation(
        nativeRenderFrameHostAndroid, caller);
  }

  @Override
  public void notifyWebAuthnAssertionRequestSucceeded(
      long nativeRenderFrameHostAndroid, RenderFrameHostImpl caller) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_framehost_RenderFrameHostImpl_notifyWebAuthnAssertionRequestSucceeded(
            nativeRenderFrameHostAndroid, caller);
  }

  @Override
  public void performGetAssertionWebAuthSecurityChecks(
      long nativeRenderFrameHostAndroid,
      RenderFrameHostImpl caller,
      String relyingPartyId,
      Origin effectiveOrigin,
      boolean isPaymentCredentialGetAssertion,
      Callback callback) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_framehost_RenderFrameHostImpl_performGetAssertionWebAuthSecurityChecks(
            nativeRenderFrameHostAndroid,
            caller,
            relyingPartyId,
            effectiveOrigin,
            isPaymentCredentialGetAssertion,
            callback);
  }

  @Override
  public void performMakeCredentialWebAuthSecurityChecks(
      long nativeRenderFrameHostAndroid,
      RenderFrameHostImpl caller,
      String relyingPartyId,
      Origin effectiveOrigin,
      boolean isPaymentCredentialCreation,
      Callback callback) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_framehost_RenderFrameHostImpl_performMakeCredentialWebAuthSecurityChecks(
            nativeRenderFrameHostAndroid,
            caller,
            relyingPartyId,
            effectiveOrigin,
            isPaymentCredentialCreation,
            callback);
  }

  @Override
  public boolean signalCloseWatcherIfActive(
      long nativeRenderFrameHostAndroid, RenderFrameHostImpl caller) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_framehost_RenderFrameHostImpl_signalCloseWatcherIfActive(
            nativeRenderFrameHostAndroid, caller);
  }

  @Override
  public void terminateRendererDueToBadMessage(
      long nativeRenderFrameHostAndroid, RenderFrameHostImpl caller, int reason) {
    if (nativeRenderFrameHostAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_framehost_RenderFrameHostImpl_terminateRendererDueToBadMessage(
            nativeRenderFrameHostAndroid, caller, reason);
  }

  public static RenderFrameHostImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      RenderFrameHostImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of RenderFrameHostImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new RenderFrameHostImplJni();
  }
}
