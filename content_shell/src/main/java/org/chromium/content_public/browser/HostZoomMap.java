package org.chromium.content_public.browser;

import java.util.Map;
import org.chromium.content.browser.HostZoomMapImpl;

public class HostZoomMap {

  public static final float TEXT_SIZE_MULTIPLIER_RATIO = 1.2f;
  public static final double[] AVAILABLE_ZOOM_FACTORS = {
    -3.8d, -2.2d, -1.58d, -1.22d, -0.58d, 0.0d, 0.52d, 1.22d, 1.56d, 2.22d, 3.07d, 3.8d, 5.03d,
    6.03d
  };
  private static float sSystemFontScale = 1.0f;

  private HostZoomMap() {}

  public static void setZoomLevel(WebContents webContents, double newZoomLevel) {
    if (webContents.isDestroyed()) {
      throw new AssertionError();
    }
    HostZoomMapImpl.setZoomLevel(
        webContents, newZoomLevel, HostZoomMapImpl.adjustZoomLevel(newZoomLevel, sSystemFontScale));
  }

  public static float getSystemFontScale() {
    return sSystemFontScale;
  }

  public static void setSystemFontScale(float newSystemFontScale) {
    sSystemFontScale = newSystemFontScale;
  }

  public static double getZoomLevel(WebContents webContents) {
    if (webContents.isDestroyed()) {
      throw new AssertionError();
    }
    return HostZoomMapImpl.adjustZoomLevel(
        HostZoomMapImpl.getZoomLevel(webContents), 1.0f / sSystemFontScale);
  }

  public static Map<String, Double> getAllHostZoomLevels(
      BrowserContextHandle browserContextHandle) {
    return HostZoomMapImpl.getAllHostZoomLevels(browserContextHandle);
  }

  public static void setZoomLevelForHost(
      BrowserContextHandle browserContextHandle, String host, double level) {
    HostZoomMapImpl.setZoomLevelForHost(browserContextHandle, host, level);
  }

  public static void setDefaultZoomLevel(BrowserContextHandle context, double newDefaultZoomLevel) {
    HostZoomMapImpl.setDefaultZoomLevel(context, newDefaultZoomLevel);
  }

  public static boolean shouldAdjustForOSLevel() {
    return HostZoomMapImpl.shouldAdjustForOSLevel();
  }

  public static double getDefaultZoomLevel(BrowserContextHandle context) {
    return HostZoomMapImpl.getDefaultZoomLevel(context);
  }
}
