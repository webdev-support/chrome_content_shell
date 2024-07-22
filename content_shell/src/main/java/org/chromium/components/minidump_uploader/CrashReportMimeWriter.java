package org.chromium.components.minidump_uploader;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jni_zero.JNINamespace;

@JNINamespace("minidump_uploader")
public class CrashReportMimeWriter {

  private static final String MINIDUMP_KEY = "upload_file_minidump";

  public interface Natives {
    void rewriteAnrsAsMIMEs(String[] strArr, String str);

    void rewriteMinidumpsAsMIMEs(String str, String str2);

    String[] rewriteMinidumpsAsMIMEsAndGetCrashKeys(String str, String str2);
  }

  public static void rewriteMinidumpsAsMIMEs(File srcDir, File destDir) {
    CrashReportMimeWriterJni.get()
        .rewriteMinidumpsAsMIMEs(srcDir.getAbsolutePath(), destDir.getAbsolutePath());
  }

  public static void rewriteAnrsAsMIMEs(List<String> anrs, File destDir) {
    CrashReportMimeWriterJni.get()
        .rewriteAnrsAsMIMEs((String[]) anrs.toArray(new String[0]), destDir.getAbsolutePath());
  }

  public static Map<String, Map<String, String>> rewriteMinidumpsAsMIMEsAndGetCrashKeys(
      File srcDir, File destDir) {
    String[] crashesKeyValueArr =
        CrashReportMimeWriterJni.get()
            .rewriteMinidumpsAsMIMEsAndGetCrashKeys(
                srcDir.getAbsolutePath(), destDir.getAbsolutePath());
    Map<String, Map<String, String>> crashesInfoMap = new HashMap<>();
    Map<String, String> lastCrashInfo = new HashMap<>();
    if (crashesKeyValueArr.length % 2 != 0) {
      throw new AssertionError();
    }
    for (int i = 0; i < crashesKeyValueArr.length; i += 2) {
      String key = crashesKeyValueArr[i];
      String value = crashesKeyValueArr[i + 1];
      if (key.equals(MINIDUMP_KEY)) {
        crashesInfoMap.put(value, lastCrashInfo);
        lastCrashInfo = new HashMap<>();
      } else {
        lastCrashInfo.put(key, value);
      }
    }
    return crashesInfoMap;
  }
}
