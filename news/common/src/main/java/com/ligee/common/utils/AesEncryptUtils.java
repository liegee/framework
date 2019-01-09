package com.ligee.common.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 * Author: 李杰
 * Date: 2018/12/7 6:49 PM
 */
public class AesEncryptUtils {

    private static final String KEY = "d7b86f6a234abcda";
    private static final String ALGORITHMS = "AES/ECB/PKCS5Padding";

    public static String base64Encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    public static byte[] base64Decode(String base64Code) throws Exception {
        return Base64.decodeBase64(base64Code);
    }

    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMS);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));
        return cipher.doFinal(content.getBytes("utf-8"));
    }

    /**
     * 加密操作
     * @param content 需要加密的内容
     * @param encryptKey 加密key
     * @return
     * @throws Exception
     */
    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMS);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes);
    }

    /**
     * 解密操作
     * @param encryptStr 需要解密的字符
     * @param decryptKey 解密key
     * @return
     * @throws Exception
     */
    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }

    public static void main(String[] args) throws Exception {
        String content = "{\n" +
                "\t\"mobile\":\"18221875359\",\n" +
                "\t\"password\":\"111111\"\n" +
                "}";
        System.out.println("加密前：" + content);

        String encrypt = aesEncrypt(content, KEY);
        System.out.println(encrypt.length() + ":加密后：" + encrypt);

        String decrypt = aesDecrypt("EaNcVSuPc1dL/gHkgVMFhzgrV12EzTS/5dOoXwrSrYANDy6jhZojs4+qJhi+JcI8Phl4Dlo8ky10cAlChDxU2RvNQebWq5r/KbfpwJSy3KgaKuBqBX4JhczjE71L0WrElxCAnUo1sHGn1srMRvhY64qfedURHwe9Uay2aGfcwMzvlKnhCGvxlnB9yU71POtV", KEY);
        System.out.println("解密后：" + decrypt);
    }
}
