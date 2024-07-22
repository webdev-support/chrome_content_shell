package org.chromium.base.process_launcher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public interface IParentProcess extends IInterface {
  public static final String DESCRIPTOR = "org.chromium.base.process_launcher.IParentProcess";

  void finishSetupConnection(int i, int i2, long j, Bundle bundle) throws RemoteException;

  void reportCleanExit() throws RemoteException;

  void reportExceptionInInit(String str) throws RemoteException;

  public static class Default implements IParentProcess {
    @Override
    public void finishSetupConnection(
        int pid, int zygotePid, long zygoteStartupTimeMillis, Bundle relroBundle)
        throws RemoteException {}

    @Override
    public void reportExceptionInInit(String exception) throws RemoteException {}

    @Override
    public void reportCleanExit() throws RemoteException {}

    @Override
    public IBinder asBinder() {
      return null;
    }
  }

  public abstract static class Stub extends Binder implements IParentProcess {
    static final int TRANSACTION_finishSetupConnection = 1;
    static final int TRANSACTION_reportCleanExit = 3;
    static final int TRANSACTION_reportExceptionInInit = 2;

    public Stub() {
      attachInterface(this, IParentProcess.DESCRIPTOR);
    }

    public static IParentProcess asInterface(IBinder obj) {
      if (obj == null) {
        return null;
      }
      IInterface iin = obj.queryLocalInterface(IParentProcess.DESCRIPTOR);
      if (iin != null && (iin instanceof IParentProcess)) {
        return (IParentProcess) iin;
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
        data.enforceInterface(IParentProcess.DESCRIPTOR);
      }
      switch (code) {
        case 1598968902:
          reply.writeString(IParentProcess.DESCRIPTOR);
          return true;
        default:
          switch (code) {
            case 1:
              int _arg0 = data.readInt();
              int _arg1 = data.readInt();
              long _arg2 = data.readLong();
              Bundle _arg3 = (Bundle) _Parcel.readTypedObject(data, Bundle.CREATOR);
              finishSetupConnection(_arg0, _arg1, _arg2, _arg3);
              break;
            case 2:
              String _arg02 = data.readString();
              reportExceptionInInit(_arg02);
              reply.writeNoException();
              break;
            case 3:
              reportCleanExit();
              reply.writeNoException();
              break;
            default:
              return super.onTransact(code, data, reply, flags);
          }
          return true;
      }
    }

    private static class Proxy implements IParentProcess {
      private IBinder mRemote;

      Proxy(IBinder remote) {
        this.mRemote = remote;
      }

      @Override
      public IBinder asBinder() {
        return this.mRemote;
      }

      public String getInterfaceDescriptor() {
        return IParentProcess.DESCRIPTOR;
      }

      @Override
      public void finishSetupConnection(
          int pid, int zygotePid, long zygoteStartupTimeMillis, Bundle relroBundle)
          throws RemoteException {
        Parcel _data = Parcel.obtain();
        try {
          _data.writeInterfaceToken(IParentProcess.DESCRIPTOR);
          _data.writeInt(pid);
          _data.writeInt(zygotePid);
          _data.writeLong(zygoteStartupTimeMillis);
          _Parcel.writeTypedObject(_data, relroBundle, 0);
          this.mRemote.transact(1, _data, null, 1);
        } finally {
          _data.recycle();
        }
      }

      @Override
      public void reportExceptionInInit(String exception) throws RemoteException {
        Parcel _data = Parcel.obtain();
        Parcel _reply = Parcel.obtain();
        try {
          _data.writeInterfaceToken(IParentProcess.DESCRIPTOR);
          _data.writeString(exception);
          this.mRemote.transact(2, _data, _reply, 0);
          _reply.readException();
        } finally {
          _reply.recycle();
          _data.recycle();
        }
      }

      @Override
      public void reportCleanExit() throws RemoteException {
        Parcel _data = Parcel.obtain();
        Parcel _reply = Parcel.obtain();
        try {
          _data.writeInterfaceToken(IParentProcess.DESCRIPTOR);
          this.mRemote.transact(3, _data, _reply, 0);
          _reply.readException();
        } finally {
          _reply.recycle();
          _data.recycle();
        }
      }
    }
  }

  public static class _Parcel {

    public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> c) {
      if (parcel.readInt() != 0) {
        return c.createFromParcel(parcel);
      }
      return null;
    }

    public static <T extends Parcelable> void writeTypedObject(
        Parcel parcel, T value, int parcelableFlags) {
      if (value != null) {
        parcel.writeInt(1);
        value.writeToParcel(parcel, parcelableFlags);
        return;
      }
      parcel.writeInt(0);
    }
  }
}
