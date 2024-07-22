package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.ImageSkia;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
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
import org.chromium.mojo_base.mojom.ByteString;
import org.chromium.mojo_base.mojom.ListValue;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.mojo_base.mojom.Value;
import org.chromium.network.mojom.ConnectionInfo;
import org.chromium.network.mojom.CspViolation;
import org.chromium.network.mojom.LoadTimingInfo;
import org.chromium.network.mojom.SourceLocation;
import org.chromium.network.mojom.UrlLoaderCompletionStatus;
import org.chromium.url.mojom.Url;

class LocalFrame_Internal {
  private static final int ADD_MESSAGE_TO_CONSOLE_ORDINAL = 5;
  private static final int ADD_RESOURCE_TIMING_ENTRY_FOR_FAILED_SUBFRAME_NAVIGATION_ORDINAL = 44;
  private static final int ADVANCE_FOCUS_FOR_IME_ORDINAL = 22;
  private static final int ADVANCE_FOCUS_IN_FRAME_ORDINAL = 21;
  private static final int BEFORE_UNLOAD_ORDINAL = 17;
  private static final int BIND_DEV_TOOLS_AGENT_ORDINAL = 34;
  private static final int BIND_REPORTING_OBSERVER_ORDINAL = 30;
  private static final int CHECK_COMPLETED_ORDINAL = 7;
  private static final int CLEAR_FOCUSED_ELEMENT_ORDINAL = 12;
  private static final int COLLAPSE_ORDINAL = 9;
  private static final int COPY_IMAGE_AT_ORDINAL = 13;
  private static final int DID_UPDATE_FRAME_POLICY_ORDINAL = 24;
  private static final int DISPATCH_NAVIGATE_EVENT_FOR_CROSS_DOCUMENT_TRAVERSAL_ORDINAL = 42;
  private static final int ENABLE_VIEW_SOURCE_MODE_ORDINAL = 10;
  private static final int EXTRACT_SMART_CLIP_DATA_ORDINAL = 35;
  private static final int FOCUS_ORDINAL = 11;
  private static final int GET_CANONICAL_URL_FOR_SHARING_ORDINAL = 37;
  private static final int GET_OPEN_GRAPH_METADATA_ORDINAL = 38;
  private static final int GET_SAVABLE_RESOURCE_LINKS_ORDINAL = 32;
  private static final int GET_TEXT_SURROUNDING_SELECTION_ORDINAL = 0;
  private static final int HANDLE_RENDERER_DEBUG_URL_ORDINAL = 36;
  private static final int JAVA_SCRIPT_EXECUTE_REQUEST_FOR_TESTS_ORDINAL = 28;
  private static final int JAVA_SCRIPT_EXECUTE_REQUEST_IN_ISOLATED_WORLD_ORDINAL = 29;
  private static final int JAVA_SCRIPT_EXECUTE_REQUEST_ORDINAL = 27;
  private static final int JAVA_SCRIPT_METHOD_EXECUTE_REQUEST_ORDINAL = 26;
  public static final Interface.Manager<LocalFrame, LocalFrame.Proxy> MANAGER =
      new Interface.Manager<LocalFrame, LocalFrame.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.LocalFrame";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public LocalFrame.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, LocalFrame impl) {
          return new Stub(core, impl);
        }

        @Override
        public LocalFrame[] buildArray(int size) {
          return new LocalFrame[size];
        }
      };
  private static final int MEDIA_PLAYER_ACTION_AT_ORDINAL = 18;
  private static final int MIXED_CONTENT_FOUND_ORDINAL = 33;
  private static final int NOTIFY_NAVIGATION_API_OF_DISPOSED_ENTRIES_ORDINAL = 40;
  private static final int NOTIFY_USER_ACTIVATION_ORDINAL = 3;
  private static final int NOTIFY_VIRTUAL_KEYBOARD_OVERLAY_RECT_ORDINAL = 4;
  private static final int PLUGIN_ACTION_AT_ORDINAL = 20;
  private static final int POST_MESSAGE_EVENT_ORDINAL = 25;
  private static final int RENDER_FALLBACK_CONTENT_ORDINAL = 16;
  private static final int REPORT_BLINK_FEATURE_USAGE_ORDINAL = 15;
  private static final int REPORT_CONTENT_SECURITY_POLICY_VIOLATION_ORDINAL = 23;
  private static final int REQUEST_FULLSCREEN_DOCUMENT_ELEMENT_ORDINAL = 45;
  private static final int REQUEST_VIDEO_FRAME_AT_ORDINAL = 19;
  private static final int SAVE_IMAGE_AT_ORDINAL = 14;
  private static final int SEND_INTERVENTION_REPORT_ORDINAL = 1;
  private static final int SET_FRAME_OWNER_PROPERTIES_ORDINAL = 2;
  private static final int SET_NAVIGATION_API_HISTORY_ENTRIES_FOR_RESTORE_ORDINAL = 39;
  private static final int SNAPSHOT_DOCUMENT_FOR_VIEW_TRANSITION_ORDINAL = 43;
  private static final int STOP_LOADING_ORDINAL = 8;
  private static final int SWAP_IN_IMMEDIATELY_ORDINAL = 6;
  private static final int TRAVERSE_CANCELLED_ORDINAL = 41;
  private static final int UPDATE_OPENER_ORDINAL = 31;

  LocalFrame_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements LocalFrame.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getTextSurroundingSelection(
        int maxLength, GetTextSurroundingSelection_Response callback) {
      LocalFrameGetTextSurroundingSelectionParams _message =
          new LocalFrameGetTextSurroundingSelectionParams();
      _message.maxLength = maxLength;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new LocalFrameGetTextSurroundingSelectionResponseParamsForwardToCallback(callback));
    }

    @Override
    public void sendInterventionReport(String id, String message) {
      LocalFrameSendInterventionReportParams _message =
          new LocalFrameSendInterventionReportParams();
      _message.id = id;
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }

    @Override
    public void setFrameOwnerProperties(FrameOwnerProperties properties) {
      LocalFrameSetFrameOwnerPropertiesParams _message =
          new LocalFrameSetFrameOwnerPropertiesParams();
      _message.properties = properties;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(2)));
    }

    @Override
    public void notifyUserActivation(int notificationType) {
      LocalFrameNotifyUserActivationParams _message = new LocalFrameNotifyUserActivationParams();
      _message.notificationType = notificationType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(3)));
    }

    @Override
    public void notifyVirtualKeyboardOverlayRect(Rect keyboardRect) {
      LocalFrameNotifyVirtualKeyboardOverlayRectParams _message =
          new LocalFrameNotifyVirtualKeyboardOverlayRectParams();
      _message.keyboardRect = keyboardRect;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(4)));
    }

    @Override
    public void addMessageToConsole(int level, String message, boolean discardDuplicates) {
      LocalFrameAddMessageToConsoleParams _message = new LocalFrameAddMessageToConsoleParams();
      _message.level = level;
      _message.message = message;
      _message.discardDuplicates = discardDuplicates;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(5)));
    }

    @Override
    public void swapInImmediately() {
      LocalFrameSwapInImmediatelyParams _message = new LocalFrameSwapInImmediatelyParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(6)));
    }

    @Override
    public void checkCompleted() {
      LocalFrameCheckCompletedParams _message = new LocalFrameCheckCompletedParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(7)));
    }

    @Override
    public void stopLoading() {
      LocalFrameStopLoadingParams _message = new LocalFrameStopLoadingParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(8)));
    }

    @Override
    public void collapse(boolean collapsed) {
      LocalFrameCollapseParams _message = new LocalFrameCollapseParams();
      _message.collapsed = collapsed;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(9)));
    }

    @Override
    public void enableViewSourceMode() {
      LocalFrameEnableViewSourceModeParams _message = new LocalFrameEnableViewSourceModeParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(10)));
    }

    @Override
    public void focus() {
      LocalFrameFocusParams _message = new LocalFrameFocusParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(11)));
    }

    @Override
    public void clearFocusedElement() {
      LocalFrameClearFocusedElementParams _message = new LocalFrameClearFocusedElementParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
    }

    @Override
    public void copyImageAt(Point windowPoint) {
      LocalFrameCopyImageAtParams _message = new LocalFrameCopyImageAtParams();
      _message.windowPoint = windowPoint;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13)));
    }

    @Override
    public void saveImageAt(Point windowPoint) {
      LocalFrameSaveImageAtParams _message = new LocalFrameSaveImageAtParams();
      _message.windowPoint = windowPoint;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(14)));
    }

    @Override
    public void reportBlinkFeatureUsage(int[] features) {
      LocalFrameReportBlinkFeatureUsageParams _message =
          new LocalFrameReportBlinkFeatureUsageParams();
      _message.features = features;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(15)));
    }

    @Override
    public void renderFallbackContent() {
      LocalFrameRenderFallbackContentParams _message = new LocalFrameRenderFallbackContentParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(16)));
    }

    @Override
    public void beforeUnload(boolean isReload, BeforeUnload_Response callback) {
      LocalFrameBeforeUnloadParams _message = new LocalFrameBeforeUnloadParams();
      _message.isReload = isReload;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(17, 1, 0L)),
              new LocalFrameBeforeUnloadResponseParamsForwardToCallback(callback));
    }

    @Override
    public void mediaPlayerActionAt(Point location, MediaPlayerAction action) {
      LocalFrameMediaPlayerActionAtParams _message = new LocalFrameMediaPlayerActionAtParams();
      _message.location = location;
      _message.action = action;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(18)));
    }

    @Override
    public void requestVideoFrameAt(
        Point location, Size maxSize, int maxArea, RequestVideoFrameAt_Response callback) {
      LocalFrameRequestVideoFrameAtParams _message = new LocalFrameRequestVideoFrameAtParams();
      _message.location = location;
      _message.maxSize = maxSize;
      _message.maxArea = maxArea;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(19, 1, 0L)),
              new LocalFrameRequestVideoFrameAtResponseParamsForwardToCallback(callback));
    }

    @Override
    public void pluginActionAt(Point location, int action) {
      LocalFramePluginActionAtParams _message = new LocalFramePluginActionAtParams();
      _message.location = location;
      _message.action = action;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(20)));
    }

    @Override
    public void advanceFocusInFrame(int focusType, RemoteFrameToken sourceFrameToken) {
      LocalFrameAdvanceFocusInFrameParams _message = new LocalFrameAdvanceFocusInFrameParams();
      _message.focusType = focusType;
      _message.sourceFrameToken = sourceFrameToken;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(21)));
    }

    @Override
    public void advanceFocusForIme(int focusType) {
      LocalFrameAdvanceFocusForImeParams _message = new LocalFrameAdvanceFocusForImeParams();
      _message.focusType = focusType;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(22)));
    }

    @Override
    public void reportContentSecurityPolicyViolation(CspViolation violation) {
      LocalFrameReportContentSecurityPolicyViolationParams _message =
          new LocalFrameReportContentSecurityPolicyViolationParams();
      _message.violation = violation;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(23)));
    }

    @Override
    public void didUpdateFramePolicy(FramePolicy framePolicy) {
      LocalFrameDidUpdateFramePolicyParams _message = new LocalFrameDidUpdateFramePolicyParams();
      _message.framePolicy = framePolicy;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(24)));
    }

    @Override
    public void postMessageEvent(
        RemoteFrameToken sourceFrameToken,
        String16 sourceOrigin,
        String16 targetOrigin,
        TransferableMessage message) {
      LocalFramePostMessageEventParams _message = new LocalFramePostMessageEventParams();
      _message.sourceFrameToken = sourceFrameToken;
      _message.sourceOrigin = sourceOrigin;
      _message.targetOrigin = targetOrigin;
      _message.message = message;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(25)));
    }

    @Override
    public void javaScriptMethodExecuteRequest(
        String16 objectName,
        String16 methodName,
        ListValue arguments,
        boolean wantsResult,
        JavaScriptMethodExecuteRequest_Response callback) {
      LocalFrameJavaScriptMethodExecuteRequestParams _message =
          new LocalFrameJavaScriptMethodExecuteRequestParams();
      _message.objectName = objectName;
      _message.methodName = methodName;
      _message.arguments = arguments;
      _message.wantsResult = wantsResult;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(26, 1, 0L)),
              new LocalFrameJavaScriptMethodExecuteRequestResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void javaScriptExecuteRequest(
        BigString16 javascript, boolean wantsResult, JavaScriptExecuteRequest_Response callback) {
      LocalFrameJavaScriptExecuteRequestParams _message =
          new LocalFrameJavaScriptExecuteRequestParams();
      _message.javascript = javascript;
      _message.wantsResult = wantsResult;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(27, 1, 0L)),
              new LocalFrameJavaScriptExecuteRequestResponseParamsForwardToCallback(callback));
    }

    @Override
    public void javaScriptExecuteRequestForTests(
        BigString16 javascript,
        boolean hasUserGesture,
        boolean resolvePromises,
        int worldId,
        JavaScriptExecuteRequestForTests_Response callback) {
      LocalFrameJavaScriptExecuteRequestForTestsParams _message =
          new LocalFrameJavaScriptExecuteRequestForTestsParams();
      _message.javascript = javascript;
      _message.hasUserGesture = hasUserGesture;
      _message.resolvePromises = resolvePromises;
      _message.worldId = worldId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(28, 1, 0L)),
              new LocalFrameJavaScriptExecuteRequestForTestsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void javaScriptExecuteRequestInIsolatedWorld(
        BigString16 javascript,
        boolean wantsResult,
        int worldId,
        JavaScriptExecuteRequestInIsolatedWorld_Response callback) {
      LocalFrameJavaScriptExecuteRequestInIsolatedWorldParams _message =
          new LocalFrameJavaScriptExecuteRequestInIsolatedWorldParams();
      _message.javascript = javascript;
      _message.wantsResult = wantsResult;
      _message.worldId = worldId;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(29, 1, 0L)),
              new LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void bindReportingObserver(InterfaceRequest<ReportingObserver> receiver) {
      LocalFrameBindReportingObserverParams _message = new LocalFrameBindReportingObserverParams();
      _message.receiver = receiver;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(30)));
    }

    @Override
    public void updateOpener(FrameToken openerFrameToken) {
      LocalFrameUpdateOpenerParams _message = new LocalFrameUpdateOpenerParams();
      _message.openerFrameToken = openerFrameToken;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(31)));
    }

    @Override
    public void getSavableResourceLinks(GetSavableResourceLinks_Response callback) {
      LocalFrameGetSavableResourceLinksParams _message =
          new LocalFrameGetSavableResourceLinksParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(32, 1, 0L)),
              new LocalFrameGetSavableResourceLinksResponseParamsForwardToCallback(callback));
    }

    @Override
    public void mixedContentFound(
        Url mainResourceUrl,
        Url mixedContentUrl,
        int requestContext,
        boolean wasAllowed,
        Url urlBeforeRedirects,
        boolean hadRedirect,
        SourceLocation sourceLocation) {
      LocalFrameMixedContentFoundParams _message = new LocalFrameMixedContentFoundParams();
      _message.mainResourceUrl = mainResourceUrl;
      _message.mixedContentUrl = mixedContentUrl;
      _message.requestContext = requestContext;
      _message.wasAllowed = wasAllowed;
      _message.urlBeforeRedirects = urlBeforeRedirects;
      _message.hadRedirect = hadRedirect;
      _message.sourceLocation = sourceLocation;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(33)));
    }

    @Override
    public void bindDevToolsAgent(
        AssociatedInterfaceNotSupported agentHost, AssociatedInterfaceRequestNotSupported agent) {
      LocalFrameBindDevToolsAgentParams _message = new LocalFrameBindDevToolsAgentParams();
      _message.agentHost = agentHost;
      _message.agent = agent;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(34)));
    }

    @Override
    public void extractSmartClipData(Rect rect, ExtractSmartClipData_Response callback) {
      LocalFrameExtractSmartClipDataParams _message = new LocalFrameExtractSmartClipDataParams();
      _message.rect = rect;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(35, 1, 0L)),
              new LocalFrameExtractSmartClipDataResponseParamsForwardToCallback(callback));
    }

    @Override
    public void handleRendererDebugUrl(Url url) {
      LocalFrameHandleRendererDebugUrlParams _message =
          new LocalFrameHandleRendererDebugUrlParams();
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(36)));
    }

    @Override
    public void getCanonicalUrlForSharing(GetCanonicalUrlForSharing_Response callback) {
      LocalFrameGetCanonicalUrlForSharingParams _message =
          new LocalFrameGetCanonicalUrlForSharingParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(37, 1, 0L)),
              new LocalFrameGetCanonicalUrlForSharingResponseParamsForwardToCallback(callback));
    }

    @Override
    public void getOpenGraphMetadata(GetOpenGraphMetadata_Response callback) {
      LocalFrameGetOpenGraphMetadataParams _message = new LocalFrameGetOpenGraphMetadataParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(38, 1, 0L)),
              new LocalFrameGetOpenGraphMetadataResponseParamsForwardToCallback(callback));
    }

    @Override
    public void setNavigationApiHistoryEntriesForRestore(
        NavigationApiHistoryEntryArrays entryArrays, int restoreReason) {
      LocalFrameSetNavigationApiHistoryEntriesForRestoreParams _message =
          new LocalFrameSetNavigationApiHistoryEntriesForRestoreParams();
      _message.entryArrays = entryArrays;
      _message.restoreReason = restoreReason;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(39)));
    }

    @Override
    public void notifyNavigationApiOfDisposedEntries(String[] keys) {
      LocalFrameNotifyNavigationApiOfDisposedEntriesParams _message =
          new LocalFrameNotifyNavigationApiOfDisposedEntriesParams();
      _message.keys = keys;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(40)));
    }

    @Override
    public void traverseCancelled(String navigationApiKey, int reason) {
      LocalFrameTraverseCancelledParams _message = new LocalFrameTraverseCancelledParams();
      _message.navigationApiKey = navigationApiKey;
      _message.reason = reason;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(41)));
    }

    @Override
    public void dispatchNavigateEventForCrossDocumentTraversal(
        Url url, ByteString pageState, boolean isBrowserInitiated) {
      LocalFrameDispatchNavigateEventForCrossDocumentTraversalParams _message =
          new LocalFrameDispatchNavigateEventForCrossDocumentTraversalParams();
      _message.url = url;
      _message.pageState = pageState;
      _message.isBrowserInitiated = isBrowserInitiated;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(42)));
    }

    @Override
    public void snapshotDocumentForViewTransition(
        PageConcealEventParams pageConcealEventParams,
        SnapshotDocumentForViewTransition_Response callback) {
      LocalFrameSnapshotDocumentForViewTransitionParams _message =
          new LocalFrameSnapshotDocumentForViewTransitionParams();
      _message.pageConcealEventParams = pageConcealEventParams;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(43, 1, 0L)),
              new LocalFrameSnapshotDocumentForViewTransitionResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void addResourceTimingEntryForFailedSubframeNavigation(
        FrameToken subframeToken,
        Url initialUrl,
        TimeTicks startTime,
        TimeTicks redirectTime,
        TimeTicks requestStart,
        TimeTicks responseStart,
        int responseCode,
        String mimeType,
        LoadTimingInfo loadTimingInfo,
        int connectionInfo,
        String alpnNegotiatedProtocol,
        boolean isSecureTransport,
        boolean isValidated,
        String normalizedServerTiming,
        UrlLoaderCompletionStatus completionStatus) {
      LocalFrameAddResourceTimingEntryForFailedSubframeNavigationParams _message =
          new LocalFrameAddResourceTimingEntryForFailedSubframeNavigationParams();
      _message.subframeToken = subframeToken;
      _message.initialUrl = initialUrl;
      _message.startTime = startTime;
      _message.redirectTime = redirectTime;
      _message.requestStart = requestStart;
      _message.responseStart = responseStart;
      _message.responseCode = responseCode;
      _message.mimeType = mimeType;
      _message.loadTimingInfo = loadTimingInfo;
      _message.connectionInfo = connectionInfo;
      _message.alpnNegotiatedProtocol = alpnNegotiatedProtocol;
      _message.isSecureTransport = isSecureTransport;
      _message.isValidated = isValidated;
      _message.normalizedServerTiming = normalizedServerTiming;
      _message.completionStatus = completionStatus;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(44)));
    }

    @Override
    public void requestFullscreenDocumentElement() {
      LocalFrameRequestFullscreenDocumentElementParams _message =
          new LocalFrameRequestFullscreenDocumentElementParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(45)));
    }
  }

  public static final class Stub extends Interface.Stub<LocalFrame> {
    Stub(Core core, LocalFrame impl) {
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
                LocalFrame_Internal.MANAGER, messageWithHeader);
          case -1:
          case 0:
          case 17:
          case 19:
          case 26:
          case 27:
          case 28:
          case 29:
          case 32:
          case 35:
          case 37:
          case 38:
          case 43:
          default:
            return false;
          case 1:
            LocalFrameSendInterventionReportParams data =
                LocalFrameSendInterventionReportParams.deserialize(messageWithHeader.getPayload());
            getImpl().sendInterventionReport(data.id, data.message);
            return true;
          case 2:
            getImpl()
                .setFrameOwnerProperties(
                    LocalFrameSetFrameOwnerPropertiesParams.deserialize(
                            messageWithHeader.getPayload())
                        .properties);
            return true;
          case 3:
            getImpl()
                .notifyUserActivation(
                    LocalFrameNotifyUserActivationParams.deserialize(messageWithHeader.getPayload())
                        .notificationType);
            return true;
          case 4:
            getImpl()
                .notifyVirtualKeyboardOverlayRect(
                    LocalFrameNotifyVirtualKeyboardOverlayRectParams.deserialize(
                            messageWithHeader.getPayload())
                        .keyboardRect);
            return true;
          case 5:
            LocalFrameAddMessageToConsoleParams data2 =
                LocalFrameAddMessageToConsoleParams.deserialize(messageWithHeader.getPayload());
            getImpl().addMessageToConsole(data2.level, data2.message, data2.discardDuplicates);
            return true;
          case 6:
            LocalFrameSwapInImmediatelyParams.deserialize(messageWithHeader.getPayload());
            getImpl().swapInImmediately();
            return true;
          case 7:
            LocalFrameCheckCompletedParams.deserialize(messageWithHeader.getPayload());
            getImpl().checkCompleted();
            return true;
          case 8:
            LocalFrameStopLoadingParams.deserialize(messageWithHeader.getPayload());
            getImpl().stopLoading();
            return true;
          case 9:
            getImpl()
                .collapse(
                    LocalFrameCollapseParams.deserialize(messageWithHeader.getPayload()).collapsed);
            return true;
          case 10:
            LocalFrameEnableViewSourceModeParams.deserialize(messageWithHeader.getPayload());
            getImpl().enableViewSourceMode();
            return true;
          case 11:
            LocalFrameFocusParams.deserialize(messageWithHeader.getPayload());
            getImpl().focus();
            return true;
          case 12:
            LocalFrameClearFocusedElementParams.deserialize(messageWithHeader.getPayload());
            getImpl().clearFocusedElement();
            return true;
          case 13:
            getImpl()
                .copyImageAt(
                    LocalFrameCopyImageAtParams.deserialize(messageWithHeader.getPayload())
                        .windowPoint);
            return true;
          case 14:
            getImpl()
                .saveImageAt(
                    LocalFrameSaveImageAtParams.deserialize(messageWithHeader.getPayload())
                        .windowPoint);
            return true;
          case 15:
            getImpl()
                .reportBlinkFeatureUsage(
                    LocalFrameReportBlinkFeatureUsageParams.deserialize(
                            messageWithHeader.getPayload())
                        .features);
            return true;
          case 16:
            LocalFrameRenderFallbackContentParams.deserialize(messageWithHeader.getPayload());
            getImpl().renderFallbackContent();
            return true;
          case 18:
            LocalFrameMediaPlayerActionAtParams data3 =
                LocalFrameMediaPlayerActionAtParams.deserialize(messageWithHeader.getPayload());
            getImpl().mediaPlayerActionAt(data3.location, data3.action);
            return true;
          case 20:
            LocalFramePluginActionAtParams data4 =
                LocalFramePluginActionAtParams.deserialize(messageWithHeader.getPayload());
            getImpl().pluginActionAt(data4.location, data4.action);
            return true;
          case 21:
            LocalFrameAdvanceFocusInFrameParams data5 =
                LocalFrameAdvanceFocusInFrameParams.deserialize(messageWithHeader.getPayload());
            getImpl().advanceFocusInFrame(data5.focusType, data5.sourceFrameToken);
            return true;
          case 22:
            getImpl()
                .advanceFocusForIme(
                    LocalFrameAdvanceFocusForImeParams.deserialize(messageWithHeader.getPayload())
                        .focusType);
            return true;
          case 23:
            getImpl()
                .reportContentSecurityPolicyViolation(
                    LocalFrameReportContentSecurityPolicyViolationParams.deserialize(
                            messageWithHeader.getPayload())
                        .violation);
            return true;
          case 24:
            getImpl()
                .didUpdateFramePolicy(
                    LocalFrameDidUpdateFramePolicyParams.deserialize(messageWithHeader.getPayload())
                        .framePolicy);
            return true;
          case 25:
            LocalFramePostMessageEventParams data6 =
                LocalFramePostMessageEventParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .postMessageEvent(
                    data6.sourceFrameToken, data6.sourceOrigin, data6.targetOrigin, data6.message);
            return true;
          case 30:
            getImpl()
                .bindReportingObserver(
                    LocalFrameBindReportingObserverParams.deserialize(
                            messageWithHeader.getPayload())
                        .receiver);
            return true;
          case 31:
            getImpl()
                .updateOpener(
                    LocalFrameUpdateOpenerParams.deserialize(messageWithHeader.getPayload())
                        .openerFrameToken);
            return true;
          case 33:
            LocalFrameMixedContentFoundParams data7 =
                LocalFrameMixedContentFoundParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .mixedContentFound(
                    data7.mainResourceUrl,
                    data7.mixedContentUrl,
                    data7.requestContext,
                    data7.wasAllowed,
                    data7.urlBeforeRedirects,
                    data7.hadRedirect,
                    data7.sourceLocation);
            return true;
          case 34:
            LocalFrameBindDevToolsAgentParams data8 =
                LocalFrameBindDevToolsAgentParams.deserialize(messageWithHeader.getPayload());
            getImpl().bindDevToolsAgent(data8.agentHost, data8.agent);
            return true;
          case 36:
            getImpl()
                .handleRendererDebugUrl(
                    LocalFrameHandleRendererDebugUrlParams.deserialize(
                            messageWithHeader.getPayload())
                        .url);
            return true;
          case 39:
            LocalFrameSetNavigationApiHistoryEntriesForRestoreParams data9 =
                LocalFrameSetNavigationApiHistoryEntriesForRestoreParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .setNavigationApiHistoryEntriesForRestore(data9.entryArrays, data9.restoreReason);
            return true;
          case 40:
            getImpl()
                .notifyNavigationApiOfDisposedEntries(
                    LocalFrameNotifyNavigationApiOfDisposedEntriesParams.deserialize(
                            messageWithHeader.getPayload())
                        .keys);
            return true;
          case 41:
            LocalFrameTraverseCancelledParams data10 =
                LocalFrameTraverseCancelledParams.deserialize(messageWithHeader.getPayload());
            getImpl().traverseCancelled(data10.navigationApiKey, data10.reason);
            return true;
          case 42:
            LocalFrameDispatchNavigateEventForCrossDocumentTraversalParams data11 =
                LocalFrameDispatchNavigateEventForCrossDocumentTraversalParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .dispatchNavigateEventForCrossDocumentTraversal(
                    data11.url, data11.pageState, data11.isBrowserInitiated);
            return true;
          case 44:
            LocalFrameAddResourceTimingEntryForFailedSubframeNavigationParams data12 =
                LocalFrameAddResourceTimingEntryForFailedSubframeNavigationParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .addResourceTimingEntryForFailedSubframeNavigation(
                    data12.subframeToken,
                    data12.initialUrl,
                    data12.startTime,
                    data12.redirectTime,
                    data12.requestStart,
                    data12.responseStart,
                    data12.responseCode,
                    data12.mimeType,
                    data12.loadTimingInfo,
                    data12.connectionInfo,
                    data12.alpnNegotiatedProtocol,
                    data12.isSecureTransport,
                    data12.isValidated,
                    data12.normalizedServerTiming,
                    data12.completionStatus);
            return true;
          case 45:
            LocalFrameRequestFullscreenDocumentElementParams.deserialize(
                messageWithHeader.getPayload());
            getImpl().requestFullscreenDocumentElement();
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
                getCore(), LocalFrame_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            LocalFrameGetTextSurroundingSelectionParams data =
                LocalFrameGetTextSurroundingSelectionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .getTextSurroundingSelection(
                    data.maxLength,
                    new LocalFrameGetTextSurroundingSelectionResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 17:
            LocalFrameBeforeUnloadParams data2 =
                LocalFrameBeforeUnloadParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .beforeUnload(
                    data2.isReload,
                    new LocalFrameBeforeUnloadResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 19:
            LocalFrameRequestVideoFrameAtParams data3 =
                LocalFrameRequestVideoFrameAtParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .requestVideoFrameAt(
                    data3.location,
                    data3.maxSize,
                    data3.maxArea,
                    new LocalFrameRequestVideoFrameAtResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 26:
            LocalFrameJavaScriptMethodExecuteRequestParams data4 =
                LocalFrameJavaScriptMethodExecuteRequestParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .javaScriptMethodExecuteRequest(
                    data4.objectName,
                    data4.methodName,
                    data4.arguments,
                    data4.wantsResult,
                    new LocalFrameJavaScriptMethodExecuteRequestResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 27:
            LocalFrameJavaScriptExecuteRequestParams data5 =
                LocalFrameJavaScriptExecuteRequestParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .javaScriptExecuteRequest(
                    data5.javascript,
                    data5.wantsResult,
                    new LocalFrameJavaScriptExecuteRequestResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 28:
            LocalFrameJavaScriptExecuteRequestForTestsParams data6 =
                LocalFrameJavaScriptExecuteRequestForTestsParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .javaScriptExecuteRequestForTests(
                    data6.javascript,
                    data6.hasUserGesture,
                    data6.resolvePromises,
                    data6.worldId,
                    new LocalFrameJavaScriptExecuteRequestForTestsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 29:
            LocalFrameJavaScriptExecuteRequestInIsolatedWorldParams data7 =
                LocalFrameJavaScriptExecuteRequestInIsolatedWorldParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .javaScriptExecuteRequestInIsolatedWorld(
                    data7.javascript,
                    data7.wantsResult,
                    data7.worldId,
                    new LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 32:
            LocalFrameGetSavableResourceLinksParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getSavableResourceLinks(
                    new LocalFrameGetSavableResourceLinksResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 35:
            LocalFrameExtractSmartClipDataParams data8 =
                LocalFrameExtractSmartClipDataParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .extractSmartClipData(
                    data8.rect,
                    new LocalFrameExtractSmartClipDataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 37:
            LocalFrameGetCanonicalUrlForSharingParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getCanonicalUrlForSharing(
                    new LocalFrameGetCanonicalUrlForSharingResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 38:
            LocalFrameGetOpenGraphMetadataParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .getOpenGraphMetadata(
                    new LocalFrameGetOpenGraphMetadataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 43:
            LocalFrameSnapshotDocumentForViewTransitionParams data9 =
                LocalFrameSnapshotDocumentForViewTransitionParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .snapshotDocumentForViewTransition(
                    data9.pageConcealEventParams,
                    new LocalFrameSnapshotDocumentForViewTransitionResponseParamsProxyToResponder(
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

  static final class LocalFrameGetTextSurroundingSelectionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int maxLength;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameGetTextSurroundingSelectionParams(int version) {
      super(16, version);
    }

    public LocalFrameGetTextSurroundingSelectionParams() {
      this(0);
    }

    public static LocalFrameGetTextSurroundingSelectionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameGetTextSurroundingSelectionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameGetTextSurroundingSelectionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameGetTextSurroundingSelectionParams result =
            new LocalFrameGetTextSurroundingSelectionParams(elementsOrVersion);
        result.maxLength = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.maxLength, 8);
    }
  }

  static final class LocalFrameGetTextSurroundingSelectionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 content;
    public int endOffset;
    public int startOffset;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameGetTextSurroundingSelectionResponseParams(int version) {
      super(24, version);
    }

    public LocalFrameGetTextSurroundingSelectionResponseParams() {
      this(0);
    }

    public static LocalFrameGetTextSurroundingSelectionResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameGetTextSurroundingSelectionResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameGetTextSurroundingSelectionResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameGetTextSurroundingSelectionResponseParams result =
            new LocalFrameGetTextSurroundingSelectionResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.content = String16.decode(decoder1);
        result.startOffset = decoder0.readInt(16);
        result.endOffset = decoder0.readInt(20);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.content, 8, false);
      encoder0.encode(this.startOffset, 16);
      encoder0.encode(this.endOffset, 20);
    }
  }

  static class LocalFrameGetTextSurroundingSelectionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrame.GetTextSurroundingSelection_Response mCallback;

    LocalFrameGetTextSurroundingSelectionResponseParamsForwardToCallback(
        LocalFrame.GetTextSurroundingSelection_Response callback) {
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
        LocalFrameGetTextSurroundingSelectionResponseParams response =
            LocalFrameGetTextSurroundingSelectionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.content, response.startOffset, response.endOffset);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameGetTextSurroundingSelectionResponseParamsProxyToResponder
      implements LocalFrame.GetTextSurroundingSelection_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameGetTextSurroundingSelectionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String16 content, int startOffset, int endOffset) {
      LocalFrameGetTextSurroundingSelectionResponseParams _response =
          new LocalFrameGetTextSurroundingSelectionResponseParams();
      _response.content = content;
      _response.startOffset = startOffset;
      _response.endOffset = endOffset;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameSendInterventionReportParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String id;
    public String message;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameSendInterventionReportParams(int version) {
      super(24, version);
    }

    public LocalFrameSendInterventionReportParams() {
      this(0);
    }

    public static LocalFrameSendInterventionReportParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameSendInterventionReportParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameSendInterventionReportParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameSendInterventionReportParams result =
            new LocalFrameSendInterventionReportParams(elementsOrVersion);
        result.id = decoder0.readString(8, false);
        result.message = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.id, 8, false);
      encoder0.encode(this.message, 16, false);
    }
  }

  static final class LocalFrameSetFrameOwnerPropertiesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FrameOwnerProperties properties;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameSetFrameOwnerPropertiesParams(int version) {
      super(16, version);
    }

    public LocalFrameSetFrameOwnerPropertiesParams() {
      this(0);
    }

    public static LocalFrameSetFrameOwnerPropertiesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameSetFrameOwnerPropertiesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameSetFrameOwnerPropertiesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameSetFrameOwnerPropertiesParams result =
            new LocalFrameSetFrameOwnerPropertiesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.properties = FrameOwnerProperties.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.properties, 8, false);
    }
  }

  static final class LocalFrameNotifyUserActivationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int notificationType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameNotifyUserActivationParams(int version) {
      super(16, version);
    }

    public LocalFrameNotifyUserActivationParams() {
      this(0);
    }

    public static LocalFrameNotifyUserActivationParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameNotifyUserActivationParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameNotifyUserActivationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameNotifyUserActivationParams result =
            new LocalFrameNotifyUserActivationParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.notificationType = readInt;
        UserActivationNotificationType.validate(readInt);
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
      encoder0.encode(this.notificationType, 8);
    }
  }

  static final class LocalFrameNotifyVirtualKeyboardOverlayRectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect keyboardRect;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameNotifyVirtualKeyboardOverlayRectParams(int version) {
      super(16, version);
    }

    public LocalFrameNotifyVirtualKeyboardOverlayRectParams() {
      this(0);
    }

    public static LocalFrameNotifyVirtualKeyboardOverlayRectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameNotifyVirtualKeyboardOverlayRectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameNotifyVirtualKeyboardOverlayRectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameNotifyVirtualKeyboardOverlayRectParams result =
            new LocalFrameNotifyVirtualKeyboardOverlayRectParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.keyboardRect = Rect.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.keyboardRect, 8, false);
    }
  }

  static final class LocalFrameAddMessageToConsoleParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean discardDuplicates;
    public int level;
    public String message;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameAddMessageToConsoleParams(int version) {
      super(24, version);
    }

    public LocalFrameAddMessageToConsoleParams() {
      this(0);
    }

    public static LocalFrameAddMessageToConsoleParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameAddMessageToConsoleParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameAddMessageToConsoleParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameAddMessageToConsoleParams result =
            new LocalFrameAddMessageToConsoleParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.level = readInt;
        ConsoleMessageLevel.validate(readInt);
        result.level = ConsoleMessageLevel.toKnownValue(result.level);
        result.discardDuplicates = decoder0.readBoolean(12, 0);
        result.message = decoder0.readString(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.level, 8);
      encoder0.encode(this.discardDuplicates, 12, 0);
      encoder0.encode(this.message, 16, false);
    }
  }

  static final class LocalFrameSwapInImmediatelyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameSwapInImmediatelyParams(int version) {
      super(8, version);
    }

    public LocalFrameSwapInImmediatelyParams() {
      this(0);
    }

    public static LocalFrameSwapInImmediatelyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameSwapInImmediatelyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameSwapInImmediatelyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameSwapInImmediatelyParams result =
            new LocalFrameSwapInImmediatelyParams(elementsOrVersion);
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

  static final class LocalFrameCheckCompletedParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameCheckCompletedParams(int version) {
      super(8, version);
    }

    public LocalFrameCheckCompletedParams() {
      this(0);
    }

    public static LocalFrameCheckCompletedParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameCheckCompletedParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameCheckCompletedParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameCheckCompletedParams result =
            new LocalFrameCheckCompletedParams(elementsOrVersion);
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

  static final class LocalFrameStopLoadingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameStopLoadingParams(int version) {
      super(8, version);
    }

    public LocalFrameStopLoadingParams() {
      this(0);
    }

    public static LocalFrameStopLoadingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameStopLoadingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameStopLoadingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameStopLoadingParams result = new LocalFrameStopLoadingParams(elementsOrVersion);
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

  static final class LocalFrameCollapseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean collapsed;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameCollapseParams(int version) {
      super(16, version);
    }

    public LocalFrameCollapseParams() {
      this(0);
    }

    public static LocalFrameCollapseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameCollapseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameCollapseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameCollapseParams result = new LocalFrameCollapseParams(elementsOrVersion);
        result.collapsed = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.collapsed, 8, 0);
    }
  }

  static final class LocalFrameEnableViewSourceModeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameEnableViewSourceModeParams(int version) {
      super(8, version);
    }

    public LocalFrameEnableViewSourceModeParams() {
      this(0);
    }

    public static LocalFrameEnableViewSourceModeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameEnableViewSourceModeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameEnableViewSourceModeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameEnableViewSourceModeParams result =
            new LocalFrameEnableViewSourceModeParams(elementsOrVersion);
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

  static final class LocalFrameFocusParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameFocusParams(int version) {
      super(8, version);
    }

    public LocalFrameFocusParams() {
      this(0);
    }

    public static LocalFrameFocusParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameFocusParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameFocusParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameFocusParams result = new LocalFrameFocusParams(elementsOrVersion);
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

  static final class LocalFrameClearFocusedElementParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameClearFocusedElementParams(int version) {
      super(8, version);
    }

    public LocalFrameClearFocusedElementParams() {
      this(0);
    }

    public static LocalFrameClearFocusedElementParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameClearFocusedElementParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameClearFocusedElementParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameClearFocusedElementParams result =
            new LocalFrameClearFocusedElementParams(elementsOrVersion);
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

  static final class LocalFrameCopyImageAtParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Point windowPoint;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameCopyImageAtParams(int version) {
      super(16, version);
    }

    public LocalFrameCopyImageAtParams() {
      this(0);
    }

    public static LocalFrameCopyImageAtParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameCopyImageAtParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameCopyImageAtParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameCopyImageAtParams result = new LocalFrameCopyImageAtParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.windowPoint = Point.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.windowPoint, 8, false);
    }
  }

  static final class LocalFrameSaveImageAtParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Point windowPoint;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameSaveImageAtParams(int version) {
      super(16, version);
    }

    public LocalFrameSaveImageAtParams() {
      this(0);
    }

    public static LocalFrameSaveImageAtParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameSaveImageAtParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameSaveImageAtParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameSaveImageAtParams result = new LocalFrameSaveImageAtParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.windowPoint = Point.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.windowPoint, 8, false);
    }
  }

  static final class LocalFrameReportBlinkFeatureUsageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int[] features;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameReportBlinkFeatureUsageParams(int version) {
      super(16, version);
    }

    public LocalFrameReportBlinkFeatureUsageParams() {
      this(0);
    }

    public static LocalFrameReportBlinkFeatureUsageParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameReportBlinkFeatureUsageParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameReportBlinkFeatureUsageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameReportBlinkFeatureUsageParams result =
            new LocalFrameReportBlinkFeatureUsageParams(elementsOrVersion);
        result.features = decoder0.readInts(8, 0, -1);
        int i1 = 0;
        while (true) {
          int[] iArr = result.features;
          if (i1 < iArr.length) {
            WebFeature.validate(iArr[i1]);
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
      encoder0.encode(this.features, 8, 0, -1);
    }
  }

  static final class LocalFrameRenderFallbackContentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameRenderFallbackContentParams(int version) {
      super(8, version);
    }

    public LocalFrameRenderFallbackContentParams() {
      this(0);
    }

    public static LocalFrameRenderFallbackContentParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameRenderFallbackContentParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameRenderFallbackContentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameRenderFallbackContentParams result =
            new LocalFrameRenderFallbackContentParams(elementsOrVersion);
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

  static final class LocalFrameBeforeUnloadParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isReload;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameBeforeUnloadParams(int version) {
      super(16, version);
    }

    public LocalFrameBeforeUnloadParams() {
      this(0);
    }

    public static LocalFrameBeforeUnloadParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameBeforeUnloadParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameBeforeUnloadParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameBeforeUnloadParams result = new LocalFrameBeforeUnloadParams(elementsOrVersion);
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

  static final class LocalFrameBeforeUnloadResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public TimeTicks beforeUnloadEndTime;
    public TimeTicks beforeUnloadStartTime;
    public boolean proceed;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameBeforeUnloadResponseParams(int version) {
      super(32, version);
    }

    public LocalFrameBeforeUnloadResponseParams() {
      this(0);
    }

    public static LocalFrameBeforeUnloadResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameBeforeUnloadResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameBeforeUnloadResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameBeforeUnloadResponseParams result =
            new LocalFrameBeforeUnloadResponseParams(elementsOrVersion);
        result.proceed = decoder0.readBoolean(8, 0);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.beforeUnloadStartTime = TimeTicks.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(24, false);
        result.beforeUnloadEndTime = TimeTicks.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.proceed, 8, 0);
      encoder0.encode((Struct) this.beforeUnloadStartTime, 16, false);
      encoder0.encode((Struct) this.beforeUnloadEndTime, 24, false);
    }
  }

  static class LocalFrameBeforeUnloadResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final LocalFrame.BeforeUnload_Response mCallback;

    LocalFrameBeforeUnloadResponseParamsForwardToCallback(
        LocalFrame.BeforeUnload_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(17, 2)) {
          return false;
        }
        LocalFrameBeforeUnloadResponseParams response =
            LocalFrameBeforeUnloadResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(
            response.proceed, response.beforeUnloadStartTime, response.beforeUnloadEndTime);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameBeforeUnloadResponseParamsProxyToResponder
      implements LocalFrame.BeforeUnload_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameBeforeUnloadResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(
        boolean proceed, TimeTicks beforeUnloadStartTime, TimeTicks beforeUnloadEndTime) {
      LocalFrameBeforeUnloadResponseParams _response = new LocalFrameBeforeUnloadResponseParams();
      _response.proceed = proceed;
      _response.beforeUnloadStartTime = beforeUnloadStartTime;
      _response.beforeUnloadEndTime = beforeUnloadEndTime;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(17, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameMediaPlayerActionAtParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public MediaPlayerAction action;
    public Point location;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameMediaPlayerActionAtParams(int version) {
      super(24, version);
    }

    public LocalFrameMediaPlayerActionAtParams() {
      this(0);
    }

    public static LocalFrameMediaPlayerActionAtParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameMediaPlayerActionAtParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameMediaPlayerActionAtParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameMediaPlayerActionAtParams result =
            new LocalFrameMediaPlayerActionAtParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.location = Point.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.action = MediaPlayerAction.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.location, 8, false);
      encoder0.encode((Struct) this.action, 16, false);
    }
  }

  static final class LocalFrameRequestVideoFrameAtParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Point location;
    public int maxArea;
    public Size maxSize;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameRequestVideoFrameAtParams(int version) {
      super(32, version);
    }

    public LocalFrameRequestVideoFrameAtParams() {
      this(0);
    }

    public static LocalFrameRequestVideoFrameAtParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameRequestVideoFrameAtParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameRequestVideoFrameAtParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameRequestVideoFrameAtParams result =
            new LocalFrameRequestVideoFrameAtParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.location = Point.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.maxSize = Size.decode(decoder12);
        result.maxArea = decoder0.readInt(24);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.location, 8, false);
      encoder0.encode((Struct) this.maxSize, 16, false);
      encoder0.encode(this.maxArea, 24);
    }
  }

  static final class LocalFrameRequestVideoFrameAtResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ImageSkia image;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameRequestVideoFrameAtResponseParams(int version) {
      super(16, version);
    }

    public LocalFrameRequestVideoFrameAtResponseParams() {
      this(0);
    }

    public static LocalFrameRequestVideoFrameAtResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameRequestVideoFrameAtResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameRequestVideoFrameAtResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameRequestVideoFrameAtResponseParams result =
            new LocalFrameRequestVideoFrameAtResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.image = ImageSkia.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.image, 8, false);
    }
  }

  static class LocalFrameRequestVideoFrameAtResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrame.RequestVideoFrameAt_Response mCallback;

    LocalFrameRequestVideoFrameAtResponseParamsForwardToCallback(
        LocalFrame.RequestVideoFrameAt_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(19, 2)) {
          return false;
        }
        LocalFrameRequestVideoFrameAtResponseParams response =
            LocalFrameRequestVideoFrameAtResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.image);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameRequestVideoFrameAtResponseParamsProxyToResponder
      implements LocalFrame.RequestVideoFrameAt_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameRequestVideoFrameAtResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ImageSkia image) {
      LocalFrameRequestVideoFrameAtResponseParams _response =
          new LocalFrameRequestVideoFrameAtResponseParams();
      _response.image = image;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(19, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFramePluginActionAtParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int action;
    public Point location;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFramePluginActionAtParams(int version) {
      super(24, version);
    }

    public LocalFramePluginActionAtParams() {
      this(0);
    }

    public static LocalFramePluginActionAtParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFramePluginActionAtParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFramePluginActionAtParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFramePluginActionAtParams result =
            new LocalFramePluginActionAtParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.location = Point.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.action = readInt;
        PluginActionType.validate(readInt);
        result.action = PluginActionType.toKnownValue(result.action);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.location, 8, false);
      encoder0.encode(this.action, 16);
    }
  }

  static final class LocalFrameAdvanceFocusInFrameParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int focusType;
    public RemoteFrameToken sourceFrameToken;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameAdvanceFocusInFrameParams(int version) {
      super(24, version);
    }

    public LocalFrameAdvanceFocusInFrameParams() {
      this(0);
    }

    public static LocalFrameAdvanceFocusInFrameParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameAdvanceFocusInFrameParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameAdvanceFocusInFrameParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameAdvanceFocusInFrameParams result =
            new LocalFrameAdvanceFocusInFrameParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.focusType = readInt;
        FocusType.validate(readInt);
        result.focusType = FocusType.toKnownValue(result.focusType);
        Decoder decoder1 = decoder0.readPointer(16, true);
        result.sourceFrameToken = RemoteFrameToken.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.focusType, 8);
      encoder0.encode((Struct) this.sourceFrameToken, 16, true);
    }
  }

  static final class LocalFrameAdvanceFocusForImeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int focusType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameAdvanceFocusForImeParams(int version) {
      super(16, version);
    }

    public LocalFrameAdvanceFocusForImeParams() {
      this(0);
    }

    public static LocalFrameAdvanceFocusForImeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameAdvanceFocusForImeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameAdvanceFocusForImeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameAdvanceFocusForImeParams result =
            new LocalFrameAdvanceFocusForImeParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.focusType = readInt;
        FocusType.validate(readInt);
        result.focusType = FocusType.toKnownValue(result.focusType);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.focusType, 8);
    }
  }

  static final class LocalFrameReportContentSecurityPolicyViolationParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public CspViolation violation;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameReportContentSecurityPolicyViolationParams(int version) {
      super(16, version);
    }

    public LocalFrameReportContentSecurityPolicyViolationParams() {
      this(0);
    }

    public static LocalFrameReportContentSecurityPolicyViolationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameReportContentSecurityPolicyViolationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameReportContentSecurityPolicyViolationParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameReportContentSecurityPolicyViolationParams result =
            new LocalFrameReportContentSecurityPolicyViolationParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.violation = CspViolation.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.violation, 8, false);
    }
  }

  static final class LocalFrameDidUpdateFramePolicyParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public FramePolicy framePolicy;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameDidUpdateFramePolicyParams(int version) {
      super(16, version);
    }

    public LocalFrameDidUpdateFramePolicyParams() {
      this(0);
    }

    public static LocalFrameDidUpdateFramePolicyParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameDidUpdateFramePolicyParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameDidUpdateFramePolicyParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameDidUpdateFramePolicyParams result =
            new LocalFrameDidUpdateFramePolicyParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.framePolicy = FramePolicy.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.framePolicy, 8, false);
    }
  }

  static final class LocalFramePostMessageEventParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public TransferableMessage message;
    public RemoteFrameToken sourceFrameToken;
    public String16 sourceOrigin;
    public String16 targetOrigin;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFramePostMessageEventParams(int version) {
      super(40, version);
    }

    public LocalFramePostMessageEventParams() {
      this(0);
    }

    public static LocalFramePostMessageEventParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFramePostMessageEventParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFramePostMessageEventParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFramePostMessageEventParams result =
            new LocalFramePostMessageEventParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.sourceFrameToken = RemoteFrameToken.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.sourceOrigin = String16.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.targetOrigin = String16.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(32, false);
        result.message = TransferableMessage.decode(decoder14);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.sourceFrameToken, 8, true);
      encoder0.encode((Struct) this.sourceOrigin, 16, false);
      encoder0.encode((Struct) this.targetOrigin, 24, false);
      encoder0.encode((Struct) this.message, 32, false);
    }
  }

  static final class LocalFrameJavaScriptMethodExecuteRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 40;
    private static final DataHeader[] VERSION_ARRAY;
    public ListValue arguments;
    public String16 methodName;
    public String16 objectName;
    public boolean wantsResult;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameJavaScriptMethodExecuteRequestParams(int version) {
      super(40, version);
    }

    public LocalFrameJavaScriptMethodExecuteRequestParams() {
      this(0);
    }

    public static LocalFrameJavaScriptMethodExecuteRequestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameJavaScriptMethodExecuteRequestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameJavaScriptMethodExecuteRequestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameJavaScriptMethodExecuteRequestParams result =
            new LocalFrameJavaScriptMethodExecuteRequestParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.objectName = String16.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.methodName = String16.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.arguments = ListValue.decode(decoder13);
        result.wantsResult = decoder0.readBoolean(32, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.objectName, 8, false);
      encoder0.encode((Struct) this.methodName, 16, false);
      encoder0.encode((Struct) this.arguments, 24, false);
      encoder0.encode(this.wantsResult, 32, 0);
    }
  }

  static final class LocalFrameJavaScriptMethodExecuteRequestResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Value result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameJavaScriptMethodExecuteRequestResponseParams(int version) {
      super(24, version);
    }

    public LocalFrameJavaScriptMethodExecuteRequestResponseParams() {
      this(0);
    }

    public static LocalFrameJavaScriptMethodExecuteRequestResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameJavaScriptMethodExecuteRequestResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameJavaScriptMethodExecuteRequestResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameJavaScriptMethodExecuteRequestResponseParams result =
            new LocalFrameJavaScriptMethodExecuteRequestResponseParams(elementsOrVersion);
        result.result = Value.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.result, 8, false);
    }
  }

  static class LocalFrameJavaScriptMethodExecuteRequestResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrame.JavaScriptMethodExecuteRequest_Response mCallback;

    LocalFrameJavaScriptMethodExecuteRequestResponseParamsForwardToCallback(
        LocalFrame.JavaScriptMethodExecuteRequest_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(26, 2)) {
          return false;
        }
        LocalFrameJavaScriptMethodExecuteRequestResponseParams response =
            LocalFrameJavaScriptMethodExecuteRequestResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameJavaScriptMethodExecuteRequestResponseParamsProxyToResponder
      implements LocalFrame.JavaScriptMethodExecuteRequest_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameJavaScriptMethodExecuteRequestResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Value result) {
      LocalFrameJavaScriptMethodExecuteRequestResponseParams _response =
          new LocalFrameJavaScriptMethodExecuteRequestResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(26, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameJavaScriptExecuteRequestParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BigString16 javascript;
    public boolean wantsResult;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameJavaScriptExecuteRequestParams(int version) {
      super(24, version);
    }

    public LocalFrameJavaScriptExecuteRequestParams() {
      this(0);
    }

    public static LocalFrameJavaScriptExecuteRequestParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameJavaScriptExecuteRequestParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameJavaScriptExecuteRequestParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameJavaScriptExecuteRequestParams result =
            new LocalFrameJavaScriptExecuteRequestParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.javascript = BigString16.decode(decoder1);
        result.wantsResult = decoder0.readBoolean(16, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.javascript, 8, false);
      encoder0.encode(this.wantsResult, 16, 0);
    }
  }

  static final class LocalFrameJavaScriptExecuteRequestResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Value result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameJavaScriptExecuteRequestResponseParams(int version) {
      super(24, version);
    }

    public LocalFrameJavaScriptExecuteRequestResponseParams() {
      this(0);
    }

    public static LocalFrameJavaScriptExecuteRequestResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameJavaScriptExecuteRequestResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameJavaScriptExecuteRequestResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameJavaScriptExecuteRequestResponseParams result =
            new LocalFrameJavaScriptExecuteRequestResponseParams(elementsOrVersion);
        result.result = Value.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.result, 8, false);
    }
  }

  static class LocalFrameJavaScriptExecuteRequestResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrame.JavaScriptExecuteRequest_Response mCallback;

    LocalFrameJavaScriptExecuteRequestResponseParamsForwardToCallback(
        LocalFrame.JavaScriptExecuteRequest_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(27, 2)) {
          return false;
        }
        LocalFrameJavaScriptExecuteRequestResponseParams response =
            LocalFrameJavaScriptExecuteRequestResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameJavaScriptExecuteRequestResponseParamsProxyToResponder
      implements LocalFrame.JavaScriptExecuteRequest_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameJavaScriptExecuteRequestResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Value result) {
      LocalFrameJavaScriptExecuteRequestResponseParams _response =
          new LocalFrameJavaScriptExecuteRequestResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(27, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameJavaScriptExecuteRequestForTestsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean hasUserGesture;
    public BigString16 javascript;
    public boolean resolvePromises;
    public int worldId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameJavaScriptExecuteRequestForTestsParams(int version) {
      super(24, version);
    }

    public LocalFrameJavaScriptExecuteRequestForTestsParams() {
      this(0);
    }

    public static LocalFrameJavaScriptExecuteRequestForTestsParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameJavaScriptExecuteRequestForTestsParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameJavaScriptExecuteRequestForTestsParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameJavaScriptExecuteRequestForTestsParams result =
            new LocalFrameJavaScriptExecuteRequestForTestsParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.javascript = BigString16.decode(decoder1);
        result.hasUserGesture = decoder0.readBoolean(16, 0);
        result.resolvePromises = decoder0.readBoolean(16, 1);
        result.worldId = decoder0.readInt(20);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.javascript, 8, false);
      encoder0.encode(this.hasUserGesture, 16, 0);
      encoder0.encode(this.resolvePromises, 16, 1);
      encoder0.encode(this.worldId, 20);
    }
  }

  static final class LocalFrameJavaScriptExecuteRequestForTestsResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Value result;
    public int resultType;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameJavaScriptExecuteRequestForTestsResponseParams(int version) {
      super(32, version);
    }

    public LocalFrameJavaScriptExecuteRequestForTestsResponseParams() {
      this(0);
    }

    public static LocalFrameJavaScriptExecuteRequestForTestsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameJavaScriptExecuteRequestForTestsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameJavaScriptExecuteRequestForTestsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameJavaScriptExecuteRequestForTestsResponseParams result =
            new LocalFrameJavaScriptExecuteRequestForTestsResponseParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.resultType = readInt;
        JavaScriptExecutionResultType.validate(readInt);
        result.resultType = JavaScriptExecutionResultType.toKnownValue(result.resultType);
        result.result = Value.decode(decoder0, 16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.resultType, 8);
      encoder0.encode((Union) this.result, 16, false);
    }
  }

  static class LocalFrameJavaScriptExecuteRequestForTestsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrame.JavaScriptExecuteRequestForTests_Response mCallback;

    LocalFrameJavaScriptExecuteRequestForTestsResponseParamsForwardToCallback(
        LocalFrame.JavaScriptExecuteRequestForTests_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(28, 2)) {
          return false;
        }
        LocalFrameJavaScriptExecuteRequestForTestsResponseParams response =
            LocalFrameJavaScriptExecuteRequestForTestsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.resultType, response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameJavaScriptExecuteRequestForTestsResponseParamsProxyToResponder
      implements LocalFrame.JavaScriptExecuteRequestForTests_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameJavaScriptExecuteRequestForTestsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(int resultType, Value result) {
      LocalFrameJavaScriptExecuteRequestForTestsResponseParams _response =
          new LocalFrameJavaScriptExecuteRequestForTestsResponseParams();
      _response.resultType = resultType;
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(28, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameJavaScriptExecuteRequestInIsolatedWorldParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BigString16 javascript;
    public boolean wantsResult;
    public int worldId;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameJavaScriptExecuteRequestInIsolatedWorldParams(int version) {
      super(24, version);
    }

    public LocalFrameJavaScriptExecuteRequestInIsolatedWorldParams() {
      this(0);
    }

    public static LocalFrameJavaScriptExecuteRequestInIsolatedWorldParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameJavaScriptExecuteRequestInIsolatedWorldParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameJavaScriptExecuteRequestInIsolatedWorldParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameJavaScriptExecuteRequestInIsolatedWorldParams result =
            new LocalFrameJavaScriptExecuteRequestInIsolatedWorldParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.javascript = BigString16.decode(decoder1);
        result.wantsResult = decoder0.readBoolean(16, 0);
        result.worldId = decoder0.readInt(20);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.javascript, 8, false);
      encoder0.encode(this.wantsResult, 16, 0);
      encoder0.encode(this.worldId, 20);
    }
  }

  static final class LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public Value result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParams(int version) {
      super(24, version);
    }

    public LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParams() {
      this(0);
    }

    public static LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParams result =
            new LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParams(elementsOrVersion);
        result.result = Value.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.result, 8, false);
    }
  }

  static class LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrame.JavaScriptExecuteRequestInIsolatedWorld_Response mCallback;

    LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParamsForwardToCallback(
        LocalFrame.JavaScriptExecuteRequestInIsolatedWorld_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(29, 2)) {
          return false;
        }
        LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParams response =
            LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParamsProxyToResponder
      implements LocalFrame.JavaScriptExecuteRequestInIsolatedWorld_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Value result) {
      LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParams _response =
          new LocalFrameJavaScriptExecuteRequestInIsolatedWorldResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(29, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameBindReportingObserverParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<ReportingObserver> receiver;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameBindReportingObserverParams(int version) {
      super(16, version);
    }

    public LocalFrameBindReportingObserverParams() {
      this(0);
    }

    public static LocalFrameBindReportingObserverParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameBindReportingObserverParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameBindReportingObserverParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameBindReportingObserverParams result =
            new LocalFrameBindReportingObserverParams(elementsOrVersion);
        result.receiver = decoder0.readInterfaceRequest(8, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.receiver, 8, false);
    }
  }

  static final class LocalFrameUpdateOpenerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public FrameToken openerFrameToken;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameUpdateOpenerParams(int version) {
      super(24, version);
    }

    public LocalFrameUpdateOpenerParams() {
      this(0);
    }

    public static LocalFrameUpdateOpenerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameUpdateOpenerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameUpdateOpenerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameUpdateOpenerParams result = new LocalFrameUpdateOpenerParams(elementsOrVersion);
        result.openerFrameToken = FrameToken.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.openerFrameToken, 8, true);
    }
  }

  static final class LocalFrameGetSavableResourceLinksParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameGetSavableResourceLinksParams(int version) {
      super(8, version);
    }

    public LocalFrameGetSavableResourceLinksParams() {
      this(0);
    }

    public static LocalFrameGetSavableResourceLinksParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameGetSavableResourceLinksParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameGetSavableResourceLinksParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameGetSavableResourceLinksParams result =
            new LocalFrameGetSavableResourceLinksParams(elementsOrVersion);
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

  static final class LocalFrameGetSavableResourceLinksResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public GetSavableResourceLinksReply reply;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameGetSavableResourceLinksResponseParams(int version) {
      super(16, version);
    }

    public LocalFrameGetSavableResourceLinksResponseParams() {
      this(0);
    }

    public static LocalFrameGetSavableResourceLinksResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameGetSavableResourceLinksResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameGetSavableResourceLinksResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameGetSavableResourceLinksResponseParams result =
            new LocalFrameGetSavableResourceLinksResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.reply = GetSavableResourceLinksReply.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.reply, 8, true);
    }
  }

  static class LocalFrameGetSavableResourceLinksResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrame.GetSavableResourceLinks_Response mCallback;

    LocalFrameGetSavableResourceLinksResponseParamsForwardToCallback(
        LocalFrame.GetSavableResourceLinks_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(32, 2)) {
          return false;
        }
        LocalFrameGetSavableResourceLinksResponseParams response =
            LocalFrameGetSavableResourceLinksResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.reply);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameGetSavableResourceLinksResponseParamsProxyToResponder
      implements LocalFrame.GetSavableResourceLinks_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameGetSavableResourceLinksResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(GetSavableResourceLinksReply reply) {
      LocalFrameGetSavableResourceLinksResponseParams _response =
          new LocalFrameGetSavableResourceLinksResponseParams();
      _response.reply = reply;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(32, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameMixedContentFoundParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 48;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean hadRedirect;
    public Url mainResourceUrl;
    public Url mixedContentUrl;
    public int requestContext;
    public SourceLocation sourceLocation;
    public Url urlBeforeRedirects;
    public boolean wasAllowed;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameMixedContentFoundParams(int version) {
      super(48, version);
    }

    public LocalFrameMixedContentFoundParams() {
      this(0);
    }

    public static LocalFrameMixedContentFoundParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameMixedContentFoundParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameMixedContentFoundParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameMixedContentFoundParams result =
            new LocalFrameMixedContentFoundParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.mainResourceUrl = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.mixedContentUrl = Url.decode(decoder12);
        int readInt = decoder0.readInt(24);
        result.requestContext = readInt;
        RequestContextType.validate(readInt);
        result.requestContext = RequestContextType.toKnownValue(result.requestContext);
        result.wasAllowed = decoder0.readBoolean(28, 0);
        result.hadRedirect = decoder0.readBoolean(28, 1);
        Decoder decoder13 = decoder0.readPointer(32, false);
        result.urlBeforeRedirects = Url.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(40, true);
        result.sourceLocation = SourceLocation.decode(decoder14);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.mainResourceUrl, 8, false);
      encoder0.encode((Struct) this.mixedContentUrl, 16, false);
      encoder0.encode(this.requestContext, 24);
      encoder0.encode(this.wasAllowed, 28, 0);
      encoder0.encode(this.hadRedirect, 28, 1);
      encoder0.encode((Struct) this.urlBeforeRedirects, 32, false);
      encoder0.encode((Struct) this.sourceLocation, 40, true);
    }
  }

  static final class LocalFrameBindDevToolsAgentParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public AssociatedInterfaceRequestNotSupported agent;
    public AssociatedInterfaceNotSupported agentHost;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameBindDevToolsAgentParams(int version) {
      super(24, version);
    }

    public LocalFrameBindDevToolsAgentParams() {
      this(0);
    }

    public static LocalFrameBindDevToolsAgentParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameBindDevToolsAgentParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameBindDevToolsAgentParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameBindDevToolsAgentParams result =
            new LocalFrameBindDevToolsAgentParams(elementsOrVersion);
        result.agentHost = decoder0.readAssociatedServiceInterfaceNotSupported(8, false);
        result.agent = decoder0.readAssociatedInterfaceRequestNotSupported(16, false);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.agentHost, 8, false);
      encoder0.encode(this.agent, 16, false);
    }
  }

  static final class LocalFrameExtractSmartClipDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect rect;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameExtractSmartClipDataParams(int version) {
      super(16, version);
    }

    public LocalFrameExtractSmartClipDataParams() {
      this(0);
    }

    public static LocalFrameExtractSmartClipDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameExtractSmartClipDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameExtractSmartClipDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameExtractSmartClipDataParams result =
            new LocalFrameExtractSmartClipDataParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.rect = Rect.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.rect, 8, false);
    }
  }

  static final class LocalFrameExtractSmartClipDataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public Rect clipRect;
    public String16 html;
    public String16 text;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameExtractSmartClipDataResponseParams(int version) {
      super(32, version);
    }

    public LocalFrameExtractSmartClipDataResponseParams() {
      this(0);
    }

    public static LocalFrameExtractSmartClipDataResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameExtractSmartClipDataResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameExtractSmartClipDataResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameExtractSmartClipDataResponseParams result =
            new LocalFrameExtractSmartClipDataResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.text = String16.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.html = String16.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(24, false);
        result.clipRect = Rect.decode(decoder13);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.text, 8, false);
      encoder0.encode((Struct) this.html, 16, false);
      encoder0.encode((Struct) this.clipRect, 24, false);
    }
  }

  static class LocalFrameExtractSmartClipDataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrame.ExtractSmartClipData_Response mCallback;

    LocalFrameExtractSmartClipDataResponseParamsForwardToCallback(
        LocalFrame.ExtractSmartClipData_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(35, 2)) {
          return false;
        }
        LocalFrameExtractSmartClipDataResponseParams response =
            LocalFrameExtractSmartClipDataResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.text, response.html, response.clipRect);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameExtractSmartClipDataResponseParamsProxyToResponder
      implements LocalFrame.ExtractSmartClipData_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameExtractSmartClipDataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String16 text, String16 html, Rect clipRect) {
      LocalFrameExtractSmartClipDataResponseParams _response =
          new LocalFrameExtractSmartClipDataResponseParams();
      _response.text = text;
      _response.html = html;
      _response.clipRect = clipRect;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(35, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameHandleRendererDebugUrlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameHandleRendererDebugUrlParams(int version) {
      super(16, version);
    }

    public LocalFrameHandleRendererDebugUrlParams() {
      this(0);
    }

    public static LocalFrameHandleRendererDebugUrlParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameHandleRendererDebugUrlParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameHandleRendererDebugUrlParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameHandleRendererDebugUrlParams result =
            new LocalFrameHandleRendererDebugUrlParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
    }
  }

  static final class LocalFrameGetCanonicalUrlForSharingParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameGetCanonicalUrlForSharingParams(int version) {
      super(8, version);
    }

    public LocalFrameGetCanonicalUrlForSharingParams() {
      this(0);
    }

    public static LocalFrameGetCanonicalUrlForSharingParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameGetCanonicalUrlForSharingParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameGetCanonicalUrlForSharingParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameGetCanonicalUrlForSharingParams result =
            new LocalFrameGetCanonicalUrlForSharingParams(elementsOrVersion);
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

  static final class LocalFrameGetCanonicalUrlForSharingResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Url canonicalUrl;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameGetCanonicalUrlForSharingResponseParams(int version) {
      super(16, version);
    }

    public LocalFrameGetCanonicalUrlForSharingResponseParams() {
      this(0);
    }

    public static LocalFrameGetCanonicalUrlForSharingResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameGetCanonicalUrlForSharingResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameGetCanonicalUrlForSharingResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameGetCanonicalUrlForSharingResponseParams result =
            new LocalFrameGetCanonicalUrlForSharingResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        result.canonicalUrl = Url.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.canonicalUrl, 8, true);
    }
  }

  static class LocalFrameGetCanonicalUrlForSharingResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrame.GetCanonicalUrlForSharing_Response mCallback;

    LocalFrameGetCanonicalUrlForSharingResponseParamsForwardToCallback(
        LocalFrame.GetCanonicalUrlForSharing_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(37, 2)) {
          return false;
        }
        LocalFrameGetCanonicalUrlForSharingResponseParams response =
            LocalFrameGetCanonicalUrlForSharingResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.canonicalUrl);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameGetCanonicalUrlForSharingResponseParamsProxyToResponder
      implements LocalFrame.GetCanonicalUrlForSharing_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameGetCanonicalUrlForSharingResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(Url canonicalUrl) {
      LocalFrameGetCanonicalUrlForSharingResponseParams _response =
          new LocalFrameGetCanonicalUrlForSharingResponseParams();
      _response.canonicalUrl = canonicalUrl;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(37, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameGetOpenGraphMetadataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameGetOpenGraphMetadataParams(int version) {
      super(8, version);
    }

    public LocalFrameGetOpenGraphMetadataParams() {
      this(0);
    }

    public static LocalFrameGetOpenGraphMetadataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameGetOpenGraphMetadataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameGetOpenGraphMetadataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameGetOpenGraphMetadataParams result =
            new LocalFrameGetOpenGraphMetadataParams(elementsOrVersion);
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

  static final class LocalFrameGetOpenGraphMetadataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public OpenGraphMetadata metadata;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameGetOpenGraphMetadataResponseParams(int version) {
      super(16, version);
    }

    public LocalFrameGetOpenGraphMetadataResponseParams() {
      this(0);
    }

    public static LocalFrameGetOpenGraphMetadataResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameGetOpenGraphMetadataResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameGetOpenGraphMetadataResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameGetOpenGraphMetadataResponseParams result =
            new LocalFrameGetOpenGraphMetadataResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.metadata = OpenGraphMetadata.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.metadata, 8, false);
    }
  }

  static class LocalFrameGetOpenGraphMetadataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrame.GetOpenGraphMetadata_Response mCallback;

    LocalFrameGetOpenGraphMetadataResponseParamsForwardToCallback(
        LocalFrame.GetOpenGraphMetadata_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(38, 2)) {
          return false;
        }
        LocalFrameGetOpenGraphMetadataResponseParams response =
            LocalFrameGetOpenGraphMetadataResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.metadata);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameGetOpenGraphMetadataResponseParamsProxyToResponder
      implements LocalFrame.GetOpenGraphMetadata_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameGetOpenGraphMetadataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(OpenGraphMetadata metadata) {
      LocalFrameGetOpenGraphMetadataResponseParams _response =
          new LocalFrameGetOpenGraphMetadataResponseParams();
      _response.metadata = metadata;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(38, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameSetNavigationApiHistoryEntriesForRestoreParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public NavigationApiHistoryEntryArrays entryArrays;
    public int restoreReason;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameSetNavigationApiHistoryEntriesForRestoreParams(int version) {
      super(24, version);
    }

    public LocalFrameSetNavigationApiHistoryEntriesForRestoreParams() {
      this(0);
    }

    public static LocalFrameSetNavigationApiHistoryEntriesForRestoreParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameSetNavigationApiHistoryEntriesForRestoreParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameSetNavigationApiHistoryEntriesForRestoreParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameSetNavigationApiHistoryEntriesForRestoreParams result =
            new LocalFrameSetNavigationApiHistoryEntriesForRestoreParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.entryArrays = NavigationApiHistoryEntryArrays.decode(decoder1);
        int readInt = decoder0.readInt(16);
        result.restoreReason = readInt;
        NavigationApiEntryRestoreReason.validate(readInt);
        result.restoreReason = NavigationApiEntryRestoreReason.toKnownValue(result.restoreReason);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.entryArrays, 8, false);
      encoder0.encode(this.restoreReason, 16);
    }
  }

  static final class LocalFrameNotifyNavigationApiOfDisposedEntriesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String[] keys;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameNotifyNavigationApiOfDisposedEntriesParams(int version) {
      super(16, version);
    }

    public LocalFrameNotifyNavigationApiOfDisposedEntriesParams() {
      this(0);
    }

    public static LocalFrameNotifyNavigationApiOfDisposedEntriesParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameNotifyNavigationApiOfDisposedEntriesParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameNotifyNavigationApiOfDisposedEntriesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameNotifyNavigationApiOfDisposedEntriesParams result =
            new LocalFrameNotifyNavigationApiOfDisposedEntriesParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.keys = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.keys[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String[] strArr = this.keys;
      if (strArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.keys;
        if (i0 < strArr2.length) {
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class LocalFrameTraverseCancelledParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String navigationApiKey;
    public int reason;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameTraverseCancelledParams(int version) {
      super(24, version);
    }

    public LocalFrameTraverseCancelledParams() {
      this(0);
    }

    public static LocalFrameTraverseCancelledParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameTraverseCancelledParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameTraverseCancelledParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameTraverseCancelledParams result =
            new LocalFrameTraverseCancelledParams(elementsOrVersion);
        result.navigationApiKey = decoder0.readString(8, false);
        int readInt = decoder0.readInt(16);
        result.reason = readInt;
        TraverseCancelledReason.validate(readInt);
        result.reason = TraverseCancelledReason.toKnownValue(result.reason);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.navigationApiKey, 8, false);
      encoder0.encode(this.reason, 16);
    }
  }

  static final class LocalFrameDispatchNavigateEventForCrossDocumentTraversalParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean isBrowserInitiated;
    public ByteString pageState;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameDispatchNavigateEventForCrossDocumentTraversalParams(int version) {
      super(32, version);
    }

    public LocalFrameDispatchNavigateEventForCrossDocumentTraversalParams() {
      this(0);
    }

    public static LocalFrameDispatchNavigateEventForCrossDocumentTraversalParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameDispatchNavigateEventForCrossDocumentTraversalParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameDispatchNavigateEventForCrossDocumentTraversalParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameDispatchNavigateEventForCrossDocumentTraversalParams result =
            new LocalFrameDispatchNavigateEventForCrossDocumentTraversalParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.url = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.pageState = ByteString.decode(decoder12);
        result.isBrowserInitiated = decoder0.readBoolean(24, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.url, 8, false);
      encoder0.encode((Struct) this.pageState, 16, false);
      encoder0.encode(this.isBrowserInitiated, 24, 0);
    }
  }

  static final class LocalFrameSnapshotDocumentForViewTransitionParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public PageConcealEventParams pageConcealEventParams;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameSnapshotDocumentForViewTransitionParams(int version) {
      super(16, version);
    }

    public LocalFrameSnapshotDocumentForViewTransitionParams() {
      this(0);
    }

    public static LocalFrameSnapshotDocumentForViewTransitionParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameSnapshotDocumentForViewTransitionParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameSnapshotDocumentForViewTransitionParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameSnapshotDocumentForViewTransitionParams result =
            new LocalFrameSnapshotDocumentForViewTransitionParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.pageConcealEventParams = PageConcealEventParams.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.pageConcealEventParams, 8, false);
    }
  }

  static final class LocalFrameSnapshotDocumentForViewTransitionResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ViewTransitionState viewTransitionState;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameSnapshotDocumentForViewTransitionResponseParams(int version) {
      super(16, version);
    }

    public LocalFrameSnapshotDocumentForViewTransitionResponseParams() {
      this(0);
    }

    public static LocalFrameSnapshotDocumentForViewTransitionResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameSnapshotDocumentForViewTransitionResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameSnapshotDocumentForViewTransitionResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameSnapshotDocumentForViewTransitionResponseParams result =
            new LocalFrameSnapshotDocumentForViewTransitionResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.viewTransitionState = ViewTransitionState.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.viewTransitionState, 8, false);
    }
  }

  static class LocalFrameSnapshotDocumentForViewTransitionResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final LocalFrame.SnapshotDocumentForViewTransition_Response mCallback;

    LocalFrameSnapshotDocumentForViewTransitionResponseParamsForwardToCallback(
        LocalFrame.SnapshotDocumentForViewTransition_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(43, 2)) {
          return false;
        }
        LocalFrameSnapshotDocumentForViewTransitionResponseParams response =
            LocalFrameSnapshotDocumentForViewTransitionResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.viewTransitionState);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class LocalFrameSnapshotDocumentForViewTransitionResponseParamsProxyToResponder
      implements LocalFrame.SnapshotDocumentForViewTransition_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    LocalFrameSnapshotDocumentForViewTransitionResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ViewTransitionState viewTransitionState) {
      LocalFrameSnapshotDocumentForViewTransitionResponseParams _response =
          new LocalFrameSnapshotDocumentForViewTransitionResponseParams();
      _response.viewTransitionState = viewTransitionState;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(43, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class LocalFrameAddResourceTimingEntryForFailedSubframeNavigationParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 120;
    private static final DataHeader[] VERSION_ARRAY;
    public String alpnNegotiatedProtocol;
    public UrlLoaderCompletionStatus completionStatus;
    public int connectionInfo;
    public Url initialUrl;
    public boolean isSecureTransport;
    public boolean isValidated;
    public LoadTimingInfo loadTimingInfo;
    public String mimeType;
    public String normalizedServerTiming;
    public TimeTicks redirectTime;
    public TimeTicks requestStart;
    public int responseCode;
    public TimeTicks responseStart;
    public TimeTicks startTime;
    public FrameToken subframeToken;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(120, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameAddResourceTimingEntryForFailedSubframeNavigationParams(int version) {
      super(120, version);
    }

    public LocalFrameAddResourceTimingEntryForFailedSubframeNavigationParams() {
      this(0);
    }

    public static LocalFrameAddResourceTimingEntryForFailedSubframeNavigationParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameAddResourceTimingEntryForFailedSubframeNavigationParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameAddResourceTimingEntryForFailedSubframeNavigationParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameAddResourceTimingEntryForFailedSubframeNavigationParams result =
            new LocalFrameAddResourceTimingEntryForFailedSubframeNavigationParams(
                elementsOrVersion);
        result.subframeToken = FrameToken.decode(decoder0, 8);
        Decoder decoder1 = decoder0.readPointer(24, false);
        result.initialUrl = Url.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(32, false);
        result.startTime = TimeTicks.decode(decoder12);
        Decoder decoder13 = decoder0.readPointer(40, false);
        result.redirectTime = TimeTicks.decode(decoder13);
        Decoder decoder14 = decoder0.readPointer(48, false);
        result.requestStart = TimeTicks.decode(decoder14);
        Decoder decoder15 = decoder0.readPointer(56, false);
        result.responseStart = TimeTicks.decode(decoder15);
        result.responseCode = decoder0.readInt(64);
        int readInt = decoder0.readInt(68);
        result.connectionInfo = readInt;
        ConnectionInfo.validate(readInt);
        result.connectionInfo = ConnectionInfo.toKnownValue(result.connectionInfo);
        result.mimeType = decoder0.readString(72, false);
        Decoder decoder16 = decoder0.readPointer(80, false);
        result.loadTimingInfo = LoadTimingInfo.decode(decoder16);
        result.alpnNegotiatedProtocol = decoder0.readString(88, false);
        result.isSecureTransport = decoder0.readBoolean(96, 0);
        result.isValidated = decoder0.readBoolean(96, 1);
        result.normalizedServerTiming = decoder0.readString(104, false);
        Decoder decoder17 = decoder0.readPointer(112, false);
        result.completionStatus = UrlLoaderCompletionStatus.decode(decoder17);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.subframeToken, 8, false);
      encoder0.encode((Struct) this.initialUrl, 24, false);
      encoder0.encode((Struct) this.startTime, 32, false);
      encoder0.encode((Struct) this.redirectTime, 40, false);
      encoder0.encode((Struct) this.requestStart, 48, false);
      encoder0.encode((Struct) this.responseStart, 56, false);
      encoder0.encode(this.responseCode, 64);
      encoder0.encode(this.connectionInfo, 68);
      encoder0.encode(this.mimeType, 72, false);
      encoder0.encode((Struct) this.loadTimingInfo, 80, false);
      encoder0.encode(this.alpnNegotiatedProtocol, 88, false);
      encoder0.encode(this.isSecureTransport, 96, 0);
      encoder0.encode(this.isValidated, 96, 1);
      encoder0.encode(this.normalizedServerTiming, 104, false);
      encoder0.encode((Struct) this.completionStatus, 112, false);
    }
  }

  static final class LocalFrameRequestFullscreenDocumentElementParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private LocalFrameRequestFullscreenDocumentElementParams(int version) {
      super(8, version);
    }

    public LocalFrameRequestFullscreenDocumentElementParams() {
      this(0);
    }

    public static LocalFrameRequestFullscreenDocumentElementParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static LocalFrameRequestFullscreenDocumentElementParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static LocalFrameRequestFullscreenDocumentElementParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        LocalFrameRequestFullscreenDocumentElementParams result =
            new LocalFrameRequestFullscreenDocumentElementParams(elementsOrVersion);
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
}
