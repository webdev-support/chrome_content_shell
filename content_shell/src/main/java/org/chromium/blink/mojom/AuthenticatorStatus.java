package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class AuthenticatorStatus {
  public static final int ABORT_ERROR = 13;
  public static final int ALGORITHM_UNSUPPORTED = 9;
  public static final int ANDROID_NOT_SUPPORTED_ERROR = 11;
  public static final int BAD_RELYING_PARTY_ID = 16;
  public static final int BAD_RELYING_PARTY_ID_ATTEMPTED_FETCH = 17;
  public static final int BAD_RELYING_PARTY_ID_JSON_PARSE_ERROR = 19;
  public static final int BAD_RELYING_PARTY_ID_NO_JSON_MATCH = 20;
  public static final int BAD_RELYING_PARTY_ID_NO_JSON_MATCH_HIT_LIMITS = 21;
  public static final int BAD_RELYING_PARTY_ID_WRONG_CONTENT_TYPE = 18;
  public static final int CANNOT_READ_AND_WRITE_LARGE_BLOB = 22;
  public static final int CERTIFICATE_ERROR = 27;
  public static final int CREDENTIAL_EXCLUDED = 4;
  public static final int DEVICE_PUBLIC_KEY_ATTESTATION_REJECTED = 26;
  public static final int EMPTY_ALLOW_CREDENTIALS = 10;
  public static final int ERROR_WITH_DOM_EXCEPTION_DETAILS = 28;
  public static final int FAILED_TO_SAVE_CREDENTIAL_ID_FOR_PAYMENT_EXTENSION = 24;
  public static final int INVALID_ALLOW_CREDENTIALS_FOR_LARGE_BLOB = 23;
  public static final int INVALID_DOMAIN = 3;
  public static final int INVALID_PROTOCOL = 15;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 29;
  public static final int MIN_VALUE = 0;
  public static final int NOT_ALLOWED_ERROR = 2;
  public static final int NOT_FOCUSED = 6;
  public static final int NOT_IMPLEMENTED = 5;
  public static final int OPAQUE_DOMAIN = 14;
  public static final int PENDING_REQUEST = 1;
  public static final int PROTECTION_POLICY_INCONSISTENT = 12;
  public static final int REMOTE_DESKTOP_CLIENT_OVERRIDE_NOT_AUTHORIZED = 25;
  public static final int RESIDENT_CREDENTIALS_UNSUPPORTED = 7;
  public static final int SUCCESS = 0;
  public static final int UNKNOWN_ERROR = 29;
  public static final int USER_VERIFICATION_UNSUPPORTED = 8;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 29;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private AuthenticatorStatus() {}
}
