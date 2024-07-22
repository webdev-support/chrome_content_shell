package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SpeechRecognitionSessionClient extends Interface {
  public static final Interface.Manager<SpeechRecognitionSessionClient, Proxy> MANAGER =
      SpeechRecognitionSessionClient_Internal.MANAGER;

  public interface Proxy extends SpeechRecognitionSessionClient, Interface.Proxy {}

  void audioEnded();

  void audioStarted();

  void ended();

  void errorOccurred(SpeechRecognitionError speechRecognitionError);

  void resultRetrieved(SpeechRecognitionResult[] speechRecognitionResultArr);

  void soundEnded();

  void soundStarted();

  void started();
}
