package org.chromium.components.minidump_uploader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
import java.util.concurrent.Callable;
import org.chromium.base.Log;
import org.chromium.components.minidump_uploader.util.CrashReportingPermissionManager;

public class MinidumpUploadCallable implements Callable<Integer> {
  private static final String TAG = "MDUploadCallable";
  private final File mFileToUpload;
  private final File mLogfile;
  private final MinidumpUploader mMinidumpUploader;
  private final CrashReportingPermissionManager mPermManager;

  @Retention(RetentionPolicy.SOURCE)
  public @interface MinidumpUploadStatus {
    public static final int DISABLED_BY_SAMPLING = 3;
    public static final int FAILURE = 1;
    public static final int SUCCESS = 0;
    public static final int USER_DISABLED = 2;
  }

  public MinidumpUploadCallable(
      File fileToUpload, File logfile, CrashReportingPermissionManager permissionManager) {
    this(fileToUpload, logfile, new MinidumpUploader(), permissionManager);
  }

  public MinidumpUploadCallable(
      File fileToUpload,
      File logfile,
      MinidumpUploader minidumpUploader,
      CrashReportingPermissionManager permissionManager) {
    this.mFileToUpload = fileToUpload;
    this.mLogfile = logfile;
    this.mMinidumpUploader = minidumpUploader;
    this.mPermManager = permissionManager;
  }

  @Override   public Integer call() {
    if (this.mPermManager.isUploadEnabledForTests()) {
      Log.i(TAG, "Minidump upload enabled for tests, skipping other checks.");
    } else if (!CrashFileManager.isForcedUpload(this.mFileToUpload)) {
      if (!this.mPermManager.isUsageAndCrashReportingPermitted()) {
        Log.i(
            TAG,
            "Minidump upload is not permitted. Marking file as skipped for cleanup to prevent future uploads.");
        CrashFileManager.markUploadSkipped(this.mFileToUpload);
        return 2;
      } else if (!this.mPermManager.isClientInMetricsSample()) {
        Log.i(
            TAG,
            "Minidump upload skipped due to sampling.  Marking file as skipped for cleanup to prevent future uploads.");
        CrashFileManager.markUploadSkipped(this.mFileToUpload);
        return 3;
      } else if (!this.mPermManager.isNetworkAvailableForCrashUploads()) {
        Log.i(TAG, "Minidump cannot currently be uploaded due to network constraints.");
        return 1;
      }
    }
    MinidumpUploader.Result result = this.mMinidumpUploader.upload(this.mFileToUpload);
    if (result.isSuccess()) {
      String uploadId = result.message();
      String crashFileName = this.mFileToUpload.getName();
      Log.i(TAG, "Minidump " + crashFileName + " uploaded successfully, id: " + uploadId);
      Log.e(TAG, "Crash with id: " + uploadId + " uploaded successfully.");
      CrashFileManager.markUploadSuccess(this.mFileToUpload);
      try {
        String localId = CrashFileManager.getCrashLocalIdFromFileName(crashFileName);
        appendUploadedEntryToLog(localId, uploadId);
      } catch (IOException e) {
        Log.e(TAG, "Fail to write uploaded entry to log file");
      }
      return 0;
    }
    if (result.isUploadError()) {
      String msg =
          String.format(
              Locale.US,
              "Failed to upload %s with code: %d (%s).",
              this.mFileToUpload.getName(),
              Integer.valueOf(result.errorCode()),
              result.message());
      Log.i(TAG, msg);
    } else {
      String name = this.mFileToUpload.getName();
      Log.e(TAG, "Local error while uploading " + name + ": " + result.message());
    }
    return 1;
  }

  private void appendUploadedEntryToLog(String localId, String uploadId) throws IOException {
    FileWriter writer = new FileWriter(this.mLogfile, true);
    StringBuilder sb = new StringBuilder();
    sb.append(System.currentTimeMillis() / 1000);
    sb.append(",");
    sb.append(uploadId);
    if (localId != null) {
      sb.append(",");
      sb.append(localId);
    }
    sb.append('\n');
    try {
      writer.write(sb.toString());
    } finally {
      writer.close();
    }
  }
}
