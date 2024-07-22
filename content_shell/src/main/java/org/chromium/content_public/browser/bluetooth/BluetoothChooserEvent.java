package org.chromium.content_public.browser.bluetooth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface BluetoothChooserEvent {
  public static final int CANCELLED = 1;
  public static final int DENIED_PERMISSION = 0;
  public static final int RESCAN = 3;
  public static final int SELECTED = 2;
  public static final int SHOW_ADAPTER_OFF_HELP = 5;
  public static final int SHOW_NEED_LOCATION_HELP = 6;
  public static final int SHOW_OVERVIEW_HELP = 4;
}
