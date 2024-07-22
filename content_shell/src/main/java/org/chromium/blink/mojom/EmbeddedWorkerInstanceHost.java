package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

public interface EmbeddedWorkerInstanceHost extends Interface {
  public static final Interface.Manager<EmbeddedWorkerInstanceHost, Proxy> MANAGER =
      EmbeddedWorkerInstanceHost_Internal.MANAGER;

  public interface Proxy extends EmbeddedWorkerInstanceHost, Interface.Proxy {}

  public interface RequestTermination_Response {
    void call(boolean z);
  }

  void countFeature(int i);

  void onReadyForInspection(
      DevToolsAgent devToolsAgent, InterfaceRequest<DevToolsAgentHost> interfaceRequest);

  void onReportConsoleMessage(int i, int i2, String16 string16, int i3, Url url);

  void onReportException(String16 string16, int i, int i2, Url url);

  void onScriptEvaluationStart();

  void onScriptLoaded();

  void onStarted(
      int i,
      int i2,
      boolean z,
      boolean z2,
      int i3,
      EmbeddedWorkerStartTiming embeddedWorkerStartTiming);

  void onStopped();

  void requestTermination(RequestTermination_Response requestTermination_Response);
}
