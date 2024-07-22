package org.chromium.ui.modelutil;

import android.animation.ObjectAnimator;
import android.util.FloatProperty;

public class PropertyModelAnimatorFactory {
  public static ObjectAnimator ofFloat(
      PropertyModel model, PropertyModel.WritableFloatPropertyKey key, float targetValue) {
    PropertyModelFloatProp customProperty = new PropertyModelFloatProp(key);
    return ObjectAnimator.ofFloat(model, customProperty, targetValue);
  }

  private static class PropertyModelFloatProp extends FloatProperty<PropertyModel> {
    final PropertyModel.WritableFloatPropertyKey mKey;

    public PropertyModelFloatProp(PropertyModel.WritableFloatPropertyKey key) {
      super(key.toString());
      this.mKey = key;
    }

    @Override // android.util.Property
    public Float get(PropertyModel model) {
      return Float.valueOf(model.get(this.mKey));
    }

    @Override // android.util.FloatProperty
    public void setValue(PropertyModel model, float value) {
      model.set(this.mKey, value);
    }
  }
}
