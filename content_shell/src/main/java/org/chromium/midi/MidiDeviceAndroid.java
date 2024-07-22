package org.chromium.midi;

import android.media.midi.MidiDevice;
import android.media.midi.MidiDeviceInfo;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.jni_zero.JNINamespace;

@JNINamespace("midi")
public class MidiDeviceAndroid {
  private final MidiDevice mDevice;
  private final MidiInputPortAndroid[] mInputPorts;
  private boolean mIsOpen = true;
  private final MidiOutputPortAndroid[] mOutputPorts =
      new MidiOutputPortAndroid[getInfo().getInputPortCount()];

  public MidiDeviceAndroid(MidiDevice device) {
    this.mDevice = device;
    int i = 0;
    while (true) {
      MidiOutputPortAndroid[] midiOutputPortAndroidArr = this.mOutputPorts;
      if (i >= midiOutputPortAndroidArr.length) {
        break;
      }
      midiOutputPortAndroidArr[i] = new MidiOutputPortAndroid(device, i);
      i++;
    }
    this.mInputPorts = new MidiInputPortAndroid[getInfo().getOutputPortCount()];
    int i2 = 0;
    while (true) {
      MidiInputPortAndroid[] midiInputPortAndroidArr = this.mInputPorts;
      if (i2 < midiInputPortAndroidArr.length) {
        midiInputPortAndroidArr[i2] = new MidiInputPortAndroid(device, i2);
        i2++;
      } else {
        return;
      }
    }
  }

  public boolean isOpen() {
    return this.mIsOpen;
  }

  public void close() {
    MidiInputPortAndroid[] midiInputPortAndroidArr;
    MidiOutputPortAndroid[] midiOutputPortAndroidArr;
    this.mIsOpen = false;
    for (MidiInputPortAndroid port : this.mInputPorts) {
      port.close();
    }
    for (MidiOutputPortAndroid port2 : this.mOutputPorts) {
      port2.close();
    }
  }

  MidiDevice getDevice() {
    return this.mDevice;
  }

  public MidiDeviceInfo getInfo() {
    return this.mDevice.getInfo();
  }

  String getManufacturer() {
    return getProperty("manufacturer");
  }

  String getProduct() {
    String product = getProperty("product");
    if (product == null || product.isEmpty()) {
      return getProperty("name");
    }
    return product;
  }

  String getVersion() {
    return getProperty(XMLWriter.VERSION);
  }

  MidiInputPortAndroid[] getInputPorts() {
    return this.mInputPorts;
  }

  MidiOutputPortAndroid[] getOutputPorts() {
    return this.mOutputPorts;
  }

  private String getProperty(String name) {
    return this.mDevice.getInfo().getProperties().getString(name);
  }
}
