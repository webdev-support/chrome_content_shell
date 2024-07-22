package org.chromium.display.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Point;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.FilePath;

public final class DisplaySnapshot extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 168;
  private static final DataHeader[] VERSION_ARRAY;
  public long baseConnectorId;
  public DisplaySnapshotColorInfo colorInfo;
  public short connectorIndex;
  public long currentModeIndex;
  public long displayId;
  public String displayName;
  public byte[] edid;
  public long edidDisplayId;
  public boolean hasContentProtectionKey;
  public boolean hasCurrentMode;
  public boolean hasNativeMode;
  public boolean hasOverscan;
  public boolean isAspectPreservingScaling;
  public Size maximumCursorSize;
  public DisplayMode[] modes;
  public long nativeModeIndex;
  public Point origin;
  public int panelOrientation;
  public long[] pathTopology;
  public Size physicalSize;
  public long portDisplayId;
  public int privacyScreenState;
  public long productCode;
  public FilePath sysPath;
  public int type;
  public int variableRefreshRateState;
  public short vsyncRateMin;
  public int yearOfManufacture;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(168, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private DisplaySnapshot(int version) {
    super(168, version);
  }

  public DisplaySnapshot() {
    this(0);
  }

  public static DisplaySnapshot deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static DisplaySnapshot deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static DisplaySnapshot decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      DisplaySnapshot result = new DisplaySnapshot(elementsOrVersion);
      result.displayId = decoder0.readLong(8);
      result.portDisplayId = decoder0.readLong(16);
      result.edidDisplayId = decoder0.readLong(24);
      result.connectorIndex = decoder0.readShort(32);
      result.isAspectPreservingScaling = decoder0.readBoolean(34, 0);
      result.hasOverscan = decoder0.readBoolean(34, 1);
      result.hasContentProtectionKey = decoder0.readBoolean(34, 2);
      result.hasCurrentMode = decoder0.readBoolean(34, 3);
      result.hasNativeMode = decoder0.readBoolean(34, 4);
      int readInt = decoder0.readInt(36);
      result.type = readInt;
      DisplayConnectionType.validate(readInt);
      result.type = DisplayConnectionType.toKnownValue(result.type);
      Decoder decoder1 = decoder0.readPointer(40, false);
      result.origin = Point.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(48, false);
      result.physicalSize = Size.decode(decoder12);
      result.baseConnectorId = decoder0.readLong(56);
      result.pathTopology = decoder0.readLongs(64, 0, -1);
      int readInt2 = decoder0.readInt(72);
      result.privacyScreenState = readInt2;
      PrivacyScreenState.validate(readInt2);
      result.privacyScreenState = PrivacyScreenState.toKnownValue(result.privacyScreenState);
      int readInt3 = decoder0.readInt(76);
      result.panelOrientation = readInt3;
      PanelOrientation.validate(readInt3);
      result.panelOrientation = PanelOrientation.toKnownValue(result.panelOrientation);
      Decoder decoder13 = decoder0.readPointer(80, false);
      result.colorInfo = DisplaySnapshotColorInfo.decode(decoder13);
      result.displayName = decoder0.readString(88, false);
      Decoder decoder14 = decoder0.readPointer(96, false);
      result.sysPath = FilePath.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(104, false);
      DataHeader si1 = decoder15.readDataHeaderForPointerArray(-1);
      result.modes = new DisplayMode[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder15.readPointer((i1 * 8) + 8, false);
        result.modes[i1] = DisplayMode.decode(decoder2);
      }
      result.edid = decoder0.readBytes(112, 0, -1);
      result.currentModeIndex = decoder0.readLong(120);
      result.nativeModeIndex = decoder0.readLong(128);
      result.productCode = decoder0.readLong(136);
      result.yearOfManufacture = decoder0.readInt(144);
      int readInt4 = decoder0.readInt(148);
      result.variableRefreshRateState = readInt4;
      VariableRefreshRateState.validate(readInt4);
      result.variableRefreshRateState =
          VariableRefreshRateState.toKnownValue(result.variableRefreshRateState);
      Decoder decoder16 = decoder0.readPointer(152, false);
      result.maximumCursorSize = Size.decode(decoder16);
      result.vsyncRateMin = decoder0.readShort(160);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.displayId, 8);
    encoder0.encode(this.portDisplayId, 16);
    encoder0.encode(this.edidDisplayId, 24);
    encoder0.encode(this.connectorIndex, 32);
    encoder0.encode(this.isAspectPreservingScaling, 34, 0);
    encoder0.encode(this.hasOverscan, 34, 1);
    encoder0.encode(this.hasContentProtectionKey, 34, 2);
    encoder0.encode(this.hasCurrentMode, 34, 3);
    encoder0.encode(this.hasNativeMode, 34, 4);
    encoder0.encode(this.type, 36);
    encoder0.encode((Struct) this.origin, 40, false);
    encoder0.encode((Struct) this.physicalSize, 48, false);
    encoder0.encode(this.baseConnectorId, 56);
    encoder0.encode(this.pathTopology, 64, 0, -1);
    encoder0.encode(this.privacyScreenState, 72);
    encoder0.encode(this.panelOrientation, 76);
    encoder0.encode((Struct) this.colorInfo, 80, false);
    encoder0.encode(this.displayName, 88, false);
    encoder0.encode((Struct) this.sysPath, 96, false);
    DisplayMode[] displayModeArr = this.modes;
    if (displayModeArr == null) {
      encoder0.encodeNullPointer(104, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(displayModeArr.length, 104, -1);
      int i0 = 0;
      while (true) {
        DisplayMode[] displayModeArr2 = this.modes;
        if (i0 >= displayModeArr2.length) {
          break;
        }
        encoder1.encode((Struct) displayModeArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.edid, 112, 0, -1);
    encoder0.encode(this.currentModeIndex, 120);
    encoder0.encode(this.nativeModeIndex, 128);
    encoder0.encode(this.productCode, 136);
    encoder0.encode(this.yearOfManufacture, 144);
    encoder0.encode(this.variableRefreshRateState, 148);
    encoder0.encode((Struct) this.maximumCursorSize, 152, false);
    encoder0.encode(this.vsyncRateMin, 160);
  }
}
