package org.chromium.base.process_launcher;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.os.UserHandle;
import com.example.chromium_content_view.BuildConfig;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import org.chromium.base.compat.ApiHelperForQ;

final class BindService {
  private static Method sBindServiceAsUserMethod;

  public static boolean supportVariableConnections() {
    return Build.VERSION.SDK_INT >= 29 && !BuildConfig.IS_INCREMENTAL_INSTALL;
  }

  public static boolean doBindService(
      Context context,
      Intent intent,
      ServiceConnection connection,
      int flags,
      Handler handler,
      Executor executor,
      String instanceName) {
    if (supportVariableConnections() && instanceName != null) {
      return ApiHelperForQ.bindIsolatedService(
          context, intent, flags, instanceName, executor, connection);
    }
    try {
      return bindServiceByReflection(context, intent, connection, flags, handler);
    } catch (ReflectiveOperationException reflectionException) {
      try {
        return bindServiceByCall(context, intent, connection, flags);
      } catch (RuntimeException runtimeException) {
        throw new RuntimeException(runtimeException.getMessage(), reflectionException);
      }
    }
  }

  private static boolean bindServiceByCall(
      Context context, Intent intent, ServiceConnection connection, int flags) {
    return context.bindService(intent, connection, flags);
  }

  private static boolean bindServiceByReflection(
      Context context, Intent intent, ServiceConnection connection, int flags, Handler handler)
      throws ReflectiveOperationException {
    if (sBindServiceAsUserMethod == null) {
      sBindServiceAsUserMethod =
          Context.class.getDeclaredMethod(
              "bindServiceAsUser",
              Intent.class,
              ServiceConnection.class,
              Integer.TYPE,
              Handler.class,
              UserHandle.class);
    }
    while (context instanceof ContextWrapper) {
      context = ((ContextWrapper) context).getBaseContext();
    }
    return ((Boolean)
            sBindServiceAsUserMethod.invoke(
                context,
                intent,
                connection,
                Integer.valueOf(flags),
                handler,
                Process.myUserHandle()))
        .booleanValue();
  }

  private BindService() {}
}
