package org.chromium.ui.gfx;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ViewConfiguration;
import com.example.chromium_content_view.R;
import org.chromium.base.ContextUtils;
import org.chromium.base.StrictModeContext;
import org.jni_zero.JNINamespace;

@JNINamespace("gfx")
public class ViewConfigurationHelper {

  private static final float MIN_SCALING_SPAN_MM = 12.0f;
  private float mDensity;
  private ViewConfiguration mViewConfiguration;

  public interface Natives {
    void updateSharedViewConfiguration(
        ViewConfigurationHelper viewConfigurationHelper,
        float f,
        float f2,
        float f3,
        float f4,
        float f5);
  }

  private ViewConfigurationHelper() {
    StrictModeContext ignored = StrictModeContext.allowAllVmPolicies();
    try {
      this.mViewConfiguration = ViewConfiguration.get(ContextUtils.getApplicationContext());
      if (ignored != null) {
        ignored.close();
      }
      float f = ContextUtils.getApplicationContext().getResources().getDisplayMetrics().density;
      this.mDensity = f;
      if (f <= 0.0f) {
        throw new AssertionError();
      }
    } catch (Throwable th) {
      if (ignored != null) {
        try {
          ignored.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }

  private void registerListener() {
    ContextUtils.getApplicationContext()
        .registerComponentCallbacks(
            new ComponentCallbacks() {
              @Override
              public void onConfigurationChanged(Configuration configuration) {
                ViewConfigurationHelper.this.updateNativeViewConfigurationIfNecessary();
              }

              @Override
              public void onLowMemory() {}
            });
  }

  public void updateNativeViewConfigurationIfNecessary() {
    ViewConfiguration configuration = ViewConfiguration.get(ContextUtils.getApplicationContext());
    if (this.mViewConfiguration == configuration) {
      if (this.mDensity
          != ContextUtils.getApplicationContext().getResources().getDisplayMetrics().density) {
        throw new AssertionError();
      }
      return;
    }
    this.mViewConfiguration = configuration;
    float f = ContextUtils.getApplicationContext().getResources().getDisplayMetrics().density;
    this.mDensity = f;
    if (f <= 0.0f) {
      throw new AssertionError();
    }
    ViewConfigurationHelperJni.get()
        .updateSharedViewConfiguration(
            this,
            getMaximumFlingVelocity(),
            getMinimumFlingVelocity(),
            getTouchSlop(),
            getDoubleTapSlop(),
            getMinScalingSpan());
  }

  private static int getDoubleTapTimeout() {
    return ViewConfiguration.getDoubleTapTimeout();
  }

  private static int getLongPressTimeout() {
    return ViewConfiguration.getLongPressTimeout();
  }

  private static int getTapTimeout() {
    return ViewConfiguration.getTapTimeout();
  }

  private float getMaximumFlingVelocity() {
    return toDips(this.mViewConfiguration.getScaledMaximumFlingVelocity());
  }

  private float getMinimumFlingVelocity() {
    return toDips(this.mViewConfiguration.getScaledMinimumFlingVelocity());
  }

  private float getTouchSlop() {
    return toDips(this.mViewConfiguration.getScaledTouchSlop());
  }

  private float getDoubleTapSlop() {
    return toDips(this.mViewConfiguration.getScaledDoubleTapSlop());
  }

  private float getMinScalingSpan() {
    return toDips(getScaledMinScalingSpan());
  }

  private int getScaledMinScalingSpan() {
    Resources res = ContextUtils.getApplicationContext().getResources();
    int id = R.dimen.config_min_scaling_span;
    try {
      return res.getDimensionPixelSize(id);
    } catch (Resources.NotFoundException e) {
      throw new AssertionError("MinScalingSpan resource lookup failed.");
    }
  }

  private float toDips(int pixels) {
    return pixels / this.mDensity;
  }

  private static ViewConfigurationHelper createWithListener() {
    ViewConfigurationHelper viewConfigurationHelper = new ViewConfigurationHelper();
    viewConfigurationHelper.registerListener();
    return viewConfigurationHelper;
  }
}
