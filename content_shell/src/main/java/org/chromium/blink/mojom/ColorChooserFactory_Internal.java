package org.chromium.blink.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.InterfaceRequest;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.MessageReceiverWithResponder;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Core;

class ColorChooserFactory_Internal {
  public static final Interface.Manager<ColorChooserFactory, ColorChooserFactory.Proxy> MANAGER =
      new Interface.Manager<ColorChooserFactory, ColorChooserFactory.Proxy>() {
        @Override
        public String getName() {
          return "blink.mojom.ColorChooserFactory";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public ColorChooserFactory.Proxy buildProxy(
            Core core, MessageReceiverWithResponder messageReceiver) {
          return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(Core core, ColorChooserFactory impl) {
          return new Stub(core, impl);
        }

        @Override
        public ColorChooserFactory[] buildArray(int size) {
          return new ColorChooserFactory[size];
        }
      };
  private static final int OPEN_COLOR_CHOOSER_ORDINAL = 0;

  ColorChooserFactory_Internal() {}

  public static final class Proxy extends Interface.AbstractProxy
      implements ColorChooserFactory.Proxy {
    @Override
    public HandlerImpl getProxyHandler() {
      return super.getProxyHandler();
    }

    Proxy(Core core, MessageReceiverWithResponder messageReceiver) {
      super(core, messageReceiver);
    }

    @Override
    public void openColorChooser(
        InterfaceRequest<ColorChooser> chooser,
        ColorChooserClient client,
        int color,
        ColorSuggestion[] suggestions) {
      ColorChooserFactoryOpenColorChooserParams _message =
          new ColorChooserFactoryOpenColorChooserParams();
      _message.chooser = chooser;
      _message.client = client;
      _message.color = color;
      _message.suggestions = suggestions;
      getProxyHandler()
          .getMessageReceiver()
          .accept(_message.serializeWithHeader(getProxyHandler().getCore(), new MessageHeader(0)));
    }
  }

  public static final class Stub extends Interface.Stub<ColorChooserFactory> {
    Stub(Core core, ColorChooserFactory impl) {
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
                ColorChooserFactory_Internal.MANAGER, messageWithHeader);
          case -1:
          default:
            return false;
          case 0:
            ColorChooserFactoryOpenColorChooserParams data =
                ColorChooserFactoryOpenColorChooserParams.deserialize(
                    messageWithHeader.getPayload());
            getImpl().openColorChooser(data.chooser, data.client, data.color, data.suggestions);
            return true;
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
                getCore(), ColorChooserFactory_Internal.MANAGER, messageWithHeader, receiver);
          default:
            return false;
        }
      } catch (DeserializationException e) {
        System.err.println(e.toString());
        return false;
      }
    }
  }

  static final class ColorChooserFactoryOpenColorChooserParams extends Struct {
    private static final DataHeader DEFAULT_STRUCT_INFO;
    private static final int STRUCT_SIZE = 32;
    private static final DataHeader[] VERSION_ARRAY;
    public InterfaceRequest<ColorChooser> chooser;
    public ColorChooserClient client;
    public int color;
    public ColorSuggestion[] suggestions;

    static {
      DataHeader[] dataHeaderArr = {new DataHeader(32, 0)};
      VERSION_ARRAY = dataHeaderArr;
      DEFAULT_STRUCT_INFO = dataHeaderArr[0];
    }

    private ColorChooserFactoryOpenColorChooserParams(int version) {
      super(32, version);
    }

    public ColorChooserFactoryOpenColorChooserParams() {
      this(0);
    }

    public static ColorChooserFactoryOpenColorChooserParams deserialize(Message message) {
      return decode(new Decoder(message));
    }

    public static ColorChooserFactoryOpenColorChooserParams deserialize(ByteBuffer data) {
      return deserialize(new Message(data, new ArrayList()));
    }

    public static ColorChooserFactoryOpenColorChooserParams decode(Decoder decoder0) {
      if (decoder0 == null) {
        return null;
      }
      decoder0.increaseStackDepth();
      try {
        DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
        int elementsOrVersion = mainDataHeader.elementsOrVersion;
        ColorChooserFactoryOpenColorChooserParams result =
            new ColorChooserFactoryOpenColorChooserParams(elementsOrVersion);
        result.chooser = decoder0.readInterfaceRequest(8, false);
        result.client =
            (ColorChooserClient)
                decoder0.readServiceInterface(12, false, ColorChooserClient.MANAGER);
        result.color = decoder0.readInt(20);
        Decoder decoder1 = decoder0.readPointer(24, false);
        DataHeader si1 = decoder1.readDataHeaderForPointerArray(-1);
        result.suggestions = new ColorSuggestion[si1.elementsOrVersion];
        for (int i1 = 0; i1 < si1.elementsOrVersion; i1++) {
          Decoder decoder2 = decoder1.readPointer((i1 * 8) + 8, false);
          result.suggestions[i1] = ColorSuggestion.decode(decoder2);
        }
        return result;
      } finally {
        decoder0.decreaseStackDepth();
      }
    }

    @Override
    public final void encode(Encoder encoder) {
      Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
      encoder0.encode((InterfaceRequest) this.chooser, 8, false);
      encoder0.encode(this.client, 12, false, ColorChooserClient.MANAGER);
      encoder0.encode(this.color, 20);
      ColorSuggestion[] colorSuggestionArr = this.suggestions;
      if (colorSuggestionArr == null) {
        encoder0.encodeNullPointer(24, false);
        return;
      }
      Encoder encoder1 = encoder0.encodePointerArray(colorSuggestionArr.length, 24, -1);
      int i0 = 0;
      while (true) {
        ColorSuggestion[] colorSuggestionArr2 = this.suggestions;
        if (i0 < colorSuggestionArr2.length) {
          encoder1.encode((Struct) colorSuggestionArr2[i0], (i0 * 8) + 8, false);
          i0++;
        } else {
          return;
        }
      }
    }
  }
}
