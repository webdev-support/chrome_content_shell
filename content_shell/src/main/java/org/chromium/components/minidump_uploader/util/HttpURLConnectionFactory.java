package org.chromium.components.minidump_uploader.util;

import java.net.HttpURLConnection;

public interface HttpURLConnectionFactory {
  HttpURLConnection createHttpURLConnection(String str);
}
