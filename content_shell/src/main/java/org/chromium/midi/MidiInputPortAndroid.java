package org.chromium.midi;

import android.media.midi.MidiDevice;
import android.media.midi.MidiOutputPort;
import android.media.midi.MidiReceiver;
import java.io.IOException;
import org.jni_zero.JNINamespace;

@JNINamespace("midi")
class MidiInputPortAndroid {
  private final MidiDevice mDevice;
  private final int mIndex;
  private long mNativeReceiverPointer;
  private MidiOutputPort mPort;

  public interface Natives {
    void onData(long j, byte[] bArr, int i, int i2, long j2);
  }

  public MidiInputPortAndroid(MidiDevice device, int index) {
    this.mDevice = device;
    this.mIndex = index;
  }

  boolean open(long nativeReceiverPointer) {
    if (this.mPort != null) {
      return true;
    }
    MidiOutputPort openOutputPort = this.mDevice.openOutputPort(this.mIndex);
    this.mPort = openOutputPort;
    if (openOutputPort == null) {
      return false;
    }
    this.mNativeReceiverPointer = nativeReceiverPointer;
    openOutputPort.connect(
        new MidiReceiver() {
          @Override
          public void onSend(byte[] bs, int offset, int count, long timestamp) {
            synchronized (MidiInputPortAndroid.this) {
              if (MidiInputPortAndroid.this.mPort == null) {
                return;
              }
              MidiInputPortAndroidJni.get()
                  .onData(
                      MidiInputPortAndroid.this.mNativeReceiverPointer,
                      bs,
                      offset,
                      count,
                      timestamp);
            }
          }
        });
    return true;
  }

  public synchronized void close() {
    MidiOutputPort midiOutputPort = this.mPort;
    if (midiOutputPort == null) {
      return;
    }
    try {
      midiOutputPort.close();
    } catch (IOException e) {
    }
    this.mNativeReceiverPointer = 0L;
    this.mPort = null;
  }
}
