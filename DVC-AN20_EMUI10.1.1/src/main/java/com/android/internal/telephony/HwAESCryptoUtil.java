package com.android.internal.telephony;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class HwAESCryptoUtil {
    private static final String HEX = "0123456789ABCDEF";
    public static final String TAG = "HwAESCryptoUtil";

    public static String encrypt(String key, String plaintext) throws Exception {
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(plaintext)) {
            return plaintext;
        }
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(Charset.defaultCharset()), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] ivBytes = new byte[16];
        new SecureRandom().nextBytes(ivBytes);
        cipher.init(1, skeySpec, new IvParameterSpec(ivBytes));
        String ciphertextStr = toHex(cipher.doFinal(plaintext.getBytes("UTF-8")));
        String ivStr = toHex(ivBytes);
        return ivStr + ciphertextStr;
    }

    public static String decrypt(String key, String encrypted) throws Exception {
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(encrypted)) {
            return encrypted;
        }
        byte[] ivBytes = toByte(encrypted.substring(0, 32));
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(Charset.defaultCharset()), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, skeySpec, new IvParameterSpec(ivBytes));
        return new String(cipher.doFinal(toByte(encrypted.substring(32, encrypted.length()))), Charset.defaultCharset());
    }

    public static String getKey(byte[] c1, byte[] c2, byte[] c3) {
        return new String(right(XOR(c1, left(XOR(c3, left(c2, 2)), 6)), 4), Charset.defaultCharset());
    }

    private static byte[] right(byte[] source, int count) {
        byte[] temp = (byte[]) source.clone();
        for (int i = 0; i < count; i++) {
            byte m = temp[temp.length - 1];
            for (int j = temp.length - 1; j > 0; j--) {
                temp[j] = temp[j - 1];
            }
            temp[0] = m;
        }
        return temp;
    }

    private static byte[] left(byte[] source, int count) {
        byte[] temp = (byte[]) source.clone();
        for (int i = 0; i < count; i++) {
            byte m = temp[0];
            for (int j = 0; j < temp.length - 1; j++) {
                temp[j] = temp[j + 1];
            }
            temp[temp.length - 1] = m;
        }
        return temp;
    }

    private static byte[] XOR(byte[] m, byte[] n) {
        byte[] temp = new byte[m.length];
        for (int i = 0; i < m.length; i++) {
            temp[i] = (byte) (m[i] ^ n[i]);
        }
        return temp;
    }

    public static byte[] toByte(String hexString) {
        if (TextUtils.isEmpty(hexString)) {
            return new byte[0];
        }
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            try {
                result[i] = Integer.valueOf(hexString.substring(i * 2, (i * 2) + 2), 16).byteValue();
            } catch (NumberFormatException e) {
                return new byte[0];
            }
        }
        return result;
    }

    public static String toHex(byte[] buf) {
        if (buf == null) {
            return "";
        }
        StringBuffer result = new StringBuffer(buf.length * 2);
        for (byte b : buf) {
            appendHex(result, b);
        }
        return result.toString();
    }

    private static void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b >> 4) & 15));
        sb.append(HEX.charAt(b & 15));
    }
}
