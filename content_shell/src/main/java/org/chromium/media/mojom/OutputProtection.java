package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface OutputProtection extends Interface {
  public static final Interface.Manager<OutputProtection, Proxy> MANAGER =
      OutputProtection_Internal.MANAGER;

  public interface EnableProtection_Response {
    void call(boolean z);
  }

  public interface Proxy extends OutputProtection, Interface.Proxy {}

  public interface QueryStatus_Response {
    void call(boolean z, int i, int i2);
  }

  void enableProtection(int i, EnableProtection_Response enableProtection_Response);

  void queryStatus(QueryStatus_Response queryStatus_Response);

  public static final class ProtectionType {
    public static final int DEFAULT_VALUE = 0;
    public static final int HDCP = 1;
    private static final boolean IS_EXTENSIBLE = true;
    public static final int MAX_VALUE = 1;
    public static final int MIN_VALUE = 0;
    public static final int NONE = 0;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 1;
    }

    public static void validate(int value) {}

    public static int toKnownValue(int value) {
      if (isKnownValue(value)) {
        return value;
      }
      return 0;
    }

    private ProtectionType() {}
  }

  public static final class LinkType {
    public static final int DEFAULT_VALUE = 0;
    public static final int DISPLAYPORT = 32;
    public static final int DVI = 16;
    public static final int HDMI = 8;
    public static final int INTERNAL = 2;
    private static final boolean IS_EXTENSIBLE = true;
    public static final int MAX_VALUE = 64;
    public static final int MIN_VALUE = 0;
    public static final int NETWORK = 64;
    public static final int NONE = 0;
    public static final int UNKNOWN = 1;
    public static final int VGA = 4;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      switch (value) {
        case 0:
        case 1:
        case 2:
        case 4:
        case 8:
        case 16:
        case 32:
        case 64:
          return true;
        default:
          return false;
      }
    }

    public static void validate(int value) {}

    public static int toKnownValue(int value) {
      if (isKnownValue(value)) {
        return value;
      }
      return 0;
    }

    private LinkType() {}
  }
}
