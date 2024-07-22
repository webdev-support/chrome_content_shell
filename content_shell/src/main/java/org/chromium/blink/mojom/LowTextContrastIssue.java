package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class LowTextContrastIssue extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public float contrastRatio;
  public String fontSize;
  public String fontWeight;
  public float thresholdAa;
  public float thresholdAaa;
  public int violatingNodeId;
  public String violatingNodeSelector;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private LowTextContrastIssue(int version) {
    super(48, version);
  }

  public LowTextContrastIssue() {
    this(0);
  }

  public static LowTextContrastIssue deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static LowTextContrastIssue deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static LowTextContrastIssue decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      LowTextContrastIssue result = new LowTextContrastIssue(elementsOrVersion);
      result.violatingNodeId = decoder0.readInt(8);
      result.contrastRatio = decoder0.readFloat(12);
      result.violatingNodeSelector = decoder0.readString(16, false);
      result.thresholdAa = decoder0.readFloat(24);
      result.thresholdAaa = decoder0.readFloat(28);
      result.fontSize = decoder0.readString(32, false);
      result.fontWeight = decoder0.readString(40, false);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.violatingNodeId, 8);
    encoder0.encode(this.contrastRatio, 12);
    encoder0.encode(this.violatingNodeSelector, 16, false);
    encoder0.encode(this.thresholdAa, 24);
    encoder0.encode(this.thresholdAaa, 28);
    encoder0.encode(this.fontSize, 32, false);
    encoder0.encode(this.fontWeight, 40, false);
  }
}
