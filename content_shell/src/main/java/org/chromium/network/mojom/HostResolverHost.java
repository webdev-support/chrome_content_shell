package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.url.mojom.SchemeHostPort;

public final class HostResolverHost extends Union {

  private HostPortPair mHostPortPair;
  private SchemeHostPort mSchemeHostPort;

  public static final class Tag {
    public static final int HostPortPair = 1;
    public static final int SchemeHostPort = 0;
  }

  public void setSchemeHostPort(SchemeHostPort schemeHostPort) {
    this.mTag = 0;
    this.mSchemeHostPort = schemeHostPort;
  }

  public SchemeHostPort getSchemeHostPort() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mSchemeHostPort;
  }

  public void setHostPortPair(HostPortPair hostPortPair) {
    this.mTag = 1;
    this.mHostPortPair = hostPortPair;
  }

  public HostPortPair getHostPortPair() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mHostPortPair;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode((Struct) this.mSchemeHostPort, offset + 8, false);
        return;
      case 1:
        encoder0.encode((Struct) this.mHostPortPair, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static HostResolverHost deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final HostResolverHost decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    HostResolverHost result = new HostResolverHost();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mSchemeHostPort = SchemeHostPort.decode(decoder1);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder12 = decoder0.readPointer(offset + 8, false);
        result.mHostPortPair = HostPortPair.decode(decoder12);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
