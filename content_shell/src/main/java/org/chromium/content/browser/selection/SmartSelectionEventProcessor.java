package org.chromium.content.browser.selection;

import android.content.Context;
import android.view.textclassifier.SelectionEvent;
import android.view.textclassifier.TextClassificationContext;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import org.chromium.content.browser.WindowEventObserver;
import org.chromium.content.browser.WindowEventObserverManager;
import org.chromium.content_public.browser.SelectionClient;
import org.chromium.content_public.browser.SelectionEventProcessor;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.WindowAndroid;

public class SmartSelectionEventProcessor implements SelectionEventProcessor {
  private static final boolean DEBUG = false;
  private static final String TAG = "SmartSelectionLogger";
  private SelectionIndicesConverter mConverter;
  private TextClassifier mSession;
  private WindowAndroid mWindowAndroid;

  public static SmartSelectionEventProcessor create(WebContents webContents) {
    if (webContents.getTopLevelNativeWindow().getContext().get() == null) {
      return null;
    }
    return new SmartSelectionEventProcessor(webContents);
  }

  private SmartSelectionEventProcessor(WebContents webContents) {
    this.mWindowAndroid = webContents.getTopLevelNativeWindow();
    WindowEventObserverManager manager = WindowEventObserverManager.from(webContents);
    if (manager != null) {
      manager.addObserver(
          new WindowEventObserver() {
            @Override
            public void onWindowAndroidChanged(WindowAndroid newWindowAndroid) {
              SmartSelectionEventProcessor.this.mWindowAndroid = newWindowAndroid;
            }
          });
    }
  }

  public void onSelectionStarted(String selectionText, int startOffset, boolean editable) {
    Context context;
    WindowAndroid windowAndroid = this.mWindowAndroid;
    if (windowAndroid == null || (context = windowAndroid.getContext().get()) == null) {
      return;
    }
    this.mSession = createSession(context, editable);
    SelectionIndicesConverter selectionIndicesConverter = new SelectionIndicesConverter();
    this.mConverter = selectionIndicesConverter;
    selectionIndicesConverter.updateSelectionState(selectionText, startOffset);
    this.mConverter.setInitialStartOffset(startOffset);
    logEvent(SelectionEvent.createSelectionStartedEvent(1, 0));
  }

  public void onSelectionModified(
      String selectionText, int startOffset, SelectionClient.Result result) {
    if (this.mSession == null) {
      return;
    }
    if (!this.mConverter.updateSelectionState(selectionText, startOffset)) {
      endTextClassificationSession();
      return;
    }
    int endOffset = selectionText.length() + startOffset;
    int[] indices = new int[2];
    if (!this.mConverter.getWordDelta(startOffset, endOffset, indices)) {
      endTextClassificationSession();
    } else if (result != null && result.textSelection != null) {
      logEvent(
          SelectionEvent.createSelectionModifiedEvent(
              indices[0], indices[1], result.textSelection));
    } else if (result == null || result.textClassification == null) {
      logEvent(SelectionEvent.createSelectionModifiedEvent(indices[0], indices[1]));
    } else {
      logEvent(
          SelectionEvent.createSelectionModifiedEvent(
              indices[0], indices[1], result.textClassification));
    }
  }

  public void onSelectionAction(
      String selectionText, int startOffset, int action, SelectionClient.Result result) {
    if (this.mSession == null) {
      return;
    }
    if (!this.mConverter.updateSelectionState(selectionText, startOffset)) {
      endTextClassificationSession();
      return;
    }
    int endOffset = selectionText.length() + startOffset;
    int[] indices = new int[2];
    if (!this.mConverter.getWordDelta(startOffset, endOffset, indices)) {
      endTextClassificationSession();
      return;
    }
    if (result == null || result.textClassification == null) {
      logEvent(SelectionEvent.createSelectionActionEvent(indices[0], indices[1], action));
    } else {
      logEvent(
          SelectionEvent.createSelectionActionEvent(
              indices[0], indices[1], action, result.textClassification));
    }
    if (SelectionEvent.isTerminal(action)) {
      endTextClassificationSession();
    }
  }

  private TextClassifier createSession(Context context, boolean editable) {
    String str;
    String packageName = context.getPackageName();
    if (editable) {
      str = "edit-webview";
    } else {
      str = "webview";
    }
    TextClassificationContext textClassificationContext =
        new TextClassificationContext.Builder(packageName, str).build();
    TextClassificationManager tcm =
        (TextClassificationManager) context.getSystemService("textclassification");
    return tcm.createTextClassificationSession(textClassificationContext);
  }

  private void endTextClassificationSession() {
    TextClassifier textClassifier = this.mSession;
    if (textClassifier == null || textClassifier.isDestroyed()) {
      return;
    }
    this.mSession.destroy();
    this.mSession = null;
  }

  public void logEvent(SelectionEvent selectionEvent) {
    this.mSession.onSelectionEvent(selectionEvent);
  }

  public TextClassifier getTextClassifierSession() {
    return this.mSession;
  }
}
