// HandwritingRecognitionService_Internal.java is auto generated by mojom_bindings_generator.py, do
// not edit

// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/handwriting/handwriting.mojom
//

package org.chromium.handwriting.mojom;

class HandwritingRecognitionService_Internal {

  public static final org.chromium.mojo.bindings.Interface.Manager<
          HandwritingRecognitionService, HandwritingRecognitionService.Proxy>
      MANAGER =
          new org.chromium.mojo.bindings.Interface.Manager<
              HandwritingRecognitionService, HandwritingRecognitionService.Proxy>() {

            @Override
            public String getName() {
              return "handwriting.mojom.HandwritingRecognitionService";
            }

            @Override
            public int getVersion() {
              return 0;
            }

            @Override
            public Proxy buildProxy(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
              return new Proxy(core, messageReceiver);
            }

            @Override
            public Stub buildStub(
                org.chromium.mojo.system.Core core, HandwritingRecognitionService impl) {
              return new Stub(core, impl);
            }

            @Override
            public HandwritingRecognitionService[] buildArray(int size) {
              return new HandwritingRecognitionService[size];
            }
          };

  private static final int CREATE_HANDWRITING_RECOGNIZER_ORDINAL = 0;

  private static final int QUERY_HANDWRITING_RECOGNIZER_ORDINAL = 1;

