package org.chromium.content.browser.input;

public class SuggestionInfo {
  private final int mMarkerTag;
  private final String mPrefix;
  private final String mSuffix;
  private final String mSuggestion;
  private final int mSuggestionIndex;

  SuggestionInfo(
      int markerTag, int suggestionIndex, String prefix, String suggestion, String suffix) {
    this.mMarkerTag = markerTag;
    this.mSuggestionIndex = suggestionIndex;
    this.mPrefix = prefix;
    this.mSuggestion = suggestion;
    this.mSuffix = suffix;
  }

  public int getMarkerTag() {
    return this.mMarkerTag;
  }

  public int getSuggestionIndex() {
    return this.mSuggestionIndex;
  }

  public String getPrefix() {
    return this.mPrefix;
  }

  public String getSuggestion() {
    return this.mSuggestion;
  }

  public String getSuffix() {
    return this.mSuffix;
  }

  private static SuggestionInfo[] createArray(int length) {
    return new SuggestionInfo[length];
  }

  private static void createSuggestionInfoAndPutInArray(
      SuggestionInfo[] suggestionInfos,
      int index,
      int markerTag,
      int suggestionIndex,
      String prefix,
      String suggestion,
      String suffix) {
    SuggestionInfo suggestionInfo =
        new SuggestionInfo(markerTag, suggestionIndex, prefix, suggestion, suffix);
    suggestionInfos[index] = suggestionInfo;
  }
}
