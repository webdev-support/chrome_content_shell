package org.chromium.ui.modelutil;

import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.chromium_content_view.R;
import java.util.Collection;

public class ModelListAdapter extends BaseAdapter implements MVCListAdapter {

  private final ListObservable.ListObserver<Void> mListObserver;
  private final ModelList mModelList;
  private final SparseArray<Pair<ViewBuilder, PropertyModelChangeProcessor.ViewBinder>>
      mViewBuilderMap = new SparseArray<>();

  public ModelListAdapter(ModelList data) {
    this.mModelList = data;
    ListObservable.ListObserver<Void> listObserver =
        new ListObservable.ListObserver<Void>() {
          @Override
          public void onItemRangeInserted(ListObservable source, int index, int count) {
            ModelListAdapter.this.notifyDataSetChanged();
          }

          @Override
          public void onItemRangeRemoved(ListObservable source, int index, int count) {
            ModelListAdapter.this.notifyDataSetChanged();
          }

          @Override
          public void onItemRangeChanged(
              ListObservable<Void> source, int index, int count, Void payload) {
            ModelListAdapter.this.notifyDataSetChanged();
          }

          @Override
          public void onItemMoved(ListObservable source, int curIndex, int newIndex) {
            ModelListAdapter.this.notifyDataSetChanged();
          }
        };
    this.mListObserver = listObserver;
    data.addObserver(listObserver);
  }

  @Override // android.widget.Adapter
  public int getCount() {
    return this.mModelList.size();
  }

  @Override // android.widget.Adapter
  public Object getItem(int position) {
    return this.mModelList.get(position);
  }

  @Override // android.widget.Adapter
  public long getItemId(int position) {
    return position;
  }

  @Override
  public <T extends View> void registerType(
      int typeId,
      ViewBuilder<T> builder,
      PropertyModelChangeProcessor.ViewBinder<PropertyModel, T, PropertyKey> binder) {
    if (this.mViewBuilderMap.get(typeId) != null) {
      throw new AssertionError();
    }
    this.mViewBuilderMap.put(typeId, new Pair<>(builder, binder));
  }

  @Override // android.widget.BaseAdapter, android.widget.Adapter
  public int getItemViewType(int position) {
    return this.mModelList.get(position).type;
  }

  @Override // android.widget.BaseAdapter, android.widget.Adapter
  public int getViewTypeCount() {
    return Math.max(1, this.mViewBuilderMap.size());
  }

  protected boolean canReuseView(View view, int desiredType) {
    return (view == null
            || view.getTag(R.id.view_type) == null
            || ((Integer) view.getTag(R.id.view_type)).intValue() != desiredType)
        ? false
        : true;
  }

  protected View createView(ViewGroup parent, int typeId) {
    return ((ViewBuilder) this.mViewBuilderMap.get(typeId).first).buildView(parent);
  }

  @Override // android.widget.Adapter
  public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView != null && convertView.getTag(R.id.view_mcp) != null) {
      PropertyModelChangeProcessor propertyModelChangeProcessor =
          (PropertyModelChangeProcessor) convertView.getTag(R.id.view_mcp);
      propertyModelChangeProcessor.destroy();
    }
    PropertyModel oldModel = null;
    int desiredViewType = getItemViewType(position);
    if (convertView == null || !canReuseView(convertView, desiredViewType)) {
      convertView = createView(parent, desiredViewType);
      convertView.setTag(R.id.view_type, Integer.valueOf(desiredViewType));
    } else {
      oldModel = (PropertyModel) convertView.getTag(R.id.view_model);
    }
    PropertyModel model = this.mModelList.get(position).model;
    PropertyModelChangeProcessor.ViewBinder binder =
        (PropertyModelChangeProcessor.ViewBinder)
            this.mViewBuilderMap.get(this.mModelList.get(position).type).second;
    convertView.setTag(
        R.id.view_mcp, PropertyModelChangeProcessor.create(model, convertView, binder, false));
    convertView.setTag(R.id.view_model, model);
    bindNewModel(model, oldModel, convertView, binder);
    convertView.jumpDrawablesToCurrentState();
    return convertView;
  }

  static void bindNewModel(
      PropertyModel newModel,
      PropertyModel oldModel,
      View view,
      PropertyModelChangeProcessor.ViewBinder binder) {
    Collection<PropertyKey> setProperties = newModel.getAllSetProperties();
    for (PropertyKey key : newModel.getAllProperties()) {
      if (oldModel != null) {
        if (!newModel.compareValue(oldModel, key)) {
          binder.bind(newModel, view, key);
        }
      } else if (setProperties.contains(key)) {
        binder.bind(newModel, view, key);
      }
    }
  }
}
