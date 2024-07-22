package org.chromium.device.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.chromium.base.ContextUtils;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
class PlatformSensorProvider {
  private final Set<PlatformSensor> mActiveSensors = new HashSet();
  private Handler mHandler;
  private SensorManager mSensorManager;
  private HandlerThread mSensorsThread;

  public Handler getHandler() {
    return this.mHandler;
  }

  public SensorManager getSensorManager() {
    return this.mSensorManager;
  }

  public void sensorStarted(PlatformSensor sensor) {
    synchronized (this.mActiveSensors) {
      if (this.mActiveSensors.isEmpty()) {
        startSensorThread();
      }
      this.mActiveSensors.add(sensor);
    }
  }

  public void sensorStopped(PlatformSensor sensor) {
    synchronized (this.mActiveSensors) {
      this.mActiveSensors.remove(sensor);
      if (this.mActiveSensors.isEmpty()) {
        stopSensorThread();
      }
    }
  }

  protected void startSensorThread() {
    if (this.mSensorsThread == null) {
      HandlerThread handlerThread = new HandlerThread("SensorsHandlerThread");
      this.mSensorsThread = handlerThread;
      handlerThread.start();
      this.mHandler = new Handler(this.mSensorsThread.getLooper());
    }
  }

  protected void stopSensorThread() {
    if (this.mSensorsThread != null) {
      this.mSensorsThread.quitSafely();
      this.mSensorsThread = null;
      this.mHandler = null;
    }
  }

  protected PlatformSensorProvider(Context context) {
    this.mSensorManager = (SensorManager) context.getSystemService("sensor");
  }

  protected static PlatformSensorProvider createForTest(Context context) {
    return new PlatformSensorProvider(context);
  }

  protected static PlatformSensorProvider create() {
    return new PlatformSensorProvider(ContextUtils.getApplicationContext());
  }

  protected void setSensorManagerToNullForTesting() {
    this.mSensorManager = null;
  }

  protected boolean hasSensorType(int type) {
    int sensorType;
    SensorManager sensorManager = this.mSensorManager;
    if (sensorManager == null) {
      return false;
    }
    switch (type) {
      case 0:
        sensorType = 5;
        break;
      case 1:
      case 7:
      case 8:
      case 10:
      default:
        return false;
      case 2:
        sensorType = 1;
        break;
      case 3:
        sensorType = 10;
        break;
      case 4:
        sensorType = 9;
        break;
      case 5:
        sensorType = 4;
        break;
      case 6:
        sensorType = 2;
        break;
      case 9:
        sensorType = 11;
        break;
      case 11:
        sensorType = 15;
        break;
    }
    List<Sensor> sensors = sensorManager.getSensorList(sensorType);
    return !sensors.isEmpty();
  }
}
