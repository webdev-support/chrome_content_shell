package org.chromium.content_public.browser;

import android.content.Context;
import android.os.ResultReceiver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import org.chromium.content.browser.input.ImeAdapterImpl;
import org.chromium.ui.base.WindowAndroid;

public interface ImeAdapter {
  public static final int COMPOSITION_KEY_CODE = 229;

  void addEventObserver(ImeEventObserver imeEventObserver);

  void advanceFocusForIME(int i);

  InputConnection getActiveInputConnection();

  InputConnection getInputConnectionForTest();

  ResultReceiver getNewShowKeyboardReceiver();

  boolean onCheckIsTextEditor();

  InputConnection onCreateInputConnection(EditorInfo editorInfo);

  void onShowKeyboardReceiveResult(int i);

  void setComposingTextForTest(CharSequence charSequence, int i);

  void setInputMethodManagerWrapper(InputMethodManagerWrapper inputMethodManagerWrapper);

  static ImeAdapter fromWebContents(WebContents webContents) {
    return ImeAdapterImpl.fromWebContents(webContents);
  }

  static InputMethodManagerWrapper createDefaultInputMethodManagerWrapper(
      Context context, WindowAndroid windowAndroid, InputMethodManagerWrapper.Delegate delegate) {
    return ImeAdapterImpl.createDefaultInputMethodManagerWrapper(context, windowAndroid, delegate);
  }
}
