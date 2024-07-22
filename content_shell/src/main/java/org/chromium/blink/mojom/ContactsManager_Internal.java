package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.SideEffectFreeCloseable;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class ContactsManager_Internal {
  public static final Interface.Manager<ContactsManager, ContactsManager.Proxy> MANAGER =
      new Interface.Manager<ContactsManager, ContactsManager.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.ContactsManager";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ContactsManager.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ContactsManager impl) {
          return new Stub(core, impl);
        }

        @Override
        public ContactsManager[] buildArray(int size) {
          return new ContactsManager[size];
        }
      };
  private static final int SELECT_ORDINAL = 0;

  ContactsManager_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements ContactsManager.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void select(
        boolean multiple,
        boolean includeNames,
        boolean includeEmails,
        boolean includeTel,
        boolean includeAddresses,
        boolean includeIcons,
        Select_Response callback) {
      ContactsManagerSelectParams _message = new ContactsManagerSelectParams();
      _message.multiple = multiple;
      _message.includeNames = includeNames;
      _message.includeEmails = includeEmails;
      _message.includeTel = includeTel;
      _message.includeAddresses = includeAddresses;
      _message.includeIcons = includeIcons;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ContactsManagerSelectResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<ContactsManager> {
    Stub(Core core, ContactsManager impl) {
      super(core, impl);
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        int flags = 0;
        if (header.hasFlag(4)) {
          flags = 0 | 4;
        }
        if (!header.validateHeader(flags)) {
          return false;
        }
        switch (header.getType()) {
          case -2:
            return InterfaceControlMessagesHelper.handleRunOrClosePipe(
                ContactsManager_Internal.MANAGER, messageWithHeader);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }

    @Override
    public boolean acceptWithResponder(Message message, MessageReceiver receiver) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        int flags = 1;
        if (header.hasFlag(4)) {
          flags = 1 | 4;
        }
        if (!header.validateHeader(flags)) {
          return false;
        }
        switch (header.getType()) {
          case -1:
            return InterfaceControlMessagesHelper.handleRun(
                getCore(), ContactsManager_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            ContactsManagerSelectParams data =
                ContactsManagerSelectParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .select(
                    data.multiple,
                    data.includeNames,
                    data.includeEmails,
                    data.includeTel,
                    data.includeAddresses,
                    data.includeIcons,
                    new ContactsManagerSelectResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ContactsManagerSelectParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean includeAddresses;
    public boolean includeEmails;
    public boolean includeIcons;
    public boolean includeNames;
    public boolean includeTel;
    public boolean multiple;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContactsManagerSelectParams(int version) {
      super(16, version);
    }

    public ContactsManagerSelectParams() {
      this(0);
    }

    public static ContactsManagerSelectParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContactsManagerSelectParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContactsManagerSelectParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContactsManagerSelectParams result = new ContactsManagerSelectParams(elementsOrVersion);
        result.multiple = decoder0.readBoolean(8, 0);
        result.includeNames = decoder0.readBoolean(8, 1);
        result.includeEmails = decoder0.readBoolean(8, 2);
        result.includeTel = decoder0.readBoolean(8, 3);
        result.includeAddresses = decoder0.readBoolean(8, 4);
        result.includeIcons = decoder0.readBoolean(8, 5);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.multiple, 8, 0);
      encoder0.encode(this.includeNames, 8, 1);
      encoder0.encode(this.includeEmails, 8, 2);
      encoder0.encode(this.includeTel, 8, 3);
      encoder0.encode(this.includeAddresses, 8, 4);
      encoder0.encode(this.includeIcons, 8, 5);
    }
  }

  static final class ContactsManagerSelectResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ContactInfo[] contacts;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ContactsManagerSelectResponseParams(int version) {
      super(16, version);
    }

    public ContactsManagerSelectResponseParams() {
      this(0);
    }

    public static ContactsManagerSelectResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ContactsManagerSelectResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ContactsManagerSelectResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ContactsManagerSelectResponseParams result =
            new ContactsManagerSelectResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, true);
        if (decoder1 == null) {
          result.contacts = null;
        } else {
          DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
          result.contacts = new ContactInfo[si1.elementsOrVersion];
          for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
            Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
            result.contacts[i1] = ContactInfo.decode(decoder2);
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
      ContactInfo[] contactInfoArr = this.contacts;
      if (contactInfoArr == null) {
        encoder0.encodeNullPointer(8, true);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(contactInfoArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        ContactInfo[] contactInfoArr2 = this.contacts;
        if (i0 < contactInfoArr2.length) {
          encoder1.encode((Struct) contactInfoArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class ContactsManagerSelectResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final ContactsManager.Select_Response mCallback;

    ContactsManagerSelectResponseParamsForwardToCallback(ContactsManager.Select_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 2)) {
          return false;
        }
        ContactsManagerSelectResponseParams response =
            ContactsManagerSelectResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.contacts);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ContactsManagerSelectResponseParamsProxyToResponder
      implements ContactsManager.Select_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ContactsManagerSelectResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ContactInfo[] contacts) {
      ContactsManagerSelectResponseParams _response = new ContactsManagerSelectResponseParams();
      _response.contacts = contacts;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
