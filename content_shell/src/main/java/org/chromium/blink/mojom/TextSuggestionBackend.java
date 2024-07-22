package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface TextSuggestionBackend extends Interface {
  public static final Interface.Manager<TextSuggestionBackend, Proxy> MANAGER =
      TextSuggestionBackend_Internal.MANAGER;

  public interface Proxy extends TextSuggestionBackend, Interface.Proxy {}

  void applySpellCheckSuggestion(String str);

  void applyTextSuggestion(int i, int i2);

  void deleteActiveSuggestionRange();

  void onNewWordAddedToDictionary(String str);

  void onSuggestionMenuClosed();

  void suggestionMenuTimeoutCallback(int i);
}
