package org.chromium.base.metrics;

public class UmaRecorderHolder {

  private static boolean sNativeInitialized;
  private static CachingUmaRecorder sRecorder = new CachingUmaRecorder();
  private static boolean sSetUpNativeUmaRecorder = true;

  private UmaRecorderHolder() {}

  public static UmaRecorder get() {
    return sRecorder;
  }

  public static void setNonNativeDelegate(UmaRecorder recorder) {
    UmaRecorder previous = sRecorder.setDelegate(recorder);
    if (previous instanceof NativeUmaRecorder) {
      throw new AssertionError("A NativeUmaRecorder has already been set");
    }
  }

  public static void setUpNativeUmaRecorder(boolean setUpNativeUmaRecorder) {
    sSetUpNativeUmaRecorder = setUpNativeUmaRecorder;
  }

  public static void onLibraryLoaded() {
    if (sSetUpNativeUmaRecorder) {
      if (sNativeInitialized) {
        throw new AssertionError();
      }
      sNativeInitialized = true;
      sRecorder.setDelegate(new NativeUmaRecorder());
    }
  }

  public static void resetForTesting() {
    if (!sNativeInitialized) {
      sRecorder = new CachingUmaRecorder();
    }
  }
}
