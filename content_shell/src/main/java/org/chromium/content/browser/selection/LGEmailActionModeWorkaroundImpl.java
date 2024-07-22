package org.chromium.content.browser.selection;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.base.Log;
import org.chromium.base.PackageUtils;
import org.chromium.base.task.PostTask;

public final class LGEmailActionModeWorkaroundImpl {
  public static final int LGEmailWorkaroundMaxVersion = 67502100;
  private static final String TAG = "Ime";

  private LGEmailActionModeWorkaroundImpl() {}

  public static boolean isSafeVersion(int versionCode) {
    return versionCode > 67502100;
  }

  public static void runIfNecessary(Context context, ActionMode actionMode) {
    if (shouldAllowActionModeDestroyOnNonUiThread(context)) {
      allowActionModeDestroyOnNonUiThread(actionMode);
    }
  }

  private static boolean shouldAllowActionModeDestroyOnNonUiThread(Context context) {
    int appTargetSdkVersion;
    String appName = context.getPackageName();
    int versionCode = PackageUtils.getPackageVersion(appName);
    if (versionCode != -1
        && (appTargetSdkVersion = context.getApplicationInfo().targetSdkVersion) >= 23
        && appTargetSdkVersion <= 24
        && "com.lge.email".equals(appName)
        && versionCode <= 67502100) {
      Log.w(
          TAG,
          "Working around action mode LG Email bug in WebView (http://crbug.com/651706). APK name: com.lge.email, versionCode: "
              + versionCode);
      return true;
    }
    return false;
  }

  private static void allowActionModeDestroyOnNonUiThread(ActionMode actionMode) {
    try {
      final ActionMode.Callback2 c = (ActionMode.Callback2) getField(actionMode, "mCallback");
      setField(
          actionMode,
          "mCallback",
          new ActionMode.Callback2() {
            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
              return c.onCreateActionMode(mode, menu);
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
              return c.onPrepareActionMode(mode, menu);
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
              return c.onActionItemClicked(mode, item);
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(final ActionMode mode) {
              PostTask.postTask(
                  7,
                  new Runnable() {
                    @Override
                    public void run() {
                      c.onDestroyActionMode(mode);
                    }
                  });
            }
          });
      Object floatingToolbar = getField(actionMode, "mFloatingToolbar");
      Object popup = getField(floatingToolbar, "mPopup");
      final ViewGroup contentContainer = (ViewGroup) getField(popup, "mContentContainer");
      final PopupWindow popupWindow = (PopupWindow) getField(popup, "mPopupWindow");
      Method createExitAnimation =
          floatingToolbar
              .getClass()
              .getDeclaredMethod(
                  "createExitAnimation", View.class, Integer.TYPE, Animator.AnimatorListener.class);
      createExitAnimation.setAccessible(true);
      Object newDismissAnimation =
          createExitAnimation.invoke(
              null,
              contentContainer,
              150,
              new AnimatorListenerAdapter() {
                @Override // android.animation.AnimatorListenerAdapter,
                // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                  PostTask.postTask(
                      7,
                      new Runnable() {
                        @Override
                        public void run() {
                          popupWindow.dismiss();
                          contentContainer.removeAllViews();
                        }
                      });
                }
              });
      setField(popup, "mDismissAnimation", newDismissAnimation);
    } catch (IllegalAccessException e) {
    } catch (IllegalArgumentException e2) {
    } catch (NoSuchFieldException e3) {
    } catch (NoSuchMethodException e4) {
    } catch (InvocationTargetException e5) {
    } catch (Exception e6) {
      Log.w(TAG, "Error occurred during LGEmailActionModeWorkaround: ", (Throwable) e6);
    }
  }

  private static Object getField(Object obj, String fieldName)
      throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
    Field f = obj.getClass().getDeclaredField(fieldName);
    f.setAccessible(true);
    return f.get(obj);
  }

  private static void setField(Object obj, String fieldName, Object value)
      throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException {
    Field f = obj.getClass().getDeclaredField(fieldName);
    f.setAccessible(true);
    f.set(obj, value);
  }
}
