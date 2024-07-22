package org.chromium.media;

import android.hardware.display.DisplayManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.chromium.base.ContextUtils;
import org.chromium.blink.mojom.CssSampleId;
import org.jni_zero.JNINamespace;

@JNINamespace("media")
public abstract class VideoCapture {
  protected int mCameraNativeOrientation;
  protected VideoCaptureFormat mCaptureFormat;
  protected final int mId;
  protected boolean mInvertDeviceOrientationReadings;
  private long mNativeVideoCaptureDeviceAndroid;
  private final Object mNativeVideoCaptureLock = new Object();
  protected boolean mUseBackgroundThreadForTesting;

  public interface Natives {
    void dCheckCurrentlyOnIncomingTaskRunner(long j, VideoCapture videoCapture);

    void onError(long j, VideoCapture videoCapture, int i, String str);

    void onFrameAvailable(long j, VideoCapture videoCapture, byte[] bArr, int i, int i2);

    void onFrameDropped(long j, VideoCapture videoCapture, int i);

    void onGetPhotoCapabilitiesReply(
        long j, VideoCapture videoCapture, long j2, PhotoCapabilities photoCapabilities);

    void onI420FrameAvailable(
        long j,
        VideoCapture videoCapture,
        ByteBuffer byteBuffer,
        int i,
        ByteBuffer byteBuffer2,
        ByteBuffer byteBuffer3,
        int i2,
        int i3,
        int i4,
        int i5,
        int i6,
        long j2);

    void onPhotoTaken(long j, VideoCapture videoCapture, long j2, byte[] bArr);

    void onStarted(long j, VideoCapture videoCapture);
  }

  public abstract boolean allocate(int i, int i2, int i3, boolean z);

  public abstract void deallocateInternal();

  public abstract void getPhotoCapabilitiesAsync(long j);

  public abstract void setPhotoOptions(
      double d,
      int i,
      double d2,
      int i2,
      double d3,
      double d4,
      double[] dArr,
      boolean z,
      double d5,
      double d6,
      int i3,
      double d7,
      boolean z2,
      boolean z3,
      int i4,
      boolean z4,
      boolean z5,
      double d8);

  public abstract boolean startCaptureMaybeAsync();

  public abstract boolean stopCaptureAndBlockUntilStopped();

  public abstract void takePhotoAsync(long j);

  public static class FramerateRange {
    public int max;
    public int min;

    public FramerateRange(int min, int max) {
      this.min = min;
      this.max = max;
    }
  }

  public VideoCapture(int id, long nativeVideoCaptureDeviceAndroid) {
    this.mId = id;
    this.mNativeVideoCaptureDeviceAndroid = nativeVideoCaptureDeviceAndroid;
  }

  public void deallocate() {
    synchronized (this.mNativeVideoCaptureLock) {
      this.mNativeVideoCaptureDeviceAndroid = 0L;
    }
    deallocateInternal();
  }

  public final int queryWidth() {
    return this.mCaptureFormat.mWidth;
  }

  public final int queryHeight() {
    return this.mCaptureFormat.mHeight;
  }

  public final int queryFrameRate() {
    return this.mCaptureFormat.mFramerate;
  }

  public final int getColorspace() {
    switch (this.mCaptureFormat.mPixelFormat) {
      case 17:
        return 17;
      case 35:
        return 35;
      case AndroidImageFormat.YV12 /* 842094169 */:
        return AndroidImageFormat.YV12;
      default:
        return 0;
    }
  }

  public final void setTestMode() {
    this.mUseBackgroundThreadForTesting = true;
  }

  public final int getCameraRotation() {
    int rotation;
    if (this.mInvertDeviceOrientationReadings) {
      rotation = 360 - getDeviceRotation();
    } else {
      rotation = getDeviceRotation();
    }
    return (this.mCameraNativeOrientation + rotation) % CssSampleId.FLOOD_COLOR;
  }

  public final int getDeviceRotation() {
    DisplayManager dm =
        (DisplayManager) ContextUtils.getApplicationContext().getSystemService("display");
    switch (dm.getDisplay(0).getRotation()) {
      case 1:
        return 90;
      case 2:
        return 180;
      case 3:
        return CssSampleId.ALIAS_WEBKIT_MARGIN_AFTER;
      default:
        return 0;
    }
  }

  public void notifyTakePhotoError(long callbackId) {
    synchronized (this.mNativeVideoCaptureLock) {
      if (this.mNativeVideoCaptureDeviceAndroid != 0) {
        VideoCaptureJni.get()
            .onPhotoTaken(this.mNativeVideoCaptureDeviceAndroid, this, callbackId, null);
      }
    }
  }

