package org.chromium.base;

import java.util.Objects;

public class ValueChangedCallback<T> implements Callback<T> {
  private T mLastValue;
  private final ValueChangedObserver<T> mValueChangedObserver;

  @FunctionalInterface
  public interface ValueChangedObserver<T> {
    void onValueChanged(T t, T t2);
  }

  public ValueChangedCallback(ValueChangedObserver<T> onValueChangedObserver) {
    this.mValueChangedObserver = onValueChangedObserver;
  }

  @Override
  public void onResult(T newValue) {
    if (Objects.equals(newValue, this.mLastValue)) {
      return;
    }
    T oldLastValue = this.mLastValue;
    this.mLastValue = newValue;
    this.mValueChangedObserver.onValueChanged(newValue, oldLastValue);
  }
}
