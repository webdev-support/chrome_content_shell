package org.chromium.content_public.browser;

import android.os.Handler;

public interface SmartClipProvider {
  void extractSmartClipData(int i, int i2, int i3, int i4);

  void setSmartClipResultHandler(Handler handler);
}
