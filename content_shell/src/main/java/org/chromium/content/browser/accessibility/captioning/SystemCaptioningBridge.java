package org.chromium.content.browser.accessibility.captioning;

public interface SystemCaptioningBridge {

  public interface SystemCaptioningBridgeListener {
    void onSystemCaptioningChanged(TextTrackSettings textTrackSettings);
  }

  void addListener(SystemCaptioningBridgeListener systemCaptioningBridgeListener);

  void removeListener(SystemCaptioningBridgeListener systemCaptioningBridgeListener);

  void syncToListener(SystemCaptioningBridgeListener systemCaptioningBridgeListener);
}
