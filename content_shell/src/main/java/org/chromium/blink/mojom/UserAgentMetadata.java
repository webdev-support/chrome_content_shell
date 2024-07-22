package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class UserAgentMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 88;
  private static final DataHeader[] VERSION_ARRAY;
  public String architecture;
  public String bitness;
  public UserAgentBrandVersion[] brandFullVersionList;
  public UserAgentBrandVersion[] brandVersionList;
  public String[] formFactor;
  public String fullVersion;
  public boolean mobile;
  public String model;
  public String platform;
  public String platformVersion;
  public boolean wow64;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(88, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private UserAgentMetadata(int version) {
    super(88, version);
  }

  public UserAgentMetadata() {
    this(0);
  }

  public static UserAgentMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static UserAgentMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static UserAgentMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      UserAgentMetadata result = new UserAgentMetadata(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
      result.brandVersionList = new UserAgentBrandVersion[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
        result.brandVersionList[i1] = UserAgentBrandVersion.decode(decoder2);
      }
      Decoder decoder12 = decoder0.readPointer(16, false);
      DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
      result.brandFullVersionList = new UserAgentBrandVersion[si12.elementsOrVersion];
      for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
        Decoder decoder22 = decoder12.readPointer((i12 * 8) + 8, false);
        result.brandFullVersionList[i12] = UserAgentBrandVersion.decode(decoder22);
      }
      result.fullVersion = decoder0.readString(24, false);
      result.platform = decoder0.readString(32, false);
      result.platformVersion = decoder0.readString(40, false);
      result.architecture = decoder0.readString(48, false);
      result.model = decoder0.readString(56, false);
      result.mobile = decoder0.readBoolean(64, 0);
      result.wow64 = decoder0.readBoolean(64, 1);
      result.bitness = decoder0.readString(72, false);
      Decoder decoder13 = decoder0.readPointer(80, false);
      DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
      result.formFactor = new String[si13.elementsOrVersion];
      for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
        result.formFactor[i13] = decoder13.readString((i13 * 8) + 8, false);
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    UserAgentBrandVersion[] userAgentBrandVersionArr = this.brandVersionList;
    if (userAgentBrandVersionArr == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(userAgentBrandVersionArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        UserAgentBrandVersion[] userAgentBrandVersionArr2 = this.brandVersionList;
        if (i0 >= userAgentBrandVersionArr2.length) {
          break;
        }
        encoder1.encode((Struct) userAgentBrandVersionArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    UserAgentBrandVersion[] userAgentBrandVersionArr3 = this.brandFullVersionList;
    if (userAgentBrandVersionArr3 == null) {
      encoder0.encodeNullPointer(16, false);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(userAgentBrandVersionArr3.length, 16, -1);
      int i02 = 0;
      while (true) {
        UserAgentBrandVersion[] userAgentBrandVersionArr4 = this.brandFullVersionList;
        if (i02 >= userAgentBrandVersionArr4.length) {
          break;
        }
        encoder12.encode((Struct) userAgentBrandVersionArr4[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    encoder0.encode(this.fullVersion, 24, false);
    encoder0.encode(this.platform, 32, false);
    encoder0.encode(this.platformVersion, 40, false);
    encoder0.encode(this.architecture, 48, false);
    encoder0.encode(this.model, 56, false);
    encoder0.encode(this.mobile, 64, 0);
    encoder0.encode(this.wow64, 64, 1);
    encoder0.encode(this.bitness, 72, false);
    String[] strArr = this.formFactor;
    if (strArr == null) {
      encoder0.encodeNullPointer(80, false);
      return;
    }
    Encoder encoder13 = encoder0.encodePointerArray(strArr.length, 80, -1);
    int i03 = 0;
    while (true) {
      String[] strArr2 = this.formFactor;
      if (i03 < strArr2.length) {
        encoder13.encode(strArr2[i03], (i03 * 8) + 8, false);
        i03++;
      } else {
        return;
      }
    }
  }
}
