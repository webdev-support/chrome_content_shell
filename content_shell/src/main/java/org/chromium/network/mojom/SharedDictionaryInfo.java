package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.url.mojom.Url;

public final class SharedDictionaryInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 80;
  private static final DataHeader[] VERSION_ARRAY;
  public Url dictionaryUrl;
  public TimeDelta expiration;
  public Sha256HashValue hash;

  public String f704id;
  public Time lastUsedTime;
  public String match;
  public int[] matchDest;
  public Time responseTime;
  public long size;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(80, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SharedDictionaryInfo(int version) {
    super(80, version);
  }

  public SharedDictionaryInfo() {
    this(0);
  }

  public static SharedDictionaryInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SharedDictionaryInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SharedDictionaryInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SharedDictionaryInfo result = new SharedDictionaryInfo(elementsOrVersion);
      result.match = decoder0.readString(8, false);
      result.matchDest = decoder0.readInts(16, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.matchDest;
        if (i1 < iArr.length) {
          RequestDestination.validate(iArr[i1]);
          i1++;
        } else {
          result.f704id = decoder0.readString(24, false);
          Decoder decoder1 = decoder0.readPointer(32, false);
          result.dictionaryUrl = Url.decode(decoder1);
          Decoder decoder12 = decoder0.readPointer(40, false);
          result.responseTime = Time.decode(decoder12);
          Decoder decoder13 = decoder0.readPointer(48, false);
          result.expiration = TimeDelta.decode(decoder13);
          Decoder decoder14 = decoder0.readPointer(56, false);
          result.lastUsedTime = Time.decode(decoder14);
          result.size = decoder0.readLong(64);
          Decoder decoder15 = decoder0.readPointer(72, false);
          result.hash = Sha256HashValue.decode(decoder15);
          return result;
        }
      }
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.match, 8, false);
    encoder0.encode(this.matchDest, 16, 0, -1);
    encoder0.encode(this.f704id, 24, false);
    encoder0.encode((Struct) this.dictionaryUrl, 32, false);
    encoder0.encode((Struct) this.responseTime, 40, false);
    encoder0.encode((Struct) this.expiration, 48, false);
    encoder0.encode((Struct) this.lastUsedTime, 56, false);
    encoder0.encode(this.size, 64);
    encoder0.encode((Struct) this.hash, 72, false);
  }
}
