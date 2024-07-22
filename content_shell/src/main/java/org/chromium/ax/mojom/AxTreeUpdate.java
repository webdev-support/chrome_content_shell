package org.chromium.ax.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AxTreeUpdate extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public int eventFrom;
  public int eventFromAction;
  public EventIntent[] eventIntents;
  public boolean hasTreeData;
  public int nodeIdToClear;
  public AxNodeData[] nodes;
  public int rootId;
  public AxTreeChecks treeChecks;
  public AxTreeData treeData;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0), new DataHeader(64, 2)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[1];
  }

  private AxTreeUpdate(int version) {
    super(64, version);
  }

  public AxTreeUpdate() {
    this(2);
  }

  public static AxTreeUpdate deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AxTreeUpdate deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AxTreeUpdate decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AxTreeUpdate result = new AxTreeUpdate(elementsOrVersion);
      result.hasTreeData = decoder0.readBoolean(8, 0);
      result.nodeIdToClear = decoder0.readInt(12);
      result.treeData = AxTreeData.decode(decoder0.readPointer(16, false));
      result.rootId = decoder0.readInt(24);
      int readInt = decoder0.readInt(28);
      result.eventFrom = readInt;
      EventFrom.validate(readInt);
      result.eventFrom = EventFrom.toKnownValue(result.eventFrom);
      Decoder decoder1 = decoder0.readPointer(32, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.nodes = new AxNodeData[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.nodes[i1] = AxNodeData.decode(decoder2);
      }
      int readInt2 = decoder0.readInt(40);
      result.eventFromAction = readInt2;
      Action.validate(readInt2);
      result.eventFromAction = Action.toKnownValue(result.eventFromAction);
      Decoder decoder12 = decoder0.readPointer(48, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.eventIntents = new EventIntent[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.eventIntents[i12] = EventIntent.decode(decoder22);
      }
      if (elementsOrVersion >= 2) {
        result.treeChecks = AxTreeChecks.decode(decoder0.readPointer(56, true));
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.hasTreeData, 8, 0);
    encoder0.encode(this.nodeIdToClear, 12);
    encoder0.encode((Struct) this.treeData, 16, false);
    encoder0.encode(this.rootId, 24);
    encoder0.encode(this.eventFrom, 28);
    AxNodeData[] axNodeDataArr = this.nodes;
    if (axNodeDataArr == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(axNodeDataArr.length, 32, -1);
      int i0 = 0;
      while (true) {
        AxNodeData[] axNodeDataArr2 = this.nodes;
        if (i0 >= axNodeDataArr2.length) {
          break;
        }
        encoder1.encode((Struct) axNodeDataArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.eventFromAction, 40);
    EventIntent[] eventIntentArr = this.eventIntents;
    if (eventIntentArr == null) {
      encoder0.encodeNullPointer(48, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(eventIntentArr.length, 48, -1);
      int i02 = 0;
      while (true) {
        EventIntent[] eventIntentArr2 = this.eventIntents;
        if (i02 >= eventIntentArr2.length) {
          break;
        }
        encoder12.encode((Struct) eventIntentArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    encoder0.encode((Struct) this.treeChecks, 56, true);
  }
}
