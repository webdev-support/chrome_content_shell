package org.chromium.content.browser.selection;

import java.text.BreakIterator;
import java.util.regex.Pattern;

public class SelectionIndicesConverter {

  private static final Pattern PATTERN_WHITESPACE = Pattern.compile("[\\p{javaSpaceChar}\\s]+");
  private String mGlobalSelectionText;
  private int mGlobalStartOffset;
  private int mInitialStartOffset;
  private String mLastSelectionText;
  private int mLastStartOffset;

  public boolean updateSelectionState(String selectionText, int startOffset) {
    if (this.mGlobalSelectionText == null) {
      updateLastSelection(selectionText, startOffset);
      updateGlobalSelection(selectionText, startOffset);
      return true;
    }
    boolean update = false;
    int endOffset = selectionText.length() + startOffset;
    int lastEndOffset = this.mLastStartOffset + this.mLastSelectionText.length();
    if (overlap(this.mLastStartOffset, lastEndOffset, startOffset, endOffset)) {
      int l = Math.max(this.mLastStartOffset, startOffset);
      int r = Math.min(lastEndOffset, endOffset);
      update =
          this.mLastSelectionText.regionMatches(
              l - this.mLastStartOffset, selectionText, l - startOffset, r - l);
    }
    update = (this.mLastStartOffset == endOffset || lastEndOffset == startOffset) ? true : true;
    if (!update) {
      this.mGlobalSelectionText = null;
      this.mLastSelectionText = null;
      return false;
    }
    updateLastSelection(selectionText, startOffset);
    combineGlobalSelection(selectionText, startOffset);
    return true;
  }

  public boolean getWordDelta(int start, int end, int[] wordIndices) {
    if (wordIndices.length != 2) {
      throw new AssertionError();
    }
    wordIndices[1] = 0;
    wordIndices[0] = 0;
    int i = this.mGlobalStartOffset;
    int start2 = start - i;
    int end2 = end - i;
    if (start2 < end2
        && start2 >= 0
        && start2 < this.mGlobalSelectionText.length()
        && end2 > 0
        && end2 <= this.mGlobalSelectionText.length()) {
      int initialStartOffset = this.mInitialStartOffset - this.mGlobalStartOffset;
      BreakIterator breakIterator = BreakIterator.getWordInstance();
      breakIterator.setText(this.mGlobalSelectionText);
      if (start2 <= initialStartOffset) {
        wordIndices[0] = -countWordsForward(start2, initialStartOffset, breakIterator);
      } else {
        wordIndices[0] = countWordsBackward(start2, initialStartOffset, breakIterator);
        if (!breakIterator.isBoundary(start2)
            && !isWhitespace(breakIterator.preceding(start2), breakIterator.following(start2))) {
          wordIndices[0] = wordIndices[0] - 1;
        }
      }
      if (end2 <= initialStartOffset) {
        wordIndices[1] = -countWordsForward(end2, initialStartOffset, breakIterator);
      } else {
        wordIndices[1] = countWordsBackward(end2, initialStartOffset, breakIterator);
      }
      return true;
    }
    return false;
  }

  public void setInitialStartOffset(int offset) {
    this.mInitialStartOffset = offset;
  }

  protected String getGlobalSelectionText() {
    return this.mGlobalSelectionText;
  }

  protected int getGlobalStartOffset() {
    return this.mGlobalStartOffset;
  }

  protected int countWordsBackward(int start, int end, BreakIterator iterator) {
    if (start < end) {
      throw new AssertionError();
    }
    int wordCount = 0;
    int offset = start;
    while (offset > end) {
      int i = iterator.preceding(offset);
      if (!isWhitespace(i, offset)) {
        wordCount++;
      }
      offset = i;
    }
    return wordCount;
  }

  protected int countWordsForward(int start, int end, BreakIterator iterator) {
    if (start > end) {
      throw new AssertionError();
    }
    int wordCount = 0;
    int offset = start;
    while (offset < end) {
      int i = iterator.following(offset);
      if (!isWhitespace(offset, i)) {
        wordCount++;
      }
      offset = i;
    }
    return wordCount;
  }

  protected boolean isWhitespace(int start, int end) {
    return PATTERN_WHITESPACE.matcher(this.mGlobalSelectionText.substring(start, end)).matches();
  }

  protected static boolean overlap(int al, int ar, int bl, int br) {
    return al <= bl ? bl < ar : br > al;
  }

  protected static boolean contains(int al, int ar, int bl, int br) {
    return al <= bl && br <= ar;
  }

  private void updateLastSelection(String selectionText, int startOffset) {
    this.mLastSelectionText = selectionText;
    this.mLastStartOffset = startOffset;
  }

  private void updateGlobalSelection(String selectionText, int startOffset) {
    this.mGlobalSelectionText = selectionText;
    this.mGlobalStartOffset = startOffset;
  }

  private void combineGlobalSelection(String selectionText, int startOffset) {
    int endOffset = selectionText.length() + startOffset;
    int globalEndOffset = this.mGlobalStartOffset + this.mGlobalSelectionText.length();
    int i = this.mGlobalStartOffset;
    if (startOffset < i) {
      String substring = selectionText.substring(0, i - startOffset);
      updateGlobalSelection(substring + this.mGlobalSelectionText, startOffset);
    }
    if (endOffset > globalEndOffset) {
      String str = this.mGlobalSelectionText;
      updateGlobalSelection(
          str + selectionText.substring(globalEndOffset - startOffset, selectionText.length()),
          this.mGlobalStartOffset);
    }
  }
}
