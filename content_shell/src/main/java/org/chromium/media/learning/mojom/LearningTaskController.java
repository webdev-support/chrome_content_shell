package org.chromium.media.learning.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.UnguessableToken;

public interface LearningTaskController extends Interface {
  public static final Interface.Manager<LearningTaskController, Proxy> MANAGER =
      LearningTaskController_Internal.MANAGER;

  public interface PredictDistribution_Response {
    void call(TargetHistogram targetHistogram);
  }

  public interface Proxy extends LearningTaskController, Interface.Proxy {}

  void beginObservation(
      UnguessableToken unguessableToken, FeatureValue[] featureValueArr, TargetValue targetValue);

  void cancelObservation(UnguessableToken unguessableToken);

  void completeObservation(
      UnguessableToken unguessableToken, ObservationCompletion observationCompletion);

  void predictDistribution(
      FeatureValue[] featureValueArr, PredictDistribution_Response predictDistribution_Response);

  void updateDefaultTarget(UnguessableToken unguessableToken, TargetValue targetValue);
}
