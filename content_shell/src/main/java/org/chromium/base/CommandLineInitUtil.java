package org.chromium.base;

import android.content.Context;
import android.provider.Settings;
import java.io.File;
import org.chromium.base.supplier.Supplier;

public final class CommandLineInitUtil {

  private static final String COMMAND_LINE_FILE_PATH = "/data/local";
  private static final String COMMAND_LINE_FILE_PATH_DEBUG_APP = "/data/local/tmp";
  private static String sFilenameOverrideForTesting;

  private CommandLineInitUtil() {}

  public static void setFilenameOverrideForTesting(String value) {
    sFilenameOverrideForTesting = value;
  }

  public static void initCommandLine(String fileName) {
    initCommandLine(fileName, null);
  }

  public static void initCommandLine(String fileName, Supplier<Boolean> shouldUseDebugFlags) {
    if (sFilenameOverrideForTesting != null) {
      fileName = sFilenameOverrideForTesting;
    }
    if (CommandLine.isInitialized()) {
      throw new AssertionError();
    }
    File commandLineFile = new File(COMMAND_LINE_FILE_PATH_DEBUG_APP, fileName);
    boolean debugFlagsExist = commandLineFile.exists();
    if (!debugFlagsExist || !shouldUseDebugCommandLine(shouldUseDebugFlags)) {
      commandLineFile = new File(COMMAND_LINE_FILE_PATH, fileName);
    }
    CommandLine.initFromFile(commandLineFile.getPath());
  }

  private static boolean shouldUseDebugCommandLine(Supplier<Boolean> shouldUseDebugFlags) {
    if (shouldUseDebugFlags != null && shouldUseDebugFlags.get().booleanValue()) {
      return true;
    }
    Context context = ContextUtils.getApplicationContext();
    return context.getPackageName().equals(getDebugApp(context)) || BuildInfo.isDebugAndroid();
  }

  private static String getDebugApp(Context context) {
    boolean adbEnabled =
        Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) == 1;
    if (adbEnabled) {
      return Settings.Global.getString(context.getContentResolver(), "debug_app");
    }
    return null;
  }
}
