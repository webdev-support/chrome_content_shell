package org.chromium.device.mojom;

import java.util.Map;
import org.chromium.mojo.bindings.Interface;

public interface Fingerprint extends Interface {
  public static final Interface.Manager<Fingerprint, Proxy> MANAGER = Fingerprint_Internal.MANAGER;

  public interface CancelCurrentEnrollSession_Response {
    void call(boolean z);
  }

  public interface DestroyAllRecords_Response {
    void call(boolean z);
  }

  public interface EndCurrentAuthSession_Response {
    void call(boolean z);
  }

  public interface GetRecordsForUser_Response {
    void call(Map<String, String> map, boolean z);
  }

  public interface Proxy extends Fingerprint, Interface.Proxy {}

  public interface RemoveRecord_Response {
    void call(boolean z);
  }

  public interface RequestRecordLabel_Response {
    void call(String str);
  }

  public interface RequestType_Response {
    void call(int i);
  }

  public interface SetRecordLabel_Response {
    void call(boolean z);
  }

  void addFingerprintObserver(FingerprintObserver fingerprintObserver);

  void cancelCurrentEnrollSession(
      CancelCurrentEnrollSession_Response cancelCurrentEnrollSession_Response);

  void destroyAllRecords(DestroyAllRecords_Response destroyAllRecords_Response);

  void endCurrentAuthSession(EndCurrentAuthSession_Response endCurrentAuthSession_Response);

  void getRecordsForUser(String str, GetRecordsForUser_Response getRecordsForUser_Response);

  void removeRecord(String str, RemoveRecord_Response removeRecord_Response);

  void requestRecordLabel(String str, RequestRecordLabel_Response requestRecordLabel_Response);

  void requestType(RequestType_Response requestType_Response);

  void setRecordLabel(String str, String str2, SetRecordLabel_Response setRecordLabel_Response);

  void startAuthSession();

  void startEnrollSession(String str, String str2);
}
