package org.chromium.device.geolocation;

import org.chromium.base.ContextUtils;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
public class LocationProviderFactory {
  private static LocationProvider sProviderImpl;
  private static boolean sUseGmsCoreLocationProvider;

  private LocationProviderFactory() {}

  public static void setLocationProviderImpl(LocationProvider provider) {
    sProviderImpl = provider;
  }

  public static void useGmsCoreLocationProvider() {
    sUseGmsCoreLocationProvider = true;
  }

  public static LocationProvider create() {
    LocationProvider locationProvider = sProviderImpl;
    if (locationProvider != null) {
      return locationProvider;
    }
    if (sUseGmsCoreLocationProvider
        && LocationProviderGmsCore.isGooglePlayServicesAvailable(
            ContextUtils.getApplicationContext())) {
      sProviderImpl = new LocationProviderGmsCore(ContextUtils.getApplicationContext());
    } else {
      sProviderImpl = new LocationProviderAndroid();
    }
    return sProviderImpl;
  }
}
