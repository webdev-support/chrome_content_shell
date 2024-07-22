package org.chromium.content_settings.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.components.content_settings.TpcdMetadataRuleSource;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.Time;
import org.chromium.mojo_base.mojom.TimeDelta;

public final class RuleMetaData extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 56;
  private static final DataHeader[] VERSION_ARRAY;
  public Time expiration;
  public Time lastModified;
  public Time lastUsed;
  public Time lastVisited;
  public TimeDelta lifetime;
  public int sessionModel;
  public int tpcdMetadataRuleSource;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(56, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private RuleMetaData(int version) {
    super(56, version);
  }

  public RuleMetaData() {
    this(0);
  }

  public static RuleMetaData deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static RuleMetaData deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static RuleMetaData decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      RuleMetaData result = new RuleMetaData(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.lastModified = Time.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.lastUsed = Time.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      result.lastVisited = Time.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, false);
      result.expiration = Time.decode(decoder14);
      int readInt = decoder0.readInt(40);
      result.sessionModel = readInt;
      SessionModel.validate(readInt);
      result.sessionModel = SessionModel.toKnownValue(result.sessionModel);
      int readInt2 = decoder0.readInt(44);
      result.tpcdMetadataRuleSource = readInt2;
      TpcdMetadataRuleSource.validate(readInt2);
      result.tpcdMetadataRuleSource =
          TpcdMetadataRuleSource.toKnownValue(result.tpcdMetadataRuleSource);
      Decoder decoder15 = decoder0.readPointer(48, false);
      result.lifetime = TimeDelta.decode(decoder15);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.lastModified, 8, false);
    encoder0.encode((Struct) this.lastUsed, 16, false);
    encoder0.encode((Struct) this.lastVisited, 24, false);
    encoder0.encode((Struct) this.expiration, 32, false);
    encoder0.encode(this.sessionModel, 40);
    encoder0.encode(this.tpcdMetadataRuleSource, 44);
    encoder0.encode((Struct) this.lifetime, 48, false);
  }
}
