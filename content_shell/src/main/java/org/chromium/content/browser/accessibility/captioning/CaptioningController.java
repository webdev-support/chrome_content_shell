package org.chromium.content.browser.accessibility.captioning;

import org.chromium.content_public.browser.WebContents;
import org.jni_zero.JNINamespace;

@JNINamespace("content")
public class CaptioningController implements SystemCaptioningBridge.SystemCaptioningBridgeListener {
  private long mNativeCaptioningController;
  private SystemCaptioningBridge mSystemCaptioningBridge = CaptioningBridge.getInstance();

  public interface Natives {
    long init(CaptioningController captioningController, WebContents webContents);

    void setTextTrackSettings(
        long j,
        CaptioningController captioningController,
        boolean z,
        String str,
        String str2,
        String str3,
        String str4,
        String str5,
        String str6,
        String str7);
  }

  public CaptioningController(WebContents webContents) {
    this.mNativeCaptioningController = CaptioningControllerJni.get().init(this, webContents);
  }

  private void onDestroy() {
    this.mNativeCaptioningController = 0L;
  }

  private void onRenderProcessChange() {
    this.mSystemCaptioningBridge.syncToListener(this);
  }

  @Override
  public void onSystemCaptioningChanged(TextTrackSettings settings) {
    if (this.mNativeCaptioningController == 0) {
      return;
    }
    CaptioningControllerJni.get()
        .setTextTrackSettings(
            this.mNativeCaptioningController,
            this,
            settings.getTextTracksEnabled(),
            settings.getTextTrackBackgroundColor(),
            settings.getTextTrackFontFamily(),
            settings.getTextTrackFontStyle(),
            settings.getTextTrackFontVariant(),
            settings.getTextTrackTextColor(),
            settings.getTextTrackTextShadow(),
            settings.getTextTrackTextSize());
  }

  public void startListening() {
    this.mSystemCaptioningBridge.addListener(this);
  }

  public void stopListening() {
    this.mSystemCaptioningBridge.removeListener(this);
  }
}
