package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Point;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.ui.mojom.ImeTextSpan;

public interface FrameWidgetInputHandler extends Interface {
  public static final Interface.Manager<FrameWidgetInputHandler, Proxy> MANAGER =
      FrameWidgetInputHandler_Internal.MANAGER;

  public interface HandleStylusWritingGestureAction_Response {
    void call(int i);
  }

  public interface Proxy extends FrameWidgetInputHandler, Interface.Proxy {}

  public interface SelectAroundCaret_Response {
    void call(SelectAroundCaretResult selectAroundCaretResult);
  }

  public interface WaitForPageScaleAnimationForTesting_Response {
    void call();
  }

  void addImeTextSpansToExistingText(int i, int i2, ImeTextSpan[] imeTextSpanArr);

  void adjustSelectionByCharacterOffset(int i, int i2, int i3);

  void centerSelection();

  void clearImeTextSpansByType(int i, int i2, int i3);

  void collapseSelection();

  void copy();

  void copyToFindPboard();

  void cut();

  void delete();

  void deleteSurroundingText(int i, int i2);

  void deleteSurroundingTextInCodePoints(int i, int i2);

  void executeEditCommand(String str, String16 string16);

  void extendSelectionAndDelete(int i, int i2);

  void extendSelectionAndReplace(int i, int i2, String16 string16);

  void handleStylusWritingGestureAction(
      StylusWritingGestureData stylusWritingGestureData,
      HandleStylusWritingGestureAction_Response handleStylusWritingGestureAction_Response);

  void moveCaret(Point point);

  void moveRangeSelectionExtent(Point point);

  void paste();

  void pasteAndMatchStyle();

  void redo();

  void replace(String16 string16);

  void replaceMisspelling(String16 string16);

  void scrollFocusedEditableNodeIntoView();

  void selectAll();

  void selectAroundCaret(
      int i, boolean z, boolean z2, SelectAroundCaret_Response selectAroundCaret_Response);

  void selectRange(Point point, Point point2);

  void setCompositionFromExistingText(int i, int i2, ImeTextSpan[] imeTextSpanArr);

  void setEditableSelectionOffsets(int i, int i2);

  void undo();

  void waitForPageScaleAnimationForTesting(
      WaitForPageScaleAnimationForTesting_Response waitForPageScaleAnimationForTesting_Response);
}
