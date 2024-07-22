package org.chromium.content.browser.input;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.blink.mojom.StylusWritingGestureData;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo_base.mojom.String16;

public class StylusGestureConverter {

  @Retention(RetentionPolicy.SOURCE)
  public @interface UmaGestureType {
    public static final int DELETE = 6;
    public static final int DELETE_RANGE = 10;
    public static final int DW_ADD_SPACE_OR_TEXT = 1;
    public static final int DW_DELETE_TEXT = 0;
    public static final int DW_REMOVE_SPACES = 2;
    public static final int DW_SPLIT_OR_MERGE = 3;
    public static final int INSERT = 5;
    public static final int JOIN_OR_SPLIT = 8;
    public static final int NUM_ENTRIES = 11;
    public static final int REMOVE_SPACE = 7;
    public static final int SELECT = 4;
    public static final int SELECT_RANGE = 9;
  }

  public static void logGestureType(int gestureType) {
    RecordHistogram.recordEnumeratedHistogram(
        "InputMethod.StylusHandwriting.Gesture", gestureType, 11);
  }

  public static StylusWritingGestureData createGestureData(HandwritingGesture gesture) {
    if (gesture instanceof SelectGesture) {
      logGestureType(4);
      return createGestureData((SelectGesture) gesture);
    } else if (gesture instanceof InsertGesture) {
      logGestureType(5);
      return createGestureData((InsertGesture) gesture);
    } else if (gesture instanceof DeleteGesture) {
      logGestureType(6);
      return createGestureData((DeleteGesture) gesture);
    } else if (gesture instanceof RemoveSpaceGesture) {
      logGestureType(7);
      return createGestureData((RemoveSpaceGesture) gesture);
    } else if (gesture instanceof JoinOrSplitGesture) {
      logGestureType(8);
      return createGestureData((JoinOrSplitGesture) gesture);
    } else if (gesture instanceof SelectRangeGesture) {
      logGestureType(9);
      return createGestureData((SelectRangeGesture) gesture);
    } else if (gesture instanceof DeleteRangeGesture) {
      logGestureType(10);
      return createGestureData((DeleteRangeGesture) gesture);
    } else {
      return null;
    }
  }

  private static StylusWritingGestureData createGestureData(SelectGesture gesture) {
    int i;
    StylusWritingGestureData gestureData = new StylusWritingGestureData();
    gestureData.action = 4;
    if (gesture.getGranularity() == 1) {
      i = 1;
    } else {
      i = 0;
    }
    gestureData.granularity = i;
    gestureData.textAlternative = toMojoString(gesture.getFallbackText());
    Rect[] areas = toTwoMojoRects(gesture.getSelectionArea());
    gestureData.startRect = areas[0];
    gestureData.endRect = areas[1];
    return gestureData;
  }

  private static StylusWritingGestureData createGestureData(InsertGesture gesture) {
    StylusWritingGestureData gestureData = new StylusWritingGestureData();
    gestureData.action = 1;
    gestureData.granularity = 0;
    gestureData.textAlternative = toMojoString(gesture.getFallbackText());
    gestureData.textToInsert = toMojoString(gesture.getTextToInsert());
    gestureData.startRect = toMojoRect(gesture.getInsertionPoint());
    return gestureData;
  }

  private static StylusWritingGestureData createGestureData(DeleteGesture gesture) {
    int i;
    StylusWritingGestureData gestureData = new StylusWritingGestureData();
    gestureData.action = 0;
    if (gesture.getGranularity() == 1) {
      i = 1;
    } else {
      i = 0;
    }
    gestureData.granularity = i;
    gestureData.textAlternative = toMojoString(gesture.getFallbackText());
    Rect[] areas = toTwoMojoRects(gesture.getDeletionArea());
    gestureData.startRect = areas[0];
    gestureData.endRect = areas[1];
    return gestureData;
  }

  private static StylusWritingGestureData createGestureData(RemoveSpaceGesture gesture) {
    StylusWritingGestureData gestureData = new StylusWritingGestureData();
    gestureData.action = 2;
    gestureData.granularity = 0;
    gestureData.textAlternative = toMojoString(gesture.getFallbackText());
    gestureData.startRect = toMojoRect(gesture.getStartPoint());
    gestureData.endRect = toMojoRect(gesture.getEndPoint());
    return gestureData;
  }

  private static StylusWritingGestureData createGestureData(JoinOrSplitGesture gesture) {
    StylusWritingGestureData gestureData = new StylusWritingGestureData();
    gestureData.action = 3;
    gestureData.granularity = 0;
    gestureData.textAlternative = toMojoString(gesture.getFallbackText());
    gestureData.startRect = toMojoRect(gesture.getJoinOrSplitPoint());
    return gestureData;
  }

  private static StylusWritingGestureData createGestureData(SelectRangeGesture gesture) {
    StylusWritingGestureData gestureData = new StylusWritingGestureData();
    gestureData.action = 4;
    gestureData.granularity = gesture.getGranularity() != 1 ? 0 : 1;
    gestureData.textAlternative = toMojoString(gesture.getFallbackText());
    gestureData.startRect = toMojoRect(gesture.getSelectionStartArea());
    gestureData.endRect = toMojoRect(gesture.getSelectionEndArea());
    return gestureData;
  }

  private static StylusWritingGestureData createGestureData(DeleteRangeGesture gesture) {
    StylusWritingGestureData gestureData = new StylusWritingGestureData();
    int i = 0;
    gestureData.action = 0;
    if (gesture.getGranularity() == 1) {
      i = 1;
    }
    gestureData.granularity = i;
    gestureData.textAlternative = toMojoString(gesture.getFallbackText());
    gestureData.startRect = toMojoRect(gesture.getDeletionStartArea());
    gestureData.endRect = toMojoRect(gesture.getDeletionEndArea());
    return gestureData;
  }

  private static Rect toMojoRect(RectF rect) {
    Rect mojoRect = new Rect();
    mojoRect.x = Math.round(rect.left);
    mojoRect.y = Math.round(rect.top);
    mojoRect.width = Math.round(rect.right - rect.left);
    mojoRect.height = Math.round(rect.bottom - rect.top);
    return mojoRect;
  }

  private static Rect toMojoRect(PointF point) {
    Rect rect = new Rect();
    rect.x = Math.round(point.x);
    rect.y = Math.round(point.y);
    rect.width = 0;
    rect.height = 0;
    return rect;
  }

  private static Rect[] toTwoMojoRects(RectF area) {
    PointF left = new PointF(area.left, (area.top + area.bottom) / 2.0f);
    PointF right = new PointF(area.right, (area.top + area.bottom) / 2.0f);
    Rect[] areas = {toMojoRect(left), toMojoRect(right)};
    return areas;
  }

  private static String16 toMojoString(String string) {
    short[] data = new short[string.length()];
    for (int i = 0; i < data.length; i++) {
      data[i] = (short) string.charAt(i);
    }
    String16 mojoString = new String16();
    mojoString.data = data;
    return mojoString;
  }

  private StylusGestureConverter() {}
}
