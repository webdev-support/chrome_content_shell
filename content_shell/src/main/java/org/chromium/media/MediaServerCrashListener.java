package org.chromium.media;

import android.media.MediaPlayer;
import android.os.SystemClock;
import com.example.chromium_content_view.R;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.jni_zero.JNINamespace;

@JNINamespace("media")
public class MediaServerCrashListener implements MediaPlayer.OnErrorListener {
  private static final int APPROX_MEDIA_SERVER_RESTART_TIME_IN_MS = 5000;
  private static final String TAG = "crMediaCrashListener";
  private static final long UNKNOWN_TIME = -1;
  private long mNativeMediaServerCrashListener;
  private MediaPlayer mPlayer;
  private final Object mLock = new Object();
  private long mLastReportedWatchdogCreationFailure = -1;

  public interface Natives {
    void onMediaServerCrashDetected(
        long j, MediaServerCrashListener mediaServerCrashListener, boolean z);
  }

  private static MediaServerCrashListener create(long nativeMediaServerCrashListener) {
    return new MediaServerCrashListener(nativeMediaServerCrashListener);
  }

  private MediaServerCrashListener(long nativeMediaServerCrashListener) {
    this.mNativeMediaServerCrashListener = nativeMediaServerCrashListener;
  }

  public void releaseWatchdog() {
    MediaPlayer mediaPlayer = this.mPlayer;
    if (mediaPlayer == null) {
      return;
    }
    mediaPlayer.release();
    this.mPlayer = null;
  }

  public boolean startListening() {
    if (this.mPlayer != null) {
      return true;
    }
    try {
      this.mPlayer = MediaPlayer.create(ContextUtils.getApplicationContext(), R.raw.empty);
    } catch (IllegalStateException e) {
      Log.e(TAG, "Exception while creating the watchdog player.", (Throwable) e);
    } catch (RuntimeException e2) {
      Log.e(TAG, "Exception while creating the watchdog player.", (Throwable) e2);
    }
    MediaPlayer mediaPlayer = this.mPlayer;
    if (mediaPlayer != null) {
      mediaPlayer.setOnErrorListener(this);
      this.mLastReportedWatchdogCreationFailure = -1L;
      return true;
    }
    long currentTime = SystemClock.elapsedRealtime();
    long j = this.mLastReportedWatchdogCreationFailure;
    if (j == -1 || currentTime - j > 5000) {
      Log.e(TAG, "Unable to create watchdog player, treating it as server crash.");
      MediaServerCrashListenerJni.get()
          .onMediaServerCrashDetected(this.mNativeMediaServerCrashListener, this, false);
      this.mLastReportedWatchdogCreationFailure = currentTime;
    }
    return false;
  }

  @Override // android.media.MediaPlayer.OnErrorListener
  public boolean onError(MediaPlayer mp, int what, int extra) {
    if (what == 100) {
      MediaServerCrashListenerJni.get()
          .onMediaServerCrashDetected(this.mNativeMediaServerCrashListener, this, true);
      releaseWatchdog();
    }
    return true;
  }
}
