package org.chromium.ui.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.compat.ApiHelperForR;
import org.jni_zero.JNINamespace;

@JNINamespace("ui")
public class DisplayAndroidManager {

  private static final int VIRTUAL_DISPLAY_ID_BEGIN = 1073741823;
  private static DisplayAndroidManager sDisplayAndroidManager;
  private int mMainSdkDisplayId;
  private long mNativePointer;
  private final SparseArray<DisplayAndroid> mIdMap = new SparseArray<>();
  private DisplayListenerBackend mBackend = new DisplayListenerBackend();

  public interface Natives {
    void removeDisplay(long j, DisplayAndroidManager displayAndroidManager, int i);

    void setPrimaryDisplayId(long j, DisplayAndroidManager displayAndroidManager, int i);

    void updateDisplay(
        long j,
        DisplayAndroidManager displayAndroidManager,
        int i,
        int i2,
        int i3,
        float f,
        int i4,
        int i5,
        int i6,
        boolean z,
        boolean z2,
        float f2);
  }

  static DisplayManager m2923$$Nest$smgetDisplayManager() {
    return getDisplayManager();
  }

  public class DisplayListenerBackend implements DisplayManager.DisplayListener {
    private DisplayListenerBackend() {}

    public void startListening() {
      DisplayAndroidManager.m2923$$Nest$smgetDisplayManager().registerDisplayListener(this, null);
    }

    @Override
    public void onDisplayAdded(int sdkDisplayId) {}

    @Override
    public void onDisplayRemoved(int sdkDisplayId) {
      PhysicalDisplayAndroid displayAndroid;
      if (sdkDisplayId == DisplayAndroidManager.this.mMainSdkDisplayId
          || (displayAndroid =
                  (PhysicalDisplayAndroid) DisplayAndroidManager.this.mIdMap.get(sdkDisplayId))
              == null) {
        return;
      }
      displayAndroid.onDisplayRemoved();
      if (DisplayAndroidManager.this.mNativePointer != 0) {
        DisplayAndroidManagerJni.get()
            .removeDisplay(
                DisplayAndroidManager.this.mNativePointer,
                DisplayAndroidManager.this,
                sdkDisplayId);
      }
      DisplayAndroidManager.this.mIdMap.remove(sdkDisplayId);
    }

    @Override
    public void onDisplayChanged(int sdkDisplayId) {
      PhysicalDisplayAndroid displayAndroid =
          (PhysicalDisplayAndroid) DisplayAndroidManager.this.mIdMap.get(sdkDisplayId);
      Display display =
          DisplayAndroidManager.m2923$$Nest$smgetDisplayManager().getDisplay(sdkDisplayId);
      if (displayAndroid != null && display != null) {
        displayAndroid.updateFromDisplay(display);
      }
    }
  }

  public static DisplayAndroidManager getInstance() {
    ThreadUtils.assertOnUiThread();
    if (sDisplayAndroidManager == null) {
      DisplayAndroidManager displayAndroidManager = new DisplayAndroidManager();
      sDisplayAndroidManager = displayAndroidManager;
      displayAndroidManager.initialize();
    }
    return sDisplayAndroidManager;
  }

  public static Display getDefaultDisplayForContext(Context context) {
    if (Build.VERSION.SDK_INT >= 30) {
      Display display = null;
      try {
        display = ApiHelperForR.getDisplay(context);
      } catch (UnsupportedOperationException e) {
      }
      return display != null ? display : getGlobalDefaultDisplay();
    }
    Display display2 = getDisplayForContextNoChecks(context);
    return display2;
  }

  private static Display getGlobalDefaultDisplay() {
    return getDisplayManager().getDisplay(0);
  }

  private static Display getDisplayForContextNoChecks(Context context) {
    WindowManager windowManager = (WindowManager) context.getSystemService("window");
    return windowManager.getDefaultDisplay();
  }

  private static Context getContext() {
    return ContextUtils.getApplicationContext();
  }

  private static DisplayManager getDisplayManager() {
    return (DisplayManager) getContext().getSystemService("display");
  }

  private static void onNativeSideCreated(long nativePointer) {
    DisplayAndroidManager singleton = getInstance();
    singleton.setNativePointer(nativePointer);
  }

  private DisplayAndroidManager() {}

  private void initialize() {
    Display display = getGlobalDefaultDisplay();
    if (display == null) {
      display = getDisplayForContextNoChecks(getContext());
    }
    this.mMainSdkDisplayId = display.getDisplayId();
    addDisplay(display);
    this.mBackend.startListening();
  }

  private void setNativePointer(long nativePointer) {
    this.mNativePointer = nativePointer;
    DisplayAndroidManagerJni.get()
        .setPrimaryDisplayId(this.mNativePointer, this, this.mMainSdkDisplayId);
    for (int i = 0; i < this.mIdMap.size(); i++) {
      updateDisplayOnNativeSide(this.mIdMap.valueAt(i));
    }
  }

  public DisplayAndroid getDisplayAndroid(Display display) {
    int sdkDisplayId = display.getDisplayId();
    DisplayAndroid displayAndroid = this.mIdMap.get(sdkDisplayId);
    if (displayAndroid == null) {
      return addDisplay(display);
    }
    return displayAndroid;
  }

  private DisplayAndroid addDisplay(Display display) {
    int sdkDisplayId = display.getDisplayId();
    PhysicalDisplayAndroid displayAndroid = new PhysicalDisplayAndroid(display);
    if (this.mIdMap.get(sdkDisplayId) != null) {
      throw new AssertionError();
    }
    this.mIdMap.put(sdkDisplayId, displayAndroid);
    displayAndroid.updateFromDisplay(display);
    return displayAndroid;
  }

  public void updateDisplayOnNativeSide(DisplayAndroid displayAndroid) {
    if (this.mNativePointer == 0) {
      return;
    }
    DisplayAndroidManagerJni.get()
        .updateDisplay(
            this.mNativePointer,
            this,
            displayAndroid.getDisplayId(),
            displayAndroid.getDisplayWidth(),
            displayAndroid.getDisplayHeight(),
            displayAndroid.getDipScale(),
            displayAndroid.getRotationDegrees(),
            displayAndroid.getBitsPerPixel(),
            displayAndroid.getBitsPerComponent(),
            displayAndroid.getIsWideColorGamut(),
            displayAndroid.getIsHdr(),
            displayAndroid.getHdrMaxLuminanceRatio());
  }

  public static void resetInstanceForTesting() {
    sDisplayAndroidManager = null;
  }
}
