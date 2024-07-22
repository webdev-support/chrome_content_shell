package org.chromium.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.ResettersForTesting;
import org.chromium.ui.interpolators.Interpolators;

public class LoadingView extends ProgressBar {
  private static final int LOADING_ANIMATION_DELAY_MS = 500;
  private static final int MINIMUM_ANIMATION_SHOW_TIME_MS = 500;
  private static boolean sDisableAnimationForTest;
  private final Runnable mDelayedHide;
  private final Runnable mDelayedShow;
  private final List<Observer> mObservers;
  private boolean mShouldShow;
  private long mStartTime;

  public interface Observer {
    void onHideLoadingUIComplete();

    void onShowLoadingUIComplete();
  }

  public LoadingView(Context context) {
    super(context);
    this.mStartTime = -1L;
    this.mObservers = new ArrayList();
    this.mDelayedShow =
        new Runnable() {
          @Override
          public void run() {
            if (LoadingView.this.mShouldShow) {
              LoadingView.this.mStartTime = SystemClock.elapsedRealtime();
              LoadingView.this.setVisibility(0);
              LoadingView.this.setAlpha(1.0f);
              for (Observer observer : LoadingView.this.mObservers) {
                observer.onShowLoadingUIComplete();
              }
            }
          }
        };
    this.mDelayedHide =
        new Runnable() {
          @Override
          public void run() {
            if (LoadingView.sDisableAnimationForTest) {
              LoadingView.this.onHideLoadingFinished();
            } else {
              LoadingView.this
                  .animate()
                  .alpha(0.0f)
                  .setInterpolator(Interpolators.FAST_OUT_SLOW_IN_INTERPOLATOR)
                  .setListener(
                      new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                          LoadingView.this.onHideLoadingFinished();
                        }
                      });
            }
          }
        };
  }

  public LoadingView(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.mStartTime = -1L;
    this.mObservers = new ArrayList();
    this.mDelayedShow =
        new Runnable() {
          @Override
          public void run() {
            if (LoadingView.this.mShouldShow) {
              LoadingView.this.mStartTime = SystemClock.elapsedRealtime();
              LoadingView.this.setVisibility(0);
              LoadingView.this.setAlpha(1.0f);
              for (Observer observer : LoadingView.this.mObservers) {
                observer.onShowLoadingUIComplete();
              }
            }
          }
        };
    this.mDelayedHide =
        new Runnable() {
          @Override
          public void run() {
            if (LoadingView.sDisableAnimationForTest) {
              LoadingView.this.onHideLoadingFinished();
            } else {
              LoadingView.this
                  .animate()
                  .alpha(0.0f)
                  .setInterpolator(Interpolators.FAST_OUT_SLOW_IN_INTERPOLATOR)
                  .setListener(
                      new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                          LoadingView.this.onHideLoadingFinished();
                        }
                      });
            }
          }
        };
  }

  public void showLoadingUI() {
    removeCallbacks(this.mDelayedShow);
    removeCallbacks(this.mDelayedHide);
    this.mShouldShow = true;
    setVisibility(8);
    postDelayed(this.mDelayedShow, 500L);
  }

  public void hideLoadingUI() {
    removeCallbacks(this.mDelayedShow);
    removeCallbacks(this.mDelayedHide);
    this.mShouldShow = false;
    if (getVisibility() == 0) {
      postDelayed(
          this.mDelayedHide, Math.max(0L, (this.mStartTime + 500) - SystemClock.elapsedRealtime()));
    } else {
      onHideLoadingFinished();
    }
  }

  public void destroy() {
    removeCallbacks(this.mDelayedShow);
    removeCallbacks(this.mDelayedHide);
    this.mObservers.clear();
  }

  public void addObserver(Observer listener) {
    this.mObservers.add(listener);
  }

  public void onHideLoadingFinished() {
    setVisibility(8);
    for (Observer observer : this.mObservers) {
      observer.onHideLoadingUIComplete();
    }
  }

  public static void setDisableAnimationForTest(boolean disableAnimation) {
    sDisableAnimationForTest = disableAnimation;
    ResettersForTesting.register(
        new Runnable() {
          @Override
          public final void run() {
            LoadingView.sDisableAnimationForTest = false;
          }
        });
  }

  public boolean isObserverListEmpty() {
    return this.mObservers.isEmpty();
  }
}
