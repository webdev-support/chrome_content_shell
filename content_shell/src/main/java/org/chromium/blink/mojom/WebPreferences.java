package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.url.mojom.Url;

public final class WebPreferences extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 288;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean accelerated2dCanvasEnabled;
  public boolean acceleratedFiltersEnabled;
  public boolean acceleratedVideoDecodeEnabled;
  public boolean allowFileAccessFromFileUrls;
  public boolean allowGeolocationOnInsecureOrigins;
  public boolean allowMixedContentUpgrades;
  public boolean allowNonEmptyNavigatorPlugins;
  public boolean allowRunningInsecureContent;
  public boolean allowScriptsToCloseWindows;
  public boolean allowUniversalAccessFromFileUrls;
  public boolean alwaysShowFocus;
  public int animationPolicy;
  public boolean antialiased2dCanvasDisabled;
  public boolean antialiasedClips2dCanvasEnabled;
  public boolean autoZoomFocusedEditableToLegibleScale;
  public int autoplayPolicy;
  public int availableHoverTypes;
  public int availablePointerTypes;
  public boolean barrelButtonForDragEnabled;
  public boolean blockMixedPluginContent;
  public boolean canvas2dLayersEnabled;
  public boolean clobberUserAgentInitialScaleQuirk;
  public boolean containerCullingEnabled;
  public boolean contextMenuOnMouseUp;
  public boolean cookieEnabled;
  public boolean cssHexAlphaColorEnabled;
  public Map<String, String16> cursiveFontFamilyMap;
  public boolean dataSaverEnabled;
  public boolean databasesEnabled;
  public String defaultEncoding;
  public int defaultFixedFontSize;
  public int defaultFontSize;
  public float defaultMaximumPageScaleFactor;
  public float defaultMinimumPageScaleFactor;
  public Url defaultVideoPosterUrl;
  public boolean deferredFiltersEnabled;
  public float deviceScaleAdjustment;
  public boolean disableAcceleratedSmallCanvases;
  public boolean disableIpcFloodingProtection;
  public boolean disableReadingFromCanvas;
  public boolean disableWebauthn;
  public boolean dnsPrefetchingEnabled;
  public boolean doNotUpdateSelectionOnMutatingSelectionRange;
  public boolean domPasteEnabled;
  public boolean dontSendKeyEventsToJavascript;
  public boolean doubleTapToZoomEnabled;
  public int editingBehavior;
  public boolean embeddedMediaExperienceEnabled;
  public boolean enableScrollAnimator;
  public boolean fakeNoAllocDirectCallForTestingEnabled;
  public Map<String, String16> fantasyFontFamilyMap;
  public Map<String, String16> fixedFontFamilyMap;
  public float fontScaleFactor;
  public int fontWeightAdjustment;
  public boolean forceDarkModeEnabled;
  public boolean forceEnableZoom;
  public boolean forceZeroLayoutHeight;
  public boolean fullscreenSupported;
  public boolean hideDownloadUi;
  public boolean hideScrollbars;
  public boolean hyperlinkAuditingEnabled;
  public boolean ignoreMainFrameOverflowHiddenQuirk;
  public boolean imagesEnabled;
  public boolean immersiveModeEnabled;
  public boolean initializeAtMinimumPageScale;
  public boolean invertedColors;
  public boolean javascriptCanAccessClipboard;
  public boolean javascriptEnabled;
  public boolean lazyLoadEnabled;
  public boolean loadsImagesAutomatically;
  public boolean localStorageEnabled;
  public int lowPriorityIframesThreshold;
  public boolean mainFrameResizesAreOrientationChanges;
  public Map<String, String16> mathFontFamilyMap;
  public boolean mediaControlsEnabled;
  public int minimumFontSize;
  public int minimumLogicalFontSize;
  public boolean modalContextMenu;
  public int networkQualityEstimatorWebHoldback;
  public int numberOfCpuCores;
  public int outputDeviceUpdateAbilityType;
  public boolean passwordEchoEnabled;
  public boolean pepper3dEnabled;
  public boolean pictureInPictureEnabled;
  public boolean pluginsEnabled;
  public int pointerEventsMaxTouchPoints;
  public int preferredColorScheme;
  public int preferredContrast;
  public boolean prefersDefaultScrollbarStyles;
  public boolean prefersReducedMotion;
  public boolean prefersReducedTransparency;
  public boolean presentationReceiver;
  public int primaryHoverType;
  public int primaryPointerType;
  public boolean privilegedWebglExtensionsEnabled;
  public boolean recordWholeDocument;
  public boolean remoteFontsEnabled;
  public boolean rendererWideNamedFrameLookup;
  public boolean reportScreenSizeInPhysicalPixelsQuirk;
  public boolean requireTransientActivationAndUserConfirmationForSubappsApi;
  public boolean requireTransientActivationForGetDisplayMedia;
  public boolean requireTransientActivationForHtmlFullscreen;
  public boolean requireTransientActivationForShowFileOrDirectoryPicker;
  public boolean reuseGlobalForUnownedMainFrame;
  public Map<String, String16> sansSerifFontFamilyMap;
  public boolean scrollTopLeftInteropEnabled;
  public Map<String, String16> serifFontFamilyMap;
  public boolean shouldClearDocumentBackground;
  public boolean shrinksStandaloneImagesToFit;
  public boolean shrinksViewportContentsToFit;
  public boolean smartInsertDeleteEnabled;
  public boolean smoothScrollForFindEnabled;
  public boolean spatialNavigationEnabled;
  public boolean spellcheckEnabledByDefault;
  public Map<String, String16> standardFontFamilyMap;
  public boolean strictMimeTypeCheckForWorkerScriptsEnabled;
  public boolean strictMixedContentChecking;
  public boolean strictPowerfulFeatureRestrictions;
  public boolean strictlyBlockBlockableMixedContent;
  public boolean stylusHandwritingEnabled;
  public boolean supportDeprecatedTargetDensityDpi;
  public boolean supportsMultipleWindows;
  public boolean syncXhrInDocumentsEnabled;
  public boolean tabsToLinks;
  public boolean targetBlankImpliesNoOpenerEnabledWillBeRemoved;
  public boolean textAreasAreResizable;
  public boolean textAutosizingEnabled;
  public int textSizeContrastFactor;
  public String textTrackBackgroundColor;
  public String textTrackFontFamily;
  public String textTrackFontStyle;
  public String textTrackFontVariant;
  public float textTrackMarginPercentage;
  public String textTrackTextColor;
  public String textTrackTextShadow;
  public String textTrackTextSize;
  public String textTrackWindowColor;
  public String textTrackWindowRadius;
  public boolean textTracksEnabled;
  public boolean touchDragDropEnabled;
  public boolean touchEventFeatureDetectionEnabled;
  public boolean translateServiceAvailable;
  public boolean useWideViewport;
  public boolean userGestureRequiredForPresentation;
  public int v8CacheOptions;
  public boolean videoFullscreenOrientationLockEnabled;
  public boolean videoRotateToFullscreenEnabled;
  public boolean viewportEnabled;
  public boolean viewportMetaEnabled;
  public boolean viewportMetaMergeContentQuirk;
  public boolean viewportMetaNonUserScalableQuirk;
  public boolean viewportMetaZeroValuesQuirk;
  public int viewportStyle;
  public Url webAppScope;
  public boolean webSecurityEnabled;
  public boolean webgl1Enabled;
  public boolean webgl2Enabled;
  public boolean webglErrorsToConsoleEnabled;
  public boolean webxrImmersiveArAllowed;
  public boolean wideViewportQuirk;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(288, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private WebPreferences(int version) {
    super(288, version);
    this.strictMimeTypeCheckForWorkerScriptsEnabled = true;
    this.modalContextMenu = true;
  }

  public WebPreferences() {
    this(0);
  }

  public static WebPreferences deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static WebPreferences deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static WebPreferences decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      WebPreferences result = new WebPreferences(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      decoder1.readDataHeaderForMap();
      Decoder decoder2 = decoder1.readPointer(8, false);
      DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
      String[] keys0 = new String[si2.elementsOrVersion];
      for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
        keys0[i2] = decoder2.readString((i2 * 8) + 8, false);
      }
      Decoder decoder22 = decoder1.readPointer(16, false);
      DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
      String16[] values0 = new String16[si22.elementsOrVersion];
      for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
        Decoder decoder3 = decoder22.readPointer((i22 * 8) + 8, false);
        values0[i22] = String16.decode(decoder3);
      }
      result.standardFontFamilyMap = new HashMap();
      for (int index0 = 0; index0 < keys0.length; index0++) {
        result.standardFontFamilyMap.put(keys0[index0], values0[index0]);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      decoder12.readDataHeaderForMap();
      Decoder decoder23 = decoder12.readPointer(8, false);
      DataHeader si23 = decoder23.readDataHeaderForPointerArray(-1);
      String[] keys02 = new String[si23.elementsOrVersion];
      for (int i23 = 0; i23 < si23.elementsOrVersion; i23++) {
        keys02[i23] = decoder23.readString((i23 * 8) + 8, false);
      }
      Decoder decoder24 = decoder12.readPointer(16, false);
      DataHeader si24 = decoder24.readDataHeaderForPointerArray(keys02.length);
      String16[] values02 = new String16[si24.elementsOrVersion];
      for (int i24 = 0; i24 < si24.elementsOrVersion; i24++) {
        Decoder decoder32 = decoder24.readPointer((i24 * 8) + 8, false);
        values02[i24] = String16.decode(decoder32);
      }
      result.fixedFontFamilyMap = new HashMap();
      for (int index02 = 0; index02 < keys02.length; index02++) {
        result.fixedFontFamilyMap.put(keys02[index02], values02[index02]);
      }
      Decoder decoder13 = decoder0.readPointer(24, false);
      decoder13.readDataHeaderForMap();
      Decoder decoder25 = decoder13.readPointer(8, false);
      DataHeader si25 = decoder25.readDataHeaderForPointerArray(-1);
      String[] keys03 = new String[si25.elementsOrVersion];
      for (int i25 = 0; i25 < si25.elementsOrVersion; i25++) {
        keys03[i25] = decoder25.readString((i25 * 8) + 8, false);
      }
      Decoder decoder26 = decoder13.readPointer(16, false);
      DataHeader si26 = decoder26.readDataHeaderForPointerArray(keys03.length);
      String16[] values03 = new String16[si26.elementsOrVersion];
      for (int i26 = 0; i26 < si26.elementsOrVersion; i26++) {
        Decoder decoder33 = decoder26.readPointer((i26 * 8) + 8, false);
        values03[i26] = String16.decode(decoder33);
      }
      result.serifFontFamilyMap = new HashMap();
      for (int index03 = 0; index03 < keys03.length; index03++) {
        result.serifFontFamilyMap.put(keys03[index03], values03[index03]);
      }
      Decoder decoder14 = decoder0.readPointer(32, false);
      decoder14.readDataHeaderForMap();
      Decoder decoder27 = decoder14.readPointer(8, false);
      DataHeader si27 = decoder27.readDataHeaderForPointerArray(-1);
      String[] keys04 = new String[si27.elementsOrVersion];
      for (int i27 = 0; i27 < si27.elementsOrVersion; i27++) {
        keys04[i27] = decoder27.readString((i27 * 8) + 8, false);
      }
      Decoder decoder28 = decoder14.readPointer(16, false);
      DataHeader si28 = decoder28.readDataHeaderForPointerArray(keys04.length);
      String16[] values04 = new String16[si28.elementsOrVersion];
      for (int i28 = 0; i28 < si28.elementsOrVersion; i28++) {
        Decoder decoder34 = decoder28.readPointer((i28 * 8) + 8, false);
        values04[i28] = String16.decode(decoder34);
      }
      result.sansSerifFontFamilyMap = new HashMap();
      for (int index04 = 0; index04 < keys04.length; index04++) {
        result.sansSerifFontFamilyMap.put(keys04[index04], values04[index04]);
      }
      Decoder decoder15 = decoder0.readPointer(40, false);
      decoder15.readDataHeaderForMap();
      Decoder decoder29 = decoder15.readPointer(8, false);
      DataHeader si29 = decoder29.readDataHeaderForPointerArray(-1);
      String[] keys05 = new String[si29.elementsOrVersion];
      for (int i29 = 0; i29 < si29.elementsOrVersion; i29++) {
        keys05[i29] = decoder29.readString((i29 * 8) + 8, false);
      }
      Decoder decoder210 = decoder15.readPointer(16, false);
      DataHeader si210 = decoder210.readDataHeaderForPointerArray(keys05.length);
      String16[] values05 = new String16[si210.elementsOrVersion];
      for (int i210 = 0; i210 < si210.elementsOrVersion; i210++) {
        Decoder decoder35 = decoder210.readPointer((i210 * 8) + 8, false);
        values05[i210] = String16.decode(decoder35);
      }
      result.cursiveFontFamilyMap = new HashMap();
      for (int index05 = 0; index05 < keys05.length; index05++) {
        result.cursiveFontFamilyMap.put(keys05[index05], values05[index05]);
      }
      Decoder decoder16 = decoder0.readPointer(48, false);
      decoder16.readDataHeaderForMap();
      Decoder decoder211 = decoder16.readPointer(8, false);
      DataHeader si211 = decoder211.readDataHeaderForPointerArray(-1);
      String[] keys06 = new String[si211.elementsOrVersion];
      for (int i211 = 0; i211 < si211.elementsOrVersion; i211++) {
        keys06[i211] = decoder211.readString((i211 * 8) + 8, false);
      }
      Decoder decoder212 = decoder16.readPointer(16, false);
      DataHeader si212 = decoder212.readDataHeaderForPointerArray(keys06.length);
      String16[] values06 = new String16[si212.elementsOrVersion];
      for (int i212 = 0; i212 < si212.elementsOrVersion; i212++) {
        Decoder decoder36 = decoder212.readPointer((i212 * 8) + 8, false);
        values06[i212] = String16.decode(decoder36);
      }
      result.fantasyFontFamilyMap = new HashMap();
      for (int index06 = 0; index06 < keys06.length; index06++) {
        result.fantasyFontFamilyMap.put(keys06[index06], values06[index06]);
      }
      Decoder decoder17 = decoder0.readPointer(56, false);
      decoder17.readDataHeaderForMap();
      Decoder decoder213 = decoder17.readPointer(8, false);
      DataHeader si213 = decoder213.readDataHeaderForPointerArray(-1);
      String[] keys07 = new String[si213.elementsOrVersion];
      for (int i213 = 0; i213 < si213.elementsOrVersion; i213++) {
        keys07[i213] = decoder213.readString((i213 * 8) + 8, false);
      }
      Decoder decoder214 = decoder17.readPointer(16, false);
      DataHeader si214 = decoder214.readDataHeaderForPointerArray(keys07.length);
      String16[] values07 = new String16[si214.elementsOrVersion];
      for (int i214 = 0; i214 < si214.elementsOrVersion; i214++) {
        Decoder decoder37 = decoder214.readPointer((i214 * 8) + 8, false);
        values07[i214] = String16.decode(decoder37);
      }
      result.mathFontFamilyMap = new HashMap();
      for (int index07 = 0; index07 < keys07.length; index07++) {
        result.mathFontFamilyMap.put(keys07[index07], values07[index07]);
      }
      result.defaultFontSize = decoder0.readInt(64);
      result.defaultFixedFontSize = decoder0.readInt(68);
      result.minimumFontSize = decoder0.readInt(72);
      result.minimumLogicalFontSize = decoder0.readInt(76);
      result.defaultEncoding = decoder0.readString(80, false);
      result.contextMenuOnMouseUp = decoder0.readBoolean(88, 0);
      result.javascriptEnabled = decoder0.readBoolean(88, 1);
      result.webSecurityEnabled = decoder0.readBoolean(88, 2);
      result.loadsImagesAutomatically = decoder0.readBoolean(88, 3);
      result.imagesEnabled = decoder0.readBoolean(88, 4);
      result.pluginsEnabled = decoder0.readBoolean(88, 5);
      result.domPasteEnabled = decoder0.readBoolean(88, 6);
      result.shrinksStandaloneImagesToFit = decoder0.readBoolean(88, 7);
      result.textAreasAreResizable = decoder0.readBoolean(89, 0);
      result.allowScriptsToCloseWindows = decoder0.readBoolean(89, 1);
      result.remoteFontsEnabled = decoder0.readBoolean(89, 2);
      result.javascriptCanAccessClipboard = decoder0.readBoolean(89, 3);
      result.dnsPrefetchingEnabled = decoder0.readBoolean(89, 4);
      result.dataSaverEnabled = decoder0.readBoolean(89, 5);
      result.localStorageEnabled = decoder0.readBoolean(89, 6);
      result.databasesEnabled = decoder0.readBoolean(89, 7);
      result.tabsToLinks = decoder0.readBoolean(90, 0);
      result.disableIpcFloodingProtection = decoder0.readBoolean(90, 1);
      result.hyperlinkAuditingEnabled = decoder0.readBoolean(90, 2);
      result.allowUniversalAccessFromFileUrls = decoder0.readBoolean(90, 3);
      result.allowFileAccessFromFileUrls = decoder0.readBoolean(90, 4);
      result.webgl1Enabled = decoder0.readBoolean(90, 5);
      result.webgl2Enabled = decoder0.readBoolean(90, 6);
      result.pepper3dEnabled = decoder0.readBoolean(90, 7);
      result.privilegedWebglExtensionsEnabled = decoder0.readBoolean(91, 0);
      result.webglErrorsToConsoleEnabled = decoder0.readBoolean(91, 1);
      result.hideScrollbars = decoder0.readBoolean(91, 2);
      result.prefersDefaultScrollbarStyles = decoder0.readBoolean(91, 3);
      result.accelerated2dCanvasEnabled = decoder0.readBoolean(91, 4);
      result.canvas2dLayersEnabled = decoder0.readBoolean(91, 5);
      result.antialiased2dCanvasDisabled = decoder0.readBoolean(91, 6);
      result.antialiasedClips2dCanvasEnabled = decoder0.readBoolean(91, 7);
      result.acceleratedFiltersEnabled = decoder0.readBoolean(92, 0);
      result.deferredFiltersEnabled = decoder0.readBoolean(92, 1);
      result.containerCullingEnabled = decoder0.readBoolean(92, 2);
      result.allowRunningInsecureContent = decoder0.readBoolean(92, 3);
      result.disableReadingFromCanvas = decoder0.readBoolean(92, 4);
      result.strictMixedContentChecking = decoder0.readBoolean(92, 5);
      result.strictPowerfulFeatureRestrictions = decoder0.readBoolean(92, 6);
      result.allowGeolocationOnInsecureOrigins = decoder0.readBoolean(92, 7);
      result.strictlyBlockBlockableMixedContent = decoder0.readBoolean(93, 0);
      result.blockMixedPluginContent = decoder0.readBoolean(93, 1);
      result.passwordEchoEnabled = decoder0.readBoolean(93, 2);
      result.shouldClearDocumentBackground = decoder0.readBoolean(93, 3);
      result.enableScrollAnimator = decoder0.readBoolean(93, 4);
      result.prefersReducedMotion = decoder0.readBoolean(93, 5);
      result.prefersReducedTransparency = decoder0.readBoolean(93, 6);
      result.invertedColors = decoder0.readBoolean(93, 7);
      result.touchEventFeatureDetectionEnabled = decoder0.readBoolean(94, 0);
      result.dontSendKeyEventsToJavascript = decoder0.readBoolean(94, 1);
      result.barrelButtonForDragEnabled = decoder0.readBoolean(94, 2);
      result.syncXhrInDocumentsEnabled = decoder0.readBoolean(94, 3);
      result.targetBlankImpliesNoOpenerEnabledWillBeRemoved = decoder0.readBoolean(94, 4);
      result.allowNonEmptyNavigatorPlugins = decoder0.readBoolean(94, 5);
      result.supportsMultipleWindows = decoder0.readBoolean(94, 6);
      result.viewportEnabled = decoder0.readBoolean(94, 7);
      result.viewportMetaEnabled = decoder0.readBoolean(95, 0);
      result.autoZoomFocusedEditableToLegibleScale = decoder0.readBoolean(95, 1);
      result.shrinksViewportContentsToFit = decoder0.readBoolean(95, 2);
      result.smoothScrollForFindEnabled = decoder0.readBoolean(95, 3);
      result.mainFrameResizesAreOrientationChanges = decoder0.readBoolean(95, 4);
      result.initializeAtMinimumPageScale = decoder0.readBoolean(95, 5);
      result.smartInsertDeleteEnabled = decoder0.readBoolean(95, 6);
      result.spatialNavigationEnabled = decoder0.readBoolean(95, 7);
      result.pointerEventsMaxTouchPoints = decoder0.readInt(96);
      result.availablePointerTypes = decoder0.readInt(100);
      int readInt = decoder0.readInt(104);
      result.primaryPointerType = readInt;
      PointerType.validate(readInt);
      result.primaryPointerType = PointerType.toKnownValue(result.primaryPointerType);
      int readInt2 = decoder0.readInt(108);
      result.outputDeviceUpdateAbilityType = readInt2;
      OutputDeviceUpdateAbilityType.validate(readInt2);
      result.outputDeviceUpdateAbilityType =
          OutputDeviceUpdateAbilityType.toKnownValue(result.outputDeviceUpdateAbilityType);
      result.availableHoverTypes = decoder0.readInt(112);
      int readInt3 = decoder0.readInt(116);
      result.primaryHoverType = readInt3;
      HoverType.validate(readInt3);
      result.primaryHoverType = HoverType.toKnownValue(result.primaryHoverType);
      result.numberOfCpuCores = decoder0.readInt(120);
      int readInt4 = decoder0.readInt(124);
      result.editingBehavior = readInt4;
      EditingBehavior.validate(readInt4);
      result.editingBehavior = EditingBehavior.toKnownValue(result.editingBehavior);
      int readInt5 = decoder0.readInt(128);
      result.viewportStyle = readInt5;
      ViewportStyle.validate(readInt5);
      result.viewportStyle = ViewportStyle.toKnownValue(result.viewportStyle);
      result.fakeNoAllocDirectCallForTestingEnabled = decoder0.readBoolean(132, 0);
      result.recordWholeDocument = decoder0.readBoolean(132, 1);
      result.stylusHandwritingEnabled = decoder0.readBoolean(132, 2);
      result.cookieEnabled = decoder0.readBoolean(132, 3);
      result.acceleratedVideoDecodeEnabled = decoder0.readBoolean(132, 4);
      result.userGestureRequiredForPresentation = decoder0.readBoolean(132, 5);
      result.textTracksEnabled = decoder0.readBoolean(132, 6);
      result.immersiveModeEnabled = decoder0.readBoolean(132, 7);
      result.doubleTapToZoomEnabled = decoder0.readBoolean(133, 0);
      result.fullscreenSupported = decoder0.readBoolean(133, 1);
      result.textAutosizingEnabled = decoder0.readBoolean(133, 2);
      result.forceEnableZoom = decoder0.readBoolean(133, 3);
      result.supportDeprecatedTargetDensityDpi = decoder0.readBoolean(133, 4);
      result.wideViewportQuirk = decoder0.readBoolean(133, 5);
      result.useWideViewport = decoder0.readBoolean(133, 6);
      result.forceZeroLayoutHeight = decoder0.readBoolean(133, 7);
      result.viewportMetaMergeContentQuirk = decoder0.readBoolean(134, 0);
      result.viewportMetaNonUserScalableQuirk = decoder0.readBoolean(134, 1);
      result.viewportMetaZeroValuesQuirk = decoder0.readBoolean(134, 2);
      result.clobberUserAgentInitialScaleQuirk = decoder0.readBoolean(134, 3);
      result.ignoreMainFrameOverflowHiddenQuirk = decoder0.readBoolean(134, 4);
      result.reportScreenSizeInPhysicalPixelsQuirk = decoder0.readBoolean(134, 5);
      result.reuseGlobalForUnownedMainFrame = decoder0.readBoolean(134, 6);
      result.spellcheckEnabledByDefault = decoder0.readBoolean(134, 7);
      result.videoFullscreenOrientationLockEnabled = decoder0.readBoolean(135, 0);
      result.videoRotateToFullscreenEnabled = decoder0.readBoolean(135, 1);
      result.embeddedMediaExperienceEnabled = decoder0.readBoolean(135, 2);
      result.cssHexAlphaColorEnabled = decoder0.readBoolean(135, 3);
      result.scrollTopLeftInteropEnabled = decoder0.readBoolean(135, 4);
      result.disableAcceleratedSmallCanvases = decoder0.readBoolean(135, 5);
      result.disableWebauthn = decoder0.readBoolean(135, 6);
      result.forceDarkModeEnabled = decoder0.readBoolean(135, 7);
      int readInt6 = decoder0.readInt(136);
      result.v8CacheOptions = readInt6;
      V8CacheOptions.validate(readInt6);
      result.v8CacheOptions = V8CacheOptions.toKnownValue(result.v8CacheOptions);
      int readInt7 = decoder0.readInt(140);
      result.animationPolicy = readInt7;
      ImageAnimationPolicy.validate(readInt7);
      result.animationPolicy = ImageAnimationPolicy.toKnownValue(result.animationPolicy);
      result.textTrackBackgroundColor = decoder0.readString(144, false);
      result.textTrackTextColor = decoder0.readString(152, false);
      result.textTrackTextSize = decoder0.readString(160, false);
      result.textTrackTextShadow = decoder0.readString(168, false);
      result.textTrackFontFamily = decoder0.readString(176, false);
      result.textTrackFontStyle = decoder0.readString(184, false);
      result.textTrackFontVariant = decoder0.readString(192, false);
      result.textTrackWindowColor = decoder0.readString(200, false);
      result.textTrackWindowRadius = decoder0.readString(208, false);
      result.textTrackMarginPercentage = decoder0.readFloat(216);
      result.fontScaleFactor = decoder0.readFloat(220);
      result.webAppScope =
          Url.decode(decoder0.readPointer(CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH, false));
      result.fontWeightAdjustment = decoder0.readInt(232);
      result.textSizeContrastFactor = decoder0.readInt(CssSampleId.FLEX_FLOW);
      result.deviceScaleAdjustment = decoder0.readFloat(240);
      result.defaultMinimumPageScaleFactor = decoder0.readFloat(244);
      result.defaultVideoPosterUrl = Url.decode(decoder0.readPointer(248, false));
      result.defaultMaximumPageScaleFactor = decoder0.readFloat(256);
      result.hideDownloadUi = decoder0.readBoolean(260, 0);
      result.presentationReceiver = decoder0.readBoolean(260, 1);
      result.mediaControlsEnabled = decoder0.readBoolean(260, 2);
      result.doNotUpdateSelectionOnMutatingSelectionRange = decoder0.readBoolean(260, 3);
      result.requireTransientActivationForGetDisplayMedia = decoder0.readBoolean(260, 4);
      result.requireTransientActivationForShowFileOrDirectoryPicker = decoder0.readBoolean(260, 5);
      result.requireTransientActivationForHtmlFullscreen = decoder0.readBoolean(260, 6);
      result.requireTransientActivationAndUserConfirmationForSubappsApi =
          decoder0.readBoolean(260, 7);
      result.pictureInPictureEnabled =
          decoder0.readBoolean(WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 0);
      result.translateServiceAvailable =
          decoder0.readBoolean(WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 1);
      result.lazyLoadEnabled =
          decoder0.readBoolean(WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 2);
      result.allowMixedContentUpgrades =
          decoder0.readBoolean(WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 3);
      result.alwaysShowFocus =
          decoder0.readBoolean(WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 4);
      result.touchDragDropEnabled =
          decoder0.readBoolean(WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 5);
      result.webxrImmersiveArAllowed =
          decoder0.readBoolean(WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 6);
      result.rendererWideNamedFrameLookup =
          decoder0.readBoolean(WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 7);
      result.strictMimeTypeCheckForWorkerScriptsEnabled =
          decoder0.readBoolean(WebFeature.DEPRECATED_WEB_KIT_REPEATING_LINEAR_GRADIENT, 0);
      result.modalContextMenu =
          decoder0.readBoolean(WebFeature.DEPRECATED_WEB_KIT_REPEATING_LINEAR_GRADIENT, 1);
      int readInt8 = decoder0.readInt(264);
      result.autoplayPolicy = readInt8;
      AutoplayPolicy.validate(readInt8);
      result.autoplayPolicy = AutoplayPolicy.toKnownValue(result.autoplayPolicy);
      int readInt9 = decoder0.readInt(CssSampleId.WEBKIT_MARGIN_TOP_COLLAPSE);
      result.preferredColorScheme = readInt9;
      PreferredColorScheme.validate(readInt9);
      result.preferredColorScheme = PreferredColorScheme.toKnownValue(result.preferredColorScheme);
      int readInt10 = decoder0.readInt(CssSampleId.ALIAS_WEBKIT_MARGIN_END);
      result.preferredContrast = readInt10;
      PreferredContrast.validate(readInt10);
      result.preferredContrast = PreferredContrast.toKnownValue(result.preferredContrast);
      int readInt11 = decoder0.readInt(WebFeature.HTML_ANCHOR_ELEMENT_PING_ATTRIBUTE);
      result.lowPriorityIframesThreshold = readInt11;
      EffectiveConnectionType.validate(readInt11);
      result.lowPriorityIframesThreshold =
          EffectiveConnectionType.toKnownValue(result.lowPriorityIframesThreshold);
      int readInt12 = decoder0.readInt(CssSampleId.WEBKIT_MASK);
      result.networkQualityEstimatorWebHoldback = readInt12;
      EffectiveConnectionType.validate(readInt12);
      result.networkQualityEstimatorWebHoldback =
          EffectiveConnectionType.toKnownValue(result.networkQualityEstimatorWebHoldback);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    if (this.standardFontFamilyMap == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encoderForMap(8);
      int size0 = this.standardFontFamilyMap.size();
      String[] keys0 = new String[size0];
      String16[] values0 = new String16[size0];
      int index0 = 0;
      for (Map.Entry<String, String16> entry0 : this.standardFontFamilyMap.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue();
        index0++;
      }
      Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode(keys0[i1], (i1 * 8) + 8, false);
      }
      Encoder encoder22 = encoder1.encodePointerArray(values0.length, 16, -1);
      for (int i12 = 0; i12 < values0.length; i12++) {
        encoder22.encode((Struct) values0[i12], (i12 * 8) + 8, false);
      }
    }
    if (this.fixedFontFamilyMap == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder12 = encoder0.encoderForMap(16);
      int size02 = this.fixedFontFamilyMap.size();
      String[] keys02 = new String[size02];
      String16[] values02 = new String16[size02];
      int index02 = 0;
      for (Map.Entry<String, String16> entry02 : this.fixedFontFamilyMap.entrySet()) {
        keys02[index02] = entry02.getKey();
        values02[index02] = entry02.getValue();
        index02++;
      }
      Encoder encoder23 = encoder12.encodePointerArray(keys02.length, 8, -1);
      for (int i13 = 0; i13 < keys02.length; i13++) {
        encoder23.encode(keys02[i13], (i13 * 8) + 8, false);
      }
      Encoder encoder24 = encoder12.encodePointerArray(values02.length, 16, -1);
      for (int i14 = 0; i14 < values02.length; i14++) {
        encoder24.encode((Struct) values02[i14], (i14 * 8) + 8, false);
      }
    }
    if (this.serifFontFamilyMap == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder13 = encoder0.encoderForMap(24);
      int size03 = this.serifFontFamilyMap.size();
      String[] keys03 = new String[size03];
      String16[] values03 = new String16[size03];
      int index03 = 0;
      for (Map.Entry<String, String16> entry03 : this.serifFontFamilyMap.entrySet()) {
        keys03[index03] = entry03.getKey();
        values03[index03] = entry03.getValue();
        index03++;
      }
      Encoder encoder25 = encoder13.encodePointerArray(keys03.length, 8, -1);
      for (int i15 = 0; i15 < keys03.length; i15++) {
        encoder25.encode(keys03[i15], (i15 * 8) + 8, false);
      }
      Encoder encoder26 = encoder13.encodePointerArray(values03.length, 16, -1);
      for (int i16 = 0; i16 < values03.length; i16++) {
        encoder26.encode((Struct) values03[i16], (i16 * 8) + 8, false);
      }
    }
    if (this.sansSerifFontFamilyMap == null) {
      encoder0.encodeNullPointer(32, false);
    } else {
      Encoder encoder14 = encoder0.encoderForMap(32);
      int size04 = this.sansSerifFontFamilyMap.size();
      String[] keys04 = new String[size04];
      String16[] values04 = new String16[size04];
      int index04 = 0;
      for (Map.Entry<String, String16> entry04 : this.sansSerifFontFamilyMap.entrySet()) {
        keys04[index04] = entry04.getKey();
        values04[index04] = entry04.getValue();
        index04++;
      }
      Encoder encoder27 = encoder14.encodePointerArray(keys04.length, 8, -1);
      for (int i17 = 0; i17 < keys04.length; i17++) {
        encoder27.encode(keys04[i17], (i17 * 8) + 8, false);
      }
      Encoder encoder28 = encoder14.encodePointerArray(values04.length, 16, -1);
      for (int i18 = 0; i18 < values04.length; i18++) {
        encoder28.encode((Struct) values04[i18], (i18 * 8) + 8, false);
      }
    }
    if (this.cursiveFontFamilyMap == null) {
      encoder0.encodeNullPointer(40, false);
    } else {
      Encoder encoder15 = encoder0.encoderForMap(40);
      int size05 = this.cursiveFontFamilyMap.size();
      String[] keys05 = new String[size05];
      String16[] values05 = new String16[size05];
      int index05 = 0;
      for (Map.Entry<String, String16> entry05 : this.cursiveFontFamilyMap.entrySet()) {
        keys05[index05] = entry05.getKey();
        values05[index05] = entry05.getValue();
        index05++;
      }
      Encoder encoder29 = encoder15.encodePointerArray(keys05.length, 8, -1);
      for (int i19 = 0; i19 < keys05.length; i19++) {
        encoder29.encode(keys05[i19], (i19 * 8) + 8, false);
      }
      Encoder encoder210 = encoder15.encodePointerArray(values05.length, 16, -1);
      for (int i110 = 0; i110 < values05.length; i110++) {
        encoder210.encode((Struct) values05[i110], (i110 * 8) + 8, false);
      }
    }
    if (this.fantasyFontFamilyMap == null) {
      encoder0.encodeNullPointer(48, false);
    } else {
      Encoder encoder16 = encoder0.encoderForMap(48);
      int size06 = this.fantasyFontFamilyMap.size();
      String[] keys06 = new String[size06];
      String16[] values06 = new String16[size06];
      int index06 = 0;
      for (Map.Entry<String, String16> entry06 : this.fantasyFontFamilyMap.entrySet()) {
        keys06[index06] = entry06.getKey();
        values06[index06] = entry06.getValue();
        index06++;
      }
      Encoder encoder211 = encoder16.encodePointerArray(keys06.length, 8, -1);
      for (int i111 = 0; i111 < keys06.length; i111++) {
        encoder211.encode(keys06[i111], (i111 * 8) + 8, false);
      }
      Encoder encoder212 = encoder16.encodePointerArray(values06.length, 16, -1);
      for (int i112 = 0; i112 < values06.length; i112++) {
        encoder212.encode((Struct) values06[i112], (i112 * 8) + 8, false);
      }
    }
    if (this.mathFontFamilyMap == null) {
      encoder0.encodeNullPointer(56, false);
    } else {
      Encoder encoder17 = encoder0.encoderForMap(56);
      int size07 = this.mathFontFamilyMap.size();
      String[] keys07 = new String[size07];
      String16[] values07 = new String16[size07];
      int index07 = 0;
      for (Map.Entry<String, String16> entry07 : this.mathFontFamilyMap.entrySet()) {
        keys07[index07] = entry07.getKey();
        values07[index07] = entry07.getValue();
        index07++;
      }
      Encoder encoder213 = encoder17.encodePointerArray(keys07.length, 8, -1);
      for (int i113 = 0; i113 < keys07.length; i113++) {
        encoder213.encode(keys07[i113], (i113 * 8) + 8, false);
      }
      Encoder encoder214 = encoder17.encodePointerArray(values07.length, 16, -1);
      for (int i114 = 0; i114 < values07.length; i114++) {
        encoder214.encode((Struct) values07[i114], (i114 * 8) + 8, false);
      }
    }
    encoder0.encode(this.defaultFontSize, 64);
    encoder0.encode(this.defaultFixedFontSize, 68);
    encoder0.encode(this.minimumFontSize, 72);
    encoder0.encode(this.minimumLogicalFontSize, 76);
    encoder0.encode(this.defaultEncoding, 80, false);
    encoder0.encode(this.contextMenuOnMouseUp, 88, 0);
    encoder0.encode(this.javascriptEnabled, 88, 1);
    encoder0.encode(this.webSecurityEnabled, 88, 2);
    encoder0.encode(this.loadsImagesAutomatically, 88, 3);
    encoder0.encode(this.imagesEnabled, 88, 4);
    encoder0.encode(this.pluginsEnabled, 88, 5);
    encoder0.encode(this.domPasteEnabled, 88, 6);
    encoder0.encode(this.shrinksStandaloneImagesToFit, 88, 7);
    encoder0.encode(this.textAreasAreResizable, 89, 0);
    encoder0.encode(this.allowScriptsToCloseWindows, 89, 1);
    encoder0.encode(this.remoteFontsEnabled, 89, 2);
    encoder0.encode(this.javascriptCanAccessClipboard, 89, 3);
    encoder0.encode(this.dnsPrefetchingEnabled, 89, 4);
    encoder0.encode(this.dataSaverEnabled, 89, 5);
    encoder0.encode(this.localStorageEnabled, 89, 6);
    encoder0.encode(this.databasesEnabled, 89, 7);
    encoder0.encode(this.tabsToLinks, 90, 0);
    encoder0.encode(this.disableIpcFloodingProtection, 90, 1);
    encoder0.encode(this.hyperlinkAuditingEnabled, 90, 2);
    encoder0.encode(this.allowUniversalAccessFromFileUrls, 90, 3);
    encoder0.encode(this.allowFileAccessFromFileUrls, 90, 4);
    encoder0.encode(this.webgl1Enabled, 90, 5);
    encoder0.encode(this.webgl2Enabled, 90, 6);
    encoder0.encode(this.pepper3dEnabled, 90, 7);
    encoder0.encode(this.privilegedWebglExtensionsEnabled, 91, 0);
    encoder0.encode(this.webglErrorsToConsoleEnabled, 91, 1);
    encoder0.encode(this.hideScrollbars, 91, 2);
    encoder0.encode(this.prefersDefaultScrollbarStyles, 91, 3);
    encoder0.encode(this.accelerated2dCanvasEnabled, 91, 4);
    encoder0.encode(this.canvas2dLayersEnabled, 91, 5);
    encoder0.encode(this.antialiased2dCanvasDisabled, 91, 6);
    encoder0.encode(this.antialiasedClips2dCanvasEnabled, 91, 7);
    encoder0.encode(this.acceleratedFiltersEnabled, 92, 0);
    encoder0.encode(this.deferredFiltersEnabled, 92, 1);
    encoder0.encode(this.containerCullingEnabled, 92, 2);
    encoder0.encode(this.allowRunningInsecureContent, 92, 3);
    encoder0.encode(this.disableReadingFromCanvas, 92, 4);
    encoder0.encode(this.strictMixedContentChecking, 92, 5);
    encoder0.encode(this.strictPowerfulFeatureRestrictions, 92, 6);
    encoder0.encode(this.allowGeolocationOnInsecureOrigins, 92, 7);
    encoder0.encode(this.strictlyBlockBlockableMixedContent, 93, 0);
    encoder0.encode(this.blockMixedPluginContent, 93, 1);
    encoder0.encode(this.passwordEchoEnabled, 93, 2);
    encoder0.encode(this.shouldClearDocumentBackground, 93, 3);
    encoder0.encode(this.enableScrollAnimator, 93, 4);
    encoder0.encode(this.prefersReducedMotion, 93, 5);
    encoder0.encode(this.prefersReducedTransparency, 93, 6);
    encoder0.encode(this.invertedColors, 93, 7);
    encoder0.encode(this.touchEventFeatureDetectionEnabled, 94, 0);
    encoder0.encode(this.dontSendKeyEventsToJavascript, 94, 1);
    encoder0.encode(this.barrelButtonForDragEnabled, 94, 2);
    encoder0.encode(this.syncXhrInDocumentsEnabled, 94, 3);
    encoder0.encode(this.targetBlankImpliesNoOpenerEnabledWillBeRemoved, 94, 4);
    encoder0.encode(this.allowNonEmptyNavigatorPlugins, 94, 5);
    encoder0.encode(this.supportsMultipleWindows, 94, 6);
    encoder0.encode(this.viewportEnabled, 94, 7);
    encoder0.encode(this.viewportMetaEnabled, 95, 0);
    encoder0.encode(this.autoZoomFocusedEditableToLegibleScale, 95, 1);
    encoder0.encode(this.shrinksViewportContentsToFit, 95, 2);
    encoder0.encode(this.smoothScrollForFindEnabled, 95, 3);
    encoder0.encode(this.mainFrameResizesAreOrientationChanges, 95, 4);
    encoder0.encode(this.initializeAtMinimumPageScale, 95, 5);
    encoder0.encode(this.smartInsertDeleteEnabled, 95, 6);
    encoder0.encode(this.spatialNavigationEnabled, 95, 7);
    encoder0.encode(this.pointerEventsMaxTouchPoints, 96);
    encoder0.encode(this.availablePointerTypes, 100);
    encoder0.encode(this.primaryPointerType, 104);
    encoder0.encode(this.outputDeviceUpdateAbilityType, 108);
    encoder0.encode(this.availableHoverTypes, 112);
    encoder0.encode(this.primaryHoverType, 116);
    encoder0.encode(this.numberOfCpuCores, 120);
    encoder0.encode(this.editingBehavior, 124);
    encoder0.encode(this.viewportStyle, 128);
    encoder0.encode(this.fakeNoAllocDirectCallForTestingEnabled, 132, 0);
    encoder0.encode(this.recordWholeDocument, 132, 1);
    encoder0.encode(this.stylusHandwritingEnabled, 132, 2);
    encoder0.encode(this.cookieEnabled, 132, 3);
    encoder0.encode(this.acceleratedVideoDecodeEnabled, 132, 4);
    encoder0.encode(this.userGestureRequiredForPresentation, 132, 5);
    encoder0.encode(this.textTracksEnabled, 132, 6);
    encoder0.encode(this.immersiveModeEnabled, 132, 7);
    encoder0.encode(this.doubleTapToZoomEnabled, 133, 0);
    encoder0.encode(this.fullscreenSupported, 133, 1);
    encoder0.encode(this.textAutosizingEnabled, 133, 2);
    encoder0.encode(this.forceEnableZoom, 133, 3);
    encoder0.encode(this.supportDeprecatedTargetDensityDpi, 133, 4);
    encoder0.encode(this.wideViewportQuirk, 133, 5);
    encoder0.encode(this.useWideViewport, 133, 6);
    encoder0.encode(this.forceZeroLayoutHeight, 133, 7);
    encoder0.encode(this.viewportMetaMergeContentQuirk, 134, 0);
    encoder0.encode(this.viewportMetaNonUserScalableQuirk, 134, 1);
    encoder0.encode(this.viewportMetaZeroValuesQuirk, 134, 2);
    encoder0.encode(this.clobberUserAgentInitialScaleQuirk, 134, 3);
    encoder0.encode(this.ignoreMainFrameOverflowHiddenQuirk, 134, 4);
    encoder0.encode(this.reportScreenSizeInPhysicalPixelsQuirk, 134, 5);
    encoder0.encode(this.reuseGlobalForUnownedMainFrame, 134, 6);
    encoder0.encode(this.spellcheckEnabledByDefault, 134, 7);
    encoder0.encode(this.videoFullscreenOrientationLockEnabled, 135, 0);
    encoder0.encode(this.videoRotateToFullscreenEnabled, 135, 1);
    encoder0.encode(this.embeddedMediaExperienceEnabled, 135, 2);
    encoder0.encode(this.cssHexAlphaColorEnabled, 135, 3);
    encoder0.encode(this.scrollTopLeftInteropEnabled, 135, 4);
    encoder0.encode(this.disableAcceleratedSmallCanvases, 135, 5);
    encoder0.encode(this.disableWebauthn, 135, 6);
    encoder0.encode(this.forceDarkModeEnabled, 135, 7);
    encoder0.encode(this.v8CacheOptions, 136);
    encoder0.encode(this.animationPolicy, 140);
    encoder0.encode(this.textTrackBackgroundColor, 144, false);
    encoder0.encode(this.textTrackTextColor, 152, false);
    encoder0.encode(this.textTrackTextSize, 160, false);
    encoder0.encode(this.textTrackTextShadow, 168, false);
    encoder0.encode(this.textTrackFontFamily, 176, false);
    encoder0.encode(this.textTrackFontStyle, 184, false);
    encoder0.encode(this.textTrackFontVariant, 192, false);
    encoder0.encode(this.textTrackWindowColor, 200, false);
    encoder0.encode(this.textTrackWindowRadius, 208, false);
    encoder0.encode(this.textTrackMarginPercentage, 216);
    encoder0.encode(this.fontScaleFactor, 220);
    encoder0.encode((Struct) this.webAppScope, CssSampleId.ALIAS_WEBKIT_COLUMN_RULE_WIDTH, false);
    encoder0.encode(this.fontWeightAdjustment, 232);
    encoder0.encode(this.textSizeContrastFactor, CssSampleId.FLEX_FLOW);
    encoder0.encode(this.deviceScaleAdjustment, 240);
    encoder0.encode(this.defaultMinimumPageScaleFactor, 244);
    encoder0.encode((Struct) this.defaultVideoPosterUrl, 248, false);
    encoder0.encode(this.defaultMaximumPageScaleFactor, 256);
    encoder0.encode(this.hideDownloadUi, 260, 0);
    encoder0.encode(this.presentationReceiver, 260, 1);
    encoder0.encode(this.mediaControlsEnabled, 260, 2);
    encoder0.encode(this.doNotUpdateSelectionOnMutatingSelectionRange, 260, 3);
    encoder0.encode(this.requireTransientActivationForGetDisplayMedia, 260, 4);
    encoder0.encode(this.requireTransientActivationForShowFileOrDirectoryPicker, 260, 5);
    encoder0.encode(this.requireTransientActivationForHtmlFullscreen, 260, 6);
    encoder0.encode(this.requireTransientActivationAndUserConfirmationForSubappsApi, 260, 7);
    encoder0.encode(this.pictureInPictureEnabled, WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 0);
    encoder0.encode(
        this.translateServiceAvailable, WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 1);
    encoder0.encode(this.lazyLoadEnabled, WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 2);
    encoder0.encode(
        this.allowMixedContentUpgrades, WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 3);
    encoder0.encode(this.alwaysShowFocus, WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 4);
    encoder0.encode(this.touchDragDropEnabled, WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 5);
    encoder0.encode(this.webxrImmersiveArAllowed, WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 6);
    encoder0.encode(
        this.rendererWideNamedFrameLookup, WebFeature.DEPRECATED_WEB_KIT_LINEAR_GRADIENT, 7);
    encoder0.encode(
        this.strictMimeTypeCheckForWorkerScriptsEnabled,
        WebFeature.DEPRECATED_WEB_KIT_REPEATING_LINEAR_GRADIENT,
        0);
    encoder0.encode(
        this.modalContextMenu, WebFeature.DEPRECATED_WEB_KIT_REPEATING_LINEAR_GRADIENT, 1);
    encoder0.encode(this.autoplayPolicy, 264);
    encoder0.encode(this.preferredColorScheme, CssSampleId.WEBKIT_MARGIN_TOP_COLLAPSE);
    encoder0.encode(this.preferredContrast, CssSampleId.ALIAS_WEBKIT_MARGIN_END);
    encoder0.encode(
        this.lowPriorityIframesThreshold, WebFeature.HTML_ANCHOR_ELEMENT_PING_ATTRIBUTE);
    encoder0.encode(this.networkQualityEstimatorWebHoldback, CssSampleId.WEBKIT_MASK);
  }
}
