package org.chromium.media.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

public interface CdmStorage extends Interface {
  public static final Interface.Manager<CdmStorage, Proxy> MANAGER = CdmStorage_Internal.MANAGER;

  public interface Open_Response {
    void call(int i, AssociatedInterfaceNotSupported associatedInterfaceNotSupported);
  }

  public interface Proxy extends CdmStorage, Interface.Proxy {}

  void open(String str, Open_Response open_Response);

  public static final class Status {
    public static final int FAILURE = 2;
    public static final int IN_USE = 1;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 2;
    public static final int MIN_VALUE = 0;
    public static final int SUCCESS = 0;

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

    private Status() {}
  }
}
