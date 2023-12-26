package org.example;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    /**
     * encrypting the password
     * @param unhashedPswd
     * @return
     */
    public String encryptPassword(String unhashedPswd){

        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); // refrence https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
            byte[] bytes = md.digest(unhashedPswd.getBytes());

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : bytes) {
                stringBuilder.append(String.format("%02x", b));
            }

            unhashedPswd=stringBuilder.toString();
            return unhashedPswd;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
    }
}
