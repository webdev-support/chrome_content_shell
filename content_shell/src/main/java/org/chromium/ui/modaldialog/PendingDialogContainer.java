package org.chromium.ui.modaldialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.chromium.ui.modelutil.PropertyModel;

class PendingDialogContainer {

  private final HashMap<Integer, List<PropertyModel>> mPendingDialogs = new HashMap<>();

  class PendingDialogType {
    public final int dialogPriority;
    public final int dialogType;
    public final PropertyModel propertyModel;

    PendingDialogType(PropertyModel model, int type, int priority) {
      this.propertyModel = model;
      this.dialogType = type;
      this.dialogPriority = priority;
    }
  }

  public void put(int dialogType, int dialogPriority, PropertyModel model, boolean showAsNext) {
    Integer key = computeKey(dialogType, dialogPriority);
    List<PropertyModel> dialogs = this.mPendingDialogs.get(key);
    if (dialogs == null) {
      HashMap<Integer, List<PropertyModel>> hashMap = this.mPendingDialogs;
      ArrayList arrayList = new ArrayList();
      dialogs = arrayList;
      hashMap.put(key, arrayList);
    }
    dialogs.add(showAsNext ? 0 : dialogs.size(), model);
  }

  public List<PropertyModel> get(int dialogType, int dialogPriority) {
    Integer key = computeKey(dialogType, dialogPriority);
    return this.mPendingDialogs.get(key);
  }

  boolean contains(PropertyModel model) {
    for (Map.Entry<Integer, List<PropertyModel>> entry : this.mPendingDialogs.entrySet()) {
      List<PropertyModel> dialogs = entry.getValue();
      for (int i = 0; i < dialogs.size(); i++) {
        if (dialogs.get(i) == model) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean isEmpty() {
    for (Map.Entry<Integer, List<PropertyModel>> entry : this.mPendingDialogs.entrySet()) {
      if (!entry.getValue().isEmpty()) {
        return false;
      }
    }
    return true;
  }

  int size() {
    return this.mPendingDialogs.size();
  }

  public boolean remove(PropertyModel model) {
    for (Map.Entry<Integer, List<PropertyModel>> entry : this.mPendingDialogs.entrySet()) {
      List<PropertyModel> dialogs = entry.getValue();
      for (int i = 0; i < dialogs.size(); i++) {
        if (dialogs.get(i) == model) {
          dialogs.remove(i);
          if (dialogs.isEmpty()) {
            this.mPendingDialogs.remove(entry.getKey());
            return true;
          }
          return true;
        }
      }
    }
    return false;
  }

  public boolean remove(int dialogType, Consumer<PropertyModel> consumer) {
    boolean dialogRemoved = false;
    for (int priority = 1; priority <= 3; priority++) {
      Integer key = computeKey(dialogType, priority);
      List<PropertyModel> dialogs = this.mPendingDialogs.get(key);
      if (dialogs != null) {
        for (int i = 0; i < dialogs.size(); i++) {
          dialogRemoved = true;
          consumer.accept(dialogs.get(i));
        }
        this.mPendingDialogs.remove(key);
      }
    }
    return dialogRemoved;
  }

  public PendingDialogType getNextPendingDialog(Set<Integer> suspendedTypes) {
    Integer key;
    List<PropertyModel> dialogs;
    for (int priority = 3; priority >= 1; priority--) {
      for (int type = 1; type >= 0; type--) {
        if (!suspendedTypes.contains(Integer.valueOf(type))
            && (dialogs = this.mPendingDialogs.get((key = computeKey(type, priority)))) != null
            && !dialogs.isEmpty()) {
          PropertyModel model = dialogs.get(0);
          dialogs.remove(0);
          if (dialogs.isEmpty()) {
            this.mPendingDialogs.remove(key);
          }
          return new PendingDialogType(model, type, priority);
        }
      }
    }
    return null;
  }

  private Integer computeKey(int dialogType, int dialogPriority) {
    if (dialogPriority < 1 || dialogPriority > 9) {
      throw new AssertionError();
    }
    return Integer.valueOf((dialogType * 10) + dialogPriority);
  }
}
