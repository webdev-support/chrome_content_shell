package org.chromium.ui.modelutil;

import java.util.Collection;
import java.util.Iterator;
import org.chromium.base.ObserverList;

public abstract class PropertyObservable<T> {
  private final ObserverList<PropertyObserver<T>> mObservers = new ObserverList<>();

  public interface PropertyObserver<T> {
    void onPropertyChanged(PropertyObservable<T> propertyObservable, T t);
  }

  public abstract Collection<T> getAllProperties();

  public abstract Collection<T> getAllSetProperties();

  public void addObserver(PropertyObserver<T> observer) {
    this.mObservers.addObserver(observer);
  }

  public void removeObserver(PropertyObserver<T> observer) {
    this.mObservers.removeObserver(observer);
  }

  public void notifyPropertyChanged(T propertyKey) {
    Iterator<PropertyObserver<T>> it = this.mObservers.iterator();
    while (it.hasNext()) {
      PropertyObserver<T> observer = it.next();
      observer.onPropertyChanged(this, propertyKey);
    }
  }
}
