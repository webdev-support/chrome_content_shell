package org.chromium.device.mojom;

import org.chromium.mojo.bindings.Interface;

public interface Nfc extends Interface {
  public static final Interface.Manager<Nfc, Proxy> MANAGER = Nfc_Internal.MANAGER;

  public interface MakeReadOnly_Response {
    void call(NdefError ndefError);
  }

  public interface Proxy extends Nfc, Interface.Proxy {}

  public interface Push_Response {
    void call(NdefError ndefError);
  }

  public interface Watch_Response {
    void call(NdefError ndefError);
  }

  void cancelMakeReadOnly();

  void cancelPush();

  void cancelWatch(int i);

  void makeReadOnly(MakeReadOnly_Response makeReadOnly_Response);

  void push(
      NdefMessage ndefMessage, NdefWriteOptions ndefWriteOptions, Push_Response push_Response);

  void setClient(NfcClient nfcClient);

  void watch(int i, Watch_Response watch_Response);
}
