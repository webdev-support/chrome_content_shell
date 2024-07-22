package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.GpuMemoryBufferHandle;
import org.chromium.gpu.mojom.MailboxHolder;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class GpuMemoryBufferVideoFrameData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public GpuMemoryBufferHandle gpuMemoryBufferHandle;
  public MailboxHolder[] mailboxHolder;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private GpuMemoryBufferVideoFrameData(int version) {
    super(24, version);
  }

  public GpuMemoryBufferVideoFrameData() {
    this(0);
  }

  public static GpuMemoryBufferVideoFrameData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static GpuMemoryBufferVideoFrameData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static GpuMemoryBufferVideoFrameData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      GpuMemoryBufferVideoFrameData result = new GpuMemoryBufferVideoFrameData(elementsOrVersion);
      result.gpuMemoryBufferHandle = GpuMemoryBufferHandle.decode(decoder0.readPointer(8, false));
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(4);
      result.mailboxHolder = new MailboxHolder[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.mailboxHolder[i1] = MailboxHolder.decode(decoder2);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.gpuMemoryBufferHandle, 8, false);
    MailboxHolder[] mailboxHolderArr = this.mailboxHolder;
    if (mailboxHolderArr == null) {
      encoder0.encodeNullPointer(16, false);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(mailboxHolderArr.length, 16, 4);
    int i0 = 0;
    while (true) {
      MailboxHolder[] mailboxHolderArr2 = this.mailboxHolder;
      if (i0 < mailboxHolderArr2.length) {
        encoder1.encode((Struct) mailboxHolderArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
