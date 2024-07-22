package org.chromium.ui.modelutil;

public class ListModelChangeProcessor<M extends ListObservable<P>, V, P>
    implements ListObservable.ListObserver<P> {

  private final M mModel;
  private final V mView;
  private final ViewBinder<M, V, P> mViewBinder;

  public interface ViewBinder<M, V, P> {
    void onItemsChanged(M m, V v, int i, int i2, P p);

    void onItemsInserted(M m, V v, int i, int i2);

    void onItemsRemoved(M m, V v, int i, int i2);
  }

  public ListModelChangeProcessor(M model, V view, ViewBinder<M, V, P> viewBinder) {
    this.mModel = model;
    this.mView = view;
    this.mViewBinder = viewBinder;
  }

  @Override
  public void onItemRangeInserted(ListObservable source, int index, int count) {
    M m = this.mModel;
    if (source != m) {
      throw new AssertionError();
    }
    this.mViewBinder.onItemsInserted(m, this.mView, index, count);
  }

  @Override
  public void onItemRangeRemoved(ListObservable source, int index, int count) {
    M m = this.mModel;
    if (source != m) {
      throw new AssertionError();
    }
    this.mViewBinder.onItemsRemoved(m, this.mView, index, count);
  }

  @Override
  public void onItemRangeChanged(ListObservable<P> source, int index, int count, P payload) {
    M m = this.mModel;
    if (source != m) {
      throw new AssertionError();
    }
    this.mViewBinder.onItemsChanged(m, this.mView, index, count, payload);
  }
}
