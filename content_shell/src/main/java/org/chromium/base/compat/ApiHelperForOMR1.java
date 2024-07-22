package org.chromium.base.compat;

import android.view.Window;

public final class ApiHelperForOMR1 {
  private ApiHelperForOMR1() {}

  public static boolean isWideColorGamut(Window window) {
    return window.isWideColorGamut();
  }
}
