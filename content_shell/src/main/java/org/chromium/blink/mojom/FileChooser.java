package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo_base.mojom.FilePath;

public interface FileChooser extends Interface {
  public static final Interface.Manager<FileChooser, Proxy> MANAGER = FileChooser_Internal.MANAGER;

  public interface EnumerateChosenDirectory_Response {
    void call(FileChooserResult fileChooserResult);
  }

  public interface OpenFileChooser_Response {
    void call(FileChooserResult fileChooserResult);
  }

  public interface Proxy extends FileChooser, Interface.Proxy {}

  void enumerateChosenDirectory(
      FilePath filePath, EnumerateChosenDirectory_Response enumerateChosenDirectory_Response);

  void openFileChooser(
      FileChooserParams fileChooserParams, OpenFileChooser_Response openFileChooser_Response);
}
