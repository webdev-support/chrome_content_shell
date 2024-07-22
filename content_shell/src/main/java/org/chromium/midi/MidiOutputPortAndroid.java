package org.chromium.midi;

import android.media.midi.MidiDevice;
import android.media.midi.MidiInputPort;
import java.io.IOException;
import org.chromium.base.Log;
import org.jni_zero.JNINamespace;

@JNINamespace("midi")
class MidiOutputPortAndroid {
  private static final String TAG = "midi";
  private final MidiDevice mDevice;
  private final int mIndex;
  private MidiInputPort mPort;

  public MidiOutputPortAndroid(MidiDevice device, int index) {
    this.mDevice = device;
    this.mIndex = index;
  }

  boolean open() {
    if (this.mPort != null) {
      return true;
    }
    MidiInputPort openInputPort = this.mDevice.openInputPort(this.mIndex);
    this.mPort = openInputPort;
    return openInputPort != null;
  }

  void send(byte[] bs) {
    MidiInputPort midiInputPort = this.mPort;
    if (midiInputPort == null) {
      return;
    }
    try {
      midiInputPort.send(bs, 0, bs.length);
    } catch (IOException e) {
      Log.e(TAG, "MidiOutputPortAndroid.send: " + e);
    }
  }

  public void close() {
    MidiInputPort midiInputPort = this.mPort;
    if (midiInputPort == null) {
      return;
    }
    try {
      midiInputPort.close();
    } catch (IOException e) {
    }
    this.mPort = null;
  }
}
