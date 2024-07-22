package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class OriginTrialFeature {
  public static final int ADD_IDENTITY_IN_CAN_MAKE_PAYMENT_EVENT = 1;
  public static final int AD_INTEREST_GROUP_API = 2;
  public static final int APP_TITLE = 3;
  public static final int ATTRIBUTION_REPORTING = 4;
  public static final int ATTRIBUTION_REPORTING_CROSS_APP_WEB = 5;
  public static final int ATTRIBUTION_REPORTING_INTERFACE = 6;
  public static final int AUTO_DARK_MODE = 7;
  public static final int BACK_FORWARD_CACHE_EXPERIMENT_HTTP_HEADER = 8;
  public static final int BACK_FORWARD_CACHE_NOT_RESTORED_REASONS = 9;
  public static final int CACHE_STORAGE_CODE_CACHE_HINT = 10;
  public static final int CAPTURED_SURFACE_CONTROL = 11;
  public static final int COMPRESSION_DICTIONARY_TRANSPORT = 12;
  public static final int COMPUTE_PRESSURE = 13;
  public static final int COOP_RESTRICT_PROPERTIES = 14;
  public static final int DATABASE = 15;
  public static final int DEPRECATE_UNLOAD_OPT_OUT = 16;
  public static final int DIGITAL_GOODS = 17;
  public static final int DISABLE_DIFFERENT_ORIGIN_SUBFRAME_DIALOG_SUPPRESSION = 18;
  public static final int DISABLE_HARDWARE_NOISE_SUPPRESSION = 19;

  public static final int f445x8d9ee244 = 20;
  public static final int DISABLE_THIRD_PARTY_STORAGE_PARTITIONING = 21;
  public static final int DOCUMENT_POLICY_NEGOTIATION = 22;
  public static final int EDIT_CONTEXT = 23;
  public static final int ELEMENT_CAPTURE = 24;
  public static final int FENCED_FRAMES = 25;
  public static final int FENCED_FRAMES_API_CHANGES = 26;
  public static final int FETCH_LATER_API = 27;
  public static final int FLEDGE = 28;
  public static final int FLEDGE_BIDDING_AND_AUCTION_SERVER_API = 29;
  public static final int FOCUSGROUP = 30;
  public static final int FULLSCREEN_POPUP_WINDOWS = 31;
  public static final int GET_ALL_SCREENS_MEDIA = 32;
  public static final int HREF_TRANSLATE = 33;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int JAVA_SCRIPT_COMPILE_HINTS_MAGIC_RUNTIME = 34;
  public static final int MAX_VALUE = 108;
  public static final int MEDIA_CAPTURE_BACKGROUND_BLUR = 35;
  public static final int MEDIA_CAPTURE_CONFIGURATION_CHANGE = 36;
  public static final int MEDIA_SOURCE_EXTENSIONS_FOR_WEB_CODECS = 37;
  public static final int MIN_VALUE = 0;
  public static final int MUTATION_EVENTS = 38;
  public static final int NAVIGATION_ID = 39;
  public static final int NON_EXISTING = 0;
  public static final int NOTIFICATION_TRIGGERS = 40;
  public static final int NO_VARY_SEARCH_PREFETCH = 41;
  public static final int ORIGIN_TRIALS_SAMPLE_API = 42;
  public static final int ORIGIN_TRIALS_SAMPLE_API_BROWSER_READ_WRITE = 43;
  public static final int ORIGIN_TRIALS_SAMPLE_API_DEPRECATION = 44;
  public static final int ORIGIN_TRIALS_SAMPLE_API_EXPIRY_GRACE_PERIOD = 45;
  public static final int ORIGIN_TRIALS_SAMPLE_API_EXPIRY_GRACE_PERIOD_THIRD_PARTY = 46;
  public static final int ORIGIN_TRIALS_SAMPLE_API_IMPLIED = 47;
  public static final int ORIGIN_TRIALS_SAMPLE_API_INVALID_OS = 48;
  public static final int ORIGIN_TRIALS_SAMPLE_API_NAVIGATION = 49;
  public static final int ORIGIN_TRIALS_SAMPLE_API_PERSISTENT_EXPIRY_GRACE_PERIOD = 50;
  public static final int ORIGIN_TRIALS_SAMPLE_API_PERSISTENT_FEATURE = 51;
  public static final int ORIGIN_TRIALS_SAMPLE_API_PERSISTENT_INVALID_OS = 52;

  public static final int f446xe0c253c3 = 53;
  public static final int ORIGIN_TRIALS_SAMPLE_API_THIRD_PARTY = 54;
  public static final int PAGE_FREEZE_OPT_IN = 55;
  public static final int PAGE_FREEZE_OPT_OUT = 56;
  public static final int PARAKEET = 57;
  public static final int PARTITIONED_COOKIES = 58;
  public static final int PAYMENT_HANDLER_MINIMAL_HEADER_UX = 59;
  public static final int PENDING_BEACON_API = 60;
  public static final int PER_METHOD_CAN_MAKE_PAYMENT_QUOTA = 61;
  public static final int PRIVACY_SANDBOX_ADS_AP_IS = 63;
  public static final int PRIVATE_NETWORK_ACCESS_NON_SECURE_CONTEXTS_ALLOWED = 64;
  public static final int PRIVATE_NETWORK_ACCESS_PERMISSION_PROMPT = 65;
  public static final int PRIVATE_STATE_TOKENS = 66;
  public static final int P_NA_CL = 62;
  public static final int REDUCE_ACCEPT_LANGUAGE = 67;
  public static final int RTC_AUDIO_JITTER_BUFFER_MAX_PACKETS = 68;
  public static final int RTC_ENCODED_FRAME_SET_METADATA = 69;
  public static final int RTC_LEGACY_CALLBACK_BASED_GET_STATS = 70;
  public static final int RTC_STATS_RELATIVE_PACKET_ARRIVAL_DELAY = 71;
  public static final int SCHEDULER_YIELD = 72;
  public static final int SECURE_PAYMENT_CONFIRMATION_OPT_OUT = 73;
  public static final int SERVICE_WORKER_BYPASS_FETCH_HANDLER = 74;
  public static final int SERVICE_WORKER_RACE_NETWORK_REQUEST = 75;
  public static final int SERVICE_WORKER_STATIC_ROUTER = 76;
  public static final int SHARED_STORAGE_API = 77;
  public static final int SIGNATURE_BASED_INTEGRITY = 78;
  public static final int SOFT_NAVIGATION_HEURISTICS = 79;
  public static final int SPECULATION_RULES_DOCUMENT_RULES = 80;
  public static final int SPECULATION_RULES_DOCUMENT_RULES_SELECTOR_MATCHES = 81;
  public static final int SPECULATION_RULES_EAGERNESS = 82;
  public static final int SPECULATION_RULES_FETCH_FROM_HEADER = 83;
  public static final int SPECULATION_RULES_NO_VARY_SEARCH_HINT = 84;
  public static final int SPECULATION_RULES_PREFETCH_FUTURE = 85;
  public static final int SPECULATION_RULES_RELATIVE_TO_DOCUMENT = 86;
  public static final int STORAGE_ACCESS_API_BEYOND_COOKIES = 87;
  public static final int TEXT_FRAGMENT_IDENTIFIERS = 88;
  public static final int TOPICS_API = 89;
  public static final int TOPICS_DOCUMENT_API = 90;
  public static final int TOP_LEVEL_TPCD = 91;
  public static final int TOUCH_EVENT_FEATURE_DETECTION = 92;
  public static final int TPCD = 93;
  public static final int UNRESTRICTED_SHARED_ARRAY_BUFFER = 94;
  public static final int WEB_APP_DARK_MODE = 95;
  public static final int WEB_APP_LAUNCH_HANDLER = 96;
  public static final int WEB_APP_LAUNCH_QUEUE = 97;
  public static final int WEB_APP_SCOPE_EXTENSIONS = 98;
  public static final int WEB_APP_TAB_STRIP = 99;
  public static final int WEB_APP_TAB_STRIP_CUSTOMIZATIONS = 100;
  public static final int WEB_APP_URL_HANDLING = 101;
  public static final int WEB_ASSEMBLY_JS_PROMISE_INTEGRATION = 102;
  public static final int WEB_ASSEMBLY_JS_STRING_BUILTINS = 103;
  public static final int WEB_IDENTITY_DIGITAL_CREDENTIALS = 104;
  public static final int WEB_TRANSPORT_CUSTOM_CERTIFICATES = 105;
  public static final int WEB_VIEW_X_REQUESTED_WITH_DEPRECATION = 106;
  public static final int WEB_XR_IMAGE_TRACKING = 107;
  public static final int WEB_XR_PLANE_DETECTION = 108;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 108;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private OriginTrialFeature() {}
}
