package org.chromium.ax.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class Mutation {
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 6;
  public static final int MIN_VALUE = 0;
  public static final int NODE_CHANGED = 3;
  public static final int NODE_CREATED = 1;
  public static final int NODE_REMOVED = 4;
  public static final int NONE = 0;
  public static final int SUBTREE_CREATED = 2;
  public static final int SUBTREE_UPDATE_END = 6;
  public static final int TEXT_CHANGED = 5;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 6;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private Mutation() {}
}
