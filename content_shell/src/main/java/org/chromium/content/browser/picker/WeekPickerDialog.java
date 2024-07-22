package org.chromium.content.browser.picker;

import android.content.Context;
import com.example.chromium_content_view.R;

public class WeekPickerDialog extends TwoFieldDatePickerDialog {
  public WeekPickerDialog(
      Context context,
      OnValueSetListener callBack,
      int year,
      int weekOfYear,
      double minValue,
      double maxValue) {
    this(context, 0, callBack, year, weekOfYear, minValue, maxValue);
  }

  public WeekPickerDialog(
      Context context,
      int theme,
      OnValueSetListener callBack,
      int year,
      int weekOfYear,
      double minValue,
      double maxValue) {
    super(context, theme, callBack, year, weekOfYear, minValue, maxValue);
    setTitle(R.string.week_picker_dialog_title);
  }

  @Override
  protected TwoFieldDatePicker createPicker(Context context, double minValue, double maxValue) {
    return new WeekPicker(context, minValue, maxValue);
  }

  public WeekPicker getWeekPicker() {
    return (WeekPicker) this.mPicker;
  }
}
