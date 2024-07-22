package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface TextSuggestionHost extends Interface {
  public static final Interface.Manager<TextSuggestionHost, Proxy> MANAGER =
      TextSuggestionHost_Internal.MANAGER;

  public interface Proxy extends TextSuggestionHost, Interface.Proxy {}

  void showSpellCheckSuggestionMenu(
      double d, double d2, String str, SpellCheckSuggestion[] spellCheckSuggestionArr);

  void showTextSuggestionMenu(double d, double d2, String str, TextSuggestion[] textSuggestionArr);

  void startSuggestionMenuTimer();
}
