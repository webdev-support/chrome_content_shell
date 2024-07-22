package org.chromium.components.variations;

public final class VariationsSwitches {
  public static final String ACCEPT_EMPTY_SEED_SIGNATURE_FOR_TESTING =
      "accept-empty-variations-seed-signature";
  public static final String DISABLE_FIELD_TRIAL_TESTING_CONFIG = "disable-field-trial-config";
  public static final String DISABLE_VARIATIONS_SAFE_MODE = "disable-variations-safe-mode";
  public static final String DISABLE_VARIATIONS_SEED_FETCH_THROTTLING =
      "disable-variations-seed-fetch-throttling";
  public static final String ENABLE_BENCHMARKING = "enable-benchmarking";
  public static final String ENABLE_FIELD_TRIAL_TESTING_CONFIG = "enable-field-trial-config";
  public static final String ENABLE_FINCH_SEED_DELTA_COMPRESSION =
      "enable-finch-seed-delta-compression";
  public static final String FAKE_VARIATIONS_CHANNEL = "fake-variations-channel";
  public static final String FORCE_DISABLE_VARIATION_IDS = "force-disable-variation-ids";
  public static final String FORCE_FIELD_TRIAL_PARAMS = "force-fieldtrial-params";
  public static final String FORCE_VARIATION_IDS = "force-variation-ids";
  public static final String VARIATIONS_INSECURE_SERVER_URL = "variations-insecure-server-url";
  public static final String VARIATIONS_OVERRIDE_COUNTRY = "variations-override-country";
  public static final String VARIATIONS_SEED_FETCH_INTERVAL = "variations-seed-fetch-interval";
  public static final String VARIATIONS_SEED_VERSION = "variations-seed-version";
  public static final String VARIATIONS_SERVER_URL = "variations-server-url";
  public static final String VARIATIONS_TEST_SEED_JSON_PATH = "variations-test-seed-path";

  private VariationsSwitches() {}
}
