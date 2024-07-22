package org.chromium.blink.mojom;

import org.chromium.gfx.mojom.ImageSkia;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.BigString16;
import org.chromium.mojo_base.mojom.ByteString;
import org.chromium.mojo_base.mojom.ListValue;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.mojo_base.mojom.Value;
import org.chromium.network.mojom.CspViolation;
import org.chromium.network.mojom.LoadTimingInfo;
import org.chromium.network.mojom.SourceLocation;
import org.chromium.network.mojom.UrlLoaderCompletionStatus;
import org.chromium.url.mojom.Url;

public interface LocalFrame extends Interface {
  public static final Interface.Manager<LocalFrame, Proxy> MANAGER = LocalFrame_Internal.MANAGER;

  public interface BeforeUnload_Response {
    void call(boolean z, TimeTicks timeTicks, TimeTicks timeTicks2);
  }

  public interface ExtractSmartClipData_Response {
    void call(String16 string16, String16 string162, Rect rect);
  }

  public interface GetCanonicalUrlForSharing_Response {
    void call(Url url);
  }

  public interface GetOpenGraphMetadata_Response {
    void call(OpenGraphMetadata openGraphMetadata);
  }

  public interface GetSavableResourceLinks_Response {
    void call(GetSavableResourceLinksReply getSavableResourceLinksReply);
  }

  public interface GetTextSurroundingSelection_Response {
    void call(String16 string16, int i, int i2);
  }

  public interface JavaScriptExecuteRequestForTests_Response {
    void call(int i, Value value);
  }

  public interface JavaScriptExecuteRequestInIsolatedWorld_Response {
    void call(Value value);
  }

  public interface JavaScriptExecuteRequest_Response {
    void call(Value value);
  }

  public interface JavaScriptMethodExecuteRequest_Response {
    void call(Value value);
  }

  public interface Proxy extends LocalFrame, Interface.Proxy {}

  public interface RequestVideoFrameAt_Response {
    void call(ImageSkia imageSkia);
  }

  public interface SnapshotDocumentForViewTransition_Response {
    void call(ViewTransitionState viewTransitionState);
  }

  void addMessageToConsole(int i, String str, boolean z);

  void addResourceTimingEntryForFailedSubframeNavigation(
      FrameToken frameToken,
      Url url,
      TimeTicks timeTicks,
      TimeTicks timeTicks2,
      TimeTicks timeTicks3,
      TimeTicks timeTicks4,
      int i,
      String str,
      LoadTimingInfo loadTimingInfo,
      int i2,
      String str2,
      boolean z,
      boolean z2,
      String str3,
      UrlLoaderCompletionStatus urlLoaderCompletionStatus);

  void advanceFocusForIme(int i);

  void advanceFocusInFrame(int i, RemoteFrameToken remoteFrameToken);

  void beforeUnload(boolean z, BeforeUnload_Response beforeUnload_Response);

  void bindDevToolsAgent(
      AssociatedInterfaceNotSupported associatedInterfaceNotSupported,
      AssociatedInterfaceRequestNotSupported associatedInterfaceRequestNotSupported);

  void bindReportingObserver(InterfaceRequest<ReportingObserver> interfaceRequest);

  void checkCompleted();

  void clearFocusedElement();

  void collapse(boolean z);

  void copyImageAt(Point point);

  void didUpdateFramePolicy(FramePolicy framePolicy);

  void dispatchNavigateEventForCrossDocumentTraversal(Url url, ByteString byteString, boolean z);

  void enableViewSourceMode();

  void extractSmartClipData(Rect rect, ExtractSmartClipData_Response extractSmartClipData_Response);

  void focus();

  void getCanonicalUrlForSharing(
      GetCanonicalUrlForSharing_Response getCanonicalUrlForSharing_Response);

  void getOpenGraphMetadata(GetOpenGraphMetadata_Response getOpenGraphMetadata_Response);

  void getSavableResourceLinks(GetSavableResourceLinks_Response getSavableResourceLinks_Response);

  void getTextSurroundingSelection(
      int i, GetTextSurroundingSelection_Response getTextSurroundingSelection_Response);

  void handleRendererDebugUrl(Url url);

  void javaScriptExecuteRequest(
      BigString16 bigString16,
      boolean z,
      JavaScriptExecuteRequest_Response javaScriptExecuteRequest_Response);

  void javaScriptExecuteRequestForTests(
      BigString16 bigString16,
      boolean z,
      boolean z2,
      int i,
      JavaScriptExecuteRequestForTests_Response javaScriptExecuteRequestForTests_Response);

  void javaScriptExecuteRequestInIsolatedWorld(
      BigString16 bigString16,
      boolean z,
      int i,
      JavaScriptExecuteRequestInIsolatedWorld_Response
          javaScriptExecuteRequestInIsolatedWorld_Response);

  void javaScriptMethodExecuteRequest(
      String16 string16,
      String16 string162,
      ListValue listValue,
      boolean z,
      JavaScriptMethodExecuteRequest_Response javaScriptMethodExecuteRequest_Response);

  void mediaPlayerActionAt(Point point, MediaPlayerAction mediaPlayerAction);

  void mixedContentFound(
      Url url, Url url2, int i, boolean z, Url url3, boolean z2, SourceLocation sourceLocation);

  void notifyNavigationApiOfDisposedEntries(String[] strArr);

  void notifyUserActivation(int i);

  void notifyVirtualKeyboardOverlayRect(Rect rect);

  void pluginActionAt(Point point, int i);

  void postMessageEvent(
      RemoteFrameToken remoteFrameToken,
      String16 string16,
      String16 string162,
      TransferableMessage transferableMessage);

  void renderFallbackContent();

  void reportBlinkFeatureUsage(int[] iArr);

  void reportContentSecurityPolicyViolation(CspViolation cspViolation);

  void requestFullscreenDocumentElement();

  void requestVideoFrameAt(
      Point point, Size size, int i, RequestVideoFrameAt_Response requestVideoFrameAt_Response);

  void saveImageAt(Point point);

  void sendInterventionReport(String str, String str2);

  void setFrameOwnerProperties(FrameOwnerProperties frameOwnerProperties);

  void setNavigationApiHistoryEntriesForRestore(
      NavigationApiHistoryEntryArrays navigationApiHistoryEntryArrays, int i);

  void snapshotDocumentForViewTransition(
      PageConcealEventParams pageConcealEventParams,
      SnapshotDocumentForViewTransition_Response snapshotDocumentForViewTransition_Response);

  void stopLoading();

  void swapInImmediately();

  void traverseCancelled(String str, int i);

  void updateOpener(FrameToken frameToken);
}
