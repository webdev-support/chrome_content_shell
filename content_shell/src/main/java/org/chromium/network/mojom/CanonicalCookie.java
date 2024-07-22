package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;

public final class CanonicalCookie extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 104;
  private static final DataHeader[] VERSION_ARRAY;
  public Time creation;
  public String domain;
  public Time expiry;
  public boolean httponly;
  public Time lastAccess;
  public Time lastUpdate;
  public String name;
  public CookiePartitionKey partitionKey;
  public String path;
  public int priority;
  public boolean secure;
  public int siteRestrictions;
  public int sourcePort;
  public int sourceScheme;
  public String value;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(104, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CanonicalCookie(int version) {
    super(104, version);
    this.secure = false;
    this.httponly = false;
    this.siteRestrictions = 0;
    this.priority = 1;
    this.sourceScheme = 0;
    this.sourcePort = -1;
  }

  public CanonicalCookie() {
    this(0);
  }

  public static CanonicalCookie deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CanonicalCookie deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CanonicalCookie decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CanonicalCookie result = new CanonicalCookie(elementsOrVersion);
      result.name = decoder0.readString(8, false);
      result.value = decoder0.readString(16, false);
      result.domain = decoder0.readString(24, false);
      result.path = decoder0.readString(32, false);
      Decoder decoder1 = decoder0.readPointer(40, false);
      result.creation = Time.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(48, false);
      result.expiry = Time.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(56, false);
      result.lastAccess = Time.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(64, false);
      result.lastUpdate = Time.decode(decoder14);
      result.secure = decoder0.readBoolean(72, 0);
      result.httponly = decoder0.readBoolean(72, 1);
      int readInt = decoder0.readInt(76);
      result.siteRestrictions = readInt;
      CookieSameSite.validate(readInt);
      result.siteRestrictions = CookieSameSite.toKnownValue(result.siteRestrictions);
      int readInt2 = decoder0.readInt(80);
      result.priority = readInt2;
      CookiePriority.validate(readInt2);
      result.priority = CookiePriority.toKnownValue(result.priority);
      int readInt3 = decoder0.readInt(84);
      result.sourceScheme = readInt3;
      CookieSourceScheme.validate(readInt3);
      result.sourceScheme = CookieSourceScheme.toKnownValue(result.sourceScheme);
      Decoder decoder15 = decoder0.readPointer(88, true);
      result.partitionKey = CookiePartitionKey.decode(decoder15);
      result.sourcePort = decoder0.readInt(96);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.name, 8, false);
    encoder0.encode(this.value, 16, false);
    encoder0.encode(this.domain, 24, false);
    encoder0.encode(this.path, 32, false);
    encoder0.encode((Struct) this.creation, 40, false);
    encoder0.encode((Struct) this.expiry, 48, false);
    encoder0.encode((Struct) this.lastAccess, 56, false);
    encoder0.encode((Struct) this.lastUpdate, 64, false);
    encoder0.encode(this.secure, 72, 0);
    encoder0.encode(this.httponly, 72, 1);
    encoder0.encode(this.siteRestrictions, 76);
    encoder0.encode(this.priority, 80);
    encoder0.encode(this.sourceScheme, 84);
    encoder0.encode((Struct) this.partitionKey, 88, true);
    encoder0.encode(this.sourcePort, 96);
  }
}
