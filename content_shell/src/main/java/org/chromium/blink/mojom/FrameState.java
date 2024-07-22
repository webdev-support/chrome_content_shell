package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.network.mojom.ReferrerPolicy;

public final class FrameState extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 144;
  private static final DataHeader[] VERSION_ARRAY;
  public FrameState[] children;
  public long documentSequenceNumber;
  public String16[] documentState;
  public HttpBody httpBody;
  public String16 initiatorBaseUrlString;
  public String initiatorOrigin;
  public long itemSequenceNumber;
  public String16 navigationApiId;
  public String16 navigationApiKey;
  public String16 navigationApiState;
  public boolean protectUrlInNavigationApi;
  public String16 referrer;
  public int referrerPolicy;
  public int scrollRestorationType;
  public String16 stateObject;
  public String16 target;
  public String16 urlString;
  public ViewState viewState;

  static {
    DataHeader[] dataHeaderArr = {
      new DataHeader(96, 0),
      new DataHeader(104, 2),
      new DataHeader(120, 3),
      new DataHeader(128, 4),
      new DataHeader(136, 5),
      new DataHeader(144, 6)
    };
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[5];
  }

  private FrameState(int version) {
    super(144, version);
  }

  public FrameState() {
    this(6);
  }

  public static FrameState deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static FrameState deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static FrameState decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      FrameState result = new FrameState(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      result.urlString = String16.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, true);
      result.referrer = String16.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, true);
      result.target = String16.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(32, true);
      result.stateObject = String16.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(40, false);
      DataHeader si1 = decoder15.readDataHeaderForPointerArray(-1);
      result.documentState = new String16[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder15.readPointer((i1 * 8) + 8, true);
        result.documentState[i1] = String16.decode(decoder2);
      }
      int readInt = decoder0.readInt(48);
      result.scrollRestorationType = readInt;
      ScrollRestorationType.validate(readInt);
      result.scrollRestorationType =
          ScrollRestorationType.toKnownValue(result.scrollRestorationType);
      int readInt2 = decoder0.readInt(52);
      result.referrerPolicy = readInt2;
      ReferrerPolicy.validate(readInt2);
      result.referrerPolicy = ReferrerPolicy.toKnownValue(result.referrerPolicy);
      Decoder decoder16 = decoder0.readPointer(56, true);
      result.viewState = ViewState.decode(decoder16);
      result.itemSequenceNumber = decoder0.readLong(64);
      result.documentSequenceNumber = decoder0.readLong(72);
      Decoder decoder17 = decoder0.readPointer(80, false);
      result.httpBody = HttpBody.decode(decoder17);
      Decoder decoder18 = decoder0.readPointer(88, false);
      DataHeader si12 = decoder18.readDataHeaderForPointerArray(-1);
      result.children = new FrameState[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder18.readPointer((i12 * 8) + 8, false);
        result.children[i12] = decode(decoder22);
      }
      if (elementsOrVersion >= 2) {
        result.initiatorOrigin = decoder0.readString(96, true);
      }
      if (elementsOrVersion >= 3) {
        Decoder decoder19 = decoder0.readPointer(104, true);
        result.navigationApiKey = String16.decode(decoder19);
        Decoder decoder110 = decoder0.readPointer(112, true);
        result.navigationApiId = String16.decode(decoder110);
      }
      if (elementsOrVersion >= 4) {
        Decoder decoder111 = decoder0.readPointer(120, true);
        result.navigationApiState = String16.decode(decoder111);
      }
      if (elementsOrVersion >= 5) {
        result.protectUrlInNavigationApi = decoder0.readBoolean(128, 0);
      }
      if (elementsOrVersion >= 6) {
        Decoder decoder112 = decoder0.readPointer(136, true);
        result.initiatorBaseUrlString = String16.decode(decoder112);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.urlString, 8, true);
    encoder0.encode((Struct) this.referrer, 16, true);
    encoder0.encode((Struct) this.target, 24, true);
    encoder0.encode((Struct) this.stateObject, 32, true);
    String16[] string16Arr = this.documentState;
    if (string16Arr == null) {
      encoder0.encodeNullPointer(40, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(string16Arr.length, 40, -1);
      int i0 = 0;
      while (true) {
        String16[] string16Arr2 = this.documentState;
        if (i0 >= string16Arr2.length) {
          break;
        }
        encoder1.encode((Struct) string16Arr2[i0], (i0 * 8) + 8, true);
        i0++;
      }
    }
    encoder0.encode(this.scrollRestorationType, 48);
    encoder0.encode(this.referrerPolicy, 52);
    encoder0.encode((Struct) this.viewState, 56, true);
    encoder0.encode(this.itemSequenceNumber, 64);
    encoder0.encode(this.documentSequenceNumber, 72);
    encoder0.encode((Struct) this.httpBody, 80, false);
    FrameState[] frameStateArr = this.children;
    if (frameStateArr == null) {
      encoder0.encodeNullPointer(88, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(frameStateArr.length, 88, -1);
      int i02 = 0;
      while (true) {
        FrameState[] frameStateArr2 = this.children;
        if (i02 >= frameStateArr2.length) {
          break;
        }
        encoder12.encode((Struct) frameStateArr2[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    encoder0.encode(this.initiatorOrigin, 96, true);
    encoder0.encode((Struct) this.navigationApiKey, 104, true);
    encoder0.encode((Struct) this.navigationApiId, 112, true);
    encoder0.encode((Struct) this.navigationApiState, 120, true);
    encoder0.encode(this.protectUrlInNavigationApi, 128, 0);
    encoder0.encode((Struct) this.initiatorBaseUrlString, 136, true);
  }
}
