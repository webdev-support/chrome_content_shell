package org.chromium.content.browser.accessibility;

import android.view.View;

public class AutoDisableAccessibilityHandler {
  private final Client mClient;
  private boolean mHasPendingTimer;
  private final Runnable mRunnable =
      new Runnable() {
        @Override
        public final void run() {
          AutoDisableAccessibilityHandler.this.notifyDisable();
        }
      };

  interface Client {
    View getView();

    void onDisabled();
  }

  public AutoDisableAccessibilityHandler(Client client) {
    this.mClient = client;
  }

  public void startDisableTimer(int duration) {
    if (this.mHasPendingTimer) {
      return;
    }
    this.mClient.getView().postDelayed(this.mRunnable, duration);
    this.mHasPendingTimer = true;
  }

  public void cancelDisableTimer() {
    if (this.mHasPendingTimer) {
      this.mClient.getView().removeCallbacks(this.mRunnable);
      this.mHasPendingTimer = false;
    }
  }

  public void notifyDisable() {
    this.mClient.onDisabled();
    this.mHasPendingTimer = false;
  }

  public boolean hasPendingTimer() {
    return this.mHasPendingTimer;
  }
}
