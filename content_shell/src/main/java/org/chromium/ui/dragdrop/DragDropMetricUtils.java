package org.chromium.ui.dragdrop;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.base.metrics.RecordHistogram;

public class DragDropMetricUtils {

  @Retention(RetentionPolicy.SOURCE)
  public @interface DragDropTabResult {
    public static final int ERROR_TAB_NOT_FOUND = 5;
    public static final int IGNORED_DIFF_MODEL_NOT_SUPPORTED = 2;
    public static final int IGNORED_SAME_INSTANCE = 4;
    public static final int IGNORED_TAB_SWITCHER = 3;
    public static final int IGNORED_TOOLBAR = 1;
    public static final int NUM_ENTRIES = 6;
    public static final int SUCCESS = 0;
  }

  @Retention(RetentionPolicy.SOURCE)
  public @interface DragDropType {
    public static final int LINK_TO_NEW_INSTANCE = 3;
    public static final int NUM_ENTRIES = 5;
    public static final int TAB_STRIP_TO_CONTENT = 1;
    public static final int TAB_STRIP_TO_NEW_INSTANCE = 2;
    public static final int TAB_STRIP_TO_TAB_STRIP = 0;
    public static final int UNKNOWN_TO_NEW_INSTANCE = 4;
  }

  @Retention(RetentionPolicy.SOURCE)
  public @interface UrlIntentSource {
    public static final int LINK = 1;
    public static final int NUM_ENTRIES = 3;
    public static final int TAB_IN_STRIP = 2;
    public static final int UNKNOWN = 0;
  }

  private DragDropMetricUtils() {}

  public static void recordTabDragDropType(int dragDropType) {
    RecordHistogram.recordEnumeratedHistogram("Android.DragDrop.Tab.Type", dragDropType, 5);
  }

  public static void recordTabDragDropResult(int result) {
    RecordHistogram.recordEnumeratedHistogram("Android.DragDrop.Tab.FromStrip.Result", result, 6);
  }

  public static void recordTabReorderStripWithDragDrop(boolean leavingStrip) {
    RecordHistogram.recordBooleanHistogram(
        "Android.DragDrop.Tab.ReorderStripWithDragDrop", leavingStrip);
  }

  public static void recordTabDurationWithinDestStrip(long duration) {
    RecordHistogram.recordMediumTimesHistogram(
        "Android.DragDrop.Tab.Duration.WithinDestStrip", duration);
  }
}
