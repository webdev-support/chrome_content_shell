package org.chromium.blink.test.mojom;

import org.chromium.mojo.bindings.Interface;

public interface VirtualAuthenticator extends Interface {
  public static final Interface.Manager<VirtualAuthenticator, Proxy> MANAGER =
      VirtualAuthenticator_Internal.MANAGER;

  public interface AddRegistration_Response {
    void call(boolean z);
  }

  public interface ClearRegistrations_Response {
    void call();
  }

  public interface GetLargeBlob_Response {
    void call(byte[] bArr);
  }

  public interface GetRegistrations_Response {
    void call(RegisteredKey[] registeredKeyArr);
  }

  public interface GetUniqueId_Response {
    void call(String str);
  }

  public interface Proxy extends VirtualAuthenticator, Interface.Proxy {}

  public interface RemoveRegistration_Response {
    void call(boolean z);
  }

  public interface SetLargeBlob_Response {
    void call(boolean z);
  }

  public interface SetUserVerified_Response {
    void call();
  }

  void addRegistration(
      RegisteredKey registeredKey, AddRegistration_Response addRegistration_Response);

  void clearRegistrations(ClearRegistrations_Response clearRegistrations_Response);

  void getLargeBlob(byte[] bArr, GetLargeBlob_Response getLargeBlob_Response);

  void getRegistrations(GetRegistrations_Response getRegistrations_Response);

  void getUniqueId(GetUniqueId_Response getUniqueId_Response);

  void removeRegistration(byte[] bArr, RemoveRegistration_Response removeRegistration_Response);

  void setLargeBlob(byte[] bArr, byte[] bArr2, SetLargeBlob_Response setLargeBlob_Response);

  void setUserVerified(boolean z, SetUserVerified_Response setUserVerified_Response);
}
