package org.chromium.content.browser.picker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.DatePicker;

class DatePickerDialogCompat extends DatePickerDialog {
  private final DatePickerDialog.OnDateSetListener mCallBack;

  public DatePickerDialogCompat(
      Context context,
      DatePickerDialog.OnDateSetListener callBack,
      int year,
      int monthOfYear,
      int dayOfMonth) {
    super(context, callBack, year, monthOfYear, dayOfMonth);
    this.mCallBack = callBack;
  }

  @Override // android.app.DatePickerDialog, android.content.DialogInterface.OnClickListener
  public void onClick(DialogInterface dialog, int which) {
    if (which == -1 && this.mCallBack != null) {
      DatePicker datePicker = getDatePicker();
      datePicker.clearFocus();
      this.mCallBack.onDateSet(
          datePicker, datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
    }
  }

  @Override // android.app.AlertDialog, android.app.Dialog
  public void setTitle(CharSequence title) {
    super.setTitle("");
  }
}
