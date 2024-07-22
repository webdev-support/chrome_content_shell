package org.chromium.ui.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.Callback;
import org.chromium.base.ContextUtils;
import org.chromium.base.LifetimeAssert;
import org.chromium.base.Log;
import org.chromium.base.ObserverList;
import org.chromium.base.PackageManagerUtils;
import org.chromium.base.TraceEvent;
import org.chromium.base.UnownedUserDataHost;
import org.chromium.base.compat.ApiHelperForO;
import org.chromium.base.compat.ApiHelperForOMR1;
import org.chromium.ui.KeyboardVisibilityDelegate;
import org.chromium.ui.display.DisplayAndroid;
import org.chromium.ui.modaldialog.ModalDialogManager;
import org.chromium.ui.permissions.AndroidPermissionDelegate;
import org.chromium.ui.permissions.PermissionCallback;
import org.chromium.ui.widget.Toast;
import org.jni_zero.JNINamespace;

@JNINamespace("ui")
public class WindowAndroid
    implements AndroidPermissionDelegate, DisplayAndroid.DisplayAndroidObserver {

  private static final float MAX_REFRESH_RATE_DELTA = 2.0f;
  private static final ImmutableWeakReference<Activity> NULL_ACTIVITY_WEAK_REF =
      new ImmutableWeakReference<>(null);
  public static final int START_INTENT_FAILURE = -1;
  private static final String TAG = "WindowAndroid";
  static final String WINDOW_CALLBACK_ERRORS = "window_callback_errors";
  private ObserverList<ActivityStateObserver> mActivityStateObservers;
  private final boolean mAllowChangeRefreshRate;
  private View mAnimationPlaceholderView;
  private HashSet<Animator> mAnimationsOverContent;
  private ApplicationViewportInsetSupplier mApplicationBottomInsetSupplier;
  private final ObserverList<OnCloseContextMenuListener> mContextMenuCloseListeners;
  private final ImmutableWeakReference<Context> mContextRef;
  private final DisplayAndroid mDisplayAndroid;
  private boolean mHasFocus;
  private IntentRequestTrackerImpl mIntentRequestTracker;
  private boolean mIsDestroyed;
  private KeyboardVisibilityDelegate mKeyboardVisibilityDelegate;
  private final LifetimeAssert mLifetimeAssert;
  private long mNativeWindowAndroid;
  private OverlayTransformApiHelper mOverlayTransformApiHelper;
  private AndroidPermissionDelegate mPermissionDelegate;
  private float mRefreshRate;
  private boolean mSelectionHandlesActive;
  private ObserverList<SelectionHandlesObserver> mSelectionHandlesObservers;
  private List<Display.Mode> mSupportedRefreshRateModes;
  private final UnownedUserDataHost mUnownedUserDataHost;
  private boolean mVSyncPaused;

  public interface ActivityStateObserver {
    void onActivityDestroyed();

    void onActivityPaused();

    void onActivityResumed();
  }

  public interface IntentCallback {
    void onIntentCompleted(int i, Intent intent);
  }

  public interface Natives {
    void destroy(long j, WindowAndroid windowAndroid);

    long init(WindowAndroid windowAndroid, int i, float f, boolean z);

    void onActivityStarted(long j, WindowAndroid windowAndroid);

    void onActivityStopped(long j, WindowAndroid windowAndroid);

    void onOverlayTransformUpdated(long j, WindowAndroid windowAndroid);

    void onSupportedRefreshRatesUpdated(long j, WindowAndroid windowAndroid, float[] fArr);

    void onUpdateRefreshRate(long j, WindowAndroid windowAndroid, float f);

    void onVisibilityChanged(long j, WindowAndroid windowAndroid, boolean z);

    void sendUnfoldLatencyBeginTimestamp(long j, long j2);

    void setVSyncPaused(long j, WindowAndroid windowAndroid, boolean z);
  }

  public interface OnCloseContextMenuListener {
    void onContextMenuClosed();
  }

  public interface SelectionHandlesObserver {
    void onSelectionHandlesStateChanged(boolean z);
  }

  public View getReadbackView() {
    return null;
  }

  public WindowAndroid(Context context) {
    this(context, DisplayAndroid.getNonMultiDisplay(context));
  }

  public WindowAndroid(Context context, IntentRequestTracker tracker) {
    this(context, DisplayAndroid.getNonMultiDisplay(context));
    this.mIntentRequestTracker = (IntentRequestTrackerImpl) tracker;
  }

  protected WindowAndroid(Context context, DisplayAndroid display) {
    this.mKeyboardVisibilityDelegate = KeyboardVisibilityDelegate.getInstance();
    this.mAnimationsOverContent = new HashSet<>();
    this.mApplicationBottomInsetSupplier = new ApplicationViewportInsetSupplier();
    this.mUnownedUserDataHost = new UnownedUserDataHost();
    boolean z = true;
    this.mHasFocus = true;
    this.mActivityStateObservers = new ObserverList<>();
    this.mSelectionHandlesObservers = new ObserverList<>();
    this.mContextMenuCloseListeners = new ObserverList<>();
    this.mLifetimeAssert = LifetimeAssert.create(this);
    this.mContextRef = new ImmutableWeakReference<>(context);
    this.mDisplayAndroid = display;
    display.addObserver(this);
    this.mAllowChangeRefreshRate = (Build.VERSION.SDK_INT < 29 || isTv(context)) ? false : false;
    recomputeSupportedRefreshRates();
    if (!Build.VERSION.RELEASE.equals("8.0.0")
        && ContextUtils.activityFromContext(context) != null) {
      Configuration configuration = context.getResources().getConfiguration();
      boolean isScreenWideColorGamut = ApiHelperForO.isScreenWideColorGamut(configuration);
      display.updateIsDisplayServerWideColorGamut(Boolean.valueOf(isScreenWideColorGamut));
    }
    if (Build.VERSION.SDK_INT >= 32) {
      this.mOverlayTransformApiHelper = OverlayTransformApiHelper.create(this);
    }
  }

  private static boolean isTv(Context context) {
    UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
    return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
  }

  private static long createForTesting() {
    WindowAndroid windowAndroid = new WindowAndroid(ContextUtils.getApplicationContext());
    return windowAndroid.getNativePointer();
  }

  private void clearNativePointer() {
    this.mNativeWindowAndroid = 0L;
  }

  public void setAndroidPermissionDelegate(AndroidPermissionDelegate delegate) {
    this.mPermissionDelegate = delegate;
  }

  public final IntentRequestTracker getIntentRequestTracker() {
    if (this.mIntentRequestTracker == null) {
      Log.w(
          TAG,
          "Cannot get IntentRequestTracker as the WindowAndroid is neither a ActivityWindowAndroid or a FragmentWindowAndroid.");
    }
    return this.mIntentRequestTracker;
  }

  public boolean showIntent(PendingIntent intent, IntentCallback callback, Integer errorId) {
    IntentRequestTrackerImpl intentRequestTrackerImpl = this.mIntentRequestTracker;
    if (intentRequestTrackerImpl != null) {
      return intentRequestTrackerImpl.showCancelableIntent(intent, callback, errorId) >= 0;
    }
    Log.d(TAG, "Can't show intent as context is not an Activity: " + intent, new Object[0]);
    return false;
  }

  public boolean showIntent(Intent intent, IntentCallback callback, Integer errorId) {
    IntentRequestTrackerImpl intentRequestTrackerImpl = this.mIntentRequestTracker;
    if (intentRequestTrackerImpl != null) {
      return intentRequestTrackerImpl.showCancelableIntent(intent, callback, errorId) >= 0;
    }
    Log.d(TAG, "Can't show intent as context is not an Activity: " + intent, new Object[0]);
    return false;
  }

  public int showCancelableIntent(PendingIntent intent, IntentCallback callback, Integer errorId) {
    IntentRequestTrackerImpl intentRequestTrackerImpl = this.mIntentRequestTracker;
    if (intentRequestTrackerImpl == null) {
      Log.d(TAG, "Can't show intent as context is not an Activity: " + intent, new Object[0]);
      return -1;
    }
    return intentRequestTrackerImpl.showCancelableIntent(intent, callback, errorId);
  }

  public int showCancelableIntent(Intent intent, IntentCallback callback, Integer errorId) {
    IntentRequestTrackerImpl intentRequestTrackerImpl = this.mIntentRequestTracker;
    if (intentRequestTrackerImpl == null) {
      Log.d(TAG, "Can't show intent as context is not an Activity: " + intent, new Object[0]);
      return -1;
    }
    return intentRequestTrackerImpl.showCancelableIntent(intent, callback, errorId);
  }

  public int showCancelableIntent(
      Callback<Integer> intentTrigger, IntentCallback callback, Integer errorId) {
    IntentRequestTrackerImpl intentRequestTrackerImpl = this.mIntentRequestTracker;
    if (intentRequestTrackerImpl == null) {
      Log.d(TAG, "Can't show intent as context is not an Activity", new Object[0]);
      return -1;
    }
    return intentRequestTrackerImpl.showCancelableIntent(intentTrigger, callback, errorId);
  }

  public void cancelIntent(int requestCode) {
    IntentRequestTrackerImpl intentRequestTrackerImpl = this.mIntentRequestTracker;
    if (intentRequestTrackerImpl == null) {
      Log.d(
          TAG, "Can't cancel intent as context is not an Activity: " + requestCode, new Object[0]);
    } else {
      intentRequestTrackerImpl.cancelIntent(requestCode);
    }
  }

  public boolean removeIntentCallback(IntentCallback callback) {
    IntentRequestTrackerImpl intentRequestTrackerImpl = this.mIntentRequestTracker;
    if (intentRequestTrackerImpl == null) {
      return false;
    }
    return intentRequestTrackerImpl.removeIntentCallback(callback);
  }

  @Override
  public boolean hasPermission(String permission) {
    AndroidPermissionDelegate androidPermissionDelegate = this.mPermissionDelegate;
    return androidPermissionDelegate != null
        ? androidPermissionDelegate.hasPermission(permission)
        : ApiCompatibilityUtils.checkPermission(
                ContextUtils.getApplicationContext(), permission, Process.myPid(), Process.myUid())
            == 0;
  }

  @Override
  public boolean canRequestPermission(String permission) {
    AndroidPermissionDelegate androidPermissionDelegate = this.mPermissionDelegate;
    if (androidPermissionDelegate != null) {
      return androidPermissionDelegate.canRequestPermission(permission);
    }
    Log.w(TAG, "Cannot determine the request permission state as the context is not an Activity");
    throw new AssertionError(
        "Failed to determine the request permission state using a WindowAndroid without an Activity");
  }

  @Override
  public boolean isPermissionRevokedByPolicy(String permission) {
    AndroidPermissionDelegate androidPermissionDelegate = this.mPermissionDelegate;
    if (androidPermissionDelegate != null) {
      return androidPermissionDelegate.isPermissionRevokedByPolicy(permission);
    }
    Log.w(TAG, "Cannot determine the policy permission state as the context is not an Activity");
    throw new AssertionError(
        "Failed to determine the policy permission state using a WindowAndroid without an Activity");
  }

  @Override
  public void requestPermissions(String[] permissions, PermissionCallback callback) {
    AndroidPermissionDelegate androidPermissionDelegate = this.mPermissionDelegate;
    if (androidPermissionDelegate != null) {
      androidPermissionDelegate.requestPermissions(permissions, callback);
    } else {
      Log.w(TAG, "Cannot request permissions as the context is not an Activity");
      throw new AssertionError(
          "Failed to request permissions using a WindowAndroid without an Activity");
    }
  }

  @Override
  public boolean handlePermissionResult(int requestCode, String[] permissions, int[] grantResults) {
    AndroidPermissionDelegate androidPermissionDelegate = this.mPermissionDelegate;
    if (androidPermissionDelegate != null) {
      return androidPermissionDelegate.handlePermissionResult(
          requestCode, permissions, grantResults);
    }
    return false;
  }

  @Override
  public boolean shouldShowRequestPermissionRationale(String permission) {
    AndroidPermissionDelegate androidPermissionDelegate = this.mPermissionDelegate;
    return androidPermissionDelegate != null
        && androidPermissionDelegate.shouldShowRequestPermissionRationale(permission);
  }

  public static void showError(String error) {
    if (error != null) {
      Toast.makeText(ContextUtils.getApplicationContext(), error, 0).show();
    }
  }

  public static void showError(int resId) {
    showError(ContextUtils.getApplicationContext().getString(resId));
  }

  public void sendBroadcast(Intent intent) {
    ContextUtils.getApplicationContext().sendBroadcast(intent);
  }

  public DisplayAndroid getDisplay() {
    return this.mDisplayAndroid;
  }

  public WeakReference<Activity> getActivity() {
    return NULL_ACTIVITY_WEAK_REF;
  }

  public Context getApplicationContext() {
    return ContextUtils.getApplicationContext();
  }

  public void onVisibilityChanged(boolean visible) {
    if (this.mNativeWindowAndroid == 0) {
      return;
    }
    WindowAndroidJni.get().onVisibilityChanged(this.mNativeWindowAndroid, this, visible);
  }

  public void onActivityStopped() {
    if (this.mNativeWindowAndroid == 0) {
      return;
    }
    WindowAndroidJni.get().onActivityStopped(this.mNativeWindowAndroid, this);
  }

  public void onActivityStarted() {
    if (this.mNativeWindowAndroid == 0) {
      return;
    }
    WindowAndroidJni.get().onActivityStarted(this.mNativeWindowAndroid, this);
  }

  public void onActivityPaused() {
    Iterator<ActivityStateObserver> it = this.mActivityStateObservers.iterator();
    while (it.hasNext()) {
      ActivityStateObserver observer = it.next();
      observer.onActivityPaused();
    }
  }

  public void onActivityResumed() {
    Iterator<ActivityStateObserver> it = this.mActivityStateObservers.iterator();
    while (it.hasNext()) {
      ActivityStateObserver observer = it.next();
      observer.onActivityResumed();
    }
  }

  public void onActivityDestroyed() {
    Iterator<ActivityStateObserver> it = this.mActivityStateObservers.iterator();
    while (it.hasNext()) {
      ActivityStateObserver observer = it.next();
      observer.onActivityDestroyed();
    }
  }

  public void addActivityStateObserver(ActivityStateObserver observer) {
    if (this.mActivityStateObservers.hasObserver(observer)) {
      throw new AssertionError();
    }
    this.mActivityStateObservers.addObserver(observer);
  }

  public void removeActivityStateObserver(ActivityStateObserver observer) {
    if (!this.mActivityStateObservers.hasObserver(observer)) {
      throw new AssertionError();
    }
    this.mActivityStateObservers.removeObserver(observer);
  }

  public void addSelectionHandlesObserver(SelectionHandlesObserver observer) {
    if (this.mSelectionHandlesObservers.hasObserver(observer)) {
      throw new AssertionError();
    }
    this.mSelectionHandlesObservers.addObserver(observer);
    observer.onSelectionHandlesStateChanged(this.mSelectionHandlesActive);
  }

  public void removeSelectionHandlesObserver(SelectionHandlesObserver observer) {
    if (!this.mSelectionHandlesObservers.hasObserver(observer)) {
      throw new AssertionError();
    }
    this.mSelectionHandlesObservers.removeObserver(observer);
  }

  private void onSelectionHandlesStateChanged(boolean active) {
    this.mSelectionHandlesActive = active;
    Iterator<SelectionHandlesObserver> it = this.mSelectionHandlesObservers.iterator();
    while (it.hasNext()) {
      SelectionHandlesObserver observer = it.next();
      observer.onSelectionHandlesStateChanged(active);
    }
  }

  public int getActivityState() {
    return 6;
  }

  public boolean canResolveActivity(Intent intent) {
    return PackageManagerUtils.canResolveActivity(intent);
  }

  public ModalDialogManager getModalDialogManager() {
    return null;
  }

  public boolean isDestroyed() {
    return this.mIsDestroyed;
  }

  public void destroy() {
    OverlayTransformApiHelper overlayTransformApiHelper;
    LifetimeAssert.setSafeToGc(this.mLifetimeAssert, true);
    this.mIsDestroyed = true;
    if (this.mNativeWindowAndroid != 0) {
      WindowAndroidJni.get().destroy(this.mNativeWindowAndroid, this);
    }
    this.mUnownedUserDataHost.destroy();
    this.mApplicationBottomInsetSupplier.destroy();
    if (Build.VERSION.SDK_INT >= 32
        && (overlayTransformApiHelper = this.mOverlayTransformApiHelper) != null) {
      overlayTransformApiHelper.destroy();
    }
  }

  private long getNativePointer() {
    if (this.mNativeWindowAndroid == 0) {
      this.mNativeWindowAndroid =
          WindowAndroidJni.get()
              .init(
                  this,
                  this.mDisplayAndroid.getDisplayId(),
                  getMouseWheelScrollFactor(),
                  getWindowIsWideColorGamut());
      WindowAndroidJni.get().setVSyncPaused(this.mNativeWindowAndroid, this, this.mVSyncPaused);
    }
    return this.mNativeWindowAndroid;
  }

  private float getMouseWheelScrollFactor() {
    TypedValue outValue = new TypedValue();
    Context context = getContext().get();
    if (context != null && context.getTheme().resolveAttribute(16842829, outValue, true)) {
      return outValue.getDimension(context.getResources().getDisplayMetrics());
    }
    return 0.0f;
  }

  public Window getWindow() {
    Activity activity = ContextUtils.activityFromContext((Context) this.mContextRef.get());
    if (activity == null || activity.isFinishing()) {
      return null;
    }
    return activity.getWindow();
  }

  private boolean getWindowIsWideColorGamut() {
    Window window;
    if (Build.VERSION.SDK_INT >= 29 && (window = getWindow()) != null) {
      return ApiHelperForOMR1.isWideColorGamut(window);
    }
    return false;
  }

  public void setAnimationPlaceholderView(View view) {
    this.mAnimationPlaceholderView = view;
  }

  public KeyboardVisibilityDelegate getKeyboardDelegate() {
    return this.mKeyboardVisibilityDelegate;
  }

  public ApplicationViewportInsetSupplier getApplicationBottomInsetSupplier() {
    return this.mApplicationBottomInsetSupplier;
  }

  public void setKeyboardDelegate(KeyboardVisibilityDelegate keyboardDelegate) {
    this.mKeyboardVisibilityDelegate = keyboardDelegate;
    KeyboardVisibilityDelegate.setInstance(keyboardDelegate);
  }

  public void addContextMenuCloseListener(OnCloseContextMenuListener listener) {
    this.mContextMenuCloseListeners.addObserver(listener);
  }

  public void removeContextMenuCloseListener(OnCloseContextMenuListener listener) {
    this.mContextMenuCloseListeners.removeObserver(listener);
  }

  public void onContextMenuClosed() {
    Iterator<OnCloseContextMenuListener> it = this.mContextMenuCloseListeners.iterator();
    while (it.hasNext()) {
      OnCloseContextMenuListener listener = it.next();
      listener.onContextMenuClosed();
    }
  }

  public void startAnimationOverContent(Animator animation) {
    if (this.mAnimationPlaceholderView == null) {
      return;
    }
    if (animation.isStarted()) {
      throw new IllegalArgumentException("Already started.");
    }
    boolean added = this.mAnimationsOverContent.add(animation);
    if (!added) {
      throw new IllegalArgumentException("Already Added.");
    }
    animation.start();
    if (this.mAnimationPlaceholderView.willNotDraw()) {
      this.mAnimationPlaceholderView.setWillNotDraw(false);
    }
    animation.addListener(
        new AnimatorListenerAdapter() {
          @Override
          public void onAnimationEnd(Animator animation2) {
            animation2.removeListener(this);
            WindowAndroid.this.mAnimationsOverContent.remove(animation2);
            if (WindowAndroid.this.mAnimationsOverContent.isEmpty()) {
              WindowAndroid.this.mAnimationPlaceholderView.setWillNotDraw(true);
            }
          }
        });
  }

  public WeakReference<Context> getContext() {
    return this.mContextRef;
  }

  public IBinder getWindowToken() {
    View decorView;
    Window window = getWindow();
    if (window == null || (decorView = window.peekDecorView()) == null) {
      return null;
    }
    return decorView.getWindowToken();
  }

  public boolean haveAnimationsEnded() {
    return this.mAnimationsOverContent.isEmpty();
  }

  public void setVSyncPaused(boolean paused) {
    if (this.mVSyncPaused == paused) {
      return;
    }
    this.mVSyncPaused = paused;
    if (this.mNativeWindowAndroid != 0) {
      WindowAndroidJni.get().setVSyncPaused(this.mNativeWindowAndroid, this, paused);
    }
  }

  @Override
  public void onRefreshRateChanged(float refreshRate) {
    if (this.mNativeWindowAndroid != 0) {
      WindowAndroidJni.get().onUpdateRefreshRate(this.mNativeWindowAndroid, this, refreshRate);
    }
  }

  public void onWindowFocusChanged(boolean hasFocus) {
    this.mHasFocus = hasFocus;
    if (!hasFocus) {
      doSetPreferredRefreshRate(0.0f);
    } else {
      doSetPreferredRefreshRate(this.mRefreshRate);
    }
  }

  @Override
  public void onCurrentModeChanged(Display.Mode currentMode) {
    recomputeSupportedRefreshRates();
  }

  @Override
  public void onDisplayModesChanged(List<Display.Mode> supportedModes) {
    recomputeSupportedRefreshRates();
  }

  public void setWideColorEnabled(boolean enabled) {
    int colorMode;
    if (Build.VERSION.SDK_INT < 29) {
      if (enabled) {
        throw new AssertionError();
      }
      return;
    }
    Window window = getWindow();
    if (window == null) {
      return;
    }
    if (enabled) {
      colorMode = 1;
    } else {
      colorMode = 0;
    }
    ApiHelperForO.setColorMode(window, colorMode);
  }

  private void recomputeSupportedRefreshRates() {
    Display.Mode currentMode = this.mDisplayAndroid.getCurrentMode();
    List<Display.Mode> supportedModes = this.mDisplayAndroid.getSupportedModes();
    if (currentMode == null || supportedModes == null || supportedModes.size() == 0) {
      return;
    }
    List<Display.Mode> supportedRefreshRateModes = new ArrayList<>();
    for (int i = 0; i < supportedModes.size(); i++) {
      if (currentMode.equals(supportedModes.get(i))) {
        supportedRefreshRateModes.add(supportedModes.get(i));
      } else if (currentMode.getPhysicalWidth() == supportedModes.get(i).getPhysicalWidth()
          && currentMode.getPhysicalHeight() == supportedModes.get(i).getPhysicalHeight()
          && currentMode.getRefreshRate() != supportedModes.get(i).getRefreshRate()) {
        supportedRefreshRateModes.add(supportedModes.get(i));
      }
    }
    boolean changed = !supportedRefreshRateModes.equals(this.mSupportedRefreshRateModes);
    if (changed) {
      this.mSupportedRefreshRateModes = supportedRefreshRateModes;
      if (this.mNativeWindowAndroid != 0) {
        WindowAndroidJni.get()
            .onSupportedRefreshRatesUpdated(
                this.mNativeWindowAndroid, this, getSupportedRefreshRates());
      }
    }
  }

  private float getRefreshRate() {
    return this.mDisplayAndroid.getRefreshRate();
  }

  private float[] getSupportedRefreshRates() {
    List<Display.Mode> list = this.mSupportedRefreshRateModes;
    if (list == null || !this.mAllowChangeRefreshRate) {
      return null;
    }
    float[] supportedRefreshRates = new float[list.size()];
    for (int i = 0; i < this.mSupportedRefreshRateModes.size(); i++) {
      supportedRefreshRates[i] = this.mSupportedRefreshRateModes.get(i).getRefreshRate();
    }
    return supportedRefreshRates;
  }

  private void setPreferredRefreshRate(float preferredRefreshRate) {
    this.mRefreshRate = preferredRefreshRate;
    if (this.mHasFocus) {
      doSetPreferredRefreshRate(preferredRefreshRate);
    }
  }

  private void doSetPreferredRefreshRate(float preferredRefreshRate) {
    if (this.mSupportedRefreshRateModes == null || !this.mAllowChangeRefreshRate) {
      return;
    }
    int preferredModeId = getPreferredModeId(preferredRefreshRate);
    Window window = getWindow();
    if (window == null) {
      return;
    }
    WindowManager.LayoutParams params = window.getAttributes();
    if (params.preferredDisplayModeId == preferredModeId) {
      return;
    }
    params.preferredDisplayModeId = preferredModeId;
    window.setAttributes(params);
  }

  private int getPreferredModeId(float preferredRefreshRate) {
    if (preferredRefreshRate == 0.0f) {
      return 0;
    }
    Display.Mode preferredMode = null;
    float preferredModeDelta = Float.MAX_VALUE;
    for (int i = 0; i < this.mSupportedRefreshRateModes.size(); i++) {
      Display.Mode mode = this.mSupportedRefreshRateModes.get(i);
      float delta = Math.abs(preferredRefreshRate - mode.getRefreshRate());
      if (delta < preferredModeDelta) {
        preferredModeDelta = delta;
        preferredMode = mode;
      }
    }
    if (preferredModeDelta > MAX_REFRESH_RATE_DELTA) {
      Log.e(TAG, "Refresh rate not supported : " + preferredRefreshRate);
      return 0;
    }
    return preferredMode.getModeId();
  }

  public UnownedUserDataHost getUnownedUserDataHost() {
    return this.mUnownedUserDataHost;
  }

  public void onOverlayTransformUpdated() {
    if (this.mNativeWindowAndroid != 0) {
      WindowAndroidJni.get().onOverlayTransformUpdated(this.mNativeWindowAndroid, this);
    }
  }

  private int getOverlayTransform() {
    OverlayTransformApiHelper overlayTransformApiHelper;
    int overlayTransform = 0;
    if (Build.VERSION.SDK_INT >= 32
        && (overlayTransformApiHelper = this.mOverlayTransformApiHelper) != null) {
      overlayTransform = overlayTransformApiHelper.getOverlayTransform();
    }
    if (overlayTransform == 0) {
      switch (this.mDisplayAndroid.getRotation()) {
        case 0:
          return 1;
        case 1:
          return 4;
        case 2:
          return 5;
        case 3:
          return 6;
        default:
          return 1;
      }
    }
    return overlayTransform;
  }

  public void setUnfoldLatencyBeginTime(long beginTimestampMs) {
    TraceEvent e = TraceEvent.scoped("setUnfoldLatencyBeginTime");
    try {
      if (this.mNativeWindowAndroid != 0) {
        WindowAndroidJni.get()
            .sendUnfoldLatencyBeginTimestamp(this.mNativeWindowAndroid, beginTimestampMs);
      }
      if (e != null) {
        e.close();
      }
    } catch (Throwable th) {
      if (e != null) {
        try {
          e.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
      }
      throw th;
    }
  }
}
