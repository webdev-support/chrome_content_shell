package org.chromium.ax.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class AxTreeData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 136;
  private static final DataHeader[] VERSION_ARRAY;
  public String doctype;
  public int focusId;
  public AxTreeId focusedTreeId;
  public boolean loaded;
  public float loadingProgress;
  public String[] metadata;
  public String mimetype;
  public AxTreeId parentTreeId;
  public int rootScrollerId;
  public int selAnchorAffinity;
  public int selAnchorObjectId;
  public int selAnchorOffset;
  public int selFocusAffinity;
  public int selFocusObjectId;
  public int selFocusOffset;
  public boolean selIsBackward;
  public String title;
  public AxTreeId treeId;
  public String url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(128, 0), new DataHeader(136, 2)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[1];
  }

  private AxTreeData(int version) {
    super(136, version);
  }

  public AxTreeData() {
    this(2);
  }

  public static AxTreeData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AxTreeData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AxTreeData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AxTreeData result = new AxTreeData(elementsOrVersion);
      result.treeId = AxTreeId.decode(decoder0, 8);
      result.parentTreeId = AxTreeId.decode(decoder0, 24);
      result.focusedTreeId = AxTreeId.decode(decoder0, 40);
      result.doctype = decoder0.readString(56, false);
      result.loaded = decoder0.readBoolean(64, 0);
      result.selIsBackward = decoder0.readBoolean(64, 1);
      result.loadingProgress = decoder0.readFloat(68);
      result.mimetype = decoder0.readString(72, false);
      result.title = decoder0.readString(80, false);
      result.url = decoder0.readString(88, false);
      result.focusId = decoder0.readInt(96);
      result.selAnchorObjectId = decoder0.readInt(100);
      result.selAnchorOffset = decoder0.readInt(104);
      int readInt = decoder0.readInt(108);
      result.selAnchorAffinity = readInt;
      TextAffinity.validate(readInt);
      result.selAnchorAffinity = TextAffinity.toKnownValue(result.selAnchorAffinity);
      result.selFocusObjectId = decoder0.readInt(112);
      result.selFocusOffset = decoder0.readInt(116);
      int readInt2 = decoder0.readInt(120);
      result.selFocusAffinity = readInt2;
      TextAffinity.validate(readInt2);
      result.selFocusAffinity = TextAffinity.toKnownValue(result.selFocusAffinity);
      result.rootScrollerId = decoder0.readInt(124);
      if (elementsOrVersion >= 2) {
        Decoder decoder1 = decoder0.readPointer(128, true);
        if (decoder1 == null) {
          result.metadata = null;
        } else {
          DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
          result.metadata = new String[si1.elementsOrVersion];
          for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
            result.metadata[i1] = decoder1.readString((i1 * 8) + 8, false);
          }
        }
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Union) this.treeId, 8, false);
    encoder0.encode((Union) this.parentTreeId, 24, false);
    encoder0.encode((Union) this.focusedTreeId, 40, false);
    encoder0.encode(this.doctype, 56, false);
    encoder0.encode(this.loaded, 64, 0);
    encoder0.encode(this.selIsBackward, 64, 1);
    encoder0.encode(this.loadingProgress, 68);
    encoder0.encode(this.mimetype, 72, false);
    encoder0.encode(this.title, 80, false);
    encoder0.encode(this.url, 88, false);
    encoder0.encode(this.focusId, 96);
    encoder0.encode(this.selAnchorObjectId, 100);
    encoder0.encode(this.selAnchorOffset, 104);
    encoder0.encode(this.selAnchorAffinity, 108);
    encoder0.encode(this.selFocusObjectId, 112);
    encoder0.encode(this.selFocusOffset, 116);
    encoder0.encode(this.selFocusAffinity, 120);
    encoder0.encode(this.rootScrollerId, 124);
    String[] strArr = this.metadata;
    if (strArr == null) {
      encoder0.encodeNullPointer(128, true);
      return;
    }
    Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 128, -1);
    int i0 = 0;
    while (true) {
      String[] strArr2 = this.metadata;
      if (i0 < strArr2.length) {
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      } else {
        return;
      }
    }
  }
}
