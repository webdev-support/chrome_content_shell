package org.chromium.content_public.browser;

import android.view.View;
import org.chromium.content.browser.MotionEventSynthesizerImpl;

public interface MotionEventSynthesizer {
  void inject(int i, int i2, int i3, long j);

  void setPointer(int i, float f, float f2, int i2, int i3);

  static MotionEventSynthesizer create(View target) {
    return MotionEventSynthesizerImpl.create(target);
  }
}
