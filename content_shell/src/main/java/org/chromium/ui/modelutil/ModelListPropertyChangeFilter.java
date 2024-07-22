package org.chromium.ui.modelutil;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ModelListPropertyChangeFilter
    implements ListObservable.ListObserver<Void>, PropertyObservable.PropertyObserver<PropertyKey> {
  private final MVCListAdapter.ModelList mModelList;
  private final Runnable mOnPropertyChange;
  private final Set<PropertyKey> mPropertyKeySet;
  private Set<PropertyModel> mTrackedPropertyModels = new HashSet();

  public ModelListPropertyChangeFilter(
      Runnable onPropertyChange,
      MVCListAdapter.ModelList modelList,
      Set<PropertyKey> filterPropertyKeySet) {
    this.mOnPropertyChange = onPropertyChange;
    this.mModelList = modelList;
    this.mPropertyKeySet = filterPropertyKeySet;
    modelList.addObserver(this);
    onItemRangeInserted(modelList, 0, modelList.size());
  }

  @Override
  public void onItemRangeInserted(ListObservable source, int index, int count) {
    for (int i = 0; i < count; i++) {
      MVCListAdapter.ListItem listItem = this.mModelList.get(index + i);
      listItem.model.addObserver(this);
      this.mTrackedPropertyModels.add(listItem.model);
    }
    this.mOnPropertyChange.run();
  }

  @Override
  public void onItemRangeRemoved(ListObservable source, int index, int count) {
    Set<PropertyModel> newPropertyModels = new HashSet<>();
    for (int i = 0; i < this.mModelList.size(); i++) {
      newPropertyModels.add(this.mModelList.get(i).model);
    }
    prunePropertyModels(newPropertyModels);
    this.mOnPropertyChange.run();
  }

  @Override
  public void onPropertyChanged(PropertyObservable<PropertyKey> source, PropertyKey propertyKey) {
    if (this.mPropertyKeySet.contains(propertyKey)) {
      this.mOnPropertyChange.run();
    }
  }

  public void destroy() {
    this.mModelList.removeObserver(this);
    prunePropertyModels(Collections.emptySet());
  }

  private void prunePropertyModels(Set<PropertyModel> newPropertyModels) {
    for (PropertyModel existingPropertyModel : this.mTrackedPropertyModels) {
      if (!newPropertyModels.contains(existingPropertyModel)) {
        existingPropertyModel.removeObserver(this);
      }
    }
    this.mTrackedPropertyModels = newPropertyModels;
  }
}
