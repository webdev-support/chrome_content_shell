package org.chromium.content.browser.picker;

import android.content.Context;
import com.example.chromium_content_view.R;

public class MonthPickerDialog extends TwoFieldDatePickerDialog {
  public MonthPickerDialog(
      Context context,
      OnValueSetListener callBack,
      int year,
      int monthOfYear,
      double minMonth,
      double maxMonth) {
    super(context, callBack, year, monthOfYear, minMonth, maxMonth);
    setTitle(R.string.month_picker_dialog_title);
  }

  @Override
  protected TwoFieldDatePicker createPicker(Context context, double minValue, double maxValue) {
    return new MonthPicker(context, minValue, maxValue);
  }

  public MonthPicker getMonthPicker() {
    return (MonthPicker) this.mPicker;
  }
}
