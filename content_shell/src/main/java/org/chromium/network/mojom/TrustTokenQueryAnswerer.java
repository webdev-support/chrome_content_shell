package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.url.internal.mojom.Origin;

public interface TrustTokenQueryAnswerer extends Interface {
  public static final Interface.Manager<TrustTokenQueryAnswerer, Proxy> MANAGER =
      TrustTokenQueryAnswerer_Internal.MANAGER;

  public interface HasRedemptionRecord_Response {
    void call(HasRedemptionRecordResult hasRedemptionRecordResult);
  }

  public interface HasTrustTokens_Response {
    void call(HasTrustTokensResult hasTrustTokensResult);
  }

  public interface Proxy extends TrustTokenQueryAnswerer, Interface.Proxy {}

  void hasRedemptionRecord(
      Origin origin, HasRedemptionRecord_Response hasRedemptionRecord_Response);

  void hasTrustTokens(Origin origin, HasTrustTokens_Response hasTrustTokens_Response);
}
