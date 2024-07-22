package org.chromium.content.browser.input;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import com.example.chromium_content_view.R;
import org.chromium.ui.base.WindowAndroid;

public class TextSuggestionsPopupWindow extends SuggestionsPopupWindow {
  private TextAppearanceSpan mPrefixSpan;
  private TextAppearanceSpan mSuffixSpan;
  private SuggestionInfo[] mSuggestionInfos;

  public TextSuggestionsPopupWindow(
      Context context,
      TextSuggestionHost textSuggestionHost,
      WindowAndroid windowAndroid,
      View parentView) {
    super(context, textSuggestionHost, windowAndroid, parentView);
    this.mPrefixSpan =
        new TextAppearanceSpan(context, androidx.appcompat.R.style.TextAppearance_AppCompat);
    this.mSuffixSpan =
        new TextAppearanceSpan(context, R.style.TextAppearance_SuggestionPrefixOrSuffix);
  }

  public void show(
      double caretX, double caretY, String highlightedText, SuggestionInfo[] suggestionInfos) {
    this.mSuggestionInfos = (SuggestionInfo[]) suggestionInfos.clone();
    setAddToDictionaryEnabled(false);
    super.show(caretX, caretY, highlightedText);
  }

  @Override
  protected int getSuggestionsCount() {
    return this.mSuggestionInfos.length;
  }

  @Override
  protected Object getSuggestionItem(int position) {
    return this.mSuggestionInfos[position];
  }

  @Override
  protected SpannableString getSuggestionText(int position) {
    SuggestionInfo suggestionInfo = this.mSuggestionInfos[position];
    String prefix = suggestionInfo.getPrefix();
    String suggestion = suggestionInfo.getSuggestion();
    SpannableString suggestionText =
        new SpannableString(prefix + suggestion + suggestionInfo.getSuffix());
    suggestionText.setSpan(this.mPrefixSpan, 0, suggestionInfo.getPrefix().length(), 33);
    suggestionText.setSpan(
        this.mSuffixSpan,
        suggestionInfo.getPrefix().length() + suggestionInfo.getSuggestion().length(),
        suggestionInfo.getPrefix().length()
            + suggestionInfo.getSuggestion().length()
            + suggestionInfo.getSuffix().length(),
        33);
    return suggestionText;
  }

  @Override
  protected void applySuggestion(int position) {
    SuggestionInfo info = this.mSuggestionInfos[position];
    this.mTextSuggestionHost.applyTextSuggestion(info.getMarkerTag(), info.getSuggestionIndex());
  }
}
