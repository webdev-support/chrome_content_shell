package org.chromium.components.minidump_uploader;

import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.GZIPOutputStream;
import org.chromium.components.minidump_uploader.util.HttpURLConnectionFactory;
import org.chromium.components.minidump_uploader.util.HttpURLConnectionFactoryImpl;
import org.chromium.components.variations.VariationsCompressionUtils;

public class MinidumpUploader {
  static final String CONTENT_TYPE_TMPL = "multipart/form-data; boundary=%s";
  static final String CRASH_URL_STRING = "https://clients2.google.com/cr/report";
  private final HttpURLConnectionFactory mHttpURLConnectionFactory;

  public static final class Result {

    private final int mErrorCode;
    private final String mResult;

    private Result(int errorCode, String result) {
      this.mErrorCode = errorCode;
      this.mResult = result;
    }

    public boolean isSuccess() {
      return this.mErrorCode == 0;
    }

    public boolean isUploadError() {
      return this.mErrorCode > 0;
    }

    public boolean isFailure() {
      return this.mErrorCode < 0;
    }

    public int errorCode() {
      return this.mErrorCode;
    }

    public String message() {
      return this.mResult;
    }

    static Result failure(String result) {
      return new Result(-1, result);
    }

    static Result uploadError(int status, String result) {
      if (status <= 0) {
        throw new AssertionError();
      }
      return new Result(status, result);
    }

    static Result success(String result) {
      return new Result(0, result);
    }
  }

  public MinidumpUploader() {
    this(new HttpURLConnectionFactoryImpl());
  }

  public MinidumpUploader(HttpURLConnectionFactory httpURLConnectionFactory) {
    this.mHttpURLConnectionFactory = httpURLConnectionFactory;
  }

  public Result upload(File fileToUpload) {
    if (fileToUpload != null) {
      try {
        if (fileToUpload.exists()) {
          HttpURLConnection connection =
              this.mHttpURLConnectionFactory.createHttpURLConnection(CRASH_URL_STRING);
          if (connection == null) {
            return Result.failure("Failed to create connection");
          }
          configureConnectionForHttpPost(connection, readBoundary(fileToUpload));
          try {
            InputStream minidumpInputStream = new FileInputStream(fileToUpload);
            OutputStream requestBodyStream = new GZIPOutputStream(connection.getOutputStream());
            streamCopy(minidumpInputStream, requestBodyStream);
            int responseCode = connection.getResponseCode();
            if (isSuccessful(responseCode)) {
              String responseContent = getResponseContentAsString(connection);
              String uploadId = responseContent != null ? responseContent : "unknown";
              Result success = Result.success(uploadId);
              requestBodyStream.close();
              minidumpInputStream.close();
              return success;
            }
            Result uploadError = Result.uploadError(responseCode, connection.getResponseMessage());
            requestBodyStream.close();
            minidumpInputStream.close();
            return uploadError;
          } finally {
            connection.disconnect();
          }
        }
      } catch (IOException | RuntimeException e) {
        return Result.failure(e.toString());
      }
    }
    return Result.failure("Crash report does not exist");
  }

  private void configureConnectionForHttpPost(HttpURLConnection connection, String boundary) {
    connection.setDoOutput(true);
    connection.setRequestProperty("Connection", HttpHeaders.KEEP_ALIVE);
    connection.setRequestProperty(
        "Content-Encoding", VariationsCompressionUtils.GZIP_COMPRESSION_HEADER);
    connection.setRequestProperty("Content-Type", String.format(CONTENT_TYPE_TMPL, boundary));
  }

  private String readBoundary(File fileToUpload) throws IOException {
    FileReader fileReader = new FileReader(fileToUpload);
    try {
      BufferedReader reader = new BufferedReader(fileReader);
      String boundary = reader.readLine();
      if (boundary == null || boundary.trim().isEmpty()) {
        throw new RuntimeException("File does not have a MIME boundary");
      }
      String boundary2 = boundary.trim();
      if (!boundary2.startsWith("--") || boundary2.length() < 10) {
        throw new RuntimeException("File does not have a MIME boundary");
      }
      if (!boundary2.matches("^[a-zA-Z0-9-]*$")) {
        throw new RuntimeException("File has an illegal MIME boundary: " + boundary2);
      }
      String boundary3 = boundary2.substring(2);
      reader.close();
      fileReader.close();
      return boundary3;
    } catch (Throwable th) {
      try {
        fileReader.close();
      } catch (Throwable th2) {
        th.addSuppressed(th2);
      }
      throw th;
    }
  }

  private boolean isSuccessful(int responseCode) {
    return responseCode == 200 || responseCode == 201 || responseCode == 202;
  }

  private String getResponseContentAsString(HttpURLConnection connection) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    streamCopy(connection.getInputStream(), baos);
    if (baos.size() == 0) {
      return null;
    }
    return baos.toString();
  }

  private void streamCopy(InputStream inStream, OutputStream outStream) throws IOException {
    byte[] temp = new byte[4096];
    int bytesRead = inStream.read(temp);
    while (bytesRead >= 0) {
      outStream.write(temp, 0, bytesRead);
      bytesRead = inStream.read(temp);
    }
    inStream.close();
    outStream.close();
  }
}
