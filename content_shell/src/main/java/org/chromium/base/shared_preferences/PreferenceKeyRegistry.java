package org.chromium.base.shared_preferences;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class PreferenceKeyRegistry {
  public final HashSet<String> mKeysInUse;
  public final HashSet<String> mLegacyFormatKeys;
  public final List<KeyPrefix> mLegacyPrefixes;
  private final String mModule;

  public PreferenceKeyRegistry(
      String module,
      List<String> keysInUse,
      List<String> legacyKeys,
      List<KeyPrefix> legacyPrefixes) {
    this.mModule = module;
    this.mKeysInUse = new HashSet<>(keysInUse);
    this.mLegacyFormatKeys = new HashSet<>(legacyKeys);
    this.mLegacyPrefixes = legacyPrefixes;
  }

  public String toDebugString() {
    return String.format(
        Locale.getDefault(),
        "%s (%d in use, %d legacy, %d legacy prefixes)",
        this.mModule,
        Integer.valueOf(this.mKeysInUse.size()),
        Integer.valueOf(this.mLegacyFormatKeys.size()),
        Integer.valueOf(this.mLegacyPrefixes.size()));
  }
}
