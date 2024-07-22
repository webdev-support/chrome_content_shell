package org.chromium.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

public class OptimizedFrameLayout extends FrameLayout {
  private final List<MeasurementState> mMatchParentChildren;

  private static class MeasurementState {
    final int mHeightMeasureSpec;
    final View mView;
    final int mWidthMeasureSpec;

    MeasurementState(View view, int widthMeasureSpec, int heightMeasureSpec) {
      this.mView = view;
      this.mWidthMeasureSpec = widthMeasureSpec;
      this.mHeightMeasureSpec = heightMeasureSpec;
    }
  }

  public OptimizedFrameLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.mMatchParentChildren = new ArrayList();
  }

  @Override // android.widget.FrameLayout, android.view.View
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int width;
    int height;
    int count;
    int i = widthMeasureSpec;
    int i2 = heightMeasureSpec;
    int count2 = getChildCount();
    boolean measureMatchParentChildren =
        (MeasureSpec.getMode(widthMeasureSpec) == 1073741824
                && MeasureSpec.getMode(heightMeasureSpec) == 1073741824)
            ? false
            : true;
    this.mMatchParentChildren.clear();
    int maxHeight = 0;
    int maxWidth = 0;
    int childState = 0;
    int paddingLeft = getPaddingLeft();
    int paddingRight = getPaddingRight();
    int paddingTop = getPaddingTop();
    int paddingBottom = getPaddingBottom();
    int i3 = 0;
    while (i3 < count2) {
      View child = getChildAt(i3);
      if (getMeasureAllChildren() || child.getVisibility() != 8) {
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        count = count2;
        int count3 = lp.leftMargin;
        int childWidthMeasureSpec =
            getChildMeasureSpec(i, paddingLeft + paddingRight + count3 + lp.rightMargin, lp.width);
        int childHeightMeasureSpec =
            getChildMeasureSpec(
                i2, paddingTop + paddingBottom + lp.topMargin + lp.bottomMargin, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        int maxWidth2 =
            Math.max(maxWidth, child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin);
        int maxHeight2 =
            Math.max(maxHeight, child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin);
        int maxHeight3 = child.getMeasuredState();
        int childState2 = combineMeasuredStates(childState, maxHeight3);
        if (measureMatchParentChildren && (lp.width == -1 || lp.height == -1)) {
          this.mMatchParentChildren.add(
              new MeasurementState(child, childWidthMeasureSpec, childHeightMeasureSpec));
        }
        maxWidth = maxWidth2;
        childState = childState2;
        maxHeight = maxHeight2;
      } else {
        count = count2;
      }
      i3++;
      i = widthMeasureSpec;
      i2 = heightMeasureSpec;
      count2 = count;
    }
    int maxHeight4 = Math.max(maxHeight + paddingTop + paddingBottom, getSuggestedMinimumHeight());
    int maxWidth3 = Math.max(maxWidth + paddingLeft + paddingRight, getSuggestedMinimumWidth());
    Drawable drawable = getForeground();
    if (drawable != null) {
      maxHeight4 = Math.max(maxHeight4, drawable.getMinimumHeight());
      maxWidth3 = Math.max(maxWidth3, drawable.getMinimumWidth());
    }
    setMeasuredDimension(
        resolveSizeAndState(maxWidth3, widthMeasureSpec, childState),
        resolveSizeAndState(maxHeight4, heightMeasureSpec, childState << 16));
    int count4 = this.mMatchParentChildren.size();
    if (count4 > 1) {
      int i4 = 0;
      while (i4 < count4) {
        MeasurementState measurementState = this.mMatchParentChildren.get(i4);
        View child2 = measurementState.mView;
        int maxHeight5 = maxHeight4;
        MarginLayoutParams lp2 = (MarginLayoutParams) child2.getLayoutParams();
        int maxWidth4 = maxWidth3;
        int maxWidth5 = lp2.width;
        Drawable drawable2 = drawable;
        if (maxWidth5 == -1) {
          int width2 =
              Math.max(
                  0,
                  (((getMeasuredWidth() - paddingLeft) - paddingRight) - lp2.leftMargin)
                      - lp2.rightMargin);
          width = MeasureSpec.makeMeasureSpec(width2, 1073741824);
        } else {
          width =
              getChildMeasureSpec(
                  widthMeasureSpec,
                  paddingLeft + paddingRight + lp2.leftMargin + lp2.rightMargin,
                  lp2.width);
        }
        boolean measureMatchParentChildren2 = measureMatchParentChildren;
        if (lp2.height == -1) {
          int height2 =
              Math.max(
                  0,
                  (((getMeasuredHeight() - paddingTop) - paddingBottom) - lp2.topMargin)
                      - lp2.bottomMargin);
          height = MeasureSpec.makeMeasureSpec(height2, 1073741824);
        } else {
          height =
              getChildMeasureSpec(
                  heightMeasureSpec,
                  paddingTop + paddingBottom + lp2.topMargin + lp2.bottomMargin,
                  lp2.height);
        }
        if (measurementState.mWidthMeasureSpec != width
            || measurementState.mHeightMeasureSpec != height) {
          child2.measure(width, height);
        }
        i4++;
        maxWidth3 = maxWidth4;
        maxHeight4 = maxHeight5;
        drawable = drawable2;
        measureMatchParentChildren = measureMatchParentChildren2;
      }
    }
    this.mMatchParentChildren.clear();
  }
}
