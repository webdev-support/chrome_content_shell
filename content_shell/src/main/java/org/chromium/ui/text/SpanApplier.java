package org.chromium.ui.text;

import android.text.SpannableString;
import java.util.Arrays;

public class SpanApplier {
  private static final int INVALID_INDEX = -1;

  public static final class SpanInfo implements Comparable<SpanInfo> {
    final String mEndTag;
    int mEndTagIndex;
    final Object[] mSpans;
    final String mStartTag;
    int mStartTagIndex;

    public SpanInfo(String startTag, String endTag, Object span) {
      this.mStartTag = startTag;
      this.mEndTag = endTag;
      this.mSpans = span == null ? null : new Object[] {span};
    }

    public SpanInfo(String startTag, String endTag, Object... spans) {
      this.mStartTag = startTag;
      this.mEndTag = endTag;
      this.mSpans = spans;
    }

    @Override     public int compareTo(SpanInfo other) {
      int i = this.mStartTagIndex;
      int i2 = other.mStartTagIndex;
      if (i < i2) {
        return -1;
      }
      return i == i2 ? 0 : 1;
    }

    public boolean equals(Object other) {
      return (other instanceof SpanInfo) && compareTo((SpanInfo) other) == 0;
    }

    public int hashCode() {
      return 0;
    }
  }

  public static SpannableString applySpans(String input, SpanInfo... spans) {
    Object[] objArr;
    setSpanInfoIndices(input, spans);
    int inputIndex = 0;
    StringBuilder output = new StringBuilder(input.length());
    for (SpanInfo span : spans) {
      validateSpanInfo(span, input, inputIndex);
      output.append((CharSequence) input, inputIndex, span.mStartTagIndex);
      int inputIndex2 = span.mStartTagIndex + span.mStartTag.length();
      int inputIndex3 = output.length();
      span.mStartTagIndex = inputIndex3;
      output.append((CharSequence) input, inputIndex2, span.mEndTagIndex);
      inputIndex = span.mEndTagIndex + span.mEndTag.length();
      int inputIndex4 = output.length();
      span.mEndTagIndex = inputIndex4;
    }
    output.append((CharSequence) input, inputIndex, input.length());
    SpannableString spannableString = new SpannableString(output);
    for (SpanInfo span2 : spans) {
      if (span2.mStartTagIndex != -1 && span2.mSpans != null && span2.mSpans.length != 0) {
        for (Object s : span2.mSpans) {
          if (s != null) {
            spannableString.setSpan(s, span2.mStartTagIndex, span2.mEndTagIndex, 0);
          }
        }
      }
    }
    return spannableString;
  }

  private static void setSpanInfoIndices(String input, SpanInfo... spans) {
    for (SpanInfo span : spans) {
      span.mStartTagIndex = input.indexOf(span.mStartTag);
      span.mEndTagIndex =
          input.indexOf(span.mEndTag, span.mStartTagIndex + span.mStartTag.length());
    }
    Arrays.sort(spans);
  }

  private static void validateSpanInfo(SpanInfo span, String input, int spanIndexLimit) {
    if (span.mStartTagIndex == -1
        || span.mEndTagIndex == -1
        || span.mStartTagIndex < spanIndexLimit) {
      span.mStartTagIndex = -1;
      String error =
          String.format(
              "Input string is missing tags %s%s: %s", span.mStartTag, span.mEndTag, input);
      throw new IllegalArgumentException(error);
    }
  }

  public static String removeSpanText(String input, SpanInfo... spans) {
    setSpanInfoIndices(input, spans);
    int inputIndex = 0;
    StringBuilder output = new StringBuilder(input.length());
    for (SpanInfo span : spans) {
      validateSpanInfo(span, input, inputIndex);
      output.append((CharSequence) input, inputIndex, span.mStartTagIndex);
      inputIndex = span.mEndTagIndex + span.mEndTag.length();
    }
    output.append((CharSequence) input, inputIndex, input.length());
    return output.toString();
  }
}
