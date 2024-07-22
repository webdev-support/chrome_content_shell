package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class FederatedAuthRequestResult {
  public static final int ERROR = 35;
  public static final int ERROR_CANCELED = 30;
  public static final int ERROR_CONFIG_NOT_IN_WELL_KNOWN = 9;
  public static final int ERROR_DISABLED_IN_SETTINGS = 2;
  public static final int ERROR_FETCHING_ACCOUNTS_HTTP_NOT_FOUND = 19;
  public static final int ERROR_FETCHING_ACCOUNTS_INVALID_CONTENT_TYPE = 23;
  public static final int ERROR_FETCHING_ACCOUNTS_INVALID_RESPONSE = 21;
  public static final int ERROR_FETCHING_ACCOUNTS_LIST_EMPTY = 22;
  public static final int ERROR_FETCHING_ACCOUNTS_NO_RESPONSE = 20;
  public static final int ERROR_FETCHING_CLIENT_METADATA_HTTP_NOT_FOUND = 15;
  public static final int ERROR_FETCHING_CLIENT_METADATA_INVALID_CONTENT_TYPE = 18;
  public static final int ERROR_FETCHING_CLIENT_METADATA_INVALID_RESPONSE = 17;
  public static final int ERROR_FETCHING_CLIENT_METADATA_NO_RESPONSE = 16;
  public static final int ERROR_FETCHING_CONFIG_HTTP_NOT_FOUND = 11;
  public static final int ERROR_FETCHING_CONFIG_INVALID_CONTENT_TYPE = 14;
  public static final int ERROR_FETCHING_CONFIG_INVALID_RESPONSE = 13;
  public static final int ERROR_FETCHING_CONFIG_NO_RESPONSE = 12;
  public static final int ERROR_FETCHING_ID_TOKEN_CROSS_SITE_IDP_ERROR_RESPONSE = 28;
  public static final int ERROR_FETCHING_ID_TOKEN_HTTP_NOT_FOUND = 24;
  public static final int ERROR_FETCHING_ID_TOKEN_IDP_ERROR_RESPONSE = 27;
  public static final int ERROR_FETCHING_ID_TOKEN_INVALID_CONTENT_TYPE = 29;
  public static final int ERROR_FETCHING_ID_TOKEN_INVALID_RESPONSE = 26;
  public static final int ERROR_FETCHING_ID_TOKEN_NO_RESPONSE = 25;
  public static final int ERROR_FETCHING_WELL_KNOWN_HTTP_NOT_FOUND = 4;
  public static final int ERROR_FETCHING_WELL_KNOWN_INVALID_CONTENT_TYPE = 8;
  public static final int ERROR_FETCHING_WELL_KNOWN_INVALID_RESPONSE = 6;
  public static final int ERROR_FETCHING_WELL_KNOWN_LIST_EMPTY = 7;
  public static final int ERROR_FETCHING_WELL_KNOWN_NO_RESPONSE = 5;
  public static final int ERROR_NOT_SIGNED_IN_WITH_IDP = 34;
  public static final int ERROR_RP_PAGE_NOT_VISIBLE = 31;
  public static final int ERROR_SILENT_MEDIATION_FAILURE = 32;
  public static final int ERROR_THIRD_PARTY_COOKIES_BLOCKED = 33;
  public static final int ERROR_TOO_MANY_REQUESTS = 3;
  public static final int ERROR_WELL_KNOWN_TOO_BIG = 10;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 35;
  public static final int MIN_VALUE = 0;
  public static final int SHOULD_EMBARGO = 1;
  public static final int SUCCESS = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 35;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private FederatedAuthRequestResult() {}
}
