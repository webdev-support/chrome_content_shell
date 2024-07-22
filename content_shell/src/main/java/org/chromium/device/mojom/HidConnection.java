package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface HidConnection extends Interface {
  public static final Interface.Manager<HidConnection, Proxy> MANAGER =
      HidConnection_Internal.MANAGER;

  public interface GetFeatureReport_Response {
    void call(boolean z, byte[] bArr);
  }

  public interface Proxy extends HidConnection, Interface.Proxy {}

  public interface Read_Response {
    void call(boolean z, byte b, byte[] bArr);
  }

  public interface SendFeatureReport_Response {
    void call(boolean z);
  }

  public interface Write_Response {
    void call(boolean z);
  }

  void getFeatureReport(byte b, GetFeatureReport_Response getFeatureReport_Response);

  void read(Read_Response read_Response);

  void sendFeatureReport(
      byte b, byte[] bArr, SendFeatureReport_Response sendFeatureReport_Response);

  void write(byte b, byte[] bArr, Write_Response write_Response);
}
