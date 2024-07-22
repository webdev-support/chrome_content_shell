package org.chromium.content.browser.selection;

import org.chromium.content_public.browser.WebContents;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class SelectionPopupControllerImplJni implements SelectionPopupControllerImpl.Natives {

  public static final JniStaticTestMocker<SelectionPopupControllerImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<SelectionPopupControllerImpl.Natives>() {
        @Override
        public void setInstanceForTesting(SelectionPopupControllerImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          SelectionPopupControllerImplJni.testInstance = instance;
        }
      };
  private static SelectionPopupControllerImpl.Natives testInstance;

  SelectionPopupControllerImplJni() {}

  @Override
  public long init(SelectionPopupControllerImpl caller, WebContents webContents) {
    return GEN_JNI.org_chromium_content_browser_selection_SelectionPopupControllerImpl_init(
        caller, webContents);
  }

  @Override
  public boolean isMagnifierWithSurfaceControlSupported() {
    return GEN_JNI
        .org_chromium_content_browser_selection_SelectionPopupControllerImpl_isMagnifierWithSurfaceControlSupported();
  }

  @Override
  public void setTextHandlesHiddenForDropdownMenu(
      long nativeSelectionPopupController, SelectionPopupControllerImpl caller, boolean hidden) {
    if (nativeSelectionPopupController == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_selection_SelectionPopupControllerImpl_setTextHandlesHiddenForDropdownMenu(
            nativeSelectionPopupController, caller, hidden);
  }

  @Override
  public void setTextHandlesTemporarilyHidden(
      long nativeSelectionPopupController, SelectionPopupControllerImpl caller, boolean hidden) {
    if (nativeSelectionPopupController == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_selection_SelectionPopupControllerImpl_setTextHandlesTemporarilyHidden(
            nativeSelectionPopupController, caller, hidden);
  }

  public static SelectionPopupControllerImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      SelectionPopupControllerImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of SelectionPopupControllerImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new SelectionPopupControllerImplJni();
  }
}
