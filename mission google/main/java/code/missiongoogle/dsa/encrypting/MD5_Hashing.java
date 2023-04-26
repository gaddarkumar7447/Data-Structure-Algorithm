package code.missiongoogle.dsa.encrypting;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MD5_Hashing {
    public static String messageDigest5(String password) {
        String encrypted = null;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] bytes = m.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            encrypted = stringBuilder.toString();

        } catch (NoSuchAlgorithmException e) {
            e.getStackTrace();
        }

        return encrypted;
    }

    // SHA 256

    public static byte[] getSHA256(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString256(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    // SHA 512 Hashing technique
    public static void getSHA512(String input) throws NoSuchAlgorithmException {
        byte []arr;
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        arr = md.digest(input.getBytes(StandardCharsets.UTF_8));
        System.out.println(toHexString512(arr));
    }

    public static String toHexString512(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    // Password-Based Encryption using Salt and Base64:

    public static void main(String[] args) {
        try{
            getSHA512("gaddar");
        }catch (NoSuchAlgorithmException e){
            e.getStackTrace();
        }

    }

}
