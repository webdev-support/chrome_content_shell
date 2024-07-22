package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class ResolveHostParameters extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;
  public int cacheUsage;
  public InterfaceRequest<ResolveHostHandle> controlHandle;
  public int dnsQueryType;
  public boolean includeCanonicalName;
  public int initialPriority;
  public boolean isSpeculative;
  public boolean loopbackOnly;
  public int purpose;
  public int secureDnsPolicy;
  public int source;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class Source {
    public static final int ANY = 0;
    public static final int DNS = 2;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int LOCAL_ONLY = 4;
    public static final int MAX_VALUE = 4;
    public static final int MIN_VALUE = 0;
    public static final int MULTICAST_DNS = 3;
    public static final int SYSTEM = 1;

    public @interface EnumType {}

    public static boolean isKnownValue(int value) {
      return value >= 0 && value <= 4;
    }

    public static void validate(int value) {
      if (!isKnownValue(value)) {
        throw new DeserializationException("Invalid enum value.");
      }
    }

    public static int toKnownValue(int value) {
      return value;
    }

    private Source() {}
  }

  public static final class CacheUsage {
    public static final int ALLOWED = 0;
    public static final int DISALLOWED = 2;
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 2;
    public static final int MIN_VALUE = 0;
    public static final int STALE_ALLOWED = 1;

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

    private CacheUsage() {}
  }

  public static final class Purpose {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 1;
    public static final int MIN_VALUE = 0;
    public static final int PRECONNECT = 1;
    public static final int UNSPECIFIED = 0;

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

    private Purpose() {}
  }

  private ResolveHostParameters(int version) {
    super(40, version);
    this.dnsQueryType = 0;
    this.initialPriority = 2;
    this.source = 0;
    this.cacheUsage = 0;
    this.includeCanonicalName = false;
    this.loopbackOnly = false;
    this.isSpeculative = false;
    this.secureDnsPolicy = 0;
    this.purpose = 0;
  }

  public ResolveHostParameters() {
    this(0);
  }

  public static ResolveHostParameters deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ResolveHostParameters deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ResolveHostParameters decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ResolveHostParameters result = new ResolveHostParameters(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.dnsQueryType = readInt;
      DnsQueryType.validate(readInt);
      result.dnsQueryType = DnsQueryType.toKnownValue(result.dnsQueryType);
      int readInt2 = decoder0.readInt(12);
      result.initialPriority = readInt2;
      RequestPriority.validate(readInt2);
      result.initialPriority = RequestPriority.toKnownValue(result.initialPriority);
      int readInt3 = decoder0.readInt(16);
      result.source = readInt3;
      Source.validate(readInt3);
      result.source = Source.toKnownValue(result.source);
      int readInt4 = decoder0.readInt(20);
      result.cacheUsage = readInt4;
      CacheUsage.validate(readInt4);
      result.cacheUsage = CacheUsage.toKnownValue(result.cacheUsage);
      result.controlHandle = decoder0.readInterfaceRequest(24, true);
      result.includeCanonicalName = decoder0.readBoolean(28, 0);
      result.loopbackOnly = decoder0.readBoolean(28, 1);
      result.isSpeculative = decoder0.readBoolean(28, 2);
      int readInt5 = decoder0.readInt(32);
      result.secureDnsPolicy = readInt5;
      SecureDnsPolicy.validate(readInt5);
      result.secureDnsPolicy = SecureDnsPolicy.toKnownValue(result.secureDnsPolicy);
      int readInt6 = decoder0.readInt(36);
      result.purpose = readInt6;
      Purpose.validate(readInt6);
      result.purpose = Purpose.toKnownValue(result.purpose);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.dnsQueryType, 8);
    encoder0.encode(this.initialPriority, 12);
    encoder0.encode(this.source, 16);
    encoder0.encode(this.cacheUsage, 20);
    encoder0.encode((InterfaceRequest) this.controlHandle, 24, true);
    encoder0.encode(this.includeCanonicalName, 28, 0);
    encoder0.encode(this.loopbackOnly, 28, 1);
    encoder0.encode(this.isSpeculative, 28, 2);
    encoder0.encode(this.secureDnsPolicy, 32);
    encoder0.encode(this.purpose, 36);
  }
}
