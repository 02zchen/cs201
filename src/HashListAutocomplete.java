import java.util.*;

public class HashListAutocomplete implements Autocompletor {

    private static final int MAX_PREFIX = 10;
    // key is a prefix/substring
    // value for each prefix key is a weighted sorted list of term objects that
    // share that prefix
    private Map<String, List<Term>> myMap;
    private int mySize;

    public HashListAutocomplete(String[] terms, double[] weights) {
        if (terms == null || weights == null) {
            throw new NullPointerException("One or more arguments null");
        }
        if (terms.length != weights.length) {
            throw new IllegalArgumentException("One or more arguments invalid");
        }
        initialize(terms, weights);
    }

    @Override
    public List<Term> topMatches(String prefix, int k) {
        if (prefix.length() > MAX_PREFIX) {
            prefix = prefix.substring(0, MAX_PREFIX);
        }
        if (myMap.containsKey(prefix)) {
            List<Term> all = myMap.get(prefix);
            List<Term> list = all.subList(0, Math.min(k, all.size()));
            return list;
        } else {
            return new ArrayList<Term>();
        }
    }

    @Override
    public void initialize(String[] terms, double[] weights) {
        myMap = new HashMap<String, List<Term>>();
        mySize = 0;
        // loop through all terms
        for (int i = 0; i < terms.length; i++) {
            // temporary term and its weight at j index
            String t = terms[i];
            double tWeight = weights[i];
            Term insert = new Term(t, tWeight);
            mySize += BYTES_PER_CHAR * t.length() + BYTES_PER_DOUBLE;
            for (int j = 0; j < MAX_PREFIX + 1; j++) {
                if (t.length() >= j) {
                    String splice = t.substring(0, j);
                    if (!myMap.containsKey(splice)) {
                        myMap.put(splice, new ArrayList<>());
                        mySize += BYTES_PER_CHAR * splice.length();
                    }
                    myMap.get(splice).add(insert);
                }

            }
        }
        Comparator<Term> comp = Comparator.comparing(Term::getWeight).reversed();
        for (String key : myMap.keySet()) {
            Collections.sort(myMap.get(key), comp);
        }

    }

    @Override
    public int sizeInBytes() {
        return mySize;
    }

    // public static void main(String[] args) {
    // String[] n = {
    // "apple", "apricot", "avocado", "almond", "alupug" };
    // double[] w = { 1.0, 3.0, 4.0, 2.0, 3.0 };
    // HashListAutocomplete bob = new HashListAutocomplete(n, w);
    // System.out.println(bob.sizeInBytes());

    // }

}
