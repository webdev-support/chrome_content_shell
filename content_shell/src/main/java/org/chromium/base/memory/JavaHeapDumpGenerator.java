package org.chromium.base.memory;

import android.os.Debug;
import java.io.IOException;
import org.chromium.base.Log;

public final class JavaHeapDumpGenerator {
  private static final String TAG = "JavaHprofGenerator";

  private JavaHeapDumpGenerator() {}

  public static boolean generateHprof(String filePath) {
    try {
      Debug.dumpHprofData(filePath);
      return true;
    } catch (IOException e) {
      Log.i(TAG, "Error writing to file " + filePath + ". Error: " + e.getMessage());
      return false;
    }
  }
}
