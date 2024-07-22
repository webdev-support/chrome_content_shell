package org.chromium.media;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.Log;
import org.chromium.base.compat.ApiHelperForS;

class AudioDeviceSelectorPostS extends AudioDeviceSelector {
  private static final String TAG = "media";
  private boolean mHasBluetoothConnectPermission;

  public AudioDeviceSelectorPostS(AudioManager audioManager) {
    super(audioManager);
  }

  private static List<Integer> getTargetTypesFromId(int deviceId) {
    List<Integer> types = new ArrayList<>();
    switch (deviceId) {
      case 0:
        types.add(2);
        break;
      case 1:
        types.add(3);
        types.add(4);
        break;
      case 2:
        types.add(1);
        break;
      case 3:
        types.add(7);
        types.add(8);
        break;
      case 4:
        types.add(22);
        types.add(11);
        break;
    }
    return types;
  }

  @Override
  public void init() {
    boolean hasBluetoothConnectPermission = ApiHelperForS.hasBluetoothConnectPermission();
    this.mHasBluetoothConnectPermission = hasBluetoothConnectPermission;
    if (!hasBluetoothConnectPermission) {
      Log.w(TAG, "BLUETOOTH_CONNECT permission is missing.");
    }
    this.mDeviceListener.init(this.mHasBluetoothConnectPermission);
  }

  @Override
  public void close() {
    this.mDeviceListener.close();
  }

  @Override
  public void setCommunicationAudioModeOn(boolean on) {
    if (!on) {
      this.mDeviceStates.clearRequestedDevice();
      this.mAudioManager.clearCommunicationDevice();
    }
  }

  @Override
  public boolean isSpeakerphoneOn() {
    AudioDeviceInfo currentDevice = this.mAudioManager.getCommunicationDevice();
    return currentDevice != null && currentDevice.getType() == 2;
  }

  @Override
  public void setSpeakerphoneOn(boolean on) {
    boolean isCurrentlyOn = isSpeakerphoneOn();
    if (isCurrentlyOn == on) {
      return;
    }
    if (on) {
      setAudioDevice(0);
      return;
    }
    this.mAudioManager.clearCommunicationDevice();
    maybeUpdateSelectedDevice();
  }

  @Override
  public boolean[] getAvailableDevices_Locked() {
    List<AudioDeviceInfo> communicationDevices =
        this.mAudioManager.getAvailableCommunicationDevices();
    boolean[] availableDevices = new boolean[5];
    for (AudioDeviceInfo device : communicationDevices) {
      switch (device.getType()) {
        case 1:
          availableDevices[2] = true;
          break;
        case 2:
          availableDevices[0] = true;
          break;
        case 3:
        case 4:
          availableDevices[1] = true;
          break;
        case 7:
        case 8:
          availableDevices[3] = true;
          break;
        case 11:
        case 22:
          availableDevices[4] = true;
          break;
      }
    }
    return availableDevices;
  }

  public AudioDeviceInfo getMatchingCommunicationDevice(List<Integer> targetTypes) {
    List<AudioDeviceInfo> availableDevices = this.mAudioManager.getAvailableCommunicationDevices();
    for (AudioDeviceInfo device : availableDevices) {
      if (targetTypes.contains(Integer.valueOf(device.getType()))) {
        return device;
      }
    }
    return null;
  }

  @Override
  protected void setAudioDevice(int deviceId) {
    if (DeviceHelpers.isDeviceValid(deviceId)) {
      AudioDeviceInfo targetDevice = getMatchingCommunicationDevice(getTargetTypesFromId(deviceId));
      if (targetDevice != null) {
        boolean result = this.mAudioManager.setCommunicationDevice(targetDevice);
        if (!result) {
          loge("Error setting communication device");
          return;
        }
        return;
      }
      loge("Couldn't find available device for: " + DeviceHelpers.getDeviceName(deviceId));
    }
  }
}
