package org.chromium.content_public.browser;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityNodeProvider;
import org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl;

public interface WebContentsAccessibility {
  AccessibilityNodeProvider getAccessibilityNodeProvider();

  boolean isNativeInitialized();

  void onAutofillPopupAccessibilityFocusCleared();

  void onAutofillPopupDismissed();

  void onAutofillPopupDisplayed(View view);

  boolean onHoverEventNoRenderer(MotionEvent motionEvent);

  void onProvideVirtualStructure(ViewStructure viewStructure, boolean z);

  void resetFocus();

  void restoreFocus();

  void setIsAutoDisableAccessibilityCandidate(boolean z);

  void setIsImageDescriptionsCandidate(boolean z);

  void setObscuredByAnotherView(boolean z);

  void setShouldFocusOnPageLoad(boolean z);

  static WebContentsAccessibility fromWebContents(WebContents webContents) {
    return WebContentsAccessibilityImpl.fromWebContents(webContents);
  }
}
