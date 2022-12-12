
import java.util.*;

public class SandwichBar {
    public int whichOrder(String[] available, String[] orders) {
        int index = -1;
        int numAvailable = 0;
        for (int i = 0; i < orders.length; i++) {
            String[] pref = orders[i].split(" ");
            for (int j = 0; j < pref.length; j++) {
                if (Arrays.asList(available).contains(pref[j])) {
                    numAvailable++;
                }
            }
            if (numAvailable >= pref.length) {
                return i;

            }
            numAvailable = 0;
        }
        return index;
    }
}
