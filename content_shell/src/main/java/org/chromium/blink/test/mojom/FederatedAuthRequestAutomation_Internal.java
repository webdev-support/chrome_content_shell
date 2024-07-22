package org.chromium.blink.test.mojom;

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

class FederatedAuthRequestAutomation_Internal {
  private static final int CLICK_FED_CM_DIALOG_BUTTON_ORDINAL = 4;
  private static final int DISMISS_FED_CM_DIALOG_ORDINAL = 3;
  private static final int GET_DIALOG_TYPE_ORDINAL = 0;
  private static final int GET_FED_CM_DIALOG_TITLE_ORDINAL = 1;
  public static final Interface.Manager<
          FederatedAuthRequestAutomation, FederatedAuthRequestAutomation.Proxy>
      MANAGER =
          new Interface.Manager<
              FederatedAuthRequestAutomation, FederatedAuthRequestAutomation.Proxy>() {
            @Override
            public String getName() {
              return "blink.test.mojom.FederatedAuthRequestAutomation";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public FederatedAuthRequestAutomation.Proxy buildProxy(
                Core core, MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(Core core, FederatedAuthRequestAutomation impl) {
              return new Stub(core, impl);
            }

            @Override
            public FederatedAuthRequestAutomation[] buildArray(int size) {
              return new FederatedAuthRequestAutomation[size];
            }
          };
  private static final int SELECT_FED_CM_ACCOUNT_ORDINAL = 2;

  FederatedAuthRequestAutomation_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements FederatedAuthRequestAutomation.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getDialogType(GetDialogType_Response callback) {
      FederatedAuthRequestAutomationGetDialogTypeParams _message =
          new FederatedAuthRequestAutomationGetDialogTypeParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new FederatedAuthRequestAutomationGetDialogTypeResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void getFedCmDialogTitle(GetFedCmDialogTitle_Response callback) {
      FederatedAuthRequestAutomationGetFedCmDialogTitleParams _message =
          new FederatedAuthRequestAutomationGetFedCmDialogTitleParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void selectFedCmAccount(int accountIndex, SelectFedCmAccount_Response callback) {
      FederatedAuthRequestAutomationSelectFedCmAccountParams _message =
          new FederatedAuthRequestAutomationSelectFedCmAccountParams();
      _message.accountIndex = accountIndex;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new FederatedAuthRequestAutomationSelectFedCmAccountResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void dismissFedCmDialog(DismissFedCmDialog_Response callback) {
      FederatedAuthRequestAutomationDismissFedCmDialogParams _message =
          new FederatedAuthRequestAutomationDismissFedCmDialogParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new FederatedAuthRequestAutomationDismissFedCmDialogResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void clickFedCmDialogButton(int dialogButton, ClickFedCmDialogButton_Response callback) {
      FederatedAuthRequestAutomationClickFedCmDialogButtonParams _message =
          new FederatedAuthRequestAutomationClickFedCmDialogButtonParams();
      _message.dialogButton = dialogButton;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParamsForwardToCallback(
                  callback));
    }
  }

  public static final class Stub extends Interface.Stub<FederatedAuthRequestAutomation> {
    Stub(Core core, FederatedAuthRequestAutomation impl) {
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
                FederatedAuthRequestAutomation_Internal.MANAGER, messageWithHeader);
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
                getCore(),
                FederatedAuthRequestAutomation_Internal.MANAGER,
                messageWithHeader,
                receiver);
          case 0:
            FederatedAuthRequestAutomationGetDialogTypeParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getDialogType(
                    new FederatedAuthRequestAutomationGetDialogTypeResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            FederatedAuthRequestAutomationGetFedCmDialogTitleParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .getFedCmDialogTitle(
                    new FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            FederatedAuthRequestAutomationSelectFedCmAccountParams data =
                FederatedAuthRequestAutomationSelectFedCmAccountParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .selectFedCmAccount(
                    data.accountIndex,
                    new FederatedAuthRequestAutomationSelectFedCmAccountResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            FederatedAuthRequestAutomationDismissFedCmDialogParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .dismissFedCmDialog(
                    new FederatedAuthRequestAutomationDismissFedCmDialogResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            FederatedAuthRequestAutomationClickFedCmDialogButtonParams data2 =
                FederatedAuthRequestAutomationClickFedCmDialogButtonParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .clickFedCmDialogButton(
                    data2.dialogButton,
                    new FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParamsProxyToResponder(
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

  static final class FederatedAuthRequestAutomationGetDialogTypeParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestAutomationGetDialogTypeParams(int version) {
      super(8, version);
    }

    public FederatedAuthRequestAutomationGetDialogTypeParams() {
      this(0);
    }

    public static FederatedAuthRequestAutomationGetDialogTypeParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestAutomationGetDialogTypeParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestAutomationGetDialogTypeParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestAutomationGetDialogTypeParams result =
            new FederatedAuthRequestAutomationGetDialogTypeParams(elementsOrVersion);
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

  static final class FederatedAuthRequestAutomationGetDialogTypeResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String title;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestAutomationGetDialogTypeResponseParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestAutomationGetDialogTypeResponseParams() {
      this(0);
    }

    public static FederatedAuthRequestAutomationGetDialogTypeResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestAutomationGetDialogTypeResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestAutomationGetDialogTypeResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestAutomationGetDialogTypeResponseParams result =
            new FederatedAuthRequestAutomationGetDialogTypeResponseParams(elementsOrVersion);
        result.title = decoder0.readString(8, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.title, 8, true);
    }
  }

  static class FederatedAuthRequestAutomationGetDialogTypeResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FederatedAuthRequestAutomation.GetDialogType_Response mCallback;

    FederatedAuthRequestAutomationGetDialogTypeResponseParamsForwardToCallback(
        FederatedAuthRequestAutomation.GetDialogType_Response callback) {
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
        FederatedAuthRequestAutomationGetDialogTypeResponseParams response =
            FederatedAuthRequestAutomationGetDialogTypeResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.title);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FederatedAuthRequestAutomationGetDialogTypeResponseParamsProxyToResponder
      implements FederatedAuthRequestAutomation.GetDialogType_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FederatedAuthRequestAutomationGetDialogTypeResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String title) {
      FederatedAuthRequestAutomationGetDialogTypeResponseParams _response =
          new FederatedAuthRequestAutomationGetDialogTypeResponseParams();
      _response.title = title;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FederatedAuthRequestAutomationGetFedCmDialogTitleParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestAutomationGetFedCmDialogTitleParams(int version) {
      super(8, version);
    }

    public FederatedAuthRequestAutomationGetFedCmDialogTitleParams() {
      this(0);
    }

    public static FederatedAuthRequestAutomationGetFedCmDialogTitleParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestAutomationGetFedCmDialogTitleParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestAutomationGetFedCmDialogTitleParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestAutomationGetFedCmDialogTitleParams result =
            new FederatedAuthRequestAutomationGetFedCmDialogTitleParams(elementsOrVersion);
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

  static final class FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String title;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParams() {
      this(0);
    }

    public static FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParams result =
            new FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParams(elementsOrVersion);
        result.title = decoder0.readString(8, true);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.title, 8, true);
    }
  }

  static class FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FederatedAuthRequestAutomation.GetFedCmDialogTitle_Response mCallback;

    FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParamsForwardToCallback(
        FederatedAuthRequestAutomation.GetFedCmDialogTitle_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 2)) {
          return false;
        }
        FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParams response =
            FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.title);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParamsProxyToResponder
      implements FederatedAuthRequestAutomation.GetFedCmDialogTitle_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String title) {
      FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParams _response =
          new FederatedAuthRequestAutomationGetFedCmDialogTitleResponseParams();
      _response.title = title;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FederatedAuthRequestAutomationSelectFedCmAccountParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int accountIndex;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestAutomationSelectFedCmAccountParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestAutomationSelectFedCmAccountParams() {
      this(0);
    }

    public static FederatedAuthRequestAutomationSelectFedCmAccountParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestAutomationSelectFedCmAccountParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestAutomationSelectFedCmAccountParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestAutomationSelectFedCmAccountParams result =
            new FederatedAuthRequestAutomationSelectFedCmAccountParams(elementsOrVersion);
        result.accountIndex = decoder0.readInt(8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.accountIndex, 8);
    }
  }

  static final class FederatedAuthRequestAutomationSelectFedCmAccountResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestAutomationSelectFedCmAccountResponseParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestAutomationSelectFedCmAccountResponseParams() {
      this(0);
    }

    public static FederatedAuthRequestAutomationSelectFedCmAccountResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestAutomationSelectFedCmAccountResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestAutomationSelectFedCmAccountResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestAutomationSelectFedCmAccountResponseParams result =
            new FederatedAuthRequestAutomationSelectFedCmAccountResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class FederatedAuthRequestAutomationSelectFedCmAccountResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FederatedAuthRequestAutomation.SelectFedCmAccount_Response mCallback;

    FederatedAuthRequestAutomationSelectFedCmAccountResponseParamsForwardToCallback(
        FederatedAuthRequestAutomation.SelectFedCmAccount_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 2)) {
          return false;
        }
        FederatedAuthRequestAutomationSelectFedCmAccountResponseParams response =
            FederatedAuthRequestAutomationSelectFedCmAccountResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FederatedAuthRequestAutomationSelectFedCmAccountResponseParamsProxyToResponder
      implements FederatedAuthRequestAutomation.SelectFedCmAccount_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FederatedAuthRequestAutomationSelectFedCmAccountResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      FederatedAuthRequestAutomationSelectFedCmAccountResponseParams _response =
          new FederatedAuthRequestAutomationSelectFedCmAccountResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FederatedAuthRequestAutomationDismissFedCmDialogParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestAutomationDismissFedCmDialogParams(int version) {
      super(8, version);
    }

