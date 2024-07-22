package org.chromium.ui.animation;

import android.os.SystemClock;
import java.util.Iterator;
import org.chromium.base.ObserverList;

public class AnimationPerformanceTracker {

  private AnimationMetrics mCurrentAnimationMetrics;
  private final ObserverList<Listener> mListeners = new ObserverList<>();

  @FunctionalInterface
  public interface Listener {
    void onAnimationEnd(AnimationMetrics animationMetrics);
  }

  public static class AnimationMetrics {
    private long mElapsedTimeMs;
    private long mFirstFrameLatencyMs;
    private long mFirstFrameTimeMs;
    private int mFrameCount;
    private long mLastFrameTimeMs;
    private long mMaxFrameIntervalMs;
    private long mStartTimeMs;

    public long getStartTimeMs() {
      return this.mStartTimeMs;
    }

    public long getFirstFrameTimeMs() {
      return this.mFirstFrameTimeMs;
    }

    public long getFirstFrameLatencyMs() {
      return this.mFirstFrameLatencyMs;
    }

    public long getLastFrameTimeMs() {
      return this.mLastFrameTimeMs;
    }

    public long getMaxFrameIntervalMs() {
      return this.mMaxFrameIntervalMs;
    }

    public long getFrameCount() {
      return this.mFrameCount;
    }

    public long getElapsedTimeMs() {
      return this.mElapsedTimeMs;
    }

    public float getFramesPerSecond() {
      return (this.mFrameCount * 1000.0f) / ((float) this.mElapsedTimeMs);
    }

    private AnimationMetrics() {
      this.mStartTimeMs = SystemClock.elapsedRealtime();
      this.mLastFrameTimeMs = -1L;
      this.mFirstFrameTimeMs = -1L;
      this.mFirstFrameLatencyMs = -1L;
      this.mMaxFrameIntervalMs = -1L;
      this.mElapsedTimeMs = -1L;
    }

    public void onUpdate() {
      long currentTimeMs = SystemClock.elapsedRealtime();
      if (this.mFrameCount == 0) {
        long j = currentTimeMs - this.mStartTimeMs;
        this.mMaxFrameIntervalMs = j;
        this.mFirstFrameLatencyMs = j;
        this.mFirstFrameTimeMs = currentTimeMs;
      } else {
        this.mMaxFrameIntervalMs =
            Math.max(this.mMaxFrameIntervalMs, currentTimeMs - this.mLastFrameTimeMs);
      }
      this.mLastFrameTimeMs = currentTimeMs;
      this.mFrameCount++;
    }

    public void onEnd() {
      this.mElapsedTimeMs = SystemClock.elapsedRealtime() - this.mStartTimeMs;
    }
  }

  public void addListener(Listener listener) {
    this.mListeners.addObserver(listener);
  }

  public void removeListener(Listener listener) {
    this.mListeners.removeObserver(listener);
  }

  public void onStart() {
    if (this.mCurrentAnimationMetrics != null) {
      throw new AssertionError("Current animation has not finished.");
    }
    this.mCurrentAnimationMetrics = new AnimationMetrics();
  }

  public void onUpdate() {
    AnimationMetrics animationMetrics = this.mCurrentAnimationMetrics;
    if (animationMetrics == null) {
      throw new AssertionError("No animation was started.");
    }
    if (animationMetrics == null) {
      return;
    }
    animationMetrics.onUpdate();
  }

  public void onEnd() {
    AnimationMetrics animationMetrics = this.mCurrentAnimationMetrics;
    if (animationMetrics == null) {
      throw new AssertionError("No animation was started.");
    }
    if (animationMetrics == null) {
      return;
    }
    animationMetrics.onEnd();
    Iterator<Listener> it = this.mListeners.iterator();
    while (it.hasNext()) {
      Listener listener = it.next();
      listener.onAnimationEnd(this.mCurrentAnimationMetrics);
    }
    this.mCurrentAnimationMetrics = null;
  }
}
