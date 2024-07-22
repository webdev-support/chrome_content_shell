package org.chromium.content.browser.input;

import android.text.Editable;
import android.text.Selection;
import android.util.StringBuilderPrinter;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.EditorInfo;
import androidx.core.view.inputmethod.EditorInfoCompat;
import java.util.Locale;
import org.chromium.base.ThreadUtils;

public class ImeUtils {
  public static void computeEditorInfo(
      int inputType,
      int inputFlags,
      int inputMode,
      int inputAction,
      int initialSelStart,
      int initialSelEnd,
      String lastText,
      EditorInfo outAttrs) {
    outAttrs.inputType = 161;
    if ((inputFlags & 2) != 0) {
      outAttrs.inputType |= 524288;
    }
    if (inputMode == 0) {
      if (inputType != 1) {
        if (inputType == 14 || inputType == 15) {
          outAttrs.inputType |= 131072;
          if ((inputFlags & 8) == 0) {
            outAttrs.inputType |= 32768;
          }
        } else if (inputType != 2) {
          if (inputType != 7) {
            if (inputType != 4) {
              if (inputType != 6) {
                if (inputType == 5) {
                  outAttrs.inputType = 8194;
                }
              } else {
                outAttrs.inputType = 3;
              }
            } else {
              outAttrs.inputType = 209;
            }
          } else {
            outAttrs.inputType = 17;
          }
        } else {
          outAttrs.inputType = 225;
        }
      } else if ((inputFlags & 8) == 0) {
        outAttrs.inputType |= 32768;
      }
    } else {
      switch (inputMode) {
        case 3:
          outAttrs.inputType = 3;
          break;
        case 4:
          outAttrs.inputType = 17;
          break;
        case 5:
          outAttrs.inputType = 209;
          break;
        case 6:
          outAttrs.inputType = 2;
          if (inputType == 2 || (inputFlags & 4096) != 0) {
            outAttrs.inputType |= 16;
            break;
          }
          break;
        case 7:
          outAttrs.inputType = 8194;
          break;
        default:
          outAttrs.inputType |= 131072;
          if ((inputFlags & 8) == 0) {
            outAttrs.inputType |= 32768;
            break;
          }
          break;
      }
    }
    outAttrs.imeOptions |=
        getImeAction(
            inputType, inputFlags, inputMode, inputAction, (outAttrs.inputType & 131072) != 0);
    if ((inputFlags & 128) != 0) {
      outAttrs.inputType |= 4096;
    } else if ((inputFlags & 256) != 0) {
      outAttrs.inputType |= 8192;
    } else if ((inputFlags & 512) != 0) {
      outAttrs.inputType |= 16384;
    }
    if ((inputFlags & 4096) != 0 && (outAttrs.inputType & 16) == 0) {
      outAttrs.inputType = 225;
    }
    outAttrs.initialSelStart = initialSelStart;
    outAttrs.initialSelEnd = initialSelEnd;
    EditorInfoCompat.setInitialSurroundingText(outAttrs, lastText);
  }

  private static int getImeAction(
      int inputType, int inputFlags, int inputMode, int inputAction, boolean isMultiLineInput) {
    if (inputAction == 0) {
      if (inputMode == 0 && inputType == 3) {
        int imeAction = 0 | 3;
        return imeAction;
      } else if (isMultiLineInput) {
        int imeAction2 = 0 | 1;
        return imeAction2;
      } else if ((inputFlags & 1024) != 0) {
        int imeAction3 = 0 | 5;
        return imeAction3;
      } else {
        int imeAction4 = 0 | 2;
        return imeAction4;
      }
    }
    switch (inputAction) {
      case 1:
        int imeAction5 = 0 | 1;
        return imeAction5;
      case 2:
        int imeAction6 = 0 | 6;
        return imeAction6;
      case 3:
        int imeAction7 = 0 | 2;
        return imeAction7;
      case 4:
        int imeAction8 = 0 | 5;
        return imeAction8;
      case 5:
        int imeAction9 = 0 | 7;
        return imeAction9;
      case 6:
        int imeAction10 = 0 | 3;
        return imeAction10;
      case 7:
        int imeAction11 = 0 | 4;
        return imeAction11;
      default:
        return 0;
    }
  }

  static String getEditorInfoDebugString(EditorInfo editorInfo) {
    StringBuilder builder = new StringBuilder();
    StringBuilderPrinter printer = new StringBuilderPrinter(builder);
    editorInfo.dump(printer, "");
    return builder.toString();
  }

  static String getEditableDebugString(Editable editable) {
    return String.format(
        Locale.US,
        "Editable {[%s] SEL[%d %d] COM[%d %d]}",
        editable.toString(),
        Integer.valueOf(Selection.getSelectionStart(editable)),
        Integer.valueOf(Selection.getSelectionEnd(editable)),
        Integer.valueOf(BaseInputConnection.getComposingSpanStart(editable)),
        Integer.valueOf(BaseInputConnection.getComposingSpanEnd(editable)));
  }

  static String getCorrectionInfoDebugString(CorrectionInfo correctionInfo) {
    return correctionInfo.toString();
  }

  public static void checkCondition(boolean condition) {
    if (!condition) {
      throw new AssertionError();
    }
  }

  static void checkCondition(String msg, boolean condition) {
    if (!condition) {
      throw new AssertionError(msg);
    }
  }

  public static void checkOnUiThread() {
    checkCondition("Should be on UI thread.", ThreadUtils.runningOnUiThread());
  }
}
