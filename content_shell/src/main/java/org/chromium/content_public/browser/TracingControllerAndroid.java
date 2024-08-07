package org.chromium.content_public.browser;

import android.content.Context;
import android.util.Pair;
import org.chromium.base.Callback;
import org.chromium.content.browser.TracingControllerAndroidImpl;

public interface TracingControllerAndroid {
  void destroy();

  boolean getKnownCategories(Callback<String[]> callback);

  String getOutputPath();

  boolean getTraceBufferUsage(Callback<Pair<Float, Long>> callback);

  boolean isTracing();

  boolean startTracing(String str, boolean z, String str2, String str3, boolean z2, boolean z3);

  void stopTracing(Callback<Void> callback);

  static TracingControllerAndroid create(Context context) {
    return new TracingControllerAndroidImpl(context);
  }
}
