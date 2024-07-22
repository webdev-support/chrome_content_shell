package org.chromium.payments.mojom;

public final class ItemType {
  public static final int DEFAULT_VALUE = 0;
  private static final boolean IS_EXTENSIBLE = true;
  public static final int MAX_VALUE = 2;
  public static final int MIN_VALUE = 0;
  public static final int PRODUCT = 1;
  public static final int SUBSCRIPTION = 2;
  public static final int UNKNOWN = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 2;
  }

  public static void validate(int value) {}

  public static int toKnownValue(int value) {
    if (isKnownValue(value)) {
      return value;
    }
    return 0;
  }

  private ItemType() {}
}
