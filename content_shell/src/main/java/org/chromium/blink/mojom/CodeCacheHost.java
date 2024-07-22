package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

public interface CodeCacheHost extends Interface {
  public static final Interface.Manager<CodeCacheHost, Proxy> MANAGER =
      CodeCacheHost_Internal.MANAGER;

  public interface FetchCachedCode_Response {
    void call(Time time, BigBuffer bigBuffer);
  }

  public interface Proxy extends CodeCacheHost, Interface.Proxy {}

  void clearCodeCacheEntry(int i, Url url);

  void didGenerateCacheableMetadata(int i, Url url, Time time, BigBuffer bigBuffer);

  void didGenerateCacheableMetadataInCacheStorage(
      Url url, Time time, BigBuffer bigBuffer, String str);

  void fetchCachedCode(int i, Url url, FetchCachedCode_Response fetchCachedCode_Response);
}
