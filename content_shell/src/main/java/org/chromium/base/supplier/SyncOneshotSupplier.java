package org.chromium.base.supplier;

import org.chromium.base.Callback;

public interface SyncOneshotSupplier<T> extends Supplier<T> {
  T onAvailable(Callback<T> callback);
}
