import java.util.*;

public class SetAside {
    public String common(String[] list) {
        TreeSet<String> combo = new TreeSet<>();
        for (int i = 0; i < list.length; i++) {
            String[] x = list[i].split(" ");
            if (i == 0) {
                combo.addAll(Arrays.asList(x));
            } else {
                combo.retainAll(Arrays.asList(x));
            }
        }
        String ret = String.join(" ", combo);
        return ret;
    }
}