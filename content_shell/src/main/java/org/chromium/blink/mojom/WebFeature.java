package org.chromium.blink.mojom;

import org.chromium.ax.mojom.Role;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.ui.mojom.KeyboardCode;

public final class WebFeature {
  public static final int ABORT_PAYMENT_RESPOND_WITH_TRUE = 4093;
  public static final int ABORT_SIGNAL_ANY = 4582;
  public static final int ABORT_SIGNAL_THROW_IF_ABORTED = 4148;
  public static final int ABORT_SIGNAL_TIMEOUT = 4159;
  public static final int ABSOLUTE_ORIENTATION_SENSOR_CONSTRUCTOR = 1900;
  public static final int ACCELEROMETER_CONSTRUCTOR = 1899;
  public static final int ACTIVATED_IMPLICIT_ROOT_SCROLLER = 2625;
  public static final int ADDRESS_SPACE_PRIVATE_NON_SECURE_CONTEXT_EMBEDDED_LOCAL = 3754;
  public static final int ADDRESS_SPACE_PRIVATE_NON_SECURE_CONTEXT_NAVIGATED_TO_LOCAL = 3764;
  public static final int ADDRESS_SPACE_PRIVATE_SECURE_CONTEXT_EMBEDDED_LOCAL = 3753;
  public static final int ADDRESS_SPACE_PRIVATE_SECURE_CONTEXT_NAVIGATED_TO_LOCAL = 3763;
  public static final int ADDRESS_SPACE_PUBLIC_NON_SECURE_CONTEXT_EMBEDDED_LOCAL = 3756;
  public static final int ADDRESS_SPACE_PUBLIC_NON_SECURE_CONTEXT_EMBEDDED_PRIVATE = 3758;
  public static final int ADDRESS_SPACE_PUBLIC_NON_SECURE_CONTEXT_NAVIGATED_TO_LOCAL = 3766;
  public static final int ADDRESS_SPACE_PUBLIC_NON_SECURE_CONTEXT_NAVIGATED_TO_PRIVATE = 3768;
  public static final int ADDRESS_SPACE_PUBLIC_SECURE_CONTEXT_EMBEDDED_LOCAL = 3755;
  public static final int ADDRESS_SPACE_PUBLIC_SECURE_CONTEXT_EMBEDDED_PRIVATE = 3757;
  public static final int ADDRESS_SPACE_PUBLIC_SECURE_CONTEXT_NAVIGATED_TO_LOCAL = 3765;
  public static final int ADDRESS_SPACE_PUBLIC_SECURE_CONTEXT_NAVIGATED_TO_PRIVATE = 3767;
  public static final int ADDRESS_SPACE_UNKNOWN_NON_SECURE_CONTEXT_EMBEDDED_LOCAL = 3760;
  public static final int ADDRESS_SPACE_UNKNOWN_NON_SECURE_CONTEXT_EMBEDDED_PRIVATE = 3762;
  public static final int ADDRESS_SPACE_UNKNOWN_NON_SECURE_CONTEXT_NAVIGATED_TO_LOCAL = 3770;
  public static final int ADDRESS_SPACE_UNKNOWN_NON_SECURE_CONTEXT_NAVIGATED_TO_PRIVATE = 3772;
  public static final int ADDRESS_SPACE_UNKNOWN_SECURE_CONTEXT_EMBEDDED_LOCAL = 3759;
  public static final int ADDRESS_SPACE_UNKNOWN_SECURE_CONTEXT_EMBEDDED_PRIVATE = 3761;
  public static final int ADDRESS_SPACE_UNKNOWN_SECURE_CONTEXT_NAVIGATED_TO_LOCAL = 3769;
  public static final int ADDRESS_SPACE_UNKNOWN_SECURE_CONTEXT_NAVIGATED_TO_PRIVATE = 3771;
  public static final int ADD_DOCUMENT_LEVEL_PASSIVE_DEFAULT_WHEEL_EVENT_LISTENER = 2520;
  public static final int ADD_DOCUMENT_LEVEL_PASSIVE_FALSE_WHEEL_EVENT_LISTENER = 2519;
  public static final int ADD_DOCUMENT_LEVEL_PASSIVE_TRUE_WHEEL_EVENT_LISTENER = 2518;
  public static final int ADD_EVENT_LISTENER_PASSIVE_FALSE = 1418;
  public static final int ADD_EVENT_LISTENER_PASSIVE_TRUE = 1417;
  public static final int ADD_EVENT_LISTENER_WITH_ABORT_SIGNAL = 3730;
  public static final int ADD_SOURCE_BUFFER_USING_CONFIG = 3733;
  public static final int ADOPTED_STYLE_SHEETS = 2846;
  public static final int AD_CLICK = 2621;
  public static final int AD_CLICK_MAIN_FRAME_NAVIGATION = 4719;
  public static final int AD_FRAME_DETECTED = 3727;
  public static final int ALERT_ENGAGEMENT_HIGH = 1735;
  public static final int ALERT_ENGAGEMENT_LOW = 1733;
  public static final int ALERT_ENGAGEMENT_MAX = 1736;
  public static final int ALERT_ENGAGEMENT_MEDIUM = 1734;
  public static final int ALERT_ENGAGEMENT_MINIMAL = 1732;
  public static final int ALERT_ENGAGEMENT_NONE = 1731;
  public static final int ALLOW_PAYMENT_REQUEST_ATTRIBUTE_HAS_EFFECT = 4094;
  public static final int AMBIENT_LIGHT_SENSOR_CONSTRUCTOR = 1901;
  public static final int ANCHOR_CLICK_DISPATCH_FOR_NON_CONNECTED_NODE = 1971;
  public static final int ANIMATION_FINISH_EVENT = 328;
  public static final int ANIMATION_FRAME_CANCELLED_WITHIN_FRAME = 2793;
  public static final int ANIMATION_SET_PLAYBACK_RATE_COMPENSATORY_SEEK = 2162;
  public static final int ANIMATION_WORKLET_REGISTER_ANIMATOR = 2365;
  public static final int ANONYMOUS_IFRAME = 4219;
  public static final int APP_HISTORY = 4056;
  public static final int APP_INSTALLED_EVENT_ADD_LISTENER = 1700;
  public static final int ARIA_ACTIVE_DESCENDANT_ATTRIBUTE = 2069;
  public static final int ARIA_ANNOTATIONS = 3050;
  public static final int ARIA_ATOMIC_ATTRIBUTE = 2070;
  public static final int ARIA_AUTOCOMPLETE_ATTRIBUTE = 2071;
  public static final int ARIA_BUSY_ATTRIBUTE = 2072;
  public static final int ARIA_CHECKED_ATTRIBUTE = 2073;
  public static final int ARIA_COL_COUNT_ATTRIBUTE = 2074;
  public static final int ARIA_COL_INDEX_ATTRIBUTE = 2075;
  public static final int ARIA_COL_SPAN_ATTRIBUTE = 2076;
  public static final int ARIA_CONTROLS_ATTRIBUTE = 2077;
  public static final int ARIA_CURRENT_ATTRIBUTE = 2078;
  public static final int ARIA_DESCRIBED_BY_ATTRIBUTE = 2079;
  public static final int ARIA_DESCRIPTION_ATTRIBUTE = 3089;
  public static final int ARIA_DETAILS_ATTRIBUTE = 2080;
  public static final int ARIA_DISABLED_ATTRIBUTE = 2081;
  public static final int ARIA_DROP_EFFECT_ATTRIBUTE = 2082;
  public static final int ARIA_ERROR_MESSAGE_ATTRIBUTE = 2083;
  public static final int ARIA_EXPANDED_ATTRIBUTE = 2084;
  public static final int ARIA_FLOW_TO_ATTRIBUTE = 2085;
  public static final int ARIA_GRABBED_ATTRIBUTE = 2086;
  public static final int ARIA_HAS_POPUP_ATTRIBUTE = 2087;
  public static final int ARIA_HIDDEN_ATTRIBUTE = 2089;
  public static final int ARIA_INVALID_ATTRIBUTE = 2090;
  public static final int ARIA_KEY_SHORTCUTS_ATTRIBUTE = 2091;
  public static final int ARIA_LABELED_BY_ATTRIBUTE = 2093;
  public static final int ARIA_LABELLED_BY_ATTRIBUTE = 2094;
  public static final int ARIA_LABEL_ATTRIBUTE = 2092;
  public static final int ARIA_LEVEL_ATTRIBUTE = 2095;
  public static final int ARIA_LIVE_ATTRIBUTE = 2096;
  public static final int ARIA_MODAL_ATTRIBUTE = 2097;
  public static final int ARIA_MULTILINE_ATTRIBUTE = 2098;
  public static final int ARIA_MULTISELECTABLE_ATTRIBUTE = 2099;
  public static final int ARIA_ORIENTATION_ATTRIBUTE = 2100;
  public static final int ARIA_OWNS_ATTRIBUTE = 2101;
  public static final int ARIA_PLACEHOLDER_ATTRIBUTE = 2102;
  public static final int ARIA_POS_IN_SET_ATTRIBUTE = 2103;
  public static final int ARIA_PRESSED_ATTRIBUTE = 2104;
  public static final int ARIA_READ_ONLY_ATTRIBUTE = 2105;
  public static final int ARIA_RELEVANT_ATTRIBUTE = 2106;
  public static final int ARIA_REQUIRED_ATTRIBUTE = 2107;
  public static final int ARIA_ROLE_DESCRIPTION_ATTRIBUTE = 2108;
  public static final int ARIA_ROW_COUNT_ATTRIBUTE = 2109;
  public static final int ARIA_ROW_INDEX_ATTRIBUTE = 2110;
  public static final int ARIA_ROW_SPAN_ATTRIBUTE = 2111;
  public static final int ARIA_SELECTED_ATTRIBUTE = 2112;
  public static final int ARIA_SET_SIZE_ATTRIBUTE = 2113;
  public static final int ARIA_SORT_ATTRIBUTE = 2114;
  public static final int ARIA_VALUE_MAX_ATTRIBUTE = 2115;
  public static final int ARIA_VALUE_MIN_ATTRIBUTE = 2116;
  public static final int ARIA_VALUE_NOW_ATTRIBUTE = 2117;
  public static final int ARIA_VALUE_TEXT_ATTRIBUTE = 2118;
  public static final int ARIA_VIRTUALCONTENT_ATTRIBUTE = 3919;
  public static final int ARRAY_BUFFER_TOO_BIG_FOR_WEB_API = 4223;
  public static final int ASPECT_RATIO_FLEX_ITEM = 479;
  public static final int ASYNC_CLIPBOARD_API_READ = 2369;
  public static final int ASYNC_CLIPBOARD_API_READ_TEXT = 2371;
  public static final int ASYNC_CLIPBOARD_API_UNSANITIZED_READ = 4524;
  public static final int ASYNC_CLIPBOARD_API_WRITE = 2370;
  public static final int ASYNC_CLIPBOARD_API_WRITE_TEXT = 2372;
  public static final int ATTRIBUTE_VALUE_CONTAINS_LT_OR_GT = 4527;
  public static final int ATTRIBUTION_FENCED_FRAME_REPORTING_BEACON = 4496;
  public static final int ATTRIBUTION_REPORTING_API_ALL = 3365;
  public static final int ATTRIBUTION_REPORTING_CROSS_APP_WEB = 4546;
  public static final int ATTRIBUTION_REPORTING_CROSS_APP_WEB_SUPPORT_HEADER = 4793;
  public static final int AUDIO_CONTEXT_BASE_LATENCY = 3387;
  public static final int AUDIO_CONTEXT_CLOSE = 689;
  public static final int AUDIO_CONTEXT_CREATE_ANALYSER = 631;
  public static final int AUDIO_CONTEXT_CREATE_BIQUAD_FILTER = 632;
  public static final int AUDIO_CONTEXT_CREATE_BUFFER_SOURCE = 633;
  public static final int AUDIO_CONTEXT_CREATE_CHANNEL_MERGER = 634;
  public static final int AUDIO_CONTEXT_CREATE_CHANNEL_SPLITTER = 635;
  public static final int AUDIO_CONTEXT_CREATE_CONSTANT_SOURCE = 1650;
  public static final int AUDIO_CONTEXT_CREATE_CONVOLVER = 636;
  public static final int AUDIO_CONTEXT_CREATE_DELAY = 637;
  public static final int AUDIO_CONTEXT_CREATE_DYNAMICS_COMPRESSOR = 638;
  public static final int AUDIO_CONTEXT_CREATE_GAIN = 639;
  public static final int AUDIO_CONTEXT_CREATE_IIR_FILTER = 1117;
  public static final int AUDIO_CONTEXT_CREATE_MEDIA_ELEMENT_SOURCE = 640;
  public static final int AUDIO_CONTEXT_CREATE_MEDIA_STREAM_DESTINATION = 641;
  public static final int AUDIO_CONTEXT_CREATE_MEDIA_STREAM_SOURCE = 642;
  public static final int AUDIO_CONTEXT_CREATE_OSCILLATOR = 643;
  public static final int AUDIO_CONTEXT_CREATE_PANNER_AUTOMATED = 1363;
  public static final int AUDIO_CONTEXT_CREATE_PERIODIC_WAVE = 645;
  public static final int AUDIO_CONTEXT_CREATE_SCRIPT_PROCESSOR = 646;
  public static final int AUDIO_CONTEXT_CREATE_STEREO_PANNER = 647;
  public static final int AUDIO_CONTEXT_CREATE_WAVE_SHAPER = 648;
  public static final int AUDIO_CONTEXT_CROSS_ORIGIN_IFRAME = 1430;
  public static final int AUDIO_CONTEXT_DECODE_AUDIO_DATA = 649;
  public static final int AUDIO_CONTEXT_GET_OUTPUT_TIMESTAMP = 1701;
  public static final int AUDIO_CONTEXT_OUTPUT_LATENCY = 4210;
  public static final int AUDIO_CONTEXT_RESUME = 650;
  public static final int AUDIO_CONTEXT_SET_SINK_ID = 4350;
  public static final int AUDIO_CONTEXT_SINK_ID = 4349;
  public static final int AUDIO_CONTEXT_SUSPEND = 651;
  public static final int AUDIO_LISTENER_SET_ORIENTATION = 1367;
  public static final int AUDIO_LISTENER_SET_POSITION = 1366;
  public static final int AUDIO_NODE_CONNECT_TO_AUDIO_NODE = 1078;
  public static final int AUDIO_NODE_CONNECT_TO_AUDIO_PARAM = 1079;
  public static final int AUDIO_NODE_DISCONNECT_FROM_AUDIO_NODE = 1080;
  public static final int AUDIO_NODE_DISCONNECT_FROM_AUDIO_PARAM = 1081;
  public static final int AUDIO_PARAM_CANCEL_AND_HOLD_AT_TIME = 1797;
  public static final int AUDIO_PARAM_CANCEL_SCHEDULED_VALUES = 914;
  public static final int AUDIO_PARAM_EXPONENTIAL_RAMP_TO_VALUE_AT_TIME = 911;
  public static final int AUDIO_PARAM_LINEAR_RAMP_TO_VALUE_AT_TIME = 910;
  public static final int AUDIO_PARAM_SET_TARGET_AT_TIME = 912;
  public static final int AUDIO_PARAM_SET_VALUE_AT_TIME = 909;
  public static final int AUDIO_PARAM_SET_VALUE_CURVE_AT_TIME = 913;
  public static final int AUDIO_WORKLET_ADD_MODULE = 2261;
  public static final int AUDIO_WORKLET_GLOBAL_SCOPE_REGISTER_PROCESSOR = 2262;
  public static final int AUDIO_WORKLET_NODE_CONSTRUCTOR = 2263;
  public static final int AUTHORIZATION_COVERED_BY_WILDCARD = 3873;
  public static final int AUTHORIZATION_CROSS_ORIGIN = 4470;
  public static final int AUTOCAPITALIZE_ATTRIBUTE = 764;
  public static final int AUTOMATIC_LAZY_ADS = 4286;
  public static final int AUTOMATIC_LAZY_EMBEDS = 4287;
  public static final int AUTOPLAY_DYNAMIC_DELEGATION = 2977;
  public static final int AUTO_DARK_MODE = 4062;
  public static final int AUTO_EXPANDED_DETAILS_FOR_FIND_IN_PAGE = 4068;
  public static final int AUTO_EXPANDED_DETAILS_FOR_SCROLL_TO_TEXT_FRAGMENT = 4069;
  public static final int AUTO_FOCUS_ATTRIBUTE = 21;
  public static final int AUTO_RELATIVE_USED_OFFSET = 4661;
  public static final int AUTO_SIZES_LAZY = 4750;
  public static final int AUTO_SIZES_NON_LAZY = 4751;
  public static final int AUTO_SPECULATION_RULES_OPTED_OUT = 4739;
  public static final int AUXCLICK_ADD_LISTENER_COUNT = 1502;
  public static final int AVIF_IMAGE = 3798;
  public static final int BACKGROUND_FETCH_MANAGER_FETCH = 2549;
  public static final int BACKGROUND_FETCH_MANAGER_GET = 2550;
  public static final int BACKGROUND_FETCH_MANAGER_GET_IDS = 2551;
  public static final int BACKGROUND_FETCH_REGISTRATION_ABORT = 2552;
  public static final int BACKGROUND_FETCH_REGISTRATION_MATCH = 2553;
  public static final int BACKGROUND_FETCH_REGISTRATION_MATCH_ALL = 2554;
  public static final int BACKGROUND_SYNC = 745;
  public static final int BACKGROUND_SYNC_REGISTER = 1025;
  public static final int BACK_FORWARD_CACHE_EXPERIMENT_HTTP_HEADER = 3461;
  public static final int BACK_FORWARD_CACHE_NOT_RESTORED_REASONS = 4371;
  public static final int BADGE_CLEAR = 2727;
  public static final int BADGE_SET = 2726;
  public static final int BARCODE_DETECTOR_DETECT = 3711;
  public static final int BARCODE_DETECTOR_GET_SUPPORTED_FORMATS = 3610;
  public static final int BAR_PROP_LOCATIONBAR = 178;
  public static final int BAR_PROP_MENUBAR = 179;
  public static final int BAR_PROP_PERSONALBAR = 180;
  public static final int BAR_PROP_SCROLLBARS = 181;
  public static final int BAR_PROP_STATUSBAR = 182;
  public static final int BAR_PROP_TOOLBAR = 183;
  public static final int BASE_ELEMENT = 1758;
  public static final int BASE_WITH_CROSS_ORIGIN_HREF = 1759;
  public static final int BASE_WITH_DATA_HREF = 1760;
  public static final int BASE_WITH_NEWLINES_IN_TARGET = 1761;
  public static final int BASE_WITH_OPEN_BRACKET_IN_TARGET = 1762;
  public static final int BASIC_CARD_TYPE = 2954;
  public static final int BASIC_SHAPE_ELLIPSE_NO_RADIUS = 2326;
  public static final int BASIC_SHAPE_ELLIPSE_TWO_RADIUS = 2328;
  public static final int BATTERY_STATUS_CROSS_ORIGIN = 2200;
  public static final int BATTERY_STATUS_GET_BATTERY = 2198;
  public static final int BATTERY_STATUS_SAME_ORIGIN_ABA = 2201;
  public static final int BEFOREMATCH_HANDLER_REGISTERED = 3429;
  public static final int BEFOREMATCH_REVEALED_HIDDEN_MATCHABLE = 3732;
  public static final int BEFORE_INSTALL_PROMPT_EVENT = 1436;
  public static final int BEFORE_INSTALL_PROMPT_EVENT_PREVENT_DEFAULT = 1438;
  public static final int BEFORE_INSTALL_PROMPT_EVENT_PROMPT = 1439;
  public static final int BEFORE_INSTALL_PROMPT_EVENT_USER_CHOICE = 1437;
  public static final int BLINK_MAC_SYSTEM_FONT = 1654;
  public static final int BLOB_STORE_ACCESS_ACROSS_AGENT_CLUSTERS_IN_RESOLVE_AS_URL_LOADER_FACTORY =
      3963;
  public static final int BLOB_STORE_ACCESS_ACROSS_AGENT_CLUSTERS_IN_RESOLVE_FOR_NAVIGATION = 3964;
  public static final int BLOB_STORE_ACCESS_ACROSS_TOP_LEVEL_SITE = 4169;
  public static final int BLOB_STORE_ACCESS_UNKNOWN_TOP_LEVEL_SITE = 4170;
  public static final int BLOCKABLE_MIXED_CONTENT_IN_SUBFRAME_BLOCKED = 966;
  public static final int BLOCKED_SNIFFING_AUDIO_TO_SCRIPT = 1544;
  public static final int BLOCKED_SNIFFING_CSV_TO_SCRIPT = 1546;
  public static final int BLOCKED_SNIFFING_IMAGE_TO_SCRIPT = 674;
  public static final int BLOCKED_SNIFFING_VIDEO_TO_SCRIPT = 1545;
  public static final int BLOCKING_ATTRIBUTE_RENDER_TOKEN = 4183;
  public static final int BLUETOOTH_ADVERTISING_EVENT_APPEARANCE = 3431;
  public static final int BLUETOOTH_ADVERTISING_EVENT_NAME = 3430;
  public static final int BLUETOOTH_ADVERTISING_EVENT_TX_POWER = 3432;
  public static final int BLUETOOTH_DEVICE_FORGET = 4181;
  public static final int BLUETOOTH_DEVICE_NAME = 3436;
  public static final int BODY_SCROLLS_IN_ADDITION_TO_VIEWPORT = 1128;
  public static final int BREAK_ITERATOR = 556;
  public static final int BREAK_ITERATOR_TYPE_LINE = 3177;
  public static final int BREAK_ITERATOR_TYPE_WORD = 3176;
  public static final int BUDGET_API_GET_BUDGET = 2022;
  public static final int BUDGET_API_GET_COST = 2021;
  public static final int BYTE_LENGTH_QUEUING_STRATEGY_CONSTRUCTOR = 3083;
  public static final int CACHE_STORAGE_CODE_CACHE_HINT = 3107;
  public static final int CACHE_STORAGE_READ = 3021;
  public static final int CACHE_STORAGE_WRITE = 3022;
  public static final int CAMERA_DISABLED_BY_FEATURE_POLICY_ESTIMATE = 2209;
  public static final int CANVAS2_D_FILTER = 1830;
  public static final int CANVAS2_D_IMAGE_SMOOTHING_QUALITY = 1831;
  public static final int CANVAS2_D_LAYERS = 4837;
  public static final int CANVAS_CAPTURE_STREAM = 2717;
  public static final int CANVAS_CONVERT_TO_BLOB = 2465;
  public static final int CANVAS_RENDERING_CONTEXT = 3284;
  public static final int CANVAS_RENDERING_CONTEXT2_D_CANVAS_FILTER = 4009;
  public static final int CANVAS_RENDERING_CONTEXT2_D_CONIC_GRADIENT = 4008;
  public static final int CANVAS_RENDERING_CONTEXT2_D_CONTEXT_LOST_EVENT = 3974;
  public static final int CANVAS_RENDERING_CONTEXT2_D_CONTEXT_RESTORED_EVENT = 3975;
  public static final int CANVAS_RENDERING_CONTEXT2_D_FONT_KERNING = 4004;
  public static final int CANVAS_RENDERING_CONTEXT2_D_FONT_STRETCH = 4005;
  public static final int CANVAS_RENDERING_CONTEXT2_D_FONT_VARIANT_CAPS = 4003;
  public static final int CANVAS_RENDERING_CONTEXT2_D_HAS_OVERDRAW = 4035;
  public static final int CANVAS_RENDERING_CONTEXT2_D_LETTER_SPACING = 4001;
  public static final int CANVAS_RENDERING_CONTEXT2_D_RESET = 4000;
  public static final int CANVAS_RENDERING_CONTEXT2_D_ROUND_RECT = 3998;
  public static final int CANVAS_RENDERING_CONTEXT2_D_TEXT_RENDERING = 4006;
  public static final int CANVAS_RENDERING_CONTEXT2_D_WORD_SPACING = 4002;
  public static final int CANVAS_TO_BLOB = 1832;
  public static final int CANVAS_TO_DATA_URL = 1833;
  public static final int CANVAS_USE_COLOR_SPACE = 3810;
  public static final int CAN_REQUEST_URLHTTP_CONTAINING_NEWLINE = 1914;
  public static final int CAPABILITY_DELEGATION_OF_FULLSCREEN_REQUEST = 4214;
  public static final int CAPABILITY_DELEGATION_OF_PAYMENT_REQUEST = 3990;
  public static final int CAPTURED_SURFACE_CONTROL = 4780;
  public static final int CAPTURE_HANDLE = 3911;
  public static final int CASCADED_CSS_ZOOM_NOT_EQUAL_TO_ONE = 3578;
  public static final int CASE_INSENSITIVE_ATTR_SELECTOR_MATCH = 244;
  public static final int CERTIFICATE_TRANSPARENCY_REQUIRED_ERROR_ON_RESOURCE_LOAD = 2259;
  public static final int CHANGE_TYPE_USING_CONFIG = 3734;
  public static final int CHROME_CSI_ONLOAD_T = 4683;
  public static final int CHROME_CSI_PAGE_T = 4684;
  public static final int CHROME_CSI_START_E = 4685;
  public static final int CHROME_CSI_TRAN = 4686;
  public static final int CHROME_CSI_UNKNOWN = 4682;
  public static final int CHROME_LOAD_TIMES_COMMIT_LOAD_TIME = 1488;
  public static final int CHROME_LOAD_TIMES_CONNECTION_INFO = 1498;
  public static final int CHROME_LOAD_TIMES_FINISH_DOCUMENT_LOAD_TIME = 1489;
  public static final int CHROME_LOAD_TIMES_FINISH_LOAD_TIME = 1490;
  public static final int CHROME_LOAD_TIMES_FIRST_PAINT_AFTER_LOAD_TIME = 1492;
  public static final int CHROME_LOAD_TIMES_FIRST_PAINT_TIME = 1491;
  public static final int CHROME_LOAD_TIMES_NAVIGATION_TYPE = 1493;
  public static final int CHROME_LOAD_TIMES_NPN_NEGOTIATED_PROTOCOL = 1496;
  public static final int CHROME_LOAD_TIMES_REQUEST_TIME = 1486;
  public static final int CHROME_LOAD_TIMES_START_LOAD_TIME = 1487;
  public static final int CHROME_LOAD_TIMES_UNKNOWN = 1499;
  public static final int CHROME_LOAD_TIMES_WAS_ALTERNATE_PROTOCOL_AVAILABLE = 1497;
  public static final int CHROME_LOAD_TIMES_WAS_FETCHED_VIA_SPDY = 1494;
  public static final int CHROME_LOAD_TIMES_WAS_NPN_NEGOTIATED = 1495;
  public static final int CLASSIC_DEDICATED_WORKER = 3084;
  public static final int CLASSIC_SHARED_WORKER = 3148;
  public static final int CLEAN_SCRIPT_ELEMENT_WITH_NONCE = 1540;
  public static final int CLEAR_PERFORMANCE_ENTRIES = 4380;
  public static final int CLIENT_HINTS_CONTENT_DPR = 906;
  public static final int CLIENT_HINTS_DEVICE_MEMORY = 4046;
  public static final int CLIENT_HINTS_DEVICE_MEMORY_DEPRECATED = 2017;
  public static final int CLIENT_HINTS_DOWNLINK_DEPRECATED = 2405;
  public static final int CLIENT_HINTS_DPR = 4047;
  public static final int CLIENT_HINTS_DPR_DEPRECATED = 835;
  public static final int CLIENT_HINTS_ECT_DEPRECATED = 2406;
  public static final int CLIENT_HINTS_META_EQUIV_DELEGATE_CH = 4301;
  public static final int CLIENT_HINTS_META_HTTP_EQUIV_ACCEPT_CH = 904;
  public static final int CLIENT_HINTS_PREFERS_COLOR_SCHEME = 3915;
  public static final int CLIENT_HINTS_PREFERS_REDUCED_MOTION = 4364;
  public static final int CLIENT_HINTS_PREFERS_REDUCED_TRANSPARENCY = 4635;
  public static final int CLIENT_HINTS_RESOURCE_WIDTH = 4048;
  public static final int CLIENT_HINTS_RESOURCE_WIDTH_DEPRECATED = 836;
  public static final int CLIENT_HINTS_RTT_DEPRECATED = 2404;
  public static final int CLIENT_HINTS_SAVE_DATA = 4206;
  public static final int CLIENT_HINTS_UA = 2789;
  public static final int CLIENT_HINTS_UA_ARCH = 2790;
  public static final int CLIENT_HINTS_UA_BITNESS = 3945;
  public static final int CLIENT_HINTS_UA_FORM_FACTOR = 4591;
  public static final int CLIENT_HINTS_UA_FULL = 4149;
  public static final int CLIENT_HINTS_UA_FULL_VERSION = 3189;
  public static final int CLIENT_HINTS_UA_FULL_VERSION_LIST = 4079;
  public static final int CLIENT_HINTS_UA_MOBILE = 3116;
  public static final int CLIENT_HINTS_UA_MODEL = 2792;
  public static final int CLIENT_HINTS_UA_PLATFORM = 2791;
  public static final int CLIENT_HINTS_UA_PLATFORM_VERSION = 3273;
  public static final int CLIENT_HINTS_UA_REDUCED = 3968;
  public static final int CLIENT_HINTS_UA_WO_W64 = 4151;
  public static final int CLIENT_HINTS_VIEWPORT_HEIGHT = 3976;
  public static final int CLIENT_HINTS_VIEWPORT_WIDTH = 4049;
  public static final int CLIENT_HINTS_VIEWPORT_WIDTH_DEPRECATED = 837;
  public static final int CLIENT_RECT_LIST_ITEM = 694;
  public static final int COEP_CREDENTIALLESS_SHARED_WORKER = 4044;
  public static final int COEP_NONE_SHARED_WORKER = 4042;
  public static final int COEP_REQUIRE_CORP_SHARED_WORKER = 4043;
  public static final int COLLATOR = 2593;
  public static final int COLOR_INPUT_TYPE_CHOOSER_BY_TRUSTED_CLICK = 2332;
  public static final int COLOR_INPUT_TYPE_CHOOSER_BY_UNTRUSTED_CLICK = 2333;
  public static final int COLOR_SCHEME_DARK_SUPPORTED_ON_ROOT = 3707;
  public static final int COMPOSITED_REPLICATION = 1322;
  public static final int COMPOSITED_SVG = 3710;
  public static final int COMPRESSION_STREAM_CONSTRUCTOR = 3060;
  public static final int CONDITIONAL_FOCUS = 4052;
  public static final int CONFIRM_ENGAGEMENT_HIGH = 1741;
  public static final int CONFIRM_ENGAGEMENT_LOW = 1739;
  public static final int CONFIRM_ENGAGEMENT_MAX = 1742;
  public static final int CONFIRM_ENGAGEMENT_MEDIUM = 1740;
  public static final int CONFIRM_ENGAGEMENT_MINIMAL = 1738;
  public static final int CONFIRM_ENGAGEMENT_NONE = 1737;
  public static final int CONTACTS_MANAGER_GET_PROPERTIES = 3044;
  public static final int CONTACTS_MANAGER_SELECT = 2993;
  public static final int CONTAINER_QUERY_EVAL_UNKNOWN = 4596;
  public static final int CONTENT_DISPOSITION_IN_SVG_USE = 4451;
  public static final int CONTENT_EDITABLE_PLAIN_TEXT_ONLY = 1132;
  public static final int CONTENT_EDITABLE_TRUE = 1130;
  public static final int CONTENT_EDITABLE_TRUE_ON_HTML = 1131;
  public static final int CONTENT_INDEX_ADD = 2983;
  public static final int CONTENT_INDEX_DELETE = 2984;
  public static final int CONTENT_INDEX_GET = 2985;
  public static final int CONTENT_SECURITY_POLICY = 15;
  public static final int CONTENT_SECURITY_POLICY_REPORT_ONLY = 16;
  public static final int CONTENT_SECURITY_POLICY_WITH_BASE_ELEMENT = 70;
  public static final int CONTENT_VISIBILITY_AUTO = 3332;
  public static final int CONTENT_VISIBILITY_AUTO_STATE_CHANGE_HANDLER_REGISTERED = 4328;
  public static final int CONTENT_VISIBILITY_HIDDEN = 3333;
  public static final int CONTENT_VISIBILITY_HIDDEN_MATCHABLE = 3334;
  public static final int CONTROLLED_NON_BLOB_URL_WORKER_WILL_BE_UNCONTROLLED = 3943;
  public static final int CONTROLLED_WORKER_WILL_BE_UNCONTROLLED = 3917;
  public static final int COOKIE_DOMAIN_NON_ASCII = 4300;
  public static final int COOKIE_GET = 2195;
  public static final int COOKIE_HAS_NOT_BEEN_REFRESHED_IN201_TO300_DAYS = 4216;
  public static final int COOKIE_HAS_NOT_BEEN_REFRESHED_IN301_TO350_DAYS = 4217;
  public static final int COOKIE_HAS_NOT_BEEN_REFRESHED_IN351_TO400_DAYS = 4218;
  public static final int COOKIE_INSECURE_AND_SAME_SITE_NONE = 2917;
  public static final int COOKIE_NO_SAME_SITE = 2916;
  public static final int COOKIE_SET = 2194;
  public static final int COOKIE_STORE_API = 2510;
  public static final int COOKIE_WITH_TRUNCATING_CHAR = 4172;
  public static final int COOP_AND_COEP_ISOLATED = 3200;
  public static final int COOP_AND_COEP_ISOLATED_REPORT_ONLY = 4088;
  public static final int COUNT_QUEUING_STRATEGY_CONSTRUCTOR = 3082;
  public static final int CREATE_CSS_MODULE_SCRIPT = 3805;
  public static final int CREATE_IMAGE_BITMAP = 1156;
  public static final int CREATE_JSON_MODULE_SCRIPT = 3804;
  public static final int CREATE_OBJECT_BLOB = 3028;
  public static final int CREATE_OBJECT_URL_BLOB = 1604;
  public static final int CREATE_OBJECT_URL_MEDIA_SOURCE = 1605;
  public static final int CREATE_OBJECT_URL_MEDIA_SOURCE_FROM_WORKER = 2939;
  public static final int CREATE_OBJECT_URL_MEDIA_STREAM = 1606;
  public static final int CREDENTIAL_MANAGER_CREATE = 1979;
  public static final int CREDENTIAL_MANAGER_CREATE_FEDERATED_CREDENTIAL = 3996;
  public static final int CREDENTIAL_MANAGER_CREATE_PASSWORD_CREDENTIAL = 3997;
  public static final int CREDENTIAL_MANAGER_CREATE_PUBLIC_KEY_CREDENTIAL = 2421;
  public static final int CREDENTIAL_MANAGER_CROSS_ORIGIN_PUBLIC_KEY_CREATE_REQUEST = 4758;
  public static final int CREDENTIAL_MANAGER_CROSS_ORIGIN_PUBLIC_KEY_GET_REQUEST = 3465;
  public static final int CREDENTIAL_MANAGER_GET = 960;
  public static final int CREDENTIAL_MANAGER_GET_LEGACY_FEDERATED_CREDENTIAL = 3992;
  public static final int CREDENTIAL_MANAGER_GET_MEDIATION_OPTIONAL = 961;
  public static final int CREDENTIAL_MANAGER_GET_MEDIATION_REQUIRED = 1984;
  public static final int CREDENTIAL_MANAGER_GET_MEDIATION_SILENT = 962;
  public static final int CREDENTIAL_MANAGER_GET_PASSWORD_CREDENTIAL = 3993;
  public static final int CREDENTIAL_MANAGER_GET_PUBLIC_KEY_CREDENTIAL = 2422;
  public static final int CREDENTIAL_MANAGER_GET_PUBLIC_KEY_CREDENTIAL_SUCCESS = 2424;
  public static final int CREDENTIAL_MANAGER_GET_RETURNED_CREDENTIAL = 1342;
  public static final int CREDENTIAL_MANAGER_GET_SUCCESS_WITH_UVM = 2951;
  public static final int CREDENTIAL_MANAGER_GET_WITH_UVM = 2949;
  public static final int CREDENTIAL_MANAGER_IS_CONDITIONAL_MEDIATION_AVAILABLE = 4318;
  public static final int CREDENTIAL_MANAGER_IS_USER_VERIFYING_PLATFORM_AUTHENTICATOR_AVAILABLE =
      3074;
  public static final int CREDENTIAL_MANAGER_MAKE_PUBLIC_KEY_CREDENTIAL_SUCCESS = 2423;
  public static final int CREDENTIAL_MANAGER_PREVENT_SILENT_ACCESS = 2012;
  public static final int CREDENTIAL_MANAGER_STORE = 963;
  public static final int CREDENTIAL_MANAGER_STORE_FEDERATED_CREDENTIAL = 3994;
  public static final int CREDENTIAL_MANAGER_STORE_PASSWORD_CREDENTIAL = 3995;
  public static final int CRITICAL_CH_RESTART_NAVIGATION_TIMING = 4574;
  public static final int CROSS_BROWSING_CONTEXT_GROUP_MAIN_FRAME_NULLED_NON_EMPTY_NAME_ACCESSED =
      3353;
  public static final int CROSS_ORIGIN_ACCESS_BASED_ON_DOCUMENT_DOMAIN = 4171;
  public static final int CROSS_ORIGIN_APPLICATION_OCTET_STREAM = 2172;
  public static final int CROSS_ORIGIN_APPLICATION_SCRIPT = 1070;
  public static final int CROSS_ORIGIN_APPLICATION_XML = 2173;
  public static final int CROSS_ORIGIN_EMBEDDER_POLICY_CREDENTIALLESS = 3881;
  public static final int CROSS_ORIGIN_EMBEDDER_POLICY_CREDENTIALLESS_REPORT_ONLY = 4086;
  public static final int CROSS_ORIGIN_EMBEDDER_POLICY_REQUIRE_CORP = 3199;
  public static final int CROSS_ORIGIN_EMBEDDER_POLICY_REQUIRE_CORP_REPORT_ONLY = 4087;
  public static final int CROSS_ORIGIN_HTMLI_FRAME_ELEMENT_CONTENT_DOCUMENT = 2407;
  public static final int CROSS_ORIGIN_HTMLI_FRAME_ELEMENT_GET_SVG_DOCUMENT = 2408;
  public static final int CROSS_ORIGIN_HTML_EMBED_ELEMENT_GET_SVG_DOCUMENT = 2409;
  public static final int CROSS_ORIGIN_HTML_FRAME_ELEMENT_CONTENT_DOCUMENT = 2410;
  public static final int CROSS_ORIGIN_HTML_OBJECT_ELEMENT_CONTENT_DOCUMENT = 2411;
  public static final int CROSS_ORIGIN_HTML_OBJECT_ELEMENT_GET_SVG_DOCUMENT = 2412;
  public static final int CROSS_ORIGIN_JSON_TYPE_FOR_SCRIPT = 3738;
  public static final int CROSS_ORIGIN_MAIN_FRAME_NULLED_NAME_ACCESSED = 1910;
  public static final int CROSS_ORIGIN_MAIN_FRAME_NULLED_NON_EMPTY_NAME_ACCESSED = 2023;
  public static final int CROSS_ORIGIN_OPENER_POLICY_REPORTING = 3433;
  public static final int CROSS_ORIGIN_OPENER_POLICY_RESTRICT_PROPERTIES = 4254;
  public static final int CROSS_ORIGIN_OPENER_POLICY_RESTRICT_PROPERTIES_REPORT_ONLY = 4255;
  public static final int CROSS_ORIGIN_OPENER_POLICY_SAME_ORIGIN = 3197;
  public static final int CROSS_ORIGIN_OPENER_POLICY_SAME_ORIGIN_ALLOW_POPUPS = 3198;
  public static final int CROSS_ORIGIN_OPENER_POLICY_SAME_ORIGIN_ALLOW_POPUPS_REPORT_ONLY = 4089;
  public static final int CROSS_ORIGIN_OPENER_POLICY_SAME_ORIGIN_REPORT_ONLY = 4090;
  public static final int CROSS_ORIGIN_OTHER_SCRIPT = 1071;
  public static final int CROSS_ORIGIN_PROPERTY_ACCESS = 1977;
  public static final int CROSS_ORIGIN_PROPERTY_ACCESS_FROM_OPENER = 1978;
  public static final int CROSS_ORIGIN_SCROLL_INTO_VIEW = 4316;
  public static final int CROSS_ORIGIN_STRICT_NOSNIFF_WOULD_BLOCK = 3740;
  public static final int CROSS_ORIGIN_SUBFRAME_WITHOUT_EMBEDDING_CONTROL = 3742;
  public static final int CROSS_ORIGIN_TEXT_HTML = 2174;
  public static final int CROSS_ORIGIN_TEXT_PLAIN = 2175;
  public static final int CROSS_ORIGIN_TEXT_SCRIPT = 1069;
  public static final int CROSS_ORIGIN_TEXT_XML = 2176;
  public static final int CROSS_ORIGIN_WINDOW_ALERT = 1411;
  public static final int CROSS_ORIGIN_WINDOW_CONFIRM = 1412;
  public static final int CROSS_ORIGIN_WINDOW_FRAME_ELEMENT = 4613;
  public static final int CROSS_ORIGIN_WINDOW_PRINT = 1414;
  public static final int CROSS_SITE_POST_MESSAGE = 3411;
  public static final int CROSS_WINDOW_ACCESS_TO_BROWSER_GENERATED_DOCUMENT = 4562;
  public static final int CRYPTO_ALGORITHM_AES_CBC = 723;
  public static final int CRYPTO_ALGORITHM_AES_CTR = 732;
  public static final int CRYPTO_ALGORITHM_AES_GCM = 730;
  public static final int CRYPTO_ALGORITHM_AES_KW = 733;
  public static final int CRYPTO_ALGORITHM_ECDH = 736;
  public static final int CRYPTO_ALGORITHM_ECDSA = 735;
  public static final int CRYPTO_ALGORITHM_ED25519 = 3170;
  public static final int CRYPTO_ALGORITHM_HKDF = 737;
  public static final int CRYPTO_ALGORITHM_HMAC = 724;
  public static final int CRYPTO_ALGORITHM_PBKDF2 = 738;
  public static final int CRYPTO_ALGORITHM_RSA_OAEP = 731;
  public static final int CRYPTO_ALGORITHM_RSA_PSS = 734;
  public static final int CRYPTO_ALGORITHM_RSA_SSA_PKCS1V1_5 = 725;
  public static final int CRYPTO_ALGORITHM_SHA1 = 726;
  public static final int CRYPTO_ALGORITHM_SHA256 = 727;
  public static final int CRYPTO_ALGORITHM_SHA384 = 728;
  public static final int CRYPTO_ALGORITHM_SHA512 = 729;
  public static final int CRYPTO_ALGORITHM_X25519 = 3171;
  public static final int CRYPTO_GET_RANDOM_VALUES = 710;
  public static final int CSPEE_SAME_ORIGIN_BLANKET_ENFORCEMENT = 4599;
  public static final int CSPRO_WITH_BETTER_THAN_REASONABLE_RESTRICTIONS = 3138;
  public static final int CSPRO_WITH_REASONABLE_BASE_RESTRICTIONS = 3134;
  public static final int CSPRO_WITH_REASONABLE_OBJECT_RESTRICTIONS = 3133;
  public static final int CSPRO_WITH_REASONABLE_RESTRICTIONS = 3136;
  public static final int CSPRO_WITH_REASONABLE_SCRIPT_RESTRICTIONS = 3135;
  public static final int CSP_REFERRER_DIRECTIVE = 1419;
  public static final int CSP_WITH_BETTER_THAN_REASONABLE_RESTRICTIONS = 3137;
  public static final int CSP_WITH_REASONABLE_BASE_RESTRICTIONS = 3130;
  public static final int CSP_WITH_REASONABLE_OBJECT_RESTRICTIONS = 3129;
  public static final int CSP_WITH_REASONABLE_RESTRICTIONS = 3132;
  public static final int CSP_WITH_REASONABLE_SCRIPT_RESTRICTIONS = 3131;
  public static final int CSP_WITH_STRICT_DYNAMIC = 1277;
  public static final int CSP_WITH_UNSAFE_EVAL = 2236;
  public static final int CSP_WOULD_BLOCK_IF_WILDCARD_DOES_NOT_MATCH_FTP = 4695;
  public static final int CSP_WOULD_BLOCK_IF_WILDCARD_DOES_NOT_MATCH_WS = 4694;
  public static final int CSS_ANCHOR_POSITIONING = 4467;
  public static final int CSS_ANIMATIONS_STACKED_NEUTRAL_KEYFRAME = 937;
  public static final int CSS_AT_RULE_ANNOTATION = 4409;
  public static final int CSS_AT_RULE_APPLY = 1249;
  public static final int CSS_AT_RULE_CHARACTER_VARIANT = 4406;
  public static final int CSS_AT_RULE_CHARSET = 969;
  public static final int CSS_AT_RULE_CONTAINER = 4165;
  public static final int CSS_AT_RULE_COUNTER_STYLE = 3809;
  public static final int CSS_AT_RULE_FONT_FACE = 970;
  public static final int CSS_AT_RULE_FONT_FEATURE_VALUES = 2641;
  public static final int CSS_AT_RULE_FONT_PALETTE_VALUES = 4164;
  public static final int CSS_AT_RULE_IMPORT = 971;
  public static final int CSS_AT_RULE_KEYFRAMES = 972;
  public static final int CSS_AT_RULE_MEDIA = 973;
  public static final int CSS_AT_RULE_NAMESPACE = 974;
  public static final int CSS_AT_RULE_ORNAMENTS = 4408;
  public static final int CSS_AT_RULE_PAGE = 975;
  public static final int CSS_AT_RULE_PAGE_MARGIN = 4776;
  public static final int CSS_AT_RULE_PROPERTY = 2940;
  public static final int CSS_AT_RULE_SCOPE = 4212;
  public static final int CSS_AT_RULE_SCROLL_TIMELINE = 3325;
  public static final int CSS_AT_RULE_STARTING_STYLE = 4486;
  public static final int CSS_AT_RULE_STYLESET = 4405;
  public static final int CSS_AT_RULE_STYLISTIC = 4404;
  public static final int CSS_AT_RULE_SUPPORTS = 976;
  public static final int CSS_AT_RULE_SWASH = 4407;
  public static final int CSS_AT_RULE_VIEWPORT = 977;
  public static final int CSS_AT_RULE_VIEW_TRANSITION = 4626;
  public static final int CSS_AT_RULE_WEBKIT_KEYFRAMES = 978;
  public static final int CSS_BACKGROUND_CLIP_BORDER = 4436;
  public static final int CSS_BACKGROUND_CLIP_CONTENT = 4437;
  public static final int CSS_BACKGROUND_CLIP_PADDING = 4438;
  public static final int CSS_BARE_DECLARATION_SHIFT = 4783;
  public static final int CSS_BASIC_SHAPE = 2354;
  public static final int CSS_CASCADE_LAYERS = 4007;
  public static final int CSS_COLOR_COLOR_SPECIFIED_SPACE = 4472;
  public static final int CSS_COLOR_GRADIENT_COLOR_SPACE = 4489;
  public static final int CSS_COLOR_LAB_OKLAB = 4473;
  public static final int CSS_COLOR_LCH_OKLCH = 4474;
  public static final int CSS_COLOR_MIX_FUNCTION = 4471;
  public static final int CSS_COMPARISON_FUNCTIONS = 3157;
  public static final int CSS_CONTAIN_ALL_WITHOUT_CONTENT_VISIBILITY = 3467;
  public static final int CSS_CONTAIN_STRICT_WITHOUT_CONTENT_VISIBILITY = 3466;
  public static final int CSS_CUSTOM_STATE_DEPRECATED_SYNTAX = 4834;
  public static final int CSS_DECLARATION_AFTER_NESTED_RULE = 4709;
  public static final int CSS_ENVIRONMENT_VARIABLE = 2488;
  public static final int CSS_ENVIRONMENT_VARIABLE_SAFE_AREA_INSET_BOTTOM = 2491;
  public static final int CSS_ENVIRONMENT_VARIABLE_SAFE_AREA_INSET_LEFT = 2490;
  public static final int CSS_ENVIRONMENT_VARIABLE_SAFE_AREA_INSET_RIGHT = 2492;
  public static final int CSS_ENVIRONMENT_VARIABLE_SAFE_AREA_INSET_TOP = 2489;
  public static final int CSS_FILL_AVAILABLE_LOGICAL_HEIGHT = 2508;
  public static final int CSS_FILL_AVAILABLE_LOGICAL_WIDTH = 2507;
  public static final int CSS_FILTER_BLUR = 1023;
  public static final int CSS_FILTER_BRIGHTNESS = 1021;
  public static final int CSS_FILTER_COLOR_MATRIX = 3889;
  public static final int CSS_FILTER_CONTRAST = 1022;
  public static final int CSS_FILTER_DROP_SHADOW = 1024;
  public static final int CSS_FILTER_FUNCTION_NO_ARGUMENTS = 1403;
  public static final int CSS_FILTER_GRAYSCALE = 1015;
  public static final int CSS_FILTER_HUE_ROTATE = 1018;
  public static final int CSS_FILTER_INVERT = 1019;
  public static final int CSS_FILTER_LUMINANCE_TO_ALPHA = 3891;
  public static final int CSS_FILTER_OPACITY = 1020;
  public static final int CSS_FILTER_REFERENCE = 1014;
  public static final int CSS_FILTER_SATURATE = 1017;
  public static final int CSS_FILTER_SEPIA = 1016;
  public static final int CSS_FLEXIBLE_BOX = 1692;
  public static final int CSS_FUNCTIONS = 4861;
  public static final int CSS_GET_COMPUTED_ANIMATION_DURATION_ZERO = 4533;
  public static final int CSS_GET_COMPUTED_WEBKIT_FONT_SMOOTHING_ANIMATION_DURATION_ZERO = 4534;
  public static final int CSS_GRADIENT = 2355;
  public static final int CSS_GRID_LAYOUT = 1693;
  public static final int CSS_KEYFRAMES_RULE_ANONYMOUS_INDEXED_GETTER = 785;
  public static final int CSS_KEYWORD_REVERT = 3252;
  public static final int CSS_LEGACY_ALIGNMENT = 2351;
  public static final int CSS_LEGACY_BORDER_IMAGE = 4252;
  public static final int CSS_LEGACY_BORDER_IMAGE_WIDTH = 4253;
  public static final int CSS_LEGACY_PERSPECTIVE_ORIGIN = 4250;
  public static final int CSS_LEGACY_TRANSFORM_ORIGIN = 4251;
  public static final int CSS_NESTED_GROUP_RULE_SPECIFICITY = 4784;
  public static final int CSS_NESTING = 4372;
  public static final int CSS_OFFSET_IN_EFFECT = 1617;
  public static final int CSS_OVERFLOW_PAGED = 1867;
  public static final int CSS_PAGE_RULE = 4862;
  public static final int CSS_PAINT_FUNCTION = 2356;
  public static final int CSS_REGISTER_PROPERTY = 2018;
  public static final int CSS_RELATIVE_COLOR = 4632;
  public static final int CSS_RESIZE_AUTO = 2418;
  public static final int CSS_RULE_WITH_SIGNALING_CHILD_MODIFIED = 4785;
  public static final int CSS_SELECTOR_CUE = 2278;
  public static final int CSS_SELECTOR_EMPTY_WHITESPACE_ONLY_FAIL = 2624;
  public static final int CSS_SELECTOR_HOST_CONTEXT_IN_LIVE_PROFILE = 2830;
  public static final int CSS_SELECTOR_HOST_CONTEXT_IN_SNAPSHOT_PROFILE = 2829;
  public static final int CSS_SELECTOR_INDIRECT_ADJACENT = 1153;
  public static final int CSS_SELECTOR_INTERNAL_MEDIA_CONTROLS_OVERLAY_CAST_BUTTON = 1064;
  public static final int CSS_SELECTOR_INTERNAL_PSEUDO_LIST_BOX = 1062;
  public static final int CSS_SELECTOR_INTERNAL_PSEUDO_SPATIAL_NAVIGATION_FOCUS = 1065;
  public static final int CSS_SELECTOR_PSEUDO_ANY = 1250;
  public static final int CSS_SELECTOR_PSEUDO_ANY_LINK = 2266;
  public static final int CSS_SELECTOR_PSEUDO_DEFINED = 1383;
  public static final int CSS_SELECTOR_PSEUDO_DIR = 3741;
  public static final int CSS_SELECTOR_PSEUDO_FOCUS = 2387;
  public static final int CSS_SELECTOR_PSEUDO_FOCUS_VISIBLE = 2388;
  public static final int CSS_SELECTOR_PSEUDO_FULL_SCREEN = 629;
  public static final int CSS_SELECTOR_PSEUDO_FULL_SCREEN_ANCESTOR = 628;
  public static final int CSS_SELECTOR_PSEUDO_HAS = 4743;
  public static final int CSS_SELECTOR_PSEUDO_HOST = 469;
  public static final int CSS_SELECTOR_PSEUDO_HOST_CONTEXT = 470;
  public static final int CSS_SELECTOR_PSEUDO_IS = 2322;
  public static final int CSS_SELECTOR_PSEUDO_READ_ONLY = 1377;
  public static final int CSS_SELECTOR_PSEUDO_READ_WRITE = 1378;
  public static final int CSS_SELECTOR_PSEUDO_SCROLLBAR = 582;
  public static final int CSS_SELECTOR_PSEUDO_SCROLLBAR_BUTTON = 583;
  public static final int CSS_SELECTOR_PSEUDO_SCROLLBAR_BUTTON_REVERSED_DIRECTION = 3038;
  public static final int CSS_SELECTOR_PSEUDO_SCROLLBAR_THUMB = 584;
  public static final int CSS_SELECTOR_PSEUDO_SCROLLBAR_TRACK = 585;
  public static final int CSS_SELECTOR_PSEUDO_SCROLLBAR_TRACK_PIECE = 586;
  public static final int CSS_SELECTOR_PSEUDO_SLOTTED = 1118;
  public static final int CSS_SELECTOR_PSEUDO_STATE = 4827;
  public static final int CSS_SELECTOR_PSEUDO_UNRESOLVED = 466;
  public static final int CSS_SELECTOR_PSEUDO_WEBKIT_ANY_LINK = 2260;
  public static final int CSS_SELECTOR_PSEUDO_WHERE = 2431;
  public static final int CSS_SELECTOR_TARGET_TEXT = 3780;
  public static final int CSS_SELECTOR_WEBKIT_CALENDAR_PICKER_INDICATOR = 2279;
  public static final int CSS_SELECTOR_WEBKIT_CLEAR_BUTTON = 2280;
  public static final int CSS_SELECTOR_WEBKIT_COLOR_SWATCH = 2281;
  public static final int CSS_SELECTOR_WEBKIT_COLOR_SWATCH_WRAPPER = 2282;
  public static final int CSS_SELECTOR_WEBKIT_DATETIME_EDIT = 2284;
  public static final int CSS_SELECTOR_WEBKIT_DATETIME_EDIT_AMPM_FIELD = 2285;
  public static final int CSS_SELECTOR_WEBKIT_DATETIME_EDIT_DAY_FIELD = 2286;
  public static final int CSS_SELECTOR_WEBKIT_DATETIME_EDIT_FIELDS_WRAPPER = 2287;
  public static final int CSS_SELECTOR_WEBKIT_DATETIME_EDIT_HOUR_FIELD = 2288;
  public static final int CSS_SELECTOR_WEBKIT_DATETIME_EDIT_MILLISECOND_FIELD = 2289;
  public static final int CSS_SELECTOR_WEBKIT_DATETIME_EDIT_MINUTE_FIELD = 2290;
  public static final int CSS_SELECTOR_WEBKIT_DATETIME_EDIT_MONTH_FIELD = 2291;
  public static final int CSS_SELECTOR_WEBKIT_DATETIME_EDIT_SECOND_FIELD = 2292;
  public static final int CSS_SELECTOR_WEBKIT_DATETIME_EDIT_TEXT = 2293;
  public static final int CSS_SELECTOR_WEBKIT_DATETIME_EDIT_WEEK_FIELD = 2294;
  public static final int CSS_SELECTOR_WEBKIT_DATETIME_EDIT_YEAR_FIELD = 2295;
  public static final int CSS_SELECTOR_WEBKIT_DATE_AND_TIME_VALUE = 2283;
  public static final int CSS_SELECTOR_WEBKIT_FILE_UPLOAD_BUTTON = 2297;
  public static final int CSS_SELECTOR_WEBKIT_INNER_SPIN_BUTTON = 2298;
  public static final int CSS_SELECTOR_WEBKIT_INPUT_PLACEHOLDER = 2299;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS = 2037;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_CURRENT_TIME_DISPLAY = 2043;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_ENCLOSURE = 2040;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_FULLSCREEN_BUTTON = 2049;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_MUTE_BUTTON = 2047;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_OVERLAY_ENCLOSURE = 2038;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_OVERLAY_PLAY_BUTTON = 2039;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_PANEL = 2041;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_PLAY_BUTTON = 2042;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_TIMELINE = 2045;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_TIMELINE_CONTAINER = 2046;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_TIME_REMAINING_DISPLAY = 2044;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_TOGGLE_CLOSED_CAPTIONS_BUTTON = 2050;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_VOLUME_SLIDER = 2048;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_SLIDER_CONTAINER = 2300;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_SLIDER_THUMB = 2301;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_TEXT_TRACK_CONTAINER = 2302;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_TEXT_TRACK_DISPLAY = 2303;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_TEXT_TRACK_REGION = 2304;
  public static final int CSS_SELECTOR_WEBKIT_MEDIA_TEXT_TRACK_REGION_CONTAINER = 2305;
  public static final int CSS_SELECTOR_WEBKIT_METER_BAR = 2306;
  public static final int CSS_SELECTOR_WEBKIT_METER_EVEN_LESS_GOOD_VALUE = 2307;
  public static final int CSS_SELECTOR_WEBKIT_METER_INNER_ELEMENT = 2308;
  public static final int CSS_SELECTOR_WEBKIT_METER_OPTIMUM_VALUE = 2309;
  public static final int CSS_SELECTOR_WEBKIT_METER_SUBOPTIMUM_VALUE = 2310;
  public static final int CSS_SELECTOR_WEBKIT_PROGRESS_BAR = 2311;
  public static final int CSS_SELECTOR_WEBKIT_PROGRESS_INNER_ELEMENT = 2312;
  public static final int CSS_SELECTOR_WEBKIT_PROGRESS_VALUE = 2313;
  public static final int CSS_SELECTOR_WEBKIT_SEARCH_CANCEL_BUTTON = 2314;
  public static final int CSS_SELECTOR_WEBKIT_SLIDER_CONTAINER = 2315;
  public static final int CSS_SELECTOR_WEBKIT_SLIDER_RUNNABLE_TRACK = 2316;
  public static final int CSS_SELECTOR_WEBKIT_SLIDER_THUMB = 2317;
  public static final int CSS_SELECTOR_WEBKIT_TEXTFIELD_DECORATION_CONTAINER = 2318;
  public static final int CSS_SELECTOR_WEBKIT_UNKNOWN_PSEUDO = 2319;
  public static final int CSS_STYLE_CONTAINER_QUERY = 4550;
  public static final int CSS_STYLE_SHEET_ADD_RULE = 220;
  public static final int CSS_STYLE_SHEET_REMOVE_RULE = 221;
  public static final int CSS_STYLE_SHEET_REPLACE = 2844;
  public static final int CSS_STYLE_SHEET_REPLACE_SYNC = 2845;
  public static final int CSS_STYLE_SHEET_RULES = 219;
  public static final int CSS_SUBGRID_LAYOUT = 4680;
  public static final int CSS_TRANSITION_BLOCKED_BY_ANIMATION = 4066;
  public static final int CSS_TRANSITION_CANCELLED_BY_REMOVING_STYLE = 2914;
  public static final int CSS_TYPED_OM_STYLE_PROPERTY_MAP = 2334;
  public static final int CSS_UNKNOWN_NAMESPACE_PREFIX_IN_SELECTOR = 2626;
  public static final int CSS_VALUE_APPEARANCE_BUTTON = 1354;
  public static final int CSS_VALUE_APPEARANCE_BUTTON_FOR_BUTTON = 1471;
  public static final int CSS_VALUE_APPEARANCE_BUTTON_FOR_OTHER_BUTTONS = 1472;
  public static final int CSS_VALUE_APPEARANCE_CHECKBOX = 1356;
  public static final int CSS_VALUE_APPEARANCE_CHECKBOX_RENDERED = 2559;
  public static final int CSS_VALUE_APPEARANCE_INNER_SPIN_BUTTON = 2814;
  public static final int CSS_VALUE_APPEARANCE_INNER_SPIN_BUTTON_RENDERED = 2563;
  public static final int CSS_VALUE_APPEARANCE_LISTBOX = 1359;
  public static final int CSS_VALUE_APPEARANCE_MEDIA_SLIDER = 4551;
  public static final int CSS_VALUE_APPEARANCE_MEDIA_SLIDERTHUMB = 4552;
  public static final int CSS_VALUE_APPEARANCE_MEDIA_SLIDER_RENDERED = 4388;
  public static final int CSS_VALUE_APPEARANCE_MEDIA_SLIDER_THUMB_RENDERED = 4389;
  public static final int CSS_VALUE_APPEARANCE_MEDIA_VOLUME_SLIDER = 4553;
  public static final int CSS_VALUE_APPEARANCE_MEDIA_VOLUME_SLIDERTHUMB = 4554;
  public static final int CSS_VALUE_APPEARANCE_MEDIA_VOLUME_SLIDER_RENDERED = 4390;
  public static final int CSS_VALUE_APPEARANCE_MEDIA_VOLUME_SLIDER_THUMB_RENDERED = 4391;
  public static final int CSS_VALUE_APPEARANCE_MENULIST = 1357;
  public static final int CSS_VALUE_APPEARANCE_MENULIST_BUTTON = 1358;
  public static final int CSS_VALUE_APPEARANCE_MENU_LIST_BUTTON_RENDERED = 2582;
  public static final int CSS_VALUE_APPEARANCE_MENU_LIST_RENDERED = 2565;
  public static final int CSS_VALUE_APPEARANCE_METER = 2815;
  public static final int CSS_VALUE_APPEARANCE_NONE = 1351;
  public static final int CSS_VALUE_APPEARANCE_NON_STANDARD = 4416;
  public static final int CSS_VALUE_APPEARANCE_NOT_NONE = 1352;
  public static final int CSS_VALUE_APPEARANCE_NO_IMPLEMENTATION_SKIP_BORDER = 2614;
  public static final int CSS_VALUE_APPEARANCE_OTHERS = 1353;
  public static final int CSS_VALUE_APPEARANCE_PROGRESS_BAR = 2816;
  public static final int CSS_VALUE_APPEARANCE_PROGRESS_BAR_RENDERED = 2567;
  public static final int CSS_VALUE_APPEARANCE_PUSH_BUTTON = 2818;
  public static final int CSS_VALUE_APPEARANCE_PUSH_BUTTON_RENDERED = 2584;
  public static final int CSS_VALUE_APPEARANCE_RADIO = 1360;
  public static final int CSS_VALUE_APPEARANCE_RADIO_RENDERED = 2561;
  public static final int CSS_VALUE_APPEARANCE_SEARCH_CANCEL = 2820;
  public static final int CSS_VALUE_APPEARANCE_SEARCH_CANCEL_RENDERED = 2578;
  public static final int CSS_VALUE_APPEARANCE_SEARCH_FIELD = 1361;
  public static final int CSS_VALUE_APPEARANCE_SEARCH_FIELD_RENDERED = 2576;
  public static final int CSS_VALUE_APPEARANCE_SLIDERTHUMB_HORIZONTAL = 4557;
  public static final int CSS_VALUE_APPEARANCE_SLIDERTHUMB_VERTICAL = 4558;
  public static final int CSS_VALUE_APPEARANCE_SLIDER_HORIZONTAL = 4555;
  public static final int CSS_VALUE_APPEARANCE_SLIDER_HORIZONTAL_RENDERED = 2568;
  public static final int CSS_VALUE_APPEARANCE_SLIDER_THUMB_HORIZONTAL_RENDERED = 2572;
  public static final int CSS_VALUE_APPEARANCE_SLIDER_THUMB_VERTICAL_RENDERED = 2574;
  public static final int CSS_VALUE_APPEARANCE_SLIDER_VERTICAL = 4556;
  public static final int CSS_VALUE_APPEARANCE_SLIDER_VERTICAL_RENDERED = 2570;
  public static final int CSS_VALUE_APPEARANCE_SQUARE_BUTTON = 2819;
  public static final int CSS_VALUE_APPEARANCE_SQUARE_BUTTON_RENDERED = 2586;
  public static final int CSS_VALUE_APPEARANCE_TEXTAREA = 2821;
  public static final int CSS_VALUE_APPEARANCE_TEXT_AREA_RENDERED = 2580;
  public static final int CSS_VALUE_APPEARANCE_TEXT_FIELD = 1362;
  public static final int CSS_VALUE_APPEARANCE_TEXT_FIELD_FOR_SEARCH = 1474;
  public static final int CSS_VALUE_APPEARANCE_TEXT_FIELD_FOR_TEMPORAL_RENDERED = 2823;
  public static final int CSS_VALUE_APPEARANCE_TEXT_FIELD_FOR_TEXT_FIELD = 1475;
  public static final int CSS_VALUE_CONTAIN_STYLE = 2871;
  public static final int CSS_VALUE_DISPLAY_CONTENTS = 2265;
  public static final int CSS_VALUE_ON_DEMAND = 1802;
  public static final int CSS_VALUE_OVERFLOW_OVERLAY = 2995;
  public static final int CSS_VALUE_PREFIXED_FILL_AVAILABLE = 924;
  public static final int CSS_VALUE_PREFIXED_FIT_CONTENT = 923;
  public static final int CSS_VALUE_PREFIXED_MAX_CONTENT = 922;
  public static final int CSS_VALUE_PREFIXED_MIN_CONTENT = 921;
  public static final int CSS_VALUE_USER_MODIFY_READ_ONLY = 1798;
  public static final int CSS_VALUE_USER_MODIFY_READ_WRITE = 1799;
  public static final int CSS_VALUE_USER_MODIFY_READ_WRITE_PLAINTEXT_ONLY = 1800;
  public static final int CSS_ZOOM_NOT_EQUAL_TO_ONE = 691;
  public static final int CURSOR_IMAGE_G_T32X32 = 2590;
  public static final int CURSOR_IMAGE_G_T64X64 = 2620;
  public static final int CURSOR_IMAGE_L_E32X32 = 2589;
  public static final int CUSTOM_ELEMENT_REGISTRY_DEFINE = 1689;
  public static final int CUSTOM_SCROLLBAR_PART_PERCENT_LENGTH = 3256;
  public static final int CUSTOM_SCROLLBAR_PERCENT_THICKNESS = 3255;
  public static final int DANGLING_MARKUP_IN_TARGET = 4493;
  public static final int DANGLING_MARKUP_IN_TARGET_NOT_ENDS_WITH_GT = 4494;
  public static final int DANGLING_MARKUP_IN_TARGET_NOT_ENDS_WITH_NEW_LINE_OR_GT = 4495;
  public static final int DANGLING_MARKUP_IN_WINDOW_NAME = 4490;
  public static final int DANGLING_MARKUP_IN_WINDOW_NAME_NOT_ENDS_WITH_GT = 4492;
  public static final int DANGLING_MARKUP_IN_WINDOW_NAME_NOT_ENDS_WITH_NEW_LINE_OR_GT = 4491;
  public static final int DATA_ELEMENT = 1099;
  public static final int DATA_LIST_ELEMENT = 23;
  public static final int DATA_URL_IN_SVG_USE = 4356;
  public static final int DATE_TIME_FORMAT = 2595;
  public static final int DATE_TIME_FORMAT_DATE_TIME_STYLE = 3175;
  public static final int DATE_TIME_FORMAT_RANGE = 3174;
  public static final int DATE_TO_LOCALE_DATE_STRING = 2606;
  public static final int DATE_TO_LOCALE_STRING = 2605;
  public static final int DATE_TO_LOCALE_TIME_STRING = 2607;
  public static final int DECLARATIVE_SHADOW_ROOT = 3196;
  public static final int DECOMPRESSION_STREAM_CONSTRUCTOR = 3061;
  public static final int DELEGATE_FOCUS = 3030;
  public static final int DEMOTED_FORM_ELEMENT = 85;
  public static final int DEPRECATED_CSS_CONTAIN_LAYOUT_POSITIONED_DESCENDANTS = 2463;
  public static final int DEPRECATED_FILE_SYSTEM_READ = 3025;
  public static final int DEPRECATED_FILE_SYSTEM_WRITE = 3026;
  public static final int DEPRECATED_FLEXBOX_CHROME = 62;
  public static final int DEPRECATED_FLEXBOX_CHROME_EXTENSION = 63;
  public static final int DEPRECATED_FLEXBOX_WEB_CONTENT = 61;
  public static final int DEPRECATED_INTEREST_GROUP_DAILY_UPDATE_URL = 4488;
  public static final int DEPRECATED_RTC_PEER_CONNECTION_ID = 2384;
  public static final int DEPRECATED_WEB_KIT_GRADIENT = 260;
  public static final int DEPRECATED_WEB_KIT_LINEAR_GRADIENT = 261;
  public static final int DEPRECATED_WEB_KIT_RADIAL_GRADIENT = 263;
  public static final int DEPRECATED_WEB_KIT_REPEATING_LINEAR_GRADIENT = 262;
  public static final int DEPRECATED_WEB_KIT_REPEATING_RADIAL_GRADIENT = 264;
  public static final int DEPRECATION_EXAMPLE = 4192;
  public static final int DEPRECATION_REPORT = 2530;
  public static final int DESTRUCTIVE_DOCUMENT_WRITE_AFTER_MODULE_SCRIPT = 4360;
  public static final int DETAILS_ELEMENT = 480;
  public static final int DEVICE_MOTION_PERMISSION_REQUESTED = 4291;
  public static final int DEVICE_MOTION_SECURE_ORIGIN = 669;
  public static final int DEVICE_MOTION_USED_WITHOUT_PERMISSION_REQUEST = 4292;
  public static final int DEVICE_ORIENTATION_ABSOLUTE_SECURE_ORIGIN = 988;
  public static final int DEVICE_ORIENTATION_PERMISSION_REQUESTED = 4289;
  public static final int DEVICE_ORIENTATION_SECURE_ORIGIN = 671;
  public static final int DEVICE_ORIENTATION_USED_WITHOUT_PERMISSION_REQUEST = 4290;
  public static final int DIALOG_ELEMENT = 481;
  public static final int DIALOG_HEIGHT_LARGER_THAN_VIEWPORT = 3330;
  public static final int DIALOG_IN_SANDBOXED_CONTEXT = 767;
  public static final int DIALOG_WITH_NON_ZERO_SCROLL_OFFSET = 3329;
  public static final int DIFFERENT_PERSPECTIVE_CB_OR_PARENT = 3946;
  public static final int DIGITAL_GOODS_ACKNOWLEDGE = 3398;
  public static final int DIGITAL_GOODS_CONSUME = 4036;
  public static final int DIGITAL_GOODS_GET_DETAILS = 3397;
  public static final int DIGITAL_GOODS_GET_DIGITAL_GOODS_SERVICE = 3396;
  public static final int DIGITAL_GOODS_LIST_PURCHASES = 3709;
  public static final int DIGITAL_GOODS_LIST_PURCHASE_HISTORY = 4037;
  public static final int DIRECTLY_COMPOSITED_IMAGE = 2731;
  public static final int DISABLE_PICTURE_IN_PICTURE_ATTRIBUTE = 2358;
  public static final int DISABLE_REMOTE_PLAYBACK_ATTRIBUTE = 1074;
  public static final int
      DISABLE_THIRD_PARTY_SESSION_STORAGE_PARTITIONING_AFTER_GENERAL_PARTITIONING = 4439;
  public static final int DISABLE_THIRD_PARTY_STORAGE_PARTITIONING = 4444;
  public static final int DISALLOW_DOCUMENT_ACCESS = 3165;
  public static final int DISCARD_INPUT_EVENT_TO_MOVING_IFRAME = 2952;
  public static final int DISPLAY_NAMES = 3172;
  public static final int DISTRUSTED_LEGACY_SYMANTEC_SUBRESOURCE = 2389;
  public static final int DOCUMENT_ALL = 83;
  public static final int DOCUMENT_BEFORE_UNLOAD_FIRED = 201;
  public static final int DOCUMENT_BEFORE_UNLOAD_REGISTERED = 200;
  public static final int DOCUMENT_CAPTURE_EVENTS = 287;
  public static final int DOCUMENT_CARET_RANGE_FROM_POINT = 387;
  public static final int DOCUMENT_CLEAR = 74;
  public static final int DOCUMENT_CREATE_ATTRIBUTE = 111;
  public static final int DOCUMENT_CREATE_ATTRIBUTE_NS = 112;
  public static final int DOCUMENT_CREATE_ELEMENT2ND_ARG_STRING_HANDLING = 1668;
  public static final int DOCUMENT_CREATE_EVENT_ANIMATION_EVENT = 1162;
  public static final int DOCUMENT_CREATE_EVENT_BEFORE_UNLOAD_EVENT = 1166;
  public static final int DOCUMENT_CREATE_EVENT_CLOSE_EVENT = 1227;
  public static final int DOCUMENT_CREATE_EVENT_COMPOSITION_EVENT = 1168;
  public static final int DOCUMENT_CREATE_EVENT_DEVICE_MOTION_EVENT = 1195;
  public static final int DOCUMENT_CREATE_EVENT_DEVICE_ORIENTATION_EVENT = 1196;
  public static final int DOCUMENT_CREATE_EVENT_DRAG_EVENT = 1169;
  public static final int DOCUMENT_CREATE_EVENT_ERROR_EVENT = 1170;
  public static final int DOCUMENT_CREATE_EVENT_FOCUS_EVENT = 1171;
  public static final int DOCUMENT_CREATE_EVENT_HASH_CHANGE_EVENT = 1172;
  public static final int DOCUMENT_CREATE_EVENT_IDB_VERSION_CHANGE_EVENT = 1201;
  public static final int DOCUMENT_CREATE_EVENT_KEYBOARD_EVENTS = 1228;
  public static final int DOCUMENT_CREATE_EVENT_MUTATION_EVENT = 1173;
  public static final int DOCUMENT_CREATE_EVENT_MUTATION_EVENTS = 1188;
  public static final int DOCUMENT_CREATE_EVENT_PAGE_TRANSITION_EVENT = 1174;
  public static final int DOCUMENT_CREATE_EVENT_POP_STATE_EVENT = 1176;
  public static final int DOCUMENT_CREATE_EVENT_STORAGE_EVENT = 1221;
  public static final int DOCUMENT_CREATE_EVENT_SVG_EVENTS = 1190;
  public static final int DOCUMENT_CREATE_EVENT_TEXT_EVENT = 1182;
  public static final int DOCUMENT_CREATE_EVENT_TRACK_EVENT = 1186;
  public static final int DOCUMENT_CREATE_EVENT_TRANSITION_EVENT = 1183;
  public static final int DOCUMENT_CREATE_EVENT_WEB_GL_CONTEXT_EVENT = 1224;
  public static final int DOCUMENT_CREATE_EVENT_WHEEL_EVENT = 1184;
  public static final int DOCUMENT_DESIGN_MODE = 742;
  public static final int DOCUMENT_DESIGN_MODE_ENABELD = 1129;
  public static final int DOCUMENT_DOMAIN_BLOCKED_CROSS_ORIGIN_ACCESS = 2543;
  public static final int DOCUMENT_DOMAIN_ENABLED_CROSS_ORIGIN_ACCESS = 2544;
  public static final int DOCUMENT_DOMAIN_SETTING_WITHOUT_ORIGIN_AGENT_CLUSTER_HEADER = 4085;
  public static final int DOCUMENT_DOMAIN_SET_WITH_DEFAULT_PORT = 2026;
  public static final int DOCUMENT_DOMAIN_SET_WITH_NON_DEFAULT_PORT = 2025;
  public static final int DOCUMENT_EXIT_POINTER_LOCK = 421;
  public static final int DOCUMENT_FONTS = 440;
  public static final int DOCUMENT_LEVEL_PASSIVE_DEFAULT_EVENT_LISTENER_PREVENTED_WHEEL = 2521;
  public static final int DOCUMENT_LOADER_DELIVERY_TYPE_NAVIGATIONAL_PREFETCH = 4393;
  public static final int DOCUMENT_OPEN_ALIASED_ORIGIN_DOCUMENT_DOMAIN = 4535;
  public static final int DOCUMENT_OPEN_DIFFERENT_WINDOW = 4374;
  public static final int DOCUMENT_OPEN_MUTATE_SANDBOX = 4375;
  public static final int DOCUMENT_OPEN_THREE_ARGS = 2496;
  public static final int DOCUMENT_OPEN_TWO_ARGS = 2494;
  public static final int DOCUMENT_OPEN_TWO_ARGS_WITH_REPLACE = 2495;
  public static final int DOCUMENT_PAGE_HIDE_FIRED = 2227;
  public static final int DOCUMENT_PAGE_HIDE_REGISTERED = 2226;
  public static final int DOCUMENT_PAGE_SHOW_FIRED = 2229;
  public static final int DOCUMENT_PAGE_SHOW_REGISTERED = 2228;
  public static final int DOCUMENT_PICTURE_IN_PICTURE_ENTER_EVENT = 4400;
  public static final int DOCUMENT_POINTER_LOCK_ELEMENT = 422;
  public static final int DOCUMENT_POLICY_CAUSED_PAGE_UNLOAD = 3229;
  public static final int DOCUMENT_POLICY_HEADER = 3225;
  public static final int DOCUMENT_POLICY_IFRAME_POLICY_ATTRIBUTE = 3228;
  public static final int DOCUMENT_POLICY_REPORT_ONLY_HEADER = 3226;
  public static final int DOCUMENT_RELEASE_EVENTS = 288;
  public static final int DOCUMENT_SET_DOMAIN = 739;
  public static final int DOCUMENT_UNLOAD_FIRED = 203;
  public static final int DOCUMENT_UNLOAD_REGISTERED = 202;
  public static final int DOCUMENT_XML_ENCODING = 115;
  public static final int DOCUMENT_XML_STANDALONE = 116;
  public static final int DOCUMENT_XML_VERSION = 117;
  public static final int DOCUMENT_X_PATH_CREATE_EXPRESSION = 295;
  public static final int DOCUMENT_X_PATH_CREATE_NS_RESOLVER = 296;
  public static final int DOCUMENT_X_PATH_EVALUATE = 297;
  public static final int DOM_CHARACTER_DATA_MODIFIED_EVENT = 148;
  public static final int DOM_CLOBBERED_VARIABLE_ACCESSED = 1824;
  public static final int DOM_FOCUS_IN_OUT_EVENT = 211;
  public static final int DOM_NODE_INSERTED_EVENT = 144;
  public static final int DOM_NODE_INSERTED_INTO_DOCUMENT_EVENT = 147;
  public static final int DOM_NODE_REMOVED_EVENT = 145;
  public static final int DOM_NODE_REMOVED_FROM_DOCUMENT_EVENT = 146;
  public static final int DOM_STORAGE_READ = 3019;
  public static final int DOM_STORAGE_WRITE = 3020;
  public static final int DOM_SUBTREE_MODIFIED_EVENT = 143;
  public static final int DOM_WINDOW_OPEN = 475;
  public static final int DOM_WINDOW_OPEN_CROSS_ORIGIN_IFRAME = 4420;
  public static final int DOM_WINDOW_OPEN_FEATURES = 476;
  public static final int DOM_WINDOW_OPEN_POSITIONING_FEATURES = 3071;
  public static final int DOM_WINDOW_OPEN_POSITIONING_FEATURES_CROSS_SCREEN = 3392;
  public static final int DOM_WINDOW_SET_WINDOW_RECT_CROSS_SCREEN = 3393;
  public static final int DOWNLOAD_IN_AD_FRAME = 2974;
  public static final int DOWNLOAD_IN_AD_FRAME_WITHOUT_USER_GESTURE = 2653;
  public static final int DOWNLOAD_IN_SANDBOX = 2975;
  public static final int DOWNLOAD_POST_POLICY_CHECK = 2839;
  public static final int DOWNLOAD_PRE_POLICY_CHECK = 2838;
  public static final int DOWNLOAD_WITHOUT_USER_GESTURE = 2976;
  public static final int DRAGGABLE_ATTRIBUTE = 1539;
  public static final int DRAG_AND_DROP_SCROLL_START = 1554;
  public static final int DUPLICATED_ATTRIBUTE = 2250;
  public static final int DUPLICATED_ATTRIBUTE_FOR_EXECUTED_SCRIPT = 2251;
  public static final int DURABLE_STORAGE_ESTIMATE = 1371;
  public static final int DURABLE_STORAGE_PERSIST = 1369;
  public static final int DURABLE_STORAGE_PERSISTED = 1370;
  public static final int DURING_MICROTASK_ALERT = 1334;
  public static final int DURING_MICROTASK_CONFIRM = 1335;
  public static final int DURING_MICROTASK_PRINT = 1336;
  public static final int DURING_MICROTASK_PROMPT = 1337;
  public static final int DURING_MICROTASK_SYNC_XHR = 1338;
  public static final int DYNAMIC_IMPORT_MODULE_SCRIPT = 2616;
  public static final int EARLY_HINTS_PRELOAD = 3967;
  public static final int EDITING_APPLE_CONVERTED_SPACE = 459;
  public static final int EDITING_APPLE_INTERCHANGE_NEWLINE = 458;
  public static final int EDITING_APPLE_PASTE_AS_QUOTATION = 460;
  public static final int EDITING_APPLE_STYLE_SPAN_CLASS = 461;
  public static final int EDIT_CONTEXT = 4588;
  public static final int EFFECTIVE_ALIGN_CONTENT_FOR_BLOCK = 4773;
  public static final int EFFECTIVE_ALIGN_CONTENT_FOR_TABLE_CELL = 4774;
  public static final int ELEMENT_ATTACH_INTERNALS = 3435;
  public static final int ELEMENT_ATTACH_SERIALIZABLE_SHADOW = 4782;
  public static final int ELEMENT_ATTACH_SHADOW = 804;
  public static final int ELEMENT_ATTACH_SHADOW_CLOSED = 908;
  public static final int ELEMENT_ATTACH_SHADOW_OPEN = 907;
  public static final int ELEMENT_CAPTURE = 4636;
  public static final int ELEMENT_CHECK_VISIBILITY = 4691;
  public static final int ELEMENT_CHECK_VISIBILITY_OPTION_CHECK_OPACITY = 4703;
  public static final int ELEMENT_CHECK_VISIBILITY_OPTION_CHECK_VISIBILITY_CSS = 4702;
  public static final int ELEMENT_CHECK_VISIBILITY_OPTION_CONTENT_VISIBILITY_AUTO = 4716;
  public static final int ELEMENT_CHECK_VISIBILITY_OPTION_OPACITY_PROPERTY = 4717;
  public static final int ELEMENT_CHECK_VISIBILITY_OPTION_VISIBILITY_PROPERTY = 4718;
  public static final int ELEMENT_GET_HTML = 4781;
  public static final int ELEMENT_GET_INNER_HTML = 3874;
  public static final int ELEMENT_HIDE_POPOVER = 4190;
  public static final int ELEMENT_INTERNALS_SHADOW_ROOT = 3378;
  public static final int ELEMENT_INTERNALS_STATES = 3796;
  public static final int ELEMENT_NAME_DOM_INVALID_HTML_PARSER_VALID = 1968;
  public static final int ELEMENT_NAME_DOM_VALID_HTML_PARSER_INVALID = 1969;
  public static final int ELEMENT_PREFIXED_MATCHES_SELECTOR = 217;
  public static final int ELEMENT_REQUEST_POINTER_LOCK = 417;
  public static final int ELEMENT_REQUEST_POINTER_LOCK_IFRAME = 1146;
  public static final int ELEMENT_REQUEST_POINTER_LOCK_IN_SHADOW = 1421;
  public static final int ELEMENT_SCROLL_INTO_VIEW_IF_NEEDED = 389;
  public static final int ELEMENT_SHOW_POPOVER = 4189;
  public static final int ELEMENT_TIMING_EXPLICITLY_REQUESTED = 2728;
  public static final int ELEMENT_TOGGLE_POPOVER = 4384;
  public static final int ELEMENT_WITH_LEFTWARD_OR_UPWARD_OVERFLOW_DIRECTION_SCROLL_LEFT_OR_TOP =
      2998;
  public static final int
      ELEMENT_WITH_LEFTWARD_OR_UPWARD_OVERFLOW_DIRECTION_SCROLL_LEFT_OR_TOP_SET_POSITIVE = 2999;
  public static final int ELIGIBLE_FOR_IMAGE_LOADING_PRIORITIZATION_FIX = 4376;
  public static final int EMAIL_FIELD_FILLED_PATTERN_MATCH = 3382;
  public static final int EMAIL_FIELD_FILLED_PREDICTED_TYPE_MATCH = 3380;
  public static final int EMBEDDED_CROSS_ORIGIN_FRAME_WITHOUT_FRAME_ANCESTORS_OR_XFO = 3752;
  public static final int EMBED_ELEMENT_WITHOUT_TYPE_SRC_CHANGED = 3749;
  public static final int ENCRYPTED_MEDIA_CROSS_ORIGIN_IFRAME = 2036;
  public static final int ENCRYPTED_MEDIA_DISABLED_BY_FEATURE_POLICY = 2197;
  public static final int ENCRYPTED_MEDIA_SECURE_ORIGIN = 770;
  public static final int ENTER_PICTURE_IN_PICTURE_EVENT_LISTENER = 2445;
  public static final int ENTRY_COPY_TO_METHOD_ISOLATED_FILE_SYSTEM = 1330;
  public static final int ENTRY_FILESYSTEM_ATTRIBUTE_GETTER_ISOLATED_FILE_SYSTEM = 1327;
  public static final int ENTRY_GET_METADATA_METHOD_ISOLATED_FILE_SYSTEM = 1328;
  public static final int ENTRY_GET_PARENT_METHOD_ISOLATED_FILE_SYSTEM = 1332;
  public static final int ENTRY_MOVE_TO_METHOD_ISOLATED_FILE_SYSTEM = 1329;
  public static final int ENTRY_REMOVE_METHOD_ISOLATED_FILE_SYSTEM = 1331;
  public static final int ENTRY_TO_URL_METHOD_ISOLATED_FILE_SYSTEM = 1333;
  public static final int EVENT_CANCEL_BUBBLE = 344;
  public static final int EVENT_COMPOSED = 1140;
  public static final int EVENT_COMPOSED_PATH = 1123;
  public static final int EVENT_GET_RETURN_VALUE_FALSE = 351;
  public static final int EVENT_GET_RETURN_VALUE_TRUE = 350;
  public static final int EVENT_RETURN_VALUE = 137;
  public static final int EVENT_SET_RETURN_VALUE_FALSE = 353;
  public static final int EVENT_SET_RETURN_VALUE_TRUE = 352;
  public static final int EVENT_SOURCE_DOCUMENT = 1479;
  public static final int EVENT_SOURCE_WORKER = 1480;
  public static final int EVENT_SRC_ELEMENT = 343;
  public static final int EVENT_TARGET_ON_OBSERVABLE = 4757;
  public static final int EVENT_TIMING_ARTIFICIAL_POINTERUP_OR_CLICK = 4581;
  public static final int EVENT_TIMING_EXPLICITLY_REQUESTED = 2487;
  public static final int EVENT_TIMING_FIRST_INPUT_EXPLICITLY_REQUESTED = 3254;
  public static final int EVENT_TIMING_INTERACTION_ID = 4256;
  public static final int EXECUTED_EMPTY_JAVA_SCRIPT_URL_FROM_FRAME = 4483;
  public static final int EXECUTED_JAVA_SCRIPT_URL = 2955;
  public static final int EXECUTED_JAVA_SCRIPT_URL_FROM_FRAME = 4484;
  public static final int EXECUTED_NON_TRIVIAL_JAVA_SCRIPT_URL = 4377;
  public static final int EXEC_COMMAND = 4585;
  public static final int EXEC_COMMAND_ALTERS_HTML_STRUCTURE = 1440;
  public static final int EXEC_COMMAND_ON_INPUT_OR_TEXTAREA = 1027;
  public static final int EXPLICIT_OVERFLOW_VISIBLE_ON_REPLACED_ELEMENT = 4201;
  public static final int EXPLICIT_OVERFLOW_VISIBLE_ON_REPLACED_ELEMENT_WITH_OBJECT_PROP = 4202;
  public static final int EXPLICIT_POINTER_CAPTURE_CLICK_TARGET_DIFF = 3942;
  public static final int EXTERNAL_PROTOCOL_BLOCKED_BY_SANDBOX = 4058;
  public static final int FACE_DETECTOR_DETECT = 3712;
  public static final int FEATURE_POLICY_ALLOW_ATTRIBUTE = 2028;
  public static final int FEATURE_POLICY_ALLOW_ATTRIBUTE_DEPRECATED_SYNTAX = 2145;
  public static final int FEATURE_POLICY_COMMA_SEPARATED_DECLARATIONS = 2922;
  public static final int FEATURE_POLICY_HEADER = 2027;
  public static final int FEATURE_POLICY_JSAPI = 2511;
  public static final int FEATURE_POLICY_JSAPI_ALLOWED_FEATURES_DOCUMENT = 3835;
  public static final int FEATURE_POLICY_JSAPI_ALLOWED_FEATURES_I_FRAME = 3834;
  public static final int FEATURE_POLICY_JSAPI_ALLOWS_FEATURE_DOCUMENT = 3831;
  public static final int FEATURE_POLICY_JSAPI_ALLOWS_FEATURE_I_FRAME = 3830;
  public static final int FEATURE_POLICY_JSAPI_ALLOWS_FEATURE_ORIGIN_DOCUMENT = 3833;
  public static final int FEATURE_POLICY_JSAPI_ALLOWS_FEATURE_ORIGIN_I_FRAME = 3832;
  public static final int FEATURE_POLICY_JSAPI_FEATURES_DOCUMENT = 3837;
  public static final int FEATURE_POLICY_JSAPI_FEATURES_I_FRAME = 3836;
  public static final int FEATURE_POLICY_JSAPI_GET_ALLOWLIST_DOCUMENT = 3839;
  public static final int FEATURE_POLICY_JSAPI_GET_ALLOWLIST_I_FRAME = 3838;
  public static final int FEATURE_POLICY_REPORT = 2536;
  public static final int FEATURE_POLICY_REPORT_ONLY_HEADER = 2720;
  public static final int FEATURE_POLICY_SEMICOLON_SEPARATED_DECLARATIONS = 2923;
  public static final int FED_CM = 4166;
  public static final int FED_CM_AUTO_REAUTHN = 4459;
  public static final int FED_CM_DISCONNECT = 4224;
  public static final int FED_CM_DOMAIN_HINT = 4755;
  public static final int FED_CM_IDP_SIGNIN_STATUS_API = 4583;
  public static final int FED_CM_IDP_SIGNIN_STATUS_JS_API = 4584;
  public static final int FED_CM_IFRAME = 4396;
  public static final int FED_CM_LOGIN_HINT = 4579;
  public static final int FED_CM_RP_CONTEXT = 4580;
  public static final int FED_CM_USER_INFO = 4426;
  public static final int FENCED_FRAME_CONFIG_ATTRIBUTE = 4477;
  public static final int FETCH = 675;
  public static final int FETCH_BODY_STREAM = 676;
  public static final int FETCH_BODY_STREAM_IN_SERVICE_WORKER = 3086;
  public static final int FETCH_BODY_STREAM_OUTSIDE_SERVICE_WORKER = 3087;
  public static final int FETCH_CACHE_RELOAD = 3014;
  public static final int FETCH_EVENT_IS_RELOAD = 2032;
  public static final int FETCH_EVENT_SOURCE_LAST_EVENT_ID_CORS_UN_SAFE = 4167;
  public static final int FETCH_KEEPALIVE = 2913;
  public static final int FETCH_LATER = 4609;
  public static final int FETCH_LATER_ERROR_QUOTA_EXCEEDED = 4654;
  public static final int FETCH_LATER_ERROR_UNKNOWN_BODY_LENGTH = 4653;
  public static final int FETCH_LATER_INVOKE_STATE_ABORTED = 4651;
  public static final int FETCH_LATER_INVOKE_STATE_ACTIVATED = 4652;
  public static final int FETCH_LATER_INVOKE_STATE_DEFERRED = 4648;
  public static final int FETCH_LATER_INVOKE_STATE_SCHEDULED = 4649;
  public static final int FETCH_LATER_INVOKE_STATE_TERMINATED = 4650;
  public static final int FETCH_REDIRECT_ERROR = 3012;
  public static final int FETCH_REDIRECT_MANUAL = 3013;
  public static final int FETCH_RESPOND_WITH_NO_RESPONSE_WITH_USED_REQUEST_BODY = 3774;
  public static final int FETCH_RESPONSE_CONSTRUCTION_WITH_STREAM = 1826;
  public static final int FETCH_SET_COOKIE_IN_REQUEST_GUARDED_HEADERS = 4152;
  public static final int FETCH_UPLOAD_STREAMING = 3326;
  public static final int FIELD_EDIT_IN_NON_SECURE_CONTEXT = 1982;
  public static final int FIELD_EDIT_IN_SECURE_CONTEXT = 1981;
  public static final int FILE_ACCESSED_CACHE = 2267;
  public static final int FILE_ACCESSED_COOKIES = 2268;
  public static final int FILE_ACCESSED_DATABASE = 2269;
  public static final int FILE_ACCESSED_FILE_SYSTEM = 2270;
  public static final int FILE_ACCESSED_LOCAL_STORAGE = 2271;
  public static final int FILE_ACCESSED_LOCKS = 2272;
  public static final int FILE_ACCESSED_SERVICE_WORKER = 2273;
  public static final int FILE_ACCESSED_SESSION_STORAGE = 2274;
  public static final int FILE_ACCESSED_SHARED_WORKER = 2275;
  public static final int FILE_API_NATIVE_LINE_ENDINGS = 1320;
  public static final int FILE_GET_LAST_MODIFIED_DATE = 212;
  public static final int FILE_HANDLING_LAUNCH = 3875;
  public static final int FILE_SYSTEM_ACCESS_DRAG_AND_DROP = 3346;
  public static final int FILE_SYSTEM_ACCESS_MOVE_RENAME = 4564;
  public static final int FILE_SYSTEM_ACCESS_MOVE_REPARENT = 4565;
  public static final int FILE_SYSTEM_ACCESS_MOVE_REPARENT_AND_RENAME = 4566;
  public static final int FILE_SYSTEM_PICKER_METHOD = 3339;
  public static final int FILE_SYSTEM_URL_NAVIGATION = 4077;
  public static final int FILTER_AS_CONTAINING_BLOCK_MAY_CHANGE_OUTPUT = 2320;
  public static final int FIRST_PARTY_SHARED_WORKER_SAME_SITE_COOKIES_NONE = 4833;
  public static final int FIXED_WIDTH_TABLE_DISTRIBUTION_CHANGED = 2122;
  public static final int FLEDGE = 4188;
  public static final int FLEXBOX_ABS_POS_JUSTIFY_CONTENT = 4330;
  public static final int FLEXBOX_ALIGN_SINGLE_LINE_DIFFERENCE = 4057;
  public static final int FLEXBOX_INTRINSIC_SIZE_ALGORITHM_IS_DIFFERENT = 939;
  public static final int FLEXBOX_NEW_ABS_POS = 4237;
  public static final int FLEXBOX_PERCENTAGE_MARGIN_VERTICAL = 956;
  public static final int FLEXBOX_PERCENTAGE_PADDING_VERTICAL = 955;
  public static final int FLEXBOX_SINGLE_LINE_ALIGN_CONTENT = 2642;
  public static final int FLEX_GAP_POSITIVE = 3308;
  public static final int FLEX_GAP_SPECIFIED = 3307;
  public static final int FLEX_INTRINSIC_SIZES_CACHE_MISS = 4549;
  public static final int FLEX_ROW_GAP_PERCENT = 3290;
  public static final int FLEX_ROW_GAP_PERCENT_INDEFINITE = 3291;
  public static final int FOCUSGROUP = 4243;
  public static final int FOCUS_IN_OUT_EVENT = 433;
  public static final int FOCUS_WITHOUT_USER_ACTIVATION_NOT_SANDBOXED_AD_FRAME = 2883;
  public static final int FOCUS_WITHOUT_USER_ACTIVATION_NOT_SANDBOXED_NOT_AD_FRAME = 2882;
  public static final int FOCUS_WITHOUT_USER_ACTIVATION_SANDBOXED_AD_FRAME = 2885;
  public static final int FOCUS_WITHOUT_USER_ACTIVATION_SANDBOXED_NOT_AD_FRAME = 2884;
  public static final int FONT_BUILDER_CSS_FONT_FAMILY_WEB_KIT_PREFIX_BODY = 3989;
  public static final int FONT_FACE_ASCENT_OVERRIDE = 3923;
  public static final int FONT_FACE_CONSTRUCTOR = 989;
  public static final int FONT_FACE_DESCENT_OVERRIDE = 3924;
  public static final int FONT_FACE_LINE_GAP_OVERRIDE = 3925;
  public static final int FONT_FACE_SIZE_ADJUST = 3926;
  public static final int FONT_SELECTOR_CSS_FONT_FAMILY_WEB_KIT_PREFIX_BODY = 3988;
  public static final int FONT_SHAPING_NOT_DEF_GLYPH_OBSERVED = 1973;
  public static final int FONT_SIZE_WEBKIT_XXX_LARGE = 2958;
  public static final int FORCED_COLORS_MEDIA_FEATURE = 3870;
  public static final int FORCED_DARK_MODE = 3579;
  public static final int FORCE_LOAD_AT_TOP = 3203;
  public static final int FORMS_SUBMITTED = 442;
  public static final int FORM_ASSOCIATED_CUSTOM_ELEMENT = 3370;
  public static final int FORM_ASSOCIATION_BY_PARSER = 248;
  public static final int FORM_ATTRIBUTE = 24;
  public static final int FORM_DATA_APPEND_NULL = 843;
  public static final int FORM_DISABLED_ATTRIBUTE_PRESENT = 2557;
  public static final int FORM_DISABLED_ATTRIBUTE_PRESENT_AND_SUBMIT = 2558;
  public static final int FORM_ELEMENT = 84;
  public static final int FORM_NAME_ACCESS_FOR_IMAGE_ELEMENT = 246;
  public static final int FORM_NAME_ACCESS_FOR_NON_DESCENDANT_IMAGE_ELEMENT = 1093;
  public static final int FORM_NAME_ACCESS_FOR_PAST_NAMES_MAP = 247;
  public static final int FORM_SUBMISSION_STARTED = 1291;
  public static final int FORM_SUBMITTED_WITH_UNCLOSED_FORM_CONTROL = 1767;
  public static final int FORM_VALIDATION_ABORTED_SUBMISSION = 1293;
  public static final int FORM_VALIDATION_SHOWED_MESSAGE = 1294;
  public static final int FORM_VALIDATION_STARTED = 1292;
  public static final int FRAGMENT_DOUBLE_HASH = 2979;
  public static final int FRAME_NAME_CONTAINS_BRACE = 4146;
  public static final int FRAME_NAME_CONTAINS_NEWLINE = 4147;
  public static final int FULLSCREEN_ALLOWED_BY_CONTENT_SETTING = 4835;
  public static final int FULLSCREEN_ALLOWED_BY_ORIENTATION_CHANGE = 1696;
  public static final int FULLSCREEN_ALLOWED_BY_SCREENS_CHANGE = 3701;
  public static final int FULLSCREEN_ALLOWED_BY_WINDOW_OPEN = 4526;
  public static final int FULLSCREEN_CROSS_SCREEN = 3394;
  public static final int FULLSCREEN_INSECURE_ORIGIN = 766;
  public static final int FULLSCREEN_REQUEST_WITH_PENDING_ELEMENT = 1804;
  public static final int FULLSCREEN_SECURE_ORIGIN = 765;
  public static final int GAMEPAD_AXES = 1964;
  public static final int GAMEPAD_BUTTONS = 1965;
  public static final int GAMEPAD_BUTTON_TOUCHED = 1628;
  public static final int GAMEPAD_DISPLAY_ID = 1627;
  public static final int GAMEPAD_HAND = 1626;
  public static final int GAMEPAD_ID = 3434;
  public static final int GAMEPAD_POSE = 1625;
  public static final int GAMEPAD_POSE_ANGULAR_ACCELERATION = 1636;
  public static final int GAMEPAD_POSE_ANGULAR_VELOCITY = 1635;
  public static final int GAMEPAD_POSE_HAS_ORIENTATION = 1629;
  public static final int GAMEPAD_POSE_HAS_POSITION = 1630;
  public static final int GAMEPAD_POSE_LINEAR_ACCELERATION = 1633;
  public static final int GAMEPAD_POSE_LINEAR_VELOCITY = 1632;
  public static final int GAMEPAD_POSE_ORIENTATION = 1634;
  public static final int GAMEPAD_POSE_POSITION = 1631;
  public static final int GAMEPAD_TOUCH_EVENTS = 4536;
  public static final int GAMEPAD_TOUCH_POSITION = 4539;
  public static final int GAMEPAD_TOUCH_SURFACE_DIMENSION = 4540;
  public static final int GAMEPAD_TOUCH_SURFACE_ID = 4538;
  public static final int GAMEPAD_TOUCH_TOUCH_ID = 4537;
  public static final int GAMEPAD_VIBRATION_ACTUATOR = 2207;
  public static final int GATT_SERVER_DISCONNECTED_EVENT = 1970;
  public static final int GENERIC_SENSOR_ACTIVATED = 1905;
  public static final int GENERIC_SENSOR_ON_ACTIVATE = 1902;
  public static final int GENERIC_SENSOR_ON_CHANGE = 1903;
  public static final int GENERIC_SENSOR_ON_ERROR = 1904;
  public static final int GENERIC_SENSOR_START = 1680;
  public static final int GENERIC_SENSOR_STOP = 1681;
  public static final int GEOLOCATION_DISABLED_BY_FEATURE_POLICY = 2196;
  public static final int GEOLOCATION_GET_CURRENT_POSITION = 2214;
  public static final int GEOLOCATION_INSECURE_ORIGIN = 562;
  public static final int GEOLOCATION_INSECURE_ORIGIN_DEPRECATED_NOT_REMOVED = 1343;
  public static final int GEOLOCATION_INSECURE_ORIGIN_IFRAME = 1141;
  public static final int GEOLOCATION_INSECURE_ORIGIN_IFRAME_DEPRECATED_NOT_REMOVED = 1344;
  public static final int GEOLOCATION_SECURE_ORIGIN = 561;
  public static final int GEOLOCATION_SECURE_ORIGIN_IFRAME = 1142;
  public static final int GEOLOCATION_WATCH_POSITION = 2215;
  public static final int GET_ALL_SCREENS_MEDIA = 4630;
  public static final int GET_B_BOX_FOR_TEXT = 3913;
  public static final int GET_CANVAS2_D_CONTEXT_ATTRIBUTES = 1850;
  public static final int GET_COALESCED_EVENTS_IN_INSECURE_CONTEXT = 4598;
  public static final int GET_COMPUTED_STYLE_OUTSIDE_FLAT_TREE = 3088;
  public static final int GET_DISPLAY_MEDIA = 2619;
  public static final int GET_DISPLAY_MEDIA_WITH_PREFER_CURRENT_TAB_TRUE = 4476;
  public static final int GET_EFFECT_TIMING_DELAY_ZERO = 4418;
  public static final int GET_GAMEPADS = 1916;
  public static final int GET_GAMEPADS_FROM_CROSS_ORIGIN_SUBFRAME = 3054;
  public static final int GET_GAMEPADS_FROM_INSECURE_CONTEXT = 3055;
  public static final int GET_USER_MEDIA_INSECURE_ORIGIN = 666;
  public static final int GET_USER_MEDIA_INSECURE_ORIGIN_IFRAME = 1144;
  public static final int GET_USER_MEDIA_LEGACY = 1401;
  public static final int GET_USER_MEDIA_PREFIXED = 1400;
  public static final int GET_USER_MEDIA_PROMISE = 1402;
  public static final int GET_USER_MEDIA_SECURE_ORIGIN = 667;
  public static final int GET_USER_MEDIA_SECURE_ORIGIN_IFRAME = 1145;
  public static final int GLOBAL_CACHE_STORAGE = 743;
  public static final int GPU_ADAPTER_NAME = 3405;
  public static final int GRAVITY_SENSOR_CONSTRUCTOR = 3795;
  public static final int GRID_ROW_GAP_PERCENT = 3288;
  public static final int GRID_ROW_GAP_PERCENT_INDEFINITE = 3289;
  public static final int GRID_ROW_TRACK_PERCENT_INDEFINITE_HEIGHT = 2248;
  public static final int GYROSCOPE_CONSTRUCTOR = 1906;
  public static final int H1_USER_AGENT_FONT_SIZE_IN_SECTION_APPLIED = 4272;
  public static final int HANDWRITING_RECOGNITION_CREATE_RECOGNIZER = 3892;
  public static final int HANDWRITING_RECOGNITION_GET_PREDICTION = 3895;
  public static final int HANDWRITING_RECOGNITION_QUERY_RECOGNIZER = 4012;
  public static final int HANDWRITING_RECOGNITION_START_DRAWING = 3894;
  public static final int HAS_BEFORE_OR_AFTER_PSEUDO_ELEMENT = 2204;
  public static final int HAS_GLYPH_RELATIVE_UNITS = 3081;
  public static final int HAS_ID_CLASS_TAG_ATTRIBUTE = 2203;
  public static final int HAS_MARKER_PSEUDO_ELEMENT = 3066;
  public static final int HEAVY_AD_INTERVENTION = 3052;
  public static final int HIDDEN_ATTRIBUTE = 4113;
  public static final int HIDDEN_AUTOPLAYED_VIDEO_IN_CANVAS = 1623;
  public static final int HIDDEN_BACKFACE_WITH3_D = 3927;
  public static final int HIDDEN_BACKFACE_WITH_POSSIBLE3_D = 3323;
  public static final int HIDDEN_BACKFACE_WITH_PRESERVE3_D = 3324;
  public static final int HIDDEN_UNTIL_FOUND_ATTRIBUTE = 4114;
  public static final int HID_DEVICE_CLOSE = 2860;
  public static final int HID_DEVICE_OPEN = 2861;
  public static final int HID_DEVICE_RECEIVE_FEATURE_REPORT = 2862;
  public static final int HID_DEVICE_SEND_FEATURE_REPORT = 2863;
  public static final int HID_DEVICE_SEND_REPORT = 2864;
  public static final int HID_GET_DEVICES = 2865;
  public static final int HID_REQUEST_DEVICE = 2866;
  public static final int HIGHLIGHT_API_REGISTER_HIGHLIGHT = 3984;
  public static final int HISTORY_LENGTH = 2719;
  public static final int HISTORY_PUSH_STATE = 2617;
  public static final int HISTORY_REPLACE_STATE = 2618;
  public static final int HORIZONTAL_SCROLLBAR_THUMB_SCROLLING_WITH_MOUSE = 2878;
  public static final int HORIZONTAL_SCROLLBAR_THUMB_SCROLLING_WITH_TOUCH = 2879;
  public static final int HOST_CANDIDATE_ATTRIBUTE_GETTER = 3128;
  public static final int HTMLI_FRAME_ELEMENT_ALLOWFULLSCREEN_ATTRIBUTE_SET_AFTER_CONTENT_LOAD =
      1805;
  public static final int HTMLI_FRAME_ELEMENT_GESTURE_MEDIA = 2363;
  public static final int HTMLI_FRAME_ELEMENT_REFERRER_POLICY_ATTRIBUTE = 1755;
  public static final int HTML_ANCHOR_ELEMENT_HREF_TRANSLATE_ATTRIBUTE = 2629;
  public static final int HTML_ANCHOR_ELEMENT_PING_ATTRIBUTE = 276;
  public static final int HTML_ANCHOR_ELEMENT_REFERRER_POLICY_ATTRIBUTE = 1754;
  public static final int HTML_BODY_CONTAINED = 3937;
  public static final int HTML_BODY_ELEMENT_ON_SELECTION_CHANGE_ATTRIBUTE = 1508;
  public static final int HTML_BUTTON_IN_SELECT = 4771;
  public static final int HTML_CANVAS_ELEMENT = 1503;
  public static final int HTML_CANVAS_ELEMENT_2D = 4025;
  public static final int HTML_CANVAS_ELEMENT_BITMAP_RENDERER = 4028;
  public static final int HTML_CANVAS_ELEMENT_LOW_LATENCY = 2611;
  public static final int HTML_CANVAS_ELEMENT_WEB_GL = 4026;
  public static final int HTML_CANVAS_ELEMENT_WEB_GL2 = 4027;
  public static final int HTML_CANVAS_ELEMENT_WEB_GPU = 4029;
  public static final int HTML_CANVAS_GET_CONTEXT = 3545;
  public static final int HTML_CLIPBOARD_API_READ = 3362;
  public static final int HTML_CLIPBOARD_API_UNSANITIZED_READ = 4522;
  public static final int HTML_CLIPBOARD_API_UNSANITIZED_WRITE = 4523;
  public static final int HTML_CLIPBOARD_API_WRITE = 3363;
  public static final int HTML_DATALIST_IN_SELECT = 4772;
  public static final int HTML_DETAILS_ELEMENT_NAME_ATTRIBUTE = 4677;
  public static final int HTML_DETAILS_ELEMENT_NAME_ATTRIBUTE_CLOSES_OTHER = 4679;
  public static final int HTML_DETAILS_ELEMENT_NAME_ATTRIBUTE_CLOSES_SELF = 4678;
  public static final int HTML_DOCUMENT_CREATE_PROCESSING_INSTRUCTION = 1825;
  public static final int HTML_ELEMENT_DEPRECATED_WIDTH = 905;
  public static final int HTML_ELEMENT_INNER_TEXT = 213;
  public static final int HTML_ELEMENT_OUTER_TEXT = 214;
  public static final int HTML_EMBED_ELEMENT_GETTER = 1840;
  public static final int HTML_EMBED_ELEMENT_SETTER = 1841;
  public static final int HTML_FENCED_FRAME_ELEMENT = 3890;
  public static final int HTML_FRAME_SET_ELEMENT = 3009;
  public static final int HTML_IMAGE_ELEMENT_REFERRER_POLICY_ATTRIBUTE = 1756;
  public static final int HTML_IMAGE_ELEMENT_X = 396;
  public static final int HTML_IMAGE_ELEMENT_Y = 397;
  public static final int HTML_INPUT_ELEMENT_SIMULATED_CLICK = 4105;
  public static final int HTML_LABEL_ELEMENT_CONTROL_FOR_NON_FORM_ASSOCIATED_ELEMENT = 1263;
  public static final int HTML_LINK_ELEMENT_DISABLED = 809;
  public static final int HTML_LINK_ELEMENT_DISABLED_BY_PARSER = 2516;
  public static final int HTML_LINK_ELEMENT_MONETIZATION = 3120;
  public static final int HTML_LINK_ELEMENT_REFERRER_POLICY_ATTRIBUTE = 1757;
  public static final int HTML_MARQUEE_ELEMENT = 53;
  public static final int HTML_MEDIA_ELEMENT = 1229;
  public static final int HTML_MEDIA_ELEMENT_CONTROLS_ATTRIBUTE = 1231;
  public static final int HTML_MEDIA_ELEMENT_CONTROLS_LIST_ATTRIBUTE = 1853;
  public static final int HTML_MEDIA_ELEMENT_CONTROLS_LIST_NO_DOWNLOAD = 1854;
  public static final int HTML_MEDIA_ELEMENT_CONTROLS_LIST_NO_FULLSCREEN = 1855;
  public static final int HTML_MEDIA_ELEMENT_CONTROLS_LIST_NO_PLAYBACK_RATE = 3930;
  public static final int HTML_MEDIA_ELEMENT_CONTROLS_LIST_NO_REMOTE_PLAYBACK = 1856;
  public static final int HTML_MEDIA_ELEMENT_EMPTY_LOAD_WITH_FUTURE_DATA = 2264;
  public static final int HTML_MEDIA_ELEMENT_IN_DOCUMENT = 1230;
  public static final int HTML_MEDIA_ELEMENT_LOAD_NETWORK_EMPTY_NOT_PAUSED = 1265;
  public static final int HTML_MEDIA_ELEMENT_MEDIA_PLAYBACK_RATE_OUT_OF_RANGE = 2192;
  public static final int HTML_MEDIA_ELEMENT_PAUSE_AT_FRAGMENT_END = 282;
  public static final int HTML_MEDIA_ELEMENT_PRELOAD_AUTO = 894;
  public static final int HTML_MEDIA_ELEMENT_PRELOAD_DEFAULT = 895;
  public static final int HTML_MEDIA_ELEMENT_PRELOAD_FORCED_METADATA = 1679;
  public static final int HTML_MEDIA_ELEMENT_PRELOAD_METADATA = 893;
  public static final int HTML_MEDIA_ELEMENT_PRELOAD_NONE = 892;
  public static final int HTML_MEDIA_ELEMENT_SEEK_TO_FRAGMENT_START = 281;
  public static final int HTML_MEDIA_ELEMENT_SET_SINK_ID = 3877;
  public static final int HTML_META_ELEMENT_MONETIZATION = 3119;
  public static final int HTML_META_ELEMENT_REFERRER_POLICY = 3112;
  public static final int HTML_META_ELEMENT_REFERRER_POLICY_MULTIPLE_TOKENS = 3315;
  public static final int HTML_META_ELEMENT_REFERRER_POLICY_MULTIPLE_TOKENS_AFFECTING_REQUEST =
      3348;
  public static final int HTML_META_ELEMENT_REFERRER_POLICY_OUTSIDE_HEAD = 3314;
  public static final int HTML_OBJECT_ELEMENT_FALLBACK = 4102;
  public static final int HTML_OBJECT_ELEMENT_GETTER = 1838;
  public static final int HTML_OBJECT_ELEMENT_SETTER = 1839;
  public static final int HTML_PARSE_ERROR_NESTED_FORM = 1972;
  public static final int HTML_PORTAL_ELEMENT = 3096;
  public static final int HTML_ROOT_CONTAINED = 3936;
  public static final int HTML_SLOT_ELEMENT = 1898;
  public static final int HTML_TABLE_CELL_ELEMENT_COLSPAN = 1783;
  public static final int HTML_TEMPLATE_ELEMENT = 2769;
  public static final int HTTP_REFRESH_WHEN_SCRIPTING_DISABLED = 4063;
  public static final int IDENTIFIABILITY_MEDIA_DEVICES_ENUMERATE_DEVICES = 3582;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3478 = 3478;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3480 = 3480;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3482 = 3482;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3483 = 3483;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3484 = 3484;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3485 = 3485;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3486 = 3486;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3487 = 3487;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3488 = 3488;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3489 = 3489;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3490 = 3490;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3491 = 3491;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3492 = 3492;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3493 = 3493;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3494 = 3494;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3495 = 3495;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3496 = 3496;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3497 = 3497;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3498 = 3498;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3505 = 3505;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3506 = 3506;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3508 = 3508;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3511 = 3511;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3512 = 3512;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3513 = 3513;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3514 = 3514;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3515 = 3515;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3516 = 3516;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3517 = 3517;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3518 = 3518;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3519 = 3519;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3520 = 3520;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3521 = 3521;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3522 = 3522;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3523 = 3523;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3524 = 3524;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3525 = 3525;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3526 = 3526;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3527 = 3527;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3528 = 3528;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3529 = 3529;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3530 = 3530;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3531 = 3531;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3532 = 3532;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3533 = 3533;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3534 = 3534;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3535 = 3535;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3536 = 3536;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3537 = 3537;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3538 = 3538;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3539 = 3539;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3540 = 3540;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3547 = 3547;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3548 = 3548;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3549 = 3549;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3550 = 3550;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3551 = 3551;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3552 = 3552;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3553 = 3553;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3554 = 3554;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3555 = 3555;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3556 = 3556;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3557 = 3557;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3558 = 3558;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3559 = 3559;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3560 = 3560;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3561 = 3561;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3562 = 3562;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3563 = 3563;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3564 = 3564;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3565 = 3565;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3572 = 3572;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3573 = 3573;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3574 = 3574;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3575 = 3575;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3576 = 3576;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3577 = 3577;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3583 = 3583;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3584 = 3584;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3585 = 3585;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3586 = 3586;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3587 = 3587;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3588 = 3588;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3589 = 3589;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3590 = 3590;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3591 = 3591;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3592 = 3592;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3593 = 3593;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3594 = 3594;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3595 = 3595;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3596 = 3596;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3597 = 3597;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3598 = 3598;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3599 = 3599;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3600 = 3600;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3601 = 3601;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3602 = 3602;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3603 = 3603;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3604 = 3604;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3605 = 3605;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3606 = 3606;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3607 = 3607;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3608 = 3608;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3609 = 3609;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3611 = 3611;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3612 = 3612;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3613 = 3613;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3614 = 3614;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3615 = 3615;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3616 = 3616;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3617 = 3617;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3618 = 3618;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3619 = 3619;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3620 = 3620;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3621 = 3621;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3622 = 3622;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3623 = 3623;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3624 = 3624;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3625 = 3625;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3626 = 3626;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3627 = 3627;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3628 = 3628;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3629 = 3629;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3630 = 3630;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3631 = 3631;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3632 = 3632;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3633 = 3633;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3634 = 3634;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3635 = 3635;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3636 = 3636;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3637 = 3637;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3638 = 3638;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3639 = 3639;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3640 = 3640;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3641 = 3641;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3642 = 3642;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3643 = 3643;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3644 = 3644;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3645 = 3645;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3646 = 3646;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3647 = 3647;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3648 = 3648;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3649 = 3649;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3650 = 3650;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3651 = 3651;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3652 = 3652;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3653 = 3653;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3654 = 3654;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3655 = 3655;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3656 = 3656;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3657 = 3657;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3658 = 3658;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3659 = 3659;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3660 = 3660;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3661 = 3661;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3662 = 3662;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3663 = 3663;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3664 = 3664;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3665 = 3665;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3666 = 3666;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3667 = 3667;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3668 = 3668;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3669 = 3669;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3670 = 3670;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3671 = 3671;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3672 = 3672;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3673 = 3673;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3674 = 3674;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3675 = 3675;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3676 = 3676;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3677 = 3677;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3678 = 3678;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3679 = 3679;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3680 = 3680;
  public static final int IDENTIFIABILITY_STUDY_RESERVED3681 = 3681;
  public static final int IDENTITY_DIGITAL_CREDENTIALS = 4826;
  public static final int IDENTITY_IN_CAN_MAKE_PAYMENT_EVENT = 4262;
  public static final int IDLE_DETECTION_PERMISSION_REQUESTED = 3477;
  public static final int IDLE_DETECTION_START = 2834;
  public static final int IDNA2008_DEVIATION_CHARACTER_IN_HOSTNAME_OF_I_FRAME = 4428;
  public static final int IDNA2008_DEVIATION_CHARACTER_IN_HOSTNAME_OF_SUBRESOURCE = 4427;
  public static final int IFRAME_AD_AUCTION_HEADERS_ATTRIBUTE = 4738;
  public static final int IFRAME_BROWSING_TOPICS_ATTRIBUTE = 4497;
  public static final int IMAGE_AD = 4312;
  public static final int IMAGE_CAPTURE_BACKGROUND_BLUR = 4529;
  public static final int IMAGE_CAPTURE_BRIGHTNESS = 3241;
  public static final int IMAGE_CAPTURE_COLOR_TEMPERATURE = 3239;
  public static final int IMAGE_CAPTURE_CONSTRUCTOR = 1686;
  public static final int IMAGE_CAPTURE_CONTRAST = 3242;
  public static final int IMAGE_CAPTURE_EXPOSURE_COMPENSATION = 3237;
  public static final int IMAGE_CAPTURE_EXPOSURE_MODE = 3234;
  public static final int IMAGE_CAPTURE_EXPOSURE_TIME = 3238;
  public static final int IMAGE_CAPTURE_FOCUS_DISTANCE = 3245;
  public static final int IMAGE_CAPTURE_FOCUS_MODE = 3235;
  public static final int IMAGE_CAPTURE_ISO = 3240;
  public static final int IMAGE_CAPTURE_PAN = 3246;
  public static final int IMAGE_CAPTURE_POINTS_OF_INTEREST = 3236;
  public static final int IMAGE_CAPTURE_SATURATION = 3243;
  public static final int IMAGE_CAPTURE_SHARPNESS = 3244;
  public static final int IMAGE_CAPTURE_TILT = 3247;
  public static final int IMAGE_CAPTURE_TORCH = 3249;
  public static final int IMAGE_CAPTURE_WHITE_BALANCE_MODE = 3233;
  public static final int IMAGE_CAPTURE_ZOOM = 3248;
  public static final int IMAGE_DECODE_API = 2348;
  public static final int IMAGE_DECODING_ATTRIBUTE = 2347;
  public static final int IMAGE_LOAD_AT_DISMISSAL_EVENT = 4091;
  public static final int IMAGE_SET = 4413;
  public static final int IMPORT_MAP = 2831;
  public static final int INCREMENTAL_ATTRIBUTE = 25;
  public static final int INDEXED_DB_READ = 3023;
  public static final int INDEXED_DB_WRITE = 3024;
  public static final int INIT_MESSAGE_EVENT = 222;
  public static final int INLINE_BOX_IGNORING_CONTINUATION = 4050;
  public static final int INLINE_OVERFLOW_AUTO_WITH_INLINE_END_PADDING = 3335;
  public static final int INLINE_OVERFLOW_SCROLL_WITH_INLINE_END_PADDING = 3336;
  public static final int INNER_SCHEME_BYPASSES_CSP = 2166;
  public static final int INNER_TEXT_WITH_SHADOW_TREE = 860;
  public static final int INPUT_ELEMENT_VALUE_AS_DATE_GETTER = 3110;
  public static final int INPUT_ELEMENT_VALUE_AS_DATE_SETTER = 3111;
  public static final int INPUT_EVENT_TO_RECENTLY_MOVED_IFRAME_MISTAKENLY_DISCARDED = 4631;
  public static final int INPUT_TYPE_BUTTON = 2853;
  public static final int INPUT_TYPE_CHECKBOX = 2851;
  public static final int INPUT_TYPE_COLOR = 26;
  public static final int INPUT_TYPE_DATE = 27;
  public static final int INPUT_TYPE_DATE_TIME_FALLBACK = 29;
  public static final int INPUT_TYPE_DATE_TIME_LOCAL = 30;
  public static final int INPUT_TYPE_EMAIL = 31;
  public static final int INPUT_TYPE_EMAIL_MAX_LENGTH = 185;
  public static final int INPUT_TYPE_EMAIL_MULTIPLE = 184;
  public static final int INPUT_TYPE_EMAIL_MULTIPLE_MAX_LENGTH = 186;
  public static final int INPUT_TYPE_FILE_INSECURE_ORIGIN = 802;
  public static final int INPUT_TYPE_FILE_INSECURE_ORIGIN_OPEN_CHOOSER = 2325;
  public static final int INPUT_TYPE_FILE_SECURE_ORIGIN = 801;
  public static final int INPUT_TYPE_FILE_SECURE_ORIGIN_OPEN_CHOOSER = 2324;
  public static final int INPUT_TYPE_HIDDEN = 2854;
  public static final int INPUT_TYPE_IMAGE = 2852;
  public static final int INPUT_TYPE_MONTH = 32;
  public static final int INPUT_TYPE_NUMBER = 33;
  public static final int INPUT_TYPE_PASSWORD = 192;
  public static final int INPUT_TYPE_PASSWORD_MAX_LENGTH = 193;
  public static final int INPUT_TYPE_RADIO = 2850;
  public static final int INPUT_TYPE_RANGE = 34;
  public static final int INPUT_TYPE_RANGE_HORIZONTAL_LTR = 4845;
  public static final int INPUT_TYPE_RANGE_HORIZONTAL_RTL = 4846;
  public static final int INPUT_TYPE_RANGE_VERTICAL_APPEARANCE = 1013;
  public static final int INPUT_TYPE_RANGE_VERTICAL_LTR = 4847;
  public static final int INPUT_TYPE_RANGE_VERTICAL_RTL = 4848;
  public static final int INPUT_TYPE_RESET = 2855;
  public static final int INPUT_TYPE_SEARCH = 35;
  public static final int INPUT_TYPE_SUBMIT = 591;
  public static final int INPUT_TYPE_SUBMIT_WITH_VALUE = 592;
  public static final int INPUT_TYPE_TEL = 36;
  public static final int INPUT_TYPE_TEXT = 190;
  public static final int INPUT_TYPE_TEXT_MAX_LENGTH = 191;
  public static final int INPUT_TYPE_TIME = 37;
  public static final int INPUT_TYPE_URL = 38;
  public static final int INPUT_TYPE_WEEK = 39;
  public static final int INPUT_TYPE_WEEK_FALLBACK = 40;
  public static final int INSERT_HTML_COMMAND_ON_INPUT = 3806;
  public static final int INSERT_HTML_COMMAND_ON_READ_WRITE_PLAIN_TEXT = 3808;
  public static final int INSERT_HTML_COMMAND_ON_TEXTAREA = 3807;
  public static final int INSTANTIATE_MODULE_SCRIPT = 2615;
  public static final int INTERACTIVE_WIDGET_OVERLAYS_CONTENT = 4366;
  public static final int INTERACTIVE_WIDGET_RESIZES_CONTENT = 4367;
  public static final int INTERACTIVE_WIDGET_RESIZES_VISUAL = 4368;
  public static final int INTERSECTION_OBSERVER_CONSTRUCTOR = 1368;
  public static final int INTERSECTION_OBSERVER_V2 = 3051;
  public static final int INTERVENTION_REPORT = 2531;
  public static final int INVALID_FRAGMENT_DIRECTIVE = 3043;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int I_FRAME_CSP_ATTRIBUTE = 3274;
  public static final int JOIN_AD_INTEREST_GROUP = 4076;
  public static final int JS_SELF_PROFILING = 3008;
  public static final int KEYBOARD_API_GET_LAYOUT_MAP = 2432;
  public static final int KEYBOARD_API_LOCK = 2394;
  public static final int KEYBOARD_API_UNLOCK = 2395;
  public static final int LANG_ATTRIBUTE = 587;
  public static final int LANG_ATTRIBUTE_DOES_NOT_MATCH_TO_UI_LOCALE = 590;
  public static final int LANG_ATTRIBUTE_ON_BODY = 589;
  public static final int LANG_ATTRIBUTE_ON_HTML = 588;
  public static final int LARGEST_CONTENTFUL_PAINT_EXPLICITLY_REQUESTED = 2927;
  public static final int LARGE_STICKY_AD = 3155;
  public static final int LAX_ALLOWING_UNSAFE_COOKIES = 3852;
  public static final int LAYER_XY_WITH_CANVAS_TARGET = 4099;
  public static final int LAYER_XY_WITH_FRAME_TARGET = 4100;
  public static final int LAYER_XY_WITH_MEDIA_TARGET = 4098;
  public static final int LAYER_XY_WITH_SVG_TARGET = 4101;
  public static final int LAYOUT_SHIFT_EXPLICITLY_REQUESTED = 2782;
  public static final int LAZY_LOAD_FRAME_LOADING_ATTRIBUTE_EAGER = 2932;
  public static final int LAZY_LOAD_FRAME_LOADING_ATTRIBUTE_LAZY = 2933;
  public static final int LAZY_LOAD_IMAGE_LOADING_ATTRIBUTE_EAGER = 2934;
  public static final int LAZY_LOAD_IMAGE_LOADING_ATTRIBUTE_LAZY = 2935;
  public static final int LCP_CANDIDATE_IMAGE_FROM_ORIGIN_DIRTY_STYLE = 4345;
  public static final int LCP_IMAGE_WAS_LAZY = 4756;
  public static final int LEAVE_PICTURE_IN_PICTURE_EVENT_LISTENER = 2446;
  public static final int LEGACY_SYMANTEC_CERT_IN_SUBFRAME_MAIN_RESOURCE = 2486;
  public static final int LEGACY_SYMANTEC_CERT_IN_SUBRESOURCE = 2485;
  public static final int LEGACY_SYMANTEC_CERT_MAIN_FRAME_RESOURCE = 2484;
  public static final int LIMITED_QUIRKS_MODE_DOCUMENT = 2035;
  public static final int LINEAR_ACCELERATION_SENSOR_CONSTRUCTOR = 2051;
  public static final int LINE_BREAK_PHRASE = 4657;
  public static final int LINE_CLAMP = 96;
  public static final int LINK_HEADER_DNS_PREFETCH = 902;
  public static final int LINK_HEADER_PRECONNECT = 903;
  public static final int LINK_HEADER_PRELOAD = 1124;
  public static final int LINK_HEADER_SERVICE_WORKER = 1690;
  public static final int LINK_PREFETCH_ERROR_EVENT = 2957;
  public static final int LINK_PREFETCH_LOAD_EVENT = 2956;
  public static final int LINK_REL_CANONICAL = 4317;
  public static final int LINK_REL_DNS_PREFETCH = 899;
  public static final int LINK_REL_MODULE_PRELOAD = 2232;
  public static final int LINK_REL_NEXT = 919;
  public static final int LINK_REL_OPENER = 4741;
  public static final int LINK_REL_OPENER_TARGETING_SAME_FRAME = 4742;
  public static final int LINK_REL_PRECONNECT = 900;
  public static final int LINK_REL_PREFETCH = 917;
  public static final int LINK_REL_PREFETCH_AS_DOCUMENT_CROSS_ORIGIN = 4314;
  public static final int LINK_REL_PREFETCH_AS_DOCUMENT_SAME_ORIGIN = 4313;
  public static final int LINK_REL_PREFETCH_FOR_SIGNED_EXCHANGES = 3103;
  public static final int LINK_REL_PRELOAD = 901;
  public static final int LINK_REL_PRELOAD_AS_FONT = 4561;
  public static final int LINK_REL_PRELOAD_IMAGE_SRCSET = 2778;
  public static final int LINK_REL_PRERENDER = 918;
  public static final int LINK_REL_PRERENDER_CROSS_SITE = 4435;
  public static final int LINK_REL_PRERENDER_SAME_ORIGIN = 4433;
  public static final int LINK_REL_PRERENDER_SAME_SITE_CROSS_ORIGIN = 4434;
  public static final int LINK_REL_PRIVACY_POLICY = 4720;
  public static final int LINK_REL_TERMS_OF_SERVICE = 4721;
  public static final int LIST_ATTRIBUTE = 41;
  public static final int LIST_FORMAT = 2599;
  public static final int LOCALE = 2598;
  public static final int LOCAL_CSS_FILE = 2256;
  public static final int LOCAL_CSS_FILE_EXTENSION_REJECTED = 2257;
  public static final int LOCATION_ORIGIN = 1827;
  public static final int LONG_ANIMATION_FRAME_OBSERVER = 4577;
  public static final int LONG_ANIMATION_FRAME_REQUESTED = 4578;
  public static final int LONG_TASK_BUFFER_FULL = 3118;
  public static final int LONG_TASK_OBSERVER = 1615;
  public static final int MAGNETOMETER_CONSTRUCTOR = 1907;
  public static final int MAIN_FRAME_CSP_VIA_HTTP = 3359;
  public static final int MAIN_FRAME_CSP_VIA_META = 3360;
  public static final int MAIN_FRAME_NON_SECURE_PRIVATE_ADDRESS_SPACE = 3928;
  public static final int MALFORMED_CSP = 2608;
  public static final int MAP_ELEMENT = 482;
  public static final int MATH_ML_MATH_ELEMENT = 4402;
  public static final int MATH_ML_MATH_ELEMENT_IN_DOCUMENT = 4403;
  public static final int MAX_ATTRIBUTE = 42;
  public static final int MAX_VALUE = 4863;
  public static final int MEASURE_MEMORY = 3139;
  public static final int MEDIA_CAPABILITIES_DECODING_INFO_WEBRTC = 4174;
  public static final int MEDIA_CAPABILITIES_DECODING_INFO_WITH_KEY_SYSTEM_CONFIG = 2888;
  public static final int MEDIA_CAPABILITIES_ENCODING_INFO_WEBRTC = 4175;
  public static final int MEDIA_CONTROLS_DISPLAY_CUTOUT_GESTURE = 2493;
  public static final int MEDIA_DEVICES_ENUMERATE_DEVICES = 1119;
  public static final int MEDIA_ELEMENT_SOURCE_ON_OFFLINE_CONTEXT = 2475;
  public static final int MEDIA_ELEMENT_TEXT_TRACK_CONTAINER = 2892;
  public static final int MEDIA_ELEMENT_TEXT_TRACK_LIST = 2893;
  public static final int MEDIA_META_THEME_COLOR = 3944;
  public static final int MEDIA_RECORDER_AUDIO_BITS_PER_SECOND = 3401;
  public static final int MEDIA_RECORDER_MIME_TYPE = 3399;
  public static final int MEDIA_RECORDER_VIDEO_BITS_PER_SECOND = 3400;
  public static final int MEDIA_SESSION_SKIP_AD = 2783;
  public static final int MEDIA_SOURCE_ABORT_REMOVE = 1428;
  public static final int MEDIA_SOURCE_DURATION_TRUNCATING_BUFFERED = 1429;
  public static final int MEDIA_SOURCE_EXTENSIONS_FOR_WEB_CODECS = 4021;
  public static final int MEDIA_SOURCE_GET_HANDLE = 4261;
  public static final int MEDIA_SOURCE_GROUP_END_TIMESTAMP_DECREASE_WITHIN_MEDIA_SEGMENT = 3034;
  public static final int MEDIA_SOURCE_KEYFRAME_TIME_GREATER_THAN_DEPENDANT = 2060;
  public static final int MEDIA_SOURCE_MUXED_SEQUENCE_MODE = 2061;
  public static final int MEDIA_STREAM_CONSTRAINTS_ASPECT_RATIO = 1924;
  public static final int MEDIA_STREAM_CONSTRAINTS_AUDIO = 1918;
  public static final int MEDIA_STREAM_CONSTRAINTS_AUDIO_UNCONSTRAINED = 1919;
  public static final int MEDIA_STREAM_CONSTRAINTS_CHANNEL_COUNT = 1932;
  public static final int MEDIA_STREAM_CONSTRAINTS_CONFORMANT = 1152;
  public static final int MEDIA_STREAM_CONSTRAINTS_DEVICE_ID_AUDIO = 1933;
  public static final int MEDIA_STREAM_CONSTRAINTS_DEVICE_ID_VIDEO = 1934;
  public static final int MEDIA_STREAM_CONSTRAINTS_DISABLE_LOCAL_ECHO = 1935;
  public static final int MEDIA_STREAM_CONSTRAINTS_ECHO_CANCELLATION = 1930;
  public static final int MEDIA_STREAM_CONSTRAINTS_FACING_MODE = 1926;
  public static final int MEDIA_STREAM_CONSTRAINTS_FRAME_RATE = 1925;
  public static final int MEDIA_STREAM_CONSTRAINTS_GOOG_ARRAY_GEOMETRY = 1956;
  public static final int MEDIA_STREAM_CONSTRAINTS_GOOG_AUDIO_MIRRORING = 1957;
  public static final int MEDIA_STREAM_CONSTRAINTS_GOOG_AUTO_GAIN_CONTROL = 1949;
  public static final int MEDIA_STREAM_CONSTRAINTS_GOOG_BEAMFORMING = 1955;
  public static final int MEDIA_STREAM_CONSTRAINTS_GOOG_DA_ECHO_CANCELLATION = 1958;
  public static final int MEDIA_STREAM_CONSTRAINTS_GOOG_ECHO_CANCELLATION = 1947;
  public static final int MEDIA_STREAM_CONSTRAINTS_GOOG_EXPERIMENTAL_AUTO_GAIN_CONTROL = 1950;
  public static final int MEDIA_STREAM_CONSTRAINTS_GOOG_EXPERIMENTAL_ECHO_CANCELLATION = 1948;
  public static final int MEDIA_STREAM_CONSTRAINTS_GOOG_EXPERIMENTAL_NOISE_SUPPRESSION = 1954;
  public static final int MEDIA_STREAM_CONSTRAINTS_GOOG_HIGHPASS_FILTER = 1952;
  public static final int MEDIA_STREAM_CONSTRAINTS_GOOG_NOISE_REDUCTION = 1959;
  public static final int MEDIA_STREAM_CONSTRAINTS_GOOG_NOISE_SUPPRESSION = 1951;
  public static final int MEDIA_STREAM_CONSTRAINTS_GOOG_TYPING_NOISE_DETECTION = 1953;
  public static final int MEDIA_STREAM_CONSTRAINTS_GROUP_ID_AUDIO = 1936;
  public static final int MEDIA_STREAM_CONSTRAINTS_GROUP_ID_VIDEO = 1937;
  public static final int MEDIA_STREAM_CONSTRAINTS_HEIGHT = 1923;
  public static final int MEDIA_STREAM_CONSTRAINTS_HOTWORD_ENABLED = 1946;
  public static final int MEDIA_STREAM_CONSTRAINTS_LATENCY = 1931;
  public static final int MEDIA_STREAM_CONSTRAINTS_MEDIA_STREAM_SOURCE_AUDIO = 1943;
  public static final int MEDIA_STREAM_CONSTRAINTS_MEDIA_STREAM_SOURCE_VIDEO = 1944;
  public static final int MEDIA_STREAM_CONSTRAINTS_NAME_VALUE = 1150;
  public static final int MEDIA_STREAM_CONSTRAINTS_OLD_AND_NEW = 1389;
  public static final int MEDIA_STREAM_CONSTRAINTS_RENDER_TO_ASSOCIATED_SINK = 1945;
  public static final int MEDIA_STREAM_CONSTRAINTS_SAMPLE_RATE = 1928;
  public static final int MEDIA_STREAM_CONSTRAINTS_SAMPLE_SIZE = 1929;
  public static final int MEDIA_STREAM_CONSTRAINTS_VIDEO = 1920;
  public static final int MEDIA_STREAM_CONSTRAINTS_VIDEO_UNCONSTRAINED = 1921;
  public static final int MEDIA_STREAM_CONSTRAINTS_VOLUME = 1927;
  public static final int MEDIA_STREAM_CONSTRAINTS_WIDTH = 1922;
  public static final int MEDIA_STREAM_ON_ACTIVE = 1415;
  public static final int MEDIA_STREAM_ON_INACTIVE = 1416;
  public static final int MEDIA_STREAM_TRACK_GENERATOR = 3728;
  public static final int MEDIA_STREAM_TRACK_PROCESSOR = 3729;
  public static final int MEDIA_STREAM_TRACK_REMOTE = 1306;
  public static final int MENU_ITEM_CLOSE_TAG = 1105;
  public static final int MENU_ITEM_ELEMENT = 1104;
  public static final int MENU_ITEM_ELEMENT_ICON_ATTRIBUTE = 1911;
  public static final int MESSAGE_EVENT_SHARED_ARRAY_BUFFER_DIFFERENT_AGENT_CLUSTER = 3106;
  public static final int MESSAGE_EVENT_SHARED_ARRAY_BUFFER_SAME_AGENT_CLUSTER = 3105;
  public static final int MESSAGE_EVENT_SHARED_ARRAY_BUFFER_SAME_ORIGIN = 3104;
  public static final int MESSAGE_PORTS_TRANSFERRED = 784;
  public static final int MESSAGE_PORT_TRANSFER_CLOSED_PORT = 2392;
  public static final int META_REFRESH = 1548;
  public static final int META_REFRESH_WHEN_CSP_BLOCKS_INLINE_SCRIPT = 1550;
  public static final int METER_ELEMENT = 483;
  public static final int METER_ELEMENT_HORIZONTAL_LTR = 4849;
  public static final int METER_ELEMENT_HORIZONTAL_RTL = 4850;
  public static final int METER_ELEMENT_VERTICAL_LTR = 4851;
  public static final int METER_ELEMENT_VERTICAL_RTL = 4852;
  public static final int METER_ELEMENT_WITH_METER_APPEARANCE = 993;
  public static final int METER_ELEMENT_WITH_NONE_APPEARANCE = 994;
  public static final int MICROPHONE_DISABLED_BY_FEATURE_POLICY_ESTIMATE = 2208;
  public static final int MIDDLE_CLICK_AUTOSCROLL_START = 1551;
  public static final int MIDI_DISABLED_BY_FEATURE_POLICY = 2210;
  public static final int MIDI_MESSAGE_EVENT = 2031;
  public static final int MIDI_MESSAGE_EVENT_RECEIVED_TIME = 1433;
  public static final int MIDI_OUTPUT_SEND = 2030;
  public static final int MIDI_PORT_OPEN = 2029;
  public static final int MIN_ATTRIBUTE = 43;
  public static final int MIN_VALUE = 0;
  public static final int MIXED_CONTENT_AUDIO = 611;
  public static final int MIXED_CONTENT_BLOCKABLE = 610;
  public static final int MIXED_CONTENT_BLOCKABLE_ALLOWED = 896;
  public static final int MIXED_CONTENT_DOWNLOAD = 612;
  public static final int MIXED_CONTENT_FAVICON = 613;
  public static final int MIXED_CONTENT_FORMS_SUBMITTED = 441;
  public static final int MIXED_CONTENT_FORM_PRESENT = 665;
  public static final int MIXED_CONTENT_IMAGE = 614;
  public static final int MIXED_CONTENT_INTERNAL = 615;
  public static final int MIXED_CONTENT_IN_NON_HTTPS_FRAME_THAT_RESTRICTS_MIXED_CONTENT = 661;
  public static final int MIXED_CONTENT_IN_SECURE_FRAME_THAT_DOES_NOT_RESTRICT_MIXED_CONTENT = 662;
  public static final int MIXED_CONTENT_PLUGIN = 616;
  public static final int MIXED_CONTENT_PREFETCH = 617;
  public static final int MIXED_CONTENT_PRESENT = 609;
  public static final int MIXED_CONTENT_PRIVATE_HOSTNAME_IN_PUBLIC_HOSTNAME = 530;
  public static final int MIXED_CONTENT_VIDEO = 618;
  public static final int MIXED_CONTENT_WEB_SOCKET = 663;
  public static final int MODULE_DEDICATED_WORKER = 3085;
  public static final int MODULE_SHARED_WORKER = 3149;
  public static final int MOUSE_DOWN_FIRED = 1451;
  public static final int MOUSE_DRAG_ON_CANCELLED_MOUSE_MOVE = 4754;
  public static final int MOUSE_EVENT_FROM_ELEMENT = 506;
  public static final int MOUSE_EVENT_MOVEMENT_X = 434;
  public static final int MOUSE_EVENT_MOVEMENT_Y = 435;
  public static final int MOUSE_EVENT_OFFSET_X = 502;
  public static final int MOUSE_EVENT_OFFSET_Y = 503;
  public static final int MOUSE_EVENT_RELATIVE_POSITION_FOR_INLINE_ELEMENT = 3720;
  public static final int MOUSE_EVENT_SCREEN_X = 3072;
  public static final int MOUSE_EVENT_SCREEN_Y = 3073;
  public static final int MOUSE_EVENT_TO_ELEMENT = 507;
  public static final int MOUSE_EVENT_X = 504;
  public static final int MOUSE_EVENT_Y = 505;
  public static final int MOUSE_WHEEL_AND_WHEEL_EVENT = 1127;
  public static final int MOUSE_WHEEL_EVENT = 1125;
  public static final int MOVED_OR_RESIZED_POPUP = 3069;
  public static final int MOVED_OR_RESIZED_POPUP2S_AFTER_CREATION = 3070;
  public static final int MULTIPLE_FETCH_HANDLERS_IN_SERVICE_WORKER = 4331;
  public static final int MULTIPLE_ORIGINS_IN_TIMING_ALLOW_ORIGIN = 1482;
  public static final int MULTI_COL_AND_LIST_ITEM = 3910;
  public static final int NAMED_ACCESS_ON_WINDOW_CHILD_BROWSING_CONTEXT = 1871;
  public static final int NAMED_ACCESS_ON_WINDOW_CHILD_BROWSING_CONTEXT_CROSS_ORIGIN_NAME_MISMATCH =
      1872;
  public static final int NAMED_NODE_MAP_GET_NAMED_ITEM = 306;
  public static final int NAMED_NODE_MAP_GET_NAMED_ITEM_NS = 310;
  public static final int NAMED_NODE_MAP_ITEM = 309;
  public static final int NAMED_NODE_MAP_REMOVE_NAMED_ITEM = 308;
  public static final int NAMED_NODE_MAP_REMOVE_NAMED_ITEM_NS = 312;
  public static final int NAMED_NODE_MAP_SET_NAMED_ITEM = 307;
  public static final int NAMED_NODE_MAP_SET_NAMED_ITEM_NS = 311;
  public static final int NAVIGATION_TIMING_L2 = 3349;
  public static final int NAVIGATOR_APP_VERSION = 2654;
  public static final int NAVIGATOR_COOKIE_ENABLED = 3275;
  public static final int NAVIGATOR_DEVICE_MEMORY = 2121;
  public static final int NAVIGATOR_DO_NOT_TRACK = 2655;
  public static final int NAVIGATOR_HARDWARE_CONCURRENCY = 2656;
  public static final int NAVIGATOR_LANGUAGE = 2657;
  public static final int NAVIGATOR_LANGUAGES = 2658;
  public static final int NAVIGATOR_MAX_TOUCH_POINTS = 2659;
  public static final int NAVIGATOR_MIME_TYPES = 2660;
  public static final int NAVIGATOR_PDF_VIEWER_ENABLED = 3973;
  public static final int NAVIGATOR_PLATFORM = 2661;
  public static final int NAVIGATOR_PLUGINS = 2662;
  public static final int NAVIGATOR_PRODUCT_SUB = 123;
  public static final int NAVIGATOR_UA_DATA_BRANDS = 4196;
  public static final int NAVIGATOR_UA_DATA_GET_HIGH_ENTROPY_VALUES = 4520;
  public static final int NAVIGATOR_UA_DATA_MOBILE = 4194;
  public static final int NAVIGATOR_UA_DATA_PLATFORM = 4195;
  public static final int NAVIGATOR_USER_AGENT = 2663;
  public static final int NAVIGATOR_VENDOR = 124;
  public static final int NAVIGATOR_VENDOR_SUB = 125;
  public static final int NAVIGATOR_VIBRATE = 850;
  public static final int NAVIGATOR_VIBRATE_ENGAGEMENT_HIGH = 1729;
  public static final int NAVIGATOR_VIBRATE_ENGAGEMENT_LOW = 1727;
  public static final int NAVIGATOR_VIBRATE_ENGAGEMENT_MAX = 1730;
  public static final int NAVIGATOR_VIBRATE_ENGAGEMENT_MEDIUM = 1728;
  public static final int NAVIGATOR_VIBRATE_ENGAGEMENT_MINIMAL = 1726;
  public static final int NAVIGATOR_VIBRATE_ENGAGEMENT_NONE = 1725;
  public static final int NAVIGATOR_VIBRATE_SUB_FRAME = 851;
  public static final int NAVIGATOR_XR = 2413;
  public static final int NEGATIVE_BACKGROUND_SIZE = 2402;
  public static final int NEGATIVE_MASK_SIZE = 2403;
  public static final int NESTED_DEDICATED_WORKER = 2499;
  public static final int NET_INFO = 744;
  public static final int NET_INFO_DOWNLINK = 1990;
  public static final int NET_INFO_DOWNLINK_MAX = 947;
  public static final int NET_INFO_EFFECTIVE_TYPE = 2013;
  public static final int NET_INFO_ON_CHANGE = 948;
  public static final int NET_INFO_ON_TYPE_CHANGE = 949;
  public static final int NET_INFO_RTT = 1989;
  public static final int NET_INFO_SAVE_DATA = 2217;
  public static final int NET_INFO_TYPE = 946;
  public static final int NEW_LAYOUT_OVERFLOW_DIFFERENT_AND_ALREADY_SCROLLS_BLOCK = 3704;
  public static final int NEW_LAYOUT_OVERFLOW_DIFFERENT_AND_ALREADY_SCROLLS_FLEX = 3705;
  public static final int NEW_LAYOUT_OVERFLOW_DIFFERENT_BLOCK = 3702;
  public static final int NEW_LAYOUT_OVERFLOW_DIFFERENT_BLOCK_WITH_NON_EMPTY_INFLOW_BOUNDS = 3999;
  public static final int NEW_LAYOUT_OVERFLOW_DIFFERENT_FLEX = 3703;
  public static final int NODE_FILTER_IS_FUNCTION = 1059;
  public static final int NODE_FILTER_IS_OBJECT = 1060;
  public static final int NODE_GET_ROOT_NODE = 1467;
  public static final int NODE_ITERATOR_DETACH = 347;
  public static final int
      NON_HTML_ELEMENT_SET_ATTRIBUTE_NODE_FROM_HTML_DOCUMENT_NAME_NOT_LOWERCASE = 845;
  public static final int NON_ORIGIN_CLEAN_IMAGE_BITMAP_SERIALIZATION = 3057;
  public static final int NON_ORIGIN_CLEAN_IMAGE_BITMAP_TRANSFER = 3059;
  public static final int NON_PASSIVE_TOUCH_EVENT_LISTENER = 2903;
  public static final int NON_WEBBY_MIXED_CONTENT = 3113;
  public static final int NOTIFICATION_API_INSECURE_ORIGIN_IFRAME = 1147;
  public static final int NOTIFICATION_API_SECURE_ORIGIN_IFRAME = 1148;
  public static final int NOTIFICATION_CLOSED = 534;
  public static final int NOTIFICATION_CLOSE_EVENT = 603;
  public static final int NOTIFICATION_CREATED = 533;
  public static final int NOTIFICATION_INSECURE_ORIGIN = 564;
  public static final int NOTIFICATION_PERMISSION = 371;
  public static final int NOTIFICATION_PERMISSION_REQUESTED = 535;
  public static final int NOTIFICATION_PERMISSION_REQUESTED_IFRAME = 1817;
  public static final int NOTIFICATION_PERMISSION_REQUESTED_INSECURE_ORIGIN = 1807;
  public static final int NOTIFICATION_SECURE_ORIGIN = 563;
  public static final int NOTIFICATION_SHOW_EVENT = 565;
  public static final int NOTIFICATION_SHOW_TRIGGER = 3017;
  public static final int NO_SYSEX_WEB_MIDI_ON_INSECURE_ORIGIN = 2771;
  public static final int NO_SYSEX_WEB_MIDI_WITHOUT_PERMISSION = 2770;
  public static final int NO_VARY_SEARCH = 4425;
  public static final int NUMBER_FORMAT = 2594;
  public static final int NUMBER_FORMAT_STYLE_UNIT = 3173;
  public static final int NUMBER_OF_FEATURES = 4863;
  public static final int NUMBER_TO_LOCALE_STRING = 2604;
  public static final int OBSERVABLE_CONSTRUCTOR = 4672;
  public static final int OBSOLETE_ADDITIONAL_GROUPING_PROPERTIES_FOR_COMPAT = 3297;
  public static final int OBSOLETE_ADDRESS_SPACE_LOCAL_EMBEDDED_IN_PRIVATE_NON_SECURE_CONTEXT =
      3689;
  public static final int OBSOLETE_ADDRESS_SPACE_LOCAL_EMBEDDED_IN_PRIVATE_SECURE_CONTEXT = 3688;
  public static final int OBSOLETE_ADDRESS_SPACE_LOCAL_EMBEDDED_IN_PUBLIC_NON_SECURE_CONTEXT = 3691;
  public static final int OBSOLETE_ADDRESS_SPACE_LOCAL_EMBEDDED_IN_PUBLIC_SECURE_CONTEXT = 3690;
  public static final int OBSOLETE_ADDRESS_SPACE_LOCAL_EMBEDDED_IN_UNKNOWN_NON_SECURE_CONTEXT =
      3693;
  public static final int OBSOLETE_ADDRESS_SPACE_LOCAL_EMBEDDED_IN_UNKNOWN_SECURE_CONTEXT = 3692;
  public static final int OBSOLETE_ADDRESS_SPACE_PRIVATE_EMBEDDED_IN_PUBLIC_NON_SECURE_CONTEXT =
      3695;
  public static final int OBSOLETE_ADDRESS_SPACE_PRIVATE_EMBEDDED_IN_PUBLIC_SECURE_CONTEXT = 3694;
  public static final int OBSOLETE_ADDRESS_SPACE_PRIVATE_EMBEDDED_IN_UNKNOWN_NON_SECURE_CONTEXT =
      3697;
  public static final int OBSOLETE_ADDRESS_SPACE_PRIVATE_EMBEDDED_IN_UNKNOWN_SECURE_CONTEXT = 3696;
  public static final int OBSOLETE_AD_CLICK_NAVIGATION = 2826;
  public static final int OBSOLETE_ANY_POPOVER_ATTRIBUTE = 4258;
  public static final int OBSOLETE_APPLICATION_CACHE_API_INSECURE_ORIGIN = 1247;
  public static final int OBSOLETE_APPLICATION_CACHE_API_SECURE_ORIGIN = 1248;
  public static final int OBSOLETE_APPLICATION_CACHE_INSTALLED_BUT_NO_MANIFEST = 2772;
  public static final int OBSOLETE_APPLICATION_CACHE_MANIFEST_SELECT_INSECURE_ORIGIN = 1245;
  public static final int OBSOLETE_APPLICATION_CACHE_MANIFEST_SELECT_SECURE_ORIGIN = 1246;
  public static final int OBSOLETE_ATTRIBUTION_REPORTING_UNDERSCORE_PREFIXED_FILTER_KEY = 4658;
  public static final int OBSOLETE_AUTO_PICTURE_IN_PICTURE_ATTRIBUTE = 2735;
  public static final int OBSOLETE_BASE_WOULD_BE_BLOCKED_BY_DEFAULT_SRC = 1763;
  public static final int OBSOLETE_BATTERY_SAVINGS_META = 3395;
  public static final int OBSOLETE_BATTERY_STATUS_INSECURE_ORIGIN = 2199;
  public static final int OBSOLETE_BCP_AUTHENTICATED_SIGNED_WRITES = 3423;
  public static final int OBSOLETE_BCP_BROADCAST = 3417;
  public static final int OBSOLETE_BCP_INDICATE = 3422;
  public static final int OBSOLETE_BCP_NOTIFY = 3421;
  public static final int OBSOLETE_BCP_READ = 3418;
  public static final int OBSOLETE_BCP_RELIABLE_WRITE = 3424;
  public static final int OBSOLETE_BCP_WRITABLE_AUXILIARIES = 3425;
  public static final int OBSOLETE_BCP_WRITE = 3420;
  public static final int OBSOLETE_BCP_WRITE_WITHOUT_RESPONSE = 3419;
  public static final int OBSOLETE_BLUETOOTH_REMOTE_GATT_CHARACTERISTIC_UUID = 3402;
  public static final int OBSOLETE_BLUETOOTH_REMOTE_GATT_DESCRIPTOR_UUID = 3403;
  public static final int OBSOLETE_BLUETOOTH_REMOTE_GATT_SERVICE_UUID = 3404;
  public static final int OBSOLETE_CERTIFICATE_TRANSPARENCY_NON_COMPLIANT_RESOURCE_IN_SUBFRAME =
      2360;
  public static final int
      OBSOLETE_CERTIFICATE_TRANSPARENCY_NON_COMPLIANT_SUBRESOURCE_IN_MAIN_FRAME = 2359;
  public static final int OBSOLETE_CLIENT_HINTS_LANG = 2777;
  public static final int OBSOLETE_CLIENT_HINTS_META_ACCEPT_CH_LIFETIME = 2500;
  public static final int OBSOLETE_CLIENT_HINTS_META_NAME_ACCEPT_CH = 4081;
  public static final int OBSOLETE_CLIENT_HINTS_PARTITIONED_COOKIES = 4160;
  public static final int OBSOLETE_COMMA_SEPARATOR_IN_ALLOW_ATTRIBUTE = 3355;
  public static final int OBSOLETE_COMPUTE_PRESSURE_OBSERVER_STOP = 3901;
  public static final int OBSOLETE_CONVERSION_REGISTRATION = 3367;
  public static final int OBSOLETE_CREATE_IMAGE_BITMAP_IMAGE_ORIENTATION_NONE = 4446;
  public static final int OBSOLETE_CREATE_NS_RESOLVER_WITH_NON_ELEMENTS = 4415;
  public static final int OBSOLETE_CREATE_NS_RESOLVER_WITH_NON_ELEMENTS2 = 4475;
  public static final int OBSOLETE_CROSS_ORIGIN_WINDOW_PROMPT = 1413;
  public static final int OBSOLETE_CSSOM_MEDIA_CONDITION_UNKNOWN = 4084;
  public static final int OBSOLETE_CSS_AT_SUPPORTS_DROP_INVALID_WHILE_FORGIVING_PARSING = 4361;
  public static final int OBSOLETE_CSS_DEEP_COMBINATOR = 471;
  public static final int OBSOLETE_CSS_DEEP_COMBINATOR_AND_SHADOW = 1375;
  public static final int OBSOLETE_CSS_GET_COMPUTED_ANIMATION_DELAY_ZERO = 4417;
  public static final int OBSOLETE_CSS_INVALID_VARIABLE_UNSET = 3377;
  public static final int OBSOLETE_CSS_MATCH_MEDIA_UNKNOWN = 4082;
  public static final int OBSOLETE_CSS_MEDIA_LIST_UNKNOWN = 4083;
  public static final int OBSOLETE_CSS_PSEUDO_HOST_COMPOUND_LIST = 3716;
  public static final int OBSOLETE_CSS_PSEUDO_HOST_CONTEXT_COMPOUND_LIST = 3717;
  public static final int OBSOLETE_CSS_PSEUDO_HOST_DYNAMIC_SPECIFICITY = 3718;
  public static final int OBSOLETE_CSS_SELECTOR_PSEUDO_CONTENT = 468;
  public static final int OBSOLETE_CSS_SELECTOR_PSEUDO_HAS_IN_LIVE_PROFILE = 3972;
  public static final int OBSOLETE_CSS_SELECTOR_PSEUDO_HAS_IN_SNAPSHOT_PROFILE = 3971;
  public static final int OBSOLETE_CSS_SELECTOR_PSEUDO_SHADOW = 467;
  public static final int OBSOLETE_CSS_STYLE_SHEET_REPLACE_WITH_IMPORT = 3169;
  public static final int OBSOLETE_CSS_SYSTEM_COLOR_COMPUTE_TO_SELF = 3364;
  public static final int OBSOLETE_CSS_VALUE_OVERFLOW_X_OVERLAY = 2981;
  public static final int OBSOLETE_CSS_VALUE_OVERFLOW_Y_OVERLAY = 2982;
  public static final int OBSOLETE_CUSTOM_CURSOR_INTERSECTS_VIEWPORT = 2776;
  public static final int OBSOLETE_DEEP_COMBINATOR_IN_STATIC_PROFILE = 2163;
  public static final int OBSOLETE_DEFAULT_IN_CUSTOM_IDENT = 2628;
  public static final int OBSOLETE_DEFERRED_SHAPING2_DISABLED_BY_FRAGMENT_ANCHOR = 4339;
  public static final int OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_COMPUTED_STYLE = 4336;
  public static final int OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_DOM_CONTENT_LOADED = 4337;
  public static final int OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_FCP = 4338;
  public static final int OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_FOCUS = 4340;
  public static final int OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_GEOMETRY = 4341;
  public static final int OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_INSPECTOR = 4342;
  public static final int OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_LAST_RESORT = 4348;
  public static final int OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_PRINTING = 4343;
  public static final int OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_SCROLLING = 4344;
  public static final int OBSOLETE_DEFERRED_SHAPING_DISABLED_BY_POSITIONED = 4213;
  public static final int OBSOLETE_DEFERRED_SHAPING_RESHAPED_BY_FORCE_LAYOUT = 4260;
  public static final int OBSOLETE_DEFERRED_SHAPING_WORKED = 4259;
  public static final int OBSOLETE_DEVICE_MOTION_INSECURE_ORIGIN = 668;
  public static final int OBSOLETE_DEVICE_ORIENTATION_ABSOLUTE_INSECURE_ORIGIN = 987;
  public static final int OBSOLETE_DEVICE_ORIENTATION_INSECURE_ORIGIN = 670;
  public static final int OBSOLETE_DIALOG_CLOSE_WATCHER_CANCEL_SKIPPED = 4422;
  public static final int OBSOLETE_DIALOG_CLOSE_WATCHER_CANCEL_SKIPPED_AND_DEFAULT_PREVENTED = 4423;
  public static final int OBSOLETE_DIALOG_CLOSE_WATCHER_CLOSE_SIGNAL_CLOSED_MULTIPLE = 4424;
  public static final int OBSOLETE_DISPATCH_MOUSE_EVENT_ON_DISABLED_FORM_CONTROL = 1967;
  public static final int OBSOLETE_DISPATCH_MOUSE_UP_DOWN_EVENT_ON_DISABLED_FORM_CONTROL = 2321;
  public static final int OBSOLETE_DOCUMENT_FULLSCREEN_ELEMENT_IN_V0_SHADOW = 1665;
  public static final int OBSOLETE_DOCUMENT_POINTER_LOCK_ELEMENT_IN_V0_SHADOW = 1423;
  public static final int OBSOLETE_DOCUMENT_REGISTER_ELEMENT = 457;
  public static final int OBSOLETE_DOCUMENT_REGISTER_ELEMENT_ON_REVERSE_ORIGIN_TRIALS = 2849;
  public static final int OBSOLETE_DOCUMENT_TRANSITION = 3931;
  public static final int OBSOLETE_ELEMENT_ATTACH_INTERNALS_BEFORE_CONSTRUCTOR = 3470;
  public static final int OBSOLETE_ELEMENT_CREATE_SHADOW_ROOT = 456;
  public static final int OBSOLETE_ELEMENT_CREATE_SHADOW_ROOT_ON_REVERSE_ORIGIN_TRIALS = 2848;
  public static final int OBSOLETE_EVENT_PATH = 345;
  public static final int
      OBSOLETE_EVENT_TIMING_PAINTED_PRESENTATION_PROMISE_RESOLVED_WITH_EARLIER_PROMISE_UNRESOLVED =
          4560;
  public static final int OBSOLETE_EVENT_TIMING_PRESENTATION_PROMISE_RESOLVED_AFTER_REPORT = 4597;
  public static final int OBSOLETE_EXEC_COMMAND_WITH_TRUSTED_TYPES = 3970;
  public static final int OBSOLETE_EXPECT_CT_HEADER = 4302;
  public static final int OBSOLETE_EXTERNAL_ADD_SEARCH_PROVIDER = 981;
  public static final int OBSOLETE_EXTERNAL_IS_SEARCH_PROVIDER_INSTALLED = 982;
  public static final int OBSOLETE_FEATURE_POLICY_PROPOSAL_WOULD_CHANGE_BEHAVIOUR = 3158;
  public static final int OBSOLETE_FED_CM_LOGOUT = 4225;
  public static final int OBSOLETE_FED_CM_LOGOUT_RPS = 4226;
  public static final int OBSOLETE_FONT_SELECTOR_CSS_FONT_FAMILY_WEB_KIT_PREFIX_PICTOGRAPH = 3986;
  public static final int OBSOLETE_FONT_SELECTOR_CSS_FONT_FAMILY_WEB_KIT_PREFIX_STANDARD = 3987;
  public static final int OBSOLETE_FORCE_ENCODED_AUDIO_INSERTABLE_STREAMS = 3294;
  public static final int OBSOLETE_FORCE_ENCODED_VIDEO_INSERTABLE_STREAMS = 3295;
  public static final int OBSOLETE_FRAGMENT_HAS_AMPERSAND_DELIMITER_QUESTION = 3042;
  public static final int OBSOLETE_FRAGMENT_HAS_COLON_TILDE_COLON = 3040;
  public static final int OBSOLETE_FRAGMENT_HAS_TILDE_AMPERSAND_TILDE = 3039;
  public static final int OBSOLETE_FRAGMENT_HAS_TILDE_AT_TILDE = 3041;
  public static final int OBSOLETE_GESTURE_SCROLL_END = 4222;
  public static final int OBSOLETE_GESTURE_SCROLL_START = 4220;
  public static final int OBSOLETE_GESTURE_SCROLL_UPDATE = 4221;
  public static final int OBSOLETE_GET_CURRENT_BROWSING_CONTEXT_MEDIA = 3719;
  public static final int OBSOLETE_GET_DISPLAY_MEDIA_WITHOUT_USER_ACTIVATION = 4370;
  public static final int OBSOLETE_HANDWRITING_RECOGNITION_QUERY_SUPPORT = 3893;
  public static final int OBSOLETE_HTML_CONTENT_ELEMENT = 1896;
  public static final int OBSOLETE_HTML_IMPORTS = 455;
  public static final int OBSOLETE_HTML_IMPORTS_ASYNC_ATTRIBUTE = 463;
  public static final int OBSOLETE_HTML_IMPORTS_HAS_STYLE_SHEETS = 940;
  public static final int OBSOLETE_HTML_IMPORTS_ON_REVERSE_ORIGIN_TRIALS = 2847;
  public static final int OBSOLETE_HTML_PARAM_ELEMENT_URL_PARAMETER = 4010;
  public static final int OBSOLETE_HTML_PARAM_ELEMENT_URL_PARAMETER_IN_USE_NON_PDF = 4111;
  public static final int OBSOLETE_HTML_PARAM_ELEMENT_URL_PARAMETER_IN_USE_PDF = 4110;
  public static final int
      OBSOLETE_HTML_PATTERN_REG_EXP_UNICODE_SET_INCOMPATIBILITIES_WITH_UNICODE_MODE = 4463;
  public static final int OBSOLETE_HTML_SHADOW_ELEMENT = 1897;
  public static final int OBSOLETE_HTML_TABLE_CELL_ELEMENT_COLSPAN_GREATER_THAN1000 = 1784;
  public static final int OBSOLETE_HTML_TABLE_CELL_ELEMENT_COLSPAN_GREATER_THAN8190 = 1785;
  public static final int OBSOLETE_HTML_TABLE_ELEMENT_PRESENTATION_ATTRIBUTE_BACKGROUND = 1869;
  public static final int OBSOLETE_IMPRESSION_REGISTRATION = 3366;
  public static final int OBSOLETE_INERT_ATTRIBUTE = 1995;
  public static final int OBSOLETE_INPUT_TYPE_CHECKBOX_RENDERED_NON_SQUARE = 3121;
  public static final int OBSOLETE_INPUT_TYPE_RADIO_RENDERED_NON_SQUARE = 3122;
  public static final int OBSOLETE_INTEREST_COHORT_API_INTEREST_COHORT_METHOD = 3687;
  public static final int OBSOLETE_K_ACCESSIBILITY_TOUCH_PASSTHROUGH_SET = 3920;
  public static final int OBSOLETE_K_ARIA_TOUCHPASSTHROUGH_ATTRIBUTE = 3918;
  public static final int OBSOLETE_K_CSS_PSEUDO_HAS_CONTAINS_MIX_OF_VALID_AND_INVALID = 4440;
  public static final int OBSOLETE_K_CSS_PSEUDO_IS_WHERE_CONTAINS_MIX_OF_VALID_AND_INVALID = 4441;
  public static final int OBSOLETE_K_NAVIGATE_EVENT_RESTORE_SCROLL = 4304;
  public static final int OBSOLETE_K_NAVIGATE_EVENT_TRANSITION_WHILE = 4303;
  public static final int OBSOLETE_K_SMOOTH_SCROLL_JS_INTERVENTION_ACTIVATED = 2020;
  public static final int OBSOLETE_K_V8_PENDING_BEACON_CONSTRUCTOR = 4273;
  public static final int OBSOLETE_K_V8_PENDING_BEACON_IS_PENDING_ATTRIBUTE_GETTER = 4295;
  public static final int OBSOLETE_K_V8_PENDING_BEACON_METHOD_ATTRIBUTE_SETTER = 4277;
  public static final int OBSOLETE_K_V8_PENDING_BEACON_PAGE_HIDE_TIMEOUT_ATTRIBUTE_GETTER = 4278;
  public static final int OBSOLETE_K_V8_PENDING_BEACON_PAGE_HIDE_TIMEOUT_ATTRIBUTE_SETTER = 4279;
  public static final int OBSOLETE_K_V8_PENDING_BEACON_SET_DATA_METHOD = 4282;
  public static final int OBSOLETE_K_V8_PENDING_BEACON_STATE_ATTRIBUTE_GETTER = 4280;
  public static final int OBSOLETE_K_V8_PENDING_BEACON_URL_ATTRIBUTE_SETTER = 4275;
  public static final int OBSOLETE_K_WINDOW_OPEN_NEW_POPUP_BEHAVIOR_MISMATCH = 3941;
  public static final int OBSOLETE_LAST_LETTER_SPACING_AFFECTS_RENDERING = 3383;
  public static final int OBSOLETE_LAYOUT_MEDIA_INLINE_CHILDREN = 4385;
  public static final int OBSOLETE_LEGACY_CONST = 748;
  public static final int OBSOLETE_LEGACY_CONSTRAINT_GOOG_CPU_OVERUSE_DETECTION = 4209;
  public static final int OBSOLETE_LEGACY_CONSTRAINT_GOOG_I_PV6 = 4207;
  public static final int OBSOLETE_LEGACY_CONSTRAINT_GOOG_SCREENCAST_MIN_BITRATE = 4204;
  public static final int OBSOLETE_LEGACY_CONSTRAINT_GOOG_SUSPEND_BELOW_MIN_BITRATE = 4208;
  public static final int OBSOLETE_LEGACY_LAYOUT_BY_DETAILS_MARKER = 3206;
  public static final int OBSOLETE_LEGACY_LAYOUT_BY_EDITING = 3207;
  public static final int OBSOLETE_LEGACY_LAYOUT_BY_FRAME_SET = 3211;
  public static final int OBSOLETE_LEGACY_LAYOUT_BY_GRID = 3212;
  public static final int OBSOLETE_LEGACY_LAYOUT_BY_MULTI_COL = 3214;
  public static final int OBSOLETE_LEGACY_LAYOUT_BY_PRINTING = 3215;
  public static final int OBSOLETE_LEGACY_LAYOUT_BY_SVG = 3217;
  public static final int OBSOLETE_LEGACY_LAYOUT_BY_TABLE = 3219;
  public static final int
      OBSOLETE_LEGACY_LAYOUT_BY_TABLE_FLEX_GRID_BLOCK_IN_NG_FRAGMENTATION_CONTEXT = 3224;
  public static final int OBSOLETE_LEGACY_LAYOUT_BY_TEXT_COMBINE = 3220;
  public static final int OBSOLETE_LEGACY_LAYOUT_BY_TEXT_CONTROL = 3221;
  public static final int OBSOLETE_LEGACY_LAYOUT_BY_VTT_CUE = 3222;
  public static final int OBSOLETE_LEGACY_PROTOCOL_EMBEDDED_AS_SUBRESOURCE = 531;
  public static final int OBSOLETE_LEGACY_TLS_VERSION_IN_MAIN_FRAME_RESOURCE = 2634;
  public static final int OBSOLETE_LEGACY_TLS_VERSION_IN_SUBFRAME_MAIN_RESOURCE = 2636;
  public static final int OBSOLETE_LEGACY_TLS_VERSION_IN_SUBRESOURCE = 2635;
  public static final int OBSOLETE_LOCAL_STORAGE_FIRST_USED_AFTER_FCP = 3715;
  public static final int OBSOLETE_LOCAL_STORAGE_FIRST_USED_BEFORE_FCP = 3714;
  public static final int OBSOLETE_LOCATION_FRAGMENT_DIRECTIVE_ACCESSED = 3283;
  public static final int OBSOLETE_MAIN_FRAME_CSP_VIA_ORIGIN_POLICY = 3361;
  public static final int OBSOLETE_MEDIA_STREAM_CONSTRAINTS_FROM_DICTIONARY = 1151;
  public static final int OBSOLETE_MEDIA_STREAM_CONSTRAINTS_VIDEO_KIND = 1938;
  public static final int OBSOLETE_MEDIA_STREAM_DESTINATION_ON_OFFLINE_CONTEXT = 2476;
  public static final int OBSOLETE_MEDIA_STREAM_SOURCE_ON_OFFLINE_CONTEXT = 2477;
  public static final int OBSOLETE_MIXED_SHADOW_ROOT_V0_AND_V1 = 1309;
  public static final int OBSOLETE_NEW_CANVAS2_DAPI = 3886;
  public static final int OBSOLETE_OFFSET_WIDTH_OR_HEIGHT_IGNORING_CONTINUATION = 4051;
  public static final int OBSOLETE_OLD_CONSTRAINT_IGNORED = 4200;
  public static final int OBSOLETE_OLD_CONSTRAINT_NOT_REPORTED = 4198;
  public static final int OBSOLETE_OLD_CONSTRAINT_REJECTED = 4199;
  public static final int OBSOLETE_OPEN_WEB_DATABASE_INSECURE_CONTEXT = 4073;
  public static final int OBSOLETE_OPEN_WEB_DATABASE_THIRD_PARTY_CONTEXT = 3865;
  public static final int OBSOLETE_ORB_BLOCK_WITHOUT_ANY_EVENT_HANDLER = 4618;
  public static final int OBSOLETE_ORB_BLOCK_WITH_ANY_EVENT_HANDLER = 4622;
  public static final int OBSOLETE_ORB_BLOCK_WITH_ON_ERROR_BUT_WITHOUT_ON_LOAD_EVENT_HANDLER = 4619;
  public static final int OBSOLETE_ORB_BLOCK_WITH_ON_LOAD_AND_ON_ERROR_EVENT_HANDLER = 4621;
  public static final int OBSOLETE_ORB_BLOCK_WITH_ON_LOAD_BUT_WITHOUT_ON_ERROR_EVENT_HANDLER = 4620;
  public static final int OBSOLETE_PAGE_DESTRUCTION = 0;
  public static final int OBSOLETE_POPOVER_ATTRIBUTE = 3781;
  public static final int OBSOLETE_PREFIXED_STORAGE_INFO = 57;
  public static final int OBSOLETE_PREFIXED_WINDOW_URL = 283;
  public static final int OBSOLETE_PRIVATE_NETWORK_ACCESS_IGNORED_PREFLIGHT_ERROR = 4092;
  public static final int OBSOLETE_PSEUDO_SHADOW_IN_STATIC_PROFILE = 2164;
  public static final int OBSOLETE_READ_OR_WRITE_WEB_DATABASE_THIRD_PARTY_CONTEXT = 3985;
  public static final int OBSOLETE_REVERT_IN_CUSTOM_IDENT = 2889;
  public static final int OBSOLETE_RTC_AUDIO_JITTER_BUFFER_RTX_HANDLING = 2736;
  public static final int OBSOLETE_RTC_CONSTRAINT_ENABLE_RTP_DATA_CHANNELS_FALSE = 3345;
  public static final int OBSOLETE_RTC_CONSTRAINT_ENABLE_RTP_DATA_CHANNELS_TRUE = 3344;
  public static final int
      OBSOLETE_RTC_PEER_CONNECTION_COMPLEX_PLAN_B_SDP_USING_DEFAULT_SDP_SEMANTICS = 2591;
  public static final int OBSOLETE_RTC_PEER_CONNECTION_CONSTRUCTED_WITH_PLAN_B = 3785;
  public static final int OBSOLETE_RTC_PEER_CONNECTION_CONSTRUCTED_WITH_UNIFIED_PLAN = 3786;
  public static final int OBSOLETE_RTC_PEER_CONNECTION_CREATE_ANSWER_LEGACY_CONSTRAINTS = 1050;
  public static final int OBSOLETE_RTC_PEER_CONNECTION_CREATE_OFFER_LEGACY_OFFER_OPTIONS = 1046;
  public static final int OBSOLETE_RTC_PEER_CONNECTION_LEGACY_CREATE_WITH_MEDIA_CONSTRAINTS = 4205;
  public static final int OBSOLETE_RTC_PEER_CONNECTION_PLAN_B_THREW_AN_EXCEPTION = 3935;
  public static final int OBSOLETE_RTC_PEER_CONNECTION_SDP_SEMANTICS_PLAN_B = 3773;
  public static final int
      OBSOLETE_RTC_PEER_CONNECTION_SDP_SEMANTICS_PLAN_B_WITH_REVERSE_ORIGIN_TRIAL = 3812;
  public static final int OBSOLETE_RTC_PEER_CONNECTION_USING_COMPLEX_PLAN_B = 3787;
  public static final int OBSOLETE_RTC_PEER_CONNECTION_USING_COMPLEX_UNIFIED_PLAN = 3788;
  public static final int OBSOLETE_SANITIZER_API_TO_STRING = 3816;
  public static final int OBSOLETE_SCHEDULER_CURRENT_TASK_SIGNAL = 3190;
  public static final int OBSOLETE_SCROLL_PADDING_ON_VIEWPORT_BREAKS = 2973;
  public static final int OBSOLETE_SCROLL_SNAP_ON_VIEWPORT_BREAKS = 2972;
  public static final int OBSOLETE_SELECTION_ADD_RANGE_INTERSECT = 1786;
  public static final int OBSOLETE_SEND_BEACON_WITH_NON_SIMPLE_CONTENT_TYPE = 1485;
  public static final int OBSOLETE_SERVICE_WORKER_SUBRESOURCE_FILTER_BYPASSED_REQUEST = 3887;
  public static final int OBSOLETE_SESSION_STORAGE_FIRST_USED_AFTER_FCP = 3794;
  public static final int OBSOLETE_SESSION_STORAGE_FIRST_USED_BEFORE_FCP = 3793;
  public static final int OBSOLETE_SHAPE_DETECTION_API = 2522;
  public static final int OBSOLETE_SHAPE_DETECTION_BARCODE_DETECTOR_CONSTRUCTOR = 1991;
  public static final int OBSOLETE_SHAPE_DETECTION_FACE_DETECTOR_CONSTRUCTOR = 1992;
  public static final int OBSOLETE_SHAPE_DETECTION_TEXT_DETECTOR_CONSTRUCTOR = 1993;
  public static final int OBSOLETE_STORAGE_FOUNDATION_FLUSH = 3827;
  public static final int OBSOLETE_STORAGE_FOUNDATION_FLUSH_SYNC = 3828;
  public static final int OBSOLETE_STORAGE_FOUNDATION_OPEN = 3822;
  public static final int OBSOLETE_STORAGE_FOUNDATION_READ = 3823;
  public static final int OBSOLETE_STORAGE_FOUNDATION_READ_SYNC = 3824;
  public static final int OBSOLETE_STORAGE_FOUNDATION_WRITE = 3825;
  public static final int OBSOLETE_STORAGE_FOUNDATION_WRITE_SYNC = 3826;
  public static final int OBSOLETE_STRING_TO_LOCALE_UPPER_CASE = 2602;
  public static final int OBSOLETE_SUBRESOURCE_WEB_BUNDLES = 3446;
  public static final int OBSOLETE_TEXT_WRAP_BALANCE = 4544;
  public static final int OBSOLETE_TEXT_WRAP_BALANCE_FAIL = 4545;
  public static final int OBSOLETE_TEXT_WRAP_PRETTY = 4594;
  public static final int OBSOLETE_TEXT_WRAP_PRETTY_FAIL = 4595;
  public static final int OBSOLETE_TOPICS_API_XHR = 4461;
  public static final int OBSOLETE_TOUCH_ACTION_CHANGED_AT_POINTER_DOWN = 4288;
  public static final int OBSOLETE_U2F_CRYPTOTOKEN_REGISTER = 2812;
  public static final int OBSOLETE_U2F_CRYPTOTOKEN_SIGN = 2813;
  public static final int OBSOLETE_UPGRADE_INSECURE_REQUESTS_UPGRADED_REQUEST = 741;
  public static final int OBSOLETE_URL_SET_PORT_CHECK_OVERFLOW = 4503;
  public static final int OBSOLETE_URN_DOCUMENT_ACCESSED_COOKIES = 3922;
  public static final int OBSOLETE_UUID_IN_PACKAGE_URL_NAVIGATION = 4387;
  public static final int OBSOLETE_V8HTML_POPUP_ELEMENT_HIDE_METHOD = 3783;
  public static final int OBSOLETE_V8HTML_POPUP_ELEMENT_SHOW_METHOD = 3782;
  public static final int OBSOLETE_V8HTML_VIDEO_ELEMENT_AUTO_PICTURE_IN_PICTURE_ATTRIBUTE_GETTER =
      2733;
  public static final int OBSOLETE_V8HTML_VIDEO_ELEMENT_AUTO_PICTURE_IN_PICTURE_ATTRIBUTE_SETTER =
      2734;
  public static final int OBSOLETE_V8RTC_QUIC_STREAM_MAX_READ_BUFFERED_AMOUNT_ATTRIBUTE_GETTER =
      2761;
  public static final int OBSOLETE_V8RTC_QUIC_STREAM_MAX_WRITE_BUFFERED_AMOUNT_ATTRIBUTE_GETTER =
      2763;
  public static final int OBSOLETE_V8RTC_QUIC_STREAM_READ_BUFFERED_AMOUNT_ATTRIBUTE_GETTER = 2760;
  public static final int OBSOLETE_V8RTC_QUIC_STREAM_READ_INTO_METHOD = 2764;
  public static final int OBSOLETE_V8RTC_QUIC_STREAM_RESET_METHOD = 2766;
  public static final int OBSOLETE_V8RTC_QUIC_STREAM_STATE_ATTRIBUTE_GETTER = 2759;
  public static final int OBSOLETE_V8RTC_QUIC_STREAM_TRANSPORT_ATTRIBUTE_GETTER = 2758;
  public static final int OBSOLETE_V8RTC_QUIC_STREAM_WAIT_FOR_READABLE_METHOD = 2768;
  public static final int OBSOLETE_V8RTC_QUIC_STREAM_WAIT_FOR_WRITE_BUFFERED_AMOUNT_BELOW_METHOD =
      2767;
  public static final int OBSOLETE_V8RTC_QUIC_STREAM_WRITE_BUFFERED_AMOUNT_ATTRIBUTE_GETTER = 2762;
  public static final int OBSOLETE_V8RTC_QUIC_STREAM_WRITE_METHOD = 2765;
  public static final int OBSOLETE_V8RTC_QUIC_TRANSPORT_CONNECT_METHOD = 2745;
  public static final int OBSOLETE_V8RTC_QUIC_TRANSPORT_CONSTRUCTOR = 2740;
  public static final int OBSOLETE_V8RTC_QUIC_TRANSPORT_CREATE_STREAM_METHOD = 2748;
  public static final int OBSOLETE_V8RTC_QUIC_TRANSPORT_GET_KEY_METHOD = 2743;
  public static final int OBSOLETE_V8RTC_QUIC_TRANSPORT_GET_STATS_METHOD = 2744;
  public static final int OBSOLETE_V8RTC_QUIC_TRANSPORT_LISTEN_METHOD = 2746;
  public static final int OBSOLETE_V8RTC_QUIC_TRANSPORT_MAX_DATAGRAM_LENGTH_ATTRIBUTE_GETTER = 2867;
  public static final int OBSOLETE_V8RTC_QUIC_TRANSPORT_READY_TO_SEND_DATAGRAM_METHOD = 2868;
  public static final int OBSOLETE_V8RTC_QUIC_TRANSPORT_RECEIVE_DATAGRAMS_METHOD = 2870;
  public static final int OBSOLETE_V8RTC_QUIC_TRANSPORT_SEND_DATAGRAM_METHOD = 2869;
  public static final int OBSOLETE_V8RTC_QUIC_TRANSPORT_STATE_ATTRIBUTE_GETTER = 2742;
  public static final int OBSOLETE_V8RTC_QUIC_TRANSPORT_STOP_METHOD = 2747;
  public static final int OBSOLETE_V8RTC_QUIC_TRANSPORT_TRANSPORT_ATTRIBUTE_GETTER = 2741;
  public static final int OBSOLETE_V8RTC_RTP_RECEIVER_CREATE_ENCODED_AUDIO_STREAMS_METHOD = 3182;
  public static final int OBSOLETE_V8RTC_RTP_RECEIVER_CREATE_ENCODED_VIDEO_STREAMS_METHOD = 3183;
  public static final int OBSOLETE_V8RTC_RTP_SENDER_CREATE_ENCODED_AUDIO_STREAMS_METHOD = 3180;
  public static final int OBSOLETE_V8RTC_RTP_SENDER_CREATE_ENCODED_VIDEO_STREAMS_METHOD = 3181;
  public static final int OBSOLETE_V8_ARRAY_INSTANCE_PROTO_MODIFIED = 1393;
  public static final int OBSOLETE_V8_ARRAY_PROTECTOR_DIRTIED = 1390;
  public static final int OBSOLETE_V8_ARRAY_PROTOTYPE_SORT_JS_ARRAY_MODIFIED_PROTOTYPE = 2437;
  public static final int OBSOLETE_V8_CONSTRUCTOR_NON_UNDEFINED_PRIMITIVE_RETURN = 2054;
  public static final int OBSOLETE_V8_FONT_MANAGER_QUERY_METHOD = 3386;
  public static final int OBSOLETE_V8_INTL_PATTERN = 1135;
  public static final int OBSOLETE_V8_INTL_RESOLVED = 1136;
  public static final int OBSOLETE_V8_INTL_V8_PARSE = 1134;
  public static final int OBSOLETE_V8_LABELED_EXPRESSION_STATEMENT = 2119;
  public static final int OBSOLETE_V8_LEGACY_FUNCTION_DECLARATION = 1395;
  public static final int OBSOLETE_V8_OPTIMIZED_FUNCTION_WITH_ONE_SHOT_BYTECODE = 2612;
  public static final int OBSOLETE_V8_PROMISE_ACCEPT = 1138;
  public static final int OBSOLETE_V8_PROMISE_CHAIN = 1137;
  public static final int OBSOLETE_V8_PROMISE_DEFER = 1139;
  public static final int OBSOLETE_V8_REG_EXP_PROTOTYPE_OLD_FLAG_GETTER = 1397;
  public static final int OBSOLETE_V8_REG_EXP_PROTOTYPE_SOURCE_GETTER = 1396;
  public static final int OBSOLETE_V8_REG_EXP_UNICODE_SET_INCOMPATIBILITIES_WITH_UNICODE_MODE =
      4458;
  public static final int OBSOLETE_V8_SCREENS_ONCHANGE_ATTRIBUTE_GETTER = 3840;
  public static final int OBSOLETE_V8_SCREENS_ONCHANGE_ATTRIBUTE_SETTER = 3841;
  public static final int OBSOLETE_V8_STRONG_MODE = 1077;
  public static final int OBSOLETE_V8_WASM_BULK_MEMORY = 3320;
  public static final int OBSOLETE_V8_WASM_MULTI_VALUE = 3322;
  public static final int OBSOLETE_V8_WINDOW_IS_MULTI_SCREEN_METHOD = 3389;
  public static final int OBSOLETE_V8_WINDOW_ONSCREENSCHANGE_ATTRIBUTE_GETTER = 3390;
  public static final int OBSOLETE_V8_WINDOW_ONSCREENSCHANGE_ATTRIBUTE_SETTER = 3391;
  public static final int OBSOLETE_V8_WINDOW_REQUEST_PICTURE_IN_PICTURE_WINDOW_METHOD = 4153;
  public static final int OBSOLETE_WAKE_LOCK_ACQUIRE_SCREEN_LOCK_WITHOUT_ACTIVATION = 4365;
  public static final int OBSOLETE_WEBRTC_TLS_VERSION = 3075;
  public static final int OBSOLETE_WEB_APP_MANIFEST_HANDLE_LINKS = 4109;
  public static final int OBSOLETE_WEB_ASSEMBLY_DYNAMIC_TIERING = 4059;
  public static final int OBSOLETE_WEB_CODECS_IMAGE_DECODER_PREMULTIPLY_ALPHA_DEPRECATION = 4299;
  public static final int OBSOLETE_WEB_CODECS_VIDEO_FRAME_DEFAULT_TIMESTAMP = 4070;
  public static final int OBSOLETE_WEB_GPU_WEB_CODECS = 4481;
  public static final int OBSOLETE_WEB_NFC_API = 3127;
  public static final int OBSOLETE_WINDOW_EVENT_IN_V0_SHADOW_TREE = 2244;
  public static final int OBSOLETE_WINDOW_OPEN_WITH_ADDITIONAL_BOOL_PARAMETER = 3784;
  public static final int OBSOLETE_WINDOW_SCREEN_ID = 3567;
  public static final int OBSOLETE_WINDOW_SCREEN_INTERNAL = 3406;
  public static final int OBSOLETE_WINDOW_SCREEN_PRIMARY = 3407;
  public static final int OBSOLETE_WINDOW_SCREEN_TOUCH_SUPPORT = 3504;
  public static final int OFFLINE_AUDIO_CONTEXT_RESUME = 1033;
  public static final int OFFLINE_AUDIO_CONTEXT_START_RENDERING = 1031;
  public static final int OFFLINE_AUDIO_CONTEXT_SUSPEND = 1032;
  public static final int OFFSCREEN_CANVAS = 1624;
  public static final int OFFSCREEN_CANVAS_2D = 4030;
  public static final int OFFSCREEN_CANVAS_BITMAP_RENDERER = 4033;
  public static final int OFFSCREEN_CANVAS_COMMIT2_D = 1660;
  public static final int OFFSCREEN_CANVAS_COMMIT_WEB_GL = 1661;
  public static final int OFFSCREEN_CANVAS_CONVERT_TO_BLOB = 1834;
  public static final int OFFSCREEN_CANVAS_GET_IMAGE_DATA = 2673;
  public static final int OFFSCREEN_CANVAS_IS_POINT_IN_PATH = 2670;
  public static final int OFFSCREEN_CANVAS_IS_POINT_IN_STROKE = 2671;
  public static final int OFFSCREEN_CANVAS_MEASURE_TEXT = 2672;
  public static final int OFFSCREEN_CANVAS_TRANSFER_TO_IMAGE_BITMAP = 2669;
  public static final int OFFSCREEN_CANVAS_TRANSFER_TO_IMAGE_BITMAP2_D = 1658;
  public static final int OFFSCREEN_CANVAS_TRANSFER_TO_IMAGE_BITMAP_WEB_GL = 1659;
  public static final int OFFSCREEN_CANVAS_WEB_GL = 4031;
  public static final int OFFSCREEN_CANVAS_WEB_GL2 = 4032;
  public static final int OFFSCREEN_CANVAS_WEB_GPU = 4034;
  public static final int OLD_CONSTRAINTS_PARSED = 4197;
  public static final int OPACITY_WITH_PRESERVE3_D_QUIRK = 1376;
  public static final int OPENER_NAVIGATION_DOWNLOAD_CROSS_ORIGIN = 2649;
  public static final int OPENER_NAVIGATION_WITHOUT_GESTURE = 2373;
  public static final int OPEN_SEARCH_INSECURE_ORIGIN_INSECURE_TARGET = 1405;
  public static final int OPEN_SEARCH_INSECURE_ORIGIN_SECURE_TARGET = 1406;
  public static final int OPEN_SEARCH_SECURE_ORIGIN_INSECURE_TARGET = 1407;
  public static final int OPEN_SEARCH_SECURE_ORIGIN_SECURE_TARGET = 1408;
  public static final int OPEN_WEB_DATABASE = 10;
  public static final int OPTION_LABEL_IN_QUIRKS_MODE = 4454;
  public static final int ORIENTATION_SENSOR_POPULATE_MATRIX = 1908;
  public static final int ORIGIN_AGENT_CLUSTER_HEADER = 3286;
  public static final int ORIGIN_CLEAN_IMAGE_BITMAP_SERIALIZATION = 3056;
  public static final int ORIGIN_CLEAN_IMAGE_BITMAP_TRANSFER = 3058;
  public static final int OUT_OF_FLOW_ALIGN_SELF_BOTH_INSETS = 4670;
  public static final int OUT_OF_FLOW_ALIGN_SELF_NO_INSETS = 4668;
  public static final int OUT_OF_FLOW_ALIGN_SELF_SINGLE_INSET = 4669;
  public static final int OUT_OF_FLOW_JUSTIFY_SELF_BOTH_INSETS = 4667;
  public static final int OUT_OF_FLOW_JUSTIFY_SELF_NO_INSETS = 4665;
  public static final int OUT_OF_FLOW_JUSTIFY_SELF_SINGLE_INSET = 4666;
  public static final int OVERFLOW_CLIP_ALONG_EITHER_AXIS = 3803;
  public static final int OVERLAY_POPUP = 3331;
  public static final int OVERLAY_POPUP_AD = 3253;
  public static final int OVERRIDE_FLASH_EMBEDWITH_HTML = 4740;
  public static final int OVERSCROLL_BEHAVIOR_WILL_BE_FIXED = 3916;
  public static final int OVERSROLL_BEHAVIOR_ON_VIEWPORT_BREAKS = 3736;
  public static final int PAGE_FREEZE_OPT_IN = 2928;
  public static final int PAGE_FREEZE_OPT_OUT = 2929;
  public static final int PAGE_LIFE_CYCLE_FREEZE = 2627;
  public static final int PAGE_VISITS = 52;
  public static final int PAINT_TIMING_OBSERVED = 2190;
  public static final int PAINT_TIMING_REQUESTED = 2191;
  public static final int PAINT_WORKLET = 2225;
  public static final int PANNER_NODE_SET_ORIENTATION = 1365;
  public static final int PANNER_NODE_SET_POSITION = 1364;
  public static final int PARENT_OF_DISABLED_FORM_CONTROL_RESPONDS_TO_MOUSE_EVENTS = 4296;
  public static final int PARSE_FROM_STRING = 4462;
  public static final int PARSE_FROM_STRING_INCLUDE_SHADOWS = 4455;
  public static final int PARSE_HTML_UNSAFE = 4687;
  public static final int PARTITIONED_COOKIES = 4177;
  public static final int PASSIVE_TOUCH_EVENT_LISTENER = 2904;
  public static final int PATTERN_ATTRIBUTE = 44;
  public static final int PAYMENT_ADDRESS_LANGUAGE_CODE = 2542;
  public static final int PAYMENT_HANDLER = 2397;
  public static final int PAYMENT_HANDLER_MINIMAL_HEADER_UX = 4479;
  public static final int PAYMENT_HANDLER_STANDARDIZED_PAYMENT_METHOD_IDENTIFIER = 3750;
  public static final int PAYMENT_INSTRUMENTS = 4229;
  public static final int PAYMENT_REQUEST_ACTIVATIONLESS_SHOW = 4607;
  public static final int PAYMENT_REQUEST_BASIC_CARD = 4045;
  public static final int PAYMENT_REQUEST_COMPLETE = 4024;
  public static final int PAYMENT_REQUEST_CSP_VIOLATION = 3871;
  public static final int PAYMENT_REQUEST_INITIALIZED = 2894;
  public static final int PAYMENT_REQUEST_PAYMENT_METHOD_CHANGE = 2898;
  public static final int PAYMENT_REQUEST_RESPONSE = 4023;
  public static final int PAYMENT_REQUEST_SHIPPING_ADDRESS_CHANGE = 2896;
  public static final int PAYMENT_REQUEST_SHIPPING_OPTION_CHANGE = 2897;
  public static final int PAYMENT_REQUEST_SHOW = 2895;
  public static final int PAYMENT_REQUEST_SHOW_WITHOUT_GESTURE = 2398;
  public static final int PAYMENT_REQUEST_SHOW_WITHOUT_GESTURE_OR_TOKEN = 3903;
  public static final int PENDING_STYLESHEET_ADDED_AFTER_BODY_STARTED = 1542;
  public static final int PERCENT_OR_CALC_RELATIVE_USED_OFFSET = 4660;
  public static final int PERCENT_OR_CALC_STICKY_USED_OFFSET = 4659;
  public static final int PERFORMANCE_ENTRY_BUFFER_SWAPS = 4379;
  public static final int PERFORMANCE_EVENT_TIMING_BUFFER = 2468;
  public static final int PERFORMANCE_EVENT_TIMING_CONSTRUCTOR = 2469;
  public static final int PERFORMANCE_FRAME_TIMING = 772;
  public static final int PERFORMANCE_MEASURE_FIND_EXISTING_NAME = 4236;
  public static final int PERFORMANCE_NAVIGATE_SYSTEM_ENTROPY = 4572;
  public static final int PERFORMANCE_OBSERVER_BUFFERED_FLAG = 3004;
  public static final int PERFORMANCE_OBSERVER_ENTRY_TYPES_AND_BUFFERED = 3231;
  public static final int PERFORMANCE_OBSERVER_FOR_WINDOW = 2188;
  public static final int PERFORMANCE_OBSERVER_FOR_WORKER = 2189;
  public static final int PERFORMANCE_OBSERVER_TYPE_ERROR = 3232;
  public static final int PERFORMANCE_RESOURCE_TIMING_INITIATOR_TYPE = 2434;
  public static final int PERFORMANCE_RESOURCE_TIMING_SIZES = 1478;
  public static final int PERFORMANCE_SERVER_TIMING = 2157;
  public static final int PERFORMANCE_TIMELINE = 2429;
  public static final int PERIODIC_BACKGROUND_SYNC = 2930;
  public static final int PERIODIC_BACKGROUND_SYNC_GET_TAGS = 2937;
  public static final int PERIODIC_BACKGROUND_SYNC_REGISTER = 2931;
  public static final int PERIODIC_BACKGROUND_SYNC_UNREGISTER = 2938;
  public static final int PERMISSIONS_POLICY_HEADER = 3850;
  public static final int PERMISSIONS_POLICY_UNLOAD = 4362;
  public static final int PERSISTENT_CLIENT_HINT_HEADER = 2065;
  public static final int PERSISTENT_QUOTA_TYPE = 4315;
  public static final int PHONE_FIELD_FILLED_PREDICTED_TYPE_MATCH = 3381;
  public static final int PICTURE = 521;
  public static final int PICTURE_IN_PICTURE_WINDOW_RESIZE_EVENT_LISTENER = 2449;
  public static final int PICTURE_SOURCE_SRC = 520;
  public static final int PINCH_ZOOM = 2920;
  public static final int PLACEHOLDER_ATTRIBUTE = 45;
  public static final int PLAIN_TEXT_EDITING_EFFECTIVE = 2631;
  public static final int PLUGIN_DESCRIPTION = 3445;
  public static final int PLUGIN_ELEMENT_LOADED_DOCUMENT = 3046;
  public static final int PLUGIN_ELEMENT_LOADED_EXTERNAL = 3048;
  public static final int PLUGIN_ELEMENT_LOADED_IMAGE = 3047;
  public static final int PLUGIN_FILENAME = 3444;
  public static final int PLUGIN_INSTANCE_ACCESS_FROM_ISOLATED_WORLD = 1996;
  public static final int PLUGIN_INSTANCE_ACCESS_FROM_MAIN_WORLD = 1997;
  public static final int PLUGIN_INSTANCE_ACCESS_SUCCESSFUL = 3309;
  public static final int PLUGIN_NAME = 3443;
  public static final int PLURAL_RULES = 2596;
  public static final int POINTER_DOWN_FIRED = 1452;
  public static final int POINTER_DOWN_FIRED_FOR_TOUCH = 1453;
  public static final int POINTER_ENTER_LEAVE_FIRED = 1535;
  public static final int POINTER_EVENT_ADD_LISTENER_COUNT = 1347;
  public static final int POINTER_EVENT_ATTRIBUTE_COUNT = 1321;
  public static final int POINTER_EVENT_CLICK_RETARGET_CAUSED_BY_CAPTURE = 1857;
  public static final int POINTER_EVENT_DISPATCH = 1432;
  public static final int POINTER_EVENT_DISPATCH_POINTER_DOWN = 1454;
  public static final int POINTER_EVENT_SET_CAPTURE = 1431;
  public static final int POINTER_EVENT_SET_CAPTURE_OUTSIDE_DISPATCH = 1806;
  public static final int POINTER_ID = 3866;
  public static final int POINTER_LOCK_UNADJUSTED_MOVEMENT = 3027;
  public static final int POINTER_OVER_OUT_FIRED = 1536;
  public static final int POLYMER_V1_DETECTED = 2466;
  public static final int POLYMER_V2_DETECTED = 2467;
  public static final int POPOVER_TYPE_AUTO = 4464;
  public static final int POPOVER_TYPE_HINT = 4480;
  public static final int POPOVER_TYPE_INVALID = 4466;
  public static final int POPOVER_TYPE_MANUAL = 4465;
  public static final int POPUP_DOES_NOT_EXCEED_OWNER_WINDOW_BOUNDS = 3298;
  public static final int POPUP_EXCEEDS_OWNER_WINDOW_BOUNDS = 3299;
  public static final int POPUP_EXCEEDS_OWNER_WINDOW_BOUNDS_FOR_IFRAME = 3300;
  public static final int POPUP_GESTURE_TAP_EXCEEDS_OWNER_WINDOW_BOUNDS = 3301;
  public static final int POPUP_MOUSE_DOWN_EXCEEDS_OWNER_WINDOW_BOUNDS = 3302;
  public static final int POPUP_MOUSE_WHEEL_EXCEEDS_OWNER_WINDOW_BOUNDS = 3303;
  public static final int POPUP_OPEN_WHILE_FILE_CHOOSER_OPENED = 2509;
  public static final int POSITION_STICKY = 3354;
  public static final int POST_MESSAGE_FROM_INSECURE_TO_INSECURE = 3883;
  public static final int POST_MESSAGE_FROM_INSECURE_TO_SECURE = 420;
  public static final int POST_MESSAGE_FROM_INSECURE_TO_SECURE_TOPLEVEL = 1787;
  public static final int POST_MESSAGE_FROM_SECURE_TO_INSECURE = 419;
  public static final int POST_MESSAGE_FROM_SECURE_TO_SECURE = 3882;
  public static final int POST_MESSAGE_INCOMING_WOULD_BE_BLOCKED_BY_CONNECT_SRC = 1975;
  public static final int POST_MESSAGE_OUTGOING_WOULD_BE_BLOCKED_BY_CONNECT_SRC = 1974;
  public static final int POTENTIALLY_INJECTED_SCRIPT_ELEMENT_WITH_NONCE = 1541;
  public static final int PPAPIURL_REQUEST_STREAM_TO_FILE = 2396;
  public static final int PPAPI_WEB_SOCKET = 2524;
  public static final int PREFERRED_COLOR_SCHEME_DARK = 3580;
  public static final int PREFERRED_COLOR_SCHEME_DARK_SETTING = 3581;
  public static final int PREFERS_COLOR_SCHEME_MEDIA_FEATURE = 3868;
  public static final int PREFERS_CONTRAST_MEDIA_FEATURE = 3869;
  public static final int PREFIXED_AND_UNPREFIXED_ANIMATION_END_EVENT = 130;
  public static final int PREFIXED_AND_UNPREFIXED_ANIMATION_ITERATION_EVENT = 136;
  public static final int PREFIXED_AND_UNPREFIXED_ANIMATION_START_EVENT = 133;
  public static final int PREFIXED_AND_UNPREFIXED_TRANSITION_END_EVENT = 20;
  public static final int PREFIXED_ANIMATION_END_EVENT = 128;
  public static final int PREFIXED_ANIMATION_ITERATION_EVENT = 134;
  public static final int PREFIXED_ANIMATION_START_EVENT = 131;
  public static final int PREFIXED_AUDIO_DECODED_BYTE_COUNT = 164;
  public static final int PREFIXED_CANCEL_ANIMATION_FRAME = 304;
  public static final int PREFIXED_CURSOR_GRAB = 2419;
  public static final int PREFIXED_CURSOR_GRABBING = 2420;
  public static final int PREFIXED_CURSOR_ZOOM_IN = 424;
  public static final int PREFIXED_CURSOR_ZOOM_OUT = 425;
  public static final int PREFIXED_DEVICE_PIXEL_RATIO_MEDIA_FEATURE = 233;
  public static final int PREFIXED_DIRECTORY_ATTRIBUTE = 47;
  public static final int PREFIXED_DOCUMENT_CANCEL_FULL_SCREEN = 321;
  public static final int PREFIXED_DOCUMENT_CURRENT_FULL_SCREEN_ELEMENT = 320;
  public static final int PREFIXED_DOCUMENT_EXIT_FULLSCREEN = 324;
  public static final int PREFIXED_DOCUMENT_FULLSCREEN_ELEMENT = 323;
  public static final int PREFIXED_DOCUMENT_FULLSCREEN_ENABLED = 322;
  public static final int PREFIXED_DOCUMENT_IS_FULLSCREEN = 318;
  public static final int PREFIXED_ELEMENT_REQUEST_FULLSCREEN = 176;
  public static final int PREFIXED_ELEMENT_REQUEST_FULLSCREEN_IN_SHADOW = 1427;
  public static final int PREFIXED_ELEMENT_REQUEST_FULL_SCREEN = 177;
  public static final int PREFIXED_FILE_RELATIVE_PATH = 386;
  public static final int PREFIXED_MAX_DEVICE_PIXEL_RATIO_MEDIA_FEATURE = 234;
  public static final int PREFIXED_MIN_DEVICE_PIXEL_RATIO_MEDIA_FEATURE = 235;
  public static final int PREFIXED_MUTATION_OBSERVER_CONSTRUCTOR = 362;
  public static final int PREFIXED_PAGE_VISIBILITY = 196;
  public static final int PREFIXED_REQUEST_ANIMATION_FRAME = 14;
  public static final int PREFIXED_STORAGE_INFO_THIRD_PARTY_CONTEXT = 3880;
  public static final int PREFIXED_STORAGE_QUOTA = 240;
  public static final int PREFIXED_STORAGE_QUOTA_THIRD_PARTY_CONTEXT = 3878;
  public static final int PREFIXED_TRANSFORM3D_MEDIA_FEATURE = 237;
  public static final int PREFIXED_TRANSITION_END_EVENT = 18;
  public static final int PREFIXED_TRANSITION_EVENT_CONSTRUCTOR = 361;
  public static final int PREFIXED_VIDEO_DECODED_BYTE_COUNT = 165;
  public static final int PREFIXED_VIDEO_DECODED_FRAME_COUNT = 172;
  public static final int PREFIXED_VIDEO_DISPLAYING_FULLSCREEN = 167;
  public static final int PREFIXED_VIDEO_DROPPED_FRAME_COUNT = 173;
  public static final int PREFIXED_VIDEO_ENTER_FULLSCREEN = 168;
  public static final int PREFIXED_VIDEO_ENTER_FULL_SCREEN = 170;
  public static final int PREFIXED_VIDEO_EXIT_FULLSCREEN = 169;
  public static final int PREFIXED_VIDEO_EXIT_FULL_SCREEN = 171;
  public static final int PREFIXED_VIDEO_SUPPORTS_FULLSCREEN = 166;
  public static final int PREPARE_MODULE_SCRIPT = 2062;
  public static final int PRESENTATION_AVAILABILITY_CHANGE_EVENT_LISTENER = 927;
  public static final int PRESENTATION_CONNECTION_CLOSE = 1038;
  public static final int PRESENTATION_CONNECTION_CLOSE_EVENT_LISTENER = 1158;
  public static final int PRESENTATION_CONNECTION_CONNECT_EVENT_LISTENER = 1157;
  public static final int PRESENTATION_CONNECTION_LIST_CONNECTION_AVAILABLE_EVENT_LISTENER = 1555;
  public static final int PRESENTATION_CONNECTION_MESSAGE_EVENT_LISTENER = 936;
  public static final int PRESENTATION_CONNECTION_SEND = 934;
  public static final int PRESENTATION_CONNECTION_TERMINATE = 933;
  public static final int PRESENTATION_CONNECTION_TERMINATE_EVENT_LISTENER = 1159;
  public static final int PRESENTATION_DEFAULT_REQUEST = 926;
  public static final int PRESENTATION_REQUEST_CONNECTION_AVAILABLE_EVENT_LISTENER = 932;
  public static final int PRESENTATION_REQUEST_CONSTRUCTOR = 928;
  public static final int PRESENTATION_REQUEST_GET_AVAILABILITY = 931;
  public static final int PRESENTATION_REQUEST_RECONNECT = 930;
  public static final int PRESENTATION_REQUEST_START = 929;
  public static final int PRESENTATION_REQUEST_START_INSECURE_ORIGIN = 2064;
  public static final int PRESENTATION_REQUEST_START_SECURE_ORIGIN = 2063;
  public static final int PRESSURE_OBSERVER_CONSTRUCTOR = 3899;
  public static final int PRESSURE_OBSERVER_DISCONNECT = 4185;
  public static final int PRESSURE_OBSERVER_OBSERVE = 3900;
  public static final int PRESSURE_OBSERVER_TAKE_RECORDS = 4186;
  public static final int PRESSURE_OBSERVER_UNOBSERVE = 4184;
  public static final int PRICE_CHANGE_CONFIRMATION = 4606;
  public static final int PRIORITY_HINTS = 2738;
  public static final int PRIVACY_SANDBOX_ADS_AP_IS = 4187;
  public static final int PRIVATE_AGGREGATION_API_ALL = 4333;
  public static final int PRIVATE_AGGREGATION_API_ENABLE_DEBUG_MODE = 4656;
  public static final int PRIVATE_AGGREGATION_API_FLEDGE = 4334;
  public static final int PRIVATE_AGGREGATION_API_FLEDGE_EXTENSIONS = 4487;
  public static final int PRIVATE_AGGREGATION_API_SHARED_STORAGE = 4335;
  public static final int PRIVATE_NETWORK_ACCESS_FETCHED_SUB_FRAME = 4442;
  public static final int PRIVATE_NETWORK_ACCESS_FETCHED_TOP_FRAME = 4443;
  public static final int PRIVATE_NETWORK_ACCESS_FETCHED_WORKER_SCRIPT = 4145;
  public static final int PRIVATE_NETWORK_ACCESS_IGNORED_CROSS_ORIGIN_PREFLIGHT_ERROR = 4431;
  public static final int PRIVATE_NETWORK_ACCESS_IGNORED_CROSS_SITE_PREFLIGHT_ERROR = 4432;
  public static final int PRIVATE_NETWORK_ACCESS_NON_SECURE_CONTEXTS_ALLOWED_DEPRECATION_TRIAL =
      3958;
  public static final int PRIVATE_NETWORK_ACCESS_NULL_IP_ADDRESS = 4203;
  public static final int PRIVATE_NETWORK_ACCESS_PERMISSION_PROMPT = 4293;
  public static final int PRIVATE_NETWORK_ACCESS_PREFLIGHT_ERROR = 4530;
  public static final int PRIVATE_NETWORK_ACCESS_PREFLIGHT_SUCCESS = 4531;
  public static final int PRIVATE_NETWORK_ACCESS_PREFLIGHT_WARNING = 4532;
  public static final int PRIVATE_NETWORK_ACCESS_WITHIN_WORKER = 4150;
  public static final int PROGRESS_ELEMENT = 484;
  public static final int PROGRESS_ELEMENT_HORIZONTAL_LTR = 4853;
  public static final int PROGRESS_ELEMENT_HORIZONTAL_RTL = 4854;
  public static final int PROGRESS_ELEMENT_VERTICAL_LTR = 4855;
  public static final int PROGRESS_ELEMENT_VERTICAL_RTL = 4856;
  public static final int PROGRESS_ELEMENT_WITH_NONE_APPEARANCE = 1345;
  public static final int PROGRESS_ELEMENT_WITH_PROGRESS_BAR_APPEARANCE = 1346;
  public static final int PROMPT_ENGAGEMENT_HIGH = 1747;
  public static final int PROMPT_ENGAGEMENT_LOW = 1745;
  public static final int PROMPT_ENGAGEMENT_MAX = 1748;
  public static final int PROMPT_ENGAGEMENT_MEDIUM = 1746;
  public static final int PROMPT_ENGAGEMENT_MINIMAL = 1744;
  public static final int PROMPT_ENGAGEMENT_NONE = 1743;
  public static final int PSEUDO_BEFORE_AFTER_FOR_DATE_TIME_INPUT_ELEMENT = 4294;
  public static final int PSEUDO_BEFORE_AFTER_FOR_INPUT_ELEMENT = 897;
  public static final int PSEUDO_FIRST_LETTER_ON_RT = 4748;
  public static final int PSEUDO_FIRST_LINE_ON_RT = 4749;
  public static final int QUIC_TRANSPORT = 3184;
  public static final int QUIC_TRANSPORT_DATAGRAM_APIS = 3186;
  public static final int QUIC_TRANSPORT_STREAM_APIS = 3185;
  public static final int QUIRKS_MODE_ABOUT_BLANK_DOCUMENT = 4614;
  public static final int QUIRKS_MODE_DOCUMENT = 2034;
  public static final int QUIRKY_LINE_BOX_BACKGROUND_SIZE = 2730;
  public static final int QUOTA_READ = 3029;
  public static final int QUOTED_ANIMATION_NAME = 571;
  public static final int QUOTED_KEYFRAMES_RULE = 572;
  public static final int RANGE_DETACH = 372;
  public static final int RANGE_EXPAND = 393;
  public static final int READABLE_STREAM_BYOB_READER = 3744;
  public static final int READABLE_STREAM_CONSTRUCTOR = 2399;
  public static final int READABLE_STREAM_GET_READER = 2841;
  public static final int READABLE_STREAM_PIPE_THROUGH = 2842;
  public static final int READABLE_STREAM_PIPE_TO = 2843;
  public static final int READABLE_STREAM_WITH_BYTE_SOURCE = 3743;
  public static final int READING_CHECKED_IN_CLICK_HANDLER = 938;
  public static final int READ_OR_WRITE_WEB_DATABASE = 4061;
  public static final int REDUCE_ACCEPT_LANGUAGE = 4386;
  public static final int REFERRER_POLICY_HEADER = 1753;
  public static final int REFLECTION = 55;
  public static final int REFRESH_HEADER = 2832;
  public static final int REGION_CAPTURE = 4055;
  public static final int REGISTER_PROTOCOL_HANDLER_CROSS_ORIGIN_SUBFRAME = 3093;
  public static final int REGISTER_PROTOCOL_HANDLER_INSECURE_ORIGIN = 1410;
  public static final int REGISTER_PROTOCOL_HANDLER_SAME_ORIGIN_AS_TOP = 3092;
  public static final int REGISTER_PROTOCOL_HANDLER_SECURE_ORIGIN = 1409;
  public static final int RELATIVE_ORIENTATION_SENSOR_CONSTRUCTOR = 2019;
  public static final int RELATIVE_TIME_FORMAT = 2597;
  public static final int RENDER_RUBY = 576;
  public static final int RENDER_SUBTREE_ATTRIBUTE = 3049;
  public static final int REPLACED_ELEMENT_PAINTED_WITH_LARGE_OVERFLOW = 4329;
  public static final int REPLACED_ELEMENT_PAINTED_WITH_OVERFLOW = 4311;
  public static final int REPLACE_CHARSET_IN_XHR = 2230;
  public static final int REPLACE_CHARSET_IN_XHR_IGNORING_CASE = 2362;
  public static final int REPLACE_DOCUMENT_VIA_JAVA_SCRIPT_URL = 215;
  public static final int REPORTING_OBSERVER = 2529;
  public static final int REPORT_URI_MULTIPLE_ENDPOINTS = 2052;
  public static final int REPORT_URI_SINGLE_ENDPOINT = 2053;
  public static final int REQUESTED_FILE_SYSTEM_PERSISTENT = 2997;
  public static final int REQUESTED_FILE_SYSTEM_PERSISTENT_THIRD_PARTY_CONTEXT = 3879;
  public static final int REQUESTED_FILE_SYSTEM_TEMPORARY = 2996;
  public static final int REQUESTED_SUBRESOURCE_WITH_EMBEDDED_CREDENTIALS = 532;
  public static final int REQUEST_FILE_SYSTEM = 508;
  public static final int REQUEST_FILE_SYSTEM_NON_WEBBY_ORIGIN = 876;
  public static final int REQUEST_FILE_SYSTEM_SYNC_WORKER = 510;
  public static final int REQUEST_FILE_SYSTEM_WORKER = 509;
  public static final int REQUEST_IS_HISTORY_NAVIGATION = 2517;
  public static final int REQUEST_MIDI_ACCESS_IFRAME_OBSCURED_BY_FOOTPRINTING = 1143;
  public static final int REQUEST_MIDI_ACCESS_IFRAME_WITH_SYS_EX_OPTION_OBSCURED_BY_FOOTPRINTING =
      1963;
  public static final int REQUEST_MIDI_ACCESS_OBSCURED_BY_FOOTPRINTING = 857;
  public static final int REQUEST_MIDI_ACCESS_WITH_SYS_EX_OPTION_OBSCURED_BY_FOOTPRINTING = 1962;
  public static final int REQUIRED_ATTRIBUTE = 49;
  public static final int REQUIRED_DOCUMENT_POLICY = 3230;
  public static final int REQUIRE_DOCUMENT_POLICY_HEADER = 3227;
  public static final int RESET_REFERRER_POLICY = 243;
  public static final int RESIZE_OBSERVER_CONSTRUCTOR = 2592;
  public static final int RESOURCE_TIMING = 3350;
  public static final int RESOURCE_TIMING_TAINTED_ORIGIN_FLAG_FAIL = 3091;
  public static final int REVERSE_ITERATE_DOM_STORAGE = 2470;
  public static final int RTCP_MUX_POLICY_NEGOTIATE = 1823;
  public static final int RTC_ADAPTIVE_PTIME = 3347;
  public static final int RTC_CONFIGURATION_ICE_TRANSPORTS = 1664;
  public static final int RTC_CONFIGURATION_ICE_TRANSPORT_POLICY = 1662;
  public static final int RTC_CONSTRAINT_ENABLE_DTLS_SRTP_FALSE = 2383;
  public static final int RTC_CONSTRAINT_ENABLE_DTLS_SRTP_TRUE = 2382;
  public static final int RTC_DATA_CHANNEL_INIT_MAX_RETRANSMIT_TIME = 2478;
  public static final int RTC_ICE_CANDIDATE_ADDRESS = 3437;
  public static final int RTC_ICE_CANDIDATE_CANDIDATE = 3438;
  public static final int RTC_ICE_CANDIDATE_DEFAULT_SDP_M_LINE_INDEX = 1386;
  public static final int RTC_ICE_CANDIDATE_PORT = 3439;
  public static final int RTC_ICE_CANDIDATE_RELATED_ADDRESS = 3440;
  public static final int RTC_ICE_CANDIDATE_RELATED_PORT = 3441;
  public static final int RTC_ICE_SERVER_URL = 1656;
  public static final int RTC_ICE_SERVER_UR_LS = 1657;
  public static final int RTC_LEGACY_RTP_DATA_CHANNEL_NEGOTIATED = 3410;
  public static final int RTC_LOCAL_SDP_MODIFICATION = 2393;
  public static final int RTC_LOCAL_SDP_MODIFICATION_ICE_UFRAG_PWD = 4106;
  public static final int RTC_LOCAL_SDP_MODIFICATION_OPUS_STEREO = 4193;
  public static final int RTC_LOCAL_SDP_MODIFICATION_SIMULCAST = 3159;
  public static final int RTC_MAX_AUDIO_BUFFER_SIZE = 2637;
  public static final int RTC_OFFER_ANSWER_OPTIONS_VOICE_ACTIVITY_DETECTION = 3909;
  public static final int RTC_PEER_CONNECTION_ADD_ICE_CANDIDATE_LEGACY = 1385;
  public static final int RTC_PEER_CONNECTION_ADD_ICE_CANDIDATE_PROMISE = 1384;
  public static final int RTC_PEER_CONNECTION_CONSTRUCTOR_COMPLIANT = 1042;
  public static final int RTC_PEER_CONNECTION_CONSTRUCTOR_CONSTRAINTS = 1041;
  public static final int RTC_PEER_CONNECTION_CREATE_ANSWER = 3454;
  public static final int RTC_PEER_CONNECTION_CREATE_ANSWER_LEGACY_COMPLIANT = 1051;
  public static final int RTC_PEER_CONNECTION_CREATE_ANSWER_LEGACY_FAILURE_CALLBACK = 1049;
  public static final int RTC_PEER_CONNECTION_CREATE_ANSWER_PROMISE = 3450;
  public static final int RTC_PEER_CONNECTION_CREATE_DATA_CHANNEL_MAX_PACKET_LIFE_TIME = 2479;
  public static final int RTC_PEER_CONNECTION_CREATE_DATA_CHANNEL_MAX_RETRANSMITS = 1649;
  public static final int RTC_PEER_CONNECTION_CREATE_DATA_CHANNEL_MAX_RETRANSMIT_TIME = 1648;
  public static final int RTC_PEER_CONNECTION_CREATE_OFFER = 3453;
  public static final int RTC_PEER_CONNECTION_CREATE_OFFER_LEGACY_COMPLIANT = 1047;
  public static final int RTC_PEER_CONNECTION_CREATE_OFFER_LEGACY_CONSTRAINTS = 1045;
  public static final int RTC_PEER_CONNECTION_CREATE_OFFER_LEGACY_FAILURE_CALLBACK = 1044;
  public static final int RTC_PEER_CONNECTION_CREATE_OFFER_OPTIONS_OFFER_TO_RECEIVE = 1553;
  public static final int RTC_PEER_CONNECTION_CREATE_OFFER_PROMISE = 3449;
  public static final int RTC_PEER_CONNECTION_GET_STATS = 1476;
  public static final int RTC_PEER_CONNECTION_GET_STATS_LEGACY_NON_COMPLIANT = 1058;
  public static final int RTC_PEER_CONNECTION_LEGACY_GET_STATS_TRIAL = 4482;
  public static final int RTC_PEER_CONNECTION_OFFER_ALLOW_EXTMAP_MIXED_FALSE = 3885;
  public static final int RTC_PEER_CONNECTION_SET_LOCAL_DESCRIPTION = 3452;
  public static final int RTC_PEER_CONNECTION_SET_LOCAL_DESCRIPTION_LEGACY_COMPLIANT = 1054;
  public static final int RTC_PEER_CONNECTION_SET_LOCAL_DESCRIPTION_LEGACY_NO_FAILURE_CALLBACK =
      1053;
  public static final int RTC_PEER_CONNECTION_SET_LOCAL_DESCRIPTION_LEGACY_NO_SUCCESS_CALLBACK =
      1052;
  public static final int RTC_PEER_CONNECTION_SET_LOCAL_DESCRIPTION_PROMISE = 3448;
  public static final int RTC_PEER_CONNECTION_SET_REMOTE_DESCRIPTION = 3451;
  public static final int RTC_PEER_CONNECTION_SET_REMOTE_DESCRIPTION_LEGACY_COMPLIANT = 1057;
  public static final int RTC_PEER_CONNECTION_SET_REMOTE_DESCRIPTION_LEGACY_NO_FAILURE_CALLBACK =
      1056;
  public static final int RTC_PEER_CONNECTION_SET_REMOTE_DESCRIPTION_LEGACY_NO_SUCCESS_CALLBACK =
      1055;
  public static final int RTC_PEER_CONNECTION_SET_REMOTE_DESCRIPTION_PROMISE = 3447;
  public static final int RTC_PEER_CONNECTION_WITH_ACTIVE_CSP = 2346;
  public static final int RTC_PEER_CONNECTION_WITH_BLOCKING_CSP = 3948;
  public static final int RTC_SESSION_DESCRIPTION_INIT_NO_SDP = 1678;
  public static final int RTC_SESSION_DESCRIPTION_INIT_NO_TYPE = 1677;
  public static final int RTC_STATS_RELATIVE_PACKET_ARRIVAL_DELAY = 2827;
  public static final int RUBY_ELEMENT_WITH_DISPLAY_BLOCK = 3282;
  public static final int RUBY_ELEMENT_WITH_DISPLAY_BLOCK_AND_RT = 4708;
  public static final int RUBY_TEXT_WITH_NON_DEFAULT_TEXT_ALIGN = 3313;
  public static final int RUN_AD_AUCTION = 4075;
  public static final int SAME_DOCUMENT_CROSS_ORIGIN_INITIATOR = 4452;
  public static final int SAME_ORIGIN_APPLICATION_OCTET_STREAM = 2167;
  public static final int SAME_ORIGIN_APPLICATION_SCRIPT = 1067;
  public static final int SAME_ORIGIN_APPLICATION_XML = 2168;
  public static final int SAME_ORIGIN_DOCUMENTS_WITH_DIFFERENT_COOP_STATUS = 3876;
  public static final int SAME_ORIGIN_IFRAME_WINDOW_ALERT = 3151;
  public static final int SAME_ORIGIN_IFRAME_WINDOW_CONFIRM = 3152;
  public static final int SAME_ORIGIN_IFRAME_WINDOW_PRINT = 3154;
  public static final int SAME_ORIGIN_IFRAME_WINDOW_PROMPT = 3153;
  public static final int SAME_ORIGIN_JSON_TYPE_FOR_SCRIPT = 3737;
  public static final int SAME_ORIGIN_OTHER_SCRIPT = 1068;
  public static final int SAME_ORIGIN_STRICT_NOSNIFF_WOULD_BLOCK = 3739;
  public static final int SAME_ORIGIN_TEXT_HTML = 2169;
  public static final int SAME_ORIGIN_TEXT_PLAIN = 2170;
  public static final int SAME_ORIGIN_TEXT_SCRIPT = 1066;
  public static final int SAME_ORIGIN_TEXT_XML = 2171;
  public static final int SAME_PARTY_COOKIE_ATTRIBUTE = 3746;
  public static final int SAME_PARTY_COOKIE_EXCLUSION_OVERRULED_SAME_SITE = 3747;
  public static final int SAME_PARTY_COOKIE_INCLUSION_OVERRULED_SAME_SITE = 3748;
  public static final int SAME_SITE_COOKIE_INCLUSION_CHANGED_BY_CROSS_SITE_REDIRECT = 3962;
  public static final int SAME_SITE_NONE_INCLUDED_BY_SAME_PARTY_ANCESTORS = 3955;
  public static final int SAME_SITE_NONE_INCLUDED_BY_SAME_PARTY_TOP_RESOURCE = 3954;
  public static final int SAME_SITE_NONE_INCLUDED_BY_SAME_SITE_LAX = 3956;
  public static final int SAME_SITE_NONE_INCLUDED_BY_SAME_SITE_STRICT = 3957;
  public static final int SAME_SITE_NONE_REQUIRED = 3953;
  public static final int SANDBOX_BACK_FORWARD_AFFECTS_FRAMES_OUTSIDE_SUBTREE = 2837;
  public static final int SANDBOX_BACK_FORWARD_STAYS_WITHIN_SUBTREE = 2836;
  public static final int SANDBOX_INEFFECTIVE_ALLOW_ORIGIN_ALLOW_SCRIPT = 4373;
  public static final int SANDBOX_VIA_CSP = 673;
  public static final int SANDBOX_VIA_FENCED_FRAME = 4541;
  public static final int SANDBOX_VIA_I_FRAME = 672;
  public static final int SANITIZER_API_ACTION_TAKEN = 3818;
  public static final int SANITIZER_API_CREATED = 3814;
  public static final int SANITIZER_API_DEFAULT_CONFIGURATION = 3815;
  public static final int SANITIZER_API_ELEMENT_SET_SANITIZED = 3950;
  public static final int SANITIZER_API_FROM_DOCUMENT = 3820;
  public static final int SANITIZER_API_FROM_FRAGMENT = 3821;
  public static final int SANITIZER_API_FROM_STRING = 3819;
  public static final int SANITIZER_API_GET_CONFIG = 3897;
  public static final int SANITIZER_API_GET_DEFAULT_CONFIG = 3898;
  public static final int SANITIZER_API_SANITIZE_FOR = 3949;
  public static final int SANITIZER_API_TO_FRAGMENT = 3817;
  public static final int SCHEDULED_ACTION_IGNORED = 1849;
  public static final int SCHEDULER_POST_TASK = 3145;
  public static final int SCHEDULER_YIELD = 4521;
  public static final int SCHEDULING_IS_INPUT_PENDING = 2794;
  public static final int SCHEMEFUL_SAME_SITE_CONTEXT_DOWNGRADE = 3285;
  public static final int SCHEMEFUL_SAME_SITE_POST_MESSAGE = 3413;
  public static final int SCHEMELESSLY_SAME_SITE_POST_MESSAGE = 3412;
  public static final int SCHEMELESSLY_SAME_SITE_POST_MESSAGE_INSECURE_TO_SECURE = 3416;
  public static final int SCHEMELESSLY_SAME_SITE_POST_MESSAGE_SECURE_TO_INSECURE = 3415;
  public static final int SCHEME_BYPASSES_CSP = 2165;
  public static final int SCREEN_ORIENTATION_ANGLE = 557;
  public static final int SCREEN_ORIENTATION_LOCK = 559;
  public static final int SCREEN_ORIENTATION_TYPE = 558;
  public static final int SCREEN_ORIENTATION_UNLOCK = 560;
  public static final int SCRIPT_ELEMENT_WITH_INVALID_TYPE_HAS_SRC = 578;
  public static final int SCRIPT_PASSES_CSP_DYNAMIC = 1275;
  public static final int SCRIPT_SCHEDULING_TYPE_ASYNC = 4242;
  public static final int SCRIPT_SCHEDULING_TYPE_DEFER = 4238;
  public static final int SCRIPT_SCHEDULING_TYPE_IN_ORDER = 4241;
  public static final int SCRIPT_SCHEDULING_TYPE_PARSER_BLOCKING = 4239;
  public static final int SCRIPT_SCHEDULING_TYPE_PARSER_BLOCKING_INLINE = 4240;
  public static final int SCRIPT_WEB_BUNDLE = 4074;
  public static final int SCRIPT_WITH_CSP_BYPASSING_SCHEME_NOT_PARSER_INSERTED = 1667;
  public static final int SCRIPT_WITH_CSP_BYPASSING_SCHEME_PARSER_INSERTED = 1666;
  public static final int SCROLLBAR_USE_HORIZONTAL_SCROLLBAR_BUTTON = 1780;
  public static final int SCROLLBAR_USE_HORIZONTAL_SCROLLBAR_TRACK = 1782;
  public static final int SCROLLBAR_USE_SCROLLBAR_BUTTON_REVERSED_DIRECTION = 3037;
  public static final int SCROLLBAR_USE_VERTICAL_SCROLLBAR_BUTTON = 1777;
  public static final int SCROLLBAR_USE_VERTICAL_SCROLLBAR_TRACK = 1779;
  public static final int SCROLLEND = 4419;
  public static final int SCROLL_ANCHORED = 1278;
  public static final int SCROLL_BY_KEYBOARD_ARROW_KEYS = 1843;
  public static final int SCROLL_BY_KEYBOARD_HOME_END_KEYS = 1845;
  public static final int SCROLL_BY_KEYBOARD_PAGE_UP_DOWN_KEYS = 1844;
  public static final int SCROLL_BY_KEYBOARD_SPACEBAR_KEY = 1846;
  public static final int SCROLL_BY_PRECISION_TOUCH_PAD = 2919;
  public static final int SCROLL_BY_TOUCH = 1847;
  public static final int SCROLL_BY_WHEEL = 1848;
  public static final int SCROLL_SNAP_CAUSES_SCROLL_ON_INITIAL_LAYOUT = 3115;
  public static final int SCROLL_SNAP_COVERING_SNAP_AREA = 4644;
  public static final int SCROLL_SNAP_NESTED_SNAP_AREAS = 4643;
  public static final int SCROLL_TIMELINE_CONSTRUCTOR = 2367;
  public static final int SEARCH_EVENT_FIRED = 2833;
  public static final int SECURE_CONTEXT_CHECK_FAILED = 1442;
  public static final int SECURE_CONTEXT_CHECK_FOR_SANDBOXED_ORIGIN_FAILED = 1444;
  public static final int SECURE_CONTEXT_CHECK_FOR_SANDBOXED_ORIGIN_PASSED = 1443;
  public static final int SECURE_CONTEXT_CHECK_PASSED = 1441;
  public static final int SECURE_CONTEXT_INCORRECT_FOR_SHARED_WORKER = 4178;
  public static final int SECURE_CONTEXT_INCORRECT_FOR_WORKER = 4103;
  public static final int SECURE_PAYMENT_CONFIRMATION = 3376;
  public static final int SECURE_PAYMENT_CONFIRMATION_ACTIVATIONLESS_SHOW = 4547;
  public static final int SECURE_PAYMENT_CONFIRMATION_OPT_OUT = 4257;
  public static final int SEGMENTER = 2600;
  public static final int SELECTION_ADD_RANGE = 1004;
  public static final int SELECTION_ANCHOR_NODE = 997;
  public static final int SELECTION_ANCHOR_OFFSET = 998;
  public static final int SELECTION_BACKGROUND_COLOR_INVERSION = 3934;
  public static final int SELECTION_BASE_NODE = 400;
  public static final int SELECTION_BASE_OFFSET = 401;
  public static final int SELECTION_COLLAPSE = 1006;
  public static final int SELECTION_COLLAPSE_NULL = 1083;
  public static final int SELECTION_COLLAPSE_TO_END = 1008;
  public static final int SELECTION_COLLAPSE_TO_START = 1007;
  public static final int SELECTION_CONTAINS_NODE = 525;
  public static final int SELECTION_DELETE_DROM_DOCUMENT = 1011;
  public static final int SELECTION_DOM_STRING = 1012;
  public static final int SELECTION_EMPTY = 407;
  public static final int SELECTION_EXTEND = 1009;
  public static final int SELECTION_EXTENT_NODE = 402;
  public static final int SELECTION_EXTENT_OFFSET = 403;
  public static final int SELECTION_FOCUS_NODE = 999;
  public static final int SELECTION_FOCUS_OFFSET = 1000;
  public static final int SELECTION_FUNCIONS_CHANGE_FOCUS = 1837;
  public static final int SELECTION_GET_RANGE_AT = 1003;
  public static final int SELECTION_IS_COLLAPSED = 1001;
  public static final int SELECTION_MODIFY = 405;
  public static final int SELECTION_RANGE_COUNT = 1002;
  public static final int SELECTION_REMOVE_ALL_RANGES = 1005;
  public static final int SELECTION_SELECT_ALL_CHILDREN = 1010;
  public static final int SELECTION_SET_BASE_AND_EXTENT = 406;
  public static final int SELECTION_SET_BASE_AND_EXTENT_NULL = 1084;
  public static final int SELECTION_SET_POSITION = 327;
  public static final int SELECTION_TO_STRING_WITH_SHADOW_TREE = 861;
  public static final int SELECTION_TYPE = 404;
  public static final int SELECTIVE_IN_ORDER_SCRIPT = 4353;
  public static final int SELECT_ELEMENT_MULTIPLE = 2857;
  public static final int SELECT_ELEMENT_SINGLE = 2856;
  public static final int SELECT_LIST_ELEMENT = 3811;
  public static final int SELECT_PARSER_DROPPED_TAG = 4844;
  public static final int SEND_BEACON = 494;
  public static final int SEND_BEACON_QUOTA_EXCEEDED = 495;
  public static final int SEND_BEACON_WITH_ARRAY_BUFFER = 4305;
  public static final int SEND_BEACON_WITH_ARRAY_BUFFER_VIEW = 4306;
  public static final int SEND_BEACON_WITH_BLOB = 4307;
  public static final int SEND_BEACON_WITH_FORM_DATA = 4308;
  public static final int SEND_BEACON_WITH_URL_SEARCH_PARAMS = 4309;
  public static final int SEND_BEACON_WITH_USV_STRING = 4310;
  public static final int SERIAL_GET_PORTS = 2545;
  public static final int SERIAL_PORT_CLOSE = 2548;
  public static final int SERIAL_PORT_FORGET = 4215;
  public static final int SERIAL_PORT_GET_INFO = 3338;
  public static final int SERIAL_PORT_OPEN = 2547;
  public static final int SERIAL_REQUEST_PORT = 2546;
  public static final int SERIVCE_WORKER_FALLBACK_MAIN_RESOURCE = 4369;
  public static final int SERVICE_WORKER_BYPASS_FETCH_HANDLER_FOR_ALL_WITH_RACE_NETWORK_REQUEST =
      4548;
  public static final int
      SERVICE_WORKER_BYPASS_FETCH_HANDLER_FOR_ALL_WITH_RACE_NETWORK_REQUEST_BY_ORIGIN_TRIAL = 4559;
  public static final int SERVICE_WORKER_BYPASS_FETCH_HANDLER_FOR_MAIN_RESOURCE = 4410;
  public static final int SERVICE_WORKER_BYPASS_FETCH_HANDLER_FOR_MAIN_RESOURCE_BY_ORIGIN_TRIAL =
      4457;
  public static final int SERVICE_WORKER_BYPASS_FETCH_HANDLER_FOR_SUB_RESOURCE = 4485;
  public static final int SERVICE_WORKER_CLIENT_FRAME_TYPE = 2033;
  public static final int SERVICE_WORKER_CONTROLLED_PAGE = 990;
  public static final int SERVICE_WORKER_EVENT_HANDLER_ADDED_AFTER_INITIALIZATION = 4468;
  public static final int SERVICE_WORKER_EVENT_HANDLER_MODIFIED_AFTER_INITIALIZATION = 4469;
  public static final int SERVICE_WORKER_FETCH_HANDLER_ADDED_AFTER_INITIALIZATION = 4445;
  public static final int SERVICE_WORKER_FETCH_HANDLER_MODIFIED_AFTER_INITIALIZATION = 4453;
  public static final int SERVICE_WORKER_IMPORT_SCRIPT_NOT_INSTALLED = 2498;
  public static final int SERVICE_WORKER_INTERCEPTED_REQUEST_FROM_ORIGIN_DIRTY_STYLE_SHEET = 2941;
  public static final int SERVICE_WORKER_NAVIGATION_PRELOAD = 1803;
  public static final int SERVICE_WORKER_RESPOND_TO_NAVIGATION_REQUEST_WITH_REDIRECTED_RESPONSE =
      1697;
  public static final int SERVICE_WORKER_SKIPPED_FOR_EMPTY_FETCH_HANDLER = 4412;
  public static final int SERVICE_WORKER_SKIPPED_FOR_SUBRESOURCE_LOAD = 4363;
  public static final int SERVICE_WORKER_STATIC_ROUTER_ADD_ROUTES = 4711;
  public static final int SERVICE_WORKER_STATIC_ROUTER_EVALUATE = 4590;
  public static final int SERVICE_WORKER_STATIC_ROUTER_REGISTER_ROUTER = 4589;
  public static final int SET_HTML_UNSAFE = 4688;
  public static final int SET_REFERRER_POLICY = 593;
  public static final int SHADOW_ROOT_DELEGATES_FOCUS = 1308;
  public static final int SHADOW_ROOT_POINTER_LOCK_ELEMENT = 1422;
  public static final int SHAPE_OUTSIDE_BORDER_BOX = 2427;
  public static final int SHAPE_OUTSIDE_CONTENT_BOX = 2425;
  public static final int SHAPE_OUTSIDE_CONTENT_BOX_DIFFERENT_FROM_MARGIN_BOX = 2461;
  public static final int SHAPE_OUTSIDE_MARGIN_BOX = 2428;
  public static final int SHAPE_OUTSIDE_MAYBE_AFFECTED_INLINE_POSITION = 2206;
  public static final int SHAPE_OUTSIDE_MAYBE_AFFECTED_INLINE_SIZE = 2205;
  public static final int SHAPE_OUTSIDE_PADDING_BOX = 2426;
  public static final int SHAPE_OUTSIDE_PADDING_BOX_DIFFERENT_FROM_MARGIN_BOX = 2462;
  public static final int SHARED_DICTIONARY_USED = 4601;
  public static final int SHARED_DICTIONARY_USED_FOR_MAIN_FRAME_NAVIGATION = 4603;
  public static final int SHARED_DICTIONARY_USED_FOR_NAVIGATION = 4602;
  public static final int SHARED_DICTIONARY_USED_FOR_SUBRESOURCE = 4605;
  public static final int SHARED_DICTIONARY_USED_FOR_SUB_FRAME_NAVIGATION = 4604;
  public static final int SHARED_DICTIONARY_USED_WITH_SHARED_BROTLI = 4627;
  public static final int SHARED_DICTIONARY_USED_WITH_SHARED_ZSTD = 4628;
  public static final int SHARED_STORAGE_API_ADD_MODULE_METHOD = 4264;
  public static final int SHARED_STORAGE_API_APPEND_METHOD = 4266;
  public static final int SHARED_STORAGE_API_CLEAR_METHOD = 4268;
  public static final int SHARED_STORAGE_API_CREATE_WORKLET_METHOD = 4836;
  public static final int SHARED_STORAGE_API_DELETE_METHOD = 4267;
  public static final int SHARED_STORAGE_API_FETCH_ATTRIBUTE = 4637;
  public static final int SHARED_STORAGE_API_IFRAME_ATTRIBUTE = 4639;
  public static final int SHARED_STORAGE_API_IMAGE_ATTRIBUTE = 4638;
  public static final int SHARED_STORAGE_API_RUN_METHOD = 4270;
  public static final int SHARED_STORAGE_API_SELECT_URL_METHOD = 4269;
  public static final int SHARED_STORAGE_API_SET_METHOD = 4265;
  public static final int SHARED_STORAGE_API_SHARED_STORAGE_DOM_REFERENCE = 4263;
  public static final int SHARED_WORKER_START = 5;
  public static final int SHOW_MODAL_FOR_ELEMENT_IN_FULLSCREEN_STACK = 2000;
  public static final int SIGNED_EXCHANGE_INNER_RESPONSE = 2541;
  public static final int SIGNED_EXCHANGE_INNER_RESPONSE_IN_MAIN_FRAME = 2643;
  public static final int SIGNED_EXCHANGE_INNER_RESPONSE_IN_SUB_FRAME = 2644;
  public static final int SIGNED_EXCHANGE_SUBRESOURCE_PREFETCH = 2953;
  public static final int SINGLE_ORIGIN_IN_TIMING_ALLOW_ORIGIN = 1481;
  public static final int SIZES = 522;
  public static final int SLOT_ASSIGN_NODE = 3442;
  public static final int SLOT_CHANGE_EVENT_ADD_LISTENER = 1468;
  public static final int SMIL_ELEMENT_HAS_REPEAT_N_EVENT_LISTENER = 3471;
  public static final int SOFT_NAVIGATION_HEURISTICS = 4401;
  public static final int SOURCE_MAPPING_URL_MAGIC_COMMENT_AT_SIGN = 4676;
  public static final int SPECULATION_RULES = 3932;
  public static final int SPECULATION_RULES_AUTHOR_PREFETCH_RULE = 4829;
  public static final int SPECULATION_RULES_AUTHOR_PRERENDER_RULE = 4830;
  public static final int SPECULATION_RULES_BROWSER_PREFETCH_RULE = 4831;
  public static final int SPECULATION_RULES_BROWSER_PRERENDER_RULE = 4832;
  public static final int SPECULATION_RULES_DOCUMENT_RULES = 4395;
  public static final int SPECULATION_RULES_EAGERNESS_CONSERVATIVE = 4500;
  public static final int SPECULATION_RULES_EAGERNESS_EAGER = 4502;
  public static final int SPECULATION_RULES_EAGERNESS_MODERATE = 4501;
  public static final int SPECULATION_RULES_EXPLICIT_EAGERNESS = 4499;
  public static final int SPECULATION_RULES_HEADER = 4394;
  public static final int SPECULATION_RULES_NO_VARY_SEARCH_HINT = 4563;
  public static final int SPECULATION_RULES_PREFETCH = 4828;
  public static final int SPECULATION_RULES_PRERENDER = 3969;
  public static final int SPECULATION_RULES_SELECTOR_MATCHES = 4498;
  public static final int SPEECH_SYNTHESIS_GET_VOICES_METHOD = 3479;
  public static final int SRCSET_DROPPED_CANDIDATE = 573;
  public static final int SRCSET_W_DESCRIPTOR = 524;
  public static final int SRCSET_X_DESCRIPTOR = 523;
  public static final int SRI_ELEMENT_INTEGRITY_ATTRIBUTE_BUT_INELIGIBLE = 838;
  public static final int SRI_ELEMENT_WITH_MATCHING_INTEGRITY_ATTRIBUTE = 540;
  public static final int SRI_ELEMENT_WITH_NON_MATCHING_INTEGRITY_ATTRIBUTE = 541;
  public static final int SRI_ELEMENT_WITH_UNPARSABLE_INTEGRITY_ATTRIBUTE = 542;
  public static final int SRI_SIGNATURE_CHECK = 2352;
  public static final int SRI_SIGNATURE_SUCCESS = 2353;
  public static final int STALE_WHILE_REVALIDATE_ENABLED = 2474;
  public static final int STAR_IN_TIMING_ALLOW_ORIGIN = 1483;
  public static final int STEP_ATTRIBUTE = 51;
  public static final int STORAGE_ACCESS_API_HAS_STORAGE_ACCESS_METHOD = 3310;
  public static final int STORAGE_ACCESS_API_HAS_UNPARTITIONED_COOKIE_ACCESS = 4790;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES = 4696;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_ALL = 4697;
  public static final int
      STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_BROADCAST_CHANNEL = 4729;
  public static final int
      STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_BROADCAST_CHANNEL_USE = 4730;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_CACHES = 4712;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_CACHES_USE =
      4713;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_COOKIES = 4791;
  public static final int
      STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_CREATE_OBJECT_URL = 4725;
  public static final int
      STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_CREATE_OBJECT_URL_USE = 4726;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_ESTIMATE = 4723;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_ESTIMATE_USE =
      4724;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_GET_DIRECTORY =
      4714;
  public static final int
      STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_GET_DIRECTORY_USE = 4715;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_INDEXED_DB =
      4704;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_INDEXED_DB_USE =
      4705;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_LOCAL_STORAGE =
      4700;
  public static final int
      STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_LOCAL_STORAGE_USE = 4701;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_LOCKS = 4706;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_LOCKS_USE = 4707;
  public static final int
      STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_REVOKE_OBJECT_URL = 4727;
  public static final int
      STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_REVOKE_OBJECT_URL_USE = 4728;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_SESSION_STORAGE =
      4698;
  public static final int
      STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_SESSION_STORAGE_USE = 4699;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_SHARED_WORKER =
      4857;
  public static final int
      STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_SHARED_WORKER_USE = 4858;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_FOR_METHOD = 4332;
  public static final int STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_METHOD = 3311;
  public static final int STORAGE_BUCKETS_OPEN = 4378;
  public static final int STREAMING_DECLARATIVE_SHADOW_DOM = 4421;
  public static final int STRICT_MIME_TYPE_CHECKS_WOULD_BLOCK_WORKER = 3090;
  public static final int STRING_LOCALE_COMPARE = 2601;
  public static final int STRING_TO_LOCALE_LOWER_CASE = 2603;
  public static final int STYLE_MEDIA = 606;
  public static final int STYLE_MEDIA_MATCH_MEDIUM = 608;
  public static final int STYLE_MEDIA_TYPE = 607;
  public static final int STYLE_SHEET_LIST_ANONYMOUS_NAMED_GETTER = 763;
  public static final int STYLE_SHEET_LIST_NON_NULL_ANONYMOUS_NAMED_GETTER = 2066;
  public static final int SUBTLE_CRYPTO_DECRYPT = 712;
  public static final int SUBTLE_CRYPTO_DERIVE_BITS = 719;
  public static final int SUBTLE_CRYPTO_DERIVE_BITS_TRUNCATION = 4746;
  public static final int SUBTLE_CRYPTO_DERIVE_BITS_ZERO_LENGTH = 4745;
  public static final int SUBTLE_CRYPTO_DERIVE_KEY = 720;
  public static final int SUBTLE_CRYPTO_DIGEST = 715;
  public static final int SUBTLE_CRYPTO_ENCRYPT = 711;
  public static final int SUBTLE_CRYPTO_EXPORT_KEY = 718;
  public static final int SUBTLE_CRYPTO_GENERATE_KEY = 716;
  public static final int SUBTLE_CRYPTO_IMPORT_KEY = 717;
  public static final int SUBTLE_CRYPTO_SIGN = 713;
  public static final int SUBTLE_CRYPTO_UNWRAP_KEY = 722;
  public static final int SUBTLE_CRYPTO_VERIFY = 714;
  public static final int SUBTLE_CRYPTO_WRAP_KEY = 721;
  public static final int SUB_FRAME_BEFORE_UNLOAD_FIRED = 98;
  public static final int SUB_FRAME_BEFORE_UNLOAD_REGISTERED = 97;
  public static final int SUPPRESS_HISTORY_ENTRY_WITHOUT_USER_GESTURE = 2146;
  public static final int SVG1DOMSVG_ELEMENT = 1114;
  public static final int SVG1DOMSVG_TESTS = 1072;
  public static final int SVG1DOM_FILTER = 1030;
  public static final int SVG1DOM_FIT_TO_VIEW_BOX = 1111;
  public static final int SVG1DOM_FOREIGN_OBJECT_ELEMENT = 1116;
  public static final int SVG1DOM_IMAGE_ELEMENT = 1115;
  public static final int SVG1DOM_MARKER_ELEMENT = 1106;
  public static final int SVG1DOM_MASK_ELEMENT = 1108;
  public static final int SVG1DOM_PAINT_SERVER = 1035;
  public static final int SVG1DOM_SHAPE = 1039;
  public static final int SVG1DOM_TEXT = 1040;
  public static final int SVG1DOM_URI_REFERENCE = 1101;
  public static final int SVG1DOM_USE_ELEMENT = 1107;
  public static final int SVG1DOM_ZOOM_AND_PAN = 1102;
  public static final int SVGSMIL_ADDITIVE_ANIMATION = 1484;
  public static final int SVGSMIL_ANIMATION_APPLIED_EFFECT = 1477;
  public static final int SVGSMIL_ANIMATION_ELEMENT_TIMING = 1504;
  public static final int SVGSMIL_ANIMATION_IN_IMAGE_REGARDLESS_OF_CACHE = 768;
  public static final int SVGSMIL_BEGIN_END_ANIMATION_ELEMENT = 1505;
  public static final int SVGSMIL_BEGIN_OR_END_EVENT_VALUE = 1455;
  public static final int SVGSMIL_BEGIN_OR_END_SYNCBASE_VALUE = 1456;
  public static final int SVGSMIL_CURRENT_TIME = 1507;
  public static final int SVGSMIL_ELEMENT_INSERTED_AFTER_LOAD = 1457;
  public static final int SVGSMIL_ELEMENT_IN_DOCUMENT = 501;
  public static final int SVGSMIL_PAUSING = 1506;
  public static final int SVGSVG_ELEMENT = 138;
  public static final int SVGSVG_ELEMENT_FORCE_REDRAW = 685;
  public static final int SVGSVG_ELEMENT_FRAGMENT_SVG_VIEW = 1036;
  public static final int SVGSVG_ELEMENT_FRAGMENT_SVG_VIEW_ELEMENT = 1037;
  public static final int SVGSVG_ELEMENT_IN_DOCUMENT = 250;
  public static final int SVGSVG_ELEMENT_IN_XML_DOCUMENT = 329;
  public static final int SVGSVG_ELEMENT_SUSPEND_REDRAW = 686;
  public static final int SVGSVG_ELEMENT_UNSUSPEND_REDRAW = 687;
  public static final int SVGSVG_ELEMENT_UNSUSPEND_REDRAW_ALL = 688;
  public static final int SVG_ANIMATED_TRANSFORM_LIST_BASE_VAL = 570;
  public static final int SVG_ANIMATION_ELEMENT = 90;
  public static final int SVG_CALC_MODE_DISCRETE = 1287;
  public static final int SVG_CALC_MODE_LINEAR = 1288;
  public static final int SVG_CALC_MODE_PACED = 1289;
  public static final int SVG_CALC_MODE_SPLINE = 1290;
  public static final int SVG_CLASS_NAME = 279;
  public static final int SVG_DOCUMENT_ROOT_ELEMENT = 251;
  public static final int SVG_FOREIGN_OBJECT_ELEMENT = 325;
  public static final int SVG_GEOMETRY_PROPERTY_HAS_NON_ZERO_UNITLESS_VALUE = 2613;
  public static final int SVG_HREF_ANIM_VAL = 759;
  public static final int SVG_HREF_BASE_VAL = 758;
  public static final int SVG_IN_CANVAS2_D = 1835;
  public static final int SVG_IN_WEB_GL = 1836;
  public static final int SVG_LOCATABLE_FARTHEST_VIEWPORT_ELEMENT = 205;
  public static final int SVG_LOCATABLE_NEAREST_VIEWPORT_ELEMENT = 204;
  public static final int SVG_POINT_MATRIX_TRANSFORM = 209;
  public static final int SVG_STYLE_ELEMENT_TITLE = 519;
  public static final int SVG_SWITCH_ELEMENT = 80;
  public static final int SVG_TEXT = 3912;
  public static final int SVG_TEXT_EDITED = 3799;
  public static final int SVG_TEXT_HANGING_FROM_PATH = 3914;
  public static final int SVG_TRANSFORM_LIST_CONSOLIDATE = 569;
  public static final int SVG_VIEW_ELEMENT = 1500;
  public static final int SYNTHETIC_KEYFRAMES_IN_COMPOSITED_CSS_ANIMATION = 664;
  public static final int TABLE_COLLAPSED_BORDER_DIFFERENT_TO_VISUAL = 3983;
  public static final int TABLE_ROW_DIRECTION_DIFFERENT_FROM_TABLE = 2015;
  public static final int TABLE_SECTION_DIRECTION_DIFFERENT_FROM_TABLE = 2016;
  public static final int TAB_SHARING_BAR_SWITCH_TO_CAPTUREE = 4285;
  public static final int TAB_SHARING_BAR_SWITCH_TO_CAPTURER = 4284;
  public static final int TAP_DELAY_ENABLED = 3965;
  public static final int TARGET_CURRENT = 2835;
  public static final int TASK_CONTROLLER_CONSTRUCTOR = 3142;
  public static final int TASK_CONTROLLER_SET_PRIORITY = 3143;
  public static final int TASK_SIGNAL_PRIORITY = 3144;
  public static final int TEMPORAL_INPUT_TYPE_CHOOSER_BY_TRUSTED_CLICK = 2329;
  public static final int TEMPORAL_INPUT_TYPE_CHOOSER_BY_UNTRUSTED_CLICK = 2330;
  public static final int TEMPORAL_INPUT_TYPE_IGNORE_UNTRUSTED_CLICK = 2331;
  public static final int TEXT_ALIGN_SPECIFIED_TO_LEGEND = 3426;
  public static final int TEXT_AREA_MAX_LENGTH = 1424;
  public static final int TEXT_AREA_MIN_LENGTH = 1425;
  public static final int TEXT_AUTOSIZED_CROSS_SITE_IFRAME = 2739;
  public static final int TEXT_AUTOSIZING = 274;
  public static final int TEXT_DECODER_CONSTRUCTOR = 431;
  public static final int TEXT_DECODER_DECODE = 432;
  public static final int TEXT_DECODER_STREAM_CONSTRUCTOR = 2540;
  public static final int TEXT_DETECTOR_DETECT = 3713;
  public static final int TEXT_DIRECTIVE_IN_SHADOW_DOM = 4747;
  public static final int TEXT_ENCODER_CONSTRUCTOR = 429;
  public static final int TEXT_ENCODER_ENCODE = 430;
  public static final int TEXT_ENCODER_ENCODE_INTO = 2787;
  public static final int TEXT_ENCODER_STREAM_CONSTRUCTOR = 2539;
  public static final int TEXT_FRAGMENT_ANCHOR = 2901;
  public static final int TEXT_FRAGMENT_ANCHOR_MATCH_FOUND = 2902;
  public static final int TEXT_FRAGMENT_ANCHOR_TAP_TO_DISMISS = 3035;
  public static final int TEXT_FRAGMENT_BLOCKED_BY_FORCE_LOAD_AT_TOP = 3921;
  public static final int TEXT_INPUT_EVENT_ON_CONTENT_EDITABLE = 1591;
  public static final int TEXT_INPUT_EVENT_ON_INPUT = 1589;
  public static final int TEXT_INPUT_EVENT_ON_NOT_NODE = 1592;
  public static final int TEXT_INPUT_EVENT_ON_TEXT_AREA = 1590;
  public static final int TEXT_INPUT_FIRED = 830;
  public static final int TEXT_SHADOW_IN_HIGHLIGHT_PSEUDO = 3951;
  public static final int TEXT_SHADOW_NOT_NONE_IN_HIGHLIGHT_PSEUDO = 3952;
  public static final int TEXT_TO_SPEECH_SPEAK = 2471;
  public static final int TEXT_TO_SPEECH_SPEAK_CROSS_ORIGIN = 2472;
  public static final int TEXT_TO_SPEECH_SPEAK_DISALLOWED_BY_AUTOPLAY = 2473;
  public static final int TEXT_WHOLE_TEXT = 599;
  public static final int TEXT_WRAP_BALANCE = 4673;
  public static final int TEXT_WRAP_PRETTY = 4674;
  public static final int THIRD_PARTY_ACCESS = 3698;
  public static final int THIRD_PARTY_ACCESS_AND_ACTIVATION = 3700;
  public static final int THIRD_PARTY_ACTIVATION = 3699;
  public static final int THIRD_PARTY_BROADCAST_CHANNEL = 3033;
  public static final int THIRD_PARTY_CACHE_STORAGE = 3193;
  public static final int THIRD_PARTY_COOKIE_ACCESS_BLOCK_BY_EXPERIMENT = 4693;
  public static final int THIRD_PARTY_COOKIE_AD_ACCESS_BLOCK_BY_EXPERIMENT = 4710;
  public static final int THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY3_PCD = 4734;
  public static final int THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY3_PCD_HEURISTICS = 4735;
  public static final int THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY3_PCD_METADATA = 4733;
  public static final int
      THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY_ENTERPRISE_POLICY_COOKIE_ALLOWED_FOR_URLS = 4777;
  public static final int THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY_EXPLICIT_SETTING = 4731;
  public static final int THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY_GLOBAL_SETTING = 4732;
  public static final int THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY_STORAGE_ACCESS = 4736;
  public static final int THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY_TOP_LEVEL_STORAGE_ACCESS = 4737;
  public static final int THIRD_PARTY_COOKIE_READ = 3408;
  public static final int THIRD_PARTY_COOKIE_WRITE = 3409;
  public static final int THIRD_PARTY_FILE_SYSTEM = 3191;
  public static final int THIRD_PARTY_INDEXED_DB = 3192;
  public static final int THIRD_PARTY_LOCAL_STORAGE = 3194;
  public static final int THIRD_PARTY_SERVICE_WORKER = 3007;
  public static final int THIRD_PARTY_SESSION_STORAGE = 3195;
  public static final int THIRD_PARTY_SHARED_WORKER = 3032;
  public static final int THREE_VALUED_POSITION_BACKGROUND = 2001;
  public static final int TIMER_INSTALL_FROM_BEFORE_UNLOAD = 3468;
  public static final int TIMER_INSTALL_FROM_UNLOAD = 3469;
  public static final int TIME_ELEMENT = 1100;
  public static final int TOGGLE_EVENT_HANDLER_DURING_PARSING = 2978;
  public static final int TOPICS_API_BROWSING_TOPICS_METHOD = 4182;
  public static final int TOPICS_API_FETCH = 4460;
  public static final int TOP_LEVEL_DOCUMENT_WITH_EMBEDDED_CREDENTIALS = 4575;
  public static final int TOP_NAVIGATION_FROM_SUB_FRAME = 1426;
  public static final int TOP_NAV_IN_SANDBOX = 1749;
  public static final int TOP_NAV_IN_SANDBOX_WITHOUT_GESTURE = 1750;
  public static final int TOP_NAV_IN_SANDBOX_WITH_PERM = 1751;
  public static final int TOP_NAV_IN_SANDBOX_WITH_PERM_BUT_NO_GESTURE = 1752;
  public static final int TOUCH_EVENT_PREVENTED_FORCED_DOCUMENT_PASSIVE_NO_TOUCH_ACTION = 1683;
  public static final int TOUCH_EVENT_PREVENTED_NO_TOUCH_ACTION = 1682;
  public static final int TOUCH_START_FIRED = 1450;
  public static final int TRANSFORM3D_SCENE = 3867;
  public static final int TRANSFORM_STREAM_CONSTRUCTOR = 2401;
  public static final int TRANSFORM_STYLE_CONTAINING_BLOCK_COMPUTED_USED_MISMATCH = 3296;
  public static final int TRANSFORM_USES_BOX_SIZE_ON_SVG = 1842;
  public static final int TRUSTED_TYPES_ALLOW_DUPLICATES = 3162;
  public static final int TRUSTED_TYPES_ASSIGNMENT_ERROR = 2725;
  public static final int TRUSTED_TYPES_CREATE_POLICY = 2723;
  public static final int TRUSTED_TYPES_DEFAULT_POLICY_CREATED = 2724;
  public static final int TRUSTED_TYPES_ENABLED = 2722;
  public static final int TRUSTED_TYPES_ENABLED_ENFORCING = 3160;
  public static final int TRUSTED_TYPES_ENABLED_REPORT_ONLY = 3161;
  public static final int TRUSTED_TYPES_INTROSPECTION = 4752;
  public static final int TRUSTED_TYPES_IS_CHECK = 4753;
  public static final int TRUSTED_TYPES_POLICY_CREATED = 3279;
  public static final int TRUST_TOKEN_FETCH = 3276;
  public static final int TRUST_TOKEN_IFRAME = 3278;
  public static final int TRUST_TOKEN_XHR = 3277;
  public static final int TWO_VALUED_OVERFLOW = 2900;
  public static final int UNDEFERRABLE_THIRD_PARTY_SUBRESOURCE_REQUEST_WITH_COOKIE = 3682;
  public static final int UNHANDLED_EXCEPTION_COUNT_IN_MAIN_THREAD = 4297;
  public static final int UNHANDLED_EXCEPTION_COUNT_IN_WORKER = 4298;
  public static final int UNICODE_BIDI_PLAIN_TEXT = 3706;
  public static final int UNITLESS_PERSPECTIVE_IN_PERSPECTIVE_PROPERTY = 1671;
  public static final int UNITLESS_PERSPECTIVE_IN_TRANSFORM_PROPERTY = 1672;
  public static final int UNITLESS_ZERO_ANGLE_FILTER = 2007;
  public static final int UNITLESS_ZERO_ANGLE_GRADIENT = 2008;
  public static final int UNITLESS_ZERO_ANGLE_TRANSFORM = 2010;
  public static final int UNOPTIMIZED_IMAGE_POLICIES = 2890;
  public static final int UNPREFIXED_ANIMATION_END_EVENT = 129;
  public static final int UNPREFIXED_ANIMATION_ITERATION_EVENT = 135;
  public static final int UNPREFIXED_ANIMATION_START_EVENT = 132;
  public static final int UNPREFIXED_REQUEST_ANIMATION_FRAME = 13;
  public static final int UNPREFIXED_TRANSITION_END_EVENT = 19;
  public static final int UNRESTRICTED_SHARED_ARRAY_BUFFER = 3829;
  public static final int UNSIZED_MEDIA_POLICY = 2918;
  public static final int UNSPECIFIED_TARGET_ORIGIN_POST_MESSAGE = 3414;
  public static final int UNTRUSTED_MOUSE_DOWN_EVENT_DISPATCHED_TO_SELECT = 1543;
  public static final int UPDATE_WITHOUT_SHIPPING_OPTION_ON_SHIPPING_ADDRESS_CHANGE = 2622;
  public static final int UPDATE_WITHOUT_SHIPPING_OPTION_ON_SHIPPING_OPTION_CHANGE = 2623;
  public static final int UPGRADE_INSECURE_REQUESTS_ENABLED = 740;
  public static final int UPGRADE_INSECURE_REQUESTS_UPGRADED_REQUEST_BLOCKABLE = 3076;
  public static final int UPGRADE_INSECURE_REQUESTS_UPGRADED_REQUEST_FORM = 3079;
  public static final int UPGRADE_INSECURE_REQUESTS_UPGRADED_REQUEST_OPTIONALLY_BLOCKABLE = 3077;
  public static final int UPGRADE_INSECURE_REQUESTS_UPGRADED_REQUEST_UNKNOWN = 3080;
  public static final int UPGRADE_INSECURE_REQUESTS_UPGRADED_REQUEST_WEBSOCKET = 3078;
  public static final int URL_PATTERN_RELIANT_ON_IMPLICIT_URL_COMPONENTS_IN_STRING = 4610;
  public static final int URL_PATTERN_RELIANT_ON_LATER_COMPONENT_FROM_BASE_URL = 4611;
  public static final int URL_SEARCH_PARAMS_DELETE_FN_BEHAVIOUR_DIVERGED = 4593;
  public static final int URL_SEARCH_PARAMS_HAS_DELETE_MULTIPLE_ARGUMENTS = 4478;
  public static final int URL_SEARCH_PARAMS_HAS_FN_BEHAVIOUR_DIVERGED = 4592;
  public static final int USB_DEVICE_CLAIM_INTERFACE = 1524;
  public static final int USB_DEVICE_CLEAR_HALT = 1529;
  public static final int USB_DEVICE_CLOSE = 1522;
  public static final int USB_DEVICE_CONTROL_TRANSFER_IN = 1527;
  public static final int USB_DEVICE_CONTROL_TRANSFER_OUT = 1528;
  public static final int USB_DEVICE_FORGET = 4176;
  public static final int USB_DEVICE_ISOCHRONOUS_TRANSFER_IN = 1532;
  public static final int USB_DEVICE_ISOCHRONOUS_TRANSFER_OUT = 1533;
  public static final int USB_DEVICE_OPEN = 1521;
  public static final int USB_DEVICE_RELEASE_INTERFACE = 1525;
  public static final int USB_DEVICE_RESET = 1534;
  public static final int USB_DEVICE_SELECT_ALTERNATE_INTERFACE = 1526;
  public static final int USB_DEVICE_SELECT_CONFIGURATION = 1523;
  public static final int USB_DEVICE_TRANSFER_IN = 1530;
  public static final int USB_DEVICE_TRANSFER_OUT = 1531;
  public static final int USB_GET_DEVICES = 1519;
  public static final int USB_REQUEST_DEVICE = 1520;
  public static final int USER_DATA_FIELD_FILLED_PREDICTED_TYPE_MATCH = 3379;
  public static final int USER_DATA_FIELD_FILLED_PREVIOUSLY = 3982;
  public static final int USER_FEATURE_NEXT_THIRD_PARTIES_GA = 4786;
  public static final int USER_FEATURE_NEXT_THIRD_PARTIES_GOOGLE_MAPS_EMBED = 4789;
  public static final int USER_FEATURE_NEXT_THIRD_PARTIES_GTM = 4787;
  public static final int USER_FEATURE_NEXT_THIRD_PARTIES_YOU_TUBE_EMBED = 4788;
  public static final int USER_FEATURE_NG_AFTER_RENDER = 4778;
  public static final int USER_FEATURE_NG_HYDRATION = 4779;
  public static final int USER_FEATURE_NG_OPTIMIZED_IMAGE = 4775;
  public static final int USER_FEATURE_NUXT_IMAGE = 4838;
  public static final int USER_FEATURE_NUXT_PICTURE = 4839;
  public static final int USER_FEATURE_NUXT_THIRD_PARTIES_GA = 4840;
  public static final int USER_FEATURE_NUXT_THIRD_PARTIES_GOOGLE_MAPS = 4843;
  public static final int USER_FEATURE_NUXT_THIRD_PARTIES_GTM = 4841;
  public static final int USER_FEATURE_NUXT_THIRD_PARTIES_YOU_TUBE_EMBED = 4842;
  public static final int USER_MEDIA_DISABLE_HARDWARE_NOISE_SUPPRESSION = 2258;
  public static final int USER_TIMING = 2430;
  public static final int USER_TIMING_L3 = 3053;
  public static final int USE_ASM = 473;
  public static final int V0_CUSTOM_ELEMENTS_CONSTRUCT = 1879;
  public static final int V0_CUSTOM_ELEMENTS_CREATE_CUSTOM_TAG_ELEMENT = 1877;
  public static final int V0_CUSTOM_ELEMENTS_CREATE_TYPE_EXTENSION_ELEMENT = 1878;
  public static final int V0_CUSTOM_ELEMENTS_REGISTER_HTML_CUSTOM_TAG = 1873;
  public static final int V0_CUSTOM_ELEMENTS_REGISTER_HTML_TYPE_EXTENSION = 1874;
  public static final int V0_CUSTOM_ELEMENTS_REGISTER_SVG_ELEMENT = 1875;
  public static final int V8CSS_FONT_FACE_RULE_STYLE_ATTRIBUTE_GETTER = 1082;
  public static final int V8CSS_RULE_LIST_ITEM_METHOD = 760;
  public static final int V8DOM_ERROR_CONSTRUCTOR = 816;
  public static final int V8DOM_ERROR_MESSAGE_ATTRIBUTE_GETTER = 818;
  public static final int V8DOM_ERROR_NAME_ATTRIBUTE_GETTER = 817;
  public static final int V8HTML_COMMENT = 1236;
  public static final int V8HTML_COMMENT_IN_EXTERNAL_SCRIPT = 1235;
  public static final int V8HTML_DIALOG_ELEMENT_SHOW_METHOD = 3725;
  public static final int V8HTML_DIALOG_ELEMENT_SHOW_MODAL_METHOD = 3726;
  public static final int V8HTML_ELEMENT_AUTOCAPITALIZE_ATTRIBUTE_GETTER = 2349;
  public static final int V8HTML_ELEMENT_AUTOCAPITALIZE_ATTRIBUTE_SETTER = 2350;
  public static final int V8HTML_ELEMENT_FOCUSGROUP_ATTRIBUTE_GETTER = 4244;
  public static final int V8HTML_ELEMENT_FOCUSGROUP_ATTRIBUTE_SETTER = 4245;
  public static final int V8HTML_FIELD_SET_ELEMENT_ELEMENTS_ATTRIBUTE_GETTER = 979;
  public static final int V8HTML_INPUT_ELEMENT_CAPTURE_ATTRIBUTE_GETTER = 1851;
  public static final int V8HTML_INPUT_ELEMENT_CAPTURE_ATTRIBUTE_SETTER = 1852;
  public static final int V8HTML_INPUT_ELEMENT_SHOW_PICKER_METHOD = 4097;
  public static final int V8HTML_INPUT_ELEMENT_WEBKIT_ENTRIES_ATTRIBUTE_GETTER = 1326;
  public static final int V8HTML_LINK_ELEMENT_DISABLED_ATTRIBUTE_GETTER = 810;
  public static final int V8HTML_LINK_ELEMENT_DISABLED_ATTRIBUTE_SETTER = 811;
  public static final int V8HTML_MEDIA_ELEMENT_CAN_PLAY_TYPE_METHOD = 2718;
  public static final int V8HTML_MEDIA_ELEMENT_CAPTURE_STREAM_METHOD = 2729;
  public static final int V8HTML_MEDIA_ELEMENT_REMOTE_ATTRIBUTE_GETTER = 2779;
  public static final int V8HTML_MEDIA_ELEMENT_SRC_OBJECT_ATTRIBUTE_GETTER = 1602;
  public static final int V8HTML_MEDIA_ELEMENT_SRC_OBJECT_ATTRIBUTE_SETTER = 1603;
  public static final int V8HTML_PORTAL_ELEMENT_ACTIVATE_METHOD = 3097;
  public static final int V8HTML_PORTAL_ELEMENT_POST_MESSAGE_METHOD = 3098;
  public static final int V8HTML_SCRIPT_ELEMENT_SUPPORTS_METHOD = 4011;
  public static final int V8HTML_STYLE_ELEMENT_DISABLED_ATTRIBUTE_GETTER = 812;
  public static final int V8HTML_STYLE_ELEMENT_DISABLED_ATTRIBUTE_SETTER = 813;
  public static final int V8HTML_VIDEO_ELEMENT_CANCEL_VIDEO_FRAME_CALLBACK_METHOD = 3281;
  public static final int V8HTML_VIDEO_ELEMENT_DISABLE_PICTURE_IN_PICTURE_ATTRIBUTE_GETTER = 2442;
  public static final int V8HTML_VIDEO_ELEMENT_DISABLE_PICTURE_IN_PICTURE_ATTRIBUTE_SETTER = 2443;
  public static final int V8HTML_VIDEO_ELEMENT_GET_VIDEO_PLAYBACK_QUALITY_METHOD = 3722;
  public static final int V8HTML_VIDEO_ELEMENT_POSTER_ATTRIBUTE_GETTER = 1815;
  public static final int V8HTML_VIDEO_ELEMENT_POSTER_ATTRIBUTE_SETTER = 1816;
  public static final int V8HTML_VIDEO_ELEMENT_REQUEST_PICTURE_IN_PICTURE_METHOD = 2444;
  public static final int V8HTML_VIDEO_ELEMENT_REQUEST_VIDEO_FRAME_CALLBACK_METHOD = 3280;
  public static final int V8IDB_FACTORY_DATABASES_METHOD = 2648;
  public static final int V8IDB_FACTORY_OPEN_METHOD = 2527;
  public static final int V8IDB_FACTORY_WEBKIT_GET_DATABASE_NAMES_METHOD = 1273;
  public static final int V8IIR_FILTER_NODE_CONSTRUCTOR = 1715;
  public static final int V8RTCDTMF_SENDER_DURATION_ATTRIBUTE_GETTER = 2379;
  public static final int V8RTCDTMF_SENDER_INTER_TONE_GAP_ATTRIBUTE_GETTER = 2380;
  public static final int V8RTCDTMF_SENDER_TRACK_ATTRIBUTE_GETTER = 2378;
  public static final int V8RTC_DATA_CHANNEL_MAX_RETRANSMITS_ATTRIBUTE_GETTER = 1639;
  public static final int V8RTC_DATA_CHANNEL_MAX_RETRANSMIT_TIME_ATTRIBUTE_GETTER = 1638;
  public static final int V8RTC_DATA_CHANNEL_RELIABLE_ATTRIBUTE_GETTER = 1640;
  public static final int V8RTC_ENCODED_AUDIO_FRAME_SET_METADATA_METHOD = 4645;
  public static final int V8RTC_ENCODED_AUDIO_FRAME_SET_TIMESTAMP_METHOD = 4625;
  public static final int V8RTC_ENCODED_VIDEO_FRAME_SET_METADATA_METHOD = 4623;
  public static final int V8RTC_ENCODED_VIDEO_FRAME_SET_TIMESTAMP_METHOD = 4624;
  public static final int V8RTC_ICE_TRANSPORT_CONSTRUCTOR = 2749;
  public static final int V8RTC_ICE_TRANSPORT_GATHERING_STATE_ATTRIBUTE_GETTER = 2752;
  public static final int V8RTC_ICE_TRANSPORT_GET_LOCAL_CANDIDATES_METHOD = 2753;
  public static final int V8RTC_ICE_TRANSPORT_GET_LOCAL_PARAMETERS_METHOD = 2756;
  public static final int V8RTC_ICE_TRANSPORT_GET_REMOTE_CANDIDATES_METHOD = 2754;
  public static final int V8RTC_ICE_TRANSPORT_GET_REMOTE_PARAMETERS_METHOD = 2757;
  public static final int V8RTC_ICE_TRANSPORT_GET_SELECTED_CANDIDATE_PAIR_METHOD = 2755;
  public static final int V8RTC_ICE_TRANSPORT_ROLE_ATTRIBUTE_GETTER = 2750;
  public static final int V8RTC_ICE_TRANSPORT_STATE_ATTRIBUTE_GETTER = 2751;
  public static final int V8RTC_LEGACY_STATS_REPORT_TIMESTAMP_ATTRIBUTE_GETTER = 3109;
  public static final int V8RTC_PEER_CONNECTION_ADD_STREAM_METHOD = 1641;
  public static final int V8RTC_PEER_CONNECTION_ADD_TRACK_METHOD = 2254;
  public static final int V8RTC_PEER_CONNECTION_ADD_TRANSCEIVER_METHOD = 2513;
  public static final int V8RTC_PEER_CONNECTION_CREATE_DTMF_SENDER_METHOD = 1642;
  public static final int V8RTC_PEER_CONNECTION_GET_LOCAL_STREAMS_METHOD = 1643;
  public static final int V8RTC_PEER_CONNECTION_GET_RECEIVERS_METHOD = 2253;
  public static final int V8RTC_PEER_CONNECTION_GET_REMOTE_STREAMS_METHOD = 1644;
  public static final int V8RTC_PEER_CONNECTION_GET_SENDERS_METHOD = 2252;
  public static final int V8RTC_PEER_CONNECTION_GET_TRANSCEIVERS_METHOD = 2512;
  public static final int V8RTC_PEER_CONNECTION_REMOVE_STREAM_METHOD = 1646;
  public static final int V8RTC_PEER_CONNECTION_REMOVE_TRACK_METHOD = 2255;
  public static final int V8RTC_RTP_RECEIVER_CREATE_ENCODED_STREAMS_METHOD = 3293;
  public static final int V8RTC_RTP_RECEIVER_GET_CAPABILITIES_METHOD = 3509;
  public static final int V8RTC_RTP_RECEIVER_JITTER_BUFFER_DELAY_HINT_ATTRIBUTE_GETTER = 2886;
  public static final int V8RTC_RTP_RECEIVER_JITTER_BUFFER_DELAY_HINT_ATTRIBUTE_SETTER = 2887;
  public static final int V8RTC_RTP_RECEIVER_PLAYOUT_DELAY_HINT_ATTRIBUTE_GETTER = 3062;
  public static final int V8RTC_RTP_RECEIVER_PLAYOUT_DELAY_HINT_ATTRIBUTE_SETTER = 3063;
  public static final int V8RTC_RTP_SENDER_CREATE_ENCODED_STREAMS_METHOD = 3292;
  public static final int V8RTC_RTP_SENDER_DTMF_ATTRIBUTE_GETTER = 2381;
  public static final int V8RTC_RTP_SENDER_GET_CAPABILITIES_METHOD = 3510;
  public static final int V8RTC_RTP_SENDER_REPLACE_TRACK_METHOD = 2323;
  public static final int V8RTC_RTP_SENDER_SET_STREAMS_METHOD = 2915;
  public static final int V8RTC_RTP_TRANSCEIVER_DIRECTION_ATTRIBUTE_GETTER = 2514;
  public static final int V8RTC_RTP_TRANSCEIVER_DIRECTION_ATTRIBUTE_SETTER = 2515;
  public static final int V8RTC_RTP_TRANSCEIVER_STOPPED_ATTRIBUTE_GETTER = 3374;
  public static final int V8RTC_RTP_TRANSCEIVER_STOP_METHOD = 3375;
  public static final int V8RTC_SESSION_DESCRIPTION_SDP_ATTRIBUTE_GETTER = 1675;
  public static final int V8RTC_SESSION_DESCRIPTION_SDP_ATTRIBUTE_SETTER = 1676;
  public static final int V8RTC_SESSION_DESCRIPTION_TYPE_ATTRIBUTE_GETTER = 1673;
  public static final int V8RTC_SESSION_DESCRIPTION_TYPE_ATTRIBUTE_SETTER = 1674;
  public static final int V8SQL_TRANSACTION_EXECUTE_SQL_METHOD = 2962;
  public static final int V8SVGA_ELEMENT_TARGET_ATTRIBUTE_GETTER = 1109;
  public static final int V8SVGFE_CONVOLVE_MATRIX_ELEMENT_PRESERVE_ALPHA_ATTRIBUTE_GETTER = 791;
  public static final int V8SVGSVG_ELEMENT_CREATE_SVG_ANGLE_METHOD = 1087;
  public static final int V8SVGSVG_ELEMENT_CREATE_SVG_LENGTH_METHOD = 1086;
  public static final int V8SVGSVG_ELEMENT_CREATE_SVG_MATRIX_METHOD = 1089;
  public static final int V8SVGSVG_ELEMENT_CREATE_SVG_NUMBER_METHOD = 1085;
  public static final int V8SVGSVG_ELEMENT_CREATE_SVG_POINT_METHOD = 1088;
  public static final int V8SVGSVG_ELEMENT_CREATE_SVG_RECT_METHOD = 1090;
  public static final int V8SVGSVG_ELEMENT_CREATE_SVG_TRANSFORM_FROM_MATRIX_METHOD = 1092;
  public static final int V8SVGSVG_ELEMENT_CREATE_SVG_TRANSFORM_METHOD = 1091;
  public static final int V8SVGSVG_ELEMENT_GET_ELEMENT_BY_ID_METHOD = 778;
  public static final int V8SVG_CLIP_PATH_ELEMENT_CLIP_PATH_UNITS_ATTRIBUTE_GETTER = 1110;
  public static final int V8SVG_ELEMENT_FOCUSGROUP_ATTRIBUTE_GETTER = 4248;
  public static final int V8SVG_ELEMENT_FOCUSGROUP_ATTRIBUTE_SETTER = 4249;
  public static final int V8SVG_GEOMETRY_ELEMENT_GET_POINT_AT_LENGTH_METHOD = 2668;
  public static final int V8SVG_GEOMETRY_ELEMENT_GET_TOTAL_LENGTH_METHOD = 2667;
  public static final int V8SVG_GEOMETRY_ELEMENT_IS_POINT_IN_FILL_METHOD = 2665;
  public static final int V8SVG_GEOMETRY_ELEMENT_IS_POINT_IN_STROKE_METHOD = 2666;
  public static final int V8SVG_GRAPHICS_ELEMENT_TRANSFORM_ATTRIBUTE_GETTER = 1103;
  public static final int V8SVG_STYLE_ELEMENT_DISABLED_ATTRIBUTE_GETTER = 798;
  public static final int V8SVG_STYLE_ELEMENT_DISABLED_ATTRIBUTE_SETTER = 799;
  public static final int V8SVG_TEXT_CONTENT_ELEMENT_GET_COMPUTED_TEXT_LENGTH_METHOD = 2674;
  public static final int V8SVG_TEXT_CONTENT_ELEMENT_GET_END_POSITION_OF_CHAR_METHOD = 2675;
  public static final int V8SVG_TEXT_CONTENT_ELEMENT_GET_EXTENT_OF_CHAR_METHOD = 2676;
  public static final int V8SVG_TEXT_CONTENT_ELEMENT_GET_START_POSITION_OF_CHAR_METHOD = 2677;
  public static final int V8SVG_TEXT_CONTENT_ELEMENT_GET_SUB_STRING_LENGTH_METHOD = 2678;
  public static final int V8TCP_SOCKET_CLOSE_METHOD = 3775;
  public static final int V8TCP_SOCKET_READABLE_ATTRIBUTE_GETTER = 3776;
  public static final int V8TCP_SOCKET_REMOTE_ADDRESS_ATTRIBUTE_GETTER = 3778;
  public static final int V8TCP_SOCKET_REMOTE_PORT_ATTRIBUTE_GETTER = 3779;
  public static final int V8TCP_SOCKET_WRITABLE_ATTRIBUTE_GETTER = 3777;
  public static final int V8UDP_SOCKET_CLOSE_METHOD = 4104;
  public static final int V8UDP_SOCKET_LOCAL_PORT_ATTRIBUTE_GETTER = 4154;
  public static final int V8UDP_SOCKET_READABLE_ATTRIBUTE_GETTER = 4155;
  public static final int V8UDP_SOCKET_REMOTE_ADDRESS_ATTRIBUTE_GETTER = 4156;
  public static final int V8UDP_SOCKET_REMOTE_PORT_ATTRIBUTE_GETTER = 4157;
  public static final int V8UDP_SOCKET_WRITABLE_ATTRIBUTE_GETTER = 4158;
  public static final int V8UI_EVENT_INIT_UI_EVENT_METHOD = 873;
  public static final int V8URL_PATTERN_COMPARE_COMPONENT_METHOD = 3966;
  public static final int V8URL_PATTERN_CONSTRUCTOR = 3959;
  public static final int V8URL_PATTERN_EXEC_METHOD = 3961;
  public static final int V8URL_PATTERN_TEST_METHOD = 3960;
  public static final int V8XR_INPUT_SOURCE_GAMEPAD_ATTRIBUTE_GETTER = 2910;
  public static final int V8XR_REFERENCE_SPACE_GET_OFFSET_REFERENCE_SPACE_METHOD = 2909;
  public static final int V8XR_SESSION_END_METHOD = 2911;
  public static final int V8XR_WEB_GL_LAYER_CONSTRUCTOR = 2912;
  public static final int V8X_PATH_EVALUATOR_CONSTRUCTOR = 853;
  public static final int V8X_PATH_EVALUATOR_CREATE_EXPRESSION_METHOD = 854;
  public static final int V8X_PATH_EVALUATOR_CREATE_NS_RESOLVER_METHOD = 855;
  public static final int V8X_PATH_EVALUATOR_EVALUATE_METHOD = 856;
  public static final int V8_ABORT_CONTROLLER_CONSTRUCTOR = 2361;
  public static final int V8_ABORT_SIGNAL_ABORT_METHOD = 3933;
  public static final int V8_ANALYSER_NODE_CONSTRUCTOR = 1703;
  public static final int V8_ANALYSER_NODE_GET_BYTE_FREQUENCY_DATA_METHOD = 2686;
  public static final int V8_ANALYSER_NODE_GET_BYTE_TIME_DOMAIN_DATA_METHOD = 2687;
  public static final int V8_ANALYSER_NODE_GET_FLOAT_FREQUENCY_DATA_METHOD = 2688;
  public static final int V8_ANALYSER_NODE_GET_FLOAT_TIME_DOMAIN_DATA_METHOD = 2689;
  public static final int V8_ANIMATION_CANCEL_METHOD = 699;
  public static final int V8_ANIMATION_COMMIT_STYLES_METHOD = 3150;
  public static final int V8_ANIMATION_CURRENT_TIME_ATTRIBUTE_GETTER = 547;
  public static final int V8_ANIMATION_CURRENT_TIME_ATTRIBUTE_SETTER = 548;
  public static final int V8_ANIMATION_EFFECT_ATTRIBUTE_GETTER = 2858;
  public static final int V8_ANIMATION_EFFECT_ATTRIBUTE_SETTER = 2859;
  public static final int V8_ANIMATION_FINISH_METHOD = 552;
  public static final int V8_ANIMATION_ID_ATTRIBUTE_GETTER = 1239;
  public static final int V8_ANIMATION_ID_ATTRIBUTE_SETTER = 1240;
  public static final int V8_ANIMATION_ONCANCEL_ATTRIBUTE_GETTER = 1233;
  public static final int V8_ANIMATION_ONCANCEL_ATTRIBUTE_SETTER = 1234;
  public static final int V8_ANIMATION_ONFINISH_ATTRIBUTE_GETTER = 700;
  public static final int V8_ANIMATION_ONFINISH_ATTRIBUTE_SETTER = 701;
  public static final int V8_ANIMATION_ONREMOVE_ATTRIBUTE_GETTER = 3146;
  public static final int V8_ANIMATION_ONREMOVE_ATTRIBUTE_SETTER = 3147;
  public static final int V8_ANIMATION_PAUSE_METHOD = 554;
  public static final int V8_ANIMATION_PENDING_ATTRIBUTE_GETTER = 2881;
  public static final int V8_ANIMATION_PERSIST_METHOD = 3141;
  public static final int V8_ANIMATION_PLAYBACK_RATE_ATTRIBUTE_GETTER = 549;
  public static final int V8_ANIMATION_PLAYBACK_RATE_ATTRIBUTE_SETTER = 550;
  public static final int V8_ANIMATION_PLAY_METHOD = 553;
  public static final int V8_ANIMATION_PLAY_STATE_ATTRIBUTE_GETTER = 551;
  public static final int V8_ANIMATION_RANGE_END_ATTRIBUTE_GETTER = 4506;
  public static final int V8_ANIMATION_RANGE_END_ATTRIBUTE_SETTER = 4507;
  public static final int V8_ANIMATION_RANGE_START_ATTRIBUTE_GETTER = 4504;
  public static final int V8_ANIMATION_RANGE_START_ATTRIBUTE_SETTER = 4505;
  public static final int V8_ANIMATION_REPLACE_STATE_ATTRIBUTE_GETTER = 3140;
  public static final int V8_ANIMATION_REVERSE_METHOD = 555;
  public static final int V8_ANIMATION_START_TIME_ATTRIBUTE_GETTER = 545;
  public static final int V8_ANIMATION_START_TIME_ATTRIBUTE_SETTER = 546;
  public static final int V8_ANIMATION_UPDATE_PLAYBACK_RATE_METHOD = 2899;
  public static final int V8_ARRAY_INSTANCE_CONSTRUCTOR_MODIFIED = 1394;
  public static final int V8_ARRAY_PROTOTYPE_CONSTRUCTOR_MODIFIED = 1392;
  public static final int V8_ARRAY_PROTOTYPE_HAS_ELEMENTS = 3163;
  public static final int V8_ARRAY_SORT_NO_ELEMENTS_PROTECTOR = 2436;
  public static final int V8_ARRAY_SPECIES_MODIFIED = 1391;
  public static final int V8_ASSIGMENT_EXPRESSION_LHS_IS_CALL_IN_SLOPPY = 1764;
  public static final int V8_ASSIGMENT_EXPRESSION_LHS_IS_CALL_IN_STRICT = 1765;
  public static final int V8_ASYNC_STACK_TAGGING_CREATE_TASK_CALL = 4354;
  public static final int V8_ATTEMPT_OVERRIDE_READ_ONLY_ON_PROTOTYPE_SLOPPY = 2609;
  public static final int V8_ATTEMPT_OVERRIDE_READ_ONLY_ON_PROTOTYPE_STRICT = 2610;
  public static final int V8_AUDIO_BUFFER_CONSTRUCTOR = 1704;
  public static final int V8_AUDIO_BUFFER_COPY_FROM_CHANNEL_METHOD = 2690;
  public static final int V8_AUDIO_BUFFER_GET_CHANNEL_DATA_METHOD = 2691;
  public static final int V8_AUDIO_BUFFER_SOURCE_NODE_CONSTRUCTOR = 1705;
  public static final int V8_AUDIO_CONTEXT_CONSTRUCTOR = 1698;
  public static final int V8_AUDIO_PROCESSING_EVENT_CONSTRUCTOR = 1706;
  public static final int V8_AUTHENTICATOR_ATTESTATION_RESPONSE_GET_TRANSPORTS_METHOD = 3455;
  public static final int V8_BACKGROUND_FETCH_REGISTRATION_FAILURE_REASON_ATTRIBUTE_GETTER = 3499;
  public static final int V8_BASE_AUDIO_CONTEXT_SAMPLE_RATE_ATTRIBUTE_GETTER = 3566;
  public static final int V8_BATTERY_MANAGER_CHARGING_ATTRIBUTE_GETTER = 2680;
  public static final int V8_BATTERY_MANAGER_CHARGING_TIME_ATTRIBUTE_GETTER = 2679;
  public static final int V8_BATTERY_MANAGER_DISCHARGING_TIME_ATTRIBUTE_GETTER = 2681;
  public static final int V8_BATTERY_MANAGER_LEVEL_ATTRIBUTE_GETTER = 2682;
  public static final int V8_BEFORE_INSTALL_PROMPT_EVENT_PLATFORMS_ATTRIBUTE_GETTER = 3546;
  public static final int V8_BIQUAD_FILTER_NODE_CONSTRUCTOR = 1707;
  public static final int V8_BROADCAST_CHANNEL_CLOSE_METHOD = 1449;
  public static final int V8_BROADCAST_CHANNEL_CONSTRUCTOR = 1447;
  public static final int V8_BROADCAST_CHANNEL_POST_MESSAGE_METHOD = 1448;
  public static final int V8_CALL_SITE_API_GET_FUNCTION_SLOPPY_CALL = 2924;
  public static final int V8_CALL_SITE_API_GET_THIS_SLOPPY_CALL = 2925;
  public static final int V8_CHANNEL_MERGER_NODE_CONSTRUCTOR = 1708;
  public static final int V8_CHANNEL_SPLITTER_NODE_CONSTRUCTOR = 1709;
  public static final int V8_CLIPBOARD_ITEM_SUPPORTS_METHOD = 4692;
  public static final int V8_COMPILE_HINTS_MAGIC_ALL = 4543;
  public static final int V8_COMPOSITION_EVENT_INIT_COMPOSITION_EVENT_METHOD = 863;
  public static final int V8_CONSTANT_SOURCE_NODE_CONSTRUCTOR = 1710;
  public static final int V8_CONVOLVER_NODE_CONSTRUCTOR = 1711;
  public static final int V8_COOKIE_CHANGE_EVENT_CHANGED_ATTRIBUTE_GETTER = 2457;
  public static final int V8_COOKIE_CHANGE_EVENT_DELETED_ATTRIBUTE_GETTER = 2458;
  public static final int V8_COOKIE_STORE_DELETE_METHOD = 2450;
  public static final int V8_COOKIE_STORE_GET_ALL_METHOD = 2452;
  public static final int V8_COOKIE_STORE_GET_CHANGE_SUBSCRIPTIONS_METHOD = 2453;
  public static final int V8_COOKIE_STORE_GET_METHOD = 2451;
  public static final int V8_COOKIE_STORE_HAS_METHOD = 2454;
  public static final int V8_COOKIE_STORE_SET_METHOD = 2455;
  public static final int V8_COOKIE_STORE_SUBSCRIBE_TO_CHANGES_METHOD = 2456;
  public static final int V8_CUSTOM_EVENT_INIT_CUSTOM_EVENT_METHOD = 864;
  public static final int V8_DATABASE_CHANGE_VERSION_METHOD = 2959;
  public static final int V8_DATABASE_READ_TRANSACTION_METHOD = 2961;
  public static final int V8_DATABASE_TRANSACTION_METHOD = 2960;
  public static final int V8_DATA_TRANSFER_ITEM_WEBKIT_GET_AS_ENTRY_METHOD = 1325;
  public static final int V8_DECIMAL_WITH_LEADING_ZERO_IN_STRICT_MODE = 1398;
  public static final int V8_DEFINE_GETTER_OR_SETTER_WOULD_THROW = 1445;
  public static final int V8_DELAY_NODE_CONSTRUCTOR = 1712;
  public static final int V8_DEOPTIMIZER_DISABLE_SPECULATION = 2277;
  public static final int V8_DEPRECATED_STORAGE_INFO_QUERY_USAGE_AND_QUOTA_METHOD = 1808;
  public static final int V8_DEPRECATED_STORAGE_INFO_REQUEST_QUOTA_METHOD = 1809;
  public static final int V8_DEPRECATED_STORAGE_QUOTA_QUERY_USAGE_AND_QUOTA_METHOD = 1810;
  public static final int V8_DEPRECATED_STORAGE_QUOTA_REQUEST_QUOTA_METHOD = 1811;
  public static final int V8_DEVICE_MOTION_EVENT_INIT_DEVICE_MOTION_EVENT_METHOD = 865;
  public static final int V8_DEVICE_ORIENTATION_EVENT_INIT_DEVICE_ORIENTATION_EVENT_METHOD = 866;
  public static final int V8_DOCUMENT_ANCHORS_ATTRIBUTE_GETTER = 1303;
  public static final int V8_DOCUMENT_APPLETS_ATTRIBUTE_GETTER = 1304;
  public static final int V8_DOCUMENT_ELEMENTS_FROM_POINT_METHOD = 3501;
  public static final int V8_DOCUMENT_ELEMENT_FROM_POINT_METHOD = 3500;
  public static final int V8_DOCUMENT_EMBEDS_ATTRIBUTE_GETTER = 1298;
  public static final int V8_DOCUMENT_EXIT_PICTURE_IN_PICTURE_METHOD = 2440;
  public static final int V8_DOCUMENT_FORMS_ATTRIBUTE_GETTER = 1301;
  public static final int V8_DOCUMENT_FRAGMENT_DIRECTIVE_ATTRIBUTE_GETTER = 3427;
  public static final int V8_DOCUMENT_GET_ANIMATIONS_METHOD = 3187;
  public static final int V8_DOCUMENT_HAS_PRIVATE_TOKEN_METHOD = 4411;
  public static final int V8_DOCUMENT_HAS_REDEMPTION_RECORD_METHOD = 4347;
  public static final int V8_DOCUMENT_HAS_TRUST_TOKEN_METHOD = 3202;
  public static final int V8_DOCUMENT_IMAGES_ATTRIBUTE_GETTER = 1297;
  public static final int V8_DOCUMENT_LINKS_ATTRIBUTE_GETTER = 1300;
  public static final int V8_DOCUMENT_ONPRERENDERINGCHANGE_ATTRIBUTE_GETTER = 4162;
  public static final int V8_DOCUMENT_ONPRERENDERINGCHANGE_ATTRIBUTE_SETTER = 4163;
  public static final int V8_DOCUMENT_PICTURE_IN_PICTURE_ELEMENT_ATTRIBUTE_GETTER = 2439;
  public static final int V8_DOCUMENT_PICTURE_IN_PICTURE_ENABLED_ATTRIBUTE_GETTER = 2438;
  public static final int V8_DOCUMENT_PICTURE_IN_PICTURE_EVENT_WINDOW_ATTRIBUTE_GETTER = 4399;
  public static final int V8_DOCUMENT_PICTURE_IN_PICTURE_REQUEST_WINDOW_METHOD = 4397;
  public static final int V8_DOCUMENT_PICTURE_IN_PICTURE_WINDOW_ATTRIBUTE_GETTER = 4398;
  public static final int V8_DOCUMENT_PLUGINS_ATTRIBUTE_GETTER = 1299;
  public static final int V8_DOCUMENT_PRERENDERING_ATTRIBUTE_GETTER = 4161;
  public static final int V8_DOCUMENT_ROOT_SCROLLER_ATTRIBUTE_GETTER = 1687;
  public static final int V8_DOCUMENT_ROOT_SCROLLER_ATTRIBUTE_SETTER = 1688;
  public static final int V8_DOCUMENT_SCRIPTS_ATTRIBUTE_GETTER = 1302;
  public static final int V8_DYNAMICS_COMPRESSOR_NODE_CONSTRUCTOR = 1713;
  public static final int V8_ELEMENT_ANIMATE_METHOD = 773;
  public static final int V8_ELEMENT_ARIA_ACTIVE_DESCENDANT_ELEMENT_ATTRIBUTE_GETTER = 4794;
  public static final int V8_ELEMENT_ARIA_ACTIVE_DESCENDANT_ELEMENT_ATTRIBUTE_SETTER = 4795;
  public static final int V8_ELEMENT_ARIA_CONTROLS_ELEMENTS_ATTRIBUTE_GETTER = 4796;
  public static final int V8_ELEMENT_ARIA_CONTROLS_ELEMENTS_ATTRIBUTE_SETTER = 4797;
  public static final int V8_ELEMENT_ARIA_DESCRIBED_BY_ELEMENTS_ATTRIBUTE_GETTER = 4798;
  public static final int V8_ELEMENT_ARIA_DESCRIBED_BY_ELEMENTS_ATTRIBUTE_SETTER = 4799;
  public static final int V8_ELEMENT_ARIA_DETAILS_ELEMENTS_ATTRIBUTE_GETTER = 4800;
  public static final int V8_ELEMENT_ARIA_DETAILS_ELEMENTS_ATTRIBUTE_SETTER = 4801;
  public static final int V8_ELEMENT_ARIA_ERROR_MESSAGE_ELEMENTS_ATTRIBUTE_GETTER = 4802;
  public static final int V8_ELEMENT_ARIA_ERROR_MESSAGE_ELEMENTS_ATTRIBUTE_SETTER = 4803;
  public static final int V8_ELEMENT_ARIA_FLOW_TO_ELEMENTS_ATTRIBUTE_GETTER = 4804;
  public static final int V8_ELEMENT_ARIA_FLOW_TO_ELEMENTS_ATTRIBUTE_SETTER = 4805;
  public static final int V8_ELEMENT_ARIA_LABELLED_BY_ELEMENTS_ATTRIBUTE_GETTER = 4806;
  public static final int V8_ELEMENT_ARIA_LABELLED_BY_ELEMENTS_ATTRIBUTE_SETTER = 4807;
  public static final int V8_ELEMENT_ARIA_OWNS_ELEMENTS_ATTRIBUTE_GETTER = 4808;
  public static final int V8_ELEMENT_ARIA_OWNS_ELEMENTS_ATTRIBUTE_SETTER = 4809;
  public static final int V8_ELEMENT_GET_BOUNDING_CLIENT_RECT_METHOD = 2219;
  public static final int V8_ELEMENT_GET_CLIENT_RECTS_METHOD = 2218;
  public static final int V8_ELEMENT_INTERNALS_ARIA_ACTIVE_DESCENDANT_ELEMENT_ATTRIBUTE_GETTER =
      4810;
  public static final int V8_ELEMENT_INTERNALS_ARIA_ACTIVE_DESCENDANT_ELEMENT_ATTRIBUTE_SETTER =
      4811;
  public static final int V8_ELEMENT_INTERNALS_ARIA_CONTROLS_ELEMENTS_ATTRIBUTE_GETTER = 4812;
  public static final int V8_ELEMENT_INTERNALS_ARIA_CONTROLS_ELEMENTS_ATTRIBUTE_SETTER = 4813;
  public static final int V8_ELEMENT_INTERNALS_ARIA_DESCRIBED_BY_ELEMENTS_ATTRIBUTE_GETTER = 4814;
  public static final int V8_ELEMENT_INTERNALS_ARIA_DESCRIBED_BY_ELEMENTS_ATTRIBUTE_SETTER = 4815;
  public static final int V8_ELEMENT_INTERNALS_ARIA_DETAILS_ELEMENTS_ATTRIBUTE_GETTER = 4816;
  public static final int V8_ELEMENT_INTERNALS_ARIA_DETAILS_ELEMENTS_ATTRIBUTE_SETTER = 4817;
  public static final int V8_ELEMENT_INTERNALS_ARIA_ERROR_MESSAGE_ELEMENTS_ATTRIBUTE_GETTER = 4818;
  public static final int V8_ELEMENT_INTERNALS_ARIA_ERROR_MESSAGE_ELEMENTS_ATTRIBUTE_SETTER = 4819;
  public static final int V8_ELEMENT_INTERNALS_ARIA_FLOW_TO_ELEMENTS_ATTRIBUTE_GETTER = 4820;
  public static final int V8_ELEMENT_INTERNALS_ARIA_FLOW_TO_ELEMENTS_ATTRIBUTE_SETTER = 4821;
  public static final int V8_ELEMENT_INTERNALS_ARIA_LABELLED_BY_ELEMENTS_ATTRIBUTE_GETTER = 4822;
  public static final int V8_ELEMENT_INTERNALS_ARIA_LABELLED_BY_ELEMENTS_ATTRIBUTE_SETTER = 4823;
  public static final int V8_ELEMENT_INTERNALS_ARIA_OWNS_ELEMENTS_ATTRIBUTE_GETTER = 4824;
  public static final int V8_ELEMENT_INTERNALS_ARIA_OWNS_ELEMENTS_ATTRIBUTE_SETTER = 4825;
  public static final int V8_ERROR_CAPTURE_STACK_TRACE = 2222;
  public static final int V8_ERROR_PREPARE_STACK_TRACE = 2223;
  public static final int V8_ERROR_STACK_TRACE_LIMIT = 2224;
  public static final int V8_EVENT_INIT_EVENT_METHOD = 867;
  public static final int V8_EVENT_STOP_IMMEDIATE_PROPAGATION_METHOD = 1685;
  public static final int V8_EVENT_STOP_PROPAGATION_METHOD = 1684;
  public static final int V8_EXTENDABLE_COOKIE_CHANGE_EVENT_CHANGED_ATTRIBUTE_GETTER = 2459;
  public static final int V8_EXTENDABLE_COOKIE_CHANGE_EVENT_DELETED_ATTRIBUTE_GETTER = 2460;
  public static final int V8_FETCH_LATER_RESULT_ACTIVATED_ATTRIBUTE_GETTER = 4646;
  public static final int V8_FILE_READER_SYNC_CONSTRUCTOR = 1812;
  public static final int V8_FILE_SYSTEM_DIRECTORY_HANDLE_GET_SYSTEM_DIRECTORY_METHOD = 3016;
  public static final int V8_FILE_SYSTEM_DIRECTORY_HANDLE_REMOVE_ENTRY_METHOD = 4567;
  public static final int V8_FILE_SYSTEM_DIRECTORY_HANDLE_RESOLVE_METHOD = 3178;
  public static final int V8_FILE_SYSTEM_FILE_HANDLE_CREATE_SYNC_ACCESS_HANDLE_METHOD = 4013;
  public static final int V8_FILE_SYSTEM_FILE_HANDLE_CREATE_WRITABLE_METHOD = 4568;
  public static final int V8_FILE_SYSTEM_FILE_HANDLE_GET_FILE_METHOD = 4569;
  public static final int V8_FILE_SYSTEM_HANDLE_GET_CLOUD_IDENTIFIERS_METHOD = 4655;
  public static final int V8_FILE_SYSTEM_HANDLE_GET_UNIQUE_ID_METHOD = 4570;
  public static final int V8_FILE_SYSTEM_HANDLE_IS_SAME_ENTRY_METHOD = 3179;
  public static final int V8_FILE_SYSTEM_HANDLE_REMOVE_METHOD = 4571;
  public static final int V8_FILE_SYSTEM_SYNC_ACCESS_HANDLE_CLOSE_METHOD = 4016;
  public static final int V8_FILE_SYSTEM_SYNC_ACCESS_HANDLE_FLUSH_METHOD = 4017;
  public static final int V8_FILE_SYSTEM_SYNC_ACCESS_HANDLE_GET_SIZE_METHOD = 4018;
  public static final int V8_FILE_SYSTEM_SYNC_ACCESS_HANDLE_READ_METHOD = 4014;
  public static final int V8_FILE_SYSTEM_SYNC_ACCESS_HANDLE_TRUNCATE_METHOD = 4019;
  public static final int V8_FILE_SYSTEM_SYNC_ACCESS_HANDLE_WRITE_METHOD = 4015;
  public static final int V8_FONT_DATA_BLOB_METHOD = 3385;
  public static final int V8_FONT_DATA_GET_TABLES_METHOD = 3384;
  public static final int V8_FOR_IN_INITIALIZER = 1238;
  public static final int V8_FRAGMENT_DIRECTIVE_CREATE_SELECTOR_DIRECTIVE_METHOD = 4065;
  public static final int V8_FRAGMENT_DIRECTIVE_ITEMS_ATTRIBUTE_GETTER = 4064;
  public static final int V8_FUNCTION_CONSTRUCTOR_RETURNED_UNDEFINED = 1446;
  public static final int V8_FUNCTION_PROTOTYPE_ARGUMENTS = 4179;
  public static final int V8_FUNCTION_PROTOTYPE_CALLER = 4180;
  public static final int V8_FUNCTION_TOKEN_OFFSET_TOO_LONG_FOR_TO_STRING = 2497;
  public static final int V8_GAIN_NODE_CONSTRUCTOR = 1714;
  public static final int V8_HEADERS_GET_ALL_METHOD = 1724;
  public static final int V8_HISTORY_SCROLL_RESTORATION_ATTRIBUTE_GETTER = 1028;
  public static final int V8_HISTORY_SCROLL_RESTORATION_ATTRIBUTE_SETTER = 1029;
  public static final int V8_IMPORT_ASSERTION_DEPRECATED_SYNTAX = 4528;
  public static final int V8_INDEX_ACCESSOR = 2238;
  public static final int V8_INPUT_DEVICE_CAPABILITIES_FIRES_TOUCH_EVENTS_ATTRIBUTE_GETTER = 1098;
  public static final int V8_INVALIDATED_ARRAY_BUFFER_DETACHING_PROTECTOR = 3257;
  public static final int V8_INVALIDATED_ARRAY_CONSTRUCTOR_PROTECTOR = 3258;
  public static final int V8_INVALIDATED_ARRAY_ITERATOR_LOOKUP_CHAIN_PROTECTOR = 3259;
  public static final int V8_INVALIDATED_ARRAY_SPECIES_LOOKUP_CHAIN_PROTECTOR = 3260;
  public static final int V8_INVALIDATED_IS_CONCAT_SPREADABLE_LOOKUP_CHAIN_PROTECTOR = 3261;
  public static final int V8_INVALIDATED_MAP_ITERATOR_LOOKUP_CHAIN_PROTECTOR = 3262;
  public static final int V8_INVALIDATED_NO_ELEMENTS_PROTECTOR = 3263;
  public static final int V8_INVALIDATED_NUMBER_STRING_NOT_REGEXP_LIKE_PROTECTOR = 4573;
  public static final int V8_INVALIDATED_PROMISE_HOOK_PROTECTOR = 3264;
  public static final int V8_INVALIDATED_PROMISE_RESOLVE_LOOKUP_CHAIN_PROTECTOR = 3265;
  public static final int V8_INVALIDATED_PROMISE_SPECIES_LOOKUP_CHAIN_PROTECTOR = 3266;
  public static final int V8_INVALIDATED_PROMISE_THEN_LOOKUP_CHAIN_PROTECTOR = 3267;
  public static final int V8_INVALIDATED_REG_EXP_SPECIES_LOOKUP_CHAIN_PROTECTOR = 3268;
  public static final int V8_INVALIDATED_SET_ITERATOR_LOOKUP_CHAIN_PROTECTOR = 3269;
  public static final int V8_INVALIDATED_STRING_ITERATOR_LOOKUP_CHAIN_PROTECTOR = 3270;
  public static final int V8_INVALIDATED_STRING_LENGTH_OVERFLOW_LOOKUP_CHAIN_PROTECTOR = 3271;
  public static final int V8_INVALIDATED_TYPED_ARRAY_SPECIES_LOOKUP_CHAIN_PROTECTOR = 3272;
  public static final int V8_KEYBOARD_EVENT_INIT_KEYBOARD_EVENT_METHOD = 868;
  public static final int V8_KEYFRAME_EFFECT_CONSTRUCTOR = 3126;
  public static final int V8_LEGACY_DATE_PARSER = 1404;
  public static final int V8_LOCK_MANAGER_QUERY_METHOD = 2376;
  public static final int V8_LOCK_MANAGER_REQUEST_METHOD = 2375;
  public static final int V8_MATH_ML_ELEMENT_FOCUSGROUP_ATTRIBUTE_GETTER = 4246;
  public static final int V8_MATH_ML_ELEMENT_FOCUSGROUP_ATTRIBUTE_SETTER = 4247;
  public static final int V8_MEDIA_CAPABILITIES_DECODING_INFO_METHOD = 2239;
  public static final int V8_MEDIA_CAPABILITIES_ENCODING_INFO_METHOD = 2240;
  public static final int V8_MEDIA_CAPABILITIES_INFO_POWER_EFFICIENT_ATTRIBUTE_GETTER = 2243;
  public static final int V8_MEDIA_CAPABILITIES_INFO_SMOOTH_ATTRIBUTE_GETTER = 2242;
  public static final int V8_MEDIA_CAPABILITIES_INFO_SUPPORTED_ATTRIBUTE_GETTER = 2241;
  public static final int V8_MEDIA_ELEMENT_AUDIO_SOURCE_NODE_CONSTRUCTOR = 1716;
  public static final int V8_MEDIA_KEYS_GET_STATUS_FOR_POLICY_METHOD = 2276;
  public static final int V8_MEDIA_LIST_ITEM_METHOD = 761;
  public static final int V8_MEDIA_RECORDER_START_METHOD = 1669;
  public static final int V8_MEDIA_SESSION_METADATA_ATTRIBUTE_GETTER = 1788;
  public static final int V8_MEDIA_SESSION_METADATA_ATTRIBUTE_SETTER = 1789;
  public static final int V8_MEDIA_SESSION_PLAYBACK_STATE_ATTRIBUTE_GETTER = 1790;
  public static final int V8_MEDIA_SESSION_PLAYBACK_STATE_ATTRIBUTE_SETTER = 1791;
  public static final int V8_MEDIA_SESSION_SET_ACTION_HANDLER_METHOD = 1792;
  public static final int V8_MEDIA_SESSION_SET_CAMERA_ACTIVE_METHOD = 3854;
  public static final int V8_MEDIA_SESSION_SET_MICROPHONE_ACTIVE_METHOD = 3853;
  public static final int V8_MEDIA_SESSION_SET_POSITION_STATE_METHOD = 2994;
  public static final int V8_MEDIA_STREAM_ACTIVE_ATTRIBUTE_GETTER = 1435;
  public static final int V8_MEDIA_STREAM_AUDIO_DESTINATION_NODE_CONSTRUCTOR = 1702;
  public static final int V8_MEDIA_STREAM_AUDIO_SOURCE_NODE_CONSTRUCTOR = 1717;
  public static final int V8_MEDIA_STREAM_TRACK_APPLY_CONSTRAINTS_METHOD = 4382;
  public static final int V8_MEDIA_STREAM_TRACK_CONTENT_HINT_ATTRIBUTE_GETTER = 2525;
  public static final int V8_MEDIA_STREAM_TRACK_CONTENT_HINT_ATTRIBUTE_SETTER = 2526;
  public static final int V8_MEDIA_STREAM_TRACK_STATS_ATTRIBUTE_GETTER = 4690;
  public static final int V8_MEMORY_INFO_JS_HEAP_SIZE_LIMIT_ATTRIBUTE_GETTER = 881;
  public static final int V8_MEMORY_INFO_TOTAL_JS_HEAP_SIZE_ATTRIBUTE_GETTER = 879;
  public static final int V8_MEMORY_INFO_USED_JS_HEAP_SIZE_ATTRIBUTE_GETTER = 880;
  public static final int V8_MESSAGE_CHANNEL_CONSTRUCTOR = 780;
  public static final int V8_MESSAGE_PORT_CLOSE_METHOD = 783;
  public static final int V8_MESSAGE_PORT_POST_MESSAGE_METHOD = 781;
  public static final int V8_MESSAGE_PORT_START_METHOD = 782;
  public static final int V8_METADATA_MODIFICATION_TIME_ATTRIBUTE_GETTER = 3108;
  public static final int V8_MOUSE_EVENT_INIT_MOUSE_EVENT_METHOD = 869;
  public static final int V8_MOUSE_EVENT_LAYER_X_ATTRIBUTE_GETTER = 858;
  public static final int V8_MOUSE_EVENT_LAYER_Y_ATTRIBUTE_GETTER = 859;
  public static final int V8_MUTATION_EVENT_INIT_MUTATION_EVENT_METHOD = 870;
  public static final int V8_NAVIGATOR_AD_AUCTION_COMPONENTS_METHOD = 4078;
  public static final int V8_NAVIGATOR_CREATE_AD_REQUEST_METHOD = 4053;
  public static final int V8_NAVIGATOR_CREATE_AUCTION_NONCE_METHOD = 4612;
  public static final int V8_NAVIGATOR_DEPRECATED_REPLACE_IN_URN_METHOD = 4227;
  public static final int V8_NAVIGATOR_DEPRECATED_URN_TO_URL_METHOD = 4108;
  public static final int V8_NAVIGATOR_FINALIZE_AD_METHOD = 4054;
  public static final int V8_NAVIGATOR_GET_INSTALLED_RELATED_APPS_METHOD = 1870;
  public static final int V8_NAVIGATOR_GET_INTEREST_GROUP_AD_AUCTION_DATA_METHOD = 4576;
  public static final int V8_NAVIGATOR_JAVA_ENABLED_METHOD = 3481;
  public static final int V8_NAVIGATOR_JOIN_AD_INTEREST_GROUP_METHOD = 3855;
  public static final int V8_NAVIGATOR_LEAVE_AD_INTEREST_GROUP_METHOD = 3856;
  public static final int V8_NAVIGATOR_MANAGED_DATA_GET_ANNOTATED_ASSET_ID_METHOD = 3980;
  public static final int V8_NAVIGATOR_MANAGED_DATA_GET_ANNOTATED_LOCATION_METHOD = 3981;
  public static final int V8_NAVIGATOR_MANAGED_DATA_GET_DIRECTORY_ID_METHOD = 3977;
  public static final int V8_NAVIGATOR_MANAGED_DATA_GET_HOSTNAME_METHOD = 3978;
  public static final int V8_NAVIGATOR_MANAGED_DATA_GET_SERIAL_NUMBER_METHOD = 3979;
  public static final int V8_NAVIGATOR_OPEN_TCP_SOCKET_METHOD = 3462;
  public static final int V8_NAVIGATOR_OPEN_UDP_SOCKET_METHOD = 3463;
  public static final int V8_NAVIGATOR_RUN_AD_AUCTION_METHOD = 3857;
  public static final int V8_NAVIGATOR_UPDATE_AD_INTEREST_GROUPS_METHOD = 3904;
  public static final int V8_NAVIGATOR_USER_MEDIA_ERROR_CONSTRAINT_NAME_ATTRIBUTE_GETTER = 1601;
  public static final int V8_NODE_IS_CONNECTED_ATTRIBUTE_GETTER = 1307;
  public static final int V8_OBJECT_PROTOTYPE_HAS_ELEMENTS = 3164;
  public static final int V8_OFFLINE_AUDIO_COMPLETION_EVENT_CONSTRUCTOR = 1718;
  public static final int V8_OFFLINE_AUDIO_CONTEXT_CONSTRUCTOR = 1699;
  public static final int V8_OSCILLATOR_NODE_CONSTRUCTOR = 1719;
  public static final int V8_PAINT_RENDERING_CONTEXT2_D_IS_POINT_IN_PATH_METHOD = 2683;
  public static final int V8_PAINT_RENDERING_CONTEXT2_D_IS_POINT_IN_STROKE_METHOD = 2684;
  public static final int V8_PAINT_WORKLET_GLOBAL_SCOPE_DEVICE_PIXEL_RATIO_ATTRIBUTE_GETTER = 2386;
  public static final int V8_PAINT_WORKLET_GLOBAL_SCOPE_REGISTER_PAINT_METHOD = 2385;
  public static final int V8_PANNER_NODE_CONSTRUCTOR = 1720;
  public static final int V8_PAYMENT_INSTRUMENTS_CLEAR_METHOD = 4230;
  public static final int V8_PAYMENT_INSTRUMENTS_DELETE_METHOD = 4231;
  public static final int V8_PAYMENT_INSTRUMENTS_GET_METHOD = 4232;
  public static final int V8_PAYMENT_INSTRUMENTS_HAS_METHOD = 4233;
  public static final int V8_PAYMENT_INSTRUMENTS_KEYS_METHOD = 4234;
  public static final int V8_PAYMENT_INSTRUMENTS_SET_METHOD = 4235;
  public static final int V8_PAYMENT_REQUEST_CAN_MAKE_PAYMENT_METHOD = 2685;
  public static final int V8_PAYMENT_REQUEST_HAS_ENROLLED_INSTRUMENT_METHOD = 2721;
  public static final int V8_PAYMENT_RESPONSE_RETRY_METHOD = 4095;
  public static final int V8_PENDING_BEACON_BACKGROUND_TIMEOUT_ATTRIBUTE_GETTER = 4320;
  public static final int V8_PENDING_BEACON_BACKGROUND_TIMEOUT_ATTRIBUTE_SETTER = 4321;
  public static final int V8_PENDING_BEACON_DEACTIVATE_METHOD = 4281;
  public static final int V8_PENDING_BEACON_METHOD_ATTRIBUTE_GETTER = 4276;
  public static final int V8_PENDING_BEACON_PENDING_ATTRIBUTE_GETTER = 4319;
  public static final int V8_PENDING_BEACON_SEND_NOW_METHOD = 4283;
  public static final int V8_PENDING_BEACON_TIMEOUT_ATTRIBUTE_GETTER = 4322;
  public static final int V8_PENDING_BEACON_TIMEOUT_ATTRIBUTE_SETTER = 4323;
  public static final int V8_PENDING_BEACON_URL_ATTRIBUTE_GETTER = 4274;
  public static final int V8_PENDING_GET_BEACON_CONSTRUCTOR = 4324;
  public static final int V8_PENDING_GET_BEACON_SET_URL_METHOD = 4325;
  public static final int V8_PENDING_POST_BEACON_CONSTRUCTOR = 4326;
  public static final int V8_PENDING_POST_BEACON_SET_DATA_METHOD = 4327;
  public static final int V8_PERFORMANCE_MEMORY_ATTRIBUTE_GETTER = 884;
  public static final int V8_PERFORMANCE_NAVIGATION_ATTRIBUTE_GETTER = 883;
  public static final int V8_PERFORMANCE_RESOURCE_TIMING_DELIVERY_TYPE_ATTRIBUTE_GETTER = 4392;
  public static final int V8_PERFORMANCE_TIMING_ATTRIBUTE_GETTER = 882;
  public static final int V8_PERIODIC_WAVE_CONSTRUCTOR = 1721;
  public static final int V8_PERMISSIONS_QUERY_METHOD = 750;
  public static final int V8_PERMISSIONS_REQUEST_ALL_METHOD = 983;
  public static final int V8_PERMISSIONS_REQUEST_METHOD = 915;
  public static final int V8_PERMISSIONS_REVOKE_METHOD = 898;
  public static final int V8_PICTURE_IN_PICTURE_WINDOW_HEIGHT_ATTRIBUTE_GETTER = 2447;
  public static final int V8_PICTURE_IN_PICTURE_WINDOW_WIDTH_ATTRIBUTE_GETTER = 2448;
  public static final int V8_POINTER_EVENT_ALTITUDE_ANGLE_ATTRIBUTE_GETTER = 3352;
  public static final int V8_POINTER_EVENT_AZIMUTH_ANGLE_ATTRIBUTE_GETTER = 3351;
  public static final int V8_POINTER_EVENT_DEVICE_ID_ATTRIBUTE_GETTER = 4675;
  public static final int V8_POINTER_EVENT_GET_COALESCED_EVENTS_METHOD = 4859;
  public static final int V8_POINTER_EVENT_GET_PREDICTED_EVENTS_METHOD = 2971;
  public static final int V8_PORTAL_ACTIVATE_EVENT_ADOPT_PREDECESSOR_METHOD = 3102;
  public static final int V8_PORTAL_ACTIVATE_EVENT_DATA_ATTRIBUTE_GETTER = 3101;
  public static final int V8_PORTAL_HOST_POST_MESSAGE_METHOD = 3100;
  public static final int V8_PROMISE_CONSTRUCTOR_RETURNED_UNDEFINED = 1766;
  public static final int V8_PUSH_MANAGER_SUPPORTED_CONTENT_ENCODINGS_ATTRIBUTE_GETTER = 3507;
  public static final int V8_RANGE_GET_BOUNDING_CLIENT_RECT_METHOD = 2221;
  public static final int V8_RANGE_GET_CLIENT_RECTS_METHOD = 2220;
  public static final int V8_REG_EXP_EXEC_CALLED_ON_SLOW_REG_EXP = 3064;
  public static final int V8_REG_EXP_MATCH_IS_FALSEISH_ON_JS_REG_EXP = 2651;
  public static final int V8_REG_EXP_MATCH_IS_TRUEISH_ON_NON_JS_REG_EXP = 2650;
  public static final int V8_REG_EXP_PROTOTYPE_STICKY_GETTER = 1096;
  public static final int V8_REG_EXP_PROTOTYPE_TO_STRING = 1097;
  public static final int V8_REG_EXP_PROTOTYPE_UNICODE_GETTER = 1133;
  public static final int V8_REG_EXP_REPLACE_CALLED_ON_SLOW_REG_EXP = 3065;
  public static final int V8_REMOTE_PLAYBACK_PROMPT_METHOD = 2781;
  public static final int V8_REMOTE_PLAYBACK_WATCH_AVAILABILITY_METHOD = 2780;
  public static final int V8_SCREEN_AVAIL_HEIGHT_ATTRIBUTE_GETTER = 2699;
  public static final int V8_SCREEN_AVAIL_LEFT_ATTRIBUTE_GETTER = 786;
  public static final int V8_SCREEN_AVAIL_TOP_ATTRIBUTE_GETTER = 787;
  public static final int V8_SCREEN_AVAIL_WIDTH_ATTRIBUTE_GETTER = 2700;
  public static final int V8_SCREEN_COLOR_DEPTH_ATTRIBUTE_GETTER = 2701;
  public static final int V8_SCREEN_DETAILED_DEVICE_PIXEL_RATIO_ATTRIBUTE_GETTER = 3846;
  public static final int V8_SCREEN_DETAILED_ID_ATTRIBUTE_GETTER = 3847;
  public static final int V8_SCREEN_DETAILED_IS_INTERNAL_ATTRIBUTE_GETTER = 3845;
  public static final int V8_SCREEN_DETAILED_IS_PRIMARY_ATTRIBUTE_GETTER = 3844;
  public static final int V8_SCREEN_DETAILED_LABEL_ATTRIBUTE_GETTER = 3849;
  public static final int V8_SCREEN_DETAILED_LEFT_ATTRIBUTE_GETTER = 3842;
  public static final int V8_SCREEN_DETAILED_POINTER_TYPES_ATTRIBUTE_GETTER = 3848;
  public static final int V8_SCREEN_DETAILED_TOP_ATTRIBUTE_GETTER = 3843;
  public static final int V8_SCREEN_DETAILS_ONCURRENTSCREENCHANGE_ATTRIBUTE_GETTER = 3907;
  public static final int V8_SCREEN_DETAILS_ONCURRENTSCREENCHANGE_ATTRIBUTE_SETTER = 3908;
  public static final int V8_SCREEN_DETAILS_ONSCREENSCHANGE_ATTRIBUTE_GETTER = 3905;
  public static final int V8_SCREEN_DETAILS_ONSCREENSCHANGE_ATTRIBUTE_SETTER = 3906;
  public static final int V8_SCREEN_HEIGHT_ATTRIBUTE_GETTER = 2702;
  public static final int V8_SCREEN_PIXEL_DEPTH_ATTRIBUTE_GETTER = 2703;
  public static final int V8_SCREEN_WIDTH_ATTRIBUTE_GETTER = 2704;
  public static final int V8_SECURITY_POLICY_VIOLATION_EVENT_BLOCKED_URI_ATTRIBUTE_GETTER = 807;
  public static final int V8_SECURITY_POLICY_VIOLATION_EVENT_DOCUMENT_URI_ATTRIBUTE_GETTER = 806;
  public static final int V8_SECURITY_POLICY_VIOLATION_EVENT_STATUS_CODE_ATTRIBUTE_GETTER = 808;
  public static final int V8_SHADOW_ROOT_ELEMENTS_FROM_POINT_METHOD = 3503;
  public static final int V8_SHADOW_ROOT_ELEMENT_FROM_POINT_METHOD = 3502;
  public static final int V8_SHADOW_ROOT_GET_ANIMATIONS_METHOD = 3188;
  public static final int V8_SHADOW_ROOT_PICTURE_IN_PICTURE_ELEMENT_ATTRIBUTE_GETTER = 2441;
  public static final int V8_SHARED_ARRAY_BUFFER_CONSTRUCTED = 3114;
  public static final int V8_SHARED_ARRAY_BUFFER_CONSTRUCTED_IN_EXTENSION_WITHOUT_ISOLATION = 4020;
  public static final int V8_SHARED_ARRAY_BUFFER_CONSTRUCTED_WITHOUT_ISOLATION = 3721;
  public static final int V8_SHARED_WORKER_WORKER_START_ATTRIBUTE_GETTER = 885;
  public static final int V8_SLOPPY_MODE = 1075;
  public static final int V8_SLOPPY_MODE_BLOCK_SCOPED_FUNCTION_REDEFINITION = 1237;
  public static final int V8_SOURCE_BUFFER_APPEND_ENCODED_CHUNKS_METHOD = 3735;
  public static final int V8_SOURCE_BUFFER_CHANGE_TYPE_METHOD = 2523;
  public static final int V8_SPEECH_GRAMMAR_CONSTRUCTOR = 2986;
  public static final int V8_SPEECH_GRAMMAR_LIST_ADD_FROM_STRING_METHOD = 2987;
  public static final int V8_SPEECH_GRAMMAR_LIST_ADD_FROM_URI_METHOD = 2480;
  public static final int V8_SPEECH_GRAMMAR_LIST_CONSTRUCTOR = 2988;
  public static final int V8_SPEECH_GRAMMAR_LIST_ITEM_METHOD = 2989;
  public static final int V8_SPEECH_RECOGNITION_CONSTRUCTOR = 2990;
  public static final int V8_SPEECH_RECOGNITION_GRAMMARS_ATTRIBUTE_GETTER = 2991;
  public static final int V8_SPEECH_RECOGNITION_GRAMMARS_ATTRIBUTE_SETTER = 2992;
  public static final int V8_SPEECH_RECOGNITION_START_METHOD = 2014;
  public static final int V8_SPEECH_SYNTHESIS_SPEAK_METHOD = 2483;
  public static final int V8_STEREO_PANNER_NODE_CONSTRUCTOR = 1722;
  public static final int V8_STORAGE_BUCKET_CACHES_ATTRIBUTE_GETTER = 4516;
  public static final int V8_STORAGE_BUCKET_DURABILITY_METHOD = 4511;
  public static final int V8_STORAGE_BUCKET_ESTIMATE_METHOD = 4510;
  public static final int V8_STORAGE_BUCKET_EXPIRES_METHOD = 4513;
  public static final int V8_STORAGE_BUCKET_GET_DIRECTORY_METHOD = 4517;
  public static final int V8_STORAGE_BUCKET_INDEXED_DB_ATTRIBUTE_GETTER = 4514;
  public static final int V8_STORAGE_BUCKET_LOCKS_ATTRIBUTE_GETTER = 4515;
  public static final int V8_STORAGE_BUCKET_MANAGER_DELETE_METHOD = 4519;
  public static final int V8_STORAGE_BUCKET_MANAGER_KEYS_METHOD = 4518;
  public static final int V8_STORAGE_BUCKET_PERSISTED_METHOD = 4509;
  public static final int V8_STORAGE_BUCKET_PERSIST_METHOD = 4508;
  public static final int V8_STORAGE_BUCKET_SET_EXPIRES_METHOD = 4512;
  public static final int V8_STORAGE_EVENT_INIT_STORAGE_EVENT_METHOD = 871;
  public static final int V8_STORAGE_MANAGER_GET_DIRECTORY_METHOD = 3428;
  public static final int V8_STRICT_MODE = 1076;
  public static final int V8_STRING_NORMALIZE = 2795;
  public static final int V8_STYLE_SHEET_LIST_ITEM_METHOD = 762;
  public static final int V8_TEMPORAL_OBJECT = 4681;
  public static final int V8_TEXT_EVENT_DATA_ATTRIBUTE_GETTER = 831;
  public static final int V8_TEXT_EVENT_INIT_TEXT_EVENT_METHOD = 832;
  public static final int V8_TOUCH_FORCE_ATTRIBUTE_GETTER = 3542;
  public static final int V8_TURBO_FAN_OSR_COMPILE_STARTED = 4346;
  public static final int V8_USER_ACTIVATION_HAS_BEEN_ACTIVE_ATTRIBUTE_GETTER = 2785;
  public static final int V8_USER_ACTIVATION_IS_ACTIVE_ATTRIBUTE_GETTER = 2786;
  public static final int V8_VAR_REDECLARED_CATCH_BINDING = 3304;
  public static final int V8_VIDEO_PLAYBACK_QUALITY_CORRUPTED_VIDEO_FRAMES_ATTRIBUTE_GETTER = 3117;
  public static final int V8_VISUAL_VIEWPORT_HEIGHT_ATTRIBUTE_GETTER = 1463;
  public static final int V8_VISUAL_VIEWPORT_OFFSET_LEFT_ATTRIBUTE_GETTER = 1458;
  public static final int V8_VISUAL_VIEWPORT_OFFSET_TOP_ATTRIBUTE_GETTER = 1459;
  public static final int V8_VISUAL_VIEWPORT_PAGE_LEFT_ATTRIBUTE_GETTER = 1460;
  public static final int V8_VISUAL_VIEWPORT_PAGE_TOP_ATTRIBUTE_GETTER = 1461;
  public static final int V8_VISUAL_VIEWPORT_SCALE_ATTRIBUTE_GETTER = 1464;
  public static final int V8_VISUAL_VIEWPORT_WIDTH_ATTRIBUTE_GETTER = 1462;
  public static final int V8_WASM_EXCEPTION_HANDLING = 3800;
  public static final int V8_WASM_EXN_REF = 4769;
  public static final int V8_WASM_EXTENDED_CONST = 4766;
  public static final int V8_WASM_GC = 4617;
  public static final int V8_WASM_JAVA_SCRIPT_PROMISE_INTEGRATION = 4760;
  public static final int V8_WASM_MEMORY64 = 4615;
  public static final int V8_WASM_MULTI_MEMORY = 4616;
  public static final int V8_WASM_REF_TYPES = 3321;
  public static final int V8_WASM_RELAXED_SIMD = 4767;
  public static final int V8_WASM_RETURN_CALL = 4765;
  public static final int V8_WASM_SHARED_MEMORY = 2532;
  public static final int V8_WASM_SIMD_OPCODES = 3287;
  public static final int V8_WASM_THREAD_OPCODES = 2533;
  public static final int V8_WASM_TYPED_FUNC_REF = 4770;
  public static final int V8_WASM_TYPE_REFLECTION = 4768;
  public static final int V8_WAVE_SHAPER_NODE_CONSTRUCTOR = 1723;
  public static final int V8_WEB_ASSEMBLY_JS_STRING_BUILTINS = 4671;
  public static final int V8_WEB_GL2_COMPUTE_RENDERING_CONTEXT_GET_EXTENSION_METHOD = 2693;
  public static final int V8_WEB_GL2_COMPUTE_RENDERING_CONTEXT_GET_SUPPORTED_EXTENSIONS_METHOD =
      2694;
  public static final int V8_WEB_GL2_RENDERING_CONTEXT_GET_EXTENSION_METHOD = 2695;
  public static final int V8_WEB_GL2_RENDERING_CONTEXT_GET_SUPPORTED_EXTENSIONS_METHOD = 2696;
  public static final int V8_WEB_GL_COMPRESSED_TEXTURE_ASTC_GET_SUPPORTED_PROFILES_METHOD = 3544;
  public static final int V8_WEB_GL_RENDERING_CONTEXT_GET_EXTENSION_METHOD = 2697;
  public static final int V8_WEB_GL_RENDERING_CONTEXT_GET_SUPPORTED_EXTENSIONS_METHOD = 2698;
  public static final int V8_WHEEL_EVENT_DELTA_MODE_ATTRIBUTE_GETTER = 3541;
  public static final int V8_WINDOW_ALERT_METHOD = 950;
  public static final int V8_WINDOW_CHOOSE_FILE_SYSTEM_ENTRIES_METHOD = 3015;
  public static final int V8_WINDOW_CONFIRM_METHOD = 951;
  public static final int V8_WINDOW_FETCH_LATER_METHOD = 4647;
  public static final int V8_WINDOW_GET_SCREEN_DETAILS_METHOD = 3388;
  public static final int V8_WINDOW_MATCH_MEDIA_METHOD = 2707;
  public static final int V8_WINDOW_PORTAL_HOST_ATTRIBUTE_GETTER = 3099;
  public static final int V8_WINDOW_PRINT_METHOD = 953;
  public static final int V8_WINDOW_PROMPT_METHOD = 952;
  public static final int V8_WINDOW_QUERY_LOCAL_FONTS_METHOD = 4211;
  public static final int V8_WINDOW_REQUEST_IDLE_CALLBACK_METHOD = 954;
  public static final int V8_WINDOW_SHOW_DIRECTORY_PICKER_METHOD = 3342;
  public static final int V8_WINDOW_SHOW_OPEN_FILE_PICKER_METHOD = 3340;
  public static final int V8_WINDOW_SHOW_SAVE_FILE_PICKER_METHOD = 3341;
  public static final int V8_WINDOW_SPEECH_SYNTHESIS_ATTRIBUTE_GETTER = 1272;
  public static final int V8_WINDOW_WEBKIT_MEDIA_STREAM_CONSTRUCTOR_GETTER = 2538;
  public static final int V8_WINDOW_WEBKIT_RTC_PEER_CONNECTION_CONSTRUCTOR_GETTER = 2537;
  public static final int V8_WINDOW_WEBKIT_SPEECH_GRAMMAR_CONSTRUCTOR_GETTER = 1267;
  public static final int V8_WINDOW_WEBKIT_SPEECH_GRAMMAR_LIST_CONSTRUCTOR_GETTER = 1268;
  public static final int V8_WINDOW_WEBKIT_SPEECH_RECOGNITION_CONSTRUCTOR_GETTER = 1269;
  public static final int V8_WINDOW_WEBKIT_SPEECH_RECOGNITION_ERROR_CONSTRUCTOR_GETTER = 1270;
  public static final int V8_WINDOW_WEBKIT_SPEECH_RECOGNITION_EVENT_CONSTRUCTOR_GETTER = 1271;
  public static final int V8_WINDOW_WEB_KIT_ANIMATION_EVENT_CONSTRUCTOR_GETTER = 707;
  public static final int VALID_POPOVER_ATTRIBUTE = 4191;
  public static final int VERTICAL_SCROLLBAR_THUMB_SCROLLING_WITH_MOUSE = 2876;
  public static final int VERTICAL_SCROLLBAR_THUMB_SCROLLING_WITH_TOUCH = 2877;
  public static final int VIDEO_IN_CANVAS = 1622;
  public static final int VIDEO_TRACK_GENERATOR = 4173;
  public static final int VIEWPORT_DEPENDENT_LAZY_LOADED_IMAGE_WITHOUT_SIZES_ATTRIBUTE = 4381;
  public static final int VIEWPORT_DEPENDENT_LAZY_LOADED_IMAGE_WITH_SIZES_ATTRIBUTE = 4351;
  public static final int VIEWPORT_FIT_CONTAIN = 4662;
  public static final int VIEWPORT_FIT_COVER = 4663;
  public static final int VIEWPORT_FIT_COVER_OR_SAFE_AREA_INSET_BOTTOM = 4664;
  public static final int VIEWPORT_FIXED_POSITION_UNDER_FILTER = 1961;
  public static final int VIEW_TIMELINE_CONSTRUCTOR = 4271;
  public static final int VIEW_TRANSITION = 4383;
  public static final int VIEW_TRANSITION_NAME_AUTO = 4759;
  public static final int VIRTUAL_KEYBOARD_HIDE = 4641;
  public static final int VIRTUAL_KEYBOARD_OVERLAY_POLICY = 4642;
  public static final int VIRTUAL_KEYBOARD_SHOW = 4640;
  public static final int VISIBILITY_STATE_OBSERVER = 4542;
  public static final int VISUAL_VIEWPORT_RESIZE_FIRED = 1466;
  public static final int VISUAL_VIEWPORT_SCROLL_END_FIRED = 4792;
  public static final int VISUAL_VIEWPORT_SCROLL_FIRED = 1465;
  public static final int VR_DEPRECATED_FIELD_OF_VIEW = 1621;
  public static final int VR_DISPLAY_DISPLAY_NAME = 1861;
  public static final int VR_DISPLAY_GET_FRAME_DATA = 2390;
  public static final int VR_EYE_PARAMETERS_OFFSET = 1862;
  public static final int VR_GET_DISPLAYS = 1558;
  public static final int VR_GET_DISPLAYS_INSECURE_ORIGIN = 1618;
  public static final int VR_GET_DISPLAYS_SUPPORTS_PRESENT = 2249;
  public static final int VR_POSE_ANGULAR_ACCELERATION = 1866;
  public static final int VR_POSE_ANGULAR_VELOCITY = 1865;
  public static final int VR_POSE_LINEAR_ACCELERATION = 1864;
  public static final int VR_POSE_LINEAR_VELOCITY = 1863;
  public static final int VR_REQUEST_PRESENT = 1619;
  public static final int VR_REQUEST_PRESENT_INSECURE_ORIGIN = 1620;
  public static final int VTT_CUE = 409;
  public static final int VTT_CUE_PARSER = 2891;
  public static final int VTT_CUE_RENDER = 410;
  public static final int VTT_CUE_RENDER_ALIGN_NOT_CENTER = 416;
  public static final int VTT_CUE_RENDER_LINE_NOT_AUTO = 413;
  public static final int VTT_CUE_RENDER_POSITION_NOT50 = 414;
  public static final int VTT_CUE_RENDER_RTL = 418;
  public static final int VTT_CUE_RENDER_SIZE_NOT100 = 415;
  public static final int VTT_CUE_RENDER_SNAP_TO_LINES_FALSE = 412;
  public static final int VTT_CUE_RENDER_VERTICAL = 411;
  public static final int WAKE_LOCK_ACQUIRE_SCREEN_LOCK = 3005;
  public static final int WAKE_LOCK_ACQUIRE_SCREEN_LOCK_WITHOUT_STICKY_ACTIVATION = 4744;
  public static final int WAKE_LOCK_ACQUIRE_SYSTEM_LOCK = 3006;
  public static final int WEBKIT_BEFORE_TEXT_INSERTED_ON_CONTENT_EDITABLE = 1595;
  public static final int WEBKIT_BEFORE_TEXT_INSERTED_ON_INPUT = 1593;
  public static final int WEBKIT_BEFORE_TEXT_INSERTED_ON_NOT_NODE = 1596;
  public static final int WEBKIT_BEFORE_TEXT_INSERTED_ON_TEXT_AREA = 1594;
  public static final int WEBKIT_BOX_ALIGN_NOT_INITIAL = 2126;
  public static final int WEBKIT_BOX_CHILD_FLEX_GROUP_NOT_INITIAL = 2131;
  public static final int WEBKIT_BOX_CHILD_FLEX_NOT_INITIAL = 2130;
  public static final int WEBKIT_BOX_CHILD_ORDINAL_GROUP_NOT_INITIAL = 2132;
  public static final int WEBKIT_BOX_DIRECTION_NOT_INITIAL = 2127;
  public static final int WEBKIT_BOX_LAYOUT = 2123;
  public static final int WEBKIT_BOX_LAYOUT_HORIZONTAL = 2124;
  public static final int WEBKIT_BOX_LAYOUT_VERTICAL = 2125;
  public static final int WEBKIT_BOX_LINES_NOT_INITIAL = 2128;
  public static final int WEBKIT_BOX_LINE_CLAMP = 2138;
  public static final int WEBKIT_BOX_LINE_CLAMP_DOES_SOMETHING = 2144;
  public static final int WEBKIT_BOX_LINE_CLAMP_MANY_CHILDREN = 2143;
  public static final int WEBKIT_BOX_LINE_CLAMP_NO_CHILDREN = 2140;
  public static final int WEBKIT_BOX_LINE_CLAMP_ONE_CHILD = 2141;
  public static final int WEBKIT_BOX_LINE_CLAMP_ONE_CHILD_IS_LAYOUT_BLOCK_FLOW_INLINE = 2142;
  public static final int WEBKIT_BOX_LINE_CLAMP_PERCENTAGE = 2139;
  public static final int WEBKIT_BOX_MANY_CHILDREN = 2137;
  public static final int WEBKIT_BOX_NOT_DEFAULT_ORDER = 2133;
  public static final int WEBKIT_BOX_NO_CHILDREN = 2134;
  public static final int WEBKIT_BOX_ONE_CHILD = 2135;
  public static final int WEBKIT_BOX_ONE_CHILD_IS_LAYOUT_BLOCK_FLOW_INLINE = 2136;
  public static final int WEBKIT_BOX_PACK_CENTER_DOES_SOMETHING = 3124;
  public static final int WEBKIT_BOX_PACK_END_DOES_SOMETHING = 3125;
  public static final int WEBKIT_BOX_PACK_JUSTIFY_DOES_SOMETHING = 3123;
  public static final int WEBKIT_BOX_PACK_NOT_INITIAL = 2129;
  public static final int WEBKIT_BOX_WITHOUT_WEBKIT_LINE_CLAMP = 4355;
  public static final int WEBKIT_CROSS_FADE = 2357;
  public static final int WEBKIT_CSS_MATRIX_CONSTRUCT_FROM_STRING = 1913;
  public static final int WEBKIT_CSS_MATRIX_SET_MATRIX_VALUE = 1912;
  public static final int WEBKIT_EDITABLE_CONTENT_CHANGED_ON_CONTENT_EDITABLE = 1599;
  public static final int WEBKIT_EDITABLE_CONTENT_CHANGED_ON_INPUT = 1597;
  public static final int WEBKIT_EDITABLE_CONTENT_CHANGED_ON_NOT_NODE = 1600;
  public static final int WEBKIT_EDITABLE_CONTENT_CHANGED_ON_TEXT_AREA = 1598;
  public static final int WEBKIT_IMAGE_SET = 3947;
  public static final int WEBKIT_LINE_CLAMP_WITHOUT_WEBKIT_BOX = 3327;
  public static final int WEBKIT_MARGIN_AFTER_COLLAPSE_DISCARD = 2945;
  public static final int WEBKIT_MARGIN_AFTER_COLLAPSE_SEPARATE = 2946;
  public static final int WEBKIT_MARGIN_AFTER_COLLAPSE_SEPARATE_MAYBE_DOES_SOMETHING = 2947;
  public static final int WEBKIT_MARGIN_BEFORE_COLLAPSE_DISCARD = 2942;
  public static final int WEBKIT_MARGIN_BEFORE_COLLAPSE_SEPARATE = 2943;
  public static final int WEBKIT_MARGIN_BEFORE_COLLAPSE_SEPARATE_MAYBE_DOES_SOMETHING = 2944;
  public static final int WEB_APP_BORDERLESS = 4228;
  public static final int WEB_APP_MANIFEST_CAPTURE_LINKS = 3813;
  public static final int WEB_APP_MANIFEST_HAS_COMMENTS = 4067;
  public static final int WEB_APP_MANIFEST_ID_FIELD = 4722;
  public static final int WEB_APP_MANIFEST_LAUNCH_HANDLER = 4080;
  public static final int WEB_APP_MANIFEST_PROTOCOL_HANDLERS = 3884;
  public static final int WEB_APP_MANIFEST_SCOPE_EXTENSIONS = 4456;
  public static final int WEB_APP_MANIFEST_URL_HANDLERS = 3851;
  public static final int WEB_APP_MANIFEST_USER_PREFERENCES = 4096;
  public static final int WEB_APP_TABBED = 4608;
  public static final int WEB_APP_WINDOW_CONTROLS_OVERLAY = 3902;
  public static final int WEB_ASSEMBLY_INSTANTIATION = 2237;
  public static final int WEB_ASSEMBLY_MODULE_COMPILATION = 4689;
  public static final int WEB_AUDIO_AUTOPLAY_CROSS_ORIGIN_IFRAME = 1556;
  public static final int WEB_AUDIO_CONSTANT_SOURCE_NODE = 1651;
  public static final int WEB_AUTHN_CONDITIONAL_UI_GET = 4357;
  public static final int WEB_AUTHN_CONDITIONAL_UI_GET_SUCCESS = 4358;
  public static final int WEB_AUTHN_RK_REQUIRED_CREATION_SUCCESS = 4359;
  public static final int WEB_BLUETOOTH_GET_AVAILABILITY = 3708;
  public static final int WEB_BLUETOOTH_GET_DEVICES = 3328;
  public static final int WEB_BLUETOOTH_MANUFACTURER_DATA_FILTER = 3896;
  public static final int WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_GET_DESCRIPTOR = 1882;
  public static final int WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_GET_DESCRIPTORS = 1883;
  public static final int WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_READ_VALUE = 1884;
  public static final int WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_START_NOTIFICATIONS = 1886;
  public static final int WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_STOP_NOTIFICATIONS = 1887;
  public static final int WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_WRITE_VALUE = 1885;
  public static final int WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_WRITE_VALUE_WITHOUT_RESPONSE = 3306;
  public static final int WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_WRITE_VALUE_WITH_RESPONSE = 3305;
  public static final int WEB_BLUETOOTH_REMOTE_DESCRIPTOR_READ_VALUE = 1888;
  public static final int WEB_BLUETOOTH_REMOTE_DESCRIPTOR_WRITE_VALUE = 1889;
  public static final int WEB_BLUETOOTH_REMOTE_SERVER_CONNECT = 1890;
  public static final int WEB_BLUETOOTH_REMOTE_SERVER_DISCONNECT = 1891;
  public static final int WEB_BLUETOOTH_REMOTE_SERVER_GET_PRIMARY_SERVICE = 1892;
  public static final int WEB_BLUETOOTH_REMOTE_SERVER_GET_PRIMARY_SERVICES = 1893;
  public static final int WEB_BLUETOOTH_REMOTE_SERVICE_GET_CHARACTERISTIC = 1894;
  public static final int WEB_BLUETOOTH_REMOTE_SERVICE_GET_CHARACTERISTICS = 1895;
  public static final int WEB_BLUETOOTH_REQUEST_DEVICE = 1670;
  public static final int WEB_BLUETOOTH_REQUEST_SCAN = 2664;
  public static final int WEB_BLUETOOTH_WATCH_ADVERTISEMENTS = 3312;
  public static final int WEB_CODECS = 3464;
  public static final int WEB_CODECS_AUDIO_DECODER = 3456;
  public static final int WEB_CODECS_AUDIO_ENCODER = 3751;
  public static final int WEB_CODECS_IMAGE_DECODER = 3460;
  public static final int WEB_CODECS_VIDEO_DECODER = 3457;
  public static final int WEB_CODECS_VIDEO_ENCODER = 3458;
  public static final int WEB_CODECS_VIDEO_FRAME_FROM_BUFFER = 4072;
  public static final int WEB_CODECS_VIDEO_FRAME_FROM_IMAGE = 4071;
  public static final int WEB_CODECS_VIDEO_TRACK_READER = 3459;
  public static final int WEB_GL2_RENDERING_CONTEXT_GET_INTERNAL_FORMAT_PARAMETER = 3571;
  public static final int WEB_GL_DEBUG_RENDERER_INFO = 2692;
  public static final int WEB_GL_RENDERING_CONTEXT_GET_PARAMETER = 3568;
  public static final int WEB_GL_RENDERING_CONTEXT_GET_RENDERBUFFER_PARAMETER = 3569;
  public static final int WEB_GL_RENDERING_CONTEXT_GET_SHADER_PRECISION_FORMAT = 3570;
  public static final int WEB_GL_RENDERING_CONTEXT_MAKE_XR_COMPATIBLE = 3543;
  public static final int WEB_GPU_CANVAS_CONTEXT_GET_CURRENT_TEXTURE = 4587;
  public static final int WEB_GPU_QUEUE_SUBMIT = 4586;
  public static final int WEB_GPU_REQUEST_ADAPTER = 3888;
  public static final int WEB_KIT_CSS_MATRIX = 630;
  public static final int WEB_KIT_USER_MODIFY_EFFECTIVE = 2630;
  public static final int WEB_KIT_USER_MODIFY_PLAIN_TEXT_EFFECTIVE = 2640;
  public static final int WEB_KIT_USER_MODIFY_READ_ONLY_EFFECTIVE = 2639;
  public static final int WEB_KIT_USER_MODIFY_READ_WRITE_EFFECTIVE = 2638;
  public static final int WEB_NFC_NDEF_MAKE_READ_ONLY = 4107;
  public static final int WEB_NFC_NDEF_READER_SCAN = 3094;
  public static final int WEB_NFC_NDEF_WRITER_WRITE = 3095;
  public static final int WEB_OTP = 2880;
  public static final int WEB_P_IMAGE = 3797;
  public static final int WEB_SHARE_CAN_SHARE = 2737;
  public static final int WEB_SHARE_CONTAINING_FILES = 4038;
  public static final int WEB_SHARE_CONTAINING_TEXT = 4040;
  public static final int WEB_SHARE_CONTAINING_TITLE = 4039;
  public static final int WEB_SHARE_CONTAINING_URL = 4041;
  public static final int WEB_SHARE_POLICY_ALLOW = 3368;
  public static final int WEB_SHARE_POLICY_DISALLOW = 3369;
  public static final int WEB_SHARE_SHARE = 1501;
  public static final int WEB_SHARE_SUCCESSFUL_CONTAINING_FILES = 2872;
  public static final int WEB_SHARE_SUCCESSFUL_WITHOUT_FILES = 2873;
  public static final int WEB_SHARE_UNSUCCESSFUL_CONTAINING_FILES = 2874;
  public static final int WEB_SHARE_UNSUCCESSFUL_WITHOUT_FILES = 2875;
  public static final int WEB_SOCKET = 1149;
  public static final int WEB_SOCKET_STREAM_CONSTRUCTOR = 3018;
  public static final int WEB_TRANSPORT = 3472;
  public static final int WEB_TRANSPORT_SERVER_CERTIFICATE_HASHES = 4112;
  public static final int WEB_XR_FRAMEBUFFER_SCALE = 2906;
  public static final int WEB_XR_IGNORE_DEPTH_VALUES = 2907;
  public static final int WEB_XR_SESSION_CREATED = 2908;
  public static final int WHEEL_EVENT = 1126;
  public static final int WHEEL_EVENT_WHEEL_DELTA = 493;
  public static final int WHEEL_EVENT_WHEEL_DELTA_X = 491;
  public static final int WHEEL_EVENT_WHEEL_DELTA_Y = 492;
  public static final int WHITE_SPACE_NOWRAP_FROM_XML_SPACE = 680;
  public static final int WHITE_SPACE_PRE_FROM_XML_SPACE = 679;
  public static final int WINDOW_CAPTURE_EVENTS = 289;
  public static final int WINDOW_CLIENT_INFORMATION = 695;
  public static final int WINDOW_CLOSED = 3371;
  public static final int WINDOW_CLOSE_HISTORY_LENGTH_ONE = 4414;
  public static final int WINDOW_DEFAULTSTATUS = 358;
  public static final int WINDOW_DEFAULT_STATUS = 357;
  public static final int WINDOW_DEVICE_PIXEL_RATIO = 2716;
  public static final int WINDOW_EVENT = 69;
  public static final int WINDOW_FIND = 696;
  public static final int WINDOW_FIND_WITH_SHADOW_TREE = 862;
  public static final int WINDOW_INNER_HEIGHT = 2706;
  public static final int WINDOW_INNER_WIDTH = 2705;
  public static final int WINDOW_MANAGEMENT_PERMISSION_DESCRIPTOR_USED = 4447;
  public static final int WINDOW_MANAGEMENT_PERMISSION_POLICY_PARSED = 4449;
  public static final int WINDOW_MAXIMIZE = 4762;
  public static final int WINDOW_MINIMIZE = 4761;
  public static final int WINDOW_MOVE = 3067;
  public static final int WINDOW_OFFSCREEN_BUFFERING = 356;
  public static final int WINDOW_OPENED_AS_POPUP_ON_MOBILE = 4430;
  public static final int WINDOW_OPEN_FULLSCREEN_REQUESTED = 4525;
  public static final int WINDOW_OPEN_POPUP_ON_MOBILE = 4429;
  public static final int WINDOW_OPEN_REALM_MISMATCH = 2247;
  public static final int WINDOW_OPEN_WITH_INVALID_URL = 1909;
  public static final int WINDOW_ORIENTATION = 285;
  public static final int WINDOW_OUTER_HEIGHT = 2714;
  public static final int WINDOW_OUTER_WIDTH = 2715;
  public static final int WINDOW_PAGE_X_OFFSET = 2710;
  public static final int WINDOW_PAGE_Y_OFFSET = 2711;
  public static final int WINDOW_PLACEMENT_PERMISSION_DESCRIPTOR_USED = 4448;
  public static final int WINDOW_PLACEMENT_PERMISSION_POLICY_PARSED = 4450;
  public static final int WINDOW_POST_MESSAGE = 574;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_BLUR = 4115;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_CLOSE = 4116;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_CLOSED = 4117;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FOCUS = 4118;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FRAMES = 4119;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_BLUR = 4130;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_CLOSE = 4131;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_CLOSED = 4132;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_FOCUS = 4133;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_FRAMES = 4134;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_INDEXED_GETTER = 4135;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_LENGTH = 4136;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_LOCATION = 4137;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_NAMED_GETTER = 4138;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_OPENER = 4139;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_PARENT = 4140;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_POST_MESSAGE = 4141;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_SELF = 4142;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_TOP = 4143;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_WINDOW = 4144;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_INDEXED_GETTER = 4120;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_LENGTH = 4121;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_LOCATION = 4122;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_NAMED_GETTER = 4123;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_OPENER = 4124;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_PARENT = 4125;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_POST_MESSAGE = 4126;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_SELF = 4127;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_TOP = 4128;
  public static final int WINDOW_PROXY_CROSS_ORIGIN_ACCESS_WINDOW = 4129;
  public static final int WINDOW_RELEASE_EVENTS = 290;
  public static final int WINDOW_RESIZE = 3068;
  public static final int WINDOW_RESTORE = 4763;
  public static final int WINDOW_SCREEN_CHANGE = 3790;
  public static final int WINDOW_SCREEN_IS_EXTENDED = 3789;
  public static final int WINDOW_SCREEN_LEFT = 697;
  public static final int WINDOW_SCREEN_TOP = 698;
  public static final int WINDOW_SCREEN_X = 2712;
  public static final int WINDOW_SCREEN_Y = 2713;
  public static final int WINDOW_SCROLL_X = 2708;
  public static final int WINDOW_SCROLL_Y = 2709;
  public static final int WINDOW_SET_RESIZABLE = 4764;
  public static final int WORKER_CONTROLLED_BY_SERVICE_WORKER_OUT_OF_SCOPE = 3859;
  public static final int
      WORKER_CONTROLLED_BY_SERVICE_WORKER_WITH_FETCH_EVENT_HANDLER_OUT_OF_SCOPE = 3872;
  public static final int WORKER_START = 4;
  public static final int WORKLET_ADD_MODULE = 2364;
  public static final int WORKLET_ANIMATION_CONSTRUCTOR = 2366;
  public static final int WRITABLE_STREAM_CONSTRUCTOR = 2400;
  public static final int WRONG_BASELINE_OF_EMPTY_LINE_BUTTON = 3373;
  public static final int WRONG_BASELINE_OF_MULTI_LINE_BUTTON = 3372;
  public static final int WRONG_BASELINE_OF_MULTI_LINE_BUTTON_WITH_NON_SPACE = 4168;
  public static final int XHRJSON_ENCODING_DETECTION = 3858;
  public static final int XML_DOCUMENT = 77;
  public static final int XML_EXTERNAL_RESOURCE_LOAD = 529;
  public static final int XML_HTTP_REQUEST_ASYNCHRONOUS = 677;
  public static final int XML_HTTP_REQUEST_RESPONSE_XML = 2391;
  public static final int XML_HTTP_REQUEST_SYNCHRONOUS = 465;
  public static final int XML_HTTP_REQUEST_SYNCHRONOUS_IN_CROSS_ORIGIN_SUBFRAME = 3001;
  public static final int XML_HTTP_REQUEST_SYNCHRONOUS_IN_MAIN_FRAME = 3000;
  public static final int XML_HTTP_REQUEST_SYNCHRONOUS_IN_NON_WORKER_OUTSIDE_BEFORE_UNLOAD = 581;
  public static final int XML_HTTP_REQUEST_SYNCHRONOUS_IN_SAME_ORIGIN_SUBFRAME = 3002;
  public static final int XML_HTTP_REQUEST_SYNCHRONOUS_IN_WORKER = 3003;
  public static final int XRCPU_DEPTH_INFORMATION_DATA_ATTRIBUTE = 3686;
  public static final int XRCPU_DEPTH_INFORMATION_GET_DEPTH = 3685;
  public static final int XRDOM_OVERLAY = 3168;
  public static final int XR_DEPTH_SENSING = 3683;
  public static final int XR_FRAME_CREATE_ANCHOR = 3250;
  public static final int XR_FRAME_DETECTED_PLANES = 3861;
  public static final int XR_FRAME_FILL_JOINT_RADII = 3939;
  public static final int XR_FRAME_FILL_POSES = 3940;
  public static final int XR_FRAME_GET_DEPTH_INFORMATION = 3684;
  public static final int XR_FRAME_GET_IMAGE_TRACKING_RESULTS = 3864;
  public static final int XR_FRAME_GET_JOINT_POSE = 3938;
  public static final int XR_FRAME_GET_LIGHT_ESTIMATE = 3724;
  public static final int XR_HIT_TEST_RESULT_CREATE_ANCHOR = 3251;
  public static final int XR_IMAGE_TRACKING = 3862;
  public static final int XR_IS_SESSION_SUPPORTED = 3036;
  public static final int XR_PLANE_DETECTION = 3860;
  public static final int XR_REQUEST_DEVICE = 2414;
  public static final int XR_REQUEST_SESSION = 2415;
  public static final int XR_SESSION_GET_INPUT_SOURCES = 2417;
  public static final int XR_SESSION_GET_TRACKED_IMAGE_SCORES = 3863;
  public static final int XR_SESSION_REQUEST_HIT_TEST_SOURCE = 3166;
  public static final int XR_SESSION_REQUEST_HIT_TEST_SOURCE_FOR_TRANSIENT_INPUT = 3167;
  public static final int XR_SESSION_REQUEST_LIGHT_PROBE = 3731;
  public static final int XR_SUPPORTS_SESSION = 2416;
  public static final int XR_WEB_GL_BINDING_GET_CAMERA_IMAGE = 4352;
  public static final int XR_WEB_GL_BINDING_GET_DEPTH_INFORMATION = 3792;
  public static final int XR_WEB_GL_BINDING_GET_REFLECTION_CUBE_MAP = 3723;
  public static final int XR_WEB_GL_DEPTH_INFORMATION_TEXTURE_ATTRIBUTE = 3791;
  public static final int XSLT_PROCESSOR = 79;
  public static final int XSL_PROCESSING_INSTRUCTION = 78;
  public static final int XSS_AUDITOR_BLOCKED_ENTIRE_PAGE = 1582;
  public static final int XSS_AUDITOR_BLOCKED_SCRIPT = 1581;
  public static final int XSS_AUDITOR_DISABLED = 1583;
  public static final int XSS_AUDITOR_ENABLED_BLOCK = 1585;
  public static final int XSS_AUDITOR_ENABLED_FILTER = 1584;
  public static final int XSS_AUDITOR_INVALID = 1586;
  public static final int X_PATH_MISSING_VARIABLE_EVALUATED = 4634;
  public static final int X_PATH_MISSING_VARIABLE_PARSED = 4633;
  public static final int ZSTD_CONTENT_ENCODING = 4629;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    switch (value) {
      case 0:
      case 4:
      case 5:
      case 10:
      case 13:
      case 14:
      case 15:
      case 16:
      case 18:
      case 19:
      case 20:
      case 21:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 29:
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
      case 45:
      case 47:
      case 49:
      case 51:
      case 52:
      case 53:
      case 55:
      case 57:
      case 61:
      case 62:
      case 63:
      case 69:
      case 70:
      case 74:
      case 77:
      case 78:
      case 79:
      case 80:
      case 83:
      case 84:
      case 85:
      case 90:
      case 96:
      case 97:
      case 98:
      case 111:
      case 112:
      case 115:
      case 116:
      case 117:
      case 123:
      case 124:
      case 125:
      case 128:
      case 129:
      case 130:
      case 131:
      case 132:
      case 133:
      case 134:
      case 135:
      case 136:
      case 137:
      case 138:
      case 143:
      case 144:
      case 145:
      case 146:
      case 147:
      case 148:
      case 164:
      case 165:
      case 166:
      case 167:
      case 168:
      case 169:
      case 170:
      case 171:
      case 172:
      case 173:
      case 176:
      case 177:
      case 178:
      case 179:
      case 180:
      case 181:
      case 182:
      case 183:
      case 184:
      case 185:
      case 186:
      case 190:
      case 191:
      case 192:
      case 193:
      case 196:
      case 200:
      case 201:
      case 202:
      case 203:
      case 204:
      case 205:
      case 209:
      case 211:
      case 212:
      case HTML_ELEMENT_INNER_TEXT /* 213 */:
      case HTML_ELEMENT_OUTER_TEXT /* 214 */:
      case 215:
      case 217:
      case 219:
      case 220:
      case 221:
      case 222:
      case 233:
      case 234:
      case 235:
      case 237:
      case 240:
      case 243:
      case 244:
      case 246:
      case 247:
      case 248:
      case 250:
      case 251:
      case 260:
      case DEPRECATED_WEB_KIT_LINEAR_GRADIENT /* 261 */:
      case DEPRECATED_WEB_KIT_REPEATING_LINEAR_GRADIENT /* 262 */:
      case 263:
      case 264:
      case TEXT_AUTOSIZING /* 274 */:
      case HTML_ANCHOR_ELEMENT_PING_ATTRIBUTE /* 276 */:
      case SVG_CLASS_NAME /* 279 */:
      case 281:
      case 282:
      case 283:
      case 285:
      case 287:
      case 288:
      case 289:
      case 290:
      case DOCUMENT_X_PATH_CREATE_EXPRESSION /* 295 */:
      case DOCUMENT_X_PATH_CREATE_NS_RESOLVER /* 296 */:
      case 297:
      case 304:
      case 306:
      case 307:
      case 308:
      case 309:
      case 310:
      case 311:
      case 312:
      case 318:
      case 320:
      case 321:
      case 322:
      case 323:
      case 324:
      case 325:
      case 327:
      case 328:
      case 329:
      case EVENT_SRC_ELEMENT /* 343 */:
      case EVENT_CANCEL_BUBBLE /* 344 */:
      case OBSOLETE_EVENT_PATH /* 345 */:
      case 347:
      case EVENT_GET_RETURN_VALUE_TRUE /* 350 */:
      case EVENT_GET_RETURN_VALUE_FALSE /* 351 */:
      case EVENT_SET_RETURN_VALUE_TRUE /* 352 */:
      case EVENT_SET_RETURN_VALUE_FALSE /* 353 */:
      case 356:
      case 357:
      case WINDOW_DEFAULTSTATUS /* 358 */:
      case 361:
      case 362:
      case 371:
      case 372:
      case 386:
      case 387:
      case ELEMENT_SCROLL_INTO_VIEW_IF_NEEDED /* 389 */:
      case 393:
      case HTML_IMAGE_ELEMENT_X /* 396 */:
      case HTML_IMAGE_ELEMENT_Y /* 397 */:
      case SELECTION_BASE_NODE /* 400 */:
      case 401:
      case 402:
      case 403:
      case 404:
      case 405:
      case 406:
      case 407:
      case 409:
      case VTT_CUE_RENDER /* 410 */:
      case VTT_CUE_RENDER_VERTICAL /* 411 */:
      case 412:
      case 413:
      case 414:
      case 415:
      case 416:
      case 417:
      case 418:
      case 419:
      case 420:
      case 421:
      case 422:
      case 424:
      case 425:
      case 429:
      case 430:
      case 431:
      case 432:
      case 433:
      case 434:
      case 435:
      case 440:
      case 441:
      case FORMS_SUBMITTED /* 442 */:
      case 455:
      case OBSOLETE_ELEMENT_CREATE_SHADOW_ROOT /* 456 */:
      case OBSOLETE_DOCUMENT_REGISTER_ELEMENT /* 457 */:
      case EDITING_APPLE_INTERCHANGE_NEWLINE /* 458 */:
      case EDITING_APPLE_CONVERTED_SPACE /* 459 */:
      case EDITING_APPLE_PASTE_AS_QUOTATION /* 460 */:
      case 461:
      case 463:
      case 465:
      case 466:
      case 467:
      case 468:
      case 469:
      case 470:
      case 471:
      case 473:
      case 475:
      case 476:
      case 479:
      case 480:
      case 481:
      case 482:
      case 483:
      case 484:
      case 491:
      case 492:
      case 493:
      case 494:
      case 495:
      case 501:
      case 502:
      case 503:
      case 504:
      case 505:
      case 506:
      case 507:
      case 508:
      case 509:
      case 510:
      case SVG_STYLE_ELEMENT_TITLE /* 519 */:
      case 520:
      case 521:
      case 522:
      case 523:
      case 524:
      case 525:
      case 529:
      case 530:
      case 531:
      case REQUESTED_SUBRESOURCE_WITH_EMBEDDED_CREDENTIALS /* 532 */:
      case 533:
      case 534:
      case 535:
      case 540:
      case 541:
      case SRI_ELEMENT_WITH_UNPARSABLE_INTEGRITY_ATTRIBUTE /* 542 */:
      case 545:
      case V8_ANIMATION_START_TIME_ATTRIBUTE_SETTER /* 546 */:
      case 547:
      case 548:
      case 549:
      case 550:
      case 551:
      case 552:
      case 553:
      case 554:
      case 555:
      case 556:
      case 557:
      case 558:
      case 559:
      case 560:
      case 561:
      case 562:
      case 563:
      case 564:
      case 565:
      case 569:
      case 570:
      case 571:
      case 572:
      case 573:
      case 574:
      case 576:
      case 578:
      case 581:
      case 582:
      case 583:
      case 584:
      case 585:
      case 586:
      case 587:
      case 588:
      case 589:
      case 590:
      case 591:
      case 592:
      case 593:
      case 599:
      case 603:
      case 606:
      case 607:
      case 608:
      case 609:
      case 610:
      case 611:
      case 612:
      case 613:
      case 614:
      case 615:
      case 616:
      case 617:
      case 618:
      case 628:
      case 629:
      case 630:
      case 631:
      case 632:
      case 633:
      case 634:
      case 635:
      case 636:
      case 637:
      case 638:
      case 639:
      case 640:
      case 641:
      case 642:
      case 643:
      case 645:
      case AUDIO_CONTEXT_CREATE_SCRIPT_PROCESSOR /* 646 */:
      case 647:
      case 648:
      case 649:
      case 650:
      case 651:
      case 661:
      case 662:
      case 663:
      case 664:
      case 665:
      case 666:
      case 667:
      case 668:
      case 669:
      case 670:
      case 671:
      case 672:
      case 673:
      case 674:
      case 675:
      case 676:
      case 677:
      case 679:
      case 680:
      case 685:
      case 686:
      case 687:
      case 688:
      case 689:
      case 691:
      case 694:
      case 695:
      case 696:
      case 697:
      case 698:
      case 699:
      case 700:
      case 701:
      case 707:
      case 710:
      case 711:
      case 712:
      case 713:
      case 714:
      case SUBTLE_CRYPTO_DIGEST /* 715 */:
      case SUBTLE_CRYPTO_GENERATE_KEY /* 716 */:
      case SUBTLE_CRYPTO_IMPORT_KEY /* 717 */:
      case SUBTLE_CRYPTO_EXPORT_KEY /* 718 */:
      case 719:
      case 720:
      case SUBTLE_CRYPTO_WRAP_KEY /* 721 */:
      case 722:
      case 723:
      case 724:
      case 725:
      case 726:
      case 727:
      case 728:
      case 729:
      case 730:
      case 731:
      case CRYPTO_ALGORITHM_AES_CTR /* 732 */:
      case 733:
      case 734:
      case 735:
      case 736:
      case 737:
      case 738:
      case 739:
      case 740:
      case 741:
      case 742:
      case 743:
      case 744:
      case 745:
      case 748:
      case 750:
      case 758:
      case 759:
      case 760:
      case 761:
      case 762:
      case 763:
      case AUTOCAPITALIZE_ATTRIBUTE /* 764 */:
      case 765:
      case 766:
      case 767:
      case 768:
      case 770:
      case 772:
      case 773:
      case 778:
      case 780:
      case 781:
      case 782:
      case 783:
      case 784:
      case 785:
      case V8_SCREEN_AVAIL_LEFT_ATTRIBUTE_GETTER /* 786 */:
      case V8_SCREEN_AVAIL_TOP_ATTRIBUTE_GETTER /* 787 */:
      case V8SVGFE_CONVOLVE_MATRIX_ELEMENT_PRESERVE_ALPHA_ATTRIBUTE_GETTER /* 791 */:
      case V8SVG_STYLE_ELEMENT_DISABLED_ATTRIBUTE_GETTER /* 798 */:
      case V8SVG_STYLE_ELEMENT_DISABLED_ATTRIBUTE_SETTER /* 799 */:
      case INPUT_TYPE_FILE_SECURE_ORIGIN /* 801 */:
      case INPUT_TYPE_FILE_INSECURE_ORIGIN /* 802 */:
      case ELEMENT_ATTACH_SHADOW /* 804 */:
      case V8_SECURITY_POLICY_VIOLATION_EVENT_DOCUMENT_URI_ATTRIBUTE_GETTER /* 806 */:
      case V8_SECURITY_POLICY_VIOLATION_EVENT_BLOCKED_URI_ATTRIBUTE_GETTER /* 807 */:
      case V8_SECURITY_POLICY_VIOLATION_EVENT_STATUS_CODE_ATTRIBUTE_GETTER /* 808 */:
      case HTML_LINK_ELEMENT_DISABLED /* 809 */:
      case V8HTML_LINK_ELEMENT_DISABLED_ATTRIBUTE_GETTER /* 810 */:
      case V8HTML_LINK_ELEMENT_DISABLED_ATTRIBUTE_SETTER /* 811 */:
      case V8HTML_STYLE_ELEMENT_DISABLED_ATTRIBUTE_GETTER /* 812 */:
      case V8HTML_STYLE_ELEMENT_DISABLED_ATTRIBUTE_SETTER /* 813 */:
      case V8DOM_ERROR_CONSTRUCTOR /* 816 */:
      case V8DOM_ERROR_NAME_ATTRIBUTE_GETTER /* 817 */:
      case V8DOM_ERROR_MESSAGE_ATTRIBUTE_GETTER /* 818 */:
      case TEXT_INPUT_FIRED /* 830 */:
      case V8_TEXT_EVENT_DATA_ATTRIBUTE_GETTER /* 831 */:
      case V8_TEXT_EVENT_INIT_TEXT_EVENT_METHOD /* 832 */:
      case CLIENT_HINTS_DPR_DEPRECATED /* 835 */:
      case CLIENT_HINTS_RESOURCE_WIDTH_DEPRECATED /* 836 */:
      case CLIENT_HINTS_VIEWPORT_WIDTH_DEPRECATED /* 837 */:
      case SRI_ELEMENT_INTEGRITY_ATTRIBUTE_BUT_INELIGIBLE /* 838 */:
      case FORM_DATA_APPEND_NULL /* 843 */:
      case NON_HTML_ELEMENT_SET_ATTRIBUTE_NODE_FROM_HTML_DOCUMENT_NAME_NOT_LOWERCASE /* 845 */:
      case NAVIGATOR_VIBRATE /* 850 */:
      case NAVIGATOR_VIBRATE_SUB_FRAME /* 851 */:
      case V8X_PATH_EVALUATOR_CONSTRUCTOR /* 853 */:
      case V8X_PATH_EVALUATOR_CREATE_EXPRESSION_METHOD /* 854 */:
      case V8X_PATH_EVALUATOR_CREATE_NS_RESOLVER_METHOD /* 855 */:
      case V8X_PATH_EVALUATOR_EVALUATE_METHOD /* 856 */:
      case REQUEST_MIDI_ACCESS_OBSCURED_BY_FOOTPRINTING /* 857 */:
      case V8_MOUSE_EVENT_LAYER_X_ATTRIBUTE_GETTER /* 858 */:
      case V8_MOUSE_EVENT_LAYER_Y_ATTRIBUTE_GETTER /* 859 */:
      case INNER_TEXT_WITH_SHADOW_TREE /* 860 */:
      case SELECTION_TO_STRING_WITH_SHADOW_TREE /* 861 */:
      case WINDOW_FIND_WITH_SHADOW_TREE /* 862 */:
      case V8_COMPOSITION_EVENT_INIT_COMPOSITION_EVENT_METHOD /* 863 */:
      case V8_CUSTOM_EVENT_INIT_CUSTOM_EVENT_METHOD /* 864 */:
      case V8_DEVICE_MOTION_EVENT_INIT_DEVICE_MOTION_EVENT_METHOD /* 865 */:
      case V8_DEVICE_ORIENTATION_EVENT_INIT_DEVICE_ORIENTATION_EVENT_METHOD /* 866 */:
      case V8_EVENT_INIT_EVENT_METHOD /* 867 */:
      case V8_KEYBOARD_EVENT_INIT_KEYBOARD_EVENT_METHOD /* 868 */:
      case V8_MOUSE_EVENT_INIT_MOUSE_EVENT_METHOD /* 869 */:
      case V8_MUTATION_EVENT_INIT_MUTATION_EVENT_METHOD /* 870 */:
      case V8_STORAGE_EVENT_INIT_STORAGE_EVENT_METHOD /* 871 */:
      case V8UI_EVENT_INIT_UI_EVENT_METHOD /* 873 */:
      case REQUEST_FILE_SYSTEM_NON_WEBBY_ORIGIN /* 876 */:
      case V8_MEMORY_INFO_TOTAL_JS_HEAP_SIZE_ATTRIBUTE_GETTER /* 879 */:
      case V8_MEMORY_INFO_USED_JS_HEAP_SIZE_ATTRIBUTE_GETTER /* 880 */:
      case V8_MEMORY_INFO_JS_HEAP_SIZE_LIMIT_ATTRIBUTE_GETTER /* 881 */:
      case V8_PERFORMANCE_TIMING_ATTRIBUTE_GETTER /* 882 */:
      case V8_PERFORMANCE_NAVIGATION_ATTRIBUTE_GETTER /* 883 */:
      case V8_PERFORMANCE_MEMORY_ATTRIBUTE_GETTER /* 884 */:
      case V8_SHARED_WORKER_WORKER_START_ATTRIBUTE_GETTER /* 885 */:
      case HTML_MEDIA_ELEMENT_PRELOAD_NONE /* 892 */:
      case HTML_MEDIA_ELEMENT_PRELOAD_METADATA /* 893 */:
      case HTML_MEDIA_ELEMENT_PRELOAD_AUTO /* 894 */:
      case HTML_MEDIA_ELEMENT_PRELOAD_DEFAULT /* 895 */:
      case MIXED_CONTENT_BLOCKABLE_ALLOWED /* 896 */:
      case PSEUDO_BEFORE_AFTER_FOR_INPUT_ELEMENT /* 897 */:
      case V8_PERMISSIONS_REVOKE_METHOD /* 898 */:
      case LINK_REL_DNS_PREFETCH /* 899 */:
      case 900:
      case 901:
      case 902:
      case 903:
      case 904:
      case 905:
      case 906:
      case ELEMENT_ATTACH_SHADOW_OPEN /* 907 */:
      case ELEMENT_ATTACH_SHADOW_CLOSED /* 908 */:
      case AUDIO_PARAM_SET_VALUE_AT_TIME /* 909 */:
      case AUDIO_PARAM_LINEAR_RAMP_TO_VALUE_AT_TIME /* 910 */:
      case AUDIO_PARAM_EXPONENTIAL_RAMP_TO_VALUE_AT_TIME /* 911 */:
      case AUDIO_PARAM_SET_TARGET_AT_TIME /* 912 */:
      case AUDIO_PARAM_SET_VALUE_CURVE_AT_TIME /* 913 */:
      case AUDIO_PARAM_CANCEL_SCHEDULED_VALUES /* 914 */:
      case V8_PERMISSIONS_REQUEST_METHOD /* 915 */:
      case LINK_REL_PREFETCH /* 917 */:
      case LINK_REL_PRERENDER /* 918 */:
      case LINK_REL_NEXT /* 919 */:
      case CSS_VALUE_PREFIXED_MIN_CONTENT /* 921 */:
      case CSS_VALUE_PREFIXED_MAX_CONTENT /* 922 */:
      case CSS_VALUE_PREFIXED_FIT_CONTENT /* 923 */:
      case CSS_VALUE_PREFIXED_FILL_AVAILABLE /* 924 */:
      case PRESENTATION_DEFAULT_REQUEST /* 926 */:
      case PRESENTATION_AVAILABILITY_CHANGE_EVENT_LISTENER /* 927 */:
      case PRESENTATION_REQUEST_CONSTRUCTOR /* 928 */:
      case PRESENTATION_REQUEST_START /* 929 */:
      case PRESENTATION_REQUEST_RECONNECT /* 930 */:
      case PRESENTATION_REQUEST_GET_AVAILABILITY /* 931 */:
      case PRESENTATION_REQUEST_CONNECTION_AVAILABLE_EVENT_LISTENER /* 932 */:
      case PRESENTATION_CONNECTION_TERMINATE /* 933 */:
      case PRESENTATION_CONNECTION_SEND /* 934 */:
      case PRESENTATION_CONNECTION_MESSAGE_EVENT_LISTENER /* 936 */:
      case CSS_ANIMATIONS_STACKED_NEUTRAL_KEYFRAME /* 937 */:
      case READING_CHECKED_IN_CLICK_HANDLER /* 938 */:
      case FLEXBOX_INTRINSIC_SIZE_ALGORITHM_IS_DIFFERENT /* 939 */:
      case OBSOLETE_HTML_IMPORTS_HAS_STYLE_SHEETS /* 940 */:
      case NET_INFO_TYPE /* 946 */:
      case NET_INFO_DOWNLINK_MAX /* 947 */:
      case NET_INFO_ON_CHANGE /* 948 */:
      case NET_INFO_ON_TYPE_CHANGE /* 949 */:
      case V8_WINDOW_ALERT_METHOD /* 950 */:
      case V8_WINDOW_CONFIRM_METHOD /* 951 */:
      case V8_WINDOW_PROMPT_METHOD /* 952 */:
      case V8_WINDOW_PRINT_METHOD /* 953 */:
      case V8_WINDOW_REQUEST_IDLE_CALLBACK_METHOD /* 954 */:
      case FLEXBOX_PERCENTAGE_PADDING_VERTICAL /* 955 */:
      case FLEXBOX_PERCENTAGE_MARGIN_VERTICAL /* 956 */:
      case CREDENTIAL_MANAGER_GET /* 960 */:
      case CREDENTIAL_MANAGER_GET_MEDIATION_OPTIONAL /* 961 */:
      case CREDENTIAL_MANAGER_GET_MEDIATION_SILENT /* 962 */:
      case CREDENTIAL_MANAGER_STORE /* 963 */:
      case BLOCKABLE_MIXED_CONTENT_IN_SUBFRAME_BLOCKED /* 966 */:
      case CSS_AT_RULE_CHARSET /* 969 */:
      case CSS_AT_RULE_FONT_FACE /* 970 */:
      case CSS_AT_RULE_IMPORT /* 971 */:
      case CSS_AT_RULE_KEYFRAMES /* 972 */:
      case CSS_AT_RULE_MEDIA /* 973 */:
      case CSS_AT_RULE_NAMESPACE /* 974 */:
      case CSS_AT_RULE_PAGE /* 975 */:
      case CSS_AT_RULE_SUPPORTS /* 976 */:
      case CSS_AT_RULE_VIEWPORT /* 977 */:
      case CSS_AT_RULE_WEBKIT_KEYFRAMES /* 978 */:
      case V8HTML_FIELD_SET_ELEMENT_ELEMENTS_ATTRIBUTE_GETTER /* 979 */:
      case OBSOLETE_EXTERNAL_ADD_SEARCH_PROVIDER /* 981 */:
      case OBSOLETE_EXTERNAL_IS_SEARCH_PROVIDER_INSTALLED /* 982 */:
      case V8_PERMISSIONS_REQUEST_ALL_METHOD /* 983 */:
      case OBSOLETE_DEVICE_ORIENTATION_ABSOLUTE_INSECURE_ORIGIN /* 987 */:
      case DEVICE_ORIENTATION_ABSOLUTE_SECURE_ORIGIN /* 988 */:
      case FONT_FACE_CONSTRUCTOR /* 989 */:
      case SERVICE_WORKER_CONTROLLED_PAGE /* 990 */:
      case METER_ELEMENT_WITH_METER_APPEARANCE /* 993 */:
      case METER_ELEMENT_WITH_NONE_APPEARANCE /* 994 */:
      case SELECTION_ANCHOR_NODE /* 997 */:
      case SELECTION_ANCHOR_OFFSET /* 998 */:
      case SELECTION_FOCUS_NODE /* 999 */:
      case 1000:
      case 1001:
      case 1002:
      case 1003:
      case 1004:
      case 1005:
      case 1006:
      case 1007:
      case 1008:
      case 1009:
      case 1010:
      case 1011:
      case 1012:
      case 1013:
      case 1014:
      case 1015:
      case 1016:
      case 1017:
      case 1018:
      case 1019:
      case 1020:
      case 1021:
      case CSS_FILTER_CONTRAST /* 1022 */:
      case CSS_FILTER_BLUR /* 1023 */:
      case 1024:
      case 1025:
      case EXEC_COMMAND_ON_INPUT_OR_TEXTAREA /* 1027 */:
      case V8_HISTORY_SCROLL_RESTORATION_ATTRIBUTE_GETTER /* 1028 */:
      case V8_HISTORY_SCROLL_RESTORATION_ATTRIBUTE_SETTER /* 1029 */:
      case SVG1DOM_FILTER /* 1030 */:
      case OFFLINE_AUDIO_CONTEXT_START_RENDERING /* 1031 */:
      case OFFLINE_AUDIO_CONTEXT_SUSPEND /* 1032 */:
      case OFFLINE_AUDIO_CONTEXT_RESUME /* 1033 */:
      case SVG1DOM_PAINT_SERVER /* 1035 */:
      case SVGSVG_ELEMENT_FRAGMENT_SVG_VIEW /* 1036 */:
      case SVGSVG_ELEMENT_FRAGMENT_SVG_VIEW_ELEMENT /* 1037 */:
      case PRESENTATION_CONNECTION_CLOSE /* 1038 */:
      case SVG1DOM_SHAPE /* 1039 */:
      case SVG1DOM_TEXT /* 1040 */:
      case RTC_PEER_CONNECTION_CONSTRUCTOR_CONSTRAINTS /* 1041 */:
      case RTC_PEER_CONNECTION_CONSTRUCTOR_COMPLIANT /* 1042 */:
      case RTC_PEER_CONNECTION_CREATE_OFFER_LEGACY_FAILURE_CALLBACK /* 1044 */:
      case RTC_PEER_CONNECTION_CREATE_OFFER_LEGACY_CONSTRAINTS /* 1045 */:
      case OBSOLETE_RTC_PEER_CONNECTION_CREATE_OFFER_LEGACY_OFFER_OPTIONS /* 1046 */:
      case RTC_PEER_CONNECTION_CREATE_OFFER_LEGACY_COMPLIANT /* 1047 */:
      case RTC_PEER_CONNECTION_CREATE_ANSWER_LEGACY_FAILURE_CALLBACK /* 1049 */:
      case OBSOLETE_RTC_PEER_CONNECTION_CREATE_ANSWER_LEGACY_CONSTRAINTS /* 1050 */:
      case RTC_PEER_CONNECTION_CREATE_ANSWER_LEGACY_COMPLIANT /* 1051 */:
      case RTC_PEER_CONNECTION_SET_LOCAL_DESCRIPTION_LEGACY_NO_SUCCESS_CALLBACK /* 1052 */:
      case RTC_PEER_CONNECTION_SET_LOCAL_DESCRIPTION_LEGACY_NO_FAILURE_CALLBACK /* 1053 */:
      case RTC_PEER_CONNECTION_SET_LOCAL_DESCRIPTION_LEGACY_COMPLIANT /* 1054 */:
      case RTC_PEER_CONNECTION_SET_REMOTE_DESCRIPTION_LEGACY_NO_SUCCESS_CALLBACK /* 1055 */:
      case RTC_PEER_CONNECTION_SET_REMOTE_DESCRIPTION_LEGACY_NO_FAILURE_CALLBACK /* 1056 */:
      case RTC_PEER_CONNECTION_SET_REMOTE_DESCRIPTION_LEGACY_COMPLIANT /* 1057 */:
      case RTC_PEER_CONNECTION_GET_STATS_LEGACY_NON_COMPLIANT /* 1058 */:
      case NODE_FILTER_IS_FUNCTION /* 1059 */:
      case NODE_FILTER_IS_OBJECT /* 1060 */:
      case CSS_SELECTOR_INTERNAL_PSEUDO_LIST_BOX /* 1062 */:
      case CSS_SELECTOR_INTERNAL_MEDIA_CONTROLS_OVERLAY_CAST_BUTTON /* 1064 */:
      case CSS_SELECTOR_INTERNAL_PSEUDO_SPATIAL_NAVIGATION_FOCUS /* 1065 */:
      case SAME_ORIGIN_TEXT_SCRIPT /* 1066 */:
      case SAME_ORIGIN_APPLICATION_SCRIPT /* 1067 */:
      case SAME_ORIGIN_OTHER_SCRIPT /* 1068 */:
      case CROSS_ORIGIN_TEXT_SCRIPT /* 1069 */:
      case CROSS_ORIGIN_APPLICATION_SCRIPT /* 1070 */:
      case CROSS_ORIGIN_OTHER_SCRIPT /* 1071 */:
      case SVG1DOMSVG_TESTS /* 1072 */:
      case DISABLE_REMOTE_PLAYBACK_ATTRIBUTE /* 1074 */:
      case V8_SLOPPY_MODE /* 1075 */:
      case V8_STRICT_MODE /* 1076 */:
      case OBSOLETE_V8_STRONG_MODE /* 1077 */:
      case AUDIO_NODE_CONNECT_TO_AUDIO_NODE /* 1078 */:
      case AUDIO_NODE_CONNECT_TO_AUDIO_PARAM /* 1079 */:
      case AUDIO_NODE_DISCONNECT_FROM_AUDIO_NODE /* 1080 */:
      case AUDIO_NODE_DISCONNECT_FROM_AUDIO_PARAM /* 1081 */:
      case V8CSS_FONT_FACE_RULE_STYLE_ATTRIBUTE_GETTER /* 1082 */:
      case SELECTION_COLLAPSE_NULL /* 1083 */:
      case SELECTION_SET_BASE_AND_EXTENT_NULL /* 1084 */:
      case V8SVGSVG_ELEMENT_CREATE_SVG_NUMBER_METHOD /* 1085 */:
      case V8SVGSVG_ELEMENT_CREATE_SVG_LENGTH_METHOD /* 1086 */:
      case V8SVGSVG_ELEMENT_CREATE_SVG_ANGLE_METHOD /* 1087 */:
      case V8SVGSVG_ELEMENT_CREATE_SVG_POINT_METHOD /* 1088 */:
      case V8SVGSVG_ELEMENT_CREATE_SVG_MATRIX_METHOD /* 1089 */:
      case V8SVGSVG_ELEMENT_CREATE_SVG_RECT_METHOD /* 1090 */:
      case V8SVGSVG_ELEMENT_CREATE_SVG_TRANSFORM_METHOD /* 1091 */:
      case V8SVGSVG_ELEMENT_CREATE_SVG_TRANSFORM_FROM_MATRIX_METHOD /* 1092 */:
      case FORM_NAME_ACCESS_FOR_NON_DESCENDANT_IMAGE_ELEMENT /* 1093 */:
      case V8_REG_EXP_PROTOTYPE_STICKY_GETTER /* 1096 */:
      case V8_REG_EXP_PROTOTYPE_TO_STRING /* 1097 */:
      case V8_INPUT_DEVICE_CAPABILITIES_FIRES_TOUCH_EVENTS_ATTRIBUTE_GETTER /* 1098 */:
      case DATA_ELEMENT /* 1099 */:
      case TIME_ELEMENT /* 1100 */:
      case SVG1DOM_URI_REFERENCE /* 1101 */:
      case SVG1DOM_ZOOM_AND_PAN /* 1102 */:
      case V8SVG_GRAPHICS_ELEMENT_TRANSFORM_ATTRIBUTE_GETTER /* 1103 */:
      case MENU_ITEM_ELEMENT /* 1104 */:
      case MENU_ITEM_CLOSE_TAG /* 1105 */:
      case SVG1DOM_MARKER_ELEMENT /* 1106 */:
      case SVG1DOM_USE_ELEMENT /* 1107 */:
      case SVG1DOM_MASK_ELEMENT /* 1108 */:
      case V8SVGA_ELEMENT_TARGET_ATTRIBUTE_GETTER /* 1109 */:
      case V8SVG_CLIP_PATH_ELEMENT_CLIP_PATH_UNITS_ATTRIBUTE_GETTER /* 1110 */:
      case SVG1DOM_FIT_TO_VIEW_BOX /* 1111 */:
      case SVG1DOMSVG_ELEMENT /* 1114 */:
      case SVG1DOM_IMAGE_ELEMENT /* 1115 */:
      case SVG1DOM_FOREIGN_OBJECT_ELEMENT /* 1116 */:
      case AUDIO_CONTEXT_CREATE_IIR_FILTER /* 1117 */:
      case CSS_SELECTOR_PSEUDO_SLOTTED /* 1118 */:
      case MEDIA_DEVICES_ENUMERATE_DEVICES /* 1119 */:
      case EVENT_COMPOSED_PATH /* 1123 */:
      case LINK_HEADER_PRELOAD /* 1124 */:
      case MOUSE_WHEEL_EVENT /* 1125 */:
      case WHEEL_EVENT /* 1126 */:
      case MOUSE_WHEEL_AND_WHEEL_EVENT /* 1127 */:
      case BODY_SCROLLS_IN_ADDITION_TO_VIEWPORT /* 1128 */:
      case DOCUMENT_DESIGN_MODE_ENABELD /* 1129 */:
      case CONTENT_EDITABLE_TRUE /* 1130 */:
      case CONTENT_EDITABLE_TRUE_ON_HTML /* 1131 */:
      case CONTENT_EDITABLE_PLAIN_TEXT_ONLY /* 1132 */:
      case V8_REG_EXP_PROTOTYPE_UNICODE_GETTER /* 1133 */:
      case OBSOLETE_V8_INTL_V8_PARSE /* 1134 */:
      case OBSOLETE_V8_INTL_PATTERN /* 1135 */:
      case OBSOLETE_V8_INTL_RESOLVED /* 1136 */:
      case OBSOLETE_V8_PROMISE_CHAIN /* 1137 */:
      case OBSOLETE_V8_PROMISE_ACCEPT /* 1138 */:
      case OBSOLETE_V8_PROMISE_DEFER /* 1139 */:
      case EVENT_COMPOSED /* 1140 */:
      case GEOLOCATION_INSECURE_ORIGIN_IFRAME /* 1141 */:
      case GEOLOCATION_SECURE_ORIGIN_IFRAME /* 1142 */:
      case REQUEST_MIDI_ACCESS_IFRAME_OBSCURED_BY_FOOTPRINTING /* 1143 */:
      case GET_USER_MEDIA_INSECURE_ORIGIN_IFRAME /* 1144 */:
      case GET_USER_MEDIA_SECURE_ORIGIN_IFRAME /* 1145 */:
      case ELEMENT_REQUEST_POINTER_LOCK_IFRAME /* 1146 */:
      case NOTIFICATION_API_INSECURE_ORIGIN_IFRAME /* 1147 */:
      case NOTIFICATION_API_SECURE_ORIGIN_IFRAME /* 1148 */:
      case WEB_SOCKET /* 1149 */:
      case MEDIA_STREAM_CONSTRAINTS_NAME_VALUE /* 1150 */:
      case OBSOLETE_MEDIA_STREAM_CONSTRAINTS_FROM_DICTIONARY /* 1151 */:
      case MEDIA_STREAM_CONSTRAINTS_CONFORMANT /* 1152 */:
      case CSS_SELECTOR_INDIRECT_ADJACENT /* 1153 */:
      case CREATE_IMAGE_BITMAP /* 1156 */:
      case PRESENTATION_CONNECTION_CONNECT_EVENT_LISTENER /* 1157 */:
      case PRESENTATION_CONNECTION_CLOSE_EVENT_LISTENER /* 1158 */:
      case PRESENTATION_CONNECTION_TERMINATE_EVENT_LISTENER /* 1159 */:
      case DOCUMENT_CREATE_EVENT_ANIMATION_EVENT /* 1162 */:
      case DOCUMENT_CREATE_EVENT_BEFORE_UNLOAD_EVENT /* 1166 */:
      case DOCUMENT_CREATE_EVENT_COMPOSITION_EVENT /* 1168 */:
      case DOCUMENT_CREATE_EVENT_DRAG_EVENT /* 1169 */:
      case DOCUMENT_CREATE_EVENT_ERROR_EVENT /* 1170 */:
      case DOCUMENT_CREATE_EVENT_FOCUS_EVENT /* 1171 */:
      case DOCUMENT_CREATE_EVENT_HASH_CHANGE_EVENT /* 1172 */:
      case DOCUMENT_CREATE_EVENT_MUTATION_EVENT /* 1173 */:
      case DOCUMENT_CREATE_EVENT_PAGE_TRANSITION_EVENT /* 1174 */:
      case DOCUMENT_CREATE_EVENT_POP_STATE_EVENT /* 1176 */:
      case DOCUMENT_CREATE_EVENT_TEXT_EVENT /* 1182 */:
      case DOCUMENT_CREATE_EVENT_TRANSITION_EVENT /* 1183 */:
      case DOCUMENT_CREATE_EVENT_WHEEL_EVENT /* 1184 */:
      case DOCUMENT_CREATE_EVENT_TRACK_EVENT /* 1186 */:
      case DOCUMENT_CREATE_EVENT_MUTATION_EVENTS /* 1188 */:
      case DOCUMENT_CREATE_EVENT_SVG_EVENTS /* 1190 */:
      case DOCUMENT_CREATE_EVENT_DEVICE_MOTION_EVENT /* 1195 */:
      case DOCUMENT_CREATE_EVENT_DEVICE_ORIENTATION_EVENT /* 1196 */:
      case DOCUMENT_CREATE_EVENT_IDB_VERSION_CHANGE_EVENT /* 1201 */:
      case DOCUMENT_CREATE_EVENT_STORAGE_EVENT /* 1221 */:
      case DOCUMENT_CREATE_EVENT_WEB_GL_CONTEXT_EVENT /* 1224 */:
      case DOCUMENT_CREATE_EVENT_CLOSE_EVENT /* 1227 */:
      case DOCUMENT_CREATE_EVENT_KEYBOARD_EVENTS /* 1228 */:
      case HTML_MEDIA_ELEMENT /* 1229 */:
      case HTML_MEDIA_ELEMENT_IN_DOCUMENT /* 1230 */:
      case HTML_MEDIA_ELEMENT_CONTROLS_ATTRIBUTE /* 1231 */:
      case V8_ANIMATION_ONCANCEL_ATTRIBUTE_GETTER /* 1233 */:
      case V8_ANIMATION_ONCANCEL_ATTRIBUTE_SETTER /* 1234 */:
      case V8HTML_COMMENT_IN_EXTERNAL_SCRIPT /* 1235 */:
      case V8HTML_COMMENT /* 1236 */:
      case V8_SLOPPY_MODE_BLOCK_SCOPED_FUNCTION_REDEFINITION /* 1237 */:
      case V8_FOR_IN_INITIALIZER /* 1238 */:
      case V8_ANIMATION_ID_ATTRIBUTE_GETTER /* 1239 */:
      case V8_ANIMATION_ID_ATTRIBUTE_SETTER /* 1240 */:
      case OBSOLETE_APPLICATION_CACHE_MANIFEST_SELECT_INSECURE_ORIGIN /* 1245 */:
      case OBSOLETE_APPLICATION_CACHE_MANIFEST_SELECT_SECURE_ORIGIN /* 1246 */:
      case OBSOLETE_APPLICATION_CACHE_API_INSECURE_ORIGIN /* 1247 */:
      case OBSOLETE_APPLICATION_CACHE_API_SECURE_ORIGIN /* 1248 */:
      case CSS_AT_RULE_APPLY /* 1249 */:
      case CSS_SELECTOR_PSEUDO_ANY /* 1250 */:
      case HTML_LABEL_ELEMENT_CONTROL_FOR_NON_FORM_ASSOCIATED_ELEMENT /* 1263 */:
      case HTML_MEDIA_ELEMENT_LOAD_NETWORK_EMPTY_NOT_PAUSED /* 1265 */:
      case V8_WINDOW_WEBKIT_SPEECH_GRAMMAR_CONSTRUCTOR_GETTER /* 1267 */:
      case V8_WINDOW_WEBKIT_SPEECH_GRAMMAR_LIST_CONSTRUCTOR_GETTER /* 1268 */:
      case V8_WINDOW_WEBKIT_SPEECH_RECOGNITION_CONSTRUCTOR_GETTER /* 1269 */:
      case V8_WINDOW_WEBKIT_SPEECH_RECOGNITION_ERROR_CONSTRUCTOR_GETTER /* 1270 */:
      case V8_WINDOW_WEBKIT_SPEECH_RECOGNITION_EVENT_CONSTRUCTOR_GETTER /* 1271 */:
      case V8_WINDOW_SPEECH_SYNTHESIS_ATTRIBUTE_GETTER /* 1272 */:
      case V8IDB_FACTORY_WEBKIT_GET_DATABASE_NAMES_METHOD /* 1273 */:
      case SCRIPT_PASSES_CSP_DYNAMIC /* 1275 */:
      case CSP_WITH_STRICT_DYNAMIC /* 1277 */:
      case SCROLL_ANCHORED /* 1278 */:
      case SVG_CALC_MODE_DISCRETE /* 1287 */:
      case SVG_CALC_MODE_LINEAR /* 1288 */:
      case SVG_CALC_MODE_PACED /* 1289 */:
      case SVG_CALC_MODE_SPLINE /* 1290 */:
      case FORM_SUBMISSION_STARTED /* 1291 */:
      case FORM_VALIDATION_STARTED /* 1292 */:
      case FORM_VALIDATION_ABORTED_SUBMISSION /* 1293 */:
      case FORM_VALIDATION_SHOWED_MESSAGE /* 1294 */:
      case V8_DOCUMENT_IMAGES_ATTRIBUTE_GETTER /* 1297 */:
      case V8_DOCUMENT_EMBEDS_ATTRIBUTE_GETTER /* 1298 */:
      case V8_DOCUMENT_PLUGINS_ATTRIBUTE_GETTER /* 1299 */:
      case V8_DOCUMENT_LINKS_ATTRIBUTE_GETTER /* 1300 */:
      case V8_DOCUMENT_FORMS_ATTRIBUTE_GETTER /* 1301 */:
      case V8_DOCUMENT_SCRIPTS_ATTRIBUTE_GETTER /* 1302 */:
      case V8_DOCUMENT_ANCHORS_ATTRIBUTE_GETTER /* 1303 */:
      case V8_DOCUMENT_APPLETS_ATTRIBUTE_GETTER /* 1304 */:
      case MEDIA_STREAM_TRACK_REMOTE /* 1306 */:
      case V8_NODE_IS_CONNECTED_ATTRIBUTE_GETTER /* 1307 */:
      case SHADOW_ROOT_DELEGATES_FOCUS /* 1308 */:
      case OBSOLETE_MIXED_SHADOW_ROOT_V0_AND_V1 /* 1309 */:
      case FILE_API_NATIVE_LINE_ENDINGS /* 1320 */:
      case POINTER_EVENT_ATTRIBUTE_COUNT /* 1321 */:
      case COMPOSITED_REPLICATION /* 1322 */:
      case V8_DATA_TRANSFER_ITEM_WEBKIT_GET_AS_ENTRY_METHOD /* 1325 */:
      case V8HTML_INPUT_ELEMENT_WEBKIT_ENTRIES_ATTRIBUTE_GETTER /* 1326 */:
      case ENTRY_FILESYSTEM_ATTRIBUTE_GETTER_ISOLATED_FILE_SYSTEM /* 1327 */:
      case ENTRY_GET_METADATA_METHOD_ISOLATED_FILE_SYSTEM /* 1328 */:
      case ENTRY_MOVE_TO_METHOD_ISOLATED_FILE_SYSTEM /* 1329 */:
      case ENTRY_COPY_TO_METHOD_ISOLATED_FILE_SYSTEM /* 1330 */:
      case ENTRY_REMOVE_METHOD_ISOLATED_FILE_SYSTEM /* 1331 */:
      case ENTRY_GET_PARENT_METHOD_ISOLATED_FILE_SYSTEM /* 1332 */:
      case ENTRY_TO_URL_METHOD_ISOLATED_FILE_SYSTEM /* 1333 */:
      case DURING_MICROTASK_ALERT /* 1334 */:
      case DURING_MICROTASK_CONFIRM /* 1335 */:
      case DURING_MICROTASK_PRINT /* 1336 */:
      case DURING_MICROTASK_PROMPT /* 1337 */:
      case DURING_MICROTASK_SYNC_XHR /* 1338 */:
      case CREDENTIAL_MANAGER_GET_RETURNED_CREDENTIAL /* 1342 */:
      case GEOLOCATION_INSECURE_ORIGIN_DEPRECATED_NOT_REMOVED /* 1343 */:
      case GEOLOCATION_INSECURE_ORIGIN_IFRAME_DEPRECATED_NOT_REMOVED /* 1344 */:
      case PROGRESS_ELEMENT_WITH_NONE_APPEARANCE /* 1345 */:
      case PROGRESS_ELEMENT_WITH_PROGRESS_BAR_APPEARANCE /* 1346 */:
      case POINTER_EVENT_ADD_LISTENER_COUNT /* 1347 */:
      case CSS_VALUE_APPEARANCE_NONE /* 1351 */:
      case CSS_VALUE_APPEARANCE_NOT_NONE /* 1352 */:
      case CSS_VALUE_APPEARANCE_OTHERS /* 1353 */:
      case CSS_VALUE_APPEARANCE_BUTTON /* 1354 */:
      case CSS_VALUE_APPEARANCE_CHECKBOX /* 1356 */:
      case CSS_VALUE_APPEARANCE_MENULIST /* 1357 */:
      case CSS_VALUE_APPEARANCE_MENULIST_BUTTON /* 1358 */:
      case CSS_VALUE_APPEARANCE_LISTBOX /* 1359 */:
      case CSS_VALUE_APPEARANCE_RADIO /* 1360 */:
      case CSS_VALUE_APPEARANCE_SEARCH_FIELD /* 1361 */:
      case CSS_VALUE_APPEARANCE_TEXT_FIELD /* 1362 */:
      case AUDIO_CONTEXT_CREATE_PANNER_AUTOMATED /* 1363 */:
      case PANNER_NODE_SET_POSITION /* 1364 */:
      case PANNER_NODE_SET_ORIENTATION /* 1365 */:
      case AUDIO_LISTENER_SET_POSITION /* 1366 */:
      case AUDIO_LISTENER_SET_ORIENTATION /* 1367 */:
      case INTERSECTION_OBSERVER_CONSTRUCTOR /* 1368 */:
      case DURABLE_STORAGE_PERSIST /* 1369 */:
      case DURABLE_STORAGE_PERSISTED /* 1370 */:
      case DURABLE_STORAGE_ESTIMATE /* 1371 */:
      case OBSOLETE_CSS_DEEP_COMBINATOR_AND_SHADOW /* 1375 */:
      case OPACITY_WITH_PRESERVE3_D_QUIRK /* 1376 */:
      case CSS_SELECTOR_PSEUDO_READ_ONLY /* 1377 */:
      case CSS_SELECTOR_PSEUDO_READ_WRITE /* 1378 */:
      case CSS_SELECTOR_PSEUDO_DEFINED /* 1383 */:
      case RTC_PEER_CONNECTION_ADD_ICE_CANDIDATE_PROMISE /* 1384 */:
      case RTC_PEER_CONNECTION_ADD_ICE_CANDIDATE_LEGACY /* 1385 */:
      case RTC_ICE_CANDIDATE_DEFAULT_SDP_M_LINE_INDEX /* 1386 */:
      case MEDIA_STREAM_CONSTRAINTS_OLD_AND_NEW /* 1389 */:
      case OBSOLETE_V8_ARRAY_PROTECTOR_DIRTIED /* 1390 */:
      case V8_ARRAY_SPECIES_MODIFIED /* 1391 */:
      case V8_ARRAY_PROTOTYPE_CONSTRUCTOR_MODIFIED /* 1392 */:
      case OBSOLETE_V8_ARRAY_INSTANCE_PROTO_MODIFIED /* 1393 */:
      case V8_ARRAY_INSTANCE_CONSTRUCTOR_MODIFIED /* 1394 */:
      case OBSOLETE_V8_LEGACY_FUNCTION_DECLARATION /* 1395 */:
      case OBSOLETE_V8_REG_EXP_PROTOTYPE_SOURCE_GETTER /* 1396 */:
      case OBSOLETE_V8_REG_EXP_PROTOTYPE_OLD_FLAG_GETTER /* 1397 */:
      case V8_DECIMAL_WITH_LEADING_ZERO_IN_STRICT_MODE /* 1398 */:
      case GET_USER_MEDIA_PREFIXED /* 1400 */:
      case GET_USER_MEDIA_LEGACY /* 1401 */:
      case GET_USER_MEDIA_PROMISE /* 1402 */:
      case CSS_FILTER_FUNCTION_NO_ARGUMENTS /* 1403 */:
      case V8_LEGACY_DATE_PARSER /* 1404 */:
      case OPEN_SEARCH_INSECURE_ORIGIN_INSECURE_TARGET /* 1405 */:
      case OPEN_SEARCH_INSECURE_ORIGIN_SECURE_TARGET /* 1406 */:
      case OPEN_SEARCH_SECURE_ORIGIN_INSECURE_TARGET /* 1407 */:
      case OPEN_SEARCH_SECURE_ORIGIN_SECURE_TARGET /* 1408 */:
      case REGISTER_PROTOCOL_HANDLER_SECURE_ORIGIN /* 1409 */:
      case REGISTER_PROTOCOL_HANDLER_INSECURE_ORIGIN /* 1410 */:
      case CROSS_ORIGIN_WINDOW_ALERT /* 1411 */:
      case CROSS_ORIGIN_WINDOW_CONFIRM /* 1412 */:
      case OBSOLETE_CROSS_ORIGIN_WINDOW_PROMPT /* 1413 */:
      case CROSS_ORIGIN_WINDOW_PRINT /* 1414 */:
      case MEDIA_STREAM_ON_ACTIVE /* 1415 */:
      case MEDIA_STREAM_ON_INACTIVE /* 1416 */:
      case ADD_EVENT_LISTENER_PASSIVE_TRUE /* 1417 */:
      case ADD_EVENT_LISTENER_PASSIVE_FALSE /* 1418 */:
      case CSP_REFERRER_DIRECTIVE /* 1419 */:
      case ELEMENT_REQUEST_POINTER_LOCK_IN_SHADOW /* 1421 */:
      case SHADOW_ROOT_POINTER_LOCK_ELEMENT /* 1422 */:
      case OBSOLETE_DOCUMENT_POINTER_LOCK_ELEMENT_IN_V0_SHADOW /* 1423 */:
      case TEXT_AREA_MAX_LENGTH /* 1424 */:
      case TEXT_AREA_MIN_LENGTH /* 1425 */:
      case TOP_NAVIGATION_FROM_SUB_FRAME /* 1426 */:
      case PREFIXED_ELEMENT_REQUEST_FULLSCREEN_IN_SHADOW /* 1427 */:
      case MEDIA_SOURCE_ABORT_REMOVE /* 1428 */:
      case MEDIA_SOURCE_DURATION_TRUNCATING_BUFFERED /* 1429 */:
      case AUDIO_CONTEXT_CROSS_ORIGIN_IFRAME /* 1430 */:
      case POINTER_EVENT_SET_CAPTURE /* 1431 */:
      case POINTER_EVENT_DISPATCH /* 1432 */:
      case MIDI_MESSAGE_EVENT_RECEIVED_TIME /* 1433 */:
      case V8_MEDIA_STREAM_ACTIVE_ATTRIBUTE_GETTER /* 1435 */:
      case BEFORE_INSTALL_PROMPT_EVENT /* 1436 */:
      case BEFORE_INSTALL_PROMPT_EVENT_USER_CHOICE /* 1437 */:
      case BEFORE_INSTALL_PROMPT_EVENT_PREVENT_DEFAULT /* 1438 */:
      case BEFORE_INSTALL_PROMPT_EVENT_PROMPT /* 1439 */:
      case EXEC_COMMAND_ALTERS_HTML_STRUCTURE /* 1440 */:
      case SECURE_CONTEXT_CHECK_PASSED /* 1441 */:
      case SECURE_CONTEXT_CHECK_FAILED /* 1442 */:
      case SECURE_CONTEXT_CHECK_FOR_SANDBOXED_ORIGIN_PASSED /* 1443 */:
      case SECURE_CONTEXT_CHECK_FOR_SANDBOXED_ORIGIN_FAILED /* 1444 */:
      case V8_DEFINE_GETTER_OR_SETTER_WOULD_THROW /* 1445 */:
      case V8_FUNCTION_CONSTRUCTOR_RETURNED_UNDEFINED /* 1446 */:
      case V8_BROADCAST_CHANNEL_CONSTRUCTOR /* 1447 */:
      case V8_BROADCAST_CHANNEL_POST_MESSAGE_METHOD /* 1448 */:
      case V8_BROADCAST_CHANNEL_CLOSE_METHOD /* 1449 */:
      case TOUCH_START_FIRED /* 1450 */:
      case MOUSE_DOWN_FIRED /* 1451 */:
      case POINTER_DOWN_FIRED /* 1452 */:
      case POINTER_DOWN_FIRED_FOR_TOUCH /* 1453 */:
      case POINTER_EVENT_DISPATCH_POINTER_DOWN /* 1454 */:
      case SVGSMIL_BEGIN_OR_END_EVENT_VALUE /* 1455 */:
      case SVGSMIL_BEGIN_OR_END_SYNCBASE_VALUE /* 1456 */:
      case SVGSMIL_ELEMENT_INSERTED_AFTER_LOAD /* 1457 */:
      case V8_VISUAL_VIEWPORT_OFFSET_LEFT_ATTRIBUTE_GETTER /* 1458 */:
      case V8_VISUAL_VIEWPORT_OFFSET_TOP_ATTRIBUTE_GETTER /* 1459 */:
      case V8_VISUAL_VIEWPORT_PAGE_LEFT_ATTRIBUTE_GETTER /* 1460 */:
      case V8_VISUAL_VIEWPORT_PAGE_TOP_ATTRIBUTE_GETTER /* 1461 */:
      case V8_VISUAL_VIEWPORT_WIDTH_ATTRIBUTE_GETTER /* 1462 */:
      case V8_VISUAL_VIEWPORT_HEIGHT_ATTRIBUTE_GETTER /* 1463 */:
      case V8_VISUAL_VIEWPORT_SCALE_ATTRIBUTE_GETTER /* 1464 */:
      case VISUAL_VIEWPORT_SCROLL_FIRED /* 1465 */:
      case VISUAL_VIEWPORT_RESIZE_FIRED /* 1466 */:
      case NODE_GET_ROOT_NODE /* 1467 */:
      case SLOT_CHANGE_EVENT_ADD_LISTENER /* 1468 */:
      case CSS_VALUE_APPEARANCE_BUTTON_FOR_BUTTON /* 1471 */:
      case CSS_VALUE_APPEARANCE_BUTTON_FOR_OTHER_BUTTONS /* 1472 */:
      case CSS_VALUE_APPEARANCE_TEXT_FIELD_FOR_SEARCH /* 1474 */:
      case CSS_VALUE_APPEARANCE_TEXT_FIELD_FOR_TEXT_FIELD /* 1475 */:
      case RTC_PEER_CONNECTION_GET_STATS /* 1476 */:
      case SVGSMIL_ANIMATION_APPLIED_EFFECT /* 1477 */:
      case PERFORMANCE_RESOURCE_TIMING_SIZES /* 1478 */:
      case EVENT_SOURCE_DOCUMENT /* 1479 */:
      case EVENT_SOURCE_WORKER /* 1480 */:
      case SINGLE_ORIGIN_IN_TIMING_ALLOW_ORIGIN /* 1481 */:
      case MULTIPLE_ORIGINS_IN_TIMING_ALLOW_ORIGIN /* 1482 */:
      case STAR_IN_TIMING_ALLOW_ORIGIN /* 1483 */:
      case SVGSMIL_ADDITIVE_ANIMATION /* 1484 */:
      case OBSOLETE_SEND_BEACON_WITH_NON_SIMPLE_CONTENT_TYPE /* 1485 */:
      case CHROME_LOAD_TIMES_REQUEST_TIME /* 1486 */:
      case CHROME_LOAD_TIMES_START_LOAD_TIME /* 1487 */:
      case CHROME_LOAD_TIMES_COMMIT_LOAD_TIME /* 1488 */:
      case CHROME_LOAD_TIMES_FINISH_DOCUMENT_LOAD_TIME /* 1489 */:
      case CHROME_LOAD_TIMES_FINISH_LOAD_TIME /* 1490 */:
      case CHROME_LOAD_TIMES_FIRST_PAINT_TIME /* 1491 */:
      case CHROME_LOAD_TIMES_FIRST_PAINT_AFTER_LOAD_TIME /* 1492 */:
      case CHROME_LOAD_TIMES_NAVIGATION_TYPE /* 1493 */:
      case CHROME_LOAD_TIMES_WAS_FETCHED_VIA_SPDY /* 1494 */:
      case CHROME_LOAD_TIMES_WAS_NPN_NEGOTIATED /* 1495 */:
      case CHROME_LOAD_TIMES_NPN_NEGOTIATED_PROTOCOL /* 1496 */:
      case CHROME_LOAD_TIMES_WAS_ALTERNATE_PROTOCOL_AVAILABLE /* 1497 */:
      case CHROME_LOAD_TIMES_CONNECTION_INFO /* 1498 */:
      case CHROME_LOAD_TIMES_UNKNOWN /* 1499 */:
      case 1500:
      case WEB_SHARE_SHARE /* 1501 */:
      case AUXCLICK_ADD_LISTENER_COUNT /* 1502 */:
      case HTML_CANVAS_ELEMENT /* 1503 */:
      case SVGSMIL_ANIMATION_ELEMENT_TIMING /* 1504 */:
      case SVGSMIL_BEGIN_END_ANIMATION_ELEMENT /* 1505 */:
      case SVGSMIL_PAUSING /* 1506 */:
      case SVGSMIL_CURRENT_TIME /* 1507 */:
      case HTML_BODY_ELEMENT_ON_SELECTION_CHANGE_ATTRIBUTE /* 1508 */:
      case USB_GET_DEVICES /* 1519 */:
      case USB_REQUEST_DEVICE /* 1520 */:
      case USB_DEVICE_OPEN /* 1521 */:
      case USB_DEVICE_CLOSE /* 1522 */:
      case USB_DEVICE_SELECT_CONFIGURATION /* 1523 */:
      case USB_DEVICE_CLAIM_INTERFACE /* 1524 */:
      case USB_DEVICE_RELEASE_INTERFACE /* 1525 */:
      case USB_DEVICE_SELECT_ALTERNATE_INTERFACE /* 1526 */:
      case USB_DEVICE_CONTROL_TRANSFER_IN /* 1527 */:
      case USB_DEVICE_CONTROL_TRANSFER_OUT /* 1528 */:
      case USB_DEVICE_CLEAR_HALT /* 1529 */:
      case USB_DEVICE_TRANSFER_IN /* 1530 */:
      case USB_DEVICE_TRANSFER_OUT /* 1531 */:
      case USB_DEVICE_ISOCHRONOUS_TRANSFER_IN /* 1532 */:
      case USB_DEVICE_ISOCHRONOUS_TRANSFER_OUT /* 1533 */:
      case USB_DEVICE_RESET /* 1534 */:
      case POINTER_ENTER_LEAVE_FIRED /* 1535 */:
      case POINTER_OVER_OUT_FIRED /* 1536 */:
      case DRAGGABLE_ATTRIBUTE /* 1539 */:
      case CLEAN_SCRIPT_ELEMENT_WITH_NONCE /* 1540 */:
      case POTENTIALLY_INJECTED_SCRIPT_ELEMENT_WITH_NONCE /* 1541 */:
      case PENDING_STYLESHEET_ADDED_AFTER_BODY_STARTED /* 1542 */:
      case UNTRUSTED_MOUSE_DOWN_EVENT_DISPATCHED_TO_SELECT /* 1543 */:
      case BLOCKED_SNIFFING_AUDIO_TO_SCRIPT /* 1544 */:
      case BLOCKED_SNIFFING_VIDEO_TO_SCRIPT /* 1545 */:
      case BLOCKED_SNIFFING_CSV_TO_SCRIPT /* 1546 */:
      case META_REFRESH /* 1548 */:
      case META_REFRESH_WHEN_CSP_BLOCKS_INLINE_SCRIPT /* 1550 */:
      case MIDDLE_CLICK_AUTOSCROLL_START /* 1551 */:
      case RTC_PEER_CONNECTION_CREATE_OFFER_OPTIONS_OFFER_TO_RECEIVE /* 1553 */:
      case DRAG_AND_DROP_SCROLL_START /* 1554 */:
      case PRESENTATION_CONNECTION_LIST_CONNECTION_AVAILABLE_EVENT_LISTENER /* 1555 */:
      case WEB_AUDIO_AUTOPLAY_CROSS_ORIGIN_IFRAME /* 1556 */:
      case VR_GET_DISPLAYS /* 1558 */:
      case XSS_AUDITOR_BLOCKED_SCRIPT /* 1581 */:
      case XSS_AUDITOR_BLOCKED_ENTIRE_PAGE /* 1582 */:
      case XSS_AUDITOR_DISABLED /* 1583 */:
      case XSS_AUDITOR_ENABLED_FILTER /* 1584 */:
      case XSS_AUDITOR_ENABLED_BLOCK /* 1585 */:
      case XSS_AUDITOR_INVALID /* 1586 */:
      case TEXT_INPUT_EVENT_ON_INPUT /* 1589 */:
      case TEXT_INPUT_EVENT_ON_TEXT_AREA /* 1590 */:
      case TEXT_INPUT_EVENT_ON_CONTENT_EDITABLE /* 1591 */:
      case TEXT_INPUT_EVENT_ON_NOT_NODE /* 1592 */:
      case WEBKIT_BEFORE_TEXT_INSERTED_ON_INPUT /* 1593 */:
      case WEBKIT_BEFORE_TEXT_INSERTED_ON_TEXT_AREA /* 1594 */:
      case WEBKIT_BEFORE_TEXT_INSERTED_ON_CONTENT_EDITABLE /* 1595 */:
      case WEBKIT_BEFORE_TEXT_INSERTED_ON_NOT_NODE /* 1596 */:
      case WEBKIT_EDITABLE_CONTENT_CHANGED_ON_INPUT /* 1597 */:
      case WEBKIT_EDITABLE_CONTENT_CHANGED_ON_TEXT_AREA /* 1598 */:
      case WEBKIT_EDITABLE_CONTENT_CHANGED_ON_CONTENT_EDITABLE /* 1599 */:
      case WEBKIT_EDITABLE_CONTENT_CHANGED_ON_NOT_NODE /* 1600 */:
      case V8_NAVIGATOR_USER_MEDIA_ERROR_CONSTRAINT_NAME_ATTRIBUTE_GETTER /* 1601 */:
      case V8HTML_MEDIA_ELEMENT_SRC_OBJECT_ATTRIBUTE_GETTER /* 1602 */:
      case V8HTML_MEDIA_ELEMENT_SRC_OBJECT_ATTRIBUTE_SETTER /* 1603 */:
      case CREATE_OBJECT_URL_BLOB /* 1604 */:
      case CREATE_OBJECT_URL_MEDIA_SOURCE /* 1605 */:
      case CREATE_OBJECT_URL_MEDIA_STREAM /* 1606 */:
      case LONG_TASK_OBSERVER /* 1615 */:
      case CSS_OFFSET_IN_EFFECT /* 1617 */:
      case VR_GET_DISPLAYS_INSECURE_ORIGIN /* 1618 */:
      case VR_REQUEST_PRESENT /* 1619 */:
      case VR_REQUEST_PRESENT_INSECURE_ORIGIN /* 1620 */:
      case VR_DEPRECATED_FIELD_OF_VIEW /* 1621 */:
      case VIDEO_IN_CANVAS /* 1622 */:
      case HIDDEN_AUTOPLAYED_VIDEO_IN_CANVAS /* 1623 */:
      case OFFSCREEN_CANVAS /* 1624 */:
      case GAMEPAD_POSE /* 1625 */:
      case GAMEPAD_HAND /* 1626 */:
      case GAMEPAD_DISPLAY_ID /* 1627 */:
      case GAMEPAD_BUTTON_TOUCHED /* 1628 */:
      case GAMEPAD_POSE_HAS_ORIENTATION /* 1629 */:
      case GAMEPAD_POSE_HAS_POSITION /* 1630 */:
      case GAMEPAD_POSE_POSITION /* 1631 */:
      case GAMEPAD_POSE_LINEAR_VELOCITY /* 1632 */:
      case GAMEPAD_POSE_LINEAR_ACCELERATION /* 1633 */:
      case GAMEPAD_POSE_ORIENTATION /* 1634 */:
      case GAMEPAD_POSE_ANGULAR_VELOCITY /* 1635 */:
      case GAMEPAD_POSE_ANGULAR_ACCELERATION /* 1636 */:
      case V8RTC_DATA_CHANNEL_MAX_RETRANSMIT_TIME_ATTRIBUTE_GETTER /* 1638 */:
      case V8RTC_DATA_CHANNEL_MAX_RETRANSMITS_ATTRIBUTE_GETTER /* 1639 */:
      case V8RTC_DATA_CHANNEL_RELIABLE_ATTRIBUTE_GETTER /* 1640 */:
      case V8RTC_PEER_CONNECTION_ADD_STREAM_METHOD /* 1641 */:
      case V8RTC_PEER_CONNECTION_CREATE_DTMF_SENDER_METHOD /* 1642 */:
      case V8RTC_PEER_CONNECTION_GET_LOCAL_STREAMS_METHOD /* 1643 */:
      case V8RTC_PEER_CONNECTION_GET_REMOTE_STREAMS_METHOD /* 1644 */:
      case V8RTC_PEER_CONNECTION_REMOVE_STREAM_METHOD /* 1646 */:
      case RTC_PEER_CONNECTION_CREATE_DATA_CHANNEL_MAX_RETRANSMIT_TIME /* 1648 */:
      case RTC_PEER_CONNECTION_CREATE_DATA_CHANNEL_MAX_RETRANSMITS /* 1649 */:
      case AUDIO_CONTEXT_CREATE_CONSTANT_SOURCE /* 1650 */:
      case WEB_AUDIO_CONSTANT_SOURCE_NODE /* 1651 */:
      case BLINK_MAC_SYSTEM_FONT /* 1654 */:
      case RTC_ICE_SERVER_URL /* 1656 */:
      case RTC_ICE_SERVER_UR_LS /* 1657 */:
      case OFFSCREEN_CANVAS_TRANSFER_TO_IMAGE_BITMAP2_D /* 1658 */:
      case OFFSCREEN_CANVAS_TRANSFER_TO_IMAGE_BITMAP_WEB_GL /* 1659 */:
      case OFFSCREEN_CANVAS_COMMIT2_D /* 1660 */:
      case OFFSCREEN_CANVAS_COMMIT_WEB_GL /* 1661 */:
      case RTC_CONFIGURATION_ICE_TRANSPORT_POLICY /* 1662 */:
      case RTC_CONFIGURATION_ICE_TRANSPORTS /* 1664 */:
      case OBSOLETE_DOCUMENT_FULLSCREEN_ELEMENT_IN_V0_SHADOW /* 1665 */:
      case SCRIPT_WITH_CSP_BYPASSING_SCHEME_PARSER_INSERTED /* 1666 */:
      case SCRIPT_WITH_CSP_BYPASSING_SCHEME_NOT_PARSER_INSERTED /* 1667 */:
      case DOCUMENT_CREATE_ELEMENT2ND_ARG_STRING_HANDLING /* 1668 */:
      case V8_MEDIA_RECORDER_START_METHOD /* 1669 */:
      case WEB_BLUETOOTH_REQUEST_DEVICE /* 1670 */:
      case UNITLESS_PERSPECTIVE_IN_PERSPECTIVE_PROPERTY /* 1671 */:
      case UNITLESS_PERSPECTIVE_IN_TRANSFORM_PROPERTY /* 1672 */:
      case V8RTC_SESSION_DESCRIPTION_TYPE_ATTRIBUTE_GETTER /* 1673 */:
      case V8RTC_SESSION_DESCRIPTION_TYPE_ATTRIBUTE_SETTER /* 1674 */:
      case V8RTC_SESSION_DESCRIPTION_SDP_ATTRIBUTE_GETTER /* 1675 */:
      case V8RTC_SESSION_DESCRIPTION_SDP_ATTRIBUTE_SETTER /* 1676 */:
      case RTC_SESSION_DESCRIPTION_INIT_NO_TYPE /* 1677 */:
      case RTC_SESSION_DESCRIPTION_INIT_NO_SDP /* 1678 */:
      case HTML_MEDIA_ELEMENT_PRELOAD_FORCED_METADATA /* 1679 */:
      case GENERIC_SENSOR_START /* 1680 */:
      case GENERIC_SENSOR_STOP /* 1681 */:
      case TOUCH_EVENT_PREVENTED_NO_TOUCH_ACTION /* 1682 */:
      case TOUCH_EVENT_PREVENTED_FORCED_DOCUMENT_PASSIVE_NO_TOUCH_ACTION /* 1683 */:
      case V8_EVENT_STOP_PROPAGATION_METHOD /* 1684 */:
      case V8_EVENT_STOP_IMMEDIATE_PROPAGATION_METHOD /* 1685 */:
      case IMAGE_CAPTURE_CONSTRUCTOR /* 1686 */:
      case V8_DOCUMENT_ROOT_SCROLLER_ATTRIBUTE_GETTER /* 1687 */:
      case V8_DOCUMENT_ROOT_SCROLLER_ATTRIBUTE_SETTER /* 1688 */:
      case CUSTOM_ELEMENT_REGISTRY_DEFINE /* 1689 */:
      case LINK_HEADER_SERVICE_WORKER /* 1690 */:
      case CSS_FLEXIBLE_BOX /* 1692 */:
      case CSS_GRID_LAYOUT /* 1693 */:
      case FULLSCREEN_ALLOWED_BY_ORIENTATION_CHANGE /* 1696 */:
      case SERVICE_WORKER_RESPOND_TO_NAVIGATION_REQUEST_WITH_REDIRECTED_RESPONSE /* 1697 */:
      case V8_AUDIO_CONTEXT_CONSTRUCTOR /* 1698 */:
      case V8_OFFLINE_AUDIO_CONTEXT_CONSTRUCTOR /* 1699 */:
      case APP_INSTALLED_EVENT_ADD_LISTENER /* 1700 */:
      case AUDIO_CONTEXT_GET_OUTPUT_TIMESTAMP /* 1701 */:
      case V8_MEDIA_STREAM_AUDIO_DESTINATION_NODE_CONSTRUCTOR /* 1702 */:
      case V8_ANALYSER_NODE_CONSTRUCTOR /* 1703 */:
      case V8_AUDIO_BUFFER_CONSTRUCTOR /* 1704 */:
      case V8_AUDIO_BUFFER_SOURCE_NODE_CONSTRUCTOR /* 1705 */:
      case V8_AUDIO_PROCESSING_EVENT_CONSTRUCTOR /* 1706 */:
      case V8_BIQUAD_FILTER_NODE_CONSTRUCTOR /* 1707 */:
      case V8_CHANNEL_MERGER_NODE_CONSTRUCTOR /* 1708 */:
      case V8_CHANNEL_SPLITTER_NODE_CONSTRUCTOR /* 1709 */:
      case V8_CONSTANT_SOURCE_NODE_CONSTRUCTOR /* 1710 */:
      case V8_CONVOLVER_NODE_CONSTRUCTOR /* 1711 */:
      case V8_DELAY_NODE_CONSTRUCTOR /* 1712 */:
      case V8_DYNAMICS_COMPRESSOR_NODE_CONSTRUCTOR /* 1713 */:
      case V8_GAIN_NODE_CONSTRUCTOR /* 1714 */:
      case V8IIR_FILTER_NODE_CONSTRUCTOR /* 1715 */:
      case V8_MEDIA_ELEMENT_AUDIO_SOURCE_NODE_CONSTRUCTOR /* 1716 */:
      case V8_MEDIA_STREAM_AUDIO_SOURCE_NODE_CONSTRUCTOR /* 1717 */:
      case V8_OFFLINE_AUDIO_COMPLETION_EVENT_CONSTRUCTOR /* 1718 */:
      case V8_OSCILLATOR_NODE_CONSTRUCTOR /* 1719 */:
      case V8_PANNER_NODE_CONSTRUCTOR /* 1720 */:
      case V8_PERIODIC_WAVE_CONSTRUCTOR /* 1721 */:
      case V8_STEREO_PANNER_NODE_CONSTRUCTOR /* 1722 */:
      case V8_WAVE_SHAPER_NODE_CONSTRUCTOR /* 1723 */:
      case V8_HEADERS_GET_ALL_METHOD /* 1724 */:
      case NAVIGATOR_VIBRATE_ENGAGEMENT_NONE /* 1725 */:
      case NAVIGATOR_VIBRATE_ENGAGEMENT_MINIMAL /* 1726 */:
      case NAVIGATOR_VIBRATE_ENGAGEMENT_LOW /* 1727 */:
      case NAVIGATOR_VIBRATE_ENGAGEMENT_MEDIUM /* 1728 */:
      case NAVIGATOR_VIBRATE_ENGAGEMENT_HIGH /* 1729 */:
      case NAVIGATOR_VIBRATE_ENGAGEMENT_MAX /* 1730 */:
      case ALERT_ENGAGEMENT_NONE /* 1731 */:
      case ALERT_ENGAGEMENT_MINIMAL /* 1732 */:
      case ALERT_ENGAGEMENT_LOW /* 1733 */:
      case ALERT_ENGAGEMENT_MEDIUM /* 1734 */:
      case ALERT_ENGAGEMENT_HIGH /* 1735 */:
      case ALERT_ENGAGEMENT_MAX /* 1736 */:
      case CONFIRM_ENGAGEMENT_NONE /* 1737 */:
      case CONFIRM_ENGAGEMENT_MINIMAL /* 1738 */:
      case CONFIRM_ENGAGEMENT_LOW /* 1739 */:
      case CONFIRM_ENGAGEMENT_MEDIUM /* 1740 */:
      case CONFIRM_ENGAGEMENT_HIGH /* 1741 */:
      case CONFIRM_ENGAGEMENT_MAX /* 1742 */:
      case PROMPT_ENGAGEMENT_NONE /* 1743 */:
      case PROMPT_ENGAGEMENT_MINIMAL /* 1744 */:
      case PROMPT_ENGAGEMENT_LOW /* 1745 */:
      case PROMPT_ENGAGEMENT_MEDIUM /* 1746 */:
      case PROMPT_ENGAGEMENT_HIGH /* 1747 */:
      case PROMPT_ENGAGEMENT_MAX /* 1748 */:
      case TOP_NAV_IN_SANDBOX /* 1749 */:
      case TOP_NAV_IN_SANDBOX_WITHOUT_GESTURE /* 1750 */:
      case TOP_NAV_IN_SANDBOX_WITH_PERM /* 1751 */:
      case TOP_NAV_IN_SANDBOX_WITH_PERM_BUT_NO_GESTURE /* 1752 */:
      case REFERRER_POLICY_HEADER /* 1753 */:
      case HTML_ANCHOR_ELEMENT_REFERRER_POLICY_ATTRIBUTE /* 1754 */:
      case HTMLI_FRAME_ELEMENT_REFERRER_POLICY_ATTRIBUTE /* 1755 */:
      case HTML_IMAGE_ELEMENT_REFERRER_POLICY_ATTRIBUTE /* 1756 */:
      case HTML_LINK_ELEMENT_REFERRER_POLICY_ATTRIBUTE /* 1757 */:
      case BASE_ELEMENT /* 1758 */:
      case BASE_WITH_CROSS_ORIGIN_HREF /* 1759 */:
      case BASE_WITH_DATA_HREF /* 1760 */:
      case BASE_WITH_NEWLINES_IN_TARGET /* 1761 */:
      case BASE_WITH_OPEN_BRACKET_IN_TARGET /* 1762 */:
      case OBSOLETE_BASE_WOULD_BE_BLOCKED_BY_DEFAULT_SRC /* 1763 */:
      case V8_ASSIGMENT_EXPRESSION_LHS_IS_CALL_IN_SLOPPY /* 1764 */:
      case V8_ASSIGMENT_EXPRESSION_LHS_IS_CALL_IN_STRICT /* 1765 */:
      case V8_PROMISE_CONSTRUCTOR_RETURNED_UNDEFINED /* 1766 */:
      case FORM_SUBMITTED_WITH_UNCLOSED_FORM_CONTROL /* 1767 */:
      case SCROLLBAR_USE_VERTICAL_SCROLLBAR_BUTTON /* 1777 */:
      case SCROLLBAR_USE_VERTICAL_SCROLLBAR_TRACK /* 1779 */:
      case SCROLLBAR_USE_HORIZONTAL_SCROLLBAR_BUTTON /* 1780 */:
      case SCROLLBAR_USE_HORIZONTAL_SCROLLBAR_TRACK /* 1782 */:
      case HTML_TABLE_CELL_ELEMENT_COLSPAN /* 1783 */:
      case OBSOLETE_HTML_TABLE_CELL_ELEMENT_COLSPAN_GREATER_THAN1000 /* 1784 */:
      case OBSOLETE_HTML_TABLE_CELL_ELEMENT_COLSPAN_GREATER_THAN8190 /* 1785 */:
      case OBSOLETE_SELECTION_ADD_RANGE_INTERSECT /* 1786 */:
      case POST_MESSAGE_FROM_INSECURE_TO_SECURE_TOPLEVEL /* 1787 */:
      case V8_MEDIA_SESSION_METADATA_ATTRIBUTE_GETTER /* 1788 */:
      case V8_MEDIA_SESSION_METADATA_ATTRIBUTE_SETTER /* 1789 */:
      case V8_MEDIA_SESSION_PLAYBACK_STATE_ATTRIBUTE_GETTER /* 1790 */:
      case V8_MEDIA_SESSION_PLAYBACK_STATE_ATTRIBUTE_SETTER /* 1791 */:
      case V8_MEDIA_SESSION_SET_ACTION_HANDLER_METHOD /* 1792 */:
      case AUDIO_PARAM_CANCEL_AND_HOLD_AT_TIME /* 1797 */:
      case CSS_VALUE_USER_MODIFY_READ_ONLY /* 1798 */:
      case CSS_VALUE_USER_MODIFY_READ_WRITE /* 1799 */:
      case CSS_VALUE_USER_MODIFY_READ_WRITE_PLAINTEXT_ONLY /* 1800 */:
      case CSS_VALUE_ON_DEMAND /* 1802 */:
      case SERVICE_WORKER_NAVIGATION_PRELOAD /* 1803 */:
      case FULLSCREEN_REQUEST_WITH_PENDING_ELEMENT /* 1804 */:
      case HTMLI_FRAME_ELEMENT_ALLOWFULLSCREEN_ATTRIBUTE_SET_AFTER_CONTENT_LOAD /* 1805 */:
      case POINTER_EVENT_SET_CAPTURE_OUTSIDE_DISPATCH /* 1806 */:
      case NOTIFICATION_PERMISSION_REQUESTED_INSECURE_ORIGIN /* 1807 */:
      case V8_DEPRECATED_STORAGE_INFO_QUERY_USAGE_AND_QUOTA_METHOD /* 1808 */:
      case V8_DEPRECATED_STORAGE_INFO_REQUEST_QUOTA_METHOD /* 1809 */:
      case V8_DEPRECATED_STORAGE_QUOTA_QUERY_USAGE_AND_QUOTA_METHOD /* 1810 */:
      case V8_DEPRECATED_STORAGE_QUOTA_REQUEST_QUOTA_METHOD /* 1811 */:
      case V8_FILE_READER_SYNC_CONSTRUCTOR /* 1812 */:
      case V8HTML_VIDEO_ELEMENT_POSTER_ATTRIBUTE_GETTER /* 1815 */:
      case V8HTML_VIDEO_ELEMENT_POSTER_ATTRIBUTE_SETTER /* 1816 */:
      case NOTIFICATION_PERMISSION_REQUESTED_IFRAME /* 1817 */:
      case RTCP_MUX_POLICY_NEGOTIATE /* 1823 */:
      case DOM_CLOBBERED_VARIABLE_ACCESSED /* 1824 */:
      case HTML_DOCUMENT_CREATE_PROCESSING_INSTRUCTION /* 1825 */:
      case FETCH_RESPONSE_CONSTRUCTION_WITH_STREAM /* 1826 */:
      case LOCATION_ORIGIN /* 1827 */:
      case CANVAS2_D_FILTER /* 1830 */:
      case CANVAS2_D_IMAGE_SMOOTHING_QUALITY /* 1831 */:
      case CANVAS_TO_BLOB /* 1832 */:
      case CANVAS_TO_DATA_URL /* 1833 */:
      case OFFSCREEN_CANVAS_CONVERT_TO_BLOB /* 1834 */:
      case SVG_IN_CANVAS2_D /* 1835 */:
      case SVG_IN_WEB_GL /* 1836 */:
      case SELECTION_FUNCIONS_CHANGE_FOCUS /* 1837 */:
      case HTML_OBJECT_ELEMENT_GETTER /* 1838 */:
      case HTML_OBJECT_ELEMENT_SETTER /* 1839 */:
      case HTML_EMBED_ELEMENT_GETTER /* 1840 */:
      case HTML_EMBED_ELEMENT_SETTER /* 1841 */:
      case TRANSFORM_USES_BOX_SIZE_ON_SVG /* 1842 */:
      case SCROLL_BY_KEYBOARD_ARROW_KEYS /* 1843 */:
      case SCROLL_BY_KEYBOARD_PAGE_UP_DOWN_KEYS /* 1844 */:
      case SCROLL_BY_KEYBOARD_HOME_END_KEYS /* 1845 */:
      case SCROLL_BY_KEYBOARD_SPACEBAR_KEY /* 1846 */:
      case SCROLL_BY_TOUCH /* 1847 */:
      case SCROLL_BY_WHEEL /* 1848 */:
      case SCHEDULED_ACTION_IGNORED /* 1849 */:
      case GET_CANVAS2_D_CONTEXT_ATTRIBUTES /* 1850 */:
      case V8HTML_INPUT_ELEMENT_CAPTURE_ATTRIBUTE_GETTER /* 1851 */:
      case V8HTML_INPUT_ELEMENT_CAPTURE_ATTRIBUTE_SETTER /* 1852 */:
      case HTML_MEDIA_ELEMENT_CONTROLS_LIST_ATTRIBUTE /* 1853 */:
      case HTML_MEDIA_ELEMENT_CONTROLS_LIST_NO_DOWNLOAD /* 1854 */:
      case HTML_MEDIA_ELEMENT_CONTROLS_LIST_NO_FULLSCREEN /* 1855 */:
      case HTML_MEDIA_ELEMENT_CONTROLS_LIST_NO_REMOTE_PLAYBACK /* 1856 */:
      case POINTER_EVENT_CLICK_RETARGET_CAUSED_BY_CAPTURE /* 1857 */:
      case VR_DISPLAY_DISPLAY_NAME /* 1861 */:
      case VR_EYE_PARAMETERS_OFFSET /* 1862 */:
      case VR_POSE_LINEAR_VELOCITY /* 1863 */:
      case VR_POSE_LINEAR_ACCELERATION /* 1864 */:
      case VR_POSE_ANGULAR_VELOCITY /* 1865 */:
      case VR_POSE_ANGULAR_ACCELERATION /* 1866 */:
      case CSS_OVERFLOW_PAGED /* 1867 */:
      case OBSOLETE_HTML_TABLE_ELEMENT_PRESENTATION_ATTRIBUTE_BACKGROUND /* 1869 */:
      case V8_NAVIGATOR_GET_INSTALLED_RELATED_APPS_METHOD /* 1870 */:
      case NAMED_ACCESS_ON_WINDOW_CHILD_BROWSING_CONTEXT /* 1871 */:
      case NAMED_ACCESS_ON_WINDOW_CHILD_BROWSING_CONTEXT_CROSS_ORIGIN_NAME_MISMATCH /* 1872 */:
      case V0_CUSTOM_ELEMENTS_REGISTER_HTML_CUSTOM_TAG /* 1873 */:
      case V0_CUSTOM_ELEMENTS_REGISTER_HTML_TYPE_EXTENSION /* 1874 */:
      case V0_CUSTOM_ELEMENTS_REGISTER_SVG_ELEMENT /* 1875 */:
      case V0_CUSTOM_ELEMENTS_CREATE_CUSTOM_TAG_ELEMENT /* 1877 */:
      case V0_CUSTOM_ELEMENTS_CREATE_TYPE_EXTENSION_ELEMENT /* 1878 */:
      case V0_CUSTOM_ELEMENTS_CONSTRUCT /* 1879 */:
      case WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_GET_DESCRIPTOR /* 1882 */:
      case WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_GET_DESCRIPTORS /* 1883 */:
      case WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_READ_VALUE /* 1884 */:
      case WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_WRITE_VALUE /* 1885 */:
      case WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_START_NOTIFICATIONS /* 1886 */:
      case WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_STOP_NOTIFICATIONS /* 1887 */:
      case WEB_BLUETOOTH_REMOTE_DESCRIPTOR_READ_VALUE /* 1888 */:
      case WEB_BLUETOOTH_REMOTE_DESCRIPTOR_WRITE_VALUE /* 1889 */:
      case WEB_BLUETOOTH_REMOTE_SERVER_CONNECT /* 1890 */:
      case WEB_BLUETOOTH_REMOTE_SERVER_DISCONNECT /* 1891 */:
      case WEB_BLUETOOTH_REMOTE_SERVER_GET_PRIMARY_SERVICE /* 1892 */:
      case WEB_BLUETOOTH_REMOTE_SERVER_GET_PRIMARY_SERVICES /* 1893 */:
      case WEB_BLUETOOTH_REMOTE_SERVICE_GET_CHARACTERISTIC /* 1894 */:
      case WEB_BLUETOOTH_REMOTE_SERVICE_GET_CHARACTERISTICS /* 1895 */:
      case OBSOLETE_HTML_CONTENT_ELEMENT /* 1896 */:
      case OBSOLETE_HTML_SHADOW_ELEMENT /* 1897 */:
      case HTML_SLOT_ELEMENT /* 1898 */:
      case ACCELEROMETER_CONSTRUCTOR /* 1899 */:
      case ABSOLUTE_ORIENTATION_SENSOR_CONSTRUCTOR /* 1900 */:
      case AMBIENT_LIGHT_SENSOR_CONSTRUCTOR /* 1901 */:
      case GENERIC_SENSOR_ON_ACTIVATE /* 1902 */:
      case GENERIC_SENSOR_ON_CHANGE /* 1903 */:
      case GENERIC_SENSOR_ON_ERROR /* 1904 */:
      case GENERIC_SENSOR_ACTIVATED /* 1905 */:
      case GYROSCOPE_CONSTRUCTOR /* 1906 */:
      case MAGNETOMETER_CONSTRUCTOR /* 1907 */:
      case ORIENTATION_SENSOR_POPULATE_MATRIX /* 1908 */:
      case WINDOW_OPEN_WITH_INVALID_URL /* 1909 */:
      case CROSS_ORIGIN_MAIN_FRAME_NULLED_NAME_ACCESSED /* 1910 */:
      case MENU_ITEM_ELEMENT_ICON_ATTRIBUTE /* 1911 */:
      case WEBKIT_CSS_MATRIX_SET_MATRIX_VALUE /* 1912 */:
      case WEBKIT_CSS_MATRIX_CONSTRUCT_FROM_STRING /* 1913 */:
      case CAN_REQUEST_URLHTTP_CONTAINING_NEWLINE /* 1914 */:
      case GET_GAMEPADS /* 1916 */:
      case MEDIA_STREAM_CONSTRAINTS_AUDIO /* 1918 */:
      case MEDIA_STREAM_CONSTRAINTS_AUDIO_UNCONSTRAINED /* 1919 */:
      case MEDIA_STREAM_CONSTRAINTS_VIDEO /* 1920 */:
      case MEDIA_STREAM_CONSTRAINTS_VIDEO_UNCONSTRAINED /* 1921 */:
      case MEDIA_STREAM_CONSTRAINTS_WIDTH /* 1922 */:
      case MEDIA_STREAM_CONSTRAINTS_HEIGHT /* 1923 */:
      case MEDIA_STREAM_CONSTRAINTS_ASPECT_RATIO /* 1924 */:
      case MEDIA_STREAM_CONSTRAINTS_FRAME_RATE /* 1925 */:
      case MEDIA_STREAM_CONSTRAINTS_FACING_MODE /* 1926 */:
      case MEDIA_STREAM_CONSTRAINTS_VOLUME /* 1927 */:
      case MEDIA_STREAM_CONSTRAINTS_SAMPLE_RATE /* 1928 */:
      case MEDIA_STREAM_CONSTRAINTS_SAMPLE_SIZE /* 1929 */:
      case MEDIA_STREAM_CONSTRAINTS_ECHO_CANCELLATION /* 1930 */:
      case MEDIA_STREAM_CONSTRAINTS_LATENCY /* 1931 */:
      case MEDIA_STREAM_CONSTRAINTS_CHANNEL_COUNT /* 1932 */:
      case MEDIA_STREAM_CONSTRAINTS_DEVICE_ID_AUDIO /* 1933 */:
      case MEDIA_STREAM_CONSTRAINTS_DEVICE_ID_VIDEO /* 1934 */:
      case MEDIA_STREAM_CONSTRAINTS_DISABLE_LOCAL_ECHO /* 1935 */:
      case MEDIA_STREAM_CONSTRAINTS_GROUP_ID_AUDIO /* 1936 */:
      case MEDIA_STREAM_CONSTRAINTS_GROUP_ID_VIDEO /* 1937 */:
      case OBSOLETE_MEDIA_STREAM_CONSTRAINTS_VIDEO_KIND /* 1938 */:
      case MEDIA_STREAM_CONSTRAINTS_MEDIA_STREAM_SOURCE_AUDIO /* 1943 */:
      case MEDIA_STREAM_CONSTRAINTS_MEDIA_STREAM_SOURCE_VIDEO /* 1944 */:
      case MEDIA_STREAM_CONSTRAINTS_RENDER_TO_ASSOCIATED_SINK /* 1945 */:
      case MEDIA_STREAM_CONSTRAINTS_HOTWORD_ENABLED /* 1946 */:
      case MEDIA_STREAM_CONSTRAINTS_GOOG_ECHO_CANCELLATION /* 1947 */:
      case MEDIA_STREAM_CONSTRAINTS_GOOG_EXPERIMENTAL_ECHO_CANCELLATION /* 1948 */:
      case MEDIA_STREAM_CONSTRAINTS_GOOG_AUTO_GAIN_CONTROL /* 1949 */:
      case MEDIA_STREAM_CONSTRAINTS_GOOG_EXPERIMENTAL_AUTO_GAIN_CONTROL /* 1950 */:
      case MEDIA_STREAM_CONSTRAINTS_GOOG_NOISE_SUPPRESSION /* 1951 */:
      case MEDIA_STREAM_CONSTRAINTS_GOOG_HIGHPASS_FILTER /* 1952 */:
      case MEDIA_STREAM_CONSTRAINTS_GOOG_TYPING_NOISE_DETECTION /* 1953 */:
      case MEDIA_STREAM_CONSTRAINTS_GOOG_EXPERIMENTAL_NOISE_SUPPRESSION /* 1954 */:
      case MEDIA_STREAM_CONSTRAINTS_GOOG_BEAMFORMING /* 1955 */:
      case MEDIA_STREAM_CONSTRAINTS_GOOG_ARRAY_GEOMETRY /* 1956 */:
      case MEDIA_STREAM_CONSTRAINTS_GOOG_AUDIO_MIRRORING /* 1957 */:
      case MEDIA_STREAM_CONSTRAINTS_GOOG_DA_ECHO_CANCELLATION /* 1958 */:
      case MEDIA_STREAM_CONSTRAINTS_GOOG_NOISE_REDUCTION /* 1959 */:
      case VIEWPORT_FIXED_POSITION_UNDER_FILTER /* 1961 */:
      case REQUEST_MIDI_ACCESS_WITH_SYS_EX_OPTION_OBSCURED_BY_FOOTPRINTING /* 1962 */:
      case REQUEST_MIDI_ACCESS_IFRAME_WITH_SYS_EX_OPTION_OBSCURED_BY_FOOTPRINTING /* 1963 */:
      case GAMEPAD_AXES /* 1964 */:
      case GAMEPAD_BUTTONS /* 1965 */:
      case OBSOLETE_DISPATCH_MOUSE_EVENT_ON_DISABLED_FORM_CONTROL /* 1967 */:
      case ELEMENT_NAME_DOM_INVALID_HTML_PARSER_VALID /* 1968 */:
      case ELEMENT_NAME_DOM_VALID_HTML_PARSER_INVALID /* 1969 */:
      case GATT_SERVER_DISCONNECTED_EVENT /* 1970 */:
      case ANCHOR_CLICK_DISPATCH_FOR_NON_CONNECTED_NODE /* 1971 */:
      case HTML_PARSE_ERROR_NESTED_FORM /* 1972 */:
      case FONT_SHAPING_NOT_DEF_GLYPH_OBSERVED /* 1973 */:
      case POST_MESSAGE_OUTGOING_WOULD_BE_BLOCKED_BY_CONNECT_SRC /* 1974 */:
      case POST_MESSAGE_INCOMING_WOULD_BE_BLOCKED_BY_CONNECT_SRC /* 1975 */:
      case CROSS_ORIGIN_PROPERTY_ACCESS /* 1977 */:
      case CROSS_ORIGIN_PROPERTY_ACCESS_FROM_OPENER /* 1978 */:
      case CREDENTIAL_MANAGER_CREATE /* 1979 */:
      case FIELD_EDIT_IN_SECURE_CONTEXT /* 1981 */:
      case FIELD_EDIT_IN_NON_SECURE_CONTEXT /* 1982 */:
      case CREDENTIAL_MANAGER_GET_MEDIATION_REQUIRED /* 1984 */:
      case NET_INFO_RTT /* 1989 */:
      case NET_INFO_DOWNLINK /* 1990 */:
      case OBSOLETE_SHAPE_DETECTION_BARCODE_DETECTOR_CONSTRUCTOR /* 1991 */:
      case OBSOLETE_SHAPE_DETECTION_FACE_DETECTOR_CONSTRUCTOR /* 1992 */:
      case OBSOLETE_SHAPE_DETECTION_TEXT_DETECTOR_CONSTRUCTOR /* 1993 */:
      case OBSOLETE_INERT_ATTRIBUTE /* 1995 */:
      case PLUGIN_INSTANCE_ACCESS_FROM_ISOLATED_WORLD /* 1996 */:
      case PLUGIN_INSTANCE_ACCESS_FROM_MAIN_WORLD /* 1997 */:
      case SHOW_MODAL_FOR_ELEMENT_IN_FULLSCREEN_STACK /* 2000 */:
      case THREE_VALUED_POSITION_BACKGROUND /* 2001 */:
      case UNITLESS_ZERO_ANGLE_FILTER /* 2007 */:
      case UNITLESS_ZERO_ANGLE_GRADIENT /* 2008 */:
      case UNITLESS_ZERO_ANGLE_TRANSFORM /* 2010 */:
      case CREDENTIAL_MANAGER_PREVENT_SILENT_ACCESS /* 2012 */:
      case NET_INFO_EFFECTIVE_TYPE /* 2013 */:
      case V8_SPEECH_RECOGNITION_START_METHOD /* 2014 */:
      case TABLE_ROW_DIRECTION_DIFFERENT_FROM_TABLE /* 2015 */:
      case TABLE_SECTION_DIRECTION_DIFFERENT_FROM_TABLE /* 2016 */:
      case CLIENT_HINTS_DEVICE_MEMORY_DEPRECATED /* 2017 */:
      case CSS_REGISTER_PROPERTY /* 2018 */:
      case RELATIVE_ORIENTATION_SENSOR_CONSTRUCTOR /* 2019 */:
      case OBSOLETE_K_SMOOTH_SCROLL_JS_INTERVENTION_ACTIVATED /* 2020 */:
      case BUDGET_API_GET_COST /* 2021 */:
      case BUDGET_API_GET_BUDGET /* 2022 */:
      case CROSS_ORIGIN_MAIN_FRAME_NULLED_NON_EMPTY_NAME_ACCESSED /* 2023 */:
      case DOCUMENT_DOMAIN_SET_WITH_NON_DEFAULT_PORT /* 2025 */:
      case DOCUMENT_DOMAIN_SET_WITH_DEFAULT_PORT /* 2026 */:
      case FEATURE_POLICY_HEADER /* 2027 */:
      case FEATURE_POLICY_ALLOW_ATTRIBUTE /* 2028 */:
      case MIDI_PORT_OPEN /* 2029 */:
      case MIDI_OUTPUT_SEND /* 2030 */:
      case MIDI_MESSAGE_EVENT /* 2031 */:
      case FETCH_EVENT_IS_RELOAD /* 2032 */:
      case SERVICE_WORKER_CLIENT_FRAME_TYPE /* 2033 */:
      case QUIRKS_MODE_DOCUMENT /* 2034 */:
      case LIMITED_QUIRKS_MODE_DOCUMENT /* 2035 */:
      case ENCRYPTED_MEDIA_CROSS_ORIGIN_IFRAME /* 2036 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS /* 2037 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_OVERLAY_ENCLOSURE /* 2038 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_OVERLAY_PLAY_BUTTON /* 2039 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_ENCLOSURE /* 2040 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_PANEL /* 2041 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_PLAY_BUTTON /* 2042 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_CURRENT_TIME_DISPLAY /* 2043 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_TIME_REMAINING_DISPLAY /* 2044 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_TIMELINE /* 2045 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_TIMELINE_CONTAINER /* 2046 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_MUTE_BUTTON /* 2047 */:
      case 2048:
      case CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_FULLSCREEN_BUTTON /* 2049 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_CONTROLS_TOGGLE_CLOSED_CAPTIONS_BUTTON /* 2050 */:
      case LINEAR_ACCELERATION_SENSOR_CONSTRUCTOR /* 2051 */:
      case REPORT_URI_MULTIPLE_ENDPOINTS /* 2052 */:
      case REPORT_URI_SINGLE_ENDPOINT /* 2053 */:
      case OBSOLETE_V8_CONSTRUCTOR_NON_UNDEFINED_PRIMITIVE_RETURN /* 2054 */:
      case MEDIA_SOURCE_KEYFRAME_TIME_GREATER_THAN_DEPENDANT /* 2060 */:
      case MEDIA_SOURCE_MUXED_SEQUENCE_MODE /* 2061 */:
      case PREPARE_MODULE_SCRIPT /* 2062 */:
      case PRESENTATION_REQUEST_START_SECURE_ORIGIN /* 2063 */:
      case PRESENTATION_REQUEST_START_INSECURE_ORIGIN /* 2064 */:
      case PERSISTENT_CLIENT_HINT_HEADER /* 2065 */:
      case STYLE_SHEET_LIST_NON_NULL_ANONYMOUS_NAMED_GETTER /* 2066 */:
      case ARIA_ACTIVE_DESCENDANT_ATTRIBUTE /* 2069 */:
      case ARIA_ATOMIC_ATTRIBUTE /* 2070 */:
      case ARIA_AUTOCOMPLETE_ATTRIBUTE /* 2071 */:
      case ARIA_BUSY_ATTRIBUTE /* 2072 */:
      case ARIA_CHECKED_ATTRIBUTE /* 2073 */:
      case ARIA_COL_COUNT_ATTRIBUTE /* 2074 */:
      case ARIA_COL_INDEX_ATTRIBUTE /* 2075 */:
      case ARIA_COL_SPAN_ATTRIBUTE /* 2076 */:
      case ARIA_CONTROLS_ATTRIBUTE /* 2077 */:
      case ARIA_CURRENT_ATTRIBUTE /* 2078 */:
      case ARIA_DESCRIBED_BY_ATTRIBUTE /* 2079 */:
      case ARIA_DETAILS_ATTRIBUTE /* 2080 */:
      case ARIA_DISABLED_ATTRIBUTE /* 2081 */:
      case ARIA_DROP_EFFECT_ATTRIBUTE /* 2082 */:
      case ARIA_ERROR_MESSAGE_ATTRIBUTE /* 2083 */:
      case ARIA_EXPANDED_ATTRIBUTE /* 2084 */:
      case ARIA_FLOW_TO_ATTRIBUTE /* 2085 */:
      case ARIA_GRABBED_ATTRIBUTE /* 2086 */:
      case ARIA_HAS_POPUP_ATTRIBUTE /* 2087 */:
      case ARIA_HIDDEN_ATTRIBUTE /* 2089 */:
      case ARIA_INVALID_ATTRIBUTE /* 2090 */:
      case ARIA_KEY_SHORTCUTS_ATTRIBUTE /* 2091 */:
      case ARIA_LABEL_ATTRIBUTE /* 2092 */:
      case ARIA_LABELED_BY_ATTRIBUTE /* 2093 */:
      case ARIA_LABELLED_BY_ATTRIBUTE /* 2094 */:
      case ARIA_LEVEL_ATTRIBUTE /* 2095 */:
      case ARIA_LIVE_ATTRIBUTE /* 2096 */:
      case ARIA_MODAL_ATTRIBUTE /* 2097 */:
      case ARIA_MULTILINE_ATTRIBUTE /* 2098 */:
      case ARIA_MULTISELECTABLE_ATTRIBUTE /* 2099 */:
      case ARIA_ORIENTATION_ATTRIBUTE /* 2100 */:
      case ARIA_OWNS_ATTRIBUTE /* 2101 */:
      case ARIA_PLACEHOLDER_ATTRIBUTE /* 2102 */:
      case ARIA_POS_IN_SET_ATTRIBUTE /* 2103 */:
      case ARIA_PRESSED_ATTRIBUTE /* 2104 */:
      case ARIA_READ_ONLY_ATTRIBUTE /* 2105 */:
      case ARIA_RELEVANT_ATTRIBUTE /* 2106 */:
      case ARIA_REQUIRED_ATTRIBUTE /* 2107 */:
      case ARIA_ROLE_DESCRIPTION_ATTRIBUTE /* 2108 */:
      case ARIA_ROW_COUNT_ATTRIBUTE /* 2109 */:
      case ARIA_ROW_INDEX_ATTRIBUTE /* 2110 */:
      case ARIA_ROW_SPAN_ATTRIBUTE /* 2111 */:
      case ARIA_SELECTED_ATTRIBUTE /* 2112 */:
      case ARIA_SET_SIZE_ATTRIBUTE /* 2113 */:
      case ARIA_SORT_ATTRIBUTE /* 2114 */:
      case ARIA_VALUE_MAX_ATTRIBUTE /* 2115 */:
      case ARIA_VALUE_MIN_ATTRIBUTE /* 2116 */:
      case ARIA_VALUE_NOW_ATTRIBUTE /* 2117 */:
      case ARIA_VALUE_TEXT_ATTRIBUTE /* 2118 */:
      case OBSOLETE_V8_LABELED_EXPRESSION_STATEMENT /* 2119 */:
      case NAVIGATOR_DEVICE_MEMORY /* 2121 */:
      case FIXED_WIDTH_TABLE_DISTRIBUTION_CHANGED /* 2122 */:
      case WEBKIT_BOX_LAYOUT /* 2123 */:
      case WEBKIT_BOX_LAYOUT_HORIZONTAL /* 2124 */:
      case WEBKIT_BOX_LAYOUT_VERTICAL /* 2125 */:
      case WEBKIT_BOX_ALIGN_NOT_INITIAL /* 2126 */:
      case WEBKIT_BOX_DIRECTION_NOT_INITIAL /* 2127 */:
      case WEBKIT_BOX_LINES_NOT_INITIAL /* 2128 */:
      case WEBKIT_BOX_PACK_NOT_INITIAL /* 2129 */:
      case WEBKIT_BOX_CHILD_FLEX_NOT_INITIAL /* 2130 */:
      case WEBKIT_BOX_CHILD_FLEX_GROUP_NOT_INITIAL /* 2131 */:
      case WEBKIT_BOX_CHILD_ORDINAL_GROUP_NOT_INITIAL /* 2132 */:
      case WEBKIT_BOX_NOT_DEFAULT_ORDER /* 2133 */:
      case WEBKIT_BOX_NO_CHILDREN /* 2134 */:
      case WEBKIT_BOX_ONE_CHILD /* 2135 */:
      case WEBKIT_BOX_ONE_CHILD_IS_LAYOUT_BLOCK_FLOW_INLINE /* 2136 */:
      case WEBKIT_BOX_MANY_CHILDREN /* 2137 */:
      case WEBKIT_BOX_LINE_CLAMP /* 2138 */:
      case WEBKIT_BOX_LINE_CLAMP_PERCENTAGE /* 2139 */:
      case WEBKIT_BOX_LINE_CLAMP_NO_CHILDREN /* 2140 */:
      case WEBKIT_BOX_LINE_CLAMP_ONE_CHILD /* 2141 */:
      case WEBKIT_BOX_LINE_CLAMP_ONE_CHILD_IS_LAYOUT_BLOCK_FLOW_INLINE /* 2142 */:
      case WEBKIT_BOX_LINE_CLAMP_MANY_CHILDREN /* 2143 */:
      case WEBKIT_BOX_LINE_CLAMP_DOES_SOMETHING /* 2144 */:
      case FEATURE_POLICY_ALLOW_ATTRIBUTE_DEPRECATED_SYNTAX /* 2145 */:
      case SUPPRESS_HISTORY_ENTRY_WITHOUT_USER_GESTURE /* 2146 */:
      case PERFORMANCE_SERVER_TIMING /* 2157 */:
      case ANIMATION_SET_PLAYBACK_RATE_COMPENSATORY_SEEK /* 2162 */:
      case OBSOLETE_DEEP_COMBINATOR_IN_STATIC_PROFILE /* 2163 */:
      case OBSOLETE_PSEUDO_SHADOW_IN_STATIC_PROFILE /* 2164 */:
      case SCHEME_BYPASSES_CSP /* 2165 */:
      case INNER_SCHEME_BYPASSES_CSP /* 2166 */:
      case SAME_ORIGIN_APPLICATION_OCTET_STREAM /* 2167 */:
      case SAME_ORIGIN_APPLICATION_XML /* 2168 */:
      case SAME_ORIGIN_TEXT_HTML /* 2169 */:
      case SAME_ORIGIN_TEXT_PLAIN /* 2170 */:
      case SAME_ORIGIN_TEXT_XML /* 2171 */:
      case CROSS_ORIGIN_APPLICATION_OCTET_STREAM /* 2172 */:
      case CROSS_ORIGIN_APPLICATION_XML /* 2173 */:
      case CROSS_ORIGIN_TEXT_HTML /* 2174 */:
      case CROSS_ORIGIN_TEXT_PLAIN /* 2175 */:
      case CROSS_ORIGIN_TEXT_XML /* 2176 */:
      case PERFORMANCE_OBSERVER_FOR_WINDOW /* 2188 */:
      case PERFORMANCE_OBSERVER_FOR_WORKER /* 2189 */:
      case PAINT_TIMING_OBSERVED /* 2190 */:
      case PAINT_TIMING_REQUESTED /* 2191 */:
      case HTML_MEDIA_ELEMENT_MEDIA_PLAYBACK_RATE_OUT_OF_RANGE /* 2192 */:
      case COOKIE_SET /* 2194 */:
      case COOKIE_GET /* 2195 */:
      case GEOLOCATION_DISABLED_BY_FEATURE_POLICY /* 2196 */:
      case ENCRYPTED_MEDIA_DISABLED_BY_FEATURE_POLICY /* 2197 */:
      case BATTERY_STATUS_GET_BATTERY /* 2198 */:
      case OBSOLETE_BATTERY_STATUS_INSECURE_ORIGIN /* 2199 */:
      case BATTERY_STATUS_CROSS_ORIGIN /* 2200 */:
      case BATTERY_STATUS_SAME_ORIGIN_ABA /* 2201 */:
      case HAS_ID_CLASS_TAG_ATTRIBUTE /* 2203 */:
      case HAS_BEFORE_OR_AFTER_PSEUDO_ELEMENT /* 2204 */:
      case SHAPE_OUTSIDE_MAYBE_AFFECTED_INLINE_SIZE /* 2205 */:
      case SHAPE_OUTSIDE_MAYBE_AFFECTED_INLINE_POSITION /* 2206 */:
      case GAMEPAD_VIBRATION_ACTUATOR /* 2207 */:
      case MICROPHONE_DISABLED_BY_FEATURE_POLICY_ESTIMATE /* 2208 */:
      case CAMERA_DISABLED_BY_FEATURE_POLICY_ESTIMATE /* 2209 */:
      case MIDI_DISABLED_BY_FEATURE_POLICY /* 2210 */:
      case GEOLOCATION_GET_CURRENT_POSITION /* 2214 */:
      case GEOLOCATION_WATCH_POSITION /* 2215 */:
      case NET_INFO_SAVE_DATA /* 2217 */:
      case V8_ELEMENT_GET_CLIENT_RECTS_METHOD /* 2218 */:
      case V8_ELEMENT_GET_BOUNDING_CLIENT_RECT_METHOD /* 2219 */:
      case V8_RANGE_GET_CLIENT_RECTS_METHOD /* 2220 */:
      case V8_RANGE_GET_BOUNDING_CLIENT_RECT_METHOD /* 2221 */:
      case V8_ERROR_CAPTURE_STACK_TRACE /* 2222 */:
      case V8_ERROR_PREPARE_STACK_TRACE /* 2223 */:
      case V8_ERROR_STACK_TRACE_LIMIT /* 2224 */:
      case PAINT_WORKLET /* 2225 */:
      case DOCUMENT_PAGE_HIDE_REGISTERED /* 2226 */:
      case DOCUMENT_PAGE_HIDE_FIRED /* 2227 */:
      case DOCUMENT_PAGE_SHOW_REGISTERED /* 2228 */:
      case DOCUMENT_PAGE_SHOW_FIRED /* 2229 */:
      case REPLACE_CHARSET_IN_XHR /* 2230 */:
      case LINK_REL_MODULE_PRELOAD /* 2232 */:
      case CSP_WITH_UNSAFE_EVAL /* 2236 */:
      case WEB_ASSEMBLY_INSTANTIATION /* 2237 */:
      case V8_INDEX_ACCESSOR /* 2238 */:
      case V8_MEDIA_CAPABILITIES_DECODING_INFO_METHOD /* 2239 */:
      case V8_MEDIA_CAPABILITIES_ENCODING_INFO_METHOD /* 2240 */:
      case V8_MEDIA_CAPABILITIES_INFO_SUPPORTED_ATTRIBUTE_GETTER /* 2241 */:
      case V8_MEDIA_CAPABILITIES_INFO_SMOOTH_ATTRIBUTE_GETTER /* 2242 */:
      case V8_MEDIA_CAPABILITIES_INFO_POWER_EFFICIENT_ATTRIBUTE_GETTER /* 2243 */:
      case OBSOLETE_WINDOW_EVENT_IN_V0_SHADOW_TREE /* 2244 */:
      case WINDOW_OPEN_REALM_MISMATCH /* 2247 */:
      case GRID_ROW_TRACK_PERCENT_INDEFINITE_HEIGHT /* 2248 */:
      case VR_GET_DISPLAYS_SUPPORTS_PRESENT /* 2249 */:
      case DUPLICATED_ATTRIBUTE /* 2250 */:
      case DUPLICATED_ATTRIBUTE_FOR_EXECUTED_SCRIPT /* 2251 */:
      case V8RTC_PEER_CONNECTION_GET_SENDERS_METHOD /* 2252 */:
      case V8RTC_PEER_CONNECTION_GET_RECEIVERS_METHOD /* 2253 */:
      case V8RTC_PEER_CONNECTION_ADD_TRACK_METHOD /* 2254 */:
      case V8RTC_PEER_CONNECTION_REMOVE_TRACK_METHOD /* 2255 */:
      case LOCAL_CSS_FILE /* 2256 */:
      case LOCAL_CSS_FILE_EXTENSION_REJECTED /* 2257 */:
      case USER_MEDIA_DISABLE_HARDWARE_NOISE_SUPPRESSION /* 2258 */:
      case CERTIFICATE_TRANSPARENCY_REQUIRED_ERROR_ON_RESOURCE_LOAD /* 2259 */:
      case CSS_SELECTOR_PSEUDO_WEBKIT_ANY_LINK /* 2260 */:
      case AUDIO_WORKLET_ADD_MODULE /* 2261 */:
      case AUDIO_WORKLET_GLOBAL_SCOPE_REGISTER_PROCESSOR /* 2262 */:
      case AUDIO_WORKLET_NODE_CONSTRUCTOR /* 2263 */:
      case HTML_MEDIA_ELEMENT_EMPTY_LOAD_WITH_FUTURE_DATA /* 2264 */:
      case CSS_VALUE_DISPLAY_CONTENTS /* 2265 */:
      case CSS_SELECTOR_PSEUDO_ANY_LINK /* 2266 */:
      case FILE_ACCESSED_CACHE /* 2267 */:
      case FILE_ACCESSED_COOKIES /* 2268 */:
      case FILE_ACCESSED_DATABASE /* 2269 */:
      case FILE_ACCESSED_FILE_SYSTEM /* 2270 */:
      case FILE_ACCESSED_LOCAL_STORAGE /* 2271 */:
      case FILE_ACCESSED_LOCKS /* 2272 */:
      case FILE_ACCESSED_SERVICE_WORKER /* 2273 */:
      case FILE_ACCESSED_SESSION_STORAGE /* 2274 */:
      case FILE_ACCESSED_SHARED_WORKER /* 2275 */:
      case V8_MEDIA_KEYS_GET_STATUS_FOR_POLICY_METHOD /* 2276 */:
      case V8_DEOPTIMIZER_DISABLE_SPECULATION /* 2277 */:
      case CSS_SELECTOR_CUE /* 2278 */:
      case CSS_SELECTOR_WEBKIT_CALENDAR_PICKER_INDICATOR /* 2279 */:
      case CSS_SELECTOR_WEBKIT_CLEAR_BUTTON /* 2280 */:
      case CSS_SELECTOR_WEBKIT_COLOR_SWATCH /* 2281 */:
      case CSS_SELECTOR_WEBKIT_COLOR_SWATCH_WRAPPER /* 2282 */:
      case CSS_SELECTOR_WEBKIT_DATE_AND_TIME_VALUE /* 2283 */:
      case CSS_SELECTOR_WEBKIT_DATETIME_EDIT /* 2284 */:
      case CSS_SELECTOR_WEBKIT_DATETIME_EDIT_AMPM_FIELD /* 2285 */:
      case CSS_SELECTOR_WEBKIT_DATETIME_EDIT_DAY_FIELD /* 2286 */:
      case CSS_SELECTOR_WEBKIT_DATETIME_EDIT_FIELDS_WRAPPER /* 2287 */:
      case CSS_SELECTOR_WEBKIT_DATETIME_EDIT_HOUR_FIELD /* 2288 */:
      case CSS_SELECTOR_WEBKIT_DATETIME_EDIT_MILLISECOND_FIELD /* 2289 */:
      case CSS_SELECTOR_WEBKIT_DATETIME_EDIT_MINUTE_FIELD /* 2290 */:
      case CSS_SELECTOR_WEBKIT_DATETIME_EDIT_MONTH_FIELD /* 2291 */:
      case CSS_SELECTOR_WEBKIT_DATETIME_EDIT_SECOND_FIELD /* 2292 */:
      case CSS_SELECTOR_WEBKIT_DATETIME_EDIT_TEXT /* 2293 */:
      case CSS_SELECTOR_WEBKIT_DATETIME_EDIT_WEEK_FIELD /* 2294 */:
      case CSS_SELECTOR_WEBKIT_DATETIME_EDIT_YEAR_FIELD /* 2295 */:
      case CSS_SELECTOR_WEBKIT_FILE_UPLOAD_BUTTON /* 2297 */:
      case CSS_SELECTOR_WEBKIT_INNER_SPIN_BUTTON /* 2298 */:
      case CSS_SELECTOR_WEBKIT_INPUT_PLACEHOLDER /* 2299 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_SLIDER_CONTAINER /* 2300 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_SLIDER_THUMB /* 2301 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_TEXT_TRACK_CONTAINER /* 2302 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_TEXT_TRACK_DISPLAY /* 2303 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_TEXT_TRACK_REGION /* 2304 */:
      case CSS_SELECTOR_WEBKIT_MEDIA_TEXT_TRACK_REGION_CONTAINER /* 2305 */:
      case CSS_SELECTOR_WEBKIT_METER_BAR /* 2306 */:
      case CSS_SELECTOR_WEBKIT_METER_EVEN_LESS_GOOD_VALUE /* 2307 */:
      case CSS_SELECTOR_WEBKIT_METER_INNER_ELEMENT /* 2308 */:
      case CSS_SELECTOR_WEBKIT_METER_OPTIMUM_VALUE /* 2309 */:
      case CSS_SELECTOR_WEBKIT_METER_SUBOPTIMUM_VALUE /* 2310 */:
      case CSS_SELECTOR_WEBKIT_PROGRESS_BAR /* 2311 */:
      case CSS_SELECTOR_WEBKIT_PROGRESS_INNER_ELEMENT /* 2312 */:
      case CSS_SELECTOR_WEBKIT_PROGRESS_VALUE /* 2313 */:
      case CSS_SELECTOR_WEBKIT_SEARCH_CANCEL_BUTTON /* 2314 */:
      case CSS_SELECTOR_WEBKIT_SLIDER_CONTAINER /* 2315 */:
      case CSS_SELECTOR_WEBKIT_SLIDER_RUNNABLE_TRACK /* 2316 */:
      case CSS_SELECTOR_WEBKIT_SLIDER_THUMB /* 2317 */:
      case CSS_SELECTOR_WEBKIT_TEXTFIELD_DECORATION_CONTAINER /* 2318 */:
      case CSS_SELECTOR_WEBKIT_UNKNOWN_PSEUDO /* 2319 */:
      case FILTER_AS_CONTAINING_BLOCK_MAY_CHANGE_OUTPUT /* 2320 */:
      case OBSOLETE_DISPATCH_MOUSE_UP_DOWN_EVENT_ON_DISABLED_FORM_CONTROL /* 2321 */:
      case CSS_SELECTOR_PSEUDO_IS /* 2322 */:
      case V8RTC_RTP_SENDER_REPLACE_TRACK_METHOD /* 2323 */:
      case INPUT_TYPE_FILE_SECURE_ORIGIN_OPEN_CHOOSER /* 2324 */:
      case INPUT_TYPE_FILE_INSECURE_ORIGIN_OPEN_CHOOSER /* 2325 */:
      case BASIC_SHAPE_ELLIPSE_NO_RADIUS /* 2326 */:
      case BASIC_SHAPE_ELLIPSE_TWO_RADIUS /* 2328 */:
      case TEMPORAL_INPUT_TYPE_CHOOSER_BY_TRUSTED_CLICK /* 2329 */:
      case TEMPORAL_INPUT_TYPE_CHOOSER_BY_UNTRUSTED_CLICK /* 2330 */:
      case TEMPORAL_INPUT_TYPE_IGNORE_UNTRUSTED_CLICK /* 2331 */:
      case COLOR_INPUT_TYPE_CHOOSER_BY_TRUSTED_CLICK /* 2332 */:
      case COLOR_INPUT_TYPE_CHOOSER_BY_UNTRUSTED_CLICK /* 2333 */:
      case CSS_TYPED_OM_STYLE_PROPERTY_MAP /* 2334 */:
      case RTC_PEER_CONNECTION_WITH_ACTIVE_CSP /* 2346 */:
      case IMAGE_DECODING_ATTRIBUTE /* 2347 */:
      case IMAGE_DECODE_API /* 2348 */:
      case V8HTML_ELEMENT_AUTOCAPITALIZE_ATTRIBUTE_GETTER /* 2349 */:
      case V8HTML_ELEMENT_AUTOCAPITALIZE_ATTRIBUTE_SETTER /* 2350 */:
      case CSS_LEGACY_ALIGNMENT /* 2351 */:
      case SRI_SIGNATURE_CHECK /* 2352 */:
      case SRI_SIGNATURE_SUCCESS /* 2353 */:
      case CSS_BASIC_SHAPE /* 2354 */:
      case CSS_GRADIENT /* 2355 */:
      case CSS_PAINT_FUNCTION /* 2356 */:
      case WEBKIT_CROSS_FADE /* 2357 */:
      case DISABLE_PICTURE_IN_PICTURE_ATTRIBUTE /* 2358 */:
      case OBSOLETE_CERTIFICATE_TRANSPARENCY_NON_COMPLIANT_SUBRESOURCE_IN_MAIN_FRAME /* 2359 */:
      case OBSOLETE_CERTIFICATE_TRANSPARENCY_NON_COMPLIANT_RESOURCE_IN_SUBFRAME /* 2360 */:
      case V8_ABORT_CONTROLLER_CONSTRUCTOR /* 2361 */:
      case REPLACE_CHARSET_IN_XHR_IGNORING_CASE /* 2362 */:
      case HTMLI_FRAME_ELEMENT_GESTURE_MEDIA /* 2363 */:
      case WORKLET_ADD_MODULE /* 2364 */:
      case ANIMATION_WORKLET_REGISTER_ANIMATOR /* 2365 */:
      case WORKLET_ANIMATION_CONSTRUCTOR /* 2366 */:
      case SCROLL_TIMELINE_CONSTRUCTOR /* 2367 */:
      case ASYNC_CLIPBOARD_API_READ /* 2369 */:
      case ASYNC_CLIPBOARD_API_WRITE /* 2370 */:
      case ASYNC_CLIPBOARD_API_READ_TEXT /* 2371 */:
      case ASYNC_CLIPBOARD_API_WRITE_TEXT /* 2372 */:
      case OPENER_NAVIGATION_WITHOUT_GESTURE /* 2373 */:
      case V8_LOCK_MANAGER_REQUEST_METHOD /* 2375 */:
      case V8_LOCK_MANAGER_QUERY_METHOD /* 2376 */:
      case V8RTCDTMF_SENDER_TRACK_ATTRIBUTE_GETTER /* 2378 */:
      case V8RTCDTMF_SENDER_DURATION_ATTRIBUTE_GETTER /* 2379 */:
      case V8RTCDTMF_SENDER_INTER_TONE_GAP_ATTRIBUTE_GETTER /* 2380 */:
      case V8RTC_RTP_SENDER_DTMF_ATTRIBUTE_GETTER /* 2381 */:
      case RTC_CONSTRAINT_ENABLE_DTLS_SRTP_TRUE /* 2382 */:
      case RTC_CONSTRAINT_ENABLE_DTLS_SRTP_FALSE /* 2383 */:
      case DEPRECATED_RTC_PEER_CONNECTION_ID /* 2384 */:
      case V8_PAINT_WORKLET_GLOBAL_SCOPE_REGISTER_PAINT_METHOD /* 2385 */:
      case V8_PAINT_WORKLET_GLOBAL_SCOPE_DEVICE_PIXEL_RATIO_ATTRIBUTE_GETTER /* 2386 */:
      case CSS_SELECTOR_PSEUDO_FOCUS /* 2387 */:
      case CSS_SELECTOR_PSEUDO_FOCUS_VISIBLE /* 2388 */:
      case DISTRUSTED_LEGACY_SYMANTEC_SUBRESOURCE /* 2389 */:
      case VR_DISPLAY_GET_FRAME_DATA /* 2390 */:
      case XML_HTTP_REQUEST_RESPONSE_XML /* 2391 */:
      case MESSAGE_PORT_TRANSFER_CLOSED_PORT /* 2392 */:
      case RTC_LOCAL_SDP_MODIFICATION /* 2393 */:
      case KEYBOARD_API_LOCK /* 2394 */:
      case KEYBOARD_API_UNLOCK /* 2395 */:
      case PPAPIURL_REQUEST_STREAM_TO_FILE /* 2396 */:
      case PAYMENT_HANDLER /* 2397 */:
      case PAYMENT_REQUEST_SHOW_WITHOUT_GESTURE /* 2398 */:
      case READABLE_STREAM_CONSTRUCTOR /* 2399 */:
      case WRITABLE_STREAM_CONSTRUCTOR /* 2400 */:
      case TRANSFORM_STREAM_CONSTRUCTOR /* 2401 */:
      case NEGATIVE_BACKGROUND_SIZE /* 2402 */:
      case NEGATIVE_MASK_SIZE /* 2403 */:
      case CLIENT_HINTS_RTT_DEPRECATED /* 2404 */:
      case CLIENT_HINTS_DOWNLINK_DEPRECATED /* 2405 */:
      case CLIENT_HINTS_ECT_DEPRECATED /* 2406 */:
      case CROSS_ORIGIN_HTMLI_FRAME_ELEMENT_CONTENT_DOCUMENT /* 2407 */:
      case CROSS_ORIGIN_HTMLI_FRAME_ELEMENT_GET_SVG_DOCUMENT /* 2408 */:
      case CROSS_ORIGIN_HTML_EMBED_ELEMENT_GET_SVG_DOCUMENT /* 2409 */:
      case CROSS_ORIGIN_HTML_FRAME_ELEMENT_CONTENT_DOCUMENT /* 2410 */:
      case CROSS_ORIGIN_HTML_OBJECT_ELEMENT_CONTENT_DOCUMENT /* 2411 */:
      case CROSS_ORIGIN_HTML_OBJECT_ELEMENT_GET_SVG_DOCUMENT /* 2412 */:
      case NAVIGATOR_XR /* 2413 */:
      case XR_REQUEST_DEVICE /* 2414 */:
      case XR_REQUEST_SESSION /* 2415 */:
      case XR_SUPPORTS_SESSION /* 2416 */:
      case XR_SESSION_GET_INPUT_SOURCES /* 2417 */:
      case CSS_RESIZE_AUTO /* 2418 */:
      case PREFIXED_CURSOR_GRAB /* 2419 */:
      case PREFIXED_CURSOR_GRABBING /* 2420 */:
      case CREDENTIAL_MANAGER_CREATE_PUBLIC_KEY_CREDENTIAL /* 2421 */:
      case CREDENTIAL_MANAGER_GET_PUBLIC_KEY_CREDENTIAL /* 2422 */:
      case CREDENTIAL_MANAGER_MAKE_PUBLIC_KEY_CREDENTIAL_SUCCESS /* 2423 */:
      case CREDENTIAL_MANAGER_GET_PUBLIC_KEY_CREDENTIAL_SUCCESS /* 2424 */:
      case SHAPE_OUTSIDE_CONTENT_BOX /* 2425 */:
      case SHAPE_OUTSIDE_PADDING_BOX /* 2426 */:
      case SHAPE_OUTSIDE_BORDER_BOX /* 2427 */:
      case SHAPE_OUTSIDE_MARGIN_BOX /* 2428 */:
      case PERFORMANCE_TIMELINE /* 2429 */:
      case USER_TIMING /* 2430 */:
      case CSS_SELECTOR_PSEUDO_WHERE /* 2431 */:
      case KEYBOARD_API_GET_LAYOUT_MAP /* 2432 */:
      case PERFORMANCE_RESOURCE_TIMING_INITIATOR_TYPE /* 2434 */:
      case V8_ARRAY_SORT_NO_ELEMENTS_PROTECTOR /* 2436 */:
      case OBSOLETE_V8_ARRAY_PROTOTYPE_SORT_JS_ARRAY_MODIFIED_PROTOTYPE /* 2437 */:
      case V8_DOCUMENT_PICTURE_IN_PICTURE_ENABLED_ATTRIBUTE_GETTER /* 2438 */:
      case V8_DOCUMENT_PICTURE_IN_PICTURE_ELEMENT_ATTRIBUTE_GETTER /* 2439 */:
      case V8_DOCUMENT_EXIT_PICTURE_IN_PICTURE_METHOD /* 2440 */:
      case V8_SHADOW_ROOT_PICTURE_IN_PICTURE_ELEMENT_ATTRIBUTE_GETTER /* 2441 */:
      case V8HTML_VIDEO_ELEMENT_DISABLE_PICTURE_IN_PICTURE_ATTRIBUTE_GETTER /* 2442 */:
      case V8HTML_VIDEO_ELEMENT_DISABLE_PICTURE_IN_PICTURE_ATTRIBUTE_SETTER /* 2443 */:
      case V8HTML_VIDEO_ELEMENT_REQUEST_PICTURE_IN_PICTURE_METHOD /* 2444 */:
      case ENTER_PICTURE_IN_PICTURE_EVENT_LISTENER /* 2445 */:
      case LEAVE_PICTURE_IN_PICTURE_EVENT_LISTENER /* 2446 */:
      case V8_PICTURE_IN_PICTURE_WINDOW_HEIGHT_ATTRIBUTE_GETTER /* 2447 */:
      case V8_PICTURE_IN_PICTURE_WINDOW_WIDTH_ATTRIBUTE_GETTER /* 2448 */:
      case PICTURE_IN_PICTURE_WINDOW_RESIZE_EVENT_LISTENER /* 2449 */:
      case V8_COOKIE_STORE_DELETE_METHOD /* 2450 */:
      case V8_COOKIE_STORE_GET_METHOD /* 2451 */:
      case V8_COOKIE_STORE_GET_ALL_METHOD /* 2452 */:
      case V8_COOKIE_STORE_GET_CHANGE_SUBSCRIPTIONS_METHOD /* 2453 */:
      case V8_COOKIE_STORE_HAS_METHOD /* 2454 */:
      case V8_COOKIE_STORE_SET_METHOD /* 2455 */:
      case V8_COOKIE_STORE_SUBSCRIBE_TO_CHANGES_METHOD /* 2456 */:
      case V8_COOKIE_CHANGE_EVENT_CHANGED_ATTRIBUTE_GETTER /* 2457 */:
      case V8_COOKIE_CHANGE_EVENT_DELETED_ATTRIBUTE_GETTER /* 2458 */:
      case V8_EXTENDABLE_COOKIE_CHANGE_EVENT_CHANGED_ATTRIBUTE_GETTER /* 2459 */:
      case V8_EXTENDABLE_COOKIE_CHANGE_EVENT_DELETED_ATTRIBUTE_GETTER /* 2460 */:
      case SHAPE_OUTSIDE_CONTENT_BOX_DIFFERENT_FROM_MARGIN_BOX /* 2461 */:
      case SHAPE_OUTSIDE_PADDING_BOX_DIFFERENT_FROM_MARGIN_BOX /* 2462 */:
      case DEPRECATED_CSS_CONTAIN_LAYOUT_POSITIONED_DESCENDANTS /* 2463 */:
      case CANVAS_CONVERT_TO_BLOB /* 2465 */:
      case POLYMER_V1_DETECTED /* 2466 */:
      case POLYMER_V2_DETECTED /* 2467 */:
      case PERFORMANCE_EVENT_TIMING_BUFFER /* 2468 */:
      case PERFORMANCE_EVENT_TIMING_CONSTRUCTOR /* 2469 */:
      case REVERSE_ITERATE_DOM_STORAGE /* 2470 */:
      case TEXT_TO_SPEECH_SPEAK /* 2471 */:
      case TEXT_TO_SPEECH_SPEAK_CROSS_ORIGIN /* 2472 */:
      case TEXT_TO_SPEECH_SPEAK_DISALLOWED_BY_AUTOPLAY /* 2473 */:
      case STALE_WHILE_REVALIDATE_ENABLED /* 2474 */:
      case MEDIA_ELEMENT_SOURCE_ON_OFFLINE_CONTEXT /* 2475 */:
      case OBSOLETE_MEDIA_STREAM_DESTINATION_ON_OFFLINE_CONTEXT /* 2476 */:
      case OBSOLETE_MEDIA_STREAM_SOURCE_ON_OFFLINE_CONTEXT /* 2477 */:
      case RTC_DATA_CHANNEL_INIT_MAX_RETRANSMIT_TIME /* 2478 */:
      case RTC_PEER_CONNECTION_CREATE_DATA_CHANNEL_MAX_PACKET_LIFE_TIME /* 2479 */:
      case V8_SPEECH_GRAMMAR_LIST_ADD_FROM_URI_METHOD /* 2480 */:
      case V8_SPEECH_SYNTHESIS_SPEAK_METHOD /* 2483 */:
      case LEGACY_SYMANTEC_CERT_MAIN_FRAME_RESOURCE /* 2484 */:
      case LEGACY_SYMANTEC_CERT_IN_SUBRESOURCE /* 2485 */:
      case LEGACY_SYMANTEC_CERT_IN_SUBFRAME_MAIN_RESOURCE /* 2486 */:
      case EVENT_TIMING_EXPLICITLY_REQUESTED /* 2487 */:
      case CSS_ENVIRONMENT_VARIABLE /* 2488 */:
      case CSS_ENVIRONMENT_VARIABLE_SAFE_AREA_INSET_TOP /* 2489 */:
      case CSS_ENVIRONMENT_VARIABLE_SAFE_AREA_INSET_LEFT /* 2490 */:
      case CSS_ENVIRONMENT_VARIABLE_SAFE_AREA_INSET_BOTTOM /* 2491 */:
      case CSS_ENVIRONMENT_VARIABLE_SAFE_AREA_INSET_RIGHT /* 2492 */:
      case MEDIA_CONTROLS_DISPLAY_CUTOUT_GESTURE /* 2493 */:
      case DOCUMENT_OPEN_TWO_ARGS /* 2494 */:
      case DOCUMENT_OPEN_TWO_ARGS_WITH_REPLACE /* 2495 */:
      case DOCUMENT_OPEN_THREE_ARGS /* 2496 */:
      case V8_FUNCTION_TOKEN_OFFSET_TOO_LONG_FOR_TO_STRING /* 2497 */:
      case SERVICE_WORKER_IMPORT_SCRIPT_NOT_INSTALLED /* 2498 */:
      case NESTED_DEDICATED_WORKER /* 2499 */:
      case OBSOLETE_CLIENT_HINTS_META_ACCEPT_CH_LIFETIME /* 2500 */:
      case CSS_FILL_AVAILABLE_LOGICAL_WIDTH /* 2507 */:
      case CSS_FILL_AVAILABLE_LOGICAL_HEIGHT /* 2508 */:
      case POPUP_OPEN_WHILE_FILE_CHOOSER_OPENED /* 2509 */:
      case COOKIE_STORE_API /* 2510 */:
      case FEATURE_POLICY_JSAPI /* 2511 */:
      case V8RTC_PEER_CONNECTION_GET_TRANSCEIVERS_METHOD /* 2512 */:
      case V8RTC_PEER_CONNECTION_ADD_TRANSCEIVER_METHOD /* 2513 */:
      case V8RTC_RTP_TRANSCEIVER_DIRECTION_ATTRIBUTE_GETTER /* 2514 */:
      case V8RTC_RTP_TRANSCEIVER_DIRECTION_ATTRIBUTE_SETTER /* 2515 */:
      case HTML_LINK_ELEMENT_DISABLED_BY_PARSER /* 2516 */:
      case REQUEST_IS_HISTORY_NAVIGATION /* 2517 */:
      case ADD_DOCUMENT_LEVEL_PASSIVE_TRUE_WHEEL_EVENT_LISTENER /* 2518 */:
      case ADD_DOCUMENT_LEVEL_PASSIVE_FALSE_WHEEL_EVENT_LISTENER /* 2519 */:
      case ADD_DOCUMENT_LEVEL_PASSIVE_DEFAULT_WHEEL_EVENT_LISTENER /* 2520 */:
      case DOCUMENT_LEVEL_PASSIVE_DEFAULT_EVENT_LISTENER_PREVENTED_WHEEL /* 2521 */:
      case OBSOLETE_SHAPE_DETECTION_API /* 2522 */:
      case V8_SOURCE_BUFFER_CHANGE_TYPE_METHOD /* 2523 */:
      case PPAPI_WEB_SOCKET /* 2524 */:
      case V8_MEDIA_STREAM_TRACK_CONTENT_HINT_ATTRIBUTE_GETTER /* 2525 */:
      case V8_MEDIA_STREAM_TRACK_CONTENT_HINT_ATTRIBUTE_SETTER /* 2526 */:
      case V8IDB_FACTORY_OPEN_METHOD /* 2527 */:
      case REPORTING_OBSERVER /* 2529 */:
      case DEPRECATION_REPORT /* 2530 */:
      case INTERVENTION_REPORT /* 2531 */:
      case V8_WASM_SHARED_MEMORY /* 2532 */:
      case V8_WASM_THREAD_OPCODES /* 2533 */:
      case FEATURE_POLICY_REPORT /* 2536 */:
      case V8_WINDOW_WEBKIT_RTC_PEER_CONNECTION_CONSTRUCTOR_GETTER /* 2537 */:
      case V8_WINDOW_WEBKIT_MEDIA_STREAM_CONSTRUCTOR_GETTER /* 2538 */:
      case TEXT_ENCODER_STREAM_CONSTRUCTOR /* 2539 */:
      case TEXT_DECODER_STREAM_CONSTRUCTOR /* 2540 */:
      case SIGNED_EXCHANGE_INNER_RESPONSE /* 2541 */:
      case PAYMENT_ADDRESS_LANGUAGE_CODE /* 2542 */:
      case DOCUMENT_DOMAIN_BLOCKED_CROSS_ORIGIN_ACCESS /* 2543 */:
      case DOCUMENT_DOMAIN_ENABLED_CROSS_ORIGIN_ACCESS /* 2544 */:
      case SERIAL_GET_PORTS /* 2545 */:
      case SERIAL_REQUEST_PORT /* 2546 */:
      case SERIAL_PORT_OPEN /* 2547 */:
      case SERIAL_PORT_CLOSE /* 2548 */:
      case BACKGROUND_FETCH_MANAGER_FETCH /* 2549 */:
      case BACKGROUND_FETCH_MANAGER_GET /* 2550 */:
      case BACKGROUND_FETCH_MANAGER_GET_IDS /* 2551 */:
      case BACKGROUND_FETCH_REGISTRATION_ABORT /* 2552 */:
      case BACKGROUND_FETCH_REGISTRATION_MATCH /* 2553 */:
      case BACKGROUND_FETCH_REGISTRATION_MATCH_ALL /* 2554 */:
      case FORM_DISABLED_ATTRIBUTE_PRESENT /* 2557 */:
      case FORM_DISABLED_ATTRIBUTE_PRESENT_AND_SUBMIT /* 2558 */:
      case CSS_VALUE_APPEARANCE_CHECKBOX_RENDERED /* 2559 */:
      case CSS_VALUE_APPEARANCE_RADIO_RENDERED /* 2561 */:
      case CSS_VALUE_APPEARANCE_INNER_SPIN_BUTTON_RENDERED /* 2563 */:
      case CSS_VALUE_APPEARANCE_MENU_LIST_RENDERED /* 2565 */:
      case CSS_VALUE_APPEARANCE_PROGRESS_BAR_RENDERED /* 2567 */:
      case CSS_VALUE_APPEARANCE_SLIDER_HORIZONTAL_RENDERED /* 2568 */:
      case CSS_VALUE_APPEARANCE_SLIDER_VERTICAL_RENDERED /* 2570 */:
      case CSS_VALUE_APPEARANCE_SLIDER_THUMB_HORIZONTAL_RENDERED /* 2572 */:
      case CSS_VALUE_APPEARANCE_SLIDER_THUMB_VERTICAL_RENDERED /* 2574 */:
      case CSS_VALUE_APPEARANCE_SEARCH_FIELD_RENDERED /* 2576 */:
      case CSS_VALUE_APPEARANCE_SEARCH_CANCEL_RENDERED /* 2578 */:
      case CSS_VALUE_APPEARANCE_TEXT_AREA_RENDERED /* 2580 */:
      case CSS_VALUE_APPEARANCE_MENU_LIST_BUTTON_RENDERED /* 2582 */:
      case CSS_VALUE_APPEARANCE_PUSH_BUTTON_RENDERED /* 2584 */:
      case CSS_VALUE_APPEARANCE_SQUARE_BUTTON_RENDERED /* 2586 */:
      case CURSOR_IMAGE_L_E32X32 /* 2589 */:
      case CURSOR_IMAGE_G_T32X32 /* 2590 */:
      case OBSOLETE_RTC_PEER_CONNECTION_COMPLEX_PLAN_B_SDP_USING_DEFAULT_SDP_SEMANTICS /* 2591 */:
      case RESIZE_OBSERVER_CONSTRUCTOR /* 2592 */:
      case COLLATOR /* 2593 */:
      case NUMBER_FORMAT /* 2594 */:
      case DATE_TIME_FORMAT /* 2595 */:
      case PLURAL_RULES /* 2596 */:
      case RELATIVE_TIME_FORMAT /* 2597 */:
      case LOCALE /* 2598 */:
      case LIST_FORMAT /* 2599 */:
      case SEGMENTER /* 2600 */:
      case STRING_LOCALE_COMPARE /* 2601 */:
      case OBSOLETE_STRING_TO_LOCALE_UPPER_CASE /* 2602 */:
      case STRING_TO_LOCALE_LOWER_CASE /* 2603 */:
      case NUMBER_TO_LOCALE_STRING /* 2604 */:
      case DATE_TO_LOCALE_STRING /* 2605 */:
      case DATE_TO_LOCALE_DATE_STRING /* 2606 */:
      case DATE_TO_LOCALE_TIME_STRING /* 2607 */:
      case MALFORMED_CSP /* 2608 */:
      case V8_ATTEMPT_OVERRIDE_READ_ONLY_ON_PROTOTYPE_SLOPPY /* 2609 */:
      case V8_ATTEMPT_OVERRIDE_READ_ONLY_ON_PROTOTYPE_STRICT /* 2610 */:
      case HTML_CANVAS_ELEMENT_LOW_LATENCY /* 2611 */:
      case OBSOLETE_V8_OPTIMIZED_FUNCTION_WITH_ONE_SHOT_BYTECODE /* 2612 */:
      case SVG_GEOMETRY_PROPERTY_HAS_NON_ZERO_UNITLESS_VALUE /* 2613 */:
      case CSS_VALUE_APPEARANCE_NO_IMPLEMENTATION_SKIP_BORDER /* 2614 */:
      case INSTANTIATE_MODULE_SCRIPT /* 2615 */:
      case DYNAMIC_IMPORT_MODULE_SCRIPT /* 2616 */:
      case HISTORY_PUSH_STATE /* 2617 */:
      case HISTORY_REPLACE_STATE /* 2618 */:
      case GET_DISPLAY_MEDIA /* 2619 */:
      case CURSOR_IMAGE_G_T64X64 /* 2620 */:
      case AD_CLICK /* 2621 */:
      case UPDATE_WITHOUT_SHIPPING_OPTION_ON_SHIPPING_ADDRESS_CHANGE /* 2622 */:
      case UPDATE_WITHOUT_SHIPPING_OPTION_ON_SHIPPING_OPTION_CHANGE /* 2623 */:
      case CSS_SELECTOR_EMPTY_WHITESPACE_ONLY_FAIL /* 2624 */:
      case ACTIVATED_IMPLICIT_ROOT_SCROLLER /* 2625 */:
      case CSS_UNKNOWN_NAMESPACE_PREFIX_IN_SELECTOR /* 2626 */:
      case PAGE_LIFE_CYCLE_FREEZE /* 2627 */:
      case OBSOLETE_DEFAULT_IN_CUSTOM_IDENT /* 2628 */:
      case HTML_ANCHOR_ELEMENT_HREF_TRANSLATE_ATTRIBUTE /* 2629 */:
      case WEB_KIT_USER_MODIFY_EFFECTIVE /* 2630 */:
      case PLAIN_TEXT_EDITING_EFFECTIVE /* 2631 */:
      case OBSOLETE_LEGACY_TLS_VERSION_IN_MAIN_FRAME_RESOURCE /* 2634 */:
      case OBSOLETE_LEGACY_TLS_VERSION_IN_SUBRESOURCE /* 2635 */:
      case OBSOLETE_LEGACY_TLS_VERSION_IN_SUBFRAME_MAIN_RESOURCE /* 2636 */:
      case RTC_MAX_AUDIO_BUFFER_SIZE /* 2637 */:
      case WEB_KIT_USER_MODIFY_READ_WRITE_EFFECTIVE /* 2638 */:
      case WEB_KIT_USER_MODIFY_READ_ONLY_EFFECTIVE /* 2639 */:
      case WEB_KIT_USER_MODIFY_PLAIN_TEXT_EFFECTIVE /* 2640 */:
      case CSS_AT_RULE_FONT_FEATURE_VALUES /* 2641 */:
      case FLEXBOX_SINGLE_LINE_ALIGN_CONTENT /* 2642 */:
      case SIGNED_EXCHANGE_INNER_RESPONSE_IN_MAIN_FRAME /* 2643 */:
      case SIGNED_EXCHANGE_INNER_RESPONSE_IN_SUB_FRAME /* 2644 */:
      case V8IDB_FACTORY_DATABASES_METHOD /* 2648 */:
      case OPENER_NAVIGATION_DOWNLOAD_CROSS_ORIGIN /* 2649 */:
      case V8_REG_EXP_MATCH_IS_TRUEISH_ON_NON_JS_REG_EXP /* 2650 */:
      case V8_REG_EXP_MATCH_IS_FALSEISH_ON_JS_REG_EXP /* 2651 */:
      case DOWNLOAD_IN_AD_FRAME_WITHOUT_USER_GESTURE /* 2653 */:
      case NAVIGATOR_APP_VERSION /* 2654 */:
      case NAVIGATOR_DO_NOT_TRACK /* 2655 */:
      case NAVIGATOR_HARDWARE_CONCURRENCY /* 2656 */:
      case NAVIGATOR_LANGUAGE /* 2657 */:
      case NAVIGATOR_LANGUAGES /* 2658 */:
      case NAVIGATOR_MAX_TOUCH_POINTS /* 2659 */:
      case NAVIGATOR_MIME_TYPES /* 2660 */:
      case NAVIGATOR_PLATFORM /* 2661 */:
      case NAVIGATOR_PLUGINS /* 2662 */:
      case NAVIGATOR_USER_AGENT /* 2663 */:
      case WEB_BLUETOOTH_REQUEST_SCAN /* 2664 */:
      case V8SVG_GEOMETRY_ELEMENT_IS_POINT_IN_FILL_METHOD /* 2665 */:
      case V8SVG_GEOMETRY_ELEMENT_IS_POINT_IN_STROKE_METHOD /* 2666 */:
      case V8SVG_GEOMETRY_ELEMENT_GET_TOTAL_LENGTH_METHOD /* 2667 */:
      case V8SVG_GEOMETRY_ELEMENT_GET_POINT_AT_LENGTH_METHOD /* 2668 */:
      case OFFSCREEN_CANVAS_TRANSFER_TO_IMAGE_BITMAP /* 2669 */:
      case OFFSCREEN_CANVAS_IS_POINT_IN_PATH /* 2670 */:
      case OFFSCREEN_CANVAS_IS_POINT_IN_STROKE /* 2671 */:
      case OFFSCREEN_CANVAS_MEASURE_TEXT /* 2672 */:
      case OFFSCREEN_CANVAS_GET_IMAGE_DATA /* 2673 */:
      case V8SVG_TEXT_CONTENT_ELEMENT_GET_COMPUTED_TEXT_LENGTH_METHOD /* 2674 */:
      case V8SVG_TEXT_CONTENT_ELEMENT_GET_END_POSITION_OF_CHAR_METHOD /* 2675 */:
      case V8SVG_TEXT_CONTENT_ELEMENT_GET_EXTENT_OF_CHAR_METHOD /* 2676 */:
      case V8SVG_TEXT_CONTENT_ELEMENT_GET_START_POSITION_OF_CHAR_METHOD /* 2677 */:
      case V8SVG_TEXT_CONTENT_ELEMENT_GET_SUB_STRING_LENGTH_METHOD /* 2678 */:
      case V8_BATTERY_MANAGER_CHARGING_TIME_ATTRIBUTE_GETTER /* 2679 */:
      case V8_BATTERY_MANAGER_CHARGING_ATTRIBUTE_GETTER /* 2680 */:
      case V8_BATTERY_MANAGER_DISCHARGING_TIME_ATTRIBUTE_GETTER /* 2681 */:
      case V8_BATTERY_MANAGER_LEVEL_ATTRIBUTE_GETTER /* 2682 */:
      case V8_PAINT_RENDERING_CONTEXT2_D_IS_POINT_IN_PATH_METHOD /* 2683 */:
      case V8_PAINT_RENDERING_CONTEXT2_D_IS_POINT_IN_STROKE_METHOD /* 2684 */:
      case V8_PAYMENT_REQUEST_CAN_MAKE_PAYMENT_METHOD /* 2685 */:
      case V8_ANALYSER_NODE_GET_BYTE_FREQUENCY_DATA_METHOD /* 2686 */:
      case V8_ANALYSER_NODE_GET_BYTE_TIME_DOMAIN_DATA_METHOD /* 2687 */:
      case V8_ANALYSER_NODE_GET_FLOAT_FREQUENCY_DATA_METHOD /* 2688 */:
      case V8_ANALYSER_NODE_GET_FLOAT_TIME_DOMAIN_DATA_METHOD /* 2689 */:
      case V8_AUDIO_BUFFER_COPY_FROM_CHANNEL_METHOD /* 2690 */:
      case V8_AUDIO_BUFFER_GET_CHANNEL_DATA_METHOD /* 2691 */:
      case WEB_GL_DEBUG_RENDERER_INFO /* 2692 */:
      case V8_WEB_GL2_COMPUTE_RENDERING_CONTEXT_GET_EXTENSION_METHOD /* 2693 */:
      case V8_WEB_GL2_COMPUTE_RENDERING_CONTEXT_GET_SUPPORTED_EXTENSIONS_METHOD /* 2694 */:
      case V8_WEB_GL2_RENDERING_CONTEXT_GET_EXTENSION_METHOD /* 2695 */:
      case V8_WEB_GL2_RENDERING_CONTEXT_GET_SUPPORTED_EXTENSIONS_METHOD /* 2696 */:
      case V8_WEB_GL_RENDERING_CONTEXT_GET_EXTENSION_METHOD /* 2697 */:
      case V8_WEB_GL_RENDERING_CONTEXT_GET_SUPPORTED_EXTENSIONS_METHOD /* 2698 */:
      case V8_SCREEN_AVAIL_HEIGHT_ATTRIBUTE_GETTER /* 2699 */:
      case V8_SCREEN_AVAIL_WIDTH_ATTRIBUTE_GETTER /* 2700 */:
      case V8_SCREEN_COLOR_DEPTH_ATTRIBUTE_GETTER /* 2701 */:
      case V8_SCREEN_HEIGHT_ATTRIBUTE_GETTER /* 2702 */:
      case V8_SCREEN_PIXEL_DEPTH_ATTRIBUTE_GETTER /* 2703 */:
      case V8_SCREEN_WIDTH_ATTRIBUTE_GETTER /* 2704 */:
      case WINDOW_INNER_WIDTH /* 2705 */:
      case WINDOW_INNER_HEIGHT /* 2706 */:
      case V8_WINDOW_MATCH_MEDIA_METHOD /* 2707 */:
      case WINDOW_SCROLL_X /* 2708 */:
      case WINDOW_SCROLL_Y /* 2709 */:
      case WINDOW_PAGE_X_OFFSET /* 2710 */:
      case WINDOW_PAGE_Y_OFFSET /* 2711 */:
      case WINDOW_SCREEN_X /* 2712 */:
      case WINDOW_SCREEN_Y /* 2713 */:
      case WINDOW_OUTER_HEIGHT /* 2714 */:
      case WINDOW_OUTER_WIDTH /* 2715 */:
      case WINDOW_DEVICE_PIXEL_RATIO /* 2716 */:
      case CANVAS_CAPTURE_STREAM /* 2717 */:
      case V8HTML_MEDIA_ELEMENT_CAN_PLAY_TYPE_METHOD /* 2718 */:
      case HISTORY_LENGTH /* 2719 */:
      case FEATURE_POLICY_REPORT_ONLY_HEADER /* 2720 */:
      case V8_PAYMENT_REQUEST_HAS_ENROLLED_INSTRUMENT_METHOD /* 2721 */:
      case TRUSTED_TYPES_ENABLED /* 2722 */:
      case TRUSTED_TYPES_CREATE_POLICY /* 2723 */:
      case TRUSTED_TYPES_DEFAULT_POLICY_CREATED /* 2724 */:
      case TRUSTED_TYPES_ASSIGNMENT_ERROR /* 2725 */:
      case BADGE_SET /* 2726 */:
      case BADGE_CLEAR /* 2727 */:
      case ELEMENT_TIMING_EXPLICITLY_REQUESTED /* 2728 */:
      case V8HTML_MEDIA_ELEMENT_CAPTURE_STREAM_METHOD /* 2729 */:
      case QUIRKY_LINE_BOX_BACKGROUND_SIZE /* 2730 */:
      case DIRECTLY_COMPOSITED_IMAGE /* 2731 */:
      case OBSOLETE_V8HTML_VIDEO_ELEMENT_AUTO_PICTURE_IN_PICTURE_ATTRIBUTE_GETTER /* 2733 */:
      case OBSOLETE_V8HTML_VIDEO_ELEMENT_AUTO_PICTURE_IN_PICTURE_ATTRIBUTE_SETTER /* 2734 */:
      case OBSOLETE_AUTO_PICTURE_IN_PICTURE_ATTRIBUTE /* 2735 */:
      case OBSOLETE_RTC_AUDIO_JITTER_BUFFER_RTX_HANDLING /* 2736 */:
      case WEB_SHARE_CAN_SHARE /* 2737 */:
      case PRIORITY_HINTS /* 2738 */:
      case TEXT_AUTOSIZED_CROSS_SITE_IFRAME /* 2739 */:
      case OBSOLETE_V8RTC_QUIC_TRANSPORT_CONSTRUCTOR /* 2740 */:
      case OBSOLETE_V8RTC_QUIC_TRANSPORT_TRANSPORT_ATTRIBUTE_GETTER /* 2741 */:
      case OBSOLETE_V8RTC_QUIC_TRANSPORT_STATE_ATTRIBUTE_GETTER /* 2742 */:
      case OBSOLETE_V8RTC_QUIC_TRANSPORT_GET_KEY_METHOD /* 2743 */:
      case OBSOLETE_V8RTC_QUIC_TRANSPORT_GET_STATS_METHOD /* 2744 */:
      case OBSOLETE_V8RTC_QUIC_TRANSPORT_CONNECT_METHOD /* 2745 */:
      case OBSOLETE_V8RTC_QUIC_TRANSPORT_LISTEN_METHOD /* 2746 */:
      case OBSOLETE_V8RTC_QUIC_TRANSPORT_STOP_METHOD /* 2747 */:
      case OBSOLETE_V8RTC_QUIC_TRANSPORT_CREATE_STREAM_METHOD /* 2748 */:
      case V8RTC_ICE_TRANSPORT_CONSTRUCTOR /* 2749 */:
      case V8RTC_ICE_TRANSPORT_ROLE_ATTRIBUTE_GETTER /* 2750 */:
      case V8RTC_ICE_TRANSPORT_STATE_ATTRIBUTE_GETTER /* 2751 */:
      case V8RTC_ICE_TRANSPORT_GATHERING_STATE_ATTRIBUTE_GETTER /* 2752 */:
      case V8RTC_ICE_TRANSPORT_GET_LOCAL_CANDIDATES_METHOD /* 2753 */:
      case V8RTC_ICE_TRANSPORT_GET_REMOTE_CANDIDATES_METHOD /* 2754 */:
      case V8RTC_ICE_TRANSPORT_GET_SELECTED_CANDIDATE_PAIR_METHOD /* 2755 */:
      case V8RTC_ICE_TRANSPORT_GET_LOCAL_PARAMETERS_METHOD /* 2756 */:
      case V8RTC_ICE_TRANSPORT_GET_REMOTE_PARAMETERS_METHOD /* 2757 */:
      case OBSOLETE_V8RTC_QUIC_STREAM_TRANSPORT_ATTRIBUTE_GETTER /* 2758 */:
      case OBSOLETE_V8RTC_QUIC_STREAM_STATE_ATTRIBUTE_GETTER /* 2759 */:
      case OBSOLETE_V8RTC_QUIC_STREAM_READ_BUFFERED_AMOUNT_ATTRIBUTE_GETTER /* 2760 */:
      case OBSOLETE_V8RTC_QUIC_STREAM_MAX_READ_BUFFERED_AMOUNT_ATTRIBUTE_GETTER /* 2761 */:
      case OBSOLETE_V8RTC_QUIC_STREAM_WRITE_BUFFERED_AMOUNT_ATTRIBUTE_GETTER /* 2762 */:
      case OBSOLETE_V8RTC_QUIC_STREAM_MAX_WRITE_BUFFERED_AMOUNT_ATTRIBUTE_GETTER /* 2763 */:
      case OBSOLETE_V8RTC_QUIC_STREAM_READ_INTO_METHOD /* 2764 */:
      case OBSOLETE_V8RTC_QUIC_STREAM_WRITE_METHOD /* 2765 */:
      case OBSOLETE_V8RTC_QUIC_STREAM_RESET_METHOD /* 2766 */:
      case OBSOLETE_V8RTC_QUIC_STREAM_WAIT_FOR_WRITE_BUFFERED_AMOUNT_BELOW_METHOD /* 2767 */:
      case OBSOLETE_V8RTC_QUIC_STREAM_WAIT_FOR_READABLE_METHOD /* 2768 */:
      case HTML_TEMPLATE_ELEMENT /* 2769 */:
      case NO_SYSEX_WEB_MIDI_WITHOUT_PERMISSION /* 2770 */:
      case NO_SYSEX_WEB_MIDI_ON_INSECURE_ORIGIN /* 2771 */:
      case OBSOLETE_APPLICATION_CACHE_INSTALLED_BUT_NO_MANIFEST /* 2772 */:
      case OBSOLETE_CUSTOM_CURSOR_INTERSECTS_VIEWPORT /* 2776 */:
      case OBSOLETE_CLIENT_HINTS_LANG /* 2777 */:
      case LINK_REL_PRELOAD_IMAGE_SRCSET /* 2778 */:
      case V8HTML_MEDIA_ELEMENT_REMOTE_ATTRIBUTE_GETTER /* 2779 */:
      case V8_REMOTE_PLAYBACK_WATCH_AVAILABILITY_METHOD /* 2780 */:
      case V8_REMOTE_PLAYBACK_PROMPT_METHOD /* 2781 */:
      case LAYOUT_SHIFT_EXPLICITLY_REQUESTED /* 2782 */:
      case MEDIA_SESSION_SKIP_AD /* 2783 */:
      case V8_USER_ACTIVATION_HAS_BEEN_ACTIVE_ATTRIBUTE_GETTER /* 2785 */:
      case V8_USER_ACTIVATION_IS_ACTIVE_ATTRIBUTE_GETTER /* 2786 */:
      case TEXT_ENCODER_ENCODE_INTO /* 2787 */:
      case CLIENT_HINTS_UA /* 2789 */:
      case CLIENT_HINTS_UA_ARCH /* 2790 */:
      case CLIENT_HINTS_UA_PLATFORM /* 2791 */:
      case CLIENT_HINTS_UA_MODEL /* 2792 */:
      case ANIMATION_FRAME_CANCELLED_WITHIN_FRAME /* 2793 */:
      case SCHEDULING_IS_INPUT_PENDING /* 2794 */:
      case V8_STRING_NORMALIZE /* 2795 */:
      case OBSOLETE_U2F_CRYPTOTOKEN_REGISTER /* 2812 */:
      case OBSOLETE_U2F_CRYPTOTOKEN_SIGN /* 2813 */:
      case CSS_VALUE_APPEARANCE_INNER_SPIN_BUTTON /* 2814 */:
      case CSS_VALUE_APPEARANCE_METER /* 2815 */:
      case CSS_VALUE_APPEARANCE_PROGRESS_BAR /* 2816 */:
      case CSS_VALUE_APPEARANCE_PUSH_BUTTON /* 2818 */:
      case CSS_VALUE_APPEARANCE_SQUARE_BUTTON /* 2819 */:
      case CSS_VALUE_APPEARANCE_SEARCH_CANCEL /* 2820 */:
      case CSS_VALUE_APPEARANCE_TEXTAREA /* 2821 */:
      case CSS_VALUE_APPEARANCE_TEXT_FIELD_FOR_TEMPORAL_RENDERED /* 2823 */:
      case OBSOLETE_AD_CLICK_NAVIGATION /* 2826 */:
      case RTC_STATS_RELATIVE_PACKET_ARRIVAL_DELAY /* 2827 */:
      case CSS_SELECTOR_HOST_CONTEXT_IN_SNAPSHOT_PROFILE /* 2829 */:
      case CSS_SELECTOR_HOST_CONTEXT_IN_LIVE_PROFILE /* 2830 */:
      case IMPORT_MAP /* 2831 */:
      case REFRESH_HEADER /* 2832 */:
      case SEARCH_EVENT_FIRED /* 2833 */:
      case IDLE_DETECTION_START /* 2834 */:
      case TARGET_CURRENT /* 2835 */:
      case SANDBOX_BACK_FORWARD_STAYS_WITHIN_SUBTREE /* 2836 */:
      case SANDBOX_BACK_FORWARD_AFFECTS_FRAMES_OUTSIDE_SUBTREE /* 2837 */:
      case DOWNLOAD_PRE_POLICY_CHECK /* 2838 */:
      case DOWNLOAD_POST_POLICY_CHECK /* 2839 */:
      case READABLE_STREAM_GET_READER /* 2841 */:
      case READABLE_STREAM_PIPE_THROUGH /* 2842 */:
      case READABLE_STREAM_PIPE_TO /* 2843 */:
      case CSS_STYLE_SHEET_REPLACE /* 2844 */:
      case CSS_STYLE_SHEET_REPLACE_SYNC /* 2845 */:
      case ADOPTED_STYLE_SHEETS /* 2846 */:
      case OBSOLETE_HTML_IMPORTS_ON_REVERSE_ORIGIN_TRIALS /* 2847 */:
      case OBSOLETE_ELEMENT_CREATE_SHADOW_ROOT_ON_REVERSE_ORIGIN_TRIALS /* 2848 */:
      case OBSOLETE_DOCUMENT_REGISTER_ELEMENT_ON_REVERSE_ORIGIN_TRIALS /* 2849 */:
      case INPUT_TYPE_RADIO /* 2850 */:
      case INPUT_TYPE_CHECKBOX /* 2851 */:
      case INPUT_TYPE_IMAGE /* 2852 */:
      case INPUT_TYPE_BUTTON /* 2853 */:
      case INPUT_TYPE_HIDDEN /* 2854 */:
      case INPUT_TYPE_RESET /* 2855 */:
      case SELECT_ELEMENT_SINGLE /* 2856 */:
      case SELECT_ELEMENT_MULTIPLE /* 2857 */:
      case V8_ANIMATION_EFFECT_ATTRIBUTE_GETTER /* 2858 */:
      case V8_ANIMATION_EFFECT_ATTRIBUTE_SETTER /* 2859 */:
      case HID_DEVICE_CLOSE /* 2860 */:
      case HID_DEVICE_OPEN /* 2861 */:
      case HID_DEVICE_RECEIVE_FEATURE_REPORT /* 2862 */:
      case HID_DEVICE_SEND_FEATURE_REPORT /* 2863 */:
      case HID_DEVICE_SEND_REPORT /* 2864 */:
      case HID_GET_DEVICES /* 2865 */:
      case HID_REQUEST_DEVICE /* 2866 */:
      case OBSOLETE_V8RTC_QUIC_TRANSPORT_MAX_DATAGRAM_LENGTH_ATTRIBUTE_GETTER /* 2867 */:
      case OBSOLETE_V8RTC_QUIC_TRANSPORT_READY_TO_SEND_DATAGRAM_METHOD /* 2868 */:
      case OBSOLETE_V8RTC_QUIC_TRANSPORT_SEND_DATAGRAM_METHOD /* 2869 */:
      case OBSOLETE_V8RTC_QUIC_TRANSPORT_RECEIVE_DATAGRAMS_METHOD /* 2870 */:
      case CSS_VALUE_CONTAIN_STYLE /* 2871 */:
      case WEB_SHARE_SUCCESSFUL_CONTAINING_FILES /* 2872 */:
      case WEB_SHARE_SUCCESSFUL_WITHOUT_FILES /* 2873 */:
      case WEB_SHARE_UNSUCCESSFUL_CONTAINING_FILES /* 2874 */:
      case WEB_SHARE_UNSUCCESSFUL_WITHOUT_FILES /* 2875 */:
      case VERTICAL_SCROLLBAR_THUMB_SCROLLING_WITH_MOUSE /* 2876 */:
      case VERTICAL_SCROLLBAR_THUMB_SCROLLING_WITH_TOUCH /* 2877 */:
      case HORIZONTAL_SCROLLBAR_THUMB_SCROLLING_WITH_MOUSE /* 2878 */:
      case HORIZONTAL_SCROLLBAR_THUMB_SCROLLING_WITH_TOUCH /* 2879 */:
      case WEB_OTP /* 2880 */:
      case V8_ANIMATION_PENDING_ATTRIBUTE_GETTER /* 2881 */:
      case FOCUS_WITHOUT_USER_ACTIVATION_NOT_SANDBOXED_NOT_AD_FRAME /* 2882 */:
      case FOCUS_WITHOUT_USER_ACTIVATION_NOT_SANDBOXED_AD_FRAME /* 2883 */:
      case FOCUS_WITHOUT_USER_ACTIVATION_SANDBOXED_NOT_AD_FRAME /* 2884 */:
      case FOCUS_WITHOUT_USER_ACTIVATION_SANDBOXED_AD_FRAME /* 2885 */:
      case V8RTC_RTP_RECEIVER_JITTER_BUFFER_DELAY_HINT_ATTRIBUTE_GETTER /* 2886 */:
      case V8RTC_RTP_RECEIVER_JITTER_BUFFER_DELAY_HINT_ATTRIBUTE_SETTER /* 2887 */:
      case MEDIA_CAPABILITIES_DECODING_INFO_WITH_KEY_SYSTEM_CONFIG /* 2888 */:
      case OBSOLETE_REVERT_IN_CUSTOM_IDENT /* 2889 */:
      case UNOPTIMIZED_IMAGE_POLICIES /* 2890 */:
      case VTT_CUE_PARSER /* 2891 */:
      case MEDIA_ELEMENT_TEXT_TRACK_CONTAINER /* 2892 */:
      case MEDIA_ELEMENT_TEXT_TRACK_LIST /* 2893 */:
      case PAYMENT_REQUEST_INITIALIZED /* 2894 */:
      case PAYMENT_REQUEST_SHOW /* 2895 */:
      case PAYMENT_REQUEST_SHIPPING_ADDRESS_CHANGE /* 2896 */:
      case PAYMENT_REQUEST_SHIPPING_OPTION_CHANGE /* 2897 */:
      case PAYMENT_REQUEST_PAYMENT_METHOD_CHANGE /* 2898 */:
      case V8_ANIMATION_UPDATE_PLAYBACK_RATE_METHOD /* 2899 */:
      case TWO_VALUED_OVERFLOW /* 2900 */:
      case TEXT_FRAGMENT_ANCHOR /* 2901 */:
      case TEXT_FRAGMENT_ANCHOR_MATCH_FOUND /* 2902 */:
      case NON_PASSIVE_TOUCH_EVENT_LISTENER /* 2903 */:
      case PASSIVE_TOUCH_EVENT_LISTENER /* 2904 */:
      case WEB_XR_FRAMEBUFFER_SCALE /* 2906 */:
      case WEB_XR_IGNORE_DEPTH_VALUES /* 2907 */:
      case WEB_XR_SESSION_CREATED /* 2908 */:
      case V8XR_REFERENCE_SPACE_GET_OFFSET_REFERENCE_SPACE_METHOD /* 2909 */:
      case V8XR_INPUT_SOURCE_GAMEPAD_ATTRIBUTE_GETTER /* 2910 */:
      case V8XR_SESSION_END_METHOD /* 2911 */:
      case V8XR_WEB_GL_LAYER_CONSTRUCTOR /* 2912 */:
      case FETCH_KEEPALIVE /* 2913 */:
      case CSS_TRANSITION_CANCELLED_BY_REMOVING_STYLE /* 2914 */:
      case V8RTC_RTP_SENDER_SET_STREAMS_METHOD /* 2915 */:
      case COOKIE_NO_SAME_SITE /* 2916 */:
      case COOKIE_INSECURE_AND_SAME_SITE_NONE /* 2917 */:
      case UNSIZED_MEDIA_POLICY /* 2918 */:
      case SCROLL_BY_PRECISION_TOUCH_PAD /* 2919 */:
      case PINCH_ZOOM /* 2920 */:
      case FEATURE_POLICY_COMMA_SEPARATED_DECLARATIONS /* 2922 */:
      case FEATURE_POLICY_SEMICOLON_SEPARATED_DECLARATIONS /* 2923 */:
      case V8_CALL_SITE_API_GET_FUNCTION_SLOPPY_CALL /* 2924 */:
      case V8_CALL_SITE_API_GET_THIS_SLOPPY_CALL /* 2925 */:
      case LARGEST_CONTENTFUL_PAINT_EXPLICITLY_REQUESTED /* 2927 */:
      case PAGE_FREEZE_OPT_IN /* 2928 */:
      case PAGE_FREEZE_OPT_OUT /* 2929 */:
      case PERIODIC_BACKGROUND_SYNC /* 2930 */:
      case PERIODIC_BACKGROUND_SYNC_REGISTER /* 2931 */:
      case LAZY_LOAD_FRAME_LOADING_ATTRIBUTE_EAGER /* 2932 */:
      case LAZY_LOAD_FRAME_LOADING_ATTRIBUTE_LAZY /* 2933 */:
      case LAZY_LOAD_IMAGE_LOADING_ATTRIBUTE_EAGER /* 2934 */:
      case LAZY_LOAD_IMAGE_LOADING_ATTRIBUTE_LAZY /* 2935 */:
      case PERIODIC_BACKGROUND_SYNC_GET_TAGS /* 2937 */:
      case PERIODIC_BACKGROUND_SYNC_UNREGISTER /* 2938 */:
      case CREATE_OBJECT_URL_MEDIA_SOURCE_FROM_WORKER /* 2939 */:
      case CSS_AT_RULE_PROPERTY /* 2940 */:
      case SERVICE_WORKER_INTERCEPTED_REQUEST_FROM_ORIGIN_DIRTY_STYLE_SHEET /* 2941 */:
      case WEBKIT_MARGIN_BEFORE_COLLAPSE_DISCARD /* 2942 */:
      case WEBKIT_MARGIN_BEFORE_COLLAPSE_SEPARATE /* 2943 */:
      case WEBKIT_MARGIN_BEFORE_COLLAPSE_SEPARATE_MAYBE_DOES_SOMETHING /* 2944 */:
      case WEBKIT_MARGIN_AFTER_COLLAPSE_DISCARD /* 2945 */:
      case WEBKIT_MARGIN_AFTER_COLLAPSE_SEPARATE /* 2946 */:
      case WEBKIT_MARGIN_AFTER_COLLAPSE_SEPARATE_MAYBE_DOES_SOMETHING /* 2947 */:
      case CREDENTIAL_MANAGER_GET_WITH_UVM /* 2949 */:
      case CREDENTIAL_MANAGER_GET_SUCCESS_WITH_UVM /* 2951 */:
      case DISCARD_INPUT_EVENT_TO_MOVING_IFRAME /* 2952 */:
      case SIGNED_EXCHANGE_SUBRESOURCE_PREFETCH /* 2953 */:
      case BASIC_CARD_TYPE /* 2954 */:
      case EXECUTED_JAVA_SCRIPT_URL /* 2955 */:
      case LINK_PREFETCH_LOAD_EVENT /* 2956 */:
      case LINK_PREFETCH_ERROR_EVENT /* 2957 */:
      case FONT_SIZE_WEBKIT_XXX_LARGE /* 2958 */:
      case V8_DATABASE_CHANGE_VERSION_METHOD /* 2959 */:
      case V8_DATABASE_TRANSACTION_METHOD /* 2960 */:
      case V8_DATABASE_READ_TRANSACTION_METHOD /* 2961 */:
      case V8SQL_TRANSACTION_EXECUTE_SQL_METHOD /* 2962 */:
      case V8_POINTER_EVENT_GET_PREDICTED_EVENTS_METHOD /* 2971 */:
      case OBSOLETE_SCROLL_SNAP_ON_VIEWPORT_BREAKS /* 2972 */:
      case OBSOLETE_SCROLL_PADDING_ON_VIEWPORT_BREAKS /* 2973 */:
      case DOWNLOAD_IN_AD_FRAME /* 2974 */:
      case DOWNLOAD_IN_SANDBOX /* 2975 */:
      case DOWNLOAD_WITHOUT_USER_GESTURE /* 2976 */:
      case AUTOPLAY_DYNAMIC_DELEGATION /* 2977 */:
      case TOGGLE_EVENT_HANDLER_DURING_PARSING /* 2978 */:
      case FRAGMENT_DOUBLE_HASH /* 2979 */:
      case OBSOLETE_CSS_VALUE_OVERFLOW_X_OVERLAY /* 2981 */:
      case OBSOLETE_CSS_VALUE_OVERFLOW_Y_OVERLAY /* 2982 */:
      case CONTENT_INDEX_ADD /* 2983 */:
      case CONTENT_INDEX_DELETE /* 2984 */:
      case CONTENT_INDEX_GET /* 2985 */:
      case V8_SPEECH_GRAMMAR_CONSTRUCTOR /* 2986 */:
      case V8_SPEECH_GRAMMAR_LIST_ADD_FROM_STRING_METHOD /* 2987 */:
      case V8_SPEECH_GRAMMAR_LIST_CONSTRUCTOR /* 2988 */:
      case V8_SPEECH_GRAMMAR_LIST_ITEM_METHOD /* 2989 */:
      case V8_SPEECH_RECOGNITION_CONSTRUCTOR /* 2990 */:
      case V8_SPEECH_RECOGNITION_GRAMMARS_ATTRIBUTE_GETTER /* 2991 */:
      case V8_SPEECH_RECOGNITION_GRAMMARS_ATTRIBUTE_SETTER /* 2992 */:
      case CONTACTS_MANAGER_SELECT /* 2993 */:
      case V8_MEDIA_SESSION_SET_POSITION_STATE_METHOD /* 2994 */:
      case CSS_VALUE_OVERFLOW_OVERLAY /* 2995 */:
      case REQUESTED_FILE_SYSTEM_TEMPORARY /* 2996 */:
      case REQUESTED_FILE_SYSTEM_PERSISTENT /* 2997 */:
      case ELEMENT_WITH_LEFTWARD_OR_UPWARD_OVERFLOW_DIRECTION_SCROLL_LEFT_OR_TOP /* 2998 */:
      case ELEMENT_WITH_LEFTWARD_OR_UPWARD_OVERFLOW_DIRECTION_SCROLL_LEFT_OR_TOP_SET_POSITIVE /* 2999 */:
      case 3000:
      case XML_HTTP_REQUEST_SYNCHRONOUS_IN_CROSS_ORIGIN_SUBFRAME /* 3001 */:
      case XML_HTTP_REQUEST_SYNCHRONOUS_IN_SAME_ORIGIN_SUBFRAME /* 3002 */:
      case XML_HTTP_REQUEST_SYNCHRONOUS_IN_WORKER /* 3003 */:
      case PERFORMANCE_OBSERVER_BUFFERED_FLAG /* 3004 */:
      case WAKE_LOCK_ACQUIRE_SCREEN_LOCK /* 3005 */:
      case WAKE_LOCK_ACQUIRE_SYSTEM_LOCK /* 3006 */:
      case THIRD_PARTY_SERVICE_WORKER /* 3007 */:
      case JS_SELF_PROFILING /* 3008 */:
      case HTML_FRAME_SET_ELEMENT /* 3009 */:
      case FETCH_REDIRECT_ERROR /* 3012 */:
      case FETCH_REDIRECT_MANUAL /* 3013 */:
      case FETCH_CACHE_RELOAD /* 3014 */:
      case V8_WINDOW_CHOOSE_FILE_SYSTEM_ENTRIES_METHOD /* 3015 */:
      case V8_FILE_SYSTEM_DIRECTORY_HANDLE_GET_SYSTEM_DIRECTORY_METHOD /* 3016 */:
      case NOTIFICATION_SHOW_TRIGGER /* 3017 */:
      case WEB_SOCKET_STREAM_CONSTRUCTOR /* 3018 */:
      case DOM_STORAGE_READ /* 3019 */:
      case DOM_STORAGE_WRITE /* 3020 */:
      case CACHE_STORAGE_READ /* 3021 */:
      case CACHE_STORAGE_WRITE /* 3022 */:
      case INDEXED_DB_READ /* 3023 */:
      case INDEXED_DB_WRITE /* 3024 */:
      case DEPRECATED_FILE_SYSTEM_READ /* 3025 */:
      case DEPRECATED_FILE_SYSTEM_WRITE /* 3026 */:
      case POINTER_LOCK_UNADJUSTED_MOVEMENT /* 3027 */:
      case CREATE_OBJECT_BLOB /* 3028 */:
      case QUOTA_READ /* 3029 */:
      case DELEGATE_FOCUS /* 3030 */:
      case THIRD_PARTY_SHARED_WORKER /* 3032 */:
      case THIRD_PARTY_BROADCAST_CHANNEL /* 3033 */:
      case MEDIA_SOURCE_GROUP_END_TIMESTAMP_DECREASE_WITHIN_MEDIA_SEGMENT /* 3034 */:
      case TEXT_FRAGMENT_ANCHOR_TAP_TO_DISMISS /* 3035 */:
      case XR_IS_SESSION_SUPPORTED /* 3036 */:
      case SCROLLBAR_USE_SCROLLBAR_BUTTON_REVERSED_DIRECTION /* 3037 */:
      case CSS_SELECTOR_PSEUDO_SCROLLBAR_BUTTON_REVERSED_DIRECTION /* 3038 */:
      case OBSOLETE_FRAGMENT_HAS_TILDE_AMPERSAND_TILDE /* 3039 */:
      case OBSOLETE_FRAGMENT_HAS_COLON_TILDE_COLON /* 3040 */:
      case OBSOLETE_FRAGMENT_HAS_TILDE_AT_TILDE /* 3041 */:
      case OBSOLETE_FRAGMENT_HAS_AMPERSAND_DELIMITER_QUESTION /* 3042 */:
      case INVALID_FRAGMENT_DIRECTIVE /* 3043 */:
      case CONTACTS_MANAGER_GET_PROPERTIES /* 3044 */:
      case PLUGIN_ELEMENT_LOADED_DOCUMENT /* 3046 */:
      case PLUGIN_ELEMENT_LOADED_IMAGE /* 3047 */:
      case PLUGIN_ELEMENT_LOADED_EXTERNAL /* 3048 */:
      case RENDER_SUBTREE_ATTRIBUTE /* 3049 */:
      case ARIA_ANNOTATIONS /* 3050 */:
      case INTERSECTION_OBSERVER_V2 /* 3051 */:
      case HEAVY_AD_INTERVENTION /* 3052 */:
      case USER_TIMING_L3 /* 3053 */:
      case GET_GAMEPADS_FROM_CROSS_ORIGIN_SUBFRAME /* 3054 */:
      case GET_GAMEPADS_FROM_INSECURE_CONTEXT /* 3055 */:
      case ORIGIN_CLEAN_IMAGE_BITMAP_SERIALIZATION /* 3056 */:
      case NON_ORIGIN_CLEAN_IMAGE_BITMAP_SERIALIZATION /* 3057 */:
      case ORIGIN_CLEAN_IMAGE_BITMAP_TRANSFER /* 3058 */:
      case NON_ORIGIN_CLEAN_IMAGE_BITMAP_TRANSFER /* 3059 */:
      case COMPRESSION_STREAM_CONSTRUCTOR /* 3060 */:
      case DECOMPRESSION_STREAM_CONSTRUCTOR /* 3061 */:
      case V8RTC_RTP_RECEIVER_PLAYOUT_DELAY_HINT_ATTRIBUTE_GETTER /* 3062 */:
      case V8RTC_RTP_RECEIVER_PLAYOUT_DELAY_HINT_ATTRIBUTE_SETTER /* 3063 */:
      case V8_REG_EXP_EXEC_CALLED_ON_SLOW_REG_EXP /* 3064 */:
      case V8_REG_EXP_REPLACE_CALLED_ON_SLOW_REG_EXP /* 3065 */:
      case HAS_MARKER_PSEUDO_ELEMENT /* 3066 */:
      case WINDOW_MOVE /* 3067 */:
      case WINDOW_RESIZE /* 3068 */:
      case MOVED_OR_RESIZED_POPUP /* 3069 */:
      case MOVED_OR_RESIZED_POPUP2S_AFTER_CREATION /* 3070 */:
      case DOM_WINDOW_OPEN_POSITIONING_FEATURES /* 3071 */:
      case MOUSE_EVENT_SCREEN_X /* 3072 */:
      case MOUSE_EVENT_SCREEN_Y /* 3073 */:
      case CREDENTIAL_MANAGER_IS_USER_VERIFYING_PLATFORM_AUTHENTICATOR_AVAILABLE /* 3074 */:
      case OBSOLETE_WEBRTC_TLS_VERSION /* 3075 */:
      case UPGRADE_INSECURE_REQUESTS_UPGRADED_REQUEST_BLOCKABLE /* 3076 */:
      case UPGRADE_INSECURE_REQUESTS_UPGRADED_REQUEST_OPTIONALLY_BLOCKABLE /* 3077 */:
      case UPGRADE_INSECURE_REQUESTS_UPGRADED_REQUEST_WEBSOCKET /* 3078 */:
      case UPGRADE_INSECURE_REQUESTS_UPGRADED_REQUEST_FORM /* 3079 */:
      case UPGRADE_INSECURE_REQUESTS_UPGRADED_REQUEST_UNKNOWN /* 3080 */:
      case HAS_GLYPH_RELATIVE_UNITS /* 3081 */:
      case COUNT_QUEUING_STRATEGY_CONSTRUCTOR /* 3082 */:
      case BYTE_LENGTH_QUEUING_STRATEGY_CONSTRUCTOR /* 3083 */:
      case CLASSIC_DEDICATED_WORKER /* 3084 */:
      case MODULE_DEDICATED_WORKER /* 3085 */:
      case FETCH_BODY_STREAM_IN_SERVICE_WORKER /* 3086 */:
      case FETCH_BODY_STREAM_OUTSIDE_SERVICE_WORKER /* 3087 */:
      case GET_COMPUTED_STYLE_OUTSIDE_FLAT_TREE /* 3088 */:
      case ARIA_DESCRIPTION_ATTRIBUTE /* 3089 */:
      case STRICT_MIME_TYPE_CHECKS_WOULD_BLOCK_WORKER /* 3090 */:
      case RESOURCE_TIMING_TAINTED_ORIGIN_FLAG_FAIL /* 3091 */:
      case REGISTER_PROTOCOL_HANDLER_SAME_ORIGIN_AS_TOP /* 3092 */:
      case REGISTER_PROTOCOL_HANDLER_CROSS_ORIGIN_SUBFRAME /* 3093 */:
      case WEB_NFC_NDEF_READER_SCAN /* 3094 */:
      case WEB_NFC_NDEF_WRITER_WRITE /* 3095 */:
      case HTML_PORTAL_ELEMENT /* 3096 */:
      case V8HTML_PORTAL_ELEMENT_ACTIVATE_METHOD /* 3097 */:
      case V8HTML_PORTAL_ELEMENT_POST_MESSAGE_METHOD /* 3098 */:
      case V8_WINDOW_PORTAL_HOST_ATTRIBUTE_GETTER /* 3099 */:
      case V8_PORTAL_HOST_POST_MESSAGE_METHOD /* 3100 */:
      case V8_PORTAL_ACTIVATE_EVENT_DATA_ATTRIBUTE_GETTER /* 3101 */:
      case V8_PORTAL_ACTIVATE_EVENT_ADOPT_PREDECESSOR_METHOD /* 3102 */:
      case LINK_REL_PREFETCH_FOR_SIGNED_EXCHANGES /* 3103 */:
      case MESSAGE_EVENT_SHARED_ARRAY_BUFFER_SAME_ORIGIN /* 3104 */:
      case MESSAGE_EVENT_SHARED_ARRAY_BUFFER_SAME_AGENT_CLUSTER /* 3105 */:
      case MESSAGE_EVENT_SHARED_ARRAY_BUFFER_DIFFERENT_AGENT_CLUSTER /* 3106 */:
      case CACHE_STORAGE_CODE_CACHE_HINT /* 3107 */:
      case V8_METADATA_MODIFICATION_TIME_ATTRIBUTE_GETTER /* 3108 */:
      case V8RTC_LEGACY_STATS_REPORT_TIMESTAMP_ATTRIBUTE_GETTER /* 3109 */:
      case INPUT_ELEMENT_VALUE_AS_DATE_GETTER /* 3110 */:
      case INPUT_ELEMENT_VALUE_AS_DATE_SETTER /* 3111 */:
      case HTML_META_ELEMENT_REFERRER_POLICY /* 3112 */:
      case NON_WEBBY_MIXED_CONTENT /* 3113 */:
      case V8_SHARED_ARRAY_BUFFER_CONSTRUCTED /* 3114 */:
      case SCROLL_SNAP_CAUSES_SCROLL_ON_INITIAL_LAYOUT /* 3115 */:
      case CLIENT_HINTS_UA_MOBILE /* 3116 */:
      case V8_VIDEO_PLAYBACK_QUALITY_CORRUPTED_VIDEO_FRAMES_ATTRIBUTE_GETTER /* 3117 */:
      case LONG_TASK_BUFFER_FULL /* 3118 */:
      case HTML_META_ELEMENT_MONETIZATION /* 3119 */:
      case HTML_LINK_ELEMENT_MONETIZATION /* 3120 */:
      case OBSOLETE_INPUT_TYPE_CHECKBOX_RENDERED_NON_SQUARE /* 3121 */:
      case OBSOLETE_INPUT_TYPE_RADIO_RENDERED_NON_SQUARE /* 3122 */:
      case WEBKIT_BOX_PACK_JUSTIFY_DOES_SOMETHING /* 3123 */:
      case WEBKIT_BOX_PACK_CENTER_DOES_SOMETHING /* 3124 */:
      case WEBKIT_BOX_PACK_END_DOES_SOMETHING /* 3125 */:
      case V8_KEYFRAME_EFFECT_CONSTRUCTOR /* 3126 */:
      case OBSOLETE_WEB_NFC_API /* 3127 */:
      case HOST_CANDIDATE_ATTRIBUTE_GETTER /* 3128 */:
      case CSP_WITH_REASONABLE_OBJECT_RESTRICTIONS /* 3129 */:
      case CSP_WITH_REASONABLE_BASE_RESTRICTIONS /* 3130 */:
      case CSP_WITH_REASONABLE_SCRIPT_RESTRICTIONS /* 3131 */:
      case CSP_WITH_REASONABLE_RESTRICTIONS /* 3132 */:
      case CSPRO_WITH_REASONABLE_OBJECT_RESTRICTIONS /* 3133 */:
      case CSPRO_WITH_REASONABLE_BASE_RESTRICTIONS /* 3134 */:
      case CSPRO_WITH_REASONABLE_SCRIPT_RESTRICTIONS /* 3135 */:
      case CSPRO_WITH_REASONABLE_RESTRICTIONS /* 3136 */:
      case CSP_WITH_BETTER_THAN_REASONABLE_RESTRICTIONS /* 3137 */:
      case CSPRO_WITH_BETTER_THAN_REASONABLE_RESTRICTIONS /* 3138 */:
      case MEASURE_MEMORY /* 3139 */:
      case V8_ANIMATION_REPLACE_STATE_ATTRIBUTE_GETTER /* 3140 */:
      case V8_ANIMATION_PERSIST_METHOD /* 3141 */:
      case TASK_CONTROLLER_CONSTRUCTOR /* 3142 */:
      case TASK_CONTROLLER_SET_PRIORITY /* 3143 */:
      case TASK_SIGNAL_PRIORITY /* 3144 */:
      case SCHEDULER_POST_TASK /* 3145 */:
      case V8_ANIMATION_ONREMOVE_ATTRIBUTE_GETTER /* 3146 */:
      case V8_ANIMATION_ONREMOVE_ATTRIBUTE_SETTER /* 3147 */:
      case CLASSIC_SHARED_WORKER /* 3148 */:
      case MODULE_SHARED_WORKER /* 3149 */:
      case V8_ANIMATION_COMMIT_STYLES_METHOD /* 3150 */:
      case SAME_ORIGIN_IFRAME_WINDOW_ALERT /* 3151 */:
      case SAME_ORIGIN_IFRAME_WINDOW_CONFIRM /* 3152 */:
      case SAME_ORIGIN_IFRAME_WINDOW_PROMPT /* 3153 */:
      case SAME_ORIGIN_IFRAME_WINDOW_PRINT /* 3154 */:
      case LARGE_STICKY_AD /* 3155 */:
      case CSS_COMPARISON_FUNCTIONS /* 3157 */:
      case OBSOLETE_FEATURE_POLICY_PROPOSAL_WOULD_CHANGE_BEHAVIOUR /* 3158 */:
      case RTC_LOCAL_SDP_MODIFICATION_SIMULCAST /* 3159 */:
      case TRUSTED_TYPES_ENABLED_ENFORCING /* 3160 */:
      case TRUSTED_TYPES_ENABLED_REPORT_ONLY /* 3161 */:
      case TRUSTED_TYPES_ALLOW_DUPLICATES /* 3162 */:
      case V8_ARRAY_PROTOTYPE_HAS_ELEMENTS /* 3163 */:
      case V8_OBJECT_PROTOTYPE_HAS_ELEMENTS /* 3164 */:
      case DISALLOW_DOCUMENT_ACCESS /* 3165 */:
      case XR_SESSION_REQUEST_HIT_TEST_SOURCE /* 3166 */:
      case XR_SESSION_REQUEST_HIT_TEST_SOURCE_FOR_TRANSIENT_INPUT /* 3167 */:
      case XRDOM_OVERLAY /* 3168 */:
      case OBSOLETE_CSS_STYLE_SHEET_REPLACE_WITH_IMPORT /* 3169 */:
      case CRYPTO_ALGORITHM_ED25519 /* 3170 */:
      case CRYPTO_ALGORITHM_X25519 /* 3171 */:
      case DISPLAY_NAMES /* 3172 */:
      case NUMBER_FORMAT_STYLE_UNIT /* 3173 */:
      case DATE_TIME_FORMAT_RANGE /* 3174 */:
      case DATE_TIME_FORMAT_DATE_TIME_STYLE /* 3175 */:
      case BREAK_ITERATOR_TYPE_WORD /* 3176 */:
      case BREAK_ITERATOR_TYPE_LINE /* 3177 */:
      case V8_FILE_SYSTEM_DIRECTORY_HANDLE_RESOLVE_METHOD /* 3178 */:
      case V8_FILE_SYSTEM_HANDLE_IS_SAME_ENTRY_METHOD /* 3179 */:
      case OBSOLETE_V8RTC_RTP_SENDER_CREATE_ENCODED_AUDIO_STREAMS_METHOD /* 3180 */:
      case OBSOLETE_V8RTC_RTP_SENDER_CREATE_ENCODED_VIDEO_STREAMS_METHOD /* 3181 */:
      case OBSOLETE_V8RTC_RTP_RECEIVER_CREATE_ENCODED_AUDIO_STREAMS_METHOD /* 3182 */:
      case OBSOLETE_V8RTC_RTP_RECEIVER_CREATE_ENCODED_VIDEO_STREAMS_METHOD /* 3183 */:
      case QUIC_TRANSPORT /* 3184 */:
      case QUIC_TRANSPORT_STREAM_APIS /* 3185 */:
      case QUIC_TRANSPORT_DATAGRAM_APIS /* 3186 */:
      case V8_DOCUMENT_GET_ANIMATIONS_METHOD /* 3187 */:
      case V8_SHADOW_ROOT_GET_ANIMATIONS_METHOD /* 3188 */:
      case CLIENT_HINTS_UA_FULL_VERSION /* 3189 */:
      case OBSOLETE_SCHEDULER_CURRENT_TASK_SIGNAL /* 3190 */:
      case THIRD_PARTY_FILE_SYSTEM /* 3191 */:
      case THIRD_PARTY_INDEXED_DB /* 3192 */:
      case THIRD_PARTY_CACHE_STORAGE /* 3193 */:
      case THIRD_PARTY_LOCAL_STORAGE /* 3194 */:
      case THIRD_PARTY_SESSION_STORAGE /* 3195 */:
      case DECLARATIVE_SHADOW_ROOT /* 3196 */:
      case CROSS_ORIGIN_OPENER_POLICY_SAME_ORIGIN /* 3197 */:
      case CROSS_ORIGIN_OPENER_POLICY_SAME_ORIGIN_ALLOW_POPUPS /* 3198 */:
      case CROSS_ORIGIN_EMBEDDER_POLICY_REQUIRE_CORP /* 3199 */:
      case COOP_AND_COEP_ISOLATED /* 3200 */:
      case V8_DOCUMENT_HAS_TRUST_TOKEN_METHOD /* 3202 */:
      case FORCE_LOAD_AT_TOP /* 3203 */:
      case OBSOLETE_LEGACY_LAYOUT_BY_DETAILS_MARKER /* 3206 */:
      case OBSOLETE_LEGACY_LAYOUT_BY_EDITING /* 3207 */:
      case OBSOLETE_LEGACY_LAYOUT_BY_FRAME_SET /* 3211 */:
      case OBSOLETE_LEGACY_LAYOUT_BY_GRID /* 3212 */:
      case OBSOLETE_LEGACY_LAYOUT_BY_MULTI_COL /* 3214 */:
      case OBSOLETE_LEGACY_LAYOUT_BY_PRINTING /* 3215 */:
      case OBSOLETE_LEGACY_LAYOUT_BY_SVG /* 3217 */:
      case OBSOLETE_LEGACY_LAYOUT_BY_TABLE /* 3219 */:
      case OBSOLETE_LEGACY_LAYOUT_BY_TEXT_COMBINE /* 3220 */:
      case OBSOLETE_LEGACY_LAYOUT_BY_TEXT_CONTROL /* 3221 */:
      case OBSOLETE_LEGACY_LAYOUT_BY_VTT_CUE /* 3222 */:
      case OBSOLETE_LEGACY_LAYOUT_BY_TABLE_FLEX_GRID_BLOCK_IN_NG_FRAGMENTATION_CONTEXT /* 3224 */:
      case DOCUMENT_POLICY_HEADER /* 3225 */:
      case DOCUMENT_POLICY_REPORT_ONLY_HEADER /* 3226 */:
      case REQUIRE_DOCUMENT_POLICY_HEADER /* 3227 */:
      case DOCUMENT_POLICY_IFRAME_POLICY_ATTRIBUTE /* 3228 */:
      case DOCUMENT_POLICY_CAUSED_PAGE_UNLOAD /* 3229 */:
      case REQUIRED_DOCUMENT_POLICY /* 3230 */:
      case PERFORMANCE_OBSERVER_ENTRY_TYPES_AND_BUFFERED /* 3231 */:
      case PERFORMANCE_OBSERVER_TYPE_ERROR /* 3232 */:
      case IMAGE_CAPTURE_WHITE_BALANCE_MODE /* 3233 */:
      case IMAGE_CAPTURE_EXPOSURE_MODE /* 3234 */:
      case IMAGE_CAPTURE_FOCUS_MODE /* 3235 */:
      case IMAGE_CAPTURE_POINTS_OF_INTEREST /* 3236 */:
      case IMAGE_CAPTURE_EXPOSURE_COMPENSATION /* 3237 */:
      case IMAGE_CAPTURE_EXPOSURE_TIME /* 3238 */:
      case IMAGE_CAPTURE_COLOR_TEMPERATURE /* 3239 */:
      case IMAGE_CAPTURE_ISO /* 3240 */:
      case IMAGE_CAPTURE_BRIGHTNESS /* 3241 */:
      case IMAGE_CAPTURE_CONTRAST /* 3242 */:
      case IMAGE_CAPTURE_SATURATION /* 3243 */:
      case IMAGE_CAPTURE_SHARPNESS /* 3244 */:
      case IMAGE_CAPTURE_FOCUS_DISTANCE /* 3245 */:
      case IMAGE_CAPTURE_PAN /* 3246 */:
      case IMAGE_CAPTURE_TILT /* 3247 */:
      case IMAGE_CAPTURE_ZOOM /* 3248 */:
      case IMAGE_CAPTURE_TORCH /* 3249 */:
      case XR_FRAME_CREATE_ANCHOR /* 3250 */:
      case XR_HIT_TEST_RESULT_CREATE_ANCHOR /* 3251 */:
      case CSS_KEYWORD_REVERT /* 3252 */:
      case OVERLAY_POPUP_AD /* 3253 */:
      case EVENT_TIMING_FIRST_INPUT_EXPLICITLY_REQUESTED /* 3254 */:
      case CUSTOM_SCROLLBAR_PERCENT_THICKNESS /* 3255 */:
      case CUSTOM_SCROLLBAR_PART_PERCENT_LENGTH /* 3256 */:
      case V8_INVALIDATED_ARRAY_BUFFER_DETACHING_PROTECTOR /* 3257 */:
      case V8_INVALIDATED_ARRAY_CONSTRUCTOR_PROTECTOR /* 3258 */:
      case V8_INVALIDATED_ARRAY_ITERATOR_LOOKUP_CHAIN_PROTECTOR /* 3259 */:
      case V8_INVALIDATED_ARRAY_SPECIES_LOOKUP_CHAIN_PROTECTOR /* 3260 */:
      case V8_INVALIDATED_IS_CONCAT_SPREADABLE_LOOKUP_CHAIN_PROTECTOR /* 3261 */:
      case V8_INVALIDATED_MAP_ITERATOR_LOOKUP_CHAIN_PROTECTOR /* 3262 */:
      case V8_INVALIDATED_NO_ELEMENTS_PROTECTOR /* 3263 */:
      case V8_INVALIDATED_PROMISE_HOOK_PROTECTOR /* 3264 */:
      case V8_INVALIDATED_PROMISE_RESOLVE_LOOKUP_CHAIN_PROTECTOR /* 3265 */:
      case V8_INVALIDATED_PROMISE_SPECIES_LOOKUP_CHAIN_PROTECTOR /* 3266 */:
      case V8_INVALIDATED_PROMISE_THEN_LOOKUP_CHAIN_PROTECTOR /* 3267 */:
      case V8_INVALIDATED_REG_EXP_SPECIES_LOOKUP_CHAIN_PROTECTOR /* 3268 */:
      case V8_INVALIDATED_SET_ITERATOR_LOOKUP_CHAIN_PROTECTOR /* 3269 */:
      case V8_INVALIDATED_STRING_ITERATOR_LOOKUP_CHAIN_PROTECTOR /* 3270 */:
      case V8_INVALIDATED_STRING_LENGTH_OVERFLOW_LOOKUP_CHAIN_PROTECTOR /* 3271 */:
      case V8_INVALIDATED_TYPED_ARRAY_SPECIES_LOOKUP_CHAIN_PROTECTOR /* 3272 */:
      case CLIENT_HINTS_UA_PLATFORM_VERSION /* 3273 */:
      case I_FRAME_CSP_ATTRIBUTE /* 3274 */:
      case NAVIGATOR_COOKIE_ENABLED /* 3275 */:
      case TRUST_TOKEN_FETCH /* 3276 */:
      case TRUST_TOKEN_XHR /* 3277 */:
      case TRUST_TOKEN_IFRAME /* 3278 */:
      case TRUSTED_TYPES_POLICY_CREATED /* 3279 */:
      case V8HTML_VIDEO_ELEMENT_REQUEST_VIDEO_FRAME_CALLBACK_METHOD /* 3280 */:
      case V8HTML_VIDEO_ELEMENT_CANCEL_VIDEO_FRAME_CALLBACK_METHOD /* 3281 */:
      case RUBY_ELEMENT_WITH_DISPLAY_BLOCK /* 3282 */:
      case OBSOLETE_LOCATION_FRAGMENT_DIRECTIVE_ACCESSED /* 3283 */:
      case CANVAS_RENDERING_CONTEXT /* 3284 */:
      case SCHEMEFUL_SAME_SITE_CONTEXT_DOWNGRADE /* 3285 */:
      case ORIGIN_AGENT_CLUSTER_HEADER /* 3286 */:
      case V8_WASM_SIMD_OPCODES /* 3287 */:
      case GRID_ROW_GAP_PERCENT /* 3288 */:
      case GRID_ROW_GAP_PERCENT_INDEFINITE /* 3289 */:
      case FLEX_ROW_GAP_PERCENT /* 3290 */:
      case FLEX_ROW_GAP_PERCENT_INDEFINITE /* 3291 */:
      case V8RTC_RTP_SENDER_CREATE_ENCODED_STREAMS_METHOD /* 3292 */:
      case V8RTC_RTP_RECEIVER_CREATE_ENCODED_STREAMS_METHOD /* 3293 */:
      case OBSOLETE_FORCE_ENCODED_AUDIO_INSERTABLE_STREAMS /* 3294 */:
      case OBSOLETE_FORCE_ENCODED_VIDEO_INSERTABLE_STREAMS /* 3295 */:
      case TRANSFORM_STYLE_CONTAINING_BLOCK_COMPUTED_USED_MISMATCH /* 3296 */:
      case OBSOLETE_ADDITIONAL_GROUPING_PROPERTIES_FOR_COMPAT /* 3297 */:
      case POPUP_DOES_NOT_EXCEED_OWNER_WINDOW_BOUNDS /* 3298 */:
      case POPUP_EXCEEDS_OWNER_WINDOW_BOUNDS /* 3299 */:
      case POPUP_EXCEEDS_OWNER_WINDOW_BOUNDS_FOR_IFRAME /* 3300 */:
      case POPUP_GESTURE_TAP_EXCEEDS_OWNER_WINDOW_BOUNDS /* 3301 */:
      case POPUP_MOUSE_DOWN_EXCEEDS_OWNER_WINDOW_BOUNDS /* 3302 */:
      case POPUP_MOUSE_WHEEL_EXCEEDS_OWNER_WINDOW_BOUNDS /* 3303 */:
      case V8_VAR_REDECLARED_CATCH_BINDING /* 3304 */:
      case WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_WRITE_VALUE_WITH_RESPONSE /* 3305 */:
      case WEB_BLUETOOTH_REMOTE_CHARACTERISTIC_WRITE_VALUE_WITHOUT_RESPONSE /* 3306 */:
      case FLEX_GAP_SPECIFIED /* 3307 */:
      case FLEX_GAP_POSITIVE /* 3308 */:
      case PLUGIN_INSTANCE_ACCESS_SUCCESSFUL /* 3309 */:
      case STORAGE_ACCESS_API_HAS_STORAGE_ACCESS_METHOD /* 3310 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_METHOD /* 3311 */:
      case WEB_BLUETOOTH_WATCH_ADVERTISEMENTS /* 3312 */:
      case RUBY_TEXT_WITH_NON_DEFAULT_TEXT_ALIGN /* 3313 */:
      case HTML_META_ELEMENT_REFERRER_POLICY_OUTSIDE_HEAD /* 3314 */:
      case HTML_META_ELEMENT_REFERRER_POLICY_MULTIPLE_TOKENS /* 3315 */:
      case OBSOLETE_V8_WASM_BULK_MEMORY /* 3320 */:
      case V8_WASM_REF_TYPES /* 3321 */:
      case OBSOLETE_V8_WASM_MULTI_VALUE /* 3322 */:
      case HIDDEN_BACKFACE_WITH_POSSIBLE3_D /* 3323 */:
      case HIDDEN_BACKFACE_WITH_PRESERVE3_D /* 3324 */:
      case CSS_AT_RULE_SCROLL_TIMELINE /* 3325 */:
      case FETCH_UPLOAD_STREAMING /* 3326 */:
      case WEBKIT_LINE_CLAMP_WITHOUT_WEBKIT_BOX /* 3327 */:
      case WEB_BLUETOOTH_GET_DEVICES /* 3328 */:
      case DIALOG_WITH_NON_ZERO_SCROLL_OFFSET /* 3329 */:
      case DIALOG_HEIGHT_LARGER_THAN_VIEWPORT /* 3330 */:
      case OVERLAY_POPUP /* 3331 */:
      case CONTENT_VISIBILITY_AUTO /* 3332 */:
      case CONTENT_VISIBILITY_HIDDEN /* 3333 */:
      case CONTENT_VISIBILITY_HIDDEN_MATCHABLE /* 3334 */:
      case INLINE_OVERFLOW_AUTO_WITH_INLINE_END_PADDING /* 3335 */:
      case INLINE_OVERFLOW_SCROLL_WITH_INLINE_END_PADDING /* 3336 */:
      case SERIAL_PORT_GET_INFO /* 3338 */:
      case FILE_SYSTEM_PICKER_METHOD /* 3339 */:
      case V8_WINDOW_SHOW_OPEN_FILE_PICKER_METHOD /* 3340 */:
      case V8_WINDOW_SHOW_SAVE_FILE_PICKER_METHOD /* 3341 */:
      case V8_WINDOW_SHOW_DIRECTORY_PICKER_METHOD /* 3342 */:
      case OBSOLETE_RTC_CONSTRAINT_ENABLE_RTP_DATA_CHANNELS_TRUE /* 3344 */:
      case OBSOLETE_RTC_CONSTRAINT_ENABLE_RTP_DATA_CHANNELS_FALSE /* 3345 */:
      case FILE_SYSTEM_ACCESS_DRAG_AND_DROP /* 3346 */:
      case RTC_ADAPTIVE_PTIME /* 3347 */:
      case HTML_META_ELEMENT_REFERRER_POLICY_MULTIPLE_TOKENS_AFFECTING_REQUEST /* 3348 */:
      case NAVIGATION_TIMING_L2 /* 3349 */:
      case RESOURCE_TIMING /* 3350 */:
      case V8_POINTER_EVENT_AZIMUTH_ANGLE_ATTRIBUTE_GETTER /* 3351 */:
      case V8_POINTER_EVENT_ALTITUDE_ANGLE_ATTRIBUTE_GETTER /* 3352 */:
      case CROSS_BROWSING_CONTEXT_GROUP_MAIN_FRAME_NULLED_NON_EMPTY_NAME_ACCESSED /* 3353 */:
      case POSITION_STICKY /* 3354 */:
      case OBSOLETE_COMMA_SEPARATOR_IN_ALLOW_ATTRIBUTE /* 3355 */:
      case MAIN_FRAME_CSP_VIA_HTTP /* 3359 */:
      case MAIN_FRAME_CSP_VIA_META /* 3360 */:
      case OBSOLETE_MAIN_FRAME_CSP_VIA_ORIGIN_POLICY /* 3361 */:
      case HTML_CLIPBOARD_API_READ /* 3362 */:
      case HTML_CLIPBOARD_API_WRITE /* 3363 */:
      case OBSOLETE_CSS_SYSTEM_COLOR_COMPUTE_TO_SELF /* 3364 */:
      case ATTRIBUTION_REPORTING_API_ALL /* 3365 */:
      case OBSOLETE_IMPRESSION_REGISTRATION /* 3366 */:
      case OBSOLETE_CONVERSION_REGISTRATION /* 3367 */:
      case WEB_SHARE_POLICY_ALLOW /* 3368 */:
      case WEB_SHARE_POLICY_DISALLOW /* 3369 */:
      case FORM_ASSOCIATED_CUSTOM_ELEMENT /* 3370 */:
      case WINDOW_CLOSED /* 3371 */:
      case WRONG_BASELINE_OF_MULTI_LINE_BUTTON /* 3372 */:
      case WRONG_BASELINE_OF_EMPTY_LINE_BUTTON /* 3373 */:
      case V8RTC_RTP_TRANSCEIVER_STOPPED_ATTRIBUTE_GETTER /* 3374 */:
      case V8RTC_RTP_TRANSCEIVER_STOP_METHOD /* 3375 */:
      case SECURE_PAYMENT_CONFIRMATION /* 3376 */:
      case OBSOLETE_CSS_INVALID_VARIABLE_UNSET /* 3377 */:
      case ELEMENT_INTERNALS_SHADOW_ROOT /* 3378 */:
      case USER_DATA_FIELD_FILLED_PREDICTED_TYPE_MATCH /* 3379 */:
      case EMAIL_FIELD_FILLED_PREDICTED_TYPE_MATCH /* 3380 */:
      case PHONE_FIELD_FILLED_PREDICTED_TYPE_MATCH /* 3381 */:
      case EMAIL_FIELD_FILLED_PATTERN_MATCH /* 3382 */:
      case OBSOLETE_LAST_LETTER_SPACING_AFFECTS_RENDERING /* 3383 */:
      case V8_FONT_DATA_GET_TABLES_METHOD /* 3384 */:
      case V8_FONT_DATA_BLOB_METHOD /* 3385 */:
      case OBSOLETE_V8_FONT_MANAGER_QUERY_METHOD /* 3386 */:
      case AUDIO_CONTEXT_BASE_LATENCY /* 3387 */:
      case V8_WINDOW_GET_SCREEN_DETAILS_METHOD /* 3388 */:
      case OBSOLETE_V8_WINDOW_IS_MULTI_SCREEN_METHOD /* 3389 */:
      case OBSOLETE_V8_WINDOW_ONSCREENSCHANGE_ATTRIBUTE_GETTER /* 3390 */:
      case OBSOLETE_V8_WINDOW_ONSCREENSCHANGE_ATTRIBUTE_SETTER /* 3391 */:
      case DOM_WINDOW_OPEN_POSITIONING_FEATURES_CROSS_SCREEN /* 3392 */:
      case DOM_WINDOW_SET_WINDOW_RECT_CROSS_SCREEN /* 3393 */:
      case FULLSCREEN_CROSS_SCREEN /* 3394 */:
      case OBSOLETE_BATTERY_SAVINGS_META /* 3395 */:
      case DIGITAL_GOODS_GET_DIGITAL_GOODS_SERVICE /* 3396 */:
      case DIGITAL_GOODS_GET_DETAILS /* 3397 */:
      case DIGITAL_GOODS_ACKNOWLEDGE /* 3398 */:
      case MEDIA_RECORDER_MIME_TYPE /* 3399 */:
      case MEDIA_RECORDER_VIDEO_BITS_PER_SECOND /* 3400 */:
      case MEDIA_RECORDER_AUDIO_BITS_PER_SECOND /* 3401 */:
      case OBSOLETE_BLUETOOTH_REMOTE_GATT_CHARACTERISTIC_UUID /* 3402 */:
      case OBSOLETE_BLUETOOTH_REMOTE_GATT_DESCRIPTOR_UUID /* 3403 */:
      case OBSOLETE_BLUETOOTH_REMOTE_GATT_SERVICE_UUID /* 3404 */:
      case GPU_ADAPTER_NAME /* 3405 */:
      case OBSOLETE_WINDOW_SCREEN_INTERNAL /* 3406 */:
      case OBSOLETE_WINDOW_SCREEN_PRIMARY /* 3407 */:
      case THIRD_PARTY_COOKIE_READ /* 3408 */:
      case THIRD_PARTY_COOKIE_WRITE /* 3409 */:
      case RTC_LEGACY_RTP_DATA_CHANNEL_NEGOTIATED /* 3410 */:
      case CROSS_SITE_POST_MESSAGE /* 3411 */:
      case SCHEMELESSLY_SAME_SITE_POST_MESSAGE /* 3412 */:
      case SCHEMEFUL_SAME_SITE_POST_MESSAGE /* 3413 */:
      case UNSPECIFIED_TARGET_ORIGIN_POST_MESSAGE /* 3414 */:
      case SCHEMELESSLY_SAME_SITE_POST_MESSAGE_SECURE_TO_INSECURE /* 3415 */:
      case SCHEMELESSLY_SAME_SITE_POST_MESSAGE_INSECURE_TO_SECURE /* 3416 */:
      case OBSOLETE_BCP_BROADCAST /* 3417 */:
      case OBSOLETE_BCP_READ /* 3418 */:
      case OBSOLETE_BCP_WRITE_WITHOUT_RESPONSE /* 3419 */:
      case OBSOLETE_BCP_WRITE /* 3420 */:
      case OBSOLETE_BCP_NOTIFY /* 3421 */:
      case OBSOLETE_BCP_INDICATE /* 3422 */:
      case OBSOLETE_BCP_AUTHENTICATED_SIGNED_WRITES /* 3423 */:
      case OBSOLETE_BCP_RELIABLE_WRITE /* 3424 */:
      case OBSOLETE_BCP_WRITABLE_AUXILIARIES /* 3425 */:
      case TEXT_ALIGN_SPECIFIED_TO_LEGEND /* 3426 */:
      case V8_DOCUMENT_FRAGMENT_DIRECTIVE_ATTRIBUTE_GETTER /* 3427 */:
      case V8_STORAGE_MANAGER_GET_DIRECTORY_METHOD /* 3428 */:
      case BEFOREMATCH_HANDLER_REGISTERED /* 3429 */:
      case BLUETOOTH_ADVERTISING_EVENT_NAME /* 3430 */:
      case BLUETOOTH_ADVERTISING_EVENT_APPEARANCE /* 3431 */:
      case BLUETOOTH_ADVERTISING_EVENT_TX_POWER /* 3432 */:
      case CROSS_ORIGIN_OPENER_POLICY_REPORTING /* 3433 */:
      case GAMEPAD_ID /* 3434 */:
      case ELEMENT_ATTACH_INTERNALS /* 3435 */:
      case BLUETOOTH_DEVICE_NAME /* 3436 */:
      case RTC_ICE_CANDIDATE_ADDRESS /* 3437 */:
      case RTC_ICE_CANDIDATE_CANDIDATE /* 3438 */:
      case RTC_ICE_CANDIDATE_PORT /* 3439 */:
      case RTC_ICE_CANDIDATE_RELATED_ADDRESS /* 3440 */:
      case RTC_ICE_CANDIDATE_RELATED_PORT /* 3441 */:
      case SLOT_ASSIGN_NODE /* 3442 */:
      case PLUGIN_NAME /* 3443 */:
      case PLUGIN_FILENAME /* 3444 */:
      case PLUGIN_DESCRIPTION /* 3445 */:
      case OBSOLETE_SUBRESOURCE_WEB_BUNDLES /* 3446 */:
      case RTC_PEER_CONNECTION_SET_REMOTE_DESCRIPTION_PROMISE /* 3447 */:
      case RTC_PEER_CONNECTION_SET_LOCAL_DESCRIPTION_PROMISE /* 3448 */:
      case RTC_PEER_CONNECTION_CREATE_OFFER_PROMISE /* 3449 */:
      case RTC_PEER_CONNECTION_CREATE_ANSWER_PROMISE /* 3450 */:
      case RTC_PEER_CONNECTION_SET_REMOTE_DESCRIPTION /* 3451 */:
      case RTC_PEER_CONNECTION_SET_LOCAL_DESCRIPTION /* 3452 */:
      case RTC_PEER_CONNECTION_CREATE_OFFER /* 3453 */:
      case RTC_PEER_CONNECTION_CREATE_ANSWER /* 3454 */:
      case V8_AUTHENTICATOR_ATTESTATION_RESPONSE_GET_TRANSPORTS_METHOD /* 3455 */:
      case WEB_CODECS_AUDIO_DECODER /* 3456 */:
      case WEB_CODECS_VIDEO_DECODER /* 3457 */:
      case WEB_CODECS_VIDEO_ENCODER /* 3458 */:
      case WEB_CODECS_VIDEO_TRACK_READER /* 3459 */:
      case WEB_CODECS_IMAGE_DECODER /* 3460 */:
      case BACK_FORWARD_CACHE_EXPERIMENT_HTTP_HEADER /* 3461 */:
      case V8_NAVIGATOR_OPEN_TCP_SOCKET_METHOD /* 3462 */:
      case V8_NAVIGATOR_OPEN_UDP_SOCKET_METHOD /* 3463 */:
      case WEB_CODECS /* 3464 */:
      case CREDENTIAL_MANAGER_CROSS_ORIGIN_PUBLIC_KEY_GET_REQUEST /* 3465 */:
      case CSS_CONTAIN_STRICT_WITHOUT_CONTENT_VISIBILITY /* 3466 */:
      case CSS_CONTAIN_ALL_WITHOUT_CONTENT_VISIBILITY /* 3467 */:
      case TIMER_INSTALL_FROM_BEFORE_UNLOAD /* 3468 */:
      case TIMER_INSTALL_FROM_UNLOAD /* 3469 */:
      case OBSOLETE_ELEMENT_ATTACH_INTERNALS_BEFORE_CONSTRUCTOR /* 3470 */:
      case SMIL_ELEMENT_HAS_REPEAT_N_EVENT_LISTENER /* 3471 */:
      case WEB_TRANSPORT /* 3472 */:
      case IDLE_DETECTION_PERMISSION_REQUESTED /* 3477 */:
      case IDENTIFIABILITY_STUDY_RESERVED3478 /* 3478 */:
      case SPEECH_SYNTHESIS_GET_VOICES_METHOD /* 3479 */:
      case IDENTIFIABILITY_STUDY_RESERVED3480 /* 3480 */:
      case V8_NAVIGATOR_JAVA_ENABLED_METHOD /* 3481 */:
      case IDENTIFIABILITY_STUDY_RESERVED3482 /* 3482 */:
      case IDENTIFIABILITY_STUDY_RESERVED3483 /* 3483 */:
      case IDENTIFIABILITY_STUDY_RESERVED3484 /* 3484 */:
      case IDENTIFIABILITY_STUDY_RESERVED3485 /* 3485 */:
      case IDENTIFIABILITY_STUDY_RESERVED3486 /* 3486 */:
      case IDENTIFIABILITY_STUDY_RESERVED3487 /* 3487 */:
      case IDENTIFIABILITY_STUDY_RESERVED3488 /* 3488 */:
      case IDENTIFIABILITY_STUDY_RESERVED3489 /* 3489 */:
      case IDENTIFIABILITY_STUDY_RESERVED3490 /* 3490 */:
      case IDENTIFIABILITY_STUDY_RESERVED3491 /* 3491 */:
      case IDENTIFIABILITY_STUDY_RESERVED3492 /* 3492 */:
      case IDENTIFIABILITY_STUDY_RESERVED3493 /* 3493 */:
      case IDENTIFIABILITY_STUDY_RESERVED3494 /* 3494 */:
      case IDENTIFIABILITY_STUDY_RESERVED3495 /* 3495 */:
      case IDENTIFIABILITY_STUDY_RESERVED3496 /* 3496 */:
      case IDENTIFIABILITY_STUDY_RESERVED3497 /* 3497 */:
      case IDENTIFIABILITY_STUDY_RESERVED3498 /* 3498 */:
      case V8_BACKGROUND_FETCH_REGISTRATION_FAILURE_REASON_ATTRIBUTE_GETTER /* 3499 */:
      case V8_DOCUMENT_ELEMENT_FROM_POINT_METHOD /* 3500 */:
      case V8_DOCUMENT_ELEMENTS_FROM_POINT_METHOD /* 3501 */:
      case V8_SHADOW_ROOT_ELEMENT_FROM_POINT_METHOD /* 3502 */:
      case V8_SHADOW_ROOT_ELEMENTS_FROM_POINT_METHOD /* 3503 */:
      case OBSOLETE_WINDOW_SCREEN_TOUCH_SUPPORT /* 3504 */:
      case IDENTIFIABILITY_STUDY_RESERVED3505 /* 3505 */:
      case IDENTIFIABILITY_STUDY_RESERVED3506 /* 3506 */:
      case V8_PUSH_MANAGER_SUPPORTED_CONTENT_ENCODINGS_ATTRIBUTE_GETTER /* 3507 */:
      case IDENTIFIABILITY_STUDY_RESERVED3508 /* 3508 */:
      case V8RTC_RTP_RECEIVER_GET_CAPABILITIES_METHOD /* 3509 */:
      case V8RTC_RTP_SENDER_GET_CAPABILITIES_METHOD /* 3510 */:
      case IDENTIFIABILITY_STUDY_RESERVED3511 /* 3511 */:
      case IDENTIFIABILITY_STUDY_RESERVED3512 /* 3512 */:
      case IDENTIFIABILITY_STUDY_RESERVED3513 /* 3513 */:
      case IDENTIFIABILITY_STUDY_RESERVED3514 /* 3514 */:
      case IDENTIFIABILITY_STUDY_RESERVED3515 /* 3515 */:
      case IDENTIFIABILITY_STUDY_RESERVED3516 /* 3516 */:
      case IDENTIFIABILITY_STUDY_RESERVED3517 /* 3517 */:
      case IDENTIFIABILITY_STUDY_RESERVED3518 /* 3518 */:
      case IDENTIFIABILITY_STUDY_RESERVED3519 /* 3519 */:
      case IDENTIFIABILITY_STUDY_RESERVED3520 /* 3520 */:
      case IDENTIFIABILITY_STUDY_RESERVED3521 /* 3521 */:
      case IDENTIFIABILITY_STUDY_RESERVED3522 /* 3522 */:
      case IDENTIFIABILITY_STUDY_RESERVED3523 /* 3523 */:
      case IDENTIFIABILITY_STUDY_RESERVED3524 /* 3524 */:
      case IDENTIFIABILITY_STUDY_RESERVED3525 /* 3525 */:
      case IDENTIFIABILITY_STUDY_RESERVED3526 /* 3526 */:
      case IDENTIFIABILITY_STUDY_RESERVED3527 /* 3527 */:
      case IDENTIFIABILITY_STUDY_RESERVED3528 /* 3528 */:
      case IDENTIFIABILITY_STUDY_RESERVED3529 /* 3529 */:
      case IDENTIFIABILITY_STUDY_RESERVED3530 /* 3530 */:
      case IDENTIFIABILITY_STUDY_RESERVED3531 /* 3531 */:
      case IDENTIFIABILITY_STUDY_RESERVED3532 /* 3532 */:
      case IDENTIFIABILITY_STUDY_RESERVED3533 /* 3533 */:
      case IDENTIFIABILITY_STUDY_RESERVED3534 /* 3534 */:
      case IDENTIFIABILITY_STUDY_RESERVED3535 /* 3535 */:
      case IDENTIFIABILITY_STUDY_RESERVED3536 /* 3536 */:
      case IDENTIFIABILITY_STUDY_RESERVED3537 /* 3537 */:
      case IDENTIFIABILITY_STUDY_RESERVED3538 /* 3538 */:
      case IDENTIFIABILITY_STUDY_RESERVED3539 /* 3539 */:
      case IDENTIFIABILITY_STUDY_RESERVED3540 /* 3540 */:
      case V8_WHEEL_EVENT_DELTA_MODE_ATTRIBUTE_GETTER /* 3541 */:
      case V8_TOUCH_FORCE_ATTRIBUTE_GETTER /* 3542 */:
      case WEB_GL_RENDERING_CONTEXT_MAKE_XR_COMPATIBLE /* 3543 */:
      case V8_WEB_GL_COMPRESSED_TEXTURE_ASTC_GET_SUPPORTED_PROFILES_METHOD /* 3544 */:
      case HTML_CANVAS_GET_CONTEXT /* 3545 */:
      case V8_BEFORE_INSTALL_PROMPT_EVENT_PLATFORMS_ATTRIBUTE_GETTER /* 3546 */:
      case IDENTIFIABILITY_STUDY_RESERVED3547 /* 3547 */:
      case IDENTIFIABILITY_STUDY_RESERVED3548 /* 3548 */:
      case IDENTIFIABILITY_STUDY_RESERVED3549 /* 3549 */:
      case IDENTIFIABILITY_STUDY_RESERVED3550 /* 3550 */:
      case IDENTIFIABILITY_STUDY_RESERVED3551 /* 3551 */:
      case IDENTIFIABILITY_STUDY_RESERVED3552 /* 3552 */:
      case IDENTIFIABILITY_STUDY_RESERVED3553 /* 3553 */:
      case IDENTIFIABILITY_STUDY_RESERVED3554 /* 3554 */:
      case IDENTIFIABILITY_STUDY_RESERVED3555 /* 3555 */:
      case IDENTIFIABILITY_STUDY_RESERVED3556 /* 3556 */:
      case IDENTIFIABILITY_STUDY_RESERVED3557 /* 3557 */:
      case IDENTIFIABILITY_STUDY_RESERVED3558 /* 3558 */:
      case IDENTIFIABILITY_STUDY_RESERVED3559 /* 3559 */:
      case IDENTIFIABILITY_STUDY_RESERVED3560 /* 3560 */:
      case IDENTIFIABILITY_STUDY_RESERVED3561 /* 3561 */:
      case IDENTIFIABILITY_STUDY_RESERVED3562 /* 3562 */:
      case IDENTIFIABILITY_STUDY_RESERVED3563 /* 3563 */:
      case IDENTIFIABILITY_STUDY_RESERVED3564 /* 3564 */:
      case IDENTIFIABILITY_STUDY_RESERVED3565 /* 3565 */:
      case V8_BASE_AUDIO_CONTEXT_SAMPLE_RATE_ATTRIBUTE_GETTER /* 3566 */:
      case OBSOLETE_WINDOW_SCREEN_ID /* 3567 */:
      case WEB_GL_RENDERING_CONTEXT_GET_PARAMETER /* 3568 */:
      case WEB_GL_RENDERING_CONTEXT_GET_RENDERBUFFER_PARAMETER /* 3569 */:
      case WEB_GL_RENDERING_CONTEXT_GET_SHADER_PRECISION_FORMAT /* 3570 */:
      case WEB_GL2_RENDERING_CONTEXT_GET_INTERNAL_FORMAT_PARAMETER /* 3571 */:
      case IDENTIFIABILITY_STUDY_RESERVED3572 /* 3572 */:
      case IDENTIFIABILITY_STUDY_RESERVED3573 /* 3573 */:
      case IDENTIFIABILITY_STUDY_RESERVED3574 /* 3574 */:
      case IDENTIFIABILITY_STUDY_RESERVED3575 /* 3575 */:
      case IDENTIFIABILITY_STUDY_RESERVED3576 /* 3576 */:
      case IDENTIFIABILITY_STUDY_RESERVED3577 /* 3577 */:
      case CASCADED_CSS_ZOOM_NOT_EQUAL_TO_ONE /* 3578 */:
      case FORCED_DARK_MODE /* 3579 */:
      case PREFERRED_COLOR_SCHEME_DARK /* 3580 */:
      case PREFERRED_COLOR_SCHEME_DARK_SETTING /* 3581 */:
      case IDENTIFIABILITY_MEDIA_DEVICES_ENUMERATE_DEVICES /* 3582 */:
      case IDENTIFIABILITY_STUDY_RESERVED3583 /* 3583 */:
      case IDENTIFIABILITY_STUDY_RESERVED3584 /* 3584 */:
      case IDENTIFIABILITY_STUDY_RESERVED3585 /* 3585 */:
      case IDENTIFIABILITY_STUDY_RESERVED3586 /* 3586 */:
      case IDENTIFIABILITY_STUDY_RESERVED3587 /* 3587 */:
      case IDENTIFIABILITY_STUDY_RESERVED3588 /* 3588 */:
      case IDENTIFIABILITY_STUDY_RESERVED3589 /* 3589 */:
      case IDENTIFIABILITY_STUDY_RESERVED3590 /* 3590 */:
      case IDENTIFIABILITY_STUDY_RESERVED3591 /* 3591 */:
      case IDENTIFIABILITY_STUDY_RESERVED3592 /* 3592 */:
      case IDENTIFIABILITY_STUDY_RESERVED3593 /* 3593 */:
      case IDENTIFIABILITY_STUDY_RESERVED3594 /* 3594 */:
      case IDENTIFIABILITY_STUDY_RESERVED3595 /* 3595 */:
      case IDENTIFIABILITY_STUDY_RESERVED3596 /* 3596 */:
      case IDENTIFIABILITY_STUDY_RESERVED3597 /* 3597 */:
      case IDENTIFIABILITY_STUDY_RESERVED3598 /* 3598 */:
      case IDENTIFIABILITY_STUDY_RESERVED3599 /* 3599 */:
      case IDENTIFIABILITY_STUDY_RESERVED3600 /* 3600 */:
      case IDENTIFIABILITY_STUDY_RESERVED3601 /* 3601 */:
      case IDENTIFIABILITY_STUDY_RESERVED3602 /* 3602 */:
      case IDENTIFIABILITY_STUDY_RESERVED3603 /* 3603 */:
      case IDENTIFIABILITY_STUDY_RESERVED3604 /* 3604 */:
      case IDENTIFIABILITY_STUDY_RESERVED3605 /* 3605 */:
      case IDENTIFIABILITY_STUDY_RESERVED3606 /* 3606 */:
      case IDENTIFIABILITY_STUDY_RESERVED3607 /* 3607 */:
      case IDENTIFIABILITY_STUDY_RESERVED3608 /* 3608 */:
      case IDENTIFIABILITY_STUDY_RESERVED3609 /* 3609 */:
      case BARCODE_DETECTOR_GET_SUPPORTED_FORMATS /* 3610 */:
      case IDENTIFIABILITY_STUDY_RESERVED3611 /* 3611 */:
      case IDENTIFIABILITY_STUDY_RESERVED3612 /* 3612 */:
      case IDENTIFIABILITY_STUDY_RESERVED3613 /* 3613 */:
      case IDENTIFIABILITY_STUDY_RESERVED3614 /* 3614 */:
      case IDENTIFIABILITY_STUDY_RESERVED3615 /* 3615 */:
      case IDENTIFIABILITY_STUDY_RESERVED3616 /* 3616 */:
      case IDENTIFIABILITY_STUDY_RESERVED3617 /* 3617 */:
      case IDENTIFIABILITY_STUDY_RESERVED3618 /* 3618 */:
      case IDENTIFIABILITY_STUDY_RESERVED3619 /* 3619 */:
      case IDENTIFIABILITY_STUDY_RESERVED3620 /* 3620 */:
      case IDENTIFIABILITY_STUDY_RESERVED3621 /* 3621 */:
      case IDENTIFIABILITY_STUDY_RESERVED3622 /* 3622 */:
      case IDENTIFIABILITY_STUDY_RESERVED3623 /* 3623 */:
      case IDENTIFIABILITY_STUDY_RESERVED3624 /* 3624 */:
      case IDENTIFIABILITY_STUDY_RESERVED3625 /* 3625 */:
      case IDENTIFIABILITY_STUDY_RESERVED3626 /* 3626 */:
      case IDENTIFIABILITY_STUDY_RESERVED3627 /* 3627 */:
      case IDENTIFIABILITY_STUDY_RESERVED3628 /* 3628 */:
      case IDENTIFIABILITY_STUDY_RESERVED3629 /* 3629 */:
      case IDENTIFIABILITY_STUDY_RESERVED3630 /* 3630 */:
      case IDENTIFIABILITY_STUDY_RESERVED3631 /* 3631 */:
      case IDENTIFIABILITY_STUDY_RESERVED3632 /* 3632 */:
      case IDENTIFIABILITY_STUDY_RESERVED3633 /* 3633 */:
      case IDENTIFIABILITY_STUDY_RESERVED3634 /* 3634 */:
      case IDENTIFIABILITY_STUDY_RESERVED3635 /* 3635 */:
      case IDENTIFIABILITY_STUDY_RESERVED3636 /* 3636 */:
      case IDENTIFIABILITY_STUDY_RESERVED3637 /* 3637 */:
      case IDENTIFIABILITY_STUDY_RESERVED3638 /* 3638 */:
      case IDENTIFIABILITY_STUDY_RESERVED3639 /* 3639 */:
      case IDENTIFIABILITY_STUDY_RESERVED3640 /* 3640 */:
      case IDENTIFIABILITY_STUDY_RESERVED3641 /* 3641 */:
      case IDENTIFIABILITY_STUDY_RESERVED3642 /* 3642 */:
      case IDENTIFIABILITY_STUDY_RESERVED3643 /* 3643 */:
      case IDENTIFIABILITY_STUDY_RESERVED3644 /* 3644 */:
      case IDENTIFIABILITY_STUDY_RESERVED3645 /* 3645 */:
      case IDENTIFIABILITY_STUDY_RESERVED3646 /* 3646 */:
      case IDENTIFIABILITY_STUDY_RESERVED3647 /* 3647 */:
      case IDENTIFIABILITY_STUDY_RESERVED3648 /* 3648 */:
      case IDENTIFIABILITY_STUDY_RESERVED3649 /* 3649 */:
      case IDENTIFIABILITY_STUDY_RESERVED3650 /* 3650 */:
      case IDENTIFIABILITY_STUDY_RESERVED3651 /* 3651 */:
      case IDENTIFIABILITY_STUDY_RESERVED3652 /* 3652 */:
      case IDENTIFIABILITY_STUDY_RESERVED3653 /* 3653 */:
      case IDENTIFIABILITY_STUDY_RESERVED3654 /* 3654 */:
      case IDENTIFIABILITY_STUDY_RESERVED3655 /* 3655 */:
      case IDENTIFIABILITY_STUDY_RESERVED3656 /* 3656 */:
      case IDENTIFIABILITY_STUDY_RESERVED3657 /* 3657 */:
      case IDENTIFIABILITY_STUDY_RESERVED3658 /* 3658 */:
      case IDENTIFIABILITY_STUDY_RESERVED3659 /* 3659 */:
      case IDENTIFIABILITY_STUDY_RESERVED3660 /* 3660 */:
      case IDENTIFIABILITY_STUDY_RESERVED3661 /* 3661 */:
      case IDENTIFIABILITY_STUDY_RESERVED3662 /* 3662 */:
      case IDENTIFIABILITY_STUDY_RESERVED3663 /* 3663 */:
      case IDENTIFIABILITY_STUDY_RESERVED3664 /* 3664 */:
      case IDENTIFIABILITY_STUDY_RESERVED3665 /* 3665 */:
      case IDENTIFIABILITY_STUDY_RESERVED3666 /* 3666 */:
      case IDENTIFIABILITY_STUDY_RESERVED3667 /* 3667 */:
      case IDENTIFIABILITY_STUDY_RESERVED3668 /* 3668 */:
      case IDENTIFIABILITY_STUDY_RESERVED3669 /* 3669 */:
      case IDENTIFIABILITY_STUDY_RESERVED3670 /* 3670 */:
      case IDENTIFIABILITY_STUDY_RESERVED3671 /* 3671 */:
      case IDENTIFIABILITY_STUDY_RESERVED3672 /* 3672 */:
      case IDENTIFIABILITY_STUDY_RESERVED3673 /* 3673 */:
      case IDENTIFIABILITY_STUDY_RESERVED3674 /* 3674 */:
      case IDENTIFIABILITY_STUDY_RESERVED3675 /* 3675 */:
      case IDENTIFIABILITY_STUDY_RESERVED3676 /* 3676 */:
      case IDENTIFIABILITY_STUDY_RESERVED3677 /* 3677 */:
      case IDENTIFIABILITY_STUDY_RESERVED3678 /* 3678 */:
      case IDENTIFIABILITY_STUDY_RESERVED3679 /* 3679 */:
      case IDENTIFIABILITY_STUDY_RESERVED3680 /* 3680 */:
      case IDENTIFIABILITY_STUDY_RESERVED3681 /* 3681 */:
      case UNDEFERRABLE_THIRD_PARTY_SUBRESOURCE_REQUEST_WITH_COOKIE /* 3682 */:
      case XR_DEPTH_SENSING /* 3683 */:
      case XR_FRAME_GET_DEPTH_INFORMATION /* 3684 */:
      case XRCPU_DEPTH_INFORMATION_GET_DEPTH /* 3685 */:
      case XRCPU_DEPTH_INFORMATION_DATA_ATTRIBUTE /* 3686 */:
      case OBSOLETE_INTEREST_COHORT_API_INTEREST_COHORT_METHOD /* 3687 */:
      case OBSOLETE_ADDRESS_SPACE_LOCAL_EMBEDDED_IN_PRIVATE_SECURE_CONTEXT /* 3688 */:
      case OBSOLETE_ADDRESS_SPACE_LOCAL_EMBEDDED_IN_PRIVATE_NON_SECURE_CONTEXT /* 3689 */:
      case OBSOLETE_ADDRESS_SPACE_LOCAL_EMBEDDED_IN_PUBLIC_SECURE_CONTEXT /* 3690 */:
      case OBSOLETE_ADDRESS_SPACE_LOCAL_EMBEDDED_IN_PUBLIC_NON_SECURE_CONTEXT /* 3691 */:
      case OBSOLETE_ADDRESS_SPACE_LOCAL_EMBEDDED_IN_UNKNOWN_SECURE_CONTEXT /* 3692 */:
      case OBSOLETE_ADDRESS_SPACE_LOCAL_EMBEDDED_IN_UNKNOWN_NON_SECURE_CONTEXT /* 3693 */:
      case OBSOLETE_ADDRESS_SPACE_PRIVATE_EMBEDDED_IN_PUBLIC_SECURE_CONTEXT /* 3694 */:
      case OBSOLETE_ADDRESS_SPACE_PRIVATE_EMBEDDED_IN_PUBLIC_NON_SECURE_CONTEXT /* 3695 */:
      case OBSOLETE_ADDRESS_SPACE_PRIVATE_EMBEDDED_IN_UNKNOWN_SECURE_CONTEXT /* 3696 */:
      case OBSOLETE_ADDRESS_SPACE_PRIVATE_EMBEDDED_IN_UNKNOWN_NON_SECURE_CONTEXT /* 3697 */:
      case THIRD_PARTY_ACCESS /* 3698 */:
      case THIRD_PARTY_ACTIVATION /* 3699 */:
      case THIRD_PARTY_ACCESS_AND_ACTIVATION /* 3700 */:
      case FULLSCREEN_ALLOWED_BY_SCREENS_CHANGE /* 3701 */:
      case NEW_LAYOUT_OVERFLOW_DIFFERENT_BLOCK /* 3702 */:
      case NEW_LAYOUT_OVERFLOW_DIFFERENT_FLEX /* 3703 */:
      case NEW_LAYOUT_OVERFLOW_DIFFERENT_AND_ALREADY_SCROLLS_BLOCK /* 3704 */:
      case NEW_LAYOUT_OVERFLOW_DIFFERENT_AND_ALREADY_SCROLLS_FLEX /* 3705 */:
      case UNICODE_BIDI_PLAIN_TEXT /* 3706 */:
      case COLOR_SCHEME_DARK_SUPPORTED_ON_ROOT /* 3707 */:
      case WEB_BLUETOOTH_GET_AVAILABILITY /* 3708 */:
      case DIGITAL_GOODS_LIST_PURCHASES /* 3709 */:
      case COMPOSITED_SVG /* 3710 */:
      case BARCODE_DETECTOR_DETECT /* 3711 */:
      case FACE_DETECTOR_DETECT /* 3712 */:
      case TEXT_DETECTOR_DETECT /* 3713 */:
      case OBSOLETE_LOCAL_STORAGE_FIRST_USED_BEFORE_FCP /* 3714 */:
      case OBSOLETE_LOCAL_STORAGE_FIRST_USED_AFTER_FCP /* 3715 */:
      case OBSOLETE_CSS_PSEUDO_HOST_COMPOUND_LIST /* 3716 */:
      case OBSOLETE_CSS_PSEUDO_HOST_CONTEXT_COMPOUND_LIST /* 3717 */:
      case OBSOLETE_CSS_PSEUDO_HOST_DYNAMIC_SPECIFICITY /* 3718 */:
      case OBSOLETE_GET_CURRENT_BROWSING_CONTEXT_MEDIA /* 3719 */:
      case MOUSE_EVENT_RELATIVE_POSITION_FOR_INLINE_ELEMENT /* 3720 */:
      case V8_SHARED_ARRAY_BUFFER_CONSTRUCTED_WITHOUT_ISOLATION /* 3721 */:
      case V8HTML_VIDEO_ELEMENT_GET_VIDEO_PLAYBACK_QUALITY_METHOD /* 3722 */:
      case XR_WEB_GL_BINDING_GET_REFLECTION_CUBE_MAP /* 3723 */:
      case XR_FRAME_GET_LIGHT_ESTIMATE /* 3724 */:
      case V8HTML_DIALOG_ELEMENT_SHOW_METHOD /* 3725 */:
      case V8HTML_DIALOG_ELEMENT_SHOW_MODAL_METHOD /* 3726 */:
      case AD_FRAME_DETECTED /* 3727 */:
      case MEDIA_STREAM_TRACK_GENERATOR /* 3728 */:
      case MEDIA_STREAM_TRACK_PROCESSOR /* 3729 */:
      case ADD_EVENT_LISTENER_WITH_ABORT_SIGNAL /* 3730 */:
      case XR_SESSION_REQUEST_LIGHT_PROBE /* 3731 */:
      case BEFOREMATCH_REVEALED_HIDDEN_MATCHABLE /* 3732 */:
      case ADD_SOURCE_BUFFER_USING_CONFIG /* 3733 */:
      case CHANGE_TYPE_USING_CONFIG /* 3734 */:
      case V8_SOURCE_BUFFER_APPEND_ENCODED_CHUNKS_METHOD /* 3735 */:
      case OVERSROLL_BEHAVIOR_ON_VIEWPORT_BREAKS /* 3736 */:
      case SAME_ORIGIN_JSON_TYPE_FOR_SCRIPT /* 3737 */:
      case CROSS_ORIGIN_JSON_TYPE_FOR_SCRIPT /* 3738 */:
      case SAME_ORIGIN_STRICT_NOSNIFF_WOULD_BLOCK /* 3739 */:
      case CROSS_ORIGIN_STRICT_NOSNIFF_WOULD_BLOCK /* 3740 */:
      case CSS_SELECTOR_PSEUDO_DIR /* 3741 */:
      case CROSS_ORIGIN_SUBFRAME_WITHOUT_EMBEDDING_CONTROL /* 3742 */:
      case READABLE_STREAM_WITH_BYTE_SOURCE /* 3743 */:
      case READABLE_STREAM_BYOB_READER /* 3744 */:
      case SAME_PARTY_COOKIE_ATTRIBUTE /* 3746 */:
      case SAME_PARTY_COOKIE_EXCLUSION_OVERRULED_SAME_SITE /* 3747 */:
      case SAME_PARTY_COOKIE_INCLUSION_OVERRULED_SAME_SITE /* 3748 */:
      case EMBED_ELEMENT_WITHOUT_TYPE_SRC_CHANGED /* 3749 */:
      case PAYMENT_HANDLER_STANDARDIZED_PAYMENT_METHOD_IDENTIFIER /* 3750 */:
      case WEB_CODECS_AUDIO_ENCODER /* 3751 */:
      case EMBEDDED_CROSS_ORIGIN_FRAME_WITHOUT_FRAME_ANCESTORS_OR_XFO /* 3752 */:
      case ADDRESS_SPACE_PRIVATE_SECURE_CONTEXT_EMBEDDED_LOCAL /* 3753 */:
      case ADDRESS_SPACE_PRIVATE_NON_SECURE_CONTEXT_EMBEDDED_LOCAL /* 3754 */:
      case ADDRESS_SPACE_PUBLIC_SECURE_CONTEXT_EMBEDDED_LOCAL /* 3755 */:
      case ADDRESS_SPACE_PUBLIC_NON_SECURE_CONTEXT_EMBEDDED_LOCAL /* 3756 */:
      case ADDRESS_SPACE_PUBLIC_SECURE_CONTEXT_EMBEDDED_PRIVATE /* 3757 */:
      case ADDRESS_SPACE_PUBLIC_NON_SECURE_CONTEXT_EMBEDDED_PRIVATE /* 3758 */:
      case ADDRESS_SPACE_UNKNOWN_SECURE_CONTEXT_EMBEDDED_LOCAL /* 3759 */:
      case ADDRESS_SPACE_UNKNOWN_NON_SECURE_CONTEXT_EMBEDDED_LOCAL /* 3760 */:
      case ADDRESS_SPACE_UNKNOWN_SECURE_CONTEXT_EMBEDDED_PRIVATE /* 3761 */:
      case ADDRESS_SPACE_UNKNOWN_NON_SECURE_CONTEXT_EMBEDDED_PRIVATE /* 3762 */:
      case ADDRESS_SPACE_PRIVATE_SECURE_CONTEXT_NAVIGATED_TO_LOCAL /* 3763 */:
      case ADDRESS_SPACE_PRIVATE_NON_SECURE_CONTEXT_NAVIGATED_TO_LOCAL /* 3764 */:
      case ADDRESS_SPACE_PUBLIC_SECURE_CONTEXT_NAVIGATED_TO_LOCAL /* 3765 */:
      case ADDRESS_SPACE_PUBLIC_NON_SECURE_CONTEXT_NAVIGATED_TO_LOCAL /* 3766 */:
      case ADDRESS_SPACE_PUBLIC_SECURE_CONTEXT_NAVIGATED_TO_PRIVATE /* 3767 */:
      case ADDRESS_SPACE_PUBLIC_NON_SECURE_CONTEXT_NAVIGATED_TO_PRIVATE /* 3768 */:
      case ADDRESS_SPACE_UNKNOWN_SECURE_CONTEXT_NAVIGATED_TO_LOCAL /* 3769 */:
      case ADDRESS_SPACE_UNKNOWN_NON_SECURE_CONTEXT_NAVIGATED_TO_LOCAL /* 3770 */:
      case ADDRESS_SPACE_UNKNOWN_SECURE_CONTEXT_NAVIGATED_TO_PRIVATE /* 3771 */:
      case ADDRESS_SPACE_UNKNOWN_NON_SECURE_CONTEXT_NAVIGATED_TO_PRIVATE /* 3772 */:
      case OBSOLETE_RTC_PEER_CONNECTION_SDP_SEMANTICS_PLAN_B /* 3773 */:
      case FETCH_RESPOND_WITH_NO_RESPONSE_WITH_USED_REQUEST_BODY /* 3774 */:
      case V8TCP_SOCKET_CLOSE_METHOD /* 3775 */:
      case V8TCP_SOCKET_READABLE_ATTRIBUTE_GETTER /* 3776 */:
      case V8TCP_SOCKET_WRITABLE_ATTRIBUTE_GETTER /* 3777 */:
      case V8TCP_SOCKET_REMOTE_ADDRESS_ATTRIBUTE_GETTER /* 3778 */:
      case V8TCP_SOCKET_REMOTE_PORT_ATTRIBUTE_GETTER /* 3779 */:
      case CSS_SELECTOR_TARGET_TEXT /* 3780 */:
      case OBSOLETE_POPOVER_ATTRIBUTE /* 3781 */:
      case OBSOLETE_V8HTML_POPUP_ELEMENT_SHOW_METHOD /* 3782 */:
      case OBSOLETE_V8HTML_POPUP_ELEMENT_HIDE_METHOD /* 3783 */:
      case OBSOLETE_WINDOW_OPEN_WITH_ADDITIONAL_BOOL_PARAMETER /* 3784 */:
      case OBSOLETE_RTC_PEER_CONNECTION_CONSTRUCTED_WITH_PLAN_B /* 3785 */:
      case OBSOLETE_RTC_PEER_CONNECTION_CONSTRUCTED_WITH_UNIFIED_PLAN /* 3786 */:
      case OBSOLETE_RTC_PEER_CONNECTION_USING_COMPLEX_PLAN_B /* 3787 */:
      case OBSOLETE_RTC_PEER_CONNECTION_USING_COMPLEX_UNIFIED_PLAN /* 3788 */:
      case WINDOW_SCREEN_IS_EXTENDED /* 3789 */:
      case WINDOW_SCREEN_CHANGE /* 3790 */:
      case XR_WEB_GL_DEPTH_INFORMATION_TEXTURE_ATTRIBUTE /* 3791 */:
      case XR_WEB_GL_BINDING_GET_DEPTH_INFORMATION /* 3792 */:
      case OBSOLETE_SESSION_STORAGE_FIRST_USED_BEFORE_FCP /* 3793 */:
      case OBSOLETE_SESSION_STORAGE_FIRST_USED_AFTER_FCP /* 3794 */:
      case GRAVITY_SENSOR_CONSTRUCTOR /* 3795 */:
      case ELEMENT_INTERNALS_STATES /* 3796 */:
      case WEB_P_IMAGE /* 3797 */:
      case AVIF_IMAGE /* 3798 */:
      case SVG_TEXT_EDITED /* 3799 */:
      case V8_WASM_EXCEPTION_HANDLING /* 3800 */:
      case OVERFLOW_CLIP_ALONG_EITHER_AXIS /* 3803 */:
      case CREATE_JSON_MODULE_SCRIPT /* 3804 */:
      case CREATE_CSS_MODULE_SCRIPT /* 3805 */:
      case INSERT_HTML_COMMAND_ON_INPUT /* 3806 */:
      case INSERT_HTML_COMMAND_ON_TEXTAREA /* 3807 */:
      case INSERT_HTML_COMMAND_ON_READ_WRITE_PLAIN_TEXT /* 3808 */:
      case CSS_AT_RULE_COUNTER_STYLE /* 3809 */:
      case CANVAS_USE_COLOR_SPACE /* 3810 */:
      case SELECT_LIST_ELEMENT /* 3811 */:
      case OBSOLETE_RTC_PEER_CONNECTION_SDP_SEMANTICS_PLAN_B_WITH_REVERSE_ORIGIN_TRIAL /* 3812 */:
      case WEB_APP_MANIFEST_CAPTURE_LINKS /* 3813 */:
      case SANITIZER_API_CREATED /* 3814 */:
      case SANITIZER_API_DEFAULT_CONFIGURATION /* 3815 */:
      case OBSOLETE_SANITIZER_API_TO_STRING /* 3816 */:
      case SANITIZER_API_TO_FRAGMENT /* 3817 */:
      case SANITIZER_API_ACTION_TAKEN /* 3818 */:
      case SANITIZER_API_FROM_STRING /* 3819 */:
      case SANITIZER_API_FROM_DOCUMENT /* 3820 */:
      case SANITIZER_API_FROM_FRAGMENT /* 3821 */:
      case OBSOLETE_STORAGE_FOUNDATION_OPEN /* 3822 */:
      case OBSOLETE_STORAGE_FOUNDATION_READ /* 3823 */:
      case OBSOLETE_STORAGE_FOUNDATION_READ_SYNC /* 3824 */:
      case OBSOLETE_STORAGE_FOUNDATION_WRITE /* 3825 */:
      case OBSOLETE_STORAGE_FOUNDATION_WRITE_SYNC /* 3826 */:
      case OBSOLETE_STORAGE_FOUNDATION_FLUSH /* 3827 */:
      case OBSOLETE_STORAGE_FOUNDATION_FLUSH_SYNC /* 3828 */:
      case UNRESTRICTED_SHARED_ARRAY_BUFFER /* 3829 */:
      case FEATURE_POLICY_JSAPI_ALLOWS_FEATURE_I_FRAME /* 3830 */:
      case FEATURE_POLICY_JSAPI_ALLOWS_FEATURE_DOCUMENT /* 3831 */:
      case FEATURE_POLICY_JSAPI_ALLOWS_FEATURE_ORIGIN_I_FRAME /* 3832 */:
      case FEATURE_POLICY_JSAPI_ALLOWS_FEATURE_ORIGIN_DOCUMENT /* 3833 */:
      case FEATURE_POLICY_JSAPI_ALLOWED_FEATURES_I_FRAME /* 3834 */:
      case FEATURE_POLICY_JSAPI_ALLOWED_FEATURES_DOCUMENT /* 3835 */:
      case FEATURE_POLICY_JSAPI_FEATURES_I_FRAME /* 3836 */:
      case FEATURE_POLICY_JSAPI_FEATURES_DOCUMENT /* 3837 */:
      case FEATURE_POLICY_JSAPI_GET_ALLOWLIST_I_FRAME /* 3838 */:
      case FEATURE_POLICY_JSAPI_GET_ALLOWLIST_DOCUMENT /* 3839 */:
      case OBSOLETE_V8_SCREENS_ONCHANGE_ATTRIBUTE_GETTER /* 3840 */:
      case OBSOLETE_V8_SCREENS_ONCHANGE_ATTRIBUTE_SETTER /* 3841 */:
      case V8_SCREEN_DETAILED_LEFT_ATTRIBUTE_GETTER /* 3842 */:
      case V8_SCREEN_DETAILED_TOP_ATTRIBUTE_GETTER /* 3843 */:
      case V8_SCREEN_DETAILED_IS_PRIMARY_ATTRIBUTE_GETTER /* 3844 */:
      case V8_SCREEN_DETAILED_IS_INTERNAL_ATTRIBUTE_GETTER /* 3845 */:
      case V8_SCREEN_DETAILED_DEVICE_PIXEL_RATIO_ATTRIBUTE_GETTER /* 3846 */:
      case V8_SCREEN_DETAILED_ID_ATTRIBUTE_GETTER /* 3847 */:
      case V8_SCREEN_DETAILED_POINTER_TYPES_ATTRIBUTE_GETTER /* 3848 */:
      case V8_SCREEN_DETAILED_LABEL_ATTRIBUTE_GETTER /* 3849 */:
      case PERMISSIONS_POLICY_HEADER /* 3850 */:
      case WEB_APP_MANIFEST_URL_HANDLERS /* 3851 */:
      case LAX_ALLOWING_UNSAFE_COOKIES /* 3852 */:
      case V8_MEDIA_SESSION_SET_MICROPHONE_ACTIVE_METHOD /* 3853 */:
      case V8_MEDIA_SESSION_SET_CAMERA_ACTIVE_METHOD /* 3854 */:
      case V8_NAVIGATOR_JOIN_AD_INTEREST_GROUP_METHOD /* 3855 */:
      case V8_NAVIGATOR_LEAVE_AD_INTEREST_GROUP_METHOD /* 3856 */:
      case V8_NAVIGATOR_RUN_AD_AUCTION_METHOD /* 3857 */:
      case XHRJSON_ENCODING_DETECTION /* 3858 */:
      case WORKER_CONTROLLED_BY_SERVICE_WORKER_OUT_OF_SCOPE /* 3859 */:
      case XR_PLANE_DETECTION /* 3860 */:
      case XR_FRAME_DETECTED_PLANES /* 3861 */:
      case XR_IMAGE_TRACKING /* 3862 */:
      case XR_SESSION_GET_TRACKED_IMAGE_SCORES /* 3863 */:
      case XR_FRAME_GET_IMAGE_TRACKING_RESULTS /* 3864 */:
      case OBSOLETE_OPEN_WEB_DATABASE_THIRD_PARTY_CONTEXT /* 3865 */:
      case POINTER_ID /* 3866 */:
      case TRANSFORM3D_SCENE /* 3867 */:
      case PREFERS_COLOR_SCHEME_MEDIA_FEATURE /* 3868 */:
      case PREFERS_CONTRAST_MEDIA_FEATURE /* 3869 */:
      case FORCED_COLORS_MEDIA_FEATURE /* 3870 */:
      case PAYMENT_REQUEST_CSP_VIOLATION /* 3871 */:
      case WORKER_CONTROLLED_BY_SERVICE_WORKER_WITH_FETCH_EVENT_HANDLER_OUT_OF_SCOPE /* 3872 */:
      case AUTHORIZATION_COVERED_BY_WILDCARD /* 3873 */:
      case ELEMENT_GET_INNER_HTML /* 3874 */:
      case FILE_HANDLING_LAUNCH /* 3875 */:
      case SAME_ORIGIN_DOCUMENTS_WITH_DIFFERENT_COOP_STATUS /* 3876 */:
      case HTML_MEDIA_ELEMENT_SET_SINK_ID /* 3877 */:
      case PREFIXED_STORAGE_QUOTA_THIRD_PARTY_CONTEXT /* 3878 */:
      case REQUESTED_FILE_SYSTEM_PERSISTENT_THIRD_PARTY_CONTEXT /* 3879 */:
      case PREFIXED_STORAGE_INFO_THIRD_PARTY_CONTEXT /* 3880 */:
      case CROSS_ORIGIN_EMBEDDER_POLICY_CREDENTIALLESS /* 3881 */:
      case POST_MESSAGE_FROM_SECURE_TO_SECURE /* 3882 */:
      case POST_MESSAGE_FROM_INSECURE_TO_INSECURE /* 3883 */:
      case WEB_APP_MANIFEST_PROTOCOL_HANDLERS /* 3884 */:
      case RTC_PEER_CONNECTION_OFFER_ALLOW_EXTMAP_MIXED_FALSE /* 3885 */:
      case OBSOLETE_NEW_CANVAS2_DAPI /* 3886 */:
      case OBSOLETE_SERVICE_WORKER_SUBRESOURCE_FILTER_BYPASSED_REQUEST /* 3887 */:
      case WEB_GPU_REQUEST_ADAPTER /* 3888 */:
      case CSS_FILTER_COLOR_MATRIX /* 3889 */:
      case HTML_FENCED_FRAME_ELEMENT /* 3890 */:
      case CSS_FILTER_LUMINANCE_TO_ALPHA /* 3891 */:
      case HANDWRITING_RECOGNITION_CREATE_RECOGNIZER /* 3892 */:
      case OBSOLETE_HANDWRITING_RECOGNITION_QUERY_SUPPORT /* 3893 */:
      case HANDWRITING_RECOGNITION_START_DRAWING /* 3894 */:
      case HANDWRITING_RECOGNITION_GET_PREDICTION /* 3895 */:
      case WEB_BLUETOOTH_MANUFACTURER_DATA_FILTER /* 3896 */:
      case SANITIZER_API_GET_CONFIG /* 3897 */:
      case SANITIZER_API_GET_DEFAULT_CONFIG /* 3898 */:
      case PRESSURE_OBSERVER_CONSTRUCTOR /* 3899 */:
      case PRESSURE_OBSERVER_OBSERVE /* 3900 */:
      case OBSOLETE_COMPUTE_PRESSURE_OBSERVER_STOP /* 3901 */:
      case WEB_APP_WINDOW_CONTROLS_OVERLAY /* 3902 */:
      case PAYMENT_REQUEST_SHOW_WITHOUT_GESTURE_OR_TOKEN /* 3903 */:
      case V8_NAVIGATOR_UPDATE_AD_INTEREST_GROUPS_METHOD /* 3904 */:
      case V8_SCREEN_DETAILS_ONSCREENSCHANGE_ATTRIBUTE_GETTER /* 3905 */:
      case V8_SCREEN_DETAILS_ONSCREENSCHANGE_ATTRIBUTE_SETTER /* 3906 */:
      case V8_SCREEN_DETAILS_ONCURRENTSCREENCHANGE_ATTRIBUTE_GETTER /* 3907 */:
      case V8_SCREEN_DETAILS_ONCURRENTSCREENCHANGE_ATTRIBUTE_SETTER /* 3908 */:
      case RTC_OFFER_ANSWER_OPTIONS_VOICE_ACTIVITY_DETECTION /* 3909 */:
      case MULTI_COL_AND_LIST_ITEM /* 3910 */:
      case CAPTURE_HANDLE /* 3911 */:
      case SVG_TEXT /* 3912 */:
      case GET_B_BOX_FOR_TEXT /* 3913 */:
      case SVG_TEXT_HANGING_FROM_PATH /* 3914 */:
      case CLIENT_HINTS_PREFERS_COLOR_SCHEME /* 3915 */:
      case OVERSCROLL_BEHAVIOR_WILL_BE_FIXED /* 3916 */:
      case CONTROLLED_WORKER_WILL_BE_UNCONTROLLED /* 3917 */:
      case OBSOLETE_K_ARIA_TOUCHPASSTHROUGH_ATTRIBUTE /* 3918 */:
      case ARIA_VIRTUALCONTENT_ATTRIBUTE /* 3919 */:
      case OBSOLETE_K_ACCESSIBILITY_TOUCH_PASSTHROUGH_SET /* 3920 */:
      case TEXT_FRAGMENT_BLOCKED_BY_FORCE_LOAD_AT_TOP /* 3921 */:
      case OBSOLETE_URN_DOCUMENT_ACCESSED_COOKIES /* 3922 */:
      case FONT_FACE_ASCENT_OVERRIDE /* 3923 */:
      case FONT_FACE_DESCENT_OVERRIDE /* 3924 */:
      case FONT_FACE_LINE_GAP_OVERRIDE /* 3925 */:
      case FONT_FACE_SIZE_ADJUST /* 3926 */:
      case HIDDEN_BACKFACE_WITH3_D /* 3927 */:
      case MAIN_FRAME_NON_SECURE_PRIVATE_ADDRESS_SPACE /* 3928 */:
      case HTML_MEDIA_ELEMENT_CONTROLS_LIST_NO_PLAYBACK_RATE /* 3930 */:
      case OBSOLETE_DOCUMENT_TRANSITION /* 3931 */:
      case SPECULATION_RULES /* 3932 */:
      case V8_ABORT_SIGNAL_ABORT_METHOD /* 3933 */:
      case SELECTION_BACKGROUND_COLOR_INVERSION /* 3934 */:
      case OBSOLETE_RTC_PEER_CONNECTION_PLAN_B_THREW_AN_EXCEPTION /* 3935 */:
      case HTML_ROOT_CONTAINED /* 3936 */:
      case HTML_BODY_CONTAINED /* 3937 */:
      case XR_FRAME_GET_JOINT_POSE /* 3938 */:
      case XR_FRAME_FILL_JOINT_RADII /* 3939 */:
      case XR_FRAME_FILL_POSES /* 3940 */:
      case OBSOLETE_K_WINDOW_OPEN_NEW_POPUP_BEHAVIOR_MISMATCH /* 3941 */:
      case EXPLICIT_POINTER_CAPTURE_CLICK_TARGET_DIFF /* 3942 */:
      case CONTROLLED_NON_BLOB_URL_WORKER_WILL_BE_UNCONTROLLED /* 3943 */:
      case MEDIA_META_THEME_COLOR /* 3944 */:
      case CLIENT_HINTS_UA_BITNESS /* 3945 */:
      case DIFFERENT_PERSPECTIVE_CB_OR_PARENT /* 3946 */:
      case WEBKIT_IMAGE_SET /* 3947 */:
      case RTC_PEER_CONNECTION_WITH_BLOCKING_CSP /* 3948 */:
      case SANITIZER_API_SANITIZE_FOR /* 3949 */:
      case SANITIZER_API_ELEMENT_SET_SANITIZED /* 3950 */:
      case TEXT_SHADOW_IN_HIGHLIGHT_PSEUDO /* 3951 */:
      case TEXT_SHADOW_NOT_NONE_IN_HIGHLIGHT_PSEUDO /* 3952 */:
      case SAME_SITE_NONE_REQUIRED /* 3953 */:
      case SAME_SITE_NONE_INCLUDED_BY_SAME_PARTY_TOP_RESOURCE /* 3954 */:
      case SAME_SITE_NONE_INCLUDED_BY_SAME_PARTY_ANCESTORS /* 3955 */:
      case SAME_SITE_NONE_INCLUDED_BY_SAME_SITE_LAX /* 3956 */:
      case SAME_SITE_NONE_INCLUDED_BY_SAME_SITE_STRICT /* 3957 */:
      case PRIVATE_NETWORK_ACCESS_NON_SECURE_CONTEXTS_ALLOWED_DEPRECATION_TRIAL /* 3958 */:
      case V8URL_PATTERN_CONSTRUCTOR /* 3959 */:
      case V8URL_PATTERN_TEST_METHOD /* 3960 */:
      case V8URL_PATTERN_EXEC_METHOD /* 3961 */:
      case SAME_SITE_COOKIE_INCLUSION_CHANGED_BY_CROSS_SITE_REDIRECT /* 3962 */:
      case BLOB_STORE_ACCESS_ACROSS_AGENT_CLUSTERS_IN_RESOLVE_AS_URL_LOADER_FACTORY /* 3963 */:
      case BLOB_STORE_ACCESS_ACROSS_AGENT_CLUSTERS_IN_RESOLVE_FOR_NAVIGATION /* 3964 */:
      case TAP_DELAY_ENABLED /* 3965 */:
      case V8URL_PATTERN_COMPARE_COMPONENT_METHOD /* 3966 */:
      case EARLY_HINTS_PRELOAD /* 3967 */:
      case CLIENT_HINTS_UA_REDUCED /* 3968 */:
      case SPECULATION_RULES_PRERENDER /* 3969 */:
      case OBSOLETE_EXEC_COMMAND_WITH_TRUSTED_TYPES /* 3970 */:
      case OBSOLETE_CSS_SELECTOR_PSEUDO_HAS_IN_SNAPSHOT_PROFILE /* 3971 */:
      case OBSOLETE_CSS_SELECTOR_PSEUDO_HAS_IN_LIVE_PROFILE /* 3972 */:
      case NAVIGATOR_PDF_VIEWER_ENABLED /* 3973 */:
      case CANVAS_RENDERING_CONTEXT2_D_CONTEXT_LOST_EVENT /* 3974 */:
      case CANVAS_RENDERING_CONTEXT2_D_CONTEXT_RESTORED_EVENT /* 3975 */:
      case CLIENT_HINTS_VIEWPORT_HEIGHT /* 3976 */:
      case V8_NAVIGATOR_MANAGED_DATA_GET_DIRECTORY_ID_METHOD /* 3977 */:
      case V8_NAVIGATOR_MANAGED_DATA_GET_HOSTNAME_METHOD /* 3978 */:
      case V8_NAVIGATOR_MANAGED_DATA_GET_SERIAL_NUMBER_METHOD /* 3979 */:
      case V8_NAVIGATOR_MANAGED_DATA_GET_ANNOTATED_ASSET_ID_METHOD /* 3980 */:
      case V8_NAVIGATOR_MANAGED_DATA_GET_ANNOTATED_LOCATION_METHOD /* 3981 */:
      case USER_DATA_FIELD_FILLED_PREVIOUSLY /* 3982 */:
      case TABLE_COLLAPSED_BORDER_DIFFERENT_TO_VISUAL /* 3983 */:
      case HIGHLIGHT_API_REGISTER_HIGHLIGHT /* 3984 */:
      case OBSOLETE_READ_OR_WRITE_WEB_DATABASE_THIRD_PARTY_CONTEXT /* 3985 */:
      case OBSOLETE_FONT_SELECTOR_CSS_FONT_FAMILY_WEB_KIT_PREFIX_PICTOGRAPH /* 3986 */:
      case OBSOLETE_FONT_SELECTOR_CSS_FONT_FAMILY_WEB_KIT_PREFIX_STANDARD /* 3987 */:
      case FONT_SELECTOR_CSS_FONT_FAMILY_WEB_KIT_PREFIX_BODY /* 3988 */:
      case FONT_BUILDER_CSS_FONT_FAMILY_WEB_KIT_PREFIX_BODY /* 3989 */:
      case CAPABILITY_DELEGATION_OF_PAYMENT_REQUEST /* 3990 */:
      case CREDENTIAL_MANAGER_GET_LEGACY_FEDERATED_CREDENTIAL /* 3992 */:
      case CREDENTIAL_MANAGER_GET_PASSWORD_CREDENTIAL /* 3993 */:
      case CREDENTIAL_MANAGER_STORE_FEDERATED_CREDENTIAL /* 3994 */:
      case CREDENTIAL_MANAGER_STORE_PASSWORD_CREDENTIAL /* 3995 */:
      case CREDENTIAL_MANAGER_CREATE_FEDERATED_CREDENTIAL /* 3996 */:
      case CREDENTIAL_MANAGER_CREATE_PASSWORD_CREDENTIAL /* 3997 */:
      case CANVAS_RENDERING_CONTEXT2_D_ROUND_RECT /* 3998 */:
      case NEW_LAYOUT_OVERFLOW_DIFFERENT_BLOCK_WITH_NON_EMPTY_INFLOW_BOUNDS /* 3999 */:
      case CANVAS_RENDERING_CONTEXT2_D_RESET /* 4000 */:
      case CANVAS_RENDERING_CONTEXT2_D_LETTER_SPACING /* 4001 */:
      case CANVAS_RENDERING_CONTEXT2_D_WORD_SPACING /* 4002 */:
      case CANVAS_RENDERING_CONTEXT2_D_FONT_VARIANT_CAPS /* 4003 */:
      case CANVAS_RENDERING_CONTEXT2_D_FONT_KERNING /* 4004 */:
      case CANVAS_RENDERING_CONTEXT2_D_FONT_STRETCH /* 4005 */:
      case CANVAS_RENDERING_CONTEXT2_D_TEXT_RENDERING /* 4006 */:
      case CSS_CASCADE_LAYERS /* 4007 */:
      case CANVAS_RENDERING_CONTEXT2_D_CONIC_GRADIENT /* 4008 */:
      case CANVAS_RENDERING_CONTEXT2_D_CANVAS_FILTER /* 4009 */:
      case OBSOLETE_HTML_PARAM_ELEMENT_URL_PARAMETER /* 4010 */:
      case V8HTML_SCRIPT_ELEMENT_SUPPORTS_METHOD /* 4011 */:
      case HANDWRITING_RECOGNITION_QUERY_RECOGNIZER /* 4012 */:
      case V8_FILE_SYSTEM_FILE_HANDLE_CREATE_SYNC_ACCESS_HANDLE_METHOD /* 4013 */:
      case V8_FILE_SYSTEM_SYNC_ACCESS_HANDLE_READ_METHOD /* 4014 */:
      case V8_FILE_SYSTEM_SYNC_ACCESS_HANDLE_WRITE_METHOD /* 4015 */:
      case V8_FILE_SYSTEM_SYNC_ACCESS_HANDLE_CLOSE_METHOD /* 4016 */:
      case V8_FILE_SYSTEM_SYNC_ACCESS_HANDLE_FLUSH_METHOD /* 4017 */:
      case V8_FILE_SYSTEM_SYNC_ACCESS_HANDLE_GET_SIZE_METHOD /* 4018 */:
      case V8_FILE_SYSTEM_SYNC_ACCESS_HANDLE_TRUNCATE_METHOD /* 4019 */:
      case V8_SHARED_ARRAY_BUFFER_CONSTRUCTED_IN_EXTENSION_WITHOUT_ISOLATION /* 4020 */:
      case MEDIA_SOURCE_EXTENSIONS_FOR_WEB_CODECS /* 4021 */:
      case PAYMENT_REQUEST_RESPONSE /* 4023 */:
      case PAYMENT_REQUEST_COMPLETE /* 4024 */:
      case HTML_CANVAS_ELEMENT_2D /* 4025 */:
      case HTML_CANVAS_ELEMENT_WEB_GL /* 4026 */:
      case HTML_CANVAS_ELEMENT_WEB_GL2 /* 4027 */:
      case HTML_CANVAS_ELEMENT_BITMAP_RENDERER /* 4028 */:
      case HTML_CANVAS_ELEMENT_WEB_GPU /* 4029 */:
      case OFFSCREEN_CANVAS_2D /* 4030 */:
      case OFFSCREEN_CANVAS_WEB_GL /* 4031 */:
      case OFFSCREEN_CANVAS_WEB_GL2 /* 4032 */:
      case OFFSCREEN_CANVAS_BITMAP_RENDERER /* 4033 */:
      case OFFSCREEN_CANVAS_WEB_GPU /* 4034 */:
      case CANVAS_RENDERING_CONTEXT2_D_HAS_OVERDRAW /* 4035 */:
      case DIGITAL_GOODS_CONSUME /* 4036 */:
      case DIGITAL_GOODS_LIST_PURCHASE_HISTORY /* 4037 */:
      case WEB_SHARE_CONTAINING_FILES /* 4038 */:
      case WEB_SHARE_CONTAINING_TITLE /* 4039 */:
      case WEB_SHARE_CONTAINING_TEXT /* 4040 */:
      case WEB_SHARE_CONTAINING_URL /* 4041 */:
      case COEP_NONE_SHARED_WORKER /* 4042 */:
      case COEP_REQUIRE_CORP_SHARED_WORKER /* 4043 */:
      case COEP_CREDENTIALLESS_SHARED_WORKER /* 4044 */:
      case PAYMENT_REQUEST_BASIC_CARD /* 4045 */:
      case CLIENT_HINTS_DEVICE_MEMORY /* 4046 */:
      case CLIENT_HINTS_DPR /* 4047 */:
      case CLIENT_HINTS_RESOURCE_WIDTH /* 4048 */:
      case CLIENT_HINTS_VIEWPORT_WIDTH /* 4049 */:
      case INLINE_BOX_IGNORING_CONTINUATION /* 4050 */:
      case OBSOLETE_OFFSET_WIDTH_OR_HEIGHT_IGNORING_CONTINUATION /* 4051 */:
      case CONDITIONAL_FOCUS /* 4052 */:
      case V8_NAVIGATOR_CREATE_AD_REQUEST_METHOD /* 4053 */:
      case V8_NAVIGATOR_FINALIZE_AD_METHOD /* 4054 */:
      case REGION_CAPTURE /* 4055 */:
      case APP_HISTORY /* 4056 */:
      case FLEXBOX_ALIGN_SINGLE_LINE_DIFFERENCE /* 4057 */:
      case EXTERNAL_PROTOCOL_BLOCKED_BY_SANDBOX /* 4058 */:
      case OBSOLETE_WEB_ASSEMBLY_DYNAMIC_TIERING /* 4059 */:
      case READ_OR_WRITE_WEB_DATABASE /* 4061 */:
      case AUTO_DARK_MODE /* 4062 */:
      case HTTP_REFRESH_WHEN_SCRIPTING_DISABLED /* 4063 */:
      case V8_FRAGMENT_DIRECTIVE_ITEMS_ATTRIBUTE_GETTER /* 4064 */:
      case V8_FRAGMENT_DIRECTIVE_CREATE_SELECTOR_DIRECTIVE_METHOD /* 4065 */:
      case CSS_TRANSITION_BLOCKED_BY_ANIMATION /* 4066 */:
      case WEB_APP_MANIFEST_HAS_COMMENTS /* 4067 */:
      case AUTO_EXPANDED_DETAILS_FOR_FIND_IN_PAGE /* 4068 */:
      case AUTO_EXPANDED_DETAILS_FOR_SCROLL_TO_TEXT_FRAGMENT /* 4069 */:
      case OBSOLETE_WEB_CODECS_VIDEO_FRAME_DEFAULT_TIMESTAMP /* 4070 */:
      case WEB_CODECS_VIDEO_FRAME_FROM_IMAGE /* 4071 */:
      case WEB_CODECS_VIDEO_FRAME_FROM_BUFFER /* 4072 */:
      case OBSOLETE_OPEN_WEB_DATABASE_INSECURE_CONTEXT /* 4073 */:
      case SCRIPT_WEB_BUNDLE /* 4074 */:
      case RUN_AD_AUCTION /* 4075 */:
      case JOIN_AD_INTEREST_GROUP /* 4076 */:
      case FILE_SYSTEM_URL_NAVIGATION /* 4077 */:
      case V8_NAVIGATOR_AD_AUCTION_COMPONENTS_METHOD /* 4078 */:
      case CLIENT_HINTS_UA_FULL_VERSION_LIST /* 4079 */:
      case WEB_APP_MANIFEST_LAUNCH_HANDLER /* 4080 */:
      case OBSOLETE_CLIENT_HINTS_META_NAME_ACCEPT_CH /* 4081 */:
      case OBSOLETE_CSS_MATCH_MEDIA_UNKNOWN /* 4082 */:
      case OBSOLETE_CSS_MEDIA_LIST_UNKNOWN /* 4083 */:
      case OBSOLETE_CSSOM_MEDIA_CONDITION_UNKNOWN /* 4084 */:
      case DOCUMENT_DOMAIN_SETTING_WITHOUT_ORIGIN_AGENT_CLUSTER_HEADER /* 4085 */:
      case CROSS_ORIGIN_EMBEDDER_POLICY_CREDENTIALLESS_REPORT_ONLY /* 4086 */:
      case CROSS_ORIGIN_EMBEDDER_POLICY_REQUIRE_CORP_REPORT_ONLY /* 4087 */:
      case COOP_AND_COEP_ISOLATED_REPORT_ONLY /* 4088 */:
      case CROSS_ORIGIN_OPENER_POLICY_SAME_ORIGIN_ALLOW_POPUPS_REPORT_ONLY /* 4089 */:
      case CROSS_ORIGIN_OPENER_POLICY_SAME_ORIGIN_REPORT_ONLY /* 4090 */:
      case IMAGE_LOAD_AT_DISMISSAL_EVENT /* 4091 */:
      case OBSOLETE_PRIVATE_NETWORK_ACCESS_IGNORED_PREFLIGHT_ERROR /* 4092 */:
      case ABORT_PAYMENT_RESPOND_WITH_TRUE /* 4093 */:
      case ALLOW_PAYMENT_REQUEST_ATTRIBUTE_HAS_EFFECT /* 4094 */:
      case V8_PAYMENT_RESPONSE_RETRY_METHOD /* 4095 */:
      case 4096:
      case 4097:
      case 4098:
      case 4099:
      case 4100:
      case LAYER_XY_WITH_SVG_TARGET /* 4101 */:
      case HTML_OBJECT_ELEMENT_FALLBACK /* 4102 */:
      case SECURE_CONTEXT_INCORRECT_FOR_WORKER /* 4103 */:
      case V8UDP_SOCKET_CLOSE_METHOD /* 4104 */:
      case HTML_INPUT_ELEMENT_SIMULATED_CLICK /* 4105 */:
      case RTC_LOCAL_SDP_MODIFICATION_ICE_UFRAG_PWD /* 4106 */:
      case WEB_NFC_NDEF_MAKE_READ_ONLY /* 4107 */:
      case V8_NAVIGATOR_DEPRECATED_URN_TO_URL_METHOD /* 4108 */:
      case OBSOLETE_WEB_APP_MANIFEST_HANDLE_LINKS /* 4109 */:
      case OBSOLETE_HTML_PARAM_ELEMENT_URL_PARAMETER_IN_USE_PDF /* 4110 */:
      case OBSOLETE_HTML_PARAM_ELEMENT_URL_PARAMETER_IN_USE_NON_PDF /* 4111 */:
      case WEB_TRANSPORT_SERVER_CERTIFICATE_HASHES /* 4112 */:
      case HIDDEN_ATTRIBUTE /* 4113 */:
      case HIDDEN_UNTIL_FOUND_ATTRIBUTE /* 4114 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_BLUR /* 4115 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_CLOSE /* 4116 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_CLOSED /* 4117 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FOCUS /* 4118 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FRAMES /* 4119 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_INDEXED_GETTER /* 4120 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_LENGTH /* 4121 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_LOCATION /* 4122 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_NAMED_GETTER /* 4123 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_OPENER /* 4124 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_PARENT /* 4125 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_POST_MESSAGE /* 4126 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_SELF /* 4127 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_TOP /* 4128 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_WINDOW /* 4129 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_BLUR /* 4130 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_CLOSE /* 4131 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_CLOSED /* 4132 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_FOCUS /* 4133 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_FRAMES /* 4134 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_INDEXED_GETTER /* 4135 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_LENGTH /* 4136 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_LOCATION /* 4137 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_NAMED_GETTER /* 4138 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_OPENER /* 4139 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_PARENT /* 4140 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_POST_MESSAGE /* 4141 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_SELF /* 4142 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_TOP /* 4143 */:
      case WINDOW_PROXY_CROSS_ORIGIN_ACCESS_FROM_OTHER_PAGE_WINDOW /* 4144 */:
      case PRIVATE_NETWORK_ACCESS_FETCHED_WORKER_SCRIPT /* 4145 */:
      case FRAME_NAME_CONTAINS_BRACE /* 4146 */:
      case FRAME_NAME_CONTAINS_NEWLINE /* 4147 */:
      case ABORT_SIGNAL_THROW_IF_ABORTED /* 4148 */:
      case CLIENT_HINTS_UA_FULL /* 4149 */:
      case PRIVATE_NETWORK_ACCESS_WITHIN_WORKER /* 4150 */:
      case CLIENT_HINTS_UA_WO_W64 /* 4151 */:
      case FETCH_SET_COOKIE_IN_REQUEST_GUARDED_HEADERS /* 4152 */:
      case OBSOLETE_V8_WINDOW_REQUEST_PICTURE_IN_PICTURE_WINDOW_METHOD /* 4153 */:
      case V8UDP_SOCKET_LOCAL_PORT_ATTRIBUTE_GETTER /* 4154 */:
      case V8UDP_SOCKET_READABLE_ATTRIBUTE_GETTER /* 4155 */:
      case V8UDP_SOCKET_REMOTE_ADDRESS_ATTRIBUTE_GETTER /* 4156 */:
      case V8UDP_SOCKET_REMOTE_PORT_ATTRIBUTE_GETTER /* 4157 */:
      case V8UDP_SOCKET_WRITABLE_ATTRIBUTE_GETTER /* 4158 */:
      case ABORT_SIGNAL_TIMEOUT /* 4159 */:
      case OBSOLETE_CLIENT_HINTS_PARTITIONED_COOKIES /* 4160 */:
      case V8_DOCUMENT_PRERENDERING_ATTRIBUTE_GETTER /* 4161 */:
      case V8_DOCUMENT_ONPRERENDERINGCHANGE_ATTRIBUTE_GETTER /* 4162 */:
      case V8_DOCUMENT_ONPRERENDERINGCHANGE_ATTRIBUTE_SETTER /* 4163 */:
      case CSS_AT_RULE_FONT_PALETTE_VALUES /* 4164 */:
      case CSS_AT_RULE_CONTAINER /* 4165 */:
      case FED_CM /* 4166 */:
      case FETCH_EVENT_SOURCE_LAST_EVENT_ID_CORS_UN_SAFE /* 4167 */:
      case WRONG_BASELINE_OF_MULTI_LINE_BUTTON_WITH_NON_SPACE /* 4168 */:
      case BLOB_STORE_ACCESS_ACROSS_TOP_LEVEL_SITE /* 4169 */:
      case BLOB_STORE_ACCESS_UNKNOWN_TOP_LEVEL_SITE /* 4170 */:
      case CROSS_ORIGIN_ACCESS_BASED_ON_DOCUMENT_DOMAIN /* 4171 */:
      case COOKIE_WITH_TRUNCATING_CHAR /* 4172 */:
      case VIDEO_TRACK_GENERATOR /* 4173 */:
      case MEDIA_CAPABILITIES_DECODING_INFO_WEBRTC /* 4174 */:
      case MEDIA_CAPABILITIES_ENCODING_INFO_WEBRTC /* 4175 */:
      case USB_DEVICE_FORGET /* 4176 */:
      case PARTITIONED_COOKIES /* 4177 */:
      case SECURE_CONTEXT_INCORRECT_FOR_SHARED_WORKER /* 4178 */:
      case V8_FUNCTION_PROTOTYPE_ARGUMENTS /* 4179 */:
      case V8_FUNCTION_PROTOTYPE_CALLER /* 4180 */:
      case BLUETOOTH_DEVICE_FORGET /* 4181 */:
      case TOPICS_API_BROWSING_TOPICS_METHOD /* 4182 */:
      case BLOCKING_ATTRIBUTE_RENDER_TOKEN /* 4183 */:
      case PRESSURE_OBSERVER_UNOBSERVE /* 4184 */:
      case PRESSURE_OBSERVER_DISCONNECT /* 4185 */:
      case PRESSURE_OBSERVER_TAKE_RECORDS /* 4186 */:
      case PRIVACY_SANDBOX_ADS_AP_IS /* 4187 */:
      case FLEDGE /* 4188 */:
      case ELEMENT_SHOW_POPOVER /* 4189 */:
      case ELEMENT_HIDE_POPOVER /* 4190 */:
      case VALID_POPOVER_ATTRIBUTE /* 4191 */:
      case DEPRECATION_EXAMPLE /* 4192 */:
      case RTC_LOCAL_SDP_MODIFICATION_OPUS_STEREO /* 4193 */:
      case NAVIGATOR_UA_DATA_MOBILE /* 4194 */:
      case NAVIGATOR_UA_DATA_PLATFORM /* 4195 */:
      case NAVIGATOR_UA_DATA_BRANDS /* 4196 */:
      case OLD_CONSTRAINTS_PARSED /* 4197 */:
      case OBSOLETE_OLD_CONSTRAINT_NOT_REPORTED /* 4198 */:
      case OBSOLETE_OLD_CONSTRAINT_REJECTED /* 4199 */:
      case OBSOLETE_OLD_CONSTRAINT_IGNORED /* 4200 */:
      case EXPLICIT_OVERFLOW_VISIBLE_ON_REPLACED_ELEMENT /* 4201 */:
      case EXPLICIT_OVERFLOW_VISIBLE_ON_REPLACED_ELEMENT_WITH_OBJECT_PROP /* 4202 */:
      case PRIVATE_NETWORK_ACCESS_NULL_IP_ADDRESS /* 4203 */:
      case OBSOLETE_LEGACY_CONSTRAINT_GOOG_SCREENCAST_MIN_BITRATE /* 4204 */:
      case OBSOLETE_RTC_PEER_CONNECTION_LEGACY_CREATE_WITH_MEDIA_CONSTRAINTS /* 4205 */:
      case CLIENT_HINTS_SAVE_DATA /* 4206 */:
      case OBSOLETE_LEGACY_CONSTRAINT_GOOG_I_PV6 /* 4207 */:
      case OBSOLETE_LEGACY_CONSTRAINT_GOOG_SUSPEND_BELOW_MIN_BITRATE /* 4208 */:
      case OBSOLETE_LEGACY_CONSTRAINT_GOOG_CPU_OVERUSE_DETECTION /* 4209 */:
      case AUDIO_CONTEXT_OUTPUT_LATENCY /* 4210 */:
      case V8_WINDOW_QUERY_LOCAL_FONTS_METHOD /* 4211 */:
      case CSS_AT_RULE_SCOPE /* 4212 */:
      case OBSOLETE_DEFERRED_SHAPING_DISABLED_BY_POSITIONED /* 4213 */:
      case CAPABILITY_DELEGATION_OF_FULLSCREEN_REQUEST /* 4214 */:
      case SERIAL_PORT_FORGET /* 4215 */:
      case COOKIE_HAS_NOT_BEEN_REFRESHED_IN201_TO300_DAYS /* 4216 */:
      case COOKIE_HAS_NOT_BEEN_REFRESHED_IN301_TO350_DAYS /* 4217 */:
      case COOKIE_HAS_NOT_BEEN_REFRESHED_IN351_TO400_DAYS /* 4218 */:
      case ANONYMOUS_IFRAME /* 4219 */:
      case OBSOLETE_GESTURE_SCROLL_START /* 4220 */:
      case OBSOLETE_GESTURE_SCROLL_UPDATE /* 4221 */:
      case OBSOLETE_GESTURE_SCROLL_END /* 4222 */:
      case ARRAY_BUFFER_TOO_BIG_FOR_WEB_API /* 4223 */:
      case FED_CM_DISCONNECT /* 4224 */:
      case OBSOLETE_FED_CM_LOGOUT /* 4225 */:
      case OBSOLETE_FED_CM_LOGOUT_RPS /* 4226 */:
      case V8_NAVIGATOR_DEPRECATED_REPLACE_IN_URN_METHOD /* 4227 */:
      case WEB_APP_BORDERLESS /* 4228 */:
      case PAYMENT_INSTRUMENTS /* 4229 */:
      case V8_PAYMENT_INSTRUMENTS_CLEAR_METHOD /* 4230 */:
      case V8_PAYMENT_INSTRUMENTS_DELETE_METHOD /* 4231 */:
      case V8_PAYMENT_INSTRUMENTS_GET_METHOD /* 4232 */:
      case V8_PAYMENT_INSTRUMENTS_HAS_METHOD /* 4233 */:
      case V8_PAYMENT_INSTRUMENTS_KEYS_METHOD /* 4234 */:
      case V8_PAYMENT_INSTRUMENTS_SET_METHOD /* 4235 */:
      case PERFORMANCE_MEASURE_FIND_EXISTING_NAME /* 4236 */:
      case FLEXBOX_NEW_ABS_POS /* 4237 */:
      case SCRIPT_SCHEDULING_TYPE_DEFER /* 4238 */:
      case SCRIPT_SCHEDULING_TYPE_PARSER_BLOCKING /* 4239 */:
      case SCRIPT_SCHEDULING_TYPE_PARSER_BLOCKING_INLINE /* 4240 */:
      case SCRIPT_SCHEDULING_TYPE_IN_ORDER /* 4241 */:
      case SCRIPT_SCHEDULING_TYPE_ASYNC /* 4242 */:
      case FOCUSGROUP /* 4243 */:
      case V8HTML_ELEMENT_FOCUSGROUP_ATTRIBUTE_GETTER /* 4244 */:
      case V8HTML_ELEMENT_FOCUSGROUP_ATTRIBUTE_SETTER /* 4245 */:
      case V8_MATH_ML_ELEMENT_FOCUSGROUP_ATTRIBUTE_GETTER /* 4246 */:
      case V8_MATH_ML_ELEMENT_FOCUSGROUP_ATTRIBUTE_SETTER /* 4247 */:
      case V8SVG_ELEMENT_FOCUSGROUP_ATTRIBUTE_GETTER /* 4248 */:
      case V8SVG_ELEMENT_FOCUSGROUP_ATTRIBUTE_SETTER /* 4249 */:
      case CSS_LEGACY_PERSPECTIVE_ORIGIN /* 4250 */:
      case CSS_LEGACY_TRANSFORM_ORIGIN /* 4251 */:
      case CSS_LEGACY_BORDER_IMAGE /* 4252 */:
      case CSS_LEGACY_BORDER_IMAGE_WIDTH /* 4253 */:
      case CROSS_ORIGIN_OPENER_POLICY_RESTRICT_PROPERTIES /* 4254 */:
      case CROSS_ORIGIN_OPENER_POLICY_RESTRICT_PROPERTIES_REPORT_ONLY /* 4255 */:
      case EVENT_TIMING_INTERACTION_ID /* 4256 */:
      case SECURE_PAYMENT_CONFIRMATION_OPT_OUT /* 4257 */:
      case OBSOLETE_ANY_POPOVER_ATTRIBUTE /* 4258 */:
      case OBSOLETE_DEFERRED_SHAPING_WORKED /* 4259 */:
      case OBSOLETE_DEFERRED_SHAPING_RESHAPED_BY_FORCE_LAYOUT /* 4260 */:
      case MEDIA_SOURCE_GET_HANDLE /* 4261 */:
      case IDENTITY_IN_CAN_MAKE_PAYMENT_EVENT /* 4262 */:
      case SHARED_STORAGE_API_SHARED_STORAGE_DOM_REFERENCE /* 4263 */:
      case SHARED_STORAGE_API_ADD_MODULE_METHOD /* 4264 */:
      case SHARED_STORAGE_API_SET_METHOD /* 4265 */:
      case SHARED_STORAGE_API_APPEND_METHOD /* 4266 */:
      case SHARED_STORAGE_API_DELETE_METHOD /* 4267 */:
      case SHARED_STORAGE_API_CLEAR_METHOD /* 4268 */:
      case SHARED_STORAGE_API_SELECT_URL_METHOD /* 4269 */:
      case SHARED_STORAGE_API_RUN_METHOD /* 4270 */:
      case VIEW_TIMELINE_CONSTRUCTOR /* 4271 */:
      case H1_USER_AGENT_FONT_SIZE_IN_SECTION_APPLIED /* 4272 */:
      case OBSOLETE_K_V8_PENDING_BEACON_CONSTRUCTOR /* 4273 */:
      case V8_PENDING_BEACON_URL_ATTRIBUTE_GETTER /* 4274 */:
      case OBSOLETE_K_V8_PENDING_BEACON_URL_ATTRIBUTE_SETTER /* 4275 */:
      case V8_PENDING_BEACON_METHOD_ATTRIBUTE_GETTER /* 4276 */:
      case OBSOLETE_K_V8_PENDING_BEACON_METHOD_ATTRIBUTE_SETTER /* 4277 */:
      case OBSOLETE_K_V8_PENDING_BEACON_PAGE_HIDE_TIMEOUT_ATTRIBUTE_GETTER /* 4278 */:
      case OBSOLETE_K_V8_PENDING_BEACON_PAGE_HIDE_TIMEOUT_ATTRIBUTE_SETTER /* 4279 */:
      case OBSOLETE_K_V8_PENDING_BEACON_STATE_ATTRIBUTE_GETTER /* 4280 */:
      case V8_PENDING_BEACON_DEACTIVATE_METHOD /* 4281 */:
      case OBSOLETE_K_V8_PENDING_BEACON_SET_DATA_METHOD /* 4282 */:
      case V8_PENDING_BEACON_SEND_NOW_METHOD /* 4283 */:
      case TAB_SHARING_BAR_SWITCH_TO_CAPTURER /* 4284 */:
      case TAB_SHARING_BAR_SWITCH_TO_CAPTUREE /* 4285 */:
      case AUTOMATIC_LAZY_ADS /* 4286 */:
      case AUTOMATIC_LAZY_EMBEDS /* 4287 */:
      case OBSOLETE_TOUCH_ACTION_CHANGED_AT_POINTER_DOWN /* 4288 */:
      case DEVICE_ORIENTATION_PERMISSION_REQUESTED /* 4289 */:
      case DEVICE_ORIENTATION_USED_WITHOUT_PERMISSION_REQUEST /* 4290 */:
      case DEVICE_MOTION_PERMISSION_REQUESTED /* 4291 */:
      case DEVICE_MOTION_USED_WITHOUT_PERMISSION_REQUEST /* 4292 */:
      case PRIVATE_NETWORK_ACCESS_PERMISSION_PROMPT /* 4293 */:
      case PSEUDO_BEFORE_AFTER_FOR_DATE_TIME_INPUT_ELEMENT /* 4294 */:
      case OBSOLETE_K_V8_PENDING_BEACON_IS_PENDING_ATTRIBUTE_GETTER /* 4295 */:
      case PARENT_OF_DISABLED_FORM_CONTROL_RESPONDS_TO_MOUSE_EVENTS /* 4296 */:
      case UNHANDLED_EXCEPTION_COUNT_IN_MAIN_THREAD /* 4297 */:
      case UNHANDLED_EXCEPTION_COUNT_IN_WORKER /* 4298 */:
      case OBSOLETE_WEB_CODECS_IMAGE_DECODER_PREMULTIPLY_ALPHA_DEPRECATION /* 4299 */:
      case COOKIE_DOMAIN_NON_ASCII /* 4300 */:
      case CLIENT_HINTS_META_EQUIV_DELEGATE_CH /* 4301 */:
      case OBSOLETE_EXPECT_CT_HEADER /* 4302 */:
      case OBSOLETE_K_NAVIGATE_EVENT_TRANSITION_WHILE /* 4303 */:
      case OBSOLETE_K_NAVIGATE_EVENT_RESTORE_SCROLL /* 4304 */:
      case SEND_BEACON_WITH_ARRAY_BUFFER /* 4305 */:
      case SEND_BEACON_WITH_ARRAY_BUFFER_VIEW /* 4306 */:
      case SEND_BEACON_WITH_BLOB /* 4307 */:
      case SEND_BEACON_WITH_FORM_DATA /* 4308 */:
      case SEND_BEACON_WITH_URL_SEARCH_PARAMS /* 4309 */:
      case SEND_BEACON_WITH_USV_STRING /* 4310 */:
      case REPLACED_ELEMENT_PAINTED_WITH_OVERFLOW /* 4311 */:
      case IMAGE_AD /* 4312 */:
      case LINK_REL_PREFETCH_AS_DOCUMENT_SAME_ORIGIN /* 4313 */:
      case LINK_REL_PREFETCH_AS_DOCUMENT_CROSS_ORIGIN /* 4314 */:
      case PERSISTENT_QUOTA_TYPE /* 4315 */:
      case CROSS_ORIGIN_SCROLL_INTO_VIEW /* 4316 */:
      case LINK_REL_CANONICAL /* 4317 */:
      case CREDENTIAL_MANAGER_IS_CONDITIONAL_MEDIATION_AVAILABLE /* 4318 */:
      case V8_PENDING_BEACON_PENDING_ATTRIBUTE_GETTER /* 4319 */:
      case V8_PENDING_BEACON_BACKGROUND_TIMEOUT_ATTRIBUTE_GETTER /* 4320 */:
      case V8_PENDING_BEACON_BACKGROUND_TIMEOUT_ATTRIBUTE_SETTER /* 4321 */:
      case V8_PENDING_BEACON_TIMEOUT_ATTRIBUTE_GETTER /* 4322 */:
      case V8_PENDING_BEACON_TIMEOUT_ATTRIBUTE_SETTER /* 4323 */:
      case V8_PENDING_GET_BEACON_CONSTRUCTOR /* 4324 */:
      case V8_PENDING_GET_BEACON_SET_URL_METHOD /* 4325 */:
      case V8_PENDING_POST_BEACON_CONSTRUCTOR /* 4326 */:
      case V8_PENDING_POST_BEACON_SET_DATA_METHOD /* 4327 */:
      case CONTENT_VISIBILITY_AUTO_STATE_CHANGE_HANDLER_REGISTERED /* 4328 */:
      case REPLACED_ELEMENT_PAINTED_WITH_LARGE_OVERFLOW /* 4329 */:
      case FLEXBOX_ABS_POS_JUSTIFY_CONTENT /* 4330 */:
      case MULTIPLE_FETCH_HANDLERS_IN_SERVICE_WORKER /* 4331 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_FOR_METHOD /* 4332 */:
      case PRIVATE_AGGREGATION_API_ALL /* 4333 */:
      case PRIVATE_AGGREGATION_API_FLEDGE /* 4334 */:
      case PRIVATE_AGGREGATION_API_SHARED_STORAGE /* 4335 */:
      case OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_COMPUTED_STYLE /* 4336 */:
      case OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_DOM_CONTENT_LOADED /* 4337 */:
      case OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_FCP /* 4338 */:
      case OBSOLETE_DEFERRED_SHAPING2_DISABLED_BY_FRAGMENT_ANCHOR /* 4339 */:
      case OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_FOCUS /* 4340 */:
      case OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_GEOMETRY /* 4341 */:
      case OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_INSPECTOR /* 4342 */:
      case OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_PRINTING /* 4343 */:
      case OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_SCROLLING /* 4344 */:
      case LCP_CANDIDATE_IMAGE_FROM_ORIGIN_DIRTY_STYLE /* 4345 */:
      case V8_TURBO_FAN_OSR_COMPILE_STARTED /* 4346 */:
      case V8_DOCUMENT_HAS_REDEMPTION_RECORD_METHOD /* 4347 */:
      case OBSOLETE_DEFERRED_SHAPING2_RESHAPED_BY_LAST_RESORT /* 4348 */:
      case AUDIO_CONTEXT_SINK_ID /* 4349 */:
      case AUDIO_CONTEXT_SET_SINK_ID /* 4350 */:
      case VIEWPORT_DEPENDENT_LAZY_LOADED_IMAGE_WITH_SIZES_ATTRIBUTE /* 4351 */:
      case XR_WEB_GL_BINDING_GET_CAMERA_IMAGE /* 4352 */:
      case SELECTIVE_IN_ORDER_SCRIPT /* 4353 */:
      case V8_ASYNC_STACK_TAGGING_CREATE_TASK_CALL /* 4354 */:
      case WEBKIT_BOX_WITHOUT_WEBKIT_LINE_CLAMP /* 4355 */:
      case DATA_URL_IN_SVG_USE /* 4356 */:
      case WEB_AUTHN_CONDITIONAL_UI_GET /* 4357 */:
      case WEB_AUTHN_CONDITIONAL_UI_GET_SUCCESS /* 4358 */:
      case WEB_AUTHN_RK_REQUIRED_CREATION_SUCCESS /* 4359 */:
      case DESTRUCTIVE_DOCUMENT_WRITE_AFTER_MODULE_SCRIPT /* 4360 */:
      case OBSOLETE_CSS_AT_SUPPORTS_DROP_INVALID_WHILE_FORGIVING_PARSING /* 4361 */:
      case PERMISSIONS_POLICY_UNLOAD /* 4362 */:
      case SERVICE_WORKER_SKIPPED_FOR_SUBRESOURCE_LOAD /* 4363 */:
      case CLIENT_HINTS_PREFERS_REDUCED_MOTION /* 4364 */:
      case OBSOLETE_WAKE_LOCK_ACQUIRE_SCREEN_LOCK_WITHOUT_ACTIVATION /* 4365 */:
      case INTERACTIVE_WIDGET_OVERLAYS_CONTENT /* 4366 */:
      case INTERACTIVE_WIDGET_RESIZES_CONTENT /* 4367 */:
      case INTERACTIVE_WIDGET_RESIZES_VISUAL /* 4368 */:
      case SERIVCE_WORKER_FALLBACK_MAIN_RESOURCE /* 4369 */:
      case OBSOLETE_GET_DISPLAY_MEDIA_WITHOUT_USER_ACTIVATION /* 4370 */:
      case BACK_FORWARD_CACHE_NOT_RESTORED_REASONS /* 4371 */:
      case CSS_NESTING /* 4372 */:
      case SANDBOX_INEFFECTIVE_ALLOW_ORIGIN_ALLOW_SCRIPT /* 4373 */:
      case DOCUMENT_OPEN_DIFFERENT_WINDOW /* 4374 */:
      case DOCUMENT_OPEN_MUTATE_SANDBOX /* 4375 */:
      case ELIGIBLE_FOR_IMAGE_LOADING_PRIORITIZATION_FIX /* 4376 */:
      case EXECUTED_NON_TRIVIAL_JAVA_SCRIPT_URL /* 4377 */:
      case STORAGE_BUCKETS_OPEN /* 4378 */:
      case PERFORMANCE_ENTRY_BUFFER_SWAPS /* 4379 */:
      case CLEAR_PERFORMANCE_ENTRIES /* 4380 */:
      case VIEWPORT_DEPENDENT_LAZY_LOADED_IMAGE_WITHOUT_SIZES_ATTRIBUTE /* 4381 */:
      case V8_MEDIA_STREAM_TRACK_APPLY_CONSTRAINTS_METHOD /* 4382 */:
      case VIEW_TRANSITION /* 4383 */:
      case ELEMENT_TOGGLE_POPOVER /* 4384 */:
      case OBSOLETE_LAYOUT_MEDIA_INLINE_CHILDREN /* 4385 */:
      case REDUCE_ACCEPT_LANGUAGE /* 4386 */:
      case OBSOLETE_UUID_IN_PACKAGE_URL_NAVIGATION /* 4387 */:
      case CSS_VALUE_APPEARANCE_MEDIA_SLIDER_RENDERED /* 4388 */:
      case CSS_VALUE_APPEARANCE_MEDIA_SLIDER_THUMB_RENDERED /* 4389 */:
      case CSS_VALUE_APPEARANCE_MEDIA_VOLUME_SLIDER_RENDERED /* 4390 */:
      case CSS_VALUE_APPEARANCE_MEDIA_VOLUME_SLIDER_THUMB_RENDERED /* 4391 */:
      case V8_PERFORMANCE_RESOURCE_TIMING_DELIVERY_TYPE_ATTRIBUTE_GETTER /* 4392 */:
      case DOCUMENT_LOADER_DELIVERY_TYPE_NAVIGATIONAL_PREFETCH /* 4393 */:
      case SPECULATION_RULES_HEADER /* 4394 */:
      case SPECULATION_RULES_DOCUMENT_RULES /* 4395 */:
      case FED_CM_IFRAME /* 4396 */:
      case V8_DOCUMENT_PICTURE_IN_PICTURE_REQUEST_WINDOW_METHOD /* 4397 */:
      case V8_DOCUMENT_PICTURE_IN_PICTURE_WINDOW_ATTRIBUTE_GETTER /* 4398 */:
      case V8_DOCUMENT_PICTURE_IN_PICTURE_EVENT_WINDOW_ATTRIBUTE_GETTER /* 4399 */:
      case DOCUMENT_PICTURE_IN_PICTURE_ENTER_EVENT /* 4400 */:
      case SOFT_NAVIGATION_HEURISTICS /* 4401 */:
      case MATH_ML_MATH_ELEMENT /* 4402 */:
      case MATH_ML_MATH_ELEMENT_IN_DOCUMENT /* 4403 */:
      case CSS_AT_RULE_STYLISTIC /* 4404 */:
      case CSS_AT_RULE_STYLESET /* 4405 */:
      case CSS_AT_RULE_CHARACTER_VARIANT /* 4406 */:
      case CSS_AT_RULE_SWASH /* 4407 */:
      case CSS_AT_RULE_ORNAMENTS /* 4408 */:
      case CSS_AT_RULE_ANNOTATION /* 4409 */:
      case SERVICE_WORKER_BYPASS_FETCH_HANDLER_FOR_MAIN_RESOURCE /* 4410 */:
      case V8_DOCUMENT_HAS_PRIVATE_TOKEN_METHOD /* 4411 */:
      case SERVICE_WORKER_SKIPPED_FOR_EMPTY_FETCH_HANDLER /* 4412 */:
      case IMAGE_SET /* 4413 */:
      case WINDOW_CLOSE_HISTORY_LENGTH_ONE /* 4414 */:
      case OBSOLETE_CREATE_NS_RESOLVER_WITH_NON_ELEMENTS /* 4415 */:
      case CSS_VALUE_APPEARANCE_NON_STANDARD /* 4416 */:
      case OBSOLETE_CSS_GET_COMPUTED_ANIMATION_DELAY_ZERO /* 4417 */:
      case GET_EFFECT_TIMING_DELAY_ZERO /* 4418 */:
      case SCROLLEND /* 4419 */:
      case DOM_WINDOW_OPEN_CROSS_ORIGIN_IFRAME /* 4420 */:
      case STREAMING_DECLARATIVE_SHADOW_DOM /* 4421 */:
      case OBSOLETE_DIALOG_CLOSE_WATCHER_CANCEL_SKIPPED /* 4422 */:
      case OBSOLETE_DIALOG_CLOSE_WATCHER_CANCEL_SKIPPED_AND_DEFAULT_PREVENTED /* 4423 */:
      case OBSOLETE_DIALOG_CLOSE_WATCHER_CLOSE_SIGNAL_CLOSED_MULTIPLE /* 4424 */:
      case NO_VARY_SEARCH /* 4425 */:
      case FED_CM_USER_INFO /* 4426 */:
      case IDNA2008_DEVIATION_CHARACTER_IN_HOSTNAME_OF_SUBRESOURCE /* 4427 */:
      case IDNA2008_DEVIATION_CHARACTER_IN_HOSTNAME_OF_I_FRAME /* 4428 */:
      case WINDOW_OPEN_POPUP_ON_MOBILE /* 4429 */:
      case WINDOW_OPENED_AS_POPUP_ON_MOBILE /* 4430 */:
      case PRIVATE_NETWORK_ACCESS_IGNORED_CROSS_ORIGIN_PREFLIGHT_ERROR /* 4431 */:
      case PRIVATE_NETWORK_ACCESS_IGNORED_CROSS_SITE_PREFLIGHT_ERROR /* 4432 */:
      case LINK_REL_PRERENDER_SAME_ORIGIN /* 4433 */:
      case LINK_REL_PRERENDER_SAME_SITE_CROSS_ORIGIN /* 4434 */:
      case LINK_REL_PRERENDER_CROSS_SITE /* 4435 */:
      case CSS_BACKGROUND_CLIP_BORDER /* 4436 */:
      case CSS_BACKGROUND_CLIP_CONTENT /* 4437 */:
      case CSS_BACKGROUND_CLIP_PADDING /* 4438 */:
      case DISABLE_THIRD_PARTY_SESSION_STORAGE_PARTITIONING_AFTER_GENERAL_PARTITIONING /* 4439 */:
      case OBSOLETE_K_CSS_PSEUDO_HAS_CONTAINS_MIX_OF_VALID_AND_INVALID /* 4440 */:
      case OBSOLETE_K_CSS_PSEUDO_IS_WHERE_CONTAINS_MIX_OF_VALID_AND_INVALID /* 4441 */:
      case PRIVATE_NETWORK_ACCESS_FETCHED_SUB_FRAME /* 4442 */:
      case PRIVATE_NETWORK_ACCESS_FETCHED_TOP_FRAME /* 4443 */:
      case DISABLE_THIRD_PARTY_STORAGE_PARTITIONING /* 4444 */:
      case SERVICE_WORKER_FETCH_HANDLER_ADDED_AFTER_INITIALIZATION /* 4445 */:
      case OBSOLETE_CREATE_IMAGE_BITMAP_IMAGE_ORIENTATION_NONE /* 4446 */:
      case WINDOW_MANAGEMENT_PERMISSION_DESCRIPTOR_USED /* 4447 */:
      case WINDOW_PLACEMENT_PERMISSION_DESCRIPTOR_USED /* 4448 */:
      case WINDOW_MANAGEMENT_PERMISSION_POLICY_PARSED /* 4449 */:
      case WINDOW_PLACEMENT_PERMISSION_POLICY_PARSED /* 4450 */:
      case CONTENT_DISPOSITION_IN_SVG_USE /* 4451 */:
      case SAME_DOCUMENT_CROSS_ORIGIN_INITIATOR /* 4452 */:
      case SERVICE_WORKER_FETCH_HANDLER_MODIFIED_AFTER_INITIALIZATION /* 4453 */:
      case OPTION_LABEL_IN_QUIRKS_MODE /* 4454 */:
      case PARSE_FROM_STRING_INCLUDE_SHADOWS /* 4455 */:
      case WEB_APP_MANIFEST_SCOPE_EXTENSIONS /* 4456 */:
      case SERVICE_WORKER_BYPASS_FETCH_HANDLER_FOR_MAIN_RESOURCE_BY_ORIGIN_TRIAL /* 4457 */:
      case OBSOLETE_V8_REG_EXP_UNICODE_SET_INCOMPATIBILITIES_WITH_UNICODE_MODE /* 4458 */:
      case FED_CM_AUTO_REAUTHN /* 4459 */:
      case TOPICS_API_FETCH /* 4460 */:
      case OBSOLETE_TOPICS_API_XHR /* 4461 */:
      case PARSE_FROM_STRING /* 4462 */:
      case OBSOLETE_HTML_PATTERN_REG_EXP_UNICODE_SET_INCOMPATIBILITIES_WITH_UNICODE_MODE /* 4463 */:
      case POPOVER_TYPE_AUTO /* 4464 */:
      case POPOVER_TYPE_MANUAL /* 4465 */:
      case POPOVER_TYPE_INVALID /* 4466 */:
      case CSS_ANCHOR_POSITIONING /* 4467 */:
      case SERVICE_WORKER_EVENT_HANDLER_ADDED_AFTER_INITIALIZATION /* 4468 */:
      case SERVICE_WORKER_EVENT_HANDLER_MODIFIED_AFTER_INITIALIZATION /* 4469 */:
      case AUTHORIZATION_CROSS_ORIGIN /* 4470 */:
      case CSS_COLOR_MIX_FUNCTION /* 4471 */:
      case CSS_COLOR_COLOR_SPECIFIED_SPACE /* 4472 */:
      case CSS_COLOR_LAB_OKLAB /* 4473 */:
      case CSS_COLOR_LCH_OKLCH /* 4474 */:
      case OBSOLETE_CREATE_NS_RESOLVER_WITH_NON_ELEMENTS2 /* 4475 */:
      case GET_DISPLAY_MEDIA_WITH_PREFER_CURRENT_TAB_TRUE /* 4476 */:
      case FENCED_FRAME_CONFIG_ATTRIBUTE /* 4477 */:
      case URL_SEARCH_PARAMS_HAS_DELETE_MULTIPLE_ARGUMENTS /* 4478 */:
      case PAYMENT_HANDLER_MINIMAL_HEADER_UX /* 4479 */:
      case POPOVER_TYPE_HINT /* 4480 */:
      case OBSOLETE_WEB_GPU_WEB_CODECS /* 4481 */:
      case RTC_PEER_CONNECTION_LEGACY_GET_STATS_TRIAL /* 4482 */:
      case EXECUTED_EMPTY_JAVA_SCRIPT_URL_FROM_FRAME /* 4483 */:
      case EXECUTED_JAVA_SCRIPT_URL_FROM_FRAME /* 4484 */:
      case SERVICE_WORKER_BYPASS_FETCH_HANDLER_FOR_SUB_RESOURCE /* 4485 */:
      case CSS_AT_RULE_STARTING_STYLE /* 4486 */:
      case PRIVATE_AGGREGATION_API_FLEDGE_EXTENSIONS /* 4487 */:
      case DEPRECATED_INTEREST_GROUP_DAILY_UPDATE_URL /* 4488 */:
      case CSS_COLOR_GRADIENT_COLOR_SPACE /* 4489 */:
      case DANGLING_MARKUP_IN_WINDOW_NAME /* 4490 */:
      case DANGLING_MARKUP_IN_WINDOW_NAME_NOT_ENDS_WITH_NEW_LINE_OR_GT /* 4491 */:
      case DANGLING_MARKUP_IN_WINDOW_NAME_NOT_ENDS_WITH_GT /* 4492 */:
      case DANGLING_MARKUP_IN_TARGET /* 4493 */:
      case DANGLING_MARKUP_IN_TARGET_NOT_ENDS_WITH_GT /* 4494 */:
      case DANGLING_MARKUP_IN_TARGET_NOT_ENDS_WITH_NEW_LINE_OR_GT /* 4495 */:
      case ATTRIBUTION_FENCED_FRAME_REPORTING_BEACON /* 4496 */:
      case IFRAME_BROWSING_TOPICS_ATTRIBUTE /* 4497 */:
      case SPECULATION_RULES_SELECTOR_MATCHES /* 4498 */:
      case SPECULATION_RULES_EXPLICIT_EAGERNESS /* 4499 */:
      case SPECULATION_RULES_EAGERNESS_CONSERVATIVE /* 4500 */:
      case SPECULATION_RULES_EAGERNESS_MODERATE /* 4501 */:
      case SPECULATION_RULES_EAGERNESS_EAGER /* 4502 */:
      case OBSOLETE_URL_SET_PORT_CHECK_OVERFLOW /* 4503 */:
      case V8_ANIMATION_RANGE_START_ATTRIBUTE_GETTER /* 4504 */:
      case V8_ANIMATION_RANGE_START_ATTRIBUTE_SETTER /* 4505 */:
      case V8_ANIMATION_RANGE_END_ATTRIBUTE_GETTER /* 4506 */:
      case V8_ANIMATION_RANGE_END_ATTRIBUTE_SETTER /* 4507 */:
      case V8_STORAGE_BUCKET_PERSIST_METHOD /* 4508 */:
      case V8_STORAGE_BUCKET_PERSISTED_METHOD /* 4509 */:
      case V8_STORAGE_BUCKET_ESTIMATE_METHOD /* 4510 */:
      case V8_STORAGE_BUCKET_DURABILITY_METHOD /* 4511 */:
      case V8_STORAGE_BUCKET_SET_EXPIRES_METHOD /* 4512 */:
      case V8_STORAGE_BUCKET_EXPIRES_METHOD /* 4513 */:
      case V8_STORAGE_BUCKET_INDEXED_DB_ATTRIBUTE_GETTER /* 4514 */:
      case V8_STORAGE_BUCKET_LOCKS_ATTRIBUTE_GETTER /* 4515 */:
      case V8_STORAGE_BUCKET_CACHES_ATTRIBUTE_GETTER /* 4516 */:
      case V8_STORAGE_BUCKET_GET_DIRECTORY_METHOD /* 4517 */:
      case V8_STORAGE_BUCKET_MANAGER_KEYS_METHOD /* 4518 */:
      case V8_STORAGE_BUCKET_MANAGER_DELETE_METHOD /* 4519 */:
      case NAVIGATOR_UA_DATA_GET_HIGH_ENTROPY_VALUES /* 4520 */:
      case SCHEDULER_YIELD /* 4521 */:
      case HTML_CLIPBOARD_API_UNSANITIZED_READ /* 4522 */:
      case HTML_CLIPBOARD_API_UNSANITIZED_WRITE /* 4523 */:
      case ASYNC_CLIPBOARD_API_UNSANITIZED_READ /* 4524 */:
      case WINDOW_OPEN_FULLSCREEN_REQUESTED /* 4525 */:
      case FULLSCREEN_ALLOWED_BY_WINDOW_OPEN /* 4526 */:
      case ATTRIBUTE_VALUE_CONTAINS_LT_OR_GT /* 4527 */:
      case V8_IMPORT_ASSERTION_DEPRECATED_SYNTAX /* 4528 */:
      case IMAGE_CAPTURE_BACKGROUND_BLUR /* 4529 */:
      case PRIVATE_NETWORK_ACCESS_PREFLIGHT_ERROR /* 4530 */:
      case PRIVATE_NETWORK_ACCESS_PREFLIGHT_SUCCESS /* 4531 */:
      case PRIVATE_NETWORK_ACCESS_PREFLIGHT_WARNING /* 4532 */:
      case CSS_GET_COMPUTED_ANIMATION_DURATION_ZERO /* 4533 */:
      case CSS_GET_COMPUTED_WEBKIT_FONT_SMOOTHING_ANIMATION_DURATION_ZERO /* 4534 */:
      case DOCUMENT_OPEN_ALIASED_ORIGIN_DOCUMENT_DOMAIN /* 4535 */:
      case GAMEPAD_TOUCH_EVENTS /* 4536 */:
      case GAMEPAD_TOUCH_TOUCH_ID /* 4537 */:
      case GAMEPAD_TOUCH_SURFACE_ID /* 4538 */:
      case GAMEPAD_TOUCH_POSITION /* 4539 */:
      case GAMEPAD_TOUCH_SURFACE_DIMENSION /* 4540 */:
      case SANDBOX_VIA_FENCED_FRAME /* 4541 */:
      case VISIBILITY_STATE_OBSERVER /* 4542 */:
      case V8_COMPILE_HINTS_MAGIC_ALL /* 4543 */:
      case OBSOLETE_TEXT_WRAP_BALANCE /* 4544 */:
      case OBSOLETE_TEXT_WRAP_BALANCE_FAIL /* 4545 */:
      case ATTRIBUTION_REPORTING_CROSS_APP_WEB /* 4546 */:
      case SECURE_PAYMENT_CONFIRMATION_ACTIVATIONLESS_SHOW /* 4547 */:
      case SERVICE_WORKER_BYPASS_FETCH_HANDLER_FOR_ALL_WITH_RACE_NETWORK_REQUEST /* 4548 */:
      case FLEX_INTRINSIC_SIZES_CACHE_MISS /* 4549 */:
      case CSS_STYLE_CONTAINER_QUERY /* 4550 */:
      case CSS_VALUE_APPEARANCE_MEDIA_SLIDER /* 4551 */:
      case CSS_VALUE_APPEARANCE_MEDIA_SLIDERTHUMB /* 4552 */:
      case CSS_VALUE_APPEARANCE_MEDIA_VOLUME_SLIDER /* 4553 */:
      case CSS_VALUE_APPEARANCE_MEDIA_VOLUME_SLIDERTHUMB /* 4554 */:
      case CSS_VALUE_APPEARANCE_SLIDER_HORIZONTAL /* 4555 */:
      case CSS_VALUE_APPEARANCE_SLIDER_VERTICAL /* 4556 */:
      case CSS_VALUE_APPEARANCE_SLIDERTHUMB_HORIZONTAL /* 4557 */:
      case CSS_VALUE_APPEARANCE_SLIDERTHUMB_VERTICAL /* 4558 */:
      case SERVICE_WORKER_BYPASS_FETCH_HANDLER_FOR_ALL_WITH_RACE_NETWORK_REQUEST_BY_ORIGIN_TRIAL /* 4559 */:
      case OBSOLETE_EVENT_TIMING_PAINTED_PRESENTATION_PROMISE_RESOLVED_WITH_EARLIER_PROMISE_UNRESOLVED /* 4560 */:
      case LINK_REL_PRELOAD_AS_FONT /* 4561 */:
      case CROSS_WINDOW_ACCESS_TO_BROWSER_GENERATED_DOCUMENT /* 4562 */:
      case SPECULATION_RULES_NO_VARY_SEARCH_HINT /* 4563 */:
      case FILE_SYSTEM_ACCESS_MOVE_RENAME /* 4564 */:
      case FILE_SYSTEM_ACCESS_MOVE_REPARENT /* 4565 */:
      case FILE_SYSTEM_ACCESS_MOVE_REPARENT_AND_RENAME /* 4566 */:
      case V8_FILE_SYSTEM_DIRECTORY_HANDLE_REMOVE_ENTRY_METHOD /* 4567 */:
      case V8_FILE_SYSTEM_FILE_HANDLE_CREATE_WRITABLE_METHOD /* 4568 */:
      case V8_FILE_SYSTEM_FILE_HANDLE_GET_FILE_METHOD /* 4569 */:
      case V8_FILE_SYSTEM_HANDLE_GET_UNIQUE_ID_METHOD /* 4570 */:
      case V8_FILE_SYSTEM_HANDLE_REMOVE_METHOD /* 4571 */:
      case PERFORMANCE_NAVIGATE_SYSTEM_ENTROPY /* 4572 */:
      case V8_INVALIDATED_NUMBER_STRING_NOT_REGEXP_LIKE_PROTECTOR /* 4573 */:
      case CRITICAL_CH_RESTART_NAVIGATION_TIMING /* 4574 */:
      case TOP_LEVEL_DOCUMENT_WITH_EMBEDDED_CREDENTIALS /* 4575 */:
      case V8_NAVIGATOR_GET_INTEREST_GROUP_AD_AUCTION_DATA_METHOD /* 4576 */:
      case LONG_ANIMATION_FRAME_OBSERVER /* 4577 */:
      case LONG_ANIMATION_FRAME_REQUESTED /* 4578 */:
      case FED_CM_LOGIN_HINT /* 4579 */:
      case FED_CM_RP_CONTEXT /* 4580 */:
      case EVENT_TIMING_ARTIFICIAL_POINTERUP_OR_CLICK /* 4581 */:
      case ABORT_SIGNAL_ANY /* 4582 */:
      case FED_CM_IDP_SIGNIN_STATUS_API /* 4583 */:
      case FED_CM_IDP_SIGNIN_STATUS_JS_API /* 4584 */:
      case EXEC_COMMAND /* 4585 */:
      case WEB_GPU_QUEUE_SUBMIT /* 4586 */:
      case WEB_GPU_CANVAS_CONTEXT_GET_CURRENT_TEXTURE /* 4587 */:
      case EDIT_CONTEXT /* 4588 */:
      case SERVICE_WORKER_STATIC_ROUTER_REGISTER_ROUTER /* 4589 */:
      case SERVICE_WORKER_STATIC_ROUTER_EVALUATE /* 4590 */:
      case CLIENT_HINTS_UA_FORM_FACTOR /* 4591 */:
      case URL_SEARCH_PARAMS_HAS_FN_BEHAVIOUR_DIVERGED /* 4592 */:
      case URL_SEARCH_PARAMS_DELETE_FN_BEHAVIOUR_DIVERGED /* 4593 */:
      case OBSOLETE_TEXT_WRAP_PRETTY /* 4594 */:
      case OBSOLETE_TEXT_WRAP_PRETTY_FAIL /* 4595 */:
      case CONTAINER_QUERY_EVAL_UNKNOWN /* 4596 */:
      case OBSOLETE_EVENT_TIMING_PRESENTATION_PROMISE_RESOLVED_AFTER_REPORT /* 4597 */:
      case GET_COALESCED_EVENTS_IN_INSECURE_CONTEXT /* 4598 */:
      case CSPEE_SAME_ORIGIN_BLANKET_ENFORCEMENT /* 4599 */:
      case SHARED_DICTIONARY_USED /* 4601 */:
      case SHARED_DICTIONARY_USED_FOR_NAVIGATION /* 4602 */:
      case SHARED_DICTIONARY_USED_FOR_MAIN_FRAME_NAVIGATION /* 4603 */:
      case SHARED_DICTIONARY_USED_FOR_SUB_FRAME_NAVIGATION /* 4604 */:
      case SHARED_DICTIONARY_USED_FOR_SUBRESOURCE /* 4605 */:
      case PRICE_CHANGE_CONFIRMATION /* 4606 */:
      case PAYMENT_REQUEST_ACTIVATIONLESS_SHOW /* 4607 */:
      case WEB_APP_TABBED /* 4608 */:
      case FETCH_LATER /* 4609 */:
      case URL_PATTERN_RELIANT_ON_IMPLICIT_URL_COMPONENTS_IN_STRING /* 4610 */:
      case URL_PATTERN_RELIANT_ON_LATER_COMPONENT_FROM_BASE_URL /* 4611 */:
      case V8_NAVIGATOR_CREATE_AUCTION_NONCE_METHOD /* 4612 */:
      case CROSS_ORIGIN_WINDOW_FRAME_ELEMENT /* 4613 */:
      case QUIRKS_MODE_ABOUT_BLANK_DOCUMENT /* 4614 */:
      case V8_WASM_MEMORY64 /* 4615 */:
      case V8_WASM_MULTI_MEMORY /* 4616 */:
      case V8_WASM_GC /* 4617 */:
      case OBSOLETE_ORB_BLOCK_WITHOUT_ANY_EVENT_HANDLER /* 4618 */:
      case OBSOLETE_ORB_BLOCK_WITH_ON_ERROR_BUT_WITHOUT_ON_LOAD_EVENT_HANDLER /* 4619 */:
      case OBSOLETE_ORB_BLOCK_WITH_ON_LOAD_BUT_WITHOUT_ON_ERROR_EVENT_HANDLER /* 4620 */:
      case OBSOLETE_ORB_BLOCK_WITH_ON_LOAD_AND_ON_ERROR_EVENT_HANDLER /* 4621 */:
      case OBSOLETE_ORB_BLOCK_WITH_ANY_EVENT_HANDLER /* 4622 */:
      case V8RTC_ENCODED_VIDEO_FRAME_SET_METADATA_METHOD /* 4623 */:
      case V8RTC_ENCODED_VIDEO_FRAME_SET_TIMESTAMP_METHOD /* 4624 */:
      case V8RTC_ENCODED_AUDIO_FRAME_SET_TIMESTAMP_METHOD /* 4625 */:
      case CSS_AT_RULE_VIEW_TRANSITION /* 4626 */:
      case SHARED_DICTIONARY_USED_WITH_SHARED_BROTLI /* 4627 */:
      case SHARED_DICTIONARY_USED_WITH_SHARED_ZSTD /* 4628 */:
      case ZSTD_CONTENT_ENCODING /* 4629 */:
      case GET_ALL_SCREENS_MEDIA /* 4630 */:
      case INPUT_EVENT_TO_RECENTLY_MOVED_IFRAME_MISTAKENLY_DISCARDED /* 4631 */:
      case CSS_RELATIVE_COLOR /* 4632 */:
      case X_PATH_MISSING_VARIABLE_PARSED /* 4633 */:
      case X_PATH_MISSING_VARIABLE_EVALUATED /* 4634 */:
      case CLIENT_HINTS_PREFERS_REDUCED_TRANSPARENCY /* 4635 */:
      case ELEMENT_CAPTURE /* 4636 */:
      case SHARED_STORAGE_API_FETCH_ATTRIBUTE /* 4637 */:
      case SHARED_STORAGE_API_IMAGE_ATTRIBUTE /* 4638 */:
      case SHARED_STORAGE_API_IFRAME_ATTRIBUTE /* 4639 */:
      case VIRTUAL_KEYBOARD_SHOW /* 4640 */:
      case VIRTUAL_KEYBOARD_HIDE /* 4641 */:
      case VIRTUAL_KEYBOARD_OVERLAY_POLICY /* 4642 */:
      case SCROLL_SNAP_NESTED_SNAP_AREAS /* 4643 */:
      case SCROLL_SNAP_COVERING_SNAP_AREA /* 4644 */:
      case V8RTC_ENCODED_AUDIO_FRAME_SET_METADATA_METHOD /* 4645 */:
      case V8_FETCH_LATER_RESULT_ACTIVATED_ATTRIBUTE_GETTER /* 4646 */:
      case V8_WINDOW_FETCH_LATER_METHOD /* 4647 */:
      case FETCH_LATER_INVOKE_STATE_DEFERRED /* 4648 */:
      case FETCH_LATER_INVOKE_STATE_SCHEDULED /* 4649 */:
      case FETCH_LATER_INVOKE_STATE_TERMINATED /* 4650 */:
      case FETCH_LATER_INVOKE_STATE_ABORTED /* 4651 */:
      case FETCH_LATER_INVOKE_STATE_ACTIVATED /* 4652 */:
      case FETCH_LATER_ERROR_UNKNOWN_BODY_LENGTH /* 4653 */:
      case FETCH_LATER_ERROR_QUOTA_EXCEEDED /* 4654 */:
      case V8_FILE_SYSTEM_HANDLE_GET_CLOUD_IDENTIFIERS_METHOD /* 4655 */:
      case PRIVATE_AGGREGATION_API_ENABLE_DEBUG_MODE /* 4656 */:
      case LINE_BREAK_PHRASE /* 4657 */:
      case OBSOLETE_ATTRIBUTION_REPORTING_UNDERSCORE_PREFIXED_FILTER_KEY /* 4658 */:
      case PERCENT_OR_CALC_STICKY_USED_OFFSET /* 4659 */:
      case PERCENT_OR_CALC_RELATIVE_USED_OFFSET /* 4660 */:
      case AUTO_RELATIVE_USED_OFFSET /* 4661 */:
      case VIEWPORT_FIT_CONTAIN /* 4662 */:
      case VIEWPORT_FIT_COVER /* 4663 */:
      case VIEWPORT_FIT_COVER_OR_SAFE_AREA_INSET_BOTTOM /* 4664 */:
      case OUT_OF_FLOW_JUSTIFY_SELF_NO_INSETS /* 4665 */:
      case OUT_OF_FLOW_JUSTIFY_SELF_SINGLE_INSET /* 4666 */:
      case OUT_OF_FLOW_JUSTIFY_SELF_BOTH_INSETS /* 4667 */:
      case OUT_OF_FLOW_ALIGN_SELF_NO_INSETS /* 4668 */:
      case OUT_OF_FLOW_ALIGN_SELF_SINGLE_INSET /* 4669 */:
      case OUT_OF_FLOW_ALIGN_SELF_BOTH_INSETS /* 4670 */:
      case V8_WEB_ASSEMBLY_JS_STRING_BUILTINS /* 4671 */:
      case OBSERVABLE_CONSTRUCTOR /* 4672 */:
      case TEXT_WRAP_BALANCE /* 4673 */:
      case TEXT_WRAP_PRETTY /* 4674 */:
      case V8_POINTER_EVENT_DEVICE_ID_ATTRIBUTE_GETTER /* 4675 */:
      case SOURCE_MAPPING_URL_MAGIC_COMMENT_AT_SIGN /* 4676 */:
      case HTML_DETAILS_ELEMENT_NAME_ATTRIBUTE /* 4677 */:
      case HTML_DETAILS_ELEMENT_NAME_ATTRIBUTE_CLOSES_SELF /* 4678 */:
      case HTML_DETAILS_ELEMENT_NAME_ATTRIBUTE_CLOSES_OTHER /* 4679 */:
      case CSS_SUBGRID_LAYOUT /* 4680 */:
      case V8_TEMPORAL_OBJECT /* 4681 */:
      case CHROME_CSI_UNKNOWN /* 4682 */:
      case CHROME_CSI_ONLOAD_T /* 4683 */:
      case CHROME_CSI_PAGE_T /* 4684 */:
      case CHROME_CSI_START_E /* 4685 */:
      case CHROME_CSI_TRAN /* 4686 */:
      case PARSE_HTML_UNSAFE /* 4687 */:
      case SET_HTML_UNSAFE /* 4688 */:
      case WEB_ASSEMBLY_MODULE_COMPILATION /* 4689 */:
      case V8_MEDIA_STREAM_TRACK_STATS_ATTRIBUTE_GETTER /* 4690 */:
      case ELEMENT_CHECK_VISIBILITY /* 4691 */:
      case V8_CLIPBOARD_ITEM_SUPPORTS_METHOD /* 4692 */:
      case THIRD_PARTY_COOKIE_ACCESS_BLOCK_BY_EXPERIMENT /* 4693 */:
      case CSP_WOULD_BLOCK_IF_WILDCARD_DOES_NOT_MATCH_WS /* 4694 */:
      case CSP_WOULD_BLOCK_IF_WILDCARD_DOES_NOT_MATCH_FTP /* 4695 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES /* 4696 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_ALL /* 4697 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_SESSION_STORAGE /* 4698 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_SESSION_STORAGE_USE /* 4699 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_LOCAL_STORAGE /* 4700 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_LOCAL_STORAGE_USE /* 4701 */:
      case ELEMENT_CHECK_VISIBILITY_OPTION_CHECK_VISIBILITY_CSS /* 4702 */:
      case ELEMENT_CHECK_VISIBILITY_OPTION_CHECK_OPACITY /* 4703 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_INDEXED_DB /* 4704 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_INDEXED_DB_USE /* 4705 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_LOCKS /* 4706 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_LOCKS_USE /* 4707 */:
      case RUBY_ELEMENT_WITH_DISPLAY_BLOCK_AND_RT /* 4708 */:
      case CSS_DECLARATION_AFTER_NESTED_RULE /* 4709 */:
      case THIRD_PARTY_COOKIE_AD_ACCESS_BLOCK_BY_EXPERIMENT /* 4710 */:
      case SERVICE_WORKER_STATIC_ROUTER_ADD_ROUTES /* 4711 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_CACHES /* 4712 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_CACHES_USE /* 4713 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_GET_DIRECTORY /* 4714 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_GET_DIRECTORY_USE /* 4715 */:
      case ELEMENT_CHECK_VISIBILITY_OPTION_CONTENT_VISIBILITY_AUTO /* 4716 */:
      case ELEMENT_CHECK_VISIBILITY_OPTION_OPACITY_PROPERTY /* 4717 */:
      case ELEMENT_CHECK_VISIBILITY_OPTION_VISIBILITY_PROPERTY /* 4718 */:
      case AD_CLICK_MAIN_FRAME_NAVIGATION /* 4719 */:
      case LINK_REL_PRIVACY_POLICY /* 4720 */:
      case LINK_REL_TERMS_OF_SERVICE /* 4721 */:
      case WEB_APP_MANIFEST_ID_FIELD /* 4722 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_ESTIMATE /* 4723 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_ESTIMATE_USE /* 4724 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_CREATE_OBJECT_URL /* 4725 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_CREATE_OBJECT_URL_USE /* 4726 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_REVOKE_OBJECT_URL /* 4727 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_REVOKE_OBJECT_URL_USE /* 4728 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_BROADCAST_CHANNEL /* 4729 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_BROADCAST_CHANNEL_USE /* 4730 */:
      case THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY_EXPLICIT_SETTING /* 4731 */:
      case THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY_GLOBAL_SETTING /* 4732 */:
      case THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY3_PCD_METADATA /* 4733 */:
      case THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY3_PCD /* 4734 */:
      case THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY3_PCD_HEURISTICS /* 4735 */:
      case THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY_STORAGE_ACCESS /* 4736 */:
      case THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY_TOP_LEVEL_STORAGE_ACCESS /* 4737 */:
      case IFRAME_AD_AUCTION_HEADERS_ATTRIBUTE /* 4738 */:
      case AUTO_SPECULATION_RULES_OPTED_OUT /* 4739 */:
      case OVERRIDE_FLASH_EMBEDWITH_HTML /* 4740 */:
      case LINK_REL_OPENER /* 4741 */:
      case LINK_REL_OPENER_TARGETING_SAME_FRAME /* 4742 */:
      case CSS_SELECTOR_PSEUDO_HAS /* 4743 */:
      case WAKE_LOCK_ACQUIRE_SCREEN_LOCK_WITHOUT_STICKY_ACTIVATION /* 4744 */:
      case SUBTLE_CRYPTO_DERIVE_BITS_ZERO_LENGTH /* 4745 */:
      case SUBTLE_CRYPTO_DERIVE_BITS_TRUNCATION /* 4746 */:
      case TEXT_DIRECTIVE_IN_SHADOW_DOM /* 4747 */:
      case PSEUDO_FIRST_LETTER_ON_RT /* 4748 */:
      case PSEUDO_FIRST_LINE_ON_RT /* 4749 */:
      case AUTO_SIZES_LAZY /* 4750 */:
      case AUTO_SIZES_NON_LAZY /* 4751 */:
      case TRUSTED_TYPES_INTROSPECTION /* 4752 */:
      case TRUSTED_TYPES_IS_CHECK /* 4753 */:
      case MOUSE_DRAG_ON_CANCELLED_MOUSE_MOVE /* 4754 */:
      case FED_CM_DOMAIN_HINT /* 4755 */:
      case LCP_IMAGE_WAS_LAZY /* 4756 */:
      case EVENT_TARGET_ON_OBSERVABLE /* 4757 */:
      case CREDENTIAL_MANAGER_CROSS_ORIGIN_PUBLIC_KEY_CREATE_REQUEST /* 4758 */:
      case VIEW_TRANSITION_NAME_AUTO /* 4759 */:
      case V8_WASM_JAVA_SCRIPT_PROMISE_INTEGRATION /* 4760 */:
      case WINDOW_MINIMIZE /* 4761 */:
      case WINDOW_MAXIMIZE /* 4762 */:
      case WINDOW_RESTORE /* 4763 */:
      case WINDOW_SET_RESIZABLE /* 4764 */:
      case V8_WASM_RETURN_CALL /* 4765 */:
      case V8_WASM_EXTENDED_CONST /* 4766 */:
      case V8_WASM_RELAXED_SIMD /* 4767 */:
      case V8_WASM_TYPE_REFLECTION /* 4768 */:
      case V8_WASM_EXN_REF /* 4769 */:
      case V8_WASM_TYPED_FUNC_REF /* 4770 */:
      case HTML_BUTTON_IN_SELECT /* 4771 */:
      case HTML_DATALIST_IN_SELECT /* 4772 */:
      case EFFECTIVE_ALIGN_CONTENT_FOR_BLOCK /* 4773 */:
      case EFFECTIVE_ALIGN_CONTENT_FOR_TABLE_CELL /* 4774 */:
      case USER_FEATURE_NG_OPTIMIZED_IMAGE /* 4775 */:
      case CSS_AT_RULE_PAGE_MARGIN /* 4776 */:
      case THIRD_PARTY_COOKIE_DEPRECATION_ALLOW_BY_ENTERPRISE_POLICY_COOKIE_ALLOWED_FOR_URLS /* 4777 */:
      case USER_FEATURE_NG_AFTER_RENDER /* 4778 */:
      case USER_FEATURE_NG_HYDRATION /* 4779 */:
      case CAPTURED_SURFACE_CONTROL /* 4780 */:
      case ELEMENT_GET_HTML /* 4781 */:
      case ELEMENT_ATTACH_SERIALIZABLE_SHADOW /* 4782 */:
      case CSS_BARE_DECLARATION_SHIFT /* 4783 */:
      case CSS_NESTED_GROUP_RULE_SPECIFICITY /* 4784 */:
      case CSS_RULE_WITH_SIGNALING_CHILD_MODIFIED /* 4785 */:
      case USER_FEATURE_NEXT_THIRD_PARTIES_GA /* 4786 */:
      case USER_FEATURE_NEXT_THIRD_PARTIES_GTM /* 4787 */:
      case USER_FEATURE_NEXT_THIRD_PARTIES_YOU_TUBE_EMBED /* 4788 */:
      case USER_FEATURE_NEXT_THIRD_PARTIES_GOOGLE_MAPS_EMBED /* 4789 */:
      case STORAGE_ACCESS_API_HAS_UNPARTITIONED_COOKIE_ACCESS /* 4790 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_COOKIES /* 4791 */:
      case VISUAL_VIEWPORT_SCROLL_END_FIRED /* 4792 */:
      case ATTRIBUTION_REPORTING_CROSS_APP_WEB_SUPPORT_HEADER /* 4793 */:
      case V8_ELEMENT_ARIA_ACTIVE_DESCENDANT_ELEMENT_ATTRIBUTE_GETTER /* 4794 */:
      case V8_ELEMENT_ARIA_ACTIVE_DESCENDANT_ELEMENT_ATTRIBUTE_SETTER /* 4795 */:
      case V8_ELEMENT_ARIA_CONTROLS_ELEMENTS_ATTRIBUTE_GETTER /* 4796 */:
      case V8_ELEMENT_ARIA_CONTROLS_ELEMENTS_ATTRIBUTE_SETTER /* 4797 */:
      case V8_ELEMENT_ARIA_DESCRIBED_BY_ELEMENTS_ATTRIBUTE_GETTER /* 4798 */:
      case V8_ELEMENT_ARIA_DESCRIBED_BY_ELEMENTS_ATTRIBUTE_SETTER /* 4799 */:
      case V8_ELEMENT_ARIA_DETAILS_ELEMENTS_ATTRIBUTE_GETTER /* 4800 */:
      case V8_ELEMENT_ARIA_DETAILS_ELEMENTS_ATTRIBUTE_SETTER /* 4801 */:
      case V8_ELEMENT_ARIA_ERROR_MESSAGE_ELEMENTS_ATTRIBUTE_GETTER /* 4802 */:
      case V8_ELEMENT_ARIA_ERROR_MESSAGE_ELEMENTS_ATTRIBUTE_SETTER /* 4803 */:
      case V8_ELEMENT_ARIA_FLOW_TO_ELEMENTS_ATTRIBUTE_GETTER /* 4804 */:
      case V8_ELEMENT_ARIA_FLOW_TO_ELEMENTS_ATTRIBUTE_SETTER /* 4805 */:
      case V8_ELEMENT_ARIA_LABELLED_BY_ELEMENTS_ATTRIBUTE_GETTER /* 4806 */:
      case V8_ELEMENT_ARIA_LABELLED_BY_ELEMENTS_ATTRIBUTE_SETTER /* 4807 */:
      case V8_ELEMENT_ARIA_OWNS_ELEMENTS_ATTRIBUTE_GETTER /* 4808 */:
      case V8_ELEMENT_ARIA_OWNS_ELEMENTS_ATTRIBUTE_SETTER /* 4809 */:
      case V8_ELEMENT_INTERNALS_ARIA_ACTIVE_DESCENDANT_ELEMENT_ATTRIBUTE_GETTER /* 4810 */:
      case V8_ELEMENT_INTERNALS_ARIA_ACTIVE_DESCENDANT_ELEMENT_ATTRIBUTE_SETTER /* 4811 */:
      case V8_ELEMENT_INTERNALS_ARIA_CONTROLS_ELEMENTS_ATTRIBUTE_GETTER /* 4812 */:
      case V8_ELEMENT_INTERNALS_ARIA_CONTROLS_ELEMENTS_ATTRIBUTE_SETTER /* 4813 */:
      case V8_ELEMENT_INTERNALS_ARIA_DESCRIBED_BY_ELEMENTS_ATTRIBUTE_GETTER /* 4814 */:
      case V8_ELEMENT_INTERNALS_ARIA_DESCRIBED_BY_ELEMENTS_ATTRIBUTE_SETTER /* 4815 */:
      case V8_ELEMENT_INTERNALS_ARIA_DETAILS_ELEMENTS_ATTRIBUTE_GETTER /* 4816 */:
      case V8_ELEMENT_INTERNALS_ARIA_DETAILS_ELEMENTS_ATTRIBUTE_SETTER /* 4817 */:
      case V8_ELEMENT_INTERNALS_ARIA_ERROR_MESSAGE_ELEMENTS_ATTRIBUTE_GETTER /* 4818 */:
      case V8_ELEMENT_INTERNALS_ARIA_ERROR_MESSAGE_ELEMENTS_ATTRIBUTE_SETTER /* 4819 */:
      case V8_ELEMENT_INTERNALS_ARIA_FLOW_TO_ELEMENTS_ATTRIBUTE_GETTER /* 4820 */:
      case V8_ELEMENT_INTERNALS_ARIA_FLOW_TO_ELEMENTS_ATTRIBUTE_SETTER /* 4821 */:
      case V8_ELEMENT_INTERNALS_ARIA_LABELLED_BY_ELEMENTS_ATTRIBUTE_GETTER /* 4822 */:
      case V8_ELEMENT_INTERNALS_ARIA_LABELLED_BY_ELEMENTS_ATTRIBUTE_SETTER /* 4823 */:
      case V8_ELEMENT_INTERNALS_ARIA_OWNS_ELEMENTS_ATTRIBUTE_GETTER /* 4824 */:
      case V8_ELEMENT_INTERNALS_ARIA_OWNS_ELEMENTS_ATTRIBUTE_SETTER /* 4825 */:
      case IDENTITY_DIGITAL_CREDENTIALS /* 4826 */:
      case CSS_SELECTOR_PSEUDO_STATE /* 4827 */:
      case SPECULATION_RULES_PREFETCH /* 4828 */:
      case SPECULATION_RULES_AUTHOR_PREFETCH_RULE /* 4829 */:
      case SPECULATION_RULES_AUTHOR_PRERENDER_RULE /* 4830 */:
      case SPECULATION_RULES_BROWSER_PREFETCH_RULE /* 4831 */:
      case SPECULATION_RULES_BROWSER_PRERENDER_RULE /* 4832 */:
      case FIRST_PARTY_SHARED_WORKER_SAME_SITE_COOKIES_NONE /* 4833 */:
      case CSS_CUSTOM_STATE_DEPRECATED_SYNTAX /* 4834 */:
      case FULLSCREEN_ALLOWED_BY_CONTENT_SETTING /* 4835 */:
      case SHARED_STORAGE_API_CREATE_WORKLET_METHOD /* 4836 */:
      case CANVAS2_D_LAYERS /* 4837 */:
      case USER_FEATURE_NUXT_IMAGE /* 4838 */:
      case USER_FEATURE_NUXT_PICTURE /* 4839 */:
      case USER_FEATURE_NUXT_THIRD_PARTIES_GA /* 4840 */:
      case USER_FEATURE_NUXT_THIRD_PARTIES_GTM /* 4841 */:
      case USER_FEATURE_NUXT_THIRD_PARTIES_YOU_TUBE_EMBED /* 4842 */:
      case USER_FEATURE_NUXT_THIRD_PARTIES_GOOGLE_MAPS /* 4843 */:
      case SELECT_PARSER_DROPPED_TAG /* 4844 */:
      case INPUT_TYPE_RANGE_HORIZONTAL_LTR /* 4845 */:
      case INPUT_TYPE_RANGE_HORIZONTAL_RTL /* 4846 */:
      case INPUT_TYPE_RANGE_VERTICAL_LTR /* 4847 */:
      case INPUT_TYPE_RANGE_VERTICAL_RTL /* 4848 */:
      case METER_ELEMENT_HORIZONTAL_LTR /* 4849 */:
      case METER_ELEMENT_HORIZONTAL_RTL /* 4850 */:
      case METER_ELEMENT_VERTICAL_LTR /* 4851 */:
      case METER_ELEMENT_VERTICAL_RTL /* 4852 */:
      case PROGRESS_ELEMENT_HORIZONTAL_LTR /* 4853 */:
      case PROGRESS_ELEMENT_HORIZONTAL_RTL /* 4854 */:
      case PROGRESS_ELEMENT_VERTICAL_LTR /* 4855 */:
      case PROGRESS_ELEMENT_VERTICAL_RTL /* 4856 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_SHARED_WORKER /* 4857 */:
      case STORAGE_ACCESS_API_REQUEST_STORAGE_ACCESS_BEYOND_COOKIES_SHARED_WORKER_USE /* 4858 */:
      case V8_POINTER_EVENT_GET_COALESCED_EVENTS_METHOD /* 4859 */:
      case CSS_FUNCTIONS /* 4861 */:
      case CSS_PAGE_RULE /* 4862 */:
      case 4863:
        return true;
      case 1:
      case 2:
      case 3:
      case 6:
      case 7:
      case 8:
      case 9:
      case 11:
      case 12:
      case 17:
      case 22:
      case 28:
      case 46:
      case 48:
      case 50:
      case 54:
      case 56:
      case 58:
      case 59:
      case 60:
      case 64:
      case 65:
      case 66:
      case 67:
      case 68:
      case 71:
      case 72:
      case 73:
      case 75:
      case 76:
      case 81:
      case 82:
      case 86:
      case 87:
      case 88:
      case 89:
      case 91:
      case 92:
      case 93:
      case 94:
      case 95:
      case 99:
      case 100:
      case 101:
      case 102:
      case 103:
      case 104:
      case 105:
      case 106:
      case 107:
      case 108:
      case 109:
      case 110:
      case 113:
      case 114:
      case 118:
      case 119:
      case 120:
      case 121:
      case 122:
      case 126:
      case 127:
      case 139:
      case 140:
      case 141:
      case 142:
      case 149:
      case 150:
      case 151:
      case 152:
      case 153:
      case 154:
      case 155:
      case 156:
      case 157:
      case 158:
      case 159:
      case 160:
      case 161:
      case 162:
      case 163:
      case 174:
      case 175:
      case 187:
      case 188:
      case 189:
      case Role.MATH_ML_OVER /* 194 */:
      case 195:
      case 197:
      case 198:
      case 199:
      case Role.MATH_ML_TEXT /* 206 */:
      case Role.MATH_ML_UNDER /* 207 */:
      case 208:
      case 210:
      case 216:
      case 218:
      case 223:
      case CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH /* 224 */:
      case 225:
      case 226:
      case CssSampleId.ALIAS_WEBKIT_COLUMNS /* 227 */:
      case 228:
      case 229:
      case 230:
      case 231:
      case 232:
      case CssSampleId.FLEX_FLOW /* 236 */:
      case CssSampleId.FLEX_SHRINK /* 238 */:
      case CssSampleId.FLEX_WRAP /* 239 */:
      case 241:
      case CssSampleId.GRID_TEMPLATE_COLUMNS /* 242 */:
      case CssSampleId.GRID_COLUMN_END /* 245 */:
      case 249:
      case 252:
      case KeyboardCode.PA1 /* 253 */:
      case 254:
      case 255:
      case 256:
      case 257:
      case 258:
      case CssSampleId.WEBKIT_LINE_BREAK /* 259 */:
      case CssSampleId.WEBKIT_MARGIN_AFTER_COLLAPSE /* 265 */:
      case CssSampleId.WEBKIT_MARGIN_BEFORE_COLLAPSE /* 266 */:
      case CssSampleId.WEBKIT_MARGIN_BOTTOM_COLLAPSE /* 267 */:
      case CssSampleId.WEBKIT_MARGIN_TOP_COLLAPSE /* 268 */:
      case CssSampleId.WEBKIT_MARGIN_COLLAPSE /* 269 */:
      case CssSampleId.ALIAS_WEBKIT_MARGIN_AFTER /* 270 */:
      case CssSampleId.ALIAS_WEBKIT_MARGIN_BEFORE /* 271 */:
      case CssSampleId.ALIAS_WEBKIT_MARGIN_END /* 272 */:
      case CssSampleId.ALIAS_WEBKIT_MARGIN_START /* 273 */:
      case 275:
      case 277:
      case 278:
      case CssSampleId.WEBKIT_MASK /* 280 */:
      case CssSampleId.WEBKIT_MASK_BOX_IMAGE_SLICE /* 284 */:
      case CssSampleId.WEBKIT_MASK_BOX_IMAGE_WIDTH /* 286 */:
      case CssSampleId.WEBKIT_MASK_POSITION /* 291 */:
      case CssSampleId.WEBKIT_MASK_POSITION_X /* 292 */:
      case CssSampleId.WEBKIT_MASK_POSITION_Y /* 293 */:
      case CssSampleId.WEBKIT_MASK_REPEAT /* 294 */:
      case CssSampleId.ALIAS_WEBKIT_MAX_LOGICAL_WIDTH /* 298 */:
      case CssSampleId.ALIAS_WEBKIT_MAX_LOGICAL_HEIGHT /* 299 */:
      case 300:
      case 301:
      case 302:
      case 303:
      case 305:
      case 313:
      case 314:
      case 315:
      case 316:
      case 317:
      case CssSampleId.ALIAS_WEBKIT_TEXT_EMPHASIS_POSITION /* 319 */:
      case CssSampleId.ALIAS_WEBKIT_TRANSFORM /* 326 */:
      case CssSampleId.WEBKIT_TRANSFORM_ORIGIN_Z /* 330 */:
      case CssSampleId.ALIAS_WEBKIT_TRANSFORM_STYLE /* 331 */:
      case CssSampleId.ALIAS_WEBKIT_TRANSITION /* 332 */:
      case CssSampleId.ALIAS_WEBKIT_TRANSITION_DELAY /* 333 */:
      case CssSampleId.ALIAS_WEBKIT_TRANSITION_DURATION /* 334 */:
      case CssSampleId.ALIAS_WEBKIT_TRANSITION_PROPERTY /* 335 */:
      case CssSampleId.ALIAS_WEBKIT_TRANSITION_TIMING_FUNCTION /* 336 */:
      case CssSampleId.WEBKIT_USER_DRAG /* 337 */:
      case CssSampleId.WEBKIT_USER_MODIFY /* 338 */:
      case CssSampleId.ALIAS_WEBKIT_USER_SELECT /* 339 */:
      case 340:
      case 341:
      case 342:
      case 346:
      case CssSampleId.SHAPE_MARGIN /* 348 */:
      case 349:
      case 354:
      case CssSampleId.CLIP_PATH /* 355 */:
      case CssSampleId.FILTER /* 359 */:
      case CssSampleId.FLOOD_COLOR /* 360 */:
      case CssSampleId.STOP_COLOR /* 363 */:
      case CssSampleId.STOP_OPACITY /* 364 */:
      case CssSampleId.COLOR_INTERPOLATION /* 365 */:
      case CssSampleId.COLOR_INTERPOLATION_FILTERS /* 366 */:
      case 367:
      case CssSampleId.COLOR_RENDERING /* 368 */:
      case CssSampleId.FILL /* 369 */:
      case CssSampleId.FILL_OPACITY /* 370 */:
      case CssSampleId.MARKER_END /* 373 */:
      case CssSampleId.MARKER_MID /* 374 */:
      case CssSampleId.MARKER_START /* 375 */:
      case CssSampleId.MASK_TYPE /* 376 */:
      case CssSampleId.SHAPE_RENDERING /* 377 */:
      case CssSampleId.STROKE /* 378 */:
      case CssSampleId.STROKE_DASHARRAY /* 379 */:
      case CssSampleId.STROKE_DASHOFFSET /* 380 */:
      case CssSampleId.STROKE_LINECAP /* 381 */:
      case CssSampleId.STROKE_LINEJOIN /* 382 */:
      case CssSampleId.STROKE_MITERLIMIT /* 383 */:
      case CssSampleId.STROKE_OPACITY /* 384 */:
      case CssSampleId.STROKE_WIDTH /* 385 */:
      case CssSampleId.DOMINANT_BASELINE /* 388 */:
      case 390:
      case 391:
      case CssSampleId.TEXT_ANCHOR /* 392 */:
      case CssSampleId.WRITING_MODE /* 394 */:
      case 395:
      case 398:
      case 399:
      case CssSampleId.ORIENTATION /* 408 */:
      case 423:
      case CssSampleId.ANIMATION_DIRECTION /* 426 */:
      case CssSampleId.ANIMATION_DURATION /* 427 */:
      case CssSampleId.ANIMATION_FILL_MODE /* 428 */:
      case CssSampleId.ISOLATION /* 436 */:
      case CssSampleId.OBJECT_POSITION /* 437 */:
      case 438:
      case CssSampleId.SHAPE_IMAGE_THRESHOLD /* 439 */:
      case CssSampleId.JUSTIFY_SELF /* 443 */:
      case CssSampleId.SCROLL_BEHAVIOR /* 444 */:
      case CssSampleId.WILL_CHANGE /* 445 */:
      case CssSampleId.TRANSFORM /* 446 */:
      case CssSampleId.TRANSFORM_ORIGIN /* 447 */:
      case CssSampleId.TRANSFORM_STYLE /* 448 */:
      case CssSampleId.PERSPECTIVE /* 449 */:
      case CssSampleId.PERSPECTIVE_ORIGIN /* 450 */:
      case CssSampleId.BACKFACE_VISIBILITY /* 451 */:
      case CssSampleId.GRID_TEMPLATE /* 452 */:
      case CssSampleId.GRID /* 453 */:
      case CssSampleId.ALL /* 454 */:
      case CssSampleId.Y /* 462 */:
      case CssSampleId.RY /* 464 */:
      case CssSampleId.ALIAS_EPUB_TEXT_EMPHASIS_COLOR /* 472 */:
      case CssSampleId.ALIAS_EPUB_TEXT_ORIENTATION /* 474 */:
      case CssSampleId.ALIAS_EPUB_WRITING_MODE /* 477 */:
      case CssSampleId.ALIAS_WEBKIT_ALIGN_CONTENT /* 478 */:
      case CssSampleId.ALIAS_WEBKIT_BOX_SIZING /* 485 */:
      case CssSampleId.ALIAS_WEBKIT_FLEX /* 486 */:
      case CssSampleId.ALIAS_WEBKIT_FLEX_BASIS /* 487 */:
      case CssSampleId.ALIAS_WEBKIT_FLEX_DIRECTION /* 488 */:
      case CssSampleId.ALIAS_WEBKIT_FLEX_FLOW /* 489 */:
      case CssSampleId.ALIAS_WEBKIT_FLEX_GROW /* 490 */:
      case CssSampleId.ALIAS_WEBKIT_SHAPE_IMAGE_THRESHOLD /* 496 */:
      case CssSampleId.ALIAS_WEBKIT_SHAPE_MARGIN /* 497 */:
      case CssSampleId.ALIAS_WEBKIT_SHAPE_OUTSIDE /* 498 */:
      case CssSampleId.SCROLL_SNAP_TYPE /* 499 */:
      case 500:
      case 511:
      case 512:
      case 513:
      case CssSampleId.FONT_FEATURE_SETTINGS /* 514 */:
      case CssSampleId.VARIABLE /* 515 */:
      case CssSampleId.FONT_DISPLAY /* 516 */:
      case CssSampleId.CONTAIN /* 517 */:
      case CssSampleId.D /* 518 */:
      case CssSampleId.COLUMN_RULE_COLOR /* 526 */:
      case CssSampleId.COLUMN_RULE_STYLE /* 527 */:
      case CssSampleId.COLUMN_RULE_WIDTH /* 528 */:
      case CssSampleId.TEXT_SIZE_ADJUST /* 536 */:
      case CssSampleId.ALIAS_WEBKIT_TEXT_SIZE_ADJUST /* 537 */:
      case CssSampleId.OVERFLOW_ANCHOR /* 538 */:
      case CssSampleId.USER_SELECT /* 539 */:
      case CssSampleId.OFFSET /* 543 */:
      case CssSampleId.OFFSET_ANCHOR /* 544 */:
      case CssSampleId.SCROLL_PADDING_LEFT /* 566 */:
      case CssSampleId.SCROLL_PADDING_BLOCK /* 567 */:
      case CssSampleId.SCROLL_PADDING_BLOCK_START /* 568 */:
      case CssSampleId.SCROLL_MARGIN_RIGHT /* 575 */:
      case CssSampleId.SCROLL_MARGIN_LEFT /* 577 */:
      case CssSampleId.SCROLL_MARGIN_BLOCK_START /* 579 */:
      case CssSampleId.SCROLL_MARGIN_BLOCK_END /* 580 */:
      case CssSampleId.MARGIN_BLOCK_START /* 594 */:
      case CssSampleId.MARGIN_BLOCK_END /* 595 */:
      case CssSampleId.MARGIN_INLINE_START /* 596 */:
      case CssSampleId.MARGIN_INLINE_END /* 597 */:
      case CssSampleId.PADDING_BLOCK_START /* 598 */:
      case 600:
      case 601:
      case 602:
      case 604:
      case 605:
      case CssSampleId.MARGIN_INLINE /* 619 */:
      case CssSampleId.PADDING_BLOCK /* 620 */:
      case CssSampleId.PADDING_INLINE /* 621 */:
      case CssSampleId.BORDER_BLOCK_COLOR /* 622 */:
      case CssSampleId.BORDER_BLOCK_STYLE /* 623 */:
      case CssSampleId.BORDER_BLOCK_WIDTH /* 624 */:
      case CssSampleId.BORDER_INLINE_COLOR /* 625 */:
      case CssSampleId.BORDER_INLINE_STYLE /* 626 */:
      case CssSampleId.BORDER_INLINE_WIDTH /* 627 */:
      case CssSampleId.OVERSCROLL_BEHAVIOR_INLINE /* 644 */:
      case CssSampleId.CONTAIN_INTRINSIC_WIDTH /* 652 */:
      case 653:
      case CssSampleId.ORIGIN_TRIAL_TEST_PROPERTY /* 654 */:
      case 655:
      case CssSampleId.MATH_STYLE /* 656 */:
      case CssSampleId.ASPECT_RATIO /* 657 */:
      case CssSampleId.APPEARANCE /* 658 */:
      case 659:
      case CssSampleId.RUBY_POSITION /* 660 */:
      case 678:
      case CssSampleId.SYSTEM /* 681 */:
      case CssSampleId.NEGATIVE /* 682 */:
      case CssSampleId.PREFIX /* 683 */:
      case CssSampleId.SUFFIX /* 684 */:
      case CssSampleId.SPEAK_AS /* 690 */:
      case CssSampleId.BORDER_START_END_RADIUS /* 692 */:
      case CssSampleId.BORDER_END_START_RADIUS /* 693 */:
      case 702:
      case CssSampleId.FONT_SYNTHESIS_SMALL_CAPS /* 703 */:
      case 704:
      case 705:
      case 706:
      case CssSampleId.TEXT_EMPHASIS_STYLE /* 708 */:
      case CssSampleId.FONT_PALETTE /* 709 */:
      case CssSampleId.TEXT_WRAP /* 746 */:
      case CssSampleId.TEXT_BOX_TRIM /* 747 */:
      case CssSampleId.WHITE_SPACE_COLLAPSE /* 749 */:
      case CssSampleId.VIEW_TIMELINE_ATTACHMENT /* 751 */:
      case CssSampleId.SCROLL_START_BLOCK /* 752 */:
      case CssSampleId.SCROLL_START_INLINE /* 753 */:
      case CssSampleId.SCROLL_START_X /* 754 */:
      case CssSampleId.SCROLL_START_Y /* 755 */:
      case CssSampleId.SCROLL_START /* 756 */:
      case CssSampleId.SCROLL_START_TARGET_BLOCK /* 757 */:
      case CssSampleId.DYNAMIC_RANGE_LIMIT /* 769 */:
      case CssSampleId.TEXT_SPACING_TRIM /* 771 */:
      case CssSampleId.MASK_SIZE /* 774 */:
      case CssSampleId.MASK_ORIGIN /* 775 */:
      case CssSampleId.TEXT_SPACING /* 776 */:
      case CssSampleId.MASK_REPEAT /* 777 */:
      case CssSampleId.MASK_POSITION /* 779 */:
      case 788:
      case 789:
      case 790:
      case 792:
      case 793:
      case 794:
      case 795:
      case 796:
      case 797:
      case 800:
      case 803:
      case 805:
      case 814:
      case 815:
      case 819:
      case 820:
      case 821:
      case 822:
      case 823:
      case 824:
      case 825:
      case 826:
      case 827:
      case 828:
      case 829:
      case 833:
      case 834:
      case 839:
      case 840:
      case 841:
      case 842:
      case 844:
      case 846:
      case 847:
      case 848:
      case 849:
      case 852:
      case 872:
      case 874:
      case 875:
      case 877:
      case 878:
      case 886:
      case 887:
      case 888:
      case 889:
      case 890:
      case 891:
      case 916:
      case 920:
      case 925:
      case 935:
      case 941:
      case 942:
      case 943:
      case 944:
      case 945:
      case 957:
      case 958:
      case 959:
      case 964:
      case 965:
      case 967:
      case 968:
      case 980:
      case 984:
      case 985:
      case 986:
      case 991:
      case 992:
      case 995:
      case 996:
      case 1026:
      case 1034:
      case 1043:
      case 1048:
      case 1061:
      case 1063:
      case 1073:
      case 1094:
      case 1095:
      case 1112:
      case 1113:
      case 1120:
      case 1121:
      case 1122:
      case 1154:
      case 1155:
      case 1160:
      case 1161:
      case 1163:
      case 1164:
      case 1165:
      case 1167:
      case 1175:
      case 1177:
      case 1178:
      case 1179:
      case 1180:
      case 1181:
      case 1185:
      case 1187:
      case 1189:
      case 1191:
      case 1192:
      case 1193:
      case 1194:
      case 1197:
      case 1198:
      case 1199:
      case 1200:
      case 1202:
      case 1203:
      case 1204:
      case 1205:
      case 1206:
      case 1207:
      case 1208:
      case 1209:
      case 1210:
      case 1211:
      case 1212:
      case 1213:
      case 1214:
      case 1215:
      case 1216:
      case 1217:
      case 1218:
      case 1219:
      case 1220:
      case 1222:
      case 1223:
      case 1225:
      case 1226:
      case 1232:
      case 1241:
      case 1242:
      case 1243:
      case 1244:
      case 1251:
      case 1252:
      case 1253:
      case 1254:
      case 1255:
      case 1256:
      case 1257:
      case 1258:
      case 1259:
      case 1260:
      case 1261:
      case 1262:
      case 1264:
      case 1266:
      case 1274:
      case 1276:
      case 1279:
      case 1280:
      case 1281:
      case 1282:
      case 1283:
      case 1284:
      case 1285:
      case 1286:
      case 1295:
      case 1296:
      case 1305:
      case 1310:
      case 1311:
      case 1312:
      case 1313:
      case 1314:
      case 1315:
      case 1316:
      case 1317:
      case 1318:
      case 1319:
      case 1323:
      case 1324:
      case 1339:
      case 1340:
      case 1341:
      case 1348:
      case 1349:
      case 1350:
      case 1355:
      case 1372:
      case 1373:
      case 1374:
      case 1379:
      case 1380:
      case 1381:
      case 1382:
      case 1387:
      case 1388:
      case 1399:
      case 1420:
      case 1434:
      case 1469:
      case 1470:
      case 1473:
      case 1509:
      case 1510:
      case 1511:
      case 1512:
      case 1513:
      case 1514:
      case 1515:
      case 1516:
      case 1517:
      case 1518:
      case 1537:
      case 1538:
      case 1547:
      case 1549:
      case 1552:
      case 1557:
      case 1559:
      case 1560:
      case 1561:
      case 1562:
      case 1563:
      case 1564:
      case 1565:
      case 1566:
      case 1567:
      case 1568:
      case 1569:
      case 1570:
      case 1571:
      case 1572:
      case 1573:
      case 1574:
      case 1575:
      case 1576:
      case 1577:
      case 1578:
      case 1579:
      case 1580:
      case 1587:
      case 1588:
      case 1607:
      case 1608:
      case 1609:
      case 1610:
      case 1611:
      case 1612:
      case 1613:
      case 1614:
      case 1616:
      case 1637:
      case 1645:
      case 1647:
      case 1652:
      case 1653:
      case 1655:
      case 1663:
      case 1691:
      case 1694:
      case 1695:
      case 1768:
      case 1769:
      case 1770:
      case 1771:
      case 1772:
      case 1773:
      case 1774:
      case 1775:
      case 1776:
      case 1778:
      case 1781:
      case 1793:
      case 1794:
      case 1795:
      case 1796:
      case 1801:
      case 1813:
      case 1814:
      case 1818:
      case 1819:
      case 1820:
      case 1821:
      case 1822:
      case 1828:
      case 1829:
      case 1858:
      case 1859:
      case 1860:
      case 1868:
      case 1876:
      case 1880:
      case 1881:
      case 1915:
      case 1917:
      case 1939:
      case 1940:
      case 1941:
      case 1942:
      case 1960:
      case 1966:
      case 1976:
      case 1980:
      case 1983:
      case 1985:
      case 1986:
      case 1987:
      case 1988:
      case 1994:
      case 1998:
      case 1999:
      case 2002:
      case 2003:
      case 2004:
      case 2005:
      case 2006:
      case 2009:
      case 2011:
      case 2024:
      case 2055:
      case 2056:
      case 2057:
      case 2058:
      case 2059:
      case 2067:
      case 2068:
      case 2088:
      case 2120:
      case 2147:
      case 2148:
      case 2149:
      case 2150:
      case 2151:
      case 2152:
      case 2153:
      case 2154:
      case 2155:
      case 2156:
      case 2158:
      case 2159:
      case 2160:
      case 2161:
      case 2177:
      case 2178:
      case 2179:
      case 2180:
      case 2181:
      case 2182:
      case 2183:
      case 2184:
      case 2185:
      case 2186:
      case 2187:
      case 2193:
      case 2202:
      case 2211:
      case 2212:
      case 2213:
      case 2216:
      case 2231:
      case 2233:
      case 2234:
      case 2235:
      case 2245:
      case 2246:
      case 2296:
      case 2327:
      case 2335:
      case 2336:
      case 2337:
      case 2338:
      case 2339:
      case 2340:
      case 2341:
      case 2342:
      case 2343:
      case 2344:
      case 2345:
      case 2368:
      case 2374:
      case 2377:
      case 2433:
      case 2435:
      case 2464:
      case 2481:
      case 2482:
      case 2501:
      case 2502:
      case 2503:
      case 2504:
      case 2505:
      case 2506:
      case 2528:
      case 2534:
      case 2535:
      case 2555:
      case 2556:
      case 2560:
      case 2562:
      case 2564:
      case 2566:
      case 2569:
      case 2571:
      case 2573:
      case 2575:
      case 2577:
      case 2579:
      case 2581:
      case 2583:
      case 2585:
      case 2587:
      case 2588:
      case 2632:
      case 2633:
      case 2645:
      case 2646:
      case 2647:
      case 2652:
      case 2732:
      case 2773:
      case 2774:
      case 2775:
      case 2784:
      case 2788:
      case 2796:
      case 2797:
      case 2798:
      case 2799:
      case 2800:
      case 2801:
      case 2802:
      case 2803:
      case 2804:
      case 2805:
      case 2806:
      case 2807:
      case 2808:
      case 2809:
      case 2810:
      case 2811:
      case 2817:
      case 2822:
      case 2824:
      case 2825:
      case 2828:
      case 2840:
      case 2905:
      case 2921:
      case 2926:
      case 2936:
      case 2948:
      case 2950:
      case 2963:
      case 2964:
      case 2965:
      case 2966:
      case 2967:
      case 2968:
      case 2969:
      case 2970:
      case 2980:
      case 3010:
      case 3011:
      case 3031:
      case 3045:
      case 3156:
      case 3201:
      case 3204:
      case 3205:
      case 3208:
      case 3209:
      case 3210:
      case 3213:
      case 3216:
      case 3218:
      case 3223:
      case 3316:
      case 3317:
      case 3318:
      case 3319:
      case 3337:
      case 3343:
      case 3356:
      case 3357:
      case 3358:
      case 3473:
      case 3474:
      case 3475:
      case 3476:
      case 3745:
      case 3801:
      case 3802:
      case 3929:
      case 3991:
      case 4022:
      case 4060:
      case 4600:
      case 4860:
      default:
        return false;
    }
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private WebFeature() {}
}
