package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;

public interface SimpleCacheEntryEnumerator extends Interface {
  public static final Interface.Manager<SimpleCacheEntryEnumerator, Proxy> MANAGER =
      SimpleCacheEntryEnumerator_Internal.MANAGER;

  public interface GetNext_Response {
    void call(SimpleCacheOpenEntryResult simpleCacheOpenEntryResult);
  }

  public interface Proxy extends SimpleCacheEntryEnumerator, Interface.Proxy {}

  void getNext(GetNext_Response getNext_Response);
}
