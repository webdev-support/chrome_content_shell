package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface ManifestManager extends Interface {
  public static final Interface.Manager<ManifestManager, Proxy> MANAGER =
      ManifestManager_Internal.MANAGER;

  public interface ParseManifestFromString_Response {
    void call(Manifest_ manifest_);
  }

  public interface Proxy extends ManifestManager, Interface.Proxy {}

  public interface RequestManifestDebugInfo_Response {
    void call(Url url, Manifest_ manifest_, ManifestDebugInfo manifestDebugInfo);
  }

  public interface RequestManifest_Response {
    void call(Url url, Manifest_ manifest_);
  }

  void parseManifestFromString(
      Url url,
      Url url2,
      String str,
      ParseManifestFromString_Response parseManifestFromString_Response);

  void requestManifest(RequestManifest_Response requestManifest_Response);

  void requestManifestDebugInfo(
      RequestManifestDebugInfo_Response requestManifestDebugInfo_Response);
}
