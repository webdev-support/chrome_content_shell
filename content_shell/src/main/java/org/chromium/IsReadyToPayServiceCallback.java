package org.chromium;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IsReadyToPayServiceCallback extends IInterface {
  public static final String DESCRIPTOR = "org.chromium.IsReadyToPayServiceCallback";

  void handleIsReadyToPay(boolean z) throws RemoteException;

  public static class Default implements IsReadyToPayServiceCallback {
    @Override
    public void handleIsReadyToPay(boolean isReadyToPay) throws RemoteException {}

    @Override
    public IBinder asBinder() {
      return null;
    }
  }

  public abstract static class Stub extends Binder implements IsReadyToPayServiceCallback {
    static final int TRANSACTION_handleIsReadyToPay = 1;

    public Stub() {
      attachInterface(this, IsReadyToPayServiceCallback.DESCRIPTOR);
    }

    public static IsReadyToPayServiceCallback asInterface(IBinder obj) {
      if (obj == null) {
        return null;
      }
      IInterface iin = obj.queryLocalInterface(IsReadyToPayServiceCallback.DESCRIPTOR);
      if (iin != null && (iin instanceof IsReadyToPayServiceCallback)) {
        return (IsReadyToPayServiceCallback) iin;
      }
      return new Proxy(obj);
    }

    @Override
    public IBinder asBinder() {
      return this;
    }

    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
        throws RemoteException {
      if (code >= 1 && code <= 16777215) {
        data.enforceInterface(IsReadyToPayServiceCallback.DESCRIPTOR);
      }
      switch (code) {
        case 1598968902:
          reply.writeString(IsReadyToPayServiceCallback.DESCRIPTOR);
          return true;
        default:
          switch (code) {
            case 1:
              boolean _arg0 = data.readInt() != 0;
              handleIsReadyToPay(_arg0);
              return true;
            default:
              return super.onTransact(code, data, reply, flags);
          }
      }
    }

    private static class Proxy implements IsReadyToPayServiceCallback {
      private IBinder mRemote;

      Proxy(IBinder remote) {
        this.mRemote = remote;
      }

      @Override
      public IBinder asBinder() {
        return this.mRemote;
      }

      public String getInterfaceDescriptor() {
        return IsReadyToPayServiceCallback.DESCRIPTOR;
      }

      @Override
      public void handleIsReadyToPay(boolean isReadyToPay) throws RemoteException {
        Parcel _data = Parcel.obtain();
        try {
          _data.writeInterfaceToken(IsReadyToPayServiceCallback.DESCRIPTOR);
          _data.writeInt(isReadyToPay ? 1 : 0);
          this.mRemote.transact(1, _data, null, 1);
        } finally {
          _data.recycle();
        }
      }
    }
  }
}
