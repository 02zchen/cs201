import java.lang.reflect.Array;
import java.util.*;

public class Closet {
    public String anywhere(String[] list) {

        TreeSet<String> combo = new TreeSet<>();
        for (int i = 0; i < list.length; i++) {
            String[] x = list[i].split(" ");
            combo.addAll(Arrays.asList(x));
        }
        String ret = String.join(" ", combo);
        return ret;
    }
}