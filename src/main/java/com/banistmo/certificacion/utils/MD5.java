package com.banistmo.certificacion.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.banistmo.certificacion.utils.enums.EnumMensajes.DECRYPT_ERROR;
import static com.banistmo.certificacion.utils.enums.EnumMensajes.ENCRYPT_ERROR;

public class MD5 {

    private static final String DESEDE = "DESede";
    private static final String SECRET_KEY = "qualityinfosolutions";
    private static final Logger logger = Logger.getLogger(MD5.class.getName());

    public static String encrypt(String texto) {
        String base64EncryptedString = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, DESEDE);
            Cipher cipher = Cipher.getInstance(DESEDE);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainTextBytes = texto.getBytes(StandardCharsets.UTF_8);
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);
        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | InvalidKeyException e) {
            logger.log(Level.WARNING, ENCRYPT_ERROR.getMensaje(), e);
        }
        return base64EncryptedString;
    }
//
//    public static void main(String[] args) {
//        System.out.println(encrypt("salvatore13_"));
//        System.out.println(encrypt("Prueba123##"));
//    }

    public static String decrypt(String textoEncriptado) {
        String base64EncryptedString = "";
        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes(StandardCharsets.UTF_8));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, DESEDE);
            Cipher decipher = Cipher.getInstance(DESEDE);
            decipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = decipher.doFinal(message);
            base64EncryptedString = new String(plainText, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | InvalidKeyException e) {
            logger.log(Level.WARNING, DECRYPT_ERROR.getMensaje(), e);
        }
        return base64EncryptedString;
    }

    private MD5() {
    }
}
