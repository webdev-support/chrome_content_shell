package org.chromium.base.shared_preferences;

public interface PreferenceKeyChecker {
  void checkIsKeyInUse(String str);

  void checkIsPrefixInUse(KeyPrefix keyPrefix);
}
