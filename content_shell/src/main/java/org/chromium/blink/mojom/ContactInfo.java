package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.payments.mojom.PaymentAddress;

public final class ContactInfo extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 48;
  private static final DataHeader[] VERSION_ARRAY;
  public PaymentAddress[] address;
  public String[] email;
  public ContactIconBlob[] icon;
  public String[] name;
  public String[] tel;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(48, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private ContactInfo(int version) {
    super(48, version);
  }

  public ContactInfo() {
    this(0);
  }

  public static ContactInfo deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static ContactInfo deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static ContactInfo decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      ContactInfo result = new ContactInfo(elementsOrVersion);
      Decoder decoder1 = decoder0.readPointer(8, true);
      if (decoder1 == null) {
        result.name = null;
      } else {
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.name = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.name[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
      }
      Decoder decoder12 = decoder0.readPointer(16, true);
      if (decoder12 == null) {
        result.email = null;
      } else {
        DataHeader si12 = decoder12.readDataHeaderForPointerArray(-1);
        result.email = new String[si12.elementsOrVersion];
        for (int i12 = 0; i12 < si12.elementsOrVersion; i12++) {
          result.email[i12] = decoder12.readString((i12 * 8) + 8, false);
        }
      }
      Decoder decoder13 = decoder0.readPointer(24, true);
      if (decoder13 == null) {
        result.tel = null;
      } else {
        DataHeader si13 = decoder13.readDataHeaderForPointerArray(-1);
        result.tel = new String[si13.elementsOrVersion];
        for (int i13 = 0; i13 < si13.elementsOrVersion; i13++) {
          result.tel[i13] = decoder13.readString((i13 * 8) + 8, false);
        }
      }
      Decoder decoder14 = decoder0.readPointer(32, true);
      if (decoder14 == null) {
        result.address = null;
      } else {
        DataHeader si14 = decoder14.readDataHeaderForPointerArray(-1);
        result.address = new PaymentAddress[si14.elementsOrVersion];
        for (int i14 = 0; i14 < si14.elementsOrVersion; i14++) {
          Decoder decoder2 = decoder14.readPointer((i14 * 8) + 8, false);
          result.address[i14] = PaymentAddress.decode(decoder2);
        }
      }
      Decoder decoder15 = decoder0.readPointer(40, true);
      if (decoder15 == null) {
        result.icon = null;
      } else {
        DataHeader si15 = decoder15.readDataHeaderForPointerArray(-1);
        result.icon = new ContactIconBlob[si15.elementsOrVersion];
        for (int i15 = 0; i15 < si15.elementsOrVersion; i15++) {
          Decoder decoder22 = decoder15.readPointer((i15 * 8) + 8, false);
          result.icon[i15] = ContactIconBlob.decode(decoder22);
        }
      }
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    String[] strArr = this.name;
    if (strArr == null) {
      encoder0.encodeNullPointer(8, true);
    } else {
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.name;
        if (i0 >= strArr2.length) {
          break;
        }
        encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
        i0++;
      }
    }
    String[] strArr3 = this.email;
    if (strArr3 == null) {
      encoder0.encodeNullPointer(16, true);
    } else {
      Encoder encoder12 = encoder0.encodePointerArray(strArr3.length, 16, -1);
      int i02 = 0;
      while (true) {
        String[] strArr4 = this.email;
        if (i02 >= strArr4.length) {
          break;
        }
        encoder12.encode(strArr4[i02], (i02 * 8) + 8, false);
        i02++;
      }
    }
    String[] strArr5 = this.tel;
    if (strArr5 == null) {
      encoder0.encodeNullPointer(24, true);
    } else {
      Encoder encoder13 = encoder0.encodePointerArray(strArr5.length, 24, -1);
      int i03 = 0;
      while (true) {
        String[] strArr6 = this.tel;
        if (i03 >= strArr6.length) {
          break;
        }
        encoder13.encode(strArr6[i03], (i03 * 8) + 8, false);
        i03++;
      }
    }
    PaymentAddress[] paymentAddressArr = this.address;
    if (paymentAddressArr == null) {
      encoder0.encodeNullPointer(32, true);
    } else {
      Encoder encoder14 = encoder0.encodePointerArray(paymentAddressArr.length, 32, -1);
      int i04 = 0;
      while (true) {
        PaymentAddress[] paymentAddressArr2 = this.address;
        if (i04 >= paymentAddressArr2.length) {
          break;
        }
        encoder14.encode((Struct) paymentAddressArr2[i04], (i04 * 8) + 8, false);
        i04++;
      }
    }
    ContactIconBlob[] contactIconBlobArr = this.icon;
    if (contactIconBlobArr == null) {
      encoder0.encodeNullPointer(40, true);
      return;
    }
    Encoder encoder15 = encoder0.encodePointerArray(contactIconBlobArr.length, 40, -1);
    int i05 = 0;
    while (true) {
      ContactIconBlob[] contactIconBlobArr2 = this.icon;
      if (i05 < contactIconBlobArr2.length) {
        encoder15.encode((Struct) contactIconBlobArr2[i05], (i05 * 8) + 8, false);
        i05++;
      } else {
        return;
      }
    }
  }
}
