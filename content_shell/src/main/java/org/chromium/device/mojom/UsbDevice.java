package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.ReadOnlyBuffer;

public interface UsbDevice extends Interface {
  public static final Interface.Manager<UsbDevice, Proxy> MANAGER = UsbDevice_Internal.MANAGER;

  public interface ClaimInterface_Response {
    void call(int i);
  }

  public interface ClearHalt_Response {
    void call(boolean z);
  }

  public interface Close_Response {
    void call();
  }

  public interface ControlTransferIn_Response {
    void call(int i, ReadOnlyBuffer readOnlyBuffer);
  }

  public interface ControlTransferOut_Response {
    void call(int i);
  }

  public interface GenericTransferIn_Response {
    void call(int i, ReadOnlyBuffer readOnlyBuffer);
  }

  public interface GenericTransferOut_Response {
    void call(int i);
  }

  public interface IsochronousTransferIn_Response {
    void call(ReadOnlyBuffer readOnlyBuffer, UsbIsochronousPacket[] usbIsochronousPacketArr);
  }

  public interface IsochronousTransferOut_Response {
    void call(UsbIsochronousPacket[] usbIsochronousPacketArr);
  }

  public interface Open_Response {
    void call(UsbOpenDeviceResult usbOpenDeviceResult);
  }

  public interface Proxy extends UsbDevice, Interface.Proxy {}

  public interface ReleaseInterface_Response {
    void call(boolean z);
  }

  public interface Reset_Response {
    void call(boolean z);
  }

  public interface SetConfiguration_Response {
    void call(boolean z);
  }

  public interface SetInterfaceAlternateSetting_Response {
    void call(boolean z);
  }

  void claimInterface(byte b, ClaimInterface_Response claimInterface_Response);

  void clearHalt(int i, byte b, ClearHalt_Response clearHalt_Response);

  void close(Close_Response close_Response);

  void controlTransferIn(
      UsbControlTransferParams usbControlTransferParams,
      int i,
      int i2,
      ControlTransferIn_Response controlTransferIn_Response);

  void controlTransferOut(
      UsbControlTransferParams usbControlTransferParams,
      ReadOnlyBuffer readOnlyBuffer,
      int i,
      ControlTransferOut_Response controlTransferOut_Response);

  void genericTransferIn(
      byte b, int i, int i2, GenericTransferIn_Response genericTransferIn_Response);

  void genericTransferOut(
      byte b,
      ReadOnlyBuffer readOnlyBuffer,
      int i,
      GenericTransferOut_Response genericTransferOut_Response);

  void isochronousTransferIn(
      byte b, int[] iArr, int i, IsochronousTransferIn_Response isochronousTransferIn_Response);

  void isochronousTransferOut(
      byte b,
      ReadOnlyBuffer readOnlyBuffer,
      int[] iArr,
      int i,
      IsochronousTransferOut_Response isochronousTransferOut_Response);

  void open(Open_Response open_Response);

  void releaseInterface(byte b, ReleaseInterface_Response releaseInterface_Response);

  void reset(Reset_Response reset_Response);

  void setConfiguration(byte b, SetConfiguration_Response setConfiguration_Response);

  void setInterfaceAlternateSetting(
      byte b, byte b2, SetInterfaceAlternateSetting_Response setInterfaceAlternateSetting_Response);
}
