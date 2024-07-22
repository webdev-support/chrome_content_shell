package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

public interface V8DetailedMemoryReporter extends Interface {
  public static final Interface.Manager<V8DetailedMemoryReporter, Proxy> MANAGER =
      V8DetailedMemoryReporter_Internal.MANAGER;

  public interface GetV8MemoryUsage_Response {
    void call(PerProcessV8MemoryUsage perProcessV8MemoryUsage);
  }

  public interface Proxy extends V8DetailedMemoryReporter, Interface.Proxy {}

  void getV8MemoryUsage(int i, GetV8MemoryUsage_Response getV8MemoryUsage_Response);

  public static final class Mode {
    public static final int DEFAULT = 0;
    public static final int EAGER = 1;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int LAZY = 2;
    public static final int MAX_VALUE = 2;
    public static final int MIN_VALUE = 0;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private Mode() {}
  }
}
