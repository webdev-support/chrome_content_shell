package org.chromium.content_public.browser;

public abstract class GestureStateListener {
  public void onPinchStarted() {}

  public void onPinchEnded() {}

  public void onFlingStartGesture(int scrollOffsetY, int scrollExtentY, boolean isDirectionUp) {}

  public void onFlingEndGesture(int scrollOffsetY, int scrollExtentY) {}

  public void onScrollUpdateGestureConsumed() {}

  public void onScrollStarted(int scrollOffsetY, int scrollExtentY, boolean isDirectionUp) {}

  public void onVerticalScrollDirectionChanged(boolean directionUp, float currentScrollRatio) {}

  public void onScrollEnded(int scrollOffsetY, int scrollExtentY) {}

  public void onScaleLimitsChanged(float minPageScaleFactor, float maxPageScaleFactor) {}

  public void onTouchDown() {}

  public void onSingleTap(boolean consumed) {}

  public void onWindowFocusChanged(boolean hasWindowFocus) {}

  public void onScrollOffsetOrExtentChanged(int scrollOffsetY, int scrollExtentY) {}

  public void onDestroyed() {}
}
