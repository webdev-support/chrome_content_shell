package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SpeechSynthesisVoiceListObserver extends Interface {
  public static final Interface.Manager<SpeechSynthesisVoiceListObserver, Proxy> MANAGER =
      SpeechSynthesisVoiceListObserver_Internal.MANAGER;

  public interface Proxy extends SpeechSynthesisVoiceListObserver, Interface.Proxy {}

  void onSetVoiceList(SpeechSynthesisVoice[] speechSynthesisVoiceArr);
}
