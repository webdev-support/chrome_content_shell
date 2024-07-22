package org.chromium.content_public.browser;

import org.chromium.content.browser.SpeechRecognitionImpl;

public final class SpeechRecognition {
  private SpeechRecognition() {}

  public static boolean initialize() {
    return SpeechRecognitionImpl.initialize();
  }
}
