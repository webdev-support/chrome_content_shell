package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo.system.Core;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.BigString;
import org.chromium.mojo_base.mojom.BigString16;
import org.chromium.mojo_base.mojom.String16;
import org.chromium.skia.mojom.BitmapN32;
import org.chromium.url.mojom.Url;

class ClipboardHost_Internal {
  private static final int COMMIT_WRITE_ORDINAL = 20;
  private static final int GET_SEQUENCE_NUMBER_ORDINAL = 0;
  private static final int IS_FORMAT_AVAILABLE_ORDINAL = 1;
  public static final Interface.Manager<ClipboardHost, ClipboardHost.Proxy> MANAGER =
      new Interface.Manager<ClipboardHost, ClipboardHost.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.ClipboardHost";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ClipboardHost.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ClipboardHost impl) {
          return new Stub(core, impl);
        }

        @Override
        public ClipboardHost[] buildArray(int size) {
          return new ClipboardHost[size];
        }
      };
  private static final int READ_AVAILABLE_CUSTOM_AND_STANDARD_FORMATS_ORDINAL = 10;
  private static final int READ_AVAILABLE_TYPES_ORDINAL = 2;
  private static final int READ_CUSTOM_DATA_ORDINAL = 9;
  private static final int READ_FILES_ORDINAL = 8;
  private static final int READ_HTML_ORDINAL = 4;
  private static final int READ_PNG_ORDINAL = 7;
  private static final int READ_RTF_ORDINAL = 6;
  private static final int READ_SVG_ORDINAL = 5;
  private static final int READ_TEXT_ORDINAL = 3;
  private static final int READ_UNSANITIZED_CUSTOM_FORMAT_ORDINAL = 11;
  private static final int WRITE_BOOKMARK_ORDINAL = 17;
  private static final int WRITE_CUSTOM_DATA_ORDINAL = 16;
  private static final int WRITE_HTML_ORDINAL = 13;
  private static final int WRITE_IMAGE_ORDINAL = 18;
  private static final int WRITE_SMART_PASTE_MARKER_ORDINAL = 15;
  private static final int WRITE_SVG_ORDINAL = 14;
  private static final int WRITE_TEXT_ORDINAL = 12;
  private static final int WRITE_UNSANITIZED_CUSTOM_FORMAT_ORDINAL = 19;

  ClipboardHost_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy implements ClipboardHost.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void getSequenceNumber(int buffer, GetSequenceNumber_Response callback) {
      ClipboardHostGetSequenceNumberParams _message = new ClipboardHostGetSequenceNumberParams();
      _message.buffer = buffer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(0, 1, 0L)),
              new ClipboardHostGetSequenceNumberResponseParamsForwardToCallback(callback));
    }

    @Override
    public void isFormatAvailable(int format, int buffer, IsFormatAvailable_Response callback) {
      ClipboardHostIsFormatAvailableParams _message = new ClipboardHostIsFormatAvailableParams();
      _message.format = format;
      _message.buffer = buffer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(1, 1, 0L)),
              new ClipboardHostIsFormatAvailableResponseParamsForwardToCallback(callback));
    }

    @Override
    public void readAvailableTypes(int buffer, ReadAvailableTypes_Response callback) {
      ClipboardHostReadAvailableTypesParams _message = new ClipboardHostReadAvailableTypesParams();
      _message.buffer = buffer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(2, 1, 0L)),
              new ClipboardHostReadAvailableTypesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void readText(int buffer, ReadText_Response callback) {
      ClipboardHostReadTextParams _message = new ClipboardHostReadTextParams();
      _message.buffer = buffer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(3, 1, 0L)),
              new ClipboardHostReadTextResponseParamsForwardToCallback(callback));
    }

    @Override
    public void readHtml(int buffer, ReadHtml_Response callback) {
      ClipboardHostReadHtmlParams _message = new ClipboardHostReadHtmlParams();
      _message.buffer = buffer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(4, 1, 0L)),
              new ClipboardHostReadHtmlResponseParamsForwardToCallback(callback));
    }

    @Override
    public void readSvg(int buffer, ReadSvg_Response callback) {
      ClipboardHostReadSvgParams _message = new ClipboardHostReadSvgParams();
      _message.buffer = buffer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(5, 1, 0L)),
              new ClipboardHostReadSvgResponseParamsForwardToCallback(callback));
    }

    @Override
    public void readRtf(int buffer, ReadRtf_Response callback) {
      ClipboardHostReadRtfParams _message = new ClipboardHostReadRtfParams();
      _message.buffer = buffer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(6, 1, 0L)),
              new ClipboardHostReadRtfResponseParamsForwardToCallback(callback));
    }

    @Override
    public void readPng(int buffer, ReadPng_Response callback) {
      ClipboardHostReadPngParams _message = new ClipboardHostReadPngParams();
      _message.buffer = buffer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(7, 1, 0L)),
              new ClipboardHostReadPngResponseParamsForwardToCallback(callback));
    }

    @Override
    public void readFiles(int buffer, ReadFiles_Response callback) {
      ClipboardHostReadFilesParams _message = new ClipboardHostReadFilesParams();
      _message.buffer = buffer;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(8, 1, 0L)),
              new ClipboardHostReadFilesResponseParamsForwardToCallback(callback));
    }

    @Override
    public void readCustomData(int buffer, String16 type, ReadCustomData_Response callback) {
      ClipboardHostReadCustomDataParams _message = new ClipboardHostReadCustomDataParams();
      _message.buffer = buffer;
      _message.type = type;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(9, 1, 0L)),
              new ClipboardHostReadCustomDataResponseParamsForwardToCallback(callback));
    }

    @Override
    public void readAvailableCustomAndStandardFormats(
        ReadAvailableCustomAndStandardFormats_Response callback) {
      ClipboardHostReadAvailableCustomAndStandardFormatsParams _message =
          new ClipboardHostReadAvailableCustomAndStandardFormatsParams();
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(10, 1, 0L)),
              new ClipboardHostReadAvailableCustomAndStandardFormatsResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void readUnsanitizedCustomFormat(
        String16 format, ReadUnsanitizedCustomFormat_Response callback) {
      ClipboardHostReadUnsanitizedCustomFormatParams _message =
          new ClipboardHostReadUnsanitizedCustomFormatParams();
      _message.format = format;
      getProxyHandler()
          .getMessageReceiver()
          .acceptWithResponder(
              _message.serializeWithHeader(
                  getProxyHandler().getCore(), new MessageHeader(11, 1, 0L)),
              new ClipboardHostReadUnsanitizedCustomFormatResponseParamsForwardToCallback(
                  callback));
    }

    @Override
    public void writeText(BigString16 text) {
      ClipboardHostWriteTextParams _message = new ClipboardHostWriteTextParams();
      _message.text = text;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(12)));
    }

    @Override
    public void writeHtml(BigString16 markup, Url url) {
      ClipboardHostWriteHtmlParams _message = new ClipboardHostWriteHtmlParams();
      _message.markup = markup;
      _message.url = url;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(13)));
    }

    @Override
    public void writeSvg(BigString16 markup) {
      ClipboardHostWriteSvgParams _message = new ClipboardHostWriteSvgParams();
      _message.markup = markup;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(14)));
    }

    @Override
    public void writeSmartPasteMarker() {
      ClipboardHostWriteSmartPasteMarkerParams _message =
          new ClipboardHostWriteSmartPasteMarkerParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(15)));
    }

    @Override
    public void writeCustomData(Map<String16, BigString16> data) {
      ClipboardHostWriteCustomDataParams _message = new ClipboardHostWriteCustomDataParams();
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(16)));
    }

    @Override
    public void writeBookmark(String url, String16 title) {
      ClipboardHostWriteBookmarkParams _message = new ClipboardHostWriteBookmarkParams();
      _message.url = url;
      _message.title = title;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(17)));
    }

    @Override
    public void writeImage(BitmapN32 image) {
      ClipboardHostWriteImageParams _message = new ClipboardHostWriteImageParams();
      _message.image = image;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(18)));
    }

    @Override
    public void writeUnsanitizedCustomFormat(String16 format, BigBuffer data) {
      ClipboardHostWriteUnsanitizedCustomFormatParams _message =
          new ClipboardHostWriteUnsanitizedCustomFormatParams();
      _message.format = format;
      _message.data = data;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(19)));
    }

    @Override
    public void commitWrite() {
      ClipboardHostCommitWriteParams _message = new ClipboardHostCommitWriteParams();
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(20)));
    }
  }

  public static final class Stub extends Interface.Stub<ClipboardHost> {
    Stub(Core core, ClipboardHost impl) {
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
                ClipboardHost_Internal.MANAGER, messageWithHeader);
          case 12:
            getImpl()
                .writeText(
                    ClipboardHostWriteTextParams.deserialize(messageWithHeader.getPayload()).text);
            return true;
          case 13:
            ClipboardHostWriteHtmlParams data =
                ClipboardHostWriteHtmlParams.deserialize(messageWithHeader.getPayload());
            getImpl().writeHtml(data.markup, data.url);
            return true;
          case 14:
            ClipboardHostWriteSvgParams data2 =
                ClipboardHostWriteSvgParams.deserialize(messageWithHeader.getPayload());
            getImpl().writeSvg(data2.markup);
            return true;
          case 15:
            ClipboardHostWriteSmartPasteMarkerParams.deserialize(messageWithHeader.getPayload());
            getImpl().writeSmartPasteMarker();
            return true;
          case 16:
            ClipboardHostWriteCustomDataParams data3 =
                ClipboardHostWriteCustomDataParams.deserialize(messageWithHeader.getPayload());
            getImpl().writeCustomData(data3.data);
            return true;
          case 17:
            ClipboardHostWriteBookmarkParams data4 =
                ClipboardHostWriteBookmarkParams.deserialize(messageWithHeader.getPayload());
            getImpl().writeBookmark(data4.url, data4.title);
            return true;
          case 18:
            ClipboardHostWriteImageParams data5 =
                ClipboardHostWriteImageParams.deserialize(messageWithHeader.getPayload());
            getImpl().writeImage(data5.image);
            return true;
          case 19:
            ClipboardHostWriteUnsanitizedCustomFormatParams data6 =
                ClipboardHostWriteUnsanitizedCustomFormatParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().writeUnsanitizedCustomFormat(data6.format, data6.data);
            return true;
          case 20:
            ClipboardHostCommitWriteParams.deserialize(messageWithHeader.getPayload());
            getImpl().commitWrite();
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
                getCore(), ClipboardHost_Internal.MANAGER, messageWithHeader, receiver);
          case 0:
            getImpl()
                .getSequenceNumber(
                    ClipboardHostGetSequenceNumberParams.deserialize(messageWithHeader.getPayload())
                        .buffer,
                    new ClipboardHostGetSequenceNumberResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 1:
            ClipboardHostIsFormatAvailableParams data =
                ClipboardHostIsFormatAvailableParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .isFormatAvailable(
                    data.format,
                    data.buffer,
                    new ClipboardHostIsFormatAvailableResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 2:
            ClipboardHostReadAvailableTypesParams data2 =
                ClipboardHostReadAvailableTypesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .readAvailableTypes(
                    data2.buffer,
                    new ClipboardHostReadAvailableTypesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 3:
            ClipboardHostReadTextParams data3 =
                ClipboardHostReadTextParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .readText(
                    data3.buffer,
                    new ClipboardHostReadTextResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 4:
            ClipboardHostReadHtmlParams data4 =
                ClipboardHostReadHtmlParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .readHtml(
                    data4.buffer,
                    new ClipboardHostReadHtmlResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 5:
            ClipboardHostReadSvgParams data5 =
                ClipboardHostReadSvgParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .readSvg(
                    data5.buffer,
                    new ClipboardHostReadSvgResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 6:
            ClipboardHostReadRtfParams data6 =
                ClipboardHostReadRtfParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .readRtf(
                    data6.buffer,
                    new ClipboardHostReadRtfResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 7:
            ClipboardHostReadPngParams data7 =
                ClipboardHostReadPngParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .readPng(
                    data7.buffer,
                    new ClipboardHostReadPngResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 8:
            ClipboardHostReadFilesParams data8 =
                ClipboardHostReadFilesParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .readFiles(
                    data8.buffer,
                    new ClipboardHostReadFilesResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 9:
            ClipboardHostReadCustomDataParams data9 =
                ClipboardHostReadCustomDataParams.deserialize(messageWithHeader.getPayload());
            getImpl()
                .readCustomData(
                    data9.buffer,
                    data9.type,
                    new ClipboardHostReadCustomDataResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 10:
            ClipboardHostReadAvailableCustomAndStandardFormatsParams.deserialize(
                messageWithHeader.getPayload());
            getImpl()
                .readAvailableCustomAndStandardFormats(
                    new ClipboardHostReadAvailableCustomAndStandardFormatsResponseParamsProxyToResponder(
                        getCore(), receiver, header.getRequestId()));
            return true;
          case 11:
            ClipboardHostReadUnsanitizedCustomFormatParams data10 =
                ClipboardHostReadUnsanitizedCustomFormatParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl()
                .readUnsanitizedCustomFormat(
                    data10.format,
                    new ClipboardHostReadUnsanitizedCustomFormatResponseParamsProxyToResponder(
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

  static final class ClipboardHostGetSequenceNumberParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int buffer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostGetSequenceNumberParams(int version) {
      super(16, version);
    }

    public ClipboardHostGetSequenceNumberParams() {
      this(0);
    }

    public static ClipboardHostGetSequenceNumberParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostGetSequenceNumberParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostGetSequenceNumberParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostGetSequenceNumberParams result =
            new ClipboardHostGetSequenceNumberParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.buffer = readInt;
        ClipboardBuffer.validate(readInt);
        result.buffer = ClipboardBuffer.toKnownValue(result.buffer);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.buffer, 8);
    }
  }

  static final class ClipboardHostGetSequenceNumberResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ClipboardSequenceNumberToken result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostGetSequenceNumberResponseParams(int version) {
      super(16, version);
    }

    public ClipboardHostGetSequenceNumberResponseParams() {
      this(0);
    }

    public static ClipboardHostGetSequenceNumberResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostGetSequenceNumberResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostGetSequenceNumberResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostGetSequenceNumberResponseParams result =
            new ClipboardHostGetSequenceNumberResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = ClipboardSequenceNumberToken.decode(decoder1);
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

  static class ClipboardHostGetSequenceNumberResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ClipboardHost.GetSequenceNumber_Response mCallback;

    ClipboardHostGetSequenceNumberResponseParamsForwardToCallback(
        ClipboardHost.GetSequenceNumber_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(0, 6)) {
          return false;
        }
        ClipboardHostGetSequenceNumberResponseParams response =
            ClipboardHostGetSequenceNumberResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ClipboardHostGetSequenceNumberResponseParamsProxyToResponder
      implements ClipboardHost.GetSequenceNumber_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ClipboardHostGetSequenceNumberResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ClipboardSequenceNumberToken result) {
      ClipboardHostGetSequenceNumberResponseParams _response =
          new ClipboardHostGetSequenceNumberResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(0, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ClipboardHostIsFormatAvailableParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int buffer;
    public int format;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostIsFormatAvailableParams(int version) {
      super(16, version);
    }

    public ClipboardHostIsFormatAvailableParams() {
      this(0);
    }

    public static ClipboardHostIsFormatAvailableParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostIsFormatAvailableParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostIsFormatAvailableParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostIsFormatAvailableParams result =
            new ClipboardHostIsFormatAvailableParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.format = readInt;
        ClipboardFormat.validate(readInt);
        result.format = ClipboardFormat.toKnownValue(result.format);
        int readInt2 = decoder0.readInt(12);
        result.buffer = readInt2;
        ClipboardBuffer.validate(readInt2);
        result.buffer = ClipboardBuffer.toKnownValue(result.buffer);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.format, 8);
      encoder0.encode(this.buffer, 12);
    }
  }

  static final class ClipboardHostIsFormatAvailableResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public boolean result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostIsFormatAvailableResponseParams(int version) {
      super(16, version);
    }

    public ClipboardHostIsFormatAvailableResponseParams() {
      this(0);
    }

    public static ClipboardHostIsFormatAvailableResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostIsFormatAvailableResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostIsFormatAvailableResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostIsFormatAvailableResponseParams result =
            new ClipboardHostIsFormatAvailableResponseParams(elementsOrVersion);
        result.result = decoder0.readBoolean(8, 0);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.result, 8, 0);
    }
  }

  static class ClipboardHostIsFormatAvailableResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ClipboardHost.IsFormatAvailable_Response mCallback;

    ClipboardHostIsFormatAvailableResponseParamsForwardToCallback(
        ClipboardHost.IsFormatAvailable_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(1, 6)) {
          return false;
        }
        ClipboardHostIsFormatAvailableResponseParams response =
            ClipboardHostIsFormatAvailableResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ClipboardHostIsFormatAvailableResponseParamsProxyToResponder
      implements ClipboardHost.IsFormatAvailable_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ClipboardHostIsFormatAvailableResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(boolean result) {
      ClipboardHostIsFormatAvailableResponseParams _response =
          new ClipboardHostIsFormatAvailableResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(1, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ClipboardHostReadAvailableTypesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int buffer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadAvailableTypesParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadAvailableTypesParams() {
      this(0);
    }

    public static ClipboardHostReadAvailableTypesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadAvailableTypesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadAvailableTypesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadAvailableTypesParams result =
            new ClipboardHostReadAvailableTypesParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.buffer = readInt;
        ClipboardBuffer.validate(readInt);
        result.buffer = ClipboardBuffer.toKnownValue(result.buffer);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.buffer, 8);
    }
  }

  static final class ClipboardHostReadAvailableTypesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String16[] types;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadAvailableTypesResponseParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadAvailableTypesResponseParams() {
      this(0);
    }

    public static ClipboardHostReadAvailableTypesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadAvailableTypesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadAvailableTypesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadAvailableTypesResponseParams result =
            new ClipboardHostReadAvailableTypesResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.types = new String16[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.types[i1] = String16.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String16[] string16Arr = this.types;
      if (string16Arr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(string16Arr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String16[] string16Arr2 = this.types;
        if (i0 < string16Arr2.length) {
          encoder1.encode((Struct) string16Arr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class ClipboardHostReadAvailableTypesResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ClipboardHost.ReadAvailableTypes_Response mCallback;

    ClipboardHostReadAvailableTypesResponseParamsForwardToCallback(
        ClipboardHost.ReadAvailableTypes_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(2, 6)) {
          return false;
        }
        ClipboardHostReadAvailableTypesResponseParams response =
            ClipboardHostReadAvailableTypesResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.types);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ClipboardHostReadAvailableTypesResponseParamsProxyToResponder
      implements ClipboardHost.ReadAvailableTypes_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ClipboardHostReadAvailableTypesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String16[] types) {
      ClipboardHostReadAvailableTypesResponseParams _response =
          new ClipboardHostReadAvailableTypesResponseParams();
      _response.types = types;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(2, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ClipboardHostReadTextParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int buffer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadTextParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadTextParams() {
      this(0);
    }

    public static ClipboardHostReadTextParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadTextParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadTextParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadTextParams result = new ClipboardHostReadTextParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.buffer = readInt;
        ClipboardBuffer.validate(readInt);
        result.buffer = ClipboardBuffer.toKnownValue(result.buffer);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.buffer, 8);
    }
  }

  static final class ClipboardHostReadTextResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BigString16 result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadTextResponseParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadTextResponseParams() {
      this(0);
    }

    public static ClipboardHostReadTextResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadTextResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadTextResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadTextResponseParams result =
            new ClipboardHostReadTextResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = BigString16.decode(decoder1);
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

  static class ClipboardHostReadTextResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final ClipboardHost.ReadText_Response mCallback;

    ClipboardHostReadTextResponseParamsForwardToCallback(ClipboardHost.ReadText_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(3, 6)) {
          return false;
        }
        ClipboardHostReadTextResponseParams response =
            ClipboardHostReadTextResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ClipboardHostReadTextResponseParamsProxyToResponder
      implements ClipboardHost.ReadText_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ClipboardHostReadTextResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BigString16 result) {
      ClipboardHostReadTextResponseParams _response = new ClipboardHostReadTextResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(3, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ClipboardHostReadHtmlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int buffer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadHtmlParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadHtmlParams() {
      this(0);
    }

    public static ClipboardHostReadHtmlParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadHtmlParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadHtmlParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadHtmlParams result = new ClipboardHostReadHtmlParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.buffer = readInt;
        ClipboardBuffer.validate(readInt);
        result.buffer = ClipboardBuffer.toKnownValue(result.buffer);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.buffer, 8);
    }
  }

  static final class ClipboardHostReadHtmlResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public int fragmentEnd;
    public int fragmentStart;
    public BigString16 markup;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadHtmlResponseParams(int version) {
      super(32, version);
    }

    public ClipboardHostReadHtmlResponseParams() {
      this(0);
    }

    public static ClipboardHostReadHtmlResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadHtmlResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadHtmlResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadHtmlResponseParams result =
            new ClipboardHostReadHtmlResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.markup = BigString16.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder12);
        result.fragmentStart = decoder0.readInt(24);
        result.fragmentEnd = decoder0.readInt(28);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.markup, 8, false);
      encoder0.encode((Struct) this.url, 16, false);
      encoder0.encode(this.fragmentStart, 24);
      encoder0.encode(this.fragmentEnd, 28);
    }
  }

  static class ClipboardHostReadHtmlResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final ClipboardHost.ReadHtml_Response mCallback;

    ClipboardHostReadHtmlResponseParamsForwardToCallback(ClipboardHost.ReadHtml_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(4, 6)) {
          return false;
        }
        ClipboardHostReadHtmlResponseParams response =
            ClipboardHostReadHtmlResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(
            response.markup, response.url, response.fragmentStart, response.fragmentEnd);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ClipboardHostReadHtmlResponseParamsProxyToResponder
      implements ClipboardHost.ReadHtml_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ClipboardHostReadHtmlResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BigString16 markup, Url url, int fragmentStart, int fragmentEnd) {
      ClipboardHostReadHtmlResponseParams _response = new ClipboardHostReadHtmlResponseParams();
      _response.markup = markup;
      _response.url = url;
      _response.fragmentStart = fragmentStart;
      _response.fragmentEnd = fragmentEnd;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(4, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ClipboardHostReadSvgParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int buffer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadSvgParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadSvgParams() {
      this(0);
    }

    public static ClipboardHostReadSvgParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadSvgParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadSvgParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadSvgParams result = new ClipboardHostReadSvgParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.buffer = readInt;
        ClipboardBuffer.validate(readInt);
        result.buffer = ClipboardBuffer.toKnownValue(result.buffer);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.buffer, 8);
    }
  }

  static final class ClipboardHostReadSvgResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BigString16 result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadSvgResponseParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadSvgResponseParams() {
      this(0);
    }

    public static ClipboardHostReadSvgResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadSvgResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadSvgResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadSvgResponseParams result =
            new ClipboardHostReadSvgResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = BigString16.decode(decoder1);
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

  static class ClipboardHostReadSvgResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final ClipboardHost.ReadSvg_Response mCallback;

    ClipboardHostReadSvgResponseParamsForwardToCallback(ClipboardHost.ReadSvg_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(5, 2)) {
          return false;
        }
        ClipboardHostReadSvgResponseParams response =
            ClipboardHostReadSvgResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ClipboardHostReadSvgResponseParamsProxyToResponder
      implements ClipboardHost.ReadSvg_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ClipboardHostReadSvgResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BigString16 result) {
      ClipboardHostReadSvgResponseParams _response = new ClipboardHostReadSvgResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(5, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ClipboardHostReadRtfParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int buffer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadRtfParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadRtfParams() {
      this(0);
    }

    public static ClipboardHostReadRtfParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadRtfParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadRtfParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadRtfParams result = new ClipboardHostReadRtfParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.buffer = readInt;
        ClipboardBuffer.validate(readInt);
        result.buffer = ClipboardBuffer.toKnownValue(result.buffer);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.buffer, 8);
    }
  }

  static final class ClipboardHostReadRtfResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BigString result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadRtfResponseParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadRtfResponseParams() {
      this(0);
    }

    public static ClipboardHostReadRtfResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadRtfResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadRtfResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadRtfResponseParams result =
            new ClipboardHostReadRtfResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = BigString.decode(decoder1);
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

  static class ClipboardHostReadRtfResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final ClipboardHost.ReadRtf_Response mCallback;

    ClipboardHostReadRtfResponseParamsForwardToCallback(ClipboardHost.ReadRtf_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(6, 6)) {
          return false;
        }
        ClipboardHostReadRtfResponseParams response =
            ClipboardHostReadRtfResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ClipboardHostReadRtfResponseParamsProxyToResponder
      implements ClipboardHost.ReadRtf_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ClipboardHostReadRtfResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BigString result) {
      ClipboardHostReadRtfResponseParams _response = new ClipboardHostReadRtfResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(6, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ClipboardHostReadPngParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int buffer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadPngParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadPngParams() {
      this(0);
    }

    public static ClipboardHostReadPngParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadPngParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadPngParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadPngParams result = new ClipboardHostReadPngParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.buffer = readInt;
        ClipboardBuffer.validate(readInt);
        result.buffer = ClipboardBuffer.toKnownValue(result.buffer);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.buffer, 8);
    }
  }

  static final class ClipboardHostReadPngResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BigBuffer png;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadPngResponseParams(int version) {
      super(24, version);
    }

    public ClipboardHostReadPngResponseParams() {
      this(0);
    }

    public static ClipboardHostReadPngResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadPngResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadPngResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadPngResponseParams result =
            new ClipboardHostReadPngResponseParams(elementsOrVersion);
        result.png = BigBuffer.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.png, 8, false);
    }
  }

  static class ClipboardHostReadPngResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final ClipboardHost.ReadPng_Response mCallback;

    ClipboardHostReadPngResponseParamsForwardToCallback(ClipboardHost.ReadPng_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(7, 6)) {
          return false;
        }
        ClipboardHostReadPngResponseParams response =
            ClipboardHostReadPngResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.png);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ClipboardHostReadPngResponseParamsProxyToResponder
      implements ClipboardHost.ReadPng_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ClipboardHostReadPngResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BigBuffer png) {
      ClipboardHostReadPngResponseParams _response = new ClipboardHostReadPngResponseParams();
      _response.png = png;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(7, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ClipboardHostReadFilesParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public int buffer;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadFilesParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadFilesParams() {
      this(0);
    }

    public static ClipboardHostReadFilesParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadFilesParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadFilesParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadFilesParams result = new ClipboardHostReadFilesParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.buffer = readInt;
        ClipboardBuffer.validate(readInt);
        result.buffer = ClipboardBuffer.toKnownValue(result.buffer);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.buffer, 8);
    }
  }

  static final class ClipboardHostReadFilesResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public ClipboardFiles result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadFilesResponseParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadFilesResponseParams() {
      this(0);
    }

    public static ClipboardHostReadFilesResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadFilesResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadFilesResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadFilesResponseParams result =
            new ClipboardHostReadFilesResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = ClipboardFiles.decode(decoder1);
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

  static class ClipboardHostReadFilesResponseParamsForwardToCallback extends SideEffectFreeCloseable
      implements MessageReceiver {
    private final ClipboardHost.ReadFiles_Response mCallback;

    ClipboardHostReadFilesResponseParamsForwardToCallback(
        ClipboardHost.ReadFiles_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(8, 6)) {
          return false;
        }
        ClipboardHostReadFilesResponseParams response =
            ClipboardHostReadFilesResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ClipboardHostReadFilesResponseParamsProxyToResponder
      implements ClipboardHost.ReadFiles_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ClipboardHostReadFilesResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(ClipboardFiles result) {
      ClipboardHostReadFilesResponseParams _response = new ClipboardHostReadFilesResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(8, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ClipboardHostReadCustomDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public int buffer;
    public String16 type;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadCustomDataParams(int version) {
      super(24, version);
    }

    public ClipboardHostReadCustomDataParams() {
      this(0);
    }

    public static ClipboardHostReadCustomDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadCustomDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadCustomDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadCustomDataParams result =
            new ClipboardHostReadCustomDataParams(elementsOrVersion);
        int readInt = decoder0.readInt(8);
        result.buffer = readInt;
        ClipboardBuffer.validate(readInt);
        result.buffer = ClipboardBuffer.toKnownValue(result.buffer);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.type = String16.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.buffer, 8);
      encoder0.encode((Struct) this.type, 16, false);
    }
  }

  static final class ClipboardHostReadCustomDataResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BigString16 result;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadCustomDataResponseParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadCustomDataResponseParams() {
      this(0);
    }

    public static ClipboardHostReadCustomDataResponseParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadCustomDataResponseParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadCustomDataResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadCustomDataResponseParams result =
            new ClipboardHostReadCustomDataResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.result = BigString16.decode(decoder1);
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

  static class ClipboardHostReadCustomDataResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ClipboardHost.ReadCustomData_Response mCallback;

    ClipboardHostReadCustomDataResponseParamsForwardToCallback(
        ClipboardHost.ReadCustomData_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(9, 6)) {
          return false;
        }
        ClipboardHostReadCustomDataResponseParams response =
            ClipboardHostReadCustomDataResponseParams.deserialize(messageWithHeader.getPayload());
        this.mCallback.call(response.result);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ClipboardHostReadCustomDataResponseParamsProxyToResponder
      implements ClipboardHost.ReadCustomData_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ClipboardHostReadCustomDataResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BigString16 result) {
      ClipboardHostReadCustomDataResponseParams _response =
          new ClipboardHostReadCustomDataResponseParams();
      _response.result = result;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(9, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ClipboardHostReadAvailableCustomAndStandardFormatsParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadAvailableCustomAndStandardFormatsParams(int version) {
      super(8, version);
    }

    public ClipboardHostReadAvailableCustomAndStandardFormatsParams() {
      this(0);
    }

    public static ClipboardHostReadAvailableCustomAndStandardFormatsParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadAvailableCustomAndStandardFormatsParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadAvailableCustomAndStandardFormatsParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadAvailableCustomAndStandardFormatsParams result =
            new ClipboardHostReadAvailableCustomAndStandardFormatsParams(elementsOrVersion);
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

  static final class ClipboardHostReadAvailableCustomAndStandardFormatsResponseParams
      extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String16[] formatTypes;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadAvailableCustomAndStandardFormatsResponseParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadAvailableCustomAndStandardFormatsResponseParams() {
      this(0);
    }

    public static ClipboardHostReadAvailableCustomAndStandardFormatsResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadAvailableCustomAndStandardFormatsResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadAvailableCustomAndStandardFormatsResponseParams decode(
        Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadAvailableCustomAndStandardFormatsResponseParams result =
            new ClipboardHostReadAvailableCustomAndStandardFormatsResponseParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.formatTypes = new String16[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.formatTypes[i1] = String16.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      String16[] string16Arr = this.formatTypes;
      if (string16Arr == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(string16Arr.length, 8, -1);
      int i0 = 0;
      while (true) {
        String16[] string16Arr2 = this.formatTypes;
        if (i0 < string16Arr2.length) {
          encoder1.encode((Struct) string16Arr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }

  static class ClipboardHostReadAvailableCustomAndStandardFormatsResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ClipboardHost.ReadAvailableCustomAndStandardFormats_Response mCallback;

    ClipboardHostReadAvailableCustomAndStandardFormatsResponseParamsForwardToCallback(
        ClipboardHost.ReadAvailableCustomAndStandardFormats_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(10, 6)) {
          return false;
        }
        ClipboardHostReadAvailableCustomAndStandardFormatsResponseParams response =
            ClipboardHostReadAvailableCustomAndStandardFormatsResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.formatTypes);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ClipboardHostReadAvailableCustomAndStandardFormatsResponseParamsProxyToResponder
      implements ClipboardHost.ReadAvailableCustomAndStandardFormats_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ClipboardHostReadAvailableCustomAndStandardFormatsResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(String16[] formatTypes) {
      ClipboardHostReadAvailableCustomAndStandardFormatsResponseParams _response =
          new ClipboardHostReadAvailableCustomAndStandardFormatsResponseParams();
      _response.formatTypes = formatTypes;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(10, 6, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ClipboardHostReadUnsanitizedCustomFormatParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 format;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadUnsanitizedCustomFormatParams(int version) {
      super(16, version);
    }

    public ClipboardHostReadUnsanitizedCustomFormatParams() {
      this(0);
    }

    public static ClipboardHostReadUnsanitizedCustomFormatParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadUnsanitizedCustomFormatParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadUnsanitizedCustomFormatParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadUnsanitizedCustomFormatParams result =
            new ClipboardHostReadUnsanitizedCustomFormatParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.format = String16.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.format, 8, false);
    }
  }

  static final class ClipboardHostReadUnsanitizedCustomFormatResponseParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BigBuffer data;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostReadUnsanitizedCustomFormatResponseParams(int version) {
      super(24, version);
    }

    public ClipboardHostReadUnsanitizedCustomFormatResponseParams() {
      this(0);
    }

    public static ClipboardHostReadUnsanitizedCustomFormatResponseParams deserialize(
        Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostReadUnsanitizedCustomFormatResponseParams deserialize(
        ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostReadUnsanitizedCustomFormatResponseParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostReadUnsanitizedCustomFormatResponseParams result =
            new ClipboardHostReadUnsanitizedCustomFormatResponseParams(elementsOrVersion);
        result.data = BigBuffer.decode(decoder0, 8);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Union) this.data, 8, false);
    }
  }

  static class ClipboardHostReadUnsanitizedCustomFormatResponseParamsForwardToCallback
      extends SideEffectFreeCloseable implements MessageReceiver {
    private final ClipboardHost.ReadUnsanitizedCustomFormat_Response mCallback;

    ClipboardHostReadUnsanitizedCustomFormatResponseParamsForwardToCallback(
        ClipboardHost.ReadUnsanitizedCustomFormat_Response callback) {
      this.mCallback = callback;
    }

    @Override
    public boolean accept(Message message) {
      try {
        ServiceMessage messageWithHeader = message.asServiceMessage();
        MessageHeader header = messageWithHeader.getHeader();
        if (!header.validateHeader(11, 2)) {
          return false;
        }
        ClipboardHostReadUnsanitizedCustomFormatResponseParams response =
            ClipboardHostReadUnsanitizedCustomFormatResponseParams.deserialize(
                messageWithHeader.getPayload());
        this.mCallback.call(response.data);
        return true;
      } catch (DeserializationException e) {
        return false;
      }
    }
  }

  static class ClipboardHostReadUnsanitizedCustomFormatResponseParamsProxyToResponder
      implements ClipboardHost.ReadUnsanitizedCustomFormat_Response {
    private final Core mCore;
    private final MessageReceiver mMessageReceiver;
    private final long mRequestId;

    ClipboardHostReadUnsanitizedCustomFormatResponseParamsProxyToResponder(
        Core core, MessageReceiver messageReceiver, long requestId) {
      this.mCore = core;
      this.mMessageReceiver = messageReceiver;
      this.mRequestId = requestId;
    }

    @Override
    public void call(BigBuffer data) {
      ClipboardHostReadUnsanitizedCustomFormatResponseParams _response =
          new ClipboardHostReadUnsanitizedCustomFormatResponseParams();
      _response.data = data;
      ServiceMessage _message =
          _response.serializeWithHeader(this.mCore, new MessageHeader(11, 2, this.mRequestId));
      this.mMessageReceiver.accept(_message);
    }
  }

  static final class ClipboardHostWriteTextParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BigString16 text;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostWriteTextParams(int version) {
      super(16, version);
    }

    public ClipboardHostWriteTextParams() {
      this(0);
    }

    public static ClipboardHostWriteTextParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostWriteTextParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostWriteTextParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostWriteTextParams result = new ClipboardHostWriteTextParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.text = BigString16.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.text, 8, false);
    }
  }

  static final class ClipboardHostWriteHtmlParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public BigString16 markup;
    public Url url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostWriteHtmlParams(int version) {
      super(24, version);
    }

    public ClipboardHostWriteHtmlParams() {
      this(0);
    }

    public static ClipboardHostWriteHtmlParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostWriteHtmlParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostWriteHtmlParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostWriteHtmlParams result = new ClipboardHostWriteHtmlParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.markup = BigString16.decode(decoder1);
        Decoder decoder12 = decoder0.readPointer(16, false);
        result.url = Url.decode(decoder12);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.markup, 8, false);
      encoder0.encode((Struct) this.url, 16, false);
    }
  }

  static final class ClipboardHostWriteSvgParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BigString16 markup;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostWriteSvgParams(int version) {
      super(16, version);
    }

    public ClipboardHostWriteSvgParams() {
      this(0);
    }

    public static ClipboardHostWriteSvgParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostWriteSvgParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostWriteSvgParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostWriteSvgParams result = new ClipboardHostWriteSvgParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.markup = BigString16.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.markup, 8, false);
    }
  }

  static final class ClipboardHostWriteSmartPasteMarkerParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostWriteSmartPasteMarkerParams(int version) {
      super(8, version);
    }

    public ClipboardHostWriteSmartPasteMarkerParams() {
      this(0);
    }

    public static ClipboardHostWriteSmartPasteMarkerParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostWriteSmartPasteMarkerParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostWriteSmartPasteMarkerParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostWriteSmartPasteMarkerParams result =
            new ClipboardHostWriteSmartPasteMarkerParams(elementsOrVersion);
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

  static final class ClipboardHostWriteCustomDataParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public Map<String16, BigString16> data;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostWriteCustomDataParams(int version) {
      super(16, version);
    }

    public ClipboardHostWriteCustomDataParams() {
      this(0);
    }

    public static ClipboardHostWriteCustomDataParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostWriteCustomDataParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostWriteCustomDataParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostWriteCustomDataParams result =
            new ClipboardHostWriteCustomDataParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        decoder1.readDataHeaderForMap();
        Decoder decoder2 = decoder1.readPointer(8, false);
        DataHeader si2 = decoder2.readDataHeaderForPointerArray(-1);
        String16[] keys0 = new String16[si2.elementsOrVersion];
        for (int i2 = 0; i2 < si2.elementsOrVersion; i2++) {
          Decoder decoder3 = decoder2.readPointer((i2 * 8) + 8, false);
          keys0[i2] = String16.decode(decoder3);
        }
        Decoder decoder22 = decoder1.readPointer(16, false);
        DataHeader si22 = decoder22.readDataHeaderForPointerArray(keys0.length);
        BigString16[] values0 = new BigString16[si22.elementsOrVersion];
        for (int i22 = 0; i22 < si22.elementsOrVersion; i22++) {
          Decoder decoder32 = decoder22.readPointer((i22 * 8) + 8, false);
          values0[i22] = BigString16.decode(decoder32);
        }
        result.data = new HashMap();
        for (int index0 = 0; index0 < keys0.length; index0++) {
          result.data.put(keys0[index0], values0[index0]);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      if (this.data == null) {
        encoder0.encodeNullPointer(8, false);
        return;
      }
      Encoder encoder1 = encoder0.encoderForMap(8);
      int size0 = this.data.size();
      String16[] keys0 = new String16[size0];
      BigString16[] values0 = new BigString16[size0];
      int index0 = 0;
      for (Map.Entry<String16, BigString16> entry0 : this.data.entrySet()) {
        keys0[index0] = entry0.getKey();
        values0[index0] = entry0.getValue();
        index0++;
      }
      Encoder encoder2 = encoder1.encodePointerArray(keys0.length, 8, -1);
      for (int i1 = 0; i1 < keys0.length; i1++) {
        encoder2.encode((Struct) keys0[i1], (i1 * 8) + 8, false);
      }
      Encoder encoder22 = encoder1.encodePointerArray(values0.length, 16, -1);
      for (int i12 = 0; i12 < values0.length; i12++) {
        encoder22.encode((Struct) values0[i12], (i12 * 8) + 8, false);
      }
    }
  }

  static final class ClipboardHostWriteBookmarkParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 24;
    private static final DataHeader[] VERSION_ARRAY;
    public String16 title;
    public String url;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(24, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostWriteBookmarkParams(int version) {
      super(24, version);
    }

    public ClipboardHostWriteBookmarkParams() {
      this(0);
    }

    public static ClipboardHostWriteBookmarkParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostWriteBookmarkParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostWriteBookmarkParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostWriteBookmarkParams result =
            new ClipboardHostWriteBookmarkParams(elementsOrVersion);
        result.url = decoder0.readString(8, false);
        Decoder decoder1 = decoder0.readPointer(16, false);
        result.title = String16.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode(this.url, 8, false);
      encoder0.encode((Struct) this.title, 16, false);
    }
  }

  static final class ClipboardHostWriteImageParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 16;
    private static final DataHeader[] VERSION_ARRAY;
    public BitmapN32 image;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(16, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostWriteImageParams(int version) {
      super(16, version);
    }

    public ClipboardHostWriteImageParams() {
      this(0);
    }

    public static ClipboardHostWriteImageParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostWriteImageParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostWriteImageParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostWriteImageParams result = new ClipboardHostWriteImageParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.image = BitmapN32.decode(decoder1);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.image, 8, false);
    }
  }

  static final class ClipboardHostWriteUnsanitizedCustomFormatParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public BigBuffer data;
    public String16 format;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostWriteUnsanitizedCustomFormatParams(int version) {
      super(32, version);
    }

    public ClipboardHostWriteUnsanitizedCustomFormatParams() {
      this(0);
    }

    public static ClipboardHostWriteUnsanitizedCustomFormatParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostWriteUnsanitizedCustomFormatParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostWriteUnsanitizedCustomFormatParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostWriteUnsanitizedCustomFormatParams result =
            new ClipboardHostWriteUnsanitizedCustomFormatParams(elementsOrVersion);
        Decoder decoder1 = decoder0.readPointer(8, false);
        result.format = String16.decode(decoder1);
        result.data = BigBuffer.decode(decoder0, 16);
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((Struct) this.format, 8, false);
      encoder0.encode((Union) this.data, 16, false);
    }
  }

  static final class ClipboardHostCommitWriteParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 8;
    private static final DataHeader[] VERSION_ARRAY;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(8, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ClipboardHostCommitWriteParams(int version) {
      super(8, version);
    }

    public ClipboardHostCommitWriteParams() {
      this(0);
    }

    public static ClipboardHostCommitWriteParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ClipboardHostCommitWriteParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ClipboardHostCommitWriteParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ClipboardHostCommitWriteParams result =
            new ClipboardHostCommitWriteParams(elementsOrVersion);
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
