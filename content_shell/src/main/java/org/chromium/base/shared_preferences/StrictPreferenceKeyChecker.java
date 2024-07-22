package org.chromium.base.shared_preferences;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.regex.Pattern;

class StrictPreferenceKeyChecker implements PreferenceKeyChecker {
  private static final Pattern DYNAMIC_PART_PATTERN = Pattern.compile("[^\\*]+");
  private final PreferenceKeyRegistry mRegistry;

  public StrictPreferenceKeyChecker(PreferenceKeyRegistry registry) {
    this.mRegistry = registry;
  }

  @Override
  public void checkIsKeyInUse(String key) {
    if (!isKeyInUse(key)) {
      throw new RuntimeException(
          "SharedPreferences key \""
              + key
              + "\" is not registered in PreferenceKeyRegistry.mKeysInUse");
    }
    KnownPreferenceKeyRegistries.onRegistryUsed(this.mRegistry);
  }

  private boolean isKeyInUse(String key) {
    if (this.mRegistry.mLegacyFormatKeys.contains(key)) {
      return true;
    }
    for (KeyPrefix prefix : this.mRegistry.mLegacyPrefixes) {
      if (prefix.hasGenerated(key)) {
        return true;
      }
    }
    String[] parts = key.split("\\.", 4);
    if (parts.length < 3) {
      return false;
    }
    boolean isPrefixed = parts.length >= 4;
    if (isPrefixed) {
      String prefixFormat = TextUtils.join(".", Arrays.asList(parts[0], parts[1], parts[2], "*"));
      if (this.mRegistry.mKeysInUse.contains(prefixFormat)) {
        String dynamicPart = parts[3];
        return DYNAMIC_PART_PATTERN.matcher(dynamicPart).matches();
      }
      return false;
    }
    return this.mRegistry.mKeysInUse.contains(key);
  }

  @Override
  public void checkIsPrefixInUse(KeyPrefix prefix) {
    if (this.mRegistry.mLegacyPrefixes.contains(prefix)
        || this.mRegistry.mKeysInUse.contains(prefix.pattern())) {
      return;
    }
    throw new RuntimeException(
        "SharedPreferences KeyPrefix \""
            + prefix.pattern()
            + "\" is not registered in PreferenceKeyRegistry.mKeysInUse()");
  }
}
