package com.aba.cryptosample.utils;

import com.aba.cryptosample.AppConstants;
import com.tozny.crypto.android.AesCbcWithIntegrity;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public class CryptoUtils {

    public static AesCbcWithIntegrity.SecretKeys generateKeys() throws GeneralSecurityException {

        return AesCbcWithIntegrity.generateKeyFromPassword(AppConstants.DEFAULT_PASSWORD , AppConstants.SALT);
    }

    public static String encrypt(String text) throws GeneralSecurityException, UnsupportedEncodingException {

        AesCbcWithIntegrity.CipherTextIvMac cipherTextIvMac = AesCbcWithIntegrity.encrypt(text, generateKeys());
        return cipherTextIvMac.toString();
    }

    public static String decrypt(String text) throws GeneralSecurityException, UnsupportedEncodingException {
        AesCbcWithIntegrity.CipherTextIvMac cipherTextIvMac = new AesCbcWithIntegrity.CipherTextIvMac(text);
        return AesCbcWithIntegrity.decryptString(cipherTextIvMac, generateKeys());
    }

}
