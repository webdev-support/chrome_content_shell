package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

public interface MdnsListenClient extends Interface {
  public static final Interface.Manager<MdnsListenClient, Proxy> MANAGER =
      MdnsListenClient_Internal.MANAGER;

  public interface Proxy extends MdnsListenClient, Interface.Proxy {}

  void onAddressResult(int i, int i2, IpEndPoint ipEndPoint);

  void onHostnameResult(int i, int i2, HostPortPair hostPortPair);

  void onTextResult(int i, int i2, String[] strArr);

  void onUnhandledResult(int i, int i2);

  public static final class UpdateType {
    public static final int ADDED = 0;
    public static final int CHANGED = 1;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 2;
    public static final int MIN_VALUE = 0;
    public static final int REMOVED = 2;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 2;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private UpdateType() {}
  }
}
