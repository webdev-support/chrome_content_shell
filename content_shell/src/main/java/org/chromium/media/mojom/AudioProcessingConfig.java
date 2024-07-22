package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class AudioProcessingConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public InterfaceRequest<AudioProcessorControls> controlsReceiver;
  public AudioProcessingSettings settings;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private AudioProcessingConfig(int version) {
    super(24, version);
  }

  public AudioProcessingConfig() {
    this(0);
  }

  public static AudioProcessingConfig deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static AudioProcessingConfig deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static AudioProcessingConfig decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      AudioProcessingConfig result = new AudioProcessingConfig(elementsOrVersion);
      result.controlsReceiver = decoder0.readInterfaceRequest(8, false);
      Decoder decoder1 = decoder0.readPointer(16, false);
      result.settings = AudioProcessingSettings.decode(decoder1);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((InterfaceRequest) this.controlsReceiver, 8, false);
    encoder0.encode((Struct) this.settings, 16, false);
  }
}
