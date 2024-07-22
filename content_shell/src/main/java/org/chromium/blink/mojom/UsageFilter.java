package org.chromium.blink.mojom;

import org.chromium.device.mojom.HidUsageAndPage;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;

public final class UsageFilter extends Union {

  private short mPage;
  private HidUsageAndPage mUsageAndPage;

  public static final class Tag {
    public static final int Page = 0;
    public static final int UsageAndPage = 1;
  }

  public void setPage(short page) {
    this.mTag = 0;
    this.mPage = page;
  }

  public short getPage() {
    if (this.mTag != 0) {
      throw new AssertionError();
    }
    return this.mPage;
  }

  public void setUsageAndPage(HidUsageAndPage usageAndPage) {
    this.mTag = 1;
    this.mUsageAndPage = usageAndPage;
  }

  public HidUsageAndPage getUsageAndPage() {
    if (this.mTag != 1) {
      throw new AssertionError();
    }
    return this.mUsageAndPage;
  }

  @Override
  public final void encode(Encoder encoder0, int offset) {
    encoder0.encode(16, offset);
    encoder0.encode(this.mTag, offset + 4);
    switch (this.mTag) {
      case 0:
        encoder0.encode(this.mPage, offset + 8);
        return;
      case 1:
        encoder0.encode((Struct) this.mUsageAndPage, offset + 8, false);
        return;
      default:
        return;
    }
  }

  public static UsageFilter deserialize(Message message) {
    return decode(new Decoder(message).decoderForSerializedUnion(), 0);
  }

  public static final UsageFilter decode(Decoder decoder0, int offset) {
    DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
    if (dataHeader.size == 0) {
      return null;
    }
    UsageFilter result = new UsageFilter();
    switch (dataHeader.elementsOrVersion) {
      case 0:
        result.mPage = decoder0.readShort(offset + 8);
        result.mTag = 0;
        break;
      case 1:
        Decoder decoder1 = decoder0.readPointer(offset + 8, false);
        result.mUsageAndPage = HidUsageAndPage.decode(decoder1);
        result.mTag = 1;
        break;
    }
    return result;
  }
}
