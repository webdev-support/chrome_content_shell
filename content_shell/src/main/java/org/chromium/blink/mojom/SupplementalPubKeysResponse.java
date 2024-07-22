// SupplementalPubKeysResponse.java is auto generated by mojom_bindings_generator.py, do not edit

// Copyright 2014 The Chromium Authors
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/webauthn/authenticator.mojom
//

package org.chromium.blink.mojom;

public final class SupplementalPubKeysResponse extends org.chromium.mojo.bindings.Struct {

  private static final int STRUCT_SIZE = 16;
  private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY =
      new org.chromium.mojo.bindings.DataHeader[] {
        new org.chromium.mojo.bindings.DataHeader(16, 0)
      };
  private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
  public byte[][] signatures;

  private SupplementalPubKeysResponse(int version) {
    super(STRUCT_SIZE, version);
  }

  public SupplementalPubKeysResponse() {
    this(0);
  }

  public static SupplementalPubKeysResponse deserialize(
      org.chromium.mojo.bindings.Message message) {
    return decode(new org.chromium.mojo.bindings.Decoder(message));
  }

  /**
   * Similar to the method above, but deserializes from a |ByteBuffer| instance.
   *
   * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
   */
  public static SupplementalPubKeysResponse deserialize(java.nio.ByteBuffer data) {
    return deserialize(
        new org.chromium.mojo.bindings.Message(
            data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
  }

  @SuppressWarnings("unchecked")
  public static SupplementalPubKeysResponse decode(org.chromium.mojo.bindings.Decoder decoder0) {
    if (decoder0 == null) {
      return null;
    }
    decoder0.increaseStackDepth();
    SupplementalPubKeysResponse result;
    try {
      org.chromium.mojo.bindings.DataHeader mainDataHeader =
          decoder0.readAndValidateDataHeader(VERSION_ARRAY);
      final int elementsOrVersion = mainDataHeader.elementsOrVersion;
      result = new SupplementalPubKeysResponse(elementsOrVersion);
      {
        org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
        {
          org.chromium.mojo.bindings.DataHeader si1 =
              decoder1.readDataHeaderForPointerArray(
                  org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
          result.signatures = new byte[si1.elementsOrVersion][];
          for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {

            result.signatures[i1] =
                decoder1.readBytes(
                    org.chromium.mojo.bindings.DataHeader.HEADER_SIZE
                        + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1,
                    org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE,
                    org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
          }
        }
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

    if (this.signatures == null) {
      encoder0.encodeNullPointer(8, false);
    } else {
      org.chromium.mojo.bindings.Encoder encoder1 =
          encoder0.encodePointerArray(
              this.signatures.length,
              8,
              org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
      for (int i0 = 0; i0 < this.signatures.length; ++i0) {

        encoder1.encode(
            this.signatures[i0],
            org.chromium.mojo.bindings.DataHeader.HEADER_SIZE
                + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0,
            org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE,
            org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
      }
    }
  }
}
