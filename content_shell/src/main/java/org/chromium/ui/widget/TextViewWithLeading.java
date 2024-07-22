package org.chromium.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.example.chromium_content_view.R;
import org.chromium.ui.base.UiAndroidFeatureList;

public class TextViewWithLeading extends TextView {

  public TextViewWithLeading(Context context) {
    super(context);
  }

  public TextViewWithLeading(Context context, AttributeSet attrs) {
    super(context, attrs);
    checkForLineSpacingAttributes(attrs);
    Float nullableLeading = getLeadingDimen(attrs);
    if (UiAndroidFeatureList.sRequireLeadingInTextViewWithLeading.isEnabled()) {
      if (nullableLeading == null) {
        throw new AssertionError("Couldn't find leading for TextViewWithLeading");
      }
      applyLeading(nullableLeading.floatValue());
    } else if (nullableLeading != null) {
      applyLeading(nullableLeading.floatValue());
    }
  }

  private Float getLeadingDimen(AttributeSet attrs) {
    Float result;
    Context context = getContext();
    TypedArray selfTypedArray =
        context.obtainStyledAttributes(attrs, R.styleable.TextViewWithLeading, 0, 0);
    int leadingIndex = R.styleable.TextViewWithLeading_leading;
    int textAppIndex = R.styleable.TextViewWithLeading_android_textAppearance;
    if (selfTypedArray.hasValue(leadingIndex)) {
      float leading = selfTypedArray.getDimension(leadingIndex, 0.0f);
      result = Float.valueOf(leading);
    } else if (selfTypedArray.hasValue(textAppIndex)) {
      int textAppRes = selfTypedArray.getResourceId(textAppIndex, 0);
      if (textAppRes == 0) {
        result = null;
      } else {
        TypedArray textAppTypedArray =
            context.obtainStyledAttributes(textAppRes, R.styleable.TextViewWithLeading);
        Float result2 = getLeadingFromTextAppearance(textAppTypedArray);
        textAppTypedArray.recycle();
        result = result2;
      }
    } else {
      result = null;
    }
    selfTypedArray.recycle();
    return result;
  }

  private Float getLeadingFromTextAppearance(TypedArray textAppTypedArray) {
    if (textAppTypedArray.hasValue(R.styleable.TextViewWithLeading_leading)) {
      return Float.valueOf(
          textAppTypedArray.getDimension(R.styleable.TextViewWithLeading_leading, 0.0f));
    }
    return null;
  }

  private void applyLeading(float newLeading) {
    float oldLeading = getPaint().getFontMetrics(null);
    setLineSpacing(newLeading - oldLeading, 1.0f);
  }

  private void checkForLineSpacingAttributes(AttributeSet attrs) {
    if (attrs.getAttributeValue(null, "android:lineSpacingExtra") != null
        || attrs.getAttributeValue(null, "android:lineSpacingMultiplier") != null) {
      throw new AssertionError(
          "Do not use android:lineSpacingExtra or android:lineSpacingMultiplier in TextViewWithLeading.");
    }
  }
}
