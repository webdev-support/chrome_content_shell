package org.chromium.device.nfc;

import org.chromium.device.mojom.Nfc;
import org.chromium.device.mojom.NfcProvider;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.system.MojoException;
import org.chromium.services.service_manager.InterfaceFactory;

public class NfcProviderImpl implements NfcProvider {
  private static final String TAG = "NfcProviderImpl";
  private NfcDelegate mDelegate;
  private NfcImpl mNfcImpl;

  public NfcProviderImpl(NfcDelegate delegate) {
    this.mDelegate = delegate;
  }

  @Override
  public void close() {
    NfcImpl nfcImpl = this.mNfcImpl;
    if (nfcImpl != null) {
      nfcImpl.closeMojoConnection();
      this.mNfcImpl = null;
    }
  }

  @Override
  public void onConnectionError(MojoException e) {}

  @Override
  public void getNfcForHost(int hostId, InterfaceRequest<Nfc> request) {
    NfcImpl nfcImpl = this.mNfcImpl;
    if (nfcImpl != null) {
      nfcImpl.closeMojoConnection();
    }
    this.mNfcImpl = new NfcImpl(hostId, this.mDelegate, request);
  }

  @Override
  public void suspendNfcOperations() {
    NfcImpl nfcImpl = this.mNfcImpl;
    if (nfcImpl != null) {
      nfcImpl.suspendNfcOperations();
    }
  }

  @Override
  public void resumeNfcOperations() {
    NfcImpl nfcImpl = this.mNfcImpl;
    if (nfcImpl != null) {
      nfcImpl.resumeNfcOperations();
    }
  }

  public static class Factory implements InterfaceFactory<NfcProvider> {
    private NfcDelegate mDelegate;

    public Factory(NfcDelegate delegate) {
      this.mDelegate = delegate;
    }

    @Override
    public NfcProvider createImpl() {
      return new NfcProviderImpl(this.mDelegate);
    }
  }
}
