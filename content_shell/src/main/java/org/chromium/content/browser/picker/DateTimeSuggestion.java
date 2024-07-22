package org.chromium.content.browser.picker;

import android.text.TextUtils;

public class DateTimeSuggestion {
  private final String mLabel;
  private final String mLocalizedValue;
  private final double mValue;

  public DateTimeSuggestion(double value, String localizedValue, String label) {
    this.mValue = value;
    this.mLocalizedValue = localizedValue;
    this.mLabel = label;
  }

  public double value() {
    return this.mValue;
  }

  public String localizedValue() {
    return this.mLocalizedValue;
  }

  public String label() {
    return this.mLabel;
  }

  public boolean equals(Object object) {
    if (object instanceof DateTimeSuggestion) {
      DateTimeSuggestion other = (DateTimeSuggestion) object;
      return this.mValue == other.mValue
          && TextUtils.equals(this.mLocalizedValue, other.mLocalizedValue)
          && TextUtils.equals(this.mLabel, other.mLabel);
    }
    return false;
  }

  public int hashCode() {
    int hash = (31 * 37) + ((int) this.mValue);
    return (((hash * 37) + this.mLocalizedValue.hashCode()) * 37) + this.mLabel.hashCode();
  }
}
