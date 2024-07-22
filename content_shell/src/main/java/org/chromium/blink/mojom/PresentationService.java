package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.mojom.Url;

public interface PresentationService extends Interface {
  public static final Interface.Manager<PresentationService, Proxy> MANAGER =
      PresentationService_Internal.MANAGER;

  public interface Proxy extends PresentationService, Interface.Proxy {}

  public interface ReconnectPresentation_Response {
    void call(
        PresentationConnectionResult presentationConnectionResult,
        PresentationError presentationError);
  }

  public interface StartPresentation_Response {
    void call(
        PresentationConnectionResult presentationConnectionResult,
        PresentationError presentationError);
  }

  void closeConnection(Url url, String str);

  void listenForScreenAvailability(Url url);

  void reconnectPresentation(
      Url[] urlArr, String str, ReconnectPresentation_Response reconnectPresentation_Response);

  void setController(PresentationController presentationController);

  void setDefaultPresentationUrls(Url[] urlArr);

  void setReceiver(PresentationReceiver presentationReceiver);

  void startPresentation(Url[] urlArr, StartPresentation_Response startPresentation_Response);

  void stopListeningForScreenAvailability(Url url);

  void terminate(Url url, String str);
}
