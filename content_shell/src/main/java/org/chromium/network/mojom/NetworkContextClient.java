package org.chromium.network.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.FilePath;
import org.chromium.mojo_base.mojom.ReadOnlyFile;
import org.chromium.url.internal.mojom.Origin;
import org.chromium.url.mojom.Url;

public interface NetworkContextClient extends Interface {
  public static final Interface.Manager<NetworkContextClient, Proxy> MANAGER =
      NetworkContextClient_Internal.MANAGER;

  public interface OnCanSendDomainReliabilityUpload_Response {
    void call(boolean z);
  }

  public interface OnCanSendReportingReports_Response {
    void call(Origin[] originArr);
  }

  public interface OnCanSendSctAuditingReport_Response {
    void call(boolean z);
  }

  public interface OnFileUploadRequested_Response {
    void call(int i, ReadOnlyFile[] readOnlyFileArr);
  }

  public interface OnGenerateHttpNegotiateAuthToken_Response {
    void call(int i, String str);
  }

  public interface Proxy extends NetworkContextClient, Interface.Proxy {}

  void onCanSendDomainReliabilityUpload(
      Origin origin,
      OnCanSendDomainReliabilityUpload_Response onCanSendDomainReliabilityUpload_Response);

  void onCanSendReportingReports(
      Origin[] originArr, OnCanSendReportingReports_Response onCanSendReportingReports_Response);

  void onCanSendSctAuditingReport(
      OnCanSendSctAuditingReport_Response onCanSendSctAuditingReport_Response);

  void onFileUploadRequested(
      int i,
      boolean z,
      FilePath[] filePathArr,
      Url url,
      OnFileUploadRequested_Response onFileUploadRequested_Response);

  void onGenerateHttpNegotiateAuthToken(
      String str,
      boolean z,
      String str2,
      String str3,
      OnGenerateHttpNegotiateAuthToken_Response onGenerateHttpNegotiateAuthToken_Response);

  void onNewSctAuditingReportSent();
}
