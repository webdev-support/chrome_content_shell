package org.chromium.media;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.components.crash.PureJavaExceptionReporter;

public class AudioDeviceListener {
  private static final String CONNECTION_HISTOGRAM_PREFIX = "Media.AudioDeviceConnectionStatus.";
  private static final boolean DEBUG = false;
  private static final String TAG = "media";
  private BroadcastReceiver mBluetoothHeadsetReceiver;
  private final AudioDeviceSelector.Devices mDeviceStates;
  private boolean mHasBluetoothPermission;
  private BroadcastReceiver mUsbAudioReceiver;
  private final UsbManager mUsbManager =
      (UsbManager) ContextUtils.getApplicationContext().getSystemService("usb");
  private BroadcastReceiver mWiredHeadsetReceiver;

  @Retention(RetentionPolicy.SOURCE)
  public @interface ConnectionStatus {
    public static final int CONNECTED = 2;
    public static final int CONNECTING = 1;
    public static final int DISCONNECTED = 0;
    public static final int DISCONNECTING = 3;
    public static final int MAX_VALUE = 4;
  }

  public AudioDeviceListener(AudioDeviceSelector.Devices devices) {
    this.mDeviceStates = devices;
  }

  public void init(boolean hasBluetoothPermission) {
    this.mDeviceStates.setDeviceExistence(2, hasEarpiece());
    this.mDeviceStates.setDeviceExistence(4, hasUsbAudio());
    this.mDeviceStates.setDeviceExistence(0, true);
    this.mHasBluetoothPermission = hasBluetoothPermission;
    registerBluetoothIntentsIfNeeded();
    registerForWiredHeadsetIntentBroadcast();
    registerForUsbAudioIntentBroadcast();
  }

  public void close() {
    unregisterForWiredHeadsetIntentBroadcast();
    unregisterBluetoothIntentsIfNeeded();
    unregisterForUsbAudioIntentBroadcast();
  }

  private void registerBluetoothIntentsIfNeeded() {
    if (!this.mHasBluetoothPermission) {
      Log.w(TAG, "registerBluetoothIntentsIfNeeded: Requires BLUETOOTH permission");
      return;
    }
    this.mDeviceStates.setDeviceExistence(3, hasBluetoothHeadset());
    registerForBluetoothHeadsetIntentBroadcast();
  }

  private void unregisterBluetoothIntentsIfNeeded() {
    if (this.mHasBluetoothPermission) {
      ContextUtils.getApplicationContext().unregisterReceiver(this.mBluetoothHeadsetReceiver);
      this.mBluetoothHeadsetReceiver = null;
    }
  }

  private boolean hasBluetoothHeadset() {
    if (!this.mHasBluetoothPermission) {
      Log.w(TAG, "hasBluetoothHeadset() requires BLUETOOTH permission");
      return false;
    }
    BluetoothManager btManager =
        (BluetoothManager) ContextUtils.getApplicationContext().getSystemService("bluetooth");
    BluetoothAdapter btAdapter = btManager.getAdapter();
    if (btAdapter == null) {
      return false;
    }
    int profileConnectionState = btAdapter.getProfileConnectionState(1);
    return btAdapter.isEnabled() && profileConnectionState == 2;
  }

  public boolean hasUsbAudio() {
    try {
      Map<String, UsbDevice> devices = this.mUsbManager.getDeviceList();
      for (UsbDevice device : devices.values()) {
        if (hasUsbAudioCommInterface(device)) {
          return true;
        }
      }
      return false;
    } catch (NullPointerException e) {
      return false;
    }
  }

  private void registerForWiredHeadsetIntentBroadcast() {
    IntentFilter filter = new IntentFilter("android.intent.action.HEADSET_PLUG");
    this.mWiredHeadsetReceiver =
        new BroadcastReceiver() {
          private static final int HAS_MIC = 1;
          private static final int HAS_NO_MIC = 0;
          private static final int STATE_PLUGGED = 1;
          private static final int STATE_UNPLUGGED = 0;

          @Override // android.content.BroadcastReceiver
          public void onReceive(Context context, Intent intent) {
            int state = intent.getIntExtra("state", 0);
            int histogramValue = 0;
            switch (state) {
              case 0:
                AudioDeviceListener.this.mDeviceStates.setDeviceExistence(1, false);
                histogramValue = 0;
                break;
              case 1:
                AudioDeviceListener.this.mDeviceStates.setDeviceExistence(1, true);
                histogramValue = 2;
                break;
            }
            AudioDeviceListener.this.mDeviceStates.onPotentialDeviceStatusChange();
            AudioDeviceListener.recordConnectionHistogram("Wired", histogramValue);
          }
        };
    ContextUtils.registerProtectedBroadcastReceiver(
        ContextUtils.getApplicationContext(), this.mWiredHeadsetReceiver, filter);
  }

