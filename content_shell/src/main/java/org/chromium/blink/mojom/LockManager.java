package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

public interface LockManager extends Interface {
  public static final Interface.Manager<LockManager, Proxy> MANAGER = LockManager_Internal.MANAGER;

  public interface Proxy extends LockManager, Interface.Proxy {}

  public interface QueryState_Response {
    void call(LockInfo[] lockInfoArr, LockInfo[] lockInfoArr2);
  }

  void queryState(QueryState_Response queryState_Response);

  void requestLock(
      String str, int i, int i2, AssociatedInterfaceNotSupported associatedInterfaceNotSupported);

  public static final class WaitMode {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 2;
    public static final int MIN_VALUE = 0;
    public static final int NO_WAIT = 1;
    public static final int PREEMPT = 2;
    public static final int WAIT = 0;

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

    private WaitMode() {}
  }
}
