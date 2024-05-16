package service;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHasher {
    private static final String AES_ALGORITHM = "AES";
    private static final String AES_CIPHER = "AES/CBC/PKCS5Padding";
    private static final int KEY_LENGTH = 256;
    private static final int IV_LENGTH = 16; // IV length per AES encryption

    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[IV_LENGTH];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String generateSaltedHash(String password, String salt) {
        try {
            byte[] saltBytes = Base64.getDecoder().decode(salt);
            SecretKeySpec secretKey = new SecretKeySpec(saltBytes, AES_ALGORITHM);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(saltBytes);

            Cipher cipher = Cipher.getInstance(AES_CIPHER);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            byte[] encryptedBytes = cipher.doFinal(password.getBytes());

            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate salted hash: " + e.getMessage(), e);
        }
    }

    public static boolean compareSaltedHash(String password, String salt, String saltedHash) {
        String generatedSaltedHash = generateSaltedHash(password, salt);
        return generatedSaltedHash.equals(saltedHash);
    }
}
