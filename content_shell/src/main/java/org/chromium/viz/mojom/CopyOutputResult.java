// CopyOutputResult.java is auto generated by mojom_bindings_generator.py, do not edit

// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/viz/public/mojom/compositing/copy_output_result.mojom
//

package org.chromium.viz.mojom;

public final class CopyOutputResult extends org.chromium.mojo.bindings.Struct {

  private static final int STRUCT_SIZE = 64;
  private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY =
      new org.chromium.mojo.bindings.DataHeader[] {
        new org.chromium.mojo.bindings.DataHeader(64, 0)
      };
  private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
  public int format;
  public int destination;
  public org.chromium.gfx.mojom.Rect rect;
  public BitmapInSharedMemory bitmap;
  public org.chromium.gpu.mojom.Mailbox mailbox;
  public org.chromium.gpu.mojom.SyncToken syncToken;
  public org.chromium.gfx.mojom.ColorSpace colorSpace;
  public TextureReleaser releaser;

  private CopyOutputResult(int version) {
    super(STRUCT_SIZE, version);
  }

  public CopyOutputResult() {
    this(0);
  }

  public static CopyOutputResult deserialize(org.chromium.mojo.bindings.Message message) {
    return decode(new org.chromium.mojo.bindings.Decoder(message));
  }

  /**
   * Similar to the method above, but deserializes from a |ByteBuffer| instance.
   *
   * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
   */
  public static CopyOutputResult deserialize(java.nio.ByteBuffer data) {
    return deserialize(
        new org.chromium.mojo.bindings.Message(
            data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
  }

  @SuppressWarnings("unchecked")
  public static CopyOutputResult decode(org.chromium.mojo.bindings.Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    CopyOutputResult result;
    try {
      org.chromium.mojo.bindings.DataHeader mainDataHeader =
          decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      final int elementsOrVersion = mainDataHeader.elementsOrVersion;
      result = new CopyOutputResult(elementsOrVersion);
      {
        result.format = decoder0.readInt(8);
        CopyOutputResultFormat.validate(result.format);
        result.format = CopyOutputResultFormat.toKnownValue(result.format);
      }
      {
        result.destination = decoder0.readInt(12);
        CopyOutputResultDestination.validate(result.destination);
        result.destination = CopyOutputResultDestination.toKnownValue(result.destination);
      }
      {
        org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
        result.rect = org.chromium.gfx.mojom.Rect.decode(decoder1);
      }
      {
        org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, true);
        result.bitmap = BitmapInSharedMemory.decode(decoder1);
      }
      {
        org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, true);
        result.mailbox = org.chromium.gpu.mojom.Mailbox.decode(decoder1);
      }
      {
        org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, true);
        result.syncToken = org.chromium.gpu.mojom.SyncToken.decode(decoder1);
      }
      {
        org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(48, true);
        result.colorSpace = org.chromium.gfx.mojom.ColorSpace.decode(decoder1);
      }
      {
        result.releaser = decoder0.readServiceInterface(56, true, TextureReleaser.MANAGER);
      }

    } finally {
      decoder0.decreaseStackDepth();
    }
    return result;
  }

  @SuppressWarnings("unchecked")
  @Override
  public final void encode(org.chromium.mojo.bindings.Encoder encoder) {
    org.chromium.mojo.bindings.Encoder encoder0 =
        encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);

    encoder0.encode(this.format, 8);

    encoder0.encode(this.destination, 12);

    encoder0.encode(this.rect, 16, false);

    encoder0.encode(this.bitmap, 24, true);

    encoder0.encode(this.mailbox, 32, true);

    encoder0.encode(this.syncToken, 40, true);

    encoder0.encode(this.colorSpace, 48, true);

    encoder0.encode(this.releaser, 56, true, TextureReleaser.MANAGER);
  }
}
