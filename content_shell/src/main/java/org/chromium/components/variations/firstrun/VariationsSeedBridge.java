package org.chromium.components.variations.firstrun;

import android.util.Base64;
import org.chromium.base.ContextUtils;

public class VariationsSeedBridge {
  protected static final String VARIATIONS_FIRST_RUN_SEED_BASE64 = "variations_seed_base64";
  protected static final String VARIATIONS_FIRST_RUN_SEED_COUNTRY = "variations_seed_country";
  protected static final String VARIATIONS_FIRST_RUN_SEED_DATE = "variations_seed_date_ms";
  protected static final String VARIATIONS_FIRST_RUN_SEED_IS_GZIP_COMPRESSED =
      "variations_seed_is_gzip_compressed";
  protected static final String VARIATIONS_FIRST_RUN_SEED_NATIVE_STORED =
      "variations_seed_native_stored";
  protected static final String VARIATIONS_FIRST_RUN_SEED_SIGNATURE = "variations_seed_signature";

  protected static String getVariationsFirstRunSeedPref(String prefName) {
    return ContextUtils.getAppSharedPreferences().getString(prefName, "");
  }

  public static void setVariationsFirstRunSeed(
      byte[] rawSeed, String signature, String country, long date, boolean isGzipCompressed) {
    ContextUtils.getAppSharedPreferences()
        .edit()
        .putString(VARIATIONS_FIRST_RUN_SEED_BASE64, Base64.encodeToString(rawSeed, 2))
        .putString(VARIATIONS_FIRST_RUN_SEED_SIGNATURE, signature)
        .putString(VARIATIONS_FIRST_RUN_SEED_COUNTRY, country)
        .putLong(VARIATIONS_FIRST_RUN_SEED_DATE, date)
        .putBoolean(VARIATIONS_FIRST_RUN_SEED_IS_GZIP_COMPRESSED, isGzipCompressed)
        .apply();
  }

  private static void clearFirstRunPrefs() {
    ContextUtils.getAppSharedPreferences()
        .edit()
        .remove(VARIATIONS_FIRST_RUN_SEED_BASE64)
        .remove(VARIATIONS_FIRST_RUN_SEED_SIGNATURE)
        .remove(VARIATIONS_FIRST_RUN_SEED_COUNTRY)
        .remove(VARIATIONS_FIRST_RUN_SEED_DATE)
        .remove(VARIATIONS_FIRST_RUN_SEED_IS_GZIP_COMPRESSED)
        .apply();
  }

  public static boolean hasJavaPref() {
    return !ContextUtils.getAppSharedPreferences()
        .getString(VARIATIONS_FIRST_RUN_SEED_BASE64, "")
        .isEmpty();
  }

  public static boolean hasNativePref() {
    return ContextUtils.getAppSharedPreferences()
        .getBoolean(VARIATIONS_FIRST_RUN_SEED_NATIVE_STORED, false);
  }

  private static void markVariationsSeedAsStored() {
    ContextUtils.getAppSharedPreferences()
        .edit()
        .putBoolean(VARIATIONS_FIRST_RUN_SEED_NATIVE_STORED, true)
        .apply();
  }

  private static byte[] getVariationsFirstRunSeedData() {
    return Base64.decode(getVariationsFirstRunSeedPref(VARIATIONS_FIRST_RUN_SEED_BASE64), 2);
  }

  private static String getVariationsFirstRunSeedSignature() {
    return getVariationsFirstRunSeedPref(VARIATIONS_FIRST_RUN_SEED_SIGNATURE);
  }

  private static String getVariationsFirstRunSeedCountry() {
    return getVariationsFirstRunSeedPref(VARIATIONS_FIRST_RUN_SEED_COUNTRY);
  }

  private static long getVariationsFirstRunSeedDate() {
    return ContextUtils.getAppSharedPreferences().getLong(VARIATIONS_FIRST_RUN_SEED_DATE, 0L);
  }

  private static boolean getVariationsFirstRunSeedIsGzipCompressed() {
    return ContextUtils.getAppSharedPreferences()
        .getBoolean(VARIATIONS_FIRST_RUN_SEED_IS_GZIP_COMPRESSED, false);
  }
}
