package org.chromium.mojo.bindings;

import org.chromium.mojo.system.MojoException;

public interface ConnectionErrorHandler {
  void onConnectionError(MojoException mojoException);
}
