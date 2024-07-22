package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface SimpleCache extends Interface {
  public static final Interface.Manager<SimpleCache, Proxy> MANAGER = SimpleCache_Internal.MANAGER;

  public interface CreateEntry_Response {
    void call(SimpleCacheEntry simpleCacheEntry, int i);
  }

  public interface Detach_Response {
    void call();
  }

  public interface DoomAllEntries_Response {
    void call(int i);
  }

  public interface DoomEntry_Response {
    void call(int i);
  }

  public interface OpenEntry_Response {
    void call(SimpleCacheEntry simpleCacheEntry, int i);
  }

  public interface Proxy extends SimpleCache, Interface.Proxy {}

  void createEntry(String str, CreateEntry_Response createEntry_Response);

  void detach(Detach_Response detach_Response);

  void doomAllEntries(DoomAllEntries_Response doomAllEntries_Response);

  void doomEntry(String str, DoomEntry_Response doomEntry_Response);

  void enumerateEntries(InterfaceRequest<SimpleCacheEntryEnumerator> interfaceRequest);

  void openEntry(String str, OpenEntry_Response openEntry_Response);
}
