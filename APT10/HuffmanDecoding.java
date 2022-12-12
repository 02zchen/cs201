import java.util.*;

public class HuffmanDecoding {
    public String decode(String archive, String[] dictionary) {
        StringBuilder ret = new StringBuilder();
        HashMap<String, Character> decoder = new HashMap<>();
        for (int i = 0; i < dictionary.length; i++) {
            char temp = (char) (65 + i);
            decoder.putIfAbsent(dictionary[i], temp);
        }
        int lastChecked = 0;
        for (int j = 0; j < archive.length(); j++) {
            String key = archive.substring(lastChecked, j + 1);
            if (decoder.containsKey(key)) {
                ret.append(decoder.get(key));
                lastChecked = j + 1;
            }
        }
        return ret.toString();
    }
}
