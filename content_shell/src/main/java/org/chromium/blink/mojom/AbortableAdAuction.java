package org.chromium.blink.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.url.internal.mojom.Origin;

public interface AbortableAdAuction extends Interface {
  public static final Interface.Manager<AbortableAdAuction, Proxy> MANAGER =
      AbortableAdAuction_Internal.MANAGER;

  public interface Proxy extends AbortableAdAuction, Interface.Proxy {}

  void abort();

  void resolvedAdditionalBids(AuctionAdConfigAuctionId auctionAdConfigAuctionId);

  void resolvedAuctionAdResponsePromise(
      AuctionAdConfigAuctionId auctionAdConfigAuctionId, BigBuffer bigBuffer);

  void resolvedBuyerCurrenciesPromise(
      AuctionAdConfigAuctionId auctionAdConfigAuctionId,
      AuctionAdConfigBuyerCurrencies auctionAdConfigBuyerCurrencies);

  void resolvedBuyerTimeoutsPromise(
      AuctionAdConfigAuctionId auctionAdConfigAuctionId,
      int i,
      AuctionAdConfigBuyerTimeouts auctionAdConfigBuyerTimeouts);

  void resolvedDeprecatedRenderUrlReplacementsPromise(
      AuctionAdConfigAuctionId auctionAdConfigAuctionId,
      AdKeywordReplacement[] adKeywordReplacementArr);

  void resolvedDirectFromSellerSignalsHeaderAdSlotPromise(
      AuctionAdConfigAuctionId auctionAdConfigAuctionId, String str);

  void resolvedDirectFromSellerSignalsPromise(
      AuctionAdConfigAuctionId auctionAdConfigAuctionId,
      DirectFromSellerSignals directFromSellerSignals);

  void resolvedPerBuyerSignalsPromise(
      AuctionAdConfigAuctionId auctionAdConfigAuctionId, Map<Origin, String> map);

  void resolvedPromiseParam(AuctionAdConfigAuctionId auctionAdConfigAuctionId, int i, String str);
}
