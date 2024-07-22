package org.chromium.ui.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class LatencyComponentType {
  public static final int DISPLAY_COMPOSITOR_RECEIVED_FRAME_COMPONENT = 9;
  public static final int INPUT_EVENT_GPU_SWAP_BUFFER_COMPONENT = 10;
  public static final int INPUT_EVENT_LATENCY_BEGIN_RWH_COMPONENT = 0;
  public static final int INPUT_EVENT_LATENCY_FIRST_SCROLL_UPDATE_ORIGINAL_COMPONENT = 2;
  public static final int INPUT_EVENT_LATENCY_FRAME_SWAP_COMPONENT = 11;
  public static final int INPUT_EVENT_LATENCY_ORIGINAL_COMPONENT = 3;
  public static final int INPUT_EVENT_LATENCY_RENDERER_MAIN_COMPONENT = 5;
  public static final int INPUT_EVENT_LATENCY_RENDERER_SWAP_COMPONENT = 8;
  public static final int INPUT_EVENT_LATENCY_RENDERING_SCHEDULED_IMPL_COMPONENT = 7;
  public static final int INPUT_EVENT_LATENCY_RENDERING_SCHEDULED_MAIN_COMPONENT = 6;
  public static final int INPUT_EVENT_LATENCY_SCROLL_UPDATE_ORIGINAL_COMPONENT = 1;
  public static final int INPUT_EVENT_LATENCY_UI_COMPONENT = 4;
  private static final boolean IS_EXTENSIBLE = false;
  public static final int MAX_VALUE = 11;
  public static final int MIN_VALUE = 0;

  public @interface EnumType {}

  public static boolean isKnownValue(int value) {
    return value >= 0 && value <= 11;
  }

  public static void validate(int value) {
    if (!isKnownValue(value)) {
      throw new DeserializationException("Invalid enum value.");
    }
  }

  public static int toKnownValue(int value) {
    return value;
  }

  private LatencyComponentType() {}
}
