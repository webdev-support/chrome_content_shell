package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface DateTimeChooser extends Interface {
  public static final Interface.Manager<DateTimeChooser, Proxy> MANAGER =
      DateTimeChooser_Internal.MANAGER;

  public interface OpenDateTimeDialog_Response {
    void call(boolean z, double d);
  }

  public interface Proxy extends DateTimeChooser, Interface.Proxy {}

  void closeDateTimeDialog();

  void openDateTimeDialog(
      DateTimeDialogValue dateTimeDialogValue,
      OpenDateTimeDialog_Response openDateTimeDialog_Response);
}
