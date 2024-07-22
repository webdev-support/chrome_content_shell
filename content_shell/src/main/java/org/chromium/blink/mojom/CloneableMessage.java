package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.UnguessableToken;
import org.chromium.url.internal.mojom.Origin;

public final class CloneableMessage extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 88;
  private static final DataHeader[] VERSION_ARRAY;
  public SerializedBlob[] blobs;
  public BigBuffer encodedMessage;
  public FileSystemAccessTransferToken[] fileSystemAccessTokens;
  public boolean lockedToSenderAgentCluster;
  public UnguessableToken senderAgentClusterId;
  public Origin senderOrigin;
  public long stackTraceDebuggerIdFirst;
  public long stackTraceDebuggerIdSecond;
  public long stackTraceId;
  public boolean stackTraceShouldPause;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(88, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private CloneableMessage(int version) {
    super(88, version);
  }

  public CloneableMessage() {
    this(0);
  }

  public static CloneableMessage deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static CloneableMessage deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static CloneableMessage decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      CloneableMessage result = new CloneableMessage(elementsOrVersion);
      result.encodedMessage = BigBuffer.decode(decoder0, 8);
      Decoder decoder1 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.blobs = new SerializedBlob[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.blobs[i1] = SerializedBlob.decode(decoder2);
      }
      result.senderOrigin = Origin.decode(decoder0.readPointer(32, true));
      result.stackTraceId = decoder0.readLong(40);
      result.stackTraceDebuggerIdFirst = decoder0.readLong(48);
      result.stackTraceDebuggerIdSecond = decoder0.readLong(56);
      result.stackTraceShouldPause = decoder0.readBoolean(64, 0);
      result.lockedToSenderAgentCluster = decoder0.readBoolean(64, 1);
      result.senderAgentClusterId = UnguessableToken.decode(decoder0.readPointer(72, false));
      result.fileSystemAccessTokens =
          (FileSystemAccessTransferToken[])
              decoder0.readServiceInterfaces(80, 0, -1, FileSystemAccessTransferToken.MANAGER);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Union) this.encodedMessage, 8, false);
    SerializedBlob[] serializedBlobArr = this.blobs;
    if (serializedBlobArr == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(serializedBlobArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        SerializedBlob[] serializedBlobArr2 = this.blobs;
        if (i0 >= serializedBlobArr2.length) {
          break;
        }
        encoder1.encode((Struct) serializedBlobArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.senderOrigin, 32, true);
    encoder0.encode(this.stackTraceId, 40);
    encoder0.encode(this.stackTraceDebuggerIdFirst, 48);
    encoder0.encode(this.stackTraceDebuggerIdSecond, 56);
    encoder0.encode(this.stackTraceShouldPause, 64, 0);
    encoder0.encode(this.lockedToSenderAgentCluster, 64, 1);
    encoder0.encode((Struct) this.senderAgentClusterId, 72, false);
    encoder0.encode(this.fileSystemAccessTokens, 80, 0, -1, FileSystemAccessTransferToken.MANAGER);
  }
}
