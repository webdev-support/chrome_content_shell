package org.chromium.content.browser.picker;

import android.content.Context;
import com.example.chromium_content_view.R;
import java.util.Calendar;
import java.util.TimeZone;

public class WeekPicker extends TwoFieldDatePicker {
  public WeekPicker(Context context, double minValue, double maxValue) {
    super(context, minValue, maxValue);
    getPositionInYearSpinner()
        .setContentDescription(getResources().getString(R.string.accessibility_date_picker_week));
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    cal.setFirstDayOfWeek(2);
    cal.setMinimalDaysInFirstWeek(4);
    cal.setTimeInMillis(System.currentTimeMillis());
    init(getISOWeekYearForDate(cal), getWeekForDate(cal), null);
  }

  public static Calendar createDateFromWeek(int year, int week) {
    Calendar date = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    date.clear();
    date.setFirstDayOfWeek(2);
    date.setMinimalDaysInFirstWeek(4);
    date.set(7, 2);
    date.set(1, year);
    date.set(3, week);
    return date;
  }

  public static Calendar createDateFromValue(double value) {
    Calendar date = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    date.clear();
    date.setFirstDayOfWeek(2);
    date.setMinimalDaysInFirstWeek(4);
    date.setTimeInMillis((long) value);
    return date;
  }

  @Override
  protected Calendar getDateForValue(double value) {
    return createDateFromValue(value);
  }

  public static int getISOWeekYearForDate(Calendar date) {
    int year = date.get(1);
    int month = date.get(2);
    int week = date.get(3);
    if (month == 0 && week > 51) {
      return year - 1;
    }
    if (month == 11 && week == 1) {
      return year + 1;
    }
    return year;
  }

  public static int getWeekForDate(Calendar date) {
    return date.get(3);
  }

  @Override
  protected void setCurrentDate(int year, int week) {
    Calendar date = createDateFromWeek(year, week);
    if (date.before(getMinDate())) {
      setCurrentDate(getMinDate());
    } else if (date.after(getMaxDate())) {
      setCurrentDate(getMaxDate());
    } else {
      setCurrentDate(date);
    }
  }

  private int getNumberOfWeeks(int year) {
    Calendar date = createDateFromWeek(year, 20);
    return date.getActualMaximum(3);
  }

  @Override
  public int getYear() {
    return getISOWeekYearForDate(getCurrentDate());
  }

  public int getWeek() {
    return getWeekForDate(getCurrentDate());
  }

  @Override
  public int getPositionInYear() {
    return getWeek();
  }

  @Override
  protected int getMaxYear() {
    return getISOWeekYearForDate(getMaxDate());
  }

  @Override
  protected int getMinYear() {
    return getISOWeekYearForDate(getMinDate());
  }

  @Override
  protected int getMaxPositionInYear(int year) {
    if (year == getISOWeekYearForDate(getMaxDate())) {
      return getWeekForDate(getMaxDate());
    }
    return getNumberOfWeeks(year);
  }

  @Override
  protected int getMinPositionInYear(int year) {
    if (year == getISOWeekYearForDate(getMinDate())) {
      return getWeekForDate(getMinDate());
    }
    return 1;
  }
}
