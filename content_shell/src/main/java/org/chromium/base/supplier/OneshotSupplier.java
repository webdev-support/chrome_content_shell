package org.chromium.base.supplier;

import org.chromium.base.Callback;

public interface OneshotSupplier<T> extends Supplier<T> {
  T onAvailable(Callback<T> callback);
}
