package org.chromium.content.browser.device_posture;

import android.content.Context;
import android.os.Build;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import org.chromium.base.ObserverList;
import org.chromium.base.UnownedUserData;
import org.chromium.base.UnownedUserDataHost;
import org.chromium.base.UnownedUserDataKey;
import org.chromium.content_public.browser.ContentFeatureMap;
import org.chromium.content_public.common.ContentFeatures;
import org.chromium.ui.base.WindowAndroid;
import org.chromium.window.WindowUtil;

public class WindowLayoutInfoListener implements UnownedUserData {

  private static final UnownedUserDataKey<WindowLayoutInfoListener> KEY =
      new UnownedUserDataKey<>(WindowLayoutInfoListener.class);
  private WindowLayoutInfo mCurrentWindowLayoutInfo;
  private ObserverList<DevicePosturePlatformProviderAndroid> mObservers = new ObserverList<>();
  private WindowAndroid mWindowAndroid;
  private final Consumer<WindowLayoutInfo> mWindowLayoutInfoChangedCallback;

  private WindowLayoutInfoListener(WindowAndroid window) {
    if (window == null) {
      throw new AssertionError();
    }
    this.mWindowLayoutInfoChangedCallback =
        new Consumer() {
          public final void accept(Object obj) {
            WindowLayoutInfoListener.this.onWindowLayoutInfoChanged((WindowLayoutInfo) obj);
          }
        };
    this.mWindowAndroid = window;
  }

  public void onWindowLayoutInfoChanged(WindowLayoutInfo windowLayoutInfo) {
    this.mCurrentWindowLayoutInfo = windowLayoutInfo;
    Iterator<DevicePosturePlatformProviderAndroid> it = this.mObservers.iterator();
    while (it.hasNext()) {
      DevicePosturePlatformProviderAndroid observer = it.next();
      observer.onWindowLayoutInfoChanged(this.mCurrentWindowLayoutInfo);
    }
  }

  @Override
  public void onDetachedFromHost(UnownedUserDataHost host) {
    this.mWindowAndroid = null;
    WindowUtil.removeWindowLayoutInfoListener(this.mWindowLayoutInfoChangedCallback);
  }

  public void addObserver(DevicePosturePlatformProviderAndroid observer) {
    if (this.mObservers.hasObserver(observer)) {
      throw new AssertionError();
    }
    Context context = this.mWindowAndroid.getContext().get();
    if (this.mObservers.isEmpty() && context != null) {
      WindowUtil.addWindowLayoutInfoListener(context, this.mWindowLayoutInfoChangedCallback);
    }
    this.mObservers.addObserver(observer);
    WindowLayoutInfo windowLayoutInfo = this.mCurrentWindowLayoutInfo;
    if (windowLayoutInfo != null) {
      observer.onWindowLayoutInfoChanged(windowLayoutInfo);
    }
  }

  public void removeObserver(DevicePosturePlatformProviderAndroid observer) {
    if (!this.mObservers.hasObserver(observer)) {
      throw new AssertionError();
    }
    this.mObservers.removeObserver(observer);
    if (this.mObservers.isEmpty()) {
      WindowUtil.removeWindowLayoutInfoListener(this.mWindowLayoutInfoChangedCallback);
      this.mCurrentWindowLayoutInfo = null;
    }
  }

  public static WindowLayoutInfoListener getWindowLayoutListenerForWindow(WindowAndroid window) {
    Context context;
    if (Build.VERSION.SDK_INT < 33
        || !ContentFeatureMap.isEnabled(ContentFeatures.DEVICE_POSTURE)
        || !WindowUtil.isAvailable()
        || window == null
        || (context = window.getContext().get()) == null
        || !context.isUiContext()) {
      return null;
    }
    UnownedUserDataKey<WindowLayoutInfoListener> unownedUserDataKey = KEY;
    WindowLayoutInfoListener listener =
        unownedUserDataKey.retrieveDataFromHost(window.getUnownedUserDataHost());
    if (listener == null) {
      WindowLayoutInfoListener listener2 = new WindowLayoutInfoListener(window);
      unownedUserDataKey.attachToHost(window.getUnownedUserDataHost(), listener2);
      return listener2;
    }
    return listener;
  }
}
