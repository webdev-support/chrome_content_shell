package org.chromium.base;

import android.content.Context;
import android.content.res.Configuration;
import android.os.LocaleList;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Locale;
import org.chromium.blink.mojom.WebFeature;

public class LocaleUtils {
  private LocaleUtils() {}

  /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
  public static String getUpdatedLanguageForChromium(String language) {
    char c;
    switch (language.hashCode()) {
      case WebFeature.ATTRIBUTION_REPORTING_API_ALL /* 3365 */:
        if (language.equals("in")) {
          c = 1;
          break;
        }
        c = 65535;
        break;
      case WebFeature.V8RTC_RTP_TRANSCEIVER_STOPPED_ATTRIBUTE_GETTER /* 3374 */:
        if (language.equals("iw")) {
          c = 2;
          break;
        }
        c = 65535;
        break;
      case WebFeature.OBSOLETE_V8_WINDOW_ONSCREENSCHANGE_ATTRIBUTE_SETTER /* 3391 */:
        if (language.equals("ji")) {
          c = 3;
          break;
        }
        c = 65535;
        break;
      case WebFeature.GPU_ADAPTER_NAME /* 3405 */:
        if (language.equals("jw")) {
          c = 4;
          break;
        }
        c = 65535;
        break;
      case WebFeature.NEW_LAYOUT_OVERFLOW_DIFFERENT_AND_ALREADY_SCROLLS_BLOCK /* 3704 */:
        if (language.equals("tl")) {
          c = 5;
          break;
        }
        c = 65535;
        break;
      case 102533:
        if (language.equals("gom")) {
          c = 0;
          break;
        }
        c = 65535;
        break;
      default:
        c = 65535;
        break;
    }
    switch (c) {
      case 0:
        return "kok";
      case 1:
        return "id";
      case 2:
        return "he";
      case 3:
        return "yi";
      case 4:
        return "jv";
      case 5:
        return "fil";
      default:
        return language;
    }
  }

  public static Locale getUpdatedLocaleForChromium(Locale locale) {
    String language = locale.getLanguage();
    String languageForChrome = getUpdatedLanguageForChromium(language);
    if (languageForChrome.equals(language)) {
      return locale;
    }
    return new Locale.Builder().setLocale(locale).setLanguage(languageForChrome).build();
  }

  /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
  public static String getUpdatedLanguageForAndroid(String language) {
    char c;
    switch (language.hashCode()) {
      case 101385:
        if (language.equals("fil")) {
          c = 1;
          break;
        }
        c = 65535;
        break;
      case 115947:
        if (language.equals("und")) {
          c = 0;
          break;
        }
        c = 65535;
        break;
      default:
        c = 65535;
        break;
    }
    switch (c) {
      case 0:
        return "";
      case 1:
        return "tl";
      default:
        return language;
    }
  }

  public static Locale getUpdatedLocaleForAndroid(Locale locale) {
    String language = locale.getLanguage();
    String languageForAndroid = getUpdatedLanguageForAndroid(language);
    if (languageForAndroid.equals(language)) {
      return locale;
    }
    return new Locale.Builder().setLocale(locale).setLanguage(languageForAndroid).build();
  }

  public static Locale forLanguageTag(String languageTag) {
    Locale locale = Locale.forLanguageTag(languageTag);
    return getUpdatedLocaleForAndroid(locale);
  }

  public static String toLanguageTag(Locale locale) {
    String language = getUpdatedLanguageForChromium(locale.getLanguage());
    String country = locale.getCountry();
    if (language.equals("no") && country.equals("NO") && locale.getVariant().equals("NY")) {
      return "nn-NO";
    }
    return country.isEmpty() ? language : language + "-" + country;
  }

  public static String toLanguageTags(LocaleList localeList) {
    ArrayList<String> newLocaleList = new ArrayList<>();
    for (int i = 0; i < localeList.size(); i++) {
      Locale locale = getUpdatedLocaleForChromium(localeList.get(i));
      newLocaleList.add(toLanguageTag(locale));
    }
    return TextUtils.join(",", newLocaleList);
  }

  public static String toBaseLanguage(String languageTag) {
    int pos = languageTag.indexOf(45);
    if (pos < 0) {
      return languageTag;
    }
    return languageTag.substring(0, pos);
  }

  public static boolean isBaseLanguageEqual(String first, String second) {
    return TextUtils.equals(toBaseLanguage(first), toBaseLanguage(second));
  }

  public static String getDefaultLocaleString() {
    return toLanguageTag(Locale.getDefault());
  }

  public static String getDefaultLocaleListString() {
    return toLanguageTags(LocaleList.getDefault());
  }

  public static String getDefaultCountryCode() {
    CommandLine commandLine = CommandLine.getInstance();
    if (commandLine.hasSwitch(BaseSwitches.DEFAULT_COUNTRY_CODE_AT_INSTALL)) {
      return commandLine.getSwitchValue(BaseSwitches.DEFAULT_COUNTRY_CODE_AT_INSTALL);
    }
    return Locale.getDefault().getCountry();
  }

  public static String getConfigurationLanguage(Configuration config) {
    Locale locale = config.locale;
    return locale != null ? locale.toLanguageTag() : "";
  }

  public static String getContextLanguage(Context context) {
    return getConfigurationLanguage(context.getResources().getConfiguration());
  }

  public static void updateConfig(Context base, Configuration config, String languageTag) {
    ApisN.setConfigLocales(base, config, languageTag);
  }

  public static void setDefaultLocalesFromConfiguration(Configuration config) {
    ApisN.setLocaleList(config);
  }

  static class ApisN {
    ApisN() {}

    static void setConfigLocales(Context base, Configuration config, String language) {
      LocaleList updatedLocales =
          prependToLocaleList(language, base.getResources().getConfiguration().getLocales());
      config.setLocales(updatedLocales);
    }

    static void setLocaleList(Configuration config) {
      LocaleList.setDefault(config.getLocales());
    }

    static LocaleList prependToLocaleList(String languageTag, LocaleList localeList) {
      String languageList = localeList.toLanguageTags();
      String pattern = String.format("(^|,)%1$s$|%1$s,", languageTag);
      return LocaleList.forLanguageTags(
          String.format("%1$s,%2$s", languageTag, languageList.replaceFirst(pattern, "")));
    }
  }
}
