package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.url.mojom.Url;

public interface CacheStorageCache extends Interface {
  public static final Interface.Manager<CacheStorageCache, Proxy> MANAGER =
      CacheStorageCache_Internal.MANAGER;

  public interface Batch_Response {
    void call(CacheStorageVerboseError cacheStorageVerboseError);
  }

  public interface GetAllMatchedEntries_Response {
    void call(GetAllMatchedEntriesResult getAllMatchedEntriesResult);
  }

  public interface Keys_Response {
    void call(CacheKeysResult cacheKeysResult);
  }

  public interface MatchAll_Response {
    void call(MatchAllResult matchAllResult);
  }

  public interface Match_Response {
    void call(MatchResult matchResult);
  }

  public interface Proxy extends CacheStorageCache, Interface.Proxy {}

  public interface WriteSideData_Response {
    void call(int i);
  }

  void batch(BatchOperation[] batchOperationArr, long j, Batch_Response batch_Response);

  void getAllMatchedEntries(
      FetchApiRequest fetchApiRequest,
      CacheQueryOptions cacheQueryOptions,
      long j,
      GetAllMatchedEntries_Response getAllMatchedEntries_Response);

  void keys(
      FetchApiRequest fetchApiRequest,
      CacheQueryOptions cacheQueryOptions,
      long j,
      Keys_Response keys_Response);

  void match(
      FetchApiRequest fetchApiRequest,
      CacheQueryOptions cacheQueryOptions,
      boolean z,
      boolean z2,
      long j,
      Match_Response match_Response);

  void matchAll(
      FetchApiRequest fetchApiRequest,
      CacheQueryOptions cacheQueryOptions,
      long j,
      MatchAll_Response matchAll_Response);

  void writeSideData(
      Url url,
      Time time,
      BigBuffer bigBuffer,
      long j,
      WriteSideData_Response writeSideData_Response);
}
