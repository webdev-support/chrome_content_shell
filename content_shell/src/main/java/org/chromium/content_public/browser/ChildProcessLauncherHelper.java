package org.chromium.content_public.browser;

import android.content.Context;
import org.chromium.content.browser.ChildProcessLauncherHelperImpl;

public final class ChildProcessLauncherHelper {
  private ChildProcessLauncherHelper() {}

  public static void warmUp(Context context, boolean sandboxed) {
    ChildProcessLauncherHelperImpl.warmUp(context, sandboxed);
  }

  public static void startBindingManagement(Context context) {
    ChildProcessLauncherHelperImpl.startBindingManagement(context);
  }
}
