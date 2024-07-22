package org.chromium.components.minidump_uploader;

public interface MinidumpUploadJob {

  public interface UploadsFinishedCallback {
    void uploadsFinished(boolean z);
  }

  boolean cancelUploads();

  void uploadAllMinidumps(UploadsFinishedCallback uploadsFinishedCallback);
}
