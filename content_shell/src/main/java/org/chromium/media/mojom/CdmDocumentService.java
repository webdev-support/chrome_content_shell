package org.chromium.media.mojom;

import org.chromium.mojo.bindings.Interface;

public interface CdmDocumentService extends Interface {
  public static final Interface.Manager<CdmDocumentService, Proxy> MANAGER =
      CdmDocumentService_Internal.MANAGER;

  public interface ChallengePlatform_Response {
    void call(boolean z, String str, String str2, String str3);
  }

  public interface GetStorageId_Response {
    void call(int i, byte[] bArr);
  }

  public interface Proxy extends CdmDocumentService, Interface.Proxy {}

  void challengePlatform(
      String str, String str2, ChallengePlatform_Response challengePlatform_Response);

  void getStorageId(int i, GetStorageId_Response getStorageId_Response);
}
