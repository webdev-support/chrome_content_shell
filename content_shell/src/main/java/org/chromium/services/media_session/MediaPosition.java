package org.chromium.services.media_session;

import android.os.SystemClock;
import org.jni_zero.JNINamespace;

@JNINamespace("media_session")
public final class MediaPosition {
  private Long mDuration;
  private Long mLastUpdatedTime;
  private Float mPlaybackRate;
  private Long mPosition;

  public MediaPosition(long duration, long position, float playbackRate, long lastUpdatedTime) {
    this.mDuration = Long.valueOf(duration);
    this.mPosition = Long.valueOf(position);
    this.mPlaybackRate = Float.valueOf(playbackRate);
    this.mLastUpdatedTime = Long.valueOf(lastUpdatedTime);
  }

  public long getDuration() {
    return this.mDuration.longValue();
  }

  public long getPosition() {
    return this.mPosition.longValue();
  }

  public float getPlaybackRate() {
    return this.mPlaybackRate.floatValue();
  }

  public long getLastUpdatedTime() {
    return this.mLastUpdatedTime.longValue();
  }

  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj instanceof MediaPosition) {
      MediaPosition other = (MediaPosition) obj;
      return this.mDuration.longValue() == other.getDuration()
          && this.mPosition.longValue() == other.getPosition()
          && this.mPlaybackRate.floatValue() == other.getPlaybackRate()
          && this.mLastUpdatedTime.longValue() == other.getLastUpdatedTime();
    }
    return false;
  }

  public int hashCode() {
    int result = this.mDuration.hashCode();
    return (((((result * 31) + this.mPosition.hashCode()) * 31) + this.mPlaybackRate.hashCode())
            * 31)
        + this.mLastUpdatedTime.hashCode();
  }

  public String toString() {
    Long l = this.mDuration;
    Long l2 = this.mPosition;
    Float f = this.mPlaybackRate;
    return "duration="
        + l
        + ", position="
        + l2
        + ", rate="
        + f
        + ", updated="
        + this.mLastUpdatedTime;
  }

  private static MediaPosition create(
      long duration, long position, float playbackRate, long lastUpdatedTime) {
    long currentTime = System.currentTimeMillis();
    long elapsedRealtime = SystemClock.elapsedRealtime();
    long j = currentTime - elapsedRealtime;
    return new MediaPosition(
        duration, position, playbackRate, lastUpdatedTime - (currentTime - elapsedRealtime));
  }
}
