package org.chromium.media.stable.mojom;

import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.system.UntypedHandle;

public interface StableCdmContext extends Interface {
  public static final Interface.Manager<StableCdmContext, Proxy> MANAGER =
      StableCdmContext_Internal.MANAGER;

  public interface AllocateSecureBuffer_Response {
    void call(UntypedHandle untypedHandle);
  }

  public interface GetHwConfigData_Response {
    void call(boolean z, byte[] bArr);
  }

  public interface GetHwKeyData_Response {
    void call(int i, byte[] bArr);
  }

  public interface GetScreenResolutions_Response {
    void call(Size[] sizeArr);
  }

  public interface ParseEncryptedSliceHeader_Response {
    void call(boolean z, byte[] bArr);
  }

  public interface Proxy extends StableCdmContext, Interface.Proxy {}

  void allocateSecureBuffer(int i, AllocateSecureBuffer_Response allocateSecureBuffer_Response);

  void getHwConfigData(GetHwConfigData_Response getHwConfigData_Response);

  void getHwKeyData(
      DecryptConfig decryptConfig, byte[] bArr, GetHwKeyData_Response getHwKeyData_Response);

  void getScreenResolutions(GetScreenResolutions_Response getScreenResolutions_Response);

  void parseEncryptedSliceHeader(
      long j,
      int i,
      byte[] bArr,
      ParseEncryptedSliceHeader_Response parseEncryptedSliceHeader_Response);

  void registerEventCallback(CdmContextEventCallback cdmContextEventCallback);
}
