import java.util.*;

public class SortByFreqs {
    public String[] sort(String[] data) {
        // return array of strings sored by frquency
        // ties broken by lexographic

        HashMap<String, Integer> freqs = new HashMap<String, Integer>();
        for (String x : data) {
            if (!freqs.containsKey(x)) {
                freqs.put(x, 1);
            } else {
                freqs.put(x, freqs.get(x) + 1);
            }
        }

        // create a retrun arraylist with all the nondupe strings
        ArrayList<String> ret = new ArrayList<>(freqs.keySet());
        Collections.sort(ret, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                int myCompare = freqs.get(y) - freqs.get(x);
                if (myCompare == 0) {
                    myCompare = x.compareTo(y);
                }
                return myCompare;
            }
        });

        String[] toArr = ret.toArray(new String[ret.size()]);
        return toArr;
    }
}
