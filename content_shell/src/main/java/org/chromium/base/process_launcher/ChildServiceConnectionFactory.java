package org.chromium.base.process_launcher;

import android.content.Intent;

interface ChildServiceConnectionFactory {
  ChildServiceConnection createConnection(
      Intent intent,
      int i,
      ChildServiceConnectionDelegate childServiceConnectionDelegate,
      String str);
}
