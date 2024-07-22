package org.chromium.content.browser.input;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import org.chromium.ui.base.WindowAndroid;

public class SpellCheckPopupWindow extends SuggestionsPopupWindow {
  private String[] mSuggestions;

  public SpellCheckPopupWindow(
      Context context,
      TextSuggestionHost textSuggestionHost,
      WindowAndroid windowAndroid,
      View parentView) {
    super(context, textSuggestionHost, windowAndroid, parentView);
    this.mSuggestions = new String[0];
  }

  public void show(double caretX, double caretY, String highlightedText, String[] suggestions) {
    this.mSuggestions = (String[]) suggestions.clone();
    setAddToDictionaryEnabled(true);
    super.show(caretX, caretY, highlightedText);
  }

  @Override
  protected int getSuggestionsCount() {
    return this.mSuggestions.length;
  }

  @Override
  protected Object getSuggestionItem(int position) {
    return this.mSuggestions[position];
  }

  @Override
  protected SpannableString getSuggestionText(int position) {
    return new SpannableString(this.mSuggestions[position]);
  }

  @Override
  protected void applySuggestion(int position) {
    this.mTextSuggestionHost.applySpellCheckSuggestion(this.mSuggestions[position]);
  }
}
