package org.chromium.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import org.chromium.base.StrictModeContext;

public class LayoutInflaterUtils {
  public static View inflate(Context context, int resource, ViewGroup root) {
    return inflate(context, resource, root, root != null);
  }

  public static View inflate(Context context, int resource, ViewGroup root, boolean attachToRoot) {
    return inflateImpl(LayoutInflater.from(context), resource, root, attachToRoot);
  }

  public static View inflate(Window window, int resource, ViewGroup root) {
    return inflate(window, resource, root, root != null);
  }

  public static View inflate(Window window, int resource, ViewGroup root, boolean attachToRoot) {
    return inflateImpl(window.getLayoutInflater(), resource, root, attachToRoot);
  }

  public static View inflate(LayoutInflater layoutInflater, int resource, ViewGroup root) {
    return inflateImpl(layoutInflater, resource, root, root != null);
  }

  private static View inflateImpl(
      LayoutInflater inflater, int resource, ViewGroup root, boolean attachToRoot) {
    StrictModeContext ignored = StrictModeContext.allowDiskReads();
    try {
      View inflate = inflater.inflate(resource, root, attachToRoot);
      if (ignored != null) {
        ignored.close();
      }
      return inflate;
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
}
