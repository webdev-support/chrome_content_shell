package org.chromium.base.supplier;

import org.chromium.base.Callback;

public interface ObservableSupplier<E> extends Supplier<E> {
  E addObserver(Callback<E> callback);

  void removeObserver(Callback<E> callback);
}
