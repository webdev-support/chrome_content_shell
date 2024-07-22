package org.chromium.net;

import org.chromium.base.ApplicationStatus;

public class RegistrationPolicyApplicationStatus
    extends NetworkChangeNotifierAutoDetect.RegistrationPolicy
    implements ApplicationStatus.ApplicationStateListener {
  private boolean mDestroyed;

  @Override
  public void init(NetworkChangeNotifierAutoDetect notifier) {
    super.init(notifier);
    ApplicationStatus.registerApplicationStateListener(this);
    onApplicationStateChange(0);
  }

  @Override
  protected void destroy() {
    if (this.mDestroyed) {
      return;
    }
    ApplicationStatus.unregisterApplicationStateListener(this);
    this.mDestroyed = true;
  }

  @Override
  public void onApplicationStateChange(int newState) {
    if (ApplicationStatus.hasVisibleActivities()) {
      register();
    } else {
      unregister();
    }
  }
}
