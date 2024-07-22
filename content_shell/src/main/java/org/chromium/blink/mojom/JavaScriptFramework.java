package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class JavaScriptFramework {
  public static final int ANGULAR = 5;
  public static final int DRUPAL = 10;
  public static final int GATSBY = 3;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int JOOMLA = 11;
  public static final int MAX_VALUE = 15;
  public static final int MIN_VALUE = 0;
  public static final int NEXT = 4;
  public static final int NUXT = 0;
  public static final int PREACT = 8;
  public static final int REACT = 9;
  public static final int SAPPER = 2;
  public static final int SHOPIFY = 12;
  public static final int SQUARESPACE = 13;
  public static final int SVELTE = 7;
  public static final int VUE = 6;
  public static final int VUE_PRESS = 1;
  public static final int WIX = 14;
  public static final int WORD_PRESS = 15;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 15;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private JavaScriptFramework() {}
}
