package org.chromium.media;

import java.nio.ByteBuffer;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class VideoCaptureJni implements VideoCapture.Natives {

  public static final JniStaticTestMocker<VideoCapture.Natives> TEST_HOOKS =
      new JniStaticTestMocker<VideoCapture.Natives>() {
        @Override
        public void setInstanceForTesting(VideoCapture.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          VideoCaptureJni.testInstance = instance;
        }
      };
  private static VideoCapture.Natives testInstance;

  VideoCaptureJni() {}

  @Override
  public void dCheckCurrentlyOnIncomingTaskRunner(
      long nativeVideoCaptureDeviceAndroid, VideoCapture caller) {
    if (nativeVideoCaptureDeviceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_VideoCapture_dCheckCurrentlyOnIncomingTaskRunner(
        nativeVideoCaptureDeviceAndroid, caller);
  }

  @Override
  public void onError(
      long nativeVideoCaptureDeviceAndroid,
      VideoCapture caller,
      int androidVideoCaptureError,
      String message) {
    if (nativeVideoCaptureDeviceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_VideoCapture_onError(
        nativeVideoCaptureDeviceAndroid, caller, androidVideoCaptureError, message);
  }

  @Override
  public void onFrameAvailable(
      long nativeVideoCaptureDeviceAndroid,
      VideoCapture caller,
      byte[] data,
      int length,
      int rotation) {
    if (nativeVideoCaptureDeviceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_VideoCapture_onFrameAvailable(
        nativeVideoCaptureDeviceAndroid, caller, data, length, rotation);
  }

  @Override
  public void onFrameDropped(
      long nativeVideoCaptureDeviceAndroid,
      VideoCapture caller,
      int androidVideoCaptureFrameDropReason) {
    if (nativeVideoCaptureDeviceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_VideoCapture_onFrameDropped(
        nativeVideoCaptureDeviceAndroid, caller, androidVideoCaptureFrameDropReason);
  }

  @Override
  public void onGetPhotoCapabilitiesReply(
      long nativeVideoCaptureDeviceAndroid,
      VideoCapture caller,
      long callbackId,
      PhotoCapabilities result) {
    if (nativeVideoCaptureDeviceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_VideoCapture_onGetPhotoCapabilitiesReply(
        nativeVideoCaptureDeviceAndroid, caller, callbackId, result);
  }

  @Override
  public void onI420FrameAvailable(
      long nativeVideoCaptureDeviceAndroid,
      VideoCapture caller,
      ByteBuffer yBuffer,
      int yStride,
      ByteBuffer uBuffer,
      ByteBuffer vBuffer,
      int uvRowStride,
      int uvPixelStride,
      int width,
      int height,
      int rotation,
      long timestamp) {
    if (nativeVideoCaptureDeviceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_VideoCapture_onI420FrameAvailable(
        nativeVideoCaptureDeviceAndroid,
        caller,
        yBuffer,
        yStride,
        uBuffer,
        vBuffer,
        uvRowStride,
        uvPixelStride,
        width,
        height,
        rotation,
        timestamp);
  }

  @Override
  public void onPhotoTaken(
      long nativeVideoCaptureDeviceAndroid, VideoCapture caller, long callbackId, byte[] data) {
    if (nativeVideoCaptureDeviceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_VideoCapture_onPhotoTaken(
        nativeVideoCaptureDeviceAndroid, caller, callbackId, data);
  }

  @Override
  public void onStarted(long nativeVideoCaptureDeviceAndroid, VideoCapture caller) {
    if (nativeVideoCaptureDeviceAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_media_VideoCapture_onStarted(nativeVideoCaptureDeviceAndroid, caller);
  }

  public static VideoCapture.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      VideoCapture.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of VideoCapture.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new VideoCaptureJni();
  }
}
