package org.chromium.components.embedder_support.util;

import android.view.MotionEvent;
import org.chromium.base.metrics.RecordHistogram;

public class TouchEventFilter {
  public static boolean hasInvalidToolType(MotionEvent event) {
    boolean unrecognizedToolType = false;
    for (int pointerIdx = 0; pointerIdx < event.getPointerCount(); pointerIdx++) {
      RecordHistogram.recordSparseHistogram(
          "Input.ToolType.Android", event.getToolType(pointerIdx));
      if (event.getToolType(pointerIdx) < 0 || event.getToolType(pointerIdx) > 4) {
        unrecognizedToolType = true;
      }
    }
    return unrecognizedToolType;
  }

  private TouchEventFilter() {}
}
