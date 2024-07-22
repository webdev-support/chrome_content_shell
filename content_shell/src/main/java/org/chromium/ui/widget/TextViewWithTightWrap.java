package org.chromium.ui.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewWithTightWrap extends TextView {
  public TextViewWithTightWrap(Context context) {
    super(context);
  }

  public TextViewWithTightWrap(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public TextViewWithTightWrap(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  @Override // android.widget.TextView, android.view.View
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    Layout layout = getLayout();
    if (layout != null && layout.getLineCount() > 1) {
      int width = getMaxLineWidth(layout) + getCompoundPaddingLeft() + getCompoundPaddingRight();
      getMeasuredHeight();
      if (width < getMeasuredWidth()) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), heightMeasureSpec);
      }
    }
  }

  private int getMaxLineWidth(Layout layout) {
    float maxWidth = 0.0f;
    int lines = layout.getLineCount();
    for (int i = 0; i < lines; i++) {
      maxWidth = Math.max(maxWidth, layout.getLineWidth(i));
    }
    return (int) Math.ceil(maxWidth);
  }
}
