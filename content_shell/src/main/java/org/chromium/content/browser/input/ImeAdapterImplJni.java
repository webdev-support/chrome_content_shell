package org.chromium.content.browser.input;

import android.view.KeyEvent;
import java.nio.ByteBuffer;
import org.chromium.content_public.browser.WebContents;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class ImeAdapterImplJni implements ImeAdapterImpl.Natives {

  public static final JniStaticTestMocker<ImeAdapterImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<ImeAdapterImpl.Natives>() {
        @Override
        public void setInstanceForTesting(ImeAdapterImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          ImeAdapterImplJni.testInstance = instance;
        }
      };
  private static ImeAdapterImpl.Natives testInstance;

  ImeAdapterImplJni() {}

  @Override
  public void advanceFocusForIME(
      long nativeImeAdapterAndroid, ImeAdapterImpl caller, int focusType) {
    if (nativeImeAdapterAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_advanceFocusForIME(
        nativeImeAdapterAndroid, caller, focusType);
  }

  @Override
  public void appendBackgroundColorSpan(long spanPtr, int start, int end, int backgroundColor) {
    GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_appendBackgroundColorSpan(
        spanPtr, start, end, backgroundColor);
  }

  @Override
  public void appendForegroundColorSpan(long spanPtr, int start, int end, int backgroundColor) {
    GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_appendForegroundColorSpan(
        spanPtr, start, end, backgroundColor);
  }

  @Override
  public void appendSuggestionSpan(
      long spanPtr,
      int start,
      int end,
      boolean isMisspelling,
      boolean removeOnFinishComposing,
      int underlineColor,
      int suggestionHighlightColor,
      String[] suggestions) {
    GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_appendSuggestionSpan(
        spanPtr,
        start,
        end,
        isMisspelling,
        removeOnFinishComposing,
        underlineColor,
        suggestionHighlightColor,
        suggestions);
  }

  @Override
  public void appendUnderlineSpan(long spanPtr, int start, int end) {
    GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_appendUnderlineSpan(
        spanPtr, start, end);
  }

  @Override
  public void commitText(
      long nativeImeAdapterAndroid,
      ImeAdapterImpl caller,
      CharSequence text,
      String textStr,
      int newCursorPosition) {
    if (nativeImeAdapterAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_commitText(
        nativeImeAdapterAndroid, caller, text, textStr, newCursorPosition);
  }

  @Override
  public void deleteSurroundingText(
      long nativeImeAdapterAndroid, ImeAdapterImpl caller, int before, int after) {
    if (nativeImeAdapterAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_deleteSurroundingText(
        nativeImeAdapterAndroid, caller, before, after);
  }

  @Override
  public void deleteSurroundingTextInCodePoints(
      long nativeImeAdapterAndroid, ImeAdapterImpl caller, int before, int after) {
    if (nativeImeAdapterAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_deleteSurroundingTextInCodePoints(
        nativeImeAdapterAndroid, caller, before, after);
  }

  @Override
  public void finishComposingText(long nativeImeAdapterAndroid, ImeAdapterImpl caller) {
    if (nativeImeAdapterAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_finishComposingText(
        nativeImeAdapterAndroid, caller);
  }

  @Override
  public void handleStylusWritingGestureAction(
      long nativeImeAdapterAndroid, ImeAdapterImpl caller, int id, ByteBuffer gestureData) {
    if (nativeImeAdapterAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_handleStylusWritingGestureAction(
        nativeImeAdapterAndroid, caller, id, gestureData);
  }

  @Override
  public long init(ImeAdapterImpl caller, WebContents webContents) {
    return GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_init(caller, webContents);
  }

  @Override
  public void requestCursorUpdate(
      long nativeImeAdapterAndroid,
      ImeAdapterImpl caller,
      boolean immediateRequest,
      boolean monitorRequest) {
    if (nativeImeAdapterAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_requestCursorUpdate(
        nativeImeAdapterAndroid, caller, immediateRequest, monitorRequest);
  }

  @Override
  public boolean requestTextInputStateUpdate(long nativeImeAdapterAndroid, ImeAdapterImpl caller) {
    if (nativeImeAdapterAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_requestTextInputStateUpdate(
        nativeImeAdapterAndroid, caller);
  }

  @Override
  public boolean sendKeyEvent(
      long nativeImeAdapterAndroid,
      ImeAdapterImpl caller,
      KeyEvent event,
      int type,
      int modifiers,
      long timestampMs,
      int keyCode,
      int scanCode,
      boolean isSystemKey,
      int unicodeChar) {
    if (nativeImeAdapterAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_sendKeyEvent(
        nativeImeAdapterAndroid,
        caller,
        event,
        type,
        modifiers,
        timestampMs,
        keyCode,
        scanCode,
        isSystemKey,
        unicodeChar);
  }

  @Override
  public void setComposingRegion(
      long nativeImeAdapterAndroid, ImeAdapterImpl caller, int start, int end) {
    if (nativeImeAdapterAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_setComposingRegion(
        nativeImeAdapterAndroid, caller, start, end);
  }

  @Override
  public void setComposingText(
      long nativeImeAdapterAndroid,
      ImeAdapterImpl caller,
      CharSequence text,
      String textStr,
      int newCursorPosition) {
    if (nativeImeAdapterAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_setComposingText(
        nativeImeAdapterAndroid, caller, text, textStr, newCursorPosition);
  }

  @Override
  public void setEditableSelectionOffsets(
      long nativeImeAdapterAndroid, ImeAdapterImpl caller, int start, int end) {
    if (nativeImeAdapterAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_input_ImeAdapterImpl_setEditableSelectionOffsets(
        nativeImeAdapterAndroid, caller, start, end);
  }

  public static ImeAdapterImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      ImeAdapterImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of ImeAdapterImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new ImeAdapterImplJni();
  }
}
