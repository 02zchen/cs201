import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BigWord {
    public String most(String[] sentences) {
        String largestWord = "";
        int largestWordCount = 0;

        ArrayList<String> words = new ArrayList<String>();
        String[] temp;

        for (String x : sentences) {
            temp = x.split(" ");
            for (int i = 0; i < temp.length; i++) {
                temp[i] = temp[i].toLowerCase();
            }
            words.addAll(Arrays.asList(temp));
        }

        for (String x : words) {
            if (largestWordCount < Collections.frequency(words, x)) {
                largestWordCount = Collections.frequency(words, x);
                largestWord = x;
            }
        }
        return largestWord;
    }
}
