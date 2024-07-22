package org.chromium.media;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class DisplayCompat {
  private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
  private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

  private DisplayCompat() {}

  public static ModeCompat[] getSupportedModes(Context context, Display display) {
    Point physicalDisplaySize = getPhysicalDisplaySize(context, display);
    Display.Mode[] supportedModes = display.getSupportedModes();
    ArrayList<ModeCompat> supportedModesCompat = new ArrayList<>(supportedModes.length);
    boolean nativeModeExists = false;
    for (int i = 0; i < supportedModes.length; i++) {
      if (physicalSizeEquals(supportedModes[i], physicalDisplaySize)) {
        supportedModesCompat.add(i, new ModeCompat(supportedModes[i], true));
        nativeModeExists = true;
      } else {
        supportedModesCompat.add(i, new ModeCompat(supportedModes[i], false));
      }
    }
    if (!nativeModeExists) {
      supportedModesCompat.add(new ModeCompat(physicalDisplaySize));
    }
    return (ModeCompat[]) supportedModesCompat.toArray(new ModeCompat[0]);
  }

  public static boolean isTv(Context context) {
    UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
    return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
  }

  private static Point parseDisplaySize(String displaySize) throws NumberFormatException {
    String[] displaySizeParts = displaySize.trim().split("x", -1);
    if (displaySizeParts.length == 2) {
      int width = Integer.parseInt(displaySizeParts[0]);
      int height = Integer.parseInt(displaySizeParts[1]);
      if (width > 0 && height > 0) {
        return new Point(width, height);
      }
    }
    throw new NumberFormatException();
  }

  private static String getSystemProperty(String name) {
    try {
      Class<?> systemProperties = Class.forName("android.os.SystemProperties");
      Method getMethod = systemProperties.getMethod("get", String.class);
      return (String) getMethod.invoke(systemProperties, name);
    } catch (Exception e) {
      return null;
    }
  }

  private static boolean physicalSizeEquals(Display.Mode mode, Point size) {
    return (mode.getPhysicalWidth() == size.x && mode.getPhysicalHeight() == size.y)
        || (mode.getPhysicalWidth() == size.y && mode.getPhysicalHeight() == size.x);
  }

  private static Point parsePhysicalDisplaySizeFromSystemProperties(
      String property, Display display) {
    if (display.getDisplayId() == 0) {
      String displaySize = getSystemProperty(property);
      if (!TextUtils.isEmpty(displaySize)) {
        try {
          return parseDisplaySize(displaySize);
        } catch (NumberFormatException e) {
          return null;
        }
      }
      return null;
    }
    return null;
  }

  private static Point getPhysicalDisplaySize(Context context, Display display) {
    Point displaySize;
    if (Build.VERSION.SDK_INT < 28) {
      displaySize = parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", display);
    } else {
      displaySize = parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", display);
    }
    if (displaySize != null) {
      return displaySize;
    }
    if (isSonyBravia4kTv(context)) {
      return new Point(3840, DISPLAY_SIZE_4K_HEIGHT);
    }
    Point displaySize2 = new Point();
    Display.Mode mode = display.getMode();
    displaySize2.x = mode.getPhysicalWidth();
    displaySize2.y = mode.getPhysicalHeight();
    return displaySize2;
  }

  private static boolean isSonyBravia4kTv(Context context) {
    return isTv(context)
        && "Sony".equals(Build.MANUFACTURER)
        && Build.MODEL.startsWith("BRAVIA")
        && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
  }

  public static final class ModeCompat {
    private final boolean mIsNative;
    private final Display.Mode mMode;
    private final Point mPhysicalDisplaySize;

    ModeCompat(Point physicalDisplaySize) {
      if (physicalDisplaySize == null) {
        throw new NullPointerException("physicalDisplaySize == null");
      }
      this.mIsNative = true;
      this.mPhysicalDisplaySize = physicalDisplaySize;
      this.mMode = null;
    }

    ModeCompat(Display.Mode mode, boolean isNative) {
      if (mode == null) {
        throw new NullPointerException("Display.Mode == null, can't wrap a null reference");
      }
      this.mIsNative = isNative;
      this.mPhysicalDisplaySize = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
      this.mMode = mode;
    }

    public int getPhysicalWidth() {
      return this.mPhysicalDisplaySize.x;
    }

    public int getPhysicalHeight() {
      return this.mPhysicalDisplaySize.y;
    }

    public Display.Mode toMode() {
      return this.mMode;
    }

    public boolean isNative() {
      return this.mIsNative;
    }
  }
}
