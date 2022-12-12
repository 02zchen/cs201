import java.util.TreeMap;

public class SortedFreqs {
    public int[] freqs(String[] data) {
        TreeMap<String, Integer> freqs = new TreeMap<String, Integer>();
        for (String x : data) {
            if (!freqs.containsKey(x)) {
                freqs.put(x, 1);
            } else {
                freqs.put(x, freqs.get(x) + 1);
            }
        }

        // create a retrun arraylist with all the nondupe strings
        int[] ret = new int[freqs.size()];
        int counter = 0;
        for (String x : freqs.keySet()) {
            ret[counter] = freqs.get(x);
            counter++;
        }

        return ret;
    }
}
