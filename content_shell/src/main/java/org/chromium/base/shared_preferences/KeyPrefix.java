package org.chromium.base.shared_preferences;

public class KeyPrefix {

  private final String mPrefix;

  public KeyPrefix(String pattern) {
    if (!pattern.endsWith("*")) {
      throw new AssertionError();
    }
    this.mPrefix = pattern.substring(0, pattern.length() - 1);
  }

  public String createKey(String stem) {
    return this.mPrefix + stem;
  }

  public String createKey(int index) {
    return this.mPrefix + index;
  }

  public String pattern() {
    return this.mPrefix + "*";
  }

  public boolean hasGenerated(String key) {
    return key.startsWith(this.mPrefix);
  }
}
