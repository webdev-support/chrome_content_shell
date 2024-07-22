package org.chromium.ui.resources;

public abstract class ResourceLoader {
  private final ResourceLoaderCallback mCallback;
  private final int mResourceType;

  public interface ResourceLoaderCallback {
    void onResourceLoaded(int i, int i2, Resource resource);

    void onResourceUnregistered(int i, int i2);
  }

  public abstract void loadResource(int i);

  public abstract void preloadResource(int i);

  public ResourceLoader(int resourceType, ResourceLoaderCallback callback) {
    this.mResourceType = resourceType;
    this.mCallback = callback;
  }

  public int getResourceType() {
    return this.mResourceType;
  }

  public void notifyLoadFinished(int resId, Resource resource) {
    ResourceLoaderCallback resourceLoaderCallback = this.mCallback;
    if (resourceLoaderCallback != null) {
      resourceLoaderCallback.onResourceLoaded(getResourceType(), resId, resource);
    }
  }

  public void notifyResourceUnregistered(int resId) {
    ResourceLoaderCallback resourceLoaderCallback = this.mCallback;
    if (resourceLoaderCallback != null) {
      resourceLoaderCallback.onResourceUnregistered(getResourceType(), resId);
    }
  }
}
