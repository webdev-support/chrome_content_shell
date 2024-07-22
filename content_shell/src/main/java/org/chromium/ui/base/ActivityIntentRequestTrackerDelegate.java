package org.chromium.ui.base;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentSender;
import java.lang.ref.WeakReference;

public class ActivityIntentRequestTrackerDelegate implements IntentRequestTracker.Delegate {

  private final ImmutableWeakReference<Activity> mActivityWeakRefHolder;

  public ActivityIntentRequestTrackerDelegate(Activity activity) {
    if (activity == null) {
      throw new AssertionError();
    }
    this.mActivityWeakRefHolder = new ImmutableWeakReference<>(activity);
  }

  @Override
  public boolean startActivityForResult(Intent intent, int requestCode) {
    Activity activity = (Activity) this.mActivityWeakRefHolder.get();
    if (activity == null) {
      return false;
    }
    try {
      activity.startActivityForResult(intent, requestCode);
      return true;
    } catch (ActivityNotFoundException e) {
      return false;
    }
  }

  @Override
  public boolean startIntentSenderForResult(IntentSender intentSender, int requestCode) {
    Activity activity = (Activity) this.mActivityWeakRefHolder.get();
    if (activity == null) {
      return false;
    }
    try {
      activity.startIntentSenderForResult(intentSender, requestCode, new Intent(), 0, 0, 0);
      return true;
    } catch (IntentSender.SendIntentException e) {
      return false;
    }
  }

  @Override
  public void finishActivity(int requestCode) {
    Activity activity = (Activity) this.mActivityWeakRefHolder.get();
    if (activity == null) {
      return;
    }
    activity.finishActivity(requestCode);
  }

  @Override
  public final WeakReference<Activity> getActivity() {
    return this.mActivityWeakRefHolder;
  }
}
