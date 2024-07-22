package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface WebLaunchService extends Interface {
  public static final Interface.Manager<WebLaunchService, Proxy> MANAGER =
      WebLaunchService_Internal.MANAGER;

  public interface Proxy extends WebLaunchService, Interface.Proxy {}

  void enqueueLaunchParams(Url url);

  void setLaunchFiles(FileSystemAccessEntry[] fileSystemAccessEntryArr);
}
