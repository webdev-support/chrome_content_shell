package org.chromium.ui.resources.dynamics;

import android.graphics.Canvas;
import android.graphics.Rect;

public interface CaptureObserver {
  default void onCaptureStart(Canvas canvas, Rect dirtyRect) {}

  default void onCaptureEnd() {}
}
