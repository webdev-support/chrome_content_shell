package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface AnchorElementMetricsHost extends Interface {
  public static final Interface.Manager<AnchorElementMetricsHost, Proxy> MANAGER =
      AnchorElementMetricsHost_Internal.MANAGER;

  public interface Proxy extends AnchorElementMetricsHost, Interface.Proxy {}

  public interface ShouldSkipUpdateDelays_Response {
    void call(boolean z);
  }

  void processPointerEventUsingMlModel(
      AnchorElementPointerEventForMlModel anchorElementPointerEventForMlModel);

  void reportAnchorElementClick(AnchorElementClick anchorElementClick);

  void reportAnchorElementPointerDataOnHoverTimerFired(
      AnchorElementPointerDataOnHoverTimerFired anchorElementPointerDataOnHoverTimerFired);

  void reportAnchorElementPointerDown(AnchorElementPointerDown anchorElementPointerDown);

  void reportAnchorElementPointerOut(AnchorElementPointerOut anchorElementPointerOut);

  void reportAnchorElementPointerOver(AnchorElementPointerOver anchorElementPointerOver);

  void reportAnchorElementsEnteredViewport(
      AnchorElementEnteredViewport[] anchorElementEnteredViewportArr);

  void reportAnchorElementsLeftViewport(AnchorElementLeftViewport[] anchorElementLeftViewportArr);

  void reportNewAnchorElements(AnchorElementMetrics[] anchorElementMetricsArr);

  void shouldSkipUpdateDelays(ShouldSkipUpdateDelays_Response shouldSkipUpdateDelays_Response);
}
