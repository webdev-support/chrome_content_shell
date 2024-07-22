package org.chromium.ui.resources.async;

import android.util.SparseArray;
import java.util.concurrent.ExecutionException;
import org.chromium.base.TraceEvent;
import org.chromium.base.task.AsyncTask;
import org.chromium.base.task.PostTask;
import org.chromium.base.task.TaskRunner;
import org.chromium.ui.resources.Resource;
import org.chromium.ui.resources.ResourceLoader;

public class AsyncPreloadResourceLoader extends ResourceLoader {
  private final ResourceCreator mCreator;
  private final SparseArray<AsyncLoadTask> mOutstandingLoads;
  private final TaskRunner mTaskQueue;

  public interface ResourceCreator {
    Resource create(int i);
  }

  public AsyncPreloadResourceLoader(
      int resourceType, ResourceLoaderCallback callback, ResourceCreator creator) {
    super(resourceType, callback);
    this.mOutstandingLoads = new SparseArray<>();
    this.mTaskQueue = PostTask.createSequencedTaskRunner(5);
    this.mCreator = creator;
  }

  @Override
  public void loadResource(int resId) {
    AsyncLoadTask task = this.mOutstandingLoads.get(resId);
    if (task != null && !task.cancel(false)) {
      try {
        registerResource(task.get(), resId);
        return;
      } catch (InterruptedException e) {
        notifyLoadFinished(resId, null);
        return;
      } catch (ExecutionException e2) {
        notifyLoadFinished(resId, null);
        return;
      }
    }
    registerResource(createResource(resId), resId);
  }

  @Override
  public void preloadResource(int resId) {
    if (this.mOutstandingLoads.get(resId) != null) {
      return;
    }
    AsyncLoadTask task = new AsyncLoadTask(resId);
    task.executeOnTaskRunner(this.mTaskQueue);
    this.mOutstandingLoads.put(resId, task);
  }

  public Resource createResource(int resId) {
    try {
      TraceEvent.begin("AsyncPreloadResourceLoader.createResource");
      return this.mCreator.create(resId);
    } finally {
      TraceEvent.end("AsyncPreloadResourceLoader.createResource");
    }
  }

  public void registerResource(Resource resource, int resourceId) {
    notifyLoadFinished(resourceId, resource);
    this.mOutstandingLoads.remove(resourceId);
  }

  public class AsyncLoadTask extends AsyncTask<Resource> {
    private final int mResourceId;

    public AsyncLoadTask(int resourceId) {
      this.mResourceId = resourceId;
    }

    @Override
    public Resource doInBackground() {
      return AsyncPreloadResourceLoader.this.createResource(this.mResourceId);
    }

    @Override
    public void onPostExecute(Resource resource) {
      if (AsyncPreloadResourceLoader.this.mOutstandingLoads.get(this.mResourceId) == null) {
        return;
      }
      AsyncPreloadResourceLoader.this.registerResource(resource, this.mResourceId);
    }
  }
}