  public static FramerateRange getClosestFramerateRange(
      List<FramerateRange> framerateRanges, final int targetFramerate) {
    return (FramerateRange)
        Collections.min(
            framerateRanges,
            new Comparator<FramerateRange>() {
              private static final int MAX_FPS_DIFF_THRESHOLD = 5000;
              private static final int MAX_FPS_HIGH_DIFF_WEIGHT = 3;
              private static final int MAX_FPS_LOW_DIFF_WEIGHT = 1;
              private static final int MIN_FPS_HIGH_VALUE_WEIGHT = 4;
              private static final int MIN_FPS_LOW_VALUE_WEIGHT = 1;
              private static final int MIN_FPS_THRESHOLD = 8000;

              private int progressivePenalty(
                  int value, int threshold, int lowWeight, int highWeight) {
                if (value < threshold) {
                  return value * lowWeight;
                }
                return (threshold * lowWeight) + ((value - threshold) * highWeight);
              }

              int diff(FramerateRange range) {
                int minFpsError = progressivePenalty(range.min, 8000, 1, 4);
                int maxFpsError =
                    progressivePenalty(
                        Math.abs(targetFramerate - range.max), MAX_FPS_DIFF_THRESHOLD, 1, 3);
                return minFpsError + maxFpsError;
              }

              @Override
              public int compare(FramerateRange range1, FramerateRange range2) {
                return diff(range1) - diff(range2);
              }
            });
  }

  public static int[] integerArrayListToArray(ArrayList<Integer> intArrayList) {
    int[] intArray = new int[intArrayList.size()];
    for (int i = 0; i < intArrayList.size(); i++) {
      intArray[i] = intArrayList.get(i).intValue();
    }
    return intArray;
  }

  public void onFrameAvailable(VideoCapture caller, byte[] data, int length, int rotation) {
    synchronized (this.mNativeVideoCaptureLock) {
      if (this.mNativeVideoCaptureDeviceAndroid != 0) {
        VideoCaptureJni.get()
            .onFrameAvailable(
                this.mNativeVideoCaptureDeviceAndroid, caller, data, length, rotation);
      }
    }
  }

  public void onI420FrameAvailable(
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
    synchronized (this.mNativeVideoCaptureLock) {
      if (this.mNativeVideoCaptureDeviceAndroid != 0) {
        VideoCaptureJni.get()
            .onI420FrameAvailable(
                this.mNativeVideoCaptureDeviceAndroid,
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
    }
  }

  public void onError(VideoCapture caller, int androidVideoCaptureError, String message) {
    synchronized (this.mNativeVideoCaptureLock) {
      if (this.mNativeVideoCaptureDeviceAndroid != 0) {
        VideoCaptureJni.get()
            .onError(
                this.mNativeVideoCaptureDeviceAndroid, caller, androidVideoCaptureError, message);
      }
    }
  }

  public void onFrameDropped(VideoCapture caller, int androidVideoCaptureFrameDropReason) {
    synchronized (this.mNativeVideoCaptureLock) {
      if (this.mNativeVideoCaptureDeviceAndroid != 0) {
        VideoCaptureJni.get()
            .onFrameDropped(
                this.mNativeVideoCaptureDeviceAndroid, caller, androidVideoCaptureFrameDropReason);
      }
    }
  }

  public void onGetPhotoCapabilitiesReply(
      VideoCapture caller, long callbackId, PhotoCapabilities result) {
    synchronized (this.mNativeVideoCaptureLock) {
      if (this.mNativeVideoCaptureDeviceAndroid != 0) {
        VideoCaptureJni.get()
            .onGetPhotoCapabilitiesReply(
                this.mNativeVideoCaptureDeviceAndroid, caller, callbackId, result);
      }
    }
  }

  public void onPhotoTaken(VideoCapture caller, long callbackId, byte[] data) {
    synchronized (this.mNativeVideoCaptureLock) {
      if (this.mNativeVideoCaptureDeviceAndroid != 0) {
        VideoCaptureJni.get()
            .onPhotoTaken(this.mNativeVideoCaptureDeviceAndroid, caller, callbackId, data);
      }
    }
  }

  public void onStarted(VideoCapture caller) {
    synchronized (this.mNativeVideoCaptureLock) {
      if (this.mNativeVideoCaptureDeviceAndroid != 0) {
        VideoCaptureJni.get().onStarted(this.mNativeVideoCaptureDeviceAndroid, caller);
      }
    }
  }

  public void dCheckCurrentlyOnIncomingTaskRunner(VideoCapture caller) {
    synchronized (this.mNativeVideoCaptureLock) {
      if (this.mNativeVideoCaptureDeviceAndroid != 0) {
        VideoCaptureJni.get()
            .dCheckCurrentlyOnIncomingTaskRunner(this.mNativeVideoCaptureDeviceAndroid, caller);
      }
    }
  }
}
