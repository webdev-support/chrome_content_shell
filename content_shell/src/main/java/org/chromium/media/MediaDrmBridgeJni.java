package org.chromium.media;

import android.media.MediaCrypto;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class MediaDrmBridgeJni implements MediaDrmBridge.Natives {

  public static final JniStaticTestMocker<MediaDrmBridge.Natives> TEST_HOOKS =
      new JniStaticTestMocker<MediaDrmBridge.Natives>() {
        @Override
        public void setInstanceForTesting(MediaDrmBridge.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          MediaDrmBridgeJni.testInstance = instance;
        }
      };
  private static MediaDrmBridge.Natives testInstance;

  MediaDrmBridgeJni() {}

  @Override
  public void onMediaCryptoReady(
      long nativeMediaDrmBridge, MediaDrmBridge caller, MediaCrypto mediaCrypto) {
    if (nativeMediaDrmBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaDrmBridge_onMediaCryptoReady(
        nativeMediaDrmBridge, caller, mediaCrypto);
  }

  @Override
  public void onPromiseRejected(
      long nativeMediaDrmBridge,
      MediaDrmBridge caller,
      long promiseId,
      long systemCode,
      String errorMessage) {
    if (nativeMediaDrmBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaDrmBridge_onPromiseRejected(
        nativeMediaDrmBridge, caller, promiseId, systemCode, errorMessage);
  }

  @Override
  public void onPromiseResolved(long nativeMediaDrmBridge, MediaDrmBridge caller, long promiseId) {
    if (nativeMediaDrmBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaDrmBridge_onPromiseResolved(
        nativeMediaDrmBridge, caller, promiseId);
  }

  @Override
  public void onPromiseResolvedWithSession(
      long nativeMediaDrmBridge, MediaDrmBridge caller, long promiseId, byte[] emeSessionId) {
    if (nativeMediaDrmBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaDrmBridge_onPromiseResolvedWithSession(
        nativeMediaDrmBridge, caller, promiseId, emeSessionId);
  }

  @Override
  public void onProvisionRequest(
      long nativeMediaDrmBridge, MediaDrmBridge caller, String defaultUrl, byte[] requestData) {
    if (nativeMediaDrmBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaDrmBridge_onProvisionRequest(
        nativeMediaDrmBridge, caller, defaultUrl, requestData);
  }

  @Override
  public void onProvisioningComplete(
      long nativeMediaDrmBridge, MediaDrmBridge caller, boolean success) {
    if (nativeMediaDrmBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaDrmBridge_onProvisioningComplete(
        nativeMediaDrmBridge, caller, success);
  }

  @Override
  public void onSessionClosed(
      long nativeMediaDrmBridge, MediaDrmBridge caller, byte[] emeSessionId) {
    if (nativeMediaDrmBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaDrmBridge_onSessionClosed(
        nativeMediaDrmBridge, caller, emeSessionId);
  }

  @Override
  public void onSessionExpirationUpdate(
      long nativeMediaDrmBridge, MediaDrmBridge caller, byte[] emeSessionId, long expirationTime) {
    if (nativeMediaDrmBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaDrmBridge_onSessionExpirationUpdate(
        nativeMediaDrmBridge, caller, emeSessionId, expirationTime);
  }

  @Override
  public void onSessionKeysChange(
      long nativeMediaDrmBridge,
      MediaDrmBridge caller,
      byte[] emeSessionId,
      Object[] keysInfo,
      boolean hasAdditionalUsableKey,
      boolean isKeyRelease) {
    if (nativeMediaDrmBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaDrmBridge_onSessionKeysChange(
        nativeMediaDrmBridge, caller, emeSessionId, keysInfo, hasAdditionalUsableKey, isKeyRelease);
  }

  @Override
  public void onSessionMessage(
      long nativeMediaDrmBridge,
      MediaDrmBridge caller,
      byte[] emeSessionId,
      int requestType,
      byte[] message) {
    if (nativeMediaDrmBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaDrmBridge_onSessionMessage(
        nativeMediaDrmBridge, caller, emeSessionId, requestType, message);
  }

  public static MediaDrmBridge.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      MediaDrmBridge.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of MediaDrmBridge.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new MediaDrmBridgeJni();
  }
}
