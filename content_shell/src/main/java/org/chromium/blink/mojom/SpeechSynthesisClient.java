package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SpeechSynthesisClient extends Interface {
  public static final Interface.Manager<SpeechSynthesisClient, Proxy> MANAGER =
      SpeechSynthesisClient_Internal.MANAGER;

  public interface Proxy extends SpeechSynthesisClient, Interface.Proxy {}

  void onEncounteredSentenceBoundary(int i, int i2);

  void onEncounteredSpeakingError();

  void onEncounteredWordBoundary(int i, int i2);

  void onFinishedSpeaking(int i);

  void onPausedSpeaking();

  void onResumedSpeaking();

  void onStartedSpeaking();
}
