package org.chromium.net;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import org.chromium.base.Log;
import org.jni_zero.JNINamespace;

@JNINamespace("net::android")
public class AndroidKeyStore {
  private static final String TAG = "AndroidKeyStore";

  private static String getPrivateKeyClassName(PrivateKey privateKey) {
    return privateKey.getClass().getName();
  }

  private static boolean privateKeySupportsSignature(PrivateKey privateKey, String algorithm) {
    try {
      Signature signature = Signature.getInstance(algorithm);
      signature.initSign(privateKey);
      return true;
    } catch (InvalidKeyException e) {
      return false;
    } catch (NoSuchAlgorithmException e2) {
      return false;
    } catch (Exception e3) {
      Log.e(TAG, "Exception while checking support for " + algorithm + ": " + e3);
      return false;
    }
  }

  private static boolean privateKeySupportsCipher(PrivateKey privateKey, String algorithm) {
    try {
      Cipher cipher = Cipher.getInstance(algorithm);
      cipher.init(1, privateKey);
      return true;
    } catch (InvalidKeyException e) {
      return false;
    } catch (NoSuchAlgorithmException e2) {
      return false;
    } catch (NoSuchPaddingException e3) {
      return false;
    } catch (Exception e4) {
      Log.e(TAG, "Exception while checking support for " + algorithm + ": " + e4);
      return false;
    }
  }

  private static byte[] signWithPrivateKey(
      PrivateKey privateKey, String algorithm, byte[] message) {
    try {
      Signature signature = Signature.getInstance(algorithm);
      try {
        signature.initSign(privateKey);
        signature.update(message);
        return signature.sign();
      } catch (Exception e) {
        String algorithm2 = privateKey.getAlgorithm();
        Log.e(
            TAG,
            "Exception while signing message with "
                + algorithm
                + " and "
                + algorithm2
                + " private key ("
                + privateKey.getClass().getName()
                + "): "
                + e);
        return null;
      }
    } catch (NoSuchAlgorithmException e2) {
      Log.e(TAG, "Signature algorithm " + algorithm + " not supported: " + e2);
      return null;
    }
  }

  private static byte[] encryptWithPrivateKey(
      PrivateKey privateKey, String algorithm, byte[] message) {
    try {
      Cipher cipher = Cipher.getInstance(algorithm);
      try {
        cipher.init(1, privateKey);
        return cipher.doFinal(message);
      } catch (Exception e) {
        String algorithm2 = privateKey.getAlgorithm();
        Log.e(
            TAG,
            "Exception while encrypting input with "
                + algorithm
                + " and "
                + algorithm2
                + " private key ("
                + privateKey.getClass().getName()
                + "): "
                + e);
        return null;
      }
    } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
      Log.e(TAG, "Cipher " + algorithm + " not supported: " + e2);
      return null;
    }
  }
}
