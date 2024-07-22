package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo_base.mojom.BigBuffer;

public interface UrlLoaderClient extends Interface {
  public static final Interface.Manager<UrlLoaderClient, Proxy> MANAGER =
      UrlLoaderClient_Internal.MANAGER;

  public interface OnUploadProgress_Response {
    void call();
  }

  public interface Proxy extends UrlLoaderClient, Interface.Proxy {}

  void onComplete(UrlLoaderCompletionStatus urlLoaderCompletionStatus);

  void onReceiveEarlyHints(EarlyHints earlyHints);

  void onReceiveRedirect(
      UrlRequestRedirectInfo urlRequestRedirectInfo, UrlResponseHead urlResponseHead);

  void onReceiveResponse(
      UrlResponseHead urlResponseHead, DataPipe.ConsumerHandle consumerHandle, BigBuffer bigBuffer);

  void onTransferSizeUpdated(int i);

  void onUploadProgress(long j, long j2, OnUploadProgress_Response onUploadProgress_Response);
}
