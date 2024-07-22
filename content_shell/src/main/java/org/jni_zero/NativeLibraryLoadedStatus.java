package org.jni_zero;

public class NativeLibraryLoadedStatus {
  private static NativeLibraryLoadedStatusProvider sProvider;

  public interface NativeLibraryLoadedStatusProvider {
    boolean areNativeMethodsReady();
  }

  public static class NativeNotLoadedException extends RuntimeException {
    public NativeNotLoadedException(String s) {
      super(s);
    }
  }

  public static void checkLoaded() {
    NativeLibraryLoadedStatusProvider nativeLibraryLoadedStatusProvider = sProvider;
    if (nativeLibraryLoadedStatusProvider != null
        && !nativeLibraryLoadedStatusProvider.areNativeMethodsReady()) {
      throw new NativeNotLoadedException(
          "Native method called before the native library was ready.");
    }
  }

  public static void setProvider(NativeLibraryLoadedStatusProvider statusProvider) {
    sProvider = statusProvider;
  }

  public static NativeLibraryLoadedStatusProvider getProviderForTesting() {
    return sProvider;
  }
}
