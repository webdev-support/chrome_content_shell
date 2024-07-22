package org.chromium.components.variations;

import java.util.HashMap;
import org.jni_zero.JNINamespace;

@JNINamespace("variations::android")
public final class VariationsAssociatedData {

  public interface Natives {
    String getFeedbackVariations();

    String getGoogleAppVariations();

    String getVariationParamValue(String str, String str2);
  }

  private VariationsAssociatedData() {}

  public static String getVariationParamValue(String trialName, String paramName) {
    return VariationsAssociatedDataJni.get().getVariationParamValue(trialName, paramName);
  }

  public static HashMap<String, String> getFeedbackMap() {
    HashMap<String, String> map = new HashMap<>();
    map.put("Chrome Variations", VariationsAssociatedDataJni.get().getFeedbackVariations());
    return map;
  }

  public static String getGoogleAppVariations() {
    String variations = VariationsAssociatedDataJni.get().getGoogleAppVariations();
    return variations;
  }
}
