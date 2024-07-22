package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.network.mojom.ContentSecurityPolicy;
import org.chromium.url.mojom.Url;

public final class SharedWorkerInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public ContentSecurityPolicy[] contentSecurityPolicies;
  public WorkerOptions options;
  public FetchClientSettingsObject outsideFetchClientSettingsObject;
  public int sameSiteCookies;
  public Url url;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private SharedWorkerInfo(int version) {
    super(48, version);
    this.sameSiteCookies = 1;
  }

  public SharedWorkerInfo() {
    this(0);
  }

  public static SharedWorkerInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static SharedWorkerInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static SharedWorkerInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      SharedWorkerInfo result = new SharedWorkerInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, false);
      result.url = Url.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(16, false);
      result.options = WorkerOptions.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(24, false);
      DataHeader si1 = decoder13.readDataHeaderForPointerArray(-1);
      result.contentSecurityPolicies = new ContentSecurityPolicy[si1.elementsOrVersion];
      for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
        Decoder decoder2 = decoder13.readPointer((i1 * 8) + 8, false);
        result.contentSecurityPolicies[i1] = ContentSecurityPolicy.decode(decoder2);
      }
      Decoder decoder14 = decoder0.readPointer(32, false);
      result.outsideFetchClientSettingsObject = FetchClientSettingsObject.decode(decoder14);
      int readInt = decoder0.readInt(40);
      result.sameSiteCookies = readInt;
      SharedWorkerSameSiteCookies.validate(readInt);
      result.sameSiteCookies = SharedWorkerSameSiteCookies.toKnownValue(result.sameSiteCookies);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Struct) this.url, 8, false);
    encoder0.encode((Struct) this.options, 16, false);
    ContentSecurityPolicy[] contentSecurityPolicyArr = this.contentSecurityPolicies;
    if (contentSecurityPolicyArr == null) {
      encoder0.encodeNullPointer(24, false);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(contentSecurityPolicyArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        ContentSecurityPolicy[] contentSecurityPolicyArr2 = this.contentSecurityPolicies;
        if (i0 >= contentSecurityPolicyArr2.length) {
          break;
        }
        encoder1.encode((Struct) contentSecurityPolicyArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    encoder0.encode((Struct) this.outsideFetchClientSettingsObject, 32, false);
    encoder0.encode(this.sameSiteCookies, 40);
  }
}
