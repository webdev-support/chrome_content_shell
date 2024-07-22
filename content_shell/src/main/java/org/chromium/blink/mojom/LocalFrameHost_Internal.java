package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Range;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.RectF;
import org.chromium.gfx.mojom.Size;
import org.chromium.gfx.mojom.Vector2d;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.BigString16;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.TextDirection;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.network.mojom.AttributionReportingRuntimeFeatures;
import org.chromium.network.mojom.RequestDestination;
import org.chromium.skia.mojom.BitmapN32;
import org.chromium.skia.mojom.SkColor;
import org.chromium.skia.mojom.SkColor4f;
import org.chromium.ui.mojom.ScrollGranularity;
import org.chromium.ui.mojom.VirtualKeyboardMode;
import org.chromium.url.mojom.Url;

class LocalFrameHost_Internal {
  private static final int BUBBLE_LOGICAL_SCROLL_IN_PARENT_FRAME_ORDINAL = 21;
  private static final int CAPTURE_PAINT_PREVIEW_OF_SUBFRAME_ORDINAL = 55;
  private static final int CREATE_FENCED_FRAME_ORDINAL = 71;
  private static final int CREATE_NEW_POPUP_WIDGET_ORDINAL = 48;
  private static final int DETACH_ORDINAL = 57;
  private static final int DID_ADD_MESSAGE_TO_CONSOLE_ORDINAL = 59;
  private static final int DID_BLOCK_NAVIGATION_ORDINAL = 23;
  private static final int DID_CALL_FOCUS_ORDINAL = 15;
  private static final int DID_CHANGE_BACKGROUND_COLOR_ORDINAL = 12;
  private static final int DID_CHANGE_FRAME_OWNER_PROPERTIES_ORDINAL = 51;
  private static final int DID_CHANGE_FRAME_POLICY_ORDINAL = 53;
  private static final int DID_CHANGE_IFRAME_ATTRIBUTES_ORDINAL = 54;
  private static final int DID_CHANGE_LOAD_PROGRESS_ORDINAL = 24;
  private static final int DID_CHANGE_OPENER_ORDINAL = 52;
  private static final int DID_CHANGE_SRC_DOC_ORDINAL = 62;
  private static final int DID_CHANGE_THEME_COLOR_ORDINAL = 11;
  private static final int DID_CONSUME_HISTORY_USER_ACTIVATION_ORDINAL = 33;
  private static final int DID_CONTAIN_INSECURE_FORM_ACTION_ORDINAL = 6;
  private static final int DID_DISPATCH_DOM_CONTENT_LOADED_EVENT_ORDINAL = 38;
  private static final int DID_DISPLAY_INSECURE_CONTENT_ORDINAL = 5;
  private static final int DID_FAIL_LOAD_WITH_ERROR_ORDINAL = 13;
  private static final int DID_FINISH_LOAD_ORDINAL = 25;
  private static final int DID_FOCUS_FRAME_ORDINAL = 14;
  private static final int DID_INFER_COLOR_SCHEME_ORDINAL = 61;
  private static final int DID_LOAD_RESOURCE_FROM_MEMORY_CACHE_ORDINAL = 50;
  private static final int DISABLE_UNTRUSTED_NETWORK_IN_FENCED_FRAME_ORDINAL = 66;
  private static final int DISPATCH_LOAD_ORDINAL = 26;
  private static final int DOCUMENT_ON_LOAD_COMPLETED_ORDINAL = 36;
  private static final int DOWNLOAD_URL_ORDINAL = 44;
  private static final int ENFORCE_INSECURE_NAVIGATIONS_SET_ORDINAL = 17;
  private static final int ENFORCE_INSECURE_REQUEST_POLICY_ORDINAL = 16;
  private static final int ENTER_FULLSCREEN_ORDINAL = 0;
  private static final int EXIT_FULLSCREEN_ORDINAL = 1;
  private static final int FOCUSED_ELEMENT_CHANGED_ORDINAL = 45;
  private static final int FORWARD_RESOURCE_TIMING_TO_PARENT_ORDINAL = 37;
  private static final int FRAME_SIZE_CHANGED_ORDINAL = 60;
  private static final int FULLSCREEN_STATE_CHANGED_ORDINAL = 2;
  private static final int GET_KEEP_ALIVE_HANDLE_FACTORY_ORDINAL = 58;
  private static final int GO_TO_ENTRY_AT_OFFSET_ORDINAL = 27;
  private static final int HAD_STICKY_USER_ACTIVATION_BEFORE_NAVIGATION_CHANGED_ORDINAL = 19;
  private static final int HANDLE_ACCESSIBILITY_FIND_IN_PAGE_RESULT_ORDINAL = 34;
  private static final int HANDLE_ACCESSIBILITY_FIND_IN_PAGE_TERMINATION_ORDINAL = 35;
  private static final int MAIN_DOCUMENT_ELEMENT_AVAILABLE_ORDINAL = 7;
  public static final Interface.Manager<LocalFrameHost, LocalFrameHost.Proxy> MANAGER =
      new Interface.Manager<LocalFrameHost, LocalFrameHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.LocalFrameHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public LocalFrameHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, LocalFrameHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public LocalFrameHost[] buildArray(int size) {
          return new LocalFrameHost[size];
        }
      };
  private static final int NAVIGATE_EVENT_HANDLER_PRESENCE_CHANGED_ORDINAL = 29;
  private static final int NAVIGATE_TO_NAVIGATION_API_KEY_ORDINAL = 28;
  private static final int ON_VIEW_TRANSITION_OPT_IN_CHANGED_ORDINAL = 72;
  private static final int RECEIVED_DELEGATED_CAPABILITY_ORDINAL = 63;
  private static final int REGISTER_PROTOCOL_HANDLER_ORDINAL = 3;
  private static final int RUN_BEFORE_UNLOAD_CONFIRM_ORDINAL = 42;
  private static final int RUN_MODAL_ALERT_DIALOG_ORDINAL = 39;
  private static final int RUN_MODAL_CONFIRM_DIALOG_ORDINAL = 40;
  private static final int RUN_MODAL_PROMPT_DIALOG_ORDINAL = 41;
  private static final int SCROLL_RECT_TO_VISIBLE_IN_PARENT_FRAME_ORDINAL = 20;
  private static final int SEND_FENCED_FRAME_REPORTING_BEACON_ORDINAL = 64;
  private static final int SEND_FENCED_FRAME_REPORTING_BEACON_TO_CUSTOM_URL_ORDINAL = 65;
  private static final int SEND_LEGACY_TECH_EVENT_ORDINAL = 67;
  private static final int SEND_PRIVATE_AGGREGATION_REQUESTS_FOR_FENCED_FRAME_EVENT_ORDINAL = 69;
  private static final int SET_ATTRIBUTION_REPORTING_RUNTIME_FEATURES_ORDINAL = 70;
  private static final int SET_CLOSE_LISTENER_ORDINAL = 56;
  private static final int SET_FENCED_FRAME_AUTOMATIC_BEACON_REPORT_EVENT_DATA_ORDINAL = 68;
  private static final int SET_NEEDS_OCCLUSION_TRACKING_ORDINAL = 8;
  private static final int SET_VIRTUAL_KEYBOARD_MODE_ORDINAL = 9;
  private static final int SHOW_CONTEXT_MENU_ORDINAL = 49;
  private static final int SHOW_POPUP_MENU_ORDINAL = 47;
  private static final int START_DRAGGING_ORDINAL = 73;
  private static final int START_LOADING_FOR_ASYNC_NAVIGATION_API_COMMIT_ORDINAL = 22;
  private static final int SUDDEN_TERMINATION_DISABLER_CHANGED_ORDINAL = 18;
  private static final int TEXT_SELECTION_CHANGED_ORDINAL = 46;
  private static final int UNREGISTER_PROTOCOL_HANDLER_ORDINAL = 4;
  private static final int UPDATE_APP_TITLE_ORDINAL = 31;
  private static final int UPDATE_FAVICON_URL_ORDINAL = 43;
  private static final int UPDATE_TITLE_ORDINAL = 30;
  private static final int UPDATE_USER_ACTIVATION_STATE_ORDINAL = 32;
  private static final int VISIBILITY_CHANGED_ORDINAL = 10;

  LocalFrameHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements LocalFrameHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void enterFullscreen(FullscreenOptions options, EnterFullscreen_Response callback) {
      LocalFrameHostEnterFullscreenParams _message = new LocalFrameHostEnterFullscreenParams();
      _message.options = options;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new LocalFrameHostEnterFullscreenResponseParamsForwardToCallback(callback));
    }

    @Override
    public void exitFullscreen() {
      LocalFrameHostExitFullscreenParams _message = new LocalFrameHostExitFullscreenParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void fullscreenStateChanged(boolean isFullscreen, FullscreenOptions options) {
      LocalFrameHostFullscreenStateChangedParams _message =
          new LocalFrameHostFullscreenStateChangedParams();
      _message.isFullscreen = isFullscreen;
      _message.options = options;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void registerProtocolHandler(String scheme, Url url, boolean userGesture) {
      LocalFrameHostRegisterProtocolHandlerParams _message =
          new LocalFrameHostRegisterProtocolHandlerParams();
      _message.scheme = scheme;
      _message.url = url;
      _message.userGesture = userGesture;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void unregisterProtocolHandler(String scheme, Url url, boolean userGesture) {
      LocalFrameHostUnregisterProtocolHandlerParams _message =
          new LocalFrameHostUnregisterProtocolHandlerParams();
      _message.scheme = scheme;
      _message.url = url;
      _message.userGesture = userGesture;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void didDisplayInsecureContent() {
      LocalFrameHostDidDisplayInsecureContentParams _message =
          new LocalFrameHostDidDisplayInsecureContentParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void didContainInsecureFormAction() {
      LocalFrameHostDidContainInsecureFormActionParams _message =
          new LocalFrameHostDidContainInsecureFormActionParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void mainDocumentElementAvailable(boolean usesTemporaryZoomLevel) {
      LocalFrameHostMainDocumentElementAvailableParams _message =
          new LocalFrameHostMainDocumentElementAvailableParams();
      _message.usesTemporaryZoomLevel = usesTemporaryZoomLevel;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void setNeedsOcclusionTracking(boolean needsTracking) {
      LocalFrameHostSetNeedsOcclusionTrackingParams _message =
          new LocalFrameHostSetNeedsOcclusionTrackingParams();
      _message.needsTracking = needsTracking;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void setVirtualKeyboardMode(int type) {
      LocalFrameHostSetVirtualKeyboardModeParams _message =
          new LocalFrameHostSetVirtualKeyboardModeParams();
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void visibilityChanged(int visibility) {
      LocalFrameHostVisibilityChangedParams _message = new LocalFrameHostVisibilityChangedParams();
      _message.visibility = visibility;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }

    @Override
    public void didChangeThemeColor(SkColor themeColor) {
      LocalFrameHostDidChangeThemeColorParams _message =
          new LocalFrameHostDidChangeThemeColorParams();
      _message.themeColor = themeColor;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
    }

    @Override
    public void didChangeBackgroundColor(SkColor4f backgroundColor, boolean colorAdjust) {
      LocalFrameHostDidChangeBackgroundColorParams _message =
          new LocalFrameHostDidChangeBackgroundColorParams();
      _message.backgroundColor = backgroundColor;
      _message.colorAdjust = colorAdjust;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
    }

    @Override
    public void didFailLoadWithError(Url url, int errorCode) {
      LocalFrameHostDidFailLoadWithErrorParams _message =
          new LocalFrameHostDidFailLoadWithErrorParams();
      _message.url = url;
      _message.errorCode = errorCode;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13)));
    }

    @Override
    public void didFocusFrame() {
      LocalFrameHostDidFocusFrameParams _message = new LocalFrameHostDidFocusFrameParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(14)));
    }

    @Override
    public void didCallFocus() {
      LocalFrameHostDidCallFocusParams _message = new LocalFrameHostDidCallFocusParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(15)));
    }

    @Override
    public void enforceInsecureRequestPolicy(int policyBitmap) {
      LocalFrameHostEnforceInsecureRequestPolicyParams _message =
          new LocalFrameHostEnforceInsecureRequestPolicyParams();
      _message.policyBitmap = policyBitmap;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(16)));
    }

    @Override
    public void enforceInsecureNavigationsSet(int[] set) {
      LocalFrameHostEnforceInsecureNavigationsSetParams _message =
          new LocalFrameHostEnforceInsecureNavigationsSetParams();
      _message.set = set;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(17)));
    }

    @Override
    public void suddenTerminationDisablerChanged(boolean present, int disablerType) {
      LocalFrameHostSuddenTerminationDisablerChangedParams _message =
          new LocalFrameHostSuddenTerminationDisablerChangedParams();
      _message.present = present;
      _message.disablerType = disablerType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(18)));
    }

    @Override
    public void hadStickyUserActivationBeforeNavigationChanged(boolean hasGesture) {
      LocalFrameHostHadStickyUserActivationBeforeNavigationChangedParams _message =
          new LocalFrameHostHadStickyUserActivationBeforeNavigationChangedParams();
      _message.hasGesture = hasGesture;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(19)));
    }

    @Override
    public void scrollRectToVisibleInParentFrame(RectF rectToScroll, ScrollIntoViewParams params) {
      LocalFrameHostScrollRectToVisibleInParentFrameParams _message =
          new LocalFrameHostScrollRectToVisibleInParentFrameParams();
      _message.rectToScroll = rectToScroll;
      _message.params = params;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(20)));
    }

    @Override
    public void bubbleLogicalScrollInParentFrame(int direction, int granularity) {
      LocalFrameHostBubbleLogicalScrollInParentFrameParams _message =
          new LocalFrameHostBubbleLogicalScrollInParentFrameParams();
      _message.direction = direction;
      _message.granularity = granularity;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(21)));
    }

    @Override
    public void startLoadingForAsyncNavigationApiCommit() {
      LocalFrameHostStartLoadingForAsyncNavigationApiCommitParams _message =
          new LocalFrameHostStartLoadingForAsyncNavigationApiCommitParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(22)));
    }

    @Override
    public void didBlockNavigation(Url blockedUrl, Url initiatorUrl, int reason) {
      LocalFrameHostDidBlockNavigationParams _message =
          new LocalFrameHostDidBlockNavigationParams();
      _message.blockedUrl = blockedUrl;
      _message.initiatorUrl = initiatorUrl;
      _message.reason = reason;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(23)));
    }

    @Override
    public void didChangeLoadProgress(double loadProgress) {
      LocalFrameHostDidChangeLoadProgressParams _message =
          new LocalFrameHostDidChangeLoadProgressParams();
      _message.loadProgress = loadProgress;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(24)));
    }

    @Override
    public void didFinishLoad(Url validatedUrl) {
      LocalFrameHostDidFinishLoadParams _message = new LocalFrameHostDidFinishLoadParams();
      _message.validatedUrl = validatedUrl;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(25)));
    }

    @Override
    public void dispatchLoad() {
      LocalFrameHostDispatchLoadParams _message = new LocalFrameHostDispatchLoadParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(26)));
    }

    @Override
    public void goToEntryAtOffset(
        int offset, boolean hasUserGesture, TaskAttributionId softNavigationHeuristicsTaskId) {
      LocalFrameHostGoToEntryAtOffsetParams _message = new LocalFrameHostGoToEntryAtOffsetParams();
      _message.offset = offset;
      _message.hasUserGesture = hasUserGesture;
      _message.softNavigationHeuristicsTaskId = softNavigationHeuristicsTaskId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(27)));
    }

    @Override
    public void navigateToNavigationApiKey(
        String key, boolean hasUserGesture, TaskAttributionId softNavigationHeuristicsTaskId) {
      LocalFrameHostNavigateToNavigationApiKeyParams _message =
          new LocalFrameHostNavigateToNavigationApiKeyParams();
      _message.key = key;
      _message.hasUserGesture = hasUserGesture;
      _message.softNavigationHeuristicsTaskId = softNavigationHeuristicsTaskId;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(28)));
    }

    @Override
    public void navigateEventHandlerPresenceChanged(boolean present) {
      LocalFrameHostNavigateEventHandlerPresenceChangedParams _message =
          new LocalFrameHostNavigateEventHandlerPresenceChangedParams();
      _message.present = present;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(29)));
    }

    @Override
    public void updateTitle(String16 title, int titleDirection) {
      LocalFrameHostUpdateTitleParams _message = new LocalFrameHostUpdateTitleParams();
      _message.title = title;
      _message.titleDirection = titleDirection;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(30)));
    }

    @Override
    public void updateAppTitle(String16 appTitle) {
      LocalFrameHostUpdateAppTitleParams _message = new LocalFrameHostUpdateAppTitleParams();
      _message.appTitle = appTitle;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(31)));
    }

    @Override
    public void updateUserActivationState(int updateType, int notificationType) {
      LocalFrameHostUpdateUserActivationStateParams _message =
          new LocalFrameHostUpdateUserActivationStateParams();
      _message.updateType = updateType;
      _message.notificationType = notificationType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(32)));
    }

    @Override
    public void didConsumeHistoryUserActivation() {
      LocalFrameHostDidConsumeHistoryUserActivationParams _message =
          new LocalFrameHostDidConsumeHistoryUserActivationParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(33)));
    }

    @Override
    public void handleAccessibilityFindInPageResult(FindInPageResultAxParams params) {
      LocalFrameHostHandleAccessibilityFindInPageResultParams _message =
          new LocalFrameHostHandleAccessibilityFindInPageResultParams();
      _message.params = params;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(34)));
    }

    @Override
    public void handleAccessibilityFindInPageTermination() {
      LocalFrameHostHandleAccessibilityFindInPageTerminationParams _message =
          new LocalFrameHostHandleAccessibilityFindInPageTerminationParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(35)));
    }

    @Override
    public void documentOnLoadCompleted() {
      LocalFrameHostDocumentOnLoadCompletedParams _message =
          new LocalFrameHostDocumentOnLoadCompletedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(36)));
    }

    @Override
    public void forwardResourceTimingToParent(ResourceTimingInfo timing) {
      LocalFrameHostForwardResourceTimingToParentParams _message =
          new LocalFrameHostForwardResourceTimingToParentParams();
      _message.timing = timing;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(37)));
    }

    @Override
    public void didDispatchDomContentLoadedEvent() {
      LocalFrameHostDidDispatchDomContentLoadedEventParams _message =
          new LocalFrameHostDidDispatchDomContentLoadedEventParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(38)));
    }

    @Override
    public void runModalAlertDialog(
        String16 alertMessage,
        boolean disableThirdPartySubframeSuppresion,
        RunModalAlertDialog_Response callback) {
      LocalFrameHostRunModalAlertDialogParams _message =
          new LocalFrameHostRunModalAlertDialogParams();
      _message.alertMessage = alertMessage;
      _message.disableThirdPartySubframeSuppresion = disableThirdPartySubframeSuppresion;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(39, 1, 0L)),
              new LocalFrameHostRunModalAlertDialogResponseParamsForwardToCallback(callback));
    }

    @Override
    public void runModalConfirmDialog(
        String16 alertMessage,
        boolean disableThirdPartySubframeSuppresion,
        RunModalConfirmDialog_Response callback) {
      LocalFrameHostRunModalConfirmDialogParams _message =
          new LocalFrameHostRunModalConfirmDialogParams();
      _message.alertMessage = alertMessage;
      _message.disableThirdPartySubframeSuppresion = disableThirdPartySubframeSuppresion;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(40, 1, 0L)),
              new LocalFrameHostRunModalConfirmDialogResponseParamsForwardToCallback(callback));
    }

    @Override
    public void runModalPromptDialog(
        String16 alertMessage,
        String16 defaultValue,
        boolean disableThirdPartySubframeSuppresion,
        RunModalPromptDialog_Response callback) {
      LocalFrameHostRunModalPromptDialogParams _message =
          new LocalFrameHostRunModalPromptDialogParams();
      _message.alertMessage = alertMessage;
      _message.defaultValue = defaultValue;
      _message.disableThirdPartySubframeSuppresion = disableThirdPartySubframeSuppresion;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(41, 1, 0L)),
              new LocalFrameHostRunModalPromptDialogResponseParamsForwardToCallback(callback));
    }

    @Override
    public void runBeforeUnloadConfirm(boolean isReload, RunBeforeUnloadConfirm_Response callback) {
      LocalFrameHostRunBeforeUnloadConfirmParams _message =
          new LocalFrameHostRunBeforeUnloadConfirmParams();
      _message.isReload = isReload;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(42, 1, 0L)),
              new LocalFrameHostRunBeforeUnloadConfirmResponseParamsForwardToCallback(callback));
    }

    @Override
    public void updateFaviconUrl(FaviconUrl[] faviconUrls) {
      LocalFrameHostUpdateFaviconUrlParams _message = new LocalFrameHostUpdateFaviconUrlParams();
      _message.faviconUrls = faviconUrls;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(43)));
    }

    @Override
    public void downloadUrl(DownloadUrlParams params) {
      LocalFrameHostDownloadUrlParams _message = new LocalFrameHostDownloadUrlParams();
      _message.params = params;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(44)));
    }

    @Override
    public void focusedElementChanged(
        boolean isEditableElement,
        boolean isRichlyEditableElement,
        Rect boundsInFrameWidget,
        int focusType) {
      LocalFrameHostFocusedElementChangedParams _message =
          new LocalFrameHostFocusedElementChangedParams();
      _message.isEditableElement = isEditableElement;
      _message.isRichlyEditableElement = isRichlyEditableElement;
      _message.boundsInFrameWidget = boundsInFrameWidget;
      _message.focusType = focusType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(45)));
    }

    @Override
    public void textSelectionChanged(BigString16 text, int offset, Range range) {
      LocalFrameHostTextSelectionChangedParams _message =
          new LocalFrameHostTextSelectionChangedParams();
      _message.text = text;
      _message.offset = offset;
      _message.range = range;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(46)));
    }

    @Override
    public void showPopupMenu(
        PopupMenuClient popupClient,
        Rect bounds,
        int itemHeight,
        double fontSize,
        int selectedItem,
        MenuItem[] menuItems,
        boolean rightAligned,
        boolean allowMultipleSelection) {
      LocalFrameHostShowPopupMenuParams _message = new LocalFrameHostShowPopupMenuParams();
      _message.popupClient = popupClient;
      _message.bounds = bounds;
      _message.itemHeight = itemHeight;
      _message.fontSize = fontSize;
      _message.selectedItem = selectedItem;
      _message.menuItems = menuItems;
      _message.rightAligned = rightAligned;
      _message.allowMultipleSelection = allowMultipleSelection;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(47)));
    }

    @Override
    public void createNewPopupWidget(
        AssociatedInterfaceRequestNotSupported popupHost,
        AssociatedInterfaceRequestNotSupported blinkWidgetHost,
        AssociatedInterfaceNotSupported blinkWidget) {
      LocalFrameHostCreateNewPopupWidgetParams _message =
          new LocalFrameHostCreateNewPopupWidgetParams();
      _message.popupHost = popupHost;
      _message.blinkWidgetHost = blinkWidgetHost;
      _message.blinkWidget = blinkWidget;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(48)));
    }

    @Override
    public void showContextMenu(
        AssociatedInterfaceNotSupported client, UntrustworthyContextMenuParams params) {
      LocalFrameHostShowContextMenuParams _message = new LocalFrameHostShowContextMenuParams();
      _message.client = client;
      _message.params = params;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(49)));
    }

    @Override
    public void didLoadResourceFromMemoryCache(
        Url url,
        String httpMethod,
        String mimeType,
        int requestDestination,
        boolean includeCredentials) {
      LocalFrameHostDidLoadResourceFromMemoryCacheParams _message =
          new LocalFrameHostDidLoadResourceFromMemoryCacheParams();
      _message.url = url;
      _message.httpMethod = httpMethod;
      _message.mimeType = mimeType;
      _message.requestDestination = requestDestination;
      _message.includeCredentials = includeCredentials;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(50)));
    }

    @Override
    public void didChangeFrameOwnerProperties(
        FrameToken childFrameToken, FrameOwnerProperties frameOwnerProperties) {
      LocalFrameHostDidChangeFrameOwnerPropertiesParams _message =
          new LocalFrameHostDidChangeFrameOwnerPropertiesParams();
      _message.childFrameToken = childFrameToken;
      _message.frameOwnerProperties = frameOwnerProperties;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(51)));
    }

    @Override
    public void didChangeOpener(LocalFrameToken openerFrame) {
      LocalFrameHostDidChangeOpenerParams _message = new LocalFrameHostDidChangeOpenerParams();
      _message.openerFrame = openerFrame;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(52)));
    }

    @Override
    public void didChangeFramePolicy(FrameToken childFrameToken, FramePolicy framePolicy) {
      LocalFrameHostDidChangeFramePolicyParams _message =
          new LocalFrameHostDidChangeFramePolicyParams();
      _message.childFrameToken = childFrameToken;
      _message.framePolicy = framePolicy;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(53)));
    }

    @Override
    public void didChangeIframeAttributes(FrameToken childFrameToken, IframeAttributes attributes) {
      LocalFrameHostDidChangeIframeAttributesParams _message =
          new LocalFrameHostDidChangeIframeAttributesParams();
      _message.childFrameToken = childFrameToken;
      _message.attributes = attributes;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(54)));
    }

    @Override
    public void capturePaintPreviewOfSubframe(Rect clipRect, UnguessableToken guid) {
      LocalFrameHostCapturePaintPreviewOfSubframeParams _message =
          new LocalFrameHostCapturePaintPreviewOfSubframeParams();
      _message.clipRect = clipRect;
      _message.guid = guid;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(55)));
    }

    @Override
    public void setCloseListener(CloseListener listener) {
      LocalFrameHostSetCloseListenerParams _message = new LocalFrameHostSetCloseListenerParams();
      _message.listener = listener;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(56)));
    }

    @Override
    public void detach() {
      LocalFrameHostDetachParams _message = new LocalFrameHostDetachParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(57)));
    }

    @Override
    public void getKeepAliveHandleFactory(InterfaceRequest<KeepAliveHandleFactory> factory) {
      LocalFrameHostGetKeepAliveHandleFactoryParams _message =
          new LocalFrameHostGetKeepAliveHandleFactoryParams();
      _message.factory = factory;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(58)));
    }

    @Override
    public void didAddMessageToConsole(
        int logLevel,
        BigString16 msg,
        int lineNumber,
        String16 sourceId,
        BigString16 untrustedStackTrace) {
      LocalFrameHostDidAddMessageToConsoleParams _message =
          new LocalFrameHostDidAddMessageToConsoleParams();
      _message.logLevel = logLevel;
      _message.msg = msg;
      _message.lineNumber = lineNumber;
      _message.sourceId = sourceId;
      _message.untrustedStackTrace = untrustedStackTrace;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(59)));
    }

    @Override
    public void frameSizeChanged(Size size) {
      LocalFrameHostFrameSizeChangedParams _message = new LocalFrameHostFrameSizeChangedParams();
      _message.size = size;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(60)));
    }

    @Override
    public void didInferColorScheme(int colorScheme) {
      LocalFrameHostDidInferColorSchemeParams _message =
          new LocalFrameHostDidInferColorSchemeParams();
      _message.colorScheme = colorScheme;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(61)));
    }

    @Override
    public void didChangeSrcDoc(FrameToken childFrameToken, String srcdocValue) {
      LocalFrameHostDidChangeSrcDocParams _message = new LocalFrameHostDidChangeSrcDocParams();
      _message.childFrameToken = childFrameToken;
      _message.srcdocValue = srcdocValue;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(62)));
    }

    @Override
    public void receivedDelegatedCapability(int delegatedCapability) {
      LocalFrameHostReceivedDelegatedCapabilityParams _message =
          new LocalFrameHostReceivedDelegatedCapabilityParams();
      _message.delegatedCapability = delegatedCapability;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(63)));
    }

    @Override
    public void sendFencedFrameReportingBeacon(
        String eventData, String eventType, int[] destinations) {
      LocalFrameHostSendFencedFrameReportingBeaconParams _message =
          new LocalFrameHostSendFencedFrameReportingBeaconParams();
      _message.eventData = eventData;
      _message.eventType = eventType;
      _message.destinations = destinations;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(64)));
    }

    @Override
    public void sendFencedFrameReportingBeaconToCustomUrl(Url destinationUrl) {
      LocalFrameHostSendFencedFrameReportingBeaconToCustomUrlParams _message =
          new LocalFrameHostSendFencedFrameReportingBeaconToCustomUrlParams();
      _message.destinationUrl = destinationUrl;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(65)));
    }

    @Override
    public void disableUntrustedNetworkInFencedFrame(
        DisableUntrustedNetworkInFencedFrame_Response callback) {
      LocalFrameHostDisableUntrustedNetworkInFencedFrameParams _message =
          new LocalFrameHostDisableUntrustedNetworkInFencedFrameParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(66, 1, 0L)),
              new LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void sendLegacyTechEvent(String type, LegacyTechEventCodeLocation codeLocation) {
      LocalFrameHostSendLegacyTechEventParams _message =
          new LocalFrameHostSendLegacyTechEventParams();
      _message.type = type;
      _message.codeLocation = codeLocation;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(67)));
    }

    @Override
    public void setFencedFrameAutomaticBeaconReportEventData(
        int eventType,
        String eventData,
        int[] destinations,
        boolean once,
        boolean crossOriginExposed) {
      LocalFrameHostSetFencedFrameAutomaticBeaconReportEventDataParams _message =
          new LocalFrameHostSetFencedFrameAutomaticBeaconReportEventDataParams();
      _message.eventType = eventType;
      _message.eventData = eventData;
      _message.destinations = destinations;
      _message.once = once;
      _message.crossOriginExposed = crossOriginExposed;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(68)));
    }

    @Override
    public void sendPrivateAggregationRequestsForFencedFrameEvent(String eventType) {
      LocalFrameHostSendPrivateAggregationRequestsForFencedFrameEventParams _message =
          new LocalFrameHostSendPrivateAggregationRequestsForFencedFrameEventParams();
      _message.eventType = eventType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(69)));
    }

    @Override
    public void setAttributionReportingRuntimeFeatures(
        AttributionReportingRuntimeFeatures features) {
      LocalFrameHostSetAttributionReportingRuntimeFeaturesParams _message =
          new LocalFrameHostSetAttributionReportingRuntimeFeaturesParams();
      _message.features = features;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(70)));
    }

    @Override
    public void createFencedFrame(
        AssociatedInterfaceRequestNotSupported fencedFrame,
        RemoteFrameInterfacesFromRenderer remoteFrameInterfaces,
        RemoteFrameToken frameToken,
        UnguessableToken devtoolsFrameToken) {
      LocalFrameHostCreateFencedFrameParams _message = new LocalFrameHostCreateFencedFrameParams();
      _message.fencedFrame = fencedFrame;
      _message.remoteFrameInterfaces = remoteFrameInterfaces;
      _message.frameToken = frameToken;
      _message.devtoolsFrameToken = devtoolsFrameToken;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(71)));
    }

    @Override
    public void onViewTransitionOptInChanged(int viewTransitionOptIn) {
      LocalFrameHostOnViewTransitionOptInChangedParams _message =
          new LocalFrameHostOnViewTransitionOptInChangedParams();
      _message.viewTransitionOptIn = viewTransitionOptIn;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(72)));
    }

    @Override
    public void startDragging(
        DragData dragData,
        AllowedDragOperations operationsAllowed,
        BitmapN32 image,
        Vector2d cursorOffsetInDip,
        Rect dragObjRectInDip,
        DragEventSourceInfo eventInfo) {
      LocalFrameHostStartDraggingParams _message = new LocalFrameHostStartDraggingParams();
      _message.dragData = dragData;
      _message.operationsAllowed = operationsAllowed;
      _message.image = image;
      _message.cursorOffsetInDip = cursorOffsetInDip;
      _message.dragObjRectInDip = dragObjRectInDip;
      _message.eventInfo = eventInfo;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(73)));
    }
  }

  public static final class Stub extends Interface.Stub<LocalFrameHost> {
    Stub(Core core, LocalFrameHost impl) {
      super(core, impl);
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        int flags = 0;
        if (header.hasFlag(4)) {
          flags = 0 | 4;
        }
        if (!header.validateHeader(flags)) {
          return false;
        }
        switch (header.getType()) {
          case -2:
            return InterfaceControlMessagesHelper.handleRunOrClosePipe(
                LocalFrameHost_Internal.MANAGER, messageWithHeader);
          case -1:
          case 0:
          case 39:
          case 40:
          case 41:
          case 42:
          case 66:
          default:
            return false;
          case 1:
            LocalFrameHostExitFullscreenParams.deserialize(messageWithHeader.getPayload());
            getImpl().exitFullscreen();
            return true;
          case 2:
            LocalFrameHostFullscreenStateChangedParams data =
                LocalFrameHostFullscreenStateChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().fullscreenStateChanged(data.isFullscreen, data.options);
            return true;
          case 3:
            LocalFrameHostRegisterProtocolHandlerParams data2 =
                LocalFrameHostRegisterProtocolHandlerParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().registerProtocolHandler(data2.scheme, data2.url, data2.userGesture);
            return true;
          case 4:
            LocalFrameHostUnregisterProtocolHandlerParams data3 =
                LocalFrameHostUnregisterProtocolHandlerParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().unregisterProtocolHandler(data3.scheme, data3.url, data3.userGesture);
            return true;
          case 5:
            LocalFrameHostDidDisplayInsecureContentParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().didDisplayInsecureContent();
            return true;
          case 6:
            LocalFrameHostDidContainInsecureFormActionParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().didContainInsecureFormAction();
            return true;
          case 7:
            getImpl()
                .mainDocumentElementAvailable(
                    LocalFrameHostMainDocumentElementAvailableParams.deserialize(
                            messageWithHeader.getPayload())
                        .usesTemporaryZoomLevel);
            return true;
          case 8:
            getImpl()
                .setNeedsOcclusionTracking(
                    LocalFrameHostSetNeedsOcclusionTrackingParams.deserialize(
                            messageWithHeader.getPayload())
                        .needsTracking);
            return true;
          case 9:
            getImpl()
                .setVirtualKeyboardMode(
                    LocalFrameHostSetVirtualKeyboardModeParams.deserialize(
                            messageWithHeader.getPayload())
                        .type);
            return true;
          case 10:
            getImpl()
                .visibilityChanged(
                    LocalFrameHostVisibilityChangedParams.deserialize(
                            messageWithHeader.getPayload())
                        .visibility);
            return true;
          case 11:
            getImpl()
                .didChangeThemeColor(
                    LocalFrameHostDidChangeThemeColorParams.deserialize(
                            messageWithHeader.getPayload())
                        .themeColor);
            return true;
          case 12:
            LocalFrameHostDidChangeBackgroundColorParams data4 =
                LocalFrameHostDidChangeBackgroundColorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().didChangeBackgroundColor(data4.backgroundColor, data4.colorAdjust);
            return true;
          case 13:
            LocalFrameHostDidFailLoadWithErrorParams data5 =
                LocalFrameHostDidFailLoadWithErrorParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().didFailLoadWithError(data5.url, data5.errorCode);
            return true;
          case 14:
            LocalFrameHostDidFocusFrameParams.deserialize(messageWithHeader.getPayload());
            getImpl().didFocusFrame();
            return true;
          case 15:
            LocalFrameHostDidCallFocusParams.deserialize(messageWithHeader.getPayload());
            getImpl().didCallFocus();
            return true;
          case 16:
            getImpl()
                .enforceInsecureRequestPolicy(
                    LocalFrameHostEnforceInsecureRequestPolicyParams.deserialize(
                            messageWithHeader.getPayload())
                        .policyBitmap);
            return true;
          case 17:
            getImpl()
                .enforceInsecureNavigationsSet(
                    LocalFrameHostEnforceInsecureNavigationsSetParams.deserialize(
                            messageWithHeader.getPayload())
                        .set);
            return true;
          case 18:
            LocalFrameHostSuddenTerminationDisablerChangedParams data6 =
                LocalFrameHostSuddenTerminationDisablerChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().suddenTerminationDisablerChanged(data6.present, data6.disablerType);
            return true;
          case 19:
            getImpl()
                .hadStickyUserActivationBeforeNavigationChanged(
                    LocalFrameHostHadStickyUserActivationBeforeNavigationChangedParams.deserialize(
                            messageWithHeader.getPayload())
                        .hasGesture);
            return true;
          case 20:
            LocalFrameHostScrollRectToVisibleInParentFrameParams data7 =
                LocalFrameHostScrollRectToVisibleInParentFrameParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().scrollRectToVisibleInParentFrame(data7.rectToScroll, data7.params);
            return true;
          case 21:
            LocalFrameHostBubbleLogicalScrollInParentFrameParams data8 =
                LocalFrameHostBubbleLogicalScrollInParentFrameParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().bubbleLogicalScrollInParentFrame(data8.direction, data8.granularity);
            return true;
          case 22:
            LocalFrameHostStartLoadingForAsyncNavigationApiCommitParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().startLoadingForAsyncNavigationApiCommit();
            return true;
          case 23:
            LocalFrameHostDidBlockNavigationParams data9 =
                LocalFrameHostDidBlockNavigationParams.deserialize(messageWithHeader.getPayload());
            getImpl().didBlockNavigation(data9.blockedUrl, data9.initiatorUrl, data9.reason);
            return true;
          case 24:
            getImpl()
                .didChangeLoadProgress(
                    LocalFrameHostDidChangeLoadProgressParams.deserialize(
                            messageWithHeader.getPayload())
                        .loadProgress);
            return true;
          case 25:
            getImpl()
                .didFinishLoad(
                    LocalFrameHostDidFinishLoadParams.deserialize(messageWithHeader.getPayload())
                        .validatedUrl);
            return true;
          case 26:
            LocalFrameHostDispatchLoadParams.deserialize(messageWithHeader.getPayload());
            getImpl().dispatchLoad();
            return true;
          case 27:
            LocalFrameHostGoToEntryAtOffsetParams data10 =
                LocalFrameHostGoToEntryAtOffsetParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .goToEntryAtOffset(
                    data10.offset, data10.hasUserGesture, data10.softNavigationHeuristicsTaskId);
            return true;
          case 28:
            LocalFrameHostNavigateToNavigationApiKeyParams data11 =
                LocalFrameHostNavigateToNavigationApiKeyParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .navigateToNavigationApiKey(
                    data11.key, data11.hasUserGesture, data11.softNavigationHeuristicsTaskId);
            return true;
          case 29:
            getImpl()
                .navigateEventHandlerPresenceChanged(
                    LocalFrameHostNavigateEventHandlerPresenceChangedParams.deserialize(
                            messageWithHeader.getPayload())
                        .present);
            return true;
          case 30:
            LocalFrameHostUpdateTitleParams data12 =
                LocalFrameHostUpdateTitleParams.deserialize(messageWithHeader.getPayload());
            getImpl().updateTitle(data12.title, data12.titleDirection);
            return true;
          case 31:
            getImpl()
                .updateAppTitle(
                    LocalFrameHostUpdateAppTitleParams.deserialize(messageWithHeader.getPayload())
                        .appTitle);
            return true;
          case 32:
            LocalFrameHostUpdateUserActivationStateParams data13 =
                LocalFrameHostUpdateUserActivationStateParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().updateUserActivationState(data13.updateType, data13.notificationType);
            return true;
          case 33:
            LocalFrameHostDidConsumeHistoryUserActivationParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().didConsumeHistoryUserActivation();
            return true;
          case 34:
            getImpl()
                .handleAccessibilityFindInPageResult(
                    LocalFrameHostHandleAccessibilityFindInPageResultParams.deserialize(
                            messageWithHeader.getPayload())
                        .params);
            return true;
          case 35:
            LocalFrameHostHandleAccessibilityFindInPageTerminationParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().handleAccessibilityFindInPageTermination();
            return true;
          case 36:
            LocalFrameHostDocumentOnLoadCompletedParams.deserialize(messageWithHeader.getPayload());
            getImpl().documentOnLoadCompleted();
            return true;
          case 37:
            getImpl()
                .forwardResourceTimingToParent(
                    LocalFrameHostForwardResourceTimingToParentParams.deserialize(
                            messageWithHeader.getPayload())
                        .timing);
            return true;
          case 38:
            LocalFrameHostDidDispatchDomContentLoadedEventParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().didDispatchDomContentLoadedEvent();
            return true;
          case 43:
            getImpl()
                .updateFaviconUrl(
                    LocalFrameHostUpdateFaviconUrlParams.deserialize(messageWithHeader.getPayload())
                        .faviconUrls);
            return true;
          case 44:
            getImpl()
                .downloadUrl(
                    LocalFrameHostDownloadUrlParams.deserialize(messageWithHeader.getPayload())
                        .params);
            return true;
          case 45:
            LocalFrameHostFocusedElementChangedParams data14 =
                LocalFrameHostFocusedElementChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .focusedElementChanged(
                    data14.isEditableElement,
                    data14.isRichlyEditableElement,
                    data14.boundsInFrameWidget,
                    data14.focusType);
            return true;
          case 46:
            LocalFrameHostTextSelectionChangedParams data15 =
                LocalFrameHostTextSelectionChangedParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().textSelectionChanged(data15.text, data15.offset, data15.range);
            return true;
          case 47:
            LocalFrameHostShowPopupMenuParams data16 =
                LocalFrameHostShowPopupMenuParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .showPopupMenu(
                    data16.popupClient,
                    data16.bounds,
                    data16.itemHeight,
                    data16.fontSize,
                    data16.selectedItem,
                    data16.menuItems,
                    data16.rightAligned,
                    data16.allowMultipleSelection);
            return true;
          case 48:
            LocalFrameHostCreateNewPopupWidgetParams data17 =
                LocalFrameHostCreateNewPopupWidgetParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .createNewPopupWidget(data17.popupHost, data17.blinkWidgetHost, data17.blinkWidget);
            return true;
          case 49:
            LocalFrameHostShowContextMenuParams data18 =
                LocalFrameHostShowContextMenuParams.deserialize(messageWithHeader.getPayload());
            getImpl().showContextMenu(data18.client, data18.params);
            return true;
          case 50:
            LocalFrameHostDidLoadResourceFromMemoryCacheParams data19 =
                LocalFrameHostDidLoadResourceFromMemoryCacheParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .didLoadResourceFromMemoryCache(
                    data19.url,
                    data19.httpMethod,
                    data19.mimeType,
                    data19.requestDestination,
                    data19.includeCredentials);
            return true;
          case 51:
            LocalFrameHostDidChangeFrameOwnerPropertiesParams data20 =
                LocalFrameHostDidChangeFrameOwnerPropertiesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .didChangeFrameOwnerProperties(data20.childFrameToken, data20.frameOwnerProperties);
            return true;
          case 52:
            getImpl()
                .didChangeOpener(
                    LocalFrameHostDidChangeOpenerParams.deserialize(messageWithHeader.getPayload())
                        .openerFrame);
            return true;
          case 53:
            LocalFrameHostDidChangeFramePolicyParams data21 =
                LocalFrameHostDidChangeFramePolicyParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().didChangeFramePolicy(data21.childFrameToken, data21.framePolicy);
            return true;
          case 54:
            LocalFrameHostDidChangeIframeAttributesParams data22 =
                LocalFrameHostDidChangeIframeAttributesParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().didChangeIframeAttributes(data22.childFrameToken, data22.attributes);
            return true;
          case 55:
            LocalFrameHostCapturePaintPreviewOfSubframeParams data23 =
                LocalFrameHostCapturePaintPreviewOfSubframeParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().capturePaintPreviewOfSubframe(data23.clipRect, data23.guid);
            return true;
          case 56:
            getImpl()
                .setCloseListener(
                    LocalFrameHostSetCloseListenerParams.deserialize(messageWithHeader.getPayload())
                        .listener);
            return true;
          case 57:
            LocalFrameHostDetachParams.deserialize(messageWithHeader.getPayload());
            getImpl().detach();
            return true;
          case 58:
            getImpl()
                .getKeepAliveHandleFactory(
                    LocalFrameHostGetKeepAliveHandleFactoryParams.deserialize(
                            messageWithHeader.getPayload())
                        .factory);
            return true;
          case 59:
            LocalFrameHostDidAddMessageToConsoleParams data24 =
                LocalFrameHostDidAddMessageToConsoleParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .didAddMessageToConsole(
                    data24.logLevel,
                    data24.msg,
                    data24.lineNumber,
                    data24.sourceId,
                    data24.untrustedStackTrace);
            return true;
          case 60:
            getImpl()
                .frameSizeChanged(
                    LocalFrameHostFrameSizeChangedParams.deserialize(messageWithHeader.getPayload())
                        .size);
            return true;
          case 61:
            getImpl()
                .didInferColorScheme(
                    LocalFrameHostDidInferColorSchemeParams.deserialize(
                            messageWithHeader.getPayload())
                        .colorScheme);
            return true;
          case 62:
            LocalFrameHostDidChangeSrcDocParams data25 =
                LocalFrameHostDidChangeSrcDocParams.deserialize(messageWithHeader.getPayload());
            getImpl().didChangeSrcDoc(data25.childFrameToken, data25.srcdocValue);
            return true;
          case 63:
            getImpl()
                .receivedDelegatedCapability(
                    LocalFrameHostReceivedDelegatedCapabilityParams.deserialize(
                            messageWithHeader.getPayload())
                        .delegatedCapability);
            return true;
          case 64:
            LocalFrameHostSendFencedFrameReportingBeaconParams data26 =
                LocalFrameHostSendFencedFrameReportingBeaconParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .sendFencedFrameReportingBeacon(
                    data26.eventData, data26.eventType, data26.destinations);
            return true;
          case 65:
            getImpl()
                .sendFencedFrameReportingBeaconToCustomUrl(
                    LocalFrameHostSendFencedFrameReportingBeaconToCustomUrlParams.deserialize(
                            messageWithHeader.getPayload())
                        .destinationUrl);
            return true;
          case 67:
            LocalFrameHostSendLegacyTechEventParams data27 =
                LocalFrameHostSendLegacyTechEventParams.deserialize(messageWithHeader.getPayload());
            getImpl().sendLegacyTechEvent(data27.type, data27.codeLocation);
            return true;
          case 68:
            LocalFrameHostSetFencedFrameAutomaticBeaconReportEventDataParams data28 =
                LocalFrameHostSetFencedFrameAutomaticBeaconReportEventDataParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setFencedFrameAutomaticBeaconReportEventData(
                    data28.eventType,
                    data28.eventData,
                    data28.destinations,
                    data28.once,
                    data28.crossOriginExposed);
            return true;
          case 69:
            getImpl()
                .sendPrivateAggregationRequestsForFencedFrameEvent(
                    LocalFrameHostSendPrivateAggregationRequestsForFencedFrameEventParams
                        .deserialize(messageWithHeader.getPayload())
                        .eventType);
            return true;
          case 70:
            getImpl()
                .setAttributionReportingRuntimeFeatures(
                    LocalFrameHostSetAttributionReportingRuntimeFeaturesParams.deserialize(
                            messageWithHeader.getPayload())
                        .features);
            return true;
          case 71:
            LocalFrameHostCreateFencedFrameParams data29 =
                LocalFrameHostCreateFencedFrameParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .createFencedFrame(
                    data29.fencedFrame,
                    data29.remoteFrameInterfaces,
                    data29.frameToken,
                    data29.devtoolsFrameToken);
            return true;
          case 72:
            getImpl()
                .onViewTransitionOptInChanged(
                    LocalFrameHostOnViewTransitionOptInChangedParams.deserialize(
                            messageWithHeader.getPayload())
                        .viewTransitionOptIn);
            return true;
          case 73:
            LocalFrameHostStartDraggingParams data30 =
                LocalFrameHostStartDraggingParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .startDragging(
                    data30.dragData,
                    data30.operationsAllowed,
                    data30.image,
                    data30.cursorOffsetInDip,
                    data30.dragObjRectInDip,
                    data30.eventInfo);
            return true;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }

    @Override
    public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        int flags = 1;
        if (header.hasFlag(4)) {
          flags = 1 | 4;
        }
        if (!header.validateHeader(flags)) {
          return false;
        }
        switch (header.getType()) {
          case -1:
            return InterfaceControlMessagesHelper.handleRun(
                getCore(), LocalFrameHost_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            getImpl()
                .enterFullscreen(
                    LocalFrameHostEnterFullscreenParams.deserialize(messageWithHeader.getPayload())
                        .options,
                    new LocalFrameHostEnterFullscreenResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 39:
            LocalFrameHostRunModalAlertDialogParams data =
                LocalFrameHostRunModalAlertDialogParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .runModalAlertDialog(
                    data.alertMessage,
                    data.disableThirdPartySubframeSuppresion,
                    new LocalFrameHostRunModalAlertDialogResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 40:
            LocalFrameHostRunModalConfirmDialogParams data2 =
                LocalFrameHostRunModalConfirmDialogParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .runModalConfirmDialog(
                    data2.alertMessage,
                    data2.disableThirdPartySubframeSuppresion,
                    new LocalFrameHostRunModalConfirmDialogResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 41:
            LocalFrameHostRunModalPromptDialogParams data3 =
                LocalFrameHostRunModalPromptDialogParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .runModalPromptDialog(
                    data3.alertMessage,
                    data3.defaultValue,
                    data3.disableThirdPartySubframeSuppresion,
                    new LocalFrameHostRunModalPromptDialogResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 42:
            LocalFrameHostRunBeforeUnloadConfirmParams data4 =
                LocalFrameHostRunBeforeUnloadConfirmParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .runBeforeUnloadConfirm(
                    data4.isReload,
                    new LocalFrameHostRunBeforeUnloadConfirmResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 66:
            LocalFrameHostDisableUntrustedNetworkInFencedFrameParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .disableUntrustedNetworkInFencedFrame(
                    new LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class LocalFrameHostEnterFullscreenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FullscreenOptions options;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostEnterFullscreenParams(int version) {
      super(16, version);
    }

    public LocalFrameHostEnterFullscreenParams() {
      this(0);
    }

    public static LocalFrameHostEnterFullscreenParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostEnterFullscreenParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostEnterFullscreenParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostEnterFullscreenParams result =
            new LocalFrameHostEnterFullscreenParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.options = FullscreenOptions.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.options, 8, false);
    }
  }

  static final class LocalFrameHostEnterFullscreenResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean granted;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostEnterFullscreenResponseParams(int version) {
      super(16, version);
    }

    public LocalFrameHostEnterFullscreenResponseParams() {
      this(0);
    }

    public static LocalFrameHostEnterFullscreenResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostEnterFullscreenResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostEnterFullscreenResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostEnterFullscreenResponseParams result =
            new LocalFrameHostEnterFullscreenResponseParams(elementsOrVersion);
        result.granted = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.granted, 8, 0);
    }
  }

  static class LocalFrameHostEnterFullscreenResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrameHost.EnterFullscreen_Response mCallback;

    LocalFrameHostEnterFullscreenResponseParamsForwardToCallback(
        LocalFrameHost.EnterFullscreen_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 2)) {
          return false;
        }
        LocalFrameHostEnterFullscreenResponseParams response =
            LocalFrameHostEnterFullscreenResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.granted);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameHostEnterFullscreenResponseParamsProxyToResponder
      implements LocalFrameHost.EnterFullscreen_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameHostEnterFullscreenResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean granted) {
      LocalFrameHostEnterFullscreenResponseParams _response =
          new LocalFrameHostEnterFullscreenResponseParams();
      _response.granted = granted;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameHostExitFullscreenParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostExitFullscreenParams(int version) {
      super(8, version);
    }

    public LocalFrameHostExitFullscreenParams() {
      this(0);
    }

    public static LocalFrameHostExitFullscreenParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostExitFullscreenParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostExitFullscreenParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostExitFullscreenParams result =
            new LocalFrameHostExitFullscreenParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class LocalFrameHostFullscreenStateChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isFullscreen;
    public FullscreenOptions options;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostFullscreenStateChangedParams(int version) {
      super(24, version);
    }

    public LocalFrameHostFullscreenStateChangedParams() {
      this(0);
    }

    public static LocalFrameHostFullscreenStateChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostFullscreenStateChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostFullscreenStateChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostFullscreenStateChangedParams result =
            new LocalFrameHostFullscreenStateChangedParams(elementsOrVersion);
        result.isFullscreen = decoder0.readBoolean(8, 0);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.options = FullscreenOptions.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.isFullscreen, 8, 0);
      encoder0.encode((Struct) this.options, 16, true);
    }
  }

  static final class LocalFrameHostRegisterProtocolHandlerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String scheme;
    public Url url;
    public boolean userGesture;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostRegisterProtocolHandlerParams(int version) {
      super(32, version);
    }

    public LocalFrameHostRegisterProtocolHandlerParams() {
      this(0);
    }

    public static LocalFrameHostRegisterProtocolHandlerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostRegisterProtocolHandlerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostRegisterProtocolHandlerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostRegisterProtocolHandlerParams result =
            new LocalFrameHostRegisterProtocolHandlerParams(elementsOrVersion);
        result.scheme = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder1);
        result.userGesture = decoder0.readBoolean(24, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.scheme, 8, false);
      encoder0.encode((Struct) this.url, 16, false);
      encoder0.encode(this.userGesture, 24, 0);
    }
  }

  static final class LocalFrameHostUnregisterProtocolHandlerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String scheme;
    public Url url;
    public boolean userGesture;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostUnregisterProtocolHandlerParams(int version) {
      super(32, version);
    }

    public LocalFrameHostUnregisterProtocolHandlerParams() {
      this(0);
    }

    public static LocalFrameHostUnregisterProtocolHandlerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostUnregisterProtocolHandlerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostUnregisterProtocolHandlerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostUnregisterProtocolHandlerParams result =
            new LocalFrameHostUnregisterProtocolHandlerParams(elementsOrVersion);
        result.scheme = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder1);
        result.userGesture = decoder0.readBoolean(24, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.scheme, 8, false);
      encoder0.encode((Struct) this.url, 16, false);
      encoder0.encode(this.userGesture, 24, 0);
    }
  }

  static final class LocalFrameHostDidDisplayInsecureContentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidDisplayInsecureContentParams(int version) {
      super(8, version);
    }

    public LocalFrameHostDidDisplayInsecureContentParams() {
      this(0);
    }

    public static LocalFrameHostDidDisplayInsecureContentParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidDisplayInsecureContentParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidDisplayInsecureContentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidDisplayInsecureContentParams result =
            new LocalFrameHostDidDisplayInsecureContentParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class LocalFrameHostDidContainInsecureFormActionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidContainInsecureFormActionParams(int version) {
      super(8, version);
    }

    public LocalFrameHostDidContainInsecureFormActionParams() {
      this(0);
    }

    public static LocalFrameHostDidContainInsecureFormActionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidContainInsecureFormActionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidContainInsecureFormActionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidContainInsecureFormActionParams result =
            new LocalFrameHostDidContainInsecureFormActionParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class LocalFrameHostMainDocumentElementAvailableParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean usesTemporaryZoomLevel;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostMainDocumentElementAvailableParams(int version) {
      super(16, version);
    }

    public LocalFrameHostMainDocumentElementAvailableParams() {
      this(0);
    }

    public static LocalFrameHostMainDocumentElementAvailableParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostMainDocumentElementAvailableParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostMainDocumentElementAvailableParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostMainDocumentElementAvailableParams result =
            new LocalFrameHostMainDocumentElementAvailableParams(elementsOrVersion);
        result.usesTemporaryZoomLevel = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.usesTemporaryZoomLevel, 8, 0);
    }
  }

  static final class LocalFrameHostSetNeedsOcclusionTrackingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean needsTracking;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostSetNeedsOcclusionTrackingParams(int version) {
      super(16, version);
    }

    public LocalFrameHostSetNeedsOcclusionTrackingParams() {
      this(0);
    }

    public static LocalFrameHostSetNeedsOcclusionTrackingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostSetNeedsOcclusionTrackingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostSetNeedsOcclusionTrackingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostSetNeedsOcclusionTrackingParams result =
            new LocalFrameHostSetNeedsOcclusionTrackingParams(elementsOrVersion);
        result.needsTracking = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.needsTracking, 8, 0);
    }
  }

  static final class LocalFrameHostSetVirtualKeyboardModeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostSetVirtualKeyboardModeParams(int version) {
      super(16, version);
    }

    public LocalFrameHostSetVirtualKeyboardModeParams() {
      this(0);
    }

    public static LocalFrameHostSetVirtualKeyboardModeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostSetVirtualKeyboardModeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostSetVirtualKeyboardModeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostSetVirtualKeyboardModeParams result =
            new LocalFrameHostSetVirtualKeyboardModeParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.type = readInt;
        VirtualKeyboardMode.validate(readInt);
        result.type = VirtualKeyboardMode.toKnownValue(result.type);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8);
    }
  }

  static final class LocalFrameHostVisibilityChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int visibility;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostVisibilityChangedParams(int version) {
      super(16, version);
    }

    public LocalFrameHostVisibilityChangedParams() {
      this(0);
    }

    public static LocalFrameHostVisibilityChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostVisibilityChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostVisibilityChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostVisibilityChangedParams result =
            new LocalFrameHostVisibilityChangedParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.visibility = readInt;
        FrameVisibility.validate(readInt);
        result.visibility = FrameVisibility.toKnownValue(result.visibility);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.visibility, 8);
    }
  }

  static final class LocalFrameHostDidChangeThemeColorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SkColor themeColor;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidChangeThemeColorParams(int version) {
      super(16, version);
    }

    public LocalFrameHostDidChangeThemeColorParams() {
      this(0);
    }

    public static LocalFrameHostDidChangeThemeColorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidChangeThemeColorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidChangeThemeColorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidChangeThemeColorParams result =
            new LocalFrameHostDidChangeThemeColorParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.themeColor = SkColor.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.themeColor, 8, true);
    }
  }

  static final class LocalFrameHostDidChangeBackgroundColorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public SkColor4f backgroundColor;
    public boolean colorAdjust;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidChangeBackgroundColorParams(int version) {
      super(24, version);
    }

    public LocalFrameHostDidChangeBackgroundColorParams() {
      this(0);
    }

    public static LocalFrameHostDidChangeBackgroundColorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidChangeBackgroundColorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidChangeBackgroundColorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidChangeBackgroundColorParams result =
            new LocalFrameHostDidChangeBackgroundColorParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.backgroundColor = SkColor4f.decode(decoder1);
        result.colorAdjust = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.backgroundColor, 8, false);
      encoder0.encode(this.colorAdjust, 16, 0);
    }
  }

  static final class LocalFrameHostDidFailLoadWithErrorParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int errorCode;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidFailLoadWithErrorParams(int version) {
      super(24, version);
    }

    public LocalFrameHostDidFailLoadWithErrorParams() {
      this(0);
    }

    public static LocalFrameHostDidFailLoadWithErrorParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidFailLoadWithErrorParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidFailLoadWithErrorParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidFailLoadWithErrorParams result =
            new LocalFrameHostDidFailLoadWithErrorParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        result.errorCode = decoder0.readInt(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode(this.errorCode, 16);
    }
  }

  static final class LocalFrameHostDidFocusFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidFocusFrameParams(int version) {
      super(8, version);
    }

    public LocalFrameHostDidFocusFrameParams() {
      this(0);
    }

    public static LocalFrameHostDidFocusFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidFocusFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidFocusFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidFocusFrameParams result =
            new LocalFrameHostDidFocusFrameParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class LocalFrameHostDidCallFocusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidCallFocusParams(int version) {
      super(8, version);
    }

    public LocalFrameHostDidCallFocusParams() {
      this(0);
    }

    public static LocalFrameHostDidCallFocusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidCallFocusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidCallFocusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidCallFocusParams result =
            new LocalFrameHostDidCallFocusParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class LocalFrameHostEnforceInsecureRequestPolicyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int policyBitmap;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostEnforceInsecureRequestPolicyParams(int version) {
      super(16, version);
    }

    public LocalFrameHostEnforceInsecureRequestPolicyParams() {
      this(0);
    }

    public static LocalFrameHostEnforceInsecureRequestPolicyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostEnforceInsecureRequestPolicyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostEnforceInsecureRequestPolicyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostEnforceInsecureRequestPolicyParams result =
            new LocalFrameHostEnforceInsecureRequestPolicyParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.policyBitmap = readInt;
        InsecureRequestPolicy.validate(readInt);
        result.policyBitmap = InsecureRequestPolicy.toKnownValue(result.policyBitmap);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.policyBitmap, 8);
    }
  }

  static final class LocalFrameHostEnforceInsecureNavigationsSetParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int[] set;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostEnforceInsecureNavigationsSetParams(int version) {
      super(16, version);
    }

    public LocalFrameHostEnforceInsecureNavigationsSetParams() {
      this(0);
    }

    public static LocalFrameHostEnforceInsecureNavigationsSetParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostEnforceInsecureNavigationsSetParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostEnforceInsecureNavigationsSetParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostEnforceInsecureNavigationsSetParams result =
            new LocalFrameHostEnforceInsecureNavigationsSetParams(elementsOrVersion);
        result.set = decoder0.readInts(8, 0, -1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.set, 8, 0, -1);
    }
  }

  static final class LocalFrameHostSuddenTerminationDisablerChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int disablerType;
    public boolean present;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostSuddenTerminationDisablerChangedParams(int version) {
      super(16, version);
    }

    public LocalFrameHostSuddenTerminationDisablerChangedParams() {
      this(0);
    }

    public static LocalFrameHostSuddenTerminationDisablerChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostSuddenTerminationDisablerChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostSuddenTerminationDisablerChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostSuddenTerminationDisablerChangedParams result =
            new LocalFrameHostSuddenTerminationDisablerChangedParams(elementsOrVersion);
        result.present = decoder0.readBoolean(8, 0);
        int readInt = decoder0.readInt(12);
        result.disablerType = readInt;
        SuddenTerminationDisablerType.validate(readInt);
        result.disablerType = SuddenTerminationDisablerType.toKnownValue(result.disablerType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.present, 8, 0);
      encoder0.encode(this.disablerType, 12);
    }
  }

  static final class LocalFrameHostHadStickyUserActivationBeforeNavigationChangedParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean hasGesture;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostHadStickyUserActivationBeforeNavigationChangedParams(int version) {
      super(16, version);
    }

    public LocalFrameHostHadStickyUserActivationBeforeNavigationChangedParams() {
      this(0);
    }

    public static LocalFrameHostHadStickyUserActivationBeforeNavigationChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostHadStickyUserActivationBeforeNavigationChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostHadStickyUserActivationBeforeNavigationChangedParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostHadStickyUserActivationBeforeNavigationChangedParams result =
            new LocalFrameHostHadStickyUserActivationBeforeNavigationChangedParams(
                elementsOrVersion);
        result.hasGesture = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.hasGesture, 8, 0);
    }
  }

  static final class LocalFrameHostScrollRectToVisibleInParentFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public ScrollIntoViewParams params;
    public RectF rectToScroll;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostScrollRectToVisibleInParentFrameParams(int version) {
      super(24, version);
    }

    public LocalFrameHostScrollRectToVisibleInParentFrameParams() {
      this(0);
    }

    public static LocalFrameHostScrollRectToVisibleInParentFrameParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostScrollRectToVisibleInParentFrameParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostScrollRectToVisibleInParentFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostScrollRectToVisibleInParentFrameParams result =
            new LocalFrameHostScrollRectToVisibleInParentFrameParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.rectToScroll = RectF.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.params = ScrollIntoViewParams.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.rectToScroll, 8, false);
      encoder0.encode((Struct) this.params, 16, false);
    }
  }

  static final class LocalFrameHostBubbleLogicalScrollInParentFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int direction;
    public int granularity;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostBubbleLogicalScrollInParentFrameParams(int version) {
      super(16, version);
    }

    public LocalFrameHostBubbleLogicalScrollInParentFrameParams() {
      this(0);
    }

    public static LocalFrameHostBubbleLogicalScrollInParentFrameParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostBubbleLogicalScrollInParentFrameParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostBubbleLogicalScrollInParentFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostBubbleLogicalScrollInParentFrameParams result =
            new LocalFrameHostBubbleLogicalScrollInParentFrameParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.direction = readInt;
        ScrollDirection.validate(readInt);
        result.direction = ScrollDirection.toKnownValue(result.direction);
        int readInt2 = decoder0.readInt(12);
        result.granularity = readInt2;
        ScrollGranularity.validate(readInt2);
        result.granularity = ScrollGranularity.toKnownValue(result.granularity);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.direction, 8);
      encoder0.encode(this.granularity, 12);
    }
  }

  static final class LocalFrameHostStartLoadingForAsyncNavigationApiCommitParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostStartLoadingForAsyncNavigationApiCommitParams(int version) {
      super(8, version);
    }

    public LocalFrameHostStartLoadingForAsyncNavigationApiCommitParams() {
      this(0);
    }

    public static LocalFrameHostStartLoadingForAsyncNavigationApiCommitParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostStartLoadingForAsyncNavigationApiCommitParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostStartLoadingForAsyncNavigationApiCommitParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostStartLoadingForAsyncNavigationApiCommitParams result =
            new LocalFrameHostStartLoadingForAsyncNavigationApiCommitParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class LocalFrameHostDidBlockNavigationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Url blockedUrl;
    public Url initiatorUrl;
    public int reason;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidBlockNavigationParams(int version) {
      super(32, version);
    }

    public LocalFrameHostDidBlockNavigationParams() {
      this(0);
    }

    public static LocalFrameHostDidBlockNavigationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidBlockNavigationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidBlockNavigationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidBlockNavigationParams result =
            new LocalFrameHostDidBlockNavigationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.blockedUrl = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.initiatorUrl = Url.decode(decoder12);
        int readInt = decoder0.readInt(24);
        result.reason = readInt;
        NavigationBlockedReason.validate(readInt);
        result.reason = NavigationBlockedReason.toKnownValue(result.reason);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.blockedUrl, 8, false);
      encoder0.encode((Struct) this.initiatorUrl, 16, false);
      encoder0.encode(this.reason, 24);
    }
  }

  static final class LocalFrameHostDidChangeLoadProgressParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public double loadProgress;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidChangeLoadProgressParams(int version) {
      super(16, version);
    }

    public LocalFrameHostDidChangeLoadProgressParams() {
      this(0);
    }

    public static LocalFrameHostDidChangeLoadProgressParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidChangeLoadProgressParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidChangeLoadProgressParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidChangeLoadProgressParams result =
            new LocalFrameHostDidChangeLoadProgressParams(elementsOrVersion);
        result.loadProgress = decoder0.readDouble(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.loadProgress, 8);
    }
  }

  static final class LocalFrameHostDidFinishLoadParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url validatedUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidFinishLoadParams(int version) {
      super(16, version);
    }

    public LocalFrameHostDidFinishLoadParams() {
      this(0);
    }

    public static LocalFrameHostDidFinishLoadParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidFinishLoadParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidFinishLoadParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidFinishLoadParams result =
            new LocalFrameHostDidFinishLoadParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.validatedUrl = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.validatedUrl, 8, false);
    }
  }

  static final class LocalFrameHostDispatchLoadParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDispatchLoadParams(int version) {
      super(8, version);
    }

    public LocalFrameHostDispatchLoadParams() {
      this(0);
    }

    public static LocalFrameHostDispatchLoadParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDispatchLoadParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDispatchLoadParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDispatchLoadParams result =
            new LocalFrameHostDispatchLoadParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class LocalFrameHostGoToEntryAtOffsetParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean hasUserGesture;
    public int offset;
    public TaskAttributionId softNavigationHeuristicsTaskId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostGoToEntryAtOffsetParams(int version) {
      super(24, version);
    }

    public LocalFrameHostGoToEntryAtOffsetParams() {
      this(0);
    }

    public static LocalFrameHostGoToEntryAtOffsetParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostGoToEntryAtOffsetParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostGoToEntryAtOffsetParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostGoToEntryAtOffsetParams result =
            new LocalFrameHostGoToEntryAtOffsetParams(elementsOrVersion);
        result.offset = decoder0.readInt(8);
        result.hasUserGesture = decoder0.readBoolean(12, 0);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.softNavigationHeuristicsTaskId = TaskAttributionId.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.offset, 8);
      encoder0.encode(this.hasUserGesture, 12, 0);
      encoder0.encode((Struct) this.softNavigationHeuristicsTaskId, 16, true);
    }
  }

  static final class LocalFrameHostNavigateToNavigationApiKeyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean hasUserGesture;
    public String key;
    public TaskAttributionId softNavigationHeuristicsTaskId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostNavigateToNavigationApiKeyParams(int version) {
      super(32, version);
    }

    public LocalFrameHostNavigateToNavigationApiKeyParams() {
      this(0);
    }

    public static LocalFrameHostNavigateToNavigationApiKeyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostNavigateToNavigationApiKeyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostNavigateToNavigationApiKeyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostNavigateToNavigationApiKeyParams result =
            new LocalFrameHostNavigateToNavigationApiKeyParams(elementsOrVersion);
        result.key = decoder0.readString(8, false);
        result.hasUserGesture = decoder0.readBoolean(16, 0);
        Decoder decoder1 = decoder0.readPointer(24, true);
        result.softNavigationHeuristicsTaskId = TaskAttributionId.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.key, 8, false);
      encoder0.encode(this.hasUserGesture, 16, 0);
      encoder0.encode((Struct) this.softNavigationHeuristicsTaskId, 24, true);
    }
  }

  static final class LocalFrameHostNavigateEventHandlerPresenceChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean present;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostNavigateEventHandlerPresenceChangedParams(int version) {
      super(16, version);
    }

    public LocalFrameHostNavigateEventHandlerPresenceChangedParams() {
      this(0);
    }

    public static LocalFrameHostNavigateEventHandlerPresenceChangedParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostNavigateEventHandlerPresenceChangedParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostNavigateEventHandlerPresenceChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostNavigateEventHandlerPresenceChangedParams result =
            new LocalFrameHostNavigateEventHandlerPresenceChangedParams(elementsOrVersion);
        result.present = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.present, 8, 0);
    }
  }

  static final class LocalFrameHostUpdateTitleParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 title;
    public int titleDirection;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostUpdateTitleParams(int version) {
      super(24, version);
    }

    public LocalFrameHostUpdateTitleParams() {
      this(0);
    }

    public static LocalFrameHostUpdateTitleParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostUpdateTitleParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostUpdateTitleParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostUpdateTitleParams result =
            new LocalFrameHostUpdateTitleParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.title = String16.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.titleDirection = readInt;
        TextDirection.validate(readInt);
        result.titleDirection = TextDirection.toKnownValue(result.titleDirection);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.title, 8, true);
      encoder0.encode(this.titleDirection, 16);
    }
  }

  static final class LocalFrameHostUpdateAppTitleParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 appTitle;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostUpdateAppTitleParams(int version) {
      super(16, version);
    }

    public LocalFrameHostUpdateAppTitleParams() {
      this(0);
    }

    public static LocalFrameHostUpdateAppTitleParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostUpdateAppTitleParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostUpdateAppTitleParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostUpdateAppTitleParams result =
            new LocalFrameHostUpdateAppTitleParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.appTitle = String16.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.appTitle, 8, false);
    }
  }

  static final class LocalFrameHostUpdateUserActivationStateParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int notificationType;
    public int updateType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostUpdateUserActivationStateParams(int version) {
      super(16, version);
    }

    public LocalFrameHostUpdateUserActivationStateParams() {
      this(0);
    }

    public static LocalFrameHostUpdateUserActivationStateParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostUpdateUserActivationStateParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostUpdateUserActivationStateParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostUpdateUserActivationStateParams result =
            new LocalFrameHostUpdateUserActivationStateParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.updateType = readInt;
        UserActivationUpdateType.validate(readInt);
        result.updateType = UserActivationUpdateType.toKnownValue(result.updateType);
        int readInt2 = decoder0.readInt(12);
        result.notificationType = readInt2;
        UserActivationNotificationType.validate(readInt2);
        result.notificationType =
            UserActivationNotificationType.toKnownValue(result.notificationType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.updateType, 8);
      encoder0.encode(this.notificationType, 12);
    }
  }

  static final class LocalFrameHostDidConsumeHistoryUserActivationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidConsumeHistoryUserActivationParams(int version) {
      super(8, version);
    }

    public LocalFrameHostDidConsumeHistoryUserActivationParams() {
      this(0);
    }

    public static LocalFrameHostDidConsumeHistoryUserActivationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidConsumeHistoryUserActivationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidConsumeHistoryUserActivationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidConsumeHistoryUserActivationParams result =
            new LocalFrameHostDidConsumeHistoryUserActivationParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class LocalFrameHostHandleAccessibilityFindInPageResultParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FindInPageResultAxParams params;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostHandleAccessibilityFindInPageResultParams(int version) {
      super(16, version);
    }

    public LocalFrameHostHandleAccessibilityFindInPageResultParams() {
      this(0);
    }

    public static LocalFrameHostHandleAccessibilityFindInPageResultParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostHandleAccessibilityFindInPageResultParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostHandleAccessibilityFindInPageResultParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostHandleAccessibilityFindInPageResultParams result =
            new LocalFrameHostHandleAccessibilityFindInPageResultParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.params = FindInPageResultAxParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.params, 8, false);
    }
  }

  static final class LocalFrameHostHandleAccessibilityFindInPageTerminationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostHandleAccessibilityFindInPageTerminationParams(int version) {
      super(8, version);
    }

    public LocalFrameHostHandleAccessibilityFindInPageTerminationParams() {
      this(0);
    }

    public static LocalFrameHostHandleAccessibilityFindInPageTerminationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostHandleAccessibilityFindInPageTerminationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostHandleAccessibilityFindInPageTerminationParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostHandleAccessibilityFindInPageTerminationParams result =
            new LocalFrameHostHandleAccessibilityFindInPageTerminationParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class LocalFrameHostDocumentOnLoadCompletedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDocumentOnLoadCompletedParams(int version) {
      super(8, version);
    }

    public LocalFrameHostDocumentOnLoadCompletedParams() {
      this(0);
    }

    public static LocalFrameHostDocumentOnLoadCompletedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDocumentOnLoadCompletedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDocumentOnLoadCompletedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDocumentOnLoadCompletedParams result =
            new LocalFrameHostDocumentOnLoadCompletedParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class LocalFrameHostForwardResourceTimingToParentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ResourceTimingInfo timing;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostForwardResourceTimingToParentParams(int version) {
      super(16, version);
    }

    public LocalFrameHostForwardResourceTimingToParentParams() {
      this(0);
    }

    public static LocalFrameHostForwardResourceTimingToParentParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostForwardResourceTimingToParentParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostForwardResourceTimingToParentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostForwardResourceTimingToParentParams result =
            new LocalFrameHostForwardResourceTimingToParentParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.timing = ResourceTimingInfo.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.timing, 8, false);
    }
  }

  static final class LocalFrameHostDidDispatchDomContentLoadedEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidDispatchDomContentLoadedEventParams(int version) {
      super(8, version);
    }

    public LocalFrameHostDidDispatchDomContentLoadedEventParams() {
      this(0);
    }

    public static LocalFrameHostDidDispatchDomContentLoadedEventParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidDispatchDomContentLoadedEventParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidDispatchDomContentLoadedEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidDispatchDomContentLoadedEventParams result =
            new LocalFrameHostDidDispatchDomContentLoadedEventParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class LocalFrameHostRunModalAlertDialogParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 alertMessage;
    public boolean disableThirdPartySubframeSuppresion;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostRunModalAlertDialogParams(int version) {
      super(24, version);
    }

    public LocalFrameHostRunModalAlertDialogParams() {
      this(0);
    }

    public static LocalFrameHostRunModalAlertDialogParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostRunModalAlertDialogParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostRunModalAlertDialogParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostRunModalAlertDialogParams result =
            new LocalFrameHostRunModalAlertDialogParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.alertMessage = String16.decode(decoder1);
        result.disableThirdPartySubframeSuppresion = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.alertMessage, 8, false);
      encoder0.encode(this.disableThirdPartySubframeSuppresion, 16, 0);
    }
  }

  static final class LocalFrameHostRunModalAlertDialogResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostRunModalAlertDialogResponseParams(int version) {
      super(8, version);
    }

    public LocalFrameHostRunModalAlertDialogResponseParams() {
      this(0);
    }

    public static LocalFrameHostRunModalAlertDialogResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostRunModalAlertDialogResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostRunModalAlertDialogResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostRunModalAlertDialogResponseParams result =
            new LocalFrameHostRunModalAlertDialogResponseParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static class LocalFrameHostRunModalAlertDialogResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrameHost.RunModalAlertDialog_Response mCallback;

    LocalFrameHostRunModalAlertDialogResponseParamsForwardToCallback(
        LocalFrameHost.RunModalAlertDialog_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(39, 6)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameHostRunModalAlertDialogResponseParamsProxyToResponder
      implements LocalFrameHost.RunModalAlertDialog_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameHostRunModalAlertDialogResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      LocalFrameHostRunModalAlertDialogResponseParams _response =
          new LocalFrameHostRunModalAlertDialogResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(39, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameHostRunModalConfirmDialogParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 alertMessage;
    public boolean disableThirdPartySubframeSuppresion;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostRunModalConfirmDialogParams(int version) {
      super(24, version);
    }

    public LocalFrameHostRunModalConfirmDialogParams() {
      this(0);
    }

    public static LocalFrameHostRunModalConfirmDialogParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostRunModalConfirmDialogParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostRunModalConfirmDialogParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostRunModalConfirmDialogParams result =
            new LocalFrameHostRunModalConfirmDialogParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.alertMessage = String16.decode(decoder1);
        result.disableThirdPartySubframeSuppresion = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.alertMessage, 8, false);
      encoder0.encode(this.disableThirdPartySubframeSuppresion, 16, 0);
    }
  }

  static final class LocalFrameHostRunModalConfirmDialogResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostRunModalConfirmDialogResponseParams(int version) {
      super(16, version);
    }

    public LocalFrameHostRunModalConfirmDialogResponseParams() {
      this(0);
    }

    public static LocalFrameHostRunModalConfirmDialogResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostRunModalConfirmDialogResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostRunModalConfirmDialogResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostRunModalConfirmDialogResponseParams result =
            new LocalFrameHostRunModalConfirmDialogResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class LocalFrameHostRunModalConfirmDialogResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrameHost.RunModalConfirmDialog_Response mCallback;

    LocalFrameHostRunModalConfirmDialogResponseParamsForwardToCallback(
        LocalFrameHost.RunModalConfirmDialog_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(40, 6)) {
          return false;
        }
        LocalFrameHostRunModalConfirmDialogResponseParams response =
            LocalFrameHostRunModalConfirmDialogResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameHostRunModalConfirmDialogResponseParamsProxyToResponder
      implements LocalFrameHost.RunModalConfirmDialog_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameHostRunModalConfirmDialogResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      LocalFrameHostRunModalConfirmDialogResponseParams _response =
          new LocalFrameHostRunModalConfirmDialogResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(40, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameHostRunModalPromptDialogParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 alertMessage;
    public String16 defaultValue;
    public boolean disableThirdPartySubframeSuppresion;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostRunModalPromptDialogParams(int version) {
      super(32, version);
    }

    public LocalFrameHostRunModalPromptDialogParams() {
      this(0);
    }

    public static LocalFrameHostRunModalPromptDialogParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostRunModalPromptDialogParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostRunModalPromptDialogParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostRunModalPromptDialogParams result =
            new LocalFrameHostRunModalPromptDialogParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.alertMessage = String16.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.defaultValue = String16.decode(decoder12);
        result.disableThirdPartySubframeSuppresion = decoder0.readBoolean(24, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.alertMessage, 8, false);
      encoder0.encode((Struct) this.defaultValue, 16, false);
      encoder0.encode(this.disableThirdPartySubframeSuppresion, 24, 0);
    }
  }

  static final class LocalFrameHostRunModalPromptDialogResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 result;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostRunModalPromptDialogResponseParams(int version) {
      super(24, version);
    }

    public LocalFrameHostRunModalPromptDialogResponseParams() {
      this(0);
    }

    public static LocalFrameHostRunModalPromptDialogResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostRunModalPromptDialogResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostRunModalPromptDialogResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostRunModalPromptDialogResponseParams result =
            new LocalFrameHostRunModalPromptDialogResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.result = String16.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
      encoder0.encode((Struct) this.result, 16, false);
    }
  }

  static class LocalFrameHostRunModalPromptDialogResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrameHost.RunModalPromptDialog_Response mCallback;

    LocalFrameHostRunModalPromptDialogResponseParamsForwardToCallback(
        LocalFrameHost.RunModalPromptDialog_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(41, 6)) {
          return false;
        }
        LocalFrameHostRunModalPromptDialogResponseParams response =
            LocalFrameHostRunModalPromptDialogResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success, response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameHostRunModalPromptDialogResponseParamsProxyToResponder
      implements LocalFrameHost.RunModalPromptDialog_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameHostRunModalPromptDialogResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success, String16 result) {
      LocalFrameHostRunModalPromptDialogResponseParams _response =
          new LocalFrameHostRunModalPromptDialogResponseParams();
      _response.success = success;
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(41, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameHostRunBeforeUnloadConfirmParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isReload;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostRunBeforeUnloadConfirmParams(int version) {
      super(16, version);
    }

    public LocalFrameHostRunBeforeUnloadConfirmParams() {
      this(0);
    }

    public static LocalFrameHostRunBeforeUnloadConfirmParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostRunBeforeUnloadConfirmParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostRunBeforeUnloadConfirmParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostRunBeforeUnloadConfirmParams result =
            new LocalFrameHostRunBeforeUnloadConfirmParams(elementsOrVersion);
        result.isReload = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.isReload, 8, 0);
    }
  }

  static final class LocalFrameHostRunBeforeUnloadConfirmResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostRunBeforeUnloadConfirmResponseParams(int version) {
      super(16, version);
    }

    public LocalFrameHostRunBeforeUnloadConfirmResponseParams() {
      this(0);
    }

    public static LocalFrameHostRunBeforeUnloadConfirmResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostRunBeforeUnloadConfirmResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostRunBeforeUnloadConfirmResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostRunBeforeUnloadConfirmResponseParams result =
            new LocalFrameHostRunBeforeUnloadConfirmResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class LocalFrameHostRunBeforeUnloadConfirmResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrameHost.RunBeforeUnloadConfirm_Response mCallback;

    LocalFrameHostRunBeforeUnloadConfirmResponseParamsForwardToCallback(
        LocalFrameHost.RunBeforeUnloadConfirm_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(42, 6)) {
          return false;
        }
        LocalFrameHostRunBeforeUnloadConfirmResponseParams response =
            LocalFrameHostRunBeforeUnloadConfirmResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameHostRunBeforeUnloadConfirmResponseParamsProxyToResponder
      implements LocalFrameHost.RunBeforeUnloadConfirm_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameHostRunBeforeUnloadConfirmResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      LocalFrameHostRunBeforeUnloadConfirmResponseParams _response =
          new LocalFrameHostRunBeforeUnloadConfirmResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(42, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameHostUpdateFaviconUrlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FaviconUrl[] faviconUrls;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostUpdateFaviconUrlParams(int version) {
      super(16, version);
    }

    public LocalFrameHostUpdateFaviconUrlParams() {
      this(0);
    }

    public static LocalFrameHostUpdateFaviconUrlParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostUpdateFaviconUrlParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostUpdateFaviconUrlParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostUpdateFaviconUrlParams result =
            new LocalFrameHostUpdateFaviconUrlParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.faviconUrls = new FaviconUrl[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.faviconUrls[i1] = FaviconUrl.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      FaviconUrl[] faviconUrlArr = this.faviconUrls;
      if (faviconUrlArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(faviconUrlArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        FaviconUrl[] faviconUrlArr2 = this.faviconUrls;
        if (i0 < faviconUrlArr2.length) {
          encoder1.encode((Struct) faviconUrlArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class LocalFrameHostDownloadUrlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DownloadUrlParams params;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDownloadUrlParams(int version) {
      super(16, version);
    }

    public LocalFrameHostDownloadUrlParams() {
      this(0);
    }

    public static LocalFrameHostDownloadUrlParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDownloadUrlParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDownloadUrlParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDownloadUrlParams result =
            new LocalFrameHostDownloadUrlParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.params = DownloadUrlParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.params, 8, false);
    }
  }

  static final class LocalFrameHostFocusedElementChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect boundsInFrameWidget;
    public int focusType;
    public boolean isEditableElement;
    public boolean isRichlyEditableElement;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostFocusedElementChangedParams(int version) {
      super(24, version);
    }

    public LocalFrameHostFocusedElementChangedParams() {
      this(0);
    }

    public static LocalFrameHostFocusedElementChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostFocusedElementChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostFocusedElementChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostFocusedElementChangedParams result =
            new LocalFrameHostFocusedElementChangedParams(elementsOrVersion);
        result.isEditableElement = decoder0.readBoolean(8, 0);
        result.isRichlyEditableElement = decoder0.readBoolean(8, 1);
        int readInt = decoder0.readInt(12);
        result.focusType = readInt;
        FocusType.validate(readInt);
        result.focusType = FocusType.toKnownValue(result.focusType);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.boundsInFrameWidget = Rect.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.isEditableElement, 8, 0);
      encoder0.encode(this.isRichlyEditableElement, 8, 1);
      encoder0.encode(this.focusType, 12);
      encoder0.encode((Struct) this.boundsInFrameWidget, 16, false);
    }
  }

  static final class LocalFrameHostTextSelectionChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int offset;
    public Range range;
    public BigString16 text;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostTextSelectionChangedParams(int version) {
      super(32, version);
    }

    public LocalFrameHostTextSelectionChangedParams() {
      this(0);
    }

    public static LocalFrameHostTextSelectionChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostTextSelectionChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostTextSelectionChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostTextSelectionChangedParams result =
            new LocalFrameHostTextSelectionChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.text = BigString16.decode(decoder1);
        result.offset = decoder0.readInt(16);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.range = Range.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.text, 8, false);
      encoder0.encode(this.offset, 16);
      encoder0.encode((Struct) this.range, 24, false);
    }
  }

  static final class LocalFrameHostShowPopupMenuParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean allowMultipleSelection;
    public Rect bounds;
    public double fontSize;
    public int itemHeight;
    public MenuItem[] menuItems;
    public PopupMenuClient popupClient;
    public boolean rightAligned;
    public int selectedItem;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostShowPopupMenuParams(int version) {
      super(56, version);
    }

    public LocalFrameHostShowPopupMenuParams() {
      this(0);
    }

    public static LocalFrameHostShowPopupMenuParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostShowPopupMenuParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostShowPopupMenuParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostShowPopupMenuParams result =
            new LocalFrameHostShowPopupMenuParams(elementsOrVersion);
        result.popupClient =
            (PopupMenuClient) decoder0.readServiceInterface(8, false, PopupMenuClient.MANAGER);
        result.bounds = Rect.decode(decoder0.readPointer(16, false));
        result.itemHeight = decoder0.readInt(24);
        result.selectedItem = decoder0.readInt(28);
        result.fontSize = decoder0.readDouble(32);
        Decoder decoder1 = decoder0.readPointer(40, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.menuItems = new MenuItem[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.menuItems[i1] = MenuItem.decode(decoder2);
        }
        result.rightAligned = decoder0.readBoolean(48, 0);
        result.allowMultipleSelection = decoder0.readBoolean(48, 1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.popupClient, 8, false, PopupMenuClient.MANAGER);
      encoder0.encode((Struct) this.bounds, 16, false);
      encoder0.encode(this.itemHeight, 24);
      encoder0.encode(this.selectedItem, 28);
      encoder0.encode(this.fontSize, 32);
      MenuItem[] menuItemArr = this.menuItems;
      if (menuItemArr == null) {
        encoder0.encodeNullPointer(40, false);
      } else {
        Encoder encoder1 = encoder0.encodePointerArray(menuItemArr.length, 40, -1);
        int i0 = 0;
        while (true) {
          MenuItem[] menuItemArr2 = this.menuItems;
          if (i0 >= menuItemArr2.length) {
            break;
          }
          encoder1.encode((Struct) menuItemArr2[i0], (i0 * 8) + 8, false);
          i0++;
        }
      }
      encoder0.encode(this.rightAligned, 48, 0);
      encoder0.encode(this.allowMultipleSelection, 48, 1);
    }
  }

  static final class LocalFrameHostCreateNewPopupWidgetParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceNotSupported blinkWidget;
    public AssociatedInterfaceRequestNotSupported blinkWidgetHost;
    public AssociatedInterfaceRequestNotSupported popupHost;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostCreateNewPopupWidgetParams(int version) {
      super(24, version);
    }

    public LocalFrameHostCreateNewPopupWidgetParams() {
      this(0);
    }

    public static LocalFrameHostCreateNewPopupWidgetParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostCreateNewPopupWidgetParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostCreateNewPopupWidgetParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostCreateNewPopupWidgetParams result =
            new LocalFrameHostCreateNewPopupWidgetParams(elementsOrVersion);
        result.popupHost = decoder0.readAssociatedInterfaceRequestNotSupported(8, false);
        result.blinkWidgetHost = decoder0.readAssociatedInterfaceRequestNotSupported(12, false);
        result.blinkWidget = decoder0.readAssociatedServiceInterfaceNotSupported(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.popupHost, 8, false);
      encoder0.encode(this.blinkWidgetHost, 12, false);
      encoder0.encode(this.blinkWidget, 16, false);
    }
  }

  static final class LocalFrameHostShowContextMenuParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceNotSupported client;
    public UntrustworthyContextMenuParams params;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostShowContextMenuParams(int version) {
      super(24, version);
    }

    public LocalFrameHostShowContextMenuParams() {
      this(0);
    }

    public static LocalFrameHostShowContextMenuParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostShowContextMenuParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostShowContextMenuParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostShowContextMenuParams result =
            new LocalFrameHostShowContextMenuParams(elementsOrVersion);
        result.client = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.params = UntrustworthyContextMenuParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.client, 8, false);
      encoder0.encode((Struct) this.params, 16, false);
    }
  }

  static final class LocalFrameHostDidLoadResourceFromMemoryCacheParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public String httpMethod;
    public boolean includeCredentials;
    public String mimeType;
    public int requestDestination;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidLoadResourceFromMemoryCacheParams(int version) {
      super(40, version);
    }

    public LocalFrameHostDidLoadResourceFromMemoryCacheParams() {
      this(0);
    }

    public static LocalFrameHostDidLoadResourceFromMemoryCacheParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidLoadResourceFromMemoryCacheParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidLoadResourceFromMemoryCacheParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidLoadResourceFromMemoryCacheParams result =
            new LocalFrameHostDidLoadResourceFromMemoryCacheParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        result.httpMethod = decoder0.readString(16, false);
        result.mimeType = decoder0.readString(24, false);
        int readInt = decoder0.readInt(32);
        result.requestDestination = readInt;
        RequestDestination.validate(readInt);
        result.requestDestination = RequestDestination.toKnownValue(result.requestDestination);
        result.includeCredentials = decoder0.readBoolean(36, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode(this.httpMethod, 16, false);
      encoder0.encode(this.mimeType, 24, false);
      encoder0.encode(this.requestDestination, 32);
      encoder0.encode(this.includeCredentials, 36, 0);
    }
  }

  static final class LocalFrameHostDidChangeFrameOwnerPropertiesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public FrameToken childFrameToken;
    public FrameOwnerProperties frameOwnerProperties;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidChangeFrameOwnerPropertiesParams(int version) {
      super(32, version);
    }

    public LocalFrameHostDidChangeFrameOwnerPropertiesParams() {
      this(0);
    }

    public static LocalFrameHostDidChangeFrameOwnerPropertiesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidChangeFrameOwnerPropertiesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidChangeFrameOwnerPropertiesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidChangeFrameOwnerPropertiesParams result =
            new LocalFrameHostDidChangeFrameOwnerPropertiesParams(elementsOrVersion);
        result.childFrameToken = FrameToken.decode(decoder0, 8);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.frameOwnerProperties = FrameOwnerProperties.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.childFrameToken, 8, false);
      encoder0.encode((Struct) this.frameOwnerProperties, 24, false);
    }
  }

  static final class LocalFrameHostDidChangeOpenerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public LocalFrameToken openerFrame;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidChangeOpenerParams(int version) {
      super(16, version);
    }

    public LocalFrameHostDidChangeOpenerParams() {
      this(0);
    }

    public static LocalFrameHostDidChangeOpenerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidChangeOpenerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidChangeOpenerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidChangeOpenerParams result =
            new LocalFrameHostDidChangeOpenerParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.openerFrame = LocalFrameToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.openerFrame, 8, true);
    }
  }

  static final class LocalFrameHostDidChangeFramePolicyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public FrameToken childFrameToken;
    public FramePolicy framePolicy;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidChangeFramePolicyParams(int version) {
      super(32, version);
    }

    public LocalFrameHostDidChangeFramePolicyParams() {
      this(0);
    }

    public static LocalFrameHostDidChangeFramePolicyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidChangeFramePolicyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidChangeFramePolicyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidChangeFramePolicyParams result =
            new LocalFrameHostDidChangeFramePolicyParams(elementsOrVersion);
        result.childFrameToken = FrameToken.decode(decoder0, 8);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.framePolicy = FramePolicy.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.childFrameToken, 8, false);
      encoder0.encode((Struct) this.framePolicy, 24, false);
    }
  }

  static final class LocalFrameHostDidChangeIframeAttributesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public IframeAttributes attributes;
    public FrameToken childFrameToken;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidChangeIframeAttributesParams(int version) {
      super(32, version);
    }

    public LocalFrameHostDidChangeIframeAttributesParams() {
      this(0);
    }

    public static LocalFrameHostDidChangeIframeAttributesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidChangeIframeAttributesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidChangeIframeAttributesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidChangeIframeAttributesParams result =
            new LocalFrameHostDidChangeIframeAttributesParams(elementsOrVersion);
        result.childFrameToken = FrameToken.decode(decoder0, 8);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.attributes = IframeAttributes.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.childFrameToken, 8, false);
      encoder0.encode((Struct) this.attributes, 24, false);
    }
  }

  static final class LocalFrameHostCapturePaintPreviewOfSubframeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect clipRect;
    public UnguessableToken guid;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostCapturePaintPreviewOfSubframeParams(int version) {
      super(24, version);
    }

    public LocalFrameHostCapturePaintPreviewOfSubframeParams() {
      this(0);
    }

    public static LocalFrameHostCapturePaintPreviewOfSubframeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostCapturePaintPreviewOfSubframeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostCapturePaintPreviewOfSubframeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostCapturePaintPreviewOfSubframeParams result =
            new LocalFrameHostCapturePaintPreviewOfSubframeParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.clipRect = Rect.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.guid = UnguessableToken.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.clipRect, 8, false);
      encoder0.encode((Struct) this.guid, 16, false);
    }
  }

  static final class LocalFrameHostSetCloseListenerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CloseListener listener;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostSetCloseListenerParams(int version) {
      super(16, version);
    }

    public LocalFrameHostSetCloseListenerParams() {
      this(0);
    }

    public static LocalFrameHostSetCloseListenerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostSetCloseListenerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostSetCloseListenerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostSetCloseListenerParams result =
            new LocalFrameHostSetCloseListenerParams(elementsOrVersion);
        result.listener =
            (CloseListener) decoder0.readServiceInterface(8, false, CloseListener.MANAGER);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.listener, 8, false, CloseListener.MANAGER);
    }
  }

  static final class LocalFrameHostDetachParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDetachParams(int version) {
      super(8, version);
    }

    public LocalFrameHostDetachParams() {
      this(0);
    }

    public static LocalFrameHostDetachParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDetachParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDetachParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDetachParams result = new LocalFrameHostDetachParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class LocalFrameHostGetKeepAliveHandleFactoryParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<KeepAliveHandleFactory> factory;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostGetKeepAliveHandleFactoryParams(int version) {
      super(16, version);
    }

    public LocalFrameHostGetKeepAliveHandleFactoryParams() {
      this(0);
    }

    public static LocalFrameHostGetKeepAliveHandleFactoryParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostGetKeepAliveHandleFactoryParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostGetKeepAliveHandleFactoryParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostGetKeepAliveHandleFactoryParams result =
            new LocalFrameHostGetKeepAliveHandleFactoryParams(elementsOrVersion);
        result.factory = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.factory, 8, false);
    }
  }

  static final class LocalFrameHostDidAddMessageToConsoleParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public int lineNumber;
    public int logLevel;
    public BigString16 msg;
    public String16 sourceId;
    public BigString16 untrustedStackTrace;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidAddMessageToConsoleParams(int version) {
      super(40, version);
    }

    public LocalFrameHostDidAddMessageToConsoleParams() {
      this(0);
    }

    public static LocalFrameHostDidAddMessageToConsoleParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidAddMessageToConsoleParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidAddMessageToConsoleParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidAddMessageToConsoleParams result =
            new LocalFrameHostDidAddMessageToConsoleParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.logLevel = readInt;
        ConsoleMessageLevel.validate(readInt);
        result.logLevel = ConsoleMessageLevel.toKnownValue(result.logLevel);
        result.lineNumber = decoder0.readInt(12);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.msg = BigString16.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, true);
        result.sourceId = String16.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(32, true);
        result.untrustedStackTrace = BigString16.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.logLevel, 8);
      encoder0.encode(this.lineNumber, 12);
      encoder0.encode((Struct) this.msg, 16, false);
      encoder0.encode((Struct) this.sourceId, 24, true);
      encoder0.encode((Struct) this.untrustedStackTrace, 32, true);
    }
  }

  static final class LocalFrameHostFrameSizeChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Size size;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostFrameSizeChangedParams(int version) {
      super(16, version);
    }

    public LocalFrameHostFrameSizeChangedParams() {
      this(0);
    }

    public static LocalFrameHostFrameSizeChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostFrameSizeChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostFrameSizeChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostFrameSizeChangedParams result =
            new LocalFrameHostFrameSizeChangedParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.size = Size.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.size, 8, false);
    }
  }

  static final class LocalFrameHostDidInferColorSchemeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int colorScheme;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidInferColorSchemeParams(int version) {
      super(16, version);
    }

    public LocalFrameHostDidInferColorSchemeParams() {
      this(0);
    }

    public static LocalFrameHostDidInferColorSchemeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidInferColorSchemeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidInferColorSchemeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidInferColorSchemeParams result =
            new LocalFrameHostDidInferColorSchemeParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.colorScheme = readInt;
        PreferredColorScheme.validate(readInt);
        result.colorScheme = PreferredColorScheme.toKnownValue(result.colorScheme);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.colorScheme, 8);
    }
  }

  static final class LocalFrameHostDidChangeSrcDocParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public FrameToken childFrameToken;
    public String srcdocValue;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDidChangeSrcDocParams(int version) {
      super(32, version);
    }

    public LocalFrameHostDidChangeSrcDocParams() {
      this(0);
    }

    public static LocalFrameHostDidChangeSrcDocParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDidChangeSrcDocParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDidChangeSrcDocParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDidChangeSrcDocParams result =
            new LocalFrameHostDidChangeSrcDocParams(elementsOrVersion);
        result.childFrameToken = FrameToken.decode(decoder0, 8);
        result.srcdocValue = decoder0.readString(24, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.childFrameToken, 8, false);
      encoder0.encode(this.srcdocValue, 24, false);
    }
  }

  static final class LocalFrameHostReceivedDelegatedCapabilityParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int delegatedCapability;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostReceivedDelegatedCapabilityParams(int version) {
      super(16, version);
    }

    public LocalFrameHostReceivedDelegatedCapabilityParams() {
      this(0);
    }

    public static LocalFrameHostReceivedDelegatedCapabilityParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostReceivedDelegatedCapabilityParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostReceivedDelegatedCapabilityParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostReceivedDelegatedCapabilityParams result =
            new LocalFrameHostReceivedDelegatedCapabilityParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.delegatedCapability = readInt;
        DelegatedCapability.validate(readInt);
        result.delegatedCapability = DelegatedCapability.toKnownValue(result.delegatedCapability);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.delegatedCapability, 8);
    }
  }

  static final class LocalFrameHostSendFencedFrameReportingBeaconParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int[] destinations;
    public String eventData;
    public String eventType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostSendFencedFrameReportingBeaconParams(int version) {
      super(32, version);
    }

    public LocalFrameHostSendFencedFrameReportingBeaconParams() {
      this(0);
    }

    public static LocalFrameHostSendFencedFrameReportingBeaconParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostSendFencedFrameReportingBeaconParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostSendFencedFrameReportingBeaconParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostSendFencedFrameReportingBeaconParams result =
            new LocalFrameHostSendFencedFrameReportingBeaconParams(elementsOrVersion);
        result.eventData = decoder0.readString(8, false);
        result.eventType = decoder0.readString(16, false);
        result.destinations = decoder0.readInts(24, 0, -1);
        int i1 = 0;
        while (true) {
          int[] iArr = result.destinations;
          if (i1 < iArr.length) {
            ReportingDestination.validate(iArr[i1]);
            i1++;
          } else {
            return result;
          }
        }
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.eventData, 8, false);
      encoder0.encode(this.eventType, 16, false);
      encoder0.encode(this.destinations, 24, 0, -1);
    }
  }

  static final class LocalFrameHostSendFencedFrameReportingBeaconToCustomUrlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url destinationUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostSendFencedFrameReportingBeaconToCustomUrlParams(int version) {
      super(16, version);
    }

    public LocalFrameHostSendFencedFrameReportingBeaconToCustomUrlParams() {
      this(0);
    }

    public static LocalFrameHostSendFencedFrameReportingBeaconToCustomUrlParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostSendFencedFrameReportingBeaconToCustomUrlParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostSendFencedFrameReportingBeaconToCustomUrlParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostSendFencedFrameReportingBeaconToCustomUrlParams result =
            new LocalFrameHostSendFencedFrameReportingBeaconToCustomUrlParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.destinationUrl = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.destinationUrl, 8, false);
    }
  }

  static final class LocalFrameHostDisableUntrustedNetworkInFencedFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDisableUntrustedNetworkInFencedFrameParams(int version) {
      super(8, version);
    }

    public LocalFrameHostDisableUntrustedNetworkInFencedFrameParams() {
      this(0);
    }

    public static LocalFrameHostDisableUntrustedNetworkInFencedFrameParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDisableUntrustedNetworkInFencedFrameParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDisableUntrustedNetworkInFencedFrameParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDisableUntrustedNetworkInFencedFrameParams result =
            new LocalFrameHostDisableUntrustedNetworkInFencedFrameParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static final class LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParams(int version) {
      super(8, version);
    }

    public LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParams() {
      this(0);
    }

    public static LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParams result =
            new LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }

  static class LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrameHost.DisableUntrustedNetworkInFencedFrame_Response mCallback;

    LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParamsForwardToCallback(
        LocalFrameHost.DisableUntrustedNetworkInFencedFrame_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(66, 2)) {
          return false;
        }
        this.mCallback.call();
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParamsProxyToResponder
      implements LocalFrameHost.DisableUntrustedNetworkInFencedFrame_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call() {
      LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParams _response =
          new LocalFrameHostDisableUntrustedNetworkInFencedFrameResponseParams();
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(66, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameHostSendLegacyTechEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public LegacyTechEventCodeLocation codeLocation;
    public String type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostSendLegacyTechEventParams(int version) {
      super(24, version);
    }

    public LocalFrameHostSendLegacyTechEventParams() {
      this(0);
    }

    public static LocalFrameHostSendLegacyTechEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostSendLegacyTechEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostSendLegacyTechEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostSendLegacyTechEventParams result =
            new LocalFrameHostSendLegacyTechEventParams(elementsOrVersion);
        result.type = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.codeLocation = LegacyTechEventCodeLocation.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.type, 8, false);
      encoder0.encode((Struct) this.codeLocation, 16, false);
    }
  }

  static final class LocalFrameHostSetFencedFrameAutomaticBeaconReportEventDataParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean crossOriginExposed;
    public int[] destinations;
    public String eventData;
    public int eventType;
    public boolean once;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostSetFencedFrameAutomaticBeaconReportEventDataParams(int version) {
      super(32, version);
    }

    public LocalFrameHostSetFencedFrameAutomaticBeaconReportEventDataParams() {
      this(0);
    }

    public static LocalFrameHostSetFencedFrameAutomaticBeaconReportEventDataParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostSetFencedFrameAutomaticBeaconReportEventDataParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostSetFencedFrameAutomaticBeaconReportEventDataParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostSetFencedFrameAutomaticBeaconReportEventDataParams result =
            new LocalFrameHostSetFencedFrameAutomaticBeaconReportEventDataParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.eventType = readInt;
        AutomaticBeaconType.validate(readInt);
        result.eventType = AutomaticBeaconType.toKnownValue(result.eventType);
        result.once = decoder0.readBoolean(12, 0);
        result.crossOriginExposed = decoder0.readBoolean(12, 1);
        result.eventData = decoder0.readString(16, false);
        result.destinations = decoder0.readInts(24, 0, -1);
        int i1 = 0;
        while (true) {
          int[] iArr = result.destinations;
          if (i1 < iArr.length) {
            ReportingDestination.validate(iArr[i1]);
            i1++;
          } else {
            return result;
          }
        }
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.eventType, 8);
      encoder0.encode(this.once, 12, 0);
      encoder0.encode(this.crossOriginExposed, 12, 1);
      encoder0.encode(this.eventData, 16, false);
      encoder0.encode(this.destinations, 24, 0, -1);
    }
  }

  static final class LocalFrameHostSendPrivateAggregationRequestsForFencedFrameEventParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String eventType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostSendPrivateAggregationRequestsForFencedFrameEventParams(int version) {
      super(16, version);
    }

    public LocalFrameHostSendPrivateAggregationRequestsForFencedFrameEventParams() {
      this(0);
    }

    public static LocalFrameHostSendPrivateAggregationRequestsForFencedFrameEventParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostSendPrivateAggregationRequestsForFencedFrameEventParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostSendPrivateAggregationRequestsForFencedFrameEventParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostSendPrivateAggregationRequestsForFencedFrameEventParams result =
            new LocalFrameHostSendPrivateAggregationRequestsForFencedFrameEventParams(
                elementsOrVersion);
        result.eventType = decoder0.readString(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.eventType, 8, false);
    }
  }

  static final class LocalFrameHostSetAttributionReportingRuntimeFeaturesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public AttributionReportingRuntimeFeatures features;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostSetAttributionReportingRuntimeFeaturesParams(int version) {
      super(16, version);
    }

    public LocalFrameHostSetAttributionReportingRuntimeFeaturesParams() {
      this(0);
    }

    public static LocalFrameHostSetAttributionReportingRuntimeFeaturesParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostSetAttributionReportingRuntimeFeaturesParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostSetAttributionReportingRuntimeFeaturesParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostSetAttributionReportingRuntimeFeaturesParams result =
            new LocalFrameHostSetAttributionReportingRuntimeFeaturesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.features = AttributionReportingRuntimeFeatures.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.features, 8, false);
    }
  }

  static final class LocalFrameHostCreateFencedFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public UnguessableToken devtoolsFrameToken;
    public AssociatedInterfaceRequestNotSupported fencedFrame;
    public RemoteFrameToken frameToken;
    public RemoteFrameInterfacesFromRenderer remoteFrameInterfaces;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostCreateFencedFrameParams(int version) {
      super(40, version);
    }

    public LocalFrameHostCreateFencedFrameParams() {
      this(0);
    }

    public static LocalFrameHostCreateFencedFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostCreateFencedFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostCreateFencedFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostCreateFencedFrameParams result =
            new LocalFrameHostCreateFencedFrameParams(elementsOrVersion);
        result.fencedFrame = decoder0.readAssociatedInterfaceRequestNotSupported(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.remoteFrameInterfaces = RemoteFrameInterfacesFromRenderer.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.frameToken = RemoteFrameToken.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(32, false);
        result.devtoolsFrameToken = UnguessableToken.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.fencedFrame, 8, false);
      encoder0.encode((Struct) this.remoteFrameInterfaces, 16, false);
      encoder0.encode((Struct) this.frameToken, 24, false);
      encoder0.encode((Struct) this.devtoolsFrameToken, 32, false);
    }
  }

  static final class LocalFrameHostOnViewTransitionOptInChangedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int viewTransitionOptIn;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostOnViewTransitionOptInChangedParams(int version) {
      super(16, version);
    }

    public LocalFrameHostOnViewTransitionOptInChangedParams() {
      this(0);
    }

    public static LocalFrameHostOnViewTransitionOptInChangedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostOnViewTransitionOptInChangedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostOnViewTransitionOptInChangedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostOnViewTransitionOptInChangedParams result =
            new LocalFrameHostOnViewTransitionOptInChangedParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.viewTransitionOptIn = readInt;
        ViewTransitionSameOriginOptIn.validate(readInt);
        result.viewTransitionOptIn =
            ViewTransitionSameOriginOptIn.toKnownValue(result.viewTransitionOptIn);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.viewTransitionOptIn, 8);
    }
  }

  static final class LocalFrameHostStartDraggingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 56;
    private static final DataHeader[] VERSION_ARRAY;
    public Vector2d cursorOffsetInDip;
    public DragData dragData;
    public Rect dragObjRectInDip;
    public DragEventSourceInfo eventInfo;
    public BitmapN32 image;
    public AllowedDragOperations operationsAllowed;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHostStartDraggingParams(int version) {
      super(56, version);
    }

    public LocalFrameHostStartDraggingParams() {
      this(0);
    }

    public static LocalFrameHostStartDraggingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHostStartDraggingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHostStartDraggingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHostStartDraggingParams result =
            new LocalFrameHostStartDraggingParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.dragData = DragData.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.operationsAllowed = AllowedDragOperations.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, true);
        result.image = BitmapN32.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(32, false);
        result.cursorOffsetInDip = Vector2d.decode(decoder14);
        Decoder decoder15 = decoder0.readPointer(40, false);
        result.dragObjRectInDip = Rect.decode(decoder15);
        Decoder decoder16 = decoder0.readPointer(48, false);
        result.eventInfo = DragEventSourceInfo.decode(decoder16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.dragData, 8, false);
      encoder0.encode((Struct) this.operationsAllowed, 16, false);
      encoder0.encode((Struct) this.image, 24, true);
      encoder0.encode((Struct) this.cursorOffsetInDip, 32, false);
      encoder0.encode((Struct) this.dragObjRectInDip, 40, false);
      encoder0.encode((Struct) this.eventInfo, 48, false);
    }
  }
}
