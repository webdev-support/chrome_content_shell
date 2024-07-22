package org.chromium.base.memory;

@FunctionalInterface
public interface MemoryPressureCallback {
  void onPressure(int i);
}
