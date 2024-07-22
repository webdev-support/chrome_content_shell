package org.chromium.ui.util;

import java.util.Iterator;
import org.chromium.base.ObserverList;
import org.chromium.base.ThreadUtils;
import org.chromium.ui.accessibility.AccessibilityState;

public class AccessibilityUtil implements AccessibilityState.Listener {
  private ObserverList<Observer> mObservers;

  @Deprecated
  public interface Observer {
    void onAccessibilityModeChanged(boolean z);
  }

  protected AccessibilityUtil() {}

  @Deprecated
  public void addObserver(Observer observer) {
    getObservers().addObserver(observer);
    observer.onAccessibilityModeChanged(AccessibilityState.isAccessibilityEnabled());
  }

  @Deprecated
  public void removeObserver(Observer observer) {
    getObservers().removeObserver(observer);
  }

  @Override
  public void onAccessibilityStateChanged(
      AccessibilityState.State oldAccessibilityState,
      AccessibilityState.State newAccessibilityState) {
    notifyModeChange(AccessibilityState.isAccessibilityEnabled());
  }

  private ObserverList<Observer> getObservers() {
    if (this.mObservers == null) {
      this.mObservers = new ObserverList<>();
    }
    return this.mObservers;
  }

  private void notifyModeChange(boolean isAccessibilityEnabled) {
    Iterator<Observer> it = getObservers().iterator();
    while (it.hasNext()) {
      Observer observer = it.next();
      observer.onAccessibilityModeChanged(isAccessibilityEnabled);
    }
  }

  public void setAccessibilityEnabledForTesting(Boolean isEnabled) {
    ThreadUtils.assertOnUiThread();
    notifyModeChange(Boolean.TRUE.equals(isEnabled));
  }
}
