package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.network.mojom.UrlLoaderCompletionStatus;
import org.chromium.network.mojom.UrlRequestRedirectInfo;
import org.chromium.network.mojom.UrlResponseHead;
import org.chromium.url.mojom.SchemeHostPort;

public interface ResourceLoadInfoNotifier extends Interface {
  public static final Interface.Manager<ResourceLoadInfoNotifier, Proxy> MANAGER =
      ResourceLoadInfoNotifier_Internal.MANAGER;

  public interface Proxy extends ResourceLoadInfoNotifier, Interface.Proxy {}

  void clone(InterfaceRequest<ResourceLoadInfoNotifier> interfaceRequest);

  void notifyResourceLoadCanceled(long j);

  void notifyResourceLoadCompleted(
      ResourceLoadInfo resourceLoadInfo, UrlLoaderCompletionStatus urlLoaderCompletionStatus);

  void notifyResourceRedirectReceived(
      UrlRequestRedirectInfo urlRequestRedirectInfo, UrlResponseHead urlResponseHead);

  void notifyResourceResponseReceived(
      long j, SchemeHostPort schemeHostPort, UrlResponseHead urlResponseHead, int i, boolean z);

  void notifyResourceTransferSizeUpdated(long j, int i);

  void notifyUpdateUserGestureCarryoverInfo();
}
