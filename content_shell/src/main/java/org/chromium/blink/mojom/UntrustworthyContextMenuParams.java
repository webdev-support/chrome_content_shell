package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.network.mojom.ReferrerPolicy;
import org.chromium.ui.mojom.MenuSourceType;
import org.chromium.url.mojom.Url;

public final class UntrustworthyContextMenuParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 200;
  private static final DataHeader[] VERSION_ARRAY;
  public String16 altText;
  public CustomContextMenuItem[] customItems;
  public String16[] dictionarySuggestions;
  public int editFlags;
  public FieldRendererId fieldRendererId;
  public Integer formControlType;
  public FormRendererId formRendererId;
  public String frameCharset;
  public boolean hasImageContents;
  public Impression impression;
  public boolean isContentEditableForAutofill;
  public boolean isEditable;
  public boolean isImageMediaPluginDocument;
  public boolean isPasswordTypeByHeuristics;
  public Url linkFollowed;
  public String16 linkText;
  public Url linkUrl;
  public int mediaFlags;
  public int mediaType;
  public String16 misspelledWord;
  public boolean openedFromHighlight;
  public int referrerPolicy;
  public Rect selectionRect;
  public int selectionStartOffset;
  public String16 selectionText;
  public int sourceType;
  public boolean spellcheckEnabled;
  public Url srcUrl;
  public String16 suggestedFilename;
  public String16 titleText;
  public Url unfilteredLinkUrl;
  public int writingDirectionDefault;
  public int writingDirectionLeftToRight;
  public int writingDirectionRightToLeft;
  public int x;
  public int y;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(200, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UntrustworthyContextMenuParams(int version) {
    super(200, version);
  }

  public UntrustworthyContextMenuParams() {
    this(0);
  }

  public static UntrustworthyContextMenuParams deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UntrustworthyContextMenuParams deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UntrustworthyContextMenuParams decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UntrustworthyContextMenuParams result = new UntrustworthyContextMenuParams(elementsOrVersion);
      int readInt = decoder0.readInt(8);
      result.mediaType = readInt;
      ContextMenuDataMediaType.validate(readInt);
      result.mediaType = ContextMenuDataMediaType.toKnownValue(result.mediaType);
      result.x = decoder0.readInt(12);
      result.y = decoder0.readInt(16);
      result.hasImageContents = decoder0.readBoolean(20, 0);
      result.isImageMediaPluginDocument = decoder0.readBoolean(20, 1);
      result.spellcheckEnabled = decoder0.readBoolean(20, 2);
      result.isEditable = decoder0.readBoolean(20, 3);
      result.openedFromHighlight = decoder0.readBoolean(20, 4);
      if (decoder0.readBoolean(20, 5)) {
        result.formControlType = new Integer(decoder0.readInt(176));
      } else {
        result.formControlType = null;
      }
      result.isContentEditableForAutofill = decoder0.readBoolean(20, 6);
      result.isPasswordTypeByHeuristics = decoder0.readBoolean(20, 7);
      Decoder decoder1 = decoder0.readPointer(24, false);
      result.linkUrl = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(32, false);
      result.linkText = String16.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(40, true);
      result.impression = Impression.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(48, false);
      result.unfilteredLinkUrl = Url.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(56, false);
      result.srcUrl = Url.decode(decoder15);
      result.mediaFlags = decoder0.readInt(64);
      result.writingDirectionDefault = decoder0.readInt(68);
      Decoder decoder16 = decoder0.readPointer(72, false);
      result.selectionText = String16.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(80, false);
      result.titleText = String16.decode(decoder17);
      Decoder decoder18 = decoder0.readPointer(88, false);
      result.altText = String16.decode(decoder18);
      Decoder decoder19 = decoder0.readPointer(96, false);
      result.suggestedFilename = String16.decode(decoder19);
      Decoder decoder110 = decoder0.readPointer(104, false);
      result.misspelledWord = String16.decode(decoder110);
      Decoder decoder111 = decoder0.readPointer(112, false);
      DataHeader si1 = decoder111.readDataHeaderForPointerArray(-1);
      result.dictionarySuggestions = new String16[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder111.readPointer((i1 * 8) + 8, false);
        result.dictionarySuggestions[i1] = String16.decode(decoder2);
      }
      result.writingDirectionLeftToRight = decoder0.readInt(120);
      result.writingDirectionRightToLeft = decoder0.readInt(124);
      result.editFlags = decoder0.readInt(128);
      int readInt2 = decoder0.readInt(132);
      result.referrerPolicy = readInt2;
      ReferrerPolicy.validate(readInt2);
      result.referrerPolicy = ReferrerPolicy.toKnownValue(result.referrerPolicy);
      result.frameCharset = decoder0.readString(136, false);
      Decoder decoder112 = decoder0.readPointer(144, false);
      result.linkFollowed = Url.decode(decoder112);
      Decoder decoder113 = decoder0.readPointer(152, false);
      DataHeader si12 = decoder113.readDataHeaderForPointerArray(-1);
      result.customItems = new CustomContextMenuItem[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder113.readPointer((i12 * 8) + 8, false);
        result.customItems[i12] = CustomContextMenuItem.decode(decoder22);
      }
      int readInt3 = decoder0.readInt(160);
      result.sourceType = readInt3;
      MenuSourceType.validate(readInt3);
      result.sourceType = MenuSourceType.toKnownValue(result.sourceType);
      result.selectionStartOffset = decoder0.readInt(164);
      Decoder decoder114 = decoder0.readPointer(168, false);
      result.selectionRect = Rect.decode(decoder114);
      Decoder decoder115 = decoder0.readPointer(184, false);
      result.fieldRendererId = FieldRendererId.decode(decoder115);
      Decoder decoder116 = decoder0.readPointer(192, false);
      result.formRendererId = FormRendererId.decode(decoder116);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    int formControlType$value;
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.mediaType, 8);
    encoder0.encode(this.x, 12);
    encoder0.encode(this.y, 16);
    encoder0.encode(this.hasImageContents, 20, 0);
    encoder0.encode(this.isImageMediaPluginDocument, 20, 1);
    encoder0.encode(this.spellcheckEnabled, 20, 2);
    encoder0.encode(this.isEditable, 20, 3);
    encoder0.encode(this.openedFromHighlight, 20, 4);
    Integer num = this.formControlType;
    boolean formControlType$flag = num != null;
    if (formControlType$flag) {
      formControlType$value = num.intValue();
    } else {
      formControlType$value = 0;
    }
    encoder0.encode(formControlType$flag, 20, 5);
    encoder0.encode(formControlType$value, 176);
    encoder0.encode(this.isContentEditableForAutofill, 20, 6);
    encoder0.encode(this.isPasswordTypeByHeuristics, 20, 7);
    encoder0.encode((Struct) this.linkUrl, 24, false);
    encoder0.encode((Struct) this.linkText, 32, false);
    encoder0.encode((Struct) this.impression, 40, true);
    encoder0.encode((Struct) this.unfilteredLinkUrl, 48, false);
    encoder0.encode((Struct) this.srcUrl, 56, false);
    encoder0.encode(this.mediaFlags, 64);
    encoder0.encode(this.writingDirectionDefault, 68);
    encoder0.encode((Struct) this.selectionText, 72, false);
    encoder0.encode((Struct) this.titleText, 80, false);
    encoder0.encode((Struct) this.altText, 88, false);
    encoder0.encode((Struct) this.suggestedFilename, 96, false);
    encoder0.encode((Struct) this.misspelledWord, 104, false);
    String16[] string16Arr = this.dictionarySuggestions;
    if (string16Arr == null) {
      encoder0.encodeNullPointer(112, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(string16Arr.length, 112, -1);
      int i0 = 0;
      while (true) {
        String16[] string16Arr2 = this.dictionarySuggestions;
        if (i0 >= string16Arr2.length) {
          break;
        }
        encoder1.encode((Struct) string16Arr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode(this.writingDirectionLeftToRight, 120);
    encoder0.encode(this.writingDirectionRightToLeft, 124);
    encoder0.encode(this.editFlags, 128);
    encoder0.encode(this.referrerPolicy, 132);
    encoder0.encode(this.frameCharset, 136, false);
    encoder0.encode((Struct) this.linkFollowed, 144, false);
    CustomContextMenuItem[] customContextMenuItemArr = this.customItems;
    if (customContextMenuItemArr == null) {
      encoder0.encodeNullPointer(152, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(customContextMenuItemArr.length, 152, -1);
      int i02 = 0;
      while (true) {
        CustomContextMenuItem[] customContextMenuItemArr2 = this.customItems;
        if (i02 >= customContextMenuItemArr2.length) {
          break;
        }
        encoder12.encode((Struct) customContextMenuItemArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    encoder0.encode(this.sourceType, 160);
    encoder0.encode(this.selectionStartOffset, 164);
    encoder0.encode((Struct) this.selectionRect, 168, false);
    encoder0.encode((Struct) this.fieldRendererId, 184, false);
    encoder0.encode((Struct) this.formRendererId, 192, false);
  }
}
