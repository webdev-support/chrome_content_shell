package org.chromium.base;

import android.os.Process;
import java.util.HashMap;

public final class UserDataHost {
  private final long mThreadId = Process.myTid();
  private HashMap<Class<? extends UserData>, UserData> mUserDataMap = new HashMap<>();

  private static void checkArgument(boolean condition) {
    if (!condition) {
      throw new IllegalArgumentException("Neither key nor object of UserDataHost can be null.");
    }
  }

  private void checkThreadAndState() {
    if (this.mThreadId != Process.myTid()) {
      throw new IllegalStateException("UserData must only be used on a single thread.");
    }
    if (this.mUserDataMap == null) {
      throw new IllegalStateException("Operation is not allowed after destroy().");
    }
  }

  public <T extends UserData> T setUserData(Class<T> key, T object) {
    checkThreadAndState();
    checkArgument((key == null || object == null) ? false : true);
    this.mUserDataMap.put(key, object);
    return (T) getUserData(key);
  }

  public <T extends UserData> T getUserData(Class<T> key) {
    checkThreadAndState();
    checkArgument(key != null);
    return key.cast(this.mUserDataMap.get(key));
  }

  public <T extends UserData> T removeUserData(Class<T> key) {
    checkThreadAndState();
    checkArgument(key != null);
    if (!this.mUserDataMap.containsKey(key)) {
      throw new IllegalStateException("UserData for the key is not present.");
    }
    return key.cast(this.mUserDataMap.remove(key));
  }

  public void destroy() {
    checkThreadAndState();
    HashMap<Class<? extends UserData>, UserData> map = this.mUserDataMap;
    this.mUserDataMap = null;
    for (UserData userData : map.values()) {
      userData.destroy();
    }
  }
}
