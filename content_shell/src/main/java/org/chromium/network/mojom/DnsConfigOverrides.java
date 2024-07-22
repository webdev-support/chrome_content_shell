package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class DnsConfigOverrides extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public int allowDnsOverHttpsUpgrade;
  public int appendToMultiLabelName;
  public int attempts;
  public boolean clearHosts;
  public DnsOverHttpsConfig dnsOverHttpsConfig;
  public TimeDelta fallbackPeriod;
  public IpEndPoint[] nameservers;
  public byte ndots;
  public int rotate;
  public String[] search;
  public int secureDnsMode;
  public int useLocalIpv6;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  public static final class Tristate {
    private static final boolean IS_EXTENSIBLE = false;
    public static final int MAX_VALUE = 2;
    public static final int MIN_VALUE = 0;
    public static final int NO_OVERRIDE = 0;
    public static final int TRISTATE_FALSE = 2;
    public static final int TRISTATE_TRUE = 1;

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

    private Tristate() {}
  }

  private DnsConfigOverrides(int version) {
    super(72, version);
    this.appendToMultiLabelName = 0;
    this.ndots = (byte) -1;
    this.attempts = -1;
    this.rotate = 0;
    this.useLocalIpv6 = 0;
    this.secureDnsMode = 0;
    this.allowDnsOverHttpsUpgrade = 0;
    this.clearHosts = false;
  }

  public DnsConfigOverrides() {
    this(0);
  }

  public static DnsConfigOverrides deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DnsConfigOverrides deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DnsConfigOverrides decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DnsConfigOverrides result = new DnsConfigOverrides(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      if (decoder1 == null) {
        result.nameservers = null;
      } else {
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.nameservers = new IpEndPoint[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.nameservers[i1] = IpEndPoint.decode(decoder2);
        }
      }
      Decoder decoder12 = decoder0.readPointer(16, true);
      if (decoder12 == null) {
        result.search = null;
      } else {
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.search = new String[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          result.search[i12] = decoder12.readString((i12 * 8) + 8, false);
        }
      }
      int readInt = decoder0.readInt(24);
      result.appendToMultiLabelName = readInt;
      Tristate.validate(readInt);
      result.appendToMultiLabelName = Tristate.toKnownValue(result.appendToMultiLabelName);
      result.ndots = decoder0.readByte(28);
      result.clearHosts = decoder0.readBoolean(29, 0);
      result.fallbackPeriod = TimeDelta.decode(decoder0.readPointer(32, true));
      result.attempts = decoder0.readInt(40);
      int readInt2 = decoder0.readInt(44);
      result.rotate = readInt2;
      Tristate.validate(readInt2);
      result.rotate = Tristate.toKnownValue(result.rotate);
      int readInt3 = decoder0.readInt(48);
      result.useLocalIpv6 = readInt3;
      Tristate.validate(readInt3);
      result.useLocalIpv6 = Tristate.toKnownValue(result.useLocalIpv6);
      int readInt4 = decoder0.readInt(52);
      result.secureDnsMode = readInt4;
      OptionalSecureDnsMode.validate(readInt4);
      result.secureDnsMode = OptionalSecureDnsMode.toKnownValue(result.secureDnsMode);
      result.dnsOverHttpsConfig = DnsOverHttpsConfig.decode(decoder0.readPointer(56, true));
      int readInt5 = decoder0.readInt(64);
      result.allowDnsOverHttpsUpgrade = readInt5;
      Tristate.validate(readInt5);
      result.allowDnsOverHttpsUpgrade = Tristate.toKnownValue(result.allowDnsOverHttpsUpgrade);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    IpEndPoint[] ipEndPointArr = this.nameservers;
    if (ipEndPointArr == null) {
      encoder0.encodeNullPointer(8, true);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(ipEndPointArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        IpEndPoint[] ipEndPointArr2 = this.nameservers;
        if (i0 >= ipEndPointArr2.length) {
          break;
        }
        encoder1.encode((Struct) ipEndPointArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    String[] strArr = this.search;
    if (strArr == null) {
      encoder0.encodeNullPointer(16, true);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(strArr.length, 16, -1);
      int i02 = 0;
      while (true) {
        String[] strArr2 = this.search;
        if (i02 >= strArr2.length) {
          break;
        }
        encoder12.encode(strArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    encoder0.encode(this.appendToMultiLabelName, 24);
    encoder0.encode(this.ndots, 28);
    encoder0.encode(this.clearHosts, 29, 0);
    encoder0.encode((Struct) this.fallbackPeriod, 32, true);
    encoder0.encode(this.attempts, 40);
    encoder0.encode(this.rotate, 44);
    encoder0.encode(this.useLocalIpv6, 48);
    encoder0.encode(this.secureDnsMode, 52);
    encoder0.encode((Struct) this.dnsOverHttpsConfig, 56, true);
    encoder0.encode(this.allowDnsOverHttpsUpgrade, 64);
  }
}
