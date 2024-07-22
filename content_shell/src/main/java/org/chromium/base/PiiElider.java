package org.chromium.base;

import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PiiElider {

  private static final String CONSOLE_ELISION = "[ELIDED:CONSOLE(0)] ELIDED CONSOLE MESSAGE";
  private static final String DOMAIN_NAME =
      "(([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-\ufdcfﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))";
  private static final String EMAIL_ELISION = "XXX@EMAIL.ELIDED";
  private static final String GOOD_GTLD_CHAR = "a-zA-Z -\ud7ff豈-\ufdcfﷰ-\uffef";
  private static final String GOOD_IRI_CHAR = "a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef";
  private static final String GTLD = "[a-zA-Z -\ud7ff豈-\ufdcfﷰ-\uffef]{2,63}";
  private static final String HOST_NAME =
      "([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-\ufdcfﷰ-\uffef]{2,63}";
  private static final String INTENT =
      "([a-zA-Z][a-zA-Z0-9+.-]+://((([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+))";
  private static final String INTENT_SCHEME = "[a-zA-Z][a-zA-Z0-9+.-]+://";
  private static final String IP_ADDRESS =
      "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))";
  private static final String IP_ELISION = "1.2.3.4";
  private static final String IRI =
      "[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]){0,1}";
  private static final String MAC_ELISION = "01:23:45:67:89:AB";
  private static final String PATH_CHAR =
      "(([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))";
  private static final String PATH_COMPONENT =
      "((([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+)";
  private static final String PORT = "(:\\d{1,5})";
  private static final String URI_CHAR = "([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2}))";
  private static final String URI_ENCODED_CHAR = "(%[a-fA-F0-9]{2})";
  private static final String URI_SCHEME =
      "((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)";
  private static final String URL_ELISION = "HTTP://WEBADDRESS.ELIDED";
  private static final String URL_OR_INTENT =
      "((((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)?(([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-\ufdcfﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(:\\d{1,5})?)|([a-zA-Z][a-zA-Z0-9+.-]+://((([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+)))";
  private static final String URL_WITH_OPTIONAL_SCHEME_AND_PORT =
      "(((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)?(([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-\ufdcfﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(:\\d{1,5})?)";
  private static final Pattern WEB_URL =
      Pattern.compile(
          "(\\b|^)(((((http|https|Http|Https|rtsp|Rtsp)://(([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,64}(:([a-zA-Z0-9$_.+!*'(),;?&=-]|(%[a-fA-F0-9]{2})){1,25})?@)?)?(([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef-]{0,61}[a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-\ufdcfﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(:\\d{1,5})?)|([a-zA-Z][a-zA-Z0-9+.-]+://((([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))+))))(/(([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef;/?:@&=#~.+!*'(),_-])|(%[a-fA-F0-9]{2}))*)?(\\b|$)");
  private static final Pattern NOT_URLS_PATTERN =
      Pattern.compile(
          "^(?:Caused by: )?java\\.lang\\.(?:ClassNotFoundException|NoClassDefFoundError):|(?:[\"' ]/(?:apex|data|mnt|proc|sdcard|storage|system))/");
  private static final Pattern MAC_ADDRESS =
      Pattern.compile("([0-9a-fA-F]{2}[-:]+){5}[0-9a-fA-F]{2}");
  private static final Pattern CONSOLE_MSG = Pattern.compile("\\[\\w*:CONSOLE.*\\].*");
  private static final String[] APP_NAMESPACE = {"org.chromium.", "com.google.", "com.chrome."};
  private static final String[] SYSTEM_NAMESPACE = {
    "android.",
    "com.android.",
    "dalvik.",
    "java.",
    "javax.",
    "org.apache.",
    "org.json.",
    "org.w3c.dom.",
    "org.xml.",
    "org.xmlpull.",
    "System."
  };

  public static String elideEmail(String original) {
    return Patterns.EMAIL_ADDRESS.matcher(original).replaceAll(EMAIL_ELISION);
  }

  public static String elideUrl(String original) {
    if (NOT_URLS_PATTERN.matcher(original).find()) {
      return original;
    }
    StringBuilder buffer = new StringBuilder(original);
    Matcher matcher = WEB_URL.matcher(buffer);
    int start = 0;
    while (matcher.find(start)) {
      int start2 = matcher.start();
      int end = matcher.end();
      String url = buffer.substring(start2, end);
      if (!likelyToBeAppNamespace(url)
          && !likelyToBeSystemNamespace(url)
          && !likelyToBeClassOrMethodName(url)) {
        buffer.replace(start2, end, URL_ELISION);
        end = start2 + URL_ELISION.length();
        matcher = WEB_URL.matcher(buffer);
      }
      start = end;
    }
    return buffer.toString();
  }

  private static boolean likelyToBeClassOrMethodName(String url) {
    if (isClassName(url)) {
      return true;
    }
    int indexOfLastPeriod = url.lastIndexOf(".");
    if (indexOfLastPeriod == -1) {
      return false;
    }
    return isClassName(url.substring(0, indexOfLastPeriod));
  }

  private static boolean isClassName(String url) {
    try {
      Class.forName(url, false, ContextUtils.getApplicationContext().getClassLoader());
      return true;
    } catch (Throwable th) {
      return false;
    }
  }

  private static boolean likelyToBeAppNamespace(String url) {
    String[] strArr;
    for (String ns : APP_NAMESPACE) {
      if (url.startsWith(ns)) {
        return true;
      }
    }
    return false;
  }

  private static boolean likelyToBeSystemNamespace(String url) {
    String[] strArr;
    for (String ns : SYSTEM_NAMESPACE) {
      if (url.startsWith(ns)) {
        return true;
      }
    }
    return false;
  }

  public static String elideIp(String original) {
    return Patterns.IP_ADDRESS.matcher(original).replaceAll(IP_ELISION);
  }

  public static String elideMac(String original) {
    return MAC_ADDRESS.matcher(original).replaceAll(MAC_ELISION);
  }

  public static String elideConsole(String original) {
    return CONSOLE_MSG.matcher(original).replaceAll(CONSOLE_ELISION);
  }

  public static String sanitizeStacktrace(String stacktrace) {
    if (TextUtils.isEmpty(stacktrace)) {
      return "";
    }
    String[] lines = stacktrace.split("\\n");
    boolean foundAtLine = false;
    for (int i = 0; i < lines.length; i++) {
      if (lines[i].startsWith("\tat ")) {
        foundAtLine = true;
      } else {
        lines[i] = elideUrl(lines[i]);
      }
    }
    if (foundAtLine || lines.length == 1) {
      return TextUtils.join("\n", lines);
    }
    throw new AssertionError("Was not a stack trace: " + stacktrace);
  }
}
