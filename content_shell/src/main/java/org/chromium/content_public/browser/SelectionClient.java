package org.chromium.content_public.browser;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import java.util.List;
import org.chromium.content.browser.selection.SmartSelectionClient;

public interface SelectionClient {

  public interface ResultCallback {
    void onClassified(Result result);
  }

  void cancelAllRequests();

  void onSelectionChanged(String str);

  void onSelectionEvent(int i, float f, float f2);

  boolean requestSelectionPopupUpdates(boolean z);

  void selectAroundCaretAck(SelectAroundCaretResult selectAroundCaretResult);

  public static class Result {
    public List<Drawable> additionalIcons;
    public int endAdjust;
    public Drawable icon;
    public Intent intent;
    public CharSequence label;
    public View.OnClickListener onClickListener;
    public int startAdjust;
    public TextClassification textClassification;
    public TextSelection textSelection;

    public boolean hasNamedAction() {
      return ((this.label == null && this.icon == null)
              || (this.intent == null && this.onClickListener == null))
          ? false
          : true;
    }
  }

  default SelectionEventProcessor getSelectionEventProcessor() {
    return null;
  }

  default void setTextClassifier(TextClassifier textClassifier) {}

  default TextClassifier getTextClassifier() {
    return null;
  }

  default TextClassifier getCustomTextClassifier() {
    return null;
  }

  static SelectionClient createSmartSelectionClient(WebContents webContents) {
    ResultCallback callback =
        SelectionPopupController.fromWebContents(webContents).getResultCallback();
    return SmartSelectionClient.create(callback, webContents);
  }
}
