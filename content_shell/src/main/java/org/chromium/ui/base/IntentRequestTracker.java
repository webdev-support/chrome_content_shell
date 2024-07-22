package org.chromium.ui.base;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import java.lang.ref.WeakReference;

public interface IntentRequestTracker {
  WeakReference<Activity> getActivity();

  boolean onActivityResult(int i, int i2, Intent intent);

  void restoreInstanceState(Bundle bundle);

  void saveInstanceState(Bundle bundle);

  public interface Delegate {
    void finishActivity(int i);

    WeakReference<Activity> getActivity();

    boolean startActivityForResult(Intent intent, int i);

    boolean startIntentSenderForResult(IntentSender intentSender, int i);

    default boolean onCallbackNotFoundError(String error) {
      return false;
    }
  }

  static IntentRequestTracker createFromDelegate(Delegate delegate) {
    return new IntentRequestTrackerImpl(delegate);
  }

  static IntentRequestTracker createFromActivity(Activity activity) {
    return new IntentRequestTrackerImpl(new ActivityIntentRequestTrackerDelegate(activity));
  }
}
