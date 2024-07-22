package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AudioProcessingSettings extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean automaticGainControl;
  public boolean echoCancellation;
  public boolean forceApmCreation;
  public boolean highPassFilter;
  public boolean multiChannelCaptureProcessing;
  public boolean noiseSuppression;
  public boolean stereoMirroring;
  public boolean transientNoiseSuppression;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AudioProcessingSettings(int version) {
    super(16, version);
  }

  public AudioProcessingSettings() {
    this(0);
  }

  public static AudioProcessingSettings deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AudioProcessingSettings deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AudioProcessingSettings decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AudioProcessingSettings result = new AudioProcessingSettings(elementsOrVersion);
      result.echoCancellation = decoder0.readBoolean(8, 0);
      result.noiseSuppression = decoder0.readBoolean(8, 1);
      result.transientNoiseSuppression = decoder0.readBoolean(8, 2);
      result.automaticGainControl = decoder0.readBoolean(8, 3);
      result.highPassFilter = decoder0.readBoolean(8, 4);
      result.multiChannelCaptureProcessing = decoder0.readBoolean(8, 5);
      result.stereoMirroring = decoder0.readBoolean(8, 6);
      result.forceApmCreation = decoder0.readBoolean(8, 7);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.echoCancellation, 8, 0);
    encoder0.encode(this.noiseSuppression, 8, 1);
    encoder0.encode(this.transientNoiseSuppression, 8, 2);
    encoder0.encode(this.automaticGainControl, 8, 3);
    encoder0.encode(this.highPassFilter, 8, 4);
    encoder0.encode(this.multiChannelCaptureProcessing, 8, 5);
    encoder0.encode(this.stereoMirroring, 8, 6);
    encoder0.encode(this.forceApmCreation, 8, 7);
  }
}
