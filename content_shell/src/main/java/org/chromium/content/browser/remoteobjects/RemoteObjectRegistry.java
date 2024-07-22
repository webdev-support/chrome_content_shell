package org.chromium.content.browser.remoteobjects;

import android.util.SparseArray;
import java.lang.annotation.Annotation;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

final class RemoteObjectRegistry implements RemoteObjectImpl.ObjectIdAllocator {

  private final SparseArray<Entry> mEntriesById = new SparseArray<>();
  private final Map<Object, Entry> mEntriesByObject = new IdentityHashMap();
  private int mNextId;
  private final Set<? super RemoteObjectRegistry> mRetainingSet;

  public static class Entry {

    public final int f550id;
    public final Object object;
    public int referenceCount = 1;
    public Class<? extends Annotation> safeAnnotationClass;

    Entry(int id, Object object, Class<? extends Annotation> safeAnnotationClass) {
      this.f550id = id;
      this.object = object;
      this.safeAnnotationClass = safeAnnotationClass;
    }
  }

  public RemoteObjectRegistry(Set<? super RemoteObjectRegistry> retainingSet) {
    retainingSet.add(this);
    this.mRetainingSet = retainingSet;
  }

  public void close() {
    boolean removed = this.mRetainingSet.remove(this);
    if (!removed) {
      throw new AssertionError();
    }
  }

  public synchronized Class<? extends Annotation> getSafeAnnotationClass(Object object) {
    Entry entry;
    entry = this.mEntriesByObject.get(object);
    return entry != null ? entry.safeAnnotationClass : null;
  }

  @Override
  public synchronized int getObjectId(
      Object object, Class<? extends Annotation> safeAnnotationClass) {
    Entry entry = this.mEntriesByObject.get(object);
    if (entry != null) {
      entry.referenceCount++;
      return entry.f550id;
    }
    int newId = this.mNextId;
    this.mNextId = newId + 1;
    if (newId < 0) {
      throw new AssertionError();
    }
    Entry entry2 = new Entry(newId, object, safeAnnotationClass);
    this.mEntriesById.put(newId, entry2);
    this.mEntriesByObject.put(object, entry2);
    return newId;
  }

  @Override
  public synchronized Object getObjectById(int id) {
    Entry entry;
    entry = this.mEntriesById.get(id);
    return entry != null ? entry.object : null;
  }

  @Override
  public synchronized void unrefObjectByObject(Object object) {
    unrefObject(this.mEntriesByObject.get(object));
  }

  public synchronized void refObjectById(int id) {
    Entry entry = this.mEntriesById.get(id);
    if (entry == null) {
      return;
    }
    entry.referenceCount++;
  }

  public synchronized void unrefObjectById(int id) {
    unrefObject(this.mEntriesById.get(id));
  }

  private synchronized void unrefObject(Entry entry) {
    if (entry == null) {
      return;
    }
    entry.referenceCount--;
    if (entry.referenceCount < 0) {
      throw new AssertionError();
    }
    if (entry.referenceCount > 0) {
      return;
    }
    this.mEntriesById.remove(entry.f550id);
    this.mEntriesByObject.remove(entry.object);
  }
}
