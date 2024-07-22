package org.chromium.ui.text;

import android.text.Editable;
import android.text.TextWatcher;

public interface EmptyTextWatcher extends TextWatcher {
  @Override // android.text.TextWatcher
  default void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

  @Override // android.text.TextWatcher
  default void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

  @Override // android.text.TextWatcher
  default void afterTextChanged(Editable editable) {}
}
