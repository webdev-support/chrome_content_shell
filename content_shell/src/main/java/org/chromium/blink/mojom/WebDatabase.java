package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.internal.mojom.Origin;

public interface WebDatabase extends Interface {
  public static final Interface.Manager<WebDatabase, Proxy> MANAGER = WebDatabase_Internal.MANAGER;

  public interface Proxy extends WebDatabase, Interface.Proxy {}

  void closeImmediately(Origin origin, String16 string16);

  void updateSize(Origin origin, String16 string16, long j);
}
