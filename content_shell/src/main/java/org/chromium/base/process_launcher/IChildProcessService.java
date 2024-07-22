package org.chromium.base.process_launcher;

import android.content.pm.ApplicationInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

public interface IChildProcessService extends IInterface {
  public static final String DESCRIPTOR = "org.chromium.base.process_launcher.IChildProcessService";

  boolean bindToCaller(String str) throws RemoteException;

  void consumeRelroBundle(Bundle bundle) throws RemoteException;

  void dumpProcessStack() throws RemoteException;

  void forceKill() throws RemoteException;

  ApplicationInfo getAppInfo() throws RemoteException;

  void onMemoryPressure(int i) throws RemoteException;

  void setupConnection(Bundle bundle, IParentProcess iParentProcess, List<IBinder> list)
      throws RemoteException;

  public static class Default implements IChildProcessService {
    @Override
    public boolean bindToCaller(String clazz) throws RemoteException {
      return false;
    }

    @Override
    public ApplicationInfo getAppInfo() throws RemoteException {
      return null;
    }

    @Override
    public void setupConnection(
        Bundle args, IParentProcess parentProcess, List<IBinder> clientInterfaces)
        throws RemoteException {}

    @Override
    public void forceKill() throws RemoteException {}

    @Override
    public void onMemoryPressure(int pressure) throws RemoteException {}

    @Override
    public void dumpProcessStack() throws RemoteException {}

    @Override
    public void consumeRelroBundle(Bundle bundle) throws RemoteException {}

    @Override
    public IBinder asBinder() {
      return null;
    }
  }

  public abstract static class Stub extends Binder implements IChildProcessService {
    static final int TRANSACTION_bindToCaller = 1;
    static final int TRANSACTION_consumeRelroBundle = 7;
    static final int TRANSACTION_dumpProcessStack = 6;
    static final int TRANSACTION_forceKill = 4;
    static final int TRANSACTION_getAppInfo = 2;
    static final int TRANSACTION_onMemoryPressure = 5;
    static final int TRANSACTION_setupConnection = 3;

    public Stub() {
      attachInterface(this, IChildProcessService.DESCRIPTOR);
    }

    public static IChildProcessService asInterface(IBinder obj) {
      if (obj == null) {
        return null;
      }
      IInterface iin = obj.queryLocalInterface(IChildProcessService.DESCRIPTOR);
      if (iin != null && (iin instanceof IChildProcessService)) {
        return (IChildProcessService) iin;
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
        data.enforceInterface(IChildProcessService.DESCRIPTOR);
      }
      switch (code) {
        case 1598968902:
          reply.writeString(IChildProcessService.DESCRIPTOR);
          return true;
        default:
          switch (code) {
            case 1:
              String _arg0 = data.readString();
              boolean bindToCaller = bindToCaller(_arg0);
              reply.writeNoException();
              reply.writeInt(bindToCaller ? 1 : 0);
              break;
            case 2:
              ApplicationInfo _result = getAppInfo();
              reply.writeNoException();
              _Parcel.writeTypedObject(reply, _result, 1);
              break;
            case 3:
              Bundle _arg02 = (Bundle) _Parcel.readTypedObject(data, Bundle.CREATOR);
              IParentProcess _arg1 = IParentProcess.Stub.asInterface(data.readStrongBinder());
              List<IBinder> _arg2 = data.createBinderArrayList();
              setupConnection(_arg02, _arg1, _arg2);
              break;
            case 4:
              forceKill();
              break;
            case 5:
              int _arg03 = data.readInt();
              onMemoryPressure(_arg03);
              break;
            case 6:
              dumpProcessStack();
              break;
            case 7:
              Bundle _arg04 = (Bundle) _Parcel.readTypedObject(data, Bundle.CREATOR);
              consumeRelroBundle(_arg04);
              break;
            default:
              return super.onTransact(code, data, reply, flags);
          }
          return true;
      }
    }

    private static class Proxy implements IChildProcessService {
      private IBinder mRemote;

      Proxy(IBinder remote) {
        this.mRemote = remote;
      }

      @Override
      public IBinder asBinder() {
        return this.mRemote;
      }

      public String getInterfaceDescriptor() {
        return IChildProcessService.DESCRIPTOR;
      }

      @Override
      public boolean bindToCaller(String clazz) throws RemoteException {
        Parcel _data = Parcel.obtain();
        Parcel _reply = Parcel.obtain();
        try {
          _data.writeInterfaceToken(IChildProcessService.DESCRIPTOR);
          _data.writeString(clazz);
          this.mRemote.transact(1, _data, _reply, 0);
          _reply.readException();
          boolean _status = _reply.readInt() != 0;
          return _status;
        } finally {
          _reply.recycle();
          _data.recycle();
        }
      }

      @Override
      public ApplicationInfo getAppInfo() throws RemoteException {
        Parcel _data = Parcel.obtain();
        Parcel _reply = Parcel.obtain();
        try {
          _data.writeInterfaceToken(IChildProcessService.DESCRIPTOR);
          this.mRemote.transact(2, _data, _reply, 0);
          _reply.readException();
          ApplicationInfo _result =
              (ApplicationInfo) _Parcel.readTypedObject(_reply, ApplicationInfo.CREATOR);
          return _result;
        } finally {
          _reply.recycle();
          _data.recycle();
        }
      }

      @Override
      public void setupConnection(
          Bundle args, IParentProcess parentProcess, List<IBinder> clientInterfaces)
          throws RemoteException {
        Parcel _data = Parcel.obtain();
        try {
          _data.writeInterfaceToken(IChildProcessService.DESCRIPTOR);
          _Parcel.writeTypedObject(_data, args, 0);
          _data.writeStrongInterface(parentProcess);
          _data.writeBinderList(clientInterfaces);
          this.mRemote.transact(3, _data, null, 1);
        } finally {
          _data.recycle();
        }
      }

      @Override
      public void forceKill() throws RemoteException {
        Parcel _data = Parcel.obtain();
        try {
          _data.writeInterfaceToken(IChildProcessService.DESCRIPTOR);
          this.mRemote.transact(4, _data, null, 1);
        } finally {
          _data.recycle();
        }
      }

      @Override
      public void onMemoryPressure(int pressure) throws RemoteException {
        Parcel _data = Parcel.obtain();
        try {
          _data.writeInterfaceToken(IChildProcessService.DESCRIPTOR);
          _data.writeInt(pressure);
          this.mRemote.transact(5, _data, null, 1);
        } finally {
          _data.recycle();
        }
      }

      @Override
      public void dumpProcessStack() throws RemoteException {
        Parcel _data = Parcel.obtain();
        try {
          _data.writeInterfaceToken(IChildProcessService.DESCRIPTOR);
          this.mRemote.transact(6, _data, null, 1);
        } finally {
          _data.recycle();
        }
      }

      @Override
      public void consumeRelroBundle(Bundle bundle) throws RemoteException {
        Parcel _data = Parcel.obtain();
        try {
          _data.writeInterfaceToken(IChildProcessService.DESCRIPTOR);
          _Parcel.writeTypedObject(_data, bundle, 0);
          this.mRemote.transact(7, _data, null, 1);
        } finally {
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
