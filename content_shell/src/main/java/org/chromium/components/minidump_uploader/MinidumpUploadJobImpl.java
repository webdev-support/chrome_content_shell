package org.chromium.components.minidump_uploader;

import java.io.File;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.task.PostTask;

public class MinidumpUploadJobImpl implements MinidumpUploadJob {

  public static final int MAX_UPLOAD_TRIES_ALLOWED = 3;
  private static final String TAG = "MDUploadJobImpl";
  private volatile boolean mCancelUpload;
  protected final MinidumpUploaderDelegate mDelegate;
  private boolean mIsActive;

  public MinidumpUploadJobImpl(MinidumpUploaderDelegate delegate) {
    this.mDelegate = delegate;
  }

  public CrashFileManager createCrashFileManager(File crashParentDir) {
    return new CrashFileManager(crashParentDir);
  }

  public MinidumpUploadCallable createMinidumpUploadCallable(File minidumpFile, File logfile) {
    return new MinidumpUploadCallable(
        minidumpFile, logfile, this.mDelegate.createCrashReportingPermissionManager());
  }

  private class UploadRunnable implements Runnable {
    private final UploadsFinishedCallback mUploadsFinishedCallback;

    public UploadRunnable(UploadsFinishedCallback uploadsFinishedCallback) {
      this.mUploadsFinishedCallback = uploadsFinishedCallback;
    }

    private void invokeCallback(boolean reschedule) {
      MinidumpUploadJobImpl.this.mIsActive = false;
      this.mUploadsFinishedCallback.uploadsFinished(reschedule);
    }

    @Override
    public void run() {
      File crashParentDir = MinidumpUploadJobImpl.this.mDelegate.getCrashParentDir();
      if (!crashParentDir.isDirectory()) {
        Log.e(MinidumpUploadJobImpl.TAG, "Parent crash directory doesn't exist!");
        invokeCallback(false);
        return;
      }
      CrashFileManager fileManager =
          MinidumpUploadJobImpl.this.createCrashFileManager(crashParentDir);
      if (!fileManager.crashDirectoryExists()) {
        Log.e(MinidumpUploadJobImpl.TAG, "Crash directory doesn't exist!");
        invokeCallback(false);
        return;
      }
      File[] minidumps = fileManager.getMinidumpsReadyForUpload(3);
      Log.i(
          MinidumpUploadJobImpl.TAG,
          "Attempting to upload %d minidumps.",
          Integer.valueOf(minidumps.length));
      for (File minidump : minidumps) {
        Log.i(MinidumpUploadJobImpl.TAG, "Attempting to upload " + minidump.getName());
        MinidumpUploadCallable uploadCallable =
            MinidumpUploadJobImpl.this.createMinidumpUploadCallable(
                minidump, fileManager.getCrashUploadLogFile());
        int uploadResult = uploadCallable.call().intValue();
        if (uploadResult == 0) {
          MinidumpUploadJobImpl.this.mDelegate.recordUploadSuccess(minidump);
        } else if (uploadResult == 1) {
          int numFailures = CrashFileManager.readAttemptNumber(minidump.getName()) + 1;
          if (numFailures == 3) {
            MinidumpUploadJobImpl.this.mDelegate.recordUploadFailure(minidump);
          }
        }
        if (MinidumpUploadJobImpl.this.mCancelUpload) {
          MinidumpUploadJobImpl.this.mIsActive = false;
          return;
        }
        if (uploadResult == 1) {
          String newName = CrashFileManager.tryIncrementAttemptNumber(minidump);
          if (newName == null) {
            Log.w(MinidumpUploadJobImpl.TAG, "Failed to increment attempt number of " + minidump);
          }
        }
      }
      fileManager.cleanOutAllNonFreshMinidumpFiles();
      boolean reschedule = fileManager.getMinidumpsReadyForUpload(3).length > 0;
      invokeCallback(reschedule);
    }
  }

  @Override
  public void uploadAllMinidumps(final UploadsFinishedCallback uploadsFinishedCallback) {
    ThreadUtils.assertOnUiThread();
    if (this.mIsActive) {
      throw new AssertionError();
    }
    this.mCancelUpload = false;
    this.mIsActive = true;
    this.mDelegate.prepareToUploadMinidumps(
        new Runnable() {
          @Override
          public void run() {
            ThreadUtils.assertOnUiThread();
            PostTask.postTask(1, new UploadRunnable(uploadsFinishedCallback));
          }
        });
  }

  @Override
  public boolean cancelUploads() {
    this.mCancelUpload = true;
    return true;
  }
}
