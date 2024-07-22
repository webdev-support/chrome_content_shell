package org.chromium;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IsReadyToPayService extends IInterface {
  public static final String DESCRIPTOR = "org.chromium.IsReadyToPayService";

  void isReadyToPay(IsReadyToPayServiceCallback isReadyToPayServiceCallback) throws RemoteException;

  public static class Default implements IsReadyToPayService {
    @Override
    public void isReadyToPay(IsReadyToPayServiceCallback callback) throws RemoteException {}

    @Override
    public IBinder asBinder() {
      return null;
    }
  }

  public abstract static class Stub extends Binder implements IsReadyToPayService {
    static final int TRANSACTION_isReadyToPay = 1;

    public Stub() {
      attachInterface(this, IsReadyToPayService.DESCRIPTOR);
    }

    public static IsReadyToPayService asInterface(IBinder obj) {
      if (obj == null) {
        return null;
      }
      IInterface iin = obj.queryLocalInterface(IsReadyToPayService.DESCRIPTOR);
      if (iin != null && (iin instanceof IsReadyToPayService)) {
        return (IsReadyToPayService) iin;
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
        data.enforceInterface(IsReadyToPayService.DESCRIPTOR);
      }
      switch (code) {
        case 1598968902:
          reply.writeString(IsReadyToPayService.DESCRIPTOR);
          return true;
        default:
          switch (code) {
            case 1:
              IsReadyToPayServiceCallback _arg0 =
                  IsReadyToPayServiceCallback.Stub.asInterface(data.readStrongBinder());
              isReadyToPay(_arg0);
              return true;
            default:
              return super.onTransact(code, data, reply, flags);
          }
      }
    }

    private static class Proxy implements IsReadyToPayService {
      private IBinder mRemote;

      Proxy(IBinder remote) {
        this.mRemote = remote;
      }

      @Override
      public IBinder asBinder() {
        return this.mRemote;
      }

      public String getInterfaceDescriptor() {
        return IsReadyToPayService.DESCRIPTOR;
      }

      @Override
      public void isReadyToPay(IsReadyToPayServiceCallback callback) throws RemoteException {
        Parcel _data = Parcel.obtain();
        try {
          _data.writeInterfaceToken(IsReadyToPayService.DESCRIPTOR);
          _data.writeStrongInterface(callback);
          this.mRemote.transact(1, _data, null, 1);
        } finally {
          _data.recycle();
        }
      }
    }
  }
}
