package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.url.mojom.Url;

public final class LinkHeader extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 40;
  private static final DataHeader[] VERSION_ARRAY;

  public int f699as;
  public int crossOrigin;
  public int fetchPriority;
  public Url href;
  public String mimeType;
  public int rel;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(40, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private LinkHeader(int version) {
    super(40, version);
    this.f699as = 0;
    this.crossOrigin = 0;
    this.fetchPriority = 1;
  }

  public LinkHeader() {
    this(0);
  }

  public static LinkHeader deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static LinkHeader deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static LinkHeader decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      LinkHeader result = new LinkHeader(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.href = Url.decode(decoder1);
      int readInt = decoder0.readInt(16);
      result.rel = readInt;
      LinkRelAttribute.validate(readInt);
      result.rel = LinkRelAttribute.toKnownValue(result.rel);
      int readInt2 = decoder0.readInt(20);
      result.f699as = readInt2;
      LinkAsAttribute.validate(readInt2);
      result.f699as = LinkAsAttribute.toKnownValue(result.f699as);
      int readInt3 = decoder0.readInt(24);
      result.crossOrigin = readInt3;
      CrossOriginAttribute.validate(readInt3);
      result.crossOrigin = CrossOriginAttribute.toKnownValue(result.crossOrigin);
      int readInt4 = decoder0.readInt(28);
      result.fetchPriority = readInt4;
      FetchPriorityAttribute.validate(readInt4);
      result.fetchPriority = FetchPriorityAttribute.toKnownValue(result.fetchPriority);
      result.mimeType = decoder0.readString(32, true);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.href, 8, false);
    encoder0.encode(this.rel, 16);
    encoder0.encode(this.f699as, 20);
    encoder0.encode(this.crossOrigin, 24);
    encoder0.encode(this.fetchPriority, 28);
    encoder0.encode(this.mimeType, 32, true);
  }
}
