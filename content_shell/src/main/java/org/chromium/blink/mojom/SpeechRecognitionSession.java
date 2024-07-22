package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SpeechRecognitionSession extends Interface {
  public static final Interface.Manager<SpeechRecognitionSession, Proxy> MANAGER =
      SpeechRecognitionSession_Internal.MANAGER;

  public interface Proxy extends SpeechRecognitionSession, Interface.Proxy {}

  void abort();

  void stopCapture();
}
