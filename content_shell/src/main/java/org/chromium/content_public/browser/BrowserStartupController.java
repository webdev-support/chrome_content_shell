package org.chromium.content_public.browser;

import org.chromium.content.browser.BrowserStartupControllerImpl;

public interface BrowserStartupController {

  public interface StartupCallback {
    void onFailure();

    void onSuccess();
  }

  void addStartupCompletedObserver(StartupCallback startupCallback);

  int getStartupMode(boolean z);

  boolean isFullBrowserStarted();

  boolean isNativeStarted();

  boolean isRunningInMinimalBrowserMode();

  void setContentMainCallbackForTests(Runnable runnable);

  void startBrowserProcessesAsync(int i, boolean z, boolean z2, StartupCallback startupCallback);

  void startBrowserProcessesSync(int i, boolean z, boolean z2);

  static BrowserStartupController getInstance() {
    return BrowserStartupControllerImpl.getInstance();
  }
}
