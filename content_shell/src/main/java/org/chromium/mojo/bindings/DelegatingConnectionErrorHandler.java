package org.chromium.mojo.bindings;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import org.chromium.mojo.system.MojoException;

public class DelegatingConnectionErrorHandler implements ConnectionErrorHandler {
  private final Set<ConnectionErrorHandler> mHandlers =
      Collections.newSetFromMap(new WeakHashMap());

  @Override
  public void onConnectionError(MojoException e) {
    for (ConnectionErrorHandler handler : this.mHandlers) {
      handler.onConnectionError(e);
    }
  }

  public void addConnectionErrorHandler(ConnectionErrorHandler handler) {
    this.mHandlers.add(handler);
  }

  public void removeConnectionErrorHandler(ConnectionErrorHandler handler) {
    this.mHandlers.remove(handler);
  }
}
