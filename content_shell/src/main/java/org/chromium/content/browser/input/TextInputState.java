package org.chromium.content.browser.input;

import android.text.TextUtils;
import android.view.inputmethod.SurroundingText;
import java.util.Locale;

public class TextInputState {
  private final Range mComposition;
  private final boolean mReplyToRequest;
  private final Range mSelection;
  private final boolean mSingleLine;
  private final CharSequence mText;

  public static class SurroundingTextInternal {
    public final int mOffset;
    public final int mSelectionEnd;
    public final int mSelectionStart;
    public final CharSequence mText;

    public SurroundingTextInternal(
        CharSequence text, int selectionStart, int selectionEnd, int offset) {
      this.mText = text;
      this.mSelectionStart = selectionStart;
      this.mSelectionEnd = selectionEnd;
      this.mOffset = offset;
    }
  }

  public TextInputState(
      CharSequence text,
      Range selection,
      Range composition,
      boolean singleLine,
      boolean replyToRequest) {
    selection.clamp(0, text.length());
    if (composition.start() != -1 || composition.end() != -1) {
      composition.clamp(0, text.length());
    }
    this.mText = text;
    this.mSelection = selection;
    this.mComposition = composition;
    this.mSingleLine = singleLine;
    this.mReplyToRequest = replyToRequest;
  }

  public CharSequence text() {
    return this.mText;
  }

  public Range selection() {
    return this.mSelection;
  }

  public Range composition() {
    return this.mComposition;
  }

  public boolean singleLine() {
    return this.mSingleLine;
  }

  public boolean replyToRequest() {
    return this.mReplyToRequest;
  }

  public CharSequence getSelectedText() {
    if (this.mSelection.start() == this.mSelection.end()) {
      return null;
    }
    return TextUtils.substring(this.mText, this.mSelection.start(), this.mSelection.end());
  }

  public CharSequence getTextAfterSelection(int maxChars) {
    return TextUtils.substring(
        this.mText,
        this.mSelection.end(),
        Math.min(
            this.mText.length(),
            this.mSelection.end()
                + Math.max(0, Math.min(maxChars, this.mText.length() - this.mSelection.end()))));
  }

  public CharSequence getTextBeforeSelection(int maxChars) {
    return TextUtils.substring(
        this.mText,
        Math.max(
            0, this.mSelection.start() - Math.max(0, Math.min(maxChars, this.mSelection.start()))),
        this.mSelection.start());
  }

  public SurroundingText getSurroundingText(int beforeLength, int afterLength) {
    SurroundingTextInternal surroundingText = getSurroundingTextInternal(beforeLength, afterLength);
    return new SurroundingText(
        surroundingText.mText,
        surroundingText.mSelectionStart,
        surroundingText.mSelectionEnd,
        surroundingText.mOffset);
  }

  SurroundingTextInternal getSurroundingTextInternal(int beforeLength, int afterLength) {
    int beforeLength2 = Math.max(0, Math.min(beforeLength, this.mSelection.start()));
    CharSequence text =
        TextUtils.substring(
            this.mText,
            this.mSelection.start() - beforeLength2,
            this.mSelection.end()
                + Math.max(0, Math.min(afterLength, this.mText.length() - this.mSelection.end())));
    return new SurroundingTextInternal(
        text, beforeLength2, this.mSelection.end() - (this.mSelection.start() - beforeLength2), -1);
  }

  public boolean equals(Object o) {
    if (o instanceof TextInputState) {
      TextInputState t = (TextInputState) o;
      if (t == this) {
        return true;
      }
      return TextUtils.equals(this.mText, t.mText)
          && this.mSelection.equals(t.mSelection)
          && this.mComposition.equals(t.mComposition)
          && this.mSingleLine == t.mSingleLine
          && this.mReplyToRequest == t.mReplyToRequest;
    }
    return false;
  }

  public int hashCode() {
    return (this.mText.hashCode() * 7)
        + (this.mSelection.hashCode() * 11)
        + (this.mComposition.hashCode() * 13)
        + (this.mSingleLine ? 19 : 0)
        + (this.mReplyToRequest ? 23 : 0);
  }

  public boolean shouldUnblock() {
    return false;
  }

  public String toString() {
    Locale locale = Locale.US;
    Object[] objArr = new Object[5];
    objArr[0] = this.mText;
    objArr[1] = this.mSelection;
    objArr[2] = this.mComposition;
    objArr[3] = this.mSingleLine ? "SIN" : "MUL";
    objArr[4] = this.mReplyToRequest ? " ReplyToRequest" : "";
    return String.format(locale, "TextInputState {[%s] SEL%s COM%s %s%s}", objArr);
  }
}
