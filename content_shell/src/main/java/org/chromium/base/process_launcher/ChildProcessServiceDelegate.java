package org.chromium.base.process_launcher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import java.util.List;

public interface ChildProcessServiceDelegate {
  void consumeRelroBundle(Bundle bundle);

  SparseArray<String> getFileDescriptorsIdsToKeys();

  void loadNativeLibrary(Context context);

  void onBeforeMain();

  void onConnectionSetup(Bundle bundle, List<IBinder> list);

  void onServiceBound(Intent intent);

  void onServiceCreated();

  void preloadNativeLibrary(String str);

  void runMain();
}
