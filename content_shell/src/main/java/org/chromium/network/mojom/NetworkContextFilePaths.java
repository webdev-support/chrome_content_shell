package org.chromium.network.mojom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.bindings.Union;
import org.chromium.mojo_base.mojom.FilePath;

public final class NetworkContextFilePaths extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  private static final int STRUCT_SIZE = 120;
  private static final DataHeader[] VERSION_ARRAY;
  public FilePath cookieDatabaseName;
  public TransferableDirectory dataDirectory;
  public TransferableDirectory httpCacheDirectory;
  public FilePath httpServerPropertiesFileName;
  public FilePath reportingAndNelStoreDatabaseName;
  public FilePath sctAuditingPendingReportsFileName;
  public TransferableDirectory sharedDictionaryDirectory;
  public FilePath transportSecurityPersisterFileName;
  public boolean triggerMigration;
  public FilePath trustTokenDatabaseName;
  public FilePath unsandboxedDataPath;

  static {
    DataHeader[] dataHeaderArr = {new DataHeader(120, 0)};
    VERSION_ARRAY = dataHeaderArr;
    DEFAULT_STRUCT_INFO = dataHeaderArr[0];
  }

  private NetworkContextFilePaths(int version) {
    super(120, version);
    this.triggerMigration = false;
  }

  public NetworkContextFilePaths() {
    this(0);
  }

  public static NetworkContextFilePaths deserialize(Message message) {
    return decode(new Decoder(message));
  }

  public static NetworkContextFilePaths deserialize(ByteBuffer data) {
    return deserialize(new Message(data, new ArrayList()));
  }

  public static NetworkContextFilePaths decode(Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    try {
      DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      int elementsOrVersion = mainDataHeader.elementsOrVersion;
      NetworkContextFilePaths result = new NetworkContextFilePaths(elementsOrVersion);
      result.sharedDictionaryDirectory = TransferableDirectory.decode(decoder0, 8);
      result.httpCacheDirectory = TransferableDirectory.decode(decoder0, 24);
      result.dataDirectory = TransferableDirectory.decode(decoder0, 40);
      Decoder decoder1 = decoder0.readPointer(56, true);
      result.unsandboxedDataPath = FilePath.decode(decoder1);
      Decoder decoder12 = decoder0.readPointer(64, true);
      result.cookieDatabaseName = FilePath.decode(decoder12);
      Decoder decoder13 = decoder0.readPointer(72, true);
      result.trustTokenDatabaseName = FilePath.decode(decoder13);
      Decoder decoder14 = decoder0.readPointer(80, true);
      result.httpServerPropertiesFileName = FilePath.decode(decoder14);
      Decoder decoder15 = decoder0.readPointer(88, true);
      result.transportSecurityPersisterFileName = FilePath.decode(decoder15);
      Decoder decoder16 = decoder0.readPointer(96, true);
      result.reportingAndNelStoreDatabaseName = FilePath.decode(decoder16);
      Decoder decoder17 = decoder0.readPointer(104, true);
      result.sctAuditingPendingReportsFileName = FilePath.decode(decoder17);
      result.triggerMigration = decoder0.readBoolean(112, 0);
      return result;
    } finally {
      decoder0.decreaseStackDepth();
    }
  }

  @Override
  public final void encode(Encoder encoder) {
    Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    encoder0.encode((Union) this.sharedDictionaryDirectory, 8, true);
    encoder0.encode((Union) this.httpCacheDirectory, 24, true);
    encoder0.encode((Union) this.dataDirectory, 40, false);
    encoder0.encode((Struct) this.unsandboxedDataPath, 56, true);
    encoder0.encode((Struct) this.cookieDatabaseName, 64, true);
    encoder0.encode((Struct) this.trustTokenDatabaseName, 72, true);
    encoder0.encode((Struct) this.httpServerPropertiesFileName, 80, true);
    encoder0.encode((Struct) this.transportSecurityPersisterFileName, 88, true);
    encoder0.encode((Struct) this.reportingAndNelStoreDatabaseName, 96, true);
    encoder0.encode((Struct) this.sctAuditingPendingReportsFileName, 104, true);
    encoder0.encode(this.triggerMigration, 112, 0);
  }
}
