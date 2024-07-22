package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public interface DevToolsObserver extends Interface {
  public static final Interface.Manager<DevToolsObserver, Proxy> MANAGER =
      DevToolsObserver_Internal.MANAGER;

  public interface Proxy extends DevToolsObserver, Interface.Proxy {}

  void clone(InterfaceRequest<DevToolsObserver> interfaceRequest);

  void onCorbError(String str, Url url);

  void onCorsError(
      String str,
      Origin origin,
      ClientSecurityState clientSecurityState,
      Url url,
      CorsErrorStatus corsErrorStatus,
      boolean z);

  void onCorsPreflightRequest(
      UnguessableToken unguessableToken,
      HttpRequestHeaders httpRequestHeaders,
      UrlRequestDevToolsInfo urlRequestDevToolsInfo,
      Url url,
      String str);

  void onCorsPreflightRequestCompleted(
      UnguessableToken unguessableToken, UrlLoaderCompletionStatus urlLoaderCompletionStatus);

  void onCorsPreflightResponse(
      UnguessableToken unguessableToken,
      Url url,
      UrlResponseHeadDevToolsInfo urlResponseHeadDevToolsInfo);

  void onPrivateNetworkRequest(
      String str, Url url, boolean z, int i, ClientSecurityState clientSecurityState);

  void onRawRequest(
      String str,
      CookieWithAccessResult[] cookieWithAccessResultArr,
      HttpRawHeaderPair[] httpRawHeaderPairArr,
      TimeTicks timeTicks,
      ClientSecurityState clientSecurityState,
      OtherPartitionInfo otherPartitionInfo);

  void onRawResponse(
      String str,
      CookieAndLineWithAccessResult[] cookieAndLineWithAccessResultArr,
      HttpRawHeaderPair[] httpRawHeaderPairArr,
      String str2,
      int i,
      int i2,
      CookiePartitionKey cookiePartitionKey);

  void onSubresourceWebBundleInnerResponse(String str, Url url, String str2);

  void onSubresourceWebBundleInnerResponseError(String str, Url url, String str2, String str3);

  void onSubresourceWebBundleMetadata(String str, Url[] urlArr);

  void onSubresourceWebBundleMetadataError(String str, String str2);

  void onTrustTokenOperationDone(String str, TrustTokenOperationResult trustTokenOperationResult);
}
