//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        Aes aesEncryption = new Aes();;
        Rsa rsaEncryption = new Rsa();

        Alice alice = new Alice();
        Bob bob = new Bob();

        String message = alice.sendMessageByAes("hello, bob!", aesEncryption);
        bob.receiveMessageByAes(message, aesEncryption);
        String message1 = bob.sendMessageByAes("hi, alice!", aesEncryption);
        alice.receiveMessageByAes(message1, aesEncryption);

        String message2 = bob.sendMessageByRsa("hello, alice!", rsaEncryption);
        alice.receiveMessageByRsa(message2, rsaEncryption);
        String message3 = alice.sendMessageByRsa("hi, bob!", rsaEncryption);
        bob.receiveMessageByRsa(message3, rsaEncryption);
    }
}