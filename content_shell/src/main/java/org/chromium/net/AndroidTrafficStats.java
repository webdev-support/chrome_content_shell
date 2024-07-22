package org.chromium.net;

import android.net.TrafficStats;
import android.os.Process;
import org.jni_zero.JNINamespace;

@JNINamespace("net::android::traffic_stats")
public class AndroidTrafficStats {
  private AndroidTrafficStats() {}

  private static long getTotalTxBytes() {
    long bytes = TrafficStats.getTotalTxBytes();
    if (bytes != -1) {
      return bytes;
    }
    return 0L;
  }

  private static long getTotalRxBytes() {
    long bytes = TrafficStats.getTotalRxBytes();
    if (bytes != -1) {
      return bytes;
    }
    return 0L;
  }

  private static long getCurrentUidTxBytes() {
    long bytes = TrafficStats.getUidTxBytes(Process.myUid());
    if (bytes != -1) {
      return bytes;
    }
    return 0L;
  }

  private static long getCurrentUidRxBytes() {
    long bytes = TrafficStats.getUidRxBytes(Process.myUid());
    if (bytes != -1) {
      return bytes;
    }
    return 0L;
  }
}
