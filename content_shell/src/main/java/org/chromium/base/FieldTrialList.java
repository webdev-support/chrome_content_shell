package org.chromium.base;

public class FieldTrialList {

  public interface Natives {
    boolean createFieldTrial(String str, String str2);

    String findFullName(String str);

    String getVariationParameter(String str, String str2);

    void logActiveTrials();

    boolean trialExists(String str);
  }

  private FieldTrialList() {}

  public static String findFullName(String trialName) {
    return FieldTrialListJni.get().findFullName(trialName);
  }

  public static boolean trialExists(String trialName) {
    return FieldTrialListJni.get().trialExists(trialName);
  }

  public static String getVariationParameter(String trialName, String parameterKey) {
    return FieldTrialListJni.get().getVariationParameter(trialName, parameterKey);
  }

  public static void logActiveTrials() {
    FieldTrialListJni.get().logActiveTrials();
  }

  public static boolean createFieldTrial(String trialName, String groupName) {
    return FieldTrialListJni.get().createFieldTrial(trialName, groupName);
  }
}
