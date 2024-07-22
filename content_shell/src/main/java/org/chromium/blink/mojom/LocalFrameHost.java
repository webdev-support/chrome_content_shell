package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.Range;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.RectF;
import org.chromium.gfx.mojom.Size;
import org.chromium.gfx.mojom.Vector2d;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.BigString16;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.network.mojom.AttributionReportingRuntimeFeatures;
import org.chromium.skia.mojom.BitmapN32;
import org.chromium.skia.mojom.SkColor;
import org.chromium.skia.mojom.SkColor4f;
import org.chromium.url.mojom.Url;

public interface LocalFrameHost extends Interface {
  public static final Interface.Manager<LocalFrameHost, Proxy> MANAGER =
      LocalFrameHost_Internal.MANAGER;

  public interface DisableUntrustedNetworkInFencedFrame_Response {
    void call();
  }

  public interface EnterFullscreen_Response {
    void call(boolean z);
  }

  public interface Proxy extends LocalFrameHost, Interface.Proxy {}

  public interface RunBeforeUnloadConfirm_Response {
    void call(boolean z);
  }

  public interface RunModalAlertDialog_Response {
    void call();
  }

  public interface RunModalConfirmDialog_Response {
    void call(boolean z);
  }

  public interface RunModalPromptDialog_Response {
    void call(boolean z, String16 string16);
  }

  void bubbleLogicalScrollInParentFrame(int i, int i2);

  void capturePaintPreviewOfSubframe(Rect rect, UnguessableToken unguessableToken);

  void createFencedFrame(
      AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported,
      RemoteFrameInterfacesFromRenderer remoteFrameInterfacesFromRenderer,
      RemoteFrameToken remoteFrameToken,
      UnguessableToken unguessableToken);

  void createNewPopupWidget(
      AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported,
      AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported2,
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported);

  void detach();

  void didAddMessageToConsole(
      int i, BigString16 bigString16, int i2, String16 string16, BigString16 bigString162);

  void didBlockNavigation(Url url, Url url2, int i);

  void didCallFocus();

  void didChangeBackgroundColor(SkColor4f skColor4f, boolean z);

  void didChangeFrameOwnerProperties(
      FrameToken frameToken, FrameOwnerProperties frameOwnerProperties);

  void didChangeFramePolicy(FrameToken frameToken, FramePolicy framePolicy);

  void didChangeIframeAttributes(FrameToken frameToken, IframeAttributes iframeAttributes);

  void didChangeLoadProgress(double d);

  void didChangeOpener(LocalFrameToken localFrameToken);

  void didChangeSrcDoc(FrameToken frameToken, String str);

  void didChangeThemeColor(SkColor skColor);

  void didConsumeHistoryUserActivation();

  void didContainInsecureFormAction();

  void didDispatchDomContentLoadedEvent();

  void didDisplayInsecureContent();

  void didFailLoadWithError(Url url, int i);

  void didFinishLoad(Url url);

  void didFocusFrame();

  void didInferColorScheme(int i);

  void didLoadResourceFromMemoryCache(Url url, String str, String str2, int i, boolean z);

  void disableUntrustedNetworkInFencedFrame(
      DisableUntrustedNetworkInFencedFrame_Response disableUntrustedNetworkInFencedFrame_Response);

  void dispatchLoad();

  void documentOnLoadCompleted();

  void downloadUrl(DownloadUrlParams downloadUrlParams);

  void enforceInsecureNavigationsSet(int[] iArr);

  void enforceInsecureRequestPolicy(int i);

  void enterFullscreen(
      FullscreenOptions fullscreenOptions, EnterFullscreen_Response enterFullscreen_Response);

  void exitFullscreen();

  void focusedElementChanged(boolean z, boolean z2, Rect rect, int i);

  void forwardResourceTimingToParent(ResourceTimingInfo resourceTimingInfo);

  void frameSizeChanged(Size size);

  void fullscreenStateChanged(boolean z, FullscreenOptions fullscreenOptions);

  void getKeepAliveHandleFactory(InterfaceRequest<KeepAliveHandleFactory> interfaceRequest);

  void goToEntryAtOffset(int i, boolean z, TaskAttributionId taskAttributionId);

  void hadStickyUserActivationBeforeNavigationChanged(boolean z);

  void handleAccessibilityFindInPageResult(FindInPageResultAxParams findInPageResultAxParams);

  void handleAccessibilityFindInPageTermination();

  void mainDocumentElementAvailable(boolean z);

  void navigateEventHandlerPresenceChanged(boolean z);

  void navigateToNavigationApiKey(String str, boolean z, TaskAttributionId taskAttributionId);

  void onViewTransitionOptInChanged(int i);

  void receivedDelegatedCapability(int i);

  void registerProtocolHandler(String str, Url url, boolean z);

  void runBeforeUnloadConfirm(
      boolean z, RunBeforeUnloadConfirm_Response runBeforeUnloadConfirm_Response);

  void runModalAlertDialog(
      String16 string16, boolean z, RunModalAlertDialog_Response runModalAlertDialog_Response);

  void runModalConfirmDialog(
      String16 string16, boolean z, RunModalConfirmDialog_Response runModalConfirmDialog_Response);

  void runModalPromptDialog(
      String16 string16,
      String16 string162,
      boolean z,
      RunModalPromptDialog_Response runModalPromptDialog_Response);

  void scrollRectToVisibleInParentFrame(RectF rectF, ScrollIntoViewParams scrollIntoViewParams);

  void sendFencedFrameReportingBeacon(String str, String str2, int[] iArr);

  void sendFencedFrameReportingBeaconToCustomUrl(Url url);

  void sendLegacyTechEvent(String str, LegacyTechEventCodeLocation legacyTechEventCodeLocation);

  void sendPrivateAggregationRequestsForFencedFrameEvent(String str);

  void setAttributionReportingRuntimeFeatures(
      AttributionReportingRuntimeFeatures attributionReportingRuntimeFeatures);

  void setCloseListener(CloseListener closeListener);

  void setFencedFrameAutomaticBeaconReportEventData(
      int i, String str, int[] iArr, boolean z, boolean z2);

  void setNeedsOcclusionTracking(boolean z);

  void setVirtualKeyboardMode(int i);

  void showContextMenu(
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      UntrustworthyContextMenuParams untrustworthyContextMenuParams);

  void showPopupMenu(
      PopupMenuClient popupMenuClient,
      Rect rect,
      int i,
      double d,
      int i2,
      MenuItem[] menuItemArr,
      boolean z,
      boolean z2);

  void startDragging(
      DragData dragData,
      AllowedDragOperations allowedDragOperations,
      BitmapN32 bitmapN32,
      Vector2d vector2d,
      Rect rect,
      DragEventSourceInfo dragEventSourceInfo);

  void startLoadingForAsyncNavigationApiCommit();

  void suddenTerminationDisablerChanged(boolean z, int i);

  void textSelectionChanged(BigString16 bigString16, int i, Range range);

  void unregisterProtocolHandler(String str, Url url, boolean z);

  void updateAppTitle(String16 string16);

  void updateFaviconUrl(FaviconUrl[] faviconUrlArr);

  void updateTitle(String16 string16, int i);

  void updateUserActivationState(int i, int i2);

  void visibilityChanged(int i);
}
