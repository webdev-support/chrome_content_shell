package org.chromium.base.shared_preferences;

class NoOpPreferenceKeyChecker implements PreferenceKeyChecker {
  @Override
  public void checkIsKeyInUse(String key) {}

  @Override
  public void checkIsPrefixInUse(KeyPrefix prefix) {}
}
