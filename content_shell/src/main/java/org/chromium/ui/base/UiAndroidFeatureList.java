package org.chromium.ui.base;

import org.chromium.base.MutableFlagWithSafeDefault;

public class UiAndroidFeatureList {
  public static final MutableFlagWithSafeDefault sRequireLeadingInTextViewWithLeading =
      newMutableFlagWithSafeDefault(
          UiAndroidFeatures.REQUIRE_LEADING_IN_TEXT_VIEW_WITH_LEADING, false);

  private static MutableFlagWithSafeDefault newMutableFlagWithSafeDefault(
      String featureName, boolean defaultValue) {
    return UiAndroidFeatureMap.getInstance().mutableFlagWithSafeDefault(featureName, defaultValue);
  }
}
