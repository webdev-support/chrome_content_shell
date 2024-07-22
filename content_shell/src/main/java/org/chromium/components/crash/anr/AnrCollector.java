package org.chromium.components.crash.anr;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Pair;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.metrics.RecordHistogram;

public class AnrCollector {
  private static final String ANR_SKIPPED_UMA = "Crashpad.AnrUpload.Skipped";
  private static final String ANR_TIMESTAMP_SHARED_PREFS_KEY = "ANR_ALREADY_UPLOADED_TIMESTAMP";
  private static final String TAG = "AnrCollector";

  public interface Natives {
    String getSharedLibraryBuildId();
  }

  public static List<String> collectAndWriteAnrs(File outDir) {
    if (Build.VERSION.SDK_INT < 30) {
      return Collections.emptyList();
    }
    return writeAnrs(collectAnrs(), outDir);
  }

  public static String getSharedLibraryBuildId() {
    return AnrCollectorJni.get().getSharedLibraryBuildId();
  }

  static AnrDataOuterClass.AnrData parseAnrFromReport(BufferedReader reader) throws IOException {
    Pattern threadFirstLine = Pattern.compile("\"(.*)\".*prio=\\d+ tid=\\d+ \\w+");
    StringBuilder preamble = new StringBuilder();
    StringBuilder mainThreadStackTrace = new StringBuilder();
    StringBuilder stackTraces = new StringBuilder();
    StringBuilder curBuilder = preamble;
    while (true) {
      String line = reader.readLine();
      if (line != null) {
        Matcher threadLineMatcher = threadFirstLine.matcher(line);
        if (threadLineMatcher.matches()) {
          if (threadLineMatcher.group(1).equals("main")) {
            curBuilder = mainThreadStackTrace;
          } else {
            curBuilder = stackTraces;
          }
        }
        curBuilder.append(line).append("\n");
      } else {
        AnrDataOuterClass.AnrData anrData =
            AnrDataOuterClass.AnrData.newBuilder()
                .setCause("Chrome_ANR_Cause")
                .setPreamble(preamble.toString())
                .setMainThreadStackTrace(mainThreadStackTrace.toString())
                .setStackTraces(stackTraces.toString())
                .build();
        return anrData;
      }
    }
  }

  private static Pair<AnrDataOuterClass.AnrData, String> getAnrPair(ApplicationExitInfo reason) {
    try {
      InputStream is = reason.getTraceInputStream();
      if (is != null) {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        AnrDataOuterClass.AnrData anr = parseAnrFromReport(in);
        in.close();
        if (is != null) {
          is.close();
        }
        byte[] processStateSummaryBytes = reason.getProcessStateSummary();
        if (processStateSummaryBytes == null || processStateSummaryBytes.length == 0) {
          RecordHistogram.recordEnumeratedHistogram(ANR_SKIPPED_UMA, 2, 4);
          return null;
        }
        String processStateSummary = new String(processStateSummaryBytes, StandardCharsets.UTF_8);
        return new Pair<>(anr, processStateSummary);
      }
      if (is != null) {
        is.close();
      }
      return null;
    } catch (IOException e) {
      Log.e(TAG, "Couldn't read ANR from system", (Throwable) e);
      RecordHistogram.recordEnumeratedHistogram(ANR_SKIPPED_UMA, 0, 4);
      return null;
    }
  }

  private static List<Pair<AnrDataOuterClass.AnrData, String>> collectAnrs() {
    Pair<AnrDataOuterClass.AnrData, String> pair;
    ActivityManager am =
        (ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity");
    SharedPreferences prefs = ContextUtils.getAppSharedPreferences();
    long lastHandledTime = prefs.getLong(ANR_TIMESTAMP_SHARED_PREFS_KEY, 0L);
    long maxHandledTime = lastHandledTime;
    List<ApplicationExitInfo> reasons = am.getHistoricalProcessExitReasons(null, 0, 0);
    List<Pair<AnrDataOuterClass.AnrData, String>> anrs = new ArrayList<>();
    for (ApplicationExitInfo reason : reasons) {
      long time = reason.getTimestamp();
      if (reason.getReason() == 6
          && time > lastHandledTime
          && (pair = getAnrPair(reason)) != null) {
        anrs.add(pair);
        if (time > maxHandledTime) {
          maxHandledTime = time;
        }
      }
    }
    SharedPreferences.Editor editor = prefs.edit();
    editor.putLong(ANR_TIMESTAMP_SHARED_PREFS_KEY, maxHandledTime);
    editor.apply();
    return anrs;
  }

  private static List<String> writeAnrs(
      List<Pair<AnrDataOuterClass.AnrData, String>> anrs, File outDir) {
    List<String> anrFiles = new ArrayList<>();
    for (Pair<AnrDataOuterClass.AnrData, String> pair : anrs) {
      AnrDataOuterClass.AnrData anr = (AnrDataOuterClass.AnrData) pair.first;
      String[] splitStateSummary = ((String) pair.second).split(",");
      String version = splitStateSummary[0];
      String buildId = "";
      if (splitStateSummary.length > 1) {
        buildId = splitStateSummary[1];
        RecordHistogram.recordEnumeratedHistogram(ANR_SKIPPED_UMA, 4, 4);
      } else {
        RecordHistogram.recordEnumeratedHistogram(ANR_SKIPPED_UMA, 3, 4);
      }
      String anrFileName = writeAnr(anr, outDir);
      if (anrFileName != null) {
        anrFiles.add(anrFileName);
        anrFiles.add(version);
        anrFiles.add(buildId);
      }
    }
    return anrFiles;
  }

  private static String writeAnr(AnrDataOuterClass.AnrData data, File outDir) {
    try {
      File anrFile = File.createTempFile("anr_data_proto", ".tmp", outDir);
      FileOutputStream out = new FileOutputStream(anrFile);
      data.writeTo(out);
      out.close();
      return anrFile.getAbsolutePath();
    } catch (IOException e) {
      Log.e(TAG, "Couldn't write ANR proto", (Throwable) e);
      RecordHistogram.recordEnumeratedHistogram(ANR_SKIPPED_UMA, 1, 4);
      return null;
    }
  }

  private AnrCollector() {}
}
