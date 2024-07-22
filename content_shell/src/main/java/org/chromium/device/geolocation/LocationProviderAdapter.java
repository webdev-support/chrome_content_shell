package org.chromium.device.geolocation;

import android.location.Location;
import java.util.concurrent.FutureTask;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;

public class LocationProviderAdapter {

  private static final String TAG = "LocationProvider";
  private LocationProvider mImpl = LocationProviderFactory.create();

  public interface Natives {
    void newErrorAvailable(String str);

    void newLocationAvailable(
        double d,
        double d2,
        double d3,
        boolean z,
        double d4,
        boolean z2,
        double d5,
        boolean z3,
        double d6,
        boolean z4,
        double d7);
  }

  private LocationProviderAdapter() {}

  public static LocationProviderAdapter create() {
    return new LocationProviderAdapter();
  }

  public void start(final boolean enableHighAccuracy) {
    FutureTask<Void> task =
        new FutureTask<>(
            new Runnable() {
              @Override
              public void run() {
                LocationProviderAdapter.this.mImpl.start(enableHighAccuracy);
              }
            },
            null);
    ThreadUtils.runOnUiThread((FutureTask) task);
  }

  public void stop() {
    FutureTask<Void> task =
        new FutureTask<>(
            new Runnable() {
              @Override
              public void run() {
                LocationProviderAdapter.this.mImpl.stop();
              }
            },
            null);
    ThreadUtils.runOnUiThread((FutureTask) task);
  }

  public boolean isRunning() {
    if (!ThreadUtils.runningOnUiThread()) {
      throw new AssertionError();
    }
    return this.mImpl.isRunning();
  }

  public static void onNewLocationAvailable(Location location) {
    LocationProviderAdapterJni.get()
        .newLocationAvailable(
            location.getLatitude(),
            location.getLongitude(),
            location.getTime() / 1000.0d,
            location.hasAltitude(),
            location.getAltitude(),
            location.hasAccuracy(),
            location.getAccuracy(),
            location.hasBearing(),
            location.getBearing(),
            location.hasSpeed(),
            location.getSpeed());
  }

  public static void newErrorAvailable(String message) {
    Log.e(TAG, "newErrorAvailable %s", message);
    LocationProviderAdapterJni.get().newErrorAvailable(message);
  }
}
