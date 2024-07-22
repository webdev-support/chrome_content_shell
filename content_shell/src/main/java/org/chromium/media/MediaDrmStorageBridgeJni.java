package org.chromium.media;

import org.chromium.base.Callback;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class MediaDrmStorageBridgeJni implements MediaDrmStorageBridge.Natives {

  public static final JniStaticTestMocker<MediaDrmStorageBridge.Natives> TEST_HOOKS =
      new JniStaticTestMocker<MediaDrmStorageBridge.Natives>() {
        @Override
        public void setInstanceForTesting(MediaDrmStorageBridge.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          MediaDrmStorageBridgeJni.testInstance = instance;
        }
      };
  private static MediaDrmStorageBridge.Natives testInstance;

  MediaDrmStorageBridgeJni() {}

  @Override
  public void onClearInfo(
      long nativeMediaDrmStorageBridge,
      MediaDrmStorageBridge caller,
      byte[] sessionId,
      Callback cb) {
    if (nativeMediaDrmStorageBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaDrmStorageBridge_onClearInfo(
        nativeMediaDrmStorageBridge, caller, sessionId, cb);
  }

  @Override
  public void onLoadInfo(
      long nativeMediaDrmStorageBridge,
      MediaDrmStorageBridge caller,
      byte[] sessionId,
      Callback cb) {
    if (nativeMediaDrmStorageBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaDrmStorageBridge_onLoadInfo(
        nativeMediaDrmStorageBridge, caller, sessionId, cb);
  }

  @Override
  public void onProvisioned(
      long nativeMediaDrmStorageBridge, MediaDrmStorageBridge caller, Callback cb) {
    if (nativeMediaDrmStorageBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaDrmStorageBridge_onProvisioned(
        nativeMediaDrmStorageBridge, caller, cb);
  }

  @Override
  public void onSaveInfo(
      long nativeMediaDrmStorageBridge,
      MediaDrmStorageBridge caller,
      MediaDrmStorageBridge.PersistentInfo info,
      Callback cb) {
    if (nativeMediaDrmStorageBridge == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_MediaDrmStorageBridge_onSaveInfo(
        nativeMediaDrmStorageBridge, caller, info, cb);
  }

  public static MediaDrmStorageBridge.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      MediaDrmStorageBridge.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of MediaDrmStorageBridge.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new MediaDrmStorageBridgeJni();
  }
}
