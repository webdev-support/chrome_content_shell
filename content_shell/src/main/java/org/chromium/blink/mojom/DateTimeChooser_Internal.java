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

class DateTimeChooser_Internal {
  private static final int CLOSE_DATE_TIME_DIALOG_ORDINAL = 1;
  public static final Interface.Manager<DateTimeChooser, DateTimeChooser.Proxy> MANAGER =
      new Interface.Manager<DateTimeChooser, DateTimeChooser.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.DateTimeChooser";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public DateTimeChooser.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, DateTimeChooser impl) {
          return new Stub(core, impl);
        }

        @Override
        public DateTimeChooser[] buildArray(int size) {
          return new DateTimeChooser[size];
        }
      };
  private static final int OPEN_DATE_TIME_DIALOG_ORDINAL = 0;

  DateTimeChooser_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements DateTimeChooser.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void openDateTimeDialog(
        DateTimeDialogValue value, OpenDateTimeDialog_Response callback) {
      DateTimeChooserOpenDateTimeDialogParams _message =
          new DateTimeChooserOpenDateTimeDialogParams();
      _message.value = value;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new DateTimeChooserOpenDateTimeDialogResponseParamsForwardToCallback(callback));
    }

    @Override
    public void closeDateTimeDialog() {
      DateTimeChooserCloseDateTimeDialogParams _message =
          new DateTimeChooserCloseDateTimeDialogParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(1)));
    }
  }

  public static final class Stub extends Interface.Stub<DateTimeChooser> {
    Stub(Core core, DateTimeChooser impl) {
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
                DateTimeChooser_Internal.MANAGER, messageWithHeader);
          case 1:
            DateTimeChooserCloseDateTimeDialogParams.deserialize(messageWithHeader.getPayload());
            getImpl().closeDateTimeDialog();
            return true;
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
                getCore(), DateTimeChooser_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            DateTimeChooserOpenDateTimeDialogParams data =
                DateTimeChooserOpenDateTimeDialogParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .openDateTimeDialog(
                    data.value,
                    new DateTimeChooserOpenDateTimeDialogResponseParamsProxyToResponder(
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

  static final class DateTimeChooserOpenDateTimeDialogParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public DateTimeDialogValue value;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DateTimeChooserOpenDateTimeDialogParams(int version) {
      super(16, version);
    }

    public DateTimeChooserOpenDateTimeDialogParams() {
      this(0);
    }

    public static DateTimeChooserOpenDateTimeDialogParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DateTimeChooserOpenDateTimeDialogParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DateTimeChooserOpenDateTimeDialogParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DateTimeChooserOpenDateTimeDialogParams result =
            new DateTimeChooserOpenDateTimeDialogParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.value = DateTimeDialogValue.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.value, 8, false);
    }
  }

  static final class DateTimeChooserOpenDateTimeDialogResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public double dialogValue;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DateTimeChooserOpenDateTimeDialogResponseParams(int version) {
      super(24, version);
    }

    public DateTimeChooserOpenDateTimeDialogResponseParams() {
      this(0);
    }

    public static DateTimeChooserOpenDateTimeDialogResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DateTimeChooserOpenDateTimeDialogResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DateTimeChooserOpenDateTimeDialogResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DateTimeChooserOpenDateTimeDialogResponseParams result =
            new DateTimeChooserOpenDateTimeDialogResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        result.dialogValue = decoder0.readDouble(16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
      encoder0.encode(this.dialogValue, 16);
    }
  }

  static class DateTimeChooserOpenDateTimeDialogResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final DateTimeChooser.OpenDateTimeDialog_Response mCallback;

    DateTimeChooserOpenDateTimeDialogResponseParamsForwardToCallback(
        DateTimeChooser.OpenDateTimeDialog_Response callback) {
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
        DateTimeChooserOpenDateTimeDialogResponseParams response =
            DateTimeChooserOpenDateTimeDialogResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success, response.dialogValue);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class DateTimeChooserOpenDateTimeDialogResponseParamsProxyToResponder
      implements DateTimeChooser.OpenDateTimeDialog_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    DateTimeChooserOpenDateTimeDialogResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success, double dialogValue) {
      DateTimeChooserOpenDateTimeDialogResponseParams _response =
          new DateTimeChooserOpenDateTimeDialogResponseParams();
      _response.success = success;
      _response.dialogValue = dialogValue;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class DateTimeChooserCloseDateTimeDialogParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private DateTimeChooserCloseDateTimeDialogParams(int version) {
      super(8, version);
    }

    public DateTimeChooserCloseDateTimeDialogParams() {
      this(0);
    }

    public static DateTimeChooserCloseDateTimeDialogParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static DateTimeChooserCloseDateTimeDialogParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static DateTimeChooserCloseDateTimeDialogParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        DateTimeChooserCloseDateTimeDialogParams result =
            new DateTimeChooserCloseDateTimeDialogParams(elementsOrVersion);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    }
  }
}
