package org.chromium.content.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import org.chromium.base.process_launcher.ChildProcessService;
import org.chromium.content_public.app.ChildProcessServiceFactory;

public class ContentChildProcessService extends Service {
  private ChildProcessService mService;

  @Override // android.app.Service
  public void onCreate() {
    super.onCreate();
    ChildProcessService create = ChildProcessServiceFactory.create(this, getApplicationContext());
    this.mService = create;
    create.onCreate();
  }

  @Override // android.app.Service
  public void onDestroy() {
    super.onDestroy();
    this.mService.onDestroy();
    this.mService = null;
  }

  @Override // android.app.Service
  public IBinder onBind(Intent intent) {
    return this.mService.onBind(intent);
  }
}
