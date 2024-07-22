package org.chromium.content_public.browser;

import org.chromium.content.browser.ChildProcessCreationParamsImpl;

public final class ChildProcessCreationParams {
  public static void set(
      String privilegedPackageName,
      String privilegedServicesName,
      String sandboxedPackageName,
      String sandboxedServicesName,
      boolean isExternalSandboxedService,
      int libraryProcessType,
      boolean bindToCallerCheck,
      boolean ignoreVisibilityForImportance) {
    ChildProcessCreationParamsImpl.set(
        privilegedPackageName,
        privilegedServicesName,
        sandboxedPackageName,
        sandboxedServicesName,
        isExternalSandboxedService,
        libraryProcessType,
        bindToCallerCheck,
        ignoreVisibilityForImportance);
  }
}
