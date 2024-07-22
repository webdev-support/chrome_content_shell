package org.chromium.blink.test.mojom;

import org.chromium.mojo.bindings.Interface;

public interface FederatedAuthRequestAutomation extends Interface {
  public static final Interface.Manager<FederatedAuthRequestAutomation, Proxy> MANAGER =
      FederatedAuthRequestAutomation_Internal.MANAGER;

  public interface ClickFedCmDialogButton_Response {
    void call(boolean z);
  }

  public interface DismissFedCmDialog_Response {
    void call(boolean z);
  }

  public interface GetDialogType_Response {
    void call(String str);
  }

  public interface GetFedCmDialogTitle_Response {
    void call(String str);
  }

  public interface Proxy extends FederatedAuthRequestAutomation, Interface.Proxy {}

  public interface SelectFedCmAccount_Response {
    void call(boolean z);
  }

  void clickFedCmDialogButton(
      int i, ClickFedCmDialogButton_Response clickFedCmDialogButton_Response);

  void dismissFedCmDialog(DismissFedCmDialog_Response dismissFedCmDialog_Response);

  void getDialogType(GetDialogType_Response getDialogType_Response);

  void getFedCmDialogTitle(GetFedCmDialogTitle_Response getFedCmDialogTitle_Response);

  void selectFedCmAccount(int i, SelectFedCmAccount_Response selectFedCmAccount_Response);
}
