package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface MediaDrmStorage extends Interface {
  public static final Interface.Manager<MediaDrmStorage, Proxy> MANAGER =
      MediaDrmStorage_Internal.MANAGER;

  public interface Initialize_Response {
    void call(boolean z, UnguessableToken unguessableToken);
  }

  public interface LoadPersistentSession_Response {
    void call(SessionData sessionData);
  }

  public interface OnProvisioned_Response {
    void call(boolean z);
  }

  public interface Proxy extends MediaDrmStorage, Interface.Proxy {}

  public interface RemovePersistentSession_Response {
    void call(boolean z);
  }

  public interface SavePersistentSession_Response {
    void call(boolean z);
  }

  void initialize(Initialize_Response initialize_Response);

  void loadPersistentSession(
      String str, LoadPersistentSession_Response loadPersistentSession_Response);

  void onProvisioned(OnProvisioned_Response onProvisioned_Response);

  void removePersistentSession(
      String str, RemovePersistentSession_Response removePersistentSession_Response);

  void savePersistentSession(
      String str,
      SessionData sessionData,
      SavePersistentSession_Response savePersistentSession_Response);
}
