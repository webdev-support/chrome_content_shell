package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;

public interface AnnotationAgentContainer extends Interface {
  public static final Interface.Manager<AnnotationAgentContainer, Proxy> MANAGER =
      AnnotationAgentContainer_Internal.MANAGER;

  public interface CreateAgentFromSelection_Response {
    void call(SelectorCreationResult selectorCreationResult, int i, int i2);
  }

  public interface Proxy extends AnnotationAgentContainer, Interface.Proxy {}

  void createAgent(
      AnnotationAgentHost annotationAgentHost,
      InterfaceRequest<AnnotationAgent> interfaceRequest,
      int i,
      String str);

  void createAgentFromSelection(
      int i, CreateAgentFromSelection_Response createAgentFromSelection_Response);
}
