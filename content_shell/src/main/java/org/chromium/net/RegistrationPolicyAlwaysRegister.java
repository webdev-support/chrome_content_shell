package org.chromium.net;

public class RegistrationPolicyAlwaysRegister
    extends NetworkChangeNotifierAutoDetect.RegistrationPolicy {

  @Override
  public void init(NetworkChangeNotifierAutoDetect notifier) {
    super.init(notifier);
    register();
  }

  @Override
  protected void destroy() {}
}