  private void unregisterForWiredHeadsetIntentBroadcast() {
    ContextUtils.getApplicationContext().unregisterReceiver(this.mWiredHeadsetReceiver);
    this.mWiredHeadsetReceiver = null;
  }

  private void registerForBluetoothHeadsetIntentBroadcast() {
    IntentFilter filter =
        new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
    this.mBluetoothHeadsetReceiver =
        new BroadcastReceiver() {
          @Override // android.content.BroadcastReceiver
          public void onReceive(Context context, Intent intent) {
            int profileState = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
            int histogramValue = 0;
            switch (profileState) {
              case 0:
                AudioDeviceListener.this.mDeviceStates.setDeviceExistence(3, false);
                AudioDeviceListener.this.mDeviceStates.onPotentialDeviceStatusChange();
                histogramValue = 0;
                break;
              case 1:
                histogramValue = 1;
                break;
              case 2:
                AudioDeviceListener.this.mDeviceStates.setDeviceExistence(3, true);
                AudioDeviceListener.this.mDeviceStates.onPotentialDeviceStatusChange();
                histogramValue = 2;
                break;
              case 3:
                histogramValue = 3;
                break;
            }
            AudioDeviceListener.recordConnectionHistogram("Bluetooth", histogramValue);
          }
        };
    ContextUtils.registerProtectedBroadcastReceiver(
        ContextUtils.getApplicationContext(), this.mBluetoothHeadsetReceiver, filter);
  }

  public boolean hasUsbAudioCommInterface(UsbDevice device) {
    for (int i = 0; i < device.getInterfaceCount(); i++) {
      UsbInterface iface = device.getInterface(i);
      if (iface.getInterfaceClass() == 1 && iface.getInterfaceSubclass() == 2) {
        return true;
      }
    }
    return false;
  }

  private void registerForUsbAudioIntentBroadcast() {
    this.mUsbAudioReceiver =
        new BroadcastReceiver() {
          @Override // android.content.BroadcastReceiver
          public void onReceive(Context context, Intent intent) {
            UsbDevice device =
                (UsbDevice) intent.getParcelableExtra(PureJavaExceptionReporter.DEVICE);
            if (AudioDeviceListener.this.hasUsbAudioCommInterface(device)) {
              int histogramValue = 0;
              if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(intent.getAction())) {
                AudioDeviceListener.this.mDeviceStates.setDeviceExistence(4, true);
                histogramValue = 2;
              } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED"
                      .equals(intent.getAction())
                  && !AudioDeviceListener.this.hasUsbAudio()) {
                AudioDeviceListener.this.mDeviceStates.setDeviceExistence(4, false);
                histogramValue = 0;
              }
              AudioDeviceListener.this.mDeviceStates.onPotentialDeviceStatusChange();
              AudioDeviceListener.recordConnectionHistogram("USB", histogramValue);
            }
          }
        };
    IntentFilter filter = new IntentFilter();
    filter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
    filter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    ContextUtils.registerProtectedBroadcastReceiver(
        ContextUtils.getApplicationContext(), this.mUsbAudioReceiver, filter);
  }

  private void unregisterForUsbAudioIntentBroadcast() {
    ContextUtils.getApplicationContext().unregisterReceiver(this.mUsbAudioReceiver);
    this.mUsbAudioReceiver = null;
  }

  private boolean hasEarpiece() {
    return ContextUtils.getApplicationContext()
        .getPackageManager()
        .hasSystemFeature("android.hardware.telephony");
  }

  public static void recordConnectionHistogram(String name, int value) {
    RecordHistogram.recordEnumeratedHistogram(CONNECTION_HISTOGRAM_PREFIX + name, value, 4);
  }

  private static void logd(String msg) {
    Log.d(TAG, msg, new Object[0]);
  }

  private static void loge(String msg) {
    Log.e(TAG, msg);
  }

  BroadcastReceiver getWiredHeadsetReceiverForTesting() {
    return this.mWiredHeadsetReceiver;
  }

  BroadcastReceiver getBluetoothHeadsetReceiverForTesting() {
    return this.mBluetoothHeadsetReceiver;
  }

  BroadcastReceiver getUsbReceiverForTesting() {
    return this.mUsbAudioReceiver;
  }
}
