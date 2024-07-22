package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.network.mojom.LoadTimingInfo;

public final class ResourceTimingInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 104;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean allowNegativeValues;
  public boolean allowTimingDetails;
  public String alpnNegotiatedProtocol;
  public int cacheState;
  public String connectionInfo;
  public String contentType;
  public long decodedBodySize;
  public boolean didReuseConnection;
  public long encodedBodySize;
  public boolean isSecureTransport;
  public TimeTicks lastRedirectEndTime;
  public String name;
  public boolean renderBlockingStatus;
  public TimeTicks responseEnd;
  public short responseStatus;
  public ServerTimingInfo[] serverTiming;
  public TimeTicks startTime;
  public LoadTimingInfo timing;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(104, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ResourceTimingInfo(int version) {
    super(104, version);
  }

  public ResourceTimingInfo() {
    this(0);
  }

  public static ResourceTimingInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ResourceTimingInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ResourceTimingInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ResourceTimingInfo result = new ResourceTimingInfo(elementsOrVersion);
      result.name = decoder0.readString(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.startTime = TimeTicks.decode(decoder1);
      result.alpnNegotiatedProtocol = decoder0.readString(24, false);
      result.connectionInfo = decoder0.readString(32, false);
      Decoder decoder12 = decoder0.readPointer(40, true);
      result.timing = LoadTimingInfo.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(48, false);
      result.lastRedirectEndTime = TimeTicks.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(56, false);
      result.responseEnd = TimeTicks.decode(decoder14);
      int readInt = decoder0.readInt(64);
      result.cacheState = readInt;
      CacheState.validate(readInt);
      result.cacheState = CacheState.toKnownValue(result.cacheState);
      result.didReuseConnection = decoder0.readBoolean(68, 0);
      result.isSecureTransport = decoder0.readBoolean(68, 1);
      result.allowTimingDetails = decoder0.readBoolean(68, 2);
      result.allowNegativeValues = decoder0.readBoolean(68, 3);
      result.renderBlockingStatus = decoder0.readBoolean(68, 4);
      result.responseStatus = decoder0.readShort(70);
      result.encodedBodySize = decoder0.readLong(72);
      result.decodedBodySize = decoder0.readLong(80);
      Decoder decoder15 = decoder0.readPointer(88, false);
      DataHeader si1 = decoder15.readDataHeaderForPointerArray(-1);
      result.serverTiming = new ServerTimingInfo[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder15.readPointer((i1 * 8) + 8, false);
        result.serverTiming[i1] = ServerTimingInfo.decode(decoder2);
      }
      result.contentType = decoder0.readString(96, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.name, 8, false);
    encoder0.encode((Struct) this.startTime, 16, false);
    encoder0.encode(this.alpnNegotiatedProtocol, 24, false);
    encoder0.encode(this.connectionInfo, 32, false);
    encoder0.encode((Struct) this.timing, 40, true);
    encoder0.encode((Struct) this.lastRedirectEndTime, 48, false);
    encoder0.encode((Struct) this.responseEnd, 56, false);
    encoder0.encode(this.cacheState, 64);
    encoder0.encode(this.didReuseConnection, 68, 0);
    encoder0.encode(this.isSecureTransport, 68, 1);
    encoder0.encode(this.allowTimingDetails, 68, 2);
    encoder0.encode(this.allowNegativeValues, 68, 3);
    encoder0.encode(this.renderBlockingStatus, 68, 4);
    encoder0.encode(this.responseStatus, 70);
    encoder0.encode(this.encodedBodySize, 72);
    encoder0.encode(this.decodedBodySize, 80);
    ServerTimingInfo[] serverTimingInfoArr = this.serverTiming;
    if (serverTimingInfoArr == null) {
      encoder0.encodeNullPointer(88, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(serverTimingInfoArr.length, 88, -1);
      int i0 = 0;
      while (true) {
        ServerTimingInfo[] serverTimingInfoArr2 = this.serverTiming;
        if (i0 >= serverTimingInfoArr2.length) {
          break;
        }
        encoder1.encode((Struct) serverTimingInfoArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.contentType, 96, false);
  }
}
