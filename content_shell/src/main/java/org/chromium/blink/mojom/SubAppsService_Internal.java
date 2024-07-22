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

class SubAppsService_Internal {
  private static final int ADD_ORDINAL = 0;
  private static final int LIST_ORDINAL = 1;
  public static final Interface.Manager<SubAppsService, SubAppsService.Proxy> MANAGER =
      new Interface.Manager<SubAppsService, SubAppsService.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.SubAppsService";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public SubAppsService.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, SubAppsService impl) {
          return new Stub(core, impl);
        }

        @Override
        public SubAppsService[] buildArray(int size) {
          return new SubAppsService[size];
        }
      };
  private static final int REMOVE_ORDINAL = 2;

  SubAppsService_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements SubAppsService.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void add(SubAppsServiceAddParameters[] subAppsToAdd, Add_Response callback) {
      SubAppsServiceAddParams _message = new SubAppsServiceAddParams();
      _message.subAppsToAdd = subAppsToAdd;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new SubAppsServiceAddResponseParamsForwardToCallback(callback));
    }

    @Override
    public void list(List_Response callback) {
      SubAppsServiceListParams _message = new SubAppsServiceListParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new SubAppsServiceListResponseParamsForwardToCallback(callback));
    }

    @Override
    public void remove(String[] manifestIdPaths, Remove_Response callback) {
      SubAppsServiceRemoveParams _message = new SubAppsServiceRemoveParams();
      _message.manifestIdPaths = manifestIdPaths;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new SubAppsServiceRemoveResponseParamsForwardToCallback(callback));
    }
  }

  public static final class Stub extends Interface.Stub<SubAppsService> {
    Stub(Core core, SubAppsService impl) {
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
                SubAppsService_Internal.MANAGER, messageWithHeader);
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
                getCore(), SubAppsService_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            SubAppsServiceAddParams data =
                SubAppsServiceAddParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .add(
                    data.subAppsToAdd,
                    new SubAppsServiceAddResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            SubAppsServiceListParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .list(
                    new SubAppsServiceListResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            SubAppsServiceRemoveParams data2 =
                SubAppsServiceRemoveParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .remove(
                    data2.manifestIdPaths,
                    new SubAppsServiceRemoveResponseParamsProxyToResponder(
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

  static final class SubAppsServiceAddParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SubAppsServiceAddParameters[] subAppsToAdd;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SubAppsServiceAddParams(int version) {
      super(16, version);
    }

    public SubAppsServiceAddParams() {
      this(0);
    }

    public static SubAppsServiceAddParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SubAppsServiceAddParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SubAppsServiceAddParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SubAppsServiceAddParams result = new SubAppsServiceAddParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.subAppsToAdd = new SubAppsServiceAddParameters[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.subAppsToAdd[i1] = SubAppsServiceAddParameters.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      SubAppsServiceAddParameters[] subAppsServiceAddParametersArr = this.subAppsToAdd;
      if (subAppsServiceAddParametersArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(subAppsServiceAddParametersArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        SubAppsServiceAddParameters[] subAppsServiceAddParametersArr2 = this.subAppsToAdd;
        if (i0 < subAppsServiceAddParametersArr2.length) {
          encoder1.encode((Struct) subAppsServiceAddParametersArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class SubAppsServiceAddResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SubAppsServiceAddResult[] result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SubAppsServiceAddResponseParams(int version) {
      super(16, version);
    }

    public SubAppsServiceAddResponseParams() {
      this(0);
    }

    public static SubAppsServiceAddResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SubAppsServiceAddResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SubAppsServiceAddResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SubAppsServiceAddResponseParams result =
            new SubAppsServiceAddResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.result = new SubAppsServiceAddResult[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.result[i1] = SubAppsServiceAddResult.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      SubAppsServiceAddResult[] subAppsServiceAddResultArr = this.result;
      if (subAppsServiceAddResultArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(subAppsServiceAddResultArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        SubAppsServiceAddResult[] subAppsServiceAddResultArr2 = this.result;
        if (i0 < subAppsServiceAddResultArr2.length) {
          encoder1.encode((Struct) subAppsServiceAddResultArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class SubAppsServiceAddResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final SubAppsService.Add_Response mCallback;

    SubAppsServiceAddResponseParamsForwardToCallback(SubAppsService.Add_Response callback) {
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
        SubAppsServiceAddResponseParams response =
            SubAppsServiceAddResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SubAppsServiceAddResponseParamsProxyToResponder
      implements SubAppsService.Add_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SubAppsServiceAddResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SubAppsServiceAddResult[] result) {
      SubAppsServiceAddResponseParams _response = new SubAppsServiceAddResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SubAppsServiceListParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SubAppsServiceListParams(int version) {
      super(8, version);
    }

    public SubAppsServiceListParams() {
      this(0);
    }

    public static SubAppsServiceListParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SubAppsServiceListParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SubAppsServiceListParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SubAppsServiceListParams result = new SubAppsServiceListParams(elementsOrVersion);
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

  static final class SubAppsServiceListResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SubAppsServiceListResult result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SubAppsServiceListResponseParams(int version) {
      super(16, version);
    }

    public SubAppsServiceListResponseParams() {
      this(0);
    }

    public static SubAppsServiceListResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SubAppsServiceListResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SubAppsServiceListResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SubAppsServiceListResponseParams result =
            new SubAppsServiceListResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = SubAppsServiceListResult.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.result, 8, false);
    }
  }

  static class SubAppsServiceListResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final SubAppsService.List_Response mCallback;

    SubAppsServiceListResponseParamsForwardToCallback(SubAppsService.List_Response callback) {
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
        SubAppsServiceListResponseParams response =
            SubAppsServiceListResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SubAppsServiceListResponseParamsProxyToResponder
      implements SubAppsService.List_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SubAppsServiceListResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SubAppsServiceListResult result) {
      SubAppsServiceListResponseParams _response = new SubAppsServiceListResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class SubAppsServiceRemoveParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String[] manifestIdPaths;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SubAppsServiceRemoveParams(int version) {
      super(16, version);
    }

    public SubAppsServiceRemoveParams() {
      this(0);
    }

    public static SubAppsServiceRemoveParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SubAppsServiceRemoveParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SubAppsServiceRemoveParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SubAppsServiceRemoveParams result = new SubAppsServiceRemoveParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.manifestIdPaths = new String[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          result.manifestIdPaths[i1] = decoder1.readString((i1 * 8) + 8, false);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String[] strArr = this.manifestIdPaths;
      if (strArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(strArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String[] strArr2 = this.manifestIdPaths;
        if (i0 < strArr2.length) {
          encoder1.encode(strArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static final class SubAppsServiceRemoveResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public SubAppsServiceRemoveResult[] result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private SubAppsServiceRemoveResponseParams(int version) {
      super(16, version);
    }

    public SubAppsServiceRemoveResponseParams() {
      this(0);
    }

    public static SubAppsServiceRemoveResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static SubAppsServiceRemoveResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static SubAppsServiceRemoveResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        SubAppsServiceRemoveResponseParams result =
            new SubAppsServiceRemoveResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.result = new SubAppsServiceRemoveResult[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.result[i1] = SubAppsServiceRemoveResult.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      SubAppsServiceRemoveResult[] subAppsServiceRemoveResultArr = this.result;
      if (subAppsServiceRemoveResultArr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(subAppsServiceRemoveResultArr.length, 8, -1);
      int i0 = 0;
      while (true) {
        SubAppsServiceRemoveResult[] subAppsServiceRemoveResultArr2 = this.result;
        if (i0 < subAppsServiceRemoveResultArr2.length) {
          encoder1.encode((Struct) subAppsServiceRemoveResultArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class SubAppsServiceRemoveResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final SubAppsService.Remove_Response mCallback;

    SubAppsServiceRemoveResponseParamsForwardToCallback(SubAppsService.Remove_Response callback) {
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
        SubAppsServiceRemoveResponseParams response =
            SubAppsServiceRemoveResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class SubAppsServiceRemoveResponseParamsProxyToResponder
      implements SubAppsService.Remove_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    SubAppsServiceRemoveResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(SubAppsServiceRemoveResult[] result) {
      SubAppsServiceRemoveResponseParams _response = new SubAppsServiceRemoveResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }
}
