package org.chromium.installedapp.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface InstalledAppProvider extends Interface {
  public static final Interface.Manager<InstalledAppProvider, Proxy> MANAGER =
      InstalledAppProvider_Internal.MANAGER;

  public interface FilterInstalledApps_Response {
    void call(RelatedApplication[] relatedApplicationArr);
  }

  public interface Proxy extends InstalledAppProvider, Interface.Proxy {}

  void filterInstalledApps(
      RelatedApplication[] relatedApplicationArr,
      Url url,
      FilterInstalledApps_Response filterInstalledApps_Response);
}
