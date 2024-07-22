package org.chromium.content.browser.input;

import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class TextSuggestionHostJni implements TextSuggestionHost.Natives {

  public static final JniStaticTestMocker<TextSuggestionHost.Natives> TEST_HOOKS =
      new JniStaticTestMocker<TextSuggestionHost.Natives>() {
        @Override
        public void setInstanceForTesting(TextSuggestionHost.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          TextSuggestionHostJni.testInstance = instance;
        }
      };
  private static TextSuggestionHost.Natives testInstance;

  TextSuggestionHostJni() {}

  @Override
  public void applySpellCheckSuggestion(
      long nativeTextSuggestionHostAndroid, TextSuggestionHost caller, String suggestion) {
    if (nativeTextSuggestionHostAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_TextSuggestionHost_applySpellCheckSuggestion(
        nativeTextSuggestionHostAndroid, caller, suggestion);
  }

  @Override
  public void applyTextSuggestion(
      long nativeTextSuggestionHostAndroid,
      TextSuggestionHost caller,
      int markerTag,
      int suggestionIndex) {
    if (nativeTextSuggestionHostAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_TextSuggestionHost_applyTextSuggestion(
        nativeTextSuggestionHostAndroid, caller, markerTag, suggestionIndex);
  }

  @Override
  public void deleteActiveSuggestionRange(
      long nativeTextSuggestionHostAndroid, TextSuggestionHost caller) {
    if (nativeTextSuggestionHostAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_TextSuggestionHost_deleteActiveSuggestionRange(
        nativeTextSuggestionHostAndroid, caller);
  }

  @Override
  public void onNewWordAddedToDictionary(
      long nativeTextSuggestionHostAndroid, TextSuggestionHost caller, String word) {
    if (nativeTextSuggestionHostAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_TextSuggestionHost_onNewWordAddedToDictionary(
        nativeTextSuggestionHostAndroid, caller, word);
  }

  @Override
  public void onSuggestionMenuClosed(
      long nativeTextSuggestionHostAndroid, TextSuggestionHost caller) {
    if (nativeTextSuggestionHostAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_TextSuggestionHost_onSuggestionMenuClosed(
        nativeTextSuggestionHostAndroid, caller);
  }

  public static TextSuggestionHost.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      TextSuggestionHost.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of TextSuggestionHost.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new TextSuggestionHostJni();
  }
}
