package org.chromium.device.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.chromium.base.Log;
import org.chromium.components.crash.PureJavaExceptionReporter;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
public class PlatformSensor implements SensorEventListener {
  private static final double MICROSECONDS_IN_SECOND = 1000000.0d;
  private static final double SECONDS_IN_MICROSECOND = 1.0E-6d;
  private static final double SECONDS_IN_NANOSECOND = 1.0E-9d;
  private static final double SENSOR_FREQUENCY_NORMAL = 5.0d;
  private static final String TAG = "PlatformSensor";
  private double mCurrentPollingFrequency;
  private final Object mLock = new Object();
  private final int mMinDelayUsec;
  private long mNativePlatformSensorAndroid;
  private final PlatformSensorProvider mProvider;
  private final int mReadingCount;
  private final Sensor mSensor;

  public interface Natives {
    void notifyPlatformSensorError(long j, PlatformSensor platformSensor);

    void updatePlatformSensorReading(
        long j,
        PlatformSensor platformSensor,
        double d,
        double d2,
        double d3,
        double d4,
        double d5);
  }

  public static PlatformSensor create(
      PlatformSensorProvider provider, int type, long nativePlatformSensorAndroid) {
    int sensorType;
    int readingCount;
    SensorManager sensorManager = provider.getSensorManager();
    if (sensorManager == null) {
      return null;
    }
    switch (type) {
      case 0:
        sensorType = 5;
        readingCount = 1;
        break;
      case 1:
      case 7:
      case 8:
      case 10:
      default:
        return null;
      case 2:
        sensorType = 1;
        readingCount = 3;
        break;
      case 3:
        sensorType = 10;
        readingCount = 3;
        break;
      case 4:
        sensorType = 9;
        readingCount = 3;
        break;
      case 5:
        sensorType = 4;
        readingCount = 3;
        break;
      case 6:
        sensorType = 2;
        readingCount = 3;
        break;
      case 9:
        sensorType = 11;
        readingCount = 4;
        break;
      case 11:
        sensorType = 15;
        readingCount = 4;
        break;
    }
    List<Sensor> sensors = sensorManager.getSensorList(sensorType);
    if (sensors.isEmpty()) {
      return null;
    }
    return new PlatformSensor(sensors.get(0), readingCount, provider, nativePlatformSensorAndroid);
  }

  protected PlatformSensor(
      Sensor sensor,
      int readingCount,
      PlatformSensorProvider provider,
      long nativePlatformSensorAndroid) {
    this.mReadingCount = readingCount;
    this.mProvider = provider;
    this.mSensor = sensor;
    this.mNativePlatformSensorAndroid = nativePlatformSensorAndroid;
    this.mMinDelayUsec = sensor.getMinDelay();
  }

  protected int getReportingMode() {
    if (this.mSensor.getReportingMode() == 0) {
      return 1;
    }
    return 0;
  }

  protected double getDefaultConfiguration() {
    return SENSOR_FREQUENCY_NORMAL;
  }

  protected double getMaximumSupportedFrequency() {
    int i = this.mMinDelayUsec;
    return i == 0 ? getDefaultConfiguration() : 1.0d / (i * SECONDS_IN_MICROSECOND);
  }

  protected void startSensor(double frequency) {
    boolean sensorStarted;
    if (this.mCurrentPollingFrequency == frequency) {
      return;
    }
    unregisterListener();
    this.mProvider.sensorStarted(this);
    try {
      sensorStarted =
          this.mProvider
              .getSensorManager()
              .registerListener(
                  this, this.mSensor, getSamplingPeriod(frequency), this.mProvider.getHandler());
    } catch (RuntimeException e) {
      Log.w(TAG, "Failed to register sensor listener.", (Throwable) e);
      sensorStarted = false;
    }
    if (!sensorStarted) {
      stopSensor();
      synchronized (this.mLock) {
        sensorError();
      }
      return;
    }
    this.mCurrentPollingFrequency = frequency;
  }

  private void unregisterListener() {
    if (this.mCurrentPollingFrequency == 0.0d) {
      return;
    }
    this.mProvider.getSensorManager().unregisterListener(this, this.mSensor);
  }

  protected void stopSensor() {
    unregisterListener();
    this.mProvider.sensorStopped(this);
    this.mCurrentPollingFrequency = 0.0d;
  }

  protected boolean checkSensorConfiguration(double frequency) {
    return this.mMinDelayUsec <= getSamplingPeriod(frequency);
  }

  protected void sensorDestroyed() {
    synchronized (this.mLock) {
      this.mNativePlatformSensorAndroid = 0L;
    }
  }

  private int getSamplingPeriod(double frequency) {
    return (int) ((1.0d / frequency) * MICROSECONDS_IN_SECOND);
  }

  protected void sensorError() {
    if (this.mNativePlatformSensorAndroid != 0) {
      PlatformSensorJni.get().notifyPlatformSensorError(this.mNativePlatformSensorAndroid, this);
    }
  }

  protected void updateSensorReading(
      double timestamp, double value1, double value2, double value3, double value4) {
    PlatformSensorJni.get()
        .updatePlatformSensorReading(
            this.mNativePlatformSensorAndroid, this, timestamp, value1, value2, value3, value4);
  }

  @Override // android.hardware.SensorEventListener
  public void onAccuracyChanged(Sensor sensor, int accuracy) {}

  @Override // android.hardware.SensorEventListener
  public void onSensorChanged(SensorEvent event) {
    synchronized (this.mLock) {
      if (this.mNativePlatformSensorAndroid != 0) {
        if (event.values.length < this.mReadingCount) {
          sensorError();
          stopSensor();
          return;
        }
        double timestamp = event.timestamp * SECONDS_IN_NANOSECOND;
        switch (event.values.length) {
          case 1:
            updateSensorReading(timestamp, event.values[0], 0.0d, 0.0d, 0.0d);
            break;
          case 2:
            updateSensorReading(timestamp, event.values[0], event.values[1], 0.0d, 0.0d);
            break;
          case 3:
            updateSensorReading(timestamp, event.values[0], event.values[1], event.values[2], 0.0d);
            break;
          default:
            updateSensorReading(
                timestamp, event.values[0], event.values[1], event.values[2], event.values[3]);
            break;
        }
        return;
      }
      Log.w(TAG, "Should not get sensor events after PlatformSensorAndroid is destroyed.");
    }
  }

  public void simulateSensorEventForTesting(int readingValuesLength) {
    try {
      Constructor<SensorEvent> sensorEventConstructor =
          SensorEvent.class.getDeclaredConstructor(Integer.TYPE);
      sensorEventConstructor.setAccessible(true);
      SensorEvent event = sensorEventConstructor.newInstance(Integer.valueOf(readingValuesLength));
      event.timestamp = 123L;
      for (int i = 0; i < readingValuesLength; i++) {
        event.values[i] = (float) (i + 0.1d);
      }
      onSensorChanged(event);
    } catch (IllegalAccessException
        | InstantiationException
        | NoSuchMethodException
        | InvocationTargetException e) {
      Log.e(TAG, "Failed to create simulated SensorEvent.", (Throwable) e);
    }
  }
}
