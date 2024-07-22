package org.chromium.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import org.chromium.base.ContextUtils;

class AudioDeviceSelectorPreS extends AudioDeviceSelector {
  private static final int STATE_BLUETOOTH_SCO_INVALID = -1;
  private static final int STATE_BLUETOOTH_SCO_OFF = 0;
  private static final int STATE_BLUETOOTH_SCO_ON = 1;
  private static final int STATE_BLUETOOTH_SCO_TURNING_OFF = 3;
  private static final int STATE_BLUETOOTH_SCO_TURNING_ON = 2;
  private static final String TAG = "media";
  private BroadcastReceiver mBluetoothScoReceiver;
  private int mBluetoothScoState;
  private boolean[] mDeviceExistence;
  private boolean mHasBluetoothPermission;

  public AudioDeviceSelectorPreS(AudioManager audioManager) {
    super(audioManager);
    this.mBluetoothScoState = -1;
    this.mDeviceExistence = new boolean[5];
  }

  @Override
  public void init() {
    this.mHasBluetoothPermission = hasPermission("android.permission.BLUETOOTH");
    this.mDeviceListener.init(this.mHasBluetoothPermission);
    if (this.mHasBluetoothPermission) {
      registerForBluetoothScoIntentBroadcast();
    }
  }

  @Override
  public void close() {
    this.mDeviceListener.close();
    if (this.mHasBluetoothPermission) {
      unregisterForBluetoothScoIntentBroadcast();
    }
  }

  @Override
  public void setCommunicationAudioModeOn(boolean on) {
    if (!on) {
      stopBluetoothSco();
      this.mDeviceStates.clearRequestedDevice();
    }
  }

  @Override
  public boolean isSpeakerphoneOn() {
    return this.mAudioManager.isSpeakerphoneOn();
  }

  @Override
  public void setSpeakerphoneOn(boolean on) {
    boolean wasOn = this.mAudioManager.isSpeakerphoneOn();
    if (wasOn == on) {
      return;
    }
    this.mAudioManager.setSpeakerphoneOn(on);
  }

  @Override
  public boolean[] getAvailableDevices_Locked() {
    boolean[] availableDevices = (boolean[]) this.mDeviceExistence.clone();
    if (availableDevices[1]) {
      availableDevices[4] = false;
      availableDevices[2] = false;
    } else if (availableDevices[4]) {
      availableDevices[2] = false;
    }
    return availableDevices;
  }

  @Override
  public void setDeviceExistence_Locked(int deviceId, boolean exists) {
    this.mDeviceExistence[deviceId] = exists;
  }

  private boolean hasPermission(String permission) {
    return ContextUtils.getApplicationContext().checkSelfPermission(permission) == 0;
  }

  private void registerForBluetoothScoIntentBroadcast() {
    IntentFilter filter = new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
    this.mBluetoothScoReceiver =
        new BroadcastReceiver() {
          @Override // android.content.BroadcastReceiver
          public void onReceive(Context context, Intent intent) {
            int state = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0);
            switch (state) {
              case 0:
                if (AudioDeviceSelectorPreS.this.mBluetoothScoState != 3) {
                  AudioDeviceSelectorPreS.this.maybeUpdateSelectedDevice();
                }
                AudioDeviceSelectorPreS.this.mBluetoothScoState = 0;
                return;
              case 1:
                AudioDeviceSelectorPreS.this.mBluetoothScoState = 1;
                return;
              case 2:
              default:
                return;
            }
          }
        };
    ContextUtils.registerProtectedBroadcastReceiver(
        ContextUtils.getApplicationContext(), this.mBluetoothScoReceiver, filter);
  }

  private void unregisterForBluetoothScoIntentBroadcast() {
    ContextUtils.getApplicationContext().unregisterReceiver(this.mBluetoothScoReceiver);
    this.mBluetoothScoReceiver = null;
  }

  private void startBluetoothSco() {
    int i;
    if (!this.mHasBluetoothPermission || (i = this.mBluetoothScoState) == 1 || i == 2) {
      return;
    }
    if (this.mAudioManager.isBluetoothScoOn()) {
      this.mBluetoothScoState = 1;
      return;
    }
    this.mBluetoothScoState = 2;
    this.mAudioManager.startBluetoothSco();
  }

  private void stopBluetoothSco() {
    if (!this.mHasBluetoothPermission) {
      return;
    }
    int i = this.mBluetoothScoState;
    if (i != 1 && i != 2) {
      return;
    }
    if (!this.mAudioManager.isBluetoothScoOn()) {
      loge("Unable to stop BT SCO since it is already disabled");
      this.mBluetoothScoState = 0;
      return;
    }
    this.mBluetoothScoState = 3;
    this.mAudioManager.stopBluetoothSco();
  }

  @Override
  protected void setAudioDevice(int device) {
    if (device == 3) {
      startBluetoothSco();
    } else {
      stopBluetoothSco();
    }
    switch (device) {
      case 0:
        setSpeakerphoneOn(true);
        return;
      case 1:
        setSpeakerphoneOn(false);
        return;
      case 2:
        setSpeakerphoneOn(false);
        return;
      case 3:
        return;
      case 4:
        setSpeakerphoneOn(false);
        return;
      default:
        loge("Invalid audio device selection");
        return;
    }
  }
}
