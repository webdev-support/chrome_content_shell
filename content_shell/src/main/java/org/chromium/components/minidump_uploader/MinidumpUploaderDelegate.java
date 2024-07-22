package org.chromium.components.minidump_uploader;

import java.io.File;
import org.chromium.components.minidump_uploader.util.CrashReportingPermissionManager;

public interface MinidumpUploaderDelegate {
  CrashReportingPermissionManager createCrashReportingPermissionManager();

  File getCrashParentDir();

  void prepareToUploadMinidumps(Runnable runnable);

  void recordUploadFailure(File file);

  void recordUploadSuccess(File file);
}
