package org.chromium.base;

import com.example.chromium_content_view.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

public final class UnownedUserDataKey<T extends UnownedUserData> {

  private final Class<T> mClazz;
  private final Set<UnownedUserDataHost> mWeakHostAttachments =
      Collections.newSetFromMap(new WeakHashMap());

  public UnownedUserDataKey(Class<T> clazz) {
    this.mClazz = clazz;
  }

  public final Class<T> getValueClass() {
    return this.mClazz;
  }

  public final void attachToHost(UnownedUserDataHost host, T object) {
    Objects.requireNonNull(object);
    host.set(this, object);
    if (!isAttachedToHost(host)) {
      this.mWeakHostAttachments.add(host);
    }
  }

  public final T retrieveDataFromHost(UnownedUserDataHost host) {
    assertNoDestroyedAttachments();
    for (UnownedUserDataHost attachedHost : this.mWeakHostAttachments) {
      if (host.equals(attachedHost)) {
        return (T) host.get(this);
      }
    }
    return null;
  }

  public final void detachFromHost(UnownedUserDataHost host) {
    assertNoDestroyedAttachments();
    Iterator it = new ArrayList(this.mWeakHostAttachments).iterator();
    while (it.hasNext()) {
      UnownedUserDataHost attachedHost = (UnownedUserDataHost) it.next();
      if (host.equals(attachedHost)) {
        removeHostAttachment(attachedHost);
      }
    }
  }

  public final void detachFromAllHosts(T object) {
    assertNoDestroyedAttachments();
    Iterator it = new ArrayList(this.mWeakHostAttachments).iterator();
    while (it.hasNext()) {
      UnownedUserDataHost attachedHost = (UnownedUserDataHost) it.next();
      if (object.equals(attachedHost.get(this))) {
        removeHostAttachment(attachedHost);
      }
    }
  }

  public final boolean isAttachedToHost(UnownedUserDataHost host) {
    T t = retrieveDataFromHost(host);
    return t != null;
  }

  public final boolean isAttachedToAnyHost(T object) {
    return getHostAttachmentCount(object) > 0;
  }

  int getHostAttachmentCount(T object) {
    assertNoDestroyedAttachments();
    int ret = 0;
    for (UnownedUserDataHost attachedHost : this.mWeakHostAttachments) {
      if (object.equals(attachedHost.get(this))) {
        ret++;
      }
    }
    return ret;
  }

  private void removeHostAttachment(UnownedUserDataHost host) {
    host.remove(this);
    this.mWeakHostAttachments.remove(host);
  }

  private void assertNoDestroyedAttachments() {
    if (BuildConfig.ENABLE_ASSERTS) {
      for (UnownedUserDataHost attachedHost : this.mWeakHostAttachments) {
        if (attachedHost.isDestroyed()) {
          throw new AssertionError("Host should have been removed already.");
        }
      }
    }
  }
}
