package org.chromium.content_public.browser;

import org.chromium.content.browser.selection.LGEmailActionModeWorkaroundImpl;

public final class LGEmailActionModeWorkaround {
  private LGEmailActionModeWorkaround() {}

  public static boolean isSafeVersion(int versionCode) {
    return LGEmailActionModeWorkaroundImpl.isSafeVersion(versionCode);
  }
}
