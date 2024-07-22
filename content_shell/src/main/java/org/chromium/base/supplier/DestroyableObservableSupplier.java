package org.chromium.base.supplier;

import org.chromium.base.lifetime.Destroyable;

public interface DestroyableObservableSupplier<E> extends ObservableSupplier<E>, Destroyable {}
