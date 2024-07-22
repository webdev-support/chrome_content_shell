package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class NavigationDownloadTypes extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 16;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean adFrame;
  public boolean adFrameNoGesture;
  public boolean interstitial;
  public boolean noGesture;
  public boolean openerCrossOrigin;
  public boolean sandbox;
  public boolean viewSource;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NavigationDownloadTypes(int version) {
    super(16, version);
  }

  public NavigationDownloadTypes() {
    this(0);
  }

  public static NavigationDownloadTypes deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NavigationDownloadTypes deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NavigationDownloadTypes decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NavigationDownloadTypes result = new NavigationDownloadTypes(elementsOrVersion);
      result.viewSource = decoder0.readBoolean(8, 0);
      result.interstitial = decoder0.readBoolean(8, 1);
      result.openerCrossOrigin = decoder0.readBoolean(8, 2);
      result.adFrameNoGesture = decoder0.readBoolean(8, 3);
      result.adFrame = decoder0.readBoolean(8, 4);
      result.sandbox = decoder0.readBoolean(8, 5);
      result.noGesture = decoder0.readBoolean(8, 6);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.viewSource, 8, 0);
    encoder0.encode(this.interstitial, 8, 1);
    encoder0.encode(this.openerCrossOrigin, 8, 2);
    encoder0.encode(this.adFrameNoGesture, 8, 3);
    encoder0.encode(this.adFrame, 8, 4);
    encoder0.encode(this.sandbox, 8, 5);
    encoder0.encode(this.noGesture, 8, 6);
  }
}
