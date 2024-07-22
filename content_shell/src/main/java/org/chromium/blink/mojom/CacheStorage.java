package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.String16;

public interface CacheStorage extends Interface {
  public static final Interface.Manager<CacheStorage, Proxy> MANAGER =
      CacheStorage_Internal.MANAGER;

  public interface Delete_Response {
    void call(int i);
  }

  public interface Has_Response {
    void call(int i);
  }

  public interface Keys_Response {
    void call(String16[] string16Arr);
  }

  public interface Match_Response {
    void call(MatchResult matchResult);
  }

  public interface Open_Response {
    void call(OpenResult openResult);
  }

  public interface Proxy extends CacheStorage, Interface.Proxy {}

  void delete(String16 string16, long j, Delete_Response delete_Response);

  void has(String16 string16, long j, Has_Response has_Response);

  void keys(long j, Keys_Response keys_Response);

  void match(
      FetchApiRequest fetchApiRequest,
      MultiCacheQueryOptions multiCacheQueryOptions,
      boolean z,
      boolean z2,
      long j,
      Match_Response match_Response);

  void open(String16 string16, long j, Open_Response open_Response);
}
