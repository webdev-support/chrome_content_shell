package org.chromium.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Region;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import org.chromium.base.TraceEvent;

public final class ViewUtils {

  private static final int[] sLocationTmp = new int[2];

  private ViewUtils() {}

  public static boolean hasFocus(View view) {
    if (isFocusable(view)) {
      return view.hasFocus();
    }
    return true;
  }

  public static void requestFocus(View view) {
    if (!isFocusable(view) || view.isFocused()) {
      return;
    }
    view.requestFocus();
  }

  private static boolean isFocusable(View view) {
    return view.isInTouchMode() ? view.isFocusableInTouchMode() : view.isFocusable();
  }

  private static void recursiveInvalidate(View view) {
    view.invalidate();
    if (view instanceof ViewGroup) {
      ViewGroup group = (ViewGroup) view;
      int childCount = group.getChildCount();
      for (int i = 0; i < childCount; i++) {
        View child = group.getChildAt(i);
        if (child.getVisibility() == 0) {
          recursiveInvalidate(child);
        }
      }
    }
  }

  public static void setEnabledRecursive(View view, boolean enabled) {
    view.setEnabled(enabled);
    if (view instanceof ViewGroup) {
      ViewGroup group = (ViewGroup) view;
      for (int i = 0; i < group.getChildCount(); i++) {
        setEnabledRecursive(group.getChildAt(i), enabled);
      }
    }
  }

  public static void captureBitmap(View view, Canvas canvas) {
    recursiveInvalidate(view);
    view.draw(canvas);
  }

  public static void getRelativeLayoutPosition(View rootView, View childView, int[] outPosition) {
    if (outPosition.length != 2) {
      throw new AssertionError();
    }
    outPosition[0] = 0;
    outPosition[1] = 0;
    if (rootView == null || childView == rootView) {
      return;
    }
    while (childView != null) {
      outPosition[0] = outPosition[0] + childView.getLeft();
      outPosition[1] = outPosition[1] + childView.getTop();
      if (childView.getParent() != rootView) {
        childView = (View) childView.getParent();
      } else {
        return;
      }
    }
  }

  public static void getRelativeDrawPosition(View rootView, View childView, int[] outPosition) {
    if (outPosition.length != 2) {
      throw new AssertionError();
    }
    outPosition[0] = 0;
    outPosition[1] = 0;
    if (rootView == null || childView == rootView) {
      return;
    }
    while (childView != null) {
      outPosition[0] = (int) (outPosition[0] + childView.getX());
      outPosition[1] = (int) (outPosition[1] + childView.getY());
      if (childView.getParent() != rootView) {
        childView = (View) childView.getParent();
      } else {
        return;
      }
    }
  }

  public static void gatherTransparentRegionsForOpaqueView(View view, Region region) {
    int[] iArr = sLocationTmp;
    view.getLocationInWindow(iArr);
    int i = iArr[0];
    region.op(
        i,
        iArr[1],
        (view.getRight() + i) - view.getLeft(),
        (iArr[1] + view.getBottom()) - view.getTop(),
        Region.Op.DIFFERENCE);
  }

  public static int dpToPx(Context context, float dp) {
    return dpToPx(context.getResources().getDisplayMetrics(), dp);
  }

  public static int dpToPx(DisplayMetrics metrics, float dp) {
    return Math.round(TypedValue.applyDimension(1, dp, metrics));
  }

  public static void setAncestorsShouldClipChildren(ViewGroup view, boolean clip) {
    for (ViewGroup parent = view; parent != null; parent = (ViewGroup) parent.getParent()) {
      parent.setClipChildren(clip);
      if (!(parent.getParent() instanceof ViewGroup) || parent.getId() == 16908290) {
        return;
      }
    }
  }

  public static RoundedBitmapDrawable createRoundedBitmapDrawable(
      Resources resources, Bitmap icon, int cornerRadius) {
    RoundedBitmapDrawable roundedIcon = RoundedBitmapDrawableFactory.create(resources, icon);
    roundedIcon.setCornerRadius(cornerRadius);
    return roundedIcon;
  }

  public static void translateCanvasToView(View from, View to, Canvas canvas)
      throws IllegalArgumentException {
    if (from == null) {
      throw new AssertionError();
    }
    if (to == null) {
      throw new AssertionError();
    }
    while (to != from) {
      canvas.translate(to.getLeft(), to.getTop());
      if (!(to.getParent() instanceof View)) {
        throw new IllegalArgumentException("View 'to' was not a desendent of 'from'.");
      }
      to = (View) to.getParent();
    }
  }

  public static void requestLayout(View view, String caller) {
    if (view == null) {
      throw new AssertionError();
    }
    TraceEvent.instant("requestLayout caller: " + caller);
    view.requestLayout();
  }
}
