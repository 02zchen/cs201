import java.util.*;

public class SimpleWordGame {
    public int points(String[] player, String[] dictionary) {
        int score = 0;
        HashSet<String> noDupes = new HashSet<>(Arrays.asList(player));

        for (String s : noDupes) {
            for (int i = 0; i < dictionary.length; i++) {
                if (dictionary[i].equals(s)) {
                    score += s.length() * s.length();
                }
            }
        }
        return score;
    }
}
