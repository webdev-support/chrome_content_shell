package org.chromium.midi;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.chromium.base.ContextUtils;
import org.chromium.base.IntentUtils;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace("midi")
class UsbMidiDeviceFactoryAndroid {

  private static final String ACTION_USB_PERMISSION = "org.chromium.midi.USB_PERMISSION";
  private boolean mIsEnumeratingDevices;
  private long mNativePointer;
  private final List<UsbMidiDeviceAndroid> mDevices = new ArrayList();
  private UsbManager mUsbManager =
      (UsbManager) ContextUtils.getApplicationContext().getSystemService("usb");
  private BroadcastReceiver mPermissionReceiver =
      new BroadcastReceiver() {

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
          if (IntentUtils.isTrustedIntentFromSelf(intent)) {
            if (!UsbMidiDeviceFactoryAndroid.ACTION_USB_PERMISSION.equals(intent.getAction())) {
              throw new AssertionError();
            }
            UsbMidiDeviceFactoryAndroid.this.onUsbDevicePermissionRequestDone(context, intent);
          }
        }
      };
  private BroadcastReceiver mDeviceChangeReceiver =
      new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
          UsbDevice device =
              (UsbDevice) intent.getParcelableExtra(PureJavaExceptionReporter.DEVICE);
          if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(intent.getAction())) {
            UsbMidiDeviceFactoryAndroid.this.requestDevicePermissionIfNecessary(device);
          }
          if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(intent.getAction())) {
            UsbMidiDeviceFactoryAndroid.this.onUsbDeviceDetached(device);
          }
        }
      };
  private Set<UsbDevice> mRequestedDevices = new HashSet();

  public interface Natives {
    void onUsbMidiDeviceAttached(long j, Object obj);

    void onUsbMidiDeviceDetached(long j, int i);

    void onUsbMidiDeviceRequestDone(long j, Object[] objArr);
  }

  UsbMidiDeviceFactoryAndroid(long nativePointer) {
    this.mNativePointer = nativePointer;
    Context context = ContextUtils.getApplicationContext();
    IntentFilter permissionFilter = new IntentFilter();
    permissionFilter.addAction(ACTION_USB_PERMISSION);
    ContextUtils.registerNonExportedBroadcastReceiver(
        context, this.mPermissionReceiver, permissionFilter);
    IntentFilter deviceChangeFilter = new IntentFilter();
    deviceChangeFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
    deviceChangeFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    ContextUtils.registerProtectedBroadcastReceiver(
        context, this.mDeviceChangeReceiver, deviceChangeFilter);
  }

  static UsbMidiDeviceFactoryAndroid create(long nativePointer) {
    return new UsbMidiDeviceFactoryAndroid(nativePointer);
  }

  boolean enumerateDevices() {
    if (this.mIsEnumeratingDevices) {
      throw new AssertionError();
    }
    this.mIsEnumeratingDevices = true;
    Map<String, UsbDevice> devices = this.mUsbManager.getDeviceList();
    if (devices.isEmpty()) {
      this.mIsEnumeratingDevices = false;
      return false;
    }
    for (UsbDevice device : devices.values()) {
      requestDevicePermissionIfNecessary(device);
    }
    return true ^ this.mRequestedDevices.isEmpty();
  }

  public void requestDevicePermissionIfNecessary(UsbDevice device) {
    for (UsbDevice d : this.mRequestedDevices) {
      if (d.getDeviceId() == device.getDeviceId()) {
        return;
      }
    }
    for (int i = 0; i < device.getInterfaceCount(); i++) {
      UsbInterface iface = device.getInterface(i);
      if (iface.getInterfaceClass() == 1 && iface.getInterfaceSubclass() == 3) {
        Context context = ContextUtils.getApplicationContext();
        Intent intent = new Intent(ACTION_USB_PERMISSION);
        intent.setPackage(context.getPackageName());
        IntentUtils.addTrustedIntentExtras(intent);
        this.mUsbManager.requestPermission(
            device,
            PendingIntent.getBroadcast(
                context, 0, intent, IntentUtils.getPendingIntentMutabilityFlag(true)));
        this.mRequestedDevices.add(device);
        return;
      }
    }
  }

  public void onUsbDeviceDetached(UsbDevice device) {
    Iterator<UsbDevice> it = this.mRequestedDevices.iterator();
    while (true) {
      if (!it.hasNext()) {
        break;
      }
      UsbDevice usbDevice = it.next();
      if (usbDevice.getDeviceId() == device.getDeviceId()) {
        this.mRequestedDevices.remove(usbDevice);
        break;
      }
    }
    for (int i = 0; i < this.mDevices.size(); i++) {
      UsbMidiDeviceAndroid midiDevice = this.mDevices.get(i);
      if (!midiDevice.isClosed()
          && midiDevice.getUsbDevice().getDeviceId() == device.getDeviceId()) {
        midiDevice.close();
        if (this.mIsEnumeratingDevices) {
          this.mDevices.remove(i);
          return;
        } else if (this.mNativePointer != 0) {
          UsbMidiDeviceFactoryAndroidJni.get().onUsbMidiDeviceDetached(this.mNativePointer, i);
          return;
        } else {
          return;
        }
      }
    }
  }

  public void onUsbDevicePermissionRequestDone(Context context, Intent intent) {
    UsbDevice device = (UsbDevice) intent.getParcelableExtra(PureJavaExceptionReporter.DEVICE);
    UsbMidiDeviceAndroid midiDevice = null;
    if (this.mRequestedDevices.contains(device)) {
      this.mRequestedDevices.remove(device);
      if (!intent.getBooleanExtra("permission", false)) {
        device = null;
      }
    } else {
      device = null;
    }
    if (device != null) {
      Iterator<UsbMidiDeviceAndroid> it = this.mDevices.iterator();
      while (true) {
        if (!it.hasNext()) {
          break;
        }
        UsbMidiDeviceAndroid registered = it.next();
        if (!registered.isClosed()
            && registered.getUsbDevice().getDeviceId() == device.getDeviceId()) {
          device = null;
          break;
        }
      }
    }
    if (device != null) {
      midiDevice = new UsbMidiDeviceAndroid(this.mUsbManager, device);
      this.mDevices.add(midiDevice);
    }
    if (!this.mRequestedDevices.isEmpty() || this.mNativePointer == 0) {
      return;
    }
    if (this.mIsEnumeratingDevices) {
      UsbMidiDeviceFactoryAndroidJni.get()
          .onUsbMidiDeviceRequestDone(this.mNativePointer, this.mDevices.toArray());
      this.mIsEnumeratingDevices = false;
    } else if (midiDevice != null) {
      UsbMidiDeviceFactoryAndroidJni.get().onUsbMidiDeviceAttached(this.mNativePointer, midiDevice);
    }
  }

  void close() {
    this.mNativePointer = 0L;
    ContextUtils.getApplicationContext().unregisterReceiver(this.mDeviceChangeReceiver);
    ContextUtils.getApplicationContext().unregisterReceiver(this.mPermissionReceiver);
  }
}
