package org.chromium.device.nfc;

import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.nfc.tech.TagTechnology;
import java.io.IOException;

public class NfcTagHandler {
  private final String mSerialNumber;
  private final TagTechnology mTech;
  private final TagTechnologyHandler mTechHandler;
  private boolean mWasConnected;

  private interface TagTechnologyHandler {
    boolean canAlwaysOverwrite()
        throws IOException, TagLostException, FormatException, IllegalStateException;

    boolean makeReadOnly() throws IOException, TagLostException;

    NdefMessage read() throws IOException, TagLostException, FormatException, IllegalStateException;

    void write(NdefMessage ndefMessage)
        throws IOException, TagLostException, FormatException, IllegalStateException;
  }

  public static NfcTagHandler create(Tag tag) {
    if (tag == null || NfcBlocklist.getInstance().isTagBlocked(tag)) {
      return null;
    }
    Ndef ndef = Ndef.get(tag);
    if (ndef != null) {
      return new NfcTagHandler(ndef, new NdefHandler(ndef), tag.getId());
    }
    NdefFormatable formattable = NdefFormatable.get(tag);
    if (formattable == null) {
      return null;
    }
    return new NfcTagHandler(formattable, new NdefFormattableHandler(formattable), tag.getId());
  }

  private static class NdefHandler implements TagTechnologyHandler {
    private final Ndef mNdef;

    NdefHandler(Ndef ndef) {
      this.mNdef = ndef;
    }

    @Override
    public void write(NdefMessage message)
        throws IOException, TagLostException, FormatException, IllegalStateException {
      this.mNdef.writeNdefMessage(message);
      this.mNdef.close();
    }

    @Override
    public boolean makeReadOnly() throws IOException, TagLostException {
      return this.mNdef.makeReadOnly();
    }

    @Override
    public NdefMessage read()
        throws IOException, TagLostException, FormatException, IllegalStateException {
      return this.mNdef.getNdefMessage();
    }

    @Override
    public boolean canAlwaysOverwrite()
        throws IOException, TagLostException, FormatException, IllegalStateException {
      return this.mNdef.getNdefMessage() == null;
    }
  }

  private static class NdefFormattableHandler implements TagTechnologyHandler {
    private final NdefFormatable mNdefFormattable;

    NdefFormattableHandler(NdefFormatable ndefFormattable) {
      this.mNdefFormattable = ndefFormattable;
    }

    @Override
    public void write(NdefMessage message)
        throws IOException, TagLostException, FormatException, IllegalStateException {
      this.mNdefFormattable.format(message);
    }

    @Override
    public boolean makeReadOnly() throws IOException, TagLostException {
      try {
        this.mNdefFormattable.formatReadOnly(NdefMessageUtils.emptyNdefMessage());
        return true;
      } catch (FormatException e) {
        return false;
      }
    }

    @Override
    public NdefMessage read() throws FormatException {
      return NdefMessageUtils.emptyNdefMessage();
    }

    @Override
    public boolean canAlwaysOverwrite() {
      return true;
    }
  }

  protected NfcTagHandler(TagTechnology tech, TagTechnologyHandler handler, byte[] id) {
    this.mTech = tech;
    this.mTechHandler = handler;
    this.mSerialNumber = bytesToSerialNumber(id);
  }

  private static String bytesToSerialNumber(byte[] octets) {
    if (octets.length < 0) {
      return null;
    }
    StringBuilder sb = new StringBuilder(octets.length * 3);
    for (byte b : octets) {
      if (sb.length() > 0) {
        sb.append(":");
      }
      sb.append(String.format("%02x", Integer.valueOf(b & 255)));
    }
    return sb.toString();
  }

  public String serialNumber() {
    return this.mSerialNumber;
  }

  public void connect() throws IOException, SecurityException, TagLostException {
    if (!this.mTech.isConnected()) {
      this.mTech.connect();
      this.mWasConnected = true;
    }
  }

  public void write(NdefMessage message)
      throws IOException, TagLostException, FormatException, IllegalStateException {
    this.mTechHandler.write(message);
  }

  public boolean makeReadOnly() throws IOException, TagLostException {
    return this.mTechHandler.makeReadOnly();
  }

  public NdefMessage read()
      throws IOException, TagLostException, FormatException, IllegalStateException {
    return this.mTechHandler.read();
  }

  public boolean isTagOutOfRange() {
    try {
      connect();
      return false;
    } catch (IOException | SecurityException e) {
      return this.mWasConnected;
    }
  }

  public boolean canAlwaysOverwrite()
      throws IOException, TagLostException, FormatException, IllegalStateException {
    return this.mTechHandler.canAlwaysOverwrite();
  }
}