    public FederatedAuthRequestAutomationDismissFedCmDialogParams() {
      this(0);
    }

    public static FederatedAuthRequestAutomationDismissFedCmDialogParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestAutomationDismissFedCmDialogParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestAutomationDismissFedCmDialogParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestAutomationDismissFedCmDialogParams result =
            new FederatedAuthRequestAutomationDismissFedCmDialogParams(elementsOrVersion);
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

  static final class FederatedAuthRequestAutomationDismissFedCmDialogResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestAutomationDismissFedCmDialogResponseParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestAutomationDismissFedCmDialogResponseParams() {
      this(0);
    }

    public static FederatedAuthRequestAutomationDismissFedCmDialogResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestAutomationDismissFedCmDialogResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestAutomationDismissFedCmDialogResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestAutomationDismissFedCmDialogResponseParams result =
            new FederatedAuthRequestAutomationDismissFedCmDialogResponseParams(elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class FederatedAuthRequestAutomationDismissFedCmDialogResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FederatedAuthRequestAutomation.DismissFedCmDialog_Response mCallback;

    FederatedAuthRequestAutomationDismissFedCmDialogResponseParamsForwardToCallback(
        FederatedAuthRequestAutomation.DismissFedCmDialog_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 2)) {
          return false;
        }
        FederatedAuthRequestAutomationDismissFedCmDialogResponseParams response =
            FederatedAuthRequestAutomationDismissFedCmDialogResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FederatedAuthRequestAutomationDismissFedCmDialogResponseParamsProxyToResponder
      implements FederatedAuthRequestAutomation.DismissFedCmDialog_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FederatedAuthRequestAutomationDismissFedCmDialogResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      FederatedAuthRequestAutomationDismissFedCmDialogResponseParams _response =
          new FederatedAuthRequestAutomationDismissFedCmDialogResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class FederatedAuthRequestAutomationClickFedCmDialogButtonParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int dialogButton;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestAutomationClickFedCmDialogButtonParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestAutomationClickFedCmDialogButtonParams() {
      this(0);
    }

