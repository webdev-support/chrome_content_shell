package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;

public interface CdmFile extends Interface {
  public static final Interface.Manager<CdmFile, Proxy> MANAGER = CdmFile_Internal.MANAGER;

  public interface Proxy extends CdmFile, Interface.Proxy {}

  public interface Read_Response {
    void call(int i, byte[] bArr);
  }

  public interface Write_Response {
    void call(int i);
  }

  void read(Read_Response read_Response);

  void write(byte[] bArr, Write_Response write_Response);

  public static final class Status {
    public static final int FAILURE = 1;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 1;
    public static final int MIN_VALUE = 0;
    public static final int SUCCESS = 0;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 1;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private Status() {}
  }
}
