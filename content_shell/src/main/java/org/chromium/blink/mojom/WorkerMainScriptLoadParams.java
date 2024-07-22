package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.network.mojom.UrlLoaderClientEndpoints;
import org.chromium.network.mojom.UrlRequestRedirectInfo;
import org.chromium.network.mojom.UrlResponseHead;

public final class WorkerMainScriptLoadParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public UrlRequestRedirectInfo[] redirectInfos;
  public UrlResponseHead[] redirectResponseHeads;
  public int requestId;
  public DataPipe.ConsumerHandle responseBody;
  public UrlResponseHead responseHead;
  public UrlLoaderClientEndpoints urlLoaderClientEndpoints;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WorkerMainScriptLoadParams(int version) {
    super(48, version);
    this.responseBody = InvalidHandle.INSTANCE;
  }

  public WorkerMainScriptLoadParams() {
    this(0);
  }

  public static WorkerMainScriptLoadParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WorkerMainScriptLoadParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WorkerMainScriptLoadParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WorkerMainScriptLoadParams result = new WorkerMainScriptLoadParams(elementsOrVersion);
      result.requestId = decoder0.readInt(8);
      result.responseBody = decoder0.readConsumerHandle(12, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.responseHead = UrlResponseHead.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.urlLoaderClientEndpoints = UrlLoaderClientEndpoints.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
      result.redirectInfos = new UrlRequestRedirectInfo[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder13.readPointer((i1 * 8) + 8, false);
        result.redirectInfos[i1] = UrlRequestRedirectInfo.decode(decoder2);
      }
      Decoder decoder14 = decoder0.readPointer(40, false);
      DataHeader si12 = decoder14.readDataHeaderForPointerArray(-1);
      result.redirectResponseHeads = new UrlResponseHead[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder14.readPointer((i12 * 8) + 8, false);
        result.redirectResponseHeads[i12] = UrlResponseHead.decode(decoder22);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.requestId, 8);
    encoder0.encode((Handle) this.responseBody, 12, false);
    encoder0.encode((Struct) this.responseHead, 16, false);
    encoder0.encode((Struct) this.urlLoaderClientEndpoints, 24, true);
    UrlRequestRedirectInfo[] urlRequestRedirectInfoArr = this.redirectInfos;
    if (urlRequestRedirectInfoArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(urlRequestRedirectInfoArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        UrlRequestRedirectInfo[] urlRequestRedirectInfoArr2 = this.redirectInfos;
        if (i0 >= urlRequestRedirectInfoArr2.length) {
          break;
        }
        encoder1.encode((Struct) urlRequestRedirectInfoArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    UrlResponseHead[] urlResponseHeadArr = this.redirectResponseHeads;
    if (urlResponseHeadArr == null) {
      encoder0.encodeNullPointer(40, false);
      return;
    }
    Encoder encoder12 = encoder0.encodePointerArray(urlResponseHeadArr.length, 40, -1);
    int i02 = 0;
    while (true) {
      UrlResponseHead[] urlResponseHeadArr2 = this.redirectResponseHeads;
      if (i02 < urlResponseHeadArr2.length) {
        encoder12.encode((Struct) urlResponseHeadArr2[i02], (i02 * 8) + 8, false);
        i02++;
      } else {
        return;
      }
    }
  }
}
