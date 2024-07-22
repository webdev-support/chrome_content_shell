package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class UsageBreakdown extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public long backgroundFetch;
  public long fileSystem;
  public long indexedDatabase;
  public long serviceWorker;
  public long serviceWorkerCache;
  public long webSql;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UsageBreakdown(int version) {
    super(56, version);
    this.fileSystem = 0L;
    this.webSql = 0L;
    this.indexedDatabase = 0L;
    this.serviceWorkerCache = 0L;
    this.serviceWorker = 0L;
    this.backgroundFetch = 0L;
  }

  public UsageBreakdown() {
    this(0);
  }

  public static UsageBreakdown deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UsageBreakdown deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UsageBreakdown decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UsageBreakdown result = new UsageBreakdown(elementsOrVersion);
      result.fileSystem = decoder0.readLong(8);
      result.webSql = decoder0.readLong(16);
      result.indexedDatabase = decoder0.readLong(24);
      result.serviceWorkerCache = decoder0.readLong(32);
      result.serviceWorker = decoder0.readLong(40);
      result.backgroundFetch = decoder0.readLong(48);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.fileSystem, 8);
    encoder0.encode(this.webSql, 16);
    encoder0.encode(this.indexedDatabase, 24);
    encoder0.encode(this.serviceWorkerCache, 32);
    encoder0.encode(this.serviceWorker, 40);
    encoder0.encode(this.backgroundFetch, 48);
  }
}
