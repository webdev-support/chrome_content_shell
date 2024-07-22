package org.chromium.ui.resources.statics;

import android.content.res.Resources;
import org.chromium.ui.resources.Resource;
import org.chromium.ui.resources.async.AsyncPreloadResourceLoader;

public class StaticResourceLoader extends AsyncPreloadResourceLoader {
  public StaticResourceLoader(
      int resourceType, ResourceLoaderCallback callback, final Resources resources) {
    super(
        resourceType,
        callback,
        new ResourceCreator() {
          @Override
          public Resource create(int resId) {
            return StaticResource.create(resources, resId, 0, 0);
          }
        });
  }
}
