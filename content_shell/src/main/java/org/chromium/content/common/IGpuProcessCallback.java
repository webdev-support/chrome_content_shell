package org.chromium.content.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.Surface;
import org.chromium.base.UnguessableToken;

public interface IGpuProcessCallback extends IInterface {
  public static final String DESCRIPTOR = "org.chromium.content.common.IGpuProcessCallback";

  void forwardSurfaceForSurfaceRequest(UnguessableToken unguessableToken, Surface surface)
      throws RemoteException;

  SurfaceWrapper getViewSurface(int i) throws RemoteException;

  public static class Default implements IGpuProcessCallback {
    @Override
    public void forwardSurfaceForSurfaceRequest(UnguessableToken requestToken, Surface surface)
        throws RemoteException {}

    @Override
    public SurfaceWrapper getViewSurface(int surfaceId) throws RemoteException {
      return null;
    }

    @Override
    public IBinder asBinder() {
      return null;
    }
  }

  public abstract static class Stub extends Binder implements IGpuProcessCallback {
    static final int TRANSACTION_forwardSurfaceForSurfaceRequest = 1;
    static final int TRANSACTION_getViewSurface = 2;

    public Stub() {
      attachInterface(this, IGpuProcessCallback.DESCRIPTOR);
    }

    public static IGpuProcessCallback asInterface(IBinder obj) {
      if (obj == null) {
        return null;
      }
      IInterface iin = obj.queryLocalInterface(IGpuProcessCallback.DESCRIPTOR);
      if (iin != null && (iin instanceof IGpuProcessCallback)) {
        return (IGpuProcessCallback) iin;
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
        data.enforceInterface(IGpuProcessCallback.DESCRIPTOR);
      }
      switch (code) {
        case 1598968902:
          reply.writeString(IGpuProcessCallback.DESCRIPTOR);
          return true;
        default:
          switch (code) {
            case 1:
              UnguessableToken _arg0 =
                  (UnguessableToken) _Parcel.readTypedObject(data, UnguessableToken.CREATOR);
              Surface _arg1 = (Surface) _Parcel.readTypedObject(data, Surface.CREATOR);
              forwardSurfaceForSurfaceRequest(_arg0, _arg1);
              break;
            case 2:
              int _arg02 = data.readInt();
              SurfaceWrapper _result = getViewSurface(_arg02);
              reply.writeNoException();
              _Parcel.writeTypedObject(reply, _result, 1);
              break;
            default:
              return super.onTransact(code, data, reply, flags);
          }
          return true;
      }
    }

    private static class Proxy implements IGpuProcessCallback {
      private IBinder mRemote;

      Proxy(IBinder remote) {
        this.mRemote = remote;
      }

      @Override
      public IBinder asBinder() {
        return this.mRemote;
      }

      public String getInterfaceDescriptor() {
        return IGpuProcessCallback.DESCRIPTOR;
      }

      @Override
      public void forwardSurfaceForSurfaceRequest(UnguessableToken requestToken, Surface surface)
          throws RemoteException {
        Parcel _data = Parcel.obtain();
        try {
          _data.writeInterfaceToken(IGpuProcessCallback.DESCRIPTOR);
          _Parcel.writeTypedObject(_data, requestToken, 0);
          _Parcel.writeTypedObject(_data, surface, 0);
          this.mRemote.transact(1, _data, null, 1);
        } finally {
          _data.recycle();
        }
      }

      @Override
      public SurfaceWrapper getViewSurface(int surfaceId) throws RemoteException {
        Parcel _data = Parcel.obtain();
        Parcel _reply = Parcel.obtain();
        try {
          _data.writeInterfaceToken(IGpuProcessCallback.DESCRIPTOR);
          _data.writeInt(surfaceId);
          this.mRemote.transact(2, _data, _reply, 0);
          _reply.readException();
          SurfaceWrapper _result =
              (SurfaceWrapper) _Parcel.readTypedObject(_reply, SurfaceWrapper.CREATOR);
          return _result;
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
