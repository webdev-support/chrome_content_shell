package org.chromium.media.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.gfx.mojom.Rect;
import org.chromium.gfx.mojom.Size;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.TimeDelta;
import org.chromium.mojo_base.mojom.TimeTicks;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class VideoFrameMetadata extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 200;
  private static final DataHeader[] VERSION_ARRAY;
  public boolean allowOverlay;
  public TimeTicks captureBeginTime;
  public int captureCounter;
  public TimeTicks captureEndTime;
  public Rect captureUpdateRect;
  public boolean copyRequired;
  public TimeTicks decodeBeginTime;
  public TimeTicks decodeEndTime;
  public double deviceScaleFactor;
  public boolean endOfStream;
  public TimeDelta frameDuration;
  public double frameRate;
  public Long frameSequence;
  public boolean hasCaptureCounter;
  public boolean hasDeviceScaleFactor;
  public boolean hasFrameRate;
  public boolean hasPageScaleFactor;
  public boolean hasRootScrollOffsetX;
  public boolean hasRootScrollOffsetY;
  public boolean hasRtpTimestamp;
  public boolean hasTopControlsVisibleHeight;
  public boolean hwProtected;
  public boolean interactiveContent;
  public boolean isWebgpuCompatible;
  public boolean needsDetiling;
  public UnguessableToken overlayPlaneId;
  public double pageScaleFactor;
  public boolean powerEfficient;
  public TimeDelta processingTime;
  public boolean protectedVideo;
  public boolean readLockFencesEnabled;
  public TimeTicks receiveTime;
  public TimeTicks referenceTime;
  public Rect regionCaptureRect;
  public double rootScrollOffsetX;
  public double rootScrollOffsetY;
  public double rtpTimestamp;
  public Size sourceSize;
  public int subCaptureTargetVersion;
  public boolean textureOriginIsTopLeft;
  public boolean textureOwner;
  public double topControlsVisibleHeight;
  public VideoTransformation transformation;
  public TimeDelta wallclockFrameDuration;
  public boolean wantsPromotionHint;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(200, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private VideoFrameMetadata(int version) {
    super(200, version);
  }

  public VideoFrameMetadata() {
    this(0);
  }

  public static VideoFrameMetadata deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static VideoFrameMetadata deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static VideoFrameMetadata decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      VideoFrameMetadata result = new VideoFrameMetadata(elementsOrVersion);
      result.allowOverlay = decoder0.readBoolean(8, 0);
      result.hasCaptureCounter = decoder0.readBoolean(8, 1);
      result.copyRequired = decoder0.readBoolean(8, 2);
      result.endOfStream = decoder0.readBoolean(8, 3);
      result.hasFrameRate = decoder0.readBoolean(8, 4);
      result.interactiveContent = decoder0.readBoolean(8, 5);
      result.readLockFencesEnabled = decoder0.readBoolean(8, 6);
      result.textureOwner = decoder0.readBoolean(8, 7);
      result.wantsPromotionHint = decoder0.readBoolean(9, 0);
      result.protectedVideo = decoder0.readBoolean(9, 1);
      result.hwProtected = decoder0.readBoolean(9, 2);
      result.needsDetiling = decoder0.readBoolean(9, 3);
      result.isWebgpuCompatible = decoder0.readBoolean(9, 4);
      result.powerEfficient = decoder0.readBoolean(9, 5);
      result.textureOriginIsTopLeft = decoder0.readBoolean(9, 6);
      result.hasDeviceScaleFactor = decoder0.readBoolean(9, 7);
      result.hasPageScaleFactor = decoder0.readBoolean(10, 0);
      result.hasRootScrollOffsetX = decoder0.readBoolean(10, 1);
      result.hasRootScrollOffsetY = decoder0.readBoolean(10, 2);
      result.hasTopControlsVisibleHeight = decoder0.readBoolean(10, 3);
      result.hasRtpTimestamp = decoder0.readBoolean(10, 4);
      if (decoder0.readBoolean(10, 5)) {
        result.frameSequence = new Long(decoder0.readLong(192));
      } else {
        result.frameSequence = null;
      }
      result.captureCounter = decoder0.readInt(12);
      Decoder decoder1 = decoder0.readPointer(16, true);
      result.captureBeginTime = TimeTicks.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(24, true);
      result.captureEndTime = TimeTicks.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(32, true);
      result.captureUpdateRect = Rect.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(40, true);
      result.sourceSize = Size.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(48, true);
      result.regionCaptureRect = Rect.decode(decoder15);
      result.subCaptureTargetVersion = decoder0.readInt(56);
      Decoder decoder16 = decoder0.readPointer(64, true);
      result.frameDuration = TimeDelta.decode(decoder16);
      result.frameRate = decoder0.readDouble(72);
      Decoder decoder17 = decoder0.readPointer(80, true);
      result.referenceTime = TimeTicks.decode(decoder17);
      Decoder decoder18 = decoder0.readPointer(88, true);
      result.transformation = VideoTransformation.decode(decoder18);
      Decoder decoder19 = decoder0.readPointer(96, true);
      result.overlayPlaneId = UnguessableToken.decode(decoder19);
      result.deviceScaleFactor = decoder0.readDouble(104);
      result.pageScaleFactor = decoder0.readDouble(112);
      result.rootScrollOffsetX = decoder0.readDouble(120);
      result.rootScrollOffsetY = decoder0.readDouble(128);
      result.topControlsVisibleHeight = decoder0.readDouble(136);
      Decoder decoder110 = decoder0.readPointer(144, true);
      result.decodeBeginTime = TimeTicks.decode(decoder110);
      Decoder decoder111 = decoder0.readPointer(152, true);
      result.decodeEndTime = TimeTicks.decode(decoder111);
      Decoder decoder112 = decoder0.readPointer(160, true);
      result.processingTime = TimeDelta.decode(decoder112);
      result.rtpTimestamp = decoder0.readDouble(168);
      Decoder decoder113 = decoder0.readPointer(176, true);
      result.receiveTime = TimeTicks.decode(decoder113);
      Decoder decoder114 = decoder0.readPointer(184, true);
      result.wallclockFrameDuration = TimeDelta.decode(decoder114);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    long frameSequence$value;
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode(this.allowOverlay, 8, 0);
    encoder0.encode(this.hasCaptureCounter, 8, 1);
    encoder0.encode(this.copyRequired, 8, 2);
    encoder0.encode(this.endOfStream, 8, 3);
    encoder0.encode(this.hasFrameRate, 8, 4);
    encoder0.encode(this.interactiveContent, 8, 5);
    encoder0.encode(this.readLockFencesEnabled, 8, 6);
    encoder0.encode(this.textureOwner, 8, 7);
    encoder0.encode(this.wantsPromotionHint, 9, 0);
    encoder0.encode(this.protectedVideo, 9, 1);
    encoder0.encode(this.hwProtected, 9, 2);
    encoder0.encode(this.needsDetiling, 9, 3);
    encoder0.encode(this.isWebgpuCompatible, 9, 4);
    encoder0.encode(this.powerEfficient, 9, 5);
    encoder0.encode(this.textureOriginIsTopLeft, 9, 6);
    encoder0.encode(this.hasDeviceScaleFactor, 9, 7);
    encoder0.encode(this.hasPageScaleFactor, 10, 0);
    encoder0.encode(this.hasRootScrollOffsetX, 10, 1);
    encoder0.encode(this.hasRootScrollOffsetY, 10, 2);
    encoder0.encode(this.hasTopControlsVisibleHeight, 10, 3);
    encoder0.encode(this.hasRtpTimestamp, 10, 4);
    Long l = this.frameSequence;
    boolean frameSequence$flag = l != null;
    if (frameSequence$flag) {
      frameSequence$value = l.longValue();
    } else {
      frameSequence$value = 0;
    }
    encoder0.encode(frameSequence$flag, 10, 5);
    encoder0.encode(frameSequence$value, 192);
    encoder0.encode(this.captureCounter, 12);
    encoder0.encode((Struct) this.captureBeginTime, 16, true);
    encoder0.encode((Struct) this.captureEndTime, 24, true);
    encoder0.encode((Struct) this.captureUpdateRect, 32, true);
    encoder0.encode((Struct) this.sourceSize, 40, true);
    encoder0.encode((Struct) this.regionCaptureRect, 48, true);
    encoder0.encode(this.subCaptureTargetVersion, 56);
    encoder0.encode((Struct) this.frameDuration, 64, true);
    encoder0.encode(this.frameRate, 72);
    encoder0.encode((Struct) this.referenceTime, 80, true);
    encoder0.encode((Struct) this.transformation, 88, true);
    encoder0.encode((Struct) this.overlayPlaneId, 96, true);
    encoder0.encode(this.deviceScaleFactor, 104);
    encoder0.encode(this.pageScaleFactor, 112);
    encoder0.encode(this.rootScrollOffsetX, 120);
    encoder0.encode(this.rootScrollOffsetY, 128);
    encoder0.encode(this.topControlsVisibleHeight, 136);
    encoder0.encode((Struct) this.decodeBeginTime, 144, true);
    encoder0.encode((Struct) this.decodeEndTime, 152, true);
    encoder0.encode((Struct) this.processingTime, 160, true);
    encoder0.encode(this.rtpTimestamp, 168);
    encoder0.encode((Struct) this.receiveTime, 176, true);
    encoder0.encode((Struct) this.wallclockFrameDuration, 184, true);
  }
}
