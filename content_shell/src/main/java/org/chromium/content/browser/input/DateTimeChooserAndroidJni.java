package org.chromium.content.browser.input;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class DateTimeChooserAndroidJni implements DateTimeChooserAndroid.Natives {

  public static final JniStaticTestMocker<DateTimeChooserAndroid.Natives> TEST_HOOKS =
      new JniStaticTestMocker<DateTimeChooserAndroid.Natives>() {
        @Override
        public void setInstanceForTesting(DateTimeChooserAndroid.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          DateTimeChooserAndroidJni.testInstance = instance;
        }
      };
  private static DateTimeChooserAndroid.Natives testInstance;

  DateTimeChooserAndroidJni() {}

  @Override
  public void cancelDialog(long nativeDateTimeChooserAndroid, DateTimeChooserAndroid caller) {
    if (nativeDateTimeChooserAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_DateTimeChooserAndroid_cancelDialog(
        nativeDateTimeChooserAndroid, caller);
  }

  @Override
  public void replaceDateTime(
      long nativeDateTimeChooserAndroid, DateTimeChooserAndroid caller, double dialogValue) {
    if (nativeDateTimeChooserAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_DateTimeChooserAndroid_replaceDateTime(
        nativeDateTimeChooserAndroid, caller, dialogValue);
  }

  public static DateTimeChooserAndroid.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      DateTimeChooserAndroid.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of DateTimeChooserAndroid.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new DateTimeChooserAndroidJni();
  }
}
