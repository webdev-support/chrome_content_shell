package org.chromium.midi;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.hardware.usb.UsbRequest;
import android.os.Handler;
import android.util.SparseArray;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.jni_zero.JNINamespace;

@JNINamespace("midi")
class UsbMidiDeviceAndroid {
  static final int MIDI_SUBCLASS = 3;
  static final int REQUEST_GET_DESCRIPTOR = 6;
  static final int STRING_DESCRIPTOR_TYPE = 3;
  private final UsbDeviceConnection mConnection;
  private UsbDevice mUsbDevice;
  private final SparseArray<UsbEndpoint> mEndpointMap = new SparseArray<>();
  private final Map<UsbEndpoint, UsbRequest> mRequestMap = new HashMap();
  private final Handler mHandler = new Handler();
  private boolean mIsClosed = false;
  private boolean mHasInputThread = false;
  private long mNativePointer = 0;

  public interface Natives {
    void onData(long j, int i, byte[] bArr);
  }

  public UsbMidiDeviceAndroid(UsbManager manager, UsbDevice device) {
    this.mConnection = manager.openDevice(device);
    this.mUsbDevice = device;
    for (int i = 0; i < device.getInterfaceCount(); i++) {
      UsbInterface iface = device.getInterface(i);
      if (iface.getInterfaceClass() == 1 && iface.getInterfaceSubclass() == 3) {
        this.mConnection.claimInterface(iface, true);
        for (int j = 0; j < iface.getEndpointCount(); j++) {
          UsbEndpoint endpoint = iface.getEndpoint(j);
          if (endpoint.getDirection() == 0) {
            this.mEndpointMap.put(endpoint.getEndpointNumber(), endpoint);
          }
        }
      }
    }
    startListen(device);
  }

  /* JADX WARN: Type inference failed for: r1v3, types: [org.chromium.midi.UsbMidiDeviceAndroid$1] */
  private void startListen(UsbDevice device) {
    final Map<UsbEndpoint, ByteBuffer> bufferForEndpoints = new HashMap<>();
    for (int i = 0; i < device.getInterfaceCount(); i++) {
      UsbInterface iface = device.getInterface(i);
      if (iface.getInterfaceClass() == 1 && iface.getInterfaceSubclass() == 3) {
        for (int j = 0; j < iface.getEndpointCount(); j++) {
          UsbEndpoint endpoint = iface.getEndpoint(j);
          if (endpoint.getDirection() == 128) {
            ByteBuffer buffer = ByteBuffer.allocate(endpoint.getMaxPacketSize());
            UsbRequest request = new UsbRequest();
            request.initialize(this.mConnection, endpoint);
            request.queue(buffer, buffer.remaining());
            bufferForEndpoints.put(endpoint, buffer);
          }
        }
      }
    }
    if (bufferForEndpoints.isEmpty()) {
      return;
    }
    this.mHasInputThread = true;
    new Thread() {
      @Override
      public void run() {
        while (true) {
          UsbRequest request2 = UsbMidiDeviceAndroid.this.mConnection.requestWait();
          if (request2 != null) {
            UsbEndpoint endpoint2 = request2.getEndpoint();
            if (endpoint2.getDirection() == 128) {
              ByteBuffer buffer2 = (ByteBuffer) bufferForEndpoints.get(endpoint2);
              int length = UsbMidiDeviceAndroid.getInputDataLength(buffer2);
              if (length > 0) {
                ByteBuffer byteBuffer = (ByteBuffer) buffer2.rewind();
                byte[] bs = new byte[length];
                buffer2.get(bs, 0, length);
                UsbMidiDeviceAndroid.this.postOnDataEvent(endpoint2.getEndpointNumber(), bs);
              }
              ByteBuffer byteBuffer2 = (ByteBuffer) buffer2.rewind();
              request2.queue(buffer2, buffer2.capacity());
            }
          } else {
            return;
          }
        }
      }
    }.start();
  }

  public void postOnDataEvent(final int endpointNumber, final byte[] bs) {
    this.mHandler.post(
        new Runnable() {
          @Override
          public void run() {
            if (UsbMidiDeviceAndroid.this.mIsClosed) {
              return;
            }
            UsbMidiDeviceAndroidJni.get()
                .onData(UsbMidiDeviceAndroid.this.mNativePointer, endpointNumber, bs);
          }
        });
  }

  public UsbDevice getUsbDevice() {
    return this.mUsbDevice;
  }

  public boolean isClosed() {
    return this.mIsClosed;
  }

  void registerSelf(long nativePointer) {
    this.mNativePointer = nativePointer;
  }

  void send(int endpointNumber, byte[] bs) {
    UsbEndpoint endpoint;
    if (this.mIsClosed || (endpoint = this.mEndpointMap.get(endpointNumber)) == null) {
      return;
    }
    if (shouldUseBulkTransfer()) {
      this.mConnection.bulkTransfer(endpoint, bs, bs.length, 100);
      return;
    }
    UsbRequest request = this.mRequestMap.get(endpoint);
    if (request == null) {
      request = new UsbRequest();
      request.initialize(this.mConnection, endpoint);
      this.mRequestMap.put(endpoint, request);
    }
    request.queue(ByteBuffer.wrap(bs), bs.length);
  }

  private boolean shouldUseBulkTransfer() {
    return this.mHasInputThread;
  }

  byte[] getDescriptors() {
    UsbDeviceConnection usbDeviceConnection = this.mConnection;
    if (usbDeviceConnection == null) {
      return new byte[0];
    }
    return usbDeviceConnection.getRawDescriptors();
  }

  byte[] getStringDescriptor(int index) {
    UsbDeviceConnection usbDeviceConnection = this.mConnection;
    if (usbDeviceConnection == null) {
      return new byte[0];
    }
    byte[] buffer = new byte[255];
    int value = index | 768;
    int read = usbDeviceConnection.controlTransfer(128, 6, value, 0, buffer, buffer.length, 0);
    if (read < 0) {
      return new byte[0];
    }
    return Arrays.copyOf(buffer, read);
  }

  public void close() {
    this.mEndpointMap.clear();
    for (UsbRequest request : this.mRequestMap.values()) {
      request.close();
    }
    this.mRequestMap.clear();
    this.mConnection.close();
    this.mNativePointer = 0L;
    this.mIsClosed = true;
  }

  public static int getInputDataLength(ByteBuffer buffer) {
    int position = buffer.position();
    for (int i = 0; i < position; i += 4) {
      if (buffer.get(i) == 0) {
        return i;
      }
    }
    return position;
  }
}
