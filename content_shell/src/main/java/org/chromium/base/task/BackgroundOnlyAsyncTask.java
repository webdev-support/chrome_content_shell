package org.chromium.base.task;

public abstract class BackgroundOnlyAsyncTask<Result> extends AsyncTask<Result> {

  @Override
  protected final void onPostExecute(Result result) {
    throw new AssertionError();
  }
}
