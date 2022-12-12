import java.util.*;

public class Encryption {
    public String encrypt(String message) {
        HashMap<Character, Character> encryptTable = new HashMap<>();
        char[] encryptString = new char[message.length()];
        char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        int counter = 0;

        for (int i = 0; i < message.length(); i++) {
            if (!encryptTable.containsKey(message.charAt(i))) {
                encryptTable.put(message.charAt(i), alphabet[counter]);
                counter++;
            }
            encryptString[i] = encryptTable.get(message.charAt(i));
        }

        String ret = new String(encryptString);
        return ret;

    }

}

/*
 * char[] encrypt = new char[message.length()];
 * int counter = 0;
 * for (int i = 0; i < message.length(); i++) {
 * if (i > 0) {
 * if (message.charAt(i) == message.charAt(i - 1)) {
 * encrypt[i] = encrypt[i - 1];
 * 
 * } else {
 * encrypt[i] = (char) (counter + 97);
 * counter++;
 * }
 * }
 * 
 * else {
 * encrypt[i] = (char) (i + 97);
 * counter++;
 * }
 * 
 * }
 */