  static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy
      implements HandwritingRecognitionService.Proxy {

    Proxy(
        org.chromium.mojo.system.Core core,
        org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void createHandwritingRecognizer(
        HandwritingModelConstraint constraint, CreateHandwritingRecognizer_Response callback) {

      HandwritingRecognitionServiceCreateHandwritingRecognizerParams _message =
          new HandwritingRecognitionServiceCreateHandwritingRecognizerParams();

      _message.constraint = constraint;

      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(),
                  new org.chromium.mojo.bindings.MessageHeader(
                      CREATE_HANDWRITING_RECOGNIZER_ORDINAL,
                      org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                      0)),
              new HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void queryHandwritingRecognizer(
        HandwritingModelConstraint constraint, QueryHandwritingRecognizer_Response callback) {

      HandwritingRecognitionServiceQueryHandwritingRecognizerParams _message =
          new HandwritingRecognitionServiceQueryHandwritingRecognizerParams();

      _message.constraint = constraint;

      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(),
                  new org.chromium.mojo.bindings.MessageHeader(
                      QUERY_HANDWRITING_RECOGNIZER_ORDINAL,
                      org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                      0)),
              new HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParamsForwardToCallback(
                  callback));
    }
  }

  static final class Stub
      extends org.chromium.mojo.bindings.Interface.Stub<HandwritingRecognitionService> {

    Stub(org.chromium.mojo.system.Core core, HandwritingRecognitionService impl) {
      super(core, impl);
    }

    @Override
    public boolean accept(org.chromium.mojo.bindings.Message message) {
      try {
        org.chromium.mojo.bindings.ServiceMessage messageWithHeader = message.asServiceMessage();
        org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
        int flags = org.chromium.mojo.bindings.MessageHeader.NO_FLAG;
        if (header.hasFlag(org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_SYNC_FLAG)) {
          flags = flags | org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_SYNC_FLAG;
        }
        if (!header.validateHeader(flags)) {
          return false;
        }
        switch (header.getType()) {
          case org.chromium.mojo.bindings.interfacecontrol.InterfaceControlMessagesConstants
              .RUN_OR_CLOSE_PIPE_MESSAGE_ID:
            return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRunOrClosePipe(
                HandwritingRecognitionService_Internal.MANAGER, messageWithHeader);

          default:
            return false;
        }
      } catch (org.chromium.mojo.bindings.DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }

    @Override
    public boolean acceptWithResponder(
        org.chromium.mojo.bindings.Message message,
        org.chromium.mojo.bindings.MessageReceiver receiver) {
      try {
        org.chromium.mojo.bindings.ServiceMessage messageWithHeader = message.asServiceMessage();
        org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
        int flags = org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG;
        if (header.hasFlag(org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_SYNC_FLAG)) {
          flags = flags | org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_SYNC_FLAG;
        }
        if (!header.validateHeader(flags)) {
          return false;
        }
        switch (header.getType()) {
          case org.chromium.mojo.bindings.interfacecontrol.InterfaceControlMessagesConstants
              .RUN_MESSAGE_ID:
            return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRun(
                getCore(),
                HandwritingRecognitionService_Internal.MANAGER,
                messageWithHeader,
                receiver);

          case CREATE_HANDWRITING_RECOGNIZER_ORDINAL:
            {
              HandwritingRecognitionServiceCreateHandwritingRecognizerParams data =
                  HandwritingRecognitionServiceCreateHandwritingRecognizerParams.deserialize(
                      messageWithHeader.getPayload());

              getImpl()
                  .createHandwritingRecognizer(
                      data.constraint,
                      new HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParamsProxyToResponder(
                          getCore(), receiver, header.getRequestId()));
              return true;
            }

          case QUERY_HANDWRITING_RECOGNIZER_ORDINAL:
            {
              HandwritingRecognitionServiceQueryHandwritingRecognizerParams data =
                  HandwritingRecognitionServiceQueryHandwritingRecognizerParams.deserialize(
                      messageWithHeader.getPayload());

              getImpl()
                  .queryHandwritingRecognizer(
                      data.constraint,
                      new HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParamsProxyToResponder(
                          getCore(), receiver, header.getRequestId()));
              return true;
            }

          default:
            return false;
        }
      } catch (org.chromium.mojo.bindings.DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class HandwritingRecognitionServiceCreateHandwritingRecognizerParams
      extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 16;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY =
        new org.chromium.mojo.bindings.DataHeader[] {
          new org.chromium.mojo.bindings.DataHeader(16, 0)
        };
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO =
        VERSION_ARRAY[0];
    public HandwritingModelConstraint constraint;

    private HandwritingRecognitionServiceCreateHandwritingRecognizerParams(int version) {
      super(STRUCT_SIZE, version);
    }

    public HandwritingRecognitionServiceCreateHandwritingRecognizerParams() {
      this(0);
    }

    public static HandwritingRecognitionServiceCreateHandwritingRecognizerParams deserialize(
        org.chromium.mojo.bindings.Message message) {
      return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static HandwritingRecognitionServiceCreateHandwritingRecognizerParams deserialize(
        java.nio.ByteBuffer data) {
      return deserialize(
          new org.chromium.mojo.bindings.Message(
              data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static HandwritingRecognitionServiceCreateHandwritingRecognizerParams decode(
        org.chromium.mojo.bindings.Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      HandwritingRecognitionServiceCreateHandwritingRecognizerParams result;
      try {
        org.chromium.mojo.bindings.DataHeader mainDataHeader =
            decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        final int elementsOrVersion = mainDataHeader.elementsOrVersion;
        result =
            new HandwritingRecognitionServiceCreateHandwritingRecognizerParams(elementsOrVersion);
        {
          org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
          result.constraint = HandwritingModelConstraint.decode(decoder1);
        }

      } finally {
        decoder0.decreaseStackDepth();
      }
      return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final void encode(org.chromium.mojo.bindings.Encoder encoder) {
      org.chromium.mojo.bindings.Encoder encoder0 =
          encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);

      encoder0.encode(this.constraint, 8, false);
    }
  }

  static final class HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParams
      extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 24;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY =
        new org.chromium.mojo.bindings.DataHeader[] {
          new org.chromium.mojo.bindings.DataHeader(24, 0)
        };
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO =
        VERSION_ARRAY[0];
    public int result;
    public HandwritingRecognizer handwritingRecognizer;

    private HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParams(int version) {
      super(STRUCT_SIZE, version);
    }

    public HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParams() {
      this(0);
    }

    public static HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParams
        deserialize(org.chromium.mojo.bindings.Message message) {
      return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParams
        deserialize(java.nio.ByteBuffer data) {
      return deserialize(
          new org.chromium.mojo.bindings.Message(
              data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParams decode(
        org.chromium.mojo.bindings.Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParams result;
      try {
        org.chromium.mojo.bindings.DataHeader mainDataHeader =
            decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        final int elementsOrVersion = mainDataHeader.elementsOrVersion;
        result =
            new HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParams(
                elementsOrVersion);
        {
          result.result = decoder0.readInt(8);
          CreateHandwritingRecognizerResult.validate(result.result);
          result.result = CreateHandwritingRecognizerResult.toKnownValue(result.result);
        }
        {
          result.handwritingRecognizer =
              decoder0.readServiceInterface(12, true, HandwritingRecognizer.MANAGER);
        }

      } finally {
        decoder0.decreaseStackDepth();
      }
      return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final void encode(org.chromium.mojo.bindings.Encoder encoder) {
      org.chromium.mojo.bindings.Encoder encoder0 =
          encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);

      encoder0.encode(this.result, 8);

      encoder0.encode(this.handwritingRecognizer, 12, true, HandwritingRecognizer.MANAGER);
    }
  }

  static
  class HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParamsForwardToCallback
      extends org.chromium.mojo.bindings.SideEffectFreeCloseable
      implements org.chromium.mojo.bindings.MessageReceiver {
    private final HandwritingRecognitionService.CreateHandwritingRecognizer_Response mCallback;

    HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParamsForwardToCallback(
        HandwritingRecognitionService.CreateHandwritingRecognizer_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(org.chromium.mojo.bindings.Message message) {
      try {
        org.chromium.mojo.bindings.ServiceMessage messageWithHeader = message.asServiceMessage();
        org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(
            CREATE_HANDWRITING_RECOGNIZER_ORDINAL,
            org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
          return false;
        }

        HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParams response =
            HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParams.deserialize(
                messageWithHeader.getPayload());

        mCallback.call(response.result, response.handwritingRecognizer);
        return true;
      } catch (org.chromium.mojo.bindings.DeserializationException e) {
        return false;
      }
    }
  }

  static
  class HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParamsProxyToResponder
      implements HandwritingRecognitionService.CreateHandwritingRecognizer_Response {

    private final org.chromium.mojo.system.Core mCore;
    private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParamsProxyToResponder(
        org.chromium.mojo.system.Core core,
        org.chromium.mojo.bindings.MessageReceiver messageReceiver,
        long requestId) {
      mCore = core;
      mMessageReceiver = messageReceiver;
      mRequestId = requestId;
    }

    @Override
    public void call(int result, HandwritingRecognizer handwritingRecognizer) {
      HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParams _response =
          new HandwritingRecognitionServiceCreateHandwritingRecognizerResponseParams();

      _response.result = result;

      _response.handwritingRecognizer = handwritingRecognizer;

      org.chromium.mojo.bindings.ServiceMessage _message =
          _response.serializeWithHeader(
              mCore,
              new org.chromium.mojo.bindings.MessageHeader(
                  CREATE_HANDWRITING_RECOGNIZER_ORDINAL,
                  org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                  mRequestId));
      mMessageReceiver.accept(_message);
    }
  }

  static final class HandwritingRecognitionServiceQueryHandwritingRecognizerParams
      extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 16;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY =
        new org.chromium.mojo.bindings.DataHeader[] {
          new org.chromium.mojo.bindings.DataHeader(16, 0)
        };
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO =
        VERSION_ARRAY[0];
    public HandwritingModelConstraint constraint;

    private HandwritingRecognitionServiceQueryHandwritingRecognizerParams(int version) {
      super(STRUCT_SIZE, version);
    }

    public HandwritingRecognitionServiceQueryHandwritingRecognizerParams() {
      this(0);
    }

    public static HandwritingRecognitionServiceQueryHandwritingRecognizerParams deserialize(
        org.chromium.mojo.bindings.Message message) {
      return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static HandwritingRecognitionServiceQueryHandwritingRecognizerParams deserialize(
        java.nio.ByteBuffer data) {
      return deserialize(
          new org.chromium.mojo.bindings.Message(
              data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static HandwritingRecognitionServiceQueryHandwritingRecognizerParams decode(
        org.chromium.mojo.bindings.Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      HandwritingRecognitionServiceQueryHandwritingRecognizerParams result;
      try {
        org.chromium.mojo.bindings.DataHeader mainDataHeader =
            decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        final int elementsOrVersion = mainDataHeader.elementsOrVersion;
        result =
            new HandwritingRecognitionServiceQueryHandwritingRecognizerParams(elementsOrVersion);
        {
          org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, true);
          result.constraint = HandwritingModelConstraint.decode(decoder1);
        }

      } finally {
        decoder0.decreaseStackDepth();
      }
      return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final void encode(org.chromium.mojo.bindings.Encoder encoder) {
      org.chromium.mojo.bindings.Encoder encoder0 =
          encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);

      encoder0.encode(this.constraint, 8, true);
    }
  }

  static final class HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParams
      extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 16;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY =
        new org.chromium.mojo.bindings.DataHeader[] {
          new org.chromium.mojo.bindings.DataHeader(16, 0)
        };
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO =
        VERSION_ARRAY[0];
    public QueryHandwritingRecognizerResult result;

    private HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParams(int version) {
      super(STRUCT_SIZE, version);
    }

    public HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParams() {
      this(0);
    }

    public static HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParams deserialize(
        org.chromium.mojo.bindings.Message message) {
      return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParams deserialize(
        java.nio.ByteBuffer data) {
      return deserialize(
          new org.chromium.mojo.bindings.Message(
              data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParams decode(
        org.chromium.mojo.bindings.Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParams result;
      try {
        org.chromium.mojo.bindings.DataHeader mainDataHeader =
            decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        final int elementsOrVersion = mainDataHeader.elementsOrVersion;
        result =
            new HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParams(
                elementsOrVersion);
        {
          org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, true);
          result.result = QueryHandwritingRecognizerResult.decode(decoder1);
        }

      } finally {
        decoder0.decreaseStackDepth();
      }
      return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final void encode(org.chromium.mojo.bindings.Encoder encoder) {
      org.chromium.mojo.bindings.Encoder encoder0 =
          encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);

      encoder0.encode(this.result, 8, true);
    }
  }

  static
  class HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParamsForwardToCallback
      extends org.chromium.mojo.bindings.SideEffectFreeCloseable
      implements org.chromium.mojo.bindings.MessageReceiver {
    private final HandwritingRecognitionService.QueryHandwritingRecognizer_Response mCallback;

    HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParamsForwardToCallback(
        HandwritingRecognitionService.QueryHandwritingRecognizer_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(org.chromium.mojo.bindings.Message message) {
      try {
        org.chromium.mojo.bindings.ServiceMessage messageWithHeader = message.asServiceMessage();
        org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(
            QUERY_HANDWRITING_RECOGNIZER_ORDINAL,
            org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
          return false;
        }

        HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParams response =
            HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParams.deserialize(
                messageWithHeader.getPayload());

        mCallback.call(response.result);
        return true;
      } catch (org.chromium.mojo.bindings.DeserializationException e) {
        return false;
      }
    }
  }

  static class HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParamsProxyToResponder
      implements HandwritingRecognitionService.QueryHandwritingRecognizer_Response {

    private final org.chromium.mojo.system.Core mCore;
    private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
    private final long mRequestId;

    HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParamsProxyToResponder(
        org.chromium.mojo.system.Core core,
        org.chromium.mojo.bindings.MessageReceiver messageReceiver,
        long requestId) {
      mCore = core;
      mMessageReceiver = messageReceiver;
      mRequestId = requestId;
    }

    @Override
    public void call(QueryHandwritingRecognizerResult result) {
      HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParams _response =
          new HandwritingRecognitionServiceQueryHandwritingRecognizerResponseParams();

      _response.result = result;

      org.chromium.mojo.bindings.ServiceMessage _message =
          _response.serializeWithHeader(
              mCore,
              new org.chromium.mojo.bindings.MessageHeader(
                  QUERY_HANDWRITING_RECOGNIZER_ORDINAL,
                  org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                  mRequestId));
      mMessageReceiver.accept(_message);
    }
  }
}
