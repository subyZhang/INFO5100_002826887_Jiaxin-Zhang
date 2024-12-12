public class Bob {
    public String sendMessageByAes(String message, Aes aesEncryption) throws Exception {
        String encryptedMessage = aesEncryption.encrypt(message);
        System.out.println("Encrypted message: " + encryptedMessage);
        return encryptedMessage;
    }

    public String sendMessageByRsa(String message, Rsa rsaEncryption) throws Exception {
        String encryptedMessage1 = rsaEncryption.encrypt(message, rsaEncryption.getPublicKey());
        System.out.println("Encrypted message: " + encryptedMessage1);
        return encryptedMessage1;
    }

    public void receiveMessageByAes(String message, Aes aesEncryption) throws Exception {
        String decryptedMessage = aesEncryption.decrypt(message);
        System.out.println("Decrypted message: " + decryptedMessage);
    }

    public void receiveMessageByRsa(String message, Rsa rsaEncryption) throws Exception {
        String decryptedMessage1 = rsaEncryption.decrypt(message, rsaEncryption.getPrivateKey());
        System.out.println("Decrypted message: " + decryptedMessage1);
    }
}
