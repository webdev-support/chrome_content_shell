package org.chromium.components.crash;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.chromium.base.ThreadUtils;

public class CrashKeys {

  private static final String[] KEYS = {
    "loaded_dynamic_module",
    "active_dynamic_module",
    "application_status",
    "installed_modules",
    "emulated_modules",
    "dynamic_module_dex_name",
    "partner_customization_config",
    "first_run"
  };
  private boolean mFlushed;
  private final AtomicReferenceArray<String> mValues;

  public interface Natives {
    void set(CrashKeys crashKeys, int i, String str);
  }

  private static class Holder {
    static final CrashKeys INSTANCE = new CrashKeys();

    private Holder() {}
  }

  private CrashKeys() {
    String[] strArr = KEYS;
    this.mValues = new AtomicReferenceArray<>(strArr.length);
    if (8 != strArr.length) {
      throw new AssertionError();
    }
  }

  public static CrashKeys getInstance() {
    return Holder.INSTANCE;
  }

  public static String getKey(int keyIndex) {
    return KEYS[keyIndex];
  }

  public AtomicReferenceArray<String> getValues() {
    if (this.mFlushed) {
      throw new AssertionError("Getting Java CrashKeys after the keys were flushed to native");
    }
    return this.mValues;
  }

  public void set(int keyIndex, String value) {
    ThreadUtils.assertOnUiThread();
    if (this.mFlushed) {
      CrashKeysJni.get().set(this, keyIndex, value);
    } else {
      this.mValues.set(keyIndex, value);
    }
  }

  public void flushToNative() {
    ThreadUtils.assertOnUiThread();
    if (this.mFlushed) {
      throw new AssertionError("Tried to flush to native twice");
    }
    for (int i = 0; i < this.mValues.length(); i++) {
      CrashKeysJni.get().set(this, i, this.mValues.getAndSet(i, null));
    }
    this.mFlushed = true;
  }
}
