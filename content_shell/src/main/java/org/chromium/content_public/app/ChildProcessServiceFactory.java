package org.chromium.content_public.app;

import android.app.Service;
import android.content.Context;
import org.chromium.base.process_launcher.ChildProcessService;
import org.chromium.content.app.ContentChildProcessServiceDelegate;

public class ChildProcessServiceFactory {
  public static ChildProcessService create(Service service, Context context) {
    return new ChildProcessService(new ContentChildProcessServiceDelegate(), service, context);
  }

  private ChildProcessServiceFactory() {}
}
