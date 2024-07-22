package org.chromium.content.browser.accessibility.captioning;

import android.view.accessibility.CaptioningManager;
import java.util.Locale;
import org.chromium.base.ContextUtils;

public class CaptioningBridge extends CaptioningManager.CaptioningChangeListener
    implements SystemCaptioningBridge {
  private static CaptioningBridge sInstance;
  private final CaptioningChangeDelegate mCaptioningChangeDelegate = new CaptioningChangeDelegate();
  private final CaptioningManager mCaptioningManager =
      (CaptioningManager) ContextUtils.getApplicationContext().getSystemService("captioning");

  public static CaptioningBridge getInstance() {
    if (sInstance == null) {
      sInstance = new CaptioningBridge();
    }
    return sInstance;
  }

  private CaptioningBridge() {}

  @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
  public void onEnabledChanged(boolean enabled) {
    this.mCaptioningChangeDelegate.onEnabledChanged(enabled);
  }

  @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
  public void onFontScaleChanged(float fontScale) {
    this.mCaptioningChangeDelegate.onFontScaleChanged(fontScale);
  }

  @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
  public void onLocaleChanged(Locale locale) {
    this.mCaptioningChangeDelegate.onLocaleChanged(locale);
  }

  @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
  public void onUserStyleChanged(CaptioningManager.CaptionStyle userStyle) {
    CaptioningStyle captioningStyle = getCaptioningStyleFrom(userStyle);
    this.mCaptioningChangeDelegate.onUserStyleChanged(captioningStyle);
  }

  private void syncToDelegate() {
    this.mCaptioningChangeDelegate.onEnabledChanged(this.mCaptioningManager.isEnabled());
    this.mCaptioningChangeDelegate.onFontScaleChanged(this.mCaptioningManager.getFontScale());
    this.mCaptioningChangeDelegate.onLocaleChanged(this.mCaptioningManager.getLocale());
    this.mCaptioningChangeDelegate.onUserStyleChanged(
        getCaptioningStyleFrom(this.mCaptioningManager.getUserStyle()));
  }

  @Override
  public void syncToListener(SystemCaptioningBridge.SystemCaptioningBridgeListener listener) {
    if (!this.mCaptioningChangeDelegate.hasActiveListener()) {
      syncToDelegate();
    }
    this.mCaptioningChangeDelegate.notifyListener(listener);
  }

  @Override
  public void addListener(SystemCaptioningBridge.SystemCaptioningBridgeListener listener) {
    if (!this.mCaptioningChangeDelegate.hasActiveListener()) {
      this.mCaptioningManager.addCaptioningChangeListener(this);
      syncToDelegate();
    }
    this.mCaptioningChangeDelegate.addListener(listener);
    this.mCaptioningChangeDelegate.notifyListener(listener);
  }

  @Override
  public void removeListener(SystemCaptioningBridge.SystemCaptioningBridgeListener listener) {
    this.mCaptioningChangeDelegate.removeListener(listener);
    if (!this.mCaptioningChangeDelegate.hasActiveListener()) {
      this.mCaptioningManager.removeCaptioningChangeListener(this);
    }
  }

  private CaptioningStyle getCaptioningStyleFrom(CaptioningManager.CaptionStyle userStyle) {
    return CaptioningStyle.createFrom(userStyle);
  }
}
