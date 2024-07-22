package org.chromium.content.browser.remoteobjects;

import android.os.Process;
import android.util.EventLog;

final class RemoteObjectAuditorImpl implements RemoteObjectImpl.Auditor {
  private static final int sObjectGetClassInvocationAttemptLogTag = 70151;

  @Override
  public void onObjectGetClassInvocationAttempt() {
    EventLog.writeEvent((int) sObjectGetClassInvocationAttemptLogTag, Process.myUid());
  }
}
