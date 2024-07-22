package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.device.mojom.ScreenOrientationLockType;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

public final class Manifest_ extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 240;
  private static final DataHeader[] VERSION_ARRAY;
  public int backgroundColor;
  public int captureLinks;
  public int darkBackgroundColor;
  public int darkThemeColor;
  public String16 description;
  public int display;
  public int[] displayOverride;
  public ManifestFileHandler[] fileHandlers;
  public String16 gcmSenderId;
  public boolean hasBackgroundColor;
  public boolean hasCustomId;
  public boolean hasDarkBackgroundColor;
  public boolean hasDarkThemeColor;
  public boolean hasThemeColor;
  public ManifestImageResource[] icons;

  public Url f438id;
  public ManifestLaunchHandler launchHandler;
  public ManifestLockScreen lockScreen;
  public String16 name;
  public ManifestNoteTaking noteTaking;
  public int orientation;
  public ParsedPermissionsPolicyDeclaration[] permissionsPolicy;
  public boolean preferRelatedApplications;
  public ManifestProtocolHandler[] protocolHandlers;
  public ManifestRelatedApplication[] relatedApplications;
  public Url scope;
  public ManifestScopeExtension[] scopeExtensions;
  public ManifestScreenshot[] screenshots;
  public ManifestShareTarget shareTarget;
  public String16 shortName;
  public ManifestShortcutItem[] shortcuts;
  public Url startUrl;
  public ManifestTabStrip tabStrip;
  public int themeColor;
  public Map<String16, ManifestTranslationItem> translations;
  public ManifestUrlHandler[] urlHandlers;
  public ManifestUserPreferences userPreferences;
  public String16 version;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(240, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private Manifest_(int version) {
    super(240, version);
  }

  public Manifest_() {
    this(0);
  }

  public static Manifest_ deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static Manifest_ deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static Manifest_ decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      Manifest_ result = new Manifest_(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.name = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.shortName = String16.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.description = String16.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, false);
      result.f438id = Url.decode(decoder14);
      result.hasCustomId = decoder0.readBoolean(40, 0);
      result.preferRelatedApplications = decoder0.readBoolean(40, 1);
      result.hasThemeColor = decoder0.readBoolean(40, 2);
      result.hasBackgroundColor = decoder0.readBoolean(40, 3);
      result.hasDarkThemeColor = decoder0.readBoolean(40, 4);
      result.hasDarkBackgroundColor = decoder0.readBoolean(40, 5);
      int readInt = decoder0.readInt(44);
      result.display = readInt;
      DisplayMode.validate(readInt);
      result.display = DisplayMode.toKnownValue(result.display);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.startUrl = Url.decode(decoder15);
      result.displayOverride = decoder0.readInts(56, 0, -1);
      int i1 = 0;
      while (true) {
        int[] iArr = result.displayOverride;
        if (i1 >= iArr.length) {
          break;
        }
        DisplayMode.validate(iArr[i1]);
        i1++;
      }
      int readInt2 = decoder0.readInt(64);
      result.orientation = readInt2;
      ScreenOrientationLockType.validate(readInt2);
      result.orientation = ScreenOrientationLockType.toKnownValue(result.orientation);
      result.themeColor = decoder0.readInt(68);
      Decoder decoder16 = decoder0.readPointer(72, false);
      DataHeader si1 = decoder16.readDataHeaderForPointerArray(-1);
      result.icons = new ManifestImageResource[si1.elementsOrVersion];
      for (int i12 = 0; i12 < si1.elementsOrVersion; i12++) {
        result.icons[i12] =
            ManifestImageResource.decode(decoder16.readPointer((i12 * 8) + 8, false));
      }
      Decoder decoder17 = decoder0.readPointer(80, false);
      DataHeader si12 = decoder17.readDataHeaderForPointerArray(-1);
      result.screenshots = new ManifestScreenshot[si12.elementsOrVersion];
      for (int i13 = 0; i13 < si12.elementsOrVersion; i13++) {
        result.screenshots[i13] =
            ManifestScreenshot.decode(decoder17.readPointer((i13 * 8) + 8, false));
      }
      Decoder decoder18 = decoder0.readPointer(88, false);
      DataHeader si13 = decoder18.readDataHeaderForPointerArray(-1);
      result.shortcuts = new ManifestShortcutItem[si13.elementsOrVersion];
      for (int i14 = 0; i14 < si13.elementsOrVersion; i14++) {
        result.shortcuts[i14] =
            ManifestShortcutItem.decode(decoder18.readPointer((i14 * 8) + 8, false));
      }
      Decoder decoder19 = decoder0.readPointer(96, true);
      result.shareTarget = ManifestShareTarget.decode(decoder19);
      Decoder decoder110 = decoder0.readPointer(104, false);
      DataHeader si14 = decoder110.readDataHeaderForPointerArray(-1);
      result.fileHandlers = new ManifestFileHandler[si14.elementsOrVersion];
      for (int i15 = 0; i15 < si14.elementsOrVersion; i15++) {
        result.fileHandlers[i15] =
            ManifestFileHandler.decode(decoder110.readPointer((i15 * 8) + 8, false));
      }
      Decoder decoder111 = decoder0.readPointer(112, false);
      DataHeader si15 = decoder111.readDataHeaderForPointerArray(-1);
      result.protocolHandlers = new ManifestProtocolHandler[si15.elementsOrVersion];
      for (int i16 = 0; i16 < si15.elementsOrVersion; i16++) {
        result.protocolHandlers[i16] =
            ManifestProtocolHandler.decode(decoder111.readPointer((i16 * 8) + 8, false));
      }
      Decoder decoder112 = decoder0.readPointer(120, false);
      DataHeader si16 = decoder112.readDataHeaderForPointerArray(-1);
      result.urlHandlers = new ManifestUrlHandler[si16.elementsOrVersion];
      for (int i17 = 0; i17 < si16.elementsOrVersion; i17++) {
        result.urlHandlers[i17] =
            ManifestUrlHandler.decode(decoder112.readPointer((i17 * 8) + 8, false));
      }
      Decoder decoder113 = decoder0.readPointer(128, false);
      DataHeader si17 = decoder113.readDataHeaderForPointerArray(-1);
      result.scopeExtensions = new ManifestScopeExtension[si17.elementsOrVersion];
      for (int i18 = 0; i18 < si17.elementsOrVersion; i18++) {
        result.scopeExtensions[i18] =
            ManifestScopeExtension.decode(decoder113.readPointer((i18 * 8) + 8, false));
      }
      Decoder decoder114 = decoder0.readPointer(136, true);
      result.lockScreen = ManifestLockScreen.decode(decoder114);
      Decoder decoder115 = decoder0.readPointer(144, true);
      result.noteTaking = ManifestNoteTaking.decode(decoder115);
      Decoder decoder116 = decoder0.readPointer(152, false);
      DataHeader si18 = decoder116.readDataHeaderForPointerArray(-1);
      result.relatedApplications = new ManifestRelatedApplication[si18.elementsOrVersion];
      for (int i19 = 0; i19 < si18.elementsOrVersion; i19++) {
        result.relatedApplications[i19] =
            ManifestRelatedApplication.decode(decoder116.readPointer((i19 * 8) + 8, false));
      }
      result.backgroundColor = decoder0.readInt(160);
      int readInt3 = decoder0.readInt(164);
      result.captureLinks = readInt3;
      CaptureLinks.validate(readInt3);
      result.captureLinks = CaptureLinks.toKnownValue(result.captureLinks);
      Decoder decoder117 = decoder0.readPointer(168, true);
      result.gcmSenderId = String16.decode(decoder117);
      Decoder decoder118 = decoder0.readPointer(176, false);
      result.scope = Url.decode(decoder118);
      Decoder decoder119 = decoder0.readPointer(184, false);
      DataHeader si19 = decoder119.readDataHeaderForPointerArray(-1);
      result.permissionsPolicy = new ParsedPermissionsPolicyDeclaration[si19.elementsOrVersion];
      for (int i110 = 0; i110 < si19.elementsOrVersion; i110++) {
        result.permissionsPolicy[i110] =
            ParsedPermissionsPolicyDeclaration.decode(
                decoder119.readPointer((i110 * 8) + 8, false));
      }
      Decoder decoder120 = decoder0.readPointer(192, true);
      result.launchHandler = ManifestLaunchHandler.decode(decoder120);
      Decoder decoder121 = decoder0.readPointer(200, false);
      decoder121.readDataHeaderForMap();
      Decoder decoder2 = decoder121.readPointer(8, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
      String16[] keys0 = new String16[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        Decoder decoder3 = decoder2.readPointer((i2 * 8) + 8, false);
        keys0[i2] = String16.decode(decoder3);
      }
      Decoder decoder22 = decoder121.readPointer(16, false);
      DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
      ManifestTranslationItem[] values0 = new ManifestTranslationItem[si22.elementsOrVersion];
      for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
        Decoder decoder32 = decoder22.readPointer((i22 * 8) + 8, false);
        values0[i22] = ManifestTranslationItem.decode(decoder32);
      }
      result.translations = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.translations.put(keys0[index0], values0[index0]);
      }
      Decoder decoder122 = decoder0.readPointer(208, true);
      result.userPreferences = ManifestUserPreferences.decode(decoder122);
      result.darkThemeColor = decoder0.readInt(216);
      result.darkBackgroundColor = decoder0.readInt(220);
      Decoder decoder123 = decoder0.readPointer(CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH, true);
      result.tabStrip = ManifestTabStrip.decode(decoder123);
      Decoder decoder124 = decoder0.readPointer(232, true);
      result.version = String16.decode(decoder124);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.name, 8, true);
    encoder0.encode((Struct) this.shortName, 16, true);
    encoder0.encode((Struct) this.description, 24, true);
    encoder0.encode((Struct) this.f438id, 32, false);
    encoder0.encode(this.hasCustomId, 40, 0);
    encoder0.encode(this.preferRelatedApplications, 40, 1);
    encoder0.encode(this.hasThemeColor, 40, 2);
    encoder0.encode(this.hasBackgroundColor, 40, 3);
    encoder0.encode(this.hasDarkThemeColor, 40, 4);
    encoder0.encode(this.hasDarkBackgroundColor, 40, 5);
    encoder0.encode(this.display, 44);
    encoder0.encode((Struct) this.startUrl, 48, false);
    encoder0.encode(this.displayOverride, 56, 0, -1);
    encoder0.encode(this.orientation, 64);
    encoder0.encode(this.themeColor, 68);
    ManifestImageResource[] manifestImageResourceArr = this.icons;
    if (manifestImageResourceArr == null) {
      encoder0.encodeNullPointer(72, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(manifestImageResourceArr.length, 72, -1);
      int i0 = 0;
      while (true) {
        ManifestImageResource[] manifestImageResourceArr2 = this.icons;
        if (i0 >= manifestImageResourceArr2.length) {
          break;
        }
        encoder1.encode((Struct) manifestImageResourceArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    ManifestScreenshot[] manifestScreenshotArr = this.screenshots;
    if (manifestScreenshotArr == null) {
      encoder0.encodeNullPointer(80, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(manifestScreenshotArr.length, 80, -1);
      int i02 = 0;
      while (true) {
        ManifestScreenshot[] manifestScreenshotArr2 = this.screenshots;
        if (i02 >= manifestScreenshotArr2.length) {
          break;
        }
        encoder12.encode((Struct) manifestScreenshotArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    ManifestShortcutItem[] manifestShortcutItemArr = this.shortcuts;
    if (manifestShortcutItemArr == null) {
      encoder0.encodeNullPointer(88, false);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(manifestShortcutItemArr.length, 88, -1);
      int i03 = 0;
      while (true) {
        ManifestShortcutItem[] manifestShortcutItemArr2 = this.shortcuts;
        if (i03 >= manifestShortcutItemArr2.length) {
          break;
        }
        encoder13.encode((Struct) manifestShortcutItemArr2[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    encoder0.encode((Struct) this.shareTarget, 96, true);
    ManifestFileHandler[] manifestFileHandlerArr = this.fileHandlers;
    if (manifestFileHandlerArr == null) {
      encoder0.encodeNullPointer(104, false);
    } else {
      Encoder encoder14 = encoder0.encodePointerArray(manifestFileHandlerArr.length, 104, -1);
      int i04 = 0;
      while (true) {
        ManifestFileHandler[] manifestFileHandlerArr2 = this.fileHandlers;
        if (i04 >= manifestFileHandlerArr2.length) {
          break;
        }
        encoder14.encode((Struct) manifestFileHandlerArr2[i04], (i04 * 8) + 8, false);
        i04++;
      }
    }
    ManifestProtocolHandler[] manifestProtocolHandlerArr = this.protocolHandlers;
    if (manifestProtocolHandlerArr == null) {
      encoder0.encodeNullPointer(112, false);
    } else {
      Encoder encoder15 = encoder0.encodePointerArray(manifestProtocolHandlerArr.length, 112, -1);
      int i05 = 0;
      while (true) {
        ManifestProtocolHandler[] manifestProtocolHandlerArr2 = this.protocolHandlers;
        if (i05 >= manifestProtocolHandlerArr2.length) {
          break;
        }
        encoder15.encode((Struct) manifestProtocolHandlerArr2[i05], (i05 * 8) + 8, false);
        i05++;
      }
    }
    ManifestUrlHandler[] manifestUrlHandlerArr = this.urlHandlers;
    if (manifestUrlHandlerArr == null) {
      encoder0.encodeNullPointer(120, false);
    } else {
      Encoder encoder16 = encoder0.encodePointerArray(manifestUrlHandlerArr.length, 120, -1);
      int i06 = 0;
      while (true) {
        ManifestUrlHandler[] manifestUrlHandlerArr2 = this.urlHandlers;
        if (i06 >= manifestUrlHandlerArr2.length) {
          break;
        }
        encoder16.encode((Struct) manifestUrlHandlerArr2[i06], (i06 * 8) + 8, false);
        i06++;
      }
    }
    ManifestScopeExtension[] manifestScopeExtensionArr = this.scopeExtensions;
    if (manifestScopeExtensionArr == null) {
      encoder0.encodeNullPointer(128, false);
    } else {
      Encoder encoder17 = encoder0.encodePointerArray(manifestScopeExtensionArr.length, 128, -1);
      int i07 = 0;
      while (true) {
        ManifestScopeExtension[] manifestScopeExtensionArr2 = this.scopeExtensions;
        if (i07 >= manifestScopeExtensionArr2.length) {
          break;
        }
        encoder17.encode((Struct) manifestScopeExtensionArr2[i07], (i07 * 8) + 8, false);
        i07++;
      }
    }
    encoder0.encode((Struct) this.lockScreen, 136, true);
    encoder0.encode((Struct) this.noteTaking, 144, true);
    ManifestRelatedApplication[] manifestRelatedApplicationArr = this.relatedApplications;
    if (manifestRelatedApplicationArr == null) {
      encoder0.encodeNullPointer(152, false);
    } else {
      Encoder encoder18 =
          encoder0.encodePointerArray(manifestRelatedApplicationArr.length, 152, -1);
      int i08 = 0;
      while (true) {
        ManifestRelatedApplication[] manifestRelatedApplicationArr2 = this.relatedApplications;
        if (i08 >= manifestRelatedApplicationArr2.length) {
          break;
        }
        encoder18.encode((Struct) manifestRelatedApplicationArr2[i08], (i08 * 8) + 8, false);
        i08++;
      }
    }
    encoder0.encode(this.backgroundColor, 160);
    encoder0.encode(this.captureLinks, 164);
    encoder0.encode((Struct) this.gcmSenderId, 168, true);
    encoder0.encode((Struct) this.scope, 176, false);
    ParsedPermissionsPolicyDeclaration[] parsedPermissionsPolicyDeclarationArr =
        this.permissionsPolicy;
    if (parsedPermissionsPolicyDeclarationArr == null) {
      encoder0.encodeNullPointer(184, false);
    } else {
      Encoder encoder19 =
          encoder0.encodePointerArray(parsedPermissionsPolicyDeclarationArr.length, 184, -1);
      int i09 = 0;
      while (true) {
        ParsedPermissionsPolicyDeclaration[] parsedPermissionsPolicyDeclarationArr2 =
            this.permissionsPolicy;
        if (i09 >= parsedPermissionsPolicyDeclarationArr2.length) {
          break;
        }
        encoder19.encode(
            (Struct) parsedPermissionsPolicyDeclarationArr2[i09], (i09 * 8) + 8, false);
        i09++;
      }
    }
    encoder0.encode((Struct) this.launchHandler, 192, true);
    if (this.translations == null) {
      encoder0.encodeNullPointer(200, false);
    } else {
      Encoder encoder110 = encoder0.encoderForMap(200);
      int size0 = this.translations.size();
      String16[] keys0 = new String16[size0];
      ManifestTranslationItem[] values0 = new ManifestTranslationItem[size0];
      int index0 = 0;
      for (Map.Entry<String16, ManifestTranslationItem> entry0 : this.translations.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue();
        index0++;
      }
      Encoder encoder2 = encoder110.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode((Struct) keys0[i1], (i1 * 8) + 8, false);
      }
      Encoder encoder22 = encoder110.encodePointerArray(values0.length, 16, -1);
      for (int i12 = 0; i12 < values0.length; i12++) {
        encoder22.encode((Struct) values0[i12], (i12 * 8) + 8, false);
      }
    }
    encoder0.encode((Struct) this.userPreferences, 208, true);
    encoder0.encode(this.darkThemeColor, 216);
    encoder0.encode(this.darkBackgroundColor, 220);
    encoder0.encode((Struct) this.tabStrip, CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH, true);
    encoder0.encode((Struct) this.version, 232, true);
  }
}
