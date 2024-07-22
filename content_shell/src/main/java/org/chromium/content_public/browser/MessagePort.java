package org.chromium.content_public.browser;

import android.os.Handler;
import org.chromium.content.browser.AppWebMessagePort;

public interface MessagePort {

  public interface MessageCallback {
    void onMessage(MessagePayload messagePayload, MessagePort[] messagePortArr);
  }

  void close();

  boolean isClosed();

  boolean isStarted();

  boolean isTransferred();

  void postMessage(MessagePayload messagePayload, MessagePort[] messagePortArr);

  void setMessageCallback(MessageCallback messageCallback, Handler handler);

  static MessagePort[] createPair() {
    return AppWebMessagePort.createPair();
  }
}
