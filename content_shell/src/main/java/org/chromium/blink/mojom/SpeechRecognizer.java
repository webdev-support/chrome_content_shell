package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SpeechRecognizer extends Interface {
  public static final Interface.Manager<SpeechRecognizer, Proxy> MANAGER =
      SpeechRecognizer_Internal.MANAGER;

  public interface Proxy extends SpeechRecognizer, Interface.Proxy {}

  void start(StartSpeechRecognitionRequestParams startSpeechRecognitionRequestParams);
}
