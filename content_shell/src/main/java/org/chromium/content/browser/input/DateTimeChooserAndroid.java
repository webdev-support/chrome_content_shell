package org.chromium.content.browser.input;

import android.content.Context;
import org.chromium.base.ContextUtils;
import org.chromium.content.browser.picker.DateTimeSuggestion;
import org.chromium.content.browser.picker.InputDialogContainer;
import org.chromium.ui.base.WindowAndroid;
import org.jni_zero.JNINamespace;

@JNINamespace("content")
class DateTimeChooserAndroid {
  private final InputDialogContainer mInputDialogContainer;
  private long mNativeDateTimeChooserAndroid;

  public interface Natives {
    void cancelDialog(long j, DateTimeChooserAndroid dateTimeChooserAndroid);

    void replaceDateTime(long j, DateTimeChooserAndroid dateTimeChooserAndroid, double d);
  }

  private DateTimeChooserAndroid(Context context, long nativeDateTimeChooserAndroid) {
    this.mNativeDateTimeChooserAndroid = nativeDateTimeChooserAndroid;
    this.mInputDialogContainer =
        new InputDialogContainer(
            context,
            new InputDialogContainer.InputActionDelegate() {
              @Override
              public void replaceDateTime(double value) {
                if (DateTimeChooserAndroid.this.mNativeDateTimeChooserAndroid == 0) {
                  return;
                }
                DateTimeChooserAndroidJni.get()
                    .replaceDateTime(
                        DateTimeChooserAndroid.this.mNativeDateTimeChooserAndroid,
                        DateTimeChooserAndroid.this,
                        value);
              }

              @Override
              public void cancelDateTimeDialog() {
                if (DateTimeChooserAndroid.this.mNativeDateTimeChooserAndroid == 0) {
                  return;
                }
                DateTimeChooserAndroidJni.get()
                    .cancelDialog(
                        DateTimeChooserAndroid.this.mNativeDateTimeChooserAndroid,
                        DateTimeChooserAndroid.this);
              }
            });
  }

  private void showDialog(
      int dialogType,
      double dialogValue,
      double min,
      double max,
      double step,
      DateTimeSuggestion[] suggestions) {
    this.mInputDialogContainer.showDialog(dialogType, dialogValue, min, max, step, suggestions);
  }

  private void dismissAndDestroy() {
    this.mNativeDateTimeChooserAndroid = 0L;
    this.mInputDialogContainer.dismissDialog();
  }

  private static DateTimeChooserAndroid createDateTimeChooser(
      WindowAndroid windowAndroid,
      long nativeDateTimeChooserAndroid,
      int dialogType,
      double dialogValue,
      double min,
      double max,
      double step,
      DateTimeSuggestion[] suggestions) {
    Context windowAndroidContext = windowAndroid.getContext().get();
    if (windowAndroidContext != null
        && ContextUtils.activityFromContext(windowAndroidContext) != null) {
      DateTimeChooserAndroid chooser =
          new DateTimeChooserAndroid(windowAndroidContext, nativeDateTimeChooserAndroid);
      chooser.showDialog(dialogType, dialogValue, min, max, step, suggestions);
      return chooser;
    }
    return null;
  }

  private static DateTimeSuggestion[] createSuggestionsArray(int size) {
    return new DateTimeSuggestion[size];
  }

  private static void setDateTimeSuggestionAt(
      DateTimeSuggestion[] array, int index, double value, String localizedValue, String label) {
    array[index] = new DateTimeSuggestion(value, localizedValue, label);
  }
}
