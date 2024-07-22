package org.chromium.components.minidump_uploader;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.os.PersistableBundle;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.TimeUtils;

public abstract class MinidumpUploadJobService extends JobService
    implements MinidumpUploadJob.UploadsFinishedCallback {

  private static final int JOB_BACKOFF_POLICY = 1;
  private static final int JOB_INITIAL_BACKOFF_TIME_IN_MS = 1800000;
  private static final String TAG = "MinidumpJobService";
  private MinidumpUploadJob mActiveJob;
  private JobParameters mActiveJobParams;
  private long mActiveJobStartTime;
  private final Object mLock = new Object();
  private boolean mShouldReschedule;

  protected abstract MinidumpUploadJob createMinidumpUploadJob(PersistableBundle persistableBundle);

  public static void scheduleUpload(JobInfo.Builder jobInfoBuilder) {
    Log.i(TAG, "Scheduling upload of all pending minidumps.");
    JobScheduler scheduler =
        (JobScheduler) ContextUtils.getApplicationContext().getSystemService("jobscheduler");
    JobInfo uploadJob = jobInfoBuilder.setBackoffCriteria(1800000L, 1).build();
    int result = scheduler.schedule(uploadJob);
    if (result != 1) {
      throw new AssertionError();
    }
  }

  @Override // android.app.job.JobService
  public boolean onStartJob(JobParameters params) {
    synchronized (this.mLock) {
      boolean z = this.mActiveJob != null;
      this.mShouldReschedule = z;
      if (z) {
        if (params.getExtras().size() + this.mActiveJobParams.getExtras().size() >= 10000) {
          throw new AssertionError();
        }
        if (params.getExtras().toString().equals(this.mActiveJobParams.getExtras().toString())) {
          return false;
        }
        throw new AssertionError(
            params.getExtras().toString() + " vs " + this.mActiveJobParams.getExtras().toString());
      }
      this.mActiveJob = createMinidumpUploadJob(params.getExtras());
      this.mActiveJobParams = params;
      this.mActiveJobStartTime = TimeUtils.uptimeMillis();
      this.mActiveJob.uploadAllMinidumps(this);
      return true;
    }
  }

  @Override // android.app.job.JobService
  public boolean onStopJob(JobParameters params) {
    boolean reschedule;
    Log.i(TAG, "Canceling pending uploads due to change in networking status.");
    synchronized (this.mLock) {
      MinidumpUploadJob minidumpUploadJob = this.mActiveJob;
      reschedule =
          (minidumpUploadJob != null && minidumpUploadJob.cancelUploads())
              || this.mShouldReschedule;
    }
    return reschedule;
  }

  @Override
  public void uploadsFinished(boolean reschedule) {
    JobParameters jobParams;
    long startTime;
    boolean z;
    boolean reschedule2;
    if (reschedule) {
      Log.i(TAG, "Some minidumps remain un-uploaded; rescheduling.");
    }
    synchronized (this.mLock) {
      jobParams = this.mActiveJobParams;
      startTime = this.mActiveJobStartTime;
      if (!reschedule && !this.mShouldReschedule) {
        z = false;
        reschedule2 = z;
        this.mActiveJob = null;
        this.mActiveJobParams = null;
      }
      z = true;
      reschedule2 = z;
      this.mActiveJob = null;
      this.mActiveJobParams = null;
    }
    jobFinished(jobParams, reschedule2);
    recordMinidumpUploadingTime(TimeUtils.uptimeMillis() - startTime);
  }

  protected void recordMinidumpUploadingTime(long taskDurationMs) {}
}
