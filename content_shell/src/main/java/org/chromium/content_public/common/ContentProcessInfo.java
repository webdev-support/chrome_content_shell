package org.chromium.content_public.common;

public final class ContentProcessInfo {
  private static boolean sIsChildProcess;

  private ContentProcessInfo() {}

  public static void setInChildProcess(boolean inChildProcess) {
    sIsChildProcess = inChildProcess;
  }

  public static boolean inChildProcess() {
    return sIsChildProcess;
  }
}
