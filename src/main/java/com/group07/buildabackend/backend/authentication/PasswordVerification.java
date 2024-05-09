package com.group07.buildabackend.backend.authentication;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class PasswordVerification {

    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256; // in bits

    public static boolean verifyPassword(String providedPassword, String storedHash, String salt) {
        try {
            char[] passwordChars = providedPassword.toCharArray();
            byte[] saltBytes = Base64.getDecoder().decode(salt);
            byte[] storedHashBytes = Base64.getDecoder().decode(storedHash);

            PBEKeySpec spec = new PBEKeySpec(passwordChars, saltBytes, ITERATIONS, KEY_LENGTH);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] generatedHashBytes = keyFactory.generateSecret(spec).getEncoded();

            int diff = storedHashBytes.length ^ generatedHashBytes.length;
            for (int i = 0; i < storedHashBytes.length && i < generatedHashBytes.length; i++) {
                diff |= storedHashBytes[i] ^ generatedHashBytes[i];
            }

            return diff == 0;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
