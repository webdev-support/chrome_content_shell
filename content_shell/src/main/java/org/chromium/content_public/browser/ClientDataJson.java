package org.chromium.content_public.browser;

import org.chromium.blink.mojom.PaymentOptions;
import org.chromium.content.browser.ClientDataJsonImpl;
import org.chromium.url.Origin;

public final class ClientDataJson {

  private ClientDataJson() {}

  public static String buildClientDataJson(
      int clientDataRequestType,
      String callerOrigin,
      byte[] challenge,
      boolean isCrossOrigin,
      PaymentOptions paymentOptions,
      String relyingPartyId,
      Origin topOrigin) {
    if (challenge == null) {
      throw new AssertionError();
    }
    return ClientDataJsonImpl.buildClientDataJson(
        clientDataRequestType,
        callerOrigin,
        challenge,
        isCrossOrigin,
        paymentOptions,
        relyingPartyId,
        topOrigin);
  }
}
