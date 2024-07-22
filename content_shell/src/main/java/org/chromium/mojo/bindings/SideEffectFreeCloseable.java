package org.chromium.mojo.bindings;

import java.io.Closeable;

public class SideEffectFreeCloseable implements Closeable {
  @Override   public void close() {}
}
