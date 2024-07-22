package org.chromium.services.device;

import org.chromium.components.crash.PureJavaExceptionReporter;
import org.chromium.device.battery.BatteryMonitorFactory;
import org.chromium.device.mojom.BatteryMonitor;
import org.chromium.device.mojom.NfcProvider;
import org.chromium.device.mojom.VibrationManager;
import org.chromium.device.nfc.NfcDelegate;
import org.chromium.device.nfc.NfcProviderImpl;
import org.chromium.device.vibration.VibrationManagerImpl;
import org.chromium.mojo.system.impl.CoreImpl;
import org.chromium.services.service_manager.InterfaceRegistry;
import org.jni_zero.JNINamespace;

@JNINamespace(PureJavaExceptionReporter.DEVICE)
class InterfaceRegistrar {
  InterfaceRegistrar() {}

  static void createInterfaceRegistryForContext(long nativeHandle, NfcDelegate nfcDelegate) {
    InterfaceRegistry registry =
        InterfaceRegistry.create(
            CoreImpl.getInstance().acquireNativeHandle(nativeHandle).toMessagePipeHandle());
    registry.addInterface(BatteryMonitor.MANAGER, new BatteryMonitorFactory());
    registry.addInterface(NfcProvider.MANAGER, new NfcProviderImpl.Factory(nfcDelegate));
    registry.addInterface(VibrationManager.MANAGER, new VibrationManagerImpl.Factory());
  }
}
