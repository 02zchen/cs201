import java.util.ArrayList;

public class Starter {
    public int begins(String[] words, String first) {
        ArrayList<String> noDupes = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            String unique = new String(words[i]);
            if (!noDupes.contains(unique)) {
                noDupes.add(unique);
                String letter = new String(words[i].substring(0, 1));
                if (letter.equals(first)) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
