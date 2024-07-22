package org.chromium.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.example.chromium_content_view.R;

public class ElidedUrlTextView extends AppCompatTextView {

  private int mCurrentMaxLines;
  private Integer mFullLinesToDisplay;
  private boolean mIsShowingTruncatedText;
  private int mOriginLength;
  private Integer mTruncatedUrlLinesToDisplay;

  public ElidedUrlTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.mIsShowingTruncatedText = true;
    this.mOriginLength = -1;
    this.mCurrentMaxLines = Integer.MAX_VALUE;
  }

  @Override // android.widget.TextView
  public void setMaxLines(int maxlines) {
    super.setMaxLines(maxlines);
    this.mCurrentMaxLines = maxlines;
  }

  private int getLineForIndex(int index) {
    Layout layout = getLayout();
    int endLine = 0;
    while (endLine < layout.getLineCount() && layout.getLineEnd(endLine) < index) {
      endLine++;
    }
    return endLine + 1;
  }

  @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView,
  // android.view.View
  public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    setMaxLines(Integer.MAX_VALUE);
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    if (this.mOriginLength < 0) {
      throw new AssertionError("setUrl() must be called before layout.");
    }
    String urlText = getText().toString();
    int originEndLine = getLineForIndex(this.mOriginLength);
    this.mTruncatedUrlLinesToDisplay = Integer.valueOf(originEndLine + 1);
    int fragmentStartIndex = urlText.indexOf(35);
    if (fragmentStartIndex == -1) {
      fragmentStartIndex = urlText.length();
    }
    int fragmentStartLine = getLineForIndex(fragmentStartIndex);
    Integer valueOf = Integer.valueOf(fragmentStartLine + 1);
    this.mFullLinesToDisplay = valueOf;
    if (valueOf.intValue() < this.mTruncatedUrlLinesToDisplay.intValue()) {
      this.mTruncatedUrlLinesToDisplay = this.mFullLinesToDisplay;
    }
    if (updateMaxLines()) {
      super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
  }

  public void setUrl(CharSequence url, int originLength) {
    if (originLength < 0 || originLength > url.length()) {
      throw new AssertionError();
    }
    setText(url);
    this.mOriginLength = originLength;
  }

  public void toggleTruncation() {
    this.mIsShowingTruncatedText = !this.mIsShowingTruncatedText;
    if (this.mFullLinesToDisplay != null && updateMaxLines()) {
      announceForAccessibilityOnToggleTruncation(this.mIsShowingTruncatedText);
    }
  }

  private void announceForAccessibilityOnToggleTruncation(boolean isUrlTruncated) {
    int i;
    Resources resources = getResources();
    if (isUrlTruncated) {
      i = R.string.elided_url_text_view_url_truncated;
    } else {
      i = R.string.elided_url_text_view_url_expanded;
    }
    announceForAccessibility(resources.getString(i));
  }

  private boolean updateMaxLines() {
    int maxLines = this.mFullLinesToDisplay.intValue();
    if (this.mIsShowingTruncatedText) {
      maxLines = this.mTruncatedUrlLinesToDisplay.intValue();
    }
    if (maxLines != this.mCurrentMaxLines) {
      setMaxLines(maxLines);
      return true;
    }
    return false;
  }
}
