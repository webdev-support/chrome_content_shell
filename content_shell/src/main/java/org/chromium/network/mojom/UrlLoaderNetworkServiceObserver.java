package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public interface UrlLoaderNetworkServiceObserver extends Interface {
  public static final Interface.Manager<UrlLoaderNetworkServiceObserver, Proxy> MANAGER =
      UrlLoaderNetworkServiceObserver_Internal.MANAGER;

  public interface OnClearSiteData_Response {
    void call();
  }

  public interface OnLoadingStateUpdate_Response {
    void call();
  }

  public interface OnPrivateNetworkAccessPermissionRequired_Response {
    void call(boolean z);
  }

  public interface OnSharedStorageHeaderReceived_Response {
    void call();
  }

  public interface OnSslCertificateError_Response {
    void call(int i);
  }

  public interface Proxy extends UrlLoaderNetworkServiceObserver, Interface.Proxy {}

  void clone(InterfaceRequest<UrlLoaderNetworkServiceObserver> interfaceRequest);

  void onAuthRequired(
      UnguessableToken unguessableToken,
      int i,
      Url url,
      boolean z,
      AuthChallengeInfo authChallengeInfo,
      HttpResponseHeaders httpResponseHeaders,
      AuthChallengeResponder authChallengeResponder);

  void onCertificateRequested(
      UnguessableToken unguessableToken,
      SslCertRequestInfo sslCertRequestInfo,
      ClientCertificateResponder clientCertificateResponder);

  void onClearSiteData(
      Url url,
      String str,
      int i,
      CookiePartitionKey cookiePartitionKey,
      boolean z,
      OnClearSiteData_Response onClearSiteData_Response);

  void onDataUseUpdate(int i, long j, long j2);

  void onLoadingStateUpdate(
      LoadInfo loadInfo, OnLoadingStateUpdate_Response onLoadingStateUpdate_Response);

  void onPrivateNetworkAccessPermissionRequired(
      Url url,
      IpAddress ipAddress,
      String str,
      String str2,
      OnPrivateNetworkAccessPermissionRequired_Response
          onPrivateNetworkAccessPermissionRequired_Response);

  void onSharedStorageHeaderReceived(
      Origin origin,
      SharedStorageOperation[] sharedStorageOperationArr,
      OnSharedStorageHeaderReceived_Response onSharedStorageHeaderReceived_Response);

  void onSslCertificateError(
      Url url,
      int i,
      SslInfo sslInfo,
      boolean z,
      OnSslCertificateError_Response onSslCertificateError_Response);
}
