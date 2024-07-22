package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class TransferableMessage extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 72;
  private static final DataHeader[] VERSION_ARRAY;
  public SerializedArrayBufferContents[] arrayBufferContentsArray;
  public int delegatedCapability;
  public SerializedStaticBitmapImage[] imageBitmapContentsArray;
  public CloneableMessage message;
  public TaskAttributionId parentTaskId;
  public MessagePortDescriptor[] ports;
  public MessagePortDescriptor[] streamChannels;
  public UserActivationSnapshot userActivation;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(72, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private TransferableMessage(int version) {
    super(72, version);
    this.delegatedCapability = 0;
  }

  public TransferableMessage() {
    this(0);
  }

  public static TransferableMessage deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static TransferableMessage deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static TransferableMessage decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      TransferableMessage result = new TransferableMessage(elementsOrVersion);
      result.message = CloneableMessage.decode(decoder0.readPointer(8, false));
      Decoder decoder1 = decoder0.readPointer(16, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.ports = new MessagePortDescriptor[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.ports[i1] = MessagePortDescriptor.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(24, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.streamChannels = new MessagePortDescriptor[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.streamChannels[i12] = MessagePortDescriptor.decode(decoder22);
      }
      Decoder decoder13 = decoder0.readPointer(32, false);
      DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
      result.arrayBufferContentsArray = new SerializedArrayBufferContents[si13.elementsOrVersion];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        Decoder decoder23 = decoder13.readPointer((i13 * 8) + 8, false);
        result.arrayBufferContentsArray[i13] = SerializedArrayBufferContents.decode(decoder23);
      }
      Decoder decoder14 = decoder0.readPointer(40, false);
      DataHeader si14 = decoder14.readDataHeaderForPointerArray(-1);
      result.imageBitmapContentsArray = new SerializedStaticBitmapImage[si14.elementsOrVersion];
      for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
        result.imageBitmapContentsArray[i14] =
            SerializedStaticBitmapImage.decode(decoder14, (i14 * 16) + 8);
      }
      result.userActivation = UserActivationSnapshot.decode(decoder0.readPointer(48, true));
      int readInt = decoder0.readInt(56);
      result.delegatedCapability = readInt;
      DelegatedCapability.validate(readInt);
      result.delegatedCapability = DelegatedCapability.toKnownValue(result.delegatedCapability);
      result.parentTaskId = TaskAttributionId.decode(decoder0.readPointer(64, true));
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.message, 8, false);
    MessagePortDescriptor[] messagePortDescriptorArr = this.ports;
    if (messagePortDescriptorArr == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(messagePortDescriptorArr.length, 16, -1);
      int i0 = 0;
      while (true) {
        MessagePortDescriptor[] messagePortDescriptorArr2 = this.ports;
        if (i0 >= messagePortDescriptorArr2.length) {
          break;
        }
        encoder1.encode((Struct) messagePortDescriptorArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    MessagePortDescriptor[] messagePortDescriptorArr3 = this.streamChannels;
    if (messagePortDescriptorArr3 == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(messagePortDescriptorArr3.length, 24, -1);
      int i02 = 0;
      while (true) {
        MessagePortDescriptor[] messagePortDescriptorArr4 = this.streamChannels;
        if (i02 >= messagePortDescriptorArr4.length) {
          break;
        }
        encoder12.encode((Struct) messagePortDescriptorArr4[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    SerializedArrayBufferContents[] serializedArrayBufferContentsArr =
        this.arrayBufferContentsArray;
    if (serializedArrayBufferContentsArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder13 =
          encoder0.encodePointerArray(serializedArrayBufferContentsArr.length, 32, -1);
      int i03 = 0;
      while (true) {
        SerializedArrayBufferContents[] serializedArrayBufferContentsArr2 =
            this.arrayBufferContentsArray;
        if (i03 >= serializedArrayBufferContentsArr2.length) {
          break;
        }
        encoder13.encode((Struct) serializedArrayBufferContentsArr2[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    SerializedStaticBitmapImage[] serializedStaticBitmapImageArr = this.imageBitmapContentsArray;
    if (serializedStaticBitmapImageArr == null) {
      encoder0.encodeNullPointer(40, false);
    } else {
      Encoder encoder14 = encoder0.encodeUnionArray(serializedStaticBitmapImageArr.length, 40, -1);
      int i04 = 0;
      while (true) {
        SerializedStaticBitmapImage[] serializedStaticBitmapImageArr2 =
            this.imageBitmapContentsArray;
        if (i04 >= serializedStaticBitmapImageArr2.length) {
          break;
        }
        encoder14.encode((Union) serializedStaticBitmapImageArr2[i04], (i04 * 16) + 8, false);
        i04++;
      }
    }
    encoder0.encode((Struct) this.userActivation, 48, true);
    encoder0.encode(this.delegatedCapability, 56);
    encoder0.encode((Struct) this.parentTaskId, 64, true);
  }
}
