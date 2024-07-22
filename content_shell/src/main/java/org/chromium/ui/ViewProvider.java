package org.chromium.ui;

import org.chromium.base.Callback;

public interface ViewProvider<T> {
  void inflate();

  void whenLoaded(Callback<T> callback);
}
