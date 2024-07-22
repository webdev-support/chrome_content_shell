package org.chromium.content.browser.selection;

import org.chromium.content_public.browser.WebContents;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class SmartSelectionClientJni implements SmartSelectionClient.Natives {

  public static final JniStaticTestMocker<SmartSelectionClient.Natives> TEST_HOOKS =
      new JniStaticTestMocker<SmartSelectionClient.Natives>() {
        @Override
        public void setInstanceForTesting(SmartSelectionClient.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          SmartSelectionClientJni.testInstance = instance;
        }
      };
  private static SmartSelectionClient.Natives testInstance;

  SmartSelectionClientJni() {}

  @Override
  public void cancelAllRequests(long nativeSmartSelectionClient, SmartSelectionClient caller) {
    if (nativeSmartSelectionClient == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_selection_SmartSelectionClient_cancelAllRequests(
        nativeSmartSelectionClient, caller);
  }

  @Override
  public long init(SmartSelectionClient caller, WebContents webContents) {
    return GEN_JNI.org_chromium_content_browser_selection_SmartSelectionClient_init(
        caller, webContents);
  }

  @Override
  public void requestSurroundingText(
      long nativeSmartSelectionClient,
      SmartSelectionClient caller,
      int numExtraCharacters,
      int callbackData) {
    if (nativeSmartSelectionClient == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_selection_SmartSelectionClient_requestSurroundingText(
        nativeSmartSelectionClient, caller, numExtraCharacters, callbackData);
  }

  public static SmartSelectionClient.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      SmartSelectionClient.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of SmartSelectionClient.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new SmartSelectionClientJni();
  }
}
