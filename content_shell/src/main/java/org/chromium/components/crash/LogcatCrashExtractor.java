package org.chromium.components.crash;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.chromium.base.Log;
import org.chromium.base.PiiElider;
import org.chromium.components.minidump_uploader.CrashFileManager;

public class LogcatCrashExtractor {
  protected static final String BEGIN_MICRODUMP = "-----BEGIN BREAKPAD MICRODUMP-----";
  protected static final String END_MICRODUMP = "-----END BREAKPAD MICRODUMP-----";
  private static final long HALF_SECOND = 500;
  protected static final int LOGCAT_SIZE = 256;
  protected static final String SNIPPED_MICRODUMP =
      "-----SNIPPED OUT BREAKPAD MICRODUMP FOR THIS CRASH-----";
  private static final String TAG = "LogcatCrashExtractor";

  public File attachLogcatToMinidump(File minidump, CrashFileManager fileManager) {
    Log.i(TAG, "Trying to extract logcat for minidump %s.", minidump.getName());
    File fileToUpload = minidump;
    try {
      List<String> logcat = getElidedLogcat();
      fileToUpload = new MinidumpLogcatPrepender(fileManager, minidump, logcat).run();
      Log.i(TAG, "Succeeded extracting logcat to %s.", fileToUpload.getName());
      return fileToUpload;
    } catch (IOException | InterruptedException e) {
      Log.w(TAG, e.toString());
      return fileToUpload;
    }
  }

  private List<String> getElidedLogcat() throws IOException, InterruptedException {
    List<String> rawLogcat = getLogcat();
    return Collections.unmodifiableList(elideLogcat(rawLogcat));
  }

  protected List<String> getLogcat() throws IOException, InterruptedException {
    Process p = Runtime.getRuntime().exec("logcat -d");
    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
    LinkedList<String> rawLogcat = new LinkedList<>();
    Integer exitValue = null;
    while (exitValue == null) {
      while (true) {
        try {
          String logLn = reader.readLine();
          if (logLn != null) {
            rawLogcat.add(logLn);
            if (rawLogcat.size() > 1024) {
              rawLogcat.removeFirst();
            }
          } else {
            try {
              break;
            } catch (IllegalThreadStateException e) {
              Thread.sleep(500L);
            }
          }
        } catch (Throwable th) {
          reader.close();
          throw th;
        }
      }
      exitValue = Integer.valueOf(p.exitValue());
    }
    reader.close();
    if (exitValue.intValue() != 0) {
      String msg = "Logcat failed: " + exitValue;
      Log.w(TAG, msg);
      throw new IOException(msg);
    }
    return trimLogcat(rawLogcat, 256);
  }

  protected static List<String> trimLogcat(List<String> rawLogcat, int maxLines) {
    int i = rawLogcat.size() - 1;
    while (true) {
      if (i < 0) {
        break;
      } else if (!rawLogcat.get(i).contains(BEGIN_MICRODUMP)) {
        i--;
      } else {
        rawLogcat = rawLogcat.subList(0, i);
        rawLogcat.add(SNIPPED_MICRODUMP);
        break;
      }
    }
    int i2 = rawLogcat.size();
    if (i2 > maxLines) {
      return rawLogcat.subList(rawLogcat.size() - maxLines, rawLogcat.size());
    }
    return rawLogcat;
  }

  protected static List<String> elideLogcat(List<String> rawLogcat) {
    List<String> elided = new ArrayList<>(rawLogcat.size());
    for (String ln : rawLogcat) {
      elided.add(
          PiiElider.elideConsole(
              PiiElider.elideMac(PiiElider.elideIp(PiiElider.elideUrl(PiiElider.elideEmail(ln))))));
    }
    return elided;
  }
}
