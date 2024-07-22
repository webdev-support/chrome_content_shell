package org.chromium.content_public.browser;

import android.content.Intent;
import android.view.textclassifier.TextClassifier;
import org.chromium.base.supplier.ObservableSupplier;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;
import org.chromium.content_public.browser.selection.SelectionActionMenuDelegate;
import org.chromium.content_public.browser.selection.SelectionDropdownMenuDelegate;

public interface SelectionPopupController {
  public static final String UMA_MOBILE_ACTION_MODE_SHARE = "MobileActionMode.Share";

  void clearSelection();

  void destroySelectActionMode();

  ActionModeCallbackHelper getActionModeCallbackHelper();

  TextClassifier getCustomTextClassifier();

  SelectionClient.ResultCallback getResultCallback();

  String getSelectedText();

  TextClassifier getTextClassifier();

  boolean hasSelection();

  boolean isFocusedNodeEditable();

  boolean isSelectActionBarShowing();

  ObservableSupplier<Boolean> isSelectActionBarShowingSupplier();

  void onReceivedProcessTextResult(int i, Intent intent);

  void setActionModeCallback(ActionModeCallback actionModeCallback);

  void setDropdownMenuDelegate(SelectionDropdownMenuDelegate selectionDropdownMenuDelegate);

  void setPreserveSelectionOnNextLossOfFocus(boolean z);

  void setSelectionActionMenuDelegate(SelectionActionMenuDelegate selectionActionMenuDelegate);

  void setSelectionClient(SelectionClient selectionClient);

  void setTextClassifier(TextClassifier textClassifier);

  void updateTextSelectionUI(boolean z);

  static SelectionPopupController fromWebContents(WebContents webContents) {
    return SelectionPopupControllerImpl.fromWebContents(webContents);
  }

  static SelectionPopupController fromWebContentsNoCreate(WebContents webContents) {
    return SelectionPopupControllerImpl.fromWebContentsNoCreate(webContents);
  }

  static void setMustUseWebContentsContext() {
    SelectionPopupControllerImpl.setMustUseWebContentsContext();
  }

  static void setShouldGetReadbackViewFromWindowAndroid() {
    SelectionPopupControllerImpl.setShouldGetReadbackViewFromWindowAndroid();
  }

  static void setAllowSurfaceControlMagnifier() {
    SelectionPopupControllerImpl.setAllowSurfaceControlMagnifier();
  }

  static boolean needsSurfaceViewDuringSelection() {
    return !SelectionPopupControllerImpl.isMagnifierWithSurfaceControlSupported();
  }
}
