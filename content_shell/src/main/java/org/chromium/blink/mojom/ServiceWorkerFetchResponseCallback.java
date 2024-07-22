package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.network.mojom.DataElementChunkedDataPipe;

public interface ServiceWorkerFetchResponseCallback extends Interface {
  public static final Interface.Manager<ServiceWorkerFetchResponseCallback, Proxy> MANAGER =
      ServiceWorkerFetchResponseCallback_Internal.MANAGER;

  public interface Proxy extends ServiceWorkerFetchResponseCallback, Interface.Proxy {}

  void onFallback(
      DataElementChunkedDataPipe dataElementChunkedDataPipe,
      ServiceWorkerFetchEventTiming serviceWorkerFetchEventTiming);

  void onResponse(
      FetchApiResponse fetchApiResponse,
      ServiceWorkerFetchEventTiming serviceWorkerFetchEventTiming);

  void onResponseStream(
      FetchApiResponse fetchApiResponse,
      ServiceWorkerStreamHandle serviceWorkerStreamHandle,
      ServiceWorkerFetchEventTiming serviceWorkerFetchEventTiming);
}
