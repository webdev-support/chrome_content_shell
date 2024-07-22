package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Hinting;
import org.chromium.gfx.mojom.SubpixelRendering;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class RendererPreferences extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 96;
  private static final DataHeader[] VERSION_ARRAY;
  public String acceptLanguages;
  public int activeSelectionBgColor;
  public int activeSelectionFgColor;
  public boolean allowCrossOriginAuthPrompt;
  public boolean browserHandlesAllTopLevelRequests;
  public boolean canAcceptLoadDrops;
  public TimeDelta caretBlinkInterval;
  public boolean caretBrowsingEnabled;
  public boolean enableDoNotTrack;
  public boolean enableEncryptedMedia;
  public boolean enableReferrers;
  public short[] explicitlyAllowedNetworkPorts;
  public int focusRingColor;
  public int hinting;
  public int inactiveSelectionBgColor;
  public int inactiveSelectionFgColor;
  public boolean pluginFullscreenAllowed;
  public boolean sendSubresourceNotification;
  public boolean shouldAntialiasText;
  public int subpixelRendering;
  public boolean useAutohinter;
  public boolean useBitmaps;
  public boolean useCustomColors;
  public boolean useSubpixelPositioning;
  public UserAgentOverride userAgentOverride;
  public String webrtcIpHandlingPolicy;
  public String[] webrtcLocalIpsAllowedUrls;
  public short webrtcUdpMaxPort;
  public short webrtcUdpMinPort;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(96, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private RendererPreferences(int version) {
    super(96, version);
    this.canAcceptLoadDrops = true;
    this.shouldAntialiasText = true;
    this.hinting = 2;
    this.useAutohinter = false;
    this.useBitmaps = false;
    this.subpixelRendering = 0;
    this.useSubpixelPositioning = false;
    this.focusRingColor = -1730816;
    this.activeSelectionBgColor = -15112238;
    this.activeSelectionFgColor = -16777216;
    this.inactiveSelectionBgColor = -3618616;
    this.inactiveSelectionFgColor = -13487566;
    this.browserHandlesAllTopLevelRequests = false;
    this.useCustomColors = true;
    this.enableReferrers = true;
    this.allowCrossOriginAuthPrompt = false;
    this.enableDoNotTrack = false;
    this.enableEncryptedMedia = true;
    this.webrtcUdpMinPort = (short) 0;
    this.webrtcUdpMaxPort = (short) 0;
    this.sendSubresourceNotification = false;
    this.pluginFullscreenAllowed = true;
    this.caretBrowsingEnabled = false;
  }

  public RendererPreferences() {
    this(0);
  }

  public static RendererPreferences deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RendererPreferences deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RendererPreferences decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RendererPreferences result = new RendererPreferences(elementsOrVersion);
      result.canAcceptLoadDrops = decoder0.readBoolean(8, 0);
      result.shouldAntialiasText = decoder0.readBoolean(8, 1);
      result.useAutohinter = decoder0.readBoolean(8, 2);
      result.useBitmaps = decoder0.readBoolean(8, 3);
      result.useSubpixelPositioning = decoder0.readBoolean(8, 4);
      result.browserHandlesAllTopLevelRequests = decoder0.readBoolean(8, 5);
      result.useCustomColors = decoder0.readBoolean(8, 6);
      result.enableReferrers = decoder0.readBoolean(8, 7);
      result.allowCrossOriginAuthPrompt = decoder0.readBoolean(9, 0);
      result.enableDoNotTrack = decoder0.readBoolean(9, 1);
      result.enableEncryptedMedia = decoder0.readBoolean(9, 2);
      result.sendSubresourceNotification = decoder0.readBoolean(9, 3);
      result.pluginFullscreenAllowed = decoder0.readBoolean(9, 4);
      result.caretBrowsingEnabled = decoder0.readBoolean(9, 5);
      result.webrtcUdpMinPort = decoder0.readShort(10);
      int readInt = decoder0.readInt(12);
      result.hinting = readInt;
      Hinting.validate(readInt);
      result.hinting = Hinting.toKnownValue(result.hinting);
      int readInt2 = decoder0.readInt(16);
      result.subpixelRendering = readInt2;
      SubpixelRendering.validate(readInt2);
      result.subpixelRendering = SubpixelRendering.toKnownValue(result.subpixelRendering);
      result.focusRingColor = decoder0.readInt(20);
      result.activeSelectionBgColor = decoder0.readInt(24);
      result.activeSelectionFgColor = decoder0.readInt(28);
      result.inactiveSelectionBgColor = decoder0.readInt(32);
      result.inactiveSelectionFgColor = decoder0.readInt(36);
      result.caretBlinkInterval = TimeDelta.decode(decoder0.readPointer(40, true));
      result.webrtcIpHandlingPolicy = decoder0.readString(48, false);
      result.webrtcUdpMaxPort = decoder0.readShort(56);
      Decoder decoder1 = decoder0.readPointer(64, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.webrtcLocalIpsAllowedUrls = new String[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        result.webrtcLocalIpsAllowedUrls[i1] = decoder1.readString((i1 * 8) + 8, false);
      }
      result.userAgentOverride = UserAgentOverride.decode(decoder0.readPointer(72, false));
      result.acceptLanguages = decoder0.readString(80, false);
      result.explicitlyAllowedNetworkPorts = decoder0.readShorts(88, 0, -1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.canAcceptLoadDrops, 8, 0);
    encoder0.encode(this.shouldAntialiasText, 8, 1);
    encoder0.encode(this.useAutohinter, 8, 2);
    encoder0.encode(this.useBitmaps, 8, 3);
    encoder0.encode(this.useSubpixelPositioning, 8, 4);
    encoder0.encode(this.browserHandlesAllTopLevelRequests, 8, 5);
    encoder0.encode(this.useCustomColors, 8, 6);
    encoder0.encode(this.enableReferrers, 8, 7);
    encoder0.encode(this.allowCrossOriginAuthPrompt, 9, 0);
    encoder0.encode(this.enableDoNotTrack, 9, 1);
    encoder0.encode(this.enableEncryptedMedia, 9, 2);
    encoder0.encode(this.sendSubresourceNotification, 9, 3);
    encoder0.encode(this.pluginFullscreenAllowed, 9, 4);
    encoder0.encode(this.caretBrowsingEnabled, 9, 5);
    encoder0.encode(this.webrtcUdpMinPort, 10);
    encoder0.encode(this.hinting, 12);
    encoder0.encode(this.subpixelRendering, 16);
    encoder0.encode(this.focusRingColor, 20);
    encoder0.encode(this.activeSelectionBgColor, 24);
    encoder0.encode(this.activeSelectionFgColor, 28);
    encoder0.encode(this.inactiveSelectionBgColor, 32);
    encoder0.encode(this.inactiveSelectionFgColor, 36);
    encoder0.encode((Struct) this.caretBlinkInterval, 40, true);
    encoder0.encode(this.webrtcIpHandlingPolicy, 48, false);
    encoder0.encode(this.webrtcUdpMaxPort, 56);
    String[] strArr = this.webrtcLocalIpsAllowedUrls;
    if (strArr == null) {
      encoder0.encodeNullPointer(64, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 64, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.webrtcLocalIpsAllowedUrls;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.userAgentOverride, 72, false);
    encoder0.encode(this.acceptLanguages, 80, false);
    encoder0.encode(this.explicitlyAllowedNetworkPorts, 88, 0, -1);
  }
}
