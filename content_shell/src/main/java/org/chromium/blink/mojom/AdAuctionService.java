package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.Uuid;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public interface AdAuctionService extends Interface {
  public static final Interface.Manager<AdAuctionService, Proxy> MANAGER =
      AdAuctionService_Internal.MANAGER;

  public interface ClearOriginJoinedInterestGroups_Response {
    void call(boolean z);
  }

  public interface CreateAdRequest_Response {
    void call(String str);
  }

  public interface CreateAuctionNonce_Response {
    void call(Uuid uuid);
  }

  public interface DeprecatedGetUrlFromUrn_Response {
    void call(Url url);
  }

  public interface DeprecatedReplaceInUrn_Response {
    void call();
  }

  public interface FinalizeAd_Response {
    void call(Url url);
  }

  public interface GetInterestGroupAdAuctionData_Response {
    void call(BigBuffer bigBuffer, Uuid uuid, String str);
  }

  public interface JoinInterestGroup_Response {
    void call(boolean z);
  }

  public interface LeaveInterestGroup_Response {
    void call(boolean z);
  }

  public interface Proxy extends AdAuctionService, Interface.Proxy {}

  public interface RunAdAuction_Response {
    void call(boolean z, FencedFrameConfig fencedFrameConfig);
  }

  void clearOriginJoinedInterestGroups(
      Origin origin,
      String[] strArr,
      ClearOriginJoinedInterestGroups_Response clearOriginJoinedInterestGroups_Response);

  void createAdRequest(
      AdRequestConfig adRequestConfig, CreateAdRequest_Response createAdRequest_Response);

  void createAuctionNonce(CreateAuctionNonce_Response createAuctionNonce_Response);

  void deprecatedGetUrlFromUrn(
      Url url, boolean z, DeprecatedGetUrlFromUrn_Response deprecatedGetUrlFromUrn_Response);

  void deprecatedReplaceInUrn(
      Url url,
      AdKeywordReplacement[] adKeywordReplacementArr,
      DeprecatedReplaceInUrn_Response deprecatedReplaceInUrn_Response);

  void finalizeAd(
      String str, AuctionAdConfig auctionAdConfig, FinalizeAd_Response finalizeAd_Response);

  void getInterestGroupAdAuctionData(
      Origin origin,
      Origin origin2,
      GetInterestGroupAdAuctionData_Response getInterestGroupAdAuctionData_Response);

  void joinInterestGroup(
      InterestGroup interestGroup, JoinInterestGroup_Response joinInterestGroup_Response);

  void leaveInterestGroup(
      Origin origin, String str, LeaveInterestGroup_Response leaveInterestGroup_Response);

  void leaveInterestGroupForDocument();

  void runAdAuction(
      AuctionAdConfig auctionAdConfig,
      InterfaceRequest<AbortableAdAuction> interfaceRequest,
      RunAdAuction_Response runAdAuction_Response);

  void updateAdInterestGroups();
}
