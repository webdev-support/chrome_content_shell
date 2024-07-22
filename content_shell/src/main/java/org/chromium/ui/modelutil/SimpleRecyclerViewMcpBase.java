package org.chromium.ui.modelutil;

public class SimpleRecyclerViewMcpBase<T, VH, P> extends ForwardingListObservable<P>
    implements RecyclerViewAdapter.Delegate<VH, P> {
  private final ItemViewTypeCallback<T> mItemViewTypeCallback;
  private final SimpleList<T> mModel;
  private final ViewBinder<T, VH, P> mViewBinder;

  public interface ItemViewTypeCallback<T> {
    int getItemViewType(T t);
  }

  public interface ViewBinder<T, VH, P> {
    void onBindViewHolder(VH vh, T t, P p);
  }

  public SimpleRecyclerViewMcpBase(
      ItemViewTypeCallback<T> itemViewTypeCallback,
      ViewBinder<T, VH, P> viewBinder,
      ListModelBase<T, P> model) {
    this.mItemViewTypeCallback = itemViewTypeCallback;
    this.mViewBinder = viewBinder;
    this.mModel = model;
    model.addObserver(this);
  }

  @Override
  public int getItemCount() {
    return this.mModel.size();
  }

  @Override
  public int getItemViewType(int position) {
    ItemViewTypeCallback<T> itemViewTypeCallback = this.mItemViewTypeCallback;
    if (itemViewTypeCallback == null) {
      return 0;
    }
    return itemViewTypeCallback.getItemViewType(this.mModel.get(position));
  }

  @Override
  public void onBindViewHolder(VH holder, int position, P payload) {
    this.mViewBinder.onBindViewHolder(holder, this.mModel.get(position), payload);
  }
}
