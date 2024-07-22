package org.chromium.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.BulletSpan;
import com.example.chromium_content_view.R;

public class ChromeBulletSpan extends BulletSpan {
  private int mXOffset;

  public ChromeBulletSpan(Context context) {
    super(context.getResources().getDimensionPixelSize(R.dimen.chrome_bullet_gap));
    this.mXOffset =
        context.getResources().getDimensionPixelSize(R.dimen.chrome_bullet_leading_offset);
  }

  @Override // android.text.style.BulletSpan, android.text.style.LeadingMarginSpan
  public void drawLeadingMargin(
      Canvas c,
      Paint p,
      int x,
      int dir,
      int top,
      int baseline,
      int bottom,
      CharSequence text,
      int start,
      int end,
      boolean first,
      Layout l) {
    super.drawLeadingMargin(
        c, p, x + this.mXOffset, dir, top, baseline, bottom, text, start, end, first, l);
  }
}
