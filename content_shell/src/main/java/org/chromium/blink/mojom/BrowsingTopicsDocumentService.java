package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface BrowsingTopicsDocumentService extends Interface {
  public static final Interface.Manager<BrowsingTopicsDocumentService, Proxy> MANAGER =
      BrowsingTopicsDocumentService_Internal.MANAGER;

  public interface GetBrowsingTopics_Response {
    void call(GetBrowsingTopicsResult getBrowsingTopicsResult);
  }

  public interface Proxy extends BrowsingTopicsDocumentService, Interface.Proxy {}

  void getBrowsingTopics(boolean z, GetBrowsingTopics_Response getBrowsingTopics_Response);
}
