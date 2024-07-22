package org.chromium.content_shell.hanlder;

import org.chromium.content_public.browser.MessagePayload;
import org.chromium.content_public.browser.WebContents;

public interface InterfaceHanlder {
  public void onMessage(MessagePayload messagePayload, WebContents webContents);
}
