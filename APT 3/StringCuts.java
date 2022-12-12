import java.util.ArrayList;

public class StringCuts {
    public String[] filter(String[] list, int minLength) {
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < list.length; i++) {
            if (list[i].length() >= minLength) {
                if (!words.contains(list[i])) {
                    words.add(list[i]);
                }
            }
        }
        String[] ret = words.toArray(new String[0]);
        return ret;
    }
}
