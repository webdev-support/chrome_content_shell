package org.chromium.base;

public class MathUtils {
  public static final float EPSILON = 0.001f;

  private MathUtils() {}

  public static int clamp(int value, int a, int b) {
    int min = a > b ? b : a;
    int max = a > b ? a : b;
    if (value < min) {
      return min;
    }
    if (value > max) {
      return max;
    }
    return value;
  }

  public static long clamp(long value, long a, long b) {
    long min = a > b ? b : a;
    long max = a > b ? a : b;
    if (value < min) {
      return min;
    }
    if (value > max) {
      return max;
    }
    return value;
  }

  public static float clamp(float value, float a, float b) {
    float min = a > b ? b : a;
    float max = a > b ? a : b;
    if (value < min) {
      return min;
    }
    if (value > max) {
      return max;
    }
    return value;
  }

  public static int positiveModulo(int a, int b) {
    int mod = a % b;
    return mod >= 0 ? mod : mod + b;
  }

  public static float interpolate(float value, float target, float speed) {
    return ((target - value) * speed) + value;
  }

  public static float smoothstep(float t) {
    return t * t * (3.0f - (2.0f * t));
  }

  public static int flipSignIf(int value, boolean flipSign) {
    return flipSign ? -value : value;
  }

  public static float flipSignIf(float value, boolean flipSign) {
    return flipSign ? -value : value;
  }

  public static boolean areFloatsEqual(float f1, float f2) {
    return Math.abs(f1 - f2) < 0.001f;
  }

  public static float distance(float x1, float y1, float x2, float y2) {
    float xDist = x2 - x1;
    float yDist = y2 - y1;
    return (float) Math.sqrt((xDist * xDist) + (yDist * yDist));
  }

  public static float distance(float distanceX, float distanceY) {
    return (float) Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
  }

  public static float map(
      float value, float fromStart, float fromStop, float toStart, float toStop) {
    return ((toStop - toStart) * ((value - fromStart) / (fromStop - fromStart))) + toStart;
  }

  public static double roundTwoDecimalPlaces(double value) {
    return Math.round(value * 100.0d) / 100.0d;
  }
}
