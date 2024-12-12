import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class Rsa {

    private KeyPair keyPair;

    public Rsa() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        this.keyPair = keyGen.generateKeyPair();
    }

    // Encrypt method
    public String encrypt(String plainText, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedText = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedText);
    }

    // Decrypt method
    public String decrypt(String encryptedText, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decodedText = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedText = cipher.doFinal(decodedText);
        return new String(decryptedText);
    }

    public PublicKey getPublicKey() {
        return keyPair.getPublic();
    }

    public PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }
}
