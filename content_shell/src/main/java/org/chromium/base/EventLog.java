package org.chromium.base;

import org.jni_zero.JNINamespace;

@JNINamespace("base::android")
public class EventLog {
  public static void writeEvent(int tag, int value) {
    android.util.EventLog.writeEvent(tag, value);
  }
}