    public static FederatedAuthRequestAutomationClickFedCmDialogButtonParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestAutomationClickFedCmDialogButtonParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestAutomationClickFedCmDialogButtonParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestAutomationClickFedCmDialogButtonParams result =
            new FederatedAuthRequestAutomationClickFedCmDialogButtonParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.dialogButton = readInt;
        DialogButton.validate(readInt);
        result.dialogButton = DialogButton.toKnownValue(result.dialogButton);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.dialogButton, 8);
    }
  }

  static final class FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean success;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParams(int version) {
      super(16, version);
    }

    public FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParams() {
      this(0);
    }

    public static FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParams result =
            new FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParams(
                elementsOrVersion);
        result.success = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.success, 8, 0);
    }
  }

  static class FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final FederatedAuthRequestAutomation.ClickFedCmDialogButton_Response mCallback;

    FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParamsForwardToCallback(
        FederatedAuthRequestAutomation.ClickFedCmDialogButton_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(4, 2)) {
          return false;
        }
        FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParams response =
            FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.success);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParamsProxyToResponder
      implements FederatedAuthRequestAutomation.ClickFedCmDialogButton_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean success) {
      FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParams _response =
          new FederatedAuthRequestAutomationClickFedCmDialogButtonResponseParams();
      _response.success = success;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
