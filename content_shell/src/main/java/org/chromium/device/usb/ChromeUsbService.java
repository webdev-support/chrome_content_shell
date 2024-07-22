package org.chromium.device.usb;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import java.util.HashMap;
import org.chromium.base.ContextUtils;
import org.chromium.base.IntentUtils;
import org.chromium.base.Log;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
final class ChromeUsbService {
  private static final String ACTION_USB_PERMISSION = "org.chromium.device.ACTION_USB_PERMISSION";
  private static final String TAG = "Usb";
  BroadcastReceiver mUsbDeviceChangeReceiver;
  UsbManager mUsbManager =
      (UsbManager) ContextUtils.getApplicationContext().getSystemService("usb");
  BroadcastReceiver mUsbPermissionReceiver;
  long mUsbServiceAndroid;

  public interface Natives {
    void deviceAttached(long j, ChromeUsbService chromeUsbService, UsbDevice usbDevice);

    void deviceDetached(long j, ChromeUsbService chromeUsbService, int i);

    void devicePermissionRequestComplete(
        long j, ChromeUsbService chromeUsbService, int i, boolean z);
  }

  private ChromeUsbService(long usbServiceAndroid) {
    this.mUsbServiceAndroid = usbServiceAndroid;
    registerForUsbDeviceIntentBroadcasts();
    Log.v(TAG, "ChromeUsbService created.", new Object[0]);
  }

  private static ChromeUsbService create(long usbServiceAndroid) {
    return new ChromeUsbService(usbServiceAndroid);
  }

  private Object[] getDevices() {
    HashMap<String, UsbDevice> deviceList = this.mUsbManager.getDeviceList();
    return deviceList.values().toArray();
  }

  private UsbDeviceConnection openDevice(ChromeUsbDevice wrapper) {
    UsbDevice device = wrapper.getDevice();
    return this.mUsbManager.openDevice(device);
  }

  private boolean hasDevicePermission(ChromeUsbDevice wrapper) {
    UsbDevice device = wrapper.getDevice();
    return this.mUsbManager.hasPermission(device);
  }

  private void requestDevicePermission(ChromeUsbDevice wrapper) {
    UsbDevice device = wrapper.getDevice();
    if (this.mUsbManager.hasPermission(device)) {
      ChromeUsbServiceJni.get()
          .devicePermissionRequestComplete(
              this.mUsbServiceAndroid, this, device.getDeviceId(), true);
      return;
    }
    Context context = ContextUtils.getApplicationContext();
    Intent intent = new Intent(ACTION_USB_PERMISSION);
    intent.setPackage(context.getPackageName());
    IntentUtils.addTrustedIntentExtras(intent);
    PendingIntent pendingIntent =
        PendingIntent.getBroadcast(
            context, 0, intent, IntentUtils.getPendingIntentMutabilityFlag(true));
    this.mUsbManager.requestPermission(wrapper.getDevice(), pendingIntent);
  }

  private void close() {
    unregisterForUsbDeviceIntentBroadcasts();
  }

  private void registerForUsbDeviceIntentBroadcasts() {
    this.mUsbPermissionReceiver =
        new BroadcastReceiver() {
          @Override // android.content.BroadcastReceiver
          public void onReceive(Context context, Intent intent) {
            if (IntentUtils.isTrustedIntentFromSelf(intent)) {
              if (!ChromeUsbService.ACTION_USB_PERMISSION.equals(intent.getAction())) {
                throw new AssertionError();
              }
              UsbDevice device =
                  (UsbDevice) intent.getParcelableExtra(PureJavaExceptionReporter.DEVICE);
              ChromeUsbServiceJni.get()
                  .devicePermissionRequestComplete(
                      ChromeUsbService.this.mUsbServiceAndroid,
                      ChromeUsbService.this,
                      device.getDeviceId(),
                      intent.getBooleanExtra("permission", false));
            }
          }
        };
    this.mUsbDeviceChangeReceiver =
        new BroadcastReceiver() {
          @Override // android.content.BroadcastReceiver
          public void onReceive(Context context, Intent intent) {
            UsbDevice device =
                (UsbDevice) intent.getParcelableExtra(PureJavaExceptionReporter.DEVICE);
            if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(intent.getAction())) {
              ChromeUsbServiceJni.get()
                  .deviceAttached(
                      ChromeUsbService.this.mUsbServiceAndroid, ChromeUsbService.this, device);
            } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED"
                .equals(intent.getAction())) {
              ChromeUsbServiceJni.get()
                  .deviceDetached(
                      ChromeUsbService.this.mUsbServiceAndroid,
                      ChromeUsbService.this,
                      device.getDeviceId());
            }
          }
        };
    Context context = ContextUtils.getApplicationContext();
    IntentFilter permissionFilter = new IntentFilter();
    permissionFilter.addAction(ACTION_USB_PERMISSION);
    ContextUtils.registerNonExportedBroadcastReceiver(
        context, this.mUsbPermissionReceiver, permissionFilter);
    IntentFilter deviceChangeFilter = new IntentFilter();
    deviceChangeFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
    deviceChangeFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    ContextUtils.registerProtectedBroadcastReceiver(
        context, this.mUsbDeviceChangeReceiver, deviceChangeFilter);
  }

  private void unregisterForUsbDeviceIntentBroadcasts() {
    ContextUtils.getApplicationContext().unregisterReceiver(this.mUsbDeviceChangeReceiver);
    this.mUsbDeviceChangeReceiver = null;
    ContextUtils.getApplicationContext().unregisterReceiver(this.mUsbPermissionReceiver);
    this.mUsbPermissionReceiver = null;
  }
}
