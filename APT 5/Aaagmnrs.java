import java.util.*;

public class Aaagmnrs {
    public String[] anagrams(String[] phrases) {
        HashMap<String, String> anaMap = new HashMap<>();
        ArrayList<String> ret = new ArrayList<>();
        for (String x : phrases) {
            String temp = toAnagramKey(x);
            if (!anaMap.containsKey(temp)) {
                anaMap.put(temp, x);
                ret.add(x);
            }
        }

        return ret.toArray(new String[0]);
    }

    private String toAnagramKey(String x) {

        String s = x.replaceAll("\\s", "");
        s = s.toLowerCase();

        char[] tempS = s.toCharArray();

        Arrays.sort(tempS);
        String ret = new String(tempS);
        return ret;

    }
}

/*
 * for every element in phrases, remove the spaces and rearrange in alphabetial
 * order
 * 
 * if the rearranged string isn't already a key in the hashmap, add it to an
 * array list
 * 
 */