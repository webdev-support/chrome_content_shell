package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SpeechSynthesis extends Interface {
  public static final Interface.Manager<SpeechSynthesis, Proxy> MANAGER =
      SpeechSynthesis_Internal.MANAGER;

  public interface Proxy extends SpeechSynthesis, Interface.Proxy {}

  void addVoiceListObserver(SpeechSynthesisVoiceListObserver speechSynthesisVoiceListObserver);

  void cancel();

  void pause();

  void resume();

  void speak(
      SpeechSynthesisUtterance speechSynthesisUtterance,
      SpeechSynthesisClient speechSynthesisClient);
}
