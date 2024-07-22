package org.chromium.content.browser.accessibility;

import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import org.chromium.content_public.browser.WebContents;
import org.jni_zero.GEN_JNI;
import org.jni_zero.JniStaticTestMocker;
import org.jni_zero.NativeLibraryLoadedStatus;

public class WebContentsAccessibilityImplJni implements WebContentsAccessibilityImpl.Natives {

  public static final JniStaticTestMocker<WebContentsAccessibilityImpl.Natives> TEST_HOOKS =
      new JniStaticTestMocker<WebContentsAccessibilityImpl.Natives>() {
        @Override
        public void setInstanceForTesting(WebContentsAccessibilityImpl.Natives instance) {
          if (!GEN_JNI.TESTING_ENABLED) {
            throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
          }
          WebContentsAccessibilityImplJni.testInstance = instance;
        }
      };
  private static WebContentsAccessibilityImpl.Natives testInstance;

  WebContentsAccessibilityImplJni() {}

  @Override
  public void addSpellingErrorForTesting(
      long nativeWebContentsAccessibilityAndroid, int id, int startOffset, int endOffset) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_addSpellingErrorForTesting(
            nativeWebContentsAccessibilityAndroid, id, startOffset, endOffset);
  }

  @Override
  public boolean adjustSlider(
      long nativeWebContentsAccessibilityAndroid, int id, boolean increment) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_adjustSlider(
            nativeWebContentsAccessibilityAndroid, id, increment);
  }

  @Override
  public boolean areInlineTextBoxesLoaded(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_areInlineTextBoxesLoaded(
            nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public void blur(long nativeWebContentsAccessibilityAndroid) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_blur(
        nativeWebContentsAccessibilityAndroid);
  }

  @Override
  public void click(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_click(
        nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public void connectInstanceToRootManager(long nativeWebContentsAccessibilityAndroid) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_connectInstanceToRootManager(
            nativeWebContentsAccessibilityAndroid);
  }

  @Override
  public void deleteEarly(long nativeWebContentsAccessibilityAndroid) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_deleteEarly(
        nativeWebContentsAccessibilityAndroid);
  }

  @Override
  public void disableRendererAccessibility(long nativeWebContentsAccessibilityAndroid) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_disableRendererAccessibility(
            nativeWebContentsAccessibilityAndroid);
  }

  @Override
  public int findElementType(
      long nativeWebContentsAccessibilityAndroid,
      int startId,
      String elementType,
      boolean forwards,
      boolean canWrapToLastElement,
      boolean useDefaultPredicate) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_findElementType(
            nativeWebContentsAccessibilityAndroid,
            startId,
            elementType,
            forwards,
            canWrapToLastElement,
            useDefaultPredicate);
  }

  @Override
  public void focus(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_focus(
        nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public int[] getAbsolutePositionForNode(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getAbsolutePositionForNode(
            nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public int[] getCharacterBoundingBoxes(
      long nativeWebContentsAccessibilityAndroid, int id, int start, int len) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getCharacterBoundingBoxes(
            nativeWebContentsAccessibilityAndroid, id, start, len);
  }

  @Override
  public int getEditableTextSelectionEnd(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getEditableTextSelectionEnd(
            nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public int getEditableTextSelectionStart(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getEditableTextSelectionStart(
            nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public int getIdForElementAfterElementHostingAutofillPopup(
      long nativeWebContentsAccessibilityAndroid) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getIdForElementAfterElementHostingAutofillPopup(
            nativeWebContentsAccessibilityAndroid);
  }

  @Override
  public boolean getImageData(
      long nativeWebContentsAccessibilityAndroid,
      AccessibilityNodeInfoCompat info,
      int id,
      boolean hasSentPreviousRequest) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getImageData(
            nativeWebContentsAccessibilityAndroid, info, id, hasSentPreviousRequest);
  }

  @Override
  public int getMaxContentChangedEventsToFireForTesting(
      long nativeWebContentsAccessibilityAndroid) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getMaxContentChangedEventsToFireForTesting(
            nativeWebContentsAccessibilityAndroid);
  }

  @Override
  public int getRootId(long nativeWebContentsAccessibilityAndroid) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getRootId(
            nativeWebContentsAccessibilityAndroid);
  }

  @Override
  public String getSupportedHtmlElementTypes(long nativeWebContentsAccessibilityAndroid) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getSupportedHtmlElementTypes(
            nativeWebContentsAccessibilityAndroid);
  }

  @Override
  public int getTextLength(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getTextLength(
            nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public long init(
      WebContentsAccessibilityImpl caller,
      WebContents webContents,
      AccessibilityNodeInfoBuilder builder) {
    return GEN_JNI.org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_init(
        caller, webContents, builder);
  }

  @Override
  public long initWithAXTree(
      WebContentsAccessibilityImpl caller, long axTreePtr, AccessibilityNodeInfoBuilder builder) {
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_initWithAXTree(
            caller, axTreePtr, builder);
  }

  @Override
  public boolean isAutofillPopupNode(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_isAutofillPopupNode(
            nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public boolean isEditableText(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_isEditableText(
            nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public boolean isFocused(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_isFocused(
            nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public boolean isNodeValid(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_isNodeValid(
            nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public boolean isRootManagerConnected(long nativeWebContentsAccessibilityAndroid) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_isRootManagerConnected(
            nativeWebContentsAccessibilityAndroid);
  }

  @Override
  public boolean isSlider(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_isSlider(
        nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public void loadInlineTextBoxes(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_loadInlineTextBoxes(
            nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public void moveAccessibilityFocus(
      long nativeWebContentsAccessibilityAndroid, int oldId, int newId) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_moveAccessibilityFocus(
            nativeWebContentsAccessibilityAndroid, oldId, newId);
  }

  @Override
  public boolean nextAtGranularity(
      long nativeWebContentsAccessibilityAndroid,
      int selectionGranularity,
      boolean extendSelection,
      int id,
      int cursorIndex) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_nextAtGranularity(
            nativeWebContentsAccessibilityAndroid,
            selectionGranularity,
            extendSelection,
            id,
            cursorIndex);
  }

  @Override
  public void onAutofillPopupDismissed(long nativeWebContentsAccessibilityAndroid) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_onAutofillPopupDismissed(
            nativeWebContentsAccessibilityAndroid);
  }

  @Override
  public void onAutofillPopupDisplayed(long nativeWebContentsAccessibilityAndroid) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_onAutofillPopupDisplayed(
            nativeWebContentsAccessibilityAndroid);
  }

  @Override
  public boolean onHoverEventNoRenderer(
      long nativeWebContentsAccessibilityAndroid, float x, float y) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_onHoverEventNoRenderer(
            nativeWebContentsAccessibilityAndroid, x, y);
  }

  @Override
  public boolean populateAccessibilityEvent(
      long nativeWebContentsAccessibilityAndroid, AccessibilityEvent event, int id, int eventType) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_populateAccessibilityEvent(
            nativeWebContentsAccessibilityAndroid, event, id, eventType);
  }

  @Override
  public boolean populateAccessibilityNodeInfo(
      long nativeWebContentsAccessibilityAndroid, AccessibilityNodeInfoCompat info, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_populateAccessibilityNodeInfo(
            nativeWebContentsAccessibilityAndroid, info, id);
  }

  @Override
  public boolean populateAccessibilityNodeInfo_exp(
      long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_populateAccessibilityNodeInfo_1exp(
            nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public boolean previousAtGranularity(
      long nativeWebContentsAccessibilityAndroid,
      int selectionGranularity,
      boolean extendSelection,
      int id,
      int cursorIndex) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_previousAtGranularity(
            nativeWebContentsAccessibilityAndroid,
            selectionGranularity,
            extendSelection,
            id,
            cursorIndex);
  }

  @Override
  public void reEnableRendererAccessibility(
      long nativeWebContentsAccessibilityAndroid, WebContents webContents) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_reEnableRendererAccessibility(
            nativeWebContentsAccessibilityAndroid, webContents);
  }

  @Override
  public boolean scroll(
      long nativeWebContentsAccessibilityAndroid, int id, int direction, boolean pageScroll) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI.org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_scroll(
        nativeWebContentsAccessibilityAndroid, id, direction, pageScroll);
  }

  @Override
  public void scrollToMakeNodeVisible(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_scrollToMakeNodeVisible(
            nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public void setAllowImageDescriptions(
      long nativeWebContentsAccessibilityAndroid, boolean allowImageDescriptions) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_setAllowImageDescriptions(
            nativeWebContentsAccessibilityAndroid, allowImageDescriptions);
  }

  @Override
  public void setBrowserAXMode(
      WebContentsAccessibilityImpl caller,
      boolean screenReaderMode,
      boolean formControlsMode,
      boolean isAccessibilityEnabled) {
    GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_setBrowserAXMode(
            caller, screenReaderMode, formControlsMode, isAccessibilityEnabled);
  }

  @Override
  public void setMaxContentChangedEventsToFireForTesting(
      long nativeWebContentsAccessibilityAndroid, int maxEvents) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_setMaxContentChangedEventsToFireForTesting(
            nativeWebContentsAccessibilityAndroid, maxEvents);
  }

  @Override
  public boolean setRangeValue(long nativeWebContentsAccessibilityAndroid, int id, float value) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_setRangeValue(
            nativeWebContentsAccessibilityAndroid, id, value);
  }

  @Override
  public void setSelection(long nativeWebContentsAccessibilityAndroid, int id, int start, int end) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_setSelection(
        nativeWebContentsAccessibilityAndroid, id, start, end);
  }

  @Override
  public void setTextFieldValue(
      long nativeWebContentsAccessibilityAndroid, int id, String newValue) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_setTextFieldValue(
            nativeWebContentsAccessibilityAndroid, id, newValue);
  }

  @Override
  public void showContextMenu(long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI.org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_showContextMenu(
        nativeWebContentsAccessibilityAndroid, id);
  }

  @Override
  public void signalEndOfTestForTesting(long nativeWebContentsAccessibilityAndroid) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_signalEndOfTestForTesting(
            nativeWebContentsAccessibilityAndroid);
  }

  @Override
  public boolean updateCachedAccessibilityNodeInfo(
      long nativeWebContentsAccessibilityAndroid, AccessibilityNodeInfoCompat info, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_updateCachedAccessibilityNodeInfo(
            nativeWebContentsAccessibilityAndroid, info, id);
  }

  @Override
  public boolean updateCachedAccessibilityNodeInfo_exp(
      long nativeWebContentsAccessibilityAndroid, int id) {
    if (nativeWebContentsAccessibilityAndroid == 0) {
      throw new AssertionError();
    }
    return GEN_JNI
        .org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_updateCachedAccessibilityNodeInfo_1exp(
            nativeWebContentsAccessibilityAndroid, id);
  }

  public static WebContentsAccessibilityImpl.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      WebContentsAccessibilityImpl.Natives natives = testInstance;
      if (natives != null) {
        return natives;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException(
            "No mock found for the native implementation of WebContentsAccessibilityImpl.Natives. The current configuration requires implementations be mocked.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded();
    return new WebContentsAccessibilityImplJni();
  }
}
