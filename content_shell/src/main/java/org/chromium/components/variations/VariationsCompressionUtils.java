package org.chromium.components.variations;

import com.google.protobuf.CodedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.chromium.base.Log;

public class VariationsCompressionUtils {
  public static final String DELTA_COMPRESSION_HEADER = "x-bm";
  public static final String GZIP_COMPRESSION_HEADER = "gzip";
  private static final String TAG = "VariationsUtils";

  public static class InvalidImHeaderException extends Exception {
    public InvalidImHeaderException(String msg) {
      super(msg);
    }
  }

  public static class DeltaPatchException extends Exception {
    public DeltaPatchException(String msg) {
      super(msg);
    }
  }

  public static class InstanceManipulations {
    public boolean isDeltaCompressed;
    public boolean isGzipCompressed;

    public InstanceManipulations(boolean gzipCompressed, boolean deltaCompressed) {
      this.isGzipCompressed = gzipCompressed;
      this.isDeltaCompressed = deltaCompressed;
    }
  }

  public static InstanceManipulations getInstanceManipulations(String imHeader)
      throws InvalidImHeaderException {
    List<String> manipulations = new ArrayList<>();
    if (imHeader.length() > 0) {
      manipulations = Arrays.asList(imHeader.split("\\s*,\\s*"));
    }
    int deltaIm = manipulations.indexOf(DELTA_COMPRESSION_HEADER);
    int gzipIm = manipulations.indexOf(GZIP_COMPRESSION_HEADER);
    boolean isDeltaCompressed = deltaIm >= 0;
    boolean isGzipCompressed = gzipIm >= 0;
    int numCompressions = (isDeltaCompressed ? 1 : 0) + (isGzipCompressed ? 1 : 0);
    if (numCompressions != manipulations.size()) {
      throw new InvalidImHeaderException(
          "Unrecognized instance manipulations in "
              + imHeader
              + "; only x-bm and gzip are supported");
    }
    if (isDeltaCompressed && isGzipCompressed && deltaIm > gzipIm) {
      throw new InvalidImHeaderException(
          "Unsupported instance manipulations order: expected x-bm,gzip, but received gzip,x-bm");
    }
    return new InstanceManipulations(isGzipCompressed, isDeltaCompressed);
  }

  public static byte[] gzipCompress(byte[] uncompressedData) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream =
        new ByteArrayOutputStream(uncompressedData.length);
    try {
      GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
      gzipOutputStream.write(uncompressedData);
      gzipOutputStream.close();
      byte[] byteArray = byteArrayOutputStream.toByteArray();
      gzipOutputStream.close();
      byteArrayOutputStream.close();
      return byteArray;
    } catch (Throwable th) {
      try {
        byteArrayOutputStream.close();
      } catch (Throwable th2) {
        th.addSuppressed(th2);
      }
      throw th;
    }
  }

  public static byte[] gzipUncompress(byte[] compressedData) throws IOException {
    ByteArrayInputStream byteInputStream = new ByteArrayInputStream(compressedData);
    try {
      ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
      GZIPInputStream gzipInputStream = new GZIPInputStream(byteInputStream);
      try {
        byte[] buffer = new byte[1024];
        while (true) {
          int len = gzipInputStream.read(buffer);
          if (len != -1) {
            byteOutputStream.write(buffer, 0, len);
          } else {
            gzipInputStream.close();
            byte[] byteArray = byteOutputStream.toByteArray();
            gzipInputStream.close();
            byteOutputStream.close();
            byteInputStream.close();
            return byteArray;
          }
        }
      } catch (Throwable th) {
        try {
          gzipInputStream.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
        throw th;
      }
    } catch (Throwable th3) {
      try {
        byteInputStream.close();
      } catch (Throwable th4) {
        th3.addSuppressed(th4);
      }
      throw th3;
    }
  }

  public static byte[] applyDeltaPatch(byte[] existingSeedData, byte[] deltaPatch)
      throws DeltaPatchException {
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      try {
        CodedInputStream deltaReader = CodedInputStream.newInstance(ByteBuffer.wrap(deltaPatch));
        while (!deltaReader.isAtEnd()) {
          int value = deltaReader.readUInt32();
          if (value != 0) {
            byte[] patch = deltaReader.readRawBytes(value);
            out.write(patch, 0, value);
          } else {
            int offset = deltaReader.readUInt32();
            int length = deltaReader.readUInt32();
            byte[] copy =
                Arrays.copyOfRange(existingSeedData, offset, Math.addExact(offset, length));
            out.write(copy, 0, length);
          }
        }
        byte[] byteArray = out.toByteArray();
        out.close();
        return byteArray;
      } catch (Throwable th) {
        try {
          out.close();
        } catch (Throwable th2) {
          th.addSuppressed(th2);
        }
        throw th;
      }
    } catch (IOException | ArithmeticException | ArrayIndexOutOfBoundsException e) {
      Log.w(TAG, "Delta patch failed.", (Throwable) e);
      throw new DeltaPatchException("Failed to delta patch variations seed");
    }
  }
}
