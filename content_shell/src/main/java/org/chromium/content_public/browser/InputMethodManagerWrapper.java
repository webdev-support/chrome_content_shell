package org.chromium.content_public.browser;

import android.os.IBinder;
import android.os.ResultReceiver;
import android.view.View;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.ExtractedText;
import org.chromium.ui.base.WindowAndroid;

public interface InputMethodManagerWrapper {

  public interface Delegate {
    boolean hasInputConnection();
  }

  boolean hideSoftInputFromWindow(IBinder iBinder, int i, ResultReceiver resultReceiver);

  boolean isActive(View view);

  void onInputConnectionCreated();

  void onWindowAndroidChanged(WindowAndroid windowAndroid);

  void restartInput(View view);

  void showSoftInput(View view, int i, ResultReceiver resultReceiver);

  void updateCursorAnchorInfo(View view, CursorAnchorInfo cursorAnchorInfo);

  void updateExtractedText(View view, int i, ExtractedText extractedText);

  void updateSelection(View view, int i, int i2, int i3, int i4);
}
