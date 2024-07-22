package org.chromium.content.browser.selection;

import android.graphics.Rect;

public interface PastePopupMenu {

  public interface PastePopupMenuDelegate {
    boolean canPaste();

    boolean canPasteAsPlainText();

    boolean canSelectAll();

    void paste();

    void pasteAsPlainText();

    void selectAll();
  }

  void hide();

  void show(Rect rect);
}
