package org.chromium.content_settings.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.Value;

public final class ContentSettingPatternSource extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 64;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean incognito;
  public RuleMetaData metadata;
  public ContentSettingsPattern primaryPattern;
  public ContentSettingsPattern secondaryPattern;
  public Value settingValue;
  public String source;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(64, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ContentSettingPatternSource(int version) {
    super(64, version);
  }

  public ContentSettingPatternSource() {
    this(0);
  }

  public static ContentSettingPatternSource deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ContentSettingPatternSource deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ContentSettingPatternSource decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ContentSettingPatternSource result = new ContentSettingPatternSource(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.primaryPattern = ContentSettingsPattern.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.secondaryPattern = ContentSettingsPattern.decode(decoder12);
      result.settingValue = Value.decode(decoder0, 24);
      Decoder decoder13 = decoder0.readPointer(40, false);
      result.metadata = RuleMetaData.decode(decoder13);
      result.source = decoder0.readString(48, false);
      result.incognito = decoder0.readBoolean(56, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.primaryPattern, 8, false);
    encoder0.encode((Struct) this.secondaryPattern, 16, false);
    encoder0.encode((Union) this.settingValue, 24, false);
    encoder0.encode((Struct) this.metadata, 40, false);
    encoder0.encode(this.source, 48, false);
    encoder0.encode(this.incognito, 56, 0);
  }
}
