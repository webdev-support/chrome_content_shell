package org.chromium.base.process_launcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import java.util.concurrent.Executor;
import org.chromium.base.Log;
import org.chromium.base.TraceEvent;
import org.chromium.base.compat.ApiHelperForQ;

class ChildServiceConnectionImpl implements ChildServiceConnection, ServiceConnection {
  private static final String TAG = "ChildServiceConn";
  private final int mBindFlags;
  private final Intent mBindIntent;
  private boolean mBound;
  private final Context mContext;
  private ChildServiceConnectionDelegate mDelegate;
  private final Executor mExecutor;
  private final Handler mHandler;
  private final String mInstanceName;

  public ChildServiceConnectionImpl(
      Context context,
      Intent bindIntent,
      int bindFlags,
      Handler handler,
      Executor executor,
      ChildServiceConnectionDelegate delegate,
      String instanceName) {
    this.mContext = context;
    this.mBindIntent = bindIntent;
    this.mBindFlags = bindFlags;
    this.mHandler = handler;
    this.mExecutor = executor;
    this.mDelegate = delegate;
    this.mInstanceName = instanceName;
  }

  @Override
  public boolean bindServiceConnection() {
    try {
      TraceEvent.begin("ChildServiceConnectionImpl.bindServiceConnection");
      this.mBound =
          BindService.doBindService(
              this.mContext,
              this.mBindIntent,
              this,
              this.mBindFlags,
              this.mHandler,
              this.mExecutor,
              this.mInstanceName);
      TraceEvent.end("ChildServiceConnectionImpl.bindServiceConnection");
      return this.mBound;
    } catch (Throwable th) {
      TraceEvent.end("ChildServiceConnectionImpl.bindServiceConnection");
      throw th;
    }
  }

  @Override
  public void unbindServiceConnection() {
    if (this.mBound) {
      this.mContext.unbindService(this);
      this.mBound = false;
    }
  }

  @Override
  public boolean isBound() {
    return this.mBound;
  }

  @Override
  public void updateGroupImportance(int group, int importanceInGroup) {
    if (isBound() && BindService.supportVariableConnections()) {
      try {
        ApiHelperForQ.updateServiceGroup(this.mContext, this, group, importanceInGroup);
        BindService.doBindService(
            this.mContext,
            this.mBindIntent,
            this,
            this.mBindFlags,
            this.mHandler,
            this.mExecutor,
            this.mInstanceName);
      } catch (IllegalArgumentException e) {
      }
    }
  }

  @Override
  public void retire() {
    this.mDelegate = null;
    unbindServiceConnection();
  }

  @Override // android.content.ServiceConnection
  public void onServiceConnected(ComponentName className, IBinder service) {
    ChildServiceConnectionDelegate childServiceConnectionDelegate = this.mDelegate;
    if (childServiceConnectionDelegate == null) {
      Log.w(TAG, "onServiceConnected after timeout " + className);
    } else {
      childServiceConnectionDelegate.onServiceConnected(service);
    }
  }

  @Override // android.content.ServiceConnection
  public void onServiceDisconnected(ComponentName className) {
    ChildServiceConnectionDelegate childServiceConnectionDelegate = this.mDelegate;
    if (childServiceConnectionDelegate != null) {
      childServiceConnectionDelegate.onServiceDisconnected();
    }
  }
}
