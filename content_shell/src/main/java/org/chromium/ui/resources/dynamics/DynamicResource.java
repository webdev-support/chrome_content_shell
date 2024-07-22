package org.chromium.ui.resources.dynamics;

import org.chromium.base.Callback;
import org.chromium.ui.resources.Resource;

public interface DynamicResource {
  void addOnResourceReadyCallback(Callback<Resource> callback);

  void onResourceRequested();

  void removeOnResourceReadyCallback(Callback<Resource> callback);
}
