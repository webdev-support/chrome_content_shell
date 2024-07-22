package org.chromium.mojo.system;

import java.io.Closeable;

public interface Handle extends Closeable {
  @Override   void close();

  Core getCore();

  boolean isValid();

  Handle pass();

  Core.HandleSignalsState querySignalsState();

  long releaseNativeHandle();

  UntypedHandle toUntypedHandle();
}
