package org.chromium.media.mojom;

import org.chromium.mojo.bindings.AssociatedInterfaceNotSupported;
import org.chromium.mojo.bindings.Interface;

public interface ContentDecryptionModule extends Interface {
  public static final Interface.Manager<ContentDecryptionModule, Proxy> MANAGER =
      ContentDecryptionModule_Internal.MANAGER;

  public interface CloseSession_Response {
    void call(CdmPromiseResult cdmPromiseResult);
  }

  public interface CreateSessionAndGenerateRequest_Response {
    void call(CdmPromiseResult cdmPromiseResult, String str);
  }

  public interface GetStatusForPolicy_Response {
    void call(CdmPromiseResult cdmPromiseResult, int i);
  }

  public interface LoadSession_Response {
    void call(CdmPromiseResult cdmPromiseResult, String str);
  }

  public interface Proxy extends ContentDecryptionModule, Interface.Proxy {}

  public interface RemoveSession_Response {
    void call(CdmPromiseResult cdmPromiseResult);
  }

  public interface SetServerCertificate_Response {
    void call(CdmPromiseResult cdmPromiseResult);
  }

  public interface UpdateSession_Response {
    void call(CdmPromiseResult cdmPromiseResult);
  }

  void closeSession(String str, CloseSession_Response closeSession_Response);

  void createSessionAndGenerateRequest(
      int i,
      int i2,
      byte[] bArr,
      CreateSessionAndGenerateRequest_Response createSessionAndGenerateRequest_Response);

  void getStatusForPolicy(int i, GetStatusForPolicy_Response getStatusForPolicy_Response);

  void loadSession(int i, String str, LoadSession_Response loadSession_Response);

  void removeSession(String str, RemoveSession_Response removeSession_Response);

  void setClient(AssociatedInterfaceNotSupported associatedInterfaceNotSupported);

  void setServerCertificate(
      byte[] bArr, SetServerCertificate_Response setServerCertificate_Response);

  void updateSession(String str, byte[] bArr, UpdateSession_Response updateSession_Response);
}
