package org.chromium.content.browser.input;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class SelectPopupJni implements SelectPopup.Natives {

  public static final JniStaticTestMocker<SelectPopup.Natives> TEST_HOOKS =
      new JniStaticTestMocker<SelectPopup.Natives>() {
        @Override
        public void setInstanceForTesting(SelectPopup.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          SelectPopupJni.testInstance = instance;
        }
      };
  private static SelectPopup.Natives testInstance;

  SelectPopupJni() {}

  @Override
  public void selectMenuItems(
      long nativeSelectPopup,
      SelectPopup caller,
      long nativeSelectPopupSourceFrame,
      int[] indices) {
    if (nativeSelectPopup == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_SelectPopup_selectMenuItems(
        nativeSelectPopup, caller, nativeSelectPopupSourceFrame, indices);
  }

  public static SelectPopup.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      SelectPopup.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of SelectPopup.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new SelectPopupJni();
  }
}
