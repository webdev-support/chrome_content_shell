package org.chromium.base;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.IOException;
import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public class ApkAssets {
  private static final String TAG = "ApkAssets";
  private static String sLastError;

  public static long[] open(String fileName, String splitName) {
    sLastError = null;
    AssetFileDescriptor afd = null;
    try {
      try {
        Context context = ContextUtils.getApplicationContext();
        if (!TextUtils.isEmpty(splitName) && BundleUtils.isIsolatedSplitInstalled(splitName)) {
          context = BundleUtils.createIsolatedSplitContext(context, splitName);
        }
        AssetManager manager = context.getAssets();
        afd = manager.openNonAssetFd(fileName);
        long[] jArr = {
          afd.getParcelFileDescriptor().detachFd(), afd.getStartOffset(), afd.getLength()
        };
        if (afd != null) {
          try {
            afd.close();
          } catch (IOException e2) {
            Log.e(TAG, "Unable to close AssetFileDescriptor", (Throwable) e2);
          }
        }
        return jArr;
      } catch (IOException e) {
        sLastError = "Error while loading asset " + fileName + " from " + splitName + ": " + e;
        if (!e.getMessage().equals("") && !e.getMessage().equals(fileName)) {
          Log.e(TAG, sLastError);
        }
        long[] jArr2 = {-1, -1, -1};
        if (afd != null) {
          try {
            afd.close();
          } catch (IOException e22) {
            Log.e(TAG, "Unable to close AssetFileDescriptor", (Throwable) e22);
          }
        }
        return jArr2;
      }
    } catch (Throwable th) {
      if (afd != null) {
        try {
          afd.close();
        } catch (IOException e23) {
          Log.e(TAG, "Unable to close AssetFileDescriptor", (Throwable) e23);
        }
      }
      throw th;
    }
  }

  private static String takeLastErrorString() {
    String rv = sLastError;
    sLastError = null;
    return rv;
  }
}
