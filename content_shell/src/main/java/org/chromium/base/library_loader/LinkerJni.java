package org.chromium.base.library_loader;

class LinkerJni implements Linker.Natives {
  private static native void nativeFindMemoryRegionAtRandomAddress(Linker.LibInfo libInfo);

  private static native boolean nativeFindRegionReservedByWebViewZygote(Linker.LibInfo libInfo);

  private static native int nativeGetRelroSharingResult();

  private static native boolean nativeLoadLibrary(String str, Linker.LibInfo libInfo, boolean z);

  private static native void nativeReserveMemoryForLibrary(Linker.LibInfo libInfo);

  private static native boolean nativeUseRelros(long j, Linker.LibInfo libInfo);

  @Override
  public void findMemoryRegionAtRandomAddress(Linker.LibInfo libInfo) {
    nativeFindMemoryRegionAtRandomAddress(libInfo);
  }

  @Override
  public void reserveMemoryForLibrary(Linker.LibInfo libInfo) {
    nativeReserveMemoryForLibrary(libInfo);
  }

  @Override
  public boolean findRegionReservedByWebViewZygote(Linker.LibInfo libInfo) {
    return nativeFindRegionReservedByWebViewZygote(libInfo);
  }

  @Override
  public boolean loadLibrary(String libFilePath, Linker.LibInfo libInfo, boolean spawnRelroRegion) {
    return nativeLoadLibrary(libFilePath, libInfo, spawnRelroRegion);
  }

  @Override
  public boolean useRelros(long localLoadAddress, Linker.LibInfo remoteLibInfo) {
    return nativeUseRelros(localLoadAddress, remoteLibInfo);
  }

  @Override
  public int getRelroSharingResult() {
    return nativeGetRelroSharingResult();
  }
}
