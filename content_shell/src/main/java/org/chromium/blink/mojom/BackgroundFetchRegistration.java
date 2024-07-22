package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class BackgroundFetchRegistration extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 24;
  private static final DataHeader[] VERSION_ARRAY;
  public BackgroundFetchRegistrationData registrationData;
  public BackgroundFetchRegistrationService registrationInterface;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private BackgroundFetchRegistration(int version) {
    super(24, version);
  }

  public BackgroundFetchRegistration() {
    this(0);
  }

  public static BackgroundFetchRegistration deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static BackgroundFetchRegistration deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static BackgroundFetchRegistration decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      BackgroundFetchRegistration result = new BackgroundFetchRegistration(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.registrationData = BackgroundFetchRegistrationData.decode(decoder1);
      result.registrationInterface =
          (BackgroundFetchRegistrationService)
              decoder0.readServiceInterface(16, false, BackgroundFetchRegistrationService.MANAGER);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.registrationData, 8, false);
    encoder0.encode(
        this.registrationInterface, 16, false, BackgroundFetchRegistrationService.MANAGER);
  }
}